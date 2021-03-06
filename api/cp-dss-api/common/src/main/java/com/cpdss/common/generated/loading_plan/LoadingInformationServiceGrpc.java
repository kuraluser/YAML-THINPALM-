/* Licensed at AlphaOri Technologies */
package com.cpdss.common.generated.loading_plan;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/** */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.40.1)",
    comments = "Source: loading_plan/loading_plan_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class LoadingInformationServiceGrpc {

  private LoadingInformationServiceGrpc() {}

  public static final String SERVICE_NAME = "LoadingInformationService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformationRequest,
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation>
      getGetLoadingInformationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetLoadingInformation",
      requestType =
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformationRequest.class,
      responseType =
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformationRequest,
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation>
      getGetLoadingInformationMethod() {
    io.grpc.MethodDescriptor<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformationRequest,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation>
        getGetLoadingInformationMethod;
    if ((getGetLoadingInformationMethod =
            LoadingInformationServiceGrpc.getGetLoadingInformationMethod)
        == null) {
      synchronized (LoadingInformationServiceGrpc.class) {
        if ((getGetLoadingInformationMethod =
                LoadingInformationServiceGrpc.getGetLoadingInformationMethod)
            == null) {
          LoadingInformationServiceGrpc.getGetLoadingInformationMethod =
              getGetLoadingInformationMethod =
                  io.grpc.MethodDescriptor
                      .<com.cpdss.common.generated.loading_plan.LoadingPlanModels
                              .LoadingInformationRequest,
                          com.cpdss.common.generated.loading_plan.LoadingPlanModels
                              .LoadingInformation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetLoadingInformation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.loading_plan.LoadingPlanModels
                                  .LoadingInformationRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.loading_plan.LoadingPlanModels
                                  .LoadingInformation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LoadingInformationServiceMethodDescriptorSupplier(
                              "GetLoadingInformation"))
                      .build();
        }
      }
    }
    return getGetLoadingInformationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation,
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoSaveResponse>
      getSaveLoadingInformationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SaveLoadingInformation",
      requestType =
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation.class,
      responseType =
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoSaveResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation,
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoSaveResponse>
      getSaveLoadingInformationMethod() {
    io.grpc.MethodDescriptor<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoSaveResponse>
        getSaveLoadingInformationMethod;
    if ((getSaveLoadingInformationMethod =
            LoadingInformationServiceGrpc.getSaveLoadingInformationMethod)
        == null) {
      synchronized (LoadingInformationServiceGrpc.class) {
        if ((getSaveLoadingInformationMethod =
                LoadingInformationServiceGrpc.getSaveLoadingInformationMethod)
            == null) {
          LoadingInformationServiceGrpc.getSaveLoadingInformationMethod =
              getSaveLoadingInformationMethod =
                  io.grpc.MethodDescriptor
                      .<com.cpdss.common.generated.loading_plan.LoadingPlanModels
                              .LoadingInformation,
                          com.cpdss.common.generated.loading_plan.LoadingPlanModels
                              .LoadingInfoSaveResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "SaveLoadingInformation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.loading_plan.LoadingPlanModels
                                  .LoadingInformation.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.loading_plan.LoadingPlanModels
                                  .LoadingInfoSaveResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LoadingInformationServiceMethodDescriptorSupplier(
                              "SaveLoadingInformation"))
                      .build();
        }
      }
    }
    return getSaveLoadingInformationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation,
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoSaveResponse>
      getSaveLoadingInfoRatesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SaveLoadingInfoRates",
      requestType =
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation.class,
      responseType =
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoSaveResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation,
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoSaveResponse>
      getSaveLoadingInfoRatesMethod() {
    io.grpc.MethodDescriptor<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoSaveResponse>
        getSaveLoadingInfoRatesMethod;
    if ((getSaveLoadingInfoRatesMethod =
            LoadingInformationServiceGrpc.getSaveLoadingInfoRatesMethod)
        == null) {
      synchronized (LoadingInformationServiceGrpc.class) {
        if ((getSaveLoadingInfoRatesMethod =
                LoadingInformationServiceGrpc.getSaveLoadingInfoRatesMethod)
            == null) {
          LoadingInformationServiceGrpc.getSaveLoadingInfoRatesMethod =
              getSaveLoadingInfoRatesMethod =
                  io.grpc.MethodDescriptor
                      .<com.cpdss.common.generated.loading_plan.LoadingPlanModels
                              .LoadingInformation,
                          com.cpdss.common.generated.loading_plan.LoadingPlanModels
                              .LoadingInfoSaveResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "SaveLoadingInfoRates"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.loading_plan.LoadingPlanModels
                                  .LoadingInformation.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.loading_plan.LoadingPlanModels
                                  .LoadingInfoSaveResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LoadingInformationServiceMethodDescriptorSupplier(
                              "SaveLoadingInfoRates"))
                      .build();
        }
      }
    }
    return getSaveLoadingInfoRatesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation,
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoSaveResponse>
      getSaveLoadingInfoBerthsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SaveLoadingInfoBerths",
      requestType =
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation.class,
      responseType =
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoSaveResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation,
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoSaveResponse>
      getSaveLoadingInfoBerthsMethod() {
    io.grpc.MethodDescriptor<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoSaveResponse>
        getSaveLoadingInfoBerthsMethod;
    if ((getSaveLoadingInfoBerthsMethod =
            LoadingInformationServiceGrpc.getSaveLoadingInfoBerthsMethod)
        == null) {
      synchronized (LoadingInformationServiceGrpc.class) {
        if ((getSaveLoadingInfoBerthsMethod =
                LoadingInformationServiceGrpc.getSaveLoadingInfoBerthsMethod)
            == null) {
          LoadingInformationServiceGrpc.getSaveLoadingInfoBerthsMethod =
              getSaveLoadingInfoBerthsMethod =
                  io.grpc.MethodDescriptor
                      .<com.cpdss.common.generated.loading_plan.LoadingPlanModels
                              .LoadingInformation,
                          com.cpdss.common.generated.loading_plan.LoadingPlanModels
                              .LoadingInfoSaveResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "SaveLoadingInfoBerths"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.loading_plan.LoadingPlanModels
                                  .LoadingInformation.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.loading_plan.LoadingPlanModels
                                  .LoadingInfoSaveResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LoadingInformationServiceMethodDescriptorSupplier(
                              "SaveLoadingInfoBerths"))
                      .build();
        }
      }
    }
    return getSaveLoadingInfoBerthsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation,
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoSaveResponse>
      getSaveLoadingInfoMachineryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SaveLoadingInfoMachinery",
      requestType =
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation.class,
      responseType =
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoSaveResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation,
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoSaveResponse>
      getSaveLoadingInfoMachineryMethod() {
    io.grpc.MethodDescriptor<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoSaveResponse>
        getSaveLoadingInfoMachineryMethod;
    if ((getSaveLoadingInfoMachineryMethod =
            LoadingInformationServiceGrpc.getSaveLoadingInfoMachineryMethod)
        == null) {
      synchronized (LoadingInformationServiceGrpc.class) {
        if ((getSaveLoadingInfoMachineryMethod =
                LoadingInformationServiceGrpc.getSaveLoadingInfoMachineryMethod)
            == null) {
          LoadingInformationServiceGrpc.getSaveLoadingInfoMachineryMethod =
              getSaveLoadingInfoMachineryMethod =
                  io.grpc.MethodDescriptor
                      .<com.cpdss.common.generated.loading_plan.LoadingPlanModels
                              .LoadingInformation,
                          com.cpdss.common.generated.loading_plan.LoadingPlanModels
                              .LoadingInfoSaveResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "SaveLoadingInfoMachinery"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.loading_plan.LoadingPlanModels
                                  .LoadingInformation.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.loading_plan.LoadingPlanModels
                                  .LoadingInfoSaveResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LoadingInformationServiceMethodDescriptorSupplier(
                              "SaveLoadingInfoMachinery"))
                      .build();
        }
      }
    }
    return getSaveLoadingInfoMachineryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation,
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoSaveResponse>
      getSaveLoadingInfoDelaysMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SaveLoadingInfoDelays",
      requestType =
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation.class,
      responseType =
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoSaveResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation,
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoSaveResponse>
      getSaveLoadingInfoDelaysMethod() {
    io.grpc.MethodDescriptor<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoSaveResponse>
        getSaveLoadingInfoDelaysMethod;
    if ((getSaveLoadingInfoDelaysMethod =
            LoadingInformationServiceGrpc.getSaveLoadingInfoDelaysMethod)
        == null) {
      synchronized (LoadingInformationServiceGrpc.class) {
        if ((getSaveLoadingInfoDelaysMethod =
                LoadingInformationServiceGrpc.getSaveLoadingInfoDelaysMethod)
            == null) {
          LoadingInformationServiceGrpc.getSaveLoadingInfoDelaysMethod =
              getSaveLoadingInfoDelaysMethod =
                  io.grpc.MethodDescriptor
                      .<com.cpdss.common.generated.loading_plan.LoadingPlanModels
                              .LoadingInformation,
                          com.cpdss.common.generated.loading_plan.LoadingPlanModels
                              .LoadingInfoSaveResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "SaveLoadingInfoDelays"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.loading_plan.LoadingPlanModels
                                  .LoadingInformation.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.loading_plan.LoadingPlanModels
                                  .LoadingInfoSaveResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LoadingInformationServiceMethodDescriptorSupplier(
                              "SaveLoadingInfoDelays"))
                      .build();
        }
      }
    }
    return getSaveLoadingInfoDelaysMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation,
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoSaveResponse>
      getSaveLoadingInfoStagesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SaveLoadingInfoStages",
      requestType =
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation.class,
      responseType =
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoSaveResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation,
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoSaveResponse>
      getSaveLoadingInfoStagesMethod() {
    io.grpc.MethodDescriptor<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoSaveResponse>
        getSaveLoadingInfoStagesMethod;
    if ((getSaveLoadingInfoStagesMethod =
            LoadingInformationServiceGrpc.getSaveLoadingInfoStagesMethod)
        == null) {
      synchronized (LoadingInformationServiceGrpc.class) {
        if ((getSaveLoadingInfoStagesMethod =
                LoadingInformationServiceGrpc.getSaveLoadingInfoStagesMethod)
            == null) {
          LoadingInformationServiceGrpc.getSaveLoadingInfoStagesMethod =
              getSaveLoadingInfoStagesMethod =
                  io.grpc.MethodDescriptor
                      .<com.cpdss.common.generated.loading_plan.LoadingPlanModels
                              .LoadingInformation,
                          com.cpdss.common.generated.loading_plan.LoadingPlanModels
                              .LoadingInfoSaveResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "SaveLoadingInfoStages"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.loading_plan.LoadingPlanModels
                                  .LoadingInformation.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.loading_plan.LoadingPlanModels
                                  .LoadingInfoSaveResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LoadingInformationServiceMethodDescriptorSupplier(
                              "SaveLoadingInfoStages"))
                      .build();
        }
      }
    }
    return getSaveLoadingInfoStagesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels
              .LoadingInformationSynopticalRequest,
          com.cpdss.common.generated.LoadableStudy.LoadingInformationSynopticalReply>
      getGetLoadigInformationByVoyageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetLoadigInformationByVoyage",
      requestType =
          com.cpdss.common.generated.loading_plan.LoadingPlanModels
              .LoadingInformationSynopticalRequest.class,
      responseType =
          com.cpdss.common.generated.LoadableStudy.LoadingInformationSynopticalReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels
              .LoadingInformationSynopticalRequest,
          com.cpdss.common.generated.LoadableStudy.LoadingInformationSynopticalReply>
      getGetLoadigInformationByVoyageMethod() {
    io.grpc.MethodDescriptor<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels
                .LoadingInformationSynopticalRequest,
            com.cpdss.common.generated.LoadableStudy.LoadingInformationSynopticalReply>
        getGetLoadigInformationByVoyageMethod;
    if ((getGetLoadigInformationByVoyageMethod =
            LoadingInformationServiceGrpc.getGetLoadigInformationByVoyageMethod)
        == null) {
      synchronized (LoadingInformationServiceGrpc.class) {
        if ((getGetLoadigInformationByVoyageMethod =
                LoadingInformationServiceGrpc.getGetLoadigInformationByVoyageMethod)
            == null) {
          LoadingInformationServiceGrpc.getGetLoadigInformationByVoyageMethod =
              getGetLoadigInformationByVoyageMethod =
                  io.grpc.MethodDescriptor
                      .<com.cpdss.common.generated.loading_plan.LoadingPlanModels
                              .LoadingInformationSynopticalRequest,
                          com.cpdss.common.generated.LoadableStudy
                              .LoadingInformationSynopticalReply>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetLoadigInformationByVoyage"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.loading_plan.LoadingPlanModels
                                  .LoadingInformationSynopticalRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.LoadableStudy
                                  .LoadingInformationSynopticalReply.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LoadingInformationServiceMethodDescriptorSupplier(
                              "GetLoadigInformationByVoyage"))
                      .build();
        }
      }
    }
    return getGetLoadigInformationByVoyageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.UpdateUllageLoadingRequest,
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.UpdateUllageLoadingReplay>
      getUpdateUllageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateUllage",
      requestType =
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.UpdateUllageLoadingRequest
              .class,
      responseType =
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.UpdateUllageLoadingReplay.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.UpdateUllageLoadingRequest,
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.UpdateUllageLoadingReplay>
      getUpdateUllageMethod() {
    io.grpc.MethodDescriptor<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.UpdateUllageLoadingRequest,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.UpdateUllageLoadingReplay>
        getUpdateUllageMethod;
    if ((getUpdateUllageMethod = LoadingInformationServiceGrpc.getUpdateUllageMethod) == null) {
      synchronized (LoadingInformationServiceGrpc.class) {
        if ((getUpdateUllageMethod = LoadingInformationServiceGrpc.getUpdateUllageMethod) == null) {
          LoadingInformationServiceGrpc.getUpdateUllageMethod =
              getUpdateUllageMethod =
                  io.grpc.MethodDescriptor
                      .<com.cpdss.common.generated.loading_plan.LoadingPlanModels
                              .UpdateUllageLoadingRequest,
                          com.cpdss.common.generated.loading_plan.LoadingPlanModels
                              .UpdateUllageLoadingReplay>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateUllage"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.loading_plan.LoadingPlanModels
                                  .UpdateUllageLoadingRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.loading_plan.LoadingPlanModels
                                  .UpdateUllageLoadingReplay.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LoadingInformationServiceMethodDescriptorSupplier("UpdateUllage"))
                      .build();
        }
      }
    }
    return getUpdateUllageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.cpdss.common.generated.LoadableStudy.AlgoStatusRequest,
          com.cpdss.common.generated.LoadableStudy.AlgoStatusReply>
      getSaveAlgoLoadingPlanStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SaveAlgoLoadingPlanStatus",
      requestType = com.cpdss.common.generated.LoadableStudy.AlgoStatusRequest.class,
      responseType = com.cpdss.common.generated.LoadableStudy.AlgoStatusReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.cpdss.common.generated.LoadableStudy.AlgoStatusRequest,
          com.cpdss.common.generated.LoadableStudy.AlgoStatusReply>
      getSaveAlgoLoadingPlanStatusMethod() {
    io.grpc.MethodDescriptor<
            com.cpdss.common.generated.LoadableStudy.AlgoStatusRequest,
            com.cpdss.common.generated.LoadableStudy.AlgoStatusReply>
        getSaveAlgoLoadingPlanStatusMethod;
    if ((getSaveAlgoLoadingPlanStatusMethod =
            LoadingInformationServiceGrpc.getSaveAlgoLoadingPlanStatusMethod)
        == null) {
      synchronized (LoadingInformationServiceGrpc.class) {
        if ((getSaveAlgoLoadingPlanStatusMethod =
                LoadingInformationServiceGrpc.getSaveAlgoLoadingPlanStatusMethod)
            == null) {
          LoadingInformationServiceGrpc.getSaveAlgoLoadingPlanStatusMethod =
              getSaveAlgoLoadingPlanStatusMethod =
                  io.grpc.MethodDescriptor
                      .<com.cpdss.common.generated.LoadableStudy.AlgoStatusRequest,
                          com.cpdss.common.generated.LoadableStudy.AlgoStatusReply>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "SaveAlgoLoadingPlanStatus"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.LoadableStudy.AlgoStatusRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.LoadableStudy.AlgoStatusReply
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LoadingInformationServiceMethodDescriptorSupplier(
                              "SaveAlgoLoadingPlanStatus"))
                      .build();
        }
      }
    }
    return getSaveAlgoLoadingPlanStatusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoAlgoRequest,
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoAlgoReply>
      getGenerateLoadingPlanMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateLoadingPlan",
      requestType =
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoAlgoRequest.class,
      responseType =
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoAlgoReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoAlgoRequest,
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoAlgoReply>
      getGenerateLoadingPlanMethod() {
    io.grpc.MethodDescriptor<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoAlgoRequest,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoAlgoReply>
        getGenerateLoadingPlanMethod;
    if ((getGenerateLoadingPlanMethod = LoadingInformationServiceGrpc.getGenerateLoadingPlanMethod)
        == null) {
      synchronized (LoadingInformationServiceGrpc.class) {
        if ((getGenerateLoadingPlanMethod =
                LoadingInformationServiceGrpc.getGenerateLoadingPlanMethod)
            == null) {
          LoadingInformationServiceGrpc.getGenerateLoadingPlanMethod =
              getGenerateLoadingPlanMethod =
                  io.grpc.MethodDescriptor
                      .<com.cpdss.common.generated.loading_plan.LoadingPlanModels
                              .LoadingInfoAlgoRequest,
                          com.cpdss.common.generated.loading_plan.LoadingPlanModels
                              .LoadingInfoAlgoReply>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GenerateLoadingPlan"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.loading_plan.LoadingPlanModels
                                  .LoadingInfoAlgoRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.loading_plan.LoadingPlanModels
                                  .LoadingInfoAlgoReply.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LoadingInformationServiceMethodDescriptorSupplier(
                              "GenerateLoadingPlan"))
                      .build();
        }
      }
    }
    return getGenerateLoadingPlanMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoStatusRequest,
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoStatusReply>
      getGetLoadingInfoAlgoStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetLoadingInfoAlgoStatus",
      requestType =
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoStatusRequest.class,
      responseType =
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoStatusReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoStatusRequest,
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoStatusReply>
      getGetLoadingInfoAlgoStatusMethod() {
    io.grpc.MethodDescriptor<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoStatusRequest,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoStatusReply>
        getGetLoadingInfoAlgoStatusMethod;
    if ((getGetLoadingInfoAlgoStatusMethod =
            LoadingInformationServiceGrpc.getGetLoadingInfoAlgoStatusMethod)
        == null) {
      synchronized (LoadingInformationServiceGrpc.class) {
        if ((getGetLoadingInfoAlgoStatusMethod =
                LoadingInformationServiceGrpc.getGetLoadingInfoAlgoStatusMethod)
            == null) {
          LoadingInformationServiceGrpc.getGetLoadingInfoAlgoStatusMethod =
              getGetLoadingInfoAlgoStatusMethod =
                  io.grpc.MethodDescriptor
                      .<com.cpdss.common.generated.loading_plan.LoadingPlanModels
                              .LoadingInfoStatusRequest,
                          com.cpdss.common.generated.loading_plan.LoadingPlanModels
                              .LoadingInfoStatusReply>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetLoadingInfoAlgoStatus"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.loading_plan.LoadingPlanModels
                                  .LoadingInfoStatusRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.loading_plan.LoadingPlanModels
                                  .LoadingInfoStatusReply.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LoadingInformationServiceMethodDescriptorSupplier(
                              "GetLoadingInfoAlgoStatus"))
                      .build();
        }
      }
    }
    return getGetLoadingInfoAlgoStatusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.cpdss.common.generated.LoadableStudy.AlgoErrorRequest,
          com.cpdss.common.generated.LoadableStudy.AlgoErrorReply>
      getGetLoadingInfoAlgoErrorsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetLoadingInfoAlgoErrors",
      requestType = com.cpdss.common.generated.LoadableStudy.AlgoErrorRequest.class,
      responseType = com.cpdss.common.generated.LoadableStudy.AlgoErrorReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.cpdss.common.generated.LoadableStudy.AlgoErrorRequest,
          com.cpdss.common.generated.LoadableStudy.AlgoErrorReply>
      getGetLoadingInfoAlgoErrorsMethod() {
    io.grpc.MethodDescriptor<
            com.cpdss.common.generated.LoadableStudy.AlgoErrorRequest,
            com.cpdss.common.generated.LoadableStudy.AlgoErrorReply>
        getGetLoadingInfoAlgoErrorsMethod;
    if ((getGetLoadingInfoAlgoErrorsMethod =
            LoadingInformationServiceGrpc.getGetLoadingInfoAlgoErrorsMethod)
        == null) {
      synchronized (LoadingInformationServiceGrpc.class) {
        if ((getGetLoadingInfoAlgoErrorsMethod =
                LoadingInformationServiceGrpc.getGetLoadingInfoAlgoErrorsMethod)
            == null) {
          LoadingInformationServiceGrpc.getGetLoadingInfoAlgoErrorsMethod =
              getGetLoadingInfoAlgoErrorsMethod =
                  io.grpc.MethodDescriptor
                      .<com.cpdss.common.generated.LoadableStudy.AlgoErrorRequest,
                          com.cpdss.common.generated.LoadableStudy.AlgoErrorReply>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetLoadingInfoAlgoErrors"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.LoadableStudy.AlgoErrorRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.LoadableStudy.AlgoErrorReply
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LoadingInformationServiceMethodDescriptorSupplier(
                              "GetLoadingInfoAlgoErrors"))
                      .build();
        }
      }
    }
    return getGetLoadingInfoAlgoErrorsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.UploadTideDetailRequest,
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.UploadTideDetailStatusReply>
      getUploadPortTideDetailsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UploadPortTideDetails",
      requestType =
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.UploadTideDetailRequest.class,
      responseType =
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.UploadTideDetailStatusReply
              .class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.UploadTideDetailRequest,
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.UploadTideDetailStatusReply>
      getUploadPortTideDetailsMethod() {
    io.grpc.MethodDescriptor<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.UploadTideDetailRequest,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.UploadTideDetailStatusReply>
        getUploadPortTideDetailsMethod;
    if ((getUploadPortTideDetailsMethod =
            LoadingInformationServiceGrpc.getUploadPortTideDetailsMethod)
        == null) {
      synchronized (LoadingInformationServiceGrpc.class) {
        if ((getUploadPortTideDetailsMethod =
                LoadingInformationServiceGrpc.getUploadPortTideDetailsMethod)
            == null) {
          LoadingInformationServiceGrpc.getUploadPortTideDetailsMethod =
              getUploadPortTideDetailsMethod =
                  io.grpc.MethodDescriptor
                      .<com.cpdss.common.generated.loading_plan.LoadingPlanModels
                              .UploadTideDetailRequest,
                          com.cpdss.common.generated.loading_plan.LoadingPlanModels
                              .UploadTideDetailStatusReply>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UploadPortTideDetails"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.loading_plan.LoadingPlanModels
                                  .UploadTideDetailRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.loading_plan.LoadingPlanModels
                                  .UploadTideDetailStatusReply.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LoadingInformationServiceMethodDescriptorSupplier(
                              "UploadPortTideDetails"))
                      .build();
        }
      }
    }
    return getUploadPortTideDetailsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.DownloadTideDetailRequest,
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.DownloadTideDetailStatusReply>
      getDownloadPortTideDetailsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DownloadPortTideDetails",
      requestType =
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.DownloadTideDetailRequest.class,
      responseType =
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.DownloadTideDetailStatusReply
              .class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.DownloadTideDetailRequest,
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.DownloadTideDetailStatusReply>
      getDownloadPortTideDetailsMethod() {
    io.grpc.MethodDescriptor<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.DownloadTideDetailRequest,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.DownloadTideDetailStatusReply>
        getDownloadPortTideDetailsMethod;
    if ((getDownloadPortTideDetailsMethod =
            LoadingInformationServiceGrpc.getDownloadPortTideDetailsMethod)
        == null) {
      synchronized (LoadingInformationServiceGrpc.class) {
        if ((getDownloadPortTideDetailsMethod =
                LoadingInformationServiceGrpc.getDownloadPortTideDetailsMethod)
            == null) {
          LoadingInformationServiceGrpc.getDownloadPortTideDetailsMethod =
              getDownloadPortTideDetailsMethod =
                  io.grpc.MethodDescriptor
                      .<com.cpdss.common.generated.loading_plan.LoadingPlanModels
                              .DownloadTideDetailRequest,
                          com.cpdss.common.generated.loading_plan.LoadingPlanModels
                              .DownloadTideDetailStatusReply>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DownloadPortTideDetails"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.loading_plan.LoadingPlanModels
                                  .DownloadTideDetailRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.loading_plan.LoadingPlanModels
                                  .DownloadTideDetailStatusReply.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LoadingInformationServiceMethodDescriptorSupplier(
                              "DownloadPortTideDetails"))
                      .build();
        }
      }
    }
    return getDownloadPortTideDetailsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation,
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoSaveResponse>
      getSaveCargoToBeLoadedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SaveCargoToBeLoaded",
      requestType =
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation.class,
      responseType =
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoSaveResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation,
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoSaveResponse>
      getSaveCargoToBeLoadedMethod() {
    io.grpc.MethodDescriptor<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoSaveResponse>
        getSaveCargoToBeLoadedMethod;
    if ((getSaveCargoToBeLoadedMethod = LoadingInformationServiceGrpc.getSaveCargoToBeLoadedMethod)
        == null) {
      synchronized (LoadingInformationServiceGrpc.class) {
        if ((getSaveCargoToBeLoadedMethod =
                LoadingInformationServiceGrpc.getSaveCargoToBeLoadedMethod)
            == null) {
          LoadingInformationServiceGrpc.getSaveCargoToBeLoadedMethod =
              getSaveCargoToBeLoadedMethod =
                  io.grpc.MethodDescriptor
                      .<com.cpdss.common.generated.loading_plan.LoadingPlanModels
                              .LoadingInformation,
                          com.cpdss.common.generated.loading_plan.LoadingPlanModels
                              .LoadingInfoSaveResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "SaveCargoToBeLoaded"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.loading_plan.LoadingPlanModels
                                  .LoadingInformation.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.loading_plan.LoadingPlanModels
                                  .LoadingInfoSaveResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LoadingInformationServiceMethodDescriptorSupplier(
                              "SaveCargoToBeLoaded"))
                      .build();
        }
      }
    }
    return getSaveCargoToBeLoadedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation,
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation>
      getGetCargoToBeLoadedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCargoToBeLoaded",
      requestType =
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation.class,
      responseType =
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation,
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation>
      getGetCargoToBeLoadedMethod() {
    io.grpc.MethodDescriptor<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation>
        getGetCargoToBeLoadedMethod;
    if ((getGetCargoToBeLoadedMethod = LoadingInformationServiceGrpc.getGetCargoToBeLoadedMethod)
        == null) {
      synchronized (LoadingInformationServiceGrpc.class) {
        if ((getGetCargoToBeLoadedMethod =
                LoadingInformationServiceGrpc.getGetCargoToBeLoadedMethod)
            == null) {
          LoadingInformationServiceGrpc.getGetCargoToBeLoadedMethod =
              getGetCargoToBeLoadedMethod =
                  io.grpc.MethodDescriptor
                      .<com.cpdss.common.generated.loading_plan.LoadingPlanModels
                              .LoadingInformation,
                          com.cpdss.common.generated.loading_plan.LoadingPlanModels
                              .LoadingInformation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCargoToBeLoaded"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.loading_plan.LoadingPlanModels
                                  .LoadingInformation.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.loading_plan.LoadingPlanModels
                                  .LoadingInformation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LoadingInformationServiceMethodDescriptorSupplier(
                              "GetCargoToBeLoaded"))
                      .build();
        }
      }
    }
    return getGetCargoToBeLoadedMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static LoadingInformationServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LoadingInformationServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<LoadingInformationServiceStub>() {
          @java.lang.Override
          public LoadingInformationServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new LoadingInformationServiceStub(channel, callOptions);
          }
        };
    return LoadingInformationServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LoadingInformationServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LoadingInformationServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<LoadingInformationServiceBlockingStub>() {
          @java.lang.Override
          public LoadingInformationServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new LoadingInformationServiceBlockingStub(channel, callOptions);
          }
        };
    return LoadingInformationServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static LoadingInformationServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LoadingInformationServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<LoadingInformationServiceFutureStub>() {
          @java.lang.Override
          public LoadingInformationServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new LoadingInformationServiceFutureStub(channel, callOptions);
          }
        };
    return LoadingInformationServiceFutureStub.newStub(factory, channel);
  }

  /** */
  public abstract static class LoadingInformationServiceImplBase
      implements io.grpc.BindableService {

    /** */
    public void getLoadingInformation(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformationRequest request,
        io.grpc.stub.StreamObserver<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetLoadingInformationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * refactoring single api to 5 grpc, Reason, please see the gateway Doc for why this split
     * Case 1, Loading Details
     * </pre>
     */
    public void saveLoadingInformation(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation request,
        io.grpc.stub.StreamObserver<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoSaveResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSaveLoadingInformationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Case 2, Only Loading Rate data
     * </pre>
     */
    public void saveLoadingInfoRates(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation request,
        io.grpc.stub.StreamObserver<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoSaveResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSaveLoadingInfoRatesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Case 3, Adding Or Removing Berth Data
     * </pre>
     */
    public void saveLoadingInfoBerths(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation request,
        io.grpc.stub.StreamObserver<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoSaveResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSaveLoadingInfoBerthsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Case 4, Machines in Use data
     * </pre>
     */
    public void saveLoadingInfoMachinery(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation request,
        io.grpc.stub.StreamObserver<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoSaveResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSaveLoadingInfoMachineryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Case 5, reason for delay
     * </pre>
     */
    public void saveLoadingInfoDelays(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation request,
        io.grpc.stub.StreamObserver<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoSaveResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSaveLoadingInfoDelaysMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Case 6, Stages and track status
     * </pre>
     */
    public void saveLoadingInfoStages(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation request,
        io.grpc.stub.StreamObserver<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoSaveResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSaveLoadingInfoStagesMethod(), responseObserver);
    }

    /** */
    public void getLoadigInformationByVoyage(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels
                .LoadingInformationSynopticalRequest
            request,
        io.grpc.stub.StreamObserver<
                com.cpdss.common.generated.LoadableStudy.LoadingInformationSynopticalReply>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetLoadigInformationByVoyageMethod(), responseObserver);
    }

    /** */
    public void updateUllage(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.UpdateUllageLoadingRequest
            request,
        io.grpc.stub.StreamObserver<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.UpdateUllageLoadingReplay>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateUllageMethod(), responseObserver);
    }

    /** */
    public void saveAlgoLoadingPlanStatus(
        com.cpdss.common.generated.LoadableStudy.AlgoStatusRequest request,
        io.grpc.stub.StreamObserver<com.cpdss.common.generated.LoadableStudy.AlgoStatusReply>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSaveAlgoLoadingPlanStatusMethod(), responseObserver);
    }

    /** */
    public void generateLoadingPlan(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoAlgoRequest request,
        io.grpc.stub.StreamObserver<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoAlgoReply>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGenerateLoadingPlanMethod(), responseObserver);
    }

    /** */
    public void getLoadingInfoAlgoStatus(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoStatusRequest request,
        io.grpc.stub.StreamObserver<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoStatusReply>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetLoadingInfoAlgoStatusMethod(), responseObserver);
    }

    /** */
    public void getLoadingInfoAlgoErrors(
        com.cpdss.common.generated.LoadableStudy.AlgoErrorRequest request,
        io.grpc.stub.StreamObserver<com.cpdss.common.generated.LoadableStudy.AlgoErrorReply>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetLoadingInfoAlgoErrorsMethod(), responseObserver);
    }

    /** */
    public void uploadPortTideDetails(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.UploadTideDetailRequest request,
        io.grpc.stub.StreamObserver<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels
                    .UploadTideDetailStatusReply>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUploadPortTideDetailsMethod(), responseObserver);
    }

    /** */
    public void downloadPortTideDetails(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.DownloadTideDetailRequest request,
        io.grpc.stub.StreamObserver<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels
                    .DownloadTideDetailStatusReply>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDownloadPortTideDetailsMethod(), responseObserver);
    }

    /** */
    public void saveCargoToBeLoaded(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation request,
        io.grpc.stub.StreamObserver<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoSaveResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSaveCargoToBeLoadedMethod(), responseObserver);
    }

    /** */
    public void getCargoToBeLoaded(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation request,
        io.grpc.stub.StreamObserver<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetCargoToBeLoadedMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getGetLoadingInformationMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels
                          .LoadingInformationRequest,
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation>(
                      this, METHODID_GET_LOADING_INFORMATION)))
          .addMethod(
              getSaveLoadingInformationMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation,
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels
                          .LoadingInfoSaveResponse>(this, METHODID_SAVE_LOADING_INFORMATION)))
          .addMethod(
              getSaveLoadingInfoRatesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation,
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels
                          .LoadingInfoSaveResponse>(this, METHODID_SAVE_LOADING_INFO_RATES)))
          .addMethod(
              getSaveLoadingInfoBerthsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation,
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels
                          .LoadingInfoSaveResponse>(this, METHODID_SAVE_LOADING_INFO_BERTHS)))
          .addMethod(
              getSaveLoadingInfoMachineryMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation,
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels
                          .LoadingInfoSaveResponse>(this, METHODID_SAVE_LOADING_INFO_MACHINERY)))
          .addMethod(
              getSaveLoadingInfoDelaysMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation,
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels
                          .LoadingInfoSaveResponse>(this, METHODID_SAVE_LOADING_INFO_DELAYS)))
          .addMethod(
              getSaveLoadingInfoStagesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation,
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels
                          .LoadingInfoSaveResponse>(this, METHODID_SAVE_LOADING_INFO_STAGES)))
          .addMethod(
              getGetLoadigInformationByVoyageMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels
                          .LoadingInformationSynopticalRequest,
                      com.cpdss.common.generated.LoadableStudy.LoadingInformationSynopticalReply>(
                      this, METHODID_GET_LOADIG_INFORMATION_BY_VOYAGE)))
          .addMethod(
              getUpdateUllageMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels
                          .UpdateUllageLoadingRequest,
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels
                          .UpdateUllageLoadingReplay>(this, METHODID_UPDATE_ULLAGE)))
          .addMethod(
              getSaveAlgoLoadingPlanStatusMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.cpdss.common.generated.LoadableStudy.AlgoStatusRequest,
                      com.cpdss.common.generated.LoadableStudy.AlgoStatusReply>(
                      this, METHODID_SAVE_ALGO_LOADING_PLAN_STATUS)))
          .addMethod(
              getGenerateLoadingPlanMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels
                          .LoadingInfoAlgoRequest,
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels
                          .LoadingInfoAlgoReply>(this, METHODID_GENERATE_LOADING_PLAN)))
          .addMethod(
              getGetLoadingInfoAlgoStatusMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels
                          .LoadingInfoStatusRequest,
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels
                          .LoadingInfoStatusReply>(this, METHODID_GET_LOADING_INFO_ALGO_STATUS)))
          .addMethod(
              getGetLoadingInfoAlgoErrorsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.cpdss.common.generated.LoadableStudy.AlgoErrorRequest,
                      com.cpdss.common.generated.LoadableStudy.AlgoErrorReply>(
                      this, METHODID_GET_LOADING_INFO_ALGO_ERRORS)))
          .addMethod(
              getUploadPortTideDetailsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels
                          .UploadTideDetailRequest,
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels
                          .UploadTideDetailStatusReply>(this, METHODID_UPLOAD_PORT_TIDE_DETAILS)))
          .addMethod(
              getDownloadPortTideDetailsMethod(),
              io.grpc.stub.ServerCalls.asyncServerStreamingCall(
                  new MethodHandlers<
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels
                          .DownloadTideDetailRequest,
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels
                          .DownloadTideDetailStatusReply>(
                      this, METHODID_DOWNLOAD_PORT_TIDE_DETAILS)))
          .addMethod(
              getSaveCargoToBeLoadedMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation,
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels
                          .LoadingInfoSaveResponse>(this, METHODID_SAVE_CARGO_TO_BE_LOADED)))
          .addMethod(
              getGetCargoToBeLoadedMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation,
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation>(
                      this, METHODID_GET_CARGO_TO_BE_LOADED)))
          .build();
    }
  }

  /** */
  public static final class LoadingInformationServiceStub
      extends io.grpc.stub.AbstractAsyncStub<LoadingInformationServiceStub> {
    private LoadingInformationServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LoadingInformationServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LoadingInformationServiceStub(channel, callOptions);
    }

    /** */
    public void getLoadingInformation(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformationRequest request,
        io.grpc.stub.StreamObserver<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetLoadingInformationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * refactoring single api to 5 grpc, Reason, please see the gateway Doc for why this split
     * Case 1, Loading Details
     * </pre>
     */
    public void saveLoadingInformation(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation request,
        io.grpc.stub.StreamObserver<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoSaveResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSaveLoadingInformationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Case 2, Only Loading Rate data
     * </pre>
     */
    public void saveLoadingInfoRates(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation request,
        io.grpc.stub.StreamObserver<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoSaveResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSaveLoadingInfoRatesMethod(), getCallOptions()),
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
    public void saveLoadingInfoBerths(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation request,
        io.grpc.stub.StreamObserver<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoSaveResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSaveLoadingInfoBerthsMethod(), getCallOptions()),
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
    public void saveLoadingInfoMachinery(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation request,
        io.grpc.stub.StreamObserver<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoSaveResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSaveLoadingInfoMachineryMethod(), getCallOptions()),
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
    public void saveLoadingInfoDelays(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation request,
        io.grpc.stub.StreamObserver<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoSaveResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSaveLoadingInfoDelaysMethod(), getCallOptions()),
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
    public void saveLoadingInfoStages(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation request,
        io.grpc.stub.StreamObserver<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoSaveResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSaveLoadingInfoStagesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void getLoadigInformationByVoyage(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels
                .LoadingInformationSynopticalRequest
            request,
        io.grpc.stub.StreamObserver<
                com.cpdss.common.generated.LoadableStudy.LoadingInformationSynopticalReply>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetLoadigInformationByVoyageMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void updateUllage(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.UpdateUllageLoadingRequest
            request,
        io.grpc.stub.StreamObserver<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.UpdateUllageLoadingReplay>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateUllageMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void saveAlgoLoadingPlanStatus(
        com.cpdss.common.generated.LoadableStudy.AlgoStatusRequest request,
        io.grpc.stub.StreamObserver<com.cpdss.common.generated.LoadableStudy.AlgoStatusReply>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSaveAlgoLoadingPlanStatusMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void generateLoadingPlan(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoAlgoRequest request,
        io.grpc.stub.StreamObserver<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoAlgoReply>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateLoadingPlanMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void getLoadingInfoAlgoStatus(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoStatusRequest request,
        io.grpc.stub.StreamObserver<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoStatusReply>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetLoadingInfoAlgoStatusMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void getLoadingInfoAlgoErrors(
        com.cpdss.common.generated.LoadableStudy.AlgoErrorRequest request,
        io.grpc.stub.StreamObserver<com.cpdss.common.generated.LoadableStudy.AlgoErrorReply>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetLoadingInfoAlgoErrorsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void uploadPortTideDetails(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.UploadTideDetailRequest request,
        io.grpc.stub.StreamObserver<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels
                    .UploadTideDetailStatusReply>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUploadPortTideDetailsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void downloadPortTideDetails(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.DownloadTideDetailRequest request,
        io.grpc.stub.StreamObserver<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels
                    .DownloadTideDetailStatusReply>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getDownloadPortTideDetailsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void saveCargoToBeLoaded(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation request,
        io.grpc.stub.StreamObserver<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoSaveResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSaveCargoToBeLoadedMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void getCargoToBeLoaded(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation request,
        io.grpc.stub.StreamObserver<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCargoToBeLoadedMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /** */
  public static final class LoadingInformationServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<LoadingInformationServiceBlockingStub> {
    private LoadingInformationServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LoadingInformationServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LoadingInformationServiceBlockingStub(channel, callOptions);
    }

    /** */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation
        getLoadingInformation(
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformationRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetLoadingInformationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * refactoring single api to 5 grpc, Reason, please see the gateway Doc for why this split
     * Case 1, Loading Details
     * </pre>
     */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoSaveResponse
        saveLoadingInformation(
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSaveLoadingInformationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Case 2, Only Loading Rate data
     * </pre>
     */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoSaveResponse
        saveLoadingInfoRates(
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSaveLoadingInfoRatesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Case 3, Adding Or Removing Berth Data
     * </pre>
     */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoSaveResponse
        saveLoadingInfoBerths(
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSaveLoadingInfoBerthsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Case 4, Machines in Use data
     * </pre>
     */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoSaveResponse
        saveLoadingInfoMachinery(
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSaveLoadingInfoMachineryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Case 5, reason for delay
     * </pre>
     */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoSaveResponse
        saveLoadingInfoDelays(
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSaveLoadingInfoDelaysMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Case 6, Stages and track status
     * </pre>
     */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoSaveResponse
        saveLoadingInfoStages(
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSaveLoadingInfoStagesMethod(), getCallOptions(), request);
    }

    /** */
    public com.cpdss.common.generated.LoadableStudy.LoadingInformationSynopticalReply
        getLoadigInformationByVoyage(
            com.cpdss.common.generated.loading_plan.LoadingPlanModels
                    .LoadingInformationSynopticalRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetLoadigInformationByVoyageMethod(), getCallOptions(), request);
    }

    /** */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.UpdateUllageLoadingReplay
        updateUllage(
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.UpdateUllageLoadingRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateUllageMethod(), getCallOptions(), request);
    }

    /** */
    public com.cpdss.common.generated.LoadableStudy.AlgoStatusReply saveAlgoLoadingPlanStatus(
        com.cpdss.common.generated.LoadableStudy.AlgoStatusRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSaveAlgoLoadingPlanStatusMethod(), getCallOptions(), request);
    }

    /** */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoAlgoReply
        generateLoadingPlan(
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoAlgoRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateLoadingPlanMethod(), getCallOptions(), request);
    }

    /** */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoStatusReply
        getLoadingInfoAlgoStatus(
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoStatusRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetLoadingInfoAlgoStatusMethod(), getCallOptions(), request);
    }

    /** */
    public com.cpdss.common.generated.LoadableStudy.AlgoErrorReply getLoadingInfoAlgoErrors(
        com.cpdss.common.generated.LoadableStudy.AlgoErrorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetLoadingInfoAlgoErrorsMethod(), getCallOptions(), request);
    }

    /** */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.UploadTideDetailStatusReply
        uploadPortTideDetails(
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.UploadTideDetailRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUploadPortTideDetailsMethod(), getCallOptions(), request);
    }

    /** */
    public java.util.Iterator<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.DownloadTideDetailStatusReply>
        downloadPortTideDetails(
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.DownloadTideDetailRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getDownloadPortTideDetailsMethod(), getCallOptions(), request);
    }

    /** */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoSaveResponse
        saveCargoToBeLoaded(
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSaveCargoToBeLoadedMethod(), getCallOptions(), request);
    }

    /** */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation
        getCargoToBeLoaded(
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCargoToBeLoadedMethod(), getCallOptions(), request);
    }
  }

  /** */
  public static final class LoadingInformationServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<LoadingInformationServiceFutureStub> {
    private LoadingInformationServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LoadingInformationServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LoadingInformationServiceFutureStub(channel, callOptions);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation>
        getLoadingInformation(
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformationRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetLoadingInformationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * refactoring single api to 5 grpc, Reason, please see the gateway Doc for why this split
     * Case 1, Loading Details
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoSaveResponse>
        saveLoadingInformation(
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSaveLoadingInformationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Case 2, Only Loading Rate data
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoSaveResponse>
        saveLoadingInfoRates(
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSaveLoadingInfoRatesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Case 3, Adding Or Removing Berth Data
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoSaveResponse>
        saveLoadingInfoBerths(
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSaveLoadingInfoBerthsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Case 4, Machines in Use data
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoSaveResponse>
        saveLoadingInfoMachinery(
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSaveLoadingInfoMachineryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Case 5, reason for delay
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoSaveResponse>
        saveLoadingInfoDelays(
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSaveLoadingInfoDelaysMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Case 6, Stages and track status
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoSaveResponse>
        saveLoadingInfoStages(
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSaveLoadingInfoStagesMethod(), getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            com.cpdss.common.generated.LoadableStudy.LoadingInformationSynopticalReply>
        getLoadigInformationByVoyage(
            com.cpdss.common.generated.loading_plan.LoadingPlanModels
                    .LoadingInformationSynopticalRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetLoadigInformationByVoyageMethod(), getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.UpdateUllageLoadingReplay>
        updateUllage(
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.UpdateUllageLoadingRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateUllageMethod(), getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            com.cpdss.common.generated.LoadableStudy.AlgoStatusReply>
        saveAlgoLoadingPlanStatus(
            com.cpdss.common.generated.LoadableStudy.AlgoStatusRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSaveAlgoLoadingPlanStatusMethod(), getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoAlgoReply>
        generateLoadingPlan(
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoAlgoRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateLoadingPlanMethod(), getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoStatusReply>
        getLoadingInfoAlgoStatus(
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoStatusRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetLoadingInfoAlgoStatusMethod(), getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            com.cpdss.common.generated.LoadableStudy.AlgoErrorReply>
        getLoadingInfoAlgoErrors(
            com.cpdss.common.generated.LoadableStudy.AlgoErrorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetLoadingInfoAlgoErrorsMethod(), getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.UploadTideDetailStatusReply>
        uploadPortTideDetails(
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.UploadTideDetailRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUploadPortTideDetailsMethod(), getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoSaveResponse>
        saveCargoToBeLoaded(
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSaveCargoToBeLoadedMethod(), getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation>
        getCargoToBeLoaded(
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCargoToBeLoadedMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_LOADING_INFORMATION = 0;
  private static final int METHODID_SAVE_LOADING_INFORMATION = 1;
  private static final int METHODID_SAVE_LOADING_INFO_RATES = 2;
  private static final int METHODID_SAVE_LOADING_INFO_BERTHS = 3;
  private static final int METHODID_SAVE_LOADING_INFO_MACHINERY = 4;
  private static final int METHODID_SAVE_LOADING_INFO_DELAYS = 5;
  private static final int METHODID_SAVE_LOADING_INFO_STAGES = 6;
  private static final int METHODID_GET_LOADIG_INFORMATION_BY_VOYAGE = 7;
  private static final int METHODID_UPDATE_ULLAGE = 8;
  private static final int METHODID_SAVE_ALGO_LOADING_PLAN_STATUS = 9;
  private static final int METHODID_GENERATE_LOADING_PLAN = 10;
  private static final int METHODID_GET_LOADING_INFO_ALGO_STATUS = 11;
  private static final int METHODID_GET_LOADING_INFO_ALGO_ERRORS = 12;
  private static final int METHODID_UPLOAD_PORT_TIDE_DETAILS = 13;
  private static final int METHODID_DOWNLOAD_PORT_TIDE_DETAILS = 14;
  private static final int METHODID_SAVE_CARGO_TO_BE_LOADED = 15;
  private static final int METHODID_GET_CARGO_TO_BE_LOADED = 16;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final LoadingInformationServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(LoadingInformationServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_LOADING_INFORMATION:
          serviceImpl.getLoadingInformation(
              (com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformationRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation>)
                  responseObserver);
          break;
        case METHODID_SAVE_LOADING_INFORMATION:
          serviceImpl.saveLoadingInformation(
              (com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels
                          .LoadingInfoSaveResponse>)
                  responseObserver);
          break;
        case METHODID_SAVE_LOADING_INFO_RATES:
          serviceImpl.saveLoadingInfoRates(
              (com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels
                          .LoadingInfoSaveResponse>)
                  responseObserver);
          break;
        case METHODID_SAVE_LOADING_INFO_BERTHS:
          serviceImpl.saveLoadingInfoBerths(
              (com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels
                          .LoadingInfoSaveResponse>)
                  responseObserver);
          break;
        case METHODID_SAVE_LOADING_INFO_MACHINERY:
          serviceImpl.saveLoadingInfoMachinery(
              (com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels
                          .LoadingInfoSaveResponse>)
                  responseObserver);
          break;
        case METHODID_SAVE_LOADING_INFO_DELAYS:
          serviceImpl.saveLoadingInfoDelays(
              (com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels
                          .LoadingInfoSaveResponse>)
                  responseObserver);
          break;
        case METHODID_SAVE_LOADING_INFO_STAGES:
          serviceImpl.saveLoadingInfoStages(
              (com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels
                          .LoadingInfoSaveResponse>)
                  responseObserver);
          break;
        case METHODID_GET_LOADIG_INFORMATION_BY_VOYAGE:
          serviceImpl.getLoadigInformationByVoyage(
              (com.cpdss.common.generated.loading_plan.LoadingPlanModels
                      .LoadingInformationSynopticalRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.cpdss.common.generated.LoadableStudy.LoadingInformationSynopticalReply>)
                  responseObserver);
          break;
        case METHODID_UPDATE_ULLAGE:
          serviceImpl.updateUllage(
              (com.cpdss.common.generated.loading_plan.LoadingPlanModels.UpdateUllageLoadingRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels
                          .UpdateUllageLoadingReplay>)
                  responseObserver);
          break;
        case METHODID_SAVE_ALGO_LOADING_PLAN_STATUS:
          serviceImpl.saveAlgoLoadingPlanStatus(
              (com.cpdss.common.generated.LoadableStudy.AlgoStatusRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.cpdss.common.generated.LoadableStudy.AlgoStatusReply>)
                  responseObserver);
          break;
        case METHODID_GENERATE_LOADING_PLAN:
          serviceImpl.generateLoadingPlan(
              (com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoAlgoRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels
                          .LoadingInfoAlgoReply>)
                  responseObserver);
          break;
        case METHODID_GET_LOADING_INFO_ALGO_STATUS:
          serviceImpl.getLoadingInfoAlgoStatus(
              (com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoStatusRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels
                          .LoadingInfoStatusReply>)
                  responseObserver);
          break;
        case METHODID_GET_LOADING_INFO_ALGO_ERRORS:
          serviceImpl.getLoadingInfoAlgoErrors(
              (com.cpdss.common.generated.LoadableStudy.AlgoErrorRequest) request,
              (io.grpc.stub.StreamObserver<com.cpdss.common.generated.LoadableStudy.AlgoErrorReply>)
                  responseObserver);
          break;
        case METHODID_UPLOAD_PORT_TIDE_DETAILS:
          serviceImpl.uploadPortTideDetails(
              (com.cpdss.common.generated.loading_plan.LoadingPlanModels.UploadTideDetailRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels
                          .UploadTideDetailStatusReply>)
                  responseObserver);
          break;
        case METHODID_DOWNLOAD_PORT_TIDE_DETAILS:
          serviceImpl.downloadPortTideDetails(
              (com.cpdss.common.generated.loading_plan.LoadingPlanModels.DownloadTideDetailRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels
                          .DownloadTideDetailStatusReply>)
                  responseObserver);
          break;
        case METHODID_SAVE_CARGO_TO_BE_LOADED:
          serviceImpl.saveCargoToBeLoaded(
              (com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels
                          .LoadingInfoSaveResponse>)
                  responseObserver);
          break;
        case METHODID_GET_CARGO_TO_BE_LOADED:
          serviceImpl.getCargoToBeLoaded(
              (com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation>)
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

  private abstract static class LoadingInformationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LoadingInformationServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.cpdss.common.generated.loading_plan.LoadingPlanServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LoadingInformationService");
    }
  }

  private static final class LoadingInformationServiceFileDescriptorSupplier
      extends LoadingInformationServiceBaseDescriptorSupplier {
    LoadingInformationServiceFileDescriptorSupplier() {}
  }

  private static final class LoadingInformationServiceMethodDescriptorSupplier
      extends LoadingInformationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    LoadingInformationServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (LoadingInformationServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new LoadingInformationServiceFileDescriptorSupplier())
                      .addMethod(getGetLoadingInformationMethod())
                      .addMethod(getSaveLoadingInformationMethod())
                      .addMethod(getSaveLoadingInfoRatesMethod())
                      .addMethod(getSaveLoadingInfoBerthsMethod())
                      .addMethod(getSaveLoadingInfoMachineryMethod())
                      .addMethod(getSaveLoadingInfoDelaysMethod())
                      .addMethod(getSaveLoadingInfoStagesMethod())
                      .addMethod(getGetLoadigInformationByVoyageMethod())
                      .addMethod(getUpdateUllageMethod())
                      .addMethod(getSaveAlgoLoadingPlanStatusMethod())
                      .addMethod(getGenerateLoadingPlanMethod())
                      .addMethod(getGetLoadingInfoAlgoStatusMethod())
                      .addMethod(getGetLoadingInfoAlgoErrorsMethod())
                      .addMethod(getUploadPortTideDetailsMethod())
                      .addMethod(getDownloadPortTideDetailsMethod())
                      .addMethod(getSaveCargoToBeLoadedMethod())
                      .addMethod(getGetCargoToBeLoadedMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
