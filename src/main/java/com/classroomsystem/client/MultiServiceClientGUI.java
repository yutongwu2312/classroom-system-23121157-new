package com.classroomsystem.client;

import com.classroomsystem.*;
import com.classroomsystem.LightProto.*;
import com.classroomsystem.ComputerProto.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.*;

public class MultiServiceClientGUI extends JFrame {

    private static final String SERVER_HOST = "localhost";
    private static final int AIR_CONDITIONER_PORT = 8082;
    private static final int COMPUTER_PORT = 8081;
    private static final int LIGHT_PORT = 8080;

    private final JButton airOnButton;
    private final JButton airOffButton;
    private final JButton computerOnButton;
    private final JButton computerOffButton;
    private final JButton lightOnButton;
    private final JButton lightOffButton;
    private final JButton lightHighButton;
    private final JButton lightLowButton;
    private final JTextField temperatureField;

    private final ManagedChannel airChannel;
    private final ManagedChannel computerChannel;
    private final ManagedChannel lightChannel;

    public MultiServiceClientGUI() {
        setTitle("多服务控制");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 创建通道
        airChannel = ManagedChannelBuilder.forAddress(SERVER_HOST, AIR_CONDITIONER_PORT)
                .usePlaintext()
                .build();
        computerChannel = ManagedChannelBuilder.forAddress(SERVER_HOST, COMPUTER_PORT)
                .usePlaintext()
                .build();
        lightChannel = ManagedChannelBuilder.forAddress(SERVER_HOST, LIGHT_PORT)
                .usePlaintext()
                .build();

        // 创建存根
        AirConditionerControlServiceGrpc.AirConditionerControlServiceStub airStub = AirConditionerControlServiceGrpc.newStub(airChannel);
        LightControlServiceGrpc.LightControlServiceStub lightStub = LightControlServiceGrpc.newStub(lightChannel);
        ComputerControlServiceGrpc.ComputerControlServiceStub computerStub = ComputerControlServiceGrpc.newStub(computerChannel);

        // 创建按钮和文本框
        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));
        airOnButton = new JButton("开启空调");
        airOffButton = new JButton("关闭空调");
        computerOnButton = new JButton("开启电脑");
        computerOffButton = new JButton("关闭电脑");
        lightOnButton = new JButton("开启灯光");
        lightOffButton = new JButton("关闭灯光");
        lightHighButton = new JButton("高亮度");
        lightLowButton = new JButton("低亮度");
        temperatureField = new JTextField();
        JButton setAirTemperatureButton = new JButton("设置温度");

        // 添加按钮和文本框到面板
        panel.add(airOnButton);
        panel.add(airOffButton);
        panel.add(computerOnButton);
        panel.add(computerOffButton);
        panel.add(lightOnButton);
        panel.add(lightOffButton);
        panel.add(lightHighButton);
        panel.add(lightLowButton);
        panel.add(temperatureField);
        panel.add(setAirTemperatureButton);

        // 添加面板到窗口
        add(panel);

        // 添加事件监听器
        airOnButton.addActionListener(e -> switchAirConditioner(airStub, true));
        airOffButton.addActionListener(e -> switchAirConditioner(airStub, false));
        computerOnButton.addActionListener(e -> toggleComputers(computerStub, true));
        computerOffButton.addActionListener(e -> toggleComputers(computerStub, false));
        lightOnButton.addActionListener(e -> switchLight(lightStub, true));
        lightOffButton.addActionListener(e -> switchLight(lightStub, false));
        lightHighButton.addActionListener(e -> adjustBrightness(lightStub, BrightnessRequest.BrightnessLevel.HIGH));
        lightLowButton.addActionListener(e -> adjustBrightness(lightStub, BrightnessRequest.BrightnessLevel.LOW));
        setAirTemperatureButton.addActionListener(e -> setAirTemperature(airStub, temperatureField.getText()));

        setVisible(true);
    }

    private void switchAirConditioner(AirConditionerControlServiceGrpc.AirConditionerControlServiceStub stub, boolean turnOn) {
        AirConditionProto.SwitchAirConditionerRequest request = AirConditionProto.SwitchAirConditionerRequest.newBuilder()
                .setTurnOn(turnOn)
                .build();
        stub.switchAirConditioner(request, new StreamObserver<AirConditionProto.SwitchAirConditionerResponse>() {
            @Override
            public void onNext(AirConditionProto.SwitchAirConditionerResponse response) {
                System.out.println("空调响应: " + response.getMessage());
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("空调出错: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("空调请求完成");
            }
        });
    }

    private void toggleComputers(ComputerControlServiceGrpc.ComputerControlServiceStub stub, boolean powerOn) {
        ToggleComputersRequest request = ToggleComputersRequest.newBuilder()
                .setPowerOn(powerOn)
                .build();
        stub.toggleComputers(request, new StreamObserver<ToggleComputersResponse>() {
            @Override
            public void onNext(ToggleComputersResponse response) {
                System.out.println("电脑响应: " + response.getMessage());
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("电脑控制出错: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("电脑控制请求完成");
            }
        });
    }

    private void switchLight(LightControlServiceGrpc.LightControlServiceStub stub, boolean turnOn) {
        SwitchLightRequest request = SwitchLightRequest.newBuilder()
                .setTurnOn(turnOn)
                .build();
        stub.switchLight(request, new StreamObserver<SwitchLightResponse>() {
            @Override
            public void onNext(SwitchLightResponse response) {
                System.out.println("灯光响应: " + response.getMessage());
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("灯光出错: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("灯光请求完成");
            }
        });
    }

    private void adjustBrightness(LightControlServiceGrpc.LightControlServiceStub stub, BrightnessRequest.BrightnessLevel level) {
        BrightnessRequest request = BrightnessRequest.newBuilder()
                .setLevel(level)
                .build();
        stub.adjustBrightness(request, new StreamObserver<BrightnessResponse>() {
            @Override
            public void onNext(BrightnessResponse response) {
                System.out.println("亮度调整响应: " + response.getMessage());
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("亮度调整出错: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("亮度调整请求完成");
            }
        });
    }

    private void setAirTemperature(AirConditionerControlServiceGrpc.AirConditionerControlServiceStub stub, String temperature) {
        try {
            float temp = Float.parseFloat(temperature);
            AirConditionProto.SetTemperatureRequest request = AirConditionProto.SetTemperatureRequest.newBuilder()
                    .setTemperatureCelsius(temp)
                    .build();
            stub.setTemperature(request, new StreamObserver<AirConditionProto.SetTemperatureResponse>() {
                @Override
                public void onNext(AirConditionProto.SetTemperatureResponse response) {
                    System.out.println("设置温度响应: " + response.getMessage());
                }

                @Override
                public void onError(Throwable t) {
                    System.err.println("设置温度出错: " + t.getMessage());
                }

                @Override
                public void onCompleted() {
                    System.out.println("设置温度请求完成");
                }
            });
        } catch (NumberFormatException e) {
            System.err.println("温度值无效。请输入有效数字。");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MultiServiceClientGUI::new);
    }
}
