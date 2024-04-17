package com.classroomsystem.client;

import com.classroomsystem.LightProto;
import com.classroomsystem.LightServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.util.concurrent.TimeUnit;

public class LightClient {
    private final ManagedChannel channel;
    private final LightServiceGrpc.LightServiceBlockingStub blockingStub;

    /** Construct client for accessing server using the existing channel. */
    public LightClient(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext() // 使用明文通信（不加密），适用于测试环境
                .build());
    }

    /** Construct client to access gRPC server using the specified channel. */
    LightClient(ManagedChannel channel) {
        this.channel = channel;
        blockingStub = LightServiceGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    /** Get the current status of the light. */
    public void getLightStatus(String name) {
        LightProto.LightStatus request = LightProto.LightStatus.newBuilder().setName(name).build();
        LightProto.LightStatus response;
        try {
            response = blockingStub.getStatus(request);
            System.out.println("Light status for " + name + ": " + (response.getIsOn() ? "On" : "Off"));
        } catch (StatusRuntimeException e) {
            System.err.println("RPC failed: " + e.getStatus());
        }
    }

    /** Toggle the current state of the light. */
    public void toggleLight(String name) {
        LightProto.LightStatus request = LightProto.LightStatus.newBuilder().setName(name).build();
        LightProto.LightStatus response;
        try {
            response = blockingStub.toggle(request);
            System.out.println("Toggled light for " + name + ". New status: " + (response.getIsOn() ? "On" : "Off"));
        } catch (StatusRuntimeException e) {
            System.err.println("RPC failed: " + e.getStatus());
        }
    }

    public static void main(String[] args) throws Exception {
        LightClient client = new LightClient("localhost", 50051);
        try {
            String lightName = "Classroom Light"; // 你可以修改这个灯的名字
            client.getLightStatus(lightName);
            client.toggleLight(lightName);
            client.getLightStatus(lightName);
        } finally {
            client.shutdown();
        }
    }
}
