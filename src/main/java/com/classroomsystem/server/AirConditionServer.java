package com.classroomsystem.server;

import com.classroomsystem.AirConditionProto;
import com.classroomsystem.AirConditionerControlServiceGrpc;
import com.orbitz.consul.AgentClient;
import com.orbitz.consul.Consul;
import com.orbitz.consul.model.agent.ImmutableRegistration;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AirConditionServer {
    private Server server;
    private AgentClient consulAgent;

    public static void main(String[] args) throws IOException, InterruptedException {
        AirConditionServer server = new AirConditionServer();
        server.start(8082);
        server.blockUntilShutdown();
    }

    public void start(int port) throws IOException {
        // 设置Consul客户端
        Consul consul = Consul.builder().build();
        consulAgent = consul.agentClient();

        // 服务注册
        ImmutableRegistration service = ImmutableRegistration.builder()
                .id("airConditionServer-" + port)
                .name("AirConditionServer")
                .address("localhost")
                .port(port)
                .addTags("gRPC")
                .build();
        consulAgent.register(service);

        server = ServerBuilder.forPort(port)
                .addService(new AirConditionerControlServiceImpl())
                .build()
                .start();
        System.out.println("服务器已启动，监听端口：" + port);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.err.println("*** 由于JVM正在关闭，gRPC服务器即将关闭");
            try {
                AirConditionServer.this.stop();
            } catch (InterruptedException e) {
                e.printStackTrace(System.err);
            }
            System.err.println("*** 服务器已关闭");
            consulAgent.deregister("airConditionServer-" + port);
        }));
    }

    private void stop() throws InterruptedException {
        if (server != null) {
            server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
        }
    }

    public void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    private static class AirConditionerControlServiceImpl extends AirConditionerControlServiceGrpc.AirConditionerControlServiceImplBase {
        @Override
        public void switchAirConditioner(AirConditionProto.SwitchAirConditionerRequest request, StreamObserver<AirConditionProto.SwitchAirConditionerResponse> responseObserver) {
            // 实现开关空调的业务逻辑
            boolean status = request.getTurnOn();
            // 模拟业务处理结果
            AirConditionProto.SwitchAirConditionerResponse response = AirConditionProto.SwitchAirConditionerResponse.newBuilder()
                    .setMessage(status ? "空调已开启" : "空调已关闭")
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        @Override
        public void setTemperature(AirConditionProto.SetTemperatureRequest request, StreamObserver<AirConditionProto.SetTemperatureResponse> responseObserver) {
            // 实现设置温度的业务逻辑
            float temperature = request.getTemperatureCelsius();
            // 模拟业务处理结果
            AirConditionProto.SetTemperatureResponse response = AirConditionProto.SetTemperatureResponse.newBuilder()
                    .setMessage("温度设置为: " + temperature + "°C")
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        @Override
        public StreamObserver<AirConditionProto.SetTemperatureRequest> streamTemperatureAdjustments(StreamObserver<AirConditionProto.StreamTemperatureAdjustmentsResponse> responseObserver) {
            // 实现客户端流式温度调节请求的业务逻辑
            return new StreamObserver<AirConditionProto.SetTemperatureRequest>() {
                @Override
                public void onNext(AirConditionProto.SetTemperatureRequest request) {
                    // 处理每个温度调节请求
                    float temperature = request.getTemperatureCelsius();
                    System.out.println("接收到温度调节请求: " + temperature + "°C");
                }

                @Override
                public void onError(Throwable t) {
                    // 处理错误情况
                    System.err.println("流式调温中发生错误: " + t.getMessage());
                }

                @Override
                public void onCompleted() {
                    // 处理请求完成的情况
                    AirConditionProto.StreamTemperatureAdjustmentsResponse response = AirConditionProto.StreamTemperatureAdjustmentsResponse.newBuilder()
                            .setMessage("温度调节完成")
                            .build();
                    responseObserver.onNext(response);
                    responseObserver.onCompleted();
                }
            };
        }
    }
}
