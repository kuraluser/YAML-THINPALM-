/* Licensed at AlphaOri Technologies */
package com.cpdss.gateway.service.dischargeplan;

import static com.cpdss.gateway.common.GatewayConstants.DISCHARGING_RULE_MASTER_ID;

import com.cpdss.common.exception.GenericServiceException;
import com.cpdss.common.generated.discharge_plan.DischargeInformation;
import com.cpdss.common.generated.discharge_plan.DischargeInformationRequest;
import com.cpdss.common.generated.discharge_plan.DischargeInformationServiceGrpc;
import com.cpdss.common.generated.discharge_plan.DischargeRuleReply;
import com.cpdss.common.generated.discharge_plan.DischargeRuleRequest;
import com.cpdss.common.generated.discharge_plan.DischargingDownloadTideDetailRequest;
import com.cpdss.common.generated.discharge_plan.DischargingDownloadTideDetailStatusReply;
import com.cpdss.common.generated.discharge_plan.DischargingUploadTideDetailRequest;
import com.cpdss.common.generated.discharge_plan.DischargingUploadTideDetailStatusReply;
import com.cpdss.common.rest.CommonErrorCodes;
import com.cpdss.common.rest.CommonSuccessResponse;
import com.cpdss.common.utils.HttpStatusCode;
import com.cpdss.gateway.domain.RuleRequest;
import com.cpdss.gateway.domain.RuleResponse;
import com.cpdss.gateway.domain.UploadTideDetailResponse;
import com.cpdss.gateway.utility.RuleUtility;
import com.google.protobuf.ByteString;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
public class DischargeInformationGrpcService {

  @GrpcClient("dischargeInformationService")
  DischargeInformationServiceGrpc.DischargeInformationServiceBlockingStub dischargeInfoServiceStub;

  private static final String SUCCESS = "SUCCESS";

  public DischargeInformation getDischargeInfoRpc(Long vesselId, Long voyageId, Long portRotationId)
      throws GenericServiceException {

    DischargeInformationRequest.Builder reqBuilder = DischargeInformationRequest.newBuilder();
    reqBuilder.setVoyageId(voyageId);
    reqBuilder.setVesselId(vesselId);
    reqBuilder.setPortRotationId(portRotationId);
    DischargeInformation rpcReplay =
        this.dischargeInfoServiceStub.getDischargeInformation(reqBuilder.build());
    if (!rpcReplay.getResponseStatus().getStatus().equals(SUCCESS)) {
      log.error(
          "Failed to get discharge plan from discharge-plan Service, vessel id {}, voyage id {}, port r Id {}",
          vesselId,
          voyageId,
          portRotationId);
      throw new GenericServiceException(
          "Failed to fetch discharge plan",
          CommonErrorCodes.E_HTTP_BAD_REQUEST,
          HttpStatusCode.BAD_REQUEST);
    }
    return rpcReplay;
  }

  public RuleResponse getOrSaveRulesForDischarge(
      Long vesselId,
      Long dischargeStudyId,
      RuleRequest dischargeStudyRuleRequest,
      String correlationId)
      throws GenericServiceException {
    DischargeRuleRequest.Builder dischargeStudyRuleRequestBuilder =
        DischargeRuleRequest.newBuilder();
    dischargeStudyRuleRequestBuilder.setVesselId(vesselId);
    dischargeStudyRuleRequestBuilder.setSectionId(DISCHARGING_RULE_MASTER_ID);
    dischargeStudyRuleRequestBuilder.setDischargeInfoId(dischargeStudyId);
    RuleUtility.buildRuleListForSaveDischargeStudy(
        dischargeStudyRuleRequest, null, dischargeStudyRuleRequestBuilder, null, false, false);
    DischargeRuleReply dischargeStudyRuleReply =
        dischargeInfoServiceStub.getOrSaveRulesForDischarging(
            dischargeStudyRuleRequestBuilder.build());
    if (!SUCCESS.equals(dischargeStudyRuleReply.getResponseStatus().getStatus())) {
      throw new GenericServiceException(
          "failed to get discharge rules ",
          dischargeStudyRuleReply.getResponseStatus().getCode(),
          HttpStatusCode.valueOf(
              Integer.valueOf(dischargeStudyRuleReply.getResponseStatus().getCode())));
    }
    RuleResponse ruleResponse = new RuleResponse();
    ruleResponse.setPlan(RuleUtility.buildDischargeRulePlan(dischargeStudyRuleReply));
    ruleResponse.setResponseStatus(
        new CommonSuccessResponse(String.valueOf(HttpStatus.OK.value()), correlationId));
    return ruleResponse;
  }

  public UploadTideDetailResponse dischargeUploadLoadingTideDetails(
      Long loadingId, MultipartFile file, String correlationId, String portName, Long portId)
      throws IOException, GenericServiceException {
    String originalFileName = file.getOriginalFilename() == null ? "" : file.getOriginalFilename();
    if (!(originalFileName.substring(originalFileName.lastIndexOf(".") + 1).toLowerCase())
        .equals("xlsx")) {
      throw new GenericServiceException(
          "unsupported file type",
          CommonErrorCodes.E_CPDSS_INVALID_EXCEL_FILE,
          HttpStatusCode.BAD_REQUEST);
    }
    com.cpdss.common.generated.discharge_plan.DischargingUploadTideDetailRequest.Builder builder =
        DischargingUploadTideDetailRequest.newBuilder();
    builder.setTideDetaildata(ByteString.copyFrom(file.getBytes()));
    builder.setLoadingId(loadingId);
    builder.setPortId(portId);
    builder.setPortName(portName);
    DischargingUploadTideDetailStatusReply statusReply =
        dischargeInfoServiceStub.dischargingUploadPortTideDetails(builder.build());
    if (!SUCCESS.equals(statusReply.getResponseStatus().getStatus())) {
      throw new GenericServiceException(
          statusReply.getResponseStatus().getMessage(),
          statusReply.getResponseStatus().getCode(),
          HttpStatusCode.valueOf(statusReply.getResponseStatus().getHttpStatusCode()));
    }
    UploadTideDetailResponse response = new UploadTideDetailResponse();
    response.setResponseStatus(
        new CommonSuccessResponse(String.valueOf(HttpStatus.OK.value()), correlationId));
    return response;
  }

  public byte[] downloadLoadingPortTideDetails(Long dischargingId) throws GenericServiceException {

    com.cpdss.common.generated.discharge_plan.DischargingDownloadTideDetailRequest.Builder builder =
        DischargingDownloadTideDetailRequest.newBuilder();
    builder.setLoadingId(dischargingId);
    DischargingDownloadTideDetailStatusReply statusReply =
        dischargeInfoServiceStub.dischargingDownloadPortTideDetails(builder.build()).next();
    if (!SUCCESS.equals(statusReply.getResponseStatus().getStatus())) {
      throw new GenericServiceException(
          statusReply.getResponseStatus().getMessage(),
          statusReply.getResponseStatus().getCode(),
          HttpStatusCode.valueOf(statusReply.getResponseStatus().getHttpStatusCode()));
    }
    return statusReply.getData().toByteArray();
  }

  public RuleResponse saveOrGetDischargingPlanRules(DischargeRuleRequest.Builder builder)
      throws GenericServiceException {
    RuleResponse ruleResponse = new RuleResponse();
    DischargeRuleReply dischargingRuleReply =
        this.dischargeInfoServiceStub.getOrSaveRulesForDischarging(builder.build());
    log.info("Discharging rules retrieved : {}", dischargingRuleReply.getRulePlanCount());
    if (!dischargingRuleReply.getResponseStatus().getStatus().equals(SUCCESS)) {
      throw new GenericServiceException(
          "Failed to save discharging plan rules",
          dischargingRuleReply.getResponseStatus().getCode(),
          HttpStatusCode.valueOf(
              Integer.valueOf(dischargingRuleReply.getResponseStatus().getCode())));
    }
    ruleResponse.setPlan(RuleUtility.buildDischargeRulePlan(dischargingRuleReply));
    ruleResponse.setResponseStatus(
        new CommonSuccessResponse(String.valueOf(HttpStatus.OK.value()), null));
    return ruleResponse;
  }
}
