package com.classroomsystem;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.14.0)",
    comments = "Source: mobile.proto")
public final class MobileAppServiceGrpc {

  private MobileAppServiceGrpc() {}

  public static final String SERVICE_NAME = "mobileapp.MobileAppService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<LightProto.LightStatus,
      LightProto.LightStatus> getGetLightStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetLightStatus",
      requestType = LightProto.LightStatus.class,
      responseType = LightProto.LightStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<LightProto.LightStatus,
      LightProto.LightStatus> getGetLightStatusMethod() {
    io.grpc.MethodDescriptor<LightProto.LightStatus, LightProto.LightStatus> getGetLightStatusMethod;
    if ((getGetLightStatusMethod = MobileAppServiceGrpc.getGetLightStatusMethod) == null) {
      synchronized (MobileAppServiceGrpc.class) {
        if ((getGetLightStatusMethod = MobileAppServiceGrpc.getGetLightStatusMethod) == null) {
          MobileAppServiceGrpc.getGetLightStatusMethod = getGetLightStatusMethod = 
              io.grpc.MethodDescriptor.<LightProto.LightStatus, LightProto.LightStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "mobileapp.MobileAppService", "GetLightStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  LightProto.LightStatus.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  LightProto.LightStatus.getDefaultInstance()))
                  .setSchemaDescriptor(new MobileAppServiceMethodDescriptorSupplier("GetLightStatus"))
                  .build();
          }
        }
     }
     return getGetLightStatusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<LightProto.LightStatus,
      LightProto.LightStatus> getToggleLightMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ToggleLight",
      requestType = LightProto.LightStatus.class,
      responseType = LightProto.LightStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<LightProto.LightStatus,
      LightProto.LightStatus> getToggleLightMethod() {
    io.grpc.MethodDescriptor<LightProto.LightStatus, LightProto.LightStatus> getToggleLightMethod;
    if ((getToggleLightMethod = MobileAppServiceGrpc.getToggleLightMethod) == null) {
      synchronized (MobileAppServiceGrpc.class) {
        if ((getToggleLightMethod = MobileAppServiceGrpc.getToggleLightMethod) == null) {
          MobileAppServiceGrpc.getToggleLightMethod = getToggleLightMethod = 
              io.grpc.MethodDescriptor.<LightProto.LightStatus, LightProto.LightStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "mobileapp.MobileAppService", "ToggleLight"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  LightProto.LightStatus.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  LightProto.LightStatus.getDefaultInstance()))
                  .setSchemaDescriptor(new MobileAppServiceMethodDescriptorSupplier("ToggleLight"))
                  .build();
          }
        }
     }
     return getToggleLightMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ComputerProto.ComputerStatus,
      ComputerProto.ComputerStatus> getGetComputerStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetComputerStatus",
      requestType = ComputerProto.ComputerStatus.class,
      responseType = ComputerProto.ComputerStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ComputerProto.ComputerStatus,
      ComputerProto.ComputerStatus> getGetComputerStatusMethod() {
    io.grpc.MethodDescriptor<ComputerProto.ComputerStatus, ComputerProto.ComputerStatus> getGetComputerStatusMethod;
    if ((getGetComputerStatusMethod = MobileAppServiceGrpc.getGetComputerStatusMethod) == null) {
      synchronized (MobileAppServiceGrpc.class) {
        if ((getGetComputerStatusMethod = MobileAppServiceGrpc.getGetComputerStatusMethod) == null) {
          MobileAppServiceGrpc.getGetComputerStatusMethod = getGetComputerStatusMethod = 
              io.grpc.MethodDescriptor.<ComputerProto.ComputerStatus, ComputerProto.ComputerStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "mobileapp.MobileAppService", "GetComputerStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ComputerProto.ComputerStatus.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ComputerProto.ComputerStatus.getDefaultInstance()))
                  .setSchemaDescriptor(new MobileAppServiceMethodDescriptorSupplier("GetComputerStatus"))
                  .build();
          }
        }
     }
     return getGetComputerStatusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ComputerProto.ComputerStatus,
      ComputerProto.ComputerStatus> getToggleComputerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ToggleComputer",
      requestType = ComputerProto.ComputerStatus.class,
      responseType = ComputerProto.ComputerStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ComputerProto.ComputerStatus,
      ComputerProto.ComputerStatus> getToggleComputerMethod() {
    io.grpc.MethodDescriptor<ComputerProto.ComputerStatus, ComputerProto.ComputerStatus> getToggleComputerMethod;
    if ((getToggleComputerMethod = MobileAppServiceGrpc.getToggleComputerMethod) == null) {
      synchronized (MobileAppServiceGrpc.class) {
        if ((getToggleComputerMethod = MobileAppServiceGrpc.getToggleComputerMethod) == null) {
          MobileAppServiceGrpc.getToggleComputerMethod = getToggleComputerMethod = 
              io.grpc.MethodDescriptor.<ComputerProto.ComputerStatus, ComputerProto.ComputerStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "mobileapp.MobileAppService", "ToggleComputer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ComputerProto.ComputerStatus.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ComputerProto.ComputerStatus.getDefaultInstance()))
                  .setSchemaDescriptor(new MobileAppServiceMethodDescriptorSupplier("ToggleComputer"))
                  .build();
          }
        }
     }
     return getToggleComputerMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MobileAppServiceStub newStub(io.grpc.Channel channel) {
    return new MobileAppServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MobileAppServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new MobileAppServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MobileAppServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new MobileAppServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class MobileAppServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * 获取灯的状态
     * </pre>
     */
    public void getLightStatus(LightProto.LightStatus request,
                               io.grpc.stub.StreamObserver<LightProto.LightStatus> responseObserver) {
      asyncUnimplementedUnaryCall(getGetLightStatusMethod(), responseObserver);
    }

    /**
     * <pre>
     * 切换灯的开关状态
     * </pre>
     */
    public void toggleLight(LightProto.LightStatus request,
                            io.grpc.stub.StreamObserver<LightProto.LightStatus> responseObserver) {
      asyncUnimplementedUnaryCall(getToggleLightMethod(), responseObserver);
    }

    /**
     * <pre>
     * 获取电脑的状态
     * </pre>
     */
    public void getComputerStatus(ComputerProto.ComputerStatus request,
                                  io.grpc.stub.StreamObserver<ComputerProto.ComputerStatus> responseObserver) {
      asyncUnimplementedUnaryCall(getGetComputerStatusMethod(), responseObserver);
    }

    /**
     * <pre>
     * 切换电脑的开关状态
     * </pre>
     */
    public void toggleComputer(ComputerProto.ComputerStatus request,
                               io.grpc.stub.StreamObserver<ComputerProto.ComputerStatus> responseObserver) {
      asyncUnimplementedUnaryCall(getToggleComputerMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetLightStatusMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                LightProto.LightStatus,
                LightProto.LightStatus>(
                  this, METHODID_GET_LIGHT_STATUS)))
          .addMethod(
            getToggleLightMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                LightProto.LightStatus,
                LightProto.LightStatus>(
                  this, METHODID_TOGGLE_LIGHT)))
          .addMethod(
            getGetComputerStatusMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ComputerProto.ComputerStatus,
                ComputerProto.ComputerStatus>(
                  this, METHODID_GET_COMPUTER_STATUS)))
          .addMethod(
            getToggleComputerMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ComputerProto.ComputerStatus,
                ComputerProto.ComputerStatus>(
                  this, METHODID_TOGGLE_COMPUTER)))
          .build();
    }
  }

  /**
   */
  public static final class MobileAppServiceStub extends io.grpc.stub.AbstractStub<MobileAppServiceStub> {
    private MobileAppServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MobileAppServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected MobileAppServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MobileAppServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * 获取灯的状态
     * </pre>
     */
    public void getLightStatus(LightProto.LightStatus request,
                               io.grpc.stub.StreamObserver<LightProto.LightStatus> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetLightStatusMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 切换灯的开关状态
     * </pre>
     */
    public void toggleLight(LightProto.LightStatus request,
                            io.grpc.stub.StreamObserver<LightProto.LightStatus> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getToggleLightMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 获取电脑的状态
     * </pre>
     */
    public void getComputerStatus(ComputerProto.ComputerStatus request,
                                  io.grpc.stub.StreamObserver<ComputerProto.ComputerStatus> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetComputerStatusMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 切换电脑的开关状态
     * </pre>
     */
    public void toggleComputer(ComputerProto.ComputerStatus request,
                               io.grpc.stub.StreamObserver<ComputerProto.ComputerStatus> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getToggleComputerMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class MobileAppServiceBlockingStub extends io.grpc.stub.AbstractStub<MobileAppServiceBlockingStub> {
    private MobileAppServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MobileAppServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected MobileAppServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MobileAppServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * 获取灯的状态
     * </pre>
     */
    public LightProto.LightStatus getLightStatus(LightProto.LightStatus request) {
      return blockingUnaryCall(
          getChannel(), getGetLightStatusMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * 切换灯的开关状态
     * </pre>
     */
    public LightProto.LightStatus toggleLight(LightProto.LightStatus request) {
      return blockingUnaryCall(
          getChannel(), getToggleLightMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * 获取电脑的状态
     * </pre>
     */
    public ComputerProto.ComputerStatus getComputerStatus(ComputerProto.ComputerStatus request) {
      return blockingUnaryCall(
          getChannel(), getGetComputerStatusMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * 切换电脑的开关状态
     * </pre>
     */
    public ComputerProto.ComputerStatus toggleComputer(ComputerProto.ComputerStatus request) {
      return blockingUnaryCall(
          getChannel(), getToggleComputerMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class MobileAppServiceFutureStub extends io.grpc.stub.AbstractStub<MobileAppServiceFutureStub> {
    private MobileAppServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MobileAppServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected MobileAppServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MobileAppServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * 获取灯的状态
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<LightProto.LightStatus> getLightStatus(
        LightProto.LightStatus request) {
      return futureUnaryCall(
          getChannel().newCall(getGetLightStatusMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * 切换灯的开关状态
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<LightProto.LightStatus> toggleLight(
        LightProto.LightStatus request) {
      return futureUnaryCall(
          getChannel().newCall(getToggleLightMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * 获取电脑的状态
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ComputerProto.ComputerStatus> getComputerStatus(
        ComputerProto.ComputerStatus request) {
      return futureUnaryCall(
          getChannel().newCall(getGetComputerStatusMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * 切换电脑的开关状态
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ComputerProto.ComputerStatus> toggleComputer(
        ComputerProto.ComputerStatus request) {
      return futureUnaryCall(
          getChannel().newCall(getToggleComputerMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_LIGHT_STATUS = 0;
  private static final int METHODID_TOGGLE_LIGHT = 1;
  private static final int METHODID_GET_COMPUTER_STATUS = 2;
  private static final int METHODID_TOGGLE_COMPUTER = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MobileAppServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MobileAppServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_LIGHT_STATUS:
          serviceImpl.getLightStatus((LightProto.LightStatus) request,
              (io.grpc.stub.StreamObserver<LightProto.LightStatus>) responseObserver);
          break;
        case METHODID_TOGGLE_LIGHT:
          serviceImpl.toggleLight((LightProto.LightStatus) request,
              (io.grpc.stub.StreamObserver<LightProto.LightStatus>) responseObserver);
          break;
        case METHODID_GET_COMPUTER_STATUS:
          serviceImpl.getComputerStatus((ComputerProto.ComputerStatus) request,
              (io.grpc.stub.StreamObserver<ComputerProto.ComputerStatus>) responseObserver);
          break;
        case METHODID_TOGGLE_COMPUTER:
          serviceImpl.toggleComputer((ComputerProto.ComputerStatus) request,
              (io.grpc.stub.StreamObserver<ComputerProto.ComputerStatus>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class MobileAppServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MobileAppServiceBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return MobileProto.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MobileAppService");
    }
  }

  private static final class MobileAppServiceFileDescriptorSupplier
      extends MobileAppServiceBaseDescriptorSupplier {
    MobileAppServiceFileDescriptorSupplier() {}
  }

  private static final class MobileAppServiceMethodDescriptorSupplier
      extends MobileAppServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MobileAppServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (MobileAppServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MobileAppServiceFileDescriptorSupplier())
              .addMethod(getGetLightStatusMethod())
              .addMethod(getToggleLightMethod())
              .addMethod(getGetComputerStatusMethod())
              .addMethod(getToggleComputerMethod())
              .build();
        }
      }
    }
    return result;
  }
}
