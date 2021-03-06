/* Licensed at AlphaOri Technologies */
package com.cpdss.common.generated.discharge_plan;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/** */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.40.1)",
    comments = "Source: discharge_plan/discharge_plan_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DischargeInformationServiceGrpc {

  private DischargeInformationServiceGrpc() {}

  public static final String SERVICE_NAME = "DischargeInformationService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.cpdss.common.generated.discharge_plan.DischargeInformationRequest,
          com.cpdss.common.generated.discharge_plan.DischargeInformation>
      getGetDischargeInformationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getDischargeInformation",
      requestType = com.cpdss.common.generated.discharge_plan.DischargeInformationRequest.class,
      responseType = com.cpdss.common.generated.discharge_plan.DischargeInformation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.cpdss.common.generated.discharge_plan.DischargeInformationRequest,
          com.cpdss.common.generated.discharge_plan.DischargeInformation>
      getGetDischargeInformationMethod() {
    io.grpc.MethodDescriptor<
            com.cpdss.common.generated.discharge_plan.DischargeInformationRequest,
            com.cpdss.common.generated.discharge_plan.DischargeInformation>
        getGetDischargeInformationMethod;
    if ((getGetDischargeInformationMethod =
            DischargeInformationServiceGrpc.getGetDischargeInformationMethod)
        == null) {
      synchronized (DischargeInformationServiceGrpc.class) {
        if ((getGetDischargeInformationMethod =
                DischargeInformationServiceGrpc.getGetDischargeInformationMethod)
            == null) {
          DischargeInformationServiceGrpc.getGetDischargeInformationMethod =
              getGetDischargeInformationMethod =
                  io.grpc.MethodDescriptor
                      .<com.cpdss.common.generated.discharge_plan.DischargeInformationRequest,
                          com.cpdss.common.generated.discharge_plan.DischargeInformation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "getDischargeInformation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.discharge_plan.DischargeInformationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.discharge_plan.DischargeInformation
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DischargeInformationServiceMethodDescriptorSupplier(
                              "getDischargeInformation"))
                      .build();
        }
      }
    }
    return getGetDischargeInformationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.cpdss.common.generated.discharge_plan.DischargeRuleRequest,
          com.cpdss.common.generated.discharge_plan.DischargeRuleReply>
      getGetOrSaveRulesForDischargingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getOrSaveRulesForDischarging",
      requestType = com.cpdss.common.generated.discharge_plan.DischargeRuleRequest.class,
      responseType = com.cpdss.common.generated.discharge_plan.DischargeRuleReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.cpdss.common.generated.discharge_plan.DischargeRuleRequest,
          com.cpdss.common.generated.discharge_plan.DischargeRuleReply>
      getGetOrSaveRulesForDischargingMethod() {
    io.grpc.MethodDescriptor<
            com.cpdss.common.generated.discharge_plan.DischargeRuleRequest,
            com.cpdss.common.generated.discharge_plan.DischargeRuleReply>
        getGetOrSaveRulesForDischargingMethod;
    if ((getGetOrSaveRulesForDischargingMethod =
            DischargeInformationServiceGrpc.getGetOrSaveRulesForDischargingMethod)
        == null) {
      synchronized (DischargeInformationServiceGrpc.class) {
        if ((getGetOrSaveRulesForDischargingMethod =
                DischargeInformationServiceGrpc.getGetOrSaveRulesForDischargingMethod)
            == null) {
          DischargeInformationServiceGrpc.getGetOrSaveRulesForDischargingMethod =
              getGetOrSaveRulesForDischargingMethod =
                  io.grpc.MethodDescriptor
                      .<com.cpdss.common.generated.discharge_plan.DischargeRuleRequest,
                          com.cpdss.common.generated.discharge_plan.DischargeRuleReply>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "getOrSaveRulesForDischarging"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.discharge_plan.DischargeRuleRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.discharge_plan.DischargeRuleReply
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DischargeInformationServiceMethodDescriptorSupplier(
                              "getOrSaveRulesForDischarging"))
                      .build();
        }
      }
    }
    return getGetOrSaveRulesForDischargingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.cpdss.common.generated.discharge_plan.DischargingUploadTideDetailRequest,
          com.cpdss.common.generated.discharge_plan.DischargingUploadTideDetailStatusReply>
      getDischargingUploadPortTideDetailsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DischargingUploadPortTideDetails",
      requestType =
          com.cpdss.common.generated.discharge_plan.DischargingUploadTideDetailRequest.class,
      responseType =
          com.cpdss.common.generated.discharge_plan.DischargingUploadTideDetailStatusReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.cpdss.common.generated.discharge_plan.DischargingUploadTideDetailRequest,
          com.cpdss.common.generated.discharge_plan.DischargingUploadTideDetailStatusReply>
      getDischargingUploadPortTideDetailsMethod() {
    io.grpc.MethodDescriptor<
            com.cpdss.common.generated.discharge_plan.DischargingUploadTideDetailRequest,
            com.cpdss.common.generated.discharge_plan.DischargingUploadTideDetailStatusReply>
        getDischargingUploadPortTideDetailsMethod;
    if ((getDischargingUploadPortTideDetailsMethod =
            DischargeInformationServiceGrpc.getDischargingUploadPortTideDetailsMethod)
        == null) {
      synchronized (DischargeInformationServiceGrpc.class) {
        if ((getDischargingUploadPortTideDetailsMethod =
                DischargeInformationServiceGrpc.getDischargingUploadPortTideDetailsMethod)
            == null) {
          DischargeInformationServiceGrpc.getDischargingUploadPortTideDetailsMethod =
              getDischargingUploadPortTideDetailsMethod =
                  io.grpc.MethodDescriptor
                      .<com.cpdss.common.generated.discharge_plan
                              .DischargingUploadTideDetailRequest,
                          com.cpdss.common.generated.discharge_plan
                              .DischargingUploadTideDetailStatusReply>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DischargingUploadPortTideDetails"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.discharge_plan
                                  .DischargingUploadTideDetailRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.discharge_plan
                                  .DischargingUploadTideDetailStatusReply.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DischargeInformationServiceMethodDescriptorSupplier(
                              "DischargingUploadPortTideDetails"))
                      .build();
        }
      }
    }
    return getDischargingUploadPortTideDetailsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.cpdss.common.generated.discharge_plan.DischargingDownloadTideDetailRequest,
          com.cpdss.common.generated.discharge_plan.DischargingDownloadTideDetailStatusReply>
      getDischargingDownloadPortTideDetailsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DischargingDownloadPortTideDetails",
      requestType =
          com.cpdss.common.generated.discharge_plan.DischargingDownloadTideDetailRequest.class,
      responseType =
          com.cpdss.common.generated.discharge_plan.DischargingDownloadTideDetailStatusReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<
          com.cpdss.common.generated.discharge_plan.DischargingDownloadTideDetailRequest,
          com.cpdss.common.generated.discharge_plan.DischargingDownloadTideDetailStatusReply>
      getDischargingDownloadPortTideDetailsMethod() {
    io.grpc.MethodDescriptor<
            com.cpdss.common.generated.discharge_plan.DischargingDownloadTideDetailRequest,
            com.cpdss.common.generated.discharge_plan.DischargingDownloadTideDetailStatusReply>
        getDischargingDownloadPortTideDetailsMethod;
    if ((getDischargingDownloadPortTideDetailsMethod =
            DischargeInformationServiceGrpc.getDischargingDownloadPortTideDetailsMethod)
        == null) {
      synchronized (DischargeInformationServiceGrpc.class) {
        if ((getDischargingDownloadPortTideDetailsMethod =
                DischargeInformationServiceGrpc.getDischargingDownloadPortTideDetailsMethod)
            == null) {
          DischargeInformationServiceGrpc.getDischargingDownloadPortTideDetailsMethod =
              getDischargingDownloadPortTideDetailsMethod =
                  io.grpc.MethodDescriptor
                      .<com.cpdss.common.generated.discharge_plan
                              .DischargingDownloadTideDetailRequest,
                          com.cpdss.common.generated.discharge_plan
                              .DischargingDownloadTideDetailStatusReply>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "DischargingDownloadPortTideDetails"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.discharge_plan
                                  .DischargingDownloadTideDetailRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.discharge_plan
                                  .DischargingDownloadTideDetailStatusReply.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DischargeInformationServiceMethodDescriptorSupplier(
                              "DischargingDownloadPortTideDetails"))
                      .build();
        }
      }
    }
    return getDischargingDownloadPortTideDetailsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.cpdss.common.generated.discharge_plan.DischargeInformationRequest,
          com.cpdss.common.generated.discharge_plan.DischargingPlanReply>
      getGetDischargingPlanMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDischargingPlan",
      requestType = com.cpdss.common.generated.discharge_plan.DischargeInformationRequest.class,
      responseType = com.cpdss.common.generated.discharge_plan.DischargingPlanReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.cpdss.common.generated.discharge_plan.DischargeInformationRequest,
          com.cpdss.common.generated.discharge_plan.DischargingPlanReply>
      getGetDischargingPlanMethod() {
    io.grpc.MethodDescriptor<
            com.cpdss.common.generated.discharge_plan.DischargeInformationRequest,
            com.cpdss.common.generated.discharge_plan.DischargingPlanReply>
        getGetDischargingPlanMethod;
    if ((getGetDischargingPlanMethod = DischargeInformationServiceGrpc.getGetDischargingPlanMethod)
        == null) {
      synchronized (DischargeInformationServiceGrpc.class) {
        if ((getGetDischargingPlanMethod =
                DischargeInformationServiceGrpc.getGetDischargingPlanMethod)
            == null) {
          DischargeInformationServiceGrpc.getGetDischargingPlanMethod =
              getGetDischargingPlanMethod =
                  io.grpc.MethodDescriptor
                      .<com.cpdss.common.generated.discharge_plan.DischargeInformationRequest,
                          com.cpdss.common.generated.discharge_plan.DischargingPlanReply>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDischargingPlan"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.discharge_plan.DischargeInformationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.discharge_plan.DischargingPlanReply
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DischargeInformationServiceMethodDescriptorSupplier(
                              "GetDischargingPlan"))
                      .build();
        }
      }
    }
    return getGetDischargingPlanMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.cpdss.common.generated.discharge_plan.DischargeInformation,
          com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>
      getSaveDischargingInformationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SaveDischargingInformation",
      requestType = com.cpdss.common.generated.discharge_plan.DischargeInformation.class,
      responseType = com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.cpdss.common.generated.discharge_plan.DischargeInformation,
          com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>
      getSaveDischargingInformationMethod() {
    io.grpc.MethodDescriptor<
            com.cpdss.common.generated.discharge_plan.DischargeInformation,
            com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>
        getSaveDischargingInformationMethod;
    if ((getSaveDischargingInformationMethod =
            DischargeInformationServiceGrpc.getSaveDischargingInformationMethod)
        == null) {
      synchronized (DischargeInformationServiceGrpc.class) {
        if ((getSaveDischargingInformationMethod =
                DischargeInformationServiceGrpc.getSaveDischargingInformationMethod)
            == null) {
          DischargeInformationServiceGrpc.getSaveDischargingInformationMethod =
              getSaveDischargingInformationMethod =
                  io.grpc.MethodDescriptor
                      .<com.cpdss.common.generated.discharge_plan.DischargeInformation,
                          com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "SaveDischargingInformation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.discharge_plan.DischargeInformation
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DischargeInformationServiceMethodDescriptorSupplier(
                              "SaveDischargingInformation"))
                      .build();
        }
      }
    }
    return getSaveDischargingInformationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.cpdss.common.generated.discharge_plan.DischargeInformation,
          com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>
      getSaveDischargingInfoRatesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SaveDischargingInfoRates",
      requestType = com.cpdss.common.generated.discharge_plan.DischargeInformation.class,
      responseType = com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.cpdss.common.generated.discharge_plan.DischargeInformation,
          com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>
      getSaveDischargingInfoRatesMethod() {
    io.grpc.MethodDescriptor<
            com.cpdss.common.generated.discharge_plan.DischargeInformation,
            com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>
        getSaveDischargingInfoRatesMethod;
    if ((getSaveDischargingInfoRatesMethod =
            DischargeInformationServiceGrpc.getSaveDischargingInfoRatesMethod)
        == null) {
      synchronized (DischargeInformationServiceGrpc.class) {
        if ((getSaveDischargingInfoRatesMethod =
                DischargeInformationServiceGrpc.getSaveDischargingInfoRatesMethod)
            == null) {
          DischargeInformationServiceGrpc.getSaveDischargingInfoRatesMethod =
              getSaveDischargingInfoRatesMethod =
                  io.grpc.MethodDescriptor
                      .<com.cpdss.common.generated.discharge_plan.DischargeInformation,
                          com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "SaveDischargingInfoRates"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.discharge_plan.DischargeInformation
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DischargeInformationServiceMethodDescriptorSupplier(
                              "SaveDischargingInfoRates"))
                      .build();
        }
      }
    }
    return getSaveDischargingInfoRatesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.cpdss.common.generated.discharge_plan.DischargeInformation,
          com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>
      getSaveDischargingInfoBerthsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SaveDischargingInfoBerths",
      requestType = com.cpdss.common.generated.discharge_plan.DischargeInformation.class,
      responseType = com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.cpdss.common.generated.discharge_plan.DischargeInformation,
          com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>
      getSaveDischargingInfoBerthsMethod() {
    io.grpc.MethodDescriptor<
            com.cpdss.common.generated.discharge_plan.DischargeInformation,
            com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>
        getSaveDischargingInfoBerthsMethod;
    if ((getSaveDischargingInfoBerthsMethod =
            DischargeInformationServiceGrpc.getSaveDischargingInfoBerthsMethod)
        == null) {
      synchronized (DischargeInformationServiceGrpc.class) {
        if ((getSaveDischargingInfoBerthsMethod =
                DischargeInformationServiceGrpc.getSaveDischargingInfoBerthsMethod)
            == null) {
          DischargeInformationServiceGrpc.getSaveDischargingInfoBerthsMethod =
              getSaveDischargingInfoBerthsMethod =
                  io.grpc.MethodDescriptor
                      .<com.cpdss.common.generated.discharge_plan.DischargeInformation,
                          com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "SaveDischargingInfoBerths"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.discharge_plan.DischargeInformation
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DischargeInformationServiceMethodDescriptorSupplier(
                              "SaveDischargingInfoBerths"))
                      .build();
        }
      }
    }
    return getSaveDischargingInfoBerthsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.cpdss.common.generated.discharge_plan.DischargeInformation,
          com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>
      getSaveDischargingInfoMachineryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SaveDischargingInfoMachinery",
      requestType = com.cpdss.common.generated.discharge_plan.DischargeInformation.class,
      responseType = com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.cpdss.common.generated.discharge_plan.DischargeInformation,
          com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>
      getSaveDischargingInfoMachineryMethod() {
    io.grpc.MethodDescriptor<
            com.cpdss.common.generated.discharge_plan.DischargeInformation,
            com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>
        getSaveDischargingInfoMachineryMethod;
    if ((getSaveDischargingInfoMachineryMethod =
            DischargeInformationServiceGrpc.getSaveDischargingInfoMachineryMethod)
        == null) {
      synchronized (DischargeInformationServiceGrpc.class) {
        if ((getSaveDischargingInfoMachineryMethod =
                DischargeInformationServiceGrpc.getSaveDischargingInfoMachineryMethod)
            == null) {
          DischargeInformationServiceGrpc.getSaveDischargingInfoMachineryMethod =
              getSaveDischargingInfoMachineryMethod =
                  io.grpc.MethodDescriptor
                      .<com.cpdss.common.generated.discharge_plan.DischargeInformation,
                          com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "SaveDischargingInfoMachinery"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.discharge_plan.DischargeInformation
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DischargeInformationServiceMethodDescriptorSupplier(
                              "SaveDischargingInfoMachinery"))
                      .build();
        }
      }
    }
    return getSaveDischargingInfoMachineryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.cpdss.common.generated.discharge_plan.DischargeInformation,
          com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>
      getSaveDischargingInfoDelaysMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SaveDischargingInfoDelays",
      requestType = com.cpdss.common.generated.discharge_plan.DischargeInformation.class,
      responseType = com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.cpdss.common.generated.discharge_plan.DischargeInformation,
          com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>
      getSaveDischargingInfoDelaysMethod() {
    io.grpc.MethodDescriptor<
            com.cpdss.common.generated.discharge_plan.DischargeInformation,
            com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>
        getSaveDischargingInfoDelaysMethod;
    if ((getSaveDischargingInfoDelaysMethod =
            DischargeInformationServiceGrpc.getSaveDischargingInfoDelaysMethod)
        == null) {
      synchronized (DischargeInformationServiceGrpc.class) {
        if ((getSaveDischargingInfoDelaysMethod =
                DischargeInformationServiceGrpc.getSaveDischargingInfoDelaysMethod)
            == null) {
          DischargeInformationServiceGrpc.getSaveDischargingInfoDelaysMethod =
              getSaveDischargingInfoDelaysMethod =
                  io.grpc.MethodDescriptor
                      .<com.cpdss.common.generated.discharge_plan.DischargeInformation,
                          com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "SaveDischargingInfoDelays"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.discharge_plan.DischargeInformation
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DischargeInformationServiceMethodDescriptorSupplier(
                              "SaveDischargingInfoDelays"))
                      .build();
        }
      }
    }
    return getSaveDischargingInfoDelaysMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.cpdss.common.generated.discharge_plan.DischargeInformation,
          com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>
      getSaveDischargingInfoStagesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SaveDischargingInfoStages",
      requestType = com.cpdss.common.generated.discharge_plan.DischargeInformation.class,
      responseType = com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.cpdss.common.generated.discharge_plan.DischargeInformation,
          com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>
      getSaveDischargingInfoStagesMethod() {
    io.grpc.MethodDescriptor<
            com.cpdss.common.generated.discharge_plan.DischargeInformation,
            com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>
        getSaveDischargingInfoStagesMethod;
    if ((getSaveDischargingInfoStagesMethod =
            DischargeInformationServiceGrpc.getSaveDischargingInfoStagesMethod)
        == null) {
      synchronized (DischargeInformationServiceGrpc.class) {
        if ((getSaveDischargingInfoStagesMethod =
                DischargeInformationServiceGrpc.getSaveDischargingInfoStagesMethod)
            == null) {
          DischargeInformationServiceGrpc.getSaveDischargingInfoStagesMethod =
              getSaveDischargingInfoStagesMethod =
                  io.grpc.MethodDescriptor
                      .<com.cpdss.common.generated.discharge_plan.DischargeInformation,
                          com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "SaveDischargingInfoStages"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.discharge_plan.DischargeInformation
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DischargeInformationServiceMethodDescriptorSupplier(
                              "SaveDischargingInfoStages"))
                      .build();
        }
      }
    }
    return getSaveDischargingInfoStagesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.cpdss.common.generated.discharge_plan.DischargeInformation,
          com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>
      getSaveCowPlanMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "saveCowPlan",
      requestType = com.cpdss.common.generated.discharge_plan.DischargeInformation.class,
      responseType = com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.cpdss.common.generated.discharge_plan.DischargeInformation,
          com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>
      getSaveCowPlanMethod() {
    io.grpc.MethodDescriptor<
            com.cpdss.common.generated.discharge_plan.DischargeInformation,
            com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>
        getSaveCowPlanMethod;
    if ((getSaveCowPlanMethod = DischargeInformationServiceGrpc.getSaveCowPlanMethod) == null) {
      synchronized (DischargeInformationServiceGrpc.class) {
        if ((getSaveCowPlanMethod = DischargeInformationServiceGrpc.getSaveCowPlanMethod) == null) {
          DischargeInformationServiceGrpc.getSaveCowPlanMethod =
              getSaveCowPlanMethod =
                  io.grpc.MethodDescriptor
                      .<com.cpdss.common.generated.discharge_plan.DischargeInformation,
                          com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "saveCowPlan"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.discharge_plan.DischargeInformation
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DischargeInformationServiceMethodDescriptorSupplier("saveCowPlan"))
                      .build();
        }
      }
    }
    return getSaveCowPlanMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.cpdss.common.generated.discharge_plan.DischargeInformation,
          com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>
      getSavePostDischargeStageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "savePostDischargeStage",
      requestType = com.cpdss.common.generated.discharge_plan.DischargeInformation.class,
      responseType = com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.cpdss.common.generated.discharge_plan.DischargeInformation,
          com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>
      getSavePostDischargeStageMethod() {
    io.grpc.MethodDescriptor<
            com.cpdss.common.generated.discharge_plan.DischargeInformation,
            com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>
        getSavePostDischargeStageMethod;
    if ((getSavePostDischargeStageMethod =
            DischargeInformationServiceGrpc.getSavePostDischargeStageMethod)
        == null) {
      synchronized (DischargeInformationServiceGrpc.class) {
        if ((getSavePostDischargeStageMethod =
                DischargeInformationServiceGrpc.getSavePostDischargeStageMethod)
            == null) {
          DischargeInformationServiceGrpc.getSavePostDischargeStageMethod =
              getSavePostDischargeStageMethod =
                  io.grpc.MethodDescriptor
                      .<com.cpdss.common.generated.discharge_plan.DischargeInformation,
                          com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "savePostDischargeStage"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.discharge_plan.DischargeInformation
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DischargeInformationServiceMethodDescriptorSupplier(
                              "savePostDischargeStage"))
                      .build();
        }
      }
    }
    return getSavePostDischargeStageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.cpdss.common.generated.discharge_plan.DischargeInformation,
          com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>
      getSaveCargoToBeDischargedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SaveCargoToBeDischarged",
      requestType = com.cpdss.common.generated.discharge_plan.DischargeInformation.class,
      responseType = com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.cpdss.common.generated.discharge_plan.DischargeInformation,
          com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>
      getSaveCargoToBeDischargedMethod() {
    io.grpc.MethodDescriptor<
            com.cpdss.common.generated.discharge_plan.DischargeInformation,
            com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>
        getSaveCargoToBeDischargedMethod;
    if ((getSaveCargoToBeDischargedMethod =
            DischargeInformationServiceGrpc.getSaveCargoToBeDischargedMethod)
        == null) {
      synchronized (DischargeInformationServiceGrpc.class) {
        if ((getSaveCargoToBeDischargedMethod =
                DischargeInformationServiceGrpc.getSaveCargoToBeDischargedMethod)
            == null) {
          DischargeInformationServiceGrpc.getSaveCargoToBeDischargedMethod =
              getSaveCargoToBeDischargedMethod =
                  io.grpc.MethodDescriptor
                      .<com.cpdss.common.generated.discharge_plan.DischargeInformation,
                          com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "SaveCargoToBeDischarged"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.discharge_plan.DischargeInformation
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DischargeInformationServiceMethodDescriptorSupplier(
                              "SaveCargoToBeDischarged"))
                      .build();
        }
      }
    }
    return getSaveCargoToBeDischargedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.cpdss.common.generated.discharge_plan.DischargeInformation,
          com.cpdss.common.generated.discharge_plan.DischargeInformation>
      getGetCargoToBeDischargedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCargoToBeDischarged",
      requestType = com.cpdss.common.generated.discharge_plan.DischargeInformation.class,
      responseType = com.cpdss.common.generated.discharge_plan.DischargeInformation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.cpdss.common.generated.discharge_plan.DischargeInformation,
          com.cpdss.common.generated.discharge_plan.DischargeInformation>
      getGetCargoToBeDischargedMethod() {
    io.grpc.MethodDescriptor<
            com.cpdss.common.generated.discharge_plan.DischargeInformation,
            com.cpdss.common.generated.discharge_plan.DischargeInformation>
        getGetCargoToBeDischargedMethod;
    if ((getGetCargoToBeDischargedMethod =
            DischargeInformationServiceGrpc.getGetCargoToBeDischargedMethod)
        == null) {
      synchronized (DischargeInformationServiceGrpc.class) {
        if ((getGetCargoToBeDischargedMethod =
                DischargeInformationServiceGrpc.getGetCargoToBeDischargedMethod)
            == null) {
          DischargeInformationServiceGrpc.getGetCargoToBeDischargedMethod =
              getGetCargoToBeDischargedMethod =
                  io.grpc.MethodDescriptor
                      .<com.cpdss.common.generated.discharge_plan.DischargeInformation,
                          com.cpdss.common.generated.discharge_plan.DischargeInformation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetCargoToBeDischarged"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.discharge_plan.DischargeInformation
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.discharge_plan.DischargeInformation
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DischargeInformationServiceMethodDescriptorSupplier(
                              "GetCargoToBeDischarged"))
                      .build();
        }
      }
    }
    return getGetCargoToBeDischargedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.cpdss.common.generated.discharge_plan.DischargeRuleRequest,
          com.cpdss.common.generated.discharge_plan.DischargeRuleReply>
      getGetOrSaveRulesForDischargingPlanMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetOrSaveRulesForDischargingPlan",
      requestType = com.cpdss.common.generated.discharge_plan.DischargeRuleRequest.class,
      responseType = com.cpdss.common.generated.discharge_plan.DischargeRuleReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.cpdss.common.generated.discharge_plan.DischargeRuleRequest,
          com.cpdss.common.generated.discharge_plan.DischargeRuleReply>
      getGetOrSaveRulesForDischargingPlanMethod() {
    io.grpc.MethodDescriptor<
            com.cpdss.common.generated.discharge_plan.DischargeRuleRequest,
            com.cpdss.common.generated.discharge_plan.DischargeRuleReply>
        getGetOrSaveRulesForDischargingPlanMethod;
    if ((getGetOrSaveRulesForDischargingPlanMethod =
            DischargeInformationServiceGrpc.getGetOrSaveRulesForDischargingPlanMethod)
        == null) {
      synchronized (DischargeInformationServiceGrpc.class) {
        if ((getGetOrSaveRulesForDischargingPlanMethod =
                DischargeInformationServiceGrpc.getGetOrSaveRulesForDischargingPlanMethod)
            == null) {
          DischargeInformationServiceGrpc.getGetOrSaveRulesForDischargingPlanMethod =
              getGetOrSaveRulesForDischargingPlanMethod =
                  io.grpc.MethodDescriptor
                      .<com.cpdss.common.generated.discharge_plan.DischargeRuleRequest,
                          com.cpdss.common.generated.discharge_plan.DischargeRuleReply>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetOrSaveRulesForDischargingPlan"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.discharge_plan.DischargeRuleRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.discharge_plan.DischargeRuleReply
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DischargeInformationServiceMethodDescriptorSupplier(
                              "GetOrSaveRulesForDischargingPlan"))
                      .build();
        }
      }
    }
    return getGetOrSaveRulesForDischargingPlanMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.cpdss.common.generated.discharge_plan.PortDischargingPlanRobDetailsRequest,
          com.cpdss.common.generated.discharge_plan.PortDischargingPlanRobDetailsReply>
      getGetPortDischargingPlanRobDetailsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getPortDischargingPlanRobDetails",
      requestType =
          com.cpdss.common.generated.discharge_plan.PortDischargingPlanRobDetailsRequest.class,
      responseType =
          com.cpdss.common.generated.discharge_plan.PortDischargingPlanRobDetailsReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.cpdss.common.generated.discharge_plan.PortDischargingPlanRobDetailsRequest,
          com.cpdss.common.generated.discharge_plan.PortDischargingPlanRobDetailsReply>
      getGetPortDischargingPlanRobDetailsMethod() {
    io.grpc.MethodDescriptor<
            com.cpdss.common.generated.discharge_plan.PortDischargingPlanRobDetailsRequest,
            com.cpdss.common.generated.discharge_plan.PortDischargingPlanRobDetailsReply>
        getGetPortDischargingPlanRobDetailsMethod;
    if ((getGetPortDischargingPlanRobDetailsMethod =
            DischargeInformationServiceGrpc.getGetPortDischargingPlanRobDetailsMethod)
        == null) {
      synchronized (DischargeInformationServiceGrpc.class) {
        if ((getGetPortDischargingPlanRobDetailsMethod =
                DischargeInformationServiceGrpc.getGetPortDischargingPlanRobDetailsMethod)
            == null) {
          DischargeInformationServiceGrpc.getGetPortDischargingPlanRobDetailsMethod =
              getGetPortDischargingPlanRobDetailsMethod =
                  io.grpc.MethodDescriptor
                      .<com.cpdss.common.generated.discharge_plan
                              .PortDischargingPlanRobDetailsRequest,
                          com.cpdss.common.generated.discharge_plan
                              .PortDischargingPlanRobDetailsReply>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "getPortDischargingPlanRobDetails"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.discharge_plan
                                  .PortDischargingPlanRobDetailsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.discharge_plan
                                  .PortDischargingPlanRobDetailsReply.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DischargeInformationServiceMethodDescriptorSupplier(
                              "getPortDischargingPlanRobDetails"))
                      .build();
        }
      }
    }
    return getGetPortDischargingPlanRobDetailsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static DischargeInformationServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DischargeInformationServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DischargeInformationServiceStub>() {
          @java.lang.Override
          public DischargeInformationServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DischargeInformationServiceStub(channel, callOptions);
          }
        };
    return DischargeInformationServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DischargeInformationServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DischargeInformationServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DischargeInformationServiceBlockingStub>() {
          @java.lang.Override
          public DischargeInformationServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DischargeInformationServiceBlockingStub(channel, callOptions);
          }
        };
    return DischargeInformationServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static DischargeInformationServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DischargeInformationServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DischargeInformationServiceFutureStub>() {
          @java.lang.Override
          public DischargeInformationServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DischargeInformationServiceFutureStub(channel, callOptions);
          }
        };
    return DischargeInformationServiceFutureStub.newStub(factory, channel);
  }

  /** */
  public abstract static class DischargeInformationServiceImplBase
      implements io.grpc.BindableService {

    /** */
    public void getDischargeInformation(
        com.cpdss.common.generated.discharge_plan.DischargeInformationRequest request,
        io.grpc.stub.StreamObserver<com.cpdss.common.generated.discharge_plan.DischargeInformation>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDischargeInformationMethod(), responseObserver);
    }

    /** */
    public void getOrSaveRulesForDischarging(
        com.cpdss.common.generated.discharge_plan.DischargeRuleRequest request,
        io.grpc.stub.StreamObserver<com.cpdss.common.generated.discharge_plan.DischargeRuleReply>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetOrSaveRulesForDischargingMethod(), responseObserver);
    }

    /** */
    public void dischargingUploadPortTideDetails(
        com.cpdss.common.generated.discharge_plan.DischargingUploadTideDetailRequest request,
        io.grpc.stub.StreamObserver<
                com.cpdss.common.generated.discharge_plan.DischargingUploadTideDetailStatusReply>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDischargingUploadPortTideDetailsMethod(), responseObserver);
    }

    /** */
    public void dischargingDownloadPortTideDetails(
        com.cpdss.common.generated.discharge_plan.DischargingDownloadTideDetailRequest request,
        io.grpc.stub.StreamObserver<
                com.cpdss.common.generated.discharge_plan.DischargingDownloadTideDetailStatusReply>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDischargingDownloadPortTideDetailsMethod(), responseObserver);
    }

    /** */
    public void getDischargingPlan(
        com.cpdss.common.generated.discharge_plan.DischargeInformationRequest request,
        io.grpc.stub.StreamObserver<com.cpdss.common.generated.discharge_plan.DischargingPlanReply>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDischargingPlanMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Case 1, Discharging Details
     * </pre>
     */
    public void saveDischargingInformation(
        com.cpdss.common.generated.discharge_plan.DischargeInformation request,
        io.grpc.stub.StreamObserver<
                com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSaveDischargingInformationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Case 2, Only Discharging Rate data
     * </pre>
     */
    public void saveDischargingInfoRates(
        com.cpdss.common.generated.discharge_plan.DischargeInformation request,
        io.grpc.stub.StreamObserver<
                com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSaveDischargingInfoRatesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Case 3, Adding Or Removing Berth Data
     * </pre>
     */
    public void saveDischargingInfoBerths(
        com.cpdss.common.generated.discharge_plan.DischargeInformation request,
        io.grpc.stub.StreamObserver<
                com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSaveDischargingInfoBerthsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Case 4, Machines in Use data
     * </pre>
     */
    public void saveDischargingInfoMachinery(
        com.cpdss.common.generated.discharge_plan.DischargeInformation request,
        io.grpc.stub.StreamObserver<
                com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSaveDischargingInfoMachineryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Case 5, reason for delay
     * </pre>
     */
    public void saveDischargingInfoDelays(
        com.cpdss.common.generated.discharge_plan.DischargeInformation request,
        io.grpc.stub.StreamObserver<
                com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSaveDischargingInfoDelaysMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Case 6, Stages and track status
     * </pre>
     */
    public void saveDischargingInfoStages(
        com.cpdss.common.generated.discharge_plan.DischargeInformation request,
        io.grpc.stub.StreamObserver<
                com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSaveDischargingInfoStagesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Case 7, Cow plan
     * </pre>
     */
    public void saveCowPlan(
        com.cpdss.common.generated.discharge_plan.DischargeInformation request,
        io.grpc.stub.StreamObserver<
                com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSaveCowPlanMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Case 7, post discharge stage
     * </pre>
     */
    public void savePostDischargeStage(
        com.cpdss.common.generated.discharge_plan.DischargeInformation request,
        io.grpc.stub.StreamObserver<
                com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSavePostDischargeStageMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Case 10, Cargo to be discharged
     * </pre>
     */
    public void saveCargoToBeDischarged(
        com.cpdss.common.generated.discharge_plan.DischargeInformation request,
        io.grpc.stub.StreamObserver<
                com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSaveCargoToBeDischargedMethod(), responseObserver);
    }

    /** */
    public void getCargoToBeDischarged(
        com.cpdss.common.generated.discharge_plan.DischargeInformation request,
        io.grpc.stub.StreamObserver<com.cpdss.common.generated.discharge_plan.DischargeInformation>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetCargoToBeDischargedMethod(), responseObserver);
    }

    /** */
    public void getOrSaveRulesForDischargingPlan(
        com.cpdss.common.generated.discharge_plan.DischargeRuleRequest request,
        io.grpc.stub.StreamObserver<com.cpdss.common.generated.discharge_plan.DischargeRuleReply>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetOrSaveRulesForDischargingPlanMethod(), responseObserver);
    }

    /** */
    public void getPortDischargingPlanRobDetails(
        com.cpdss.common.generated.discharge_plan.PortDischargingPlanRobDetailsRequest request,
        io.grpc.stub.StreamObserver<
                com.cpdss.common.generated.discharge_plan.PortDischargingPlanRobDetailsReply>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetPortDischargingPlanRobDetailsMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getGetDischargeInformationMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.cpdss.common.generated.discharge_plan.DischargeInformationRequest,
                      com.cpdss.common.generated.discharge_plan.DischargeInformation>(
                      this, METHODID_GET_DISCHARGE_INFORMATION)))
          .addMethod(
              getGetOrSaveRulesForDischargingMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.cpdss.common.generated.discharge_plan.DischargeRuleRequest,
                      com.cpdss.common.generated.discharge_plan.DischargeRuleReply>(
                      this, METHODID_GET_OR_SAVE_RULES_FOR_DISCHARGING)))
          .addMethod(
              getDischargingUploadPortTideDetailsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.cpdss.common.generated.discharge_plan.DischargingUploadTideDetailRequest,
                      com.cpdss.common.generated.discharge_plan
                          .DischargingUploadTideDetailStatusReply>(
                      this, METHODID_DISCHARGING_UPLOAD_PORT_TIDE_DETAILS)))
          .addMethod(
              getDischargingDownloadPortTideDetailsMethod(),
              io.grpc.stub.ServerCalls.asyncServerStreamingCall(
                  new MethodHandlers<
                      com.cpdss.common.generated.discharge_plan
                          .DischargingDownloadTideDetailRequest,
                      com.cpdss.common.generated.discharge_plan
                          .DischargingDownloadTideDetailStatusReply>(
                      this, METHODID_DISCHARGING_DOWNLOAD_PORT_TIDE_DETAILS)))
          .addMethod(
              getGetDischargingPlanMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.cpdss.common.generated.discharge_plan.DischargeInformationRequest,
                      com.cpdss.common.generated.discharge_plan.DischargingPlanReply>(
                      this, METHODID_GET_DISCHARGING_PLAN)))
          .addMethod(
              getSaveDischargingInformationMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.cpdss.common.generated.discharge_plan.DischargeInformation,
                      com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>(
                      this, METHODID_SAVE_DISCHARGING_INFORMATION)))
          .addMethod(
              getSaveDischargingInfoRatesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.cpdss.common.generated.discharge_plan.DischargeInformation,
                      com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>(
                      this, METHODID_SAVE_DISCHARGING_INFO_RATES)))
          .addMethod(
              getSaveDischargingInfoBerthsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.cpdss.common.generated.discharge_plan.DischargeInformation,
                      com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>(
                      this, METHODID_SAVE_DISCHARGING_INFO_BERTHS)))
          .addMethod(
              getSaveDischargingInfoMachineryMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.cpdss.common.generated.discharge_plan.DischargeInformation,
                      com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>(
                      this, METHODID_SAVE_DISCHARGING_INFO_MACHINERY)))
          .addMethod(
              getSaveDischargingInfoDelaysMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.cpdss.common.generated.discharge_plan.DischargeInformation,
                      com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>(
                      this, METHODID_SAVE_DISCHARGING_INFO_DELAYS)))
          .addMethod(
              getSaveDischargingInfoStagesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.cpdss.common.generated.discharge_plan.DischargeInformation,
                      com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>(
                      this, METHODID_SAVE_DISCHARGING_INFO_STAGES)))
          .addMethod(
              getSaveCowPlanMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.cpdss.common.generated.discharge_plan.DischargeInformation,
                      com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>(
                      this, METHODID_SAVE_COW_PLAN)))
          .addMethod(
              getSavePostDischargeStageMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.cpdss.common.generated.discharge_plan.DischargeInformation,
                      com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>(
                      this, METHODID_SAVE_POST_DISCHARGE_STAGE)))
          .addMethod(
              getSaveCargoToBeDischargedMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.cpdss.common.generated.discharge_plan.DischargeInformation,
                      com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>(
                      this, METHODID_SAVE_CARGO_TO_BE_DISCHARGED)))
          .addMethod(
              getGetCargoToBeDischargedMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.cpdss.common.generated.discharge_plan.DischargeInformation,
                      com.cpdss.common.generated.discharge_plan.DischargeInformation>(
                      this, METHODID_GET_CARGO_TO_BE_DISCHARGED)))
          .addMethod(
              getGetOrSaveRulesForDischargingPlanMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.cpdss.common.generated.discharge_plan.DischargeRuleRequest,
                      com.cpdss.common.generated.discharge_plan.DischargeRuleReply>(
                      this, METHODID_GET_OR_SAVE_RULES_FOR_DISCHARGING_PLAN)))
          .addMethod(
              getGetPortDischargingPlanRobDetailsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.cpdss.common.generated.discharge_plan
                          .PortDischargingPlanRobDetailsRequest,
                      com.cpdss.common.generated.discharge_plan.PortDischargingPlanRobDetailsReply>(
                      this, METHODID_GET_PORT_DISCHARGING_PLAN_ROB_DETAILS)))
          .build();
    }
  }

  /** */
  public static final class DischargeInformationServiceStub
      extends io.grpc.stub.AbstractAsyncStub<DischargeInformationServiceStub> {
    private DischargeInformationServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DischargeInformationServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DischargeInformationServiceStub(channel, callOptions);
    }

    /** */
    public void getDischargeInformation(
        com.cpdss.common.generated.discharge_plan.DischargeInformationRequest request,
        io.grpc.stub.StreamObserver<com.cpdss.common.generated.discharge_plan.DischargeInformation>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDischargeInformationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void getOrSaveRulesForDischarging(
        com.cpdss.common.generated.discharge_plan.DischargeRuleRequest request,
        io.grpc.stub.StreamObserver<com.cpdss.common.generated.discharge_plan.DischargeRuleReply>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetOrSaveRulesForDischargingMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void dischargingUploadPortTideDetails(
        com.cpdss.common.generated.discharge_plan.DischargingUploadTideDetailRequest request,
        io.grpc.stub.StreamObserver<
                com.cpdss.common.generated.discharge_plan.DischargingUploadTideDetailStatusReply>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDischargingUploadPortTideDetailsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void dischargingDownloadPortTideDetails(
        com.cpdss.common.generated.discharge_plan.DischargingDownloadTideDetailRequest request,
        io.grpc.stub.StreamObserver<
                com.cpdss.common.generated.discharge_plan.DischargingDownloadTideDetailStatusReply>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getDischargingDownloadPortTideDetailsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void getDischargingPlan(
        com.cpdss.common.generated.discharge_plan.DischargeInformationRequest request,
        io.grpc.stub.StreamObserver<com.cpdss.common.generated.discharge_plan.DischargingPlanReply>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDischargingPlanMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Case 1, Discharging Details
     * </pre>
     */
    public void saveDischargingInformation(
        com.cpdss.common.generated.discharge_plan.DischargeInformation request,
        io.grpc.stub.StreamObserver<
                com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSaveDischargingInformationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Case 2, Only Discharging Rate data
     * </pre>
     */
    public void saveDischargingInfoRates(
        com.cpdss.common.generated.discharge_plan.DischargeInformation request,
        io.grpc.stub.StreamObserver<
                com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSaveDischargingInfoRatesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Case 3, Adding Or Removing Berth Data
     * </pre>
     */
    public void saveDischargingInfoBerths(
        com.cpdss.common.generated.discharge_plan.DischargeInformation request,
        io.grpc.stub.StreamObserver<
                com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSaveDischargingInfoBerthsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Case 4, Machines in Use data
     * </pre>
     */
    public void saveDischargingInfoMachinery(
        com.cpdss.common.generated.discharge_plan.DischargeInformation request,
        io.grpc.stub.StreamObserver<
                com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSaveDischargingInfoMachineryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Case 5, reason for delay
     * </pre>
     */
    public void saveDischargingInfoDelays(
        com.cpdss.common.generated.discharge_plan.DischargeInformation request,
        io.grpc.stub.StreamObserver<
                com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSaveDischargingInfoDelaysMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Case 6, Stages and track status
     * </pre>
     */
    public void saveDischargingInfoStages(
        com.cpdss.common.generated.discharge_plan.DischargeInformation request,
        io.grpc.stub.StreamObserver<
                com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSaveDischargingInfoStagesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Case 7, Cow plan
     * </pre>
     */
    public void saveCowPlan(
        com.cpdss.common.generated.discharge_plan.DischargeInformation request,
        io.grpc.stub.StreamObserver<
                com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSaveCowPlanMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Case 7, post discharge stage
     * </pre>
     */
    public void savePostDischargeStage(
        com.cpdss.common.generated.discharge_plan.DischargeInformation request,
        io.grpc.stub.StreamObserver<
                com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSavePostDischargeStageMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Case 10, Cargo to be discharged
     * </pre>
     */
    public void saveCargoToBeDischarged(
        com.cpdss.common.generated.discharge_plan.DischargeInformation request,
        io.grpc.stub.StreamObserver<
                com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSaveCargoToBeDischargedMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void getCargoToBeDischarged(
        com.cpdss.common.generated.discharge_plan.DischargeInformation request,
        io.grpc.stub.StreamObserver<com.cpdss.common.generated.discharge_plan.DischargeInformation>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCargoToBeDischargedMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void getOrSaveRulesForDischargingPlan(
        com.cpdss.common.generated.discharge_plan.DischargeRuleRequest request,
        io.grpc.stub.StreamObserver<com.cpdss.common.generated.discharge_plan.DischargeRuleReply>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetOrSaveRulesForDischargingPlanMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void getPortDischargingPlanRobDetails(
        com.cpdss.common.generated.discharge_plan.PortDischargingPlanRobDetailsRequest request,
        io.grpc.stub.StreamObserver<
                com.cpdss.common.generated.discharge_plan.PortDischargingPlanRobDetailsReply>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPortDischargingPlanRobDetailsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /** */
  public static final class DischargeInformationServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<DischargeInformationServiceBlockingStub> {
    private DischargeInformationServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DischargeInformationServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DischargeInformationServiceBlockingStub(channel, callOptions);
    }

    /** */
    public com.cpdss.common.generated.discharge_plan.DischargeInformation getDischargeInformation(
        com.cpdss.common.generated.discharge_plan.DischargeInformationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDischargeInformationMethod(), getCallOptions(), request);
    }

    /** */
    public com.cpdss.common.generated.discharge_plan.DischargeRuleReply
        getOrSaveRulesForDischarging(
            com.cpdss.common.generated.discharge_plan.DischargeRuleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetOrSaveRulesForDischargingMethod(), getCallOptions(), request);
    }

    /** */
    public com.cpdss.common.generated.discharge_plan.DischargingUploadTideDetailStatusReply
        dischargingUploadPortTideDetails(
            com.cpdss.common.generated.discharge_plan.DischargingUploadTideDetailRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDischargingUploadPortTideDetailsMethod(), getCallOptions(), request);
    }

    /** */
    public java.util.Iterator<
            com.cpdss.common.generated.discharge_plan.DischargingDownloadTideDetailStatusReply>
        dischargingDownloadPortTideDetails(
            com.cpdss.common.generated.discharge_plan.DischargingDownloadTideDetailRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getDischargingDownloadPortTideDetailsMethod(), getCallOptions(), request);
    }

    /** */
    public com.cpdss.common.generated.discharge_plan.DischargingPlanReply getDischargingPlan(
        com.cpdss.common.generated.discharge_plan.DischargeInformationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDischargingPlanMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Case 1, Discharging Details
     * </pre>
     */
    public com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse
        saveDischargingInformation(
            com.cpdss.common.generated.discharge_plan.DischargeInformation request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSaveDischargingInformationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Case 2, Only Discharging Rate data
     * </pre>
     */
    public com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse
        saveDischargingInfoRates(
            com.cpdss.common.generated.discharge_plan.DischargeInformation request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSaveDischargingInfoRatesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Case 3, Adding Or Removing Berth Data
     * </pre>
     */
    public com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse
        saveDischargingInfoBerths(
            com.cpdss.common.generated.discharge_plan.DischargeInformation request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSaveDischargingInfoBerthsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Case 4, Machines in Use data
     * </pre>
     */
    public com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse
        saveDischargingInfoMachinery(
            com.cpdss.common.generated.discharge_plan.DischargeInformation request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSaveDischargingInfoMachineryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Case 5, reason for delay
     * </pre>
     */
    public com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse
        saveDischargingInfoDelays(
            com.cpdss.common.generated.discharge_plan.DischargeInformation request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSaveDischargingInfoDelaysMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Case 6, Stages and track status
     * </pre>
     */
    public com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse
        saveDischargingInfoStages(
            com.cpdss.common.generated.discharge_plan.DischargeInformation request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSaveDischargingInfoStagesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Case 7, Cow plan
     * </pre>
     */
    public com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse saveCowPlan(
        com.cpdss.common.generated.discharge_plan.DischargeInformation request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSaveCowPlanMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Case 7, post discharge stage
     * </pre>
     */
    public com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse
        savePostDischargeStage(
            com.cpdss.common.generated.discharge_plan.DischargeInformation request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSavePostDischargeStageMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Case 10, Cargo to be discharged
     * </pre>
     */
    public com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse
        saveCargoToBeDischarged(
            com.cpdss.common.generated.discharge_plan.DischargeInformation request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSaveCargoToBeDischargedMethod(), getCallOptions(), request);
    }

    /** */
    public com.cpdss.common.generated.discharge_plan.DischargeInformation getCargoToBeDischarged(
        com.cpdss.common.generated.discharge_plan.DischargeInformation request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCargoToBeDischargedMethod(), getCallOptions(), request);
    }

    /** */
    public com.cpdss.common.generated.discharge_plan.DischargeRuleReply
        getOrSaveRulesForDischargingPlan(
            com.cpdss.common.generated.discharge_plan.DischargeRuleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetOrSaveRulesForDischargingPlanMethod(), getCallOptions(), request);
    }

    /** */
    public com.cpdss.common.generated.discharge_plan.PortDischargingPlanRobDetailsReply
        getPortDischargingPlanRobDetails(
            com.cpdss.common.generated.discharge_plan.PortDischargingPlanRobDetailsRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPortDischargingPlanRobDetailsMethod(), getCallOptions(), request);
    }
  }

  /** */
  public static final class DischargeInformationServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<DischargeInformationServiceFutureStub> {
    private DischargeInformationServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DischargeInformationServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DischargeInformationServiceFutureStub(channel, callOptions);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            com.cpdss.common.generated.discharge_plan.DischargeInformation>
        getDischargeInformation(
            com.cpdss.common.generated.discharge_plan.DischargeInformationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDischargeInformationMethod(), getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            com.cpdss.common.generated.discharge_plan.DischargeRuleReply>
        getOrSaveRulesForDischarging(
            com.cpdss.common.generated.discharge_plan.DischargeRuleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetOrSaveRulesForDischargingMethod(), getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            com.cpdss.common.generated.discharge_plan.DischargingUploadTideDetailStatusReply>
        dischargingUploadPortTideDetails(
            com.cpdss.common.generated.discharge_plan.DischargingUploadTideDetailRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDischargingUploadPortTideDetailsMethod(), getCallOptions()),
          request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            com.cpdss.common.generated.discharge_plan.DischargingPlanReply>
        getDischargingPlan(
            com.cpdss.common.generated.discharge_plan.DischargeInformationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDischargingPlanMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Case 1, Discharging Details
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>
        saveDischargingInformation(
            com.cpdss.common.generated.discharge_plan.DischargeInformation request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSaveDischargingInformationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Case 2, Only Discharging Rate data
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>
        saveDischargingInfoRates(
            com.cpdss.common.generated.discharge_plan.DischargeInformation request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSaveDischargingInfoRatesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Case 3, Adding Or Removing Berth Data
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>
        saveDischargingInfoBerths(
            com.cpdss.common.generated.discharge_plan.DischargeInformation request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSaveDischargingInfoBerthsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Case 4, Machines in Use data
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>
        saveDischargingInfoMachinery(
            com.cpdss.common.generated.discharge_plan.DischargeInformation request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSaveDischargingInfoMachineryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Case 5, reason for delay
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>
        saveDischargingInfoDelays(
            com.cpdss.common.generated.discharge_plan.DischargeInformation request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSaveDischargingInfoDelaysMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Case 6, Stages and track status
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>
        saveDischargingInfoStages(
            com.cpdss.common.generated.discharge_plan.DischargeInformation request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSaveDischargingInfoStagesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Case 7, Cow plan
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>
        saveCowPlan(com.cpdss.common.generated.discharge_plan.DischargeInformation request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSaveCowPlanMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Case 7, post discharge stage
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>
        savePostDischargeStage(
            com.cpdss.common.generated.discharge_plan.DischargeInformation request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSavePostDischargeStageMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Case 10, Cargo to be discharged
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>
        saveCargoToBeDischarged(
            com.cpdss.common.generated.discharge_plan.DischargeInformation request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSaveCargoToBeDischargedMethod(), getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            com.cpdss.common.generated.discharge_plan.DischargeInformation>
        getCargoToBeDischarged(
            com.cpdss.common.generated.discharge_plan.DischargeInformation request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCargoToBeDischargedMethod(), getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            com.cpdss.common.generated.discharge_plan.DischargeRuleReply>
        getOrSaveRulesForDischargingPlan(
            com.cpdss.common.generated.discharge_plan.DischargeRuleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetOrSaveRulesForDischargingPlanMethod(), getCallOptions()),
          request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            com.cpdss.common.generated.discharge_plan.PortDischargingPlanRobDetailsReply>
        getPortDischargingPlanRobDetails(
            com.cpdss.common.generated.discharge_plan.PortDischargingPlanRobDetailsRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPortDischargingPlanRobDetailsMethod(), getCallOptions()),
          request);
    }
  }

  private static final int METHODID_GET_DISCHARGE_INFORMATION = 0;
  private static final int METHODID_GET_OR_SAVE_RULES_FOR_DISCHARGING = 1;
  private static final int METHODID_DISCHARGING_UPLOAD_PORT_TIDE_DETAILS = 2;
  private static final int METHODID_DISCHARGING_DOWNLOAD_PORT_TIDE_DETAILS = 3;
  private static final int METHODID_GET_DISCHARGING_PLAN = 4;
  private static final int METHODID_SAVE_DISCHARGING_INFORMATION = 5;
  private static final int METHODID_SAVE_DISCHARGING_INFO_RATES = 6;
  private static final int METHODID_SAVE_DISCHARGING_INFO_BERTHS = 7;
  private static final int METHODID_SAVE_DISCHARGING_INFO_MACHINERY = 8;
  private static final int METHODID_SAVE_DISCHARGING_INFO_DELAYS = 9;
  private static final int METHODID_SAVE_DISCHARGING_INFO_STAGES = 10;
  private static final int METHODID_SAVE_COW_PLAN = 11;
  private static final int METHODID_SAVE_POST_DISCHARGE_STAGE = 12;
  private static final int METHODID_SAVE_CARGO_TO_BE_DISCHARGED = 13;
  private static final int METHODID_GET_CARGO_TO_BE_DISCHARGED = 14;
  private static final int METHODID_GET_OR_SAVE_RULES_FOR_DISCHARGING_PLAN = 15;
  private static final int METHODID_GET_PORT_DISCHARGING_PLAN_ROB_DETAILS = 16;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DischargeInformationServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DischargeInformationServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_DISCHARGE_INFORMATION:
          serviceImpl.getDischargeInformation(
              (com.cpdss.common.generated.discharge_plan.DischargeInformationRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.cpdss.common.generated.discharge_plan.DischargeInformation>)
                  responseObserver);
          break;
        case METHODID_GET_OR_SAVE_RULES_FOR_DISCHARGING:
          serviceImpl.getOrSaveRulesForDischarging(
              (com.cpdss.common.generated.discharge_plan.DischargeRuleRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.cpdss.common.generated.discharge_plan.DischargeRuleReply>)
                  responseObserver);
          break;
        case METHODID_DISCHARGING_UPLOAD_PORT_TIDE_DETAILS:
          serviceImpl.dischargingUploadPortTideDetails(
              (com.cpdss.common.generated.discharge_plan.DischargingUploadTideDetailRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.cpdss.common.generated.discharge_plan
                          .DischargingUploadTideDetailStatusReply>)
                  responseObserver);
          break;
        case METHODID_DISCHARGING_DOWNLOAD_PORT_TIDE_DETAILS:
          serviceImpl.dischargingDownloadPortTideDetails(
              (com.cpdss.common.generated.discharge_plan.DischargingDownloadTideDetailRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.cpdss.common.generated.discharge_plan
                          .DischargingDownloadTideDetailStatusReply>)
                  responseObserver);
          break;
        case METHODID_GET_DISCHARGING_PLAN:
          serviceImpl.getDischargingPlan(
              (com.cpdss.common.generated.discharge_plan.DischargeInformationRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.cpdss.common.generated.discharge_plan.DischargingPlanReply>)
                  responseObserver);
          break;
        case METHODID_SAVE_DISCHARGING_INFORMATION:
          serviceImpl.saveDischargingInformation(
              (com.cpdss.common.generated.discharge_plan.DischargeInformation) request,
              (io.grpc.stub.StreamObserver<
                      com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>)
                  responseObserver);
          break;
        case METHODID_SAVE_DISCHARGING_INFO_RATES:
          serviceImpl.saveDischargingInfoRates(
              (com.cpdss.common.generated.discharge_plan.DischargeInformation) request,
              (io.grpc.stub.StreamObserver<
                      com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>)
                  responseObserver);
          break;
        case METHODID_SAVE_DISCHARGING_INFO_BERTHS:
          serviceImpl.saveDischargingInfoBerths(
              (com.cpdss.common.generated.discharge_plan.DischargeInformation) request,
              (io.grpc.stub.StreamObserver<
                      com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>)
                  responseObserver);
          break;
        case METHODID_SAVE_DISCHARGING_INFO_MACHINERY:
          serviceImpl.saveDischargingInfoMachinery(
              (com.cpdss.common.generated.discharge_plan.DischargeInformation) request,
              (io.grpc.stub.StreamObserver<
                      com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>)
                  responseObserver);
          break;
        case METHODID_SAVE_DISCHARGING_INFO_DELAYS:
          serviceImpl.saveDischargingInfoDelays(
              (com.cpdss.common.generated.discharge_plan.DischargeInformation) request,
              (io.grpc.stub.StreamObserver<
                      com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>)
                  responseObserver);
          break;
        case METHODID_SAVE_DISCHARGING_INFO_STAGES:
          serviceImpl.saveDischargingInfoStages(
              (com.cpdss.common.generated.discharge_plan.DischargeInformation) request,
              (io.grpc.stub.StreamObserver<
                      com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>)
                  responseObserver);
          break;
        case METHODID_SAVE_COW_PLAN:
          serviceImpl.saveCowPlan(
              (com.cpdss.common.generated.discharge_plan.DischargeInformation) request,
              (io.grpc.stub.StreamObserver<
                      com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>)
                  responseObserver);
          break;
        case METHODID_SAVE_POST_DISCHARGE_STAGE:
          serviceImpl.savePostDischargeStage(
              (com.cpdss.common.generated.discharge_plan.DischargeInformation) request,
              (io.grpc.stub.StreamObserver<
                      com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>)
                  responseObserver);
          break;
        case METHODID_SAVE_CARGO_TO_BE_DISCHARGED:
          serviceImpl.saveCargoToBeDischarged(
              (com.cpdss.common.generated.discharge_plan.DischargeInformation) request,
              (io.grpc.stub.StreamObserver<
                      com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse>)
                  responseObserver);
          break;
        case METHODID_GET_CARGO_TO_BE_DISCHARGED:
          serviceImpl.getCargoToBeDischarged(
              (com.cpdss.common.generated.discharge_plan.DischargeInformation) request,
              (io.grpc.stub.StreamObserver<
                      com.cpdss.common.generated.discharge_plan.DischargeInformation>)
                  responseObserver);
          break;
        case METHODID_GET_OR_SAVE_RULES_FOR_DISCHARGING_PLAN:
          serviceImpl.getOrSaveRulesForDischargingPlan(
              (com.cpdss.common.generated.discharge_plan.DischargeRuleRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.cpdss.common.generated.discharge_plan.DischargeRuleReply>)
                  responseObserver);
          break;
        case METHODID_GET_PORT_DISCHARGING_PLAN_ROB_DETAILS:
          serviceImpl.getPortDischargingPlanRobDetails(
              (com.cpdss.common.generated.discharge_plan.PortDischargingPlanRobDetailsRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.cpdss.common.generated.discharge_plan.PortDischargingPlanRobDetailsReply>)
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

  private abstract static class DischargeInformationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DischargeInformationServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.cpdss.common.generated.discharge_plan.DischargePlanServiceOuterClass
          .getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DischargeInformationService");
    }
  }

  private static final class DischargeInformationServiceFileDescriptorSupplier
      extends DischargeInformationServiceBaseDescriptorSupplier {
    DischargeInformationServiceFileDescriptorSupplier() {}
  }

  private static final class DischargeInformationServiceMethodDescriptorSupplier
      extends DischargeInformationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DischargeInformationServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (DischargeInformationServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new DischargeInformationServiceFileDescriptorSupplier())
                      .addMethod(getGetDischargeInformationMethod())
                      .addMethod(getGetOrSaveRulesForDischargingMethod())
                      .addMethod(getDischargingUploadPortTideDetailsMethod())
                      .addMethod(getDischargingDownloadPortTideDetailsMethod())
                      .addMethod(getGetDischargingPlanMethod())
                      .addMethod(getSaveDischargingInformationMethod())
                      .addMethod(getSaveDischargingInfoRatesMethod())
                      .addMethod(getSaveDischargingInfoBerthsMethod())
                      .addMethod(getSaveDischargingInfoMachineryMethod())
                      .addMethod(getSaveDischargingInfoDelaysMethod())
                      .addMethod(getSaveDischargingInfoStagesMethod())
                      .addMethod(getSaveCowPlanMethod())
                      .addMethod(getSavePostDischargeStageMethod())
                      .addMethod(getSaveCargoToBeDischargedMethod())
                      .addMethod(getGetCargoToBeDischargedMethod())
                      .addMethod(getGetOrSaveRulesForDischargingPlanMethod())
                      .addMethod(getGetPortDischargingPlanRobDetailsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
