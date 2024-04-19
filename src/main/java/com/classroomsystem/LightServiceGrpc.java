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
    comments = "Source: light.proto")
public final class LightServiceGrpc {

  private LightServiceGrpc() {}

  public static final String SERVICE_NAME = "light.LightService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<LightProto.LightStatus,
      LightProto.LightStatus> getGetStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetStatus",
      requestType = LightProto.LightStatus.class,
      responseType = LightProto.LightStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<LightProto.LightStatus,
      LightProto.LightStatus> getGetStatusMethod() {
    io.grpc.MethodDescriptor<LightProto.LightStatus, LightProto.LightStatus> getGetStatusMethod;
    if ((getGetStatusMethod = LightServiceGrpc.getGetStatusMethod) == null) {
      synchronized (LightServiceGrpc.class) {
        if ((getGetStatusMethod = LightServiceGrpc.getGetStatusMethod) == null) {
          LightServiceGrpc.getGetStatusMethod = getGetStatusMethod = 
              io.grpc.MethodDescriptor.<LightProto.LightStatus, LightProto.LightStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "light.LightService", "GetStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  LightProto.LightStatus.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  LightProto.LightStatus.getDefaultInstance()))
                  .setSchemaDescriptor(new LightServiceMethodDescriptorSupplier("GetStatus"))
                  .build();
          }
        }
     }
     return getGetStatusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<LightProto.LightStatus,
      LightProto.LightStatus> getToggleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Toggle",
      requestType = LightProto.LightStatus.class,
      responseType = LightProto.LightStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<LightProto.LightStatus,
      LightProto.LightStatus> getToggleMethod() {
    io.grpc.MethodDescriptor<LightProto.LightStatus, LightProto.LightStatus> getToggleMethod;
    if ((getToggleMethod = LightServiceGrpc.getToggleMethod) == null) {
      synchronized (LightServiceGrpc.class) {
        if ((getToggleMethod = LightServiceGrpc.getToggleMethod) == null) {
          LightServiceGrpc.getToggleMethod = getToggleMethod = 
              io.grpc.MethodDescriptor.<LightProto.LightStatus, LightProto.LightStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "light.LightService", "Toggle"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  LightProto.LightStatus.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  LightProto.LightStatus.getDefaultInstance()))
                  .setSchemaDescriptor(new LightServiceMethodDescriptorSupplier("Toggle"))
                  .build();
          }
        }
     }
     return getToggleMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LightServiceStub newStub(io.grpc.Channel channel) {
    return new LightServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LightServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new LightServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LightServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new LightServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class LightServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * 获取灯的状态
     * </pre>
     */
    public void getStatus(LightProto.LightStatus request,
                          io.grpc.stub.StreamObserver<LightProto.LightStatus> responseObserver) {
      asyncUnimplementedUnaryCall(getGetStatusMethod(), responseObserver);
    }

    /**
     * <pre>
     * 控制灯的开关
     * </pre>
     */
    public void toggle(LightProto.LightStatus request,
                       io.grpc.stub.StreamObserver<LightProto.LightStatus> responseObserver) {
      asyncUnimplementedUnaryCall(getToggleMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetStatusMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                LightProto.LightStatus,
                LightProto.LightStatus>(
                  this, METHODID_GET_STATUS)))
          .addMethod(
            getToggleMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                LightProto.LightStatus,
                LightProto.LightStatus>(
                  this, METHODID_TOGGLE)))
          .build();
    }
  }

  /**
   */
  public static final class LightServiceStub extends io.grpc.stub.AbstractStub<LightServiceStub> {
    private LightServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LightServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected LightServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LightServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * 获取灯的状态
     * </pre>
     */
    public void getStatus(LightProto.LightStatus request,
                          io.grpc.stub.StreamObserver<LightProto.LightStatus> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetStatusMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 控制灯的开关
     * </pre>
     */
    public void toggle(LightProto.LightStatus request,
                       io.grpc.stub.StreamObserver<LightProto.LightStatus> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getToggleMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class LightServiceBlockingStub extends io.grpc.stub.AbstractStub<LightServiceBlockingStub> {
    private LightServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LightServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected LightServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LightServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * 获取灯的状态
     * </pre>
     */
    public LightProto.LightStatus getStatus(LightProto.LightStatus request) {
      return blockingUnaryCall(
          getChannel(), getGetStatusMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * 控制灯的开关
     * </pre>
     */
    public LightProto.LightStatus toggle(LightProto.LightStatus request) {
      return blockingUnaryCall(
          getChannel(), getToggleMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class LightServiceFutureStub extends io.grpc.stub.AbstractStub<LightServiceFutureStub> {
    private LightServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LightServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected LightServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LightServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * 获取灯的状态
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<LightProto.LightStatus> getStatus(
        LightProto.LightStatus request) {
      return futureUnaryCall(
          getChannel().newCall(getGetStatusMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * 控制灯的开关
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<LightProto.LightStatus> toggle(
        LightProto.LightStatus request) {
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
    private final LightServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(LightServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_STATUS:
          serviceImpl.getStatus((LightProto.LightStatus) request,
              (io.grpc.stub.StreamObserver<LightProto.LightStatus>) responseObserver);
          break;
        case METHODID_TOGGLE:
          serviceImpl.toggle((LightProto.LightStatus) request,
              (io.grpc.stub.StreamObserver<LightProto.LightStatus>) responseObserver);
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

  private static abstract class LightServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LightServiceBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return LightProto.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LightService");
    }
  }

  private static final class LightServiceFileDescriptorSupplier
      extends LightServiceBaseDescriptorSupplier {
    LightServiceFileDescriptorSupplier() {}
  }

  private static final class LightServiceMethodDescriptorSupplier
      extends LightServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    LightServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (LightServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LightServiceFileDescriptorSupplier())
              .addMethod(getGetStatusMethod())
              .addMethod(getToggleMethod())
              .build();
        }
      }
    }
    return result;
  }
}
