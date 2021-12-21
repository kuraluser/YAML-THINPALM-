/* Licensed at AlphaOri Technologies */
package com.cpdss.loadablestudy.service;

// region Import
import static com.cpdss.loadablestudy.utility.LoadableStudiesConstants.CPDSS_BUILD_ENV_SHORE;
import static com.cpdss.loadablestudy.utility.LoadableStudiesConstants.LoadableStudyTables;
import static org.apache.commons.collections4.ListUtils.emptyIfNull;
import static org.springframework.util.CollectionUtils.isEmpty;

import com.cpdss.common.communication.entity.DataTransferStage;
import com.cpdss.common.exception.GenericServiceException;
import com.cpdss.common.rest.CommonErrorCodes;
import com.cpdss.common.utils.EntityDoc;
import com.cpdss.common.utils.HttpStatusCode;
import com.cpdss.common.utils.MessageTypes;
import com.cpdss.common.utils.StagingStatus;
import com.cpdss.loadablestudy.communication.LoadableStudyStagingService;
import com.cpdss.loadablestudy.entity.*;
import com.cpdss.loadablestudy.repository.*;
import com.cpdss.loadablestudy.utility.ProcessIdentifiers;
import com.google.common.reflect.TypeToken;
import com.google.gson.*;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.ResourceAccessException;

// endregion

/*
Author(S) - Mahesh KM , Selvy Thomas
Purpose - Communicating Lodable study related tables to ship to shore and vice versa
 */
@Log4j2
@Service
@Transactional
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class LoadableStudyCommunicationService {

  // region Autowired
  @Autowired private LoadableStudyStagingService loadableStudyStagingService;
  @Autowired private LoadableStudyRepository loadableStudyRepository;
  @Autowired private VoyageRepository voyageRepository;
  @Autowired private CommingleCargoRepository commingleCargoRepository;
  @Autowired private CargoNominationRepository cargoNominationRepository;
  @Autowired private LoadableStudyPortRotationRepository loadableStudyPortRotationRepository;

  @Autowired
  private LoadableStudyPortRotationCommuncationRepository
      loadableStudyPortRotationCommuncationRepository;

  @Autowired private OnHandQuantityRepository onHandQuantityRepository;
  @Autowired private OnBoardQuantityRepository onBoardQuantityRepository;
  @Autowired private LoadableQuantityRepository loadableQuantityRepository;
  @Autowired private SynopticalTableRepository synopticalTableRepository;
  @Autowired private JsonDataRepository jsonDataRepository;
  @Autowired private LoadableStudyAlgoStatusRepository loadableStudyAlgoStatusRepository;
  @Autowired private LoadablePatternRepository loadablePatternRepository;
  @Autowired private AlgoErrorHeadingRepository algoErrorHeadingRepository;
  @Autowired private AlgoErrorsRepository algoErrorsRepository;
  @Autowired private LoadablePlanConstraintsRespository loadablePlanConstraintsRespository;
  @Autowired private LoadablePlanQuantityRepository loadablePlanQuantityRepository;
  @Autowired private LoadablePlanCommingleDetailsRepository loadablePlanCommingleDetailsRepository;

  @Autowired
  private CargoNominationOperationDetailsRepository cargoNominationOperationDetailsRepository;

  @Autowired
  private LoadablePatternCargoToppingOffSequenceRepository
      loadablePatternCargoToppingOffSequenceRepository;

  @Autowired private LoadablePlanStowageDetailsRespository loadablePlanStowageDetailsRespository;
  @Autowired private LoadablePlanBallastDetailsRepository loadablePlanBallastDetailsRepository;

  @Autowired
  private LoadablePlanCommingleDetailsPortwiseRepository
      loadablePlanCommingleDetailsPortwiseRepository;

  @Autowired private StabilityParameterRepository stabilityParameterRepository;
  @Autowired private LoadablePatternCargoDetailsRepository loadablePatternCargoDetailsRepository;

  @Autowired
  private LoadablePlanStowageBallastDetailsRepository loadablePlanStowageBallastDetailsRepository;

  @Autowired
  private SynopticalTableLoadicatorDataRepository synopticalTableLoadicatorDataRepository;

  @Autowired CargoOperationRepository cargoOperationRepository;

  @Autowired private JsonTypeRepository jsonTypeRepository;
  @Autowired private LoadableStudyStatusRepository loadableStudyStatusRepository;
  @Autowired private LoadablePlanRepository loadablePlanRepository;

  @Autowired
  private LoadableStudyCommunicationStatusRepository loadableStudyCommunicationStatusRepository;

  @Autowired private LoadablePatternService loadablePatternService;
  @Autowired private LoadablePlanService loadablePlanService;
  @Autowired private CowHistoryRepository cowHistoryRepository;
  @Autowired private LoadableStudyServiceShore loadableStudyServiceShore;

  @Autowired
  private DischargePatternQuantityCargoPortwiseRepository
      dischargePatternQuantityCargoPortwiseRepository;

  @Autowired LoadableStudyRuleRepository loadableStudyRuleRepository;
  @Autowired LoadableStudyRuleInputRepository loadableStudyRuleInputRepository;
  @Autowired LoadablePlanCommentsRepository loadablePlanCommentsRepository;
  @Autowired LoadablePlanStowageDetailsTempRepository loadablePlanStowageDetailsTempRepository;

  @Autowired private GenerateDischargeStudyJson generateDischargeStudyJson;
  @Autowired private VoyageStatusRepository voyageStatusRepository;
  @Autowired private LoadablePatternAlgoStatusRepository loadablePatternAlgoStatusRepository;
  // endregion

  // region Declarations
  private LoadableStudy loadableStudyStage = null;
  private Voyage voyageStage = null;
  private List<CommingleCargo> commingleCargoStage = null;
  private List<CargoNomination> cargoNominationStage = null;
  private List<LoadableStudyPortRotation> loadableStudyPortRotationStage = null;
  private List<LoadableStudyPortRotationCommunication> loadableStudyPortRotationStageCommunication =
      null;
  private List<OnHandQuantity> onHandQuantityStage = null;
  private List<OnBoardQuantity> onBoardQuantityStage = null;
  private List<LoadableQuantity> loadableQuantityStage = null;
  private List<SynopticalTable> synopticalTableStage = null;
  private List<JsonData> jsonDataStage = null;
  private LoadableStudyAlgoStatus loadableStudyAlgoStatusStage = null;
  private List<LoadablePattern> loadablePatternStage = null;
  private List<AlgoErrorHeading> algoErrorHeadingStage = null;
  private List<AlgoErrors> algoErrorsStage = null;
  private List<LoadablePlanConstraints> loadablePlanConstraintsStage = null;
  private List<LoadablePlanQuantity> loadablePlanQuantityStage = null;
  private List<LoadablePlanCommingleDetails> loadablePlanCommingleDetailsStage = null;
  private List<LoadablePatternCargoToppingOffSequence> loadablePatternCargoToppingOffSequenceStage =
      null;
  private List<LoadablePlanStowageDetails> loadablePlanStowageDetailsStage = null;
  private List<LoadablePlanBallastDetails> loadablePlanBallastDetailsStage = null;
  private List<LoadablePlanComminglePortwiseDetails> loadablePlanComminglePortwiseDetailsStage =
      null;
  private List<StabilityParameters> stabilityParametersStage = null;
  private List<LoadablePatternCargoDetails> loadablePatternCargoDetailsStage = null;
  private List<LoadablePlanStowageBallastDetails> loadablePlanStowageBallastDetailsStage = null;
  private List<SynopticalTableLoadicatorData> synopticalTableLoadicatorDataStage = null;
  private List<LoadablePlan> loadablePlanStage = null;
  private List<CargoNominationPortDetails> cargoNominationOperationDetailsStage = null;
  private List<LoadableStudyCommunicationStatus> loadableStudyCommunicationStatusStage = null;
  private List<CowHistory> cowHistoryStage = null;
  private List<DischargePatternQuantityCargoPortwiseDetails>
      dischargePatternQuantityCargoPortwiseDetailsStage = null;
  private List<LoadableStudyRules> loadableStudyRulesStage = null;
  private List<LoadableStudyRuleInput> loadableStudyRuleInputsStage = null;
  private List<LoadablePlanComments> loadablePlanCommentsStage = null;
  private List<LoadablePlanStowageDetailsTemp> loadablePlanStowageDetailsTempStage = null;
  private LoadablePatternAlgoStatus loadablePatternAlgoStatusStage = null;
  HashMap<String, Long> idMap = new HashMap<>();
  Long voyageId;
  Long loadableStudyStatusId;
  Long voyageStatusId;
  String current_table_name = "";
  // endregion

  // region Get Methods
  public void getLoadableStudyStagingData(String status, String env, String taskName)
      throws GenericServiceException {
    log.info("Inside getLoadableStudyStagingData for env:{} and status:{}", env, status);
    String retryStatus = getRetryStatus(status);
    List<DataTransferStage> dataTransferStagesWithStatus = getDataTransferWithStatus(status);
    List<DataTransferStage> dataTransferStages =
        dataTransferStagesWithStatus.stream()
            .filter(
                dataTransfer ->
                    Arrays.asList(
                            MessageTypes.LOADABLESTUDY.getMessageType(),
                            MessageTypes.ALGORESULT.getMessageType())
                        .contains(dataTransfer.getProcessGroupId()))
            .collect(Collectors.toList());
    log.info("DataTransferStages in LOADABLE_STUDY_DATA_UPDATE task:" + dataTransferStages);
    if (!dataTransferStages.isEmpty()) {
      processStagingData(dataTransferStages, env, retryStatus);
    }
  }

  public void getStowageStagingData(String status, String env, String taskName)
      throws GenericServiceException {
    log.info("Inside getStowageStagingData for env:{} and status:{}", env, status);
    String retryStatus = getRetryStatus(status);
    List<DataTransferStage> dataTransferStagesWithStatus = getDataTransferWithStatus(status);
    List<DataTransferStage> dataTransferStages =
        dataTransferStagesWithStatus.stream()
            .filter(
                dataTransfer ->
                    Arrays.asList(
                            MessageTypes.VALIDATEPLAN.getMessageType(),
                            MessageTypes.PATTERNDETAIL.getMessageType())
                        .contains(dataTransfer.getProcessGroupId()))
            .collect(Collectors.toList());
    log.info("DataTransferStages in STOWAGE_DATA_UPDATE task:" + dataTransferStages);
    if (!dataTransferStages.isEmpty()) {
      processStagingData(dataTransferStages, env, retryStatus);
    }
  }

  public void getDischargeStudyStagingData(String status, String env, String taskName)
      throws GenericServiceException {
    log.info("Inside getDischargeStudyStagingData for env:{} and status:{}", env, status);
    String retryStatus = getRetryStatus(status);
    List<DataTransferStage> dataTransferStagesWithStatus = getDataTransferWithStatus(status);
    List<DataTransferStage> dataTransferStages =
        dataTransferStagesWithStatus.stream()
            .filter(
                dataTransfer ->
                    Arrays.asList(MessageTypes.DISCHARGESTUDY.getMessageType())
                        .contains(dataTransfer.getProcessGroupId()))
            .collect(Collectors.toList());
    log.info("DataTransferStages in DISCHARGE_STUDY_DATA_UPDATE task:" + dataTransferStages);
    if (!dataTransferStages.isEmpty()) {
      processStagingData(dataTransferStages, env, retryStatus);
    }
  }

  private String getRetryStatus(String status) {
    String retryStatus = StagingStatus.RETRY.getStatus();
    if (status.equals(retryStatus)) {
      retryStatus = StagingStatus.FAILED.getStatus();
    }
    return retryStatus;
  }

  private List<DataTransferStage> getDataTransferWithStatus(String status) {
    List<DataTransferStage> dataTransferStagesWithStatus = null;
    if (status.equals(StagingStatus.IN_PROGRESS.getStatus())) {
      dataTransferStagesWithStatus =
          loadableStudyStagingService.getAllWithStatusAndTime(
              status, LocalDateTime.now().minusMinutes(10));
    } else {
      dataTransferStagesWithStatus = loadableStudyStagingService.getAllWithStatus(status);
    }
    return dataTransferStagesWithStatus;
  }

  private Optional<LoadablePattern> getLoadablePattern(Long id) {
    return loadablePatternRepository.findById(id);
  }

  private Optional<LoadablePlan> getLoadablePlan(Long id) {
    return loadablePlanRepository.findById(id);
  }
  // endregion

  // region Process
  public void processStagingData(
      List<DataTransferStage> dataTransferStages, String env, String retryStatus)
      throws GenericServiceException {
    log.info("Inside processStagingData");
    Map<String, List<DataTransferStage>> dataTransferByProcessId =
        dataTransferStages.stream().collect(Collectors.groupingBy(DataTransferStage::getProcessId));
    log.info("processId group:" + dataTransferByProcessId);
    for (Map.Entry<String, List<DataTransferStage>> entry : dataTransferByProcessId.entrySet()) {
      clear();
      HashMap<String, Long> idMap = new HashMap<>();
      String processId = entry.getKey();

      loadableStudyStagingService.updateStatusForProcessId(
          processId, StagingStatus.IN_PROGRESS.getStatus());
      log.info(
          "updated status to in_progress for processId:{} and time:{}",
          processId,
          LocalDateTime.now());
      String processGroupId = null;
      Integer arrivalDeparture = null;
      processGroupId = entry.getValue().get(0).getProcessGroupId();
      for (DataTransferStage dataTransferStage : entry.getValue()) {
        Type listType = null;
        String dataTransferString = dataTransferStage.getData();
        String data = null;
        if (dataTransferStage.getProcessIdentifier().equals("pyuser")) {
          data = JsonParser.parseString(dataTransferString).getAsJsonArray().get(0).toString();
        } else if (dataTransferStage.getProcessIdentifier().equals("json_data")) {
          data = JsonParser.parseString(dataTransferString).getAsJsonArray().toString();
        } else {
          data = replaceString(dataTransferString);
        }
        switch (ProcessIdentifiers.valueOf(dataTransferStage.getProcessIdentifier())) {
          case voyage:
            {
              Type type = new TypeToken<Voyage>() {}.getType();
              voyageStatusId = getVoyageStatus(data);
              voyageStage =
                  bindDataToEntity(
                      new Voyage(),
                      type,
                      LoadableStudyTables.VOYAGE,
                      data,
                      dataTransferStage.getId(),
                      null);
              break;
            }
          case loadable_study:
            {
              Type type = new TypeToken<LoadableStudy>() {}.getType();
              voyageId = getVoyageId(data);
              loadableStudyStatusId = getLoadableStudyStatusId(data);
              loadableStudyStage =
                  bindDataToEntity(
                      new LoadableStudy(),
                      type,
                      LoadableStudyTables.LOADABLE_STUDY,
                      data,
                      dataTransferStage.getId(),
                      "voyage_xid");
              break;
            }
          case comingle_cargo:
            {
              Type type = new TypeToken<ArrayList<CommingleCargo>>() {}.getType();
              commingleCargoStage =
                  bindDataToEntity(
                      new CommingleCargo(),
                      type,
                      LoadableStudyTables.COMINGLE_CARGO,
                      data,
                      dataTransferStage.getId(),
                      null);
              break;
            }
          case loadable_study_port_rotation:
            {
              Type type =
                  new TypeToken<ArrayList<LoadableStudyPortRotationCommunication>>() {}.getType();
              loadableStudyPortRotationStageCommunication =
                  bindDataToEntity(
                      new LoadableStudyPortRotation(),
                      type,
                      LoadableStudyTables.LOADABLE_STUDY_PORT_ROTATION,
                      data,
                      dataTransferStage.getId(),
                      "operation_xid");
              break;
            }
          case on_hand_quantity:
            {
              Type type = new TypeToken<ArrayList<OnHandQuantity>>() {}.getType();
              onHandQuantityStage =
                  bindDataToEntity(
                      new OnHandQuantity(),
                      type,
                      LoadableStudyTables.ON_HAND_QUANTITY,
                      data,
                      dataTransferStage.getId(),
                      "port_rotation_xid");
              break;
            }
          case on_board_quantity:
            {
              Type type = new TypeToken<ArrayList<OnBoardQuantity>>() {}.getType();
              onBoardQuantityStage =
                  bindDataToEntity(
                      new OnBoardQuantity(),
                      type,
                      LoadableStudyTables.ON_BOARD_QUANTITY,
                      data,
                      dataTransferStage.getId(),
                      null);
              break;
            }
          case loadable_quantity:
            {
              Type type = new TypeToken<ArrayList<LoadableQuantity>>() {}.getType();
              loadableQuantityStage =
                  bindDataToEntity(
                      new LoadableQuantity(),
                      type,
                      LoadableStudyTables.LOADABLE_QUANTITY,
                      data,
                      dataTransferStage.getId(),
                      "port_rotation_xid");
              break;
            }
          case synoptical_table:
            {
              Type type = new TypeToken<ArrayList<SynopticalTable>>() {}.getType();
              synopticalTableStage =
                  bindDataToEntity(
                      new SynopticalTable(),
                      type,
                      LoadableStudyTables.SYNOPTICAL_TABLE,
                      data,
                      dataTransferStage.getId(),
                      "port_rotation_xid");
              break;
            }
          case json_data:
            {
              Type type = new TypeToken<ArrayList<JsonData>>() {}.getType();
              jsonDataStage =
                  bindDataToEntity(
                      new JsonData(),
                      type,
                      LoadableStudyTables.JSON_DATA,
                      data,
                      dataTransferStage.getId(),
                      "json_type_xid");
              break;
            }
          case loadable_study_algo_status:
            {
              Type type = new TypeToken<LoadableStudyAlgoStatus>() {}.getType();
              loadableStudyAlgoStatusStage =
                  bindDataToEntity(
                      new LoadableStudyAlgoStatus(),
                      type,
                      LoadableStudyTables.LOADABLE_STUDY_ALGO_STATUS,
                      data,
                      dataTransferStage.getId(),
                      "loadable_study_status");
              break;
            }
          case loadable_pattern:
            {
              Type type = new TypeToken<ArrayList<LoadablePattern>>() {}.getType();
              loadablePatternStage =
                  bindDataToEntity(
                      new LoadablePattern(),
                      type,
                      LoadableStudyTables.LOADABLE_PATTERN,
                      data,
                      dataTransferStage.getId(),
                      "loadablestudy_xid");
              break;
            }
          case algo_error_heading:
            {
              Type type = new TypeToken<ArrayList<AlgoErrorHeading>>() {}.getType();
              algoErrorHeadingStage =
                  bindDataToEntity(
                      new AlgoErrorHeading(),
                      type,
                      LoadableStudyTables.ALGO_ERROR_HEADING,
                      data,
                      dataTransferStage.getId(),
                      "loadable_pattern_xid");
              break;
            }
          case algo_errors:
            {
              Type type = new TypeToken<ArrayList<AlgoErrors>>() {}.getType();
              algoErrorsStage =
                  bindDataToEntity(
                      new AlgoErrors(),
                      type,
                      LoadableStudyTables.ALGO_ERRORS,
                      data,
                      dataTransferStage.getId(),
                      "error_heading_xid");
              break;
            }
          case loadable_plan_constraints:
            {
              Type type = new TypeToken<ArrayList<LoadablePlanConstraints>>() {}.getType();
              loadablePlanConstraintsStage =
                  bindDataToEntity(
                      new LoadablePlanConstraints(),
                      type,
                      LoadableStudyTables.LOADABLE_PLAN_CONSTRAINTS,
                      data,
                      dataTransferStage.getId(),
                      "loadable_pattern_xid");
              break;
            }
          case loadable_plan_quantity:
            {
              Type type = new TypeToken<ArrayList<LoadablePlanQuantity>>() {}.getType();
              loadablePlanQuantityStage =
                  bindDataToEntity(
                      new LoadablePlanQuantity(),
                      type,
                      LoadableStudyTables.LOADABLE_PLAN_QUANTITY,
                      data,
                      dataTransferStage.getId(),
                      "loadable_pattern_xid");
              break;
            }
          case loadable_plan_commingle_details:
            {
              Type type = new TypeToken<ArrayList<LoadablePlanCommingleDetails>>() {}.getType();
              loadablePlanCommingleDetailsStage =
                  bindDataToEntity(
                      new LoadablePlanCommingleDetails(),
                      type,
                      LoadableStudyTables.LOADABLE_PLAN_COMMINGLE_DETAILS,
                      data,
                      dataTransferStage.getId(),
                      "loadable_pattern_xid");
              break;
            }
          case loadable_pattern_cargo_topping_off_sequence:
            {
              Type type =
                  new TypeToken<ArrayList<LoadablePatternCargoToppingOffSequence>>() {}.getType();
              loadablePatternCargoToppingOffSequenceStage =
                  bindDataToEntity(
                      new LoadablePatternCargoToppingOffSequence(),
                      type,
                      LoadableStudyTables.LOADABLE_PATTERN_CARGO_TOPPING_OFF_SEQUENCE,
                      data,
                      dataTransferStage.getId(),
                      "loadable_pattern_xid");
              break;
            }
          case loadable_plan_stowage_details:
            {
              Type type = new TypeToken<ArrayList<LoadablePlanStowageDetails>>() {}.getType();
              loadablePlanStowageDetailsStage =
                  bindDataToEntity(
                      new LoadablePlanStowageDetails(),
                      type,
                      LoadableStudyTables.LOADABLE_PLAN_STOWAGE_DETAILS,
                      data,
                      dataTransferStage.getId(),
                      "loadable_pattern_xid");
              break;
            }
          case loadable_plan_ballast_details:
            {
              Type type = new TypeToken<ArrayList<LoadablePlanBallastDetails>>() {}.getType();
              loadablePlanBallastDetailsStage =
                  bindDataToEntity(
                      new LoadablePlanBallastDetails(),
                      type,
                      LoadableStudyTables.LOADABLE_PLAN_BALLAST_DETAILS,
                      data,
                      dataTransferStage.getId(),
                      "loadable_pattern_xid");
              break;
            }
          case loadable_plan_commingle_details_portwise:
            {
              Type type =
                  new TypeToken<ArrayList<LoadablePlanComminglePortwiseDetails>>() {}.getType();
              loadablePlanComminglePortwiseDetailsStage =
                  bindDataToEntity(
                      new LoadablePlanComminglePortwiseDetails(),
                      type,
                      LoadableStudyTables.LOADABLE_PLAN_COMMINGLE_DETAILS_PORTWISE,
                      data,
                      dataTransferStage.getId(),
                      "loadable_pattern_xid");
              break;
            }
          case cargo_nomination:
            {
              Type type = new TypeToken<ArrayList<CargoNomination>>() {}.getType();
              cargoNominationStage =
                  bindDataToEntity(
                      new CargoNomination(),
                      type,
                      LoadableStudyTables.CARGO_NOMINATION,
                      data,
                      dataTransferStage.getId(),
                      null);
              break;
            }
          case cargo_nomination_operation_details:
            {
              Type type = new TypeToken<ArrayList<CargoNominationPortDetails>>() {}.getType();
              cargoNominationOperationDetailsStage =
                  bindDataToEntity(
                      new CargoNominationPortDetails(),
                      type,
                      LoadableStudyTables.CARGO_NOMINATION_OPERATION_DETAILS,
                      data,
                      dataTransferStage.getId(),
                      "cargo_nomination_xid");
              break;
            }
          case communication_status_update:
            {
              Type type = new TypeToken<ArrayList<LoadableStudyCommunicationStatus>>() {}.getType();
              loadableStudyCommunicationStatusStage =
                  bindDataToEntity(
                      new LoadableStudyCommunicationStatus(),
                      type,
                      LoadableStudyTables.COMMUNICATION_STATUS_UPDATE,
                      data,
                      dataTransferStage.getId(),
                      null);
              break;
            }
          case stability_parameters:
            {
              Type type = new TypeToken<ArrayList<StabilityParameters>>() {}.getType();
              stabilityParametersStage =
                  bindDataToEntity(
                      new StabilityParameters(),
                      type,
                      LoadableStudyTables.STABILITY_PARAMETERS,
                      data,
                      dataTransferStage.getId(),
                      "loadable_pattern_xid");
              break;
            }
          case loadable_pattern_cargo_details:
            {
              Type type = new TypeToken<ArrayList<LoadablePatternCargoDetails>>() {}.getType();
              loadablePatternCargoDetailsStage =
                  bindDataToEntity(
                      new LoadablePatternCargoDetails(),
                      type,
                      LoadableStudyTables.LOADABLE_PATTERN_CARGO_DETAILS,
                      data,
                      dataTransferStage.getId(),
                      null);
              break;
            }
          case loadable_plan_stowage_ballast_details:
            {
              Type type =
                  new TypeToken<ArrayList<LoadablePlanStowageBallastDetails>>() {}.getType();
              loadablePlanStowageBallastDetailsStage =
                  bindDataToEntity(
                      new LoadablePlanStowageBallastDetails(),
                      type,
                      LoadableStudyTables.LOADABLE_PLAN_STOWAGE_BALLAST_DETAILS,
                      data,
                      dataTransferStage.getId(),
                      "loadable_plan_xid");
              break;
            }
          case loadicator_data_for_synoptical_table:
            {
              Type type = new TypeToken<ArrayList<SynopticalTableLoadicatorData>>() {}.getType();
              synopticalTableLoadicatorDataStage =
                  bindDataToEntity(
                      new SynopticalTableLoadicatorData(),
                      type,
                      LoadableStudyTables.LOADICATOR_DATA_FOR_SYNOPTICAL_TABLE,
                      data,
                      dataTransferStage.getId(),
                      "synoptical_table_xid");
              break;
            }
          case cow_history:
            {
              Type type = new TypeToken<ArrayList<CowHistory>>() {}.getType();
              cowHistoryStage =
                  bindDataToEntity(
                      new CowHistory(),
                      type,
                      LoadableStudyTables.COW_HISTORY,
                      data,
                      dataTransferStage.getId(),
                      null);
              break;
            }
          case discharge_quantity_cargo_details:
            {
              Type type =
                  new TypeToken<
                      ArrayList<DischargePatternQuantityCargoPortwiseDetails>>() {}.getType();
              dischargePatternQuantityCargoPortwiseDetailsStage =
                  bindDataToEntity(
                      new DischargePatternQuantityCargoPortwiseDetails(),
                      type,
                      LoadableStudyTables.DISCHARGE_QUANTITY_CARGO_DETAILS,
                      data,
                      dataTransferStage.getId(),
                      null);
              break;
            }
          case loadable_study_rules:
            {
              Type type = new TypeToken<ArrayList<LoadableStudyRules>>() {}.getType();
              loadableStudyRulesStage =
                  bindDataToEntity(
                      new LoadableStudyRules(),
                      type,
                      LoadableStudyTables.LOADABLE_STUDY_RULES,
                      data,
                      dataTransferStage.getId(),
                      "loadable_study_xid");
              break;
            }
          case loadable_study_rule_input:
            {
              Type type = new TypeToken<ArrayList<LoadableStudyRuleInput>>() {}.getType();
              loadableStudyRuleInputsStage =
                  bindDataToEntity(
                      new LoadableStudyRuleInput(),
                      type,
                      LoadableStudyTables.LOADABLE_STUDY_RULE_INPUT,
                      data,
                      dataTransferStage.getId(),
                      "loadable_study_rule_xid");
              break;
            }
          case loadable_plan_comments:
            {
              Type type = new TypeToken<ArrayList<LoadablePlanComments>>() {}.getType();
              loadablePlanCommentsStage =
                  bindDataToEntity(
                      new LoadablePlanComments(),
                      type,
                      LoadableStudyTables.LOADABLE_PLAN_COMMENTS,
                      data,
                      dataTransferStage.getId(),
                      "loadable_pattern_xid");
              break;
            }
          case loadable_plan_stowage_details_temp:
            {
              Type type = new TypeToken<ArrayList<LoadablePlanStowageDetailsTemp>>() {}.getType();
              loadablePlanStowageDetailsTempStage =
                  bindDataToEntity(
                      new LoadablePlanStowageDetailsTemp(),
                      type,
                      LoadableStudyTables.LOADABLE_PLAN_STOWAGE_DETAILS_TEMP,
                      data,
                      dataTransferStage.getId(),
                      "stowage_details_xid",
                      "ballast_details_xid",
                      "loadable_pattern_xid",
                      "loadable_plan_commingle_details_xid");
              break;
            }
          case loadable_pattern_algo_status:
            {
              Type type = new TypeToken<LoadablePatternAlgoStatus>() {}.getType();
              loadablePatternAlgoStatusStage =
                  bindDataToEntity(
                      new LoadablePatternAlgoStatus(),
                      type,
                      LoadableStudyTables.LOADABLE_PATTERN_ALGO_STATUS,
                      data,
                      dataTransferStage.getId(),
                      "loadabale_pattern_xid",
                      "loadable_study_status");
              break;
            }
        }
      }

      // Save all -save order should not be changed
      try {
        saveVoyage();
        saveLoadableStudy();
        saveCargoNomination();
        saveCargoNominationOperationDetails();
        saveCommingleCargo();
        saveLoadableStudyPortRotation();
        saveOnHandQuantity();
        saveOnBoardQuantity();
        saveLoadableQuantity();
        saveSynopticalTable();
        saveJsonData();
        saveLoadableStudyAlgoStatus();
        saveLoadablePattern();
        saveAlgoErrorHeading();
        saveAlgoErrors();
        saveLoadablePlanConstraints();
        saveLoadablePlanQuantity();
        saveLoadablePlanCommingleDetails();
        saveLoadablePatternCargoToppingOffSequence();
        saveLoadablePlanStowageDetails();
        saveLoadablePlanBallastDetails();
        saveLoadablePlanCommingleDetailsPortwise();
        saveStabilityParameter();
        saveLoadablePatternCargoDetails();
        saveLoadablePlanStowageBallastDetails();
        saveSynopticalTableLoadicatorData();
        saveCowHistory();
        saveDischargePatternQuantityCargoPortwiseDetails();
        saveLoadableStudyRules();
        saveLoadableStudyRuleInputs();
        saveLoadablePlanComments();
        saveLoadablePlanStowageDetailsTemp();
        saveLoadablePatternAlgoStatus();
        saveCommunicationStatusUpdate(processGroupId);
      } catch (ResourceAccessException e) {
        updateStatusInExceptionCase(
            idMap.get(current_table_name), processId, retryStatus, e.getMessage());
      } catch (Exception e) {
        updateStatusInExceptionCase(
            idMap.get(current_table_name),
            processId,
            StagingStatus.FAILED.getStatus(),
            e.getMessage());
      }
      loadableStudyStagingService.updateStatusCompletedForProcessId(
          processId, StagingStatus.COMPLETED.getStatus());
      log.info("updated status to completed for processId:" + processId);
      // Generate pattern with communicated data at shore
      if (CPDSS_BUILD_ENV_SHORE.equals(env)) {
        try {
          if (processGroupId.equals(MessageTypes.LOADABLESTUDY.getMessageType())) {
            com.cpdss.common.generated.LoadableStudy.AlgoRequest algoRequest =
                com.cpdss.common.generated.LoadableStudy.AlgoRequest.newBuilder()
                    .setLoadableStudyId(loadableStudyStage.getId())
                    .build();
            com.cpdss.common.generated.LoadableStudy.AlgoReply.Builder algoReply =
                com.cpdss.common.generated.LoadableStudy.AlgoReply.newBuilder();
            loadablePatternService.generateLoadablePatterns(algoRequest, algoReply);
            log.info("Invoking generateLoadablePatterns method.");
          } else if (processGroupId.equals(MessageTypes.VALIDATEPLAN.getMessageType())) {
            com.cpdss.common.generated.LoadableStudy.LoadablePlanDetailsRequest algoRequest =
                com.cpdss.common.generated.LoadableStudy.LoadablePlanDetailsRequest.newBuilder()
                    .setLoadablePatternId(loadablePatternStage.get(0).getId())
                    .build();
            com.cpdss.common.generated.LoadableStudy.AlgoReply.Builder algoReply =
                com.cpdss.common.generated.LoadableStudy.AlgoReply.newBuilder();
            loadablePlanService.validateLoadablePlan(algoRequest, algoReply);
            log.info("Invoking validateLoadablePlan method.");
          } else if (processGroupId.equals(MessageTypes.DISCHARGESTUDY.getMessageType())) {
            com.cpdss.common.generated.LoadableStudy.AlgoRequest algoRequest =
                com.cpdss.common.generated.LoadableStudy.AlgoRequest.newBuilder()
                    .setLoadableStudyId(loadableStudyStage.getId())
                    .build();
            com.cpdss.common.generated.LoadableStudy.AlgoReply.Builder algoReply =
                com.cpdss.common.generated.LoadableStudy.AlgoReply.newBuilder();
            generateDischargeStudyJson.generateDischargePatterns(algoRequest, algoReply);
            log.info("Invoking generateDischargePatterns method in Discharge Study.");
          }
        } catch (IOException e) {
          log.error("Exception calling generate loadable patterns.", e);
          throw new GenericServiceException(
              "Exception calling generate loadable patterns",
              CommonErrorCodes.E_GEN_INTERNAL_ERR,
              HttpStatusCode.INTERNAL_SERVER_ERROR,
              e);
        }
      }
    }
  }

  private Long getVoyageStatus(String json) {
    JsonArray jsonArray = JsonParser.parseString(json).getAsJsonArray();
    return jsonArray.get(0).getAsJsonObject().get("voyage_status").getAsLong();
  }
  // endregion

  // region Save Methods

  /** Method to save loadable study */
  private void saveLoadableStudy() {
    current_table_name = LoadableStudyTables.VOYAGE.getTable();
    if (loadableStudyStage != null) {
      Optional<LoadableStudy> optionalLoadableStudy =
          loadableStudyRepository.findById(loadableStudyStage.getId());
      loadableStudyStage.setVersion(optionalLoadableStudy.map(EntityDoc::getVersion).orElse(null));
      loadableStudyStage.setVoyage(voyageStage);
      loadableStudyStage.setLoadableStudyStatus(
          loadableStudyStatusRepository.findById(loadableStudyStatusId).orElse(null));

      loadableStudyStage = loadableStudyRepository.save(loadableStudyStage);
      log.info("Communication ####### Loadable Study saved with id:" + loadableStudyStage.getId());
    }
  }

  /** Method to save voyage */
  private void saveVoyage() {
    current_table_name = LoadableStudyTables.VOYAGE.getTable();
    if (null == voyageStage) {
      log.info("Communication XXXXXXX  Voyage is empty");
      voyageStage = voyageRepository.findById(voyageId).orElse(null);
      return;
    }

    Optional<Voyage> optionalVoyage = voyageRepository.findById(voyageStage.getId());
    voyageStage.setVersion(optionalVoyage.map(EntityDoc::getVersion).orElse(null));

    Optional<VoyageStatus> voyageStatus = voyageStatusRepository.findById(voyageStatusId);
    if (voyageStatus.isPresent()) {
      voyageStage.setVoyageStatus(voyageStatus.get());
    }
    voyageStage = voyageRepository.save(voyageStage);
    log.info("Communication #######  Voyage saved with id:" + voyageStage.getId());
  }

  /** Method to save commingle cargo */
  private void saveCommingleCargo() {
    current_table_name = LoadableStudyTables.COMINGLE_CARGO.getTable();
    if (null == commingleCargoStage || commingleCargoStage.isEmpty()) {
      log.info("Communication XXXXXXX  CommingleCargo is empty");
      return;
    }

    commingleCargoStage.forEach(
        commingleCargo -> {
          Optional<CommingleCargo> optionalCommingleCargo =
              commingleCargoRepository.findById(commingleCargo.getId());
          Long version = optionalCommingleCargo.map(EntityDoc::getVersion).orElse(null);
          commingleCargo.setVersion(version);
        });
    commingleCargoStage = commingleCargoRepository.saveAll(commingleCargoStage);
    log.info("Communication #######  CommingleCargo saved with id:" + commingleCargoStage);
  }

  /** Method to save cargo nomination */
  private void saveCargoNomination() {
    current_table_name = LoadableStudyTables.CARGO_NOMINATION.getTable();
    if (null == cargoNominationStage || cargoNominationStage.isEmpty()) {
      log.info("Communication XXXXXXX  CargoNomination is empty");
      return;
    }

    cargoNominationStage.forEach(
        cargoNomination -> {
          Optional<CargoNomination> optionalCargoNomination =
              cargoNominationRepository.findById(cargoNomination.getId());
          cargoNomination.setVersion(
              optionalCargoNomination.map(EntityDoc::getVersion).orElse(null));
        });
    cargoNominationStage = cargoNominationRepository.saveAll(cargoNominationStage);
    log.info("Communication #######  CargoNomination saved");
  }

  /** Method to save cargo nomination operation details */
  private void saveCargoNominationOperationDetails() {
    current_table_name = LoadableStudyTables.CARGO_NOMINATION_OPERATION_DETAILS.getTable();
    if (null == cargoNominationOperationDetailsStage
        || cargoNominationOperationDetailsStage.isEmpty()) {
      log.info("Communication XXXXXXX  CargoNomination Operation Details is empty");
      return;
    }

    cargoNominationOperationDetailsStage.forEach(
        cargoNominationOperationDetails -> {
          Optional<CargoNominationPortDetails> optionalCargoNominationOperationDetails =
              cargoNominationOperationDetailsRepository.findById(
                  cargoNominationOperationDetails.getId());
          cargoNominationOperationDetails.setVersion(
              optionalCargoNominationOperationDetails.map(EntityDoc::getVersion).orElse(null));

          Optional<CargoNomination> optionalCargoNomination =
              cargoNominationRepository.findById(
                  cargoNominationOperationDetails.getCommunicationRelatedEntityId());
          optionalCargoNomination.ifPresent(cargoNominationOperationDetails::setCargoNomination);
        });
    cargoNominationOperationDetailsStage =
        cargoNominationOperationDetailsRepository.saveAll(cargoNominationOperationDetailsStage);
    log.info("Communication #######  CargoNomination Operation Details saved");
  }

  /** Method to save loadable study port rotation */
  private void saveLoadableStudyPortRotation() {
    current_table_name = LoadableStudyTables.LOADABLE_STUDY_PORT_ROTATION.getTable();
    if (null == loadableStudyPortRotationStageCommunication
        || loadableStudyPortRotationStageCommunication.isEmpty()) {
      log.info("Communication XXXXXXX  LoadableStudyPortRotation is empty");
      return;
    }
    for (LoadableStudyPortRotationCommunication lsprStage :
        loadableStudyPortRotationStageCommunication) {
      Optional<LoadableStudyPortRotationCommunication> loadableStudyPortRotation =
          loadableStudyPortRotationCommuncationRepository.findById(lsprStage.getId());
      lsprStage.setVersion(null);
      loadableStudyPortRotation.ifPresent(
          studyPortRotation -> lsprStage.setVersion(studyPortRotation.getVersion()));
      lsprStage.setLoadableStudy(loadableStudyStage);
      Optional<CargoOperation> cargoOperationOpt =
          cargoOperationRepository.findById(lsprStage.getCommunicationRelatedEntityId());
      cargoOperationOpt.ifPresent(lsprStage::setOperation);
    }
    loadableStudyPortRotationCommuncationRepository.saveAll(
        loadableStudyPortRotationStageCommunication);
    loadableStudyPortRotationStage =
        loadableStudyPortRotationRepository.findByLoadableStudy(loadableStudyStage);
    log.info("Communication #######  LoadableStudyPortRotation saved ");
  }

  /** Method to save on hand quantity */
  private void saveOnHandQuantity() {
    current_table_name = LoadableStudyTables.ON_HAND_QUANTITY.getTable();
    if (null == onHandQuantityStage || onHandQuantityStage.isEmpty()) {
      log.info("Communication XXXXXXX  OnHandQuantity is empty");
      return;
    }
    for (OnHandQuantity ohqStage : onHandQuantityStage) {
      ohqStage.setVersion(null);
      ohqStage.setLoadableStudy(loadableStudyStage);
      Optional<OnHandQuantity> ohq = onHandQuantityRepository.findById(ohqStage.getId());
      ohq.ifPresent(onHandQuantity -> ohqStage.setVersion(onHandQuantity.getVersion()));
      for (LoadableStudyPortRotation lspr : loadableStudyPortRotationStage) {
        if (Objects.equals(ohqStage.getCommunicationRelatedEntityId(), lspr.getId())) {
          ohqStage.setPortRotation(lspr);
        }
      }
    }
    onHandQuantityStage = onHandQuantityRepository.saveAll(onHandQuantityStage);
    log.info("Communication #######  OnHandQuantity saved with id:" + onHandQuantityStage);
  }

  /** Method to save on board quantity */
  private void saveOnBoardQuantity() {
    current_table_name = LoadableStudyTables.ON_BOARD_QUANTITY.getTable();
    if (null == onBoardQuantityStage || onBoardQuantityStage.isEmpty()) {
      log.info("Communication XXXXXXX  onBoardQuantity is empty");
      return;
    }
    for (OnBoardQuantity obqStage : onBoardQuantityStage) {
      obqStage.setVersion(null);
      obqStage.setLoadableStudy(loadableStudyStage);
      Optional<OnBoardQuantity> ohq = onBoardQuantityRepository.findById(obqStage.getId());
      ohq.ifPresent(onBoardQuantity -> obqStage.setVersion(onBoardQuantity.getVersion()));
    }

    onBoardQuantityStage = onBoardQuantityRepository.saveAll(onBoardQuantityStage);
    log.info("Communication #######  onBoardQuantity saved with id:" + onBoardQuantityStage);
  }

  /** Method to save loadable quantity */
  private void saveLoadableQuantity() {
    current_table_name = LoadableStudyTables.LOADABLE_QUANTITY.getTable();
    if (null == loadableQuantityStage || loadableQuantityStage.isEmpty()) {
      log.info("Communication XXXXXXX  loadableQuantity is empty");
      return;
    }
    for (LoadableQuantity lqStage : loadableQuantityStage) {
      lqStage.setVersion(null);
      lqStage.setLoadableStudyXId(loadableStudyStage);
      Optional<LoadableQuantity> lq = loadableQuantityRepository.findById(lqStage.getId());
      lq.ifPresent(loadableQuantity -> lqStage.setVersion(loadableQuantity.getVersion()));
      for (LoadableStudyPortRotation lspr : loadableStudyPortRotationStage) {
        if (Objects.equals(lqStage.getCommunicationRelatedEntityId(), lspr.getId())) {
          lqStage.setLoadableStudyPortRotation(lspr);
        }
      }
    }

    loadableQuantityStage = loadableQuantityRepository.saveAll(loadableQuantityStage);
    log.info("Communication #######  loadableQuantity saved with id:" + loadableQuantityStage);
  }

  /** Method to save synoptical table */
  private void saveSynopticalTable() {
    current_table_name = LoadableStudyTables.SYNOPTICAL_TABLE.getTable();
    if (null == synopticalTableStage || synopticalTableStage.isEmpty()) {
      log.info("Communication XXXXXXX  synopticalTable is empty");
      return;
    }
    for (SynopticalTable stStage : synopticalTableStage) {
      stStage.setVersion(null);
      stStage.setLoadableStudyXId(loadableStudyStage.getId());
      Optional<SynopticalTable> st = synopticalTableRepository.findById(stStage.getId());
      st.ifPresent(synopticalTable -> stStage.setVersion(synopticalTable.getVersion()));

      Optional<LoadableStudyPortRotation> loadableStudyPortRotationOpt =
          loadableStudyPortRotationRepository.findById(stStage.getCommunicationRelatedEntityId());
      loadableStudyPortRotationOpt.ifPresent(stStage::setLoadableStudyPortRotation);
    }

    synopticalTableStage = synopticalTableRepository.saveAll(synopticalTableStage);
    log.info("Communication #######  synopticalTable saved with id:" + synopticalTableStage);
  }

  /** Method to save json data */
  private void saveJsonData() {
    current_table_name = LoadableStudyTables.JSON_DATA.getTable();
    if (null == jsonDataStage || jsonDataStage.isEmpty()) {
      log.info("Communication XXXXXXX  JSON_DATA is empty");
      return;
    }
    jsonDataStage.forEach(
        jsonData -> {
          Optional<JsonType> jsonType =
              jsonTypeRepository.findById(jsonData.getCommunicationRelatedEntityId());
          if (jsonType.isPresent()) {
            jsonData.setJsonTypeXId(jsonType.get());
            Optional<JsonData> jData = jsonDataRepository.findById(jsonData.getId());
            jsonData.setVersion(jData.map(EntityDoc::getVersion).orElse(null));
          } else {
            log.info(
                "Communication XXXXXXX  JsonData is not saved , Json Type is not found : "
                    + jsonData.getCommunicationRelatedEntityId());
          }
        });
    jsonDataStage = jsonDataRepository.saveAll(jsonDataStage);
    log.info("Communication #######  JsonData saved");
  }

  /** Method to save loadable study algo status */
  private void saveLoadableStudyAlgoStatus() {
    current_table_name = LoadableStudyTables.LOADABLE_STUDY_ALGO_STATUS.getTable();
    if (null == loadableStudyAlgoStatusStage) {
      log.info("Communication XXXXXXX  LOADABLE_STUDY_ALGO_STATUS is empty");
      return;
    }
    Optional<LoadableStudyStatus> loadableStudyStatus =
        loadableStudyStatusRepository.findById(
            loadableStudyAlgoStatusStage.getCommunicationRelatedEntityId());
    if (loadableStudyStatus.isPresent()) {
      loadableStudyAlgoStatusRepository
          .findByLoadableStudyId(loadableStudyStage.getId())
          .ifPresentOrElse(
              loadableStudyAlgoStatus -> {
                loadableStudyAlgoStatus.setProcessId(loadableStudyAlgoStatusStage.getProcessId());
                loadableStudyAlgoStatusStage = loadableStudyAlgoStatus;
              },
              () -> {
                loadableStudyAlgoStatusStage.setVersion(null);
                loadableStudyAlgoStatusStage.setLoadableStudy(loadableStudyStage);
              });
      loadableStudyAlgoStatusStage.setGeneratedFromShore(true);
      loadableStudyAlgoStatusStage.setLoadableStudyStatus(loadableStudyStatus.get());
      loadableStudyAlgoStatusStage =
          loadableStudyAlgoStatusRepository.save(loadableStudyAlgoStatusStage);
      log.info(
          "Communication #######  loadableStudyAlgoStatus saved with id:"
              + loadableStudyAlgoStatusStage.getId());

    } else {
      log.info(
          "Communication XXXXXXX  loadableStudyAlgoStatus is not saved , loadableStudyStatus is not found : "
              + loadableStudyAlgoStatusStage.getCommunicationRelatedEntityId());
    }
  }

  /** Method to save loadable plan */
  private void saveLoadablePlan() {
    current_table_name = LoadableStudyTables.LOADABLE_PLAN.getTable();
    if (null == loadablePlanStage || loadablePlanStage.isEmpty()) {
      log.info("Communication XXXXXXX  LoadablePlan is empty");
      return;
    }
    for (LoadablePlan lPlan : loadablePlanStage) {
      Optional<LoadablePlan> loadablePlanOptional = loadablePlanRepository.findById(lPlan.getId());
      lPlan.setVersion(loadablePlanOptional.map(EntityDoc::getVersion).orElse(null));
      lPlan.setLoadablePatternXId(
          getLoadablePattern(lPlan.getCommunicationRelatedEntityId()).orElse(null));

      loadablePlanRepository.saveAll(loadablePlanStage);
      log.info("Communication #######  LoadablePlan saved");
    }
  }

  /** Method to save loadable pattern */
  private void saveLoadablePattern() {
    current_table_name = LoadableStudyTables.LOADABLE_PATTERN.getTable();
    if (null == loadablePatternStage || loadablePatternStage.isEmpty()) {
      log.info("Communication XXXXXXX  loadablePattern is empty");
      return;
    }
    for (LoadablePattern lp : loadablePatternStage) {
      Optional<LoadablePattern> loadablePatternOptional =
          loadablePatternRepository.findById(lp.getId());

      // Set loadable study
      Optional.ofNullable(loadableStudyStage)
          .ifPresentOrElse(
              loadableStudy -> lp.setLoadableStudy(loadableStudyStage),
              () ->
                  lp.setLoadableStudy(
                      loadableStudyRepository
                          .findById(lp.getCommunicationRelatedEntityId())
                          .orElse(null)));
      lp.setVersion(loadablePatternOptional.map(EntityDoc::getVersion).orElse(null));
    }

    loadablePatternStage = loadablePatternRepository.saveAll(loadablePatternStage);
    log.info("Communication #######  loadablePatterns saved");
  }

  /** Method to save algo error heading */
  private void saveAlgoErrorHeading() {
    current_table_name = LoadableStudyTables.ALGO_ERROR_HEADING.getTable();
    if (null == algoErrorHeadingStage || algoErrorHeadingStage.isEmpty()) {
      log.info("Communication XXXXXXX  AlgoErrorHeading  is empty");
      return;
    }
    for (AlgoErrorHeading arStage : algoErrorHeadingStage) {
      log.info("Communication +++++++  AlgoErrorHeading  id : " + arStage.getId());
      Optional<AlgoErrorHeading> algoErrorHeadingOptional =
          algoErrorHeadingRepository.findById(arStage.getId());
      arStage.setVersion(algoErrorHeadingOptional.map(EntityDoc::getVersion).orElse(null));
      log.info(
          "Communication +++++++  AlgoErrorHeading  CommunicationRelatedEntityId : "
              + arStage.getCommunicationRelatedEntityId());
      if (arStage.getCommunicationRelatedEntityId() != null) {
        arStage.setLoadablePattern(
            getLoadablePattern(arStage.getCommunicationRelatedEntityId()).orElse(null));
      } else {
        arStage.setLoadableStudy(loadableStudyStage);
      }
    }

    algoErrorHeadingStage = algoErrorHeadingRepository.saveAll(algoErrorHeadingStage);
    log.info("Communication #######  AlgoErrorHeading  saved");
  }

  /** Method to save algo errors */
  private void saveAlgoErrors() {
    current_table_name = LoadableStudyTables.ALGO_ERRORS.getTable();
    if (null == algoErrorsStage || algoErrorsStage.isEmpty()) {
      log.info("Communication XXXXXXX  ALGO_ERRORS  is empty");
      return;
    }
    for (AlgoErrors ae : algoErrorsStage) {
      Optional<AlgoErrors> algoErrorsOptional = algoErrorsRepository.findById(ae.getId());
      ae.setVersion(algoErrorsOptional.map(EntityDoc::getVersion).orElse(null));

      for (AlgoErrorHeading aeh : algoErrorHeadingStage) {
        if (Objects.equals(aeh.getId(), ae.getCommunicationRelatedEntityId())) {
          ae.setAlgoErrorHeading(aeh);
        }
      }
    }
    algoErrorsStage = algoErrorsRepository.saveAll(algoErrorsStage);
    log.info("Communication #######  AlgoErrors  saved");
  }

  /** Method to save loadable plan constraints */
  private void saveLoadablePlanConstraints() {
    current_table_name = LoadableStudyTables.LOADABLE_PLAN_CONSTRAINTS.getTable();
    if (null == loadablePlanConstraintsStage || loadablePlanConstraintsStage.isEmpty()) {
      log.info("Communication XXXXXXX  LoadablePlanConstraints is empty");
      return;
    }
    for (LoadablePlanConstraints lpConstraint : loadablePlanConstraintsStage) {
      Optional<LoadablePlanConstraints> loadablePlanConstraintsOptional =
          loadablePlanConstraintsRespository.findById(lpConstraint.getId());
      lpConstraint.setVersion(
          loadablePlanConstraintsOptional.map(EntityDoc::getVersion).orElse(null));
      lpConstraint.setLoadablePattern(
          getLoadablePattern(lpConstraint.getCommunicationRelatedEntityId()).orElse(null));
    }

    loadablePlanConstraintsStage =
        loadablePlanConstraintsRespository.saveAll(loadablePlanConstraintsStage);
    log.info("Communication #######  LoadablePlanConstraints are saved");
  }

  /** Method to save loadable plan quantity */
  private void saveLoadablePlanQuantity() {
    current_table_name = LoadableStudyTables.LOADABLE_PLAN_QUANTITY.getTable();
    if (null == loadablePlanQuantityStage || loadablePlanQuantityStage.isEmpty()) {
      log.info("Communication XXXXXXX  LoadablePlanQuantity is empty");
      return;
    }
    for (LoadablePlanQuantity lpQuantity : loadablePlanQuantityStage) {
      Optional<LoadablePlanQuantity> loadablePlanConstraintsOptional =
          loadablePlanQuantityRepository.findById(lpQuantity.getId());
      lpQuantity.setVersion(
          loadablePlanConstraintsOptional.map(EntityDoc::getVersion).orElse(null));
      lpQuantity.setLoadablePattern(
          getLoadablePattern(lpQuantity.getCommunicationRelatedEntityId()).orElse(null));
    }

    loadablePlanQuantityStage = loadablePlanQuantityRepository.saveAll(loadablePlanQuantityStage);
    log.info("Communication #######  LoadablePlanQuantity are saved");
  }

  /** Method to save loadable plan commingle details */
  private void saveLoadablePlanCommingleDetails() {
    current_table_name = LoadableStudyTables.LOADABLE_PLAN_COMMINGLE_DETAILS.getTable();
    if (null == loadablePlanCommingleDetailsStage || loadablePlanCommingleDetailsStage.isEmpty()) {
      log.info("Communication XXXXXXX  loadable_plan_commingle_details is empty");
      return;
    }
    // Set relations and version
    for (LoadablePlanCommingleDetails lpCommingleDetail : loadablePlanCommingleDetailsStage) {
      Optional<LoadablePlanCommingleDetails> lpCommingleDetailsOptional =
          loadablePlanCommingleDetailsRepository.findById(lpCommingleDetail.getId());
      LoadablePattern loadablePattern =
          loadablePatternRepository
              .findById(lpCommingleDetail.getCommunicationRelatedEntityId())
              .orElse(null);
      lpCommingleDetail.setLoadablePattern(loadablePattern);
      lpCommingleDetail.setVersion(
          lpCommingleDetailsOptional.map(EntityDoc::getVersion).orElse(null));
    }

    loadablePlanCommingleDetailsStage =
        loadablePlanCommingleDetailsRepository.saveAll(loadablePlanCommingleDetailsStage);
    log.info(
        "Communication #######  loadable_plan_commingle_details are saved. Entries: {}",
        loadablePlanCommingleDetailsStage.size());
  }

  /** Method to save loadable pattern cargo topping off sequence */
  private void saveLoadablePatternCargoToppingOffSequence() {
    current_table_name = LoadableStudyTables.LOADABLE_PATTERN_CARGO_TOPPING_OFF_SEQUENCE.getTable();
    if (null == loadablePatternCargoToppingOffSequenceStage
        || loadablePatternCargoToppingOffSequenceStage.isEmpty()) {
      log.info("Communication XXXXXXX  LoadablePatternCargoToppingOffSequence is empty");
      return;
    }
    for (LoadablePatternCargoToppingOffSequence lpCargoToppingOffSequence :
        loadablePatternCargoToppingOffSequenceStage) {
      Optional<LoadablePatternCargoToppingOffSequence> lpCargoToppingOffSequenceOptional =
          loadablePatternCargoToppingOffSequenceRepository.findById(
              lpCargoToppingOffSequence.getId());
      lpCargoToppingOffSequence.setVersion(
          lpCargoToppingOffSequenceOptional.map(EntityDoc::getVersion).orElse(null));
      lpCargoToppingOffSequence.setLoadablePattern(
          getLoadablePattern(lpCargoToppingOffSequence.getCommunicationRelatedEntityId())
              .orElse(null));
    }

    loadablePatternCargoToppingOffSequenceStage =
        loadablePatternCargoToppingOffSequenceRepository.saveAll(
            loadablePatternCargoToppingOffSequenceStage);
    log.info("Communication #######  LoadablePatternCargoToppingOffSequence are saved");
  }

  /** Method to save loadable plan stowage details */
  private void saveLoadablePlanStowageDetails() {
    current_table_name = LoadableStudyTables.LOADABLE_PLAN_STOWAGE_DETAILS.getTable();
    if (null == loadablePlanStowageDetailsStage || loadablePlanStowageDetailsStage.isEmpty()) {
      log.info("Communication XXXXXXX  LoadablePlanStowageDetails is empty");
      return;
    }
    for (LoadablePlanStowageDetails lpStowageDetail : loadablePlanStowageDetailsStage) {
      Optional<LoadablePlanStowageDetails> lpStowageDetailsOptional =
          loadablePlanStowageDetailsRespository.findById(lpStowageDetail.getId());
      lpStowageDetail.setVersion(lpStowageDetailsOptional.map(EntityDoc::getVersion).orElse(null));

      LoadablePlan loadablePlan =
          getLoadablePlan(lpStowageDetail.getCommunicationRelatedEntityId()).orElse(null);
      lpStowageDetail.setLoadablePlan(loadablePlan);
      LoadablePattern loadablePattern =
          getLoadablePattern(lpStowageDetail.getCommunicationRelatedEntityId()).orElse(null);
      lpStowageDetail.setLoadablePattern(loadablePattern);
    }

    loadablePlanStowageDetailsStage =
        loadablePlanStowageDetailsRespository.saveAll(loadablePlanStowageDetailsStage);
    log.info("Communication #######  LoadablePlanStowageDetails are saved");
  }

  /** Method to save loadable plan ballast details */
  private void saveLoadablePlanBallastDetails() {
    current_table_name = LoadableStudyTables.LOADABLE_PLAN_BALLAST_DETAILS.getTable();
    if (loadablePlanBallastDetailsStage == null || loadablePlanBallastDetailsStage.isEmpty()) {
      log.info("Communication XXXXXXX  LoadablePlanBallastDetails is empty");
      return;
    }
    for (LoadablePlanBallastDetails lpBallastDetail : loadablePlanBallastDetailsStage) {
      Optional<LoadablePlanBallastDetails> lpBallastDetailsOptional =
          loadablePlanBallastDetailsRepository.findById(lpBallastDetail.getId());
      lpBallastDetail.setVersion(lpBallastDetailsOptional.map(EntityDoc::getVersion).orElse(null));
      lpBallastDetail.setLoadablePattern(
          getLoadablePattern(lpBallastDetail.getCommunicationRelatedEntityId()).orElse(null));
    }

    loadablePlanBallastDetailsStage =
        loadablePlanBallastDetailsRepository.saveAll(loadablePlanBallastDetailsStage);
    log.info("Communication #######  LoadablePlanBallastDetails are saved");
  }

  /** Method to save loadable plan commingle details port-wise */
  private void saveLoadablePlanCommingleDetailsPortwise() {
    current_table_name = LoadableStudyTables.LOADABLE_PLAN_COMMINGLE_DETAILS_PORTWISE.getTable();
    if (null == loadablePlanComminglePortwiseDetailsStage
        || loadablePlanComminglePortwiseDetailsStage.isEmpty()) {
      log.info("Communication XXXXXXX  LoadablePlanComminglePortwiseDetails is empty");
      return;
    }
    for (LoadablePlanComminglePortwiseDetails lpComminglePortwiseDetail :
        loadablePlanComminglePortwiseDetailsStage) {
      Optional<LoadablePlanComminglePortwiseDetails> lpComminglePortwiseDetailsOptional =
          loadablePlanCommingleDetailsPortwiseRepository.findById(
              lpComminglePortwiseDetail.getId());
      lpComminglePortwiseDetail.setVersion(
          lpComminglePortwiseDetailsOptional.map(EntityDoc::getVersion).orElse(null));
      lpComminglePortwiseDetail.setLoadablePattern(
          getLoadablePattern(lpComminglePortwiseDetail.getCommunicationRelatedEntityId())
              .orElse(null));
    }

    loadablePlanComminglePortwiseDetailsStage =
        loadablePlanCommingleDetailsPortwiseRepository.saveAll(
            loadablePlanComminglePortwiseDetailsStage);
    log.info("Communication #######  LoadablePlanComminglePortwiseDetails are saved");
  }

  /** Method to save communication status update table */
  private void saveCommunicationStatusUpdate(String messageType) {
    if (MessageTypes.VALIDATEPLAN.getMessageType().equals(messageType)) {
      loadableStudyServiceShore.updateCommunicationStatus(
          UUID.randomUUID().toString(), null, loadablePatternStage.get(0).getId());
      log.info("Communication #######  communication_status_update table saved");
    }
  }

  /** Method to save stability parameter */
  private void saveStabilityParameter() {
    current_table_name = LoadableStudyTables.STABILITY_PARAMETERS.getTable();
    if (null == stabilityParametersStage || stabilityParametersStage.isEmpty()) {
      log.info("Communication XXXXXXX  StabilityParameters is empty");
      return;
    }
    for (StabilityParameters stabilityParameter : stabilityParametersStage) {
      Optional<StabilityParameters> stabilityParametersOptional =
          stabilityParameterRepository.findById(stabilityParameter.getId());
      stabilityParameter.setVersion(
          stabilityParametersOptional.map(EntityDoc::getVersion).orElse(null));
      stabilityParameter.setLoadablePattern(
          getLoadablePattern(stabilityParameter.getCommunicationRelatedEntityId()).orElse(null));
    }

    stabilityParameterRepository.saveAll(stabilityParametersStage);
    log.info("Communication #######  StabilityParameters are saved");
  }

  /** Method to save loadable pattern cargo details */
  private void saveLoadablePatternCargoDetails() {
    current_table_name = LoadableStudyTables.LOADABLE_PATTERN_CARGO_DETAILS.getTable();
    if (null == loadablePatternCargoDetailsStage || loadablePatternCargoDetailsStage.isEmpty()) {
      log.info("Communication XXXXXXX  LoadablePatternCargoDetails is empty");
      return;
    }
    for (LoadablePatternCargoDetails lpCargoDetail : loadablePatternCargoDetailsStage) {
      Optional<LoadablePatternCargoDetails> loadablePatternCargoDetailsOptional =
          loadablePatternCargoDetailsRepository.findById(lpCargoDetail.getId());
      lpCargoDetail.setVersion(
          loadablePatternCargoDetailsOptional.map(EntityDoc::getVersion).orElse(null));
    }

    loadablePatternCargoDetailsRepository.saveAll(loadablePatternCargoDetailsStage);
    log.info("Communication #######  LoadablePatternCargoDetails are saved");
  }

  /** Method to save loadable plan stowage ballast details */
  private void saveLoadablePlanStowageBallastDetails() {
    current_table_name = LoadableStudyTables.LOADABLE_PLAN_STOWAGE_BALLAST_DETAILS.getTable();
    if (null == loadablePlanStowageBallastDetailsStage
        || loadablePlanStowageBallastDetailsStage.isEmpty()) {
      log.info("Communication XXXXXXX  {} is empty", current_table_name);
      return;
    }
    for (LoadablePlanStowageBallastDetails lpStowageBallastDetail :
        loadablePlanStowageBallastDetailsStage) {
      Optional<LoadablePlanStowageBallastDetails> loadablePatternCargoDetailsOptional =
          loadablePlanStowageBallastDetailsRepository.findById(lpStowageBallastDetail.getId());
      lpStowageBallastDetail.setVersion(
          loadablePatternCargoDetailsOptional.map(EntityDoc::getVersion).orElse(null));
      lpStowageBallastDetail.setLoadablePlan(
          getLoadablePlan(lpStowageBallastDetail.getCommunicationRelatedEntityId()).orElse(null));
    }

    loadablePlanStowageBallastDetailsRepository.saveAll(loadablePlanStowageBallastDetailsStage);
    log.info(
        "Communication #######  {} are saved. Entries: {}",
        current_table_name,
        loadablePlanStowageBallastDetailsStage.size());
  }

  /** Method to save synoptical table loadicator data */
  private void saveSynopticalTableLoadicatorData() {
    current_table_name = LoadableStudyTables.LOADICATOR_DATA_FOR_SYNOPTICAL_TABLE.getTable();
    if (null == synopticalTableLoadicatorDataStage
        || synopticalTableLoadicatorDataStage.isEmpty()) {
      log.info("Communication XXXXXXX  SynopticalTableLoadicatorData is empty");
      return;
    }
    for (SynopticalTableLoadicatorData sTableLoadicatorData : synopticalTableLoadicatorDataStage) {
      Optional<SynopticalTableLoadicatorData> sTableLoadicatorDataOptional =
          synopticalTableLoadicatorDataRepository.findById(sTableLoadicatorData.getId());
      sTableLoadicatorData.setVersion(
          sTableLoadicatorDataOptional.map(EntityDoc::getVersion).orElse(null));
      for (SynopticalTable st : synopticalTableStage) {
        if (Objects.equals(sTableLoadicatorData.getCommunicationRelatedEntityId(), st.getId())) {
          sTableLoadicatorData.setSynopticalTable(st);
        }
      }
    }
    synopticalTableLoadicatorDataStage =
        synopticalTableLoadicatorDataRepository.saveAll(synopticalTableLoadicatorDataStage);
    log.info("Communication #######  SynopticalTableLoadicatorData are saved");
  }
  /** Method to save CowHistory table */
  private void saveCowHistory() {
    current_table_name = LoadableStudyTables.COW_HISTORY.getTable();
    if (null == cowHistoryStage || cowHistoryStage.isEmpty()) {
      log.info("Communication XXXXXXX  CowHistoryData is empty");
      return;
    }
    for (CowHistory cowHistory : cowHistoryStage) {
      Optional<CowHistory> cowHistoryOptional = cowHistoryRepository.findById(cowHistory.getId());
      cowHistory.setVersion(cowHistoryOptional.map(EntityDoc::getVersion).orElse(null));
    }
    cowHistoryRepository.saveAll(cowHistoryStage);
    log.info("Communication #######  CowHistory are saved");
  }

  /** Method to save DischargePatternQuantityCargoPortwiseDetails table */
  private void saveDischargePatternQuantityCargoPortwiseDetails() {
    current_table_name = LoadableStudyTables.DISCHARGE_QUANTITY_CARGO_DETAILS.getTable();
    if (null == dischargePatternQuantityCargoPortwiseDetailsStage
        || dischargePatternQuantityCargoPortwiseDetailsStage.isEmpty()) {
      log.info("Communication XXXXXXX  DischargePatternQuantityCargoPortwiseDetails is empty");
      return;
    }
    for (DischargePatternQuantityCargoPortwiseDetails dischargenQuantityDetails :
        dischargePatternQuantityCargoPortwiseDetailsStage) {
      Optional<DischargePatternQuantityCargoPortwiseDetails> dischargenQuantityDetailsOptional =
          dischargePatternQuantityCargoPortwiseRepository.findById(
              dischargenQuantityDetails.getId());
      dischargenQuantityDetails.setVersion(
          dischargenQuantityDetailsOptional.map(EntityDoc::getVersion).orElse(null));
    }
    dischargePatternQuantityCargoPortwiseRepository.saveAll(
        dischargePatternQuantityCargoPortwiseDetailsStage);
    log.info("Communication #######  DischargePatternQuantityCargoPortwiseDetails are saved");
  }

  /** Method to save loadable_study_rules table */
  private void saveLoadableStudyRules() {
    current_table_name = LoadableStudyTables.LOADABLE_STUDY_RULES.getTable();

    if (!isEmpty(loadableStudyRulesStage)) {
      for (LoadableStudyRules loadableStudyRules : loadableStudyRulesStage) {
        // Set detached entities
        Optional<LoadableStudyRules> loadableStudyRulesOpt =
            loadableStudyRuleRepository.findById(loadableStudyRules.getId());
        loadableStudyRules.setLoadableStudy(loadableStudyStage);

        // Set version
        loadableStudyRules.setVersion(
            loadableStudyRulesOpt.map(EntityDoc::getVersion).orElse(null));
      }

      // Save data
      loadableStudyRuleRepository.saveAll(loadableStudyRulesStage);
      log.info(
          "Communication #######  loadable_study_rules saved. Entries: {}",
          loadableStudyRulesStage.size());
    }
  }

  /**
   * Method to save loadable_study_rule_input table
   *
   * @throws GenericServiceException Exception when rule not found
   */
  private void saveLoadableStudyRuleInputs() throws GenericServiceException {
    current_table_name = LoadableStudyTables.LOADABLE_STUDY_RULE_INPUT.getTable();

    if (!isEmpty(loadableStudyRuleInputsStage)) {
      for (LoadableStudyRuleInput loadableStudyRuleInput : loadableStudyRuleInputsStage) {
        // Set detached entities
        LoadableStudyRules loadableStudyRule =
            loadableStudyRuleRepository
                .findById(loadableStudyRuleInput.getCommunicationRelatedEntityId())
                .orElseThrow(
                    () ->
                        new GenericServiceException(
                            String.format(
                                "Loadable study rule not found for Id: %d",
                                loadableStudyRuleInput.getCommunicationRelatedEntityId()),
                            CommonErrorCodes.E_GEN_INTERNAL_ERR,
                            HttpStatusCode.INTERNAL_SERVER_ERROR));
        loadableStudyRuleInput.setLoadableStudyRuleXId(loadableStudyRule);

        // Set version
        Optional<LoadableStudyRuleInput> loadableStudyRuleInputOpt =
            loadableStudyRuleInputRepository.findById(loadableStudyRuleInput.getId());
        loadableStudyRuleInput.setVersion(
            loadableStudyRuleInputOpt.map(EntityDoc::getVersion).orElse(null));
      }

      // Save data
      loadableStudyRuleInputRepository.saveAll(loadableStudyRuleInputsStage);
      log.info(
          "Communication #######  loadable_study_rule_input saved. Entries: {}",
          loadableStudyRuleInputsStage.size());
    }
  }

  /**
   * Method to save loadable_plan_comments table
   *
   * @throws GenericServiceException Exception when pattern not found
   */
  private void saveLoadablePlanComments() throws GenericServiceException {
    current_table_name = LoadableStudyTables.LOADABLE_PLAN_COMMENTS.getTable();

    if (!isEmpty(loadablePlanCommentsStage)) {
      for (LoadablePlanComments comment : loadablePlanCommentsStage) {
        // Set detached entities
        LoadablePattern loadablePattern =
            loadablePatternRepository
                .findById(comment.getCommunicationRelatedEntityId())
                .orElseThrow(
                    () ->
                        new GenericServiceException(
                            String.format(
                                "Loadable pattern not found for Id: %d",
                                comment.getCommunicationRelatedEntityId()),
                            CommonErrorCodes.E_GEN_INTERNAL_ERR,
                            HttpStatusCode.INTERNAL_SERVER_ERROR));
        comment.setLoadablePattern(loadablePattern);

        // Set version
        Optional<LoadablePlanComments> commentOpt =
            loadablePlanCommentsRepository.findById(comment.getId());
        comment.setVersion(commentOpt.map(EntityDoc::getVersion).orElse(null));
      }

      // Save data
      loadablePlanCommentsRepository.saveAll(loadablePlanCommentsStage);
      log.info(
          "Communication #######  loadable_plan_comments saved. Entries: {}",
          loadablePlanCommentsStage.size());
    }
  }

  /** Method to save loadable_plan_stowage_details_temp table */
  private void saveLoadablePlanStowageDetailsTemp() {
    current_table_name = LoadableStudyTables.LOADABLE_PLAN_STOWAGE_DETAILS_TEMP.getTable();

    if (!isEmpty(loadablePlanStowageDetailsTempStage)) {
      for (LoadablePlanStowageDetailsTemp loadablePlanStowageDetailsTemp :
          loadablePlanStowageDetailsTempStage) {

        // Set version
        Optional<LoadablePlanStowageDetailsTemp> loadablePlanStowageDetailsTempOpt =
            loadablePlanStowageDetailsTempRepository.findById(
                loadablePlanStowageDetailsTemp.getId());
        loadablePlanStowageDetailsTemp.setVersion(
            loadablePlanStowageDetailsTempOpt.map(EntityDoc::getVersion).orElse(null));

        // Set stowage details
        loadablePlanStowageDetailsTemp.setLoadablePlanStowageDetails(
            emptyIfNull(loadablePlanStowageDetailsStage).stream()
                .filter(
                    loadablePlanStowageDetails ->
                        loadablePlanStowageDetails
                            .getId()
                            .equals(
                                loadablePlanStowageDetailsTemp
                                    .getCommunicationRelatedIdMap()
                                    .get("stowage_details_xid")))
                .findFirst()
                .orElse(null));

        // Set ballast details
        loadablePlanStowageDetailsTemp.setLoadablePlanBallastDetails(
            emptyIfNull(loadablePlanBallastDetailsStage).stream()
                .filter(
                    loadablePlanBallastDetails ->
                        loadablePlanBallastDetails
                            .getId()
                            .equals(
                                loadablePlanStowageDetailsTemp
                                    .getCommunicationRelatedIdMap()
                                    .get("ballast_details_xid")))
                .findFirst()
                .orElse(null));

        // Set loadable_pattern details
        loadablePlanStowageDetailsTemp.setLoadablePattern(
            emptyIfNull(loadablePatternStage).stream()
                .filter(
                    loadablePattern ->
                        loadablePattern
                            .getId()
                            .equals(
                                loadablePlanStowageDetailsTemp
                                    .getCommunicationRelatedIdMap()
                                    .get("loadable_pattern_xid")))
                .findFirst()
                .orElse(null));

        // Set loadable_plan_commingle details
        loadablePlanStowageDetailsTemp.setLoadablePlanCommingleDetails(
            emptyIfNull(loadablePlanCommingleDetailsStage).stream()
                .filter(
                    loadablePlanCommingleDetails ->
                        loadablePlanCommingleDetails
                            .getId()
                            .equals(
                                loadablePlanStowageDetailsTemp
                                    .getCommunicationRelatedIdMap()
                                    .get("loadable_plan_commingle_details_xid")))
                .findFirst()
                .orElse(null));
      }

      // Save data
      loadablePlanStowageDetailsTempRepository.saveAll(loadablePlanStowageDetailsTempStage);
      log.info(
          "Communication #######  loadable_plan_stowage_details_temp saved. Entries: {}",
          loadablePlanStowageDetailsTempStage.size());
    }
  }

  /** Method to save loadable_pattern_algo_status table */
  private void saveLoadablePatternAlgoStatus() {
    current_table_name = LoadableStudyTables.LOADABLE_PATTERN_ALGO_STATUS.getTable();

    if (null == loadablePatternAlgoStatusStage) {
      log.info("Communication XXXXXXX  loadable_pattern_algo_status is empty");
      return;
    }
    Optional<LoadableStudyStatus> loadableStudyStatus =
        loadableStudyStatusRepository.findById(
            loadablePatternAlgoStatusStage
                .getCommunicationRelatedIdMap()
                .get("loadable_study_status"));

    // Update status for recent record
    if (loadableStudyStatus.isPresent()) {
      loadablePatternAlgoStatusRepository
          .findByLoadablePatternId(
              loadablePatternAlgoStatusStage
                  .getCommunicationRelatedIdMap()
                  .get("loadabale_pattern_xid"))
          .ifPresentOrElse(
              loadablePatternAlgoStatus -> {
                loadablePatternAlgoStatusStage = loadablePatternAlgoStatus;
              },
              () -> {
                loadablePatternAlgoStatusStage.setVersion(null);
                Optional<LoadablePattern> loadablePattern =
                    loadablePatternRepository.findById(
                        loadablePatternAlgoStatusStage.getLoadablePattern().getId());
                loadablePatternAlgoStatusStage.setLoadablePattern(loadablePattern.orElse(null));
              });
      loadablePatternAlgoStatusStage.setGenerateFromShore(true);
      loadablePatternAlgoStatusStage.setLoadableStudyStatus(loadableStudyStatus.get());
      loadablePatternAlgoStatusStage =
          loadablePatternAlgoStatusRepository.save(loadablePatternAlgoStatusStage);
      log.info(
          "Communication #######  loadable_pattern_algo_status saved with id:"
              + loadablePatternAlgoStatusStage.getId());

    } else {
      log.info(
          "Communication XXXXXXX  loadable_pattern_algo_status is not saved , loadableStudyStatus is not found : "
              + loadablePatternAlgoStatusStage
                  .getCommunicationRelatedIdMap()
                  .get("loadable_study_status"));
    }
  }

  /**
   * Method to update status in exception
   *
   * @param id id value
   * @param processId process id value
   * @param status status value
   * @param statusDescription status description
   */
  private void updateStatusInExceptionCase(
      Long id, String processId, String status, String statusDescription) {
    loadableStudyStagingService.updateStatusAndStatusDescriptionForId(
        id, status, statusDescription, LocalDateTime.now());
    loadableStudyStagingService.updateStatusAndModifiedDateTimeForProcessId(
        processId, status, LocalDateTime.now());
  }
  // endregion

  // region Data Binding
  private <T> T bindDataToEntity(
      Object entity,
      Type listType,
      LoadableStudyTables table,
      String jsonData,
      Long dataTransferStageId,
      String... columnsToRemove) {
    try {
      HashMap<String, String> map = loadableStudyStagingService.getAttributeMapping(entity);
      JsonArray jsonArray =
          removeJsonFields(JsonParser.parseString(jsonData).getAsJsonArray(), map, columnsToRemove);

      idMap.put(table.getTable(), dataTransferStageId);
      if (listType.getTypeName().startsWith(ArrayList.class.getTypeName())) {
        return new Gson().fromJson(jsonArray, listType);
      }
      return new Gson().fromJson(jsonArray.get(0).getAsJsonObject(), listType);
    } catch (Exception e) {
      log.error(
          "Communication XXXXXXX Unable to bind the Json to object : "
              + entity.getClass().getName());
      log.error(e);
    }
    return null;
  }
  // endregion

  // region Utils
  private JsonArray removeJsonFields(JsonArray array, HashMap<String, String> map, String... xIds) {
    List<String> xIdList = xIds == null ? null : List.of(xIds);
    return removeJsonFields(array, map, xIdList);
  }

  private JsonArray removeJsonFields(
      JsonArray array, HashMap<String, String> map, List<String> xIds) {
    JsonArray json = loadableStudyStagingService.getAsEntityJson(map, array);
    JsonArray jsonArray = new JsonArray();
    JsonObject communicationRelatedIdMap = new JsonObject();
    for (JsonElement jsonElement : json) {
      final JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (xIds != null) {
        for (String xId : xIds) {
          if (xIds.size() == 1) {
            jsonObj.add("communicationRelatedEntityId", jsonObj.get(xId));
          } else {
            if (!"null".equals(jsonObj.get(xId).toString())) {
              communicationRelatedIdMap.addProperty(xId, jsonObj.get(xId).getAsLong());
            }
          }
          jsonObj.remove(xId);
        }
      }
      jsonObj.add("communicationRelatedIdMap", communicationRelatedIdMap);
      jsonArray.add(jsonObj);
    }
    return jsonArray;
  }

  private String replaceString(String str) {
    return str.replace("[\"", "[")
        .replace("\"]", "]")
        .replace("\"{", "{")
        .replace("}\"", "}")
        .replace("\\", "");
  }

  private Long getVoyageId(String json) {
    JsonArray jsonArray = JsonParser.parseString(json).getAsJsonArray();
    return jsonArray.get(0).getAsJsonObject().get("voyage_xid").getAsLong();
  }

  private Long getLoadableStudyStatusId(String json) {
    JsonArray jsonArray = JsonParser.parseString(json).getAsJsonArray();
    return jsonArray.get(0).getAsJsonObject().get("loadable_study_status_xid").getAsLong();
  }

  private void clear() {
    loadableStudyStage = null;
    voyageStage = null;
    commingleCargoStage = null;
    cargoNominationStage = null;
    loadableStudyPortRotationStage = null;
    onHandQuantityStage = null;
    onBoardQuantityStage = null;
    loadableQuantityStage = null;
    synopticalTableStage = null;
    jsonDataStage = null;
    loadableStudyAlgoStatusStage = null;
    loadablePatternStage = null;
    algoErrorHeadingStage = null;
    algoErrorsStage = null;
    loadablePlanConstraintsStage = null;
    loadablePlanQuantityStage = null;
    loadablePlanCommingleDetailsStage = null;
    loadablePatternCargoToppingOffSequenceStage = null;
    loadablePlanStowageDetailsStage = null;
    loadablePlanBallastDetailsStage = null;
    loadablePlanComminglePortwiseDetailsStage = null;
    stabilityParametersStage = null;
    loadablePatternCargoDetailsStage = null;
    loadablePlanStowageBallastDetailsStage = null;
    synopticalTableLoadicatorDataStage = null;
    loadablePlanStage = null;
    cargoNominationOperationDetailsStage = null;
    loadableStudyCommunicationStatusStage = null;
    cowHistoryStage = null;
    dischargePatternQuantityCargoPortwiseDetailsStage = null;
    idMap = new HashMap<>();
    voyageId = 0L;
    loadableStudyStatusId = 0L;
    current_table_name = "";
    loadableStudyPortRotationStageCommunication = null;
    loadableStudyRulesStage = null;
    loadableStudyRuleInputsStage = null;
    loadablePlanCommentsStage = null;
    loadablePlanStowageDetailsTempStage = null;
    loadablePatternAlgoStatusStage = null;
  }

  // endregion
}
