/* Licensed at AlphaOri Technologies */
package com.cpdss.loadingplan.service;

import com.cpdss.common.exception.GenericServiceException;
import com.cpdss.common.generated.Common;
import com.cpdss.common.generated.Common.ResponseStatus;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanSyncDetails;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanSyncReply;
import com.cpdss.common.rest.CommonErrorCodes;
import com.cpdss.common.utils.HttpStatusCode;
import com.cpdss.loadingplan.common.LoadingPlanConstants;
import com.cpdss.loadingplan.entity.*;
import com.cpdss.loadingplan.repository.*;
import io.grpc.stub.StreamObserver;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Transactional
@Service
public class LoadingPlanService {

  private static final String SUCCESS = "SUCCESS";
  private static final String FAILED = "FAILED";
  @Autowired LoadingInformationService loadingInformationService;
  @Autowired CargoToppingOffSequenceService cargoToppingOffSequenceService;
  @Autowired LoadablePlanBallastDetailsService loadablePlanBallastDetailsService;
  @Autowired LoadablePlanCommingleDetailsService loadablePlanCommingleDetailsService;
  @Autowired LoadablePlanQuantityService loadablePlanQuantityService;
  @Autowired LoadablePlanStowageDetailsService loadablePlanStowageDetailsService;
  @Autowired PortLoadingPlanBallastDetailsRepository plpBallastDetailsRepository;
  @Autowired PortLoadingPlanStowageDetailsRepository plpStowageDetailsRepository;
  @Autowired PortLoadingPlanRobDetailsRepository plpRobDetailsRepository;
  @Autowired PortLoadingPlanStabilityParametersRepository plpStabilityParametersRepository;
  @Autowired LoadingInformationBuilderService informationBuilderService;
  @Autowired LoadingBerthDetailsRepository berthDetailsRepository;
  @Autowired CargoToppingOffSequenceRepository cargoToppingOffSequenceRepository;

  @Autowired BillOfLaddingRepository billOfLaddingRepo;
  @Autowired PortLoadingPlanStowageDetailsRepository portLoadingPlanStowageDetailsRepository;
  @Autowired PortLoadingPlanBallastDetailsRepository portLoadingPlanBallastDetailsRepository;
  @Autowired PortLoadingPlanRobDetailsRepository portLoadingPlanRobDetailsRepository;

  @Autowired
  PortLoadingPlanStowageTempDetailsRepository portLoadingPlanStowageTempDetailsRepository;

  @Autowired
  PortLoadingPlanBallastTempDetailsRepository portLoadingPlanBallastTempDetailsRepository;

  @Autowired LoadablePlanCommingleDetailsRepository loadablePlanCommingleDetailsRepository;

  @Autowired BillOfLandingRepository billOfLandingRepository;

  @Autowired PortLoadingPlanStowageTempDetailsRepository loadingPlanStowageDetailsTempRepository;
  @Autowired PortLoadingPlanBallastTempDetailsRepository loadingPlanBallastDetailsTempRepository;
  @Autowired PortLoadingPlanStowageDetailsRepository loadingPlanStowageDetailsRepository;
  @Autowired PortLoadingPlanBallastDetailsRepository loadingPlanBallastDetailsRepository;
  @Autowired PortLoadingPlanRobDetailsRepository loadingPlanRobDetailsRepository;

  @Autowired StageOffsetRepository stageOffsetRepository;
  @Autowired StageDurationRepository stageDurationRepository;
  @Autowired ReasonForDelayRepository reasonForDelayRepository;
  @Autowired LoadingDelayRepository loadingDelayRepository;

  /**
   * @param request
   * @param builder
   */
  public void loadingPlanSynchronization(
      LoadingPlanSyncDetails request, LoadingPlanSyncReply.Builder builder) {
    try {
      LoadingInformation loadingInformation = new LoadingInformation();
      LoadingInformation savedLoadingInformation =
          loadingInformationService.saveLoadingInformationDetail(
              request.getLoadingInformationDetail(), loadingInformation);
      cargoToppingOffSequenceService.saveCargoToppingOffSequenceList(
          request.getCargoToppingOffSequencesList(), savedLoadingInformation);
      loadablePlanBallastDetailsService.saveLoadablePlanBallastDetailsList(
          request.getLoadablePlanDetailsReply().getLoadablePlanBallastDetailsList(),
          savedLoadingInformation);
      loadablePlanCommingleDetailsService.saveLoadablePlanCommingleDetailsList(
          request.getLoadablePlanDetailsReply().getLoadableQuantityCommingleCargoDetailsList(),
          savedLoadingInformation);
      loadablePlanQuantityService.saveLoadablePlanQuantyList(
          request.getLoadablePlanDetailsReply().getLoadableQuantityCargoDetailsList(),
          savedLoadingInformation);
      loadablePlanStowageDetailsService.saveLoadablePlanStowageDetailsList(
          request.getLoadablePlanDetailsReply().getLoadablePlanStowageDetailsList(),
          savedLoadingInformation);
      log.info(
          "Saved LoadingInformation on port "
              + request.getLoadingInformationDetail().getPortId()
              + " of Loadable pattern "
              + request.getLoadingInformationDetail().getLoadablePatternId());
      builder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setMessage("Successfully saved loading information in database")
              .setStatus(LoadingPlanConstants.SUCCESS)
              .build());
    } catch (Exception e) {
      log.info(
          "Failed to save LoadingInformation on port "
              + request.getLoadingInformationDetail().getPortId()
              + " of Loadable pattern "
              + request.getLoadingInformationDetail().getLoadablePatternId());
      builder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setMessage("Error occured while saving loading information in database")
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setStatus(LoadingPlanConstants.SUCCESS)
              .build());
      e.printStackTrace();
    }
  }

  public void getLoadingPlan(
      LoadingPlanModels.LoadingInformationRequest request,
      LoadingPlanModels.LoadingPlanReply.Builder masterBuilder)
      throws GenericServiceException {

    Optional<LoadingInformation> var1;
    if (request.getLoadingPlanId() > 0) {
      var1 = loadingInformationService.getLoadingInformation(request.getLoadingPlanId());
    } else {
      var1 =
          loadingInformationService.getLoadingInformation(
              0L,
              request.getVesselId(),
              request.getVoyageId(),
              request.getLoadingPatternId(),
              request.getPortRotationId());
    }

    if (var1.isPresent()) {

      // <---Loading Information Start-->
      LoadingPlanModels.LoadingInformation.Builder loadingInformation =
          LoadingPlanModels.LoadingInformation.newBuilder();

      // Loading Rate From Loading Info
      LoadingPlanModels.LoadingRates rates =
          this.informationBuilderService.buildLoadingRateMessage(var1.get());
      loadingInformation.setLoadingRate(rates);

      // Set Saved Berth Data
      List<LoadingBerthDetail> list1 =
          this.berthDetailsRepository.findAllByLoadingInformationAndIsActiveTrue(var1.orElse(null));
      List<LoadingPlanModels.LoadingBerths> berths =
          this.informationBuilderService.buildLoadingBerthsMessage(list1);
      loadingInformation.addAllLoadingBerths(berths);

      // Topping Off Sequence
      List<CargoToppingOffSequence> list2 =
          this.cargoToppingOffSequenceRepository.findAllByLoadingInformationAndIsActiveTrue(
              var1.orElse(null));
      List<LoadingPlanModels.LoadingToppingOff> toppingOff =
          this.informationBuilderService.buildToppingOffMessage(list2);
      loadingInformation.addAllToppingOffSequence(toppingOff);

      // Loading Sequences
      // Stage Min Amount Master
      List<StageOffset> list3 = this.stageOffsetRepository.findAll();
      // Stage Duration Master
      List<StageDuration> list4 = this.stageDurationRepository.findAll();

      // Staging User data and Master data
      LoadingPlanModels.LoadingStages loadingStages =
          this.informationBuilderService.buildLoadingStageMessage(var1.orElse(null), list3, list4);
      loadingInformation.setLoadingStage(loadingStages);

      // Loading Delay
      List<ReasonForDelay> list5 = this.reasonForDelayRepository.findAll();
      List<LoadingDelay> list6 =
          this.loadingDelayRepository.findAllByLoadingInformationAndIsActiveTrue(var1.orElse(null));
      LoadingPlanModels.LoadingDelay loadingDelay =
          this.informationBuilderService.buildLoadingDelayMessage(list5, list6);
      loadingInformation.setLoadingDelays(loadingDelay);
      Optional.ofNullable(var1.get().getLoadingInformationStatus())
          .ifPresent(status -> loadingInformation.setLoadingInfoStatusId(status.getId()));
      Optional.ofNullable(var1.get().getArrivalStatus())
          .ifPresent(status -> loadingInformation.setLoadingPlanArrStatusId(status.getId()));
      Optional.ofNullable(var1.get().getDepartureStatus())
          .ifPresent(status -> loadingInformation.setLoadingPlanDepStatusId(status.getId()));
      Optional.ofNullable(var1.get().getLoadablePatternXId())
          .ifPresent(loadingInformation::setLoadablePatternId);
      masterBuilder.setLoadingInformation(loadingInformation.build());

      // <---Loading Information End-->

      // <---Cargo Details Start-->
      List<PortLoadingPlanBallastDetails> plpBallastList =
          plpBallastDetailsRepository.findByLoadingInformationAndIsActive(var1.get(), true);
      List<PortLoadingPlanStowageDetails> plpStowageList =
          plpStowageDetailsRepository.findByLoadingInformationAndIsActive(var1.get(), true);
      List<PortLoadingPlanRobDetails> plpRobList =
          plpRobDetailsRepository.findByLoadingInformationAndIsActive(var1.get(), true);
      List<PortLoadingPlanStabilityParameters> plpStabilityList =
          plpStabilityParametersRepository.findByLoadingInformationAndIsActive(var1.get(), true);

      masterBuilder.addAllPortLoadingPlanBallastDetails(
          this.informationBuilderService.buildLoadingPlanTankBallastMessage(plpBallastList));
      masterBuilder.addAllPortLoadingPlanStowageDetails(
          this.informationBuilderService.buildLoadingPlanTankStowageMessage(plpStowageList));
      masterBuilder.addAllPortLoadingPlanRobDetails(
          this.informationBuilderService.buildLoadingPlanTankRobMessage(plpRobList));
      masterBuilder.addAllPortLoadingPlanStabilityParameters(
          this.informationBuilderService.buildLoadingPlanTankStabilityMessage(plpStabilityList));
      // <---Loading Information End-->
    } else {
      log.error("Failed to fetch Loading Plan, Loading info Id is 0");
      throw new GenericServiceException(
          "Loading Info Id Is 0", CommonErrorCodes.E_HTTP_BAD_REQUEST, HttpStatusCode.BAD_REQUEST);
    }
    masterBuilder.setResponseStatus(
        ResponseStatus.newBuilder().setStatus(LoadingPlanConstants.SUCCESS).build());
    masterBuilder.build();
  }

  public void getBillOfLaddingDetails(
      LoadingPlanModels.UpdateUllageDetailsRequest request,
      LoadingPlanModels.UpdateUllageDetailsResponse.Builder builder) {

    List<BillOfLadding> billOfLaddingDetails =
        this.billOfLaddingRepo.findByLoadablePatternXIdAndIsActive(request.getPatternId(), true);
    billOfLaddingDetails.stream()
        .forEach(
            bill -> {
              Common.BillOfLadding.Builder blBuilder = Common.BillOfLadding.newBuilder();
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
    return;
  }

  public void getPortWiseStowageDetails(
      LoadingPlanModels.UpdateUllageDetailsRequest request,
      LoadingPlanModels.UpdateUllageDetailsResponse.Builder builder) {
    List<PortLoadingPlanStowageDetails> portWiseStowageDetails =
        portLoadingPlanStowageDetailsRepository.findByPatternIdAndPortRotationIdAndIsActive(
            request.getPatternId(), request.getPortRotationId(), true);
    for (PortLoadingPlanStowageDetails portWiseStowageDetail : portWiseStowageDetails) {
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
      builder.addPortLoadablePlanStowageDetails(newBuilder);
    }
  }

  public void getPortWiseBallastDetails(
      LoadingPlanModels.UpdateUllageDetailsRequest request,
      LoadingPlanModels.UpdateUllageDetailsResponse.Builder builder) {
    List<PortLoadingPlanBallastDetails> portWiseStowageDetails =
        portLoadingPlanBallastDetailsRepository.findByPatternIdAndPortRotationIdAndIsActive(
            request.getPatternId(), request.getPortRotationId(), true);
    for (PortLoadingPlanBallastDetails portWiseBallastDetail : portWiseStowageDetails) {
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
      LoadingPlanModels.UpdateUllageDetailsRequest request,
      LoadingPlanModels.UpdateUllageDetailsResponse.Builder builder) {
    List<PortLoadingPlanRobDetails> portWiseRobDetails =
        portLoadingPlanRobDetailsRepository.findByPatternIdAndPortRotationIdAndIsActive(
            request.getPatternId(), request.getPortRotationId(), true);
    for (PortLoadingPlanRobDetails portWiseRobDetail : portWiseRobDetails) {
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

  public LoadingPlanModels.UllageBillReply getLoadableStudyShoreTwo(
      LoadingPlanModels.UllageBillRequest request,
      StreamObserver<LoadingPlanModels.UllageBillReply> responseObserver) {

    LoadingPlanModels.UllageBillReply.Builder builder =
        LoadingPlanModels.UllageBillReply.newBuilder();

    try {

      request
          .getBillOfLandingList()
          .forEach(
              billOfLanding -> {
                billOfLandingRepository.updateBillOfLandingRepository(
                    billOfLanding.getBlRefNumber(),
                    BigDecimal.valueOf(billOfLanding.getBblAt60F()),
                    BigDecimal.valueOf(billOfLanding.getQuantityLt()),
                    BigDecimal.valueOf(billOfLanding.getQuantityMt()),
                    BigDecimal.valueOf(billOfLanding.getKlAt15C()),
                    BigDecimal.valueOf(billOfLanding.getApi()),
                    BigDecimal.valueOf(billOfLanding.getTemperature()),
                    Integer.valueOf(billOfLanding.getCargoId() + ""),
                    Integer.valueOf(billOfLanding.getPortId() + ""));
              });

      request
          .getBillOfLandingRemoveList()
          .forEach(
              billOfLanding -> {
                billOfLandingRepository.deleteBillOfLandingRepository(
                    Boolean.valueOf(billOfLanding.getIsActive() == 0 ? false : true),
                    Integer.valueOf(billOfLanding.getCargoId() + ""),
                    Integer.valueOf(billOfLanding.getPortId() + ""));
              });

      request
          .getRobUpdateList()
          .forEach(
              ullageInsert -> {
                if (ullageInsert.getIsUpdate()) {
                  loadingPlanRobDetailsRepository.updatePortLoadingPlanRobDetailsRepository(
                      BigDecimal.valueOf(ullageInsert.getQuantity()),
                      BigDecimal.valueOf(ullageInsert.getQuantity()),
                      Long.valueOf(ullageInsert.getTankId()),
                      true);
                } else {
                  loadingPlanRobDetailsRepository.save(new PortLoadingPlanRobDetails());
                }
              });

      if (request.getIsValidate() != null && request.getIsValidate().equals("true")) {

        request
            .getBallastUpdateList()
            .forEach(
                ullageInsert -> {
                  if (ullageInsert.getIsUpdate()) {
                    loadingPlanBallastDetailsTempRepository
                        .updateLoadingPlanBallastDetailsRepository(
                            BigDecimal.valueOf(ullageInsert.getQuantity()),
                            BigDecimal.valueOf(ullageInsert.getSounding()),
                            BigDecimal.valueOf(ullageInsert.getQuantity()),
                            Long.valueOf(ullageInsert.getTankId()),
                            true,
                            Long.valueOf(ullageInsert.getTankId()));
                  } else {
                    loadingPlanBallastDetailsTempRepository.save(
                        new PortLoadingPlanBallastTempDetails());
                  }
                });

        request
            .getUpdateUllageList()
            .forEach(
                ullageInsert -> {
                  if (ullageInsert.getIsUpdate()) {
                    loadingPlanStowageDetailsTempRepository
                        .updatePortLoadingPlanStowageDetailsRepository(
                            BigDecimal.valueOf(ullageInsert.getQuantity()),
                            BigDecimal.valueOf(ullageInsert.getCorrectedUllage()),
                            BigDecimal.valueOf(ullageInsert.getQuantity()),
                            BigDecimal.valueOf(Long.parseLong(ullageInsert.getApi() + "")),
                            BigDecimal.valueOf(Long.parseLong(ullageInsert.getTemperature() + "")),
                            Long.valueOf(ullageInsert.getTankId()),
                            true,
                            Long.valueOf(ullageInsert.getTankId()));
                  } else {
                    loadingPlanStowageDetailsTempRepository.save(
                        new PortLoadingPlanStowageTempDetails());
                  }
                });
      } else {
        validateAndSaveData(request);
      }

      builder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS).build());
    } catch (Exception e) {
      e.printStackTrace();
      builder.setResponseStatus(ResponseStatus.newBuilder().setStatus(FAILED).build());
    } finally {
      responseObserver.onNext(builder.build());
      responseObserver.onCompleted();
    }

    // log.info("getLoadableStudyShoreTwo ", request);
    return builder.build();
  }

  private void validateAndSaveData(LoadingPlanModels.UllageBillRequest request) {

    // Validation pending since API from ALGO is not yet created.

    loadingPlanBallastDetailsTempRepository.deleteByLoadingInformationId(null);
    request
        .getBallastUpdateList()
        .forEach(
            ullageInsert -> {
              if (ullageInsert.getIsUpdate()) {
                loadingPlanBallastDetailsRepository.updateLoadingPlanBallastDetailsRepository(
                    BigDecimal.valueOf(ullageInsert.getQuantity()),
                    BigDecimal.valueOf(ullageInsert.getSounding()),
                    BigDecimal.valueOf(ullageInsert.getQuantity()),
                    Long.valueOf(ullageInsert.getTankId()),
                    true,
                    Long.valueOf(ullageInsert.getTankId()));
              } else {
                loadingPlanBallastDetailsRepository.save(new PortLoadingPlanBallastDetails());
              }
            });

    loadingPlanStowageDetailsRepository.deleteByLoadingInformationId(null);
    request
        .getUpdateUllageList()
        .forEach(
            ullageInsert -> {
              if (ullageInsert.getIsUpdate()) {
                loadingPlanStowageDetailsRepository.updatePortLoadingPlanStowageDetailsRepository(
                    BigDecimal.valueOf(ullageInsert.getQuantity()),
                    BigDecimal.valueOf(ullageInsert.getCorrectedUllage()),
                    BigDecimal.valueOf(ullageInsert.getQuantity()),
                    BigDecimal.valueOf(Long.parseLong(ullageInsert.getApi() + "")),
                    BigDecimal.valueOf(Long.parseLong(ullageInsert.getTemperature() + "")),
                    Long.valueOf(ullageInsert.getTankId()),
                    true,
                    Long.valueOf(ullageInsert.getTankId()));
              } else {
                loadingPlanStowageDetailsRepository.save(new PortLoadingPlanStowageDetails());
              }
            });
  }

  public void getPortWiseStowageTempDetails(
      LoadingPlanModels.UpdateUllageDetailsRequest request,
      LoadingPlanModels.UpdateUllageDetailsResponse.Builder builder) {
    List<PortLoadingPlanStowageTempDetails> portWiseStowageTempDetails =
        portLoadingPlanStowageTempDetailsRepository.findByPatternIdAndPortRotationIdAndIsActive(
            request.getPatternId(), request.getPortRotationId(), true);
    for (PortLoadingPlanStowageTempDetails portWiseStowageDetail : portWiseStowageTempDetails) {
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
      LoadingPlanModels.UpdateUllageDetailsRequest request,
      LoadingPlanModels.UpdateUllageDetailsResponse.Builder builder) {
    List<PortLoadingPlanBallastTempDetails> portWiseBallastTempDetails =
        portLoadingPlanBallastTempDetailsRepository.findByPatternIdAndPortRotationIdAndIsActive(
            request.getPatternId(), request.getPortRotationId(), true);
    for (PortLoadingPlanBallastTempDetails portWiseBallastDetail : portWiseBallastTempDetails) {
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
      LoadingPlanModels.UpdateUllageDetailsRequest request,
      LoadingPlanModels.UpdateUllageDetailsResponse.Builder builder) {
    List<LoadablePlanCommingleDetails> portWiseRobDetails =
        loadablePlanCommingleDetailsRepository.findByLoadablePatternXIdAndIsActive(
            request.getPatternId(), true);

    for (LoadablePlanCommingleDetails portWiseCommingleDetail : portWiseRobDetails) {
      LoadingPlanModels.LoadablePlanCommingleDetails.Builder newBuilder =
          LoadingPlanModels.LoadablePlanCommingleDetails.newBuilder();

      newBuilder.setLoadablePatternId(request.getPatternId());
      newBuilder.setId(portWiseCommingleDetail.getId());
      newBuilder.setLoadingInformationId(portWiseCommingleDetail.getLoadingInformation().getId());
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
          portWiseCommingleDetail.getLoadingOrder() == null
              ? Long.valueOf(0)
              : portWiseCommingleDetail.getLoadingOrder().longValue());
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
          portWiseCommingleDetail.getTimeRequiredForLoading() == null
              ? ""
              : portWiseCommingleDetail.getTimeRequiredForLoading());
      builder.addLoadablePlanCommingleDetails(newBuilder);
    }
  }
}
