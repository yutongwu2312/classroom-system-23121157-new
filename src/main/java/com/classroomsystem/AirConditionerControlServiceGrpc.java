package com.classroomsystem;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * 空调控制服务的定义，包括开关控制和温度调节。
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.63.0)",
    comments = "Source: aircondition.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AirConditionerControlServiceGrpc {

  private AirConditionerControlServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "classroom_system.control.AirConditionerControlService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.classroomsystem.AirConditionProto.SwitchAirConditionerRequest,
      com.classroomsystem.AirConditionProto.SwitchAirConditionerResponse> getSwitchAirConditionerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SwitchAirConditioner",
      requestType = com.classroomsystem.AirConditionProto.SwitchAirConditionerRequest.class,
      responseType = com.classroomsystem.AirConditionProto.SwitchAirConditionerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.classroomsystem.AirConditionProto.SwitchAirConditionerRequest,
      com.classroomsystem.AirConditionProto.SwitchAirConditionerResponse> getSwitchAirConditionerMethod() {
    io.grpc.MethodDescriptor<com.classroomsystem.AirConditionProto.SwitchAirConditionerRequest, com.classroomsystem.AirConditionProto.SwitchAirConditionerResponse> getSwitchAirConditionerMethod;
    if ((getSwitchAirConditionerMethod = AirConditionerControlServiceGrpc.getSwitchAirConditionerMethod) == null) {
      synchronized (AirConditionerControlServiceGrpc.class) {
        if ((getSwitchAirConditionerMethod = AirConditionerControlServiceGrpc.getSwitchAirConditionerMethod) == null) {
          AirConditionerControlServiceGrpc.getSwitchAirConditionerMethod = getSwitchAirConditionerMethod =
              io.grpc.MethodDescriptor.<com.classroomsystem.AirConditionProto.SwitchAirConditionerRequest, com.classroomsystem.AirConditionProto.SwitchAirConditionerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SwitchAirConditioner"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.classroomsystem.AirConditionProto.SwitchAirConditionerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.classroomsystem.AirConditionProto.SwitchAirConditionerResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AirConditionerControlServiceMethodDescriptorSupplier("SwitchAirConditioner"))
              .build();
        }
      }
    }
    return getSwitchAirConditionerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.classroomsystem.AirConditionProto.SetTemperatureRequest,
      com.classroomsystem.AirConditionProto.SetTemperatureResponse> getSetTemperatureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetTemperature",
      requestType = com.classroomsystem.AirConditionProto.SetTemperatureRequest.class,
      responseType = com.classroomsystem.AirConditionProto.SetTemperatureResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.classroomsystem.AirConditionProto.SetTemperatureRequest,
      com.classroomsystem.AirConditionProto.SetTemperatureResponse> getSetTemperatureMethod() {
    io.grpc.MethodDescriptor<com.classroomsystem.AirConditionProto.SetTemperatureRequest, com.classroomsystem.AirConditionProto.SetTemperatureResponse> getSetTemperatureMethod;
    if ((getSetTemperatureMethod = AirConditionerControlServiceGrpc.getSetTemperatureMethod) == null) {
      synchronized (AirConditionerControlServiceGrpc.class) {
        if ((getSetTemperatureMethod = AirConditionerControlServiceGrpc.getSetTemperatureMethod) == null) {
          AirConditionerControlServiceGrpc.getSetTemperatureMethod = getSetTemperatureMethod =
              io.grpc.MethodDescriptor.<com.classroomsystem.AirConditionProto.SetTemperatureRequest, com.classroomsystem.AirConditionProto.SetTemperatureResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetTemperature"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.classroomsystem.AirConditionProto.SetTemperatureRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.classroomsystem.AirConditionProto.SetTemperatureResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AirConditionerControlServiceMethodDescriptorSupplier("SetTemperature"))
              .build();
        }
      }
    }
    return getSetTemperatureMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.classroomsystem.AirConditionProto.SetTemperatureRequest,
      com.classroomsystem.AirConditionProto.StreamTemperatureAdjustmentsResponse> getStreamTemperatureAdjustmentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamTemperatureAdjustments",
      requestType = com.classroomsystem.AirConditionProto.SetTemperatureRequest.class,
      responseType = com.classroomsystem.AirConditionProto.StreamTemperatureAdjustmentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.classroomsystem.AirConditionProto.SetTemperatureRequest,
      com.classroomsystem.AirConditionProto.StreamTemperatureAdjustmentsResponse> getStreamTemperatureAdjustmentsMethod() {
    io.grpc.MethodDescriptor<com.classroomsystem.AirConditionProto.SetTemperatureRequest, com.classroomsystem.AirConditionProto.StreamTemperatureAdjustmentsResponse> getStreamTemperatureAdjustmentsMethod;
    if ((getStreamTemperatureAdjustmentsMethod = AirConditionerControlServiceGrpc.getStreamTemperatureAdjustmentsMethod) == null) {
      synchronized (AirConditionerControlServiceGrpc.class) {
        if ((getStreamTemperatureAdjustmentsMethod = AirConditionerControlServiceGrpc.getStreamTemperatureAdjustmentsMethod) == null) {
          AirConditionerControlServiceGrpc.getStreamTemperatureAdjustmentsMethod = getStreamTemperatureAdjustmentsMethod =
              io.grpc.MethodDescriptor.<com.classroomsystem.AirConditionProto.SetTemperatureRequest, com.classroomsystem.AirConditionProto.StreamTemperatureAdjustmentsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StreamTemperatureAdjustments"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.classroomsystem.AirConditionProto.SetTemperatureRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.classroomsystem.AirConditionProto.StreamTemperatureAdjustmentsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AirConditionerControlServiceMethodDescriptorSupplier("StreamTemperatureAdjustments"))
              .build();
        }
      }
    }
    return getStreamTemperatureAdjustmentsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AirConditionerControlServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AirConditionerControlServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AirConditionerControlServiceStub>() {
        @java.lang.Override
        public AirConditionerControlServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AirConditionerControlServiceStub(channel, callOptions);
        }
      };
    return AirConditionerControlServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AirConditionerControlServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AirConditionerControlServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AirConditionerControlServiceBlockingStub>() {
        @java.lang.Override
        public AirConditionerControlServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AirConditionerControlServiceBlockingStub(channel, callOptions);
        }
      };
    return AirConditionerControlServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AirConditionerControlServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AirConditionerControlServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AirConditionerControlServiceFutureStub>() {
        @java.lang.Override
        public AirConditionerControlServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AirConditionerControlServiceFutureStub(channel, callOptions);
        }
      };
    return AirConditionerControlServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * 空调控制服务的定义，包括开关控制和温度调节。
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * 发送请求远程开启或关闭空调。
     * </pre>
     */
    default void switchAirConditioner(com.classroomsystem.AirConditionProto.SwitchAirConditionerRequest request,
        io.grpc.stub.StreamObserver<com.classroomsystem.AirConditionProto.SwitchAirConditionerResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSwitchAirConditionerMethod(), responseObserver);
    }

    /**
     * <pre>
     * 发送请求指定具体温度值。
     * </pre>
     */
    default void setTemperature(com.classroomsystem.AirConditionProto.SetTemperatureRequest request,
        io.grpc.stub.StreamObserver<com.classroomsystem.AirConditionProto.SetTemperatureResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSetTemperatureMethod(), responseObserver);
    }

    /**
     * <pre>
     * 客户端流式 RPC：允许客户端发送一系列温度调节请求。
     * </pre>
     */
    default io.grpc.stub.StreamObserver<com.classroomsystem.AirConditionProto.SetTemperatureRequest> streamTemperatureAdjustments(
        io.grpc.stub.StreamObserver<com.classroomsystem.AirConditionProto.StreamTemperatureAdjustmentsResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getStreamTemperatureAdjustmentsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AirConditionerControlService.
   * <pre>
   * 空调控制服务的定义，包括开关控制和温度调节。
   * </pre>
   */
  public static abstract class AirConditionerControlServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return AirConditionerControlServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service AirConditionerControlService.
   * <pre>
   * 空调控制服务的定义，包括开关控制和温度调节。
   * </pre>
   */
  public static final class AirConditionerControlServiceStub
      extends io.grpc.stub.AbstractAsyncStub<AirConditionerControlServiceStub> {
    private AirConditionerControlServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AirConditionerControlServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AirConditionerControlServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * 发送请求远程开启或关闭空调。
     * </pre>
     */
    public void switchAirConditioner(com.classroomsystem.AirConditionProto.SwitchAirConditionerRequest request,
        io.grpc.stub.StreamObserver<com.classroomsystem.AirConditionProto.SwitchAirConditionerResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSwitchAirConditionerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 发送请求指定具体温度值。
     * </pre>
     */
    public void setTemperature(com.classroomsystem.AirConditionProto.SetTemperatureRequest request,
        io.grpc.stub.StreamObserver<com.classroomsystem.AirConditionProto.SetTemperatureResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetTemperatureMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 客户端流式 RPC：允许客户端发送一系列温度调节请求。
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.classroomsystem.AirConditionProto.SetTemperatureRequest> streamTemperatureAdjustments(
        io.grpc.stub.StreamObserver<com.classroomsystem.AirConditionProto.StreamTemperatureAdjustmentsResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getStreamTemperatureAdjustmentsMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AirConditionerControlService.
   * <pre>
   * 空调控制服务的定义，包括开关控制和温度调节。
   * </pre>
   */
  public static final class AirConditionerControlServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AirConditionerControlServiceBlockingStub> {
    private AirConditionerControlServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AirConditionerControlServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AirConditionerControlServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * 发送请求远程开启或关闭空调。
     * </pre>
     */
    public com.classroomsystem.AirConditionProto.SwitchAirConditionerResponse switchAirConditioner(com.classroomsystem.AirConditionProto.SwitchAirConditionerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSwitchAirConditionerMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * 发送请求指定具体温度值。
     * </pre>
     */
    public com.classroomsystem.AirConditionProto.SetTemperatureResponse setTemperature(com.classroomsystem.AirConditionProto.SetTemperatureRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetTemperatureMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service AirConditionerControlService.
   * <pre>
   * 空调控制服务的定义，包括开关控制和温度调节。
   * </pre>
   */
  public static final class AirConditionerControlServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<AirConditionerControlServiceFutureStub> {
    private AirConditionerControlServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AirConditionerControlServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AirConditionerControlServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * 发送请求远程开启或关闭空调。
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.classroomsystem.AirConditionProto.SwitchAirConditionerResponse> switchAirConditioner(
        com.classroomsystem.AirConditionProto.SwitchAirConditionerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSwitchAirConditionerMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * 发送请求指定具体温度值。
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.classroomsystem.AirConditionProto.SetTemperatureResponse> setTemperature(
        com.classroomsystem.AirConditionProto.SetTemperatureRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetTemperatureMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SWITCH_AIR_CONDITIONER = 0;
  private static final int METHODID_SET_TEMPERATURE = 1;
  private static final int METHODID_STREAM_TEMPERATURE_ADJUSTMENTS = 2;

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
        case METHODID_SWITCH_AIR_CONDITIONER:
          serviceImpl.switchAirConditioner((com.classroomsystem.AirConditionProto.SwitchAirConditionerRequest) request,
              (io.grpc.stub.StreamObserver<com.classroomsystem.AirConditionProto.SwitchAirConditionerResponse>) responseObserver);
          break;
        case METHODID_SET_TEMPERATURE:
          serviceImpl.setTemperature((com.classroomsystem.AirConditionProto.SetTemperatureRequest) request,
              (io.grpc.stub.StreamObserver<com.classroomsystem.AirConditionProto.SetTemperatureResponse>) responseObserver);
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
        case METHODID_STREAM_TEMPERATURE_ADJUSTMENTS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.streamTemperatureAdjustments(
              (io.grpc.stub.StreamObserver<com.classroomsystem.AirConditionProto.StreamTemperatureAdjustmentsResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getSwitchAirConditionerMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.classroomsystem.AirConditionProto.SwitchAirConditionerRequest,
              com.classroomsystem.AirConditionProto.SwitchAirConditionerResponse>(
                service, METHODID_SWITCH_AIR_CONDITIONER)))
        .addMethod(
          getSetTemperatureMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.classroomsystem.AirConditionProto.SetTemperatureRequest,
              com.classroomsystem.AirConditionProto.SetTemperatureResponse>(
                service, METHODID_SET_TEMPERATURE)))
        .addMethod(
          getStreamTemperatureAdjustmentsMethod(),
          io.grpc.stub.ServerCalls.asyncClientStreamingCall(
            new MethodHandlers<
              com.classroomsystem.AirConditionProto.SetTemperatureRequest,
              com.classroomsystem.AirConditionProto.StreamTemperatureAdjustmentsResponse>(
                service, METHODID_STREAM_TEMPERATURE_ADJUSTMENTS)))
        .build();
  }

  private static abstract class AirConditionerControlServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AirConditionerControlServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.classroomsystem.AirConditionProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AirConditionerControlService");
    }
  }

  private static final class AirConditionerControlServiceFileDescriptorSupplier
      extends AirConditionerControlServiceBaseDescriptorSupplier {
    AirConditionerControlServiceFileDescriptorSupplier() {}
  }

  private static final class AirConditionerControlServiceMethodDescriptorSupplier
      extends AirConditionerControlServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    AirConditionerControlServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (AirConditionerControlServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AirConditionerControlServiceFileDescriptorSupplier())
              .addMethod(getSwitchAirConditionerMethod())
              .addMethod(getSetTemperatureMethod())
              .addMethod(getStreamTemperatureAdjustmentsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
