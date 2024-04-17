package com.classroomsystem.client;

import com.classroomsystem.LightProto;
import com.classroomsystem.ComputerProto;
import com.classroomsystem.MobileAppServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.util.concurrent.TimeUnit;

public class MobileClient {
    private final ManagedChannel channel;
    private final MobileAppServiceGrpc.MobileAppServiceBlockingStub blockingStub;

    public MobileClient(String host, int port) {
        // 使用明文传输，注意生产环境中应该使用加密传输
        channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        blockingStub = MobileAppServiceGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public void getLightStatus(String name) {
        LightProto.LightStatus request = LightProto.LightStatus.newBuilder().setName(name).build();
        LightProto.LightStatus response;
        try {
            response = blockingStub.getLightStatus(request);
            System.out.println("Light status for " + name + ": " + (response.getIsOn() ? "On" : "Off"));
        } catch (StatusRuntimeException e) {
            System.err.println("RPC failed: " + e.getStatus());
        }
    }

    public void toggleLight(String name) {
        LightProto.LightStatus request = LightProto.LightStatus.newBuilder().setName(name).build();
        LightProto.LightStatus response;
        try {
            response = blockingStub.toggleLight(request);
            System.out.println("Light toggled for " + name + ". New status: " + (response.getIsOn() ? "On" : "Off"));
        } catch (StatusRuntimeException e) {
            System.err.println("RPC failed: " + e.getStatus());
        }
    }

    public void getComputerStatus(String name) {
        ComputerProto.ComputerStatus request = ComputerProto.ComputerStatus.newBuilder().setName(name).build();
        ComputerProto.ComputerStatus response;
        try {
            response = blockingStub.getComputerStatus(request);
            System.out.println("Computer status for " + name + ": " + (response.getIsOn() ? "On" : "Off"));
        } catch (StatusRuntimeException e) {
            System.err.println("RPC failed: " + e.getStatus());
        }
    }

    public void toggleComputer(String name) {
        ComputerProto.ComputerStatus request = ComputerProto.ComputerStatus.newBuilder().setName(name).build();
        ComputerProto.ComputerStatus response;
        try {
            response = blockingStub.toggleComputer(request);
            System.out.println("Computer toggled for " + name + ". New status: " + (response.getIsOn() ? "On" : "Off"));
        } catch (StatusRuntimeException e) {
            System.err.println("RPC failed: " + e.getStatus());
        }
    }

    public static void main(String[] args) throws Exception {
        MobileClient client = new MobileClient("localhost", 50052);
        try {
            String deviceName = "Classroom Device"; // 你可以修改这个设备的名字
            client.getLightStatus(deviceName);
            client.toggleLight(deviceName);
            client.getLightStatus(deviceName);
            client.getComputerStatus(deviceName);
            client.toggleComputer(deviceName);
            client.getComputerStatus(deviceName);
        } finally {
            client.shutdown();
        }
    }
}
