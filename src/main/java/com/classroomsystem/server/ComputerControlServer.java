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

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class ComputerControlServer extends ComputerControlServiceGrpc.ComputerControlServiceImplBase {

    private final AtomicBoolean computersOn = new AtomicBoolean(false);
    private static final String CONSUL_SERVICE_ID = "computer-control-server";
    private static final String CONSUL_SERVICE_NAME = "computer-control";
    private static final String CONSUL_SERVICE_CHECK_ENDPOINT = "/health";
    private static final int HTTP_PORT = 8010;

    public void toggleComputers(ToggleComputersRequest request, StreamObserver<ToggleComputersResponse> responseObserver) {
        boolean requestedState = request.getPowerOn();
        computersOn.set(requestedState);

        String message = "The computer has" + (requestedState ? " opened." : " closed.");
        ToggleComputersResponse response = ToggleComputersResponse.newBuilder()
                .setSuccess(true)
                .setMessage(message)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    public void monitorComputers(Empty request, StreamObserver<ComputerStatusResponse> responseObserver) {
        Runnable monitorTask = () -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    ComputerStatusResponse response = ComputerStatusResponse.newBuilder()
                            .setIsOn(computersOn.get())
                            .setStatusInfo("Status check time: " + LocalDateTime.now())
                            .build();
                    responseObserver.onNext(response);
                    Thread.sleep(5000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                responseObserver.onCompleted();
            }
        };

        new Thread(monitorTask).start();
    }

    private static void startHttpServer() throws IOException {
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(HTTP_PORT), 0);
        httpServer.createContext(CONSUL_SERVICE_CHECK_ENDPOINT, (HttpExchange exchange) -> {
            String response = "Healthy";
            exchange.sendResponseHeaders(200, response.getBytes().length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response.getBytes());
            }
        });
        httpServer.setExecutor(null);
        httpServer.start();
        System.out.println("HTTP Server started on port " + HTTP_PORT);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        final int grpcPort = 8081;
        Server grpcServer = ServerBuilder.forPort(grpcPort)
                .addService(new ComputerControlServer())
                .build();

        startHttpServer();

        // Consul Register
        Consul consul = Consul.builder().build();
        AgentClient agentClient = consul.agentClient();

        ImmutableRegistration service = ImmutableRegistration.builder()
                .id(CONSUL_SERVICE_ID)
                .name(CONSUL_SERVICE_NAME)
                .port(grpcPort)
                .check(ImmutableRegCheck.builder()
                        .http("http://localhost:" + HTTP_PORT + CONSUL_SERVICE_CHECK_ENDPOINT)
                        .interval("10s")
                        .build())
                .build();
        agentClient.register(service);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down gRPC server since JVM is shutting down");
            try {
                grpcServer.shutdown().awaitTermination(30, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace(System.err);
            }
            System.out.println("Server shut down");
            agentClient.deregister(CONSUL_SERVICE_ID);
        }));

        grpcServer.start();
        System.out.println("Server started, listening on " + grpcPort);
        grpcServer.awaitTermination();
    }
}
