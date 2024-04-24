package com.classroomsystem.client;


import com.classroomsystem.AirConditionProto;
import com.classroomsystem.AirConditionerControlServiceGrpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class AirconditionServiceClient {

    private final ManagedChannel channel;
    private final AirConditionerControlServiceGrpc.AirConditionerControlServiceStub stub;

    public AirconditionServiceClient(String host, int port) {
        this.channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        this.stub = AirConditionerControlServiceGrpc.newStub(channel);
    }

    public void switchAirConditioner(boolean turnOn) {
        AirConditionProto.SwitchAirConditionerRequest request = AirConditionProto.SwitchAirConditionerRequest.newBuilder()
                .setTurnOn(turnOn)
                .build();
        stub.switchAirConditioner(request, new StreamObserver<AirConditionProto.SwitchAirConditionerResponse>() {
            @Override
            public void onNext(AirConditionProto.SwitchAirConditionerResponse response) {
                System.out.println("SwitchAirConditioner response: " + response.getMessage());
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Error in switchAirConditioner: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("SwitchAirConditioner request completed");
            }
        });
    }

    public void setTemperature(float temperatureCelsius) {
        AirConditionProto.SetTemperatureRequest request = AirConditionProto.SetTemperatureRequest.newBuilder()
                .setTemperatureCelsius(temperatureCelsius)
                .build();
        stub.setTemperature(request, new StreamObserver<AirConditionProto.SetTemperatureResponse>() {
            @Override
            public void onNext(AirConditionProto.SetTemperatureResponse response) {
                System.out.println("SetTemperature response: " + response.getMessage());
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Error in setTemperature: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("SetTemperature request completed");
            }
        });
    }

    public void streamTemperatureAdjustments() {
        StreamObserver<AirConditionProto.SetTemperatureRequest> requestObserver = stub.streamTemperatureAdjustments(new StreamObserver<AirConditionProto.StreamTemperatureAdjustmentsResponse>() {
            @Override
            public void onNext(AirConditionProto.StreamTemperatureAdjustmentsResponse response) {
                System.out.println("StreamTemperatureAdjustments response: " + response.getMessage());
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Error in streamTemperatureAdjustments: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("StreamTemperatureAdjustments request completed");
            }
        });

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter temperature value (type 'exit' to quit): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                requestObserver.onCompleted();
                break;
            } else {
                try {
                    float temperature = Float.parseFloat(input);
                    AirConditionProto.SetTemperatureRequest request = AirConditionProto.SetTemperatureRequest.newBuilder()
                            .setTemperatureCelsius(temperature)
                            .build();
                    requestObserver.onNext(request);
                } catch (NumberFormatException e) {
                    System.err.println("Invalid temperature value. Please enter a valid number.");
                }
            }
        }
    }

    public void shutdown() {
        try {
            channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("Error while shutting down client: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        AirconditionServiceClient client = new AirconditionServiceClient("localhost", 8082);
        client.switchAirConditioner(true); // Example: Turn on the air conditioner
        client.setTemperature(25.5f); // Example: Set the temperature to 25.5 degrees Celsius
        client.streamTemperatureAdjustments(); // Example: Stream temperature adjustments
        client.shutdown(); // Shutdown the client
    }
}
