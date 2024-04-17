package com.classroomsystem.server;

import com.classroomsystem.ComputerProto;
import com.classroomsystem.ComputerServiceGrpc;
import io.grpc.stub.StreamObserver;

public class ComputerServiceImpl extends ComputerServiceGrpc.ComputerServiceImplBase {
    private boolean isComputerOn = false; // 默认电脑状态

    @Override
    public void getStatus(ComputerProto.ComputerStatus request, StreamObserver<ComputerProto.ComputerStatus> responseObserver) {
        ComputerProto.ComputerStatus response = ComputerProto.ComputerStatus.newBuilder()
                .setName(request.getName())
                .setIsOn(isComputerOn)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void toggle(ComputerProto.ComputerStatus request, StreamObserver<ComputerProto.ComputerStatus> responseObserver) {
        isComputerOn = !isComputerOn; // 切换电脑状态
        ComputerProto.ComputerStatus response = ComputerProto.ComputerStatus.newBuilder()
                .setName(request.getName())
                .setIsOn(isComputerOn)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
