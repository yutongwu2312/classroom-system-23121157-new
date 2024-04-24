package com.classroomsystem.client;

import com.classroomsystem.*;
import com.classroomsystem.LightProto.*;
import com.classroomsystem.ComputerProto.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import javax.swing.*;
import java.awt.*;


public class ClassroomClientGUI extends JFrame {

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

    public ClassroomClientGUI() {
        setTitle("Classroom control");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        airChannel = ManagedChannelBuilder.forAddress(SERVER_HOST, AIR_CONDITIONER_PORT)
                .usePlaintext()
                .build();
        computerChannel = ManagedChannelBuilder.forAddress(SERVER_HOST, COMPUTER_PORT)
                .usePlaintext()
                .build();
        lightChannel = ManagedChannelBuilder.forAddress(SERVER_HOST, LIGHT_PORT)
                .usePlaintext()
                .build();

        AirConditionerControlServiceGrpc.AirConditionerControlServiceStub airStub = AirConditionerControlServiceGrpc.newStub(airChannel);
        LightControlServiceGrpc.LightControlServiceStub lightStub = LightControlServiceGrpc.newStub(lightChannel);
        ComputerControlServiceGrpc.ComputerControlServiceStub computerStub = ComputerControlServiceGrpc.newStub(computerChannel);

        //create button
        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));
        airOnButton = new JButton("Turn on the air conditioner");
        airOffButton = new JButton("Turn off the air conditioner");
        computerOnButton = new JButton("Turn on the computer");
        computerOffButton = new JButton("Turn off the computer");
        lightOnButton = new JButton("Turn on the light");
        lightOffButton = new JButton("Turn off the light");
        lightHighButton = new JButton("High light");
        lightLowButton = new JButton("low light");
        temperatureField = new JTextField();
        JButton setAirTemperatureButton = new JButton("set temperature");

        //add button
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

        add(panel);

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
            public void onNext(AirConditionProto.SwitchAirConditionerResponse response) {
                System.out.println("Air conditioning response: " + response.getMessage());
            }

            public void onError(Throwable t) {
                System.err.println("Air conditioning error:" + t.getMessage());
            }

            public void onCompleted() {
                System.out.println("Air conditioning request completed");
            }
        });
    }

    private void toggleComputers(ComputerControlServiceGrpc.ComputerControlServiceStub stub, boolean powerOn) {
        ToggleComputersRequest request = ToggleComputersRequest.newBuilder()
                .setPowerOn(powerOn)
                .build();
        stub.toggleComputers(request, new StreamObserver<ToggleComputersResponse>() {
            public void onNext(ToggleComputersResponse response) {
                System.out.println("Computer response:" + response.getMessage());
            }

            public void onError(Throwable t) {
                System.err.println("Computer control error: " + t.getMessage());
            }

            public void onCompleted() {
                System.out.println("Computer control request completed");
            }
        });
    }

    private void switchLight(LightControlServiceGrpc.LightControlServiceStub stub, boolean turnOn) {
        SwitchLightRequest request = SwitchLightRequest.newBuilder()
                .setTurnOn(turnOn)
                .build();
        stub.switchLight(request, new StreamObserver<SwitchLightResponse>() {
            public void onNext(SwitchLightResponse response) {
                System.out.println("Light response:" + response.getMessage());
            }


            public void onError(Throwable t) {
                System.err.println("Lighting error: " + t.getMessage());
            }

            public void onCompleted() {
                System.out.println("Light request completed");
            }
        });
    }

    private void adjustBrightness(LightControlServiceGrpc.LightControlServiceStub stub, BrightnessRequest.BrightnessLevel level) {
        BrightnessRequest request = BrightnessRequest.newBuilder()
                .setLevel(level)
                .build();
        stub.adjustBrightness(request, new StreamObserver<BrightnessResponse>() {
            public void onNext(BrightnessResponse response) {
                System.out.println("Brightness adjustment response: " + response.getMessage());
            }

            public void onError(Throwable t) {
                System.err.println("Brightness adjustment error: " + t.getMessage());
            }

            public void onCompleted() {
                System.out.println("Brightness adjustment request complete");
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
                public void onNext(AirConditionProto.SetTemperatureResponse response) {
                    System.out.println("Setting temperature response: " + response.getMessage());
                }

                public void onError(Throwable t) {
                    System.err.println("Error setting temperature:" + t.getMessage());
                }

                public void onCompleted() {
                    System.out.println("The request for setting the temperature is complete.");
                }
            });
        } catch (NumberFormatException e) {
            System.err.println("The temperature value is invalid. Please enter a valid number.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ClassroomClientGUI::new);
    }
}
