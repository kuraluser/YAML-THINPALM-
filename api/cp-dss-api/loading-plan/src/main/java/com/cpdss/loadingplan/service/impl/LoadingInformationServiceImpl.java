/* Licensed at AlphaOri Technologies */
package com.cpdss.loadingplan.service.impl;

import static com.cpdss.loadingplan.common.LoadingPlanConstants.*;

import com.cpdss.common.exception.GenericServiceException;
import com.cpdss.common.generated.Common;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformationDetail;
import com.cpdss.loadingplan.domain.LoadingInfoResponse;
import com.cpdss.loadingplan.entity.*;
import com.cpdss.loadingplan.repository.*;
import com.cpdss.loadingplan.service.CargoToppingOffSequenceService;
import com.cpdss.loadingplan.service.LoadingBerthService;
import com.cpdss.loadingplan.service.LoadingDelayService;
import com.cpdss.loadingplan.service.LoadingInformationBuilderService;
import com.cpdss.loadingplan.service.LoadingInformationService;
import com.cpdss.loadingplan.service.LoadingMachineryInUseService;
import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Slf4j
@Service
@Transactional
public class LoadingInformationServiceImpl implements LoadingInformationService {

  @Autowired LoadingInformationRepository loadingInformationRepository;
  @Autowired CargoToppingOffSequenceRepository cargoToppingOffSequenceRepository;
  @Autowired LoadablePlanBallastDetailsRepository loadablePlanBallastDetailsRepository;
  @Autowired LoadablePlanCommingleDetailsRepository loadablePlanCommingleDetailsRepository;
  @Autowired LoadablePlanQuantityRepository loadablePlanQuantityRepository;
  @Autowired LoadablePlanStowageDetailsRepository loadablePlanStowageDetailsRepository;
  @Autowired LoadingInformationBuilderService informationBuilderService;
  @Autowired LoadingBerthDetailsRepository berthDetailsRepository;
  @Autowired LoadingMachineryInUseRepository loadingMachineryInUserRepository;
  @Autowired LoadingBerthDetailsRepository loadingBerthDetailsRepository;

  @Autowired StageOffsetRepository stageOffsetRepository;

  @Autowired StageDurationRepository stageDurationRepository;

  @Autowired ReasonForDelayRepository reasonForDelayRepository;

  @Autowired LoadingDelayRepository loadingDelayRepository;

  @Autowired LoadingBerthService loadingBerthService;
  @Autowired LoadingDelayService loadingDelayService;
  @Autowired LoadingMachineryInUseService loadingMachineryInUseService;
  @Autowired CargoToppingOffSequenceService toppingOffSequenceService;

  @Override
  public LoadingInformation saveLoadingInformationDetail(
      LoadingInformationDetail loadingInformationDetail, LoadingInformation loadingInformation) {
    deleteLoadingInformationOfVessel(
        loadingInformationDetail.getVesselId(), loadingInformationDetail.getLoadablePatternId());

    Optional.ofNullable(loadingInformationDetail.getLoadablePatternId())
        .ifPresent(loadingInformation::setLoadablePatternXId);
    Optional.ofNullable(loadingInformationDetail.getPortId())
        .ifPresent(loadingInformation::setPortXId);
    Optional.ofNullable(loadingInformationDetail.getSynopticalTableId())
        .ifPresent(loadingInformation::setSynopticalTableXId);
    Optional.ofNullable(loadingInformationDetail.getVesselId())
        .ifPresent(loadingInformation::setVesselXId);
    Optional.ofNullable(loadingInformationDetail.getVoyageId())
        .ifPresent(loadingInformation::setVoyageId);
    Optional.ofNullable(loadingInformationDetail.getPortRotationId())
        .ifPresent(loadingInformation::setPortRotationXId);
    Optional<StageOffset> defaultOffsetOpt =
        stageOffsetRepository.findByStageOffsetValAndIsActiveTrue(DEFAULT_STAGE_OFFSET_VALUE);
    Optional<StageDuration> defaultDurationOpt =
        stageDurationRepository.findByDurationAndIsActiveTrue(DEFAULT_STAGE_DURATION_VALUE);
    if (defaultOffsetOpt.isPresent()) {
      loadingInformation.setStageOffset(defaultOffsetOpt.get());
    }
    if (defaultDurationOpt.isPresent()) {
      loadingInformation.setStageDuration(defaultDurationOpt.get());
    }
    loadingInformation.setIsLoadingInfoComplete(false);
    loadingInformation.setIsActive(true);
    return loadingInformationRepository.save(loadingInformation);
  }

  private void deleteLoadingInformationOfVessel(Long vesselId, Long loadablePatternId) {

    List<LoadingInformation> loadingInformations =
        loadingInformationRepository.findByVesselXIdAndLoadablePatternXIdNotAndIsActive(
            vesselId, loadablePatternId, true);
    loadingInformations.forEach(
        loadingInformation -> {
          deleteLoadablePlanDetails(loadingInformation);
          loadingInformationRepository.deleteByLoadingInformationId(loadingInformation.getId());
        });
  }

  @Override
  public void deleteLoadablePlanDetails(LoadingInformation loadingInformation) {
    cargoToppingOffSequenceRepository.deleteByLoadingInformation(loadingInformation);
    loadablePlanBallastDetailsRepository.deleteByLoadingInformation(loadingInformation);
    loadablePlanCommingleDetailsRepository.deleteByLoadingInformation(loadingInformation);
    loadablePlanQuantityRepository.deleteByLoadingInformation(loadingInformation);
    loadablePlanStowageDetailsRepository.deleteByLoadingInformation(loadingInformation);
    loadingBerthDetailsRepository.deleteByLoadingInformationId(loadingInformation.getId());
    loadingDelayRepository.deleteByLoadingInformationId(loadingInformation.getId());
    loadingMachineryInUserRepository.deleteByLoadingInformationId(loadingInformation.getId());
  }

  @Override
  public Optional<LoadingInformation> getLoadingInformation(
      Long id, Long vesselId, Long voyageId, Long patternId, Long portRotationId) {
    Optional<LoadingInformation> information = Optional.empty();
    if (id != 0) {
      information = this.loadingInformationRepository.findById(id);
      log.info("Loading Information found for Id {}", id);
      if (information.isPresent()) return information;
    }
    if (vesselId != 0 && voyageId != 0 && portRotationId != 0) {
      information =
          this.loadingInformationRepository
              .findByVesselXIdAndVoyageIdAndPortRotationXIdAndIsActiveTrue(
                  vesselId, voyageId, portRotationId);
      if (information.isPresent()) {
        log.info(
            "Loading Information found Id {}, for Voyage Id {}, Port Rotation Id {}",
            information.get().getId(),
            voyageId,
            portRotationId);
        return information;
      }
    }
    log.info("No data found for Loading Information");
    return information;
  }

  @Override
  public Optional<LoadingInformation> getLoadingInformation(Long id) {
    return this.getLoadingInformation(id, 0L, 0L, 0L, 0L);
  }

  @Override
  public LoadingPlanModels.LoadingInformation getLoadingInformation(
      LoadingPlanModels.LoadingInformationRequest request,
      LoadingPlanModels.LoadingInformation.Builder builder)
      throws GenericServiceException {

    Common.ResponseStatus.Builder responseStatus = Common.ResponseStatus.newBuilder();
    responseStatus.setStatus(FAILED);

    Optional<LoadingInformation> var1 =
        this.getLoadingInformation(
            request.getLoadingPlanId(),
            request.getVesselId(),
            request.getVoyageId(),
            request.getLoadingPatternId(),
            request.getPortRotationId());
    if (!var1.isPresent()) {
      log.info("No Loading Information found for Id {}", request.getLoadingPlanId());
    }

    // Common fields
    var1.ifPresent(v -> builder.setLoadingInfoId(v.getId()));
    var1.ifPresent(v -> builder.setSynopticTableId(v.getSynopticalTableXId()));
    var1.ifPresent(
        v -> {
          if (v.getIsLoadingInfoComplete() != null) {
            builder.setIsLoadingInfoComplete(v.getIsLoadingInfoComplete());
          }
        });

    // Loading Details
    LoadingPlanModels.LoadingDetails details =
        this.informationBuilderService.buildLoadingDetailsMessage(var1.orElse(null));

    // Loading Rates
    LoadingPlanModels.LoadingRates rates =
        this.informationBuilderService.buildLoadingRateMessage(var1.orElse(null));

    // Loading Berths
    List<LoadingBerthDetail> list1 =
        this.berthDetailsRepository.findAllByLoadingInformationAndIsActiveTrue(var1.orElse(null));
    List<LoadingPlanModels.LoadingBerths> berths =
        this.informationBuilderService.buildLoadingBerthsMessage(list1);

    // Machines in use
    List<LoadingMachineryInUse> list2 =
        this.loadingMachineryInUserRepository.findAllByLoadingInformationAndIsActiveTrue(
            var1.orElse(null));
    List<LoadingPlanModels.LoadingMachinesInUse> machines =
        this.informationBuilderService.buildLoadingMachineryInUseMessage(list2);

    // Stage Min Amount Master
    List<StageOffset> list3 = this.stageOffsetRepository.findAll();
    // Stage Duration Master
    List<StageDuration> list4 = this.stageDurationRepository.findAll();

    // Staging User data and Master data
    LoadingPlanModels.LoadingStages loadingStages =
        this.informationBuilderService.buildLoadingStageMessage(var1.orElse(null), list3, list4);

    // Loading Delay
    List<ReasonForDelay> list5 = this.reasonForDelayRepository.findAll();
    List<LoadingDelay> list6 =
        this.loadingDelayRepository.findAllByLoadingInformationAndIsActiveTrue(var1.orElse(null));
    LoadingPlanModels.LoadingDelay loadingDelay =
        this.informationBuilderService.buildLoadingDelayMessage(list5, list6);

    List<CargoToppingOffSequence> list8 =
        this.cargoToppingOffSequenceRepository.findAllByLoadingInformationAndIsActiveTrue(
            var1.orElse(null));
    List<LoadingPlanModels.LoadingToppingOff> toppingOff =
        this.informationBuilderService.buildToppingOffMessage(list8);

    builder.setLoadingDetail(details);
    builder.setLoadingRate(rates);
    builder.addAllLoadingBerths(berths);
    builder.addAllLoadingMachines(machines);
    builder.setLoadingStage(loadingStages);
    builder.setLoadingDelays(loadingDelay);
    builder.addAllToppingOffSequence(toppingOff);
    builder.setResponseStatus(responseStatus.setStatus(SUCCESS));
    return builder.build();
  }

  @Override
  public LoadingInformation saveLoadingInformation(
      com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation request)
      throws Exception {
    Optional<LoadingInformation> loadingInformationOpt =
        loadingInformationRepository.findByIdAndIsActiveTrue(request.getLoadingDetail().getId());
    if (loadingInformationOpt.isPresent()) {
      LoadingInformation loadingInformation = loadingInformationOpt.get();
      informationBuilderService.buildLoadingInfoFromRpcMessage(request, loadingInformation);
      loadingInformationRepository.save(loadingInformation);
      return loadingInformationOpt.get();
    } else {
      throw new Exception(
          "Cannot find loading information with id " + request.getLoadingDetail().getId());
    }
  }

  @Override
  public LoadingInformation saveLoadingInfoRates(
      LoadingPlanModels.LoadingRates source,
      LoadingInformation loadingInformation,
      LoadingPlanModels.LoadingInfoSaveResponse.Builder response) {
    Optional<LoadingInformation> information = this.getLoadingInformation(source.getId());
    if (information.isPresent()) {
      LoadingInformation var1 = information.get();
      log.info("Save Loading Info, Set Loading Rates");
      if (!source.getLineContentRemaining().isEmpty())
        var1.setLineContentRemaining(new BigDecimal(source.getLineContentRemaining()));

      if (!source.getMaxDeBallastingRate().isEmpty())
        var1.setMaxDeBallastRate(new BigDecimal(source.getMaxDeBallastingRate()));

      if (!source.getMaxLoadingRate().isEmpty())
        var1.setMaxLoadingRate(new BigDecimal(source.getMaxLoadingRate()));

      if (!source.getMinDeBallastingRate().isEmpty())
        var1.setMinDeBallastRate(new BigDecimal(source.getMinDeBallastingRate()));

      if (!source.getReducedLoadingRate().isEmpty())
        var1.setReducedLoadingRate(new BigDecimal(source.getReducedLoadingRate()));

      if (!source.getMinLoadingRate().isEmpty())
        var1.setMinLoadingRate(new BigDecimal(source.getMinLoadingRate()));

      if (!source.getInitialLoadingRate().isEmpty())
        var1.setInitialLoadingRate(new BigDecimal(source.getInitialLoadingRate()));

      if (!source.getNoticeTimeRateReduction().isEmpty())
        var1.setNoticeTimeForRateReduction(Integer.valueOf(source.getNoticeTimeRateReduction()));

      if (!source.getNoticeTimeStopLoading().isEmpty())
        var1.setNoticeTimeForStopLoading(Integer.valueOf(source.getNoticeTimeStopLoading()));

      if (!source.getShoreLoadingRate().isEmpty())
        var1.setShoreLoadingRate(new BigDecimal(source.getShoreLoadingRate()));

      loadingInformationRepository.save(var1);
      return var1;
    }
    return null;
  }

  @Override
  public LoadingInformation saveLoadingInfoBerths(
      List<LoadingPlanModels.LoadingBerths> berths,
      LoadingInformation loadingInformation,
      LoadingPlanModels.LoadingInfoSaveResponse.Builder response)
      throws GenericServiceException {
    return null;
  }

  @Override
  public LoadingInformation saveLoadingInfoMachines(
      List<LoadingPlanModels.LoadingMachinesInUse> machines,
      LoadingInformation loadingInformation,
      LoadingPlanModels.LoadingInfoSaveResponse.Builder response)
      throws GenericServiceException {
    return null;
  }

  @Override
  public LoadingInformation saveLoadingInfoDelays(
      List<LoadingPlanModels.LoadingDelay> loadingDelays,
      LoadingInformation loadingInformation,
      LoadingPlanModels.LoadingInfoSaveResponse.Builder response)
      throws GenericServiceException {
    return null;
  }

  @Override
  public LoadingInformation saveLoadingInfoStages(
      LoadingPlanModels.LoadingStages loadingStage, LoadingInformation loadingInformation) {

    if (loadingStage != null) {
      loadingInformation.setTrackStartEndStage(loadingStage.getTrackStartEndStage());
      loadingInformation.setTrackGradeSwitch(loadingStage.getTrackGradeSwitch());
      if (Optional.ofNullable(loadingStage.getDuration().getId()).isPresent()
          && loadingStage.getDuration().getId() != 0) {
        Optional<StageDuration> stageDurationOpt =
            stageDurationRepository.findByIdAndIsActiveTrue(loadingStage.getDuration().getId());
        if (stageDurationOpt.isPresent()) {
          loadingInformation.setStageDuration(stageDurationOpt.get());
        } else {
          log.error("Duration not found id {}", loadingStage.getDuration().getId());
        }
      }
      if (Optional.of(loadingStage.getOffset().getId()).isPresent()
          && loadingStage.getOffset().getId() != 0) {
        Optional<StageOffset> stageOffsetOpt =
            stageOffsetRepository.findByIdAndIsActiveTrue(loadingStage.getOffset().getId());
        if (stageOffsetOpt.isPresent()) {
          loadingInformation.setStageOffset(stageOffsetOpt.get());
        } else {
          log.info("Offset Not found Id {}", loadingStage.getOffset().getId());
        }
      }
      loadingInformationRepository.save(loadingInformation);
    }
    return null;
  }

  private void buildLoadingInfoResponse(
      LoadingInformation loadingInformation, LoadingInfoResponse loadingInfoResponse) {
    loadingInfoResponse.setLoadingInfoId(loadingInformation.getId());
    loadingInfoResponse.setVesselId(loadingInformation.getVesselXId());
    loadingInfoResponse.setVoyageId(loadingInformation.getVoyageId());
    loadingInfoResponse.setPortRotationId(loadingInformation.getPortRotationXId());
    loadingInfoResponse.setSynopticalTableId(loadingInformation.getSynopticalTableXId());
  }

  private void buildLoadingInformation(
      com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformation request,
      LoadingInformation loadingInformation)
      throws Exception {
    if (Optional.ofNullable(request.getLoadingStage().getDuration().getId()).isPresent()
        && request.getLoadingStage().getDuration().getId() != 0) {
      Optional<StageDuration> stageDurationOpt =
          stageDurationRepository.findByIdAndIsActiveTrue(
              request.getLoadingStage().getDuration().getId());
      if (stageDurationOpt.isPresent()) {
        loadingInformation.setStageDuration(stageDurationOpt.get());
      } else {
        throw new Exception("Invalid stage duration");
      }
    }

    if (Optional.ofNullable(request.getLoadingStage().getOffset().getId()).isPresent()
        && request.getLoadingStage().getOffset().getId() != 0) {
      Optional<StageOffset> stageOffsetOpt =
          stageOffsetRepository.findByIdAndIsActiveTrue(
              request.getLoadingStage().getOffset().getId());
      if (stageOffsetOpt.isPresent()) {
        loadingInformation.setStageOffset(stageOffsetOpt.get());
      } else {
        throw new Exception("Invalid stage offset");
      }
    }
    loadingInformation.setStartTime(
        StringUtils.isEmpty(request.getLoadingDetail().getStartTime())
            ? null
            : LocalTime.from(TIME_FORMATTER.parse(request.getLoadingDetail().getStartTime())));
    loadingInformation.setFinalTrim(
        StringUtils.isEmpty(request.getLoadingDetail().getTrimAllowed().getFinalTrim())
            ? null
            : new BigDecimal(request.getLoadingDetail().getTrimAllowed().getFinalTrim()));
    loadingInformation.setInitialTrim(
        StringUtils.isEmpty(request.getLoadingDetail().getTrimAllowed().getInitialTrim())
            ? null
            : new BigDecimal(request.getLoadingDetail().getTrimAllowed().getInitialTrim()));
    loadingInformation.setMaximumTrim(
        StringUtils.isEmpty(request.getLoadingDetail().getTrimAllowed().getMaximumTrim())
            ? null
            : new BigDecimal(request.getLoadingDetail().getTrimAllowed().getMaximumTrim()));
    loadingInformation.setLineContentRemaining(
        StringUtils.isEmpty(request.getLoadingRate().getLineContentRemaining())
            ? null
            : new BigDecimal(request.getLoadingRate().getLineContentRemaining()));
    loadingInformation.setMaxDeBallastRate(
        StringUtils.isEmpty(request.getLoadingRate().getMaxDeBallastingRate())
            ? null
            : new BigDecimal(request.getLoadingRate().getMaxDeBallastingRate()));
    loadingInformation.setMaxLoadingRate(
        StringUtils.isEmpty(request.getLoadingRate().getMaxLoadingRate())
            ? null
            : new BigDecimal(request.getLoadingRate().getMaxLoadingRate()));
    loadingInformation.setMinDeBallastRate(
        StringUtils.isEmpty(request.getLoadingRate().getMinDeBallastingRate())
            ? null
            : new BigDecimal(request.getLoadingRate().getMinDeBallastingRate()));
    loadingInformation.setReducedLoadingRate(
        StringUtils.isEmpty(request.getLoadingRate().getReducedLoadingRate())
            ? null
            : new BigDecimal(request.getLoadingRate().getReducedLoadingRate()));
    loadingInformation.setMinLoadingRate(
        StringUtils.isEmpty(request.getLoadingRate().getMinLoadingRate())
            ? null
            : new BigDecimal(request.getLoadingRate().getMinLoadingRate()));
    loadingInformation.setInitialLoadingRate(
        StringUtils.isEmpty(request.getLoadingRate().getInitialLoadingRate())
            ? null
            : new BigDecimal(request.getLoadingRate().getInitialLoadingRate()));
    loadingInformation.setNoticeTimeForRateReduction(
        StringUtils.isEmpty(request.getLoadingRate().getNoticeTimeRateReduction())
            ? null
            : Integer.valueOf(request.getLoadingRate().getNoticeTimeRateReduction()));
    loadingInformation.setNoticeTimeForStopLoading(
        StringUtils.isEmpty(request.getLoadingRate().getNoticeTimeStopLoading())
            ? null
            : Integer.valueOf(request.getLoadingRate().getNoticeTimeStopLoading()));
    loadingInformation.setTrackGradeSwitch(request.getLoadingStage().getTrackGradeSwitch());
    loadingInformation.setTrackStartEndStage(request.getLoadingStage().getTrackStartEndStage());

    if (request.getLoadingBerthsCount() > 0) {
      loadingInformation.setIsLoadingInfoComplete(true);
    } else {
      loadingInformation.setIsLoadingInfoComplete(false);
    }
  }
}