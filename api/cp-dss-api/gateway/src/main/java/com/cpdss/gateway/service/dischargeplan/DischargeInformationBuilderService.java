/* Licensed at AlphaOri Technologies */
package com.cpdss.gateway.service.dischargeplan;

import com.cpdss.common.exception.GenericServiceException;
import com.cpdss.common.generated.Common;
import com.cpdss.common.generated.LoadableStudy;
import com.cpdss.common.generated.PortInfo;
import com.cpdss.common.generated.VesselInfo;
import com.cpdss.common.generated.discharge_plan.CargoForCow;
import com.cpdss.common.generated.discharge_plan.CowPlan;
import com.cpdss.common.generated.discharge_plan.CowTankDetails;
import com.cpdss.common.generated.discharge_plan.DischargeBerths;
import com.cpdss.common.generated.discharge_plan.DischargeDelay;
import com.cpdss.common.generated.discharge_plan.DischargeDelays;
import com.cpdss.common.generated.discharge_plan.DischargeDetails;
import com.cpdss.common.generated.discharge_plan.DischargeInformation;
import com.cpdss.common.generated.discharge_plan.DischargeInformationServiceGrpc;
import com.cpdss.common.generated.discharge_plan.DischargingInfoSaveResponse;
import com.cpdss.common.generated.discharge_plan.PostDischargeStageTime;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingStages;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels.StageOffsets;
import com.cpdss.gateway.common.GatewayConstants;
import com.cpdss.gateway.domain.dischargeplan.*;
import com.cpdss.gateway.domain.loadingplan.BerthDetails;
import com.cpdss.gateway.domain.loadingplan.CargoMachineryInUse;
import com.cpdss.gateway.domain.loadingplan.LoadingDelays;
import com.cpdss.gateway.domain.loadingplan.LoadingDetails;
import com.cpdss.gateway.domain.loadingplan.LoadingMachinesInUse;
import com.cpdss.gateway.domain.loadingplan.LoadingSequences;
import com.cpdss.gateway.domain.loadingplan.ReasonForDelay;
import com.cpdss.gateway.domain.loadingplan.TrimAllowed;
import com.cpdss.gateway.domain.loadingplan.VesselComponent;
import com.cpdss.gateway.domain.vessel.PumpType;
import com.cpdss.gateway.domain.vessel.VesselPump;
import com.cpdss.gateway.service.VesselInfoService;
import com.cpdss.gateway.service.loadingplan.LoadingPlanGrpcService;
import com.cpdss.gateway.utility.AdminRuleTemplate;
import com.cpdss.gateway.utility.AdminRuleValueExtract;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Slf4j
@Service
public class DischargeInformationBuilderService {

  @Autowired VesselInfoService vesselInfoService;

  @Autowired LoadingPlanGrpcService loadingPlanGrpcService;

  @GrpcClient("dischargeInformationService")
  DischargeInformationServiceGrpc.DischargeInformationServiceBlockingStub dischargeInfoServiceStub;

  public LoadingDetails buildDischargeDetailFromMessage(
      DischargeDetails var1, Long portId, Long portRId, AdminRuleValueExtract extract)
      throws GenericServiceException {
    LoadingDetails var2 = new LoadingDetails();
    LoadableStudy.LoadingSynopticResponse var3 =
        loadingPlanGrpcService.fetchSynopticRecordForPortRotation(
            portRId, GatewayConstants.OPERATION_TYPE_ARR);

    var2.setTimeOfSunrise(var3.getTimeOfSunrise().isEmpty() ? null : var3.getTimeOfSunrise());
    var2.setTimeOfSunset(var3.getTimeOfSunset().isEmpty() ? null : var3.getTimeOfSunset());

    // If not found in LS, Synoptic Go to Port Master
    if (var2.getTimeOfSunrise() == null || var2.getTimeOfSunset() == null) {
      PortInfo.PortDetail response2 = this.loadingPlanGrpcService.fetchPortDetailByPortId(portId);
      if (var2.getTimeOfSunrise() == null || var2.getTimeOfSunrise().isEmpty()) {
        var2.setTimeOfSunrise(response2.getSunriseTime());
      }
      if (var2.getTimeOfSunset() == null || var2.getTimeOfSunset().isEmpty()) {
        var2.setTimeOfSunset(response2.getSunsetTime());
      }
      log.info(
          "Get Loading info, Sunrise/Sunset added from Port Info table {}, {}",
          response2.getSunriseTime(),
          response2.getSunsetTime());
    } else {
      log.info("Get Synoptic Table, Port Rotation Id {}", portRId);
    }

    if (!var1.getStartTime().isEmpty()) {
      var2.setStartTime(var1.getStartTime());
    }

    if (var1.hasTrimAllowed()) {
      TrimAllowed trimAllowed = new TrimAllowed();
      if (!var1.getTrimAllowed().getInitialTrim().isEmpty()) {
        trimAllowed.setInitialTrim(new BigDecimal(var1.getTrimAllowed().getInitialTrim()));
      }
      if (!var1.getTrimAllowed().getMaximumTrim().isEmpty()) {
        trimAllowed.setMaximumTrim(new BigDecimal(var1.getTrimAllowed().getMaximumTrim()));
      }
      if (!var1.getTrimAllowed().getFinalTrim().isEmpty()) {
        trimAllowed.setFinalTrim(new BigDecimal(var1.getTrimAllowed().getFinalTrim()));
      }
      var2.setTrimAllowed(trimAllowed);
    }

    if (!var1.getCommonDate().isEmpty()) {
      var2.setCommonDate(LocalDate.parse(var1.getCommonDate()));
    }
    var2.setSlopQuantity(
        StringUtils.hasLength(var1.getSlopQuantity())
            ? new BigDecimal(var1.getSlopQuantity())
            : BigDecimal.ZERO);
    return var2;
  }

  public DischargeRates buildDischargeRatesFromMessage(
      com.cpdss.common.generated.discharge_plan.DischargeRates var1,
      AdminRuleValueExtract extract) {
    DischargeRates var2 = new DischargeRates();
    if (var1.getInitialDischargeRate().isEmpty()) {
      String val = extract.getDefaultValueForKey(AdminRuleTemplate.DISCHARGE_INITIAL_RATE);
      var2.setInitialDischargingRate(val.isEmpty() ? null : new BigDecimal(val));
    } else {
      var2.setInitialDischargingRate(new BigDecimal(var1.getInitialDischargeRate()));
    }

    if (var1.getMaxDischargeRate().isEmpty()) {
      String val = extract.getDefaultValueForKey(AdminRuleTemplate.DISCHARGE_MAXIMUM_RATE);
      var2.setMaxDischargingRate(val.isEmpty() ? null : new BigDecimal(val));
    } else {
      var2.setMaxDischargingRate(new BigDecimal(var1.getMaxDischargeRate()));
    }

    if (var1.getMinBallastRate().isEmpty()) {
      String val = extract.getDefaultValueForKey(AdminRuleTemplate.DISCHARGE_MIN_DE_BALLAST_RATE);
      var2.setMinBallastRate(val.isEmpty() ? null : new BigDecimal(val));
    } else {
      var2.setMinBallastRate(new BigDecimal(var1.getMinBallastRate()));
    }

    if (var1.getMaxBallastRate().isEmpty()) {
      String val = extract.getDefaultValueForKey(AdminRuleTemplate.DISCHARGE_MAX_DE_BALLAST_RATE);
      var2.setMaxBallastRate(val.isEmpty() ? null : new BigDecimal(val));
    } else {
      var2.setMaxBallastRate(new BigDecimal(var1.getMaxBallastRate()));
    }
    var2.setId(var1.getId());

    return var2;
  }

  /**
   * Builds discharge berth details from grpc
   *
   * @param dischargeBerthsList list of discharge berth details from grpc
   * @return list of berth details dto
   */
  public List<BerthDetails> buildDischargeBerthsFromMessage(
      List<DischargeBerths> dischargeBerthsList) {

    log.info("Inside buildDischargeBerthsFromMessage method!");
    List<BerthDetails> berthDetailsList = new ArrayList<>();

    for (DischargeBerths dischargeBerths : dischargeBerthsList) {

      BerthDetails berthDetails = new BerthDetails();

      // Set fields
      berthDetails.setLoadingBerthId(dischargeBerths.getId());
      berthDetails.setLoadingInfoId(dischargeBerths.getDischargeInfoId());
      berthDetails.setBerthId(dischargeBerths.getBerthId());
      berthDetails.setMaxShipDepth(returnZeroIfBlank(dischargeBerths.getDepth()));
      berthDetails.setSeaDraftLimitation(
          returnZeroIfBlank(dischargeBerths.getSeaDraftLimitation()));
      berthDetails.setAirDraftLimitation(
          returnZeroIfBlank(dischargeBerths.getAirDraftLimitation()));
      berthDetails.setMaxManifoldHeight(returnZeroIfBlank(dischargeBerths.getMaxManifoldHeight()));

      berthDetails.setRegulationAndRestriction(dischargeBerths.getSpecialRegulationRestriction());
      berthDetails.setItemsToBeAgreedWith(dischargeBerths.getItemsToBeAgreedWith());
      berthDetails.setHoseConnections(dischargeBerths.getHoseConnections());
      berthDetails.setLineDisplacement(dischargeBerths.getLineDisplacement());
      berthDetails.setAirPurge(dischargeBerths.getAirPurge());
      berthDetails.setCargoCirculation(dischargeBerths.getCargoCirculation());
      berthDetails.setMaxManifoldPressure(dischargeBerths.getMaxManifoldPressure());
      berthDetails.setDisplacement(returnZeroIfBlank(dischargeBerths.getDisplacement()));
      berthDetails.setEnableDayLightRestriction(dischargeBerths.getEnableDayLightRestriction());
      berthDetails.setNeedFlushingOilAndCrudeStorage(
          dischargeBerths.getNeedFlushingOilAndCrudeStorage());
      berthDetails.setFreshCrudeOilQuantity(
          returnZeroIfBlank(dischargeBerths.getFreshCrudeOilQuantity()));
      berthDetails.setFreshCrudeOilTime(returnZeroIfBlank(dischargeBerths.getFreshCrudeOilTime()));

      berthDetailsList.add(berthDetails);
    }

    return berthDetailsList;
  }

  /**
   * Returns big decimal value of provided string else returns big decimal zero
   *
   * @param string input string
   * @return big decimal value
   */
  private BigDecimal returnZeroIfBlank(String string) {

    return io.micrometer.core.instrument.util.StringUtils.isBlank(string)
        ? BigDecimal.ZERO
        : new BigDecimal(string);
  }

  public CargoMachineryInUse buildDischargeMachinesFromMessage(
      List<LoadingPlanModels.LoadingMachinesInUse> var1, Long vesselId) {
    VesselInfo.VesselPumpsResponse grpcReply =
        vesselInfoService.getVesselPumpsFromVesselInfo(vesselId);
    CargoMachineryInUse machineryInUse = new CargoMachineryInUse();

    // Setting master data
    if (grpcReply != null) {
      try {
        List<PumpType> pumpTypes = new ArrayList<>();
        if (grpcReply.getPumpTypeCount() > 0) {
          for (VesselInfo.PumpType vpy : grpcReply.getPumpTypeList()) {
            PumpType type = new PumpType();
            BeanUtils.copyProperties(vpy, type);
            pumpTypes.add(type);
          }
        }
        List<VesselPump> vesselPumps = new ArrayList<>();
        if (grpcReply.getVesselPumpCount() > 0) {
          for (VesselInfo.VesselPump vp : grpcReply.getVesselPumpList()) {
            // created an array of ids from constants.
            if (GatewayConstants.DISCHARGING_VESSEL_PUMPS_VAL.contains(vp.getPumpTypeId())) {
              VesselPump pump = new VesselPump();
              BeanUtils.copyProperties(vp, pump);
              Optional.ofNullable(vp.getPumpCapacity())
                  .ifPresent(v -> pump.setPumpCapacity(new BigDecimal(v)));
              pump.setMachineType(Common.MachineType.VESSEL_PUMP_VALUE);
              vesselPumps.add(pump);
            }
          }
        }
        machineryInUse.setPumpTypes(pumpTypes);
        machineryInUse.setVesselPumps(vesselPumps);

        if (!grpcReply.getVesselManifoldList().isEmpty()) {
          List<VesselComponent> list1 = new ArrayList<>();
          for (VesselInfo.VesselComponent vc : grpcReply.getVesselManifoldList()) {
            VesselComponent vcDto = new VesselComponent();
            vcDto.setId(vc.getId());
            vcDto.setComponentCode(vc.getComponentCode());
            vcDto.setComponentName(vc.getComponentName());
            vcDto.setVesselId(vc.getVesselId());
            vcDto.setComponentType(vc.getComponentType());
            vcDto.setMachineTypeId(Common.MachineType.MANIFOLD_VALUE);
            list1.add(vcDto);
          }
          machineryInUse.setVesselManifold(list1);
        }

        if (!grpcReply.getVesselBottomLineList().isEmpty()) {
          List<VesselComponent> list2 = new ArrayList<>();
          for (VesselInfo.VesselComponent vc : grpcReply.getVesselBottomLineList()) {
            VesselComponent vcDto = new VesselComponent();
            vcDto.setId(vc.getId());
            vcDto.setComponentCode(vc.getComponentCode());
            vcDto.setComponentName(vc.getComponentName());
            vcDto.setVesselId(vc.getVesselId());
            vcDto.setComponentType(vc.getComponentType());
            vcDto.setMachineTypeId(Common.MachineType.BOTTOM_LINE_VALUE);
            list2.add(vcDto);
          }
          machineryInUse.setVesselBottomLine(list2);
        }

        if (!grpcReply.getTankTypeList().isEmpty()) {
          var tankList =
              grpcReply.getTankTypeList().stream()
                  .filter(v -> GatewayConstants.OPERATIONS_TANK_TYPE.contains(v.getId()))
                  .map(
                      v -> {
                        PumpType type = new PumpType();
                        Optional.ofNullable(v.getId()).ifPresent(type::setId);
                        Optional.ofNullable(v.getTypeName()).ifPresent(type::setName);
                        return type;
                      })
                  .collect(Collectors.toList());
          machineryInUse.setTankTypes(tankList);
        }

        log.info(
            "Get loading info, Cargo machines Pump List Size {}, Type Size {} from Vessel Info",
            vesselPumps.size(),
            pumpTypes.size());
      } catch (Exception e) {
        log.error("Failed to process Vessel Pumps");
        e.printStackTrace();
      }
    }

    // Setting Loading info Data
    if (!var1.isEmpty()) {
      List<LoadingMachinesInUse> list2 = new ArrayList<>();
      for (LoadingPlanModels.LoadingMachinesInUse lm : var1) {
        LoadingMachinesInUse var2 = new LoadingMachinesInUse();
        var2.setId(lm.getId());
        var2.setMachineId(lm.getMachineId());
        var2.setLoadingInfoId(lm.getLoadingInfoId());
        var2.setMachineTypeId(lm.getMachineType().getNumber());
        var2.setCapacity(
            lm.getCapacity().isEmpty() ? BigDecimal.ZERO : new BigDecimal(lm.getCapacity()));
        var2.setIsUsing(lm.getIsUsing());
        list2.add(var2);
      }
      log.info("Discharging plan machine in use added, Size {}", var1.size());
      // machineryInUse.setLoadingMachinesInUses(list2);
      machineryInUse.setDischargeMachinesInUses(list2);
    }
    return machineryInUse;
  }

  public LoadingSequences buildDischargeSequencesAndDelayFromMessage(
      DischargeDelay dischargeDelay) {
    LoadingSequences loadingSequences = new LoadingSequences();
    List<ReasonForDelay> reasonForDelays = new ArrayList<>();
    for (LoadingPlanModels.DelayReasons delayReasons : dischargeDelay.getReasonsList()) {
      ReasonForDelay reasonForDelay = new ReasonForDelay();
      BeanUtils.copyProperties(delayReasons, reasonForDelay);
      reasonForDelays.add(reasonForDelay);
    }
    List<LoadingDelays> loadingDelaysList = new ArrayList<>();
    for (DischargeDelays dischargeDelays : dischargeDelay.getDelaysList()) {
      LoadingDelays loadingDelays = new LoadingDelays();
      Optional.of(dischargeDelays.getDuration())
          .ifPresent(
              v -> {
                if (!v.isEmpty()) loadingDelays.setDuration(new BigDecimal(v));
              });
      Optional.of(dischargeDelays.getQuantity())
          .ifPresent(
              v -> {
                if (!v.isEmpty()) loadingDelays.setQuantity(new BigDecimal(v));
              });
      Optional.of(dischargeDelays.getSequenceNo()).ifPresent(loadingDelays::setSequenceNo);
      loadingDelays.setDischargingRate(
          StringUtils.hasLength(dischargeDelays.getDischargingRate())
              ? new BigDecimal(dischargeDelays.getDischargingRate())
              : null);
      BeanUtils.copyProperties(dischargeDelays, loadingDelays);
      loadingDelays.setLoadingInfoId(dischargeDelays.getDischargeInfoId());
      loadingDelays.setReasonForDelayIds(dischargeDelays.getReasonForDelayIdsList());
      loadingDelaysList.add(loadingDelays);
    }

    loadingSequences.setReasonForDelays(reasonForDelays);
    loadingSequences.setDischargingDelays(copy(loadingDelaysList));
    log.info(
        "manage sequence data added from  loading plan, Size {}", dischargeDelay.getDelaysCount());
    return loadingSequences;
  }

  private List<DischargingDelays> copy(List<LoadingDelays> loadingDelays) {
    List<DischargingDelays> delays = new ArrayList<>();
    loadingDelays.forEach(
        delay -> {
          DischargingDelays dischargeDelay = new DischargingDelays();
          BeanUtils.copyProperties(delay, dischargeDelay);
          dischargeDelay.setDischargeInfoId(delay.getLoadingInfoId());
          delays.add(dischargeDelay);
        });

    return delays;
  }

  public com.cpdss.gateway.domain.dischargeplan.CowPlan buildDischargeCowPlan(
      CowPlan cowPlan, AdminRuleValueExtract extract) {
    com.cpdss.gateway.domain.dischargeplan.CowPlan var1 =
        new com.cpdss.gateway.domain.dischargeplan.CowPlan();
    try {
      BeanUtils.copyProperties(cowPlan, var1);

      var1.setCowOption(cowPlan.getCowOptionTypeValue());
      var1.setCowPercentage(cowPlan.getCowTankPercent());
      var1.setCowStart(cowPlan.getCowStartTime());
      var1.setCowEnd(cowPlan.getCowEndTime());
      var1.setCowDuration(cowPlan.getEstCowDuration());
      var1.setWashTanksWithDifferentCargo(cowPlan.getCowWithCargoEnable());

      // If no value in discharge-plan DB, set admin Rule Value
      if (cowPlan.getTrimCowMin().isEmpty()) {
        String val = extract.getDefaultValueForKey(AdminRuleTemplate.DISCHARGE_COW_TRIM_MIN, false);
        var1.setCowTrimMin(val);
      } else {
        var1.setCowTrimMin(cowPlan.getTrimCowMin());
      }
      if (cowPlan.getTrimCowMax().isEmpty()) {
        String val = extract.getDefaultValueForKey(AdminRuleTemplate.DISCHARGE_COW_TRIM_MAX, true);
        var1.setCowTrimMax(val);
      } else {
        var1.setCowTrimMax(cowPlan.getTrimCowMax());
      }

      var topCow =
          cowPlan.getCowTankDetailsList().stream()
              .filter(v -> v.getCowType().equals(Common.COW_TYPE.TOP_COW))
              .map(CowTankDetails::getTankIdsList)
              .flatMap(Collection::stream)
              .collect(Collectors.toList());

      var bottomCow =
          cowPlan.getCowTankDetailsList().stream()
              .filter(v -> v.getCowType().equals(Common.COW_TYPE.BOTTOM_COW))
              .map(CowTankDetails::getTankIdsList)
              .flatMap(Collection::stream)
              .collect(Collectors.toList());

      var allCow =
          cowPlan.getCowTankDetailsList().stream()
              .filter(v -> v.getCowType().equals(Common.COW_TYPE.ALL_COW))
              .map(CowTankDetails::getTankIdsList)
              .flatMap(Collection::stream)
              .collect(Collectors.toList());

      var cargoCowTankList =
          cowPlan.getCowTankDetailsList().stream()
              .filter(v -> v.getCowType().equals(Common.COW_TYPE.CARGO))
              .map(v -> v.getCargoForCowList())
              .flatMap(Collection::stream)
              .map(
                  v -> {
                    return new CargoForCowDetails(
                        v.getCargoId(),
                        v.getCargoNominationId(),
                        v.getWashingCargoId(),
                        v.getWashingCargoNominationId(),
                        v.getTankIdsList());
                  })
              .collect(Collectors.toList());

      var1.setTopCow(topCow);
      var1.setBottomCow(bottomCow);
      var1.setAllCow(allCow);
      var1.setCargoCow(cargoCowTankList);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return var1;
  }

  public DischargingInfoSaveResponse saveDataAsync(DischargingInformationRequest request)
      throws InterruptedException, ExecutionException {

    DischargeInformation.Builder builder = DischargeInformation.newBuilder();
    List<Callable<DischargingInfoSaveResponse>> callableTasks = new ArrayList<>();
    builder.setDischargeInfoId(request.getDischargeInfoId());
    builder.setSynopticTableId(request.getSynopticTableId());
    builder.setIsDischargingInfoComplete(request.getIsDischargeInfoComplete());

    // Discharging Info Case 1 - Details
    if (request.getDischargeDetails() != null) {
      Callable<DischargingInfoSaveResponse> t1 =
          () -> {
            builder.setDischargeDetails(
                buildDischargingDetails(
                    request.getDischargeDetails(), request.getDischargeInfoId()));
            return dischargeInfoServiceStub.saveDischargingInformation(builder.build());
          };
      callableTasks.add(t1);
    }

    // Discharging Info Case 2 - Stages
    if (request.getDischargeStages() != null) {
      Callable<DischargingInfoSaveResponse> t2 =
          () -> {
            builder.setDischargeStage(buildDischargingStage(request));
            return dischargeInfoServiceStub.saveDischargingInfoStages(builder.build());
          };
      callableTasks.add(t2);
    }

    // Discharging Info Case 3 - Rates
    if (request.getDischargeRates() != null) {
      Callable<DischargingInfoSaveResponse> t3 =
          () -> {
            builder.setDischargeRate(
                buildDischargingRates(request.getDischargeRates(), request.getDischargeInfoId()));
            return dischargeInfoServiceStub.saveDischargingInfoRates(builder.build());
          };
      callableTasks.add(t3);
    }

    // Discharging Info Case 4 - Berths
    if (request.getDischargingBerths() != null) {
      Callable<DischargingInfoSaveResponse> t4 =
          () -> {
            builder.addAllBerthDetails(
                buildDischargingBerths(
                    request.getDischargingBerths(), request.getDischargeInfoId()));
            return dischargeInfoServiceStub.saveDischargingInfoBerths(builder.build());
          };
      callableTasks.add(t4);
    }

    // Discharging Info Case 5 - Delays
    if (request.getDischargingDelays() != null) {
      Callable<DischargingInfoSaveResponse> t5 =
          () -> {
            DischargeDelay.Builder dischargingDelayBuilder = DischargeDelay.newBuilder();
            dischargingDelayBuilder.addAllDelays(
                buildDischargingDelays(
                    request.getDischargingDelays(), request.getDischargeInfoId()));
            builder.setDischargeDelay(dischargingDelayBuilder.build());
            return dischargeInfoServiceStub.saveDischargingInfoDelays(builder.build());
          };
      callableTasks.add(t5);
    }

    // Discharging Info Case 6 - Machines
    if (request.getDischargingMachineries() != null) {
      Callable<DischargingInfoSaveResponse> t6 =
          () -> {
            builder.addAllMachineInUse(
                buildDischargingMachineries(
                    request.getDischargingMachineries(), request.getDischargeInfoId()));
            return dischargeInfoServiceStub.saveDischargingInfoMachinery(builder.build());
          };
      callableTasks.add(t6);
    }
    // Discharging Info Case 7 - cow plan
    if (request.getCowPlan() != null) {
      Callable<DischargingInfoSaveResponse> t7 =
          () -> {
            builder.setCowPlan(
                buildDischargeCowDetails(request.getCowPlan(), request.getDischargeInfoId()));
            return dischargeInfoServiceStub.saveCowPlan(builder.build());
          };
      callableTasks.add(t7);
    }

    // Discharging Info Case 8 - post discharge stage
    if (request.getPostDischargeStageTime() != null) {
      Callable<DischargingInfoSaveResponse> t8 =
          () -> {
            builder.setPostDischargeStageTime(
                buildPostDischargeStageDetails(request.getPostDischargeStageTime()));
            return dischargeInfoServiceStub.savePostDischargeStage(builder.build());
          };
      callableTasks.add(t8);
    }
    // Discharging Info Case 9 -  DischargeCommingledCargoSeparately
    if (request.getCargoToBeDischarged() != null
        && (request.getCargoToBeDischarged().getDischargeCommingledCargoSeparately() != null
            || request.getCargoToBeDischarged().getDischargeSlopTanksFirst() != null)) {
      Callable<DischargingInfoSaveResponse> t9 =
          () -> {
            Optional.ofNullable(
                    request.getCargoToBeDischarged().getDischargeCommingledCargoSeparately())
                .ifPresent(builder::setDischargeCommingledCargoSeparately);
            Optional.ofNullable(request.getCargoToBeDischarged().getDischargeSlopTanksFirst())
                .ifPresent(builder::setDischargeSlopTanksFirst);
            return dischargeInfoServiceStub.saveDischargingInformation(builder.build());
          };
      callableTasks.add(t9);
    }

    // Discharging Info Case 10 - CargoToBeDischarged
    if (request.getCargoToBeDischarged() != null) {
      Callable<DischargingInfoSaveResponse> t10 =
          () -> {
            builder.addAllDischargeQuantityCargoDetails(
                buildDischargeQuantityCargoDetails(
                    request.getCargoToBeDischarged(), request.getDischargeInfoId()));
            return dischargeInfoServiceStub.saveCargoToBeDischarged(builder.build());
          };
      callableTasks.add(t10);
    }

    ExecutorService executorService =
        new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
    List<Future<DischargingInfoSaveResponse>> futures = executorService.invokeAll(callableTasks);

    if (futures.isEmpty()) {
      // Means no save goes to DS-Plan Service
      return DischargingInfoSaveResponse.newBuilder()
          .setVesselId(request.getVesselId())
          .setVoyageId(request.getVoyageId())
          .setPortRotationId(request.getPortRotationId())
          .build(); // to bypass null check at caller.
    }

    List<Future<DischargingInfoSaveResponse>> data =
        futures.stream()
            .filter(
                v -> {
                  try {
                    if (v.get().getDischargingInfoId() > 0) {
                      return true;
                    }
                    log.error("Failed to save Thread {}", v.get());
                  } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                  }
                  return false;
                })
            .collect(Collectors.toList());
    log.info(
        "Save Discharging info, Save Request Count - {}, Response Count {}",
        callableTasks.size(),
        data.size());
    return data.isEmpty() ? null : data.stream().findFirst().get().get();
  }

  /**
   * Method to build cargo to be discharged details
   *
   * @param cargoToBeDischarged PlannedCargo input
   * @param dischargeInfoId Discharge Information Id input
   * @return List of LoadableStudy.DischargeQuantityCargoDetails grpc object
   */
  public List<LoadableStudy.DischargeQuantityCargoDetails> buildDischargeQuantityCargoDetails(
      PlannedCargo cargoToBeDischarged, Long dischargeInfoId) {

    log.info("Inside buildDischargeQuantityCargoDetails method!");

    List<LoadableStudy.DischargeQuantityCargoDetails> dischargeQuantityCargoDetailsList =
        new ArrayList<>();
    if (cargoToBeDischarged.getDischargeQuantityCargoDetails() != null) {

      cargoToBeDischarged
          .getDischargeQuantityCargoDetails()
          .forEach(
              dischargeQuantityCargoDetails -> {
                LoadableStudy.DischargeQuantityCargoDetails.Builder builder =
                    LoadableStudy.DischargeQuantityCargoDetails.newBuilder();

                // Set fields
                Optional.ofNullable(dischargeQuantityCargoDetails.getCargoNominationId())
                    .ifPresent(builder::setCargoNominationId);
                Optional.ofNullable(dischargeQuantityCargoDetails.getMaxDischargingRate())
                    .ifPresent(builder::setMaxDischargingRate);
                Optional.ofNullable(dischargeQuantityCargoDetails.getEstimatedTemp())
                    .ifPresent(builder::setEstimatedTemp);
                Optional.ofNullable(dischargeQuantityCargoDetails.getEstimatedAPI())
                    .ifPresent(builder::setEstimatedApi);

                dischargeQuantityCargoDetailsList.add(builder.build());
              });
    }

    return dischargeQuantityCargoDetailsList;
  }

  private PostDischargeStageTime buildPostDischargeStageDetails(
      PostDischargeStage postDischargeStage) {
    PostDischargeStageTime.Builder builder = PostDischargeStageTime.newBuilder();
    builder.setFinalStripping(postDischargeStage.getFinalStrippingTime().toString());
    builder.setFreshOilWashing(postDischargeStage.getFreshOilWashingTime().toString());
    builder.setSlopDischarging(postDischargeStage.getSlopDischargingTime().toString());
    builder.setTimeForDryCheck(postDischargeStage.getDryCheckTime().toString());
    return builder.build();
  }

  private CowPlan buildDischargeCowDetails(
      com.cpdss.gateway.domain.dischargeplan.CowPlan cowPlan, Long dischargingId) {
    CowPlan.Builder builder = CowPlan.newBuilder();

    builder.setCowOptionType(Common.COW_OPTION_TYPE.forNumber(cowPlan.getCowOption()));
    builder.setDischargingInfoId(dischargingId);
    if (cowPlan.getAllCow() != null && !cowPlan.getAllCow().isEmpty()) {
      CowTankDetails.Builder cowTankBuilder = CowTankDetails.newBuilder();
      cowTankBuilder.setCowType(Common.COW_TYPE.ALL_COW);
      cowTankBuilder.addAllTankIds(cowPlan.getAllCow());
      builder.addCowTankDetails(cowTankBuilder);
    }
    if (cowPlan.getBottomCow() != null && !cowPlan.getBottomCow().isEmpty()) {
      CowTankDetails.Builder cowTankBuilder = CowTankDetails.newBuilder();
      cowTankBuilder.setCowType(Common.COW_TYPE.BOTTOM_COW);
      cowTankBuilder.addAllTankIds(cowPlan.getBottomCow());
      builder.addCowTankDetails(cowTankBuilder);
    }
    if (cowPlan.getTopCow() != null && !cowPlan.getTopCow().isEmpty()) {
      CowTankDetails.Builder cowTankBuilder = CowTankDetails.newBuilder();
      cowTankBuilder.setCowType(Common.COW_TYPE.TOP_COW);
      cowTankBuilder.addAllTankIds(cowPlan.getTopCow());
      builder.addCowTankDetails(cowTankBuilder);
    }
    if (cowPlan.getCargoCow() != null && !cowPlan.getCargoCow().isEmpty()) {
      CowTankDetails.Builder cowTankBuilder = CowTankDetails.newBuilder();
      cowTankBuilder.setCowType(Common.COW_TYPE.CARGO);
      cowPlan.getCargoCow().stream()
          .forEach(
              cargo -> {
                CargoForCow.Builder cargoCow = CargoForCow.newBuilder();
                cargoCow.setCargoId(cargo.getCargoId() == null ? 0 : cargo.getCargoId());
                cargoCow.setCargoNominationId(
                    cargo.getCargoNominationId() == null ? 0 : cargo.getCargoNominationId());
                cargoCow.setWashingCargoId(
                    cargo.getWashingCargoId() == null ? 0 : cargo.getWashingCargoId());
                cargoCow.setWashingCargoNominationId(
                    cargo.getWashingCargoNominationId() == null
                        ? 0
                        : cargo.getWashingCargoNominationId());
                cargoCow.addAllTankIds(cargo.getTankIds());
                cowTankBuilder.addCargoForCow(cargoCow);
              });
      builder.addCowTankDetails(cowTankBuilder);
    }
    Optional.ofNullable(cowPlan.getCowOption()).ifPresent(builder::setCowOptionTypeValue);
    Optional.ofNullable(cowPlan.getCowDuration()).ifPresent(builder::setEstCowDuration);
    Optional.ofNullable(cowPlan.getCowEnd()).ifPresent(builder::setCowEndTime);
    Optional.ofNullable(cowPlan.getCowPercentage()).ifPresent(builder::setCowTankPercent);
    Optional.ofNullable(cowPlan.getCowStart()).ifPresent(builder::setCowStartTime);
    Optional.ofNullable(cowPlan.getCowTrimMax()).ifPresent(builder::setTrimCowMax);
    Optional.ofNullable(cowPlan.getCowTrimMin()).ifPresent(builder::setTrimCowMin);

    Optional.ofNullable(cowPlan.getNeedFreshCrudeStorage())
        .ifPresent(builder::setNeedFreshCrudeStorage);
    Optional.ofNullable(cowPlan.getNeedFlushingOil()).ifPresent(builder::setNeedFlushingOil);
    Optional.ofNullable(cowPlan.getWashTanksWithDifferentCargo())
        .ifPresent(builder::setCowWithCargoEnable);

    return builder.build();
  }

  public List<DischargeDelays> buildDischargingDelays(
      List<DischargingDelays> dischargingDelays, Long dischargingInfoId) {
    List<DischargeDelays> delayList = new ArrayList<>();
    dischargingDelays.forEach(
        delay -> {
          DischargeDelays.Builder builder = DischargeDelays.newBuilder();
          Optional.ofNullable(delay.getCargoId()).ifPresent(builder::setCargoId);
          Optional.ofNullable(delay.getDuration())
              .ifPresent(duration -> builder.setDuration(String.valueOf(duration)));
          Optional.ofNullable(delay.getId()).ifPresent(builder::setId);
          Optional.ofNullable(dischargingInfoId).ifPresent(builder::setDischargeInfoId);
          Optional.ofNullable(delay.getQuantity())
              .ifPresent(quantity -> builder.setQuantity(String.valueOf(quantity)));
          Optional.ofNullable(delay.getReasonForDelayIds())
              .ifPresent(v -> v.forEach(s -> builder.addReasonForDelayIds(s)));
          Optional.ofNullable(delay.getCargoNominationId())
              .ifPresent(builder::setCargoNominationId);
          Optional.ofNullable(delay.getSequenceNo()).ifPresent(builder::setSequenceNo);
          Optional.ofNullable(delay.getDischargingRate())
              .ifPresent(dischargingRate -> builder.setDischargingRate(dischargingRate.toString()));
          delayList.add(builder.build());
        });
    return delayList;
  }

  private List<DischargeBerths> buildDischargingBerths(
      List<BerthDetails> dischargingBerths, Long dischargingInfoId) {
    List<DischargeBerths> berthList = new ArrayList<>();
    dischargingBerths.forEach(
        berth -> {
          DischargeBerths.Builder builder = DischargeBerths.newBuilder();
          Optional.ofNullable(berth.getAirDraftLimitation())
              .ifPresent(airDraft -> builder.setAirDraftLimitation(String.valueOf(airDraft)));
          Optional.ofNullable(berth.getHoseConnections()).ifPresent(builder::setHoseConnections);
          Optional.ofNullable(berth.getBerthId()).ifPresent(builder::setBerthId);
          Optional.ofNullable(berth.getLoadingBerthId()).ifPresent(builder::setId);
          Optional.ofNullable(berth.getDischargingBerthId()).ifPresent(builder::setId);
          Optional.ofNullable(dischargingInfoId).ifPresent(builder::setDischargeInfoId);
          // missing depth, itemsToBeAgreedWith added to domain
          Optional.ofNullable(berth.getMaxManifoldHeight())
              .ifPresent(
                  maxManifoldHeight ->
                      builder.setMaxManifoldHeight(String.valueOf(maxManifoldHeight)));
          Optional.ofNullable(berth.getMaxManifoldPressure())
              .ifPresent(builder::setMaxManifoldPressure);
          Optional.ofNullable(berth.getRegulationAndRestriction())
              .ifPresent(builder::setSpecialRegulationRestriction);
          Optional.ofNullable(berth.getSeaDraftLimitation())
              .ifPresent(seaDraft -> builder.setSeaDraftLimitation(String.valueOf(seaDraft)));
          Optional.ofNullable(berth.getItemsToBeAgreedWith())
              .ifPresent(builder::setItemsToBeAgreedWith);
          // maxShipDepth is taken as depth in LoadingBerthDetails table
          Optional.ofNullable(berth.getMaxShipDepth())
              .ifPresent(depth -> builder.setDepth(String.valueOf(depth)));
          Optional.ofNullable(berth.getLineDisplacement()).ifPresent(builder::setLineDisplacement);

          // Regarding DSS-5899 : cargo circulation and air purge check boxes combined to a single
          // field in UI. But algo needs both flags.
          Optional.ofNullable(berth.getCargoCirculation()).ifPresent(builder::setAirPurge);
          Optional.ofNullable(berth.getCargoCirculation()).ifPresent(builder::setCargoCirculation);
          Optional.ofNullable(berth.getDisplacement())
              .ifPresent(displacement -> builder.setDisplacement(displacement.toString()));
          Optional.ofNullable(berth.getEnableDayLightRestriction())
              .ifPresent(builder::setEnableDayLightRestriction);
          Optional.ofNullable(berth.getNeedFlushingOilAndCrudeStorage())
              .ifPresent(builder::setNeedFlushingOilAndCrudeStorage);
          Optional.ofNullable(berth.getFreshCrudeOilTime())
              .ifPresent(time -> builder.setFreshCrudeOilTime(String.valueOf(time)));
          Optional.ofNullable(berth.getFreshCrudeOilQuantity())
              .ifPresent(quantity -> builder.setFreshCrudeOilQuantity(String.valueOf(quantity)));

          berthList.add(builder.build());
        });
    return berthList;
  }

  private com.cpdss.common.generated.discharge_plan.DischargeRates buildDischargingRates(
      DischargeRates dischargingRates, Long dischargingInfoId) {
    com.cpdss.common.generated.discharge_plan.DischargeRates.Builder builder =
        com.cpdss.common.generated.discharge_plan.DischargeRates.newBuilder();
    Optional.ofNullable(dischargingInfoId).ifPresent(builder::setId);

    Optional.ofNullable(dischargingRates.getMaxBallastRate())
        .ifPresent(maxDeBallast -> builder.setMaxBallastRate(String.valueOf(maxDeBallast)));

    Optional.ofNullable(dischargingRates.getMaxDischargingRate())
        .ifPresent(maxLoadingRate -> builder.setMaxDischargeRate(String.valueOf(maxLoadingRate)));

    Optional.ofNullable(dischargingRates.getMinBallastRate())
        .ifPresent(minDeBallast -> builder.setMinBallastRate(String.valueOf(minDeBallast)));

    Optional.ofNullable(dischargingRates.getInitialDischargingRate())
        .ifPresent(v -> builder.setInitialDischargeRate(v.toString()));
    return builder.build();
  }

  private List<LoadingPlanModels.LoadingMachinesInUse> buildDischargingMachineries(
      List<LoadingMachinesInUse> dischargingMachineries, Long dischargingInfoId) {
    List<LoadingPlanModels.LoadingMachinesInUse> machineries = new ArrayList<>();
    dischargingMachineries.forEach(
        machine -> {
          LoadingPlanModels.LoadingMachinesInUse.Builder builder =
              LoadingPlanModels.LoadingMachinesInUse.newBuilder();
          Optional.ofNullable(machine.getCapacity())
              .ifPresent(capacity -> builder.setCapacity(String.valueOf(capacity)));
          Optional.ofNullable(machine.getId()).ifPresent(builder::setId);
          Optional.ofNullable(dischargingInfoId).ifPresent(builder::setLoadingInfoId);
          Optional.ofNullable(machine.getMachineId()).ifPresent(builder::setMachineId);
          Optional.ofNullable(machine.getMachineTypeId()).ifPresent(builder::setMachineTypeValue);
          // isUsing missing added to domain
          Optional.ofNullable(machine.getIsUsing()).ifPresent(builder::setIsUsing);
          machineries.add(builder.build());
        });
    return machineries;
  }

  public DischargeDetails buildDischargingDetails(
      com.cpdss.gateway.domain.loadingplan.LoadingDetails dischargingDetails,
      Long dischargingInfoId) {
    DischargeDetails.Builder builder = DischargeDetails.newBuilder();
    Optional.ofNullable(dischargingInfoId).ifPresent(builder::setId);
    Optional.ofNullable(dischargingDetails.getStartTime()).ifPresent(builder::setStartTime);
    Optional.ofNullable(dischargingDetails.getTimeOfSunrise()).ifPresent(builder::setTimeOfSunrise);
    Optional.ofNullable(dischargingDetails.getTimeOfSunset()).ifPresent(builder::setTimeOfSunset);
    com.cpdss.common.generated.loading_plan.LoadingPlanModels.TrimAllowed.Builder trimBuilder =
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.TrimAllowed.newBuilder();
    if (!Optional.ofNullable(dischargingDetails.getTrimAllowed()).isEmpty()) {
      Optional.ofNullable(dischargingDetails.getTrimAllowed().getFinalTrim())
          .ifPresent(finalTrim -> trimBuilder.setFinalTrim(String.valueOf(finalTrim)));
      Optional.ofNullable(dischargingDetails.getTrimAllowed().getInitialTrim())
          .ifPresent(initialTrim -> trimBuilder.setInitialTrim(String.valueOf(initialTrim)));
      Optional.ofNullable(dischargingDetails.getTrimAllowed().getMaximumTrim())
          .ifPresent(maxTrim -> trimBuilder.setMaximumTrim(String.valueOf(maxTrim)));
    }
    builder.setTrimAllowed(trimBuilder.build());
    Optional.ofNullable(dischargingDetails.getCommonDate())
        .ifPresent(commonDate -> builder.setCommonDate(String.valueOf(commonDate)));
    Optional.ofNullable(dischargingDetails.getSlopQuantity())
        .ifPresent(slopQuantity -> builder.setSlopQuantity(slopQuantity.toString()));
    return builder.build();
  }

  /**
   * Method to build discharge stage
   *
   * @param request DischargingInformationRequest object
   * @return LoadingStages object
   */
  public LoadingStages buildDischargingStage(DischargingInformationRequest request) {

    log.info("Inside buildDischargingStage method!");
    LoadingStages.Builder builder = LoadingStages.newBuilder();
    com.cpdss.common.generated.loading_plan.LoadingPlanModels.StageDuration.Builder
        durationBuilder =
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.StageDuration.newBuilder();
    StageOffsets.Builder offsetBuilder = StageOffsets.newBuilder();

    if (request.getDischargeStages() != null) {
      if (request.getDischargeStages().getStageDuration() != null) {

        // Set fields
        Optional.ofNullable(request.getDischargeStages().getStageDuration().getId())
            .ifPresent(durationBuilder::setId);
        Optional.ofNullable(request.getDischargeStages().getStageDuration().getDuration())
            .ifPresent(durationBuilder::setDuration);
      }

      if (request.getDischargeStages().getStageOffset() != null) {
        Optional.ofNullable(request.getDischargeStages().getStageOffset().getId())
            .ifPresent(offsetBuilder::setId);
        Optional.ofNullable(request.getDischargeStages().getStageOffset().getStageOffsetVal())
            .ifPresent(offsetBuilder::setStageOffsetVal);
      }

      Optional.ofNullable(request.getDischargeStages().getTrackGradeSwitch())
          .ifPresent(builder::setTrackGradeSwitch);
      Optional.ofNullable(request.getDischargeStages().getTrackStartEndStage())
          .ifPresent(builder::setTrackStartEndStage);

      // Set flags for check boxes
      Optional.ofNullable(request.getDischargeStages().getIsStageDurationUsed())
          .ifPresent(builder::setIsStageDurationUsed);
      Optional.ofNullable(request.getDischargeStages().getIsStageOffsetUsed())
          .ifPresent(builder::setIsStageOffsetUsed);
    }

    builder.setDuration(durationBuilder.build());
    builder.setOffset(offsetBuilder.build());
    return builder.build();
  }

  public void buildPostDischargeRates(
      PostDischargeStageTime postDischargeStageTime,
      AdminRuleValueExtract extract,
      com.cpdss.gateway.domain.dischargeplan.DischargeInformation dischargeInformation) {

    // All 4 fields need to get From Admin Rule
    PostDischargeStage postDischargeStage = new PostDischargeStage();
    if (postDischargeStageTime.getTimeForDryCheck().isEmpty()) {
      var defaultValueForKey =
          extract.getDefaultValueForKey(AdminRuleTemplate.DISCHARGE_TIME_FOR_DRY_CHECK);
      postDischargeStage.setDryCheckTime(returnZeroIfBlank(defaultValueForKey));
    } else {
      postDischargeStage.setDryCheckTime(
          returnZeroIfBlank(postDischargeStageTime.getTimeForDryCheck()));
    }

    if (postDischargeStageTime.getSlopDischarging().isEmpty()) {
      var defaultValueForKey =
          extract.getDefaultValueForKey(AdminRuleTemplate.DISCHARGE_SLOP_DISCHARGE);
      postDischargeStage.setSlopDischargingTime(returnZeroIfBlank(defaultValueForKey));
    } else {
      postDischargeStage.setSlopDischargingTime(
          returnZeroIfBlank(postDischargeStageTime.getSlopDischarging()));
    }

    if (postDischargeStageTime.getFinalStripping().isEmpty()) {
      var defaultValueForKey =
          extract.getDefaultValueForKey(AdminRuleTemplate.DISCHARGE_FINAL_STRIPPING);
      postDischargeStage.setFinalStrippingTime(returnZeroIfBlank(defaultValueForKey));
    } else {
      postDischargeStage.setFinalStrippingTime(
          returnZeroIfBlank(postDischargeStageTime.getFinalStripping()));
    }

    if (postDischargeStageTime.getFreshOilWashing().isEmpty()) {
      var defaultValueForKey =
          extract.getDefaultValueForKey(AdminRuleTemplate.DISCHARGE_FRESH_OIL_WASHING);
      postDischargeStage.setFreshOilWashingTime(returnZeroIfBlank(defaultValueForKey));
    } else {
      postDischargeStage.setFreshOilWashingTime(
          returnZeroIfBlank(postDischargeStageTime.getFreshOilWashing()));
    }

    dischargeInformation.setPostDischargeStageTime(postDischargeStage);
  }
}
