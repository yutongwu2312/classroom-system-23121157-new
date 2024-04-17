package com.classroomsystem.server;


import io.grpc.Server;
import io.grpc.ServerBuilder;

public class MobileServer {
    public static void main(String[] args) throws Exception {
        int port = 50052; // Ensure this port is not in use or is configured correctly for your environment
        Server server = ServerBuilder.forPort(port)
                .addService(new MobileServiceImpl())
                .build()
                .start();

        System.out.println("服务器启动，监听端口 " + port);
        server.awaitTermination();
    }
}
