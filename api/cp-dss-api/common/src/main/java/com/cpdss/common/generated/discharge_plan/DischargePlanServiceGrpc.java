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

  private static volatile io.grpc.MethodDescriptor<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.UpdateUllageDetailsRequest,
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.UpdateUllageDetailsResponse>
      getGetDischargeUpdateUllageDetailsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDischargeUpdateUllageDetails",
      requestType =
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.UpdateUllageDetailsRequest
              .class,
      responseType =
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.UpdateUllageDetailsResponse
              .class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.UpdateUllageDetailsRequest,
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.UpdateUllageDetailsResponse>
      getGetDischargeUpdateUllageDetailsMethod() {
    io.grpc.MethodDescriptor<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.UpdateUllageDetailsRequest,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.UpdateUllageDetailsResponse>
        getGetDischargeUpdateUllageDetailsMethod;
    if ((getGetDischargeUpdateUllageDetailsMethod =
            DischargePlanServiceGrpc.getGetDischargeUpdateUllageDetailsMethod)
        == null) {
      synchronized (DischargePlanServiceGrpc.class) {
        if ((getGetDischargeUpdateUllageDetailsMethod =
                DischargePlanServiceGrpc.getGetDischargeUpdateUllageDetailsMethod)
            == null) {
          DischargePlanServiceGrpc.getGetDischargeUpdateUllageDetailsMethod =
              getGetDischargeUpdateUllageDetailsMethod =
                  io.grpc.MethodDescriptor
                      .<com.cpdss.common.generated.loading_plan.LoadingPlanModels
                              .UpdateUllageDetailsRequest,
                          com.cpdss.common.generated.loading_plan.LoadingPlanModels
                              .UpdateUllageDetailsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetDischargeUpdateUllageDetails"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.loading_plan.LoadingPlanModels
                                  .UpdateUllageDetailsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.loading_plan.LoadingPlanModels
                                  .UpdateUllageDetailsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DischargePlanServiceMethodDescriptorSupplier(
                              "GetDischargeUpdateUllageDetails"))
                      .build();
        }
      }
    }
    return getGetDischargeUpdateUllageDetailsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.cpdss.common.generated.discharge_plan.DischargeInformationRequest,
          com.cpdss.common.generated.discharge_plan.DischargePlanAlgoRequest>
      getGenerateDischargePlanMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "generateDischargePlan",
      requestType = com.cpdss.common.generated.discharge_plan.DischargeInformationRequest.class,
      responseType = com.cpdss.common.generated.discharge_plan.DischargePlanAlgoRequest.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.cpdss.common.generated.discharge_plan.DischargeInformationRequest,
          com.cpdss.common.generated.discharge_plan.DischargePlanAlgoRequest>
      getGenerateDischargePlanMethod() {
    io.grpc.MethodDescriptor<
            com.cpdss.common.generated.discharge_plan.DischargeInformationRequest,
            com.cpdss.common.generated.discharge_plan.DischargePlanAlgoRequest>
        getGenerateDischargePlanMethod;
    if ((getGenerateDischargePlanMethod = DischargePlanServiceGrpc.getGenerateDischargePlanMethod)
        == null) {
      synchronized (DischargePlanServiceGrpc.class) {
        if ((getGenerateDischargePlanMethod =
                DischargePlanServiceGrpc.getGenerateDischargePlanMethod)
            == null) {
          DischargePlanServiceGrpc.getGenerateDischargePlanMethod =
              getGenerateDischargePlanMethod =
                  io.grpc.MethodDescriptor
                      .<com.cpdss.common.generated.discharge_plan.DischargeInformationRequest,
                          com.cpdss.common.generated.discharge_plan.DischargePlanAlgoRequest>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "generateDischargePlan"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.discharge_plan.DischargeInformationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.discharge_plan.DischargePlanAlgoRequest
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DischargePlanServiceMethodDescriptorSupplier("generateDischargePlan"))
                      .build();
        }
      }
    }
    return getGenerateDischargePlanMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.UllageBillRequest,
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.UllageBillReply>
      getUpdateDischargeUllageDetailsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateDischargeUllageDetails",
      requestType =
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.UllageBillRequest.class,
      responseType =
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.UllageBillReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.UllageBillRequest,
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.UllageBillReply>
      getUpdateDischargeUllageDetailsMethod() {
    io.grpc.MethodDescriptor<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.UllageBillRequest,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.UllageBillReply>
        getUpdateDischargeUllageDetailsMethod;
    if ((getUpdateDischargeUllageDetailsMethod =
            DischargePlanServiceGrpc.getUpdateDischargeUllageDetailsMethod)
        == null) {
      synchronized (DischargePlanServiceGrpc.class) {
        if ((getUpdateDischargeUllageDetailsMethod =
                DischargePlanServiceGrpc.getUpdateDischargeUllageDetailsMethod)
            == null) {
          DischargePlanServiceGrpc.getUpdateDischargeUllageDetailsMethod =
              getUpdateDischargeUllageDetailsMethod =
                  io.grpc.MethodDescriptor
                      .<com.cpdss.common.generated.loading_plan.LoadingPlanModels.UllageBillRequest,
                          com.cpdss.common.generated.loading_plan.LoadingPlanModels.UllageBillReply>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "updateDischargeUllageDetails"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.loading_plan.LoadingPlanModels
                                  .UllageBillRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.loading_plan.LoadingPlanModels
                                  .UllageBillReply.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DischargePlanServiceMethodDescriptorSupplier(
                              "updateDischargeUllageDetails"))
                      .build();
        }
      }
    }
    return getUpdateDischargeUllageDetailsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.cpdss.common.generated.discharge_plan.DischargingPlanSaveRequest,
          com.cpdss.common.generated.discharge_plan.DischargingPlanSaveResponse>
      getSaveDischargingPlanMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "saveDischargingPlan",
      requestType = com.cpdss.common.generated.discharge_plan.DischargingPlanSaveRequest.class,
      responseType = com.cpdss.common.generated.discharge_plan.DischargingPlanSaveResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.cpdss.common.generated.discharge_plan.DischargingPlanSaveRequest,
          com.cpdss.common.generated.discharge_plan.DischargingPlanSaveResponse>
      getSaveDischargingPlanMethod() {
    io.grpc.MethodDescriptor<
            com.cpdss.common.generated.discharge_plan.DischargingPlanSaveRequest,
            com.cpdss.common.generated.discharge_plan.DischargingPlanSaveResponse>
        getSaveDischargingPlanMethod;
    if ((getSaveDischargingPlanMethod = DischargePlanServiceGrpc.getSaveDischargingPlanMethod)
        == null) {
      synchronized (DischargePlanServiceGrpc.class) {
        if ((getSaveDischargingPlanMethod = DischargePlanServiceGrpc.getSaveDischargingPlanMethod)
            == null) {
          DischargePlanServiceGrpc.getSaveDischargingPlanMethod =
              getSaveDischargingPlanMethod =
                  io.grpc.MethodDescriptor
                      .<com.cpdss.common.generated.discharge_plan.DischargingPlanSaveRequest,
                          com.cpdss.common.generated.discharge_plan.DischargingPlanSaveResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "saveDischargingPlan"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.discharge_plan.DischargingPlanSaveRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.discharge_plan.DischargingPlanSaveResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DischargePlanServiceMethodDescriptorSupplier("saveDischargingPlan"))
                      .build();
        }
      }
    }
    return getSaveDischargingPlanMethod;
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

    /** */
    public void getDischargeUpdateUllageDetails(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.UpdateUllageDetailsRequest
            request,
        io.grpc.stub.StreamObserver<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels
                    .UpdateUllageDetailsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDischargeUpdateUllageDetailsMethod(), responseObserver);
    }

    /** */
    public void generateDischargePlan(
        com.cpdss.common.generated.discharge_plan.DischargeInformationRequest request,
        io.grpc.stub.StreamObserver<
                com.cpdss.common.generated.discharge_plan.DischargePlanAlgoRequest>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGenerateDischargePlanMethod(), responseObserver);
    }

    /** */
    public void updateDischargeUllageDetails(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.UllageBillRequest request,
        io.grpc.stub.StreamObserver<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.UllageBillReply>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateDischargeUllageDetailsMethod(), responseObserver);
    }

    /** */
    public void saveDischargingPlan(
        com.cpdss.common.generated.discharge_plan.DischargingPlanSaveRequest request,
        io.grpc.stub.StreamObserver<
                com.cpdss.common.generated.discharge_plan.DischargingPlanSaveResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSaveDischargingPlanMethod(), responseObserver);
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
          .addMethod(
              getGetDischargeUpdateUllageDetailsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels
                          .UpdateUllageDetailsRequest,
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels
                          .UpdateUllageDetailsResponse>(
                      this, METHODID_GET_DISCHARGE_UPDATE_ULLAGE_DETAILS)))
          .addMethod(
              getGenerateDischargePlanMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.cpdss.common.generated.discharge_plan.DischargeInformationRequest,
                      com.cpdss.common.generated.discharge_plan.DischargePlanAlgoRequest>(
                      this, METHODID_GENERATE_DISCHARGE_PLAN)))
          .addMethod(
              getUpdateDischargeUllageDetailsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels.UllageBillRequest,
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels.UllageBillReply>(
                      this, METHODID_UPDATE_DISCHARGE_ULLAGE_DETAILS)))
          .addMethod(
              getSaveDischargingPlanMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.cpdss.common.generated.discharge_plan.DischargingPlanSaveRequest,
                      com.cpdss.common.generated.discharge_plan.DischargingPlanSaveResponse>(
                      this, METHODID_SAVE_DISCHARGING_PLAN)))
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

    /** */
    public void getDischargeUpdateUllageDetails(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.UpdateUllageDetailsRequest
            request,
        io.grpc.stub.StreamObserver<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels
                    .UpdateUllageDetailsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDischargeUpdateUllageDetailsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void generateDischargePlan(
        com.cpdss.common.generated.discharge_plan.DischargeInformationRequest request,
        io.grpc.stub.StreamObserver<
                com.cpdss.common.generated.discharge_plan.DischargePlanAlgoRequest>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateDischargePlanMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void updateDischargeUllageDetails(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.UllageBillRequest request,
        io.grpc.stub.StreamObserver<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.UllageBillReply>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateDischargeUllageDetailsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void saveDischargingPlan(
        com.cpdss.common.generated.discharge_plan.DischargingPlanSaveRequest request,
        io.grpc.stub.StreamObserver<
                com.cpdss.common.generated.discharge_plan.DischargingPlanSaveResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSaveDischargingPlanMethod(), getCallOptions()),
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

    /** */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.UpdateUllageDetailsResponse
        getDischargeUpdateUllageDetails(
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.UpdateUllageDetailsRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDischargeUpdateUllageDetailsMethod(), getCallOptions(), request);
    }

    /** */
    public com.cpdss.common.generated.discharge_plan.DischargePlanAlgoRequest generateDischargePlan(
        com.cpdss.common.generated.discharge_plan.DischargeInformationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateDischargePlanMethod(), getCallOptions(), request);
    }

    /** */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.UllageBillReply
        updateDischargeUllageDetails(
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.UllageBillRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDischargeUllageDetailsMethod(), getCallOptions(), request);
    }

    /** */
    public com.cpdss.common.generated.discharge_plan.DischargingPlanSaveResponse
        saveDischargingPlan(
            com.cpdss.common.generated.discharge_plan.DischargingPlanSaveRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSaveDischargingPlanMethod(), getCallOptions(), request);
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

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.UpdateUllageDetailsResponse>
        getDischargeUpdateUllageDetails(
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.UpdateUllageDetailsRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDischargeUpdateUllageDetailsMethod(), getCallOptions()),
          request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            com.cpdss.common.generated.discharge_plan.DischargePlanAlgoRequest>
        generateDischargePlan(
            com.cpdss.common.generated.discharge_plan.DischargeInformationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateDischargePlanMethod(), getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.UllageBillReply>
        updateDischargeUllageDetails(
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.UllageBillRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateDischargeUllageDetailsMethod(), getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            com.cpdss.common.generated.discharge_plan.DischargingPlanSaveResponse>
        saveDischargingPlan(
            com.cpdss.common.generated.discharge_plan.DischargingPlanSaveRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSaveDischargingPlanMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_DISCHARGE_PLAN_SYNCHRONIZATION = 0;
  private static final int METHODID_GET_DISCHARGE_UPDATE_ULLAGE_DETAILS = 1;
  private static final int METHODID_GENERATE_DISCHARGE_PLAN = 2;
  private static final int METHODID_UPDATE_DISCHARGE_ULLAGE_DETAILS = 3;
  private static final int METHODID_SAVE_DISCHARGING_PLAN = 4;

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
        case METHODID_GET_DISCHARGE_UPDATE_ULLAGE_DETAILS:
          serviceImpl.getDischargeUpdateUllageDetails(
              (com.cpdss.common.generated.loading_plan.LoadingPlanModels.UpdateUllageDetailsRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels
                          .UpdateUllageDetailsResponse>)
                  responseObserver);
          break;
        case METHODID_GENERATE_DISCHARGE_PLAN:
          serviceImpl.generateDischargePlan(
              (com.cpdss.common.generated.discharge_plan.DischargeInformationRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.cpdss.common.generated.discharge_plan.DischargePlanAlgoRequest>)
                  responseObserver);
          break;
        case METHODID_UPDATE_DISCHARGE_ULLAGE_DETAILS:
          serviceImpl.updateDischargeUllageDetails(
              (com.cpdss.common.generated.loading_plan.LoadingPlanModels.UllageBillRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels.UllageBillReply>)
                  responseObserver);
          break;
        case METHODID_SAVE_DISCHARGING_PLAN:
          serviceImpl.saveDischargingPlan(
              (com.cpdss.common.generated.discharge_plan.DischargingPlanSaveRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.cpdss.common.generated.discharge_plan.DischargingPlanSaveResponse>)
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
                      .addMethod(getGetDischargeUpdateUllageDetailsMethod())
                      .addMethod(getGenerateDischargePlanMethod())
                      .addMethod(getUpdateDischargeUllageDetailsMethod())
                      .addMethod(getSaveDischargingPlanMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
