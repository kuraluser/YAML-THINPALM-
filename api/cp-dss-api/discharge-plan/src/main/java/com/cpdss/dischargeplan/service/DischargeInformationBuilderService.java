/* Licensed at AlphaOri Technologies */
package com.cpdss.dischargeplan.service;

import com.cpdss.common.exception.GenericServiceException;
import com.cpdss.common.generated.Common;
import com.cpdss.common.generated.VesselInfo;
import com.cpdss.common.generated.discharge_plan.CargoForCow;
import com.cpdss.common.generated.discharge_plan.CowPlan;
import com.cpdss.common.generated.discharge_plan.CowTankDetails;
import com.cpdss.common.generated.discharge_plan.DischargeBerths;
import com.cpdss.common.generated.discharge_plan.DischargeDelay;
import com.cpdss.common.generated.discharge_plan.DischargeDelays;
import com.cpdss.common.generated.discharge_plan.DischargeDetails;
import com.cpdss.common.generated.discharge_plan.DischargeRates;
import com.cpdss.common.generated.discharge_plan.DischargeRuleReply;
import com.cpdss.common.generated.discharge_plan.PostDischargeStageTime;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels.DelayReasons;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingBerths;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingDelay;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingDelays;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingDetails;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingMachinesInUse;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanCommingleDetails;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingRates;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingStages;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels.StageOffsets;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels.TrimAllowed;
import com.cpdss.common.rest.CommonErrorCodes;
import com.cpdss.common.utils.HttpStatusCode;
import com.cpdss.dischargeplan.domain.*;
import com.cpdss.dischargeplan.domain.rules.RuleMasterData;
import com.cpdss.dischargeplan.domain.rules.RuleType;
import com.cpdss.dischargeplan.entity.CowPlanDetail;
import com.cpdss.dischargeplan.entity.CowTankDetail;
import com.cpdss.dischargeplan.entity.CowWithDifferentCargo;
import com.cpdss.dischargeplan.entity.DischargeInformation;
import com.cpdss.dischargeplan.entity.DischargePlanRuleInput;
import com.cpdss.dischargeplan.entity.DischargePlanRules;
import com.cpdss.dischargeplan.entity.DischargingBerthDetail;
import com.cpdss.dischargeplan.entity.DischargingDelay;
import com.cpdss.dischargeplan.entity.DischargingDelayReason;
import com.cpdss.dischargeplan.entity.DischargingMachineryInUse;
import com.cpdss.dischargeplan.entity.DischargingStagesDuration;
import com.cpdss.dischargeplan.entity.DischargingStagesMinAmount;
import com.cpdss.dischargeplan.entity.PortDischargingPlanBallastDetails;
import com.cpdss.dischargeplan.entity.PortDischargingPlanCommingleDetails;
import com.cpdss.dischargeplan.entity.PortDischargingPlanRobDetails;
import com.cpdss.dischargeplan.entity.PortDischargingPlanStabilityParameters;
import com.cpdss.dischargeplan.entity.PortDischargingPlanStowageDetails;
import com.cpdss.dischargeplan.entity.ReasonForDelay;
import com.cpdss.dischargeplan.repository.CowPlanDetailRepository;
import com.cpdss.dischargeplan.repository.CowWithDifferentCargoRepository;
import com.cpdss.dischargeplan.repository.DischargeStageDurationRepository;
import com.cpdss.dischargeplan.repository.DischargeStageMinAmountRepository;
import com.cpdss.dischargeplan.repository.DischargingDelayReasonRepository;
import com.cpdss.dischargeplan.repository.DischargingDelayRepository;
import com.cpdss.dischargeplan.repository.DischargingMachineryInUseRepository;
import com.cpdss.dischargeplan.repository.ReasonForDelayRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DischargeInformationBuilderService {

  @Autowired DischargeStageDurationRepository dischargeStageDurationRepository;

  @Autowired DischargeStageMinAmountRepository dischargeStageMinAmountRepository;

  @Autowired ReasonForDelayRepository reasonForDelayRepository;

  @Autowired DischargingDelayRepository dischargingDelayRepository;

  @Autowired DischargingDelayReasonRepository dischargingDelayReasonRepository;

  @Autowired DischargingMachineryInUseRepository dischargingMachineryInUseRepository;

  @Autowired CowPlanDetailRepository cowPlanDetailRepository;

  @Autowired CowWithDifferentCargoRepository cowWithDifferentCargoRepository;

  public LoadingDetails buildLoadingDetailsMessage(DischargeInformation var1) {
    LoadingDetails.Builder builder = LoadingDetails.newBuilder();
    if (var1 != null) {
      Optional.of(var1.getId()).ifPresent(builder::setId);
      Optional.ofNullable(var1.getSunriseTime())
          .ifPresent(v -> builder.setTimeOfSunrise(v.toString()));
      Optional.ofNullable(var1.getSunsetTime())
          .ifPresent(v -> builder.setTimeOfSunset(v.toString()));
      Optional.ofNullable(var1.getStartTime()).ifPresent(v -> builder.setStartTime(v.toString()));

      TrimAllowed.Builder builder1 = TrimAllowed.newBuilder();
      Optional.ofNullable(var1.getInitialTrim())
          .ifPresent(v -> builder1.setInitialTrim(v.toString()));
      Optional.ofNullable(var1.getMaximumTrim())
          .ifPresent(v -> builder1.setMaximumTrim(v.toString()));
      Optional.ofNullable(var1.getFinalTrim()).ifPresent(v -> builder1.setFinalTrim(v.toString()));

      builder.setTrimAllowed(builder1.build());
    }
    return builder.build();
  }

  public LoadingRates buildLoadingRateMessage(DischargeInformation var1) {
    LoadingRates.Builder builder = LoadingRates.newBuilder();
    if (var1 != null) {
      Optional.ofNullable(var1.getId()).ifPresent(builder::setId);
      Optional.ofNullable(var1.getInitialDischargingRate())
          .ifPresent(v -> builder.setInitialLoadingRate(v.toString()));
      Optional.ofNullable(var1.getMaxDischargingRate())
          .ifPresent(v -> builder.setMaxLoadingRate(v.toString()));
      Optional.ofNullable(var1.getReducedDischargingRate())
          .ifPresent(v -> builder.setReducedLoadingRate(v.toString()));
      Optional.ofNullable(var1.getMinBallastRate())
          .ifPresent(v -> builder.setMinDeBallastingRate(v.toString()));
      Optional.ofNullable(var1.getMaxBallastRate())
          .ifPresent(v -> builder.setMaxDeBallastingRate(v.toString()));
      Optional.ofNullable(var1.getNoticeTimeForRateReduction())
          .ifPresent(v -> builder.setNoticeTimeRateReduction(v.toString()));
      Optional.ofNullable(var1.getNoticeTimeForStopDischarging())
          .ifPresent(v -> builder.setNoticeTimeStopLoading(v.toString()));
      Optional.ofNullable(var1.getLineContentRemaining())
          .ifPresent(v -> builder.setLineContentRemaining(v.toString()));
      Optional.ofNullable(var1.getMinDischargingRate())
          .ifPresent(v -> builder.setMinLoadingRate(v.toString()));
    }
    return builder.build();
  }

  public List<LoadingBerths> buildLoadingBerthsMessage(List<DischargingBerthDetail> list) {
    List<LoadingBerths> berths = new ArrayList<>();
    for (DischargingBerthDetail var1 : list) {
      LoadingBerths.Builder builder = LoadingBerths.newBuilder();
      Optional.ofNullable(var1.getId()).ifPresent(builder::setId);
      Optional.ofNullable(var1.getDischargingInformation().getId())
          .ifPresent(builder::setLoadingInfoId);
      Optional.ofNullable(var1.getBerthXid()).ifPresent(builder::setBerthId);
      Optional.ofNullable(var1.getDepth()).ifPresent(v -> builder.setDepth(v.toString()));
      Optional.ofNullable(var1.getSeaDraftLimitation())
          .ifPresent(v -> builder.setSeaDraftLimitation(v.toString()));
      Optional.ofNullable(var1.getAirDraftLimitation())
          .ifPresent(v -> builder.setAirDraftLimitation(v.toString()));
      Optional.ofNullable(var1.getMaxManifoldHeight())
          .ifPresent(v -> builder.setMaxManifoldHeight(v.toString()));
      Optional.ofNullable(var1.getSpecialRegulationRestriction())
          .ifPresent(v -> builder.setSpecialRegulationRestriction(v.toString()));
      Optional.ofNullable(var1.getItemToBeAgreed())
          .ifPresent(v -> builder.setItemsToBeAgreedWith(v));
      Optional.ofNullable(var1.getHoseConnections()).ifPresent(v -> builder.setHoseConnections(v));
      Optional.ofNullable(var1.getLineContentDisplacement())
          .ifPresent(v -> builder.setLineDisplacement(v.toString()));
      berths.add(builder.build());
    }
    return berths;
  }

  public List<LoadingMachinesInUse> buildLoadingMachineryInUseMessage(
      List<DischargingMachineryInUse> list) {
    List<LoadingMachinesInUse> machinery = new ArrayList<>();
    for (DischargingMachineryInUse var1 : list) {
      LoadingMachinesInUse.Builder builder = LoadingMachinesInUse.newBuilder();
      Optional.ofNullable(var1.getId()).ifPresent(builder::setId);
      Optional.ofNullable(var1.getDischargingInformation().getId())
          .ifPresent(builder::setLoadingInfoId);
      Optional.ofNullable(var1.getMachineXid()).ifPresent(builder::setMachineId);
      Optional.ofNullable(var1.getMachineTypeXid())
          .ifPresent(
              v -> {
                builder.setMachineTypeValue(v);
              });
      Optional.ofNullable(var1.getCapacity())
          .ifPresent(value -> builder.setCapacity(value.toString()));
      Optional.ofNullable(var1.getIsUsing()).ifPresent(builder::setIsUsing);
      machinery.add(builder.build());
    }
    return machinery;
  }

  public LoadingStages buildLoadingStageMessage(
      DischargeInformation var1,
      List<DischargingStagesMinAmount> list3,
      List<DischargingStagesDuration> list4) {
    LoadingStages.Builder builder = LoadingStages.newBuilder();
    if (var1 != null) {
      Optional.ofNullable(var1.getId()).ifPresent(builder::setId);
      Optional.ofNullable(var1.getDischargingStagesMinAmount())
          .ifPresent(value -> builder.setStageOffset(value.getId().intValue()));
      Optional.ofNullable(var1.getDischargingStagesDuration())
          .ifPresent(value -> builder.setStageDuration(value.getId().intValue()));
    }

    // Set Offset Master
    builder.addAllStageOffsets(this.buildStageOffsetMasterMessage(list3));
    builder.addAllStageDurations(this.buildStageDurationMasterMessage(list4));
    return builder.build();
  }

  public List<LoadingPlanModels.StageDuration> buildStageDurationMasterMessage(
      List<DischargingStagesDuration> list) {
    List<LoadingPlanModels.StageDuration> durations = new ArrayList<>();
    for (DischargingStagesDuration dr : list) {
      LoadingPlanModels.StageDuration.Builder builder =
          LoadingPlanModels.StageDuration.newBuilder();
      builder.setId(dr.getId());
      builder.setDuration(dr.getDuration());
      durations.add(builder.build());
    }
    return durations;
  }

  public List<StageOffsets> buildStageOffsetMasterMessage(List<DischargingStagesMinAmount> list) {
    List<StageOffsets> offsets = new ArrayList<>();
    for (DischargingStagesMinAmount offset : list) {
      StageOffsets.Builder builder = StageOffsets.newBuilder();
      builder.setId(offset.getId());
      builder.setStageOffsetVal(offset.getMinAmount());
      offsets.add(builder.build());
    }
    return offsets;
  }

  public LoadingDelay buildLoadingDelayMessage(
      List<DischargingDelayReason> list, List<DischargingDelay> list6) {
    LoadingDelay.Builder builder = LoadingDelay.newBuilder();
    for (DischargingDelayReason var : list) {
      DelayReasons.Builder builder1 = DelayReasons.newBuilder();
      builder1.setId(var.getId());
      builder1.setReason(var.getReasonForDelay().getReason());
      builder.addReasons(builder1);
    }
    for (DischargingDelay var : list6) {
      List<DischargingDelayReason> activeReasons =
          var.getDischargingDelayReasons().stream()
              .filter(delay -> delay.getIsActive())
              .collect(Collectors.toList());
      var.setDischargingDelayReasons(
          new ArrayList<>()); // always set empty array, as the Lazy fetch not works :(
      if (!activeReasons.isEmpty()) {
        var.setDischargingDelayReasons(activeReasons);
      }
      LoadingDelays.Builder builder1 = LoadingDelays.newBuilder();
      builder1.setId(var.getId());
      Optional.ofNullable(var.getDischargingInformation().getId())
          .ifPresent(builder1::setLoadingInfoId);
      Optional.ofNullable(var.getDischargingDelayReasons())
          .ifPresent(
              v -> v.forEach(s -> builder1.addReasonForDelayIds(s.getReasonForDelay().getId())));
      Optional.ofNullable(var.getDuration())
          .ifPresent(value -> builder1.setDuration(value.toString()));
      Optional.ofNullable(var.getCargoXid()).ifPresent(builder1::setCargoId);
      Optional.ofNullable(var.getQuantity())
          .ifPresent(value -> builder1.setQuantity(value.toString()));
      Optional.ofNullable(var.getCargoNominationXid()).ifPresent(builder1::setCargoNominationId);
      builder.addDelays(builder1);
    }
    // Cargo List for drop down, at gate way
    return builder.build();
  }

  public List<LoadingPlanTankDetails> buildDischargingPlanTankBallastMessage(
      List<PortDischargingPlanBallastDetails> list) throws GenericServiceException {
    log.info("Discharging Plan, Ballast Builder");
    List<LoadingPlanTankDetails> response = new ArrayList<>();
    for (PortDischargingPlanBallastDetails var1 : list) {
      response.add(
          this.buildDischargingPlanTankBuilder(
              var1.getId(),
              null,
              null,
              null,
              var1.getQuantity(),
              var1.getTankXId(),
              null,
              var1.getQuantityM3(),
              var1.getSounding(),
              var1.getConditionType(),
              var1.getValueType(),
              var1.getColorCode(),
              null,
              null,
              var1.getSg()));
    }
    return response;
  }

  public List<LoadingPlanTankDetails> buildDischargingPlanTankStowageMessage(
      List<PortDischargingPlanStowageDetails> list) throws GenericServiceException {
    log.info("Loading Plan, Stowage Builder");
    List<LoadingPlanTankDetails> response = new ArrayList<>();
    for (PortDischargingPlanStowageDetails var1 : list) {
      response.add(
          this.buildDischargingPlanTankBuilder(
              var1.getId(),
              var1.getApi(),
              var1.getTemperature(),
              var1.getCargoNominationXId(),
              var1.getQuantity(),
              var1.getTankXId(),
              var1.getUllage(),
              var1.getQuantityM3(),
              null,
              var1.getConditionType(),
              var1.getValueType(),
              var1.getColorCode(),
              var1.getCargoXId(),
              var1.getAbbreviation(),
              null));
    }
    return response;
  }

  public List<LoadingPlanTankDetails> buildDischargingPlanTankRobMessage(
      List<PortDischargingPlanRobDetails> list) throws GenericServiceException {
    log.info("Discharging Plan, Rob Builder");
    List<LoadingPlanTankDetails> response = new ArrayList<>();
    for (PortDischargingPlanRobDetails var1 : list) {
      response.add(
          this.buildDischargingPlanTankBuilder(
              var1.getId(),
              null,
              null,
              null,
              var1.getQuantity(),
              var1.getTankXId(),
              null,
              var1.getQuantityM3(),
              null,
              var1.getConditionType(),
              var1.getValueType(),
              var1.getColorCode(),
              null,
              null,
              null));
    }
    return response;
  }

  public List<LoadingPlanModels.LoadingPlanStabilityParameters>
      buildDischargingPlanTankStabilityMessage(List<PortDischargingPlanStabilityParameters> list)
          throws GenericServiceException {
    log.info("Discharging Plan, Rob Builder");
    List<LoadingPlanModels.LoadingPlanStabilityParameters> response = new ArrayList<>();
    for (PortDischargingPlanStabilityParameters var1 : list) {
      response.add(
          this.buildDischargingPlanStabilityBuilder(
              var1.getForeDraft(),
              var1.getMeanDraft(),
              var1.getAftDraft(),
              var1.getTrim(),
              var1.getBendingMoment(),
              var1.getShearingForce(),
              var1.getConditionType(),
              var1.getValueType(),
              var1.getFreeboard(),
              var1.getManifoldHeight()));
    }
    return response;
  }

  private LoadingPlanModels.LoadingPlanStabilityParameters buildDischargingPlanStabilityBuilder(
      BigDecimal foreDraft,
      BigDecimal meanDraft,
      BigDecimal aftDraft,
      BigDecimal trim,
      BigDecimal bm,
      BigDecimal sf,
      Integer conditionType,
      Integer valueType,
      BigDecimal freeboard,
      BigDecimal manifoldHeight)
      throws GenericServiceException {
    try {
      LoadingPlanModels.LoadingPlanStabilityParameters builder =
          LoadingPlanModels.LoadingPlanStabilityParameters.newBuilder()
              .setForeDraft(foreDraft != null ? foreDraft.toString() : "")
              .setMeanDraft(meanDraft != null ? meanDraft.toString() : "")
              .setAftDraft(aftDraft != null ? aftDraft.toString() : "")
              .setTrim(trim != null ? trim.toString() : "")
              .setBm(bm != null ? bm.toString() : "")
              .setSf(sf != null ? sf.toString() : "")
              .setConditionType(conditionType != null ? conditionType : 0)
              .setValueType(valueType != null ? valueType : 0)
              .setFreeboard(freeboard != null ? freeboard.toString() : "")
              .setManifoldHeight(manifoldHeight != null ? manifoldHeight.toString() : "")
              .build();
      return builder;
    } catch (Exception e) {
      e.printStackTrace();
      throw new GenericServiceException(
          "DischargingPlanStabilityParameters Object Build failed",
          CommonErrorCodes.E_HTTP_BAD_REQUEST,
          HttpStatusCode.BAD_REQUEST);
    }
  }

  private LoadingPlanTankDetails buildDischargingPlanTankBuilder(
      Long id,
      BigDecimal api,
      BigDecimal temp,
      Long nominationId,
      BigDecimal quantity,
      Long tankId,
      BigDecimal ullage,
      BigDecimal quantityM3,
      BigDecimal sounding,
      Integer conditionType,
      Integer valueType,
      String colorCode,
      Long cargoId,
      String abbreviation,
      BigDecimal bigDecimal)
      throws GenericServiceException {

    try {
      LoadingPlanTankDetails builder =
          LoadingPlanTankDetails.newBuilder()
              .setId(id != null ? id : 0)
              .setApi(api != null ? api.toString() : "")
              .setTemperature(temp != null ? temp.toString() : "")
              .setCargoNominationId(nominationId != null ? nominationId : 0)
              .setQuantity(quantity != null ? quantity.toString() : "")
              .setTankId(tankId != null ? tankId : 0)
              .setUllage(ullage != null ? ullage.toString() : "")
              .setQuantityM3(quantityM3 != null ? quantityM3.toString() : "")
              .setSounding(sounding != null ? sounding.toString() : "")
              .setConditionType(conditionType != null ? conditionType : 0)
              .setValueType(valueType != null ? valueType : 0)
              .setColorCode(colorCode != null ? colorCode : "")
              .setCargoId(cargoId != null ? cargoId : 0L)
              .setAbbreviation(abbreviation != null ? abbreviation : "")
              .setSg(bigDecimal != null ? bigDecimal.toString() : "0")
              .build();
      return builder;
    } catch (Exception e) {
      e.printStackTrace();
      throw new GenericServiceException(
          "LoadingPlanTankDetails Object Build failed",
          CommonErrorCodes.E_HTTP_BAD_REQUEST,
          HttpStatusCode.BAD_REQUEST);
    }
  }

  public void buildDischargeDetailsMessageFromEntity(
      DischargeInformation disEntity,
      com.cpdss.common.generated.discharge_plan.DischargeInformation.Builder builder) {
    try {
      DischargeDetails.Builder builder1 = DischargeDetails.newBuilder();
      builder1.setId(disEntity.getId());
      Optional.ofNullable(disEntity.getSunriseTime())
          .ifPresent(v -> builder1.setTimeOfSunrise(v.toString()));
      Optional.ofNullable(disEntity.getSunsetTime())
          .ifPresent(v -> builder1.setTimeOfSunset(v.toString()));
      Optional.ofNullable(disEntity.getStartTime())
          .ifPresent(v -> builder1.setStartTime(v.toString()));
      builder1.setVoyageId(disEntity.getVoyageXid());

      // Set Trim Values
      LoadingPlanModels.TrimAllowed.Builder trimAllowed =
          LoadingPlanModels.TrimAllowed.newBuilder();
      Optional.ofNullable(disEntity.getInitialTrim())
          .ifPresent(v -> trimAllowed.setInitialTrim(v.toString()));
      Optional.ofNullable(disEntity.getMaximumTrim())
          .ifPresent(v -> trimAllowed.setMaximumTrim(v.toString()));
      Optional.ofNullable(disEntity.getFinalTrim())
          .ifPresent(v -> trimAllowed.setFinalTrim(v.toString()));

      builder1.setTrimAllowed(trimAllowed.build());

      Optional.ofNullable(disEntity.getCommonDate())
          .ifPresent(commonDate -> builder1.setCommonDate(String.valueOf(commonDate)));

      Optional.ofNullable(disEntity.getSlopQuantity())
          .ifPresent(slopQuantity -> builder1.setSlopQuantity(slopQuantity.toString()));

      builder.setDischargeDetails(builder1.build());
      log.info("Setting Discharge Details");
    } catch (Exception e) {
      log.error("Failed to set Discharge Details {}", e.getMessage());
      e.printStackTrace();
    }
  }

  public void buildDischargeRateMessageFromEntity(
      DischargeInformation disEntity,
      com.cpdss.common.generated.discharge_plan.DischargeInformation.Builder builder) {
    try {
      DischargeRates.Builder builder1 = DischargeRates.newBuilder();
      Optional.ofNullable(disEntity.getInitialDischargingRate())
          .ifPresent(v -> builder1.setInitialDischargeRate(v.toString()));
      Optional.ofNullable(disEntity.getMaxDischargingRate())
          .ifPresent(v -> builder1.setMaxDischargeRate(v.toString()));
      Optional.ofNullable(disEntity.getMinBallastRate())
          .ifPresent(v -> builder1.setMinBallastRate(v.toString()));
      Optional.ofNullable(disEntity.getMaxBallastRate())
          .ifPresent(v -> builder1.setMaxBallastRate(v.toString()));
      Optional.ofNullable(disEntity.getId()).ifPresent(builder1::setId);

      builder.setDischargeRate(builder1.build());
      log.info("Setting Discharge Rates");
    } catch (Exception e) {
      log.error("Failed to set Discharge Rates {}", e.getMessage());
      e.printStackTrace();
    }
  }

  /**
   * Builds discharge berth details from entity to grpc builder
   *
   * @param disEntity discharge information entity
   * @param dischargingBerthDetails list of discharging berth details entity
   * @param builder discharge information proto builder
   */
  public void buildDischargeBerthMessageFromEntity(
      DischargeInformation disEntity,
      List<DischargingBerthDetail> dischargingBerthDetails,
      com.cpdss.common.generated.discharge_plan.DischargeInformation.Builder builder) {

    log.info("Inside buildDischargeBerthMessageFromEntity method!");

    if (!dischargingBerthDetails.isEmpty()) {
      try {
        for (DischargingBerthDetail dischargingBerthDetail : dischargingBerthDetails) {

          DischargeBerths.Builder dischargeBerthsBuilder = DischargeBerths.newBuilder();

          // Set fields
          Optional.ofNullable(disEntity.getId())
              .ifPresent(dischargeBerthsBuilder::setDischargeInfoId);
          Optional.ofNullable(dischargingBerthDetail.getId())
              .ifPresent(dischargeBerthsBuilder::setId);
          Optional.ofNullable(dischargingBerthDetail.getBerthXid())
              .ifPresent(dischargeBerthsBuilder::setBerthId);
          Optional.ofNullable(dischargingBerthDetail.getDepth())
              .ifPresent(depth -> dischargeBerthsBuilder.setDepth(depth.toString()));
          Optional.ofNullable(dischargingBerthDetail.getMaxManifoldHeight())
              .ifPresent(height -> dischargeBerthsBuilder.setMaxManifoldHeight(height.toString()));
          Optional.ofNullable(dischargingBerthDetail.getMaxManifoldPressure())
              .ifPresent(
                  pressure -> dischargeBerthsBuilder.setMaxManifoldPressure(pressure.toString()));
          Optional.ofNullable(dischargingBerthDetail.getHoseConnections())
              .ifPresent(dischargeBerthsBuilder::setHoseConnections);
          Optional.ofNullable(dischargingBerthDetail.getSeaDraftLimitation())
              .ifPresent(draft -> dischargeBerthsBuilder.setSeaDraftLimitation(draft.toString()));

          Optional.ofNullable(dischargingBerthDetail.getSeaDraftLimitation())
              .ifPresent(draft -> dischargeBerthsBuilder.setSeaDraftLimitation(draft.toString()));
          Optional.ofNullable(dischargingBerthDetail.getAirDraftLimitation())
              .ifPresent(draft -> dischargeBerthsBuilder.setAirDraftLimitation(draft.toString()));

          // Regarding DSS-5899 : cargo circulation and air purge check boxes combined to a single
          // field in UI. But algo needs both flags.
          Optional.ofNullable(dischargingBerthDetail.getIsAirPurge())
              .ifPresent(dischargeBerthsBuilder::setAirPurge);
          Optional.ofNullable(dischargingBerthDetail.getIsCargoCirculation())
              .ifPresent(dischargeBerthsBuilder::setCargoCirculation);
          Optional.ofNullable(dischargingBerthDetail.getLineContentDisplacement())
              .ifPresent(
                  displacement ->
                      dischargeBerthsBuilder.setLineDisplacement(displacement.toString()));
          Optional.ofNullable(dischargingBerthDetail.getSpecialRegulationRestriction())
              .ifPresent(dischargeBerthsBuilder::setSpecialRegulationRestriction);
          Optional.ofNullable(dischargingBerthDetail.getItemToBeAgreed())
              .ifPresent(dischargeBerthsBuilder::setItemsToBeAgreedWith);
          Optional.ofNullable(dischargingBerthDetail.getDisplacement())
              .ifPresent(
                  displacement -> dischargeBerthsBuilder.setDisplacement(displacement.toString()));
          Optional.ofNullable(dischargingBerthDetail.getEnableDayLightRestriction())
              .ifPresent(dischargeBerthsBuilder::setEnableDayLightRestriction);
          Optional.ofNullable(dischargingBerthDetail.getNeedFlushingOilAndCrudeStorage())
              .ifPresent(dischargeBerthsBuilder::setNeedFlushingOilAndCrudeStorage);
          Optional.ofNullable(dischargingBerthDetail.getFreshCrudeOilQuantity())
              .ifPresent(
                  quantity ->
                      dischargeBerthsBuilder.setFreshCrudeOilQuantity(String.valueOf(quantity)));
          Optional.ofNullable(dischargingBerthDetail.getFreshCrudeOilTime())
              .ifPresent(time -> dischargeBerthsBuilder.setFreshCrudeOilTime(String.valueOf(time)));

          builder.addBerthDetails(dischargeBerthsBuilder.build());
        }
        log.info("Setting Discharge berths");
      } catch (Exception e) {
        log.error("Failed to set Discharge Berths {}", e.getMessage());
        e.printStackTrace();
      }
    }
  }

  /**
   * Method to build Discharge stage
   *
   * @param disEntity DischargeInformation object
   * @param builder DischargeInformation.Builder object
   */
  public void buildDischargeStageMessageFromEntity(
      DischargeInformation disEntity,
      com.cpdss.common.generated.discharge_plan.DischargeInformation.Builder builder) {

    log.info("Inside buildDischargeStageMessageFromEntity method!");
    try {
      LoadingPlanModels.LoadingStages.Builder builder1 =
          LoadingPlanModels.LoadingStages.newBuilder();

      // Set fields
      Optional.ofNullable(disEntity.getId()).ifPresent(builder1::setId);
      Optional.ofNullable(disEntity.getDischargingStagesMinAmount())
          .ifPresent(v -> builder1.setStageOffset(v.getId().intValue()));
      Optional.ofNullable(disEntity.getDischargingStagesDuration())
          .ifPresent(v -> builder1.setStageDuration(v.getId().intValue()));
      Optional.ofNullable(disEntity.getIsTrackStartEndStage())
          .ifPresent(builder1::setTrackStartEndStage);
      Optional.ofNullable(disEntity.getIsTrackGradeSwitching())
          .ifPresent(builder1::setTrackGradeSwitch);

      // Set flags for check boxes
      Optional.ofNullable(disEntity.getIsStageDurationUsed())
          .ifPresent(builder1::setIsStageDurationUsed);
      Optional.ofNullable(disEntity.getIsStageOffsetUsed())
          .ifPresent(builder1::setIsStageOffsetUsed);

      // Master data Offset
      List<DischargingStagesDuration> var1 =
          dischargeStageDurationRepository.findAllByIsActiveTrueOrderByDuration();
      this.buildStageDurationMasterDataToMessage(var1, builder1);

      // Master data duration
      List<DischargingStagesMinAmount> var2 =
          dischargeStageMinAmountRepository.findAllByIsActiveTrueOrderByMinAmount();
      this.buildStageMinAmountMasterDataToMessage(var2, builder1);

      builder.setDischargeStage(builder1.build());
      log.info("Setting Discharge Stages");
    } catch (Exception e) {
      log.error("Failed to set Discharge Berths {}", e.getMessage());
      e.printStackTrace();
    }
  }

  // Offset Value
  private void buildStageMinAmountMasterDataToMessage(
      List<DischargingStagesMinAmount> var1, LoadingPlanModels.LoadingStages.Builder builder1) {
    for (DischargingStagesMinAmount var2 : var1) {
      LoadingPlanModels.StageOffsets.Builder offsets = LoadingPlanModels.StageOffsets.newBuilder();
      offsets.setId(var2.getId());
      offsets.setStageOffsetVal(var2.getMinAmount());
      builder1.addStageOffsets(offsets.build());
    }
  }

  // Duration
  private void buildStageDurationMasterDataToMessage(
      List<DischargingStagesDuration> var2, LoadingPlanModels.LoadingStages.Builder builder1) {
    for (DischargingStagesDuration dr : var2) {
      LoadingPlanModels.StageDuration.Builder builder =
          LoadingPlanModels.StageDuration.newBuilder();
      builder.setId(dr.getId());
      builder.setDuration(dr.getDuration());
      builder1.addStageDurations(builder.build());
    }
  }

  public void buildDischargeDelaysMessageFromEntity(
      DischargeInformation disEntity,
      com.cpdss.common.generated.discharge_plan.DischargeInformation.Builder builder) {

    DischargeDelay.Builder builder1 = DischargeDelay.newBuilder();

    try {
      // Set Master data of Reasons
      List<ReasonForDelay> list = this.reasonForDelayRepository.findAllByIsActiveTrue();
      for (ReasonForDelay var : list) {
        LoadingPlanModels.DelayReasons.Builder reason = LoadingPlanModels.DelayReasons.newBuilder();
        reason.setId(var.getId());
        reason.setReason(var.getReason());
        builder1.addReasons(reason.build());
      }
      log.info("Setting Delay Reasons (master)");
    } catch (Exception e) {
      log.error("Failed to set Discharge Delay Reasons (master) {}", e.getMessage());
      e.printStackTrace();
    }

    try {
      List<DischargingDelay> delays =
          this.dischargingDelayRepository.findAllByDischargingInformation_IdAndIsActiveOrderById(
              disEntity.getId(), true);
      for (DischargingDelay source : delays) {
        DischargeDelays.Builder builder2 = DischargeDelays.newBuilder();
        builder2.setId(source.getId());
        builder2.setDischargeInfoId(disEntity.getId());
        builder2.setDuration(source.getDuration().toString());
        Optional.ofNullable(source.getQuantity())
            .ifPresent(value -> builder2.setQuantity(value.toString()));
        Optional.ofNullable(source.getCargoXid())
            .ifPresent(builder2::setCargoId); // can empty of initial delay
        Optional.ofNullable(source.getCargoNominationXid())
            .ifPresent(builder2::setCargoNominationId); // can empty of initial delay
        builder2.addAllReasonForDelayIds(
            source.getDischargingDelayReasons().stream()
                .filter(DischargingDelayReason::getIsActive)
                .map(DischargingDelayReason::getReasonForDelay)
                .map(ReasonForDelay::getId)
                .collect(Collectors.toList()));
        Optional.ofNullable(source.getSequenceNo()).ifPresent(builder2::setSequenceNo);
        Optional.ofNullable(source.getDischargingRate())
            .ifPresent(dischargingRate -> builder2.setDischargingRate(dischargingRate.toString()));
        builder1.addDelays(builder2.build());
      }
      log.info("Setting Delay Reasons");
    } catch (Exception e) {
      log.error("Failed to set Discharge Delay Reasons {}", e.getMessage());
      e.printStackTrace();
    }
    builder.setDischargeDelay(builder1.build());
  }

  public void buildPostDischargeStageMessageFromEntity(
      DischargeInformation disEntity,
      com.cpdss.common.generated.discharge_plan.DischargeInformation.Builder builder) {
    try {
      PostDischargeStageTime.Builder builder1 = PostDischargeStageTime.newBuilder();
      Optional.ofNullable(disEntity.getTimeForDryCheck())
          .ifPresent(v -> builder1.setTimeForDryCheck(v.toString()));
      Optional.ofNullable(disEntity.getTimeForSlopDischarging())
          .ifPresent(v -> builder1.setSlopDischarging(v.toString()));
      Optional.ofNullable(disEntity.getTimeForFinalStripping())
          .ifPresent(v -> builder1.setFinalStripping(v.toString()));
      Optional.ofNullable(disEntity.getFreshOilWashing())
          .ifPresent(v -> builder1.setFreshOilWashing(v.toString()));
      builder.setPostDischargeStageTime(builder1.build());
      log.info("Setting Post Discharge stage");
    } catch (Exception e) {
      log.error("Failed to Set Post Discharge stage");
      e.printStackTrace();
    }
  }

  public void buildMachineInUseMessageFromEntity(
      DischargeInformation disEntity,
      com.cpdss.common.generated.discharge_plan.DischargeInformation.Builder builder) {
    try {
      List<DischargingMachineryInUse> list =
          dischargingMachineryInUseRepository.findAllByDischargingInfoId(disEntity.getId());
      for (DischargingMachineryInUse var1 : list) {
        LoadingPlanModels.LoadingMachinesInUse.Builder builder1 =
            LoadingPlanModels.LoadingMachinesInUse.newBuilder();
        builder1.setId(var1.getId());
        builder1.setLoadingInfoId(disEntity.getId());
        builder1.setMachineId(var1.getMachineXid());
        builder1.setMachineTypeValue(var1.getMachineTypeXid());
        Optional.ofNullable(var1.getCapacity())
            .ifPresent(value -> builder1.setCapacity(value.toString()));
        builder1.setIsUsing(var1.getIsUsing());
        builder.addMachineInUse(builder1.build());
      }
      log.info("Setting Machine in use");
    } catch (Exception e) {
      log.error("Failed to Set Machine In Use");
      e.printStackTrace();
    }
  }

  public void buildCowPlanMessageFromEntity(
      DischargeInformation disEntity,
      com.cpdss.common.generated.discharge_plan.DischargeInformation.Builder builder) {
    try {
      CowPlan.Builder builder1 = CowPlan.newBuilder();
      Optional<CowPlanDetail> cpdOpt =
          this.cowPlanDetailRepository.findByDischargingId(disEntity.getId());
      if (cpdOpt.isPresent()) {
        CowPlanDetail cpd = cpdOpt.get();
        Optional.ofNullable(cpd.getCowOperationType())
            .ifPresent(v -> builder1.setCowOptionType(Common.COW_OPTION_TYPE.forNumber(v)));
        Optional.ofNullable(cpd.getCowPercentage())
            .ifPresent(v -> builder1.setCowTankPercent(v.toString()));

        Optional.ofNullable(cpd.getCowPercentage())
            .ifPresent(v -> builder1.setCowTankPercent(v.toString()));
        Optional.ofNullable(cpd.getCowStartTime())
            .ifPresent(v -> builder1.setCowStartTime(v.toString()));
        Optional.ofNullable(cpd.getCowEndTime())
            .ifPresent(v -> builder1.setCowEndTime(v.toString()));
        Optional.ofNullable(cpd.getEstimatedCowDuration())
            .ifPresent(v -> builder1.setEstCowDuration(v.toString()));

        Optional.ofNullable(cpd.getCowMinTrim())
            .ifPresent(v -> builder1.setTrimCowMin(v.toString()));
        Optional.ofNullable(cpd.getCowMaxTrim())
            .ifPresent(v -> builder1.setTrimCowMax(v.toString()));

        Optional.ofNullable(cpd.getNeedFreshCrudeStorage())
            .ifPresent(builder1::setNeedFreshCrudeStorage);
        Optional.ofNullable(cpd.getNeedFlushingOil()).ifPresent(builder1::setNeedFlushingOil);

        Optional.ofNullable(cpd.getWashTankWithDifferentCargo())
            .ifPresent(
                builder1::setCowWithCargoEnable); // radio button for enable/disable CWC section
        Optional.ofNullable(cpd.getEnableDayLightRestriction())
            .ifPresent(builder1::setEnableDayLightRestriction);
        // tank wise details
        if (!cpd.getCowTankDetails().isEmpty()) {
          this.buildCowTankDetails(
              Common.COW_TYPE.TOP_COW,
              builder1,
              cpd.getCowTankDetails().stream()
                  .filter(CowTankDetail::getIsActive)
                  .filter(v -> v.getCowTypeXid().equals(Common.COW_TYPE.TOP_COW_VALUE))
                  .collect(Collectors.toList()));
          this.buildCowTankDetails(
              Common.COW_TYPE.BOTTOM_COW,
              builder1,
              cpd.getCowTankDetails().stream()
                  .filter(CowTankDetail::getIsActive)
                  .filter(v -> v.getCowTypeXid().equals(Common.COW_TYPE.BOTTOM_COW_VALUE))
                  .collect(Collectors.toList()));
          this.buildCowTankDetails(
              Common.COW_TYPE.ALL_COW,
              builder1,
              cpd.getCowTankDetails().stream()
                  .filter(CowTankDetail::getIsActive)
                  .filter(v -> v.getCowTypeXid().equals(Common.COW_TYPE.ALL_COW_VALUE))
                  .collect(Collectors.toList()));
        }
        if (!cpd.getCowWithDifferentCargos().isEmpty()) {
          this.buildCowTankDetails(
              Common.COW_TYPE.CARGO, builder1, cpd.getCowWithDifferentCargos());
        }
      } else {
        log.error("Cow data not found for Discharge info {}", disEntity.getId());
      }
      builder.setCowPlan(builder1.build());
    } catch (Exception e) {
      log.error("Failed to set cow plan");
      e.printStackTrace();
    }
  }

  private void buildCowTankDetails(
      final Common.COW_TYPE cow_type, CowPlan.Builder builder, Collection list) {
    CowTankDetails.Builder tankDetails = CowTankDetails.newBuilder();
    tankDetails.setCowType(cow_type);
    switch (cow_type) {
      case TOP_COW:
      case BOTTOM_COW:
      case ALL_COW:
        {
          List<CowTankDetail> ls1 = new ArrayList<>(list); // cast from generic list
          var ids = ls1.stream().map(CowTankDetail::getTankXid).collect(Collectors.toList());
          tankDetails.addAllTankIds(ids);
        }
        break;
      case CARGO:
        {
          List<CowWithDifferentCargo> ls1 = new ArrayList<>(list); // cast from generic list
          List<CowWithDifferentCargo> activeCowWithCargos =
              ls1.stream()
                  .filter(cow -> cow.getIsActive() != null && cow.getIsActive())
                  .collect(Collectors.toList());
          var gp1 =
              activeCowWithCargos.stream()
                  .collect(
                      Collectors.groupingBy(CowWithDifferentCargo::getCargoXid)); // group by cargo
          for (Map.Entry<Long, List<CowWithDifferentCargo>> map1 : gp1.entrySet()) {
            CowWithDifferentCargo firstItem = map1.getValue().stream().findFirst().get();
            CargoForCow.Builder cargoForCow = CargoForCow.newBuilder();
            cargoForCow.setCargoId(firstItem.getCargoXid());
            cargoForCow.setCargoNominationId(firstItem.getCargoNominationXid());
            cargoForCow.setWashingCargoId(firstItem.getWashingCargoXid());
            cargoForCow.setWashingCargoNominationId(firstItem.getWashingCargoNominationXid());
            cargoForCow.addAllTankIds(
                map1.getValue().stream()
                    .map(CowWithDifferentCargo::getTankXid)
                    .collect(Collectors.toList()));
            tankDetails.addCargoForCow(cargoForCow.build());
          }
        }
        break;
      default:
        {
          log.info("Default case for build cow tank details");
        }
    }
    builder.addCowTankDetails(tankDetails.build());
  }

  /**
   * @param dStudyRulesList
   * @param rulePlanBuilder
   * @param builder
   * @param vesselRuleReply
   */
  public void buildResponseForDSRules(
      List<DischargePlanRules> dStudyRulesList,
      Common.RulePlans.Builder rulePlanBuilder,
      DischargeRuleReply.Builder builder,
      VesselInfo.VesselRuleReply vesselRuleReply) {
    dStudyRulesList.forEach(
        ruleList -> {
          // for (int ruleIndex = 0; ruleIndex < lStudyRulesList.size(); ruleIndex++) {
          Common.Rules.Builder rulesBuilder = Common.Rules.newBuilder();
          Optional.ofNullable(ruleList.getIsEnable())
              .ifPresentOrElse(rulesBuilder::setEnable, () -> rulesBuilder.setEnable(false));
          Optional.ofNullable(ruleList.getDisplayInSettings())
              .ifPresentOrElse(
                  rulesBuilder::setDisplayInSettings,
                  () -> rulesBuilder.setDisplayInSettings(false));
          Optional.ofNullable(ruleList.getId())
              .ifPresentOrElse(
                  item -> rulesBuilder.setId(String.valueOf(item)), () -> rulesBuilder.setId(""));
          Optional.ofNullable(ruleList.getRuleTypeXId())
              .filter(item -> item.equals(RuleType.ABSOLUTE.getId()))
              .ifPresentOrElse(
                  item -> rulesBuilder.setRuleType(RuleType.ABSOLUTE.getRuleType()),
                  () -> rulesBuilder.setRuleType(RuleType.PREFERABLE.getRuleType()));
          Optional.ofNullable(ruleList.getIsHardRule())
              .ifPresentOrElse(
                  rulesBuilder::setIsHardRule, () -> rulesBuilder.setIsHardRule(false));
          Optional.ofNullable(ruleList.getVesselRuleXId())
              .ifPresentOrElse(
                  item -> rulesBuilder.setVesselRuleXId(String.valueOf(item)),
                  () -> rulesBuilder.setVesselRuleXId(""));
          Optional.ofNullable(ruleList.getParentRuleXId())
              .ifPresentOrElse(
                  item -> rulesBuilder.setRuleTemplateId(String.valueOf(item)),
                  () -> rulesBuilder.setRuleTemplateId(""));
          Optional.ofNullable(ruleList.getNumericPrecision())
              .ifPresentOrElse(
                  rulesBuilder::setNumericPrecision, () -> rulesBuilder.setNumericPrecision(0));
          Optional.ofNullable(ruleList.getNumericScale())
              .ifPresentOrElse(
                  rulesBuilder::setNumericScale, () -> rulesBuilder.setNumericScale(0));
          Common.RulesInputs.Builder ruleInput = Common.RulesInputs.newBuilder();
          List<DischargePlanRuleInput> loadableStudyRuleInputs;
          if (ruleList != null && ruleList.getDischargePlanRuleInputList().size() != 0) {
            loadableStudyRuleInputs =
                ruleList.getDischargePlanRuleInputList().stream()
                    .sorted(Comparator.comparingLong(DischargePlanRuleInput::getId))
                    .collect(Collectors.toList());
          } else {
            loadableStudyRuleInputs = new ArrayList<>();
          }
          for (int inputIndex = 0; inputIndex < loadableStudyRuleInputs.size(); inputIndex++) {
            Common.RulesInputs.Builder finalRuleInput = ruleInput;
            DischargePlanRuleInput input = loadableStudyRuleInputs.get(inputIndex);
            Optional.ofNullable(input.getDefaultValue())
                .filter(item -> item.trim().length() != 0)
                .ifPresentOrElse(
                    finalRuleInput::setDefaultValue, () -> finalRuleInput.setDefaultValue(""));
            Optional.ofNullable(input.getPrefix())
                .filter(item -> item.trim().length() != 0)
                .ifPresentOrElse(finalRuleInput::setPrefix, () -> finalRuleInput.setPrefix(""));
            Optional.ofNullable(input.getMinValue())
                .filter(item -> item.trim().length() != 0)
                .ifPresentOrElse(finalRuleInput::setMin, () -> finalRuleInput.setMin(""));
            Optional.ofNullable(input.getMaxValue())
                .filter(item -> item.trim().length() != 0)
                .ifPresentOrElse(finalRuleInput::setMax, () -> finalRuleInput.setMax(""));
            Optional.ofNullable(input.getTypeValue())
                .filter(item -> item.trim().length() != 0)
                .ifPresentOrElse(finalRuleInput::setType, () -> finalRuleInput.setType(""));
            Optional.ofNullable(input.getSuffix())
                .filter(item -> item.trim().length() != 0)
                .ifPresentOrElse(finalRuleInput::setSuffix, () -> finalRuleInput.setSuffix(""));
            Optional.ofNullable(input.getId())
                .ifPresentOrElse(
                    item -> finalRuleInput.setId(String.valueOf(item)),
                    () -> finalRuleInput.setId(""));
            Optional.ofNullable(input.getIsMandatory())
                .ifPresentOrElse(
                    finalRuleInput::setIsMandatory, () -> finalRuleInput.setIsMandatory(false));
            Optional<String> isTypeBoolean =
                Optional.ofNullable(input.getTypeValue())
                    .filter(
                        item ->
                            item.trim().length() != 0
                                && item.trim()
                                    .equalsIgnoreCase(
                                        com.cpdss.dischargeplan.domain.TypeValue.BOOLEAN
                                            .getType()));
            if (isTypeBoolean.isPresent()) {
              Optional.ofNullable(input.getDefaultValue())
                  .filter(item -> item.trim().length() != 0 && item.trim().equalsIgnoreCase("true"))
                  .ifPresentOrElse(
                      ruleInput::setDefaultValue, () -> ruleInput.setDefaultValue("false"));
            }
            Optional<String> isTypeDropDownOrMultiSelect =
                Optional.ofNullable(input.getTypeValue())
                    .filter(
                        item ->
                            item.trim().length() != 0
                                    && item.trim()
                                        .equalsIgnoreCase(
                                            com.cpdss.dischargeplan.domain.TypeValue.DROPDOWN
                                                .getType())
                                || item.trim()
                                    .equalsIgnoreCase(
                                        com.cpdss.dischargeplan.domain.TypeValue.MULTISELECT
                                            .getType()));
            if (isTypeDropDownOrMultiSelect.isPresent()) {
              Optional<String> isPrefixExist =
                  Optional.ofNullable(input.getPrefix())
                      .filter(
                          item ->
                              item.trim().length() != 0
                                  && item.trim()
                                      .equalsIgnoreCase(RuleMasterData.CargoTank.getPrefix()));
              Optional<String> isSuffixExist =
                  Optional.ofNullable(input.getSuffix())
                      .filter(
                          item ->
                              item.trim().length() != 0
                                  && item.trim()
                                      .equalsIgnoreCase(RuleMasterData.CargoTank.getSuffix()));
              Common.RuleDropDownMaster.Builder ruleDropDownMaster =
                  Common.RuleDropDownMaster.newBuilder();
              if (isSuffixExist.isPresent() && isPrefixExist.isPresent()) {
                vesselRuleReply
                    .getCargoTankMasterList()
                    .forEach(
                        cargoTank -> {
                          Optional.ofNullable(cargoTank.getId())
                              .ifPresent(ruleDropDownMaster::setId);
                          Optional.ofNullable(cargoTank.getShortName())
                              .ifPresentOrElse(
                                  ruleDropDownMaster::setValue,
                                  () -> ruleDropDownMaster.setValue(""));
                          ruleInput.addRuleDropDownMaster(ruleDropDownMaster.build());
                        });
              } else {
                Optional<Long> ruleTempId = Optional.ofNullable(ruleList.getParentRuleXId());
                if (ruleTempId.isPresent()) {
                  List<VesselInfo.RuleDropDownValueMaster> filterMasterByRule =
                      vesselRuleReply.getRuleDropDownValueMasterList().stream()
                          .filter(
                              rDropDown ->
                                  rDropDown.getRuleTemplateId() != 0
                                      && ruleTempId.get() != null
                                      && rDropDown.getRuleTemplateId() == ruleTempId.get())
                          .collect(Collectors.toList());
                  filterMasterByRule.forEach(
                      masterDropDownRule -> {
                        Optional.ofNullable(masterDropDownRule.getId())
                            .ifPresent(ruleDropDownMaster::setId);
                        Optional.ofNullable(masterDropDownRule.getValue())
                            .ifPresent(ruleDropDownMaster::setValue);
                        ruleInput.addRuleDropDownMaster(ruleDropDownMaster.build());
                      });
                }
              }
            }
            rulesBuilder.addInputs(finalRuleInput.build());
          }
          rulePlanBuilder.addRules(rulesBuilder.build());
        });
    builder.addRulePlan(rulePlanBuilder);
  }

  public void buildResponseForDefaultDSRules(
      VesselInfo.VesselRuleReply vesselRuleReply, DischargeRuleReply.Builder builder) {
    vesselRuleReply
        .getRulePlanList()
        .forEach(
            rulePlans -> {
              Common.RulePlans.Builder rulePlanBuilder = Common.RulePlans.newBuilder();
              Optional.ofNullable(rulePlans.getHeader()).ifPresent(rulePlanBuilder::setHeader);
              List<Common.Rules> ruleList =
                  rulePlans.getRulesList().stream().collect(Collectors.toList());
              if (ruleList != null && ruleList.size() > 0) {
                rulePlanBuilder.addAllRules(ruleList);
                builder.addRulePlan(rulePlanBuilder);
              }
            });
  }

  /**
   * Building PortDischargingPlanRobDetailsReply
   *
   * @param portDischargingPlanRobDetailsList
   * @return List<com.cpdss.common.generated.discharge_plan.PortDischargingPlanRobDetails>
   */
  public List<com.cpdss.common.generated.discharge_plan.PortDischargingPlanRobDetails>
      buildPortDischargingPlanRobDetailsReply(
          List<PortDischargingPlanRobDetails> portDischargingPlanRobDetailsList) {
    List<com.cpdss.common.generated.discharge_plan.PortDischargingPlanRobDetails>
        detailsListGenerated = new ArrayList<>();
    portDischargingPlanRobDetailsList.forEach(
        detail ->
            detailsListGenerated.add(
                com.cpdss.common.generated.discharge_plan.PortDischargingPlanRobDetails.newBuilder()
                    .setConditionType(detail.getConditionType())
                    .setPortXId(detail.getPortXId())
                    .setTankXId(detail.getTankXId())
                    .setPortRotationXId(detail.getPortRotationXId())
                    .setQuantity(detail.getQuantity().doubleValue())
                    .setDensity(detail.getDensity().doubleValue())
                    .build()));
    return detailsListGenerated;
  }

  /**
   * @param plpCommingleList
   * @return
   * @throws GenericServiceException
   */
  public List<LoadingPlanCommingleDetails> buildDischargingPlanCommingleMessage(
      List<PortDischargingPlanCommingleDetails> plpCommingleList) throws GenericServiceException {
    List<LoadingPlanCommingleDetails> portLoadingPlanCommingleDetails = new ArrayList<>();
    try {
      plpCommingleList.forEach(
          commingle -> {
            LoadingPlanCommingleDetails.Builder builder = LoadingPlanCommingleDetails.newBuilder();
            Optional.ofNullable(commingle.getGrade()).ifPresent(builder::setAbbreviation);
            Optional.ofNullable(commingle.getApi()).ifPresent(builder::setApi);
            Optional.ofNullable(commingle.getCargo1XId()).ifPresent(builder::setCargo1Id);
            Optional.ofNullable(commingle.getCargo2XId()).ifPresent(builder::setCargo2Id);
            Optional.ofNullable(commingle.getCargoNomination1XId())
                .ifPresent(builder::setCargoNomination1Id);
            Optional.ofNullable(commingle.getCargoNomination2XId())
                .ifPresent(builder::setCargoNomination2Id);
            Optional.ofNullable(commingle.getId()).ifPresent(builder::setId);
            Optional.ofNullable(commingle.getQuantity()).ifPresent(builder::setQuantityMT);
            Optional.ofNullable(commingle.getQuantityM3()).ifPresent(builder::setQuantityM3);
            Optional.ofNullable(commingle.getTankId()).ifPresent(builder::setTankId);
            Optional.ofNullable(commingle.getTemperature()).ifPresent(builder::setTemperature);
            Optional.ofNullable(commingle.getUllage()).ifPresent(builder::setUllage);
            Optional.ofNullable(commingle.getConditionType()).ifPresent(builder::setConditionType);
            Optional.ofNullable(commingle.getValueType()).ifPresent(builder::setValueType);
            Optional.ofNullable(commingle.getColorCode()).ifPresent(builder::setColorCode);
            portLoadingPlanCommingleDetails.add(builder.build());
          });
    } catch (Exception e) {
      e.printStackTrace();
      throw new GenericServiceException(
          "LoadingPlanCommingleDetails Object Build failed",
          CommonErrorCodes.E_HTTP_BAD_REQUEST,
          HttpStatusCode.BAD_REQUEST);
    }
    return portLoadingPlanCommingleDetails;
  }

  /**
   * Building discharge berth details from saved json of algo response
   *
   * @param disEntity
   * @param dischargeBerthDetails
   * @param builder
   */
  public void buildDischargeBerthDetails(
      DischargeInformation disEntity,
      DischargeBerthDetails dischargeBerthDetails,
      com.cpdss.common.generated.discharge_plan.DischargeInformation.Builder builder) {

    Optional.ofNullable(dischargeBerthDetails)
        .ifPresent(
            dischargeBerthDetails1 ->
                Optional.ofNullable(dischargeBerthDetails1.getSelectedBerths())
                    .ifPresent(
                        berthDetailsList ->
                            berthDetailsList.forEach(
                                berthDetails -> {
                                  DischargeBerths.Builder builder1 = DischargeBerths.newBuilder();
                                  Optional.ofNullable(disEntity.getId())
                                      .ifPresent(builder1::setDischargeInfoId);
                                  Optional.ofNullable(berthDetails.getDischargeBerthId())
                                      .ifPresent(builder1::setId);
                                  Optional.ofNullable(berthDetails.getBerthId())
                                      .ifPresent(builder1::setBerthId);
                                  Optional.ofNullable(berthDetails.getMaxShipDepth())
                                      .ifPresent(v -> builder1.setDepth(v.toString()));
                                  Optional.ofNullable(berthDetails.getMaxManifoldHeight())
                                      .ifPresent(v -> builder1.setMaxManifoldHeight(v.toString()));
                                  Optional.ofNullable(berthDetails.getMaxManifoldPressure())
                                      .ifPresent(
                                          v -> builder1.setMaxManifoldPressure(v.toString()));
                                  Optional.ofNullable(berthDetails.getHoseConnections())
                                      .ifPresent(builder1::setHoseConnections);
                                  Optional.ofNullable(berthDetails.getSeaDraftLimitation())
                                      .ifPresent(v -> builder1.setSeaDraftLimitation(v.toString()));
                                  Optional.ofNullable(berthDetails.getSeaDraftLimitation())
                                      .ifPresent(v -> builder1.setSeaDraftLimitation(v.toString()));
                                  Optional.ofNullable(berthDetails.getAirDraftLimitation())
                                      .ifPresent(v -> builder1.setAirDraftLimitation(v.toString()));
                                  Optional.ofNullable(berthDetails.getAirPurge())
                                      .ifPresent(builder1::setAirPurge);
                                  Optional.ofNullable(berthDetails.getCargoCirculation())
                                      .ifPresent(builder1::setCargoCirculation);
                                  Optional.ofNullable(berthDetails.getLineDisplacement())
                                      .ifPresent(v -> builder1.setLineDisplacement(v.toString()));
                                  Optional.ofNullable(berthDetails.getRegulationAndRestriction())
                                      .ifPresent(builder1::setSpecialRegulationRestriction);
                                  Optional.ofNullable(berthDetails.getItemsToBeAgreedWith())
                                      .ifPresent(builder1::setItemsToBeAgreedWith);

                                  builder.addBerthDetails(builder1.build());
                                })));
  }

  /**
   * Building discharge machine in use details from saved json of algo response
   *
   * @param disEntity
   * @param machineryInUses
   * @param builder
   */
  public void buildMachineInUse(
      DischargeInformation disEntity,
      CargoMachineryInUse machineryInUses,
      com.cpdss.common.generated.discharge_plan.DischargeInformation.Builder builder) {

    Optional.ofNullable(machineryInUses)
        .ifPresent(
            cargoMachineryInUses ->
                Optional.ofNullable(cargoMachineryInUses.getMachinesInUses())
                    .ifPresent(
                        dischargeMachinesInUses ->
                            dischargeMachinesInUses.forEach(
                                dischargingMachineryInUse -> {
                                  LoadingPlanModels.LoadingMachinesInUse.Builder builder1 =
                                      LoadingPlanModels.LoadingMachinesInUse.newBuilder();
                                  builder1.setId(dischargingMachineryInUse.getId());
                                  builder1.setLoadingInfoId(disEntity.getId());
                                  builder1.setMachineId(dischargingMachineryInUse.getMachineId());
                                  builder1.setMachineTypeValue(
                                      dischargingMachineryInUse.getMachineTypeId());
                                  Optional.ofNullable(dischargingMachineryInUse.getCapacity())
                                      .ifPresent(value -> builder1.setCapacity(value.toString()));
                                  builder.addMachineInUse(builder1.build());
                                })));
    log.info("Setting Machine in use");
  }

  /**
   * Building discharge cow plan details from saved json of algo response
   *
   * @param cowPlan
   * @param builder
   */
  public void buildCowPlan(
      com.cpdss.dischargeplan.domain.CowPlan cowPlan,
      com.cpdss.common.generated.discharge_plan.DischargeInformation.Builder builder) {

    Optional.ofNullable(cowPlan)
        .ifPresent(
            cowPlan1 -> {
              CowPlan.Builder builder1 = CowPlan.newBuilder();
              Optional.ofNullable(cowPlan1.getCowOptionTypeValue())
                  .ifPresent(
                      optionType ->
                          builder1.setCowOptionType(Common.COW_OPTION_TYPE.forNumber(optionType)));
              Optional.ofNullable(cowPlan1.getCowPercentage())
                  .ifPresent(percentage -> builder1.setCowTankPercent(percentage.toString()));
              Optional.ofNullable(cowPlan1.getCowStartTime())
                  .ifPresent(startTime -> builder1.setCowStartTime(startTime.toString()));
              Optional.ofNullable(cowPlan1.getCowEndTime())
                  .ifPresent(endTime -> builder1.setCowEndTime(endTime.toString()));
              Optional.ofNullable(cowPlan1.getEstimatedCowDuration())
                  .ifPresent(duration -> builder1.setEstCowDuration(duration.toString()));

              Optional.ofNullable(cowPlan1.getCowMinTrim())
                  .ifPresent(minTrim -> builder1.setTrimCowMin(minTrim.toString()));
              Optional.ofNullable(cowPlan1.getCowMaxTrim())
                  .ifPresent(maxTrim -> builder1.setTrimCowMax(maxTrim.toString()));

              Optional.ofNullable(cowPlan1.getNeedFreshCrudeStorage())
                  .ifPresent(builder1::setNeedFreshCrudeStorage);
              Optional.ofNullable(cowPlan1.getNeedFlushingOil())
                  .ifPresent(builder1::setNeedFlushingOil);

              Optional.ofNullable(cowPlan1.getWashTanksWithDifferentCargo())
                  .ifPresent(
                      builder1
                          ::setCowWithCargoEnable); // radio button for enable/disable CWC section

              //               tank wise details
              Optional.ofNullable(cowPlan1.getTopCowTankIds())
                  .ifPresent(
                      topCowTankIds -> {
                        if (!topCowTankIds.isEmpty()) {
                          this.buildCowTankDetailsFromAlgo(
                              Common.COW_TYPE.TOP_COW, builder1, topCowTankIds);
                        }
                      });

              Optional.ofNullable(cowPlan1.getBottomCowTankIds())
                  .ifPresent(
                      bottomCowTankIds -> {
                        if (!bottomCowTankIds.isEmpty()) {
                          this.buildCowTankDetailsFromAlgo(
                              Common.COW_TYPE.BOTTOM_COW, builder1, bottomCowTankIds);
                        }
                      });

              Optional.ofNullable(cowPlan1.getAllCowTankIds())
                  .ifPresent(
                      allCowTankIds -> {
                        if (!allCowTankIds.isEmpty()) {
                          this.buildCowTankDetailsFromAlgo(
                              Common.COW_TYPE.ALL_COW, builder1, allCowTankIds);
                        }
                      });

              Optional.ofNullable(cowPlan1.getCargoCowTankIds())
                  .ifPresent(
                      cargoForCowDetails -> {
                        if (!cargoForCowDetails.isEmpty()) {
                          this.buildCowTankDetailsFromAlgo(
                              Common.COW_TYPE.CARGO, builder1, cargoForCowDetails);
                        }
                      });

              builder.setCowPlan(builder1.build());
            });
  }

  /**
   * Building Cow Details from algo response
   *
   * @param cow_type
   * @param builder
   * @param list
   */
  private void buildCowTankDetailsFromAlgo(
      final Common.COW_TYPE cow_type, CowPlan.Builder builder, Collection list) {
    CowTankDetails.Builder tankDetails = CowTankDetails.newBuilder();
    tankDetails.setCowType(cow_type);
    switch (cow_type) {
      case TOP_COW:
      case BOTTOM_COW:
      case ALL_COW:
        {
          List<Long> ls1 = new ArrayList<>(list); // cast from generic list
          tankDetails.addAllTankIds(ls1);
        }
        break;
      case CARGO:
        {
          List<CargoForCowDetails> cargoForCowDetails =
              new ArrayList<>(list); // cast from generic list

          var gp1 =
              cargoForCowDetails.stream()
                  .collect(Collectors.groupingBy(CargoForCowDetails::getCargoId)); // group by cargo
          for (Map.Entry<Long, List<CargoForCowDetails>> map1 : gp1.entrySet()) {
            CargoForCowDetails firstItem = map1.getValue().stream().findFirst().get();
            CargoForCow.Builder cargoForCow = CargoForCow.newBuilder();
            cargoForCow.setCargoId(firstItem.getCargoId());
            cargoForCow.setCargoNominationId(firstItem.getCargoNominationId());
            cargoForCow.setWashingCargoId(firstItem.getWashingCargoId());
            cargoForCow.setWashingCargoNominationId(firstItem.getWashingCargoNominationId());
            cargoForCow.addAllTankIds(firstItem.getTankIds());
            tankDetails.addCargoForCow(cargoForCow.build());
          }
        }
        break;
      default:
        {
          log.info("Default case for build cow tank details");
        }
    }
    builder.addCowTankDetails(tankDetails.build());
  }

  /**
   * Builds discharge details message from ALGO JSON
   *
   * @param dischargeDetails
   * @param dischargingInformation
   */
  public void buildDischargeDetailsMessageFromJson(
      com.cpdss.dischargeplan.domain.DischargeDetails dischargeDetails,
      com.cpdss.common.generated.discharge_plan.DischargeInformation.Builder
          dischargingInformation) {
    if (dischargeDetails != null) {
      DischargeDetails.Builder builder = DischargeDetails.newBuilder();
      Optional.ofNullable(dischargeDetails.getTimeOfSunrise()).ifPresent(builder::setTimeOfSunrise);
      Optional.ofNullable(dischargeDetails.getTimeOfSunset()).ifPresent(builder::setTimeOfSunset);
      Optional.ofNullable(dischargeDetails.getStartTime()).ifPresent(builder::setStartTime);

      if (dischargeDetails.getTrimAllowed() != null) {
        // Set Trim Values
        LoadingPlanModels.TrimAllowed.Builder trimAllowed =
            LoadingPlanModels.TrimAllowed.newBuilder();
        Optional.ofNullable(dischargeDetails.getTrimAllowed().getInitialTrim())
            .ifPresent(v -> trimAllowed.setInitialTrim(v.toString()));
        Optional.ofNullable(dischargeDetails.getTrimAllowed().getMaximumTrim())
            .ifPresent(v -> trimAllowed.setMaximumTrim(v.toString()));
        Optional.ofNullable(dischargeDetails.getTrimAllowed().getFinalTrim())
            .ifPresent(v -> trimAllowed.setFinalTrim(v.toString()));
        builder.setTrimAllowed(trimAllowed.build());
      }
      Optional.ofNullable(dischargeDetails.getCommonDate()).ifPresent(builder::setCommonDate);

      Optional.ofNullable(dischargeDetails.getSlopQuantity())
          .ifPresent(slopQuantity -> builder.setSlopQuantity(slopQuantity.toString()));
      dischargingInformation.setDischargeDetails(builder.build());
    }
  }
}
