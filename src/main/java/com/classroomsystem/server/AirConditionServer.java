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
        //Consul Client
        Consul consul = Consul.builder().build();
        consulAgent = consul.agentClient();

        //Register
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
        System.out.println("The server is started, listening port:" + port);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.err.println(" The gRPC server is about to shut down because the JVM is shutting down");
            try {
                AirConditionServer.this.stop();
            } catch (InterruptedException e) {
                e.printStackTrace(System.err);
            }
            System.err.println(" Server shut down");
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
        public void switchAirConditioner(AirConditionProto.SwitchAirConditionerRequest request, StreamObserver<AirConditionProto.SwitchAirConditionerResponse> responseObserver) {
            boolean status = request.getTurnOn();
            AirConditionProto.SwitchAirConditionerResponse response = AirConditionProto.SwitchAirConditionerResponse.newBuilder()
                    .setMessage(status ? "air conditioner is on" : "air conditioner is close")
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        public void setTemperature(AirConditionProto.SetTemperatureRequest request, StreamObserver<AirConditionProto.SetTemperatureResponse> responseObserver) {
            float temperature = request.getTemperatureCelsius();
            AirConditionProto.SetTemperatureResponse response = AirConditionProto.SetTemperatureResponse.newBuilder()
                    .setMessage("Temperature is set to:" + temperature + "°C")
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        public StreamObserver<AirConditionProto.SetTemperatureRequest> streamTemperatureAdjustments(StreamObserver<AirConditionProto.StreamTemperatureAdjustmentsResponse> responseObserver) {
            return new StreamObserver<AirConditionProto.SetTemperatureRequest>() {
                public void onNext(AirConditionProto.SetTemperatureRequest request) {
                    // Handle each temperature regulation
                    float temperature = request.getTemperatureCelsius();
                    System.out.println("Temperature adjustment request received: " + temperature + "°C");
                }

                public void onError(Throwable t) {
                    // handle error
                    System.err.println("An error occurred during flow temperature control:" + t.getMessage());
                }

                public void onCompleted() {
                    AirConditionProto.StreamTemperatureAdjustmentsResponse response = AirConditionProto.StreamTemperatureAdjustmentsResponse.newBuilder()
                            .setMessage("Temperature control complete.")
                            .build();
                    responseObserver.onNext(response);
                    responseObserver.onCompleted();
                }
            };
        }
    }
}
