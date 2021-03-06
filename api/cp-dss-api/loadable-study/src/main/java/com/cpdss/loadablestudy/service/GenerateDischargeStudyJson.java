/* Licensed at AlphaOri Technologies */
package com.cpdss.loadablestudy.service;

import static com.cpdss.loadablestudy.utility.LoadableStudiesConstants.*;
import static java.util.Optional.ofNullable;

import com.cpdss.common.exception.GenericServiceException;
import com.cpdss.common.generated.Common;
import com.cpdss.common.generated.EnvoyWriter;
import com.cpdss.common.generated.LoadableStudy.ActiveVoyage;
import com.cpdss.common.generated.LoadableStudy.AlgoReply;
import com.cpdss.common.generated.LoadableStudy.AlgoRequest;
import com.cpdss.common.generated.LoadableStudy.PortRotationDetail;
import com.cpdss.common.generated.LoadableStudy.PortRotationReply;
import com.cpdss.common.generated.LoadableStudy.PortRotationRequest;
import com.cpdss.common.generated.PortInfo;
import com.cpdss.common.generated.PortInfoServiceGrpc.PortInfoServiceBlockingStub;
import com.cpdss.common.generated.VesselInfo;
import com.cpdss.common.generated.VesselInfo.VesselTankRequest;
import com.cpdss.common.generated.VesselInfo.VesselTankResponse;
import com.cpdss.common.generated.VesselInfoServiceGrpc.VesselInfoServiceBlockingStub;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanCommingleDetails;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanReply;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParameters;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails;
import com.cpdss.common.generated.loading_plan.LoadingPlanServiceGrpc.LoadingPlanServiceBlockingStub;
import com.cpdss.common.rest.CommonErrorCodes;
import com.cpdss.common.utils.HttpStatusCode;
import com.cpdss.common.utils.MessageTypes;
import com.cpdss.loadablestudy.communication.LoadableStudyStagingService;
import com.cpdss.loadablestudy.domain.*;
import com.cpdss.loadablestudy.domain.CargoNomination;
import com.cpdss.loadablestudy.domain.CowHistory;
import com.cpdss.loadablestudy.domain.DischargeStudyAlgoJson;
import com.cpdss.loadablestudy.domain.DischargeStudyPortRotationJson;
import com.cpdss.loadablestudy.domain.LoadablePlanStowageDetailsJson;
import com.cpdss.loadablestudy.domain.LoadableQuantityCommingleCargoDetails;
import com.cpdss.loadablestudy.domain.LoadableStudyInstruction;
import com.cpdss.loadablestudy.domain.OnHandQuantity;
import com.cpdss.loadablestudy.entity.*;
import com.cpdss.loadablestudy.entity.LoadableStudy;
import com.cpdss.loadablestudy.entity.LoadableStudyPortRotation;
import com.cpdss.loadablestudy.entity.SynopticalTable;
import com.cpdss.loadablestudy.repository.*;
import com.cpdss.loadablestudy.utility.RuleUtility;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.extern.log4j.Log4j2;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

@Log4j2
@Component
public class GenerateDischargeStudyJson {

  public static final String SUCCESS = "SUCCESS";
  public static final String FAILED = "FAILED";
  public static final String INVALID_DISCHARGE_STUDY_ID = "INVALID_DISCHARGE_STUDY_ID";
  public static final String INVALID_DISCHARGE_QUANTITY = "INVALID_DISCHARGE_QUANTITY";

  @Value("${loadablestudy.attachement.rootFolder}")
  private String rootFolder;

  @Value("${algo.dischargestudy.api.url}")
  private String dischargeStudyUrl;

  @Value("${cpdss.communication.enable}")
  private boolean enableCommunication;

  @Value("${cpdss.build.env}")
  private String env;

  @Autowired private PortInstructionRepository portInstructionRepository;

  @Autowired private CargoNominationRepository cargoNominationRepository;

  @Autowired private LoadableStudyRepository loadableStudyRepository;

  @Autowired private LoadableStudyPortRotationService loadableStudyPortRotationService;

  @Autowired private CowDetailService cowDetailService;

  @Autowired private RestTemplate restTemplate;

  @Autowired private LoadableStudyAlgoStatusRepository loadableStudyAlgoStatusRepository;

  @Autowired private OnHandQuantityRepository onHandQuantityRepository;

  @Autowired private CowHistoryRepository cowHistoryRepository;

  @Autowired private LoadableStudyStatusRepository loadableStudyStatusRepository;

  @Autowired private VoyageRepository voyageRepository;

  @Autowired VoyageService voyageService;

  @Autowired private LoadableStudyRuleService loadableStudyRuleService;

  @Autowired
  private CargoNominationOperationDetailsRepository cargoNominationOperationDetailsRepository;

  @GrpcClient("vesselInfoService")
  private VesselInfoServiceBlockingStub vesselInfoGrpcService;

  @GrpcClient("portInfoService")
  private PortInfoServiceBlockingStub portInfoGrpcService;

  @GrpcClient("loadingPlanService")
  private LoadingPlanServiceBlockingStub loadingPlanGrpcService;

  @Autowired JsonDataService jsonDataService;

  @Autowired private CommunicationService communicationService;

  @Autowired
  private LoadableStudyCommunicationStatusRepository loadableStudyCommunicationStatusRepository;

  @Autowired LoadableStudyStagingService loadableStudyStagingService;

  @Autowired LoadablePatternRepository loadablePatternRepository;

  @Autowired LoadablePatternCargoDetailsRepository loadablePatternCargoDetailsRepository;

  @Autowired
  LoadablePlanStowageBallastDetailsRepository loadablePlanStowageBallastDetailsRepository;

  @Autowired
  LoadablePlanCommingleDetailsPortwiseRepository loadablePlanCommingleDetailsPortwiseRepository;

  @Autowired SynopticalTableRepository synopticalTableRepository;

  @Autowired SynopticalTableLoadicatorDataRepository synopticalTableLoadicatorDataRepository;

  @Autowired CargoNominationService cargoNominationService;

  @Autowired
  private CommingleCargoToDischargePortwiseDetailsRepository
      commingleCargoToDischargePortwiseDetailsRepository;

  public AlgoReply.Builder generateDischargePatterns(
      AlgoRequest request, AlgoReply.Builder replyBuilder)
      throws GenericServiceException, JsonGenerationException, JsonMappingException, IOException {
    // Checking requested discharge Id validity
    Optional<LoadableStudy> loadableStudyOpt =
        loadableStudyRepository.findByIdAndIsActive(request.getLoadableStudyId(), true);
    if (loadableStudyOpt.isPresent()) {
      String processId = null;
      if (enableCommunication && env.equals("ship")) {
        processId = communicateDischargeStudy(loadableStudyOpt.get().getId(), true);
      } else {
        log.info("Before Create algo payload");
        DischargeStudyAlgoJson AlgoJsonPayload =
            this.generateDischargeStudyJson(request.getLoadableStudyId(), loadableStudyOpt.get());
        log.info("Algo payload created:{}", AlgoJsonPayload);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(
            new File(
                this.rootFolder + "/json/dischargeStudy_" + request.getLoadableStudyId() + ".json"),
            AlgoJsonPayload);
        jsonDataService.saveJsonToDatabase(
            request.getLoadableStudyId(),
            DISCHARGE_STUDY_REQUEST,
            objectMapper.writeValueAsString(AlgoJsonPayload));
        log.info("Before Algo call");
        // Invoking Algo service
        AlgoResponse algoResponse =
            restTemplate.postForObject(dischargeStudyUrl, AlgoJsonPayload, AlgoResponse.class);
        processId = algoResponse.getProcessId();
        log.info("Algo response :{}", algoResponse);
        loadableStudyRepository.updateLoadableStudyStatus(
            LOADABLE_STUDY_PROCESSING_STARTED_ID, loadableStudyOpt.get().getId());
        updateProcessIdForDischargeStudy(
            processId, loadableStudyOpt.get(), LOADABLE_STUDY_PROCESSING_STARTED_ID);
      }

      replyBuilder
          .setProcesssId(processId)
          .setResponseStatus(
              Common.ResponseStatus.newBuilder().setMessage(SUCCESS).setStatus(SUCCESS).build());

    } else {
      log.info("INVALID_DISCHARGE_STUDY {} - ", request.getLoadableStudyId());
      throw new GenericServiceException(
          INVALID_DISCHARGE_STUDY_ID,
          CommonErrorCodes.E_HTTP_BAD_REQUEST,
          HttpStatusCode.BAD_REQUEST);
    }
    return replyBuilder;
  }

  public void updateProcessIdForDischargeStudy(
      String processId, LoadableStudy loadableStudy, Long loadableStudyStatus) {
    LoadableStudyAlgoStatus status = new LoadableStudyAlgoStatus();
    status.setLoadableStudy(loadableStudy);
    status.setIsActive(true);
    status.setLoadableStudyStatus(loadableStudyStatusRepository.getOne(loadableStudyStatus));
    status.setProcessId(processId);
    status.setVesselxid(loadableStudy.getVesselXId());
    loadableStudyAlgoStatusRepository.save(status);
  }

  public DischargeStudyAlgoJson generateDischargeStudyJson(
      Long dischargeStudyId, LoadableStudy loadableStudy) throws GenericServiceException {
    log.info("Generating Discharge study request Json for  :{}", dischargeStudyId);
    DischargeStudyAlgoJson dischargeStudyAlgoJson = new DischargeStudyAlgoJson();

    dischargeStudyAlgoJson.setModule(DISCHARGE_STUDY_JSON_MODULE_NAME);
    dischargeStudyAlgoJson.setId(dischargeStudyId);
    dischargeStudyAlgoJson.setVoyageId(loadableStudy.getVoyage().getId());
    dischargeStudyAlgoJson.setVoyageNo(loadableStudy.getVoyage().getVoyageNo());
    dischargeStudyAlgoJson.setVesselId(loadableStudy.getVesselXId());
    dischargeStudyAlgoJson.setName(loadableStudy.getName());
    dischargeStudyAlgoJson.setCowDetails(getCowDetails(dischargeStudyId));

    List<LoadableStudyInstruction> instructionsDetails = getAllLoadableStudyInstruction();
    dischargeStudyAlgoJson.setInstructionMaster(instructionsDetails);

    List<DischargeStudyPortRotationJson> portRotationList =
        getDischargeStudyPortRotation(dischargeStudyId, instructionsDetails);
    dischargeStudyAlgoJson.setDischargeStudyPortRotation(portRotationList);

    List<CargoNomination> cargoNominations = getCargoNomination(dischargeStudyId);
    dischargeStudyAlgoJson.setCargoNomination(cargoNominations);
    dischargeStudyAlgoJson.setCargoNominationOperationDetails(
        getCargoNominationOperationDetails(dischargeStudyId));

    List<DischargingMode> dischargingModes =
        Stream.of(DischargingModesEnum.values())
            .map(item -> new DischargingMode(item.getId(), item.getMode()))
            .collect(Collectors.toList());
    dischargeStudyAlgoJson.setDischargingModeMaster(dischargingModes);

    dischargeStudyAlgoJson.setOnHandQuantity(getOnHandQuantity(dischargeStudyId));

    dischargeStudyAlgoJson.setPortDetails(getPortDetails(portRotationList));

    dischargeStudyAlgoJson.setCowHistory(
        getCowHistory(loadableStudy.getVesselXId(), dischargeStudyId));

    dischargeStudyAlgoJson.setLoadablePlanPortWiseDetails(
        getLoadablePlanPortWiseDetails(
            dischargeStudyId,
            loadableStudy.getVesselXId(),
            loadableStudy.getVoyage().getVoyageNo()));

    // build admin rules section
    VesselInfo.VesselRuleRequest.Builder vesselRuleBuilder =
        VesselInfo.VesselRuleRequest.newBuilder();
    vesselRuleBuilder.setSectionId(RuleMasterSection.Discharging.getId());
    vesselRuleBuilder.setVesselId(loadableStudy.getVesselXId());
    vesselRuleBuilder.setIsFetchEnabledRules(false);
    vesselRuleBuilder.setIsNoDefaultRule(true);
    VesselInfo.VesselRuleReply vesselRuleReply =
        this.vesselInfoGrpcService.getRulesByVesselIdAndSectionId(vesselRuleBuilder.build());
    if (!SUCCESS.equals(vesselRuleReply.getResponseStatus().getStatus())) {
      throw new GenericServiceException(
          "failed to get vessel rule Details ",
          vesselRuleReply.getResponseStatus().getCode(),
          HttpStatusCode.valueOf(Integer.parseInt(vesselRuleReply.getResponseStatus().getCode())));
    }
    List<com.cpdss.loadablestudy.domain.RulePlans> adminRulePlan =
        RuleUtility.buildAdminRulePlan(vesselRuleReply);
    dischargeStudyAlgoJson.setDischargeStudyRuleList(adminRulePlan);

    return dischargeStudyAlgoJson;
  }

  /**
   * Getting COW history for vessel. Details of tank washed in previous voyages
   *
   * @param dischargeStudyId
   * @return
   */
  private List<CowHistory> getCowHistory(Long vesselId, Long dischargeStudyId) {
    log.info(
        "Fetching CowHistory details for discharge id {}, vessel Id {}",
        dischargeStudyId,
        vesselId);
    Pageable pageable = PageRequest.of(0, 500, Sort.by("lastModifiedDateTime").descending());
    List<com.cpdss.loadablestudy.entity.CowHistory> cowHistory =
        cowHistoryRepository.findAllByVesselIdAndIsActiveTrue(vesselId, pageable);
    if (!CollectionUtils.isEmpty(cowHistory)) {
      List<CowHistory> cowHistoryList = new ArrayList<>();
      cowHistory.forEach(
          item -> {
            CowHistory cowHistoryObj = new CowHistory();
            ofNullable(item.getId()).ifPresent(cowHistoryObj::setId);
            ofNullable(item.getVesselId()).ifPresent(cowHistoryObj::setVesselId);
            ofNullable(item.getVoyageId()).ifPresent(cowHistoryObj::setVoyageId);
            ofNullable(item.getTankId()).ifPresent(cowHistoryObj::setTankId);
            ofNullable(item.getCowTypeId())
                .ifPresent(
                    id -> {
                      cowHistoryObj.setCowTypeId(id);
                      cowHistoryObj.setCowType(
                          Common.COW_OPTION_TYPE.forNumber(id.intValue()).toString());
                    });
            ofNullable(item.getCowTypeId()).ifPresent(cowHistoryObj::setCowTypeId);
            ofNullable(item.getPortId()).ifPresent(cowHistoryObj::setPortId);
            Voyage voyage = voyageRepository.findByIdAndIsActive(cowHistoryObj.getVoyageId(), true);
            if (voyage != null) {
              if (voyage.getActualEndDate() != null) {
                DateTimeFormatter dft = DateTimeFormatter.ofPattern(VOYAGE_DATE_FORMAT);
                String endDate = voyage.getActualEndDate().format(dft);
                cowHistoryObj.setVoyageEndDate(endDate);
              }
            }
            cowHistoryList.add(cowHistoryObj);
          });
      log.info("Found {} items", cowHistoryList.size());
      return cowHistoryList;
    }
    log.info("No CowHistory details found ");
    return null;
  }

  private ArrivalConditionJson getLoadablePlanPortWiseDetails(
      Long dischargeStudyId, Long vesselId, String voyageNo) throws GenericServiceException {
    log.info("Fetching LoadablePlan PortWise Details for discharge id {}", dischargeStudyId);
    ActiveVoyage.Builder builder = ActiveVoyage.newBuilder();

    Optional<LoadableStudy> dischargeStudyOpt =
        this.loadableStudyRepository.findByIdAndIsActive(dischargeStudyId, true);

    if (dischargeStudyOpt.isPresent()
        && dischargeStudyOpt.get().getConfirmedLoadableStudyId() != null) {
      try {
        this.voyageService.fetchActiveVoyageByVesselId(builder, vesselId, ACTIVE_VOYAGE_STATUS);
      } catch (Exception e) {
        e.printStackTrace();
        log.error("Failed to fetch active voyage for, Vessel Id {}", vesselId);
        throw new GenericServiceException(
            "NO active voyage Found",
            CommonErrorCodes.E_HTTP_BAD_REQUEST,
            HttpStatusCode.BAD_REQUEST);
      }
      ActiveVoyage activeVoyage = builder.build();
      if (!activeVoyage.getVoyageNumber().equals(voyageNo)) {
        log.error(
            "Active voyage number and request voyage number does not match for DischargeStudyID {}",
            dischargeStudyId);
        throw new GenericServiceException(
            "Active voyage number and request voyage number does not match ",
            CommonErrorCodes.E_HTTP_BAD_REQUEST,
            HttpStatusCode.BAD_REQUEST);
      } else {
        log.info("Found active voyage {} ", voyageNo);

        Optional<LoadableStudy> respectiveLoadableStudyOpt =
            this.loadableStudyRepository.findByIdAndIsActive(
                dischargeStudyOpt.get().getConfirmedLoadableStudyId(), true);

        //        Optional<com.cpdss.loadablestudy.entity.LoadableStudyPortRotation>
        //            optionalLoadableStudyWithMAXPortOrder =
        //                respectiveLoadableStudyOpt.get().getPortRotations().stream()
        //                    .filter(item -> item.getOperation().getId() == 1L)
        //                    .max(
        //                        Comparator.comparing(
        //                            com.cpdss.loadablestudy.entity.LoadableStudyPortRotation
        //                                ::getPortOrder));
        //      We will be taking the first discharging port's arrival condition.
        log.info(
            "Fetching discharge port of confirmed loadable study {}",
            respectiveLoadableStudyOpt.get().getId());
        Optional<com.cpdss.loadablestudy.entity.LoadableStudyPortRotation>
            optionalLoadableStudyWithMAXPortOrder =
                respectiveLoadableStudyOpt.get().getPortRotations().stream()
                    .filter(item -> item.getOperation().getId() == DISCHARGING_OPERATION_ID)
                    .min(
                        Comparator.comparing(
                            com.cpdss.loadablestudy.entity.LoadableStudyPortRotation
                                ::getPortOrder));
        if (optionalLoadableStudyWithMAXPortOrder.isEmpty()) {
          log.error("No port rotation details found for DischargeID  {} ", dischargeStudyId);
          throw new GenericServiceException(
              "No port rotation details found for DischargeID",
              CommonErrorCodes.E_HTTP_BAD_REQUEST,
              HttpStatusCode.BAD_REQUEST);
        } else {
          //          log.info(
          //              "Requesting loading plan for port rotation id {}",
          //              optionalLoadableStudyWithMAXPortOrder.get().getId());
          //
          //
          // com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInformationRequest
          //                  .Builder
          //              LoadingInformationRequest =
          //                  com.cpdss.common.generated.loading_plan.LoadingPlanModels
          //                      .LoadingInformationRequest.newBuilder();
          //          LoadingInformationRequest.setCompanyId(1L);
          //          LoadingInformationRequest.setVesselId(vesselId);
          //          LoadingInformationRequest.setVoyageId(activeVoyage.getId());
          //          LoadingInformationRequest.setLoadingPatternId(activeVoyage.getPatternId());
          //          LoadingInformationRequest.setPortRotationId(
          //              optionalLoadableStudyWithMAXPortOrder.get().getId());
          //          LoadingPlanReply loadingPlanReply =
          //              loadingPlanGrpcService.getLoadingPlan(LoadingInformationRequest.build());
          //          if (!SUCCESS.equals(loadingPlanReply.getResponseStatus().getStatus())) {
          //            log.error(
          //                "No Loading plan found for port rotaion id {} ",
          //                optionalLoadableStudyWithMAXPortOrder.get().getId());
          //            throw new GenericServiceException(
          //                "No Loading plan found for port rotaion",
          //                CommonErrorCodes.E_HTTP_BAD_REQUEST,
          //                HttpStatusCode.BAD_REQUEST);
          //          } else {
          //            return buildArrivalCondition(loadingPlanReply);
          //          }
          log.info(
              "Building port wise details for port rotation {}",
              optionalLoadableStudyWithMAXPortOrder.get().getId());
          return buildArrivalConditionFromLoadableStudy(
              respectiveLoadableStudyOpt.get(), optionalLoadableStudyWithMAXPortOrder.get());
        }
      }
    } else {
      log.error(
          "Invalid Discharge study ID - No confirmed Loadable Study exists ", dischargeStudyId);
      throw new GenericServiceException(
          "Invalid Discharge study ID - No confirmed Loadable Study exists",
          CommonErrorCodes.E_HTTP_BAD_REQUEST,
          HttpStatusCode.BAD_REQUEST);
    }
  }

  /**
   * Builds the arrival condition JSON from loadable study
   *
   * @param loadableStudy
   * @param loadableStudyPortRotation
   * @return
   * @throws GenericServiceException
   */
  private ArrivalConditionJson buildArrivalConditionFromLoadableStudy(
      LoadableStudy loadableStudy, LoadableStudyPortRotation loadableStudyPortRotation)
      throws GenericServiceException {
    ArrivalConditionJson arrivalCondition = new ArrivalConditionJson();
    Optional<LoadablePattern> confirmedLoadablePatternOpt =
        loadablePatternRepository.findByLoadableStudyAndLoadableStudyStatusAndIsActive(
            loadableStudy, CONFIRMED_STATUS_ID, true);
    if (confirmedLoadablePatternOpt.isEmpty()) {
      log.error("No confirmed pattern found for Loadable Study {} ", loadableStudy.getId());
      throw new GenericServiceException(
          "No Confirmed pattern found for Loadable Study " + loadableStudy.getId(),
          CommonErrorCodes.E_HTTP_BAD_REQUEST,
          HttpStatusCode.BAD_REQUEST);
    } else {
      log.info(
          "Building arrival condition of Loadable pattern {}, port rotation {}",
          confirmedLoadablePatternOpt.get().getId(),
          loadableStudyPortRotation.getId());
      buildStowageDetailsForArrivalCondition(
          arrivalCondition, confirmedLoadablePatternOpt.get(), loadableStudyPortRotation);

      buildBallastDetailsForArrivalCondition(
          arrivalCondition, confirmedLoadablePatternOpt.get(), loadableStudyPortRotation);

      buildCommingleDetailsForArrivalCondition(
          arrivalCondition, confirmedLoadablePatternOpt.get(), loadableStudyPortRotation);

      buildStabilityParametersForArrivalCondition(
          arrivalCondition, confirmedLoadablePatternOpt.get(), loadableStudyPortRotation);
    }
    return arrivalCondition;
  }

  private void buildStabilityParametersForArrivalCondition(
      ArrivalConditionJson arrivalCondition,
      LoadablePattern loadablePattern,
      LoadableStudyPortRotation loadableStudyPortRotation) {
    Optional<SynopticalTable> synopticalTableOpt =
        synopticalTableRepository.findByLoadableStudyAndPortRotationAndOperationTypeAndIsActive(
            loadablePattern.getLoadableStudy().getId(),
            loadableStudyPortRotation.getId(),
            SYNOPTICAL_TABLE_OP_TYPE_ARRIVAL,
            true);
    SynopticalTableLoadicatorData loadicatorData =
        synopticalTableLoadicatorDataRepository
            .findByloadablePatternIdAndSynopticalTableAndIsActive(
                loadablePattern.getId(), synopticalTableOpt.get(), true);

    StabilityParameter stabilityParameterDto = new StabilityParameter();
    Optional.ofNullable(loadicatorData.getBendingMoment())
        .ifPresent(bm -> stabilityParameterDto.setBm(bm.toString()));
    Optional.ofNullable(loadicatorData.getCalculatedDraftAftPlanned())
        .ifPresent(aftDraft -> stabilityParameterDto.setAfterDraft(aftDraft.toString()));
    Optional.ofNullable(loadicatorData.getCalculatedDraftFwdPlanned())
        .ifPresent(fwdDraft -> stabilityParameterDto.setForwardDraft(fwdDraft.toString()));
    Optional.ofNullable(loadicatorData.getCalculatedDraftMidPlanned())
        .ifPresent(midDraft -> stabilityParameterDto.setMeanDraft(midDraft.toString()));
    Optional.ofNullable(loadicatorData.getCalculatedTrimPlanned())
        .ifPresent(trim -> stabilityParameterDto.setTrim(trim.toString()));
    Optional.ofNullable(loadicatorData.getFreeboard())
        .ifPresent(freeBoard -> stabilityParameterDto.setFreeboard(freeBoard.toString()));
    Optional.ofNullable(loadicatorData.getManifoldHeight())
        .ifPresent(
            manifoldHeight -> stabilityParameterDto.setManifoldHeight(manifoldHeight.toString()));
    Optional.ofNullable(loadicatorData.getShearingForce())
        .ifPresent(sf -> stabilityParameterDto.setSf(sf.toString()));
    arrivalCondition.setStabilityParameters(stabilityParameterDto);
  }

  private void buildCommingleDetailsForArrivalCondition(
      ArrivalConditionJson arrivalCondition,
      LoadablePattern loadablePattern,
      LoadableStudyPortRotation loadableStudyPortRotation) {
    List<LoadablePlanComminglePortwiseDetails> loadablePlanCommingleDetails =
        loadablePlanCommingleDetailsPortwiseRepository
            .findByLoadablePatternIdAndPortRotationIdAndOperationTypeAndIsActive(
                loadablePattern.getId(),
                loadableStudyPortRotation.getId(),
                SYNOPTICAL_TABLE_OP_TYPE_ARRIVAL,
                true);
    List<LoadableQuantityCommingleCargoDetails> loadableQuantityCommingleCargoDetails =
        new ArrayList<>();
    loadablePlanCommingleDetails.forEach(
        loadablePlanComminglePortwiseDetails -> {
          LoadableQuantityCommingleCargoDetails commingleCargoDetails =
              new LoadableQuantityCommingleCargoDetails();
          ofNullable(loadablePlanComminglePortwiseDetails.getId())
              .ifPresent(commingleCargoDetails::setId);
          ofNullable(loadablePlanComminglePortwiseDetails.getApi())
              .ifPresent(commingleCargoDetails::setApi);
          ofNullable(loadablePlanComminglePortwiseDetails.getTemperature())
              .ifPresent(commingleCargoDetails::setTemp);
          ofNullable(loadablePlanComminglePortwiseDetails.getQuantity())
              .ifPresent(commingleCargoDetails::setQuantity);
          ofNullable(loadablePlanComminglePortwiseDetails.getTankName())
              .ifPresent(commingleCargoDetails::setTankName);
          ofNullable(loadablePlanComminglePortwiseDetails.getTankId())
              .ifPresent(commingleCargoDetails::setTankId);
          ofNullable(loadablePlanComminglePortwiseDetails.getRdgUllage())
              .ifPresent(commingleCargoDetails::setCorrectedUllage);
          ofNullable(loadablePlanComminglePortwiseDetails.getCommingleColour())
              .ifPresent(commingleCargoDetails::setColorCode);
          ofNullable(loadablePlanComminglePortwiseDetails.getGrade())
              .ifPresent(commingleCargoDetails::setAbbreviation);
          ofNullable(loadablePlanComminglePortwiseDetails.getCargo1Mt())
              .ifPresent(commingleCargoDetails::setCargo1MT);
          ofNullable(loadablePlanComminglePortwiseDetails.getCargo2Mt())
              .ifPresent(commingleCargoDetails::setCargo2MT);
          ofNullable(loadablePlanComminglePortwiseDetails.getCargo1NominationId())
              .ifPresent(commingleCargoDetails::setCargo1NominationId);
          ofNullable(loadablePlanComminglePortwiseDetails.getCargo2NominationId())
              .ifPresent(commingleCargoDetails::setCargo2NominationId);
          loadableQuantityCommingleCargoDetails.add(commingleCargoDetails);
        });
    arrivalCondition.setLoadableQuantityCommingleCargoDetails(
        loadableQuantityCommingleCargoDetails);
  }

  private void buildBallastDetailsForArrivalCondition(
      ArrivalConditionJson arrivalCondition,
      LoadablePattern loadablePattern,
      LoadableStudyPortRotation loadableStudyPortRotation) {
    List<LoadablePlanStowageBallastDetails> ballastDetails =
        loadablePlanStowageBallastDetailsRepository
            .findByLoadablePatternIdAndPortRotationIdAndOperationTypeAndIsActive(
                loadablePattern.getId(),
                loadableStudyPortRotation.getId(),
                SYNOPTICAL_TABLE_OP_TYPE_ARRIVAL,
                true);
    List<LoadablePlanStowageDetailsJson> ballastDetailsJsons = new ArrayList<>();
    ballastDetails.forEach(
        ballastDetail -> {
          LoadablePlanStowageDetailsJson ballastDetailsJson = new LoadablePlanStowageDetailsJson();
          Optional.ofNullable(ballastDetail.getRdgUllage())
              .ifPresent(rdgUllage -> ballastDetailsJson.setSounding(rdgUllage.toString()));
          Optional.ofNullable(ballastDetail.getVolume())
              .ifPresent(volume -> ballastDetailsJson.setQuantityM3(volume.toString()));
          ballastDetailsJson.setQuantity(
              ballastDetail.getQuantity() == null
                  ? BigDecimal.ZERO.toString()
                  : ballastDetail.getQuantity().toString());
          Optional.ofNullable(ballastDetail.getId()).ifPresent(id -> ballastDetailsJson.setId(id));
          Optional.ofNullable(ballastDetail.getTankXId())
              .ifPresent(tankId -> ballastDetailsJson.setTankId(tankId));
          ballastDetailsJsons.add(ballastDetailsJson);
        });
    arrivalCondition.setLoadablePlanBallastDetails(ballastDetailsJsons);
  }

  private void buildStowageDetailsForArrivalCondition(
      ArrivalConditionJson arrivalCondition,
      LoadablePattern loadablePattern,
      LoadableStudyPortRotation loadableStudyPortRotation) {
    List<LoadablePatternCargoDetails> loadablePatternCargoDetails =
        loadablePatternCargoDetailsRepository
            .findByLoadablePatternIdAndPortRotationIdAndOperationTypeAndIsActive(
                loadablePattern.getId(),
                loadableStudyPortRotation.getId(),
                SYNOPTICAL_TABLE_OP_TYPE_ARRIVAL,
                true);
    List<LoadablePlanStowageDetailsJson> stowageDetailsJsons = new ArrayList<>();
    loadablePatternCargoDetails.forEach(
        loadablePatternCargoDetail -> {
          LoadablePlanStowageDetailsJson stowageDetailsJson = new LoadablePlanStowageDetailsJson();
          Optional.ofNullable(loadablePatternCargoDetail.getApi())
              .ifPresent(api -> stowageDetailsJson.setApi(api.toString()));
          Optional.ofNullable(loadablePatternCargoDetail.getPlannedQuantity())
              .ifPresent(quantity -> stowageDetailsJson.setQuantity(quantity.toString()));
          Optional.ofNullable(loadablePatternCargoDetail.getId())
              .ifPresent(id -> stowageDetailsJson.setId(id));
          Optional.ofNullable(loadablePatternCargoDetail.getCargoNominationId())
              .ifPresent(
                  cargoNominationId -> stowageDetailsJson.setCargoNominationId(cargoNominationId));
          Optional.ofNullable(loadablePatternCargoDetail.getTankId())
              .ifPresent(tankId -> stowageDetailsJson.setTankId(tankId));
          Optional.ofNullable(loadablePatternCargoDetail.getTemperature())
              .ifPresent(temperature -> stowageDetailsJson.setTemperature(temperature.toString()));
          stowageDetailsJsons.add(stowageDetailsJson);
        });
    arrivalCondition.setLoadablePlanStowageDetails(stowageDetailsJsons);
  }

  private ArrivalConditionJson buildArrivalCondition(LoadingPlanReply loadingPlanReply) {
    ArrivalConditionJson arrivalCondition = new ArrivalConditionJson();

    arrivalCondition.setLoadableQuantityCargoDetails(new ArrayList<>()); // For future

    ofNullable(loadingPlanReply.getPortLoadingPlanCommingleDetailsList())
        .ifPresent(
            loadingPlanCommingleDetailsReply ->
                arrivalCondition.setLoadableQuantityCommingleCargoDetails(
                    getCommingleCargoDetails(loadingPlanCommingleDetailsReply)));

    ofNullable(loadingPlanReply.getPortLoadingPlanStabilityParametersList())
        .ifPresent(
            stabilityParameterFromloadingPlanReply ->
                arrivalCondition.setStabilityParameters(
                    getStabilityParameters(stabilityParameterFromloadingPlanReply)));

    ofNullable(loadingPlanReply.getPortLoadingPlanStowageDetailsList())
        .ifPresent(
            loadablePlanStowageFromloadingPlanReply ->
                arrivalCondition.setLoadablePlanStowageDetails(
                    getLoadablePlanStowageDetails(loadablePlanStowageFromloadingPlanReply)));

    ofNullable(loadingPlanReply.getPortLoadingPlanBallastDetailsList())
        .ifPresent(
            loadablePlanBallastFromloadingPlanReply ->
                arrivalCondition.setLoadablePlanBallastDetails(
                    getLoadablePlanStowageDetails(loadablePlanBallastFromloadingPlanReply)));

    return arrivalCondition;
  }

  private List<LoadableQuantityCommingleCargoDetails> getCommingleCargoDetails(
      List<LoadingPlanCommingleDetails> loadingPlanCommingleDetailsReply) {
    List<LoadableQuantityCommingleCargoDetails> commingleDetailsList = new ArrayList<>();
    loadingPlanCommingleDetailsReply =
        loadingPlanCommingleDetailsReply.stream()
            .filter(item -> item.getConditionType() == 2L && item.getValueType() == 1L)
            .collect(Collectors.toList());
    loadingPlanCommingleDetailsReply.forEach(
        item -> {
          LoadableQuantityCommingleCargoDetails commingleDetails =
              new LoadableQuantityCommingleCargoDetails();
          ofNullable(item.getId()).ifPresent(commingleDetails::setId);
          ofNullable(item.getApi()).ifPresent(commingleDetails::setApi);
          ofNullable(item.getTemperature()).ifPresent(commingleDetails::setTemp);
          ofNullable(item.getQuantityMT()).ifPresent(commingleDetails::setQuantity);
          ofNullable(item.getTankName()).ifPresent(commingleDetails::setTankName);
          ofNullable(item.getTankId()).ifPresent(commingleDetails::setTankId);
          ofNullable(item.getUllage()).ifPresent(commingleDetails::setCorrectedUllage);
          ofNullable(item.getColorCode()).ifPresent(commingleDetails::setColorCode);
          ofNullable(item.getAbbreviation()).ifPresent(commingleDetails::setAbbreviation);
          ofNullable(item.getQuantity1MT()).ifPresent(commingleDetails::setCargo1MT);
          ofNullable(item.getQuantity2MT()).ifPresent(commingleDetails::setCargo2MT);
          ofNullable(item.getQuantity1M3()).ifPresent(commingleDetails::setCargo1M3);
          ofNullable(item.getQuantity2M3()).ifPresent(commingleDetails::setCargo2M3);
          ofNullable(item.getUllage1()).ifPresent(commingleDetails::setCargo1Ullage);
          ofNullable(item.getUllage2()).ifPresent(commingleDetails::setCargo2Ullage);
          ofNullable(item.getCargo1Id()).ifPresent(commingleDetails::setCargo1Id);
          ofNullable(item.getCargo2Id()).ifPresent(commingleDetails::setCargo2Id);
          ofNullable(item.getCargoNomination1Id())
              .ifPresent(commingleDetails::setCargo1NominationId);
          ofNullable(item.getCargoNomination2Id())
              .ifPresent(commingleDetails::setCargo2NominationId);
          commingleDetailsList.add(commingleDetails);
        });
    return commingleDetailsList;
  }

  private List<LoadablePlanStowageDetailsJson> getLoadablePlanStowageDetails(
      List<LoadingPlanTankDetails> loadablePlanStowageFromloadingPlanReply) {

    List<LoadablePlanStowageDetailsJson> stowageDetailsList = new ArrayList<>();
    loadablePlanStowageFromloadingPlanReply =
        loadablePlanStowageFromloadingPlanReply.stream()
            .filter(item -> item.getConditionType() == 2L && item.getValueType() == 1L)
            .collect(Collectors.toList());

    loadablePlanStowageFromloadingPlanReply.forEach(
        item -> {
          LoadablePlanStowageDetailsJson stowageDetails = new LoadablePlanStowageDetailsJson();
          ofNullable(item.getId()).ifPresent(stowageDetails::setId);
          ofNullable(item.getApi()).ifPresent(stowageDetails::setApi);
          ofNullable(item.getCargoNominationId()).ifPresent(stowageDetails::setCargoNominationId);
          ofNullable(item.getQuantity()).ifPresent(stowageDetails::setQuantity);
          ofNullable(item.getTankId()).ifPresent(stowageDetails::setTankId);
          ofNullable(item.getTemperature()).ifPresent(stowageDetails::setTemperature);
          ofNullable(item.getUllage()).ifPresent(stowageDetails::setUllage);
          ofNullable(item.getQuantityM3()).ifPresent(stowageDetails::setQuantityM3);
          ofNullable(item.getSounding()).ifPresent(stowageDetails::setSounding);
          stowageDetailsList.add(stowageDetails);
        });
    return stowageDetailsList;
  }

  private StabilityParameter getStabilityParameters(
      List<LoadingPlanStabilityParameters> loadingPlanStabilityParametersList) {

    Optional<LoadingPlanStabilityParameters> optionalItem =
        loadingPlanStabilityParametersList.stream()
            .filter(item -> item.getConditionType() == 2L && item.getValueType() == 1L)
            .findAny();
    StabilityParameter parameter = new StabilityParameter();
    if (optionalItem.isPresent()) {
      ofNullable(optionalItem.get().getDraft()).ifPresent(parameter::setDraft);
      ofNullable(optionalItem.get().getTrim()).ifPresent(parameter::setTrim);
      ofNullable(optionalItem.get().getBm()).ifPresent(parameter::setBm);
      ofNullable(optionalItem.get().getSf()).ifPresent(parameter::setSf);
    }
    return parameter;
  }

  private List<PortDetails> getPortDetails(List<DischargeStudyPortRotationJson> portRotationList) {
    log.info("Fetching Port details for {} ports", portRotationList.size());
    if (!CollectionUtils.isEmpty(portRotationList)) {
      List<PortDetails> portDetailsList = new ArrayList<>();
      List<Long> portIds =
          portRotationList.stream().map(item -> item.getPortId()).collect(Collectors.toList());
      PortInfo.PortReply portReply = getPortInfo(portIds);
      if (portReply.getResponseStatus().getStatus().equals(SUCCESS)) {
        portReply
            .getPortsList()
            .forEach(
                item -> {
                  PortDetails portdetail = new PortDetails();
                  ofNullable(item.getId()).ifPresent(portdetail::setId);
                  ofNullable(item.getName()).ifPresent(portdetail::setName);
                  ofNullable(item.getCode()).ifPresent(portdetail::setCode);
                  ofNullable(item.getAverageTideHeight())
                      .ifPresent(portdetail::setAverageTideHeight);
                  ofNullable(item.getTideHeight()).ifPresent(portdetail::setTideHeight);
                  // Bug fix : 4615
                  ofNullable(item.getWaterDensity()).ifPresent(portdetail::setDensitySeaWater);
                  ofNullable(item.getCountryName()).ifPresent(portdetail::setCountryName);
                  portDetailsList.add(portdetail);
                });
        log.info("Found {} items", portDetailsList.size());
        return portDetailsList;
      }
    }
    log.info("No Port details  found ");
    return null;
  }

  /** @return PortReply */
  public PortInfo.PortReply getPortInfo(List<Long> portIds) {
    PortInfo.GetPortInfoByPortIdsRequest request =
        PortInfo.GetPortInfoByPortIdsRequest.newBuilder().addAllId(portIds).build();
    return portInfoGrpcService.getPortInfoByPortIds(request);
  }

  private List<OnHandQuantity> getOnHandQuantity(Long dischargeStudyId) {
    log.info("Fetching OnHand quantity details for discharge id {}", dischargeStudyId);
    List<com.cpdss.loadablestudy.entity.OnHandQuantity> ohqList =
        onHandQuantityRepository.findByDischargeStudyIdAndActive(dischargeStudyId);
    if (!CollectionUtils.isEmpty(ohqList)) {
      List<OnHandQuantity> onHandQuantityList = new ArrayList<>();
      ohqList.forEach(
          item -> {
            OnHandQuantity onHandQuantity = new OnHandQuantity();
            ofNullable(item.getId()).ifPresent(onHandQuantity::setId);
            ofNullable(item.getPortXId()).ifPresent(onHandQuantity::setPortId);
            ofNullable(item.getFuelTypeXId()).ifPresent(onHandQuantity::setFueltypeId);
            ofNullable(item.getTankXId()).ifPresent(onHandQuantity::setTankId);
            ofNullable(item.getArrivalVolume())
                .ifPresent(i -> onHandQuantity.setArrivalVolume(i.toString()));
            ofNullable(item.getArrivalQuantity())
                .ifPresent(i -> onHandQuantity.setArrivalQuantity(i.toString()));
            ofNullable(item.getDepartureVolume())
                .ifPresent(i -> onHandQuantity.setDepartureVolume(i.toString()));
            ofNullable(item.getDepartureQuantity())
                .ifPresent(i -> onHandQuantity.setDepartureQuantity(i.toString()));
            // Bug fix : 4615
            ofNullable(item.getDensity()).ifPresent(i -> onHandQuantity.setDensity(i.toString()));
            onHandQuantityList.add(onHandQuantity);
          });
      log.info("Found {} items", onHandQuantityList.size());
      return onHandQuantityList;
    }
    log.info("No  OnHand quantity details found ");
    return null;
  }

  private List<CargoNominationOperationDetails> getCargoNominationOperationDetails(
      Long dischargeStudyId) {
    log.info("Fetching CargoNomination Operation details for discharge id {}", dischargeStudyId);
    List<CargoNominationOperationDetails> cargoNominationOperationDetailsList = new ArrayList<>();
    List<com.cpdss.loadablestudy.entity.CargoNomination> cargoNominationReply =
        getCargoNominationforDischargeID(dischargeStudyId);
    if (!CollectionUtils.isEmpty(cargoNominationReply)) {

      cargoNominationReply.forEach(
          item -> {
            List<CargoNominationPortDetails> cargoNominationPortDetails =
                cargoNominationOperationDetailsRepository.findByCargoNominationAndIsActiveTrue(
                    item);
            if (!CollectionUtils.isEmpty(cargoNominationPortDetails)) {
              log.info("CargoNominationPortDetails get:{}", cargoNominationPortDetails.size());
              Iterator<CargoNominationPortDetails> iterator = cargoNominationPortDetails.iterator();
              while (iterator.hasNext()) {
                CargoNominationPortDetails iteratorItem = iterator.next();
                if (iteratorItem.getIsActive()) {
                  CargoNominationOperationDetails cargoNominationOperation =
                      new CargoNominationOperationDetails();
                  ofNullable(iteratorItem.getId()).ifPresent(cargoNominationOperation::setId);
                  ofNullable(item.getLsCargoNominationId())
                      .ifPresent(cargoNominationOperation::setCargoNominationId);
                  ofNullable(item.getId())
                      .ifPresent(cargoNominationOperation::setDscargoNominationId);
                  ofNullable(iteratorItem.getPortId())
                      .ifPresent(cargoNominationOperation::setPortId);
                  ofNullable(iteratorItem.getQuantity())
                      .ifPresent(i -> cargoNominationOperation.setQuantity(i.toString()));
                  ofNullable(iteratorItem.getSequenceNo())
                      .ifPresent(cargoNominationOperation::setSequenceNo);
                  ofNullable(iteratorItem.getEmptyMaxNoOfTanks())
                      .ifPresent(cargoNominationOperation::setEmptyMaxNoOfTanks);
                  ofNullable(iteratorItem.getMode())
                      .ifPresent(cargoNominationOperation::setDischargingMode);
                  ofNullable(iteratorItem.getPortRotation())
                      .ifPresent(
                          loadableStudyPortRotation ->
                              cargoNominationOperation.setPortRotationId(
                                  loadableStudyPortRotation.getId()));
                  cargoNominationOperationDetailsList.add(cargoNominationOperation);
                }
              }
            }
          });
    }
    log.info("Found {} items", cargoNominationOperationDetailsList.size());
    return cargoNominationOperationDetailsList;
  }

  private List<com.cpdss.loadablestudy.entity.CargoNomination> getCargoNominationforDischargeID(
      Long dischargeStudyId) {
    return this.cargoNominationRepository.findByLoadableStudyXIdAndIsActiveOrderByCreatedDateTime(
        dischargeStudyId, true);
  }

  private List<CargoNomination> getCargoNomination(Long dischargeStudyId) {
    log.info("Fetching CargoNomination details for discharge id {}", dischargeStudyId);
    List<CargoNomination> cargoNominationList = new ArrayList<>();
    List<com.cpdss.loadablestudy.entity.CargoNomination> cargoNominationReply =
        getCargoNominationforDischargeID(dischargeStudyId);
    if (!CollectionUtils.isEmpty(cargoNominationReply)) {
      cargoNominationReply.forEach(
          item -> {
            CargoNomination nomination = new CargoNomination();
            ofNullable(item.getId()).ifPresent(nomination::setId);
            ofNullable(item.getLoadableStudyXId()).ifPresent(nomination::setDischargeStudyId);
            ofNullable(item.getPriority()).ifPresent(nomination::setPriority);
            ofNullable(item.getColor()).ifPresent(nomination::setColor);
            ofNullable(item.getCargoXId()).ifPresent(nomination::setCargoId);
            ofNullable(item.getAbbreviation()).ifPresent(nomination::setAbbreviation);
            ofNullable(item.getQuantity()).ifPresent(nomination::setQuantity);
            ofNullable(item.getMaxTolerance()).ifPresent(nomination::setMaxTolerance);
            ofNullable(item.getMinTolerance()).ifPresent(nomination::setMinTolerance);
            ofNullable(item.getApi()).ifPresent(nomination::setApi);
            ofNullable(item.getTemperature()).ifPresent(nomination::setTemperature);
            ofNullable(item.getSegregationXId()).ifPresent(nomination::setSegregationId);
            nomination.setIsCondensateCargo(null); // for future
            nomination.setIsHrvpCargo(null); // for future
            // Added as part of DSS- 4936
            nomination.setIsCommingled(item.getIsCommingled());
            //            nomination.setSequenceNo(item.getSequenceNo());
            //            nomination.setEmptyMaxNoOfTanks(item.getEmptyMaxNoOfTanks());
            cargoNominationList.add(nomination);
          });
    }
    log.info("Found {} items", cargoNominationList.size());
    return cargoNominationList;
  }

  private List<DischargeStudyPortRotationJson> getDischargeStudyPortRotation(
      Long dischargeStudyId, List<LoadableStudyInstruction> instructionsDetails) {
    log.info("Fetching Port Roataion details ");
    List<DischargeStudyPortRotationJson> portRotationList = new ArrayList<>();
    PortRotationRequest.Builder request = PortRotationRequest.newBuilder();
    request.setLoadableStudyId(dischargeStudyId);
    PortRotationReply reply =
        loadableStudyPortRotationService
            .getPortRotationByLoadableStudyId(request.build(), PortRotationReply.newBuilder())
            .build();
    if (reply.getResponseStatus().getStatus() != SUCCESS) {
      log.info("No port rotaion details found for Discharge ID  :{}", dischargeStudyId);
      return null;
    } else {
      reply
          .getPortsList()
          .forEach(
              port -> {
                DischargeStudyPortRotationJson portRotation = new DischargeStudyPortRotationJson();
                portRotation.setId(port.getId());
                portRotation.setDischargeStudyId(port.getLoadableStudyId());
                portRotation.setPortId(port.getPortId());
                portRotation.setBerthId(port.getBerthId());
                portRotation.setOperationId(port.getOperationId());
                portRotation.setSeaWaterDensity(port.getSeaWaterDensity());
                portRotation.setDistanceBetweenPorts(port.getDistanceBetweenPorts());
                portRotation.setTimeOfStay(port.getTimeOfStay());
                portRotation.setMaxDraft(port.getMaxDraft());
                portRotation.setMaxAirDraft(port.getMaxAirDraft());
                portRotation.setEta(port.getEta());
                portRotation.setEtd(port.getEtd());
                portRotation.setPortOrder(port.getPortOrder());
                portRotation.setCow(port.getCow());
                //                portRotation.setCowDetails(getCowDetails(dischargeStudyId,
                // port.getId()));
                portRotation.setInstructions(getPortInstructions(port, instructionsDetails));
                portRotation.setFreshCrudeOil(port.getFreshCrudeOil());
                portRotation.setFreshCrudeOilQuantity(
                    port.getFreshCrudeOilQuantity().isEmpty()
                        ? null
                        : new BigDecimal(port.getFreshCrudeOilQuantity()));
                portRotation.setFreshCrudeOilTime(
                    port.getFreshCrudeOilTime().isEmpty()
                        ? null
                        : new BigDecimal(port.getFreshCrudeOilTime()));
                portRotationList.add(portRotation);
              });
      log.info("Found {} items", portRotationList.size());
      return portRotationList;
    }
  }

  private CowDetail getCowDetails(Long dischargeStudyId) {
    log.info("Getting Cow details for {}", dischargeStudyId);
    DischargeStudyCowDetail reply = cowDetailService.getCowDetailForDS(dischargeStudyId);
    if (reply != null) {
      CowDetail cowDetail = new CowDetail();
      cowDetail.setId(reply.getId());
      cowDetail.setType(reply.getCowType());
      cowDetail.setPercentage(reply.getPercentage());
      if (reply.getTankIds() != null && !reply.getTankIds().isBlank()) {
        List<Long> tankIdList =
            Stream.of(reply.getTankIds().split(","))
                .map(Long::parseLong)
                .collect(Collectors.toList());
        VesselTankRequest.Builder tankRequest = VesselTankRequest.newBuilder();
        tankRequest.addAllTankIds(tankIdList);
        VesselTankResponse replyBuilder =
            this.vesselInfoGrpcService.getVesselInfoBytankIds(tankRequest.build());
        if (replyBuilder.getVesselTankOrderList() != null) {
          log.info("Tank Sort name found for Discharge ID  :{}", dischargeStudyId);
          cowDetail.setTanks(
              replyBuilder.getVesselTankOrderList().stream()
                  .map(item -> item.getShortName())
                  .collect(Collectors.joining(",")));
        }
      }
      return cowDetail;
    }
    log.info("No COW Details found for DS  :{}", dischargeStudyId);
    return null;
  }

  private List<LoadableStudyInstruction> getPortInstructions(
      PortRotationDetail port, List<LoadableStudyInstruction> instructionsDetails) {
    log.info("Getting Instruction details for port {}", port.getPortId());
    List<LoadableStudyInstruction> instructionList = new ArrayList<LoadableStudyInstruction>();
    port.getInstructionIdList()
        .forEach(
            instructionId -> {
              instructionsDetails.forEach(
                  instructionMasterItem -> {
                    if (instructionId == instructionMasterItem.getId()) {
                      LoadableStudyInstruction portInstruction = new LoadableStudyInstruction();
                      portInstruction.setId(instructionId);
                      portInstruction.setPortInstruction(instructionMasterItem.getInstruction());
                      instructionList.add(portInstruction);
                    }
                  });
            });
    log.info("Found {} items", instructionList.size());
    return instructionList;
  }

  // Getting all instructions from master table PortInstruction
  private List<LoadableStudyInstruction> getAllLoadableStudyInstruction() {

    List<PortInstruction> instructionsDetails = portInstructionRepository.findByIsActive(true);
    List<LoadableStudyInstruction> instructionList = new ArrayList<>();
    instructionsDetails.forEach(
        item -> {
          LoadableStudyInstruction instruction = new LoadableStudyInstruction();
          instruction.setId(item.getId());
          instruction.setInstruction(item.getPortInstruction());
          instructionList.add(instruction);
        });
    return instructionList;
  }

  /**
   * Method to communicate discharge study
   *
   * @param dischargeStudyId - dischargeStudy Id value
   * @return communication id value
   * @throws GenericServiceException Exception on invalid response from envoy-writer or invalid
   *     dischargeStudyId
   */
  public String communicateDischargeStudy(final long dischargeStudyId, boolean callRemoteAlgo)
      throws GenericServiceException {

    LoadableStudy loadableStudy =
        loadableStudyRepository
            .findById(dischargeStudyId)
            .orElseThrow(
                () -> {
                  log.error("Discharge Study not found. Id: {}", dischargeStudyId);
                  return new GenericServiceException(
                      "Discharge Study not found. Id: " + dischargeStudyId,
                      CommonErrorCodes.E_GEN_INTERNAL_ERR,
                      HttpStatusCode.INTERNAL_SERVER_ERROR);
                });

    final String processId = UUID.randomUUID().toString();
    if (callRemoteAlgo) {
      final String messageId =
          communicateData(
              loadableStudy.getId(),
              processId,
              DISCHARGE_STUDY_COMM_TABLES_SHIP_TO_SHORE,
              loadableStudy.getVesselXId(),
              MessageTypes.DISCHARGESTUDY);

      LoadableStudyCommunicationStatus loadableStudyCommunicationStatus =
          new LoadableStudyCommunicationStatus();

      loadableStudyCommunicationStatus.setMessageUUID(messageId);
      loadableStudyCommunicationStatus.setCommunicationStatus(
          CommunicationStatus.UPLOAD_WITH_HASH_VERIFIED.getId());

      loadableStudyCommunicationStatus.setReferenceId(loadableStudy.getId());
      loadableStudyCommunicationStatus.setMessageType(MessageTypes.DISCHARGESTUDY.getMessageType());
      loadableStudyCommunicationStatus.setCommunicationDateTime(LocalDateTime.now());
      LoadableStudyCommunicationStatus loadingPlanCommunication =
          this.loadableStudyCommunicationStatusRepository.save(loadableStudyCommunicationStatus);
      log.info("Communication table update : " + loadingPlanCommunication.getId());
      updateProcessIdForDischargeStudy("", loadableStudy, DISCHARGE_STUDY_COMMUNICATED_TO_SHORE);
      loadableStudyRepository.updateLoadableStudyStatus(
          DISCHARGE_STUDY_COMMUNICATED_TO_SHORE, loadableStudy.getId());
    } else {
      // Sequence communication
      Set<String> dsSequenceTables = new LinkedHashSet<>(DISCHARGE_STUDY_COMM_TABLES_SHIP_TO_SHORE);
      dsSequenceTables.addAll(LOADABLE_STUDY_COMM_TABLES_SHORE_TO_SHIP);

      communicateData(
          loadableStudy.getId(),
          processId,
          new ArrayList<>(dsSequenceTables),
          loadableStudy.getVesselXId(),
          MessageTypes.DISCHARGESTUDY_WITHOUT_ALGO);
    }
    return processId;
  }

  /**
   * Method to communicate data
   *
   * @param dischargeStudyId
   * @param communicationId
   * @param communicationTables
   * @param vesselId
   * @param messageType
   * @return
   * @throws GenericServiceException
   */
  private String communicateData(
      final Long dischargeStudyId,
      final String communicationId,
      final List<String> communicationTables,
      final Long vesselId,
      final MessageTypes messageType)
      throws GenericServiceException {
    JsonArray jsonArray =
        loadableStudyStagingService.getCommunicationData(
            communicationTables,
            communicationId,
            messageType.getMessageType(),
            dischargeStudyId,
            null);
    log.debug("Communication Request: {}", jsonArray.toString());

    EnvoyWriter.WriterReply ewReply =
        communicationService.passRequestPayloadToEnvoyWriter(
            jsonArray.toString(), vesselId, messageType.getMessageType());
    if (!SUCCESS.equals(ewReply.getResponseStatus().getStatus())) {
      log.error("Invalid response from envoy-writer. Response: {}", ewReply);
      throw new GenericServiceException(
          "Invalid response from envoy-writer. Response: " + ewReply,
          CommonErrorCodes.E_GEN_INTERNAL_ERR,
          HttpStatusCode.INTERNAL_SERVER_ERROR);
    }
    log.info("------- Envoy writer has called successfully : " + ewReply.toString());
    return ewReply.getMessageId();
  }
}
