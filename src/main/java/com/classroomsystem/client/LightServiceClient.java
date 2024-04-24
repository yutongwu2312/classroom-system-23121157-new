package com.classroomsystem.client;

import com.classroomsystem.LightControlServiceGrpc;
import com.classroomsystem.LightProto.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.TimeUnit;

public class LightServiceClient {

    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 8080;

    public static void main(String[] args) {
        // 创建到服务器的通道
        ManagedChannel channel = ManagedChannelBuilder.forAddress(SERVER_HOST, SERVER_PORT)
                .usePlaintext()
                .build();

        // 创建灯光控制服务的存根
        LightControlServiceGrpc.LightControlServiceStub stub = LightControlServiceGrpc.newStub(channel);

        // 创建用于接收服务器流的响应观察者
        StreamObserver<LightControlMessage> responseObserver = new StreamObserver<LightControlMessage>() {
            @Override
            public void onNext(LightControlMessage message) {
                // 处理从服务器接收到的消息
                System.out.println("Received message from server: " + message);
            }

            @Override
            public void onError(Throwable t) {
                // 处理从服务器接收到的错误
                System.err.println("Error from server: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                // 服务器流结束时的处理
                System.out.println("Server stream completed");
            }
        };

        // 创建用于向服务器发送流的请求观察者
        StreamObserver<LightControlMessage> requestObserver = stub.streamLightControl(responseObserver);

        // 向服务器发送三个开关灯请求
        for (int i = 0; i < 3; i++) {
            SwitchLightRequest switchRequest = SwitchLightRequest.newBuilder()
                    .setTurnOn(true)
                    .build();
            LightControlMessage switchMessage = LightControlMessage.newBuilder()
                    .setSwitchRequest(switchRequest)
                    .build();
            requestObserver.onNext(switchMessage);
        }

        // 发送亮度调节请求
        BrightnessRequest brightnessRequest = BrightnessRequest.newBuilder()
                .setLevel(BrightnessRequest.BrightnessLevel.HIGH)
                .build();
        LightControlMessage brightnessMessage = LightControlMessage.newBuilder()
                .setBrightnessRequest(brightnessRequest)
                .build();
        requestObserver.onNext(brightnessMessage);

        // 标记向服务器发送请求的结束
        requestObserver.onCompleted();

        // 关闭通道
        try {
            channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("Interrupted while shutting down the channel: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}