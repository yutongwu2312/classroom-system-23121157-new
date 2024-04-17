package com.classroomsystem.client;

import com.classroomsystem.ComputerProto;
import com.classroomsystem.ComputerServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.util.concurrent.TimeUnit;

public class ComputerClient {
    private final ManagedChannel channel;
    private final ComputerServiceGrpc.ComputerServiceBlockingStub blockingStub;

    public ComputerClient(String host, int port) {
        // 使用明文传输，注意生产环境中应该使用加密传输
        channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        blockingStub = ComputerServiceGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public void getComputerStatus(String name) {
        ComputerProto.ComputerStatus request = ComputerProto.ComputerStatus.newBuilder()
                .setName(name)
                .build();
        ComputerProto.ComputerStatus response;
        try {
            response = blockingStub.getStatus(request);
            System.out.println("Computer status for " + name + ": " + (response.getIsOn() ? "On" : "Off"));
        } catch (StatusRuntimeException e) {
            System.err.println("RPC failed: " + e.getStatus());
        }
    }

    public void toggleComputer(String name) {
        ComputerProto.ComputerStatus request = ComputerProto.ComputerStatus.newBuilder()
                .setName(name)
                .build();
        ComputerProto.ComputerStatus response;
        try {
            response = blockingStub.toggle(request);
            System.out.println("Toggled computer for " + name + ". New status: " + (response.getIsOn() ? "On" : "Off"));
        } catch (StatusRuntimeException e) {
            System.err.println("RPC failed: " + e.getStatus());
        }
    }

    public static void main(String[] args) throws Exception {
        ComputerClient client = new ComputerClient("localhost", 50053); // 确保这里的端口号与服务器的端口号相匹配
        try {
            String computerName = "Office Computer"; // 你可以根据需要修改计算机的名称
            client.getComputerStatus(computerName);
            client.toggleComputer(computerName);
            client.getComputerStatus(computerName);
        } finally {
            client.shutdown();
        }
    }
}
