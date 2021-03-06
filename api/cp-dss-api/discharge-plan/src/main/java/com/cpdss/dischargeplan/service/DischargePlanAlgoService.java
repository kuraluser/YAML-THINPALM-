/* Licensed at AlphaOri Technologies */
package com.cpdss.dischargeplan.service;

import static com.cpdss.dischargeplan.service.utility.DischargePlanConstants.SUCCESS;
import static org.springframework.util.StringUtils.isEmpty;

import com.cpdss.common.constants.AlgoErrorHeaderConstants;
import com.cpdss.common.exception.GenericServiceException;
import com.cpdss.common.generated.*;
import com.cpdss.common.generated.LoadableStudy.AlgoErrorReply.Builder;
import com.cpdss.common.generated.LoadableStudy.AlgoErrorRequest;
import com.cpdss.common.generated.LoadableStudy.AlgoStatusRequest;
import com.cpdss.common.generated.LoadableStudy.JsonRequest;
import com.cpdss.common.generated.discharge_plan.*;
import com.cpdss.common.generated.loadableStudy.LoadableStudyModels;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels.*;
import com.cpdss.common.rest.CommonErrorCodes;
import com.cpdss.common.utils.HttpStatusCode;
import com.cpdss.common.utils.MessageTypes;
import com.cpdss.dischargeplan.common.CommunicationStatus;
import com.cpdss.dischargeplan.common.DischargePlanConstants;
import com.cpdss.dischargeplan.common.RuleUtility;
import com.cpdss.dischargeplan.communication.DischargePlanStagingService;
import com.cpdss.dischargeplan.domain.*;
import com.cpdss.dischargeplan.domain.CowPlan;
import com.cpdss.dischargeplan.domain.DischargeDelays;
import com.cpdss.dischargeplan.domain.DischargeDetails;
import com.cpdss.dischargeplan.domain.DischargeMachinesInUse;
import com.cpdss.dischargeplan.domain.DischargePlanPortWiseDetails;
import com.cpdss.dischargeplan.domain.DischargeRates;
import com.cpdss.dischargeplan.domain.ReasonForDelay;
import com.cpdss.dischargeplan.domain.TrimAllowed;
import com.cpdss.dischargeplan.domain.cargo.DischargeQuantityCargoDetails;
import com.cpdss.dischargeplan.domain.cargo.LoadablePlanPortWiseDetails;
import com.cpdss.dischargeplan.domain.cargo.OnBoardQuantity;
import com.cpdss.dischargeplan.domain.cargo.OnHandQuantity;
import com.cpdss.dischargeplan.domain.rules.RulePlans;
import com.cpdss.dischargeplan.domain.rules.RuleResponse;
import com.cpdss.dischargeplan.domain.vessel.PumpTypes;
import com.cpdss.dischargeplan.domain.vessel.VesselBottomLine;
import com.cpdss.dischargeplan.domain.vessel.VesselManifold;
import com.cpdss.dischargeplan.domain.vessel.VesselPump;
import com.cpdss.dischargeplan.entity.*;
import com.cpdss.dischargeplan.entity.DischargeInformation;
import com.cpdss.dischargeplan.entity.DischargingPlanStabilityParameters;
import com.cpdss.dischargeplan.entity.DischargingSequence;
import com.cpdss.dischargeplan.entity.PortDischargingPlanRobDetails;
import com.cpdss.dischargeplan.repository.*;
import com.cpdss.dischargeplan.repository.projections.PortTideAlgo;
import com.cpdss.dischargeplan.service.loadicator.LoadicatorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

@Slf4j
@Service
public class DischargePlanAlgoService {

  @Autowired private DischargeInformationService dischargeInformationService;

  @Autowired private DischargeBerthDetailRepository dischargeBerthDetailRepository;

  @Autowired DischargingMachineryInUseRepository dischargingMachineryInUseRepository;
  @Autowired private ReasonForDelayRepository reasonForDelayRepository;

  @Autowired private CowPlanDetailRepository cowPlanDetailRepository;
  @Autowired private CowTankDetailRepository cowTankDetailRepository;
  @Autowired private CowWithDifferentCargoRepository cowWithDifferentCargoRepository;

  @Autowired private DischargeInformationStatusRepository dischargeInformationStatusRepository;
  @Autowired private DischargingPlanBuilderService dischargingPlanBuilderService;

  @Autowired
  private DischargingInformationAlgoStatusRepository dischargingInformationAlgoStatusRepository;

  @Autowired private DischargingSequenceRepository dischargingSequenceRepository;
  @Autowired private LoadicatorService loadicatorService;
  @Autowired private BallastOperationRepository ballastOperationRepository;
  @Autowired private CargoDischargingRateRepository cargoDischargingRateRepository;
  @Autowired private DeballastingRateRepository deballastingRateRepository;

  @Autowired
  private DischargingSequenceStabiltyParametersRepository
      dischargingSequenceStabiltyParametersRepository;

  @Autowired private AlgoErrorHeadingRepository algoErrorHeadingRepository;
  @Autowired private AlgoErrorsRepository algoErrorsRepository;
  @Autowired private BallastValveRepository ballastValveRepository;
  @Autowired private CargoValveRepository cargoValveRepository;

  @Autowired
  private DischargingPlanCommingleDetailsRepository dischargingPlanCommingleDetailsRepository;

  @Autowired
  private DischargingPlanStabilityParametersRepository dischargingPlanStabilityParametersRepository;

  @Autowired private DischargingPlanRobDetailsRepository dischargingPlanRobDetailsRepository;

  @Autowired
  private DischargingPlanBallastDetailsRepository dischargingPlanBallastDetailsRepository;

  @Autowired
  private DischargingPlanStowageDetailsRepository dischargingPlanStowageDetailsRepository;

  @Autowired
  private DischargingPlanPortWiseDetailsRepository dischargingPlanPortWiseDetailsRepository;

  @Autowired private PortDischargingPlanRobDetailsRepository portRobDetailsRepository;
  @Autowired private PortDischargingPlanStabilityParametersRepository portStabilityParamsRepository;
  @Autowired private PortDischargingPlanStowageDetailsRepository portStowageDetailsRepository;

  @Autowired
  private PortDischargingPlanCommingleDetailsRepository
      portDischargingPlanCommingleDetailsRepository;

  @Autowired
  private PortDischargingPlanStowageTempDetailsRepository
      portDischargingPlanStowageTempDetailsRepository;

  @Autowired
  private PortDischargingPlanBallastTempDetailsRepository
      portDischargingPlanBallastTempDetailsRepository;

  @GrpcClient("loadableStudyService")
  private LoadableStudyServiceGrpc.LoadableStudyServiceBlockingStub loadableStudyService;

  @GrpcClient("loadableStudyService")
  private DischargeStudyOperationServiceGrpc.DischargeStudyOperationServiceBlockingStub
      dischargeStudyService;

  @Autowired
  private PortDischargingPlanBallastDetailsRepository portDischargingPlanBallastDetailsRepository;

  @GrpcClient("vesselInfoService")
  private VesselInfoServiceGrpc.VesselInfoServiceBlockingStub vesselInfoService;

  @GrpcClient("portInfoService")
  private PortInfoServiceGrpc.PortInfoServiceBlockingStub portInfoServiceBlockingStub;

  @GrpcClient("loadableStudyService")
  private DischargeStudyOperationServiceGrpc.DischargeStudyOperationServiceBlockingStub
      dischargeStudyOperationServiceBlockingStub;

  @Autowired private DischargingDelayRepository dischargingDelayRepository;
  @Autowired private DischargingDelayReasonRepository dischargingDelayReasonRepository;

  @Value("${cpdss.build.env}")
  private String env;

  @Value("${cpdss.communication.enable}")
  private boolean enableCommunication;

  @Autowired private DischargePlanCommunicationService dischargePlanCommunicationService;

  @Autowired
  private DischargePlanCommunicationStatusRepository dischargePlanCommunicationStatusRepository;

  @Autowired private DischargePlanStagingService dischargePlanStagingService;

  @Autowired private EductionOperationRepository eductionOperationRepository;

  @Autowired private DischargingDriveTankRepository dischargingDriveTankRepository;
  @Autowired private PortTideDetailsRepository portTideDetailsRepository;

  @Autowired private DischargingTankTransferRepository dischargingTankTransferRepository;

  @Autowired
  private DischargingTankTransferDetailsRepository dischargingTankTransferDetailsRepository;

  private static final Integer cowBottomTypeId = 2;
  private static final Integer cowTopTypeId = 3;
  private static final Integer cowFullTypeId = 1;

  @Value("${loadingplan.attachment.rootFolder}")
  private String rootFolder;

  public void buildDischargeInformation(
      DischargeInformationRequest request,
      com.cpdss.dischargeplan.domain.DischargeInformationAlgoRequest algoRequest)
      throws GenericServiceException {
    com.cpdss.dischargeplan.entity.DischargeInformation entity =
        dischargeInformationService.getDischargeInformation(request.getDischargeInfoId());
    com.cpdss.dischargeplan.domain.DischargeInformation disDto =
        new com.cpdss.dischargeplan.domain.DischargeInformation();
    if (entity != null) {

      // basic details
      algoRequest.setVoyageId(entity.getVoyageXid());
      algoRequest.setVesselId(entity.getVesselXid());
      algoRequest.setPortId(entity.getPortXid());
      disDto.setDischargeInfoId(entity.getId());
      disDto.setSynopticTableId(entity.getSynopticTableXid());
      algoRequest.setPortRotationId(entity.getPortRotationXid());
      disDto.setDischargeCommingledCargoSeparately(entity.getDischargeCommingleCargoSeparately());
      disDto.setDischargeSlopTanksFirst(entity.getDischargeSlopTankFirst());

      // discharge details
      DischargeDetails dischargeDetails = new DischargeDetails();
      dischargeDetails.setStartTime(
          entity.getStartTime() != null ? entity.getStartTime().toString() : null);
      // sunrise and sunset from DS(synoptic)
      this.getAndSetDataFromSynopticTable(entity.getPortRotationXid(), dischargeDetails);
      TrimAllowed trimAllowed = new TrimAllowed();
      trimAllowed.setInitialTrim(entity.getInitialTrim());
      trimAllowed.setMaximumTrim(entity.getMaximumTrim());
      trimAllowed.setFinalTrim(entity.getFinalTrim());

      dischargeDetails.setTrimAllowed(trimAllowed);
      dischargeDetails.setCommonDate(String.valueOf(entity.getCommonDate()));
      dischargeDetails.setSlopQuantity(entity.getSlopQuantity());
      disDto.setDischargeDetails(dischargeDetails);

      // discharge rates
      DischargeRates dischargeRates = new DischargeRates();
      BeanUtils.copyProperties(entity, dischargeRates);
      disDto.setDischargeRates(dischargeRates);

      // discharge berths
      disDto.setBerthDetails(this.buildDischargeBerthDto(entity.getId(), algoRequest));

      // discharge machines
      disDto.setMachineryInUses(this.buildDischargeMachines(entity));

      // discharge stages
      DischargeStages dischargeStages = new DischargeStages();
      if (entity.getDischargingStagesDuration() != null)
        dischargeStages.setStageDuration(entity.getDischargingStagesDuration().getDuration());
      if (entity.getDischargingStagesMinAmount() != null)
        dischargeStages.setStageOffset(entity.getDischargingStagesMinAmount().getMinAmount());
      dischargeStages.setTrackGradeSwitch(entity.getIsTrackGradeSwitching());
      dischargeStages.setTrackStartEndStage(entity.getIsTrackStartEndStage());
      dischargeStages.setIsStageDurationUsed(entity.getIsStageDurationUsed());
      dischargeStages.setIsStageOffsetUsed(entity.getIsStageOffsetUsed());
      disDto.setDischargeStages(dischargeStages);

      // discharge delays
      disDto.setDischargeSequences(this.buildDischargeDelays(entity));

      // discharge cow
      disDto.setCowPlan(this.buildDischargeCowDetails(entity));

      // post discharge rate
      PostDischargeRates postDischargeRates = new PostDischargeRates();
      BeanUtils.copyProperties(entity, postDischargeRates);
      disDto.setPostDischargeStages(postDischargeRates);

      // discharge cargo details, LoadablePlanPortWiseDetails (OHQ, OBQ)
      this.buildDischargePlanPortWiseDetails(algoRequest, entity);

      // Discharge Cargo Quantity
      disDto.setDischargeQuantityCargoDetails(buildCargoVesselTankDetails(entity));

      // Build hourly based tide details which upload from loading info page - TO DO
      algoRequest.setPortTideDetails(buildPortTideDetails(entity.getId(), entity.getPortXid()));

      // Build Discharging Rule, service is in discharging-plan (self)
      buildDischargingRules(algoRequest, entity);

      this.buildDischargeStudy(algoRequest, entity);

      algoRequest.setDischargeInformation(disDto);
    }
  }

  /**
   * Builds the discharge study input details
   *
   * @param algoRequest
   * @param entity
   */
  private void buildDischargeStudy(
      DischargeInformationAlgoRequest algoRequest, DischargeInformation entity)
      throws GenericServiceException {
    Object dischargeStudy = getDischargeStudy(entity);
    algoRequest.setDischargeStudy(dischargeStudy);
  }

  /**
   * Fetches discharge study request JSON from loadable-study MS.
   *
   * @param entity
   * @return
   * @throws GenericServiceException
   */
  private Object getDischargeStudy(DischargeInformation entity) throws GenericServiceException {
    JsonRequest.Builder requestBuilder = JsonRequest.newBuilder();
    requestBuilder.setReferenceId(entity.getDischargingPatternXid());
    LoadableStudyModels.DischargeStudyJsonReply reply =
        dischargeStudyService.getDischargeStudyRequestJson(requestBuilder.build());
    if (!reply.getResponseStatus().getStatus().equals(SUCCESS)) {
      log.error("Failed to get Discharge study input details from Loadable-Study MS");
      throw new GenericServiceException(
          "Failed to get Discharge study input details from Loadable-Study MS",
          CommonErrorCodes.E_HTTP_BAD_REQUEST,
          HttpStatusCode.BAD_REQUEST);
    }
    ObjectMapper objectMapper = new ObjectMapper();
    Object dischargeStudy = null;
    try {
      dischargeStudy = objectMapper.readValue(reply.getDischargeStudyJson(), Object.class);
    } catch (JsonProcessingException e) {
      log.error("Failed to parse discharge study input JSON");
      e.printStackTrace();
      throw new GenericServiceException(
          "Failed to parse Discharge study input details",
          CommonErrorCodes.E_HTTP_BAD_REQUEST,
          HttpStatusCode.BAD_REQUEST);
    }
    return dischargeStudy;
  }

  private List<PortTideAlgo> buildPortTideDetails(Long id, Long portXid) {
    var list = portTideDetailsRepository.findByDischargingXidAndPortXidAndIsActiveTrue(id, portXid);
    log.info("Discharging port tide details - Size {}", list.size());
    return list.isEmpty() ? null : list;
  }

  /**
   * Build discharge plan rule section for the algo request JSON
   *
   * @param algoRequest
   * @param dischargeInformation
   */
  private void buildDischargingRules(
      DischargeInformationAlgoRequest algoRequest, DischargeInformation dischargeInformation) {
    DischargeRuleReply ruleReply =
        dischargeInformationService.getDischargingRuleForAlgo(
            dischargeInformation.getVesselXid(), dischargeInformation.getId());
    if (ruleReply != null) {
      List<RulePlans> rulePlans = RuleUtility.buildDischargingRule(ruleReply);
      algoRequest.setDischargingRules(new RuleResponse(rulePlans));
    }
  }

  private void getAndSetDataFromSynopticTable(
      Long portRotationXid, DischargeDetails dischargeDetails) throws GenericServiceException {
    LoadableStudy.LoadingPlanCommonResponse response =
        this.loadableStudyService.getSynopticDataForLoadingPlan(
            LoadableStudy.LoadingPlanIdRequest.newBuilder()
                .setIdType("PORT_ROTATION")
                .setId(portRotationXid)
                .build());
    if (!response.getResponseStatus().getStatus().equals(DischargePlanConstants.SUCCESS)) {
      log.error("Failed to get Synoptic data from LS ", response.getResponseStatus().getMessage());
      throw new GenericServiceException(
          "Failed to get Synoptic Data for Port",
          CommonErrorCodes.E_HTTP_BAD_REQUEST,
          HttpStatusCode.BAD_REQUEST);
    }
    var synopticData =
        response.getSynopticDataList().stream()
            .filter(v -> v.getOperationType().equalsIgnoreCase("ARR"))
            .findFirst()
            .get();
    if (!synopticData.getTimeOfSunrise().isEmpty()) {
      dischargeDetails.setTimeOfSunrise(synopticData.getTimeOfSunrise());
    }
    if (!synopticData.getTimeOfSunset().isEmpty()) {
      dischargeDetails.setTimeOfSunset(synopticData.getTimeOfSunset());
    }
    log.info("Setting sunrise/sunset from Synoptic table - Port R Id {}", portRotationXid);
  }

  private CowPlan buildDischargeCowDetails(
      com.cpdss.dischargeplan.entity.DischargeInformation entity) {
    CowPlan cowPlan = new CowPlan();
    // need null check, also confirm data will insert from DS
    Optional<CowPlanDetail> cpdOpt =
        this.cowPlanDetailRepository.findByDischargingId(entity.getId());
    cpdOpt.ifPresent(
        cpd -> {
          BeanUtils.copyProperties(cpd, cowPlan);
          cowPlan.setCowOptionType(
              Common.COW_OPTION_TYPE.forNumber(cpd.getCowOperationType()).name());
          List<CowTankDetail> cowTankDetails = cowTankDetailRepository.findAllByCowPlanDetail(cpd);
          if (!CollectionUtils.isEmpty(cowTankDetails)) {
            log.info("CowTankDetail size:{}", cowTankDetails.size());
            cowPlan.setTopCowTankIds(
                cowTankDetails.stream()
                    .filter(v -> v.getCowTypeXid().equals(Common.COW_TYPE.TOP_COW_VALUE))
                    .map(CowTankDetail::getTankXid)
                    .collect(Collectors.toList()));

            cowPlan.setBottomCowTankIds(
                cowTankDetails.stream()
                    .filter(v -> v.getCowTypeXid().equals(Common.COW_TYPE.BOTTOM_COW_VALUE))
                    .map(CowTankDetail::getTankXid)
                    .collect(Collectors.toList()));

            cowPlan.setAllCowTankIds(
                cowTankDetails.stream()
                    .filter(v -> v.getCowTypeXid().equals(Common.COW_TYPE.ALL_COW_VALUE))
                    .map(CowTankDetail::getTankXid)
                    .collect(Collectors.toList()));
          }
          List<CowWithDifferentCargo> cowWithDifferentCargos =
              cowWithDifferentCargoRepository.findAllByCowPlanDetail(cpd);
          if (!CollectionUtils.isEmpty(cowWithDifferentCargos)) {
            log.info("CowWithDifferentCargo size:{}", cowWithDifferentCargos.size());
            List<CargoForCowDetails> cargoForCowDetails = new ArrayList<>();
            var gp1 =
                cowWithDifferentCargos.stream()
                    .collect(
                        Collectors.groupingBy(
                            CowWithDifferentCargo::getCargoXid)); // group by cargo
            for (Map.Entry<Long, List<CowWithDifferentCargo>> map1 : gp1.entrySet()) {
              CowWithDifferentCargo firstItem = map1.getValue().stream().findFirst().get();
              CargoForCowDetails cargoForCow = new CargoForCowDetails();
              cargoForCow.setCargoId(firstItem.getCargoXid());
              cargoForCow.setCargoNominationId(firstItem.getCargoNominationXid());
              cargoForCow.setWashingCargoId(firstItem.getWashingCargoXid());
              cargoForCow.setWashingCargoNominationId(firstItem.getWashingCargoNominationXid());
              cargoForCow.setTankIds(
                  map1.getValue().stream()
                      .map(CowWithDifferentCargo::getTankXid)
                      .collect(Collectors.toList()));
              cargoForCowDetails.add(cargoForCow);
            }
            cowPlan.setCargoCowTankIds(cargoForCowDetails);
          }
        });

    // set cow history
    cowPlan.setCowHistories(this.setCowHistory(entity.getVesselXid()));

    return cowPlan;
  }

  private List<CowHistory> setCowHistory(Long vesselXid) {
    List<CowHistory> cowHistories = new ArrayList<>();
    LoadableStudy.CowHistoryReply cowHistoryReply =
        dischargeStudyOperationServiceBlockingStub.getCowHistoryByVesselId(
            LoadableStudy.CowHistoryRequest.newBuilder().setVesselId(vesselXid).build());

    if (DischargePlanConstants.FAILED.equals(cowHistoryReply.getResponseStatus().getStatus())) {
      log.error("Failed to get cow history details");
      return null;
    }
    var result =
        cowHistoryReply.getCowHistoryList().stream()
            .filter(v -> v.getId() > 0)
            .map(this::buildCowHistoryDto)
            .collect(Collectors.toList());
    log.info("Cow history added to cow plan Size - {}", result.size());
    return result;
  }

  private CowHistory buildCowHistoryDto(LoadableStudy.CowHistory history) {
    CowHistory cowHistory = new CowHistory();
    cowHistory.setId(history.getId());
    cowHistory.setVesselId(history.getVesselId());
    cowHistory.setVoyageId(history.getVoyageId());
    cowHistory.setTankId(history.getTankId());
    cowHistory.setPortId(history.getPortId());
    cowHistory.setCowOptionType(history.getCowOptionType().name());
    cowHistory.setVoyageEndDate(history.getVoyageEndDate());
    return cowHistory;
  }

  private DischargeSequences buildDischargeDelays(
      com.cpdss.dischargeplan.entity.DischargeInformation entity) throws GenericServiceException {

    DischargeSequences dischargeSequences = new DischargeSequences();

    // Set Master data of Reasons
    List<com.cpdss.dischargeplan.entity.ReasonForDelay> list =
        this.reasonForDelayRepository.findAllByIsActiveTrue();
    List<ReasonForDelay> reasonsForDelay = new ArrayList<ReasonForDelay>();
    list.forEach(
        delayReason -> {
          ReasonForDelay reason = new ReasonForDelay();
          reason.setId(delayReason.getId());
          reason.setReason(delayReason.getReason());
          reasonsForDelay.add(reason);
        });
    dischargeSequences.setReasonForDelays(reasonsForDelay); // Master data

    // User Data from DB
    List<DischargeDelays> dischargeDelays = new ArrayList<>();
    List<DischargingDelay> delays =
        dischargingDelayRepository.findByDischargingInformationIdAndIsActive(entity.getId(), true);
    delays.forEach(
        delay -> {
          DischargeDelays ld = new DischargeDelays();
          ld.setCargoId(delay.getCargoXid());
          ld.setSequenceNumber(delay.getSequenceNo());
          ld.setDsCargoNominationId(delay.getCargoNominationXid());
          ld.setDuration(delay.getDuration());
          ld.setId(delay.getId());
          ld.setDischargeInfoId(delay.getDischargingInformation().getId());
          ld.setQuantity(delay.getQuantity());
          ld.setDischargingRate(delay.getDischargingRate());
          List<DischargingDelayReason> reasonForDelayIds =
              dischargingDelayReasonRepository.findAllByDischargingDelayAndIsActive(delay, true);
          if (!CollectionUtils.isEmpty(reasonForDelayIds)) {
            log.info("DischargingDelayReason get with size:{}", reasonForDelayIds.size());
            ld.setReasonForDelayIds(
                reasonForDelayIds.stream()
                    .map(v -> v.getReasonForDelay().getId())
                    .collect(Collectors.toList()));
          }
          //          ld.setReasonForDelayIds(
          //              delay.getDischargingDelayReasons().stream()
          //                  .filter(DischargingDelayReason::getIsActive)
          //                  .map(v -> v.getReasonForDelay().getId())
          //                  .collect(Collectors.toList()));
          dischargeDelays.add(ld);
        });
    dischargeSequences.setDischargeDelays(dischargeDelays);

    checkAndSetIsSequenceAltered(dischargeDelays, dischargeSequences, entity.getPortXid());
    return dischargeSequences;
  }

  /**
   * Checks and sets sequence flag
   *
   * @param dischargeDelaysList list of discharge delays
   * @param dischargeSequences discharge sequence object
   * @param portXid
   */
  private void checkAndSetIsSequenceAltered(
      List<DischargeDelays> dischargeDelaysList,
      DischargeSequences dischargeSequences,
      Long portXid)
      throws GenericServiceException {

    log.info("Inside checkAndSetIsSequenceAltered method!");

    // Get all default manage sequence values
    LoadableStudy.CargoNominationOperationDetailsRequest.Builder cargoNominationRequestBuilder =
        LoadableStudy.CargoNominationOperationDetailsRequest.newBuilder()
            .addAllCargoNominationIds(
                dischargeDelaysList.stream()
                    .map(DischargeDelays::getDsCargoNominationId)
                    .collect(Collectors.toList()))
            .setPortId(portXid);

    // Fetch default sequence numbers from discharge study cargo nomination operation details
    LoadableStudy.CargoNominationOperationDetailsResponse cargoNominationOperationResponse =
        dischargeStudyOperationServiceBlockingStub.getCargoNominationOperationDetails(
            cargoNominationRequestBuilder.build());
    if (cargoNominationOperationResponse == null
        || !SUCCESS.equals(cargoNominationOperationResponse.getResponseStatus().getStatus())) {

      log.debug("Failed to fetch cargo nomination operation details!");
      throw new GenericServiceException(
          "Failed to fetch cargo nomination operation details!",
          CommonErrorCodes.E_HTTP_BAD_REQUEST,
          HttpStatusCode.BAD_REQUEST);
    }

    Map<Long, List<Long>> defaultSequenceNumberWithCargo =
        cargoNominationOperationResponse.getCargoNominationOperationDetailsList().stream()
            .collect(
                Collectors.groupingBy(
                    LoadableStudy.CargoNominationOperationDetails::getSequenceNo,
                    Collectors.mapping(
                        LoadableStudy.CargoNominationOperationDetails::getCargoNominationId,
                        Collectors.toList())));

    // Get all saved manage sequence values
    Map<Long, List<Long>> sequenceNumberWithCargo =
        dischargeDelaysList.stream()
            .collect(
                Collectors.groupingBy(
                    DischargeDelays::getSequenceNumber,
                    Collectors.mapping(
                        DischargeDelays::getDsCargoNominationId, Collectors.toList())));

    // Compare and set flag if sequence is altered
    dischargeSequences.setIsSequenceAltered(
        !defaultSequenceNumberWithCargo.equals(sequenceNumberWithCargo));
  }

  private CargoMachineryInUse buildDischargeMachines(
      com.cpdss.dischargeplan.entity.DischargeInformation entity) throws GenericServiceException {
    CargoMachineryInUse cargoMachineryInUse = new CargoMachineryInUse();
    List<DischargingMachineryInUse> list =
        this.dischargingMachineryInUseRepository.findAllByDischargingInfoId(entity.getId());
    List<DischargeMachinesInUse> machineList = new ArrayList<>();

    VesselInfo.VesselPumpsResponse grpcReply =
        this.vesselInfoService.getVesselPumpsByVesselId(
            VesselInfo.VesselIdRequest.newBuilder().setVesselId(entity.getVesselXid()).build());

    if (!DischargePlanConstants.SUCCESS.equals(grpcReply.getResponseStatus().getStatus())) {
      log.info("Failed to get Vessel Details for Id {}", entity.getVesselXid());
      return null;
    }

    // Setting master data
    if (grpcReply != null) {
      try {
        List<PumpTypes> pumpTypes = new ArrayList<>();
        if (grpcReply.getPumpTypeCount() > 0) {
          for (VesselInfo.PumpType vpy : grpcReply.getPumpTypeList()) {
            PumpTypes type = new PumpTypes();
            BeanUtils.copyProperties(vpy, type);
            pumpTypes.add(type);
          }
        }
        List<VesselPump> vesselPumps = new ArrayList<>();
        if (grpcReply.getVesselPumpCount() > 0) {
          for (VesselInfo.VesselPump vp : grpcReply.getVesselPumpList()) {
            VesselPump pump = new VesselPump();
            BeanUtils.copyProperties(vp, pump);
            vesselPumps.add(pump);
          }
        }
        cargoMachineryInUse.setPumpTypes(pumpTypes);
        cargoMachineryInUse.setVesselPumps(vesselPumps);
        if (!grpcReply.getVesselManifoldList().isEmpty()) {
          List<VesselManifold> list1 = new ArrayList<>();
          for (VesselInfo.VesselComponent vc : grpcReply.getVesselManifoldList()) {
            VesselManifold vcDto = new VesselManifold();
            vcDto.setId(vc.getId());
            vcDto.setManifoldName(vc.getComponentName());
            vcDto.setManifoldCode(vc.getComponentCode());
            if (!grpcReply.getTankTypeList().isEmpty() && vc.getTankTypeId() > 0) {
              Optional<String> tankType =
                  grpcReply.getTankTypeList().stream()
                      .filter(v -> v.getId() == vc.getTankTypeId())
                      .findFirst()
                      .map(VesselInfo.TankType::getTypeName);
              if (tankType.isPresent()) {
                vcDto.setTankType(tankType.get());
              }
            }
            list1.add(vcDto);
          }
          cargoMachineryInUse.setVesselManifolds(list1);
        }
        if (!grpcReply.getVesselBottomLineList().isEmpty()) {
          List<VesselBottomLine> list2 = new ArrayList<>();
          for (VesselInfo.VesselComponent vc : grpcReply.getVesselBottomLineList()) {
            VesselBottomLine vcDto = new VesselBottomLine();
            vcDto.setId(vc.getId());
            vcDto.setBottomLineName(vc.getComponentName());
            vcDto.setBottomLineCode(vc.getComponentCode());
            list2.add(vcDto);
          }
          cargoMachineryInUse.setVesselBottomLines(list2);
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

    for (DischargingMachineryInUse machine : list) {
      DischargeMachinesInUse loadingMachine = new DischargeMachinesInUse();
      loadingMachine.setCapacity(machine.getCapacity());
      loadingMachine.setId(machine.getId());
      loadingMachine.setLoadingInfoId(entity.getId());
      loadingMachine.setMachineId(machine.getMachineXid());
      loadingMachine.setMachineTypeId(machine.getMachineTypeXid());
      this.setMachineNameAndTypeByIdAndTypeId(
          grpcReply, machine.getMachineXid(), machine.getMachineTypeXid(), loadingMachine);
      machineList.add(loadingMachine);
    }
    cargoMachineryInUse.setMachinesInUses(machineList);
    return cargoMachineryInUse;
  }

  private void setMachineNameAndTypeByIdAndTypeId(
      VesselInfo.VesselPumpsResponse grpcReply,
      Long machineId,
      Integer typeId,
      DischargeMachinesInUse loadingMachine) {
    if (typeId == Common.MachineType.VESSEL_PUMP_VALUE) {
      Optional<VesselInfo.VesselPump> vesselPump =
          grpcReply.getVesselPumpList().stream().filter(v -> v.getId() == machineId).findFirst();
      if (vesselPump.isPresent()) {
        loadingMachine.setMachineName(vesselPump.get().getPumpName());
        loadingMachine.setMachineTypeName(Common.MachineType.VESSEL_PUMP.name());
      }
    }
    if (typeId == Common.MachineType.MANIFOLD_VALUE) {
      Optional<VesselInfo.VesselComponent> manifold =
          grpcReply.getVesselManifoldList().stream()
              .filter(v -> v.getId() == machineId)
              .findFirst();
      if (manifold.isPresent()) {
        loadingMachine.setMachineName(manifold.get().getComponentName());
        loadingMachine.setMachineTypeName(Common.MachineType.MANIFOLD.name());
        loadingMachine.setTankTypeName(manifold.get().getTankTypeName());
      }
    }
    if (typeId == Common.MachineType.BOTTOM_LINE_VALUE) {
      Optional<VesselInfo.VesselComponent> bottomLine =
          grpcReply.getVesselBottomLineList().stream()
              .filter(v -> v.getId() == machineId)
              .findFirst();
      if (bottomLine.isPresent()) {
        loadingMachine.setMachineName(bottomLine.get().getComponentName());
        loadingMachine.setMachineTypeName(Common.MachineType.BOTTOM_LINE.name());
      }
    }
  }

  private void buildDischargePlanPortWiseDetails(
      DischargeInformationAlgoRequest algoRequest,
      com.cpdss.dischargeplan.entity.DischargeInformation entity)
      throws GenericServiceException {
    LoadableStudy.LoadablePlanDetailsRequest.Builder requestBuilder =
        LoadableStudy.LoadablePlanDetailsRequest.newBuilder();
    requestBuilder.setLoadablePatternId(entity.getDischargingPatternXid());
    requestBuilder.setIsDischargePlan(true);
    LoadableStudy.LoadablePatternPortWiseDetailsJson response =
        this.loadableStudyService.getLoadablePatternDetailsJson(requestBuilder.build());
    if (!response.getResponseStatus().getStatus().equals(DischargePlanConstants.SUCCESS)) {
      throw new GenericServiceException(
          "Failed to get Portwise details from Loadable-Study MS",
          CommonErrorCodes.E_HTTP_BAD_REQUEST,
          HttpStatusCode.BAD_REQUEST);
    }

    ObjectMapper mapper = new ObjectMapper();
    try {
      List<LoadablePlanPortWiseDetails> planPortWiseDetails =
          Arrays.asList(
              mapper.readValue(
                  response.getLoadablePatternDetails(), LoadablePlanPortWiseDetails[].class));

      if (!planPortWiseDetails.isEmpty()) {
        List<DischargePlanPortWiseDetails> planPortWiseDetailsNew = new ArrayList<>();
        // We need to change the variable name as per discharge (loadablePlanStowageDetails,
        // loadablePlanBallastDetails, loadablePlanCommingleDetails)
        for (LoadablePlanPortWiseDetails source : planPortWiseDetails) {
          DischargePlanPortWiseDetails dsPDetails = new DischargePlanPortWiseDetails();
          dsPDetails.setPortCode(source.getPortCode());
          dsPDetails.setPortId(source.getPortId());
          dsPDetails.setPortRotationId(source.getPortRotationId());

          DischargePatternDetails arrival = new DischargePatternDetails();
          arrival.setDischargePlanStowageDetails(
              source.getArrivalCondition().getLoadablePlanStowageDetails());
          arrival.setDischargePlanBallastDetails(
              source.getArrivalCondition().getLoadablePlanBallastDetails());
          arrival.setDischargePlanCommingleDetails(
              source.getArrivalCondition().getLoadablePlanCommingleDetails());
          dsPDetails.setArrivalCondition(arrival);

          DischargePatternDetails departure = new DischargePatternDetails();
          departure.setDischargePlanStowageDetails(
              source.getDepartureCondition().getLoadablePlanStowageDetails());
          departure.setDischargePlanBallastDetails(
              source.getDepartureCondition().getLoadablePlanBallastDetails());
          departure.setDischargePlanCommingleDetails(
              source.getDepartureCondition().getLoadablePlanCommingleDetails());
          dsPDetails.setDepartureCondition(departure);
          planPortWiseDetailsNew.add(dsPDetails);
        }
        algoRequest.setPlanPortWiseDetails(planPortWiseDetailsNew);
      }
    } catch (JsonProcessingException e) {
      e.printStackTrace();
      throw new GenericServiceException(
          "Failed to deserialize port wise details",
          CommonErrorCodes.E_HTTP_BAD_REQUEST,
          HttpStatusCode.BAD_REQUEST);
    }

    buildOnHandQuantities(algoRequest, entity, response.getLoadableStudyId());
    buildOnBoardQuantities(algoRequest, entity, response.getLoadableStudyId());
  }

  /**
   * Builds discharge berth dto for algo
   *
   * @param dischargeInformationId discharge information id
   * @param algoRequest algo request object
   * @return discharge berth details
   */
  private DischargeBerthDetails buildDischargeBerthDto(
      Long dischargeInformationId, DischargeInformationAlgoRequest algoRequest) {

    log.info("Inside buildDischargeBerthDto method!");

    DischargeBerthDetails berthDetails = new DischargeBerthDetails();
    List<DischargingBerthDetail> dischargingBerthDetails =
        dischargeBerthDetailRepository.findAllByDischargingInformationIdAndIsActiveTrue(
            dischargeInformationId);
    if (!dischargingBerthDetails.isEmpty()) {
      berthDetails.setSelectedBerths(
          dischargingBerthDetails.stream()
              .map(
                  dischargingBerthDetail -> {
                    BerthDetails dto = new BerthDetails();

                    // Set fields
                    Optional.ofNullable(dischargingBerthDetail.getId())
                        .ifPresent(dto::setDischargeBerthId);
                    Optional.ofNullable(dischargingBerthDetail.getDischargingInformation().getId())
                        .ifPresent(dto::setDischargeInfoId);
                    Optional.ofNullable(dischargingBerthDetail.getBerthXid())
                        .ifPresent(dto::setBerthId);
                    Optional.ofNullable(dischargingBerthDetail.getDepth())
                        .ifPresent(dto::setMaxShipDepth);
                    Optional.ofNullable(dischargingBerthDetail.getMaxManifoldHeight())
                        .ifPresent(dto::setMaxManifoldHeight);
                    Optional.ofNullable(dischargingBerthDetail.getMaxManifoldPressure())
                        .ifPresent(dto::setMaxManifoldPressure);
                    Optional.ofNullable(dischargingBerthDetail.getSeaDraftLimitation())
                        .ifPresent(dto::setSeaDraftLimitation);

                    Optional.ofNullable(dischargingBerthDetail.getAirDraftLimitation())
                        .ifPresent(dto::setAirDraftLimitation);
                    Optional.ofNullable(dischargingBerthDetail.getIsCargoCirculation())
                        .ifPresent(dto::setCargoCirculation);
                    Optional.ofNullable(dischargingBerthDetail.getIsAirPurge())
                        .ifPresent(dto::setAirPurge);
                    Optional.ofNullable(dischargingBerthDetail.getLineContentDisplacement())
                        .ifPresent(dto::setLineDisplacement);
                    Optional.ofNullable(dischargingBerthDetail.getHoseConnections())
                        .ifPresent(dto::setHoseConnections);
                    Optional.ofNullable(dischargingBerthDetail.getDisplacement())
                        .ifPresent(dto::setDisplacement);

                    Optional.ofNullable(dischargingBerthDetail.getEnableDayLightRestriction())
                        .ifPresent(dto::setEnableDayLightRestriction);
                    Optional.ofNullable(dischargingBerthDetail.getNeedFlushingOilAndCrudeStorage())
                        .ifPresent(dto::setNeedFlushingOilAndCrudeStorage);
                    Optional.ofNullable(dischargingBerthDetail.getFreshCrudeOilQuantity())
                        .ifPresent(dto::setFreshCrudeOilQuantity);
                    Optional.ofNullable(dischargingBerthDetail.getFreshCrudeOilTime())
                        .ifPresent(dto::setFreshCrudeOilTime);

                    // Call 1 to Port info, set value from berth table
                    // Setting berth name
                    this.getBerthDetailsByPortIdAndBerthId(
                        dischargingBerthDetail.getDischargingInformation().getPortXid(),
                        dischargingBerthDetail.getBerthXid(),
                        dto,
                        algoRequest);

                    // Call 2 to Port info, set value from port table
                    this.getPortInfoIntoBerthData(dischargingBerthDetail.getBerthXid(), dto);
                    return dto;
                  })
              .collect(Collectors.toList()));
    }
    return berthDetails;
  }

  private void getBerthDetailsByPortIdAndBerthId(
      Long portXid, Long berthXid, BerthDetails bd, DischargeInformationAlgoRequest algoRequest) {
    try {
      PortInfo.PortIdRequest.Builder idRequest = PortInfo.PortIdRequest.newBuilder();
      PortInfo.BerthInfoResponse response =
          portInfoServiceBlockingStub.getBerthDetailsByPortId(idRequest.setPortId(portXid).build());
      log.info(
          "Get berth Name ({}) from port service - status {}",
          berthXid,
          response.getResponseStatus().getStatus());
      if (!DischargePlanConstants.SUCCESS.equals(response.getResponseStatus().getStatus())) {
        log.error("Failed to get berth details by Port id - {}", response);
      }
      algoRequest.setPortCode(response.getPortCode());
      var berthData =
          response.getBerthsList().stream().filter(v -> v.getId() == berthXid).findFirst();
      if (berthData.isPresent()) {
        bd.setBerthName(berthData.get().getBerthName());
        if (!berthData.get().getUkc().isEmpty()) {
          bd.setUkc(berthData.get().getUkc());
        }
        if (!berthData.get().getPortMaxPermissibleDraft().isEmpty()) {
          bd.setPortMaxPermissibleDraft(berthData.get().getPortMaxPermissibleDraft());
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void buildOnBoardQuantities(
      DischargeInformationAlgoRequest algoRequest,
      com.cpdss.dischargeplan.entity.DischargeInformation dischargeInformation,
      long loadableStudyId)
      throws NumberFormatException, GenericServiceException {
    log.info(
        "Populating onBoardQuantities of Port {} in Loadable Study {}",
        dischargeInformation.getPortXid(),
        loadableStudyId);
    LoadableStudy.OnBoardQuantityRequest request =
        LoadableStudy.OnBoardQuantityRequest.newBuilder()
            .setVoyageId(dischargeInformation.getVoyageXid())
            .setLoadableStudyId(loadableStudyId)
            .setVesselId(dischargeInformation.getVesselXid())
            .setPortId(dischargeInformation.getPortXid())
            .build();
    LoadableStudy.OnBoardQuantityReply grpcReply = loadableStudyService.getOnBoardQuantity(request);
    if (!DischargePlanConstants.SUCCESS.equals(grpcReply.getResponseStatus().getStatus())) {
      throw new GenericServiceException(
          "Failed to fetch on board quantities from Loadable-Study MS",
          grpcReply.getResponseStatus().getCode(),
          HttpStatusCode.valueOf(Integer.valueOf(grpcReply.getResponseStatus().getCode())));
    }

    List<OnBoardQuantity> onBoardQuantities = new ArrayList<OnBoardQuantity>();
    grpcReply
        .getOnBoardQuantityList()
        .forEach(
            detail -> {
              OnBoardQuantity dto = new OnBoardQuantity();
              dto.setId(detail.getId());
              dto.setCargoId(0 == detail.getCargoId() ? null : detail.getCargoId());
              dto.setColorCode(isEmpty(detail.getColorCode()) ? null : detail.getColorCode());
              dto.setAbbreviation(
                  isEmpty(detail.getAbbreviation()) ? null : detail.getAbbreviation());
              dto.setSounding(
                  isEmpty(detail.getSounding())
                      ? BigDecimal.ZERO
                      : new BigDecimal(detail.getSounding()));
              dto.setQuantity(
                  isEmpty(detail.getWeight())
                      ? BigDecimal.ZERO
                      : new BigDecimal(detail.getWeight()));
              dto.setActualWeight(
                  isEmpty(detail.getActualWeight())
                      ? BigDecimal.ZERO
                      : new BigDecimal(detail.getActualWeight()));
              dto.setVolume(
                  isEmpty(detail.getVolume())
                      ? BigDecimal.ZERO
                      : new BigDecimal(detail.getVolume()));
              dto.setTankId(detail.getTankId());
              dto.setTankName(detail.getTankName());
              dto.setApi(
                  isEmpty(detail.getDensity())
                      ? BigDecimal.ZERO
                      : new BigDecimal(detail.getDensity()));
              if (detail.getTemperature() != null && detail.getTemperature().length() > 0) {
                dto.setTemperature(new BigDecimal(detail.getTemperature()));
              }

              onBoardQuantities.add(dto);
            });

    algoRequest.setOnBoardQuantity(onBoardQuantities);
  }

  private void buildOnHandQuantities(
      DischargeInformationAlgoRequest algoRequest,
      com.cpdss.dischargeplan.entity.DischargeInformation dischargeInformation,
      long loadableStudyId)
      throws NumberFormatException, GenericServiceException {
    log.info(
        "Populating onHandQuantities of Port Rotation {} in Loadable Study {}",
        dischargeInformation.getPortRotationXid(),
        loadableStudyId);
    LoadableStudy.OnHandQuantityRequest request =
        LoadableStudy.OnHandQuantityRequest.newBuilder()
            .setCompanyId(1L)
            .setVesselId(dischargeInformation.getVesselXid())
            .setLoadableStudyId(loadableStudyId)
            .setPortRotationId(dischargeInformation.getPortRotationXid())
            .build();
    LoadableStudy.OnHandQuantityReply grpcReply = loadableStudyService.getOnHandQuantity(request);
    if (!DischargePlanConstants.SUCCESS.equals(grpcReply.getResponseStatus().getStatus())) {
      throw new GenericServiceException(
          "Failed to fetch on hand quantities from Loadable-Study MS",
          grpcReply.getResponseStatus().getCode(),
          HttpStatusCode.valueOf(Integer.parseInt(grpcReply.getResponseStatus().getCode())));
    }

    List<OnHandQuantity> ohqList = new ArrayList<>();
    grpcReply
        .getOnHandQuantityList()
        .forEach(
            detail -> {
              OnHandQuantity onHandQuantity = new OnHandQuantity();
              onHandQuantity.setId(detail.getId());
              onHandQuantity.setTankId(detail.getTankId());
              onHandQuantity.setTankName(detail.getTankName());
              onHandQuantity.setFuelTypeId(detail.getFuelTypeId());
              onHandQuantity.setFuelTypeName(detail.getFuelType());
              onHandQuantity.setFuelTypeShortName(detail.getFuelTypeShortName());
              onHandQuantity.setPortRotationId(detail.getPortRotationId());
              onHandQuantity.setPortId(detail.getPortId());
              onHandQuantity.setArrivalQuantity(
                  isEmpty(detail.getArrivalQuantity())
                      ? BigDecimal.ZERO
                      : new BigDecimal(detail.getArrivalQuantity()));
              onHandQuantity.setActualArrivalQuantity(
                  isEmpty(detail.getActualArrivalQuantity())
                      ? BigDecimal.ZERO
                      : new BigDecimal(detail.getActualArrivalQuantity()));
              onHandQuantity.setArrivalVolume(
                  isEmpty(detail.getArrivalVolume())
                      ? BigDecimal.ZERO
                      : new BigDecimal(detail.getArrivalVolume()));
              onHandQuantity.setDepartureQuantity(
                  isEmpty(detail.getDepartureQuantity())
                      ? BigDecimal.ZERO
                      : new BigDecimal(detail.getDepartureQuantity()));
              onHandQuantity.setActualDepartureQuantity(
                  isEmpty(detail.getActualDepartureQuantity())
                      ? BigDecimal.ZERO
                      : new BigDecimal(detail.getActualDepartureQuantity()));
              onHandQuantity.setDepartureVolume(
                  isEmpty(detail.getDepartureVolume())
                      ? BigDecimal.ZERO
                      : new BigDecimal(detail.getDepartureVolume()));
              onHandQuantity.setColorCode(
                  isEmpty(detail.getColorCode()) ? null : detail.getColorCode());
              onHandQuantity.setDensity(
                  isEmpty(detail.getDensity())
                      ? BigDecimal.ZERO
                      : new BigDecimal(detail.getDensity()));
              ohqList.add(onHandQuantity);
            });
    algoRequest.setOnHandQuantity(ohqList);
  }

  private List<DischargeQuantityCargoDetails> buildCargoVesselTankDetails(
      DischargeInformation entity) throws NumberFormatException, GenericServiceException {
    log.info(
        "Populating cargo vessel tank details of Port Rotation {} and Loadable Pattern {}",
        entity.getPortRotationXid(),
        entity.getDischargingPatternXid());
    LoadableStudy.LoadingPlanCommonResponse response =
        this.loadableStudyService.getSynopticDataForLoadingPlan(
            LoadableStudy.LoadingPlanIdRequest.newBuilder()
                .setPatternId(entity.getDischargingPatternXid())
                .setOperationType("DEP")
                .setPortRotationId(entity.getPortRotationXid())
                .setPortId(entity.getPortXid())
                .setCargoNominationFilter(false)
                .setPlanningType(Common.PLANNING_TYPE.DISCHARGE_STUDY)
                .build());

    if (!DischargePlanConstants.SUCCESS.equals(response.getResponseStatus().getStatus())) {
      throw new GenericServiceException(
          "Failed to fetch cargoVesselTankDetails from Loadable-Study MS",
          response.getResponseStatus().getCode(),
          HttpStatusCode.valueOf(Integer.valueOf(response.getResponseStatus().getCode())));
    }

    List<DischargeQuantityCargoDetails> loadableQuantityCargoDetails = new ArrayList<>();
    response
        .getLoadableQuantityCargoDetailsList()
        .forEach(
            cargo -> {
              DischargeQuantityCargoDetails loadableQuantity = new DischargeQuantityCargoDetails();
              Optional.of(cargo.getLoadingOrder()).ifPresent(loadableQuantity::setDischargingOrder);
              Optional.of(cargo.getCargoId()).ifPresent(loadableQuantity::setCargoId);
              Optional.of(cargo.getCargoNominationId())
                  .ifPresent(loadableQuantity::setCargoNominationId);
              Optional.of(cargo.getDscargoNominationId())
                  .ifPresent(loadableQuantity::setDsCargoNominationId);
              Optional.of(cargo.getEstimatedAPI()).ifPresent(loadableQuantity::setEstimatedAPI);
              Optional.of(cargo.getEstimatedTemp()).ifPresent(loadableQuantity::setEstimatedTemp);
              Optional.of(cargo.getSlopQuantity()).ifPresent(loadableQuantity::setSlopQuantity);
              Optional.of(cargo.getIsCommingled())
                  .ifPresent(loadableQuantity::setIsCommingledDischarge);
              loadableQuantityCargoDetails.add(loadableQuantity);
            });
    return loadableQuantityCargoDetails;
  }

  /**
   * Fetches Loading Information Status based on status ID.
   *
   * @param dischargingInformationStatusId
   * @return
   * @throws GenericServiceException
   */
  public Optional<DischargingInformationStatus> getDischargingInformationStatus(
      Long dischargingInformationStatusId) throws GenericServiceException {
    Optional<DischargingInformationStatus> dischargingInfoStatusOpt =
        dischargeInformationStatusRepository.findByIdAndIsActive(
            dischargingInformationStatusId, true);
    if (dischargingInfoStatusOpt.isEmpty()) {
      throw new GenericServiceException(
          "Could not find dsicharging information status with id " + dischargingInformationStatusId,
          CommonErrorCodes.E_HTTP_BAD_REQUEST,
          HttpStatusCode.BAD_REQUEST);
    }

    return dischargingInfoStatusOpt;
  }

  public void createDischargingInformationAlgoStatus(
      DischargeInformation dischargeInformation,
      String processId,
      DischargingInformationStatus dischargingInformationStatus,
      Integer arrivalDepartutre) {
    log.info(
        "Creating ALGO status for Loading Information {}, condition Type {}",
        dischargeInformation.getId(),
        arrivalDepartutre);
    DischargingInformationAlgoStatus algoStatus = new DischargingInformationAlgoStatus();
    algoStatus.setIsActive(true);
    algoStatus.setDischargeInformation(dischargeInformation);
    algoStatus.setDischargingInformationStatus(dischargingInformationStatus);
    algoStatus.setConditionType(arrivalDepartutre);
    algoStatus.setProcessId(processId);
    algoStatus.setVesselXId(dischargeInformation.getVesselXid());
    dischargingInformationAlgoStatusRepository.save(algoStatus);
  }

  /**
   * Saves the Loading Information ALGO Request JSON to DB.
   *
   * @param algoRequest
   * @param dischargingInfoId
   * @throws GenericServiceException
   */
  public void saveDischargingInformationRequestJson(
      DischargeInformationAlgoRequest algoRequest, Long dischargingInfoId)
      throws GenericServiceException {
    log.info("Saving Discharging Information ALGO request to Loadable study DB");
    JsonRequest.Builder jsonBuilder = JsonRequest.newBuilder();
    jsonBuilder.setReferenceId(dischargingInfoId);
    jsonBuilder.setJsonTypeId(DischargePlanConstants.DISCHARGE_INFORMATION_REQUEST_JSON_TYPE_ID);
    ObjectMapper mapper = new ObjectMapper();
    try {
      mapper.writeValue(
          new File(
              this.rootFolder
                  + "/json/dischargingInformationRequest_"
                  + dischargingInfoId
                  + ".json"),
          algoRequest);
      jsonBuilder.setJson(mapper.writeValueAsString(algoRequest));
      this.loadableStudyService.saveJson(jsonBuilder.build());
    } catch (JsonProcessingException e) {
      e.printStackTrace();
      throw new GenericServiceException(
          "Could not save request JSON to DB",
          CommonErrorCodes.E_HTTP_BAD_REQUEST,
          HttpStatusCode.BAD_REQUEST);
    } catch (IOException e) {
      e.printStackTrace();
      throw new GenericServiceException(
          "Could not save request JSON to DB",
          CommonErrorCodes.E_HTTP_BAD_REQUEST,
          HttpStatusCode.BAD_REQUEST);
    }
  }

  public void saveDischargingSequenceAndPlan(
      DischargingPlanSaveRequest request, DischargingPlanSaveResponse.Builder builder)
      throws GenericServiceException {
    log.info(
        "Saving Loading plan and sequence of loading information {}",
        request.getDischargingInfoId());

    DischargeInformation dischargingInfo =
        dischargeInformationService.getDischargeInformation(request.getDischargingInfoId());
    if (dischargingInfo == null) {
      throw new GenericServiceException(
          "Could not find discharging information " + request.getDischargingInfoId(),
          CommonErrorCodes.E_HTTP_BAD_REQUEST,
          HttpStatusCode.BAD_REQUEST);
    }
    // for excel
    builder.setPortRotationId(dischargingInfo.getPortRotationXid());
    dischargeInformationService.updateDischargingPlanDetailsFromAlgo(
        dischargingInfo.getId(), request.getDischargingPlanDetailsFromAlgo());

    if (request.getDischargingSequencesList().isEmpty()) {
      log.info("No Plans Available for Loading Information {}", dischargingInfo.getId());
      Optional<DischargingInformationStatus> noPlanAvailableStatusOpt =
          getDischargingInformationStatus(
              DischargePlanConstants.DISCHARGING_INFORMATION_NO_PLAN_AVAILABLE_ID);
      dischargeInformationService.updateDischargingInformationStatus(
          noPlanAvailableStatusOpt.get(), dischargingInfo.getId());
      updateDischargingInfoAlgoStatus(
          dischargingInfo, request.getProcessId(), noPlanAvailableStatusOpt.get(), null);
    }

    if (!request.getAlgoErrorsList().isEmpty()) {
      saveAlgoErrors(dischargingInfo, request);
      if (!env.equals("ship") && enableCommunication) {
        log.info("Discharge Plan communication Started when Algo errors occurred.");
        dischargeAlgoPlanCallBackCommunicationCall(
            dischargingInfo,
            com.cpdss.dischargeplan.service.utility.DischargePlanConstants
                .DISCHARGE_PLAN_ALGO_ERRORS_SHORE_TO_SHIP);
      }
    }

    if (!request.getDischargingSequencesList().isEmpty()) {
      List<DischargingSequence> oldLoadingSequences =
          dischargingSequenceRepository.findByDischargeInformationAndIsActive(
              dischargingInfo, true);
      cowTankDetailRepository.deleteByDischargingInformationId(dischargingInfo.getId());
      // Saving Loading Sequence
      request.getDischargingSequencesList().stream()
          .forEach(
              sequence -> {
                saveDischargingSequence(sequence, dischargingInfo);
              });
      deleteDischargingSequences(dischargingInfo.getId(), oldLoadingSequences);
      deleteDischargingSequenceStabilityParams(dischargingInfo.getId());
      saveDischargingSequenceStabilityParams(request, dischargingInfo);

      deleteDischargingPlan(dischargingInfo.getId());
      saveDischargingPlan(request, dischargingInfo);
      if (request.getHasLoadicator()) {
        log.info("Passing Loading Sequence to Loadicator");
        loadicatorService.saveLoadicatorInfo(dischargingInfo, request.getProcessId());
        Optional<DischargingInformationStatus> loadicatorVerificationStatusOpt =
            getDischargingInformationStatus(
                DischargePlanConstants.DISCHARGING_INFORMATION_VERIFICATION_WITH_LOADICATOR_ID);
        updateDischargingInfoAlgoStatus(
            dischargingInfo, request.getProcessId(), loadicatorVerificationStatusOpt.get(), null);
      } else {
        Optional<DischargingInformationStatus> dischargingInfoStatusOpt =
            getDischargingInformationStatus(DischargePlanConstants.PLAN_GENERATED_ID);
        dischargeInformationService.updateDischargingInformationStatuses(
            dischargingInfoStatusOpt.get(),
            dischargingInfoStatusOpt.get(),
            dischargingInfoStatusOpt.get(),
            dischargingInfo.getId());
        updateDischargingInfoAlgoStatus(
            dischargingInfo, request.getProcessId(), dischargingInfoStatusOpt.get(), null);
        dischargeInformationService.updateIsDischargingSequenceGeneratedStatus(
            dischargingInfo.getId(), true);
        dischargeInformationService.updateIsDischargingPlanGeneratedStatus(
            dischargingInfo.getId(), true);
      }
      if (!env.equals("ship") && enableCommunication) {
        log.info("Discharge Plan communication Started.");
        dischargeAlgoPlanCallBackCommunicationCall(
            dischargingInfo,
            com.cpdss.dischargeplan.service.utility.DischargePlanConstants
                .DISCHARGE_PLAN_SHORE_TO_SHIP);
      }
    }
  }

  private void saveDischargingPlan(
      DischargingPlanSaveRequest request, DischargeInformation dischargingInfo) {

    savePortBallastDetails(dischargingInfo, request.getPortDischargingPlanBallastDetailsList());
    savePortRobDetails(dischargingInfo, request.getPortDischargingPlanRobDetailsList());
    savePortStabilityParams(
        dischargingInfo, request.getPortDischargingPlanStabilityParametersList());
    savePortStowageDetails(dischargingInfo, request.getPortDischargingPlanStowageDetailsList());
    savePortCommingleDetails(dischargingInfo, request.getPortDischargingPlanCommingleDetailsList());
    saveDriveTankDetails(dischargingInfo, request.getDriveTankDetailsList());
  }

  /**
   * Saves drive tank details to DB
   *
   * @param dischargingInfo
   * @param driveTankDetailsList
   */
  private void saveDriveTankDetails(
      DischargeInformation dischargingInfo, List<DriveTankDetail> driveTankDetailsList) {
    log.info("Saving Drive Tanks for Discharging Information {}", dischargingInfo.getId());
    List<DischargingDriveTank> driveTanks = new ArrayList<DischargingDriveTank>();
    driveTankDetailsList.forEach(
        driveTankDetail -> {
          DischargingDriveTank dischargingDriveTank = new DischargingDriveTank();
          dischargingDriveTank.setDischargingInformation(dischargingInfo);
          dischargingDriveTank.setTankId(driveTankDetail.getTankId());
          dischargingDriveTank.setIsActive(true);
          dischargingDriveTank.setTankShortName(driveTankDetail.getTankShortName());
          dischargingDriveTank.setStartTime(
              StringUtils.hasLength(driveTankDetail.getTimeStart())
                  ? Integer.valueOf(driveTankDetail.getTimeStart())
                  : null);
          dischargingDriveTank.setEndTime(
              StringUtils.hasLength(driveTankDetail.getTimeEnd())
                  ? Integer.valueOf(driveTankDetail.getTimeEnd())
                  : null);
          driveTanks.add(dischargingDriveTank);
        });

    dischargingDriveTankRepository.saveAll(driveTanks);
  }

  private void savePortStowageDetails(
      DischargeInformation dischargingInformation,
      List<LoadingPlanTankDetails> portDischargingPlanStowageDetailsList) {
    log.info(
        "Saving Loading Plan Stowage Details for LoadingInformation {}, PortRotation",
        dischargingInformation.getId(),
        dischargingInformation.getPortRotationXid());
    List<PortDischargingPlanStowageDetails> portLoadingPlanStowages = new ArrayList<>();
    portDischargingPlanStowageDetailsList.forEach(
        stowage -> {
          PortDischargingPlanStowageDetails stowageDetails =
              new PortDischargingPlanStowageDetails();
          dischargingPlanBuilderService.buildPortStowage(
              dischargingInformation, stowageDetails, stowage);
          portLoadingPlanStowages.add(stowageDetails);
        });
    portStowageDetailsRepository.saveAll(portLoadingPlanStowages);
  }

  private void savePortBallastDetails(
      DischargeInformation dischargingInformation,
      List<LoadingPlanTankDetails> portLoadingPlanBallastDetailsList) {
    log.info(
        "Saving Loading Plan Ballast Details for LoadingInformation {}, PortRotation",
        dischargingInformation.getId(),
        dischargingInformation.getPortRotationXid());
    List<PortDischargingPlanBallastDetails> portLoadingPlanBallastDetails = new ArrayList<>();
    portLoadingPlanBallastDetailsList.forEach(
        ballast -> {
          PortDischargingPlanBallastDetails ballastDetails =
              new PortDischargingPlanBallastDetails();
          dischargingPlanBuilderService.buildPortBallast(
              dischargingInformation, ballastDetails, ballast);
          portLoadingPlanBallastDetails.add(ballastDetails);
        });
    portDischargingPlanBallastDetailsRepository.saveAll(portLoadingPlanBallastDetails);
  }

  private void savePortCommingleDetails(
      DischargeInformation dischargingInformation,
      List<LoadingPlanCommingleDetails> portLoadingPlanCommingleDetailsList) {
    log.info(
        "Saving Loading Plan Commingle Details for LoadingInformation {}, PortRotation",
        dischargingInformation.getId(),
        dischargingInformation.getPortRotationXid());
    List<PortDischargingPlanCommingleDetails> portLoadingPlanCommingleDetails = new ArrayList<>();
    portLoadingPlanCommingleDetailsList.forEach(
        commingle -> {
          PortDischargingPlanCommingleDetails commingleDetails =
              new PortDischargingPlanCommingleDetails();
          dischargingPlanBuilderService.buildPortCommingle(
              dischargingInformation, commingleDetails, commingle);
          portLoadingPlanCommingleDetails.add(commingleDetails);
        });
    portDischargingPlanCommingleDetailsRepository.saveAll(portLoadingPlanCommingleDetails);
  }

  private void deleteDischargingPlan(Long id) {

    log.info("Deleting Old Loading Plan of LoadingInformation {}", id);
    portDischargingPlanBallastDetailsRepository.deleteByDischargingInformationId(id);
    portRobDetailsRepository.deleteByDischargingInformationId(id);
    portStabilityParamsRepository.deleteByDischargingInformationId(id);
    portStowageDetailsRepository.deleteByDischargingInformationId(id);
    portDischargingPlanStowageTempDetailsRepository.deleteByDischargingInformationId(id);
    portDischargingPlanBallastTempDetailsRepository.deleteByDischargingInformationId(id);
    portDischargingPlanCommingleDetailsRepository.deleteByDischargingInformationId(id);
    dischargingDriveTankRepository.deleteByDischargingInformationId(id);
  }

  private void saveDischargingSequenceStabilityParams(
      DischargingPlanSaveRequest request, DischargeInformation dischargingInfo) {

    log.info(
        "Saving Loading Sequence Stability Params for LoadingInformation {}, PortRotation",
        dischargingInfo.getId(),
        dischargingInfo.getPortRotationXid());
    List<DischargingSequenceStabilityParameters> dischargingSequenceStabilityParams =
        new ArrayList<>();
    request
        .getDischargingSequenceStabilityParametersList()
        .forEach(
            param -> {
              DischargingSequenceStabilityParameters stabilityParameters =
                  new DischargingSequenceStabilityParameters();
              dischargingPlanBuilderService.buildDischargingSequenceStabilityParams(
                  dischargingInfo, param, stabilityParameters);
              dischargingSequenceStabilityParams.add(stabilityParameters);
            });
    dischargingSequenceStabiltyParametersRepository.saveAll(dischargingSequenceStabilityParams);
  }

  private void savePortStabilityParams(
      DischargeInformation dischargingInformation,
      List<LoadingPlanStabilityParameters> portLoadingPlanStabilityParametersList) {
    log.info(
        "Saving Loading Plan Stability Parameters for LoadingInformation {}, PortRotation",
        dischargingInformation.getId(),
        dischargingInformation.getPortRotationXid());
    List<PortDischargingPlanStabilityParameters> portLoadingPlanStabilityParams = new ArrayList<>();
    portLoadingPlanStabilityParametersList.forEach(
        params -> {
          PortDischargingPlanStabilityParameters stabilityParams =
              new PortDischargingPlanStabilityParameters();
          dischargingPlanBuilderService.buildPortStabilityParams(
              dischargingInformation, stabilityParams, params);
          portLoadingPlanStabilityParams.add(stabilityParams);
        });
    portStabilityParamsRepository.saveAll(portLoadingPlanStabilityParams);
  }

  private void deleteDischargingSequenceStabilityParams(Long id) {

    log.info("Deleting Old Loading Sequence Stability Parameters of Loading Information {}", id);
    dischargingSequenceStabiltyParametersRepository.deleteByDischargingInformationId(id);
  }

  private void saveDischargingSequence(
      com.cpdss.common.generated.discharge_plan.DischargingSequence sequence,
      DischargeInformation dischargingInfo) {

    log.info("Saving Loading sequence of loading information {}", dischargingInfo.getId());
    DischargingSequence dischargingSequence = new DischargingSequence();
    dischargingPlanBuilderService.buildDischargingSequence(
        dischargingSequence, sequence, dischargingInfo);
    DischargingSequence savedDischargingSequence =
        dischargingSequenceRepository.save(dischargingSequence);

    saveBallastValves(savedDischargingSequence, sequence.getBallastValvesList());
    saveCargoValves(savedDischargingSequence, sequence.getCargoValvesList());
    saveDeBallastingRates(savedDischargingSequence, sequence.getDeBallastingRatesList());
    saveDischargingPlanPortWiseDetails(
        savedDischargingSequence, sequence.getDischargingPlanPortWiseDetailsList());
    saveCargoDischargingRates(savedDischargingSequence, sequence.getDischargingRatesList());
    savePumps(savedDischargingSequence, sequence.getBallastOperationsList());
    if (sequence.getCleaningTanks() != null) {
      saveCleaningDetails(dischargingInfo, sequence.getCleaningTanks());
    }
    saveStrippingDetails(savedDischargingSequence, sequence.getEductorOperationList());
    saveTankTransfers(savedDischargingSequence, sequence.getTankTransfersList());
  }

  /**
   * Saves tank transfers of a Discharging Sequence;
   *
   * @param dischargingSequence
   * @param tankTransfersList
   */
  private void saveTankTransfers(
      DischargingSequence dischargingSequence, List<TankTransfer> tankTransfersList) {
    log.info("Save Tank transfers for discharging sequence: {}", dischargingSequence.getId());
    tankTransfersList.forEach(
        tankTransfer -> {
          DischargingTankTransfer dischargingTankTransfer = new DischargingTankTransfer();
          dischargingTankTransfer.setDischargingSequence(dischargingSequence);
          dischargingTankTransfer.setCargoNominationId(tankTransfer.getCargoNominationId());
          dischargingTankTransfer.setToTankId(tankTransfer.getToTankId());
          dischargingTankTransfer.setFromTankIds(
              tankTransfer.getFromTankIdsList().stream()
                  .map(tankId -> tankId.toString())
                  .collect(Collectors.joining(",")));
          dischargingTankTransfer.setIsActive(true);
          dischargingTankTransfer.setPurpose(tankTransfer.getPurpose());
          dischargingTankTransfer.setTimeEnd(tankTransfer.getTimeEnd());
          dischargingTankTransfer.setTimeStart(tankTransfer.getTimeStart());
          DischargingTankTransfer savedDischargingTankTransfer =
              dischargingTankTransferRepository.save(dischargingTankTransfer);
          saveDischargingTankTransferDetails(
              savedDischargingTankTransfer, tankTransfer.getTankTransferDetailsList());
        });
  }

  /**
   * Saves the transfer details of the tank-to-tank transfer
   *
   * @param dischargingTankTransfer DischargingTankTransfer entity
   * @param tankTransferDetailsList TankTransferDetails messages
   */
  private void saveDischargingTankTransferDetails(
      DischargingTankTransfer dischargingTankTransfer,
      List<TankTransferDetail> tankTransferDetailsList) {
    List<DischargingTankTransferDetails> dischargingTankTransferDetails = new ArrayList<>();
    for (TankTransferDetail tankTransferDetail : tankTransferDetailsList) {
      DischargingTankTransferDetails tankTransferDetails = new DischargingTankTransferDetails();
      tankTransferDetails.setTankXId(tankTransferDetail.getTankId());
      tankTransferDetails.setStartQuantity(
          StringUtils.hasLength(tankTransferDetail.getStartQuantity())
              ? new BigDecimal(tankTransferDetail.getStartQuantity())
              : null);
      tankTransferDetails.setEndQuantity(
          StringUtils.hasLength(tankTransferDetail.getEndQuantity())
              ? new BigDecimal(tankTransferDetail.getEndQuantity())
              : null);
      tankTransferDetails.setStartUllage(
          StringUtils.hasLength(tankTransferDetail.getStartUllage())
              ? new BigDecimal(tankTransferDetail.getStartUllage())
              : null);
      tankTransferDetails.setEndUllage(
          StringUtils.hasLength(tankTransferDetail.getEndUllage())
              ? new BigDecimal(tankTransferDetail.getEndUllage())
              : null);
      tankTransferDetails.setDischargingTankTransfer(dischargingTankTransfer);
      tankTransferDetails.setIsActive(true);
      dischargingTankTransferDetails.add(tankTransferDetails);
    }
    dischargingTankTransferDetailsRepository.saveAll(dischargingTankTransferDetails);
  }

  /**
   * Saves Stripping details to DB
   *
   * @param dischargingSequence
   * @param eductorOperationList
   */
  private void saveStrippingDetails(
      DischargingSequence dischargingSequence,
      List<LoadingPlanModels.EductorOperation> eductorOperationList) {
    log.info("Save Stripping details for discharging sequence: {}", dischargingSequence.getId());
    List<EductionOperation> eductionOperations = new ArrayList<EductionOperation>();
    eductorOperationList.forEach(
        eductorOperation -> {
          EductionOperation eductionOperation = new EductionOperation();
          eductionOperation.setIsActive(true);
          eductionOperation.setDischargingSequence(dischargingSequence);
          eductionOperation.setStartTime(eductorOperation.getStartTime());
          eductionOperation.setEndTime(eductorOperation.getEndTime());
          eductionOperation.setTanksUsed(eductorOperation.getTanksUsed());
          eductionOperations.add(eductionOperation);
        });
    eductionOperationRepository.saveAll(eductionOperations);
  }

  /**
   * Save tank cleaning details
   *
   * @param dischargingInfo
   * @param cleaningTanks
   */
  private void saveCleaningDetails(
      DischargeInformation dischargingInfo, CleaningTanks cleaningTanks) {
    List<CowTankDetail> cowTankDetails = new ArrayList<>();
    List<CleaningTankDetails> bottomTankList = cleaningTanks.getBottomTankList();
    if (!bottomTankList.isEmpty()) {
      bottomTankList.forEach(
          item -> {
            CowTankDetail cowTankDetail =
                buildCowTankDetails(
                    item, Common.COW_TYPE.BOTTOM_COW_VALUE, dischargingInfo.getId());
            cowTankDetails.add(cowTankDetail);
          });
    }
    List<CleaningTankDetails> fullTankList = cleaningTanks.getFullTankList();
    if (!fullTankList.isEmpty()) {
      fullTankList.forEach(
          item -> {
            CowTankDetail cowTankDetail =
                buildCowTankDetails(item, Common.COW_TYPE.ALL_COW_VALUE, dischargingInfo.getId());
            cowTankDetails.add(cowTankDetail);
          });
    }
    List<CleaningTankDetails> topTankList = cleaningTanks.getTopTankList();
    if (!topTankList.isEmpty()) {
      topTankList.forEach(
          item -> {
            CowTankDetail cowTankDetail =
                buildCowTankDetails(item, Common.COW_TYPE.TOP_COW_VALUE, dischargingInfo.getId());
            cowTankDetails.add(cowTankDetail);
          });
    }
    cowTankDetailRepository.saveAll(cowTankDetails);
  }

  /**
   * Build cleaning tank detail entity data to save
   *
   * @param cleaningTankDetails
   * @param cowTypeId
   * @param dischargeId
   * @return CowTankDetail
   */
  private CowTankDetail buildCowTankDetails(
      CleaningTankDetails cleaningTankDetails, Integer cowTypeId, Long dischargeId) {
    CowTankDetail tankDetail = new CowTankDetail();
    tankDetail.setActualPlanned(1);
    Optional.ofNullable(cleaningTankDetails.getTankId()).ifPresent(tankDetail::setTankXid);
    tankDetail.setTankShortName(cleaningTankDetails.getTankShortName());
    tankDetail.setTimeEnd(Long.parseLong(cleaningTankDetails.getTimeEnd()));
    tankDetail.setTimeStart(Long.parseLong(cleaningTankDetails.getTimeStart()));
    tankDetail.setCowTypeXid(cowTypeId);
    tankDetail.setDischargingXid(dischargeId);
    tankDetail.setIsActive(true);
    return tankDetail;
  }

  private void saveCargoDischargingRates(
      DischargingSequence loadingSequence, List<DischargingRate> dischargingRatesList) {
    log.info("Saving Cargo Loading Rates for Loading Sequence {}", loadingSequence.getId());
    List<CargoDischargingRate> cargoLoadingRates = new ArrayList<CargoDischargingRate>();
    dischargingRatesList.forEach(
        loadingRate -> {
          CargoDischargingRate cargoLoadingRate = new CargoDischargingRate();
          dischargingPlanBuilderService.buildCargoDischargingRate(
              loadingSequence, cargoLoadingRate, loadingRate);
          cargoLoadingRates.add(cargoLoadingRate);
        });
    cargoDischargingRateRepository.saveAll(cargoLoadingRates);
  }

  private void deleteDischargingSequences(
      Long dischargingInfoId, List<DischargingSequence> oldDischargingSequences) {
    log.info("Deleting Old Loading Sequences of DischargingInformation {}", dischargingInfoId);
    oldDischargingSequences.forEach(
        dischargingSequence -> {
          dischargingSequenceRepository.deleteById(dischargingSequence.getId());
          ballastOperationRepository.deleteByDischargingSequence(dischargingSequence);
          cargoDischargingRateRepository.deleteByDischargingSequence(dischargingSequence);
          deballastingRateRepository.deleteByDischargingSequence(dischargingSequence);
          deleteDischargingPlanPortWiseDetailsByDischargingSequence(dischargingSequence);
          eductionOperationRepository.deleteByDischargingSequence(dischargingSequence);
          dischargingTankTransferRepository.deleteByDischargingSequence(dischargingSequence);
          dischargingTankTransferDetailsRepository.deleteByDischargingSequence(dischargingSequence);
        });
  }

  private void deleteDischargingPlanPortWiseDetailsByDischargingSequence(
      DischargingSequence dischargingSequence) {
    List<DischargingPlanPortWiseDetails> oldPortWiseDetails =
        dischargingPlanPortWiseDetailsRepository.findByDischargingSequenceAndIsActiveTrueOrderById(
            dischargingSequence);
    oldPortWiseDetails.forEach(
        loadingPlanPortWiseDetails -> {
          dischargingPlanPortWiseDetailsRepository.deleteById(loadingPlanPortWiseDetails.getId());
          deballastingRateRepository.deleteByDischargingPlanPortWiseDetails(
              loadingPlanPortWiseDetails);
          dischargingPlanBallastDetailsRepository.deleteByDischargingPlanPortWiseDetails(
              loadingPlanPortWiseDetails);
          dischargingPlanRobDetailsRepository.deleteByDischargingPlanPortWiseDetails(
              loadingPlanPortWiseDetails);
          dischargingPlanStabilityParametersRepository.deleteByDischargingPlanPortWiseDetails(
              loadingPlanPortWiseDetails);
          dischargingPlanStowageDetailsRepository.deleteByDischargingPlanPortWiseDetails(
              loadingPlanPortWiseDetails);
          dischargingPlanCommingleDetailsRepository.deleteByDischargingPlanPortWiseDetails(
              loadingPlanPortWiseDetails);
        });
  }

  private void saveAlgoErrors(
      DischargeInformation dischargeInformation, DischargingPlanSaveRequest request)
      throws GenericServiceException {
    log.info(
        "ALGO returned errors while generating loading plan for loading information {}",
        dischargeInformation.getId());

    algoErrorHeadingRepository.deleteByDischargingInformation(dischargeInformation);
    algoErrorsRepository.deleteByLoadingInformation(dischargeInformation);

    request
        .getAlgoErrorsList()
        .forEach(
            algoError -> {
              AlgoErrorHeading algoErrorHeading = new AlgoErrorHeading();
              algoErrorHeading.setErrorHeading(algoError.getErrorHeading());
              algoErrorHeading.setDischargingInformation(dischargeInformation);
              algoErrorHeading.setIsActive(true);
              algoErrorHeadingRepository.save(algoErrorHeading);
              algoError
                  .getErrorMessagesList()
                  .forEach(
                      error -> {
                        AlgoErrors algoErrors = new AlgoErrors();
                        algoErrors.setAlgoErrorHeading(algoErrorHeading);
                        algoErrors.setErrorMessage(error);
                        algoErrors.setIsActive(true);
                        algoErrorsRepository.save(algoErrors);
                      });
            });
    Optional<DischargingInformationStatus> errorOccurredStatusOpt =
        getDischargingInformationStatus(
            DischargePlanConstants.DISCHARGING_INFORMATION_ERROR_OCCURRED_ID);
    dischargeInformationService.updateDischargingInformationStatus(
        errorOccurredStatusOpt.get(), dischargeInformation.getId());
    updateDischargingInfoAlgoStatus(
        dischargeInformation, request.getProcessId(), errorOccurredStatusOpt.get(), null);
  }

  private void saveDischargingPlanPortWiseDetails(
      DischargingSequence dischargingSequence,
      List<LoadingPlanPortWiseDetails> loadingPlanPortWiseDetailsList) {
    log.info(
        "Saving Loading Plan PortWise Details for Loading Sequence {}",
        dischargingSequence.getId());
    loadingPlanPortWiseDetailsList.forEach(
        details -> {
          DischargingPlanPortWiseDetails portWiseDetails = new DischargingPlanPortWiseDetails();
          dischargingPlanBuilderService.buildDischargingPlanPortWiseDetails(
              dischargingSequence, portWiseDetails, details);
          DischargingPlanPortWiseDetails savedPortWiseDetails =
              dischargingPlanPortWiseDetailsRepository.save(portWiseDetails);
          saveDeBallastingRates(savedPortWiseDetails, details.getDeballastingRatesList());
          saveDischargingPlanBallastDetails(
              savedPortWiseDetails, details.getLoadingPlanBallastDetailsList());
          saveDischargingPlanRobDetails(
              savedPortWiseDetails, details.getLoadingPlanRobDetailsList());
          saveDischargingPlanStowageDetails(
              savedPortWiseDetails, details.getLoadingPlanStowageDetailsList());
          saveDischargingPlanStabilityParameters(
              savedPortWiseDetails, details.getLoadingPlanStabilityParameters());
          saveDischargingPlanCommingleDetails(
              savedPortWiseDetails, details.getLoadingPlanCommingleDetailsList());
        });
  }

  public void updateDischargingInfoAlgoStatus(
      DischargeInformation dischargingInformation,
      String processId,
      DischargingInformationStatus dischargingInformationStatus,
      Integer conditionType) {
    Optional<DischargingInformationAlgoStatus> algoStatusOpt =
        this.dischargingInformationAlgoStatusRepository
            .findByProcessIdAndDischargeInformationAndConditionTypeAndIsActiveTrue(
                processId, dischargingInformation, conditionType);
    if (algoStatusOpt.isEmpty()) {
      createDischargingInformationAlgoStatus(
          dischargingInformation, processId, dischargingInformationStatus, conditionType);
    } else {
      this.dischargingInformationAlgoStatusRepository.updateDischargingInformationAlgoStatus(
          dischargingInformationStatus.getId(), dischargingInformation.getId(), processId);
    }
  }

  /**
   * Saves cargo and ballast pump details
   *
   * @param dischargingSequence
   * @param ballastOperationsList
   */
  private void savePumps(
      DischargingSequence dischargingSequence, List<PumpOperation> ballastOperationsList) {
    log.info(
        "Saving Ballast, Cargo & TCP Pumps for Discharging Sequence {}",
        dischargingSequence.getId());
    List<com.cpdss.dischargeplan.entity.BallastOperation> ballastOperations = new ArrayList<>();
    ballastOperationsList.forEach(
        pumpOperation -> {
          com.cpdss.dischargeplan.entity.BallastOperation ballastOperation =
              new com.cpdss.dischargeplan.entity.BallastOperation();
          dischargingPlanBuilderService.buildBallastOperation(
              dischargingSequence, ballastOperation, pumpOperation);
          ballastOperations.add(ballastOperation);
        });
    ballastOperationRepository.saveAll(ballastOperations);
  }
  /**
   * @param dischargingPlanPortWiseDetails
   * @param loadingPlanCommingleDetailsList
   */
  private void saveDischargingPlanCommingleDetails(
      DischargingPlanPortWiseDetails dischargingPlanPortWiseDetails,
      List<LoadingPlanCommingleDetails> loadingPlanCommingleDetailsList) {
    log.info(
        "Saving Loading Plan Commingle Details for LoadingPlanPortWiseDetails {}",
        dischargingPlanPortWiseDetails.getId());
    List<DischargingPlanCommingleDetails> loadingPlanCommingleDetails = new ArrayList<>();
    loadingPlanCommingleDetailsList.forEach(
        commingle -> {
          DischargingPlanCommingleDetails commingleDetails = new DischargingPlanCommingleDetails();
          dischargingPlanBuilderService.buildDischargingPlanCommingleDetails(
              dischargingPlanPortWiseDetails, commingleDetails, commingle);
          loadingPlanCommingleDetails.add(commingleDetails);
        });
    dischargingPlanCommingleDetailsRepository.saveAll(loadingPlanCommingleDetails);
  }

  private void saveDischargingPlanStabilityParameters(
      DischargingPlanPortWiseDetails dischargingPlanPortWiseDetails,
      LoadingPlanStabilityParameters loadingPlanStabilityParameters) {
    log.info(
        "Saving Stability Parameters for LoadingPlanPortWiseDetails {}",
        dischargingPlanPortWiseDetails.getId());
    DischargingPlanStabilityParameters parameters = new DischargingPlanStabilityParameters();
    dischargingPlanBuilderService.buildStabilityParameters(
        dischargingPlanPortWiseDetails, parameters, loadingPlanStabilityParameters);
    dischargingPlanStabilityParametersRepository.save(parameters);
  }

  private void saveDischargingPlanStowageDetails(
      DischargingPlanPortWiseDetails dischargingPlanPortWiseDetails,
      List<LoadingPlanTankDetails> loadingPlanStowageDetailsList) {
    log.info(
        "Saving Loading Plan Stowage Details for LoadingPlanPortWiseDetails {}",
        dischargingPlanPortWiseDetails.getId());
    List<DischargingPlanStowageDetails> loadingPlanStowageDetails = new ArrayList<>();
    loadingPlanStowageDetailsList.forEach(
        stowage -> {
          DischargingPlanStowageDetails stowageDetails = new DischargingPlanStowageDetails();
          dischargingPlanBuilderService.buildDischargingPlanStowageDetails(
              dischargingPlanPortWiseDetails, stowageDetails, stowage);
          loadingPlanStowageDetails.add(stowageDetails);
        });
    dischargingPlanStowageDetailsRepository.saveAll(loadingPlanStowageDetails);
  }

  private void saveDischargingPlanRobDetails(
      DischargingPlanPortWiseDetails dischargingPlanPortWiseDetails,
      List<LoadingPlanTankDetails> loadingPlanRobDetailsList) {
    log.info(
        "Saving Loading Plan ROB Details for LoadingPlanPortWiseDetails {}",
        dischargingPlanPortWiseDetails.getId());
    List<DischargingPlanRobDetails> loadingPlanRobDetails = new ArrayList<>();
    loadingPlanRobDetailsList.forEach(
        rob -> {
          DischargingPlanRobDetails robDetails = new DischargingPlanRobDetails();
          dischargingPlanBuilderService.buildDischargingPlanRobDetails(
              dischargingPlanPortWiseDetails, robDetails, rob);
          loadingPlanRobDetails.add(robDetails);
        });
    dischargingPlanRobDetailsRepository.saveAll(loadingPlanRobDetails);
  }

  private void saveDischargingPlanBallastDetails(
      DischargingPlanPortWiseDetails dischargingPlanPortWiseDetails,
      List<LoadingPlanTankDetails> loadingPlanBallastDetailsList) {
    log.info(
        "Saving Loading Plan Ballast Details for LoadingPlanPortWiseDetails {}",
        dischargingPlanPortWiseDetails.getId());
    List<DischargingPlanBallastDetails> loadingPlanBallastDetails =
        new ArrayList<DischargingPlanBallastDetails>();
    loadingPlanBallastDetailsList.forEach(
        ballast -> {
          DischargingPlanBallastDetails ballastDetails = new DischargingPlanBallastDetails();
          dischargingPlanBuilderService.buildDischargingPlanBallastDetails(
              dischargingPlanPortWiseDetails, ballastDetails, ballast);
          loadingPlanBallastDetails.add(ballastDetails);
        });
    dischargingPlanBallastDetailsRepository.saveAll(loadingPlanBallastDetails);
  }

  private void savePortRobDetails(
      DischargeInformation dischargingInformation,
      List<LoadingPlanTankDetails> portLoadingPlanRobDetailsList) {
    log.info(
        "Saving Loading Plan ROB Details for LoadingInformation {}, PortRotation",
        dischargingInformation.getId(),
        dischargingInformation.getPortRotationXid());
    List<PortDischargingPlanRobDetails> portLoadingPlanRobDetails = new ArrayList<>();
    portLoadingPlanRobDetailsList.forEach(
        rob -> {
          PortDischargingPlanRobDetails robDetails = new PortDischargingPlanRobDetails();
          dischargingPlanBuilderService.buildPortRob(dischargingInformation, robDetails, rob);
          portLoadingPlanRobDetails.add(robDetails);
        });
    portRobDetailsRepository.saveAll(portLoadingPlanRobDetails);
  }

  private void saveDeBallastingRates(
      DischargingPlanPortWiseDetails dischargingPlanPortWiseDetails,
      List<DeBallastingRate> deballastingRatesList) {
    log.info(
        "Saving DeBallastingRates for LoadingPlanPortWiseDetails {}",
        dischargingPlanPortWiseDetails.getId());
    List<DeballastingRate> deballastingRates = new ArrayList<DeballastingRate>();
    deballastingRatesList.forEach(
        rate -> {
          DeballastingRate deballastingRate = new DeballastingRate();
          dischargingPlanBuilderService.buildDeBallastingRate(
              dischargingPlanPortWiseDetails, deballastingRate, rate);
          deballastingRates.add(deballastingRate);
        });
    deballastingRateRepository.saveAll(deballastingRates);
  }

  private void saveDeBallastingRates(
      DischargingSequence dischargingSequence, List<DeBallastingRate> deBallastingRatesList) {
    log.info("Saving DeBallastingRates for LoadingSequence {}", dischargingSequence.getId());
    List<DeballastingRate> deballastingRates = new ArrayList<DeballastingRate>();
    deBallastingRatesList.forEach(
        rate -> {
          DeballastingRate deballastingRate = new DeballastingRate();
          dischargingPlanBuilderService.buildDeBallastingRate(
              dischargingSequence, deballastingRate, rate);
          deballastingRates.add(deballastingRate);
        });
    deballastingRateRepository.saveAll(deballastingRates);
  }

  private void saveCargoValves(
      DischargingSequence dischargingSequence, List<Valve> cargoValvesList) {
    log.info("Saving CargoValves for LoadingSequence {}", dischargingSequence.getId());
    List<CargoValve> cargoValves = new ArrayList<CargoValve>();
    cargoValvesList.forEach(
        valve -> {
          CargoValve cargoValve = new CargoValve();
          dischargingPlanBuilderService.buildCargoValve(dischargingSequence, cargoValve, valve);
          cargoValves.add(cargoValve);
        });
    cargoValveRepository.saveAll(cargoValves);
  }

  private void saveBallastValves(
      DischargingSequence dischargingSequence, List<Valve> ballastValvesList) {
    log.info("Saving BallastValves for LoadingSequence {}", dischargingSequence.getId());
    List<BallastValve> ballastValves = new ArrayList<BallastValve>();
    ballastValvesList.forEach(
        valve -> {
          BallastValve ballastValve = new BallastValve();
          buildBallastValve(dischargingSequence, ballastValve, valve);
          ballastValves.add(ballastValve);
        });
    this.ballastValveRepository.saveAll(ballastValves);
  }

  public void buildBallastValve(
      DischargingSequence dischargingSequence, BallastValve ballastValve, Valve valve) {
    ballastValve.setIsActive(true);
    ballastValve.setDischargingSequence(dischargingSequence);
    ballastValve.setOperation(valve.getOperation());
    ballastValve.setTime(valve.getTime());
    ballastValve.setValveCode(valve.getValveCode());
    ballastValve.setValveType(valve.getValveType());
    ballastValve.setValveXId(valve.getValveId());
  }

  /**
   * Updates discharge plan ALGO status.
   *
   * @param request
   * @throws GenericServiceException
   */
  public void saveDischargingInfoAlgoStatus(AlgoStatusRequest request)
      throws GenericServiceException {
    Optional<DischargingInformationAlgoStatus> dischargingInfoStatusOpt =
        dischargingInformationAlgoStatusRepository.findByProcessIdAndIsActiveTrue(
            request.getProcesssId());
    if (dischargingInfoStatusOpt.isEmpty()) {
      throw new GenericServiceException(
          "Could not find discharging information " + request.getProcesssId(),
          CommonErrorCodes.E_HTTP_BAD_REQUEST,
          HttpStatusCode.BAD_REQUEST);
    }
    dischargingInformationAlgoStatusRepository.updateDischargingInformationAlgoStatus(
        request.getLoadableStudystatusId(), request.getProcesssId());
  }

  /**
   * Controlling Depth for Port Set UKC from berth, if not available Set UKC from port.
   *
   * @param berthId Long
   * @param berthDetails BerthDetails
   */
  private void getPortInfoIntoBerthData(Long berthId, BerthDetails berthDetails) {
    PortInfo.LoadingAlgoBerthData portReply =
        this.portInfoServiceBlockingStub.getLoadingPlanBerthData(
            PortInfo.BerthIdsRequest.newBuilder().addBerthIds(berthId).build());
    if (portReply != null && portReply.getResponseStatus().getStatus().equals("SUCCESS")) {
      if (!portReply.getPortControllingDepth().isEmpty()) {
        berthDetails.setControllingDepth(portReply.getPortControllingDepth());
      }
      if (!portReply.getBerthUKC().isEmpty()) {
        berthDetails.setUkc(portReply.getBerthUKC());
      } else if (!portReply.getPortUKC().isEmpty()) {
        berthDetails.setUkc(portReply.getPortUKC());
      } else {
        log.error("Failed to set UKC Berth Id - {}", berthId);
      }
    }
  }

  /**
   * Fetches ALGO errors of Discharge Information with the given condition type
   *
   * @param request
   * @param builder
   */
  public void getDischargingInfoAlgoErrors(AlgoErrorRequest request, Builder builder)
      throws GenericServiceException {
    log.info("Fetching ALGO errors of Loading Information {}", request.getLoadingInformationId());
    List<AlgoErrorHeading> errorHeaders = null;
    if (request.getConditionType() == 0) {
      errorHeaders =
          algoErrorHeadingRepository.findByDischargingInformationIdAndConditionTypeAndIsActiveTrue(
              request.getLoadingInformationId(), null);
    } else {
      errorHeaders =
          algoErrorHeadingRepository.findByDischargingInformationIdAndConditionTypeAndIsActiveTrue(
              request.getLoadingInformationId(), request.getConditionType());
    }
    errorHeaders.forEach(
        header -> {
          com.cpdss.common.generated.LoadableStudy.AlgoErrors.Builder errorBuilder =
              com.cpdss.common.generated.LoadableStudy.AlgoErrors.newBuilder();
          errorBuilder.setId(header.getId());
          errorBuilder.setErrorHeading(header.getErrorHeading());
          header
              .getAlgoErrors()
              .forEach(
                  error -> {
                    errorBuilder.addErrorMessages(error.getErrorMessage());
                  });
          builder.addAlgoErrors(errorBuilder.build());
        });
  }

  /**
   * @param conditionType
   * @param heading
   * @param dischargingInformation
   * @param errors
   */
  public void saveAlgoErrors(
      DischargeInformation dischargingInformation,
      String heading,
      Integer conditionType,
      List<String> errors) {
    AlgoErrorHeading algoErrorHeading = new AlgoErrorHeading();
    algoErrorHeading.setErrorHeading(heading);
    algoErrorHeading.setDischargingInformation(dischargingInformation);
    algoErrorHeading.setConditionType(conditionType);
    algoErrorHeading.setIsActive(true);
    algoErrorHeadingRepository.save(algoErrorHeading);
    errors.forEach(
        error -> {
          AlgoErrors algoErrors = new AlgoErrors();
          algoErrors.setAlgoErrorHeading(algoErrorHeading);
          algoErrors.setErrorMessage(error);
          algoErrors.setIsActive(true);
          algoErrorsRepository.save(algoErrors);
        });
  }

  /** */
  public void saveAlgoInternalError(
      DischargeInformation dischargingInformation, Integer conditionType, List<String> errors) {
    if (conditionType != null) {
      algoErrorHeadingRepository.deleteByDischargingInformationAndConditionType(
          dischargingInformation, conditionType);
      algoErrorsRepository.deleteByDischargingInformationAndConditionType(
          dischargingInformation, conditionType);
    } else {
      algoErrorHeadingRepository.deleteByDischargingInformation(dischargingInformation);
      algoErrorsRepository.deleteByLoadingInformation(dischargingInformation);
    }
    saveAlgoErrors(
        dischargingInformation,
        AlgoErrorHeaderConstants.ALGO_INTERNAL_SERVER_ERROR,
        conditionType,
        errors);
  }

  private void dischargeAlgoPlanCallBackCommunicationCall(
      DischargeInformation dischargeInformation, List<String> processIdentifiers)
      throws GenericServiceException {
    JsonArray jsonArray =
        dischargePlanStagingService.getCommunicationData(
            processIdentifiers,
            UUID.randomUUID().toString(),
            MessageTypes.DISCHARGEPLAN_ALGORESULT.getMessageType(),
            dischargeInformation.getId(),
            dischargeInformation.getDischargeStudyProcessId());
    log.info("Json Array in Loading plan service: " + jsonArray.toString());
    EnvoyWriter.WriterReply ewReply =
        dischargePlanCommunicationService.passRequestPayloadToEnvoyWriter(
            jsonArray.toString(),
            dischargeInformation.getVesselXid(),
            MessageTypes.DISCHARGEPLAN_ALGORESULT.getMessageType());

    if (DischargePlanConstants.SUCCESS.equals(ewReply.getResponseStatus().getStatus())) {
      log.info("------- Envoy writer has called successfully : " + ewReply);
      DischargePlanCommunicationStatus dischargePlanCommunicationStatus =
          new DischargePlanCommunicationStatus();
      if (ewReply.getMessageId() != null) {
        dischargePlanCommunicationStatus.setMessageUUID(ewReply.getMessageId());
        dischargePlanCommunicationStatus.setCommunicationStatus(
            CommunicationStatus.UPLOAD_WITH_HASH_VERIFIED.getId());
      }
      dischargePlanCommunicationStatus.setReferenceId(dischargeInformation.getId());
      dischargePlanCommunicationStatus.setMessageType(
          MessageTypes.DISCHARGEPLAN_ALGORESULT.getMessageType());
      dischargePlanCommunicationStatus.setCommunicationDateTime(LocalDateTime.now());
      dischargePlanCommunicationStatus.setActive(true);
      DischargePlanCommunicationStatus dischargePlanCommcationStatus =
          dischargePlanCommunicationStatusRepository.save(dischargePlanCommunicationStatus);
      log.info(
          "DischargePlanCommunicationStatus table updated id : "
              + dischargePlanCommcationStatus.getId());
    }
  }
}
