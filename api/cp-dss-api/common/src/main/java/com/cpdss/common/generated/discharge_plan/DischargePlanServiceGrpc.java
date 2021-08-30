/* Licensed at AlphaOri Technologies */
package com.cpdss.common.generated.discharge_plan;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/** */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.36.0)",
    comments = "Source: discharge_plan/discharge_plan_service.proto")
public final class DischargePlanServiceGrpc {

  private DischargePlanServiceGrpc() {}

  public static final String SERVICE_NAME = "DischargePlanService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.cpdss.common.generated.discharge_plan.DischargeStudyDataTransferRequest,
          com.cpdss.common.generated.Common.ResponseStatus>
      getDischargePlanSynchronizationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DischargePlanSynchronization",
      requestType =
          com.cpdss.common.generated.discharge_plan.DischargeStudyDataTransferRequest.class,
      responseType = com.cpdss.common.generated.Common.ResponseStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.cpdss.common.generated.discharge_plan.DischargeStudyDataTransferRequest,
          com.cpdss.common.generated.Common.ResponseStatus>
      getDischargePlanSynchronizationMethod() {
    io.grpc.MethodDescriptor<
            com.cpdss.common.generated.discharge_plan.DischargeStudyDataTransferRequest,
            com.cpdss.common.generated.Common.ResponseStatus>
        getDischargePlanSynchronizationMethod;
    if ((getDischargePlanSynchronizationMethod =
            DischargePlanServiceGrpc.getDischargePlanSynchronizationMethod)
        == null) {
      synchronized (DischargePlanServiceGrpc.class) {
        if ((getDischargePlanSynchronizationMethod =
                DischargePlanServiceGrpc.getDischargePlanSynchronizationMethod)
            == null) {
          DischargePlanServiceGrpc.getDischargePlanSynchronizationMethod =
              getDischargePlanSynchronizationMethod =
                  io.grpc.MethodDescriptor
                      .<com.cpdss.common.generated.discharge_plan.DischargeStudyDataTransferRequest,
                          com.cpdss.common.generated.Common.ResponseStatus>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DischargePlanSynchronization"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.discharge_plan
                                  .DischargeStudyDataTransferRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.Common.ResponseStatus
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DischargePlanServiceMethodDescriptorSupplier(
                              "DischargePlanSynchronization"))
                      .build();
        }
      }
    }
    return getDischargePlanSynchronizationMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static DischargePlanServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DischargePlanServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DischargePlanServiceStub>() {
          @java.lang.Override
          public DischargePlanServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DischargePlanServiceStub(channel, callOptions);
          }
        };
    return DischargePlanServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DischargePlanServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DischargePlanServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DischargePlanServiceBlockingStub>() {
          @java.lang.Override
          public DischargePlanServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DischargePlanServiceBlockingStub(channel, callOptions);
          }
        };
    return DischargePlanServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static DischargePlanServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DischargePlanServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DischargePlanServiceFutureStub>() {
          @java.lang.Override
          public DischargePlanServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DischargePlanServiceFutureStub(channel, callOptions);
          }
        };
    return DischargePlanServiceFutureStub.newStub(factory, channel);
  }

  /** */
  public abstract static class DischargePlanServiceImplBase implements io.grpc.BindableService {

    /** */
    public void dischargePlanSynchronization(
        com.cpdss.common.generated.discharge_plan.DischargeStudyDataTransferRequest request,
        io.grpc.stub.StreamObserver<com.cpdss.common.generated.Common.ResponseStatus>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDischargePlanSynchronizationMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getDischargePlanSynchronizationMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.cpdss.common.generated.discharge_plan.DischargeStudyDataTransferRequest,
                      com.cpdss.common.generated.Common.ResponseStatus>(
                      this, METHODID_DISCHARGE_PLAN_SYNCHRONIZATION)))
          .build();
    }
  }

  /** */
  public static final class DischargePlanServiceStub
      extends io.grpc.stub.AbstractAsyncStub<DischargePlanServiceStub> {
    private DischargePlanServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DischargePlanServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DischargePlanServiceStub(channel, callOptions);
    }

    /** */
    public void dischargePlanSynchronization(
        com.cpdss.common.generated.discharge_plan.DischargeStudyDataTransferRequest request,
        io.grpc.stub.StreamObserver<com.cpdss.common.generated.Common.ResponseStatus>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDischargePlanSynchronizationMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /** */
  public static final class DischargePlanServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<DischargePlanServiceBlockingStub> {
    private DischargePlanServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DischargePlanServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DischargePlanServiceBlockingStub(channel, callOptions);
    }

    /** */
    public com.cpdss.common.generated.Common.ResponseStatus dischargePlanSynchronization(
        com.cpdss.common.generated.discharge_plan.DischargeStudyDataTransferRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDischargePlanSynchronizationMethod(), getCallOptions(), request);
    }
  }

  /** */
  public static final class DischargePlanServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<DischargePlanServiceFutureStub> {
    private DischargePlanServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DischargePlanServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DischargePlanServiceFutureStub(channel, callOptions);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            com.cpdss.common.generated.Common.ResponseStatus>
        dischargePlanSynchronization(
            com.cpdss.common.generated.discharge_plan.DischargeStudyDataTransferRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDischargePlanSynchronizationMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_DISCHARGE_PLAN_SYNCHRONIZATION = 0;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DischargePlanServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DischargePlanServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_DISCHARGE_PLAN_SYNCHRONIZATION:
          serviceImpl.dischargePlanSynchronization(
              (com.cpdss.common.generated.discharge_plan.DischargeStudyDataTransferRequest) request,
              (io.grpc.stub.StreamObserver<com.cpdss.common.generated.Common.ResponseStatus>)
                  responseObserver);
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

  private abstract static class DischargePlanServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DischargePlanServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.cpdss.common.generated.discharge_plan.DischargePlanServiceOuterClass
          .getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DischargePlanService");
    }
  }

  private static final class DischargePlanServiceFileDescriptorSupplier
      extends DischargePlanServiceBaseDescriptorSupplier {
    DischargePlanServiceFileDescriptorSupplier() {}
  }

  private static final class DischargePlanServiceMethodDescriptorSupplier
      extends DischargePlanServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DischargePlanServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (DischargePlanServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new DischargePlanServiceFileDescriptorSupplier())
                      .addMethod(getDischargePlanSynchronizationMethod())
                      .build();
        }
      }
    }
    return result;
  }
}