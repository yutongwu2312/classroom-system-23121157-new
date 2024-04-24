package com.classroomsystem.server;

import com.classroomsystem.LightControlServiceGrpc;
import com.classroomsystem.LightProto.*;
import com.orbitz.consul.AgentClient;
import com.orbitz.consul.Consul;
import com.orbitz.consul.model.agent.ImmutableRegistration;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LightControlServer {

    private static final int PORT = 8080;
    private static final String SERVICE_ID = "light-control-server";
    private static final String SERVICE_NAME = "lightcontrol";

    public static void main(String[] args) throws IOException, InterruptedException {
        // Initialize Consul client
        Consul consul = Consul.builder().build();
        AgentClient agentClient = consul.agentClient();

        // Create service registration object with Consul
        ImmutableRegistration registration = ImmutableRegistration.builder()
                .id(SERVICE_ID)
                .name(SERVICE_NAME)
                .address("localhost")
                .port(PORT)
                .addTags("gRPC")
                .build();

        // Register service
        agentClient.register(registration);

        Server server = ServerBuilder.forPort(PORT)
                .addService(new LightControlServiceImpl())
                .build();

        server.start();
        System.out.println("Server started, listening on port " + PORT);

        // Graceful shutdown
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down gRPC server due to JVM shutdown");
            try {
                server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace(System.err);
            } finally {
                // Deregister service
                agentClient.deregister(SERVICE_ID);
                System.out.println("Server shut down and service deregistered");
            }
        }));

        server.awaitTermination();
    }

    static class LightControlServiceImpl extends LightControlServiceGrpc.LightControlServiceImplBase {

        @Override
        public void switchLight(SwitchLightRequest request, StreamObserver<SwitchLightResponse> responseObserver) {
            System.out.println("Switching lights " + (request.getTurnOn() ? "on" : "off"));

            SwitchLightResponse response = SwitchLightResponse.newBuilder()
                    .setSuccess(true)
                    .setMessage("Light has been " + (request.getTurnOn() ? "turned on" : "turned off"))
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        @Override
        public void adjustBrightness(BrightnessRequest request, StreamObserver<BrightnessResponse> responseObserver) {
            System.out.println("Adjusting brightness to " + (request.getLevel() == BrightnessRequest.BrightnessLevel.HIGH ? "high" : "low"));

            BrightnessResponse response = BrightnessResponse.newBuilder()
                    .setSuccess(true)
                    .setMessage("Brightness adjusted to " + (request.getLevel() == BrightnessRequest.BrightnessLevel.HIGH ? "high" : "low"))
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        @Override
        public StreamObserver<LightControlMessage> streamLightControl(StreamObserver<LightControlMessage> responseObserver) {
            return new StreamObserver<LightControlMessage>() {
                @Override
                public void onNext(LightControlMessage message) {
                    System.out.println("Received streaming message: " + message);
                    responseObserver.onNext(message);
                }

                @Override
                public void onError(Throwable t) {
                    System.err.println("Error in streaming: " + t.getMessage());
                    responseObserver.onError(t);
                }

                @Override
                public void onCompleted() {
                    System.out.println("Completed incoming stream.");
                    responseObserver.onCompleted();
                }
            };
        }
    }
}
