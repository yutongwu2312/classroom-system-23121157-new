package com.classroomsystem.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import com.orbitz.consul.AgentClient;
import com.orbitz.consul.Consul;
import com.orbitz.consul.model.agent.ImmutableRegistration;

public class LightServer {
    public static void main(String[] args) throws Exception {
        int port = 50051;

        // Create a new server
        Server server = ServerBuilder.forPort(port)
                .addService(new LightServiceImpl())
                .build()
                .start();

        // Register the service with Consul
        Consul consul = Consul.builder().build(); // Assumes Consul is running locally
        AgentClient agentClient = consul.agentClient();

        ImmutableRegistration registration = ImmutableRegistration.builder()
                .id("light-service-" + port)
                .name("light-service")
                .address("localhost") // Change to actual address if needed
                .port(port)
                .build();

        agentClient.register(registration);

        System.out.println("服务器启动，监听端口 " + port);

        // Wait for the server to terminate
        server.awaitTermination();
    }
}
