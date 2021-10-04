/* Licensed at AlphaOri Technologies */
package com.cpdss.dischargeplan.service.grpc;

import static com.cpdss.dischargeplan.common.DischargePlanConstants.FAILED;
import static com.cpdss.dischargeplan.common.DischargePlanConstants.SUCCESS;

import com.cpdss.common.exception.GenericServiceException;
import com.cpdss.common.generated.Common;
import com.cpdss.common.generated.Common.ResponseStatus;
import com.cpdss.common.generated.discharge_plan.DischargeInformationRequest;
import com.cpdss.common.generated.discharge_plan.DischargePlanServiceGrpc;
import com.cpdss.common.generated.discharge_plan.DischargeStudyDataTransferRequest;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels.UllageBillReply;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels.UllageBillRequest;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels.UpdateUllageDetailsRequest;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels.UpdateUllageDetailsResponse;
import com.cpdss.common.rest.CommonErrorCodes;
import com.cpdss.common.utils.Utils;
import com.cpdss.dischargeplan.common.DischargePlanConstants;
import com.cpdss.dischargeplan.entity.BillOfLadding;
import com.cpdss.dischargeplan.entity.DischargePlanCommingleDetails;
import com.cpdss.dischargeplan.entity.PortDischargingPlanBallastDetails;
import com.cpdss.dischargeplan.entity.PortDischargingPlanBallastTempDetails;
import com.cpdss.dischargeplan.entity.PortDischargingPlanRobDetails;
import com.cpdss.dischargeplan.entity.PortDischargingPlanStowageDetails;
import com.cpdss.dischargeplan.entity.PortDischargingPlanStowageTempDetails;
import com.cpdss.dischargeplan.repository.BillOfLaddingRepository;
import com.cpdss.dischargeplan.repository.DischargePlanCommingleDetailsRepository;
import com.cpdss.dischargeplan.repository.PortDischargingPlanBallastDetailsRepository;
import com.cpdss.dischargeplan.repository.PortDischargingPlanBallastTempDetailsRepository;
import com.cpdss.dischargeplan.repository.PortDischargingPlanRobDetailsRepository;
import com.cpdss.dischargeplan.repository.PortDischargingPlanStabilityParametersRepository;
import com.cpdss.dischargeplan.repository.PortDischargingPlanStowageDetailsRepository;
import com.cpdss.dischargeplan.repository.PortDischargingPlanStowageTempDetailsRepository;
import com.cpdss.dischargeplan.service.DischargeInformationService;
import com.cpdss.dischargeplan.service.DischargePlanAlgoService;
import com.cpdss.dischargeplan.service.DischargePlanSynchronizeService;
import com.cpdss.dischargeplan.service.DischargeUllageServiceUtils;
import com.cpdss.dischargeplan.service.loadicator.UllageUpdateLoadicatorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.grpc.stub.StreamObserver;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Slf4j
@GrpcService
@Transactional
public class DischargePlanRPCService extends DischargePlanServiceGrpc.DischargePlanServiceImplBase {

  @Autowired DischargePlanSynchronizeService dischargePlanSynchronizeService;

  @Autowired DischargePlanAlgoService dischargePlanAlgoService;
  @Autowired PortDischargingPlanBallastDetailsRepository pdpBallastDetailsRepository;
  @Autowired PortDischargingPlanStowageDetailsRepository pdpStowageDetailsRepository;
  @Autowired PortDischargingPlanRobDetailsRepository pdpRobDetailsRepository;
  @Autowired PortDischargingPlanStabilityParametersRepository pdpStabilityParametersRepository;
  @Autowired BillOfLaddingRepository billOfLaddingRepo;
  @Autowired DischargeInformationService dischargeInformationService;

  @Autowired
  PortDischargingPlanStowageTempDetailsRepository portLoadingPlanStowageTempDetailsRepository;

  @Autowired
  PortDischargingPlanBallastTempDetailsRepository portLoadingPlanBallastTempDetailsRepository;

  @Autowired DischargePlanCommingleDetailsRepository loadablePlanCommingleDetailsRepository;
  @Autowired UllageUpdateLoadicatorService ullageUpdateLoadicatorService;

  @Override
  public void dischargePlanSynchronization(
      DischargeStudyDataTransferRequest request, StreamObserver<ResponseStatus> responseObserver) {
    ResponseStatus.Builder response = ResponseStatus.newBuilder();
    try {
      this.dischargePlanSynchronizeService.saveDischargeInformation(
          request); // Create new Discharge Information
      if (!request.getPortDataList().isEmpty()) {
        this.dischargePlanSynchronizeService.saveCowDetailsForDischargeStudy(
            request); // Save Cow Plan per/discharge-info
      }
      response.setStatus(SUCCESS);
      response.setMessage(SUCCESS);
    } catch (Exception e) {

      TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
      e.printStackTrace();
      e.printStackTrace();
      response
          .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
          .setMessage(e.getMessage())
          .setStatus(FAILED)
          .build();
    } finally {
      log.info("Exiting GRPC method");
      responseObserver.onNext(response.build());
      responseObserver.onCompleted();
    }
  }

  @Override
  public void generateDischargePlan(
      DischargeInformationRequest request,
      StreamObserver<com.cpdss.common.generated.discharge_plan.DischargePlanAlgoRequest>
          responseObserver) {
    com.cpdss.common.generated.discharge_plan.DischargePlanAlgoRequest.Builder builder =
        com.cpdss.common.generated.discharge_plan.DischargePlanAlgoRequest.newBuilder();
    com.cpdss.dischargeplan.domain.DischargeInformationAlgoRequest algoRequest =
        new com.cpdss.dischargeplan.domain.DischargeInformationAlgoRequest();
    try {
      log.info("Generate Discharge Plan RPC: Payload", Utils.toJson(request));

      // build DTO object
      this.dischargePlanAlgoService.buildDischargeInformation(request, algoRequest);

      // Save Above JSON In LS json data Table
      ObjectMapper objectMapper = new ObjectMapper();
      String ss = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(algoRequest);
      builder.setRequestAsJsonString(ss);
      log.info("algo request payload - {}", ss);

      // Call To Algo End Point for Loading

      // Set Loading Status

    } catch (Exception e) {
      e.printStackTrace();
      builder.setResponseStatus(
          Common.ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage(e.getMessage())
              .setStatus(DischargePlanConstants.FAILED)
              .build());
    } finally {
      responseObserver.onNext(builder.build());
      responseObserver.onCompleted();
    }
  }

  @Override
  public void getDischargeUpdateUllageDetails(
      UpdateUllageDetailsRequest request,
      StreamObserver<UpdateUllageDetailsResponse> responseObserver) {
    log.info("Inside get Update Ullage details");
    UpdateUllageDetailsResponse.Builder builder = UpdateUllageDetailsResponse.newBuilder();
    try {
      getBillOfLaddingDetails(request, builder);
      getPortWiseStowageDetails(request, builder);
      getPortWiseBallastDetails(request, builder);
      getPortWiseRobDetails(request, builder);
      getPortWiseStowageTempDetails(request, builder);
      getPortWiseBallastTempDetails(request, builder);
      getPortWiseCommingleDetails(request, builder);
    } catch (Exception e) {
      log.error("Exception when saveLoadingPlan microservice is called", e);

    } finally {
      responseObserver.onNext(builder.build());
      responseObserver.onCompleted();
    }
  }

  public void getBillOfLaddingDetails(
      UpdateUllageDetailsRequest request, UpdateUllageDetailsResponse.Builder builder) {

    List<BillOfLadding> billOfLaddingDetails =
        this.billOfLaddingRepo.findByDischargePatternXIdAndPortIdAndIsActive(
            request.getPatternId(), request.getPortId(), true);
    billOfLaddingDetails.stream()
        .forEach(
            bill -> {
              Common.BillOfLadding.Builder blBuilder = Common.BillOfLadding.newBuilder();
              blBuilder.setId(bill.getId());
              blBuilder.setBlRefNo(bill.getBlRefNo());
              blBuilder.setApi(bill.getApi() != null ? bill.getApi().toString() : "");
              blBuilder.setTemperature(
                  bill.getTemperature() != null ? bill.getTemperature().toString() : "");
              blBuilder.setCargoNominationId(bill.getCargoNominationId());
              blBuilder.setPortId(bill.getPortId());
              blBuilder.setQuantityMt(
                  bill.getQuantityMt() != null ? bill.getQuantityMt().toString() : "");
              blBuilder.setQuantityBbls(
                  bill.getQuantityMt() != null ? bill.getQuantityBbls().toString() : "");
              blBuilder.setQuantityKl(
                  bill.getQuantityMt() != null ? bill.getQuantityKl().toString() : "");
              blBuilder.setQuantityLT(
                  bill.getQuantityLT() != null ? bill.getQuantityLT().toString() : "");
              blBuilder.setCargoNominationId(bill.getCargoNominationId());
              builder.addBillOfLadding(blBuilder);
            });
  }

  public void getPortWiseStowageDetails(
      UpdateUllageDetailsRequest request, UpdateUllageDetailsResponse.Builder builder) {
    List<PortDischargingPlanStowageDetails> portWiseStowageDetails =
        pdpStowageDetailsRepository.findByPatternIdAndPortRotationIdAndIsActive(
            request.getPatternId(), request.getPortRotationId(), true);
    for (PortDischargingPlanStowageDetails portWiseStowageDetail : portWiseStowageDetails) {
      LoadingPlanModels.PortLoadablePlanStowageDetail.Builder newBuilder =
          LoadingPlanModels.PortLoadablePlanStowageDetail.newBuilder();
      newBuilder.setAbbreviation(
          portWiseStowageDetail.getAbbreviation() != null
              ? portWiseStowageDetail.getAbbreviation()
              : "");
      newBuilder.setApi(
          portWiseStowageDetail.getApi() != null ? portWiseStowageDetail.getApi().toString() : "");
      newBuilder.setCargoNominationId(portWiseStowageDetail.getCargoNominationXId());
      newBuilder.setColorCode(
          portWiseStowageDetail.getColorCode() != null ? portWiseStowageDetail.getColorCode() : "");
      newBuilder.setCorrectedUllage(
          portWiseStowageDetail.getCorrectedUllage() != null
              ? portWiseStowageDetail.getCorrectedUllage().toString()
              : "");
      newBuilder.setCorrectionFactor(
          portWiseStowageDetail.getCorrectionFactor() != null
              ? portWiseStowageDetail.getCorrectionFactor().toString()
              : "");
      newBuilder.setFillingPercentage(
          portWiseStowageDetail.getFillingPercentage() != null
              ? portWiseStowageDetail.getFillingPercentage().toString()
              : "");
      newBuilder.setId(portWiseStowageDetail.getId());
      newBuilder.setLoadablePatternId(request.getPatternId());
      newBuilder.setRdgUllage(
          portWiseStowageDetail.getRdgUllage() != null
              ? portWiseStowageDetail.getRdgUllage().toString()
              : "");
      newBuilder.setTankId(portWiseStowageDetail.getTankXId());
      newBuilder.setTemperature(
          portWiseStowageDetail.getTemperature() != null
              ? portWiseStowageDetail.getTemperature().toString()
              : "");
      newBuilder.setWeight(
          portWiseStowageDetail.getWeight() != null
              ? portWiseStowageDetail.getWeight().toString()
              : "");
      newBuilder.setQuantity(
          portWiseStowageDetail.getQuantity() != null
              ? portWiseStowageDetail.getQuantity().toString()
              : "");
      newBuilder.setActualPlanned(
          portWiseStowageDetail.getValueType() != null
              ? portWiseStowageDetail.getValueType().toString()
              : "");
      newBuilder.setArrivalDeparture(
          portWiseStowageDetail.getConditionType() != null
              ? portWiseStowageDetail.getConditionType().toString()
              : "");
      newBuilder.setUllage(
          portWiseStowageDetail.getUllage() != null
              ? portWiseStowageDetail.getUllage().toString()
              : "");
      builder.addPortLoadablePlanStowageDetails(newBuilder);
    }
  }

  public void getPortWiseBallastDetails(
      UpdateUllageDetailsRequest request, UpdateUllageDetailsResponse.Builder builder) {
    List<PortDischargingPlanBallastDetails> portWiseStowageDetails =
        pdpBallastDetailsRepository.findByPatternIdAndPortRotationIdAndIsActive(
            request.getPatternId(), request.getPortRotationId(), true);
    for (PortDischargingPlanBallastDetails portWiseBallastDetail : portWiseStowageDetails) {
      LoadingPlanModels.PortLoadingPlanBallastDetails.Builder newBuilder =
          LoadingPlanModels.PortLoadingPlanBallastDetails.newBuilder();

      newBuilder.setColorCode(
          portWiseBallastDetail.getColorCode() != null
              ? portWiseBallastDetail.getColorCode().toString()
              : "");
      newBuilder.setCorrectedUllage(
          portWiseBallastDetail.getCorrectedUllage() != null
              ? portWiseBallastDetail.getCorrectedUllage().toString()
              : "");
      newBuilder.setCorrectionFactor(
          portWiseBallastDetail.getCorrectionFactor() != null
              ? portWiseBallastDetail.getCorrectionFactor().toString()
              : "");
      newBuilder.setFillingPercentage(
          portWiseBallastDetail.getFillingPercentage() != null
              ? portWiseBallastDetail.getFillingPercentage().toString()
              : "");
      newBuilder.setId(portWiseBallastDetail.getId());
      newBuilder.setLoadablePatternId(request.getPatternId());
      newBuilder.setTankId(portWiseBallastDetail.getTankXId());
      newBuilder.setTemperature(
          portWiseBallastDetail.getTemperature() != null
              ? portWiseBallastDetail.getTemperature().toString()
              : "");
      newBuilder.setQuantity(
          portWiseBallastDetail.getQuantity() != null
              ? portWiseBallastDetail.getQuantity().toString()
              : "");
      newBuilder.setActualPlanned(
          portWiseBallastDetail.getValueType() != null
              ? portWiseBallastDetail.getValueType().toString()
              : "");
      newBuilder.setArrivalDeparture(
          portWiseBallastDetail.getConditionType() != null
              ? portWiseBallastDetail.getConditionType().toString()
              : "");
      newBuilder.setSounding(
          portWiseBallastDetail.getSounding() != null
              ? portWiseBallastDetail.getSounding().toString()
              : "");
      newBuilder.setSg(
          portWiseBallastDetail.getSg() != null ? portWiseBallastDetail.getSg().toString() : "");
      builder.addPortLoadingPlanBallastDetails(newBuilder);
    }
  }

  public void getPortWiseRobDetails(
      UpdateUllageDetailsRequest request, UpdateUllageDetailsResponse.Builder builder) {
    List<PortDischargingPlanRobDetails> portWiseRobDetails =
        pdpRobDetailsRepository.findByPatternIdAndPortRotationIdAndIsActive(
            request.getPatternId(), request.getPortRotationId(), true);
    for (PortDischargingPlanRobDetails portWiseRobDetail : portWiseRobDetails) {
      LoadingPlanModels.PortLoadingPlanRobDetails.Builder newBuilder =
          LoadingPlanModels.PortLoadingPlanRobDetails.newBuilder();

      newBuilder.setId(portWiseRobDetail.getId());
      newBuilder.setLoadablePatternId(request.getPatternId());
      newBuilder.setTankId(portWiseRobDetail.getTankXId());
      newBuilder.setQuantity(
          portWiseRobDetail.getQuantity() != null
              ? portWiseRobDetail.getQuantity().toString()
              : "");
      newBuilder.setActualPlanned(
          portWiseRobDetail.getValueType() != null
              ? portWiseRobDetail.getValueType().toString()
              : "");
      newBuilder.setArrivalDeparture(
          portWiseRobDetail.getConditionType() != null
              ? portWiseRobDetail.getConditionType().toString()
              : "");
      newBuilder.setDensity(
          portWiseRobDetail.getDensity() != null ? portWiseRobDetail.getDensity().toString() : "");
      newBuilder.setColorCode(
          portWiseRobDetail.getColorCode() != null ? portWiseRobDetail.getColorCode() : "");
      builder.addPortLoadingPlanRobDetails(newBuilder);
    }
  }

  public void getPortWiseStowageTempDetails(
      UpdateUllageDetailsRequest request, UpdateUllageDetailsResponse.Builder builder) {
    List<PortDischargingPlanStowageTempDetails> portWiseStowageTempDetails =
        portLoadingPlanStowageTempDetailsRepository.findByPatternIdAndPortRotationIdAndIsActive(
            request.getPatternId(), request.getPortRotationId(), true);
    for (PortDischargingPlanStowageTempDetails portWiseStowageDetail : portWiseStowageTempDetails) {
      LoadingPlanModels.PortLoadablePlanStowageDetail.Builder newBuilder =
          LoadingPlanModels.PortLoadablePlanStowageDetail.newBuilder();
      newBuilder.setAbbreviation(
          portWiseStowageDetail.getAbbreviation() != null
              ? portWiseStowageDetail.getAbbreviation()
              : "");
      newBuilder.setApi(
          portWiseStowageDetail.getApi() != null ? portWiseStowageDetail.getApi().toString() : "");
      newBuilder.setCargoNominationId(portWiseStowageDetail.getCargoNominationXId());
      newBuilder.setColorCode(
          portWiseStowageDetail.getColorCode() != null
              ? portWiseStowageDetail.getColorCode().toString()
              : "");
      newBuilder.setCorrectedUllage(
          portWiseStowageDetail.getCorrectedUllage() != null
              ? portWiseStowageDetail.getCorrectedUllage().toString()
              : "");
      newBuilder.setCorrectionFactor(
          portWiseStowageDetail.getCorrectionFactor() != null
              ? portWiseStowageDetail.getCorrectionFactor().toString()
              : "");
      newBuilder.setFillingPercentage(
          portWiseStowageDetail.getFillingPercentage() != null
              ? portWiseStowageDetail.getFillingPercentage().toString()
              : "");
      newBuilder.setId(portWiseStowageDetail.getId());
      newBuilder.setLoadablePatternId(request.getPatternId());
      newBuilder.setRdgUllage(
          portWiseStowageDetail.getRdgUllage() != null
              ? portWiseStowageDetail.getRdgUllage().toString()
              : "");
      newBuilder.setTankId(portWiseStowageDetail.getTankXId());
      newBuilder.setTemperature(
          portWiseStowageDetail.getTemperature() != null
              ? portWiseStowageDetail.getTemperature().toString()
              : "");
      newBuilder.setWeight(
          portWiseStowageDetail.getWeight() != null
              ? portWiseStowageDetail.getWeight().toString()
              : "");
      newBuilder.setQuantity(
          portWiseStowageDetail.getQuantity() != null
              ? portWiseStowageDetail.getQuantity().toString()
              : "");
      newBuilder.setActualPlanned(
          portWiseStowageDetail.getValueType() != null
              ? portWiseStowageDetail.getValueType().toString()
              : "");
      newBuilder.setArrivalDeparture(
          portWiseStowageDetail.getConditionType() != null
              ? portWiseStowageDetail.getConditionType().toString()
              : "");
      newBuilder.setUllage(
          portWiseStowageDetail.getUllage() != null
              ? portWiseStowageDetail.getUllage().toString()
              : "");
      builder.addPortLoadablePlanStowageTempDetails(newBuilder);
    }
  }

  public void getPortWiseBallastTempDetails(
      UpdateUllageDetailsRequest request, UpdateUllageDetailsResponse.Builder builder) {
    List<PortDischargingPlanBallastTempDetails> portWiseBallastTempDetails =
        portLoadingPlanBallastTempDetailsRepository.findByPatternIdAndPortRotationIdAndIsActive(
            request.getPatternId(), request.getPortRotationId(), true);
    for (PortDischargingPlanBallastTempDetails portWiseBallastDetail : portWiseBallastTempDetails) {
      LoadingPlanModels.PortLoadingPlanBallastDetails.Builder newBuilder =
          LoadingPlanModels.PortLoadingPlanBallastDetails.newBuilder();

      newBuilder.setColorCode(
          portWiseBallastDetail.getColorCode() != null
              ? portWiseBallastDetail.getColorCode().toString()
              : "");
      newBuilder.setCorrectedUllage(
          portWiseBallastDetail.getCorrectedUllage() != null
              ? portWiseBallastDetail.getCorrectedUllage().toString()
              : "");
      newBuilder.setCorrectionFactor(
          portWiseBallastDetail.getCorrectionFactor() != null
              ? portWiseBallastDetail.getCorrectionFactor().toString()
              : "");
      newBuilder.setFillingPercentage(
          portWiseBallastDetail.getFillingPercentage() != null
              ? portWiseBallastDetail.getFillingPercentage().toString()
              : "");
      newBuilder.setId(portWiseBallastDetail.getId());
      newBuilder.setLoadablePatternId(request.getPatternId());
      newBuilder.setTankId(portWiseBallastDetail.getTankXId());
      newBuilder.setTemperature(
          portWiseBallastDetail.getTemperature() != null
              ? portWiseBallastDetail.getTemperature().toString()
              : "");
      newBuilder.setQuantity(
          portWiseBallastDetail.getQuantity() != null
              ? portWiseBallastDetail.getQuantity().toString()
              : "");
      newBuilder.setActualPlanned(
          portWiseBallastDetail.getValueType() != null
              ? portWiseBallastDetail.getValueType().toString()
              : "");
      newBuilder.setArrivalDeparture(
          portWiseBallastDetail.getConditionType() != null
              ? portWiseBallastDetail.getConditionType().toString()
              : "");
      newBuilder.setSounding(
          portWiseBallastDetail.getSounding() != null
              ? portWiseBallastDetail.getSounding().toString()
              : "");
      builder.addPortLoadingPlanBallastTempDetails(newBuilder);
    }
  }

  public void getPortWiseCommingleDetails(
      UpdateUllageDetailsRequest request, UpdateUllageDetailsResponse.Builder builder) {
    List<DischargePlanCommingleDetails> portWiseRobDetails =
        loadablePlanCommingleDetailsRepository.findByDischargePatternXIdAndIsActive(
            request.getPatternId(), true);

    for (DischargePlanCommingleDetails portWiseCommingleDetail : portWiseRobDetails) {
      LoadingPlanModels.LoadablePlanCommingleDetails.Builder newBuilder =
          LoadingPlanModels.LoadablePlanCommingleDetails.newBuilder();

      newBuilder.setLoadablePatternId(request.getPatternId());
      newBuilder.setId(portWiseCommingleDetail.getId());
      newBuilder.setLoadingInformationId(portWiseCommingleDetail.getDischargeInformation().getId());
      newBuilder.setLoadablePlanId(portWiseCommingleDetail.getLoadablePatternXId());
      newBuilder.setGrade(
          portWiseCommingleDetail.getGrade() == null ? "" : portWiseCommingleDetail.getGrade());
      newBuilder.setTankName(
          portWiseCommingleDetail.getTankName() == null
              ? ""
              : portWiseCommingleDetail.getTankName());
      newBuilder.setQuantity(
          portWiseCommingleDetail.getQuantity() == null
              ? ""
              : portWiseCommingleDetail.getQuantity());
      newBuilder.setApi(
          portWiseCommingleDetail.getApi() == null ? "" : portWiseCommingleDetail.getApi());
      newBuilder.setTemperature(
          portWiseCommingleDetail.getTemperature() == null
              ? ""
              : portWiseCommingleDetail.getTemperature());
      newBuilder.setCargo1Abbreviation(
          portWiseCommingleDetail.getCargo1Abbreviation() == null
              ? ""
              : portWiseCommingleDetail.getCargo1Abbreviation());
      newBuilder.setCargo2Abbreviation(
          portWiseCommingleDetail.getCargo2Abbreviation() == null
              ? ""
              : portWiseCommingleDetail.getCargo2Abbreviation());
      newBuilder.setCargo1Percentage(
          portWiseCommingleDetail.getCargo1Percentage() == null
              ? ""
              : portWiseCommingleDetail.getCargo1Percentage());
      newBuilder.setCargo2Percentage(
          portWiseCommingleDetail.getCargo2Percentage() == null
              ? ""
              : portWiseCommingleDetail.getCargo2Percentage());
      newBuilder.setCargo1BblsDbs(
          portWiseCommingleDetail.getCargo1BblsDbs() == null
              ? ""
              : portWiseCommingleDetail.getCargo1BblsDbs());
      newBuilder.setCargo2BblsDbs(
          portWiseCommingleDetail.getCargo2BblsDbs() == null
              ? ""
              : portWiseCommingleDetail.getCargo2BblsDbs());
      newBuilder.setCargo1Bbls60F(
          portWiseCommingleDetail.getCargo1Bbls60f() == null
              ? ""
              : portWiseCommingleDetail.getCargo1Bbls60f());
      newBuilder.setCargo2Bbls60F(
          portWiseCommingleDetail.getCargo2Bbls60f() == null
              ? ""
              : portWiseCommingleDetail.getCargo2Bbls60f());
      newBuilder.setCargo1Lt(
          portWiseCommingleDetail.getCargo1Lt() == null
              ? ""
              : portWiseCommingleDetail.getCargo1Lt());
      newBuilder.setCargo2Lt(
          portWiseCommingleDetail.getCargo2Lt() == null
              ? ""
              : portWiseCommingleDetail.getCargo2Lt());
      newBuilder.setCargo1Mt(
          portWiseCommingleDetail.getCargo1Mt() == null
              ? ""
              : portWiseCommingleDetail.getCargo1Mt());
      newBuilder.setCargo2Mt(
          portWiseCommingleDetail.getCargo2Mt() == null
              ? ""
              : portWiseCommingleDetail.getCargo2Mt());
      newBuilder.setCargo1Kl(
          portWiseCommingleDetail.getCargo1Kl() == null
              ? ""
              : portWiseCommingleDetail.getCargo1Kl());
      newBuilder.setCargo2Kl(
          portWiseCommingleDetail.getCargo2Kl() == null
              ? ""
              : portWiseCommingleDetail.getCargo2Kl());
      newBuilder.setIsActive(portWiseCommingleDetail.getIsActive());
      newBuilder.setPriority(
          portWiseCommingleDetail.getPriority() == null
              ? Long.valueOf(0)
              : portWiseCommingleDetail.getPriority().longValue());
      newBuilder.setOrderQuantity(
          portWiseCommingleDetail.getOrderQuantity() == null
              ? ""
              : portWiseCommingleDetail.getOrderQuantity());
      newBuilder.setLoadingOrder(
          portWiseCommingleDetail.getDischargingOrder() == null
              ? Long.valueOf(0)
              : portWiseCommingleDetail.getDischargingOrder().longValue());
      newBuilder.setTankId(
          portWiseCommingleDetail.getTankId() == null
              ? Long.valueOf(0)
              : portWiseCommingleDetail.getTankId().longValue());
      newBuilder.setFillingRatio(
          portWiseCommingleDetail.getFillingRatio() == null
              ? ""
              : portWiseCommingleDetail.getFillingRatio());
      newBuilder.setCorrectedUllage(
          portWiseCommingleDetail.getCorrectedUllage() == null
              ? ""
              : portWiseCommingleDetail.getCorrectedUllage());
      newBuilder.setCorrectionFactor(
          portWiseCommingleDetail.getCorrectionFactor() == null
              ? ""
              : portWiseCommingleDetail.getCorrectionFactor());
      newBuilder.setRdgUllage(
          portWiseCommingleDetail.getRdgUllage() == null
              ? ""
              : portWiseCommingleDetail.getRdgUllage());
      newBuilder.setSlopQuantity(
          portWiseCommingleDetail.getSlopQuantity() == null
              ? ""
              : portWiseCommingleDetail.getSlopQuantity());
      newBuilder.setTimeRequiredForLoading(
          portWiseCommingleDetail.getTimeRequiredForDischarging() == null
              ? ""
              : portWiseCommingleDetail.getTimeRequiredForDischarging());
      builder.addLoadablePlanCommingleDetails(newBuilder);
    }
  }

  @Override
  public void updateDischargeUllageDetails(
      UllageBillRequest request, StreamObserver<UllageBillReply> responseObserver) {
    LoadingPlanModels.UllageBillReply.Builder builder =
        LoadingPlanModels.UllageBillReply.newBuilder();
    String processId = "";
    try {

      // update and save ballast
      List<PortDischargingPlanBallastTempDetails> tempBallast =
          portLoadingPlanBallastTempDetailsRepository
              .findByDischargingInformationAndConditionTypeAndIsActive(
                  request.getUpdateUllage(0).getLoadingInformationId(),
                  request.getUpdateUllage(0).getArrivalDepartutre(),
                  true);
      List<PortDischargingPlanBallastTempDetails> updatedBallast =
          DischargeUllageServiceUtils.updateBallast(request, tempBallast);
      portLoadingPlanBallastTempDetailsRepository.saveAll(updatedBallast);

      // update and save stowage
      List<PortDischargingPlanStowageTempDetails> tempStowage =
          portLoadingPlanStowageTempDetailsRepository
              .findByDischargingInformationAndConditionTypeAndIsActive(
                  request.getUpdateUllage(0).getLoadingInformationId(),
                  request.getUpdateUllage(0).getArrivalDepartutre(),
                  true);
      List<PortDischargingPlanStowageTempDetails> updatedStowage =
          DischargeUllageServiceUtils.updateStowage(request, tempStowage);
      portLoadingPlanStowageTempDetailsRepository.saveAll(updatedStowage);

      // update and save ROB
      List<PortDischargingPlanRobDetails> tempRob =
          pdpRobDetailsRepository.findByDischargingInformationAndConditionTypeAndIsActive(
              request.getRobUpdate(0).getLoadingInformationId(),
              request.getRobUpdate(0).getArrivalDepartutre(),
              true);
      List<PortDischargingPlanRobDetails> updatedRob =
          DischargeUllageServiceUtils.updateRob(request, tempRob);
      pdpRobDetailsRepository.saveAll(updatedRob);

      // update and save bill of ladding
      List<BillOfLadding> updatedBillOfLadding =
          DischargeUllageServiceUtils.updateBillOfLadding(
              request, billOfLaddingRepo, dischargeInformationService);
      billOfLaddingRepo.saveAll(updatedBillOfLadding);

      if (request.getIsValidate() != null && request.getIsValidate().equals("true")) {
        processId = validateAndSaveData(request);
      }
      builder.setProcessId(processId);
      builder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS).build());
    } catch (Exception e) {
      TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
      e.printStackTrace();
      builder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage(e.getMessage())
              .setStatus(DischargePlanConstants.FAILED)
              .build());
    } finally {
      responseObserver.onNext(builder.build());
      responseObserver.onCompleted();
    }
  }

  private String validateAndSaveData(UllageBillRequest request)
      throws GenericServiceException, IllegalAccessException, InvocationTargetException {
    return ullageUpdateLoadicatorService.saveLoadicatorInfoForUllageUpdate(request);
  }
}
