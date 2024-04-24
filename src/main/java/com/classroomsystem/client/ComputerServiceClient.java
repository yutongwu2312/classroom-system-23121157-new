package com.classroomsystem.client;

import com.classroomsystem.ComputerControlServiceGrpc;
import com.classroomsystem.ComputerProto.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ComputerServiceClient {

    private final ManagedChannel channel;
    private final ComputerControlServiceGrpc.ComputerControlServiceStub stub;

    public ComputerServiceClient(String host, int port) {
        this.channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        this.stub = ComputerControlServiceGrpc.newStub(channel);
    }

    public void toggleComputers(boolean powerOn) {
        ToggleComputersRequest request = ToggleComputersRequest.newBuilder()
                .setPowerOn(powerOn)
                .build();
        stub.toggleComputers(request, new StreamObserver<ToggleComputersResponse>() {
            @Override
            public void onNext(ToggleComputersResponse response) {
                System.out.println("电脑开关响应: " + response.getMessage());
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("切换电脑状态时出错: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("电脑开关请求完成");
            }
        });
    }

    public void monitorComputers() {
        StreamObserver<ComputerStatusResponse> responseObserver = new StreamObserver<ComputerStatusResponse>() {
            @Override
            public void onNext(ComputerStatusResponse response) {
                System.out.println("电脑状态: " + (response.getIsOn() ? "开机" : "关机") + ", 信息: " + response.getStatusInfo());
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("监视电脑状态时出错: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("电脑监视流结束");
            }
        };

        stub.monitorComputers(Empty.newBuilder().build(), responseObserver);
    }

    public static void main(String[] args) {
        ComputerServiceClient client = new ComputerServiceClient("localhost", 8081);

        // 切换电脑状态
        System.out.println("正在开启电脑");
        client.toggleComputers(true);

        // 监视电脑状态
        client.monitorComputers();

        // 退出
        Scanner scanner = new Scanner(System.in);
        System.out.println("按 'Q' 退出");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("Q")) {
                client.shutdown();
                break;
            }
        }
    }

    public void shutdown() {
        try {
            channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("关闭客户端时出错: " + e.getMessage());
        }
    }
}
