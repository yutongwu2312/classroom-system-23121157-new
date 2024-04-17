package com.classroomsystem.client;

import com.classroomsystem.ComputerProto;
import com.classroomsystem.LightProto;
import com.classroomsystem.ComputerServiceGrpc;
import com.classroomsystem.LightServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.concurrent.TimeUnit;

public class ControlGUI extends Application {

    private final ManagedChannel channel;
    private final ComputerServiceGrpc.ComputerServiceBlockingStub computerStub;
    private final LightServiceGrpc.LightServiceBlockingStub lightStub;

    private Label computerStatusLabel;
    private Label lightStatusLabel;

    public ControlGUI() {
        // 创建与 gRPC 服务器的通道
        channel = ManagedChannelBuilder.forAddress("localhost", 50053) // 请根据你的服务器地址和端口号修改
                .usePlaintext() // 使用明文通信
                .build();

        // 创建 ComputerServiceBlockingStub 和 LightServiceBlockingStub 客户端 stub
        computerStub = ComputerServiceGrpc.newBlockingStub(channel);
        lightStub = LightServiceGrpc.newBlockingStub(channel);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Classroom System Control");

        // Computer controls
        computerStatusLabel = new Label("Computer Status: Off");
        Button toggleComputerButton = new Button("Toggle Computer");
        toggleComputerButton.setOnAction(e -> {
            // 发送请求并更新界面
            ComputerProto.ComputerStatus status = computerStub.toggle(ComputerProto.ComputerStatus.newBuilder().setName("Computer 1").build());
            updateComputerStatusLabel(status);
        });

        // Light controls
        lightStatusLabel = new Label("Light Status: Off");
        Button toggleLightButton = new Button("Toggle Light");
        toggleLightButton.setOnAction(e -> {
            // 发送请求并更新界面
            LightProto.LightStatus status = lightStub.toggle(LightProto.LightStatus.newBuilder().setName("Light 1").build());
            updateLightStatusLabel(status);
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));
        layout.getChildren().addAll(computerStatusLabel, toggleComputerButton, lightStatusLabel, toggleLightButton);

        Scene scene = new Scene(layout, 250, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void updateComputerStatusLabel(ComputerProto.ComputerStatus status) {
        String statusText = status.getIsOn() ? "On" : "Off";
        computerStatusLabel.setText("Computer Status: " + statusText);
    }

    private void updateLightStatusLabel(LightProto.LightStatus status) {
        String statusText = status.getIsOn() ? "On" : "Off";
        lightStatusLabel.setText("Light Status: " + statusText);
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        // 关闭与 gRPC 服务器的通道
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
