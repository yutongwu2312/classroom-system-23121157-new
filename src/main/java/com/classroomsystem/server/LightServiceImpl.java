package com.classroomsystem.server;

import com.classroomsystem.LightProto;
import com.classroomsystem.LightServiceGrpc;
import io.grpc.stub.StreamObserver;

public class LightServiceImpl extends LightServiceGrpc.LightServiceImplBase {

    private boolean isLightOn = false; // 默认灯光状态

    @Override
    public void getStatus(LightProto.LightStatus request, StreamObserver<LightProto.LightStatus> responseObserver) {
        LightProto.LightStatus response = LightProto.LightStatus.newBuilder()
                .setName(request.getName())
                .setIsOn(isLightOn)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void toggle(LightProto.LightStatus request, StreamObserver<LightProto.LightStatus> responseObserver) {
        isLightOn = !isLightOn; // 切换灯光状态
        LightProto.LightStatus response = LightProto.LightStatus.newBuilder()
                .setName(request.getName())
                .setIsOn(isLightOn)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    public boolean isLightOn() {
        return isLightOn;
    }
}
