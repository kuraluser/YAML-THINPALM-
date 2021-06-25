/* Licensed at AlphaOri Technologies */
package com.cpdss.loadingplan.service.grpc;

import static com.cpdss.loadingplan.common.LoadingPlanConstants.*;

import com.cpdss.common.exception.GenericServiceException;
import com.cpdss.common.generated.Common;
import com.cpdss.common.generated.Common.ResponseStatus;
import com.cpdss.common.generated.loading_plan.LoadingInformationServiceGrpc;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoAlgoRequest;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformationSynopticalReply;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformationSynopticalRequest;
import com.cpdss.common.rest.CommonErrorCodes;
import com.cpdss.loadingplan.service.CargoToppingOffSequenceService;
import com.cpdss.loadingplan.service.LoadingInformationService;
import com.cpdss.loadingplan.service.algo.LoadingInformationAlgoService;
import com.cpdss.loadingplan.service.impl.LoadingInformationDischargeService;
import io.grpc.stub.StreamObserver;
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
  public void getLoadigInformationBySynoptical(
      LoadingInformationSynopticalRequest request,
      StreamObserver<LoadingInformationSynopticalReply> responseObserver) {
    LoadingInformationSynopticalReply.Builder builder =
        LoadingInformationSynopticalReply.newBuilder();
    log.info("Inside getLoadigInformationBySynoptical in LP MS");
    try {
      this.loadingInfoService.getLoadigInformationBySynoptical(request, builder);
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

  @Override
  public void saveLoadingInformation(
      LoadingInformation request, StreamObserver<ResponseStatus> responseObserver) {
    ResponseStatus.Builder builder = ResponseStatus.newBuilder();
    try {
      log.info("Saving Loading Information for id {}", request.getLoadingDetail().getId());
      this.loadingInformationService.saveLoadingInformation(request);
      builder.setMessage("Successfully saved Loading information").setStatus(SUCCESS).build();
    } catch (Exception e) {
      log.error(
          "Exception occured while saving Loading Information for id {}",
          request.getLoadingDetail().getId());
      e.printStackTrace();
      builder
          .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
          .setMessage(e.getMessage())
          .setStatus(FAILED)
          .build();
    } finally {
      responseObserver.onNext(builder.build());
      responseObserver.onCompleted();
    }
  }

  @Override
  public void updateUllage(
      LoadingPlanModels.UpdateUllageLoadingRequest request,
      StreamObserver<LoadingPlanModels.UpdateUllageLoadingReplay> responseObserver) {
    LoadingPlanModels.UpdateUllageLoadingReplay.Builder builder =
        LoadingPlanModels.UpdateUllageLoadingReplay.newBuilder();
    try {
      this.toppingOffSequenceService.updateUllageFromLsAlgo(request, builder.build());
    } catch (GenericServiceException e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
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
