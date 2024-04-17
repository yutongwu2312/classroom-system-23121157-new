package com.classroomsystem.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;


public class LightServer {
    public static void main(String[] args) throws Exception {
        int port = 50051;
        Server server = ServerBuilder.forPort(port)
                .addService(new LightServiceImpl())
                .build()
                .start();

        System.out.println("服务器启动，监听端口 " + port);
        server.awaitTermination();
    }
}

