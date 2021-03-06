/* Licensed at AlphaOri Technologies */
package com.cpdss.gateway.service.loadingplan;

import com.cpdss.common.exception.GenericServiceException;
import com.cpdss.common.generated.Common;
import com.cpdss.common.generated.Common.ResponseStatus;
import com.cpdss.common.generated.LoadableStudy;
import com.cpdss.common.generated.LoadableStudy.AlgoErrorReply;
import com.cpdss.common.generated.LoadableStudy.AlgoErrorRequest;
import com.cpdss.common.generated.LoadableStudy.JsonRequest;
import com.cpdss.common.generated.LoadableStudy.StatusReply;
import com.cpdss.common.generated.PortInfo;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoAlgoReply;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoSaveResponse;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoStatusReply;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoStatusRequest;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanSaveRequest;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanSaveResponse;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingSequenceReply;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingSequenceRequest.Builder;
import com.cpdss.gateway.domain.DischargeQuantityCargoDetails;
import com.cpdss.gateway.domain.RuleResponse;
import com.cpdss.gateway.domain.UllageBillReply;
import com.cpdss.gateway.domain.loadingplan.CargoVesselTankDetails;
import com.cpdss.gateway.domain.voyage.VoyageResponse;
import java.util.List;

public interface LoadingPlanGrpcService {

  VoyageResponse getActiveVoyageDetails(Long vesselId) throws GenericServiceException;

  Object getPortRotationDetailsForActiveVoyage(Long vesselId);

  LoadableStudy.LoadingSynopticResponse fetchSynopticRecordForPortRotation(
      Long portRId, String operationType) throws GenericServiceException;

  PortInfo.PortDetail fetchPortDetailByPortId(Long portId) throws GenericServiceException;

  LoadingPlanModels.LoadingInformation fetchLoadingInformation(
      Long vesselId, Long voyageId, Long loadingInfoId, Long patternId, Long portRotationId)
      throws GenericServiceException;

  CargoVesselTankDetails fetchPortWiseCargoDetails(
      Long vesselId,
      Long voyageId,
      Long loadableStudyId,
      Long portId,
      Long portOrder,
      Long portRotationId,
      String operationType);

  List<LoadableStudy.LoadableQuantityCargoDetails> fetchLoadablePlanCargoDetails(
      Long patternId,
      String operationType,
      Long portRotationId,
      Long portId,
      Boolean isFilterOn,
      Common.PLANNING_TYPE planning_type,
      Long dischargeInfoId);

  LoadableStudy.LoadingPlanCommonResponse fetchLoadablePlanCargoDetailsReplay(
      Long patternId,
      String operationType,
      Long portRotationId,
      Long portId,
      Boolean isFilterOn,
      Common.PLANNING_TYPE planning_type,
      Long loadingInfoId);

  List<LoadableStudy.LoadablePlanBallastDetails> fetchLoadablePlanBallastDetails(
      Long patternId, Long portRotationId);

  LoadingInfoSaveResponse saveLoadingInformation(LoadingInformation loadingInformation);

  Boolean updateUllageAtLoadingPlan(LoadingPlanModels.UpdateUllageLoadingRequest request)
      throws GenericServiceException;

  LoadingInfoAlgoReply generateLoadingPlan(Long loadingInfoId);

  RuleResponse saveOrGetLoadingPlanRules(LoadingPlanModels.LoadingPlanRuleRequest.Builder builder)
      throws GenericServiceException;

  LoadingSequenceReply getLoadingSequence(Builder builder) throws GenericServiceException;

  LoadingPlanSaveResponse saveLoadingPlan(LoadingPlanSaveRequest request);

  LoadingPlanModels.LoadingPlanReply getLoadingPlan(
      Long vesselId, Long voyageId, Long loadingInfoId, Long patternId, Long portRotationId)
      throws GenericServiceException;

  UllageBillReply getLoadableStudyShoreTwo(
      String first, LoadingPlanModels.UllageBillRequest.Builder inputData)
      throws GenericServiceException;

  StatusReply saveJson(JsonRequest jsonRequest);

  LoadingPlanModels.UpdateUllageDetailsResponse getUpdateUllageDetails(
      LoadingPlanModels.UpdateUllageDetailsRequest.Builder builder) throws GenericServiceException;

  /**
   * Fetches ALGO status of Loading Information
   *
   * @param vesselId
   * @param voyageId
   * @param infoId
   * @return
   */
  LoadingInfoStatusReply getLoadingInfoAlgoStatus(LoadingInfoStatusRequest request);

  /**
   * @param build
   * @return
   */
  AlgoErrorReply getLoadingInfoAlgoErrors(AlgoErrorRequest request);

  ResponseStatus updateDischargeQuantityCargoDetails(List<DischargeQuantityCargoDetails> list);
}
