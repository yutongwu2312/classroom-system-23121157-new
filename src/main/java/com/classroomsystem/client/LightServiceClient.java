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
        ManagedChannel channel = ManagedChannelBuilder.forAddress(SERVER_HOST, SERVER_PORT)
                .usePlaintext()
                .build();

        LightControlServiceGrpc.LightControlServiceStub stub = LightControlServiceGrpc.newStub(channel);

        StreamObserver<LightControlMessage> responseObserver = new StreamObserver<LightControlMessage>() {
            public void onNext(LightControlMessage message) {
                System.out.println("Received message from server: " + message);
            }

            public void onError(Throwable t) {
                System.err.println("Error from server: " + t.getMessage());
            }

            public void onCompleted() {
                System.out.println("Server stream completed");
            }
        };

        StreamObserver<LightControlMessage> requestObserver = stub.streamLightControl(responseObserver);

        // Send three light on/off requests to the server
        for (int i = 0; i < 3; i++) {
            SwitchLightRequest switchRequest = SwitchLightRequest.newBuilder()
                    .setTurnOn(true)
                    .build();
            LightControlMessage switchMessage = LightControlMessage.newBuilder()
                    .setSwitchRequest(switchRequest)
                    .build();
            requestObserver.onNext(switchMessage);
        }

        // Send a brightness adjustment
        BrightnessRequest brightnessRequest = BrightnessRequest.newBuilder()
                .setLevel(BrightnessRequest.BrightnessLevel.HIGH)
                .build();
        LightControlMessage brightnessMessage = LightControlMessage.newBuilder()
                .setBrightnessRequest(brightnessRequest)
                .build();
        requestObserver.onNext(brightnessMessage);
        requestObserver.onCompleted();


        try {
            channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("Interrupted while shutting down the channel: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}