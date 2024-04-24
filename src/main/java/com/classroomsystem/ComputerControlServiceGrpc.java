package com.classroomsystem;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * 电脑控制服务，提供远程开关机功能
 *
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.63.0)",
    comments = "Source: computer.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ComputerControlServiceGrpc {

  private ComputerControlServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "classroom_system.control.ComputerControlService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.classroomsystem.ComputerProto.ToggleComputersRequest,
      com.classroomsystem.ComputerProto.ToggleComputersResponse> getToggleComputersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ToggleComputers",
      requestType = com.classroomsystem.ComputerProto.ToggleComputersRequest.class,
      responseType = com.classroomsystem.ComputerProto.ToggleComputersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.classroomsystem.ComputerProto.ToggleComputersRequest,
      com.classroomsystem.ComputerProto.ToggleComputersResponse> getToggleComputersMethod() {
    io.grpc.MethodDescriptor<com.classroomsystem.ComputerProto.ToggleComputersRequest, com.classroomsystem.ComputerProto.ToggleComputersResponse> getToggleComputersMethod;
    if ((getToggleComputersMethod = ComputerControlServiceGrpc.getToggleComputersMethod) == null) {
      synchronized (ComputerControlServiceGrpc.class) {
        if ((getToggleComputersMethod = ComputerControlServiceGrpc.getToggleComputersMethod) == null) {
          ComputerControlServiceGrpc.getToggleComputersMethod = getToggleComputersMethod =
              io.grpc.MethodDescriptor.<com.classroomsystem.ComputerProto.ToggleComputersRequest, com.classroomsystem.ComputerProto.ToggleComputersResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ToggleComputers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.classroomsystem.ComputerProto.ToggleComputersRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.classroomsystem.ComputerProto.ToggleComputersResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ComputerControlServiceMethodDescriptorSupplier("ToggleComputers"))
              .build();
        }
      }
    }
    return getToggleComputersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.classroomsystem.ComputerProto.Empty,
      com.classroomsystem.ComputerProto.ComputerStatusResponse> getMonitorComputersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MonitorComputers",
      requestType = com.classroomsystem.ComputerProto.Empty.class,
      responseType = com.classroomsystem.ComputerProto.ComputerStatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.classroomsystem.ComputerProto.Empty,
      com.classroomsystem.ComputerProto.ComputerStatusResponse> getMonitorComputersMethod() {
    io.grpc.MethodDescriptor<com.classroomsystem.ComputerProto.Empty, com.classroomsystem.ComputerProto.ComputerStatusResponse> getMonitorComputersMethod;
    if ((getMonitorComputersMethod = ComputerControlServiceGrpc.getMonitorComputersMethod) == null) {
      synchronized (ComputerControlServiceGrpc.class) {
        if ((getMonitorComputersMethod = ComputerControlServiceGrpc.getMonitorComputersMethod) == null) {
          ComputerControlServiceGrpc.getMonitorComputersMethod = getMonitorComputersMethod =
              io.grpc.MethodDescriptor.<com.classroomsystem.ComputerProto.Empty, com.classroomsystem.ComputerProto.ComputerStatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "MonitorComputers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.classroomsystem.ComputerProto.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.classroomsystem.ComputerProto.ComputerStatusResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ComputerControlServiceMethodDescriptorSupplier("MonitorComputers"))
              .build();
        }
      }
    }
    return getMonitorComputersMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ComputerControlServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ComputerControlServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ComputerControlServiceStub>() {
        @java.lang.Override
        public ComputerControlServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ComputerControlServiceStub(channel, callOptions);
        }
      };
    return ComputerControlServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ComputerControlServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ComputerControlServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ComputerControlServiceBlockingStub>() {
        @java.lang.Override
        public ComputerControlServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ComputerControlServiceBlockingStub(channel, callOptions);
        }
      };
    return ComputerControlServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ComputerControlServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ComputerControlServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ComputerControlServiceFutureStub>() {
        @java.lang.Override
        public ComputerControlServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ComputerControlServiceFutureStub(channel, callOptions);
        }
      };
    return ComputerControlServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * 电脑控制服务，提供远程开关机功能
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * 开关机：发送请求远程开关所有电脑
     * </pre>
     */
    default void toggleComputers(com.classroomsystem.ComputerProto.ToggleComputersRequest request,
        io.grpc.stub.StreamObserver<com.classroomsystem.ComputerProto.ToggleComputersResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getToggleComputersMethod(), responseObserver);
    }

    /**
     * <pre>
     * 服务端流：服务端不断发送当前所有电脑的状态更新
     * </pre>
     */
    default void monitorComputers(com.classroomsystem.ComputerProto.Empty request,
        io.grpc.stub.StreamObserver<com.classroomsystem.ComputerProto.ComputerStatusResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getMonitorComputersMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ComputerControlService.
   * <pre>
   * 电脑控制服务，提供远程开关机功能
   * </pre>
   */
  public static abstract class ComputerControlServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ComputerControlServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ComputerControlService.
   * <pre>
   * 电脑控制服务，提供远程开关机功能
   * </pre>
   */
  public static final class ComputerControlServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ComputerControlServiceStub> {
    private ComputerControlServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ComputerControlServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ComputerControlServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * 开关机：发送请求远程开关所有电脑
     * </pre>
     */
    public void toggleComputers(com.classroomsystem.ComputerProto.ToggleComputersRequest request,
        io.grpc.stub.StreamObserver<com.classroomsystem.ComputerProto.ToggleComputersResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getToggleComputersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 服务端流：服务端不断发送当前所有电脑的状态更新
     * </pre>
     */
    public void monitorComputers(com.classroomsystem.ComputerProto.Empty request,
        io.grpc.stub.StreamObserver<com.classroomsystem.ComputerProto.ComputerStatusResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getMonitorComputersMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ComputerControlService.
   * <pre>
   * 电脑控制服务，提供远程开关机功能
   * </pre>
   */
  public static final class ComputerControlServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ComputerControlServiceBlockingStub> {
    private ComputerControlServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ComputerControlServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ComputerControlServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * 开关机：发送请求远程开关所有电脑
     * </pre>
     */
    public com.classroomsystem.ComputerProto.ToggleComputersResponse toggleComputers(com.classroomsystem.ComputerProto.ToggleComputersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getToggleComputersMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * 服务端流：服务端不断发送当前所有电脑的状态更新
     * </pre>
     */
    public java.util.Iterator<com.classroomsystem.ComputerProto.ComputerStatusResponse> monitorComputers(
        com.classroomsystem.ComputerProto.Empty request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getMonitorComputersMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ComputerControlService.
   * <pre>
   * 电脑控制服务，提供远程开关机功能
   * </pre>
   */
  public static final class ComputerControlServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ComputerControlServiceFutureStub> {
    private ComputerControlServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ComputerControlServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ComputerControlServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * 开关机：发送请求远程开关所有电脑
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.classroomsystem.ComputerProto.ToggleComputersResponse> toggleComputers(
        com.classroomsystem.ComputerProto.ToggleComputersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getToggleComputersMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_TOGGLE_COMPUTERS = 0;
  private static final int METHODID_MONITOR_COMPUTERS = 1;

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
        case METHODID_TOGGLE_COMPUTERS:
          serviceImpl.toggleComputers((com.classroomsystem.ComputerProto.ToggleComputersRequest) request,
              (io.grpc.stub.StreamObserver<com.classroomsystem.ComputerProto.ToggleComputersResponse>) responseObserver);
          break;
        case METHODID_MONITOR_COMPUTERS:
          serviceImpl.monitorComputers((com.classroomsystem.ComputerProto.Empty) request,
              (io.grpc.stub.StreamObserver<com.classroomsystem.ComputerProto.ComputerStatusResponse>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getToggleComputersMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.classroomsystem.ComputerProto.ToggleComputersRequest,
              com.classroomsystem.ComputerProto.ToggleComputersResponse>(
                service, METHODID_TOGGLE_COMPUTERS)))
        .addMethod(
          getMonitorComputersMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.classroomsystem.ComputerProto.Empty,
              com.classroomsystem.ComputerProto.ComputerStatusResponse>(
                service, METHODID_MONITOR_COMPUTERS)))
        .build();
  }

  private static abstract class ComputerControlServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ComputerControlServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.classroomsystem.ComputerProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ComputerControlService");
    }
  }

  private static final class ComputerControlServiceFileDescriptorSupplier
      extends ComputerControlServiceBaseDescriptorSupplier {
    ComputerControlServiceFileDescriptorSupplier() {}
  }

  private static final class ComputerControlServiceMethodDescriptorSupplier
      extends ComputerControlServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ComputerControlServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ComputerControlServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ComputerControlServiceFileDescriptorSupplier())
              .addMethod(getToggleComputersMethod())
              .addMethod(getMonitorComputersMethod())
              .build();
        }
      }
    }
    return result;
  }
}
