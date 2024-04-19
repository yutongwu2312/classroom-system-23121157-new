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
    comments = "Source: computer.proto")
public final class ComputerServiceGrpc {

  private ComputerServiceGrpc() {}

  public static final String SERVICE_NAME = "computer.ComputerService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ComputerProto.ComputerStatus,
      ComputerProto.ComputerStatus> getGetStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetStatus",
      requestType = ComputerProto.ComputerStatus.class,
      responseType = ComputerProto.ComputerStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ComputerProto.ComputerStatus,
      ComputerProto.ComputerStatus> getGetStatusMethod() {
    io.grpc.MethodDescriptor<ComputerProto.ComputerStatus, ComputerProto.ComputerStatus> getGetStatusMethod;
    if ((getGetStatusMethod = ComputerServiceGrpc.getGetStatusMethod) == null) {
      synchronized (ComputerServiceGrpc.class) {
        if ((getGetStatusMethod = ComputerServiceGrpc.getGetStatusMethod) == null) {
          ComputerServiceGrpc.getGetStatusMethod = getGetStatusMethod = 
              io.grpc.MethodDescriptor.<ComputerProto.ComputerStatus, ComputerProto.ComputerStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "computer.ComputerService", "GetStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ComputerProto.ComputerStatus.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ComputerProto.ComputerStatus.getDefaultInstance()))
                  .setSchemaDescriptor(new ComputerServiceMethodDescriptorSupplier("GetStatus"))
                  .build();
          }
        }
     }
     return getGetStatusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ComputerProto.ComputerStatus,
      ComputerProto.ComputerStatus> getToggleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Toggle",
      requestType = ComputerProto.ComputerStatus.class,
      responseType = ComputerProto.ComputerStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ComputerProto.ComputerStatus,
      ComputerProto.ComputerStatus> getToggleMethod() {
    io.grpc.MethodDescriptor<ComputerProto.ComputerStatus, ComputerProto.ComputerStatus> getToggleMethod;
    if ((getToggleMethod = ComputerServiceGrpc.getToggleMethod) == null) {
      synchronized (ComputerServiceGrpc.class) {
        if ((getToggleMethod = ComputerServiceGrpc.getToggleMethod) == null) {
          ComputerServiceGrpc.getToggleMethod = getToggleMethod = 
              io.grpc.MethodDescriptor.<ComputerProto.ComputerStatus, ComputerProto.ComputerStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "computer.ComputerService", "Toggle"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ComputerProto.ComputerStatus.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ComputerProto.ComputerStatus.getDefaultInstance()))
                  .setSchemaDescriptor(new ComputerServiceMethodDescriptorSupplier("Toggle"))
                  .build();
          }
        }
     }
     return getToggleMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ComputerServiceStub newStub(io.grpc.Channel channel) {
    return new ComputerServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ComputerServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ComputerServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ComputerServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ComputerServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ComputerServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * 获取电脑的状态
     * </pre>
     */
    public void getStatus(ComputerProto.ComputerStatus request,
                          io.grpc.stub.StreamObserver<ComputerProto.ComputerStatus> responseObserver) {
      asyncUnimplementedUnaryCall(getGetStatusMethod(), responseObserver);
    }

    /**
     * <pre>
     * 控制电脑的开关
     * </pre>
     */
    public void toggle(ComputerProto.ComputerStatus request,
                       io.grpc.stub.StreamObserver<ComputerProto.ComputerStatus> responseObserver) {
      asyncUnimplementedUnaryCall(getToggleMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetStatusMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ComputerProto.ComputerStatus,
                ComputerProto.ComputerStatus>(
                  this, METHODID_GET_STATUS)))
          .addMethod(
            getToggleMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ComputerProto.ComputerStatus,
                ComputerProto.ComputerStatus>(
                  this, METHODID_TOGGLE)))
          .build();
    }
  }

  /**
   */
  public static final class ComputerServiceStub extends io.grpc.stub.AbstractStub<ComputerServiceStub> {
    private ComputerServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ComputerServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected ComputerServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ComputerServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * 获取电脑的状态
     * </pre>
     */
    public void getStatus(ComputerProto.ComputerStatus request,
                          io.grpc.stub.StreamObserver<ComputerProto.ComputerStatus> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetStatusMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 控制电脑的开关
     * </pre>
     */
    public void toggle(ComputerProto.ComputerStatus request,
                       io.grpc.stub.StreamObserver<ComputerProto.ComputerStatus> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getToggleMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ComputerServiceBlockingStub extends io.grpc.stub.AbstractStub<ComputerServiceBlockingStub> {
    private ComputerServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ComputerServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected ComputerServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ComputerServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * 获取电脑的状态
     * </pre>
     */
    public ComputerProto.ComputerStatus getStatus(ComputerProto.ComputerStatus request) {
      return blockingUnaryCall(
          getChannel(), getGetStatusMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * 控制电脑的开关
     * </pre>
     */
    public ComputerProto.ComputerStatus toggle(ComputerProto.ComputerStatus request) {
      return blockingUnaryCall(
          getChannel(), getToggleMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ComputerServiceFutureStub extends io.grpc.stub.AbstractStub<ComputerServiceFutureStub> {
    private ComputerServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ComputerServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected ComputerServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ComputerServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * 获取电脑的状态
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ComputerProto.ComputerStatus> getStatus(
        ComputerProto.ComputerStatus request) {
      return futureUnaryCall(
          getChannel().newCall(getGetStatusMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * 控制电脑的开关
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ComputerProto.ComputerStatus> toggle(
        ComputerProto.ComputerStatus request) {
      return futureUnaryCall(
          getChannel().newCall(getToggleMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_STATUS = 0;
  private static final int METHODID_TOGGLE = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ComputerServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ComputerServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_STATUS:
          serviceImpl.getStatus((ComputerProto.ComputerStatus) request,
              (io.grpc.stub.StreamObserver<ComputerProto.ComputerStatus>) responseObserver);
          break;
        case METHODID_TOGGLE:
          serviceImpl.toggle((ComputerProto.ComputerStatus) request,
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

  private static abstract class ComputerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ComputerServiceBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ComputerProto.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ComputerService");
    }
  }

  private static final class ComputerServiceFileDescriptorSupplier
      extends ComputerServiceBaseDescriptorSupplier {
    ComputerServiceFileDescriptorSupplier() {}
  }

  private static final class ComputerServiceMethodDescriptorSupplier
      extends ComputerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ComputerServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ComputerServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ComputerServiceFileDescriptorSupplier())
              .addMethod(getGetStatusMethod())
              .addMethod(getToggleMethod())
              .build();
        }
      }
    }
    return result;
  }
}
