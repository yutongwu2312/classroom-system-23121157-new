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
            public void onNext(ToggleComputersResponse response) {
                System.out.println("Computer switch response: " + response.getMessage());
            }

            public void onError(Throwable t) {
                System.err.println("Error while switching computer state: " + t.getMessage());
            }

            public void onCompleted() {
                System.out.println("Computer switch request completed");
            }
        });
    }

    public void monitorComputers() {
        StreamObserver<ComputerStatusResponse> responseObserver = new StreamObserver<ComputerStatusResponse>() {
            public void onNext(ComputerStatusResponse response) {
                System.out.println("Computer Status:" + (response.getIsOn() ? "open" : "close") + ", message: " + response.getStatusInfo());
            }

            public void onError(Throwable t) {
                System.err.println("Error monitoring computer status: " + t.getMessage());
            }

            public void onCompleted() {
                System.out.println("computer monitor stream ends");
            }
        };

        stub.monitorComputers(Empty.newBuilder().build(), responseObserver);
    }

    public static void main(String[] args) {
        ComputerServiceClient client = new ComputerServiceClient("localhost", 8081);

        //switch computer status
        System.out.println("Starting the computer");
        client.toggleComputers(true);

        client.monitorComputers();

        //exit
        Scanner scanner = new Scanner(System.in);
        System.out.println("press 'Q' exit");
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
            System.err.println("Error while closing client: " + e.getMessage());
        }
    }
}
