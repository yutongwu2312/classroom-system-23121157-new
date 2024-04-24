package com.classroomsystem;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * 灯光控制服务，包含开关控制和亮度调节功能
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.63.0)",
    comments = "Source: light.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class LightControlServiceGrpc {

  private LightControlServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "classroom_system.control.LightControlService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.classroomsystem.LightProto.SwitchLightRequest,
      com.classroomsystem.LightProto.SwitchLightResponse> getSwitchLightMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SwitchLight",
      requestType = com.classroomsystem.LightProto.SwitchLightRequest.class,
      responseType = com.classroomsystem.LightProto.SwitchLightResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.classroomsystem.LightProto.SwitchLightRequest,
      com.classroomsystem.LightProto.SwitchLightResponse> getSwitchLightMethod() {
    io.grpc.MethodDescriptor<com.classroomsystem.LightProto.SwitchLightRequest, com.classroomsystem.LightProto.SwitchLightResponse> getSwitchLightMethod;
    if ((getSwitchLightMethod = LightControlServiceGrpc.getSwitchLightMethod) == null) {
      synchronized (LightControlServiceGrpc.class) {
        if ((getSwitchLightMethod = LightControlServiceGrpc.getSwitchLightMethod) == null) {
          LightControlServiceGrpc.getSwitchLightMethod = getSwitchLightMethod =
              io.grpc.MethodDescriptor.<com.classroomsystem.LightProto.SwitchLightRequest, com.classroomsystem.LightProto.SwitchLightResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SwitchLight"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.classroomsystem.LightProto.SwitchLightRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.classroomsystem.LightProto.SwitchLightResponse.getDefaultInstance()))
              .setSchemaDescriptor(new LightControlServiceMethodDescriptorSupplier("SwitchLight"))
              .build();
        }
      }
    }
    return getSwitchLightMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.classroomsystem.LightProto.BrightnessRequest,
      com.classroomsystem.LightProto.BrightnessResponse> getAdjustBrightnessMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AdjustBrightness",
      requestType = com.classroomsystem.LightProto.BrightnessRequest.class,
      responseType = com.classroomsystem.LightProto.BrightnessResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.classroomsystem.LightProto.BrightnessRequest,
      com.classroomsystem.LightProto.BrightnessResponse> getAdjustBrightnessMethod() {
    io.grpc.MethodDescriptor<com.classroomsystem.LightProto.BrightnessRequest, com.classroomsystem.LightProto.BrightnessResponse> getAdjustBrightnessMethod;
    if ((getAdjustBrightnessMethod = LightControlServiceGrpc.getAdjustBrightnessMethod) == null) {
      synchronized (LightControlServiceGrpc.class) {
        if ((getAdjustBrightnessMethod = LightControlServiceGrpc.getAdjustBrightnessMethod) == null) {
          LightControlServiceGrpc.getAdjustBrightnessMethod = getAdjustBrightnessMethod =
              io.grpc.MethodDescriptor.<com.classroomsystem.LightProto.BrightnessRequest, com.classroomsystem.LightProto.BrightnessResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AdjustBrightness"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.classroomsystem.LightProto.BrightnessRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.classroomsystem.LightProto.BrightnessResponse.getDefaultInstance()))
              .setSchemaDescriptor(new LightControlServiceMethodDescriptorSupplier("AdjustBrightness"))
              .build();
        }
      }
    }
    return getAdjustBrightnessMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.classroomsystem.LightProto.LightControlMessage,
      com.classroomsystem.LightProto.LightControlMessage> getStreamLightControlMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamLightControl",
      requestType = com.classroomsystem.LightProto.LightControlMessage.class,
      responseType = com.classroomsystem.LightProto.LightControlMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.classroomsystem.LightProto.LightControlMessage,
      com.classroomsystem.LightProto.LightControlMessage> getStreamLightControlMethod() {
    io.grpc.MethodDescriptor<com.classroomsystem.LightProto.LightControlMessage, com.classroomsystem.LightProto.LightControlMessage> getStreamLightControlMethod;
    if ((getStreamLightControlMethod = LightControlServiceGrpc.getStreamLightControlMethod) == null) {
      synchronized (LightControlServiceGrpc.class) {
        if ((getStreamLightControlMethod = LightControlServiceGrpc.getStreamLightControlMethod) == null) {
          LightControlServiceGrpc.getStreamLightControlMethod = getStreamLightControlMethod =
              io.grpc.MethodDescriptor.<com.classroomsystem.LightProto.LightControlMessage, com.classroomsystem.LightProto.LightControlMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StreamLightControl"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.classroomsystem.LightProto.LightControlMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.classroomsystem.LightProto.LightControlMessage.getDefaultInstance()))
              .setSchemaDescriptor(new LightControlServiceMethodDescriptorSupplier("StreamLightControl"))
              .build();
        }
      }
    }
    return getStreamLightControlMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LightControlServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LightControlServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LightControlServiceStub>() {
        @java.lang.Override
        public LightControlServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LightControlServiceStub(channel, callOptions);
        }
      };
    return LightControlServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LightControlServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LightControlServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LightControlServiceBlockingStub>() {
        @java.lang.Override
        public LightControlServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LightControlServiceBlockingStub(channel, callOptions);
        }
      };
    return LightControlServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LightControlServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LightControlServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LightControlServiceFutureStub>() {
        @java.lang.Override
        public LightControlServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LightControlServiceFutureStub(channel, callOptions);
        }
      };
    return LightControlServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * 灯光控制服务，包含开关控制和亮度调节功能
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * 开关控制：发送一个简单的请求来远程开启或关闭灯光
     * </pre>
     */
    default void switchLight(com.classroomsystem.LightProto.SwitchLightRequest request,
        io.grpc.stub.StreamObserver<com.classroomsystem.LightProto.SwitchLightResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSwitchLightMethod(), responseObserver);
    }

    /**
     * <pre>
     * 亮度调节：通过请求指定亮度等级（低或高）来改变灯光亮度
     * </pre>
     */
    default void adjustBrightness(com.classroomsystem.LightProto.BrightnessRequest request,
        io.grpc.stub.StreamObserver<com.classroomsystem.LightProto.BrightnessResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAdjustBrightnessMethod(), responseObserver);
    }

    /**
     * <pre>
     * 双向流：客户端和服务端可以交换灯光设置和状态信息
     * </pre>
     */
    default io.grpc.stub.StreamObserver<com.classroomsystem.LightProto.LightControlMessage> streamLightControl(
        io.grpc.stub.StreamObserver<com.classroomsystem.LightProto.LightControlMessage> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getStreamLightControlMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service LightControlService.
   * <pre>
   * 灯光控制服务，包含开关控制和亮度调节功能
   * </pre>
   */
  public static abstract class LightControlServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return LightControlServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service LightControlService.
   * <pre>
   * 灯光控制服务，包含开关控制和亮度调节功能
   * </pre>
   */
  public static final class LightControlServiceStub
      extends io.grpc.stub.AbstractAsyncStub<LightControlServiceStub> {
    private LightControlServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LightControlServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LightControlServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * 开关控制：发送一个简单的请求来远程开启或关闭灯光
     * </pre>
     */
    public void switchLight(com.classroomsystem.LightProto.SwitchLightRequest request,
        io.grpc.stub.StreamObserver<com.classroomsystem.LightProto.SwitchLightResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSwitchLightMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 亮度调节：通过请求指定亮度等级（低或高）来改变灯光亮度
     * </pre>
     */
    public void adjustBrightness(com.classroomsystem.LightProto.BrightnessRequest request,
        io.grpc.stub.StreamObserver<com.classroomsystem.LightProto.BrightnessResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAdjustBrightnessMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 双向流：客户端和服务端可以交换灯光设置和状态信息
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.classroomsystem.LightProto.LightControlMessage> streamLightControl(
        io.grpc.stub.StreamObserver<com.classroomsystem.LightProto.LightControlMessage> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getStreamLightControlMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service LightControlService.
   * <pre>
   * 灯光控制服务，包含开关控制和亮度调节功能
   * </pre>
   */
  public static final class LightControlServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<LightControlServiceBlockingStub> {
    private LightControlServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LightControlServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LightControlServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * 开关控制：发送一个简单的请求来远程开启或关闭灯光
     * </pre>
     */
    public com.classroomsystem.LightProto.SwitchLightResponse switchLight(com.classroomsystem.LightProto.SwitchLightRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSwitchLightMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * 亮度调节：通过请求指定亮度等级（低或高）来改变灯光亮度
     * </pre>
     */
    public com.classroomsystem.LightProto.BrightnessResponse adjustBrightness(com.classroomsystem.LightProto.BrightnessRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAdjustBrightnessMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service LightControlService.
   * <pre>
   * 灯光控制服务，包含开关控制和亮度调节功能
   * </pre>
   */
  public static final class LightControlServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<LightControlServiceFutureStub> {
    private LightControlServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LightControlServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LightControlServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * 开关控制：发送一个简单的请求来远程开启或关闭灯光
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.classroomsystem.LightProto.SwitchLightResponse> switchLight(
        com.classroomsystem.LightProto.SwitchLightRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSwitchLightMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * 亮度调节：通过请求指定亮度等级（低或高）来改变灯光亮度
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.classroomsystem.LightProto.BrightnessResponse> adjustBrightness(
        com.classroomsystem.LightProto.BrightnessRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAdjustBrightnessMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SWITCH_LIGHT = 0;
  private static final int METHODID_ADJUST_BRIGHTNESS = 1;
  private static final int METHODID_STREAM_LIGHT_CONTROL = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SWITCH_LIGHT:
          serviceImpl.switchLight((com.classroomsystem.LightProto.SwitchLightRequest) request,
              (io.grpc.stub.StreamObserver<com.classroomsystem.LightProto.SwitchLightResponse>) responseObserver);
          break;
        case METHODID_ADJUST_BRIGHTNESS:
          serviceImpl.adjustBrightness((com.classroomsystem.LightProto.BrightnessRequest) request,
              (io.grpc.stub.StreamObserver<com.classroomsystem.LightProto.BrightnessResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_STREAM_LIGHT_CONTROL:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.streamLightControl(
              (io.grpc.stub.StreamObserver<com.classroomsystem.LightProto.LightControlMessage>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getSwitchLightMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.classroomsystem.LightProto.SwitchLightRequest,
              com.classroomsystem.LightProto.SwitchLightResponse>(
                service, METHODID_SWITCH_LIGHT)))
        .addMethod(
          getAdjustBrightnessMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.classroomsystem.LightProto.BrightnessRequest,
              com.classroomsystem.LightProto.BrightnessResponse>(
                service, METHODID_ADJUST_BRIGHTNESS)))
        .addMethod(
          getStreamLightControlMethod(),
          io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
            new MethodHandlers<
              com.classroomsystem.LightProto.LightControlMessage,
              com.classroomsystem.LightProto.LightControlMessage>(
                service, METHODID_STREAM_LIGHT_CONTROL)))
        .build();
  }

  private static abstract class LightControlServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LightControlServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.classroomsystem.LightProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LightControlService");
    }
  }

  private static final class LightControlServiceFileDescriptorSupplier
      extends LightControlServiceBaseDescriptorSupplier {
    LightControlServiceFileDescriptorSupplier() {}
  }

  private static final class LightControlServiceMethodDescriptorSupplier
      extends LightControlServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    LightControlServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (LightControlServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LightControlServiceFileDescriptorSupplier())
              .addMethod(getSwitchLightMethod())
              .addMethod(getAdjustBrightnessMethod())
              .addMethod(getStreamLightControlMethod())
              .build();
        }
      }
    }
    return result;
  }
}
