package com.classroomsystem.server;

import com.classroomsystem.ComputerControlServiceGrpc;
import com.classroomsystem.ComputerProto.*;
import com.orbitz.consul.AgentClient;
import com.orbitz.consul.Consul;
import com.orbitz.consul.model.agent.ImmutableRegCheck;
import com.orbitz.consul.model.agent.ImmutableRegistration;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class ComputerControlServer extends ComputerControlServiceGrpc.ComputerControlServiceImplBase {

    private final AtomicBoolean computersOn = new AtomicBoolean(false);
    private static final String CONSUL_SERVICE_ID = "computer-control-server";
    private static final String CONSUL_SERVICE_NAME = "computer-control";
    private static final String CONSUL_SERVICE_CHECK_ENDPOINT = "/health";

    @Override
    public void toggleComputers(ToggleComputersRequest request, StreamObserver<ToggleComputersResponse> responseObserver) {
        boolean requestedState = request.getPowerOn();
        computersOn.set(requestedState);

        String message = "电脑已经" + (requestedState ? "开启。" : "关闭。");
        ToggleComputersResponse response = ToggleComputersResponse.newBuilder()
                .setSuccess(true)
                .setMessage(message)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void monitorComputers(Empty request, StreamObserver<ComputerStatusResponse> responseObserver) {
        Runnable monitorTask = () -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    ComputerStatusResponse response = ComputerStatusResponse.newBuilder()
                            .setIsOn(computersOn.get())
                            .setStatusInfo("状态检查时间：" + LocalDateTime.now())
                            .build();
                    responseObserver.onNext(response);
                    Thread.sleep(5000); // 每5秒发送一次状态更新
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                responseObserver.onCompleted();
            }
        };

        new Thread(monitorTask).start();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        final int port = 8081;
        Server server = ServerBuilder.forPort(port)
                .addService(new ComputerControlServer())
                .build();

        // Consul服务注册
        Consul consul = Consul.builder().build();
        AgentClient agentClient = consul.agentClient();

        ImmutableRegistration service = ImmutableRegistration.builder()
                .id(CONSUL_SERVICE_ID)
                .name(CONSUL_SERVICE_NAME)
                .port(port)
                .check(ImmutableRegCheck.builder()
                        .http("http://localhost:" + port + CONSUL_SERVICE_CHECK_ENDPOINT)
                        .interval("10s")
                        .build())
                .build();

        agentClient.register(service);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down gRPC server since JVM is shutting down");
            try {
                server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
                agentClient.deregister(CONSUL_SERVICE_ID); // 注销服务
            } catch (InterruptedException e) {
                e.printStackTrace(System.err);
            }
            System.out.println("Server shut down");
        }));

        server.start();
        System.out.println("Server started, listening on " + port);
        server.awaitTermination();
    }
}
