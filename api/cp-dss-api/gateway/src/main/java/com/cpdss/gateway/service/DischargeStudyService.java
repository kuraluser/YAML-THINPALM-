/* Licensed at AlphaOri Technologies */
package com.cpdss.gateway.service;

import com.cpdss.common.exception.GenericServiceException;
import com.cpdss.common.generated.LoadableStudy;
import com.cpdss.common.generated.LoadableStudyServiceGrpc;
import com.cpdss.common.generated.dischargestudy.DischargeStudyServiceGrpc.DischargeStudyServiceBlockingStub;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformationSynopticalReply;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformationSynopticalRequest;
import com.cpdss.common.rest.CommonErrorCodes;
import com.cpdss.common.rest.CommonSuccessResponse;
import com.cpdss.common.utils.HttpStatusCode;
import com.cpdss.gateway.domain.BillOfLadding;
import com.cpdss.gateway.domain.DischargeStudyResponse;
import java.util.ArrayList;
import lombok.extern.log4j.Log4j2;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/** @Author jerin.g */
@Log4j2
@Service
public class DischargeStudyService {

  @GrpcClient("dischargeStudyService")
  private DischargeStudyServiceBlockingStub dischargeStudyGrpcService;

  @GrpcClient("loadableStudyService")
  private LoadableStudyServiceGrpc.LoadableStudyServiceBlockingStub
      loadableStudyServiceBlockingStub;

  private static final String SUCCESS = "SUCCESS";

  /**
   * @param vesselId
   * @param voyageId
   * @param dischargeStudyId
   * @param synopticalId
   * @param correlationId
   * @return LoadableStudyResponse
   */
  public DischargeStudyResponse getDischargeStudyByVoyage(
      Long vesselId, Long voyageId, Long dischargeStudyId, Long synopticalId, String correlationId)
      throws GenericServiceException {
    log.info(
        "Inside getDischargeStudyByVoyage gateway service with correlationId : " + correlationId);
    LoadableStudy.LoadableStudyRequest.Builder loadableStudyRequest =
        LoadableStudy.LoadableStudyRequest.newBuilder();
    loadableStudyRequest.setVoyageId(voyageId);
    LoadableStudy.LoadablePatternConfirmedReply patternReply =
        loadableStudyServiceBlockingStub.getLoadablePatternByVoyageAndStatus(
            loadableStudyRequest.build());
    if (patternReply != null
        && patternReply.getResponseStatus() != null
        && SUCCESS.equalsIgnoreCase(patternReply.getResponseStatus().getStatus())) {
      LoadingInformationSynopticalRequest.Builder requestBuilder =
          LoadingInformationSynopticalRequest.newBuilder();
      requestBuilder.setLoadablePatternId(patternReply.getPattern().getLoadablePatternId());
      LoadingInformationSynopticalReply grpcReply =
          this.getDischargeStudyByVoyage(requestBuilder.build());
      if (!SUCCESS.equals(grpcReply.getResponseStatus().getStatus())) {
        throw new GenericServiceException(
            "Failed to fetch getDischargeStudyByVoyage",
            grpcReply.getResponseStatus().getCode(),
            HttpStatusCode.valueOf(Integer.valueOf(grpcReply.getResponseStatus().getCode())));
      }
      DischargeStudyResponse dischargeStudyResponse = new DischargeStudyResponse();
      dischargeStudyResponse.setResponseStatus(
          new CommonSuccessResponse(String.valueOf(HttpStatus.OK.value()), correlationId));
      return buildDischargeStudyResponse(grpcReply, dischargeStudyResponse);

    } else {
      throw new GenericServiceException(
          "Error in calling loadablestudy service",
          CommonErrorCodes.E_GEN_INTERNAL_ERR,
          HttpStatusCode.INTERNAL_SERVER_ERROR);
    }
  }

  private DischargeStudyResponse buildDischargeStudyResponse(
      LoadingInformationSynopticalReply grpcReply, DischargeStudyResponse dischargeStudyResponse) {
    ModelMapper modelMapper = new ModelMapper();

    dischargeStudyResponse.setBillOfLaddings(new ArrayList<>());
    grpcReply
        .getBillOfLaddingList()
        .forEach(
            billOfLadding -> {
              BillOfLadding blfigure = new BillOfLadding();
              blfigure =
                  modelMapper.map(billOfLadding, com.cpdss.gateway.domain.BillOfLadding.class);
              dischargeStudyResponse.getBillOfLaddings().add(blfigure);
            });
    return dischargeStudyResponse;
  }

  public LoadingInformationSynopticalReply getDischargeStudyByVoyage(
      LoadingInformationSynopticalRequest request) {
    return this.dischargeStudyGrpcService.getDischargeStudyByVoyage(request);
  }
}
