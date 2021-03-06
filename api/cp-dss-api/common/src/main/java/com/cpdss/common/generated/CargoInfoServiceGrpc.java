/* Licensed at AlphaOri Technologies */
package com.cpdss.common.generated;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/** */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.40.1)",
    comments = "Source: cargo_info.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CargoInfoServiceGrpc {

  private CargoInfoServiceGrpc() {}

  public static final String SERVICE_NAME = "CargoInfoService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.cpdss.common.generated.CargoInfo.CargoRequest,
          com.cpdss.common.generated.CargoInfo.CargoReply>
      getGetCargoInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCargoInfo",
      requestType = com.cpdss.common.generated.CargoInfo.CargoRequest.class,
      responseType = com.cpdss.common.generated.CargoInfo.CargoReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.cpdss.common.generated.CargoInfo.CargoRequest,
          com.cpdss.common.generated.CargoInfo.CargoReply>
      getGetCargoInfoMethod() {
    io.grpc.MethodDescriptor<
            com.cpdss.common.generated.CargoInfo.CargoRequest,
            com.cpdss.common.generated.CargoInfo.CargoReply>
        getGetCargoInfoMethod;
    if ((getGetCargoInfoMethod = CargoInfoServiceGrpc.getGetCargoInfoMethod) == null) {
      synchronized (CargoInfoServiceGrpc.class) {
        if ((getGetCargoInfoMethod = CargoInfoServiceGrpc.getGetCargoInfoMethod) == null) {
          CargoInfoServiceGrpc.getGetCargoInfoMethod =
              getGetCargoInfoMethod =
                  io.grpc.MethodDescriptor
                      .<com.cpdss.common.generated.CargoInfo.CargoRequest,
                          com.cpdss.common.generated.CargoInfo.CargoReply>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCargoInfo"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.CargoInfo.CargoRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.CargoInfo.CargoReply.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CargoInfoServiceMethodDescriptorSupplier("GetCargoInfo"))
                      .build();
        }
      }
    }
    return getGetCargoInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.cpdss.common.generated.CargoInfo.CargoRequestWithPaging,
          com.cpdss.common.generated.CargoInfo.CargoReply>
      getGetCargoInfoByPagingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCargoInfoByPaging",
      requestType = com.cpdss.common.generated.CargoInfo.CargoRequestWithPaging.class,
      responseType = com.cpdss.common.generated.CargoInfo.CargoReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.cpdss.common.generated.CargoInfo.CargoRequestWithPaging,
          com.cpdss.common.generated.CargoInfo.CargoReply>
      getGetCargoInfoByPagingMethod() {
    io.grpc.MethodDescriptor<
            com.cpdss.common.generated.CargoInfo.CargoRequestWithPaging,
            com.cpdss.common.generated.CargoInfo.CargoReply>
        getGetCargoInfoByPagingMethod;
    if ((getGetCargoInfoByPagingMethod = CargoInfoServiceGrpc.getGetCargoInfoByPagingMethod)
        == null) {
      synchronized (CargoInfoServiceGrpc.class) {
        if ((getGetCargoInfoByPagingMethod = CargoInfoServiceGrpc.getGetCargoInfoByPagingMethod)
            == null) {
          CargoInfoServiceGrpc.getGetCargoInfoByPagingMethod =
              getGetCargoInfoByPagingMethod =
                  io.grpc.MethodDescriptor
                      .<com.cpdss.common.generated.CargoInfo.CargoRequestWithPaging,
                          com.cpdss.common.generated.CargoInfo.CargoReply>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetCargoInfoByPaging"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.CargoInfo.CargoRequestWithPaging
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.CargoInfo.CargoReply.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CargoInfoServiceMethodDescriptorSupplier("GetCargoInfoByPaging"))
                      .build();
        }
      }
    }
    return getGetCargoInfoByPagingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.cpdss.common.generated.CargoInfo.CargoRequest,
          com.cpdss.common.generated.CargoInfo.CargoDetailReply>
      getGetCargoInfoByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCargoInfoById",
      requestType = com.cpdss.common.generated.CargoInfo.CargoRequest.class,
      responseType = com.cpdss.common.generated.CargoInfo.CargoDetailReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.cpdss.common.generated.CargoInfo.CargoRequest,
          com.cpdss.common.generated.CargoInfo.CargoDetailReply>
      getGetCargoInfoByIdMethod() {
    io.grpc.MethodDescriptor<
            com.cpdss.common.generated.CargoInfo.CargoRequest,
            com.cpdss.common.generated.CargoInfo.CargoDetailReply>
        getGetCargoInfoByIdMethod;
    if ((getGetCargoInfoByIdMethod = CargoInfoServiceGrpc.getGetCargoInfoByIdMethod) == null) {
      synchronized (CargoInfoServiceGrpc.class) {
        if ((getGetCargoInfoByIdMethod = CargoInfoServiceGrpc.getGetCargoInfoByIdMethod) == null) {
          CargoInfoServiceGrpc.getGetCargoInfoByIdMethod =
              getGetCargoInfoByIdMethod =
                  io.grpc.MethodDescriptor
                      .<com.cpdss.common.generated.CargoInfo.CargoRequest,
                          com.cpdss.common.generated.CargoInfo.CargoDetailReply>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCargoInfoById"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.CargoInfo.CargoRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.CargoInfo.CargoDetailReply
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CargoInfoServiceMethodDescriptorSupplier("GetCargoInfoById"))
                      .build();
        }
      }
    }
    return getGetCargoInfoByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.cpdss.common.generated.CargoInfo.CargoListRequest,
          com.cpdss.common.generated.CargoInfo.CargoReply>
      getGetCargoInfosByCargoIdsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCargoInfosByCargoIds",
      requestType = com.cpdss.common.generated.CargoInfo.CargoListRequest.class,
      responseType = com.cpdss.common.generated.CargoInfo.CargoReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.cpdss.common.generated.CargoInfo.CargoListRequest,
          com.cpdss.common.generated.CargoInfo.CargoReply>
      getGetCargoInfosByCargoIdsMethod() {
    io.grpc.MethodDescriptor<
            com.cpdss.common.generated.CargoInfo.CargoListRequest,
            com.cpdss.common.generated.CargoInfo.CargoReply>
        getGetCargoInfosByCargoIdsMethod;
    if ((getGetCargoInfosByCargoIdsMethod = CargoInfoServiceGrpc.getGetCargoInfosByCargoIdsMethod)
        == null) {
      synchronized (CargoInfoServiceGrpc.class) {
        if ((getGetCargoInfosByCargoIdsMethod =
                CargoInfoServiceGrpc.getGetCargoInfosByCargoIdsMethod)
            == null) {
          CargoInfoServiceGrpc.getGetCargoInfosByCargoIdsMethod =
              getGetCargoInfosByCargoIdsMethod =
                  io.grpc.MethodDescriptor
                      .<com.cpdss.common.generated.CargoInfo.CargoListRequest,
                          com.cpdss.common.generated.CargoInfo.CargoReply>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetCargoInfosByCargoIds"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.CargoInfo.CargoListRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.CargoInfo.CargoReply.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CargoInfoServiceMethodDescriptorSupplier("GetCargoInfosByCargoIds"))
                      .build();
        }
      }
    }
    return getGetCargoInfosByCargoIdsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.cpdss.common.generated.CargoInfo.CargoRequest,
          com.cpdss.common.generated.CargoInfo.CargoDetailedReply>
      getGetCargoInfoDetailedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCargoInfoDetailed",
      requestType = com.cpdss.common.generated.CargoInfo.CargoRequest.class,
      responseType = com.cpdss.common.generated.CargoInfo.CargoDetailedReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.cpdss.common.generated.CargoInfo.CargoRequest,
          com.cpdss.common.generated.CargoInfo.CargoDetailedReply>
      getGetCargoInfoDetailedMethod() {
    io.grpc.MethodDescriptor<
            com.cpdss.common.generated.CargoInfo.CargoRequest,
            com.cpdss.common.generated.CargoInfo.CargoDetailedReply>
        getGetCargoInfoDetailedMethod;
    if ((getGetCargoInfoDetailedMethod = CargoInfoServiceGrpc.getGetCargoInfoDetailedMethod)
        == null) {
      synchronized (CargoInfoServiceGrpc.class) {
        if ((getGetCargoInfoDetailedMethod = CargoInfoServiceGrpc.getGetCargoInfoDetailedMethod)
            == null) {
          CargoInfoServiceGrpc.getGetCargoInfoDetailedMethod =
              getGetCargoInfoDetailedMethod =
                  io.grpc.MethodDescriptor
                      .<com.cpdss.common.generated.CargoInfo.CargoRequest,
                          com.cpdss.common.generated.CargoInfo.CargoDetailedReply>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetCargoInfoDetailed"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.CargoInfo.CargoRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.CargoInfo.CargoDetailedReply
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CargoInfoServiceMethodDescriptorSupplier("GetCargoInfoDetailed"))
                      .build();
        }
      }
    }
    return getGetCargoInfoDetailedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.cpdss.common.generated.CargoInfo.CargoRequest,
          com.cpdss.common.generated.CargoInfo.CargoByIdDetailedReply>
      getGetCargoInfoDetailedByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCargoInfoDetailedById",
      requestType = com.cpdss.common.generated.CargoInfo.CargoRequest.class,
      responseType = com.cpdss.common.generated.CargoInfo.CargoByIdDetailedReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.cpdss.common.generated.CargoInfo.CargoRequest,
          com.cpdss.common.generated.CargoInfo.CargoByIdDetailedReply>
      getGetCargoInfoDetailedByIdMethod() {
    io.grpc.MethodDescriptor<
            com.cpdss.common.generated.CargoInfo.CargoRequest,
            com.cpdss.common.generated.CargoInfo.CargoByIdDetailedReply>
        getGetCargoInfoDetailedByIdMethod;
    if ((getGetCargoInfoDetailedByIdMethod = CargoInfoServiceGrpc.getGetCargoInfoDetailedByIdMethod)
        == null) {
      synchronized (CargoInfoServiceGrpc.class) {
        if ((getGetCargoInfoDetailedByIdMethod =
                CargoInfoServiceGrpc.getGetCargoInfoDetailedByIdMethod)
            == null) {
          CargoInfoServiceGrpc.getGetCargoInfoDetailedByIdMethod =
              getGetCargoInfoDetailedByIdMethod =
                  io.grpc.MethodDescriptor
                      .<com.cpdss.common.generated.CargoInfo.CargoRequest,
                          com.cpdss.common.generated.CargoInfo.CargoByIdDetailedReply>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetCargoInfoDetailedById"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.CargoInfo.CargoRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.CargoInfo.CargoByIdDetailedReply
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CargoInfoServiceMethodDescriptorSupplier("GetCargoInfoDetailedById"))
                      .build();
        }
      }
    }
    return getGetCargoInfoDetailedByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.cpdss.common.generated.CargoInfo.CargoRequest,
          com.cpdss.common.generated.CargoInfo.CargoByIdDetailedReply>
      getDeleteCargoByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteCargoById",
      requestType = com.cpdss.common.generated.CargoInfo.CargoRequest.class,
      responseType = com.cpdss.common.generated.CargoInfo.CargoByIdDetailedReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.cpdss.common.generated.CargoInfo.CargoRequest,
          com.cpdss.common.generated.CargoInfo.CargoByIdDetailedReply>
      getDeleteCargoByIdMethod() {
    io.grpc.MethodDescriptor<
            com.cpdss.common.generated.CargoInfo.CargoRequest,
            com.cpdss.common.generated.CargoInfo.CargoByIdDetailedReply>
        getDeleteCargoByIdMethod;
    if ((getDeleteCargoByIdMethod = CargoInfoServiceGrpc.getDeleteCargoByIdMethod) == null) {
      synchronized (CargoInfoServiceGrpc.class) {
        if ((getDeleteCargoByIdMethod = CargoInfoServiceGrpc.getDeleteCargoByIdMethod) == null) {
          CargoInfoServiceGrpc.getDeleteCargoByIdMethod =
              getDeleteCargoByIdMethod =
                  io.grpc.MethodDescriptor
                      .<com.cpdss.common.generated.CargoInfo.CargoRequest,
                          com.cpdss.common.generated.CargoInfo.CargoByIdDetailedReply>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteCargoById"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.CargoInfo.CargoRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.CargoInfo.CargoByIdDetailedReply
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CargoInfoServiceMethodDescriptorSupplier("DeleteCargoById"))
                      .build();
        }
      }
    }
    return getDeleteCargoByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.cpdss.common.generated.CargoInfo.CargoDetailed,
          com.cpdss.common.generated.CargoInfo.CargoByIdDetailedReply>
      getSaveCargoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SaveCargo",
      requestType = com.cpdss.common.generated.CargoInfo.CargoDetailed.class,
      responseType = com.cpdss.common.generated.CargoInfo.CargoByIdDetailedReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.cpdss.common.generated.CargoInfo.CargoDetailed,
          com.cpdss.common.generated.CargoInfo.CargoByIdDetailedReply>
      getSaveCargoMethod() {
    io.grpc.MethodDescriptor<
            com.cpdss.common.generated.CargoInfo.CargoDetailed,
            com.cpdss.common.generated.CargoInfo.CargoByIdDetailedReply>
        getSaveCargoMethod;
    if ((getSaveCargoMethod = CargoInfoServiceGrpc.getSaveCargoMethod) == null) {
      synchronized (CargoInfoServiceGrpc.class) {
        if ((getSaveCargoMethod = CargoInfoServiceGrpc.getSaveCargoMethod) == null) {
          CargoInfoServiceGrpc.getSaveCargoMethod =
              getSaveCargoMethod =
                  io.grpc.MethodDescriptor
                      .<com.cpdss.common.generated.CargoInfo.CargoDetailed,
                          com.cpdss.common.generated.CargoInfo.CargoByIdDetailedReply>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SaveCargo"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.CargoInfo.CargoDetailed
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.cpdss.common.generated.CargoInfo.CargoByIdDetailedReply
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CargoInfoServiceMethodDescriptorSupplier("SaveCargo"))
                      .build();
        }
      }
    }
    return getSaveCargoMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static CargoInfoServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CargoInfoServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CargoInfoServiceStub>() {
          @java.lang.Override
          public CargoInfoServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CargoInfoServiceStub(channel, callOptions);
          }
        };
    return CargoInfoServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CargoInfoServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CargoInfoServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CargoInfoServiceBlockingStub>() {
          @java.lang.Override
          public CargoInfoServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CargoInfoServiceBlockingStub(channel, callOptions);
          }
        };
    return CargoInfoServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static CargoInfoServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CargoInfoServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CargoInfoServiceFutureStub>() {
          @java.lang.Override
          public CargoInfoServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CargoInfoServiceFutureStub(channel, callOptions);
          }
        };
    return CargoInfoServiceFutureStub.newStub(factory, channel);
  }

  /** */
  public abstract static class CargoInfoServiceImplBase implements io.grpc.BindableService {

    /** */
    public void getCargoInfo(
        com.cpdss.common.generated.CargoInfo.CargoRequest request,
        io.grpc.stub.StreamObserver<com.cpdss.common.generated.CargoInfo.CargoReply>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetCargoInfoMethod(), responseObserver);
    }

    /** */
    public void getCargoInfoByPaging(
        com.cpdss.common.generated.CargoInfo.CargoRequestWithPaging request,
        io.grpc.stub.StreamObserver<com.cpdss.common.generated.CargoInfo.CargoReply>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetCargoInfoByPagingMethod(), responseObserver);
    }

    /** */
    public void getCargoInfoById(
        com.cpdss.common.generated.CargoInfo.CargoRequest request,
        io.grpc.stub.StreamObserver<com.cpdss.common.generated.CargoInfo.CargoDetailReply>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetCargoInfoByIdMethod(), responseObserver);
    }

    /** */
    public void getCargoInfosByCargoIds(
        com.cpdss.common.generated.CargoInfo.CargoListRequest request,
        io.grpc.stub.StreamObserver<com.cpdss.common.generated.CargoInfo.CargoReply>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetCargoInfosByCargoIdsMethod(), responseObserver);
    }

    /** */
    public void getCargoInfoDetailed(
        com.cpdss.common.generated.CargoInfo.CargoRequest request,
        io.grpc.stub.StreamObserver<com.cpdss.common.generated.CargoInfo.CargoDetailedReply>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetCargoInfoDetailedMethod(), responseObserver);
    }

    /** */
    public void getCargoInfoDetailedById(
        com.cpdss.common.generated.CargoInfo.CargoRequest request,
        io.grpc.stub.StreamObserver<com.cpdss.common.generated.CargoInfo.CargoByIdDetailedReply>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetCargoInfoDetailedByIdMethod(), responseObserver);
    }

    /** */
    public void deleteCargoById(
        com.cpdss.common.generated.CargoInfo.CargoRequest request,
        io.grpc.stub.StreamObserver<com.cpdss.common.generated.CargoInfo.CargoByIdDetailedReply>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteCargoByIdMethod(), responseObserver);
    }

    /** */
    public void saveCargo(
        com.cpdss.common.generated.CargoInfo.CargoDetailed request,
        io.grpc.stub.StreamObserver<com.cpdss.common.generated.CargoInfo.CargoByIdDetailedReply>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSaveCargoMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getGetCargoInfoMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.cpdss.common.generated.CargoInfo.CargoRequest,
                      com.cpdss.common.generated.CargoInfo.CargoReply>(
                      this, METHODID_GET_CARGO_INFO)))
          .addMethod(
              getGetCargoInfoByPagingMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.cpdss.common.generated.CargoInfo.CargoRequestWithPaging,
                      com.cpdss.common.generated.CargoInfo.CargoReply>(
                      this, METHODID_GET_CARGO_INFO_BY_PAGING)))
          .addMethod(
              getGetCargoInfoByIdMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.cpdss.common.generated.CargoInfo.CargoRequest,
                      com.cpdss.common.generated.CargoInfo.CargoDetailReply>(
                      this, METHODID_GET_CARGO_INFO_BY_ID)))
          .addMethod(
              getGetCargoInfosByCargoIdsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.cpdss.common.generated.CargoInfo.CargoListRequest,
                      com.cpdss.common.generated.CargoInfo.CargoReply>(
                      this, METHODID_GET_CARGO_INFOS_BY_CARGO_IDS)))
          .addMethod(
              getGetCargoInfoDetailedMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.cpdss.common.generated.CargoInfo.CargoRequest,
                      com.cpdss.common.generated.CargoInfo.CargoDetailedReply>(
                      this, METHODID_GET_CARGO_INFO_DETAILED)))
          .addMethod(
              getGetCargoInfoDetailedByIdMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.cpdss.common.generated.CargoInfo.CargoRequest,
                      com.cpdss.common.generated.CargoInfo.CargoByIdDetailedReply>(
                      this, METHODID_GET_CARGO_INFO_DETAILED_BY_ID)))
          .addMethod(
              getDeleteCargoByIdMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.cpdss.common.generated.CargoInfo.CargoRequest,
                      com.cpdss.common.generated.CargoInfo.CargoByIdDetailedReply>(
                      this, METHODID_DELETE_CARGO_BY_ID)))
          .addMethod(
              getSaveCargoMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.cpdss.common.generated.CargoInfo.CargoDetailed,
                      com.cpdss.common.generated.CargoInfo.CargoByIdDetailedReply>(
                      this, METHODID_SAVE_CARGO)))
          .build();
    }
  }

  /** */
  public static final class CargoInfoServiceStub
      extends io.grpc.stub.AbstractAsyncStub<CargoInfoServiceStub> {
    private CargoInfoServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CargoInfoServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CargoInfoServiceStub(channel, callOptions);
    }

    /** */
    public void getCargoInfo(
        com.cpdss.common.generated.CargoInfo.CargoRequest request,
        io.grpc.stub.StreamObserver<com.cpdss.common.generated.CargoInfo.CargoReply>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCargoInfoMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void getCargoInfoByPaging(
        com.cpdss.common.generated.CargoInfo.CargoRequestWithPaging request,
        io.grpc.stub.StreamObserver<com.cpdss.common.generated.CargoInfo.CargoReply>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCargoInfoByPagingMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void getCargoInfoById(
        com.cpdss.common.generated.CargoInfo.CargoRequest request,
        io.grpc.stub.StreamObserver<com.cpdss.common.generated.CargoInfo.CargoDetailReply>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCargoInfoByIdMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void getCargoInfosByCargoIds(
        com.cpdss.common.generated.CargoInfo.CargoListRequest request,
        io.grpc.stub.StreamObserver<com.cpdss.common.generated.CargoInfo.CargoReply>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCargoInfosByCargoIdsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void getCargoInfoDetailed(
        com.cpdss.common.generated.CargoInfo.CargoRequest request,
        io.grpc.stub.StreamObserver<com.cpdss.common.generated.CargoInfo.CargoDetailedReply>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCargoInfoDetailedMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void getCargoInfoDetailedById(
        com.cpdss.common.generated.CargoInfo.CargoRequest request,
        io.grpc.stub.StreamObserver<com.cpdss.common.generated.CargoInfo.CargoByIdDetailedReply>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCargoInfoDetailedByIdMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void deleteCargoById(
        com.cpdss.common.generated.CargoInfo.CargoRequest request,
        io.grpc.stub.StreamObserver<com.cpdss.common.generated.CargoInfo.CargoByIdDetailedReply>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteCargoByIdMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void saveCargo(
        com.cpdss.common.generated.CargoInfo.CargoDetailed request,
        io.grpc.stub.StreamObserver<com.cpdss.common.generated.CargoInfo.CargoByIdDetailedReply>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSaveCargoMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /** */
  public static final class CargoInfoServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CargoInfoServiceBlockingStub> {
    private CargoInfoServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CargoInfoServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CargoInfoServiceBlockingStub(channel, callOptions);
    }

    /** */
    public com.cpdss.common.generated.CargoInfo.CargoReply getCargoInfo(
        com.cpdss.common.generated.CargoInfo.CargoRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCargoInfoMethod(), getCallOptions(), request);
    }

    /** */
    public com.cpdss.common.generated.CargoInfo.CargoReply getCargoInfoByPaging(
        com.cpdss.common.generated.CargoInfo.CargoRequestWithPaging request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCargoInfoByPagingMethod(), getCallOptions(), request);
    }

    /** */
    public com.cpdss.common.generated.CargoInfo.CargoDetailReply getCargoInfoById(
        com.cpdss.common.generated.CargoInfo.CargoRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCargoInfoByIdMethod(), getCallOptions(), request);
    }

    /** */
    public com.cpdss.common.generated.CargoInfo.CargoReply getCargoInfosByCargoIds(
        com.cpdss.common.generated.CargoInfo.CargoListRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCargoInfosByCargoIdsMethod(), getCallOptions(), request);
    }

    /** */
    public com.cpdss.common.generated.CargoInfo.CargoDetailedReply getCargoInfoDetailed(
        com.cpdss.common.generated.CargoInfo.CargoRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCargoInfoDetailedMethod(), getCallOptions(), request);
    }

    /** */
    public com.cpdss.common.generated.CargoInfo.CargoByIdDetailedReply getCargoInfoDetailedById(
        com.cpdss.common.generated.CargoInfo.CargoRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCargoInfoDetailedByIdMethod(), getCallOptions(), request);
    }

    /** */
    public com.cpdss.common.generated.CargoInfo.CargoByIdDetailedReply deleteCargoById(
        com.cpdss.common.generated.CargoInfo.CargoRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteCargoByIdMethod(), getCallOptions(), request);
    }

    /** */
    public com.cpdss.common.generated.CargoInfo.CargoByIdDetailedReply saveCargo(
        com.cpdss.common.generated.CargoInfo.CargoDetailed request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSaveCargoMethod(), getCallOptions(), request);
    }
  }

  /** */
  public static final class CargoInfoServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<CargoInfoServiceFutureStub> {
    private CargoInfoServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CargoInfoServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CargoInfoServiceFutureStub(channel, callOptions);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            com.cpdss.common.generated.CargoInfo.CargoReply>
        getCargoInfo(com.cpdss.common.generated.CargoInfo.CargoRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCargoInfoMethod(), getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            com.cpdss.common.generated.CargoInfo.CargoReply>
        getCargoInfoByPaging(com.cpdss.common.generated.CargoInfo.CargoRequestWithPaging request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCargoInfoByPagingMethod(), getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            com.cpdss.common.generated.CargoInfo.CargoDetailReply>
        getCargoInfoById(com.cpdss.common.generated.CargoInfo.CargoRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCargoInfoByIdMethod(), getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            com.cpdss.common.generated.CargoInfo.CargoReply>
        getCargoInfosByCargoIds(com.cpdss.common.generated.CargoInfo.CargoListRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCargoInfosByCargoIdsMethod(), getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            com.cpdss.common.generated.CargoInfo.CargoDetailedReply>
        getCargoInfoDetailed(com.cpdss.common.generated.CargoInfo.CargoRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCargoInfoDetailedMethod(), getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            com.cpdss.common.generated.CargoInfo.CargoByIdDetailedReply>
        getCargoInfoDetailedById(com.cpdss.common.generated.CargoInfo.CargoRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCargoInfoDetailedByIdMethod(), getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            com.cpdss.common.generated.CargoInfo.CargoByIdDetailedReply>
        deleteCargoById(com.cpdss.common.generated.CargoInfo.CargoRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteCargoByIdMethod(), getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            com.cpdss.common.generated.CargoInfo.CargoByIdDetailedReply>
        saveCargo(com.cpdss.common.generated.CargoInfo.CargoDetailed request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSaveCargoMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_CARGO_INFO = 0;
  private static final int METHODID_GET_CARGO_INFO_BY_PAGING = 1;
  private static final int METHODID_GET_CARGO_INFO_BY_ID = 2;
  private static final int METHODID_GET_CARGO_INFOS_BY_CARGO_IDS = 3;
  private static final int METHODID_GET_CARGO_INFO_DETAILED = 4;
  private static final int METHODID_GET_CARGO_INFO_DETAILED_BY_ID = 5;
  private static final int METHODID_DELETE_CARGO_BY_ID = 6;
  private static final int METHODID_SAVE_CARGO = 7;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CargoInfoServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CargoInfoServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_CARGO_INFO:
          serviceImpl.getCargoInfo(
              (com.cpdss.common.generated.CargoInfo.CargoRequest) request,
              (io.grpc.stub.StreamObserver<com.cpdss.common.generated.CargoInfo.CargoReply>)
                  responseObserver);
          break;
        case METHODID_GET_CARGO_INFO_BY_PAGING:
          serviceImpl.getCargoInfoByPaging(
              (com.cpdss.common.generated.CargoInfo.CargoRequestWithPaging) request,
              (io.grpc.stub.StreamObserver<com.cpdss.common.generated.CargoInfo.CargoReply>)
                  responseObserver);
          break;
        case METHODID_GET_CARGO_INFO_BY_ID:
          serviceImpl.getCargoInfoById(
              (com.cpdss.common.generated.CargoInfo.CargoRequest) request,
              (io.grpc.stub.StreamObserver<com.cpdss.common.generated.CargoInfo.CargoDetailReply>)
                  responseObserver);
          break;
        case METHODID_GET_CARGO_INFOS_BY_CARGO_IDS:
          serviceImpl.getCargoInfosByCargoIds(
              (com.cpdss.common.generated.CargoInfo.CargoListRequest) request,
              (io.grpc.stub.StreamObserver<com.cpdss.common.generated.CargoInfo.CargoReply>)
                  responseObserver);
          break;
        case METHODID_GET_CARGO_INFO_DETAILED:
          serviceImpl.getCargoInfoDetailed(
              (com.cpdss.common.generated.CargoInfo.CargoRequest) request,
              (io.grpc.stub.StreamObserver<com.cpdss.common.generated.CargoInfo.CargoDetailedReply>)
                  responseObserver);
          break;
        case METHODID_GET_CARGO_INFO_DETAILED_BY_ID:
          serviceImpl.getCargoInfoDetailedById(
              (com.cpdss.common.generated.CargoInfo.CargoRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.cpdss.common.generated.CargoInfo.CargoByIdDetailedReply>)
                  responseObserver);
          break;
        case METHODID_DELETE_CARGO_BY_ID:
          serviceImpl.deleteCargoById(
              (com.cpdss.common.generated.CargoInfo.CargoRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.cpdss.common.generated.CargoInfo.CargoByIdDetailedReply>)
                  responseObserver);
          break;
        case METHODID_SAVE_CARGO:
          serviceImpl.saveCargo(
              (com.cpdss.common.generated.CargoInfo.CargoDetailed) request,
              (io.grpc.stub.StreamObserver<
                      com.cpdss.common.generated.CargoInfo.CargoByIdDetailedReply>)
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

  private abstract static class CargoInfoServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CargoInfoServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.cpdss.common.generated.CargoInfo.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CargoInfoService");
    }
  }

  private static final class CargoInfoServiceFileDescriptorSupplier
      extends CargoInfoServiceBaseDescriptorSupplier {
    CargoInfoServiceFileDescriptorSupplier() {}
  }

  private static final class CargoInfoServiceMethodDescriptorSupplier
      extends CargoInfoServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CargoInfoServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (CargoInfoServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new CargoInfoServiceFileDescriptorSupplier())
                      .addMethod(getGetCargoInfoMethod())
                      .addMethod(getGetCargoInfoByPagingMethod())
                      .addMethod(getGetCargoInfoByIdMethod())
                      .addMethod(getGetCargoInfosByCargoIdsMethod())
                      .addMethod(getGetCargoInfoDetailedMethod())
                      .addMethod(getGetCargoInfoDetailedByIdMethod())
                      .addMethod(getDeleteCargoByIdMethod())
                      .addMethod(getSaveCargoMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
