package com.classroomsystem.server;

import com.classroomsystem.LightProto;
import com.classroomsystem.ComputerProto;
import com.classroomsystem.MobileAppServiceGrpc;
import io.grpc.stub.StreamObserver;

public class MobileServiceImpl extends MobileAppServiceGrpc.MobileAppServiceImplBase {

    private boolean isLightOn = false; // Default light status
    private boolean isComputerOn = false; // Default computer status


    public void getLightStatus(LightProto.LightStatus request, StreamObserver<LightProto.LightStatus> responseObserver) {
        LightProto.LightStatus response = LightProto.LightStatus.newBuilder()
                .setName(request.getName())
                .setIsOn(isLightOn)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


    public void toggleLight(LightProto.LightStatus request, StreamObserver<LightProto.LightStatus> responseObserver) {
        isLightOn = !isLightOn; // Toggle light status
        LightProto.LightStatus response = LightProto.LightStatus.newBuilder()
                .setName(request.getName())
                .setIsOn(isLightOn)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


    public void getComputerStatus(ComputerProto.ComputerStatus request, StreamObserver<ComputerProto.ComputerStatus> responseObserver) {
        ComputerProto.ComputerStatus response = ComputerProto.ComputerStatus.newBuilder()
                .setName(request.getName())
                .setIsOn(isComputerOn)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


    public void toggleComputer(ComputerProto.ComputerStatus request, StreamObserver<ComputerProto.ComputerStatus> responseObserver) {
        isComputerOn = !isComputerOn; // Toggle computer status
        ComputerProto.ComputerStatus response = ComputerProto.ComputerStatus.newBuilder()
                .setName(request.getName())
                .setIsOn(isComputerOn)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
