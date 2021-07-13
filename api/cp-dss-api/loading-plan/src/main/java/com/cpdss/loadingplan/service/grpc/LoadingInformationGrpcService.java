/* Licensed at AlphaOri Technologies */
package com.cpdss.loadingplan.service.grpc;

import static com.cpdss.loadingplan.common.LoadingPlanConstants.*;

import com.cpdss.common.exception.GenericServiceException;
import com.cpdss.common.generated.Common;
import com.cpdss.common.generated.Common.ResponseStatus;
import com.cpdss.common.generated.loading_plan.LoadingInformationServiceGrpc;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoAlgoRequest;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoSaveResponse;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoSaveResponse.Builder;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformationSynopticalReply;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformationSynopticalRequest;
import com.cpdss.common.rest.CommonErrorCodes;
import com.cpdss.common.utils.Utils;
import com.cpdss.loadingplan.service.*;
import com.cpdss.loadingplan.service.algo.LoadingInformationAlgoService;
import com.cpdss.loadingplan.service.impl.LoadingInformationDischargeService;
import io.grpc.stub.StreamObserver;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Grpc Service Implementation from common
 *
 * @author Johnsooraj.X
 * @since 20-05-2021
 */
@Slf4j
@GrpcService
public class LoadingInformationGrpcService
    extends LoadingInformationServiceGrpc.LoadingInformationServiceImplBase {

  @Autowired LoadingInformationService loadingInformationService;
  @Autowired CargoToppingOffSequenceService toppingOffSequenceService;
  @Autowired LoadingInformationDischargeService loadingInfoService;
  @Autowired LoadingInformationAlgoService loadingInfoAlgoService;

  @Autowired LoadingMachineryInUseService loadingMachineryInUseService;

  @Autowired LoadingDelayService loadingDelayService;

  @Autowired LoadingBerthService loadingBerthService;

  /**
   * Loading Information Is the First page in Loading module (UI).
   *
   * <p>Some data are parse at gateway service, some from LS Service.
   *
   * <p>A large JSON response needed based on the UI layout. Total 8 object counted Till - 20/05/21
   * Discussion (IT CAN CHANGE BASED ON REQUIREMENT)
   *
   * @param request - GRPC Request From Proto
   * @param responseObserver - Builder Response for GRPC Request
   */
  @Override
  public void getLoadingInformation(
      LoadingPlanModels.LoadingInformationRequest request,
      StreamObserver<LoadingPlanModels.LoadingInformation> responseObserver) {
    LoadingPlanModels.LoadingInformation.Builder builder =
        LoadingPlanModels.LoadingInformation.newBuilder();
    try {
      this.loadingInformationService.getLoadingInformation(request, builder);
    } catch (GenericServiceException e) {
      e.printStackTrace();
      builder.setResponseStatus(
          Common.ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage(e.getMessage())
              .setStatus(FAILED)
              .build());
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      responseObserver.onNext(builder.build());
      responseObserver.onCompleted();
    }
  }

  @Override
  public void getLoadigInformationByVoyage(
      LoadingInformationSynopticalRequest request,
      StreamObserver<LoadingInformationSynopticalReply> responseObserver) {
    LoadingInformationSynopticalReply.Builder builder =
        LoadingInformationSynopticalReply.newBuilder();
    log.info("Inside getLoadigInformationBySynoptical in LP MS");
    try {
      this.loadingInfoService.getLoadigInformationByVoyage(request, builder);
    } catch (GenericServiceException e) {
      log.info("GenericServiceException in getLoadigInformationBySynoptical at  LP MS ", e);
      builder.setResponseStatus(
          Common.ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage(e.getMessage())
              .setStatus(FAILED)
              .build());
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      responseObserver.onNext(builder.build());
      responseObserver.onCompleted();
    }
  }

  /**
   * Save For Loading Info Details
   *
   * @param request
   * @param responseObserver
   */
  @Override
  public void saveLoadingInformation(
      LoadingInformation request, StreamObserver<LoadingInfoSaveResponse> responseObserver) {
    LoadingInfoSaveResponse.Builder builder = LoadingInfoSaveResponse.newBuilder();
    try {
      com.cpdss.loadingplan.entity.LoadingInformation response =
          this.loadingInformationService.saveLoadingInformation(request);
      buildLoadingInfoSaveResponse(builder, response);
      builder
          .setResponseStatus(
              ResponseStatus.newBuilder()
                  .setMessage("Successfully saved Loading information")
                  .setStatus(SUCCESS)
                  .build())
          .build();
      log.info("Save Loading Info, Details Id {}", request.getLoadingInfoId());
    } catch (Exception e) {
      log.error(
          "Exception occured while saving Loading Information for id {}",
          request.getLoadingDetail().getId());
      e.printStackTrace();
      builder
          .setResponseStatus(
              ResponseStatus.newBuilder()
                  .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
                  .setMessage(e.getMessage())
                  .setStatus(FAILED)
                  .build())
          .build();
    } finally {
      responseObserver.onNext(builder.build());
      responseObserver.onCompleted();
    }
  }

  /**
   * Save For Loading Info Rates
   *
   * @param request
   * @param responseObserver
   */
  @Override
  public void saveLoadingInfoRates(
      LoadingInformation request, StreamObserver<LoadingInfoSaveResponse> responseObserver) {
    LoadingInfoSaveResponse.Builder builder = LoadingInfoSaveResponse.newBuilder();
    try {
      Optional<com.cpdss.loadingplan.entity.LoadingInformation> loadingInformation =
          loadingInformationService.getLoadingInformation(request.getLoadingInfoId());
      log.info("Save Loading Info, Rates Id {}", request.getLoadingInfoId());
      if (loadingInformation.isPresent()) {
        loadingInformationService.saveLoadingInfoRates(
            request.getLoadingRate(), loadingInformation.get(), builder);
      }
      buildLoadingInfoSaveResponse(builder, loadingInformation.get());
      builder
          .setResponseStatus(
              ResponseStatus.newBuilder()
                  .setMessage("Successfully saved Loading information Rates")
                  .setStatus(SUCCESS)
                  .build())
          .build();
    } catch (Exception e) {
      e.printStackTrace();
      builder
          .setResponseStatus(
              ResponseStatus.newBuilder().setMessage(e.getMessage()).setStatus(FAILED).build())
          .build();
    } finally {
      responseObserver.onNext(builder.build());
      responseObserver.onCompleted();
    }
  }

  /**
   * Save For Loading Info Stages
   *
   * @param request
   * @param responseObserver
   */
  @Override
  public void saveLoadingInfoStages(
      LoadingInformation request, StreamObserver<LoadingInfoSaveResponse> responseObserver) {
    LoadingInfoSaveResponse.Builder builder = LoadingInfoSaveResponse.newBuilder();
    try {
      Optional<com.cpdss.loadingplan.entity.LoadingInformation> loadingInformation =
          loadingInformationService.getLoadingInformation(request.getLoadingInfoId());
      log.info("Save Loading Info, Stages Id {}", request.getLoadingInfoId());
      if (loadingInformation.isPresent()) {
        loadingInformationService.saveLoadingInfoStages(
            request.getLoadingStage(), loadingInformation.get());
      }
      buildLoadingInfoSaveResponse(builder, loadingInformation.get());
      builder
          .setResponseStatus(
              ResponseStatus.newBuilder()
                  .setMessage("Successfully saved Loading information Stages")
                  .setStatus(SUCCESS)
                  .build())
          .build();
    } catch (Exception e) {
      e.printStackTrace();
      builder
          .setResponseStatus(
              ResponseStatus.newBuilder().setMessage(e.getMessage()).setStatus(FAILED).build())
          .build();
    } finally {
      responseObserver.onNext(builder.build());
      responseObserver.onCompleted();
    }
  }

  /**
   * Save For Loading Info Berth List
   *
   * @param request
   * @param responseObserver
   */
  @Override
  public void saveLoadingInfoBerths(
      LoadingInformation request, StreamObserver<LoadingInfoSaveResponse> responseObserver) {
    LoadingInfoSaveResponse.Builder builder = LoadingInfoSaveResponse.newBuilder();
    try {
      Optional<com.cpdss.loadingplan.entity.LoadingInformation> loadingInformation =
          loadingInformationService.getLoadingInformation(request.getLoadingInfoId());
      log.info("Save Loading Info, Berths Id {}", request.getLoadingInfoId());
      if (loadingInformation.isPresent()) {
        loadingBerthService.saveLoadingBerthList(
            request.getLoadingBerthsList(), loadingInformation.get());
      }
      buildLoadingInfoSaveResponse(builder, loadingInformation.get());
      builder
          .setResponseStatus(
              ResponseStatus.newBuilder()
                  .setMessage("Successfully saved Loading information Berths")
                  .setStatus(SUCCESS)
                  .build())
          .build();
    } catch (Exception e) {
      e.printStackTrace();
      builder
          .setResponseStatus(
              ResponseStatus.newBuilder().setMessage(e.getMessage()).setStatus(FAILED).build())
          .build();
    } finally {
      responseObserver.onNext(builder.build());
      responseObserver.onCompleted();
    }
  }

  /**
   * Save For Loading Info Machinery List
   *
   * @param request
   * @param responseObserver
   */
  @Override
  public void saveLoadingInfoMachinery(
      LoadingInformation request, StreamObserver<LoadingInfoSaveResponse> responseObserver) {
    LoadingInfoSaveResponse.Builder builder = LoadingInfoSaveResponse.newBuilder();
    try {
      Optional<com.cpdss.loadingplan.entity.LoadingInformation> loadingInformation =
          loadingInformationService.getLoadingInformation(request.getLoadingInfoId());
      log.info("Save Loading Info, Machines Id {}", request.getLoadingInfoId());
      log.info("Request payload {}", Utils.toJson(request));
      if (loadingInformation.isPresent()) {
        loadingMachineryInUseService.saveLoadingMachineryList(
            request.getLoadingMachinesList(), loadingInformation.get());
      }
      buildLoadingInfoSaveResponse(builder, loadingInformation.get());
      builder
          .setResponseStatus(
              ResponseStatus.newBuilder()
                  .setMessage("Successfully saved Loading information Machinery")
                  .setStatus(SUCCESS)
                  .build())
          .build();
    } catch (Exception e) {
      e.printStackTrace();
      builder
          .setResponseStatus(
              ResponseStatus.newBuilder().setMessage(e.getMessage()).setStatus(FAILED).build())
          .build();
    } finally {
      responseObserver.onNext(builder.build());
      responseObserver.onCompleted();
    }
  }

  /**
   * Save For Loading Info Delay List
   *
   * @param request
   * @param responseObserver
   */
  @Override
  public void saveLoadingInfoDelays(
      LoadingInformation request, StreamObserver<LoadingInfoSaveResponse> responseObserver) {
    LoadingInfoSaveResponse.Builder builder = LoadingInfoSaveResponse.newBuilder();
    try {
      Optional<com.cpdss.loadingplan.entity.LoadingInformation> loadingInformation =
          loadingInformationService.getLoadingInformation(request.getLoadingInfoId());
      log.info("Save Loading Info, Delays Id {}", request.getLoadingInfoId());
      if (loadingInformation.isPresent()) {
        loadingDelayService.saveLoadingDelayList(
            request.getLoadingDelays(), loadingInformation.get());
      }
      buildLoadingInfoSaveResponse(builder, loadingInformation.get());
      builder
          .setResponseStatus(
              ResponseStatus.newBuilder()
                  .setMessage("Successfully saved Loading information Delays")
                  .setStatus(SUCCESS)
                  .build())
          .build();
    } catch (Exception e) {
      e.printStackTrace();
      builder
          .setResponseStatus(
              ResponseStatus.newBuilder().setMessage(e.getMessage()).setStatus(FAILED).build())
          .build();
    } finally {
      responseObserver.onNext(builder.build());
      responseObserver.onCompleted();
    }
  }

  private void buildLoadingInfoSaveResponse(
      Builder builder, com.cpdss.loadingplan.entity.LoadingInformation response) {
    Optional.ofNullable(response.getId()).ifPresent(builder::setLoadingInfoId);
    Optional.ofNullable(response.getPortRotationXId()).ifPresent(builder::setPortRotationId);
    Optional.ofNullable(response.getSynopticalTableXId()).ifPresent(builder::setLoadingInfoId);
    Optional.ofNullable(response.getVesselXId()).ifPresent(builder::setVesselId);
    Optional.ofNullable(response.getVoyageId()).ifPresent(builder::setVoyageId);
  }

  @Override
  public void updateUllage(
      LoadingPlanModels.UpdateUllageLoadingRequest request,
      StreamObserver<LoadingPlanModels.UpdateUllageLoadingReplay> responseObserver) {
    LoadingPlanModels.UpdateUllageLoadingReplay.Builder builder =
        LoadingPlanModels.UpdateUllageLoadingReplay.newBuilder();
    try {
      this.toppingOffSequenceService.updateUllageFromLsAlgo(request, builder);
    } catch (GenericServiceException e) {
      e.printStackTrace();
      builder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setStatus(FAILED)
              .setMessage(e.getMessage())
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .build());
    } catch (Exception e) {
      e.printStackTrace();
      builder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setStatus(FAILED)
              .setMessage(e.getMessage())
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .build());
    } finally {
      responseObserver.onNext(builder.build());
      responseObserver.onCompleted();
    }
  }

  @Override
  public void generateLoadingPlan(
      LoadingInfoAlgoRequest request, StreamObserver<ResponseStatus> responseObserver) {
    log.info("Inside generateLoadingPlan in LP MS");
    ResponseStatus.Builder builder = ResponseStatus.newBuilder();
    try {
      this.loadingInfoAlgoService.generateLoadingPlan(request);
      builder.setStatus(SUCCESS);
    } catch (GenericServiceException e) {
      log.info("GenericServiceException in generateLoadingPlan at LP MS ", e);
      builder
          .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
          .setMessage(e.getMessage())
          .setStatus(FAILED);
    } catch (Exception e) {
      e.printStackTrace();
      log.info("GenericServiceException in generateLoadingPlan at LP MS ", e);
      builder
          .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
          .setMessage(e.getMessage())
          .setStatus(FAILED);
    } finally {
      responseObserver.onNext(builder.build());
      responseObserver.onCompleted();
    }
  }
}
