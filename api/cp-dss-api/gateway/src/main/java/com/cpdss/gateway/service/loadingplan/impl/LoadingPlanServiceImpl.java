/* Licensed at AlphaOri Technologies */
package com.cpdss.gateway.service.loadingplan.impl;

import static com.cpdss.gateway.common.GatewayConstants.*;
import static com.cpdss.gateway.utility.TimeUtility.getTimezoneConvertedDate;
import static org.springframework.util.StringUtils.isEmpty;

import com.cpdss.common.exception.GenericServiceException;
import com.cpdss.common.generated.*;
import com.cpdss.common.generated.Common.PLANNING_TYPE;
import com.cpdss.common.generated.LoadableStudy;
import com.cpdss.common.generated.LoadableStudy.AlgoStatusReply;
import com.cpdss.common.generated.LoadableStudy.JsonRequest;
import com.cpdss.common.generated.LoadableStudy.StatusReply;
import com.cpdss.common.generated.discharge_plan.DischargePlanServiceGrpc;
import com.cpdss.common.generated.loading_plan.LoadingInformationServiceGrpc;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels.*;
import com.cpdss.common.generated.loading_plan.LoadingPlanServiceGrpc;
import com.cpdss.common.rest.CommonErrorCodes;
import com.cpdss.common.rest.CommonSuccessResponse;
import com.cpdss.common.utils.HttpStatusCode;
import com.cpdss.gateway.common.GatewayConstants;
import com.cpdss.gateway.domain.*;
import com.cpdss.gateway.domain.UllageBillReply;
import com.cpdss.gateway.domain.UllageBillRequest;
import com.cpdss.gateway.domain.loadingplan.*;
import com.cpdss.gateway.domain.loadingplan.LoadablePlanCommingleDetails;
import com.cpdss.gateway.domain.loadingplan.LoadingDelays;
import com.cpdss.gateway.domain.loadingplan.LoadingDetails;
import com.cpdss.gateway.domain.loadingplan.LoadingInformation;
import com.cpdss.gateway.domain.loadingplan.LoadingInformationRequest;
import com.cpdss.gateway.domain.loadingplan.LoadingRates;
import com.cpdss.gateway.domain.loadingplan.LoadingStages;
import com.cpdss.gateway.domain.loadingplan.sequence.LoadingPlanAlgoRequest;
import com.cpdss.gateway.domain.loadingplan.sequence.LoadingPlanAlgoResponse;
import com.cpdss.gateway.domain.loadingplan.sequence.LoadingSequenceResponse;
import com.cpdss.gateway.domain.voyage.VoyageResponse;
import com.cpdss.gateway.service.UllageReportFileParsingService;
import com.cpdss.gateway.service.VesselInfoService;
import com.cpdss.gateway.service.loadingplan.*;
import com.cpdss.gateway.utility.RuleUtility;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
public class LoadingPlanServiceImpl implements LoadingPlanService {

  @Autowired LoadingInformationService loadingInformationService;

  @Autowired LoadingInformationServiceImpl loadingInformationServiceImpl;

  @Autowired LoadingPlanGrpcService loadingPlanGrpcService;

  @Autowired LoadingPlanGrpcServiceImpl loadingPlanGrpcServiceImpl;

  @Autowired UllageReportFileParsingService ullageReportFileParsingService;

  @Autowired GenerateLoadingPlanExcelReportService loadingPlanExcelReportService;

  @Autowired private LoadingInformationBuilderService loadingInformationBuilderService;

  @GrpcClient("loadableStudyService")
  private LoadableStudyServiceGrpc.LoadableStudyServiceBlockingStub
      loadableStudyServiceBlockingStub;

  @GrpcClient("dischargeInformationService")
  private DischargePlanServiceGrpc.DischargePlanServiceBlockingStub
      dischargePlanServiceBlockingStub;

  @GrpcClient("cargoInfoService")
  private CargoInfoServiceGrpc.CargoInfoServiceBlockingStub cargoInfoServiceBlockingStub;

  @GrpcClient("vesselInfoService")
  private VesselInfoServiceGrpc.VesselInfoServiceBlockingStub vesselInfoGrpcService;

  @GrpcClient("loadingPlanService")
  private LoadingPlanServiceGrpc.LoadingPlanServiceBlockingStub loadingPlanServiceBlockingStub;

  @GrpcClient("portInfoService")
  private PortInfoServiceGrpc.PortInfoServiceBlockingStub portInfoGrpcService;

  @GrpcClient("loadingInformationService")
  private LoadingInformationServiceGrpc.LoadingInformationServiceBlockingStub
      loadingInfoServiceBlockingStub;

  @Autowired LoadingPlanService loadingPlanService;

  private static final String SUCCESS = "SUCCESS";
  public static final String BALLAST_FRONT_TANK = "FRONT";
  public static final String BALLAST_CENTER_TANK = "CENTER";
  public static final String BALLAST_REAR_TANK = "REAR";
  public static final Long CARGO_TANK_CATEGORY_ID = 1L;
  public static final Long CARGO_SLOP_TANK_CATEGORY_ID = 9L;
  public static final Long CARGO_VOID_TANK_CATEGORY_ID = 15L;
  public static final Long FRESH_WATER_TANK_CATEGORY_ID = 3L;
  public static final Long FUEL_OIL_TANK_CATEGORY_ID = 5L;
  public static final Long DIESEL_OIL_TANK_CATEGORY_ID = 6L;
  public static final Long LUBRICATING_OIL_TANK_CATEGORY_ID = 14L;
  public static final Long LUBRICANT_OIL_TANK_CATEGORY_ID = 19L;
  public static final Long FUEL_VOID_TANK_CATEGORY_ID = 22L;
  public static final Long FRESH_WATER_VOID_TANK_CATEGORY_ID = 23L;
  public static final Long BALLAST_VOID_TANK_CATEGORY_ID = 16L;
  public static final Long BALLAST_TANK_CATEGORY_ID = 2L;
  public static final List<Long> CARGO_TANK_CATEGORIES =
      Arrays.asList(
          CARGO_TANK_CATEGORY_ID, CARGO_SLOP_TANK_CATEGORY_ID, CARGO_VOID_TANK_CATEGORY_ID);

  public static final List<Long> BALLAST_TANK_CATEGORIES =
      Arrays.asList(BALLAST_TANK_CATEGORY_ID, BALLAST_VOID_TANK_CATEGORY_ID);

  public static final List<Long> OHQ_REAR_TANK_CATEGORIES =
      Arrays.asList(FRESH_WATER_TANK_CATEGORY_ID, FRESH_WATER_VOID_TANK_CATEGORY_ID);

  public static final List<Long> OHQ_CENTER_TANK_CATEGORIES =
      Arrays.asList(
          FUEL_OIL_TANK_CATEGORY_ID, DIESEL_OIL_TANK_CATEGORY_ID, FUEL_VOID_TANK_CATEGORY_ID);

  public static final List<Long> OHQ_TANK_CATEGORIES =
      Arrays.asList(
          FRESH_WATER_TANK_CATEGORY_ID,
          FUEL_OIL_TANK_CATEGORY_ID,
          DIESEL_OIL_TANK_CATEGORY_ID,
          FUEL_VOID_TANK_CATEGORY_ID,
          FRESH_WATER_VOID_TANK_CATEGORY_ID);

  public static final List<Long> ALL_TANK_CATEGORIES =
      Arrays.asList(
          FRESH_WATER_TANK_CATEGORY_ID,
          FUEL_OIL_TANK_CATEGORY_ID,
          DIESEL_OIL_TANK_CATEGORY_ID,
          FUEL_VOID_TANK_CATEGORY_ID,
          FRESH_WATER_VOID_TANK_CATEGORY_ID,
          BALLAST_TANK_CATEGORY_ID,
          BALLAST_VOID_TANK_CATEGORY_ID,
          CARGO_TANK_CATEGORY_ID,
          CARGO_SLOP_TANK_CATEGORY_ID,
          CARGO_VOID_TANK_CATEGORY_ID);

  public final String ACTUAL = "1";
  public final String PLANNED = "2";
  public final String ARRIVAL = "1";
  public final String DEPARTURE = "2";

  @Autowired VesselInfoService vesselInfoService;

  @Autowired LoadingSequenceService loadingSequenceService;

  @Autowired LoadingPlanBuilderService loadingPlanBuilderService;

  @Value("${gateway.attachement.rootFolder}")
  private String rootFolder;

  /**
   * Port Rotation From Loading Plan DB
   *
   * @param vesselId Numeric Long
   * @param portRId Numeric Long
   * @return Not decided
   * @throws GenericServiceException
   */
  @Override
  public Object getLoadingPortRotationDetails(Long vesselId, Long portRId)
      throws GenericServiceException {
    VoyageResponse activeVoyage = this.loadingPlanGrpcService.getActiveVoyageDetails(vesselId);
    log.info("Active Voyage {} For Vessel Id {}", activeVoyage.getVoyageNumber(), vesselId);
    // TO DO
    return activeVoyage.getPortRotations();
  }

  /**
   * @param request
   * @param correlationId
   * @return LoadingInfoAlgoResponse
   */
  public LoadingInfoAlgoResponse saveLoadingInfoStatus(
      AlgoStatusRequest request, String correlationId) throws GenericServiceException {
    log.info("update loading info status api");
    LoadingInfoAlgoResponse loadingInfoAlgoResponse = new LoadingInfoAlgoResponse();
    com.cpdss.common.generated.LoadableStudy.AlgoStatusRequest.Builder requestBuilder =
        com.cpdss.common.generated.LoadableStudy.AlgoStatusRequest.newBuilder();
    requestBuilder.setLoadableStudystatusId(request.getLoadingInfoStatusId());
    requestBuilder.setProcesssId(request.getProcessId());
    AlgoStatusReply reply =
        loadingPlanGrpcServiceImpl.saveLoadingInfoStatus(requestBuilder.build());
    if (!SUCCESS.equals(reply.getResponseStatus().getStatus())) {
      throw new GenericServiceException(
          "Failed to saveLoadingInfoStatus",
          reply.getResponseStatus().getCode(),
          HttpStatusCode.valueOf(Integer.valueOf(reply.getResponseStatus().getCode())));
    }
    loadingInfoAlgoResponse.setResponseStatus(
        new CommonSuccessResponse(String.valueOf(HttpStatus.OK.value()), correlationId));
    return loadingInfoAlgoResponse;
  }

  /**
   * 1. Loading Details from LS 2. loading rate
   *
   * @param vesselId
   * @param planId
   * @param portRId
   * @param voyageId
   * @return
   */
  @Override
  public LoadingInformation getLoadingInformationByPortRotation(
      Long vesselId, Long planId, Long portRId, Long voyageId) throws GenericServiceException {
    LoadingInformation var1 = new LoadingInformation();

    final String OPERATION_TYPE = "DEP";

    VoyageResponse activeVoyage = this.loadingPlanGrpcService.getActiveVoyageDetails(vesselId);
    log.info(
        "Get Loading Info, Active Voyage Number {} and Id {} ",
        activeVoyage.getVoyageNumber(),
        activeVoyage.getId());
    Optional<PortRotation> portRotation =
        activeVoyage.getPortRotations().stream().filter(v -> v.getId().equals(portRId)).findFirst();

    if (portRotation.isEmpty() || portRotation.get().getPortId() == null) {
      log.error("Port Rotation Id cannot be empty");
      throw new GenericServiceException(
          "Port Rotation Id Cannot be empty",
          CommonErrorCodes.E_HTTP_BAD_REQUEST,
          HttpStatusCode.BAD_REQUEST);
    }

    LoadingPlanModels.LoadingInformation loadingInfo =
        this.loadingPlanGrpcService.fetchLoadingInformation(
            vesselId,
            activeVoyage.getId(),
            planId,
            activeVoyage.getPatternId(),
            portRotation.get().getId());

    log.info(
        "Get Loading Info, Port rotation id is available in Active Voyage, Port Id is {}",
        portRotation.get().getPortId());

    // Set LS name and id
    if (activeVoyage.getActiveLs() != null) {
      var1.setLoadableStudyId(activeVoyage.getActiveLs().getId());
      var1.setLoadableStudyName(activeVoyage.getActiveLs().getName());
      log.info(
          "Setting Loadable Study Name {} and Id {}",
          var1.getLoadableStudyName(),
          var1.getLoadableStudyId());
    }

    // call to synoptic/port master table for sunrise/sunset data
    LoadingDetails loadingDetails =
        this.loadingInformationService.getLoadingDetailsByPortRotationId(
            loadingInfo.getLoadingDetail(),
            vesselId,
            activeVoyage.getId(),
            portRId,
            portRotation.get().getPortId());

    // Fetch timezoneOffsetValue, eta and etd
    LoadableStudy.PortRotationDetailReply portRotationDetailReply =
        this.loadableStudyServiceBlockingStub.getLoadableStudyPortRotationByPortRotationId(
            LoadableStudy.PortRotationRequest.newBuilder()
                .setId(portRotation.get().getId())
                .build());

    LoadableStudy.PortRotationDetail portRotationDetail =
        portRotationDetailReply.getPortRotationDetail();
    loadingDetails.setEta(LocalDateTime.parse(portRotationDetail.getEta()));
    loadingDetails.setEtd(LocalDateTime.parse(portRotationDetail.getEtd()));

    PortInfo.PortReply portReply =
        this.portInfoGrpcService.getPortInfoByPortIds(
            PortInfo.GetPortInfoByPortIdsRequest.newBuilder()
                .addId(portRotation.get().getPortId())
                .build());
    if (!portReply.getPortsList().isEmpty()) {
      loadingDetails.setTimezoneOffsetVal(portReply.getPorts(0).getTimezoneOffsetVal());
    }

    // Setting default common date with date from eta
    if (loadingDetails.getCommonDate() == null
        || String.valueOf(loadingDetails.getCommonDate()).isEmpty()) {
      loadingDetails.setCommonDate(LocalDate.from(loadingDetails.getEta()));
    }

    // Setting default start time with time from eta
    if (loadingDetails.getStartTime() == null || loadingDetails.getStartTime().isEmpty()) {
      loadingDetails.setStartTime(
          String.valueOf(
              LocalTime.from(
                  getTimezoneConvertedDate(
                      loadingDetails.getEta(),
                      Double.parseDouble(loadingDetails.getTimezoneOffsetVal())))));
    }

    // from loading info table, loading plan service
    LoadingRates loadingRates =
        this.loadingInformationService.getLoadingRateForVessel(
            loadingInfo.getLoadingRate(), vesselId);

    // Berth data from master, call to port Info service
    List<BerthDetails> masterBerthDetails =
        this.loadingInformationService.getMasterBerthDetailsByPortId(
            portRotation.get().getPortId());
    List<BerthDetails> loadingBerthDetails =
        this.loadingInformationService.buildLoadingPlanBerthDetails(
            loadingInfo.getLoadingBerthsList());

    // Machine In use master and selected data setting
    CargoMachineryInUse machineryInUse =
        this.loadingInformationService.getCargoMachinesInUserFromVessel(
            loadingInfo.getLoadingMachinesList(), vesselId);

    // from loading plan, user data + master data
    LoadingStages loadingStages =
        this.loadingInformationService.getLoadingStagesAndMasters(loadingInfo.getLoadingStage());

    // Topping Off Sequence
    List<ToppingOffSequence> toppingSequence =
        this.loadingInformationService.getToppingOffSequence(
            loadingInfo.getToppingOffSequenceList());

    // Call No. 1 To synoptic table api (voyage-status)
    CargoVesselTankDetails vesselTankDetails =
        this.loadingPlanGrpcService.fetchPortWiseCargoDetails(
            vesselId,
            activeVoyage.getId(),
            activeVoyage.getActiveLs().getId(),
            portRotation.get().getPortId(),
            portRotation.get().getPortOrder(),
            portRotation.get().getId(),
            OPERATION_TYPE);

    // Call No. 2 To synoptic data for loading (same as port rotation in above code)
    // Set missing cargo condition data for commingle cargos.
    LoadableStudy.LoadingPlanCommonResponse loadingPlanCommonResponse =
        this.loadingInformationService.setCargoTobeLoadedAndCargoGrade(
            vesselTankDetails,
            vesselId,
            activeVoyage.getPatternId(),
            OPERATION_TYPE,
            portRotation.get().getId(),
            portRotation.get().getPortId(),
            Common.PLANNING_TYPE.LOADABLE_STUDY,
            false,
            loadingInfo.getLoadingInfoId());

    // Manage Sequence
    LoadingSequences loadingSequences =
        this.loadingInformationService.getLoadingSequence(loadingInfo.getLoadingDelays());

    addDefaultCargoDetailsForManagingSequence(
        loadingPlanCommonResponse.getLoadableQuantityCargoDetailsList(),
        loadingSequences,
        loadingInfo.getLoadingInfoId());

    var1.setLoadingInfoId(loadingInfo.getLoadingInfoId());
    var1.setSynopticTableId(loadingInfo.getSynopticTableId());
    var1.setIsLoadingInfoComplete(loadingInfo.getIsLoadingInfoComplete());
    var1.setLoadingDetails(loadingDetails);
    var1.setLoadingRates(loadingRates);
    var1.setBerthDetails(new LoadingBerthDetails(masterBerthDetails, loadingBerthDetails));
    var1.setMachineryInUses(machineryInUse);
    var1.setLoadingStages(loadingStages);
    var1.setToppingOffSequence(toppingSequence);
    var1.setCargoVesselTankDetails(vesselTankDetails);
    var1.setLoadingSequences(loadingSequences);
    var1.setIsLoadingInstructionsComplete(loadingInfo.getIsLoadingInstructionsComplete());
    var1.setIsLoadingSequenceGenerated(loadingInfo.getIsLoadingSequenceGenerated());
    var1.setIsLoadingPlanGenerated(loadingInfo.getIsLoadingPlanGenerated());
    var1.setLoadingInfoStatusId(loadingInfo.getLoadingInfoStatusId());
    var1.setLoadingPlanArrStatusId(loadingInfo.getLoadingPlanArrStatusId());
    var1.setLoadingPlanDepStatusId(loadingInfo.getLoadingPlanDepStatusId());
    var1.setResponseStatus(new CommonSuccessResponse(String.valueOf(HttpStatus.OK.value()), null));
    return var1;
  }

  /**
   * Method to set default cargo details for managing sequence
   *
   * @param loadableQuantityCargoDetailsList List of LoadableQuantityCargoDetails objects from
   *     synoptical table response
   * @param loadingSequences LoadingSequences object to be set
   * @param loadingInfoId Loading Info Id
   */
  private void addDefaultCargoDetailsForManagingSequence(
      List<LoadableStudy.LoadableQuantityCargoDetails> loadableQuantityCargoDetailsList,
      LoadingSequences loadingSequences,
      long loadingInfoId)
      throws GenericServiceException {

    log.info("Inside addDefaultCargoDetailsForManagingSequence method!");

    if (loadingSequences != null
        && (loadingSequences.getLoadingDelays() == null
            || loadingSequences.getLoadingDelays().isEmpty())) {

      // Set default values
      List<LoadingDelays> loadingDelaysList = new ArrayList<>();
      AtomicReference<Long> defaultSequenceNumberCounter =
          new AtomicReference<>(DEFAULT_SEQUENCE_NUMBER_COUNTER_START_VALUE);
      loadableQuantityCargoDetailsList.stream()
          .sorted(
              Comparator.comparingInt(LoadableStudy.LoadableQuantityCargoDetails::getLoadingOrder))
          .forEach(
              loadableQuantityCargoDetails -> {
                LoadingDelays loadingDelays = new LoadingDelays();

                // Set fields
                loadingDelays.setCargoId(loadableQuantityCargoDetails.getCargoId());
                loadingDelays.setCargoNominationId(
                    loadableQuantityCargoDetails.getCargoNominationId());
                loadingDelays.setLoadingInfoId(loadingInfoId);
                loadingDelays.setDuration(BigDecimal.ZERO);
                defaultSequenceNumberCounter.set(
                    defaultSequenceNumberCounter.get()
                        + DEFAULT_SEQUENCE_NUMBER_COUNTER_INCREMENT_VALUE);
                loadingDelays.setSequenceNo(defaultSequenceNumberCounter.get());

                loadingDelays.setQuantity(
                    StringUtils.hasLength(loadableQuantityCargoDetails.getLoadableMT())
                        ? new BigDecimal(loadableQuantityCargoDetails.getLoadableMT())
                        : BigDecimal.ZERO);
                loadingDelays.setLoadingRate(
                    StringUtils.hasLength(loadableQuantityCargoDetails.getLoadingRateM3Hr())
                        ? new BigDecimal(loadableQuantityCargoDetails.getLoadingRateM3Hr())
                        : BigDecimal.ZERO);

                loadingDelaysList.add(loadingDelays);
              });
      loadingSequences.setLoadingDelays(loadingDelaysList);

      // Save default manage sequence loading delays to database table
      LoadingPlanModels.LoadingInformation.Builder builder =
          LoadingPlanModels.LoadingInformation.newBuilder();
      builder.setLoadingInfoId(loadingInfoId);
      builder.setIsLoadingInfoComplete(IS_LOADING_INFO_COMPLETE_DEFAULT);
      LoadingPlanModels.LoadingDelay.Builder loadingDelayBuilder =
          LoadingPlanModels.LoadingDelay.newBuilder();
      loadingDelayBuilder.addAllDelays(
          loadingInformationBuilderService.buildLoadingDelays(loadingDelaysList, loadingInfoId));
      builder.setLoadingDelays(loadingDelayBuilder.build());

      LoadingPlanModels.LoadingInfoSaveResponse loadingInfoSaveResponse =
          loadingInfoServiceBlockingStub.saveLoadingInfoDelays(builder.build());
      if (loadingInfoSaveResponse == null
          || !SUCCESS.equals(loadingInfoSaveResponse.getResponseStatus().getStatus())) {

        log.error(
            "Failed to save default manage sequence loading delays for loading information id: {}",
            loadingInfoId);
        throw new GenericServiceException(
            "Failed to save default manage sequence loading delays for loading information id: "
                + loadingInfoId,
            CommonErrorCodes.E_HTTP_BAD_REQUEST,
            HttpStatusCode.BAD_REQUEST);
      }
    }
  }

  @Override
  public LoadingInformationResponse saveLoadingInformation(
      LoadingInformationRequest request, String correlationId) throws GenericServiceException {
    LoadingInformationResponse response =
        this.loadingInformationService.saveLoadingInformation(request, correlationId);
    response.setLoadingInformation(
        this.getLoadingInformationByPortRotation(
            response.getVesseld(), 0L, response.getPortRotationId(), response.getVoyageId()));
    return response;
  }

  @Override
  public RuleResponse getLoadingPlanRules(Long vesselId, Long voyageId, Long loadingInfoId)
      throws GenericServiceException {
    LoadingPlanModels.LoadingPlanRuleRequest.Builder builder =
        LoadingPlanModels.LoadingPlanRuleRequest.newBuilder();
    builder.setVesselId(vesselId);
    builder.setSectionId(LOADING_RULE_MASTER_ID);
    builder.setLoadingInfoId(loadingInfoId);
    RuleResponse ruleResponse = this.loadingPlanGrpcService.saveOrGetLoadingPlanRules(builder);
    log.info("Loading Info Rule Fetch for Vessel Id {}, info Id {}", vesselId, loadingInfoId);
    return ruleResponse;
  }

  @Override
  public RuleResponse saveLoadingPlanRules(
      Long vesselId, Long voyageId, Long loadingInfoId, RuleRequest ruleRequest)
      throws GenericServiceException {
    LoadingPlanModels.LoadingPlanRuleRequest.Builder builder =
        LoadingPlanModels.LoadingPlanRuleRequest.newBuilder();
    builder.setVesselId(vesselId);
    builder.setSectionId(LOADING_RULE_MASTER_ID);
    builder.setLoadingInfoId(loadingInfoId);
    RuleUtility.buildRuleListForSave(ruleRequest, null, null, builder, null, false, true, false);
    RuleResponse ruleResponse = this.loadingPlanGrpcService.saveOrGetLoadingPlanRules(builder);
    return ruleResponse;
  }

  @Override
  public LoadingSequenceResponse getLoadingSequence(Long vesselId, Long voyageId, Long infoId)
      throws GenericServiceException {
    LoadingSequenceRequest.Builder builder = LoadingSequenceRequest.newBuilder();
    builder.setLoadingInfoId(infoId);
    LoadingSequenceReply reply = this.loadingPlanGrpcService.getLoadingSequence(builder);
    LoadingSequenceResponse response = new LoadingSequenceResponse();
    loadingSequenceService.buildLoadingSequence(vesselId, reply, response);
    return response;
  }

  @Override
  public LoadingPlanAlgoResponse saveLoadingPlan(
      Long vesselId,
      Long voyageId,
      Long infoId,
      LoadingPlanAlgoRequest loadingPlanAlgoRequest,
      String requestJsonString)
      throws GenericServiceException, Exception {
    LoadingPlanAlgoResponse algoResponse = new LoadingPlanAlgoResponse();
    LoadingPlanSaveRequest.Builder builder = LoadingPlanSaveRequest.newBuilder();
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      objectMapper.writeValue(
          new File(this.rootFolder + "/json/loadingInformationResult_" + infoId + ".json"),
          loadingPlanAlgoRequest);
    } catch (IOException e) {
      log.error("Exception encountered when saving Loading Information Response JSON");
    }
    try {
      log.info("Saving Loading Information Response JSON");
      StatusReply reply =
          this.saveJson(
              infoId,
              GatewayConstants.LOADING_INFORMATION_RESPONSE_JSON_SIMULATOR_ID,
              requestJsonString);
      if (!GatewayConstants.SUCCESS.equals(reply.getStatus())) {
        log.error("Error occured  in gateway while writing JSON to database.");
      }
    } catch (Exception e) {
      log.error(
          "Exception encountered when processing Loading Information Response JSON : {}",
          e.getMessage());
    }
    loadingSequenceService.buildLoadingPlanSaveRequest(
        loadingPlanAlgoRequest, vesselId, infoId, builder);
    LoadingPlanSaveResponse response = loadingPlanGrpcService.saveLoadingPlan(builder.build());
    if (!response.getResponseStatus().getStatus().equals(SUCCESS)) {
      log.error("Exception occured when saving loading plan");
      throw new GenericServiceException(
          "Unable to save loading plan for loading information " + infoId,
          CommonErrorCodes.E_HTTP_BAD_REQUEST,
          HttpStatusCode.BAD_REQUEST);
    }
    algoResponse.setProcessId(loadingPlanAlgoRequest.getProcessId());
    algoResponse.setResponseStatus(new CommonSuccessResponse(SUCCESS, ""));

    // Generate Loading Plan excel and Push to file repo
    loadingPlanExcelReportService.generateLoadingPlanExcel(
        null, vesselId, voyageId, infoId, response.getPortRotationId(), false);

    return algoResponse;
  }

  @Override
  public LoadingPlanResponse getLoadingPlan(
      Long vesselId, Long voyageId, Long infoId, Long portRotationId)
      throws GenericServiceException {

    final String OPERATION_TYPE = "DEP";
    LoadingPlanResponse loadingPlanResponse = new LoadingPlanResponse();

    VoyageResponse activeVoyage = this.loadingPlanGrpcService.getActiveVoyageDetails(vesselId);
    log.info(
        "Get Loading Plan, Active Voyage Number {} and Id {} ",
        activeVoyage.getVoyageNumber(),
        activeVoyage.getId());
    loadingPlanResponse.setVoyageDate(activeVoyage.getActualStartDate());
    Optional<PortRotation> portRotation =
        activeVoyage.getPortRotations().stream()
            .filter(v -> v.getId().equals(portRotationId))
            .findFirst();

    LoadingPlanModels.LoadingPlanReply planReply =
        this.loadingPlanGrpcService.getLoadingPlan(
            vesselId, voyageId, infoId, activeVoyage.getPatternId(), portRotation.get().getId());

    LoadingInformation loadingInformation = new LoadingInformation();
    // from loading info table, loading plan service
    LoadingRates loadingRates =
        this.loadingInformationService.getLoadingRateForVessel(
            planReply.getLoadingInformation().getLoadingRate(), vesselId);

    // Topping Off Sequence
    List<ToppingOffSequence> toppingSequence =
        this.loadingInformationService.getToppingOffSequence(
            planReply.getLoadingInformation().getToppingOffSequenceList());
    buildTankLayout(vesselId, loadingPlanResponse);
    loadingInformation.setLoadingRates(loadingRates);
    loadingInformation.setToppingOffSequence(toppingSequence);

    LoadingDetails loadingDetails =
        this.loadingInformationService.getLoadingDetailsByPortRotationId(
            planReply.getLoadingInformation().getLoadingDetail(),
            vesselId,
            activeVoyage.getId(),
            portRotationId,
            portRotation.get().getPortId());
    loadingInformation.setLoadingDetails(loadingDetails);

    // Berth data from master, call to port Info service
    List<BerthDetails> masterBerthDetails =
        this.loadingInformationService.getMasterBerthDetailsByPortId(
            portRotation.get().getPortId());
    List<BerthDetails> loadingBerthDetails =
        this.loadingInformationService.buildLoadingPlanBerthDetails(
            planReply.getLoadingInformation().getLoadingBerthsList());

    LoadingBerthDetails berthDetails = new LoadingBerthDetails();
    berthDetails.setAvailableBerths(masterBerthDetails);
    berthDetails.setSelectedBerths(loadingBerthDetails);
    loadingInformation.setBerthDetails(berthDetails);

    CargoMachineryInUse machineryInUse =
        this.loadingInformationService.getCargoMachinesInUserFromVessel(
            planReply.getLoadingInformation().getLoadingMachinesList(), vesselId);
    loadingInformation.setMachineryInUses(machineryInUse);

    LoadingStages loadingStages =
        this.loadingInformationService.getLoadingStagesAndMasters(
            planReply.getLoadingInformation().getLoadingStage());
    loadingInformation.setLoadingStages(loadingStages);

    loadingInformation.setLoadingInfoStatusId(
        planReply.getLoadingInformation().getLoadingInfoStatusId());
    loadingInformation.setLoadingPlanArrStatusId(
        planReply.getLoadingInformation().getLoadingPlanArrStatusId());
    loadingInformation.setLoadingPlanDepStatusId(
        planReply.getLoadingInformation().getLoadingPlanDepStatusId());
    loadingInformation.setLoadablePatternId(
        planReply.getLoadingInformation().getLoadablePatternId());

    CargoVesselTankDetails vesselTankDetails =
        this.loadingPlanGrpcService.fetchPortWiseCargoDetails(
            vesselId,
            activeVoyage.getId(),
            activeVoyage.getActiveLs().getId(),
            portRotation.get().getPortId(),
            portRotation.get().getPortOrder(),
            portRotation.get().getId(),
            OPERATION_TYPE);
    // Call No. 2 To synoptic data for loading (same as port rotation in above code)
    vesselTankDetails.setLoadableQuantityCargoDetails(
        this.loadingInformationService.getLoadablePlanCargoDetailsByPort(
            vesselId,
            activeVoyage.getPatternId(),
            OPERATION_TYPE,
            portRotation.get().getId(),
            portRotation.get().getPortId(),
            Common.PLANNING_TYPE.LOADABLE_STUDY,
            false));
    loadingInformation.setCargoVesselTankDetails(vesselTankDetails);

    LoadingSequences loadingSequences =
        this.loadingInformationService.getLoadingSequence(
            planReply.getLoadingInformation().getLoadingDelays());
    loadingInformation.setLoadingSequences(loadingSequences);
    loadingInformation.setIsLoadingPlanGenerated(true);

    loadingPlanResponse.setLoadingInformation(loadingInformation);

    loadingPlanResponse.setPlanBallastDetails(
        loadingPlanBuilderService.buildLoadingPlanBallastFromRpc(
            planReply.getPortLoadingPlanBallastDetailsList()));
    loadingPlanResponse.setPlanStowageDetails(
        loadingPlanBuilderService.buildLoadingPlanStowageFromRpc(
            planReply.getPortLoadingPlanStowageDetailsList()));
    loadingPlanResponse.setPlanRobDetails(
        loadingPlanBuilderService.buildLoadingPlanRobFromRpc(
            planReply.getPortLoadingPlanRobDetailsList()));
    loadingPlanResponse.setPlanStabilityParams(
        loadingPlanBuilderService.buildLoadingPlanStabilityParamFromRpc(
            planReply.getPortLoadingPlanStabilityParametersList()));
    loadingPlanResponse.setPlanCommingleDetails(
        loadingPlanBuilderService.buildLoadingPlanCommingleFromRpc(
            planReply.getPortLoadingPlanCommingleDetailsList()));
    loadingPlanResponse.setCurrentPortCargos(
        this.loadingInformationService.getLoadablePlanCargoDetailsByPortUnfiltered(
            vesselId,
            activeVoyage.getPatternId(),
            OPERATION_TYPE,
            portRotation.get().getId(),
            portRotation.get().getPortId(),
            PLANNING_TYPE.LOADABLE_STUDY,
            false));

    return loadingPlanResponse;
  }

  /**
   * Builds vessel tank layout parameters
   *
   * @param vesselId
   * @param loadingPlanResponse
   */
  @Override
  public void buildTankLayout(Long vesselId, LoadingPlanResponse loadingPlanResponse) {
    // Getting ballast tanks
    VesselInfo.VesselRequest.Builder vesselGrpcRequest = VesselInfo.VesselRequest.newBuilder();
    vesselGrpcRequest.setVesselId(vesselId);
    vesselGrpcRequest.addAllTankCategories(ALL_TANK_CATEGORIES);
    VesselInfo.VesselReply vesselReply =
        this.getVesselDetailForSynopticalTable(vesselGrpcRequest.build());
    // sorting the tanks based on tank display order from vessel tank table
    List<VesselInfo.VesselTankDetail> sortedTankList =
        new ArrayList<>(vesselReply.getVesselTanksList());
    Collections.sort(
        sortedTankList, Comparator.comparing(VesselInfo.VesselTankDetail::getTankDisplayOrder));
    // build ballast tank details
    List<VesselInfo.VesselTankDetail> ballastTankList =
        sortedTankList.stream()
            .filter(tankList -> BALLAST_TANK_CATEGORIES.contains(tankList.getTankCategoryId()))
            .collect(Collectors.toList());
    List<VesselInfo.VesselTankDetail> frontBallastTanks = new ArrayList<>();
    List<VesselInfo.VesselTankDetail> centerBallastTanks = new ArrayList<>();
    List<VesselInfo.VesselTankDetail> rearBallastTanks = new ArrayList<>();
    frontBallastTanks.addAll(
        ballastTankList.stream()
            .filter(tank -> BALLAST_FRONT_TANK.equals(tank.getTankPositionCategory()))
            .collect(Collectors.toList()));
    centerBallastTanks.addAll(
        ballastTankList.stream()
            .filter(tank -> BALLAST_CENTER_TANK.equals(tank.getTankPositionCategory()))
            .collect(Collectors.toList()));
    rearBallastTanks.addAll(
        ballastTankList.stream()
            .filter(tank -> BALLAST_REAR_TANK.equals(tank.getTankPositionCategory()))
            .collect(Collectors.toList()));
    loadingPlanResponse.setBallastFrontTanks(
        this.createGroupWiseTankList(this.groupTanks(frontBallastTanks)));
    loadingPlanResponse.setBallastCenterTanks(
        this.createGroupWiseTankList(this.groupTanks(centerBallastTanks)));
    loadingPlanResponse.setBallastRearTanks(
        this.createGroupWiseTankList(this.groupTanks(rearBallastTanks)));

    // getting bunker tanks
    List<VesselInfo.VesselTankDetail> bunkerTankList =
        sortedTankList.stream()
            .filter(tankList -> OHQ_TANK_CATEGORIES.contains(tankList.getTankCategoryId()))
            .collect(Collectors.toList());
    List<VesselInfo.VesselTankDetail> bunkerTanks = new ArrayList<>();
    List<VesselInfo.VesselTankDetail> bunkerRearTanks = new ArrayList<>();
    bunkerTanks.addAll(
        bunkerTankList.stream()
            .filter(tank -> OHQ_CENTER_TANK_CATEGORIES.contains(tank.getTankCategoryId()))
            .collect(Collectors.toList()));
    bunkerRearTanks.addAll(
        bunkerTankList.stream()
            .filter(tank -> OHQ_REAR_TANK_CATEGORIES.contains(tank.getTankCategoryId()))
            .collect(Collectors.toList()));
    loadingPlanResponse.setBunkerTanks(this.createGroupWiseTankList(this.groupTanks(bunkerTanks)));
    loadingPlanResponse.setBunkerRearTanks(
        this.createGroupWiseTankList(this.groupTanks(bunkerRearTanks)));

    // getting cargo tanks
    List<VesselInfo.VesselTankDetail> cargoTanks =
        sortedTankList.stream()
            .filter(tankList -> CARGO_TANK_CATEGORIES.contains(tankList.getTankCategoryId()))
            .collect(Collectors.toList());
    loadingPlanResponse.setCargoTanks(this.createGroupWiseTankList(this.groupTanks(cargoTanks)));
  }

  @Override
  public LoadingUpdateUllageResponse getUpdateUllageDetails(
      Long vesselId,
      Long patternId,
      Long portRotationId,
      String operationType,
      boolean isDischarging)
      throws GenericServiceException {
    LoadingPlanModels.UpdateUllageDetailsRequest.Builder requestBuilder =
        LoadingPlanModels.UpdateUllageDetailsRequest.newBuilder();
    requestBuilder.setPatternId(patternId).setPortRotationId(portRotationId).setVesselId(vesselId);
    // getting active voyage details
    VoyageResponse activeVoyage = this.loadingPlanGrpcService.getActiveVoyageDetails(vesselId);
    log.info("Active Voyage {} For Vessel Id {}", activeVoyage.getVoyageNumber(), vesselId);

    Optional<PortRotation> portRotation = null;
    Long studyId = null;
    // Set loadable study id
    if (isDischarging) {
      portRotation =
          activeVoyage.getDischargePortRotations().stream()
              .filter(v -> v.getId().doubleValue() == portRotationId.doubleValue())
              .findFirst();
      // Set portId from discharge portRoatation
      requestBuilder.setPortId(portRotation.get().getPortId());
      studyId = activeVoyage.getActiveDs().getId();
    } else {
      portRotation =
          activeVoyage.getPortRotations().stream()
              .filter(v -> v.getId().doubleValue() == portRotationId.doubleValue())
              .findFirst();
      // Set portId from portRoatation
      requestBuilder.setPortId(portRotation.get().getPortId());
      studyId = activeVoyage.getActiveLs().getId();
    }

    // Retrieve cargo Nominations from cargo nomination table
    com.cpdss.common.generated.LoadableStudy.CargoNominationReply cargoNominationReply =
        getCargoNominationsByStudyId(studyId);

    // Get Update Ullage Data
    LoadingPlanModels.UpdateUllageDetailsResponse response = null;
    // discharging and loading has same functionality after the data taken from specific micro
    // service. so re using the loading plan logic
    if (isDischarging) {
      response =
          this.dischargePlanServiceBlockingStub.getDischargeUpdateUllageDetails(
              requestBuilder.build());
    } else {
      response = this.loadingPlanGrpcService.getUpdateUllageDetails(requestBuilder);
    }
    LoadingUpdateUllageResponse outResponse = new LoadingUpdateUllageResponse();
    // group cargo nomination ids
    CargoInfo.CargoListRequest.Builder cargoRequestBuilder =
        CargoInfo.CargoListRequest.newBuilder();
    List<Long> cargoNominationIds = new ArrayList<>();
    List<Long> finalCargoNominationIds = cargoNominationIds;
    cargoNominationReply.getCargoNominationsList().stream()
        .forEach(
            cargoNominationDetail -> {
              cargoRequestBuilder.addId(cargoNominationDetail.getCargoId());
              finalCargoNominationIds.add(cargoNominationDetail.getId());
            });
    cargoNominationIds = removeDuplicates(finalCargoNominationIds);

    // Retrieve cargo information from cargo master
    CargoInfo.CargoReply cargoReply =
        cargoInfoServiceBlockingStub.getCargoInfosByCargoIds(cargoRequestBuilder.build());

    final String OPERATION_TYPE = "DEP";
    // Getting Cargo to Be Loaded in the Port
    List<LoadableQuantityCargoDetails> loadablePlanCargoDetails = new ArrayList<>();
    // Getting already added cargoes until this port
    List<LoadableQuantityCargoDetails> loadedCargoDetails = new ArrayList<>();
    if (isDischarging) {
      loadablePlanCargoDetails =
          this.loadingInformationService.getLoadablePlanCargoDetailsByPort(
              vesselId,
              activeVoyage.getDischargePatternId(),
              OPERATION_TYPE,
              portRotation.get().getId(),
              portRotation.get().getPortId(),
              Common.PLANNING_TYPE.DISCHARGE_STUDY,
              isDischarging);
      // Getting already added cargoes until this port
      loadedCargoDetails =
          this.loadingInformationService.getLoadablePlanCargoDetailsByPortUnfiltered(
              vesselId,
              activeVoyage.getDischargePatternId(),
              OPERATION_TYPE,
              portRotation.get().getId(),
              portRotation.get().getPortId(),
              Common.PLANNING_TYPE.DISCHARGE_STUDY,
              isDischarging);
    } else {
      loadablePlanCargoDetails =
          this.loadingInformationService.getLoadablePlanCargoDetailsByPort(
              vesselId,
              activeVoyage.getPatternId(),
              OPERATION_TYPE,
              portRotation.get().getId(),
              portRotation.get().getPortId(),
              Common.PLANNING_TYPE.LOADABLE_STUDY,
              isDischarging);
      // Getting already added cargoes until this port
      loadedCargoDetails =
          this.loadingInformationService.getLoadablePlanCargoDetailsByPortUnfiltered(
              vesselId,
              activeVoyage.getPatternId(),
              OPERATION_TYPE,
              portRotation.get().getId(),
              portRotation.get().getPortId(),
              Common.PLANNING_TYPE.LOADABLE_STUDY,
              isDischarging);
    }

    cargoNominationIds =
        loadedCargoDetails.stream()
            .map(LoadableQuantityCargoDetails::getCargoNominationId)
            .collect(Collectors.toList());

    // Getting ballast tanks
    VesselInfo.VesselRequest.Builder vesselGrpcRequest = VesselInfo.VesselRequest.newBuilder();
    vesselGrpcRequest.setVesselId(vesselId);
    vesselGrpcRequest.addAllTankCategories(ALL_TANK_CATEGORIES);
    VesselInfo.VesselReply vesselReply =
        this.getVesselDetailForSynopticalTable(vesselGrpcRequest.build());
    // sorting the tanks based on tank display order from vessel tank table
    List<VesselInfo.VesselTankDetail> sortedTankList =
        new ArrayList<>(vesselReply.getVesselTanksList());
    Collections.sort(
        sortedTankList, Comparator.comparing(VesselInfo.VesselTankDetail::getTankDisplayOrder));
    // build ballast tank details
    List<VesselInfo.VesselTankDetail> ballastTankList =
        sortedTankList.stream()
            .filter(tankList -> BALLAST_TANK_CATEGORIES.contains(tankList.getTankCategoryId()))
            .collect(Collectors.toList());
    List<VesselInfo.VesselTankDetail> frontBallastTanks = new ArrayList<>();
    List<VesselInfo.VesselTankDetail> centerBallastTanks = new ArrayList<>();
    List<VesselInfo.VesselTankDetail> rearBallastTanks = new ArrayList<>();
    frontBallastTanks.addAll(
        ballastTankList.stream()
            .filter(tank -> BALLAST_FRONT_TANK.equals(tank.getTankPositionCategory()))
            .collect(Collectors.toList()));
    centerBallastTanks.addAll(
        ballastTankList.stream()
            .filter(tank -> BALLAST_CENTER_TANK.equals(tank.getTankPositionCategory()))
            .collect(Collectors.toList()));
    rearBallastTanks.addAll(
        ballastTankList.stream()
            .filter(tank -> BALLAST_REAR_TANK.equals(tank.getTankPositionCategory()))
            .collect(Collectors.toList()));
    outResponse.setBallastFrontTanks(
        this.createGroupWiseTankList(this.groupTanks(frontBallastTanks)));
    outResponse.setBallastCenterTanks(
        this.createGroupWiseTankList(this.groupTanks(centerBallastTanks)));
    outResponse.setBallastRearTanks(
        this.createGroupWiseTankList(this.groupTanks(rearBallastTanks)));

    // getting bunker tanks
    List<VesselInfo.VesselTankDetail> bunkerTankList =
        sortedTankList.stream()
            .filter(tank -> OHQ_TANK_CATEGORIES.contains(tank.getTankCategoryId()))
            .collect(Collectors.toList());
    List<VesselInfo.VesselTankDetail> bunkerTanks = new ArrayList<>();
    List<VesselInfo.VesselTankDetail> bunkerRearTanks = new ArrayList<>();
    bunkerTanks.addAll(
        bunkerTankList.stream()
            .filter(
                tank ->
                    OHQ_CENTER_TANK_CATEGORIES.contains(tank.getTankCategoryId())
                        && tank.getShowInOhqObq())
            .collect(Collectors.toList()));
    bunkerRearTanks.addAll(
        bunkerTankList.stream()
            .filter(
                tank ->
                    OHQ_REAR_TANK_CATEGORIES.contains(tank.getTankCategoryId())
                        && tank.getShowInOhqObq())
            .collect(Collectors.toList()));
    outResponse.setBunkerTanks(this.createGroupWiseTankList(this.groupTanks(bunkerTanks)));
    outResponse.setBunkerRearTanks(this.createGroupWiseTankList(this.groupTanks(bunkerRearTanks)));

    // getting cargo tanks
    List<VesselInfo.VesselTankDetail> cargoTanks =
        sortedTankList.stream()
            .filter(tankList -> CARGO_TANK_CATEGORIES.contains(tankList.getTankCategoryId()))
            .collect(Collectors.toList());
    outResponse.setCargoTanks(this.createGroupWiseTankList(this.groupTanks(cargoTanks)));

    String arrivalDeparture = operationType.equalsIgnoreCase("ARR") ? "1" : "2";
    List<PortLoadablePlanStowageDetails> portLoadablePlanStowageDetails =
        this.buildPortLoadablePlanStowageDetails(response, arrivalDeparture, sortedTankList);
    outResponse.setPortLoadablePlanStowageDetails(portLoadablePlanStowageDetails);
    List<PortLoadablePlanBallastDetails> portLoadablePlanBallastDetails =
        this.buildPortLoadablePlanBallastDetails(response, arrivalDeparture, sortedTankList);
    outResponse.setPortLoadablePlanBallastDetails(portLoadablePlanBallastDetails);
    List<PortLoadablePlanRobDetails> portLoadablePlanRobDetails =
        this.buildPortLoadablePlanRobDetails(response, arrivalDeparture, sortedTankList);
    outResponse.setPortLoadablePlanRobDetails(portLoadablePlanRobDetails);
    List<LoadablePlanCommingleDetails> loadablePlanCommingleDetails =
        this.buildLoadableCommingleDetails(response, arrivalDeparture, sortedTankList);
    outResponse.setLoadablePlanCommingleDetails(loadablePlanCommingleDetails);
    this.buildUpdateUllageDetails(
        response,
        outResponse,
        cargoNominationIds,
        cargoNominationReply,
        portLoadablePlanStowageDetails,
        cargoReply,
        arrivalDeparture,
        loadablePlanCargoDetails,
        loadedCargoDetails,
        isDischarging);

    outResponse.setResponseStatus(
        new CommonSuccessResponse(String.valueOf(HttpStatus.OK.value()), null));
    return outResponse;
    //    } catch (Exception e) {
    //      log.error(
    //          "Failed to retrieve update ullage details of  vesselID: {} on port: {}",
    //          vesselId,
    //          portId);
    //      throw new GenericServiceException(
    //          "Failed to retrieve update ullage details",
    //          CommonErrorCodes.E_HTTP_BAD_REQUEST,
    //          HttpStatusCode.BAD_REQUEST);
    //    }
  }

  @Override
  public com.cpdss.common.generated.LoadableStudy.CargoNominationReply getCargoNominationsByStudyId(
      Long studyId) {
    com.cpdss.common.generated.LoadableStudy.CargoNominationRequest cargoNominationRequest =
        com.cpdss.common.generated.LoadableStudy.CargoNominationRequest.newBuilder()
            .setLoadableStudyId(studyId)
            .build();

    return loadableStudyServiceBlockingStub.getCargoNominationById(cargoNominationRequest);
  }

  private LoadingUpdateUllageResponse buildUpdateUllageDetails(
      LoadingPlanModels.UpdateUllageDetailsResponse response,
      LoadingUpdateUllageResponse outResponse,
      List<Long> cargoNominationIds,
      LoadableStudy.CargoNominationReply cargoNominationReply,
      List<PortLoadablePlanStowageDetails> portLoadablePlanStowageDetails,
      CargoInfo.CargoReply cargoReply,
      String arrivalDeparture,
      List<LoadableQuantityCargoDetails> loadablePlanCargoDetails,
      List<LoadableQuantityCargoDetails> loadedCargoDetails,
      boolean isDischarging) {
    // Setting actual or planned
    boolean isPlanned = true;
    if (portLoadablePlanStowageDetails.size() > 0
        && portLoadablePlanStowageDetails.get(0).getActualPlanned().equalsIgnoreCase(ACTUAL)) {
      isPlanned = false;
    }
    outResponse.setIsPlannedValues(isPlanned);
    List<CargoBillOfLadding> billOfLaddingList = new ArrayList<CargoBillOfLadding>();
    List<UpdateUllageCargoQuantityDetail> cargoQuantityDetailList =
        new ArrayList<UpdateUllageCargoQuantityDetail>();
    for (Long cargoNominationId : cargoNominationIds) {
      CargoBillOfLadding cargoBillOfLadding = new CargoBillOfLadding();
      UpdateUllageCargoQuantityDetail cargoQuantityDetail = new UpdateUllageCargoQuantityDetail();

      // get cargonomination details
      LoadableStudy.CargoNominationDetail cargoNomination =
          cargoNominationReply.getCargoNominationsList().stream()
              .filter(
                  cargoNominationDetail ->
                      cargoNominationDetail.getId() == cargoNominationId.longValue())
              .findFirst()
              .get();

      // get cargo details
      CargoInfo.CargoDetail cargo =
          cargoReply.getCargosList().stream()
              .filter(cargoDetail -> cargoDetail.getId() == cargoNomination.getCargoId())
              .findFirst()
              .get();

      // set cargo To Be Loaded
      boolean cargoToBeLoaded = false;
      if (loadablePlanCargoDetails.stream()
              .filter(
                  loadablePlanCargoDetail ->
                      loadablePlanCargoDetail.getCargoNominationId().equals(cargoNominationId))
              .count()
          > 0) {
        cargoToBeLoaded = true;
      }

      // set already added cargo or not
      boolean cargoLoaded = false;
      if (!cargoToBeLoaded
          && loadedCargoDetails.stream()
                  .filter(
                      loadablePlanCargoDetail ->
                          loadablePlanCargoDetail.getCargoNominationId().equals(cargoNominationId))
                  .count()
              > 0) {
        cargoLoaded = true;
      }

      // get the bill of laddings for the cargo nomination
      List<Common.BillOfLadding> cargoBills =
          response.getBillOfLaddingList().stream()
              .filter(
                  billOfLadding ->
                      billOfLadding.getCargoNominationId() == cargoNominationId.longValue())
              .collect(Collectors.toList());
      List<BillOfLadding> billOfLaddings = new ArrayList<BillOfLadding>();
      if (cargoBills.size() > 0) {
        billOfLaddings =
            cargoBills.stream()
                .<BillOfLadding>map(cargoBill -> this.buildBillOfLadding(cargoBill))
                .collect(Collectors.toList());
      }
      cargoBillOfLadding.setCargoId(cargoNomination.getCargoId());
      cargoBillOfLadding.setCargoColor(cargoNomination.getColor());
      cargoBillOfLadding.setCargoName(cargo.getCrudeType());
      cargoBillOfLadding.setCargoAbbrevation(cargoNomination.getAbbreviation());
      cargoBillOfLadding.setCargoNominationId(cargoNominationId);
      cargoBillOfLadding.setCargoToBeLoaded(cargoToBeLoaded);
      cargoBillOfLadding.setCargoLoaded(cargoLoaded);
      if (isDischarging) {
        cargoBillOfLadding.setCargoToBeDischarged(cargoToBeLoaded);
        cargoBillOfLadding.setCargoDischarged(cargoLoaded);
      }
      cargoBillOfLadding.setBillOfLaddings(billOfLaddings);
      billOfLaddingList.add(cargoBillOfLadding);

      // Setting Cargo Quantity Table values
      cargoQuantityDetail.setCargoId(cargoNomination.getCargoId());
      cargoQuantityDetail.setCargoColor(cargoNomination.getColor());
      cargoQuantityDetail.setCargoName(cargo.getCrudeType());
      cargoQuantityDetail.setCargoAbbrevation(cargoNomination.getAbbreviation());
      cargoQuantityDetail.setCargoNominationId(cargoNominationId);
      cargoQuantityDetail.setNominationApi(cargoNomination.getApi());
      cargoQuantityDetail.setNominationTemp(cargoNomination.getTemperature());
      Double nominationQuantity =
          !cargoNomination.getQuantity().isEmpty()
              ? Double.parseDouble(cargoNomination.getQuantity())
              : 0;
      cargoQuantityDetail.setNominationTotal(nominationQuantity);
      Double minTolerance =
          !cargoNomination.getMinTolerance().isEmpty()
              ? Double.parseDouble(cargoNomination.getMinTolerance())
              : 0;
      cargoQuantityDetail.setMinTolerance(minTolerance);
      Double maxTolerance =
          !cargoNomination.getMaxTolerance().isEmpty()
              ? Double.parseDouble(cargoNomination.getMaxTolerance())
              : 0;
      cargoQuantityDetail.setMaxTolerance(maxTolerance);
      Double minQuantity = nominationQuantity * (100 + minTolerance) / 100;
      cargoQuantityDetail.setMinQuantity(minQuantity);
      Double maxQuantity = nominationQuantity * (100 + maxTolerance) / 100;
      cargoQuantityDetail.setMaxQuantity(maxQuantity);
      Double actualQuantityTotal =
          portLoadablePlanStowageDetails.stream()
              .filter(
                  stowage ->
                      stowage.getCargoNominationId().doubleValue() == cargoNominationId
                          && stowage.getActualPlanned().equalsIgnoreCase(ACTUAL)
                          && stowage.getArrivalDeparture().equalsIgnoreCase(arrivalDeparture))
              .mapToDouble(stowage -> Double.parseDouble(stowage.getQuantity()))
              .reduce(0, (subtotal, element) -> subtotal + element);
      OptionalDouble actualCommingleTotal =
          response.getLoadablePlanCommingleDetailsList().stream()
              .filter(
                  commingle ->
                      (commingle.getCargoNomination1Id() == cargoNominationId
                              || commingle.getCargoNomination2Id() == cargoNominationId)
                          && commingle.getActualPlanned().equalsIgnoreCase(ACTUAL)
                          && commingle.getArrivalDeparture().equalsIgnoreCase(arrivalDeparture))
              .mapToDouble(
                  commingle ->
                      commingle.getCargoNomination1Id() == cargoNominationId
                          ? Double.parseDouble(commingle.getQuantity1MT())
                          : Double.parseDouble(commingle.getQuantity2MT()))
              .reduce(Double::sum);
      if (actualCommingleTotal.isPresent()) {
        actualQuantityTotal = Double.sum(actualQuantityTotal, actualCommingleTotal.getAsDouble());
      }
      cargoQuantityDetail.setActualQuantityTotal(actualQuantityTotal);
      Double plannedQuantityTotal =
          response.getPortLoadablePlanStowageDetailsList().stream()
              .filter(
                  stowage ->
                      stowage.getCargoNominationId() == cargoNominationId.longValue()
                          && stowage.getActualPlanned().equalsIgnoreCase(PLANNED)
                          && stowage.getArrivalDeparture().equalsIgnoreCase(arrivalDeparture))
              .mapToDouble(stowage -> Double.parseDouble(stowage.getQuantity()))
              .reduce(0, (subtotal, element) -> subtotal + element);
      OptionalDouble plannedCommingleTotal =
          response.getLoadablePlanCommingleDetailsList().stream()
              .filter(
                  commingle ->
                      (commingle.getCargoNomination1Id() == cargoNominationId
                              || commingle.getCargoNomination2Id() == cargoNominationId)
                          && commingle.getActualPlanned().equalsIgnoreCase(PLANNED)
                          && commingle.getArrivalDeparture().equalsIgnoreCase(arrivalDeparture))
              .mapToDouble(
                  commingle ->
                      commingle.getCargoNomination1Id() == cargoNominationId
                          ? Double.parseDouble(commingle.getQuantity1MT())
                          : Double.parseDouble(commingle.getQuantity2MT()))
              .reduce(Double::sum);
      if (plannedCommingleTotal.isPresent()) {
        plannedQuantityTotal =
            Double.sum(plannedQuantityTotal, plannedCommingleTotal.getAsDouble());
      }
      cargoQuantityDetail.setPlannedQuantityTotal(plannedQuantityTotal);
      Double blQuantityMtTotal =
          billOfLaddings.stream()
              .mapToDouble(billOfLadding -> billOfLadding.getQuantityMt().doubleValue())
              .reduce(0, (subtotal, element) -> subtotal + element);
      cargoQuantityDetail.setBlQuantityMTTotal(blQuantityMtTotal);
      Double blQuantityLTTotal =
          billOfLaddings.stream()
              .mapToDouble(billOfLadding -> billOfLadding.getQuantityLT().doubleValue())
              .reduce(0, (subtotal, element) -> subtotal + element);
      cargoQuantityDetail.setBlQuantityLTTotal(blQuantityLTTotal);
      Double blQuantityKLTotal =
          billOfLaddings.stream()
              .mapToDouble(billOfLadding -> billOfLadding.getQuantityKl().doubleValue())
              .reduce(0, (subtotal, element) -> subtotal + element);
      cargoQuantityDetail.setBlQuantityKLTotal(blQuantityKLTotal);
      Double blQuantityBblsTotal =
          billOfLaddings.stream()
              .mapToDouble(billOfLadding -> billOfLadding.getQuantityBbls().doubleValue())
              .reduce(0, (subtotal, element) -> subtotal + element);
      cargoQuantityDetail.setBlQuantityBblsTotal(blQuantityBblsTotal);
      Double difference = actualQuantityTotal.doubleValue() - blQuantityMtTotal.doubleValue();
      cargoQuantityDetail.setDifference(difference);
      Double blAvgApi =
          billOfLaddings.stream()
              .mapToDouble(billOfLadding -> billOfLadding.getApi().doubleValue())
              .average()
              .orElse(Double.valueOf(0));
      cargoQuantityDetail.setBlAvgApi(blAvgApi.toString());
      Double blAvgTemp =
          billOfLaddings.stream()
              .mapToDouble(billOfLadding -> billOfLadding.getTemperature().doubleValue())
              .average()
              .orElse(Double.valueOf(0));
      cargoQuantityDetail.setBlAvgTemp(blAvgTemp.toString());
      Double actualAvgApi =
          portLoadablePlanStowageDetails.stream()
              .filter(
                  stowage ->
                      stowage.getCargoNominationId().doubleValue() == cargoNominationId
                          && stowage.getActualPlanned().equalsIgnoreCase(ACTUAL))
              .mapToDouble(stowage -> Double.parseDouble(stowage.getApi()))
              .average()
              .orElse(Double.valueOf(0));
      cargoQuantityDetail.setActualAvgApi(actualAvgApi.toString());
      Double actualAvgTemp =
          portLoadablePlanStowageDetails.stream()
              .filter(
                  stowage ->
                      stowage.getCargoNominationId().doubleValue() == cargoNominationId
                          && stowage.getActualPlanned().equalsIgnoreCase(ACTUAL))
              .mapToDouble(stowage -> Double.parseDouble(stowage.getTemperature()))
              .average()
              .orElse(Double.valueOf(0));
      cargoQuantityDetail.setActualAvgTemp(actualAvgTemp.toString());
      cargoQuantityDetailList.add(cargoQuantityDetail);
    }
    outResponse.setBillOfLaddingList(billOfLaddingList);
    outResponse.setCargoQuantityDetails(cargoQuantityDetailList);
    return outResponse;
  }

  private BillOfLadding buildBillOfLadding(Common.BillOfLadding cargoBill) {
    BillOfLadding billOfLadding = new BillOfLadding();
    Optional.ofNullable(cargoBill.getId()).ifPresent(id -> billOfLadding.setId(id));
    Optional.ofNullable(cargoBill.getPortId()).ifPresent(id -> billOfLadding.setPortId(id));
    Optional.ofNullable(cargoBill.getCargoNominationId())
        .ifPresent(id -> billOfLadding.setCargoNominationId(id));
    Optional.ofNullable(cargoBill.getApi())
        .ifPresent(api -> billOfLadding.setApi(new BigDecimal(api)));
    Optional.ofNullable(cargoBill.getTemperature())
        .ifPresent(temp -> billOfLadding.setTemperature(new BigDecimal(temp)));
    Optional.ofNullable(cargoBill.getQuantityMt())
        .ifPresent(quantity -> billOfLadding.setQuantityMt(new BigDecimal(quantity)));
    Optional.ofNullable(cargoBill.getQuantityBbls())
        .ifPresent(quantity -> billOfLadding.setQuantityBbls(new BigDecimal(quantity)));
    Optional.ofNullable(cargoBill.getQuantityKl())
        .ifPresent(quantity -> billOfLadding.setQuantityKl(new BigDecimal(quantity)));
    Optional.ofNullable(cargoBill.getQuantityLT())
        .ifPresent(quantity -> billOfLadding.setQuantityLT(new BigDecimal(quantity)));
    Optional.ofNullable(cargoBill.getBlRefNo()).ifPresent(ref -> billOfLadding.setBlRefNo(ref));
    return billOfLadding;
  }

  private List<PortLoadablePlanStowageDetails> buildPortLoadablePlanStowageDetails(
      LoadingPlanModels.UpdateUllageDetailsResponse response,
      String arrivalDeparture,
      List<VesselInfo.VesselTankDetail> sortedTankList) {
    List<PortLoadablePlanStowageDetails> portLoadablePlanStowageDetailsList = new ArrayList<>();
    List<LoadingPlanModels.PortLoadablePlanStowageDetail> portLoadablePlanStowageDetails =
        response.getPortLoadablePlanStowageTempDetailsList().stream()
            .filter(
                portWiseStowageTempDetail ->
                    portWiseStowageTempDetail
                            .getArrivalDeparture()
                            .equalsIgnoreCase(arrivalDeparture)
                        && portWiseStowageTempDetail.getActualPlanned().equalsIgnoreCase(ACTUAL))
            .collect(Collectors.toList());
    // if no value in temp take actual
    if (portLoadablePlanStowageDetails.size() == 0) {
      portLoadablePlanStowageDetails =
          response.getPortLoadablePlanStowageDetailsList().stream()
              .filter(
                  portWiseStowageDetail ->
                      portWiseStowageDetail.getArrivalDeparture().equalsIgnoreCase(arrivalDeparture)
                          && portWiseStowageDetail.getActualPlanned().equalsIgnoreCase(ACTUAL))
              .collect(Collectors.toList());
    }
    // if no values take planned
    if (portLoadablePlanStowageDetails.size() == 0) {
      portLoadablePlanStowageDetails =
          response.getPortLoadablePlanStowageDetailsList().stream()
              .filter(
                  portWiseStowageDetail ->
                      portWiseStowageDetail.getArrivalDeparture().equalsIgnoreCase(arrivalDeparture)
                          && portWiseStowageDetail.getActualPlanned().equalsIgnoreCase(PLANNED))
              .collect(Collectors.toList());
    }
    // if no values take departure
    if (portLoadablePlanStowageDetails.size() == 0) {
      portLoadablePlanStowageDetails =
          response.getPortLoadablePlanStowageDetailsList().stream()
              .filter(
                  portWiseStowageDetail ->
                      portWiseStowageDetail.getArrivalDeparture().equalsIgnoreCase(DEPARTURE)
                          && portWiseStowageDetail.getActualPlanned().equalsIgnoreCase(PLANNED))
              .collect(Collectors.toList());
    }
    if (portLoadablePlanStowageDetails.size() > 0) {

      for (VesselInfo.VesselTankDetail tankDetail : sortedTankList) {

        Optional<PortLoadablePlanStowageDetail> portWiseStowageDetailOptional =
            portLoadablePlanStowageDetails.stream()
                .filter(stowageDetail -> stowageDetail.getTankId() == tankDetail.getTankId())
                .findFirst();

        portWiseStowageDetailOptional.ifPresent(
            portWiseStowageDetail -> {
              PortLoadablePlanStowageDetails stowageDetail = new PortLoadablePlanStowageDetails();
              stowageDetail.setAbbreviation(portWiseStowageDetail.getAbbreviation());
              stowageDetail.setApi(portWiseStowageDetail.getApi());
              stowageDetail.setCargoNominationId(portWiseStowageDetail.getCargoNominationId());
              stowageDetail.setCargoId(portWiseStowageDetail.getCargoId());
              stowageDetail.setColorCode(portWiseStowageDetail.getColorCode());
              stowageDetail.setCorrectedUllage(portWiseStowageDetail.getCorrectedUllage());
              stowageDetail.setCorrectionFactor(portWiseStowageDetail.getCorrectionFactor());
              stowageDetail.setFillingPercentage(portWiseStowageDetail.getFillingPercentage());
              stowageDetail.setId(portWiseStowageDetail.getId());
              stowageDetail.setLoadablePatternId(portWiseStowageDetail.getLoadablePatternId());
              stowageDetail.setDischargePatternId(portWiseStowageDetail.getLoadablePatternId());
              stowageDetail.setRdgUllage(portWiseStowageDetail.getRdgUllage());
              stowageDetail.setTankId(portWiseStowageDetail.getTankId());
              stowageDetail.setTemperature(portWiseStowageDetail.getTemperature());
              stowageDetail.setWeight(portWiseStowageDetail.getWeight());
              stowageDetail.setQuantity(portWiseStowageDetail.getQuantity());
              stowageDetail.setArrivalDeparture(portWiseStowageDetail.getArrivalDeparture());
              stowageDetail.setActualPlanned(portWiseStowageDetail.getActualPlanned());
              stowageDetail.setUllage(portWiseStowageDetail.getUllage());
              stowageDetail.setTankName(tankDetail.getTankName());
              stowageDetail.setTankShortName(tankDetail.getShortName());

              portLoadablePlanStowageDetailsList.add(stowageDetail);
            });
      }
    }
    return portLoadablePlanStowageDetailsList;
  }

  private List<PortLoadablePlanBallastDetails> buildPortLoadablePlanBallastDetails(
      LoadingPlanModels.UpdateUllageDetailsResponse response,
      String arrivalDeparture,
      List<VesselInfo.VesselTankDetail> sortedTankList) {
    List<PortLoadablePlanBallastDetails> portLoadablePlanBallastDetailsList = new ArrayList<>();
    List<LoadingPlanModels.PortLoadingPlanBallastDetails> portLoadablePlanBallastDetails =
        response.getPortLoadingPlanBallastTempDetailsList().stream()
            .filter(
                portLoadablePlanBallastDetail ->
                    portLoadablePlanBallastDetail
                            .getArrivalDeparture()
                            .equalsIgnoreCase(arrivalDeparture)
                        && portLoadablePlanBallastDetail
                            .getActualPlanned()
                            .equalsIgnoreCase(ACTUAL))
            .collect(Collectors.toList());

    if (portLoadablePlanBallastDetails.size() == 0) {
      portLoadablePlanBallastDetails =
          response.getPortLoadingPlanBallastDetailsList().stream()
              .filter(
                  portLoadablePlanBallastDetail ->
                      portLoadablePlanBallastDetail
                              .getArrivalDeparture()
                              .equalsIgnoreCase(arrivalDeparture)
                          && portLoadablePlanBallastDetail
                              .getActualPlanned()
                              .equalsIgnoreCase(ACTUAL))
              .collect(Collectors.toList());
    }
    if (portLoadablePlanBallastDetails.size() == 0) {
      portLoadablePlanBallastDetails =
          response.getPortLoadingPlanBallastDetailsList().stream()
              .filter(
                  portLoadablePlanBallastDetail ->
                      portLoadablePlanBallastDetail
                              .getArrivalDeparture()
                              .equalsIgnoreCase(arrivalDeparture)
                          && portLoadablePlanBallastDetail
                              .getActualPlanned()
                              .equalsIgnoreCase(PLANNED))
              .collect(Collectors.toList());
    }
    if (portLoadablePlanBallastDetails.size() > 0) {
      portLoadablePlanBallastDetails.stream()
          .forEach(
              portWiseBallastDetail -> {
                PortLoadablePlanBallastDetails ballastDetails =
                    new PortLoadablePlanBallastDetails();
                ballastDetails.setCargoId(portWiseBallastDetail.getCargoId());
                ballastDetails.setColorCode(
                    StringUtils.isEmpty(portWiseBallastDetail.getColorCode())
                        ? GatewayConstants.BALLAST_COLOR
                        : portWiseBallastDetail.getColorCode());
                ballastDetails.setCorrectedUllage(portWiseBallastDetail.getCorrectedUllage());
                ballastDetails.setCorrectionFactor(portWiseBallastDetail.getCorrectionFactor());
                ballastDetails.setFillingPercentage(portWiseBallastDetail.getFillingPercentage());
                ballastDetails.setId(portWiseBallastDetail.getId());
                ballastDetails.setLoadablePatternId(portWiseBallastDetail.getLoadablePatternId());
                ballastDetails.setDischargePatternId(portWiseBallastDetail.getLoadablePatternId());
                ballastDetails.setTankId(portWiseBallastDetail.getTankId());
                ballastDetails.setTemperature(
                    !portWiseBallastDetail.getTemperature().isEmpty()
                        ? new BigDecimal(portWiseBallastDetail.getTemperature())
                        : null);
                ballastDetails.setQuantity(
                    !portWiseBallastDetail.getQuantity().isEmpty()
                        ? new BigDecimal(portWiseBallastDetail.getQuantity())
                        : null);
                ballastDetails.setArrivalDeparture(portWiseBallastDetail.getArrivalDeparture());
                ballastDetails.setActualPlanned(portWiseBallastDetail.getActualPlanned());
                ballastDetails.setSounding(
                    !portWiseBallastDetail.getSounding().isEmpty()
                        ? new BigDecimal(portWiseBallastDetail.getSounding())
                        : null);
                ballastDetails.setSg(
                    !portWiseBallastDetail.getSg().isEmpty()
                        ? new BigDecimal(portWiseBallastDetail.getSg())
                        : null);

                Optional<VesselInfo.VesselTankDetail> tankDetail =
                    sortedTankList.stream()
                        .filter(
                            vesselTankDetail ->
                                vesselTankDetail.getTankId() == portWiseBallastDetail.getTankId())
                        .findFirst();
                if (tankDetail.isPresent()) {
                  ballastDetails.setTankName(tankDetail.get().getTankName());
                  ballastDetails.setTankShortName(tankDetail.get().getShortName());
                }
                portLoadablePlanBallastDetailsList.add(ballastDetails);
              });
    }
    return portLoadablePlanBallastDetailsList;
  }

  private List<PortLoadablePlanRobDetails> buildPortLoadablePlanRobDetails(
      LoadingPlanModels.UpdateUllageDetailsResponse response,
      String arrivalDeparture,
      List<VesselInfo.VesselTankDetail> sortedTankList) {
    List<PortLoadablePlanRobDetails> portLoadablePlanRobDetailsList = new ArrayList<>();
    List<LoadingPlanModels.PortLoadingPlanRobDetails> portLoadablePlanRobDetails =
        response.getPortLoadingPlanRobDetailsList().stream()
            .filter(
                item ->
                    item.getArrivalDeparture().equalsIgnoreCase(arrivalDeparture)
                        && item.getActualPlanned().equalsIgnoreCase(ACTUAL))
            .collect(Collectors.toList());
    if (portLoadablePlanRobDetails.size() == 0) {
      portLoadablePlanRobDetails =
          response.getPortLoadingPlanRobDetailsList().stream()
              .filter(
                  item ->
                      item.getArrivalDeparture().equalsIgnoreCase(arrivalDeparture)
                          && item.getActualPlanned().equalsIgnoreCase(PLANNED))
              .collect(Collectors.toList());
    }
    if (portLoadablePlanRobDetails.size() > 0) {

      for (VesselInfo.VesselTankDetail tankDetail : sortedTankList) {
        Optional<PortLoadingPlanRobDetails> portLoadablePlanRobDetailsOptional =
            portLoadablePlanRobDetails.stream()
                .filter(robDetail -> robDetail.getTankId() == tankDetail.getTankId())
                .findFirst();
        portLoadablePlanRobDetailsOptional.ifPresent(
            portWiseRobDetail -> {
              PortLoadablePlanRobDetails robDetail = new PortLoadablePlanRobDetails();
              robDetail.setId(portWiseRobDetail.getId());
              robDetail.setLoadablePatternId(portWiseRobDetail.getLoadablePatternId());
              robDetail.setDischargePatternId(portWiseRobDetail.getLoadablePatternId());
              robDetail.setTankId(portWiseRobDetail.getTankId());
              robDetail.setQuantity(portWiseRobDetail.getQuantity());
              robDetail.setArrivalDeparture(portWiseRobDetail.getArrivalDeparture());
              robDetail.setActualPlanned(portWiseRobDetail.getActualPlanned());
              robDetail.setDensity(
                  portWiseRobDetail.getDensity().isEmpty()
                      ? null
                      : new BigDecimal(portWiseRobDetail.getDensity()));
              robDetail.setColorCode(portWiseRobDetail.getColorCode());
              robDetail.setTankName(tankDetail.getTankName());
              robDetail.setTankShortName(tankDetail.getShortName());
              robDetail.setFuelTypeId(tankDetail.getTankCategoryId());
              robDetail.setFuelTypeShortName(tankDetail.getTankCategoryShortName());
              robDetail.setFuelTypeName(tankDetail.getTankCategoryName());

              portLoadablePlanRobDetailsList.add(robDetail);
            });
      }
    }
    return portLoadablePlanRobDetailsList;
  }

  // Function to remove duplicates from an ArrayList
  private <T> List<T> removeDuplicates(List<T> list) {
    // Create a new LinkedHashSet
    Set<T> set = new LinkedHashSet<>();

    // Add the elements to set
    set.addAll(list);

    // Clear the list
    list.clear();

    // add the elements of set
    // with no duplicates to the list
    list.addAll(set);

    // return the list
    return list;
  }

  /**
   * @param referenceId
   * @return StatusReply
   */
  public StatusReply saveJson(Long referenceId, Long jsonTypeId, String json) {
    JsonRequest jsonRequest =
        JsonRequest.newBuilder()
            .setReferenceId(referenceId)
            .setJsonTypeId(jsonTypeId)
            .setJson(json)
            .build();
    return this.loadingPlanGrpcService.saveJson(jsonRequest);
  }

  /**
   * Group tanks based on tank group parameter
   *
   * @param tankList
   * @return
   */
  private List<List<VesselTank>> createGroupWiseTankList(List<LoadableStudy.TankList> tankList) {
    List<List<VesselTank>> tanks = new ArrayList<>();
    for (LoadableStudy.TankList list : tankList) {
      List<VesselTank> tankGroup = new ArrayList<>();
      for (LoadableStudy.TankDetail detail : list.getVesselTankList()) {
        VesselTank tank = new VesselTank();
        tank.setId(detail.getTankId());
        tank.setCategoryId(detail.getTankCategoryId());
        tank.setFrameNumberFrom(detail.getFrameNumberFrom());
        tank.setFrameNumberTo(detail.getFrameNumberTo());
        tank.setShortName(detail.getShortName());
        tank.setCategoryName(detail.getTankCategoryName());
        tank.setName(detail.getTankName());
        tank.setDensity(isEmpty(detail.getDensity()) ? null : new BigDecimal(detail.getDensity()));
        tank.setFillCapcityCubm(
            isEmpty(detail.getFillCapacityCubm())
                ? null
                : new BigDecimal(detail.getFillCapacityCubm()));
        tank.setFullCapacityCubm(
            isEmpty(detail.getFullCapacityCubm()) ? null : detail.getFullCapacityCubm());
        tank.setSlopTank(detail.getIsSlopTank());
        tank.setGroup(detail.getTankGroup());
        tank.setOrder(detail.getTankOrder());
        tank.setHeightFrom(detail.getHeightFrom());
        tank.setHeightTo(detail.getHeightTo());
        tankGroup.add(tank);
      }
      tanks.add(tankGroup);
    }
    return tanks;
  }

  /**
   * Call micro service over grpc
   *
   * @param request
   * @return
   */
  public LoadableStudy.OnHandQuantityReply getOnHandQuantity(
      LoadableStudy.OnHandQuantityRequest request) {
    return this.loadableStudyServiceBlockingStub.getOnHandQuantity(request);
  }

  /**
   * Call vessel info grpc service for synoptical table data
   *
   * @param request
   * @return
   */
  public VesselInfo.VesselReply getVesselDetailForSynopticalTable(
      VesselInfo.VesselRequest request) {
    return this.vesselInfoGrpcService.getVesselDetailForSynopticalTable(request);
  }

  /**
   * Group tanks based on tank group
   *
   * @param tankDetailList
   * @return
   */
  public List<LoadableStudy.TankList> groupTanks(List<VesselInfo.VesselTankDetail> tankDetailList) {
    Map<Integer, List<VesselInfo.VesselTankDetail>> vesselTankMap = new HashMap<>();
    for (VesselInfo.VesselTankDetail tank : tankDetailList) {
      Integer tankGroup = tank.getTankGroup();
      List<VesselInfo.VesselTankDetail> list = null;
      if (null == vesselTankMap.get(tankGroup)) {
        list = new ArrayList<>();
      } else {
        list = vesselTankMap.get(tankGroup);
      }
      list.add(tank);
      vesselTankMap.put(tankGroup, list);
    }
    List<LoadableStudy.TankList> tankList = new ArrayList<>();
    List<LoadableStudy.TankDetail> tankGroup = null;
    for (Map.Entry<Integer, List<VesselInfo.VesselTankDetail>> entry : vesselTankMap.entrySet()) {
      tankGroup = entry.getValue().stream().map(this::buildTankDetail).collect(Collectors.toList());
      Collections.sort(tankGroup, Comparator.comparing(LoadableStudy.TankDetail::getTankOrder));
      tankList.add(LoadableStudy.TankList.newBuilder().addAllVesselTank(tankGroup).build());
    }
    return tankList;
  }

  /**
   * create tank detail
   *
   * @param detail
   * @return
   */
  public LoadableStudy.TankDetail buildTankDetail(VesselInfo.VesselTankDetail detail) {
    LoadableStudy.TankDetail.Builder builder = LoadableStudy.TankDetail.newBuilder();
    builder.setFrameNumberFrom(detail.getFrameNumberFrom());
    builder.setFrameNumberTo(detail.getFrameNumberTo());
    builder.setShortName(detail.getShortName());
    builder.setTankCategoryId(detail.getTankCategoryId());
    builder.setTankCategoryName(detail.getTankCategoryName());
    builder.setTankId(detail.getTankId());
    builder.setTankName(detail.getTankName());
    builder.setIsSlopTank(detail.getIsSlopTank());
    builder.setDensity(detail.getDensity());
    builder.setFillCapacityCubm(detail.getFillCapacityCubm());
    builder.setHeightFrom(detail.getHeightFrom());
    builder.setHeightTo(detail.getHeightTo());
    builder.setTankOrder(detail.getTankOrder());
    builder.setTankDisplayOrder(detail.getTankDisplayOrder());
    builder.setTankGroup(detail.getTankGroup());
    builder.setFullCapacityCubm(detail.getFullCapacityCubm());
    return builder.build();
  }

  @Override
  public UllageBillReply getLoadableStudyShoreTwo(
      String correlationID, UllageBillRequest inputData, boolean isDischarging)
      throws GenericServiceException {

    LoadingPlanModels.UllageBillRequest.Builder builder =
        LoadingPlanModels.UllageBillRequest.newBuilder();

    LoadingPlanModels.BillOfLanding.Builder billOfLandingBuilder =
        LoadingPlanModels.BillOfLanding.newBuilder();

    LoadingPlanModels.UpdateUllage.Builder updateUllageBuilder =
        LoadingPlanModels.UpdateUllage.newBuilder();

    LoadingPlanModels.RobUpdate.Builder updateRobBuilder = LoadingPlanModels.RobUpdate.newBuilder();

    LoadingPlanModels.BallastUpdate.Builder updateBallastBuilder =
        LoadingPlanModels.BallastUpdate.newBuilder();

    LoadingPlanModels.BillOfLandingRemove.Builder updateBillRemoveBuilder =
        LoadingPlanModels.BillOfLandingRemove.newBuilder();

    LoadingPlanModels.CommingleUpdate.Builder updateCommingleBuilder =
        LoadingPlanModels.CommingleUpdate.newBuilder();

    builder.setIsValidate(inputData.getIsValidate());

    UllageBillReply replays = new UllageBillReply();

    try {

      if (inputData.getUllageUpdList().isEmpty()
          || inputData.getBallastUpdateList().isEmpty()
          || inputData.getRobUpdateList().isEmpty()) {
        throw new GenericServiceException(
            "invalid input  error",
            CommonErrorCodes.E_HTTP_BAD_REQUEST,
            HttpStatusCode.valueOf(500));
      }
      inputData
          .getBillOfLandingList()
          .forEach(
              billLanding -> {
                billOfLandingBuilder
                    .setId(StringUtils.isEmpty(billLanding.getId()) ? 0 : billLanding.getId())
                    .setLoadingId(
                        StringUtils.isEmpty(billLanding.getLoadingId())
                            ? 0
                            : billLanding.getLoadingId())
                    .setDischargingId(isDischarging ? billLanding.getDischargingId() : 0)
                    .setPortId(
                        StringUtils.isEmpty(billLanding.getPortId()) ? 0 : billLanding.getPortId())
                    .setCargoId(
                        StringUtils.isEmpty(billLanding.getCargoId())
                            ? 0
                            : billLanding.getCargoId())
                    .setBlRefNumber(
                        StringUtils.isEmpty(billLanding.getBlRefNumber())
                            ? ""
                            : billLanding.getBlRefNumber())
                    .setBblAt60F(
                        StringUtils.isEmpty(billLanding.getBblAt60f())
                            ? "0"
                            : billLanding.getBblAt60f().toString())
                    .setQuantityLt(
                        StringUtils.isEmpty(billLanding.getQuantityLt())
                            ? "0"
                            : billLanding.getQuantityLt().toString())
                    .setQuantityMt(
                        StringUtils.isEmpty(billLanding.getQuantityMt())
                            ? "0"
                            : billLanding.getQuantityMt().toString())
                    .setKlAt15C(
                        StringUtils.isEmpty(billLanding.getKlAt15c())
                            ? "0"
                            : billLanding.getKlAt15c().toString())
                    .setApi(
                        StringUtils.isEmpty(billLanding.getApi())
                            ? "0"
                            : billLanding.getApi().toString())
                    .setTemperature(
                        StringUtils.isEmpty(billLanding.getTemperature())
                            ? "0"
                            : billLanding.getTemperature().toString())
                    .setIsActive(
                        StringUtils.isEmpty(billLanding.getIsActive())
                            ? 0
                            : billLanding.getIsActive().longValue())
                    .setVersion(
                        StringUtils.isEmpty(billLanding.getVersion())
                            ? 0
                            : billLanding.getVersion())
                    .setIsUpdate(
                        billLanding.getIsUpdate() == false ? false : billLanding.getIsUpdate())
                    .build();
                builder.addBillOfLanding(billOfLandingBuilder.build());
              });

      inputData
          .getBillOfLandingListRemove()
          .forEach(
              billLanding -> {
                updateBillRemoveBuilder
                    .setId(billLanding.getId() == null ? 0 : billLanding.getId())
                    .setLoadingId(
                        billLanding.getLoadingId() == null ? 0 : billLanding.getLoadingId())
                    .setDischargingId(isDischarging ? billLanding.getDischargingId() : 0)
                    .setPortId(billLanding.getPortId() == null ? 0 : billLanding.getPortId())
                    .setCargoId(billLanding.getCargoId() == null ? 0 : billLanding.getCargoId())
                    .build();
                builder.addBillOfLandingRemove(updateBillRemoveBuilder.build());
              });

      inputData
          .getUllageUpdList()
          .forEach(
              ullageList -> {
                updateUllageBuilder
                    .setLoadingInformationId(
                        ullageList.getLoadingInformationId() == null
                            ? 0
                            : ullageList.getLoadingInformationId().longValue())
                    .setDischargingInfoId(
                        isDischarging ? ullageList.getDischargingInformationId().longValue() : 0)
                    .setTankId(
                        ullageList.getTankId() == null ? 0 : ullageList.getTankId().longValue())
                    .setTemperature(
                        ullageList.getTemperature() == null
                            ? "0"
                            : ullageList.getTemperature().toString())
                    .setCorrectedUllage(
                        ullageList.getCorrectedUllage() == null
                            ? "0"
                            : ullageList.getCorrectedUllage().toString())
                    .setQuantity(
                        ullageList.getQuantity() == null
                            ? ""
                            : String.valueOf(ullageList.getQuantity()))
                    // DSS 5450 saving volume of cargo for next voyage OBQ
                    .setObservedM3(
                        ullageList.getObservedM3() == null
                            ? ""
                            : String.valueOf(ullageList.getObservedM3()))
                    .setFillingPercentage(
                        ullageList.getFillingPercentage() == null
                            ? "0"
                            : ullageList.getFillingPercentage().toString())
                    // .setFillingRatio(ullageList.getFillingRatio() == null? 0:
                    // ullageList.getFillingRatio().longValue())
                    .setApi(ullageList.getApi() == null ? "0" : ullageList.getApi().toString())
                    .setCargoNominationXid(
                        ullageList.getCargoNominationId() == null
                            ? 0
                            : ullageList.getCargoNominationId().longValue())
                    .setUllage(
                        ullageList.getUllage() == null
                            ? ""
                            : String.valueOf(ullageList.getUllage()))
                    .setPortXid(
                        ullageList.getPort_xid() == null ? 0 : ullageList.getPort_xid().longValue())
                    .setPortRotationXid(
                        ullageList.getPort_rotation_xid() == null
                            ? 0
                            : ullageList.getPort_rotation_xid().longValue())
                    .setArrivalDepartutre(
                        ullageList.getArrival_departutre() == null
                            ? 0
                            : ullageList.getArrival_departutre().intValue())
                    .setActualPlanned(
                        ullageList.getActual_planned() == null
                            ? 0
                            : ullageList.getActual_planned().intValue())
                    .setGrade(ullageList.getGrade() == null ? 0 : ullageList.getGrade().longValue())
                    .setCorrectionFactor(
                        ullageList.getCorrectionFactor() == null
                            ? "0"
                            : ullageList.getCorrectionFactor().toString())
                    .setIsUpdate(ullageList.getIsUpdate())
                    .setColorCode(
                        ullageList.getColor_code() == null ? "" : ullageList.getColor_code())
                    .setAbbreviation(
                        ullageList.getAbbreviation() == null ? "" : ullageList.getAbbreviation())
                    .setCargoId(ullageList.getCargoId() == null ? 0 : ullageList.getCargoId())
                    .build();
                builder.addUpdateUllage(updateUllageBuilder.build());
              });

      inputData
          .getBallastUpdateList()
          .forEach(
              ullageList -> {
                updateBallastBuilder
                    .setLoadingInformationId(
                        ullageList.getLoadingInformationId() == null
                            ? 0
                            : ullageList.getLoadingInformationId().longValue())
                    .setDischargingInformationId(
                        isDischarging ? ullageList.getDischargingInformationId().longValue() : 0)
                    .setTankId(
                        ullageList.getTankId() == null ? 0 : ullageList.getTankId().longValue())
                    .setTemperature(
                        ullageList.getTemperature() == null
                            ? "0"
                            : ullageList.getTemperature().toString())
                    .setCorrectedUllage(
                        ullageList.getCorrectedUllage() == null
                            ? "0"
                            : ullageList.getCorrectedUllage().toString())
                    .setCorrectionFactor(
                        ullageList.getCorrectionFactor() == null
                            ? "0"
                            : ullageList.getCorrectionFactor().toString())
                    .setQuantity(
                        ullageList.getQuantity() == null
                            ? ""
                            : String.valueOf(ullageList.getQuantity()))
                    .setObservedM3(
                        ullageList.getObservedM3() == null
                            ? "0"
                            : ullageList.getObservedM3().toString())
                    .setFillingRatio(
                        ullageList.getFillingRatio() == null
                            ? "0"
                            : ullageList.getFillingRatio().toString())
                    .setSounding(
                        ullageList.getSounding() == null
                            ? ""
                            : String.valueOf(ullageList.getSounding()))
                    .setFillingPercentage(
                        ullageList.getFilling_percentage() == null
                            ? "0"
                            : ullageList.getFilling_percentage().toString())
                    .setArrivalDepartutre(
                        ullageList.getArrival_departutre() == null
                            ? 0
                            : ullageList.getArrival_departutre().intValue())
                    .setActualPlanned(
                        ullageList.getActual_planned() == null
                            ? 0
                            : ullageList.getActual_planned().intValue())
                    .setColorCode(
                        ullageList.getColor_code() == null ? "" : ullageList.getColor_code())
                    .setSg(ullageList.getSg() == null ? "0" : ullageList.getSg().toString())
                    .setPortXid(ullageList.getPortXId() == null ? 0 : ullageList.getPortXId())
                    .setPortRotationXid(
                        ullageList.getPortRotationXId() == null
                            ? 0
                            : ullageList.getPortRotationXId())
                    .setIsUpdate(
                        ullageList.getIsUpdate() == false ? false : ullageList.getIsUpdate())
                    .build();
                builder.addBallastUpdate(updateBallastBuilder.build());
              });

      inputData
          .getRobUpdateList()
          .forEach(
              ullageList -> {
                updateRobBuilder
                    .setLoadingInformationId(
                        ullageList.getLoadingInformationId() == null
                            ? 0
                            : ullageList.getLoadingInformationId().longValue())
                    .setDischargingInformationId(
                        isDischarging ? ullageList.getDischargingInformationId().longValue() : 0)
                    .setTankId(
                        ullageList.getTankId() == null ? 0 : ullageList.getTankId().longValue())
                    .setTemperature(
                        ullageList.getTemperature() == null
                            ? "0"
                            : ullageList.getTemperature().toString())
                    // .setCorrectedUllage(ullageList.getCorrectedUllage() == null? 0:
                    // ullageList.getCorrectedUllage().longValue())
                    // .setCorrectionFactor(ullageList.getCorrectionFactor() == null ? 0:
                    // ullageList.getCorrectionFactor().longValue())
                    .setQuantity(
                        ullageList.getQuantity() == null
                            ? ""
                            : String.valueOf(ullageList.getQuantity()))
                    .setIsUpdate(ullageList.getIsUpdate())
                    .setDensity(
                        ullageList.getDensity() == null ? "" : ullageList.getDensity().toString())
                    // .setObservedM3(ullageList.getObservedM3() == null? 0:
                    // ullageList.getObservedM3().longValue())
                    // .setFillingRatio(ullageList.getFillingRatio() == null? 0:
                    // ullageList.getFillingRatio().longValue())
                    .setColourCode(
                        ullageList.getColour_code() == null ? "" : ullageList.getColour_code())
                    .setArrivalDepartutre(
                        ullageList.getArrival_departutre() == null
                            ? 0
                            : ullageList.getArrival_departutre().intValue())
                    .setActualPlanned(
                        ullageList.getActual_planned() == null
                            ? 0
                            : ullageList.getActual_planned().intValue())
                    .setPortXid(ullageList.getPortXId() == null ? 0 : ullageList.getPortXId())
                    .setPortRotationXid(
                        ullageList.getPortRotationXId() == null
                            ? 0
                            : ullageList.getPortRotationXId())
                    .build();
                builder.addRobUpdate(updateRobBuilder.build());
              });
      if (inputData.getCommingleUpdateList() != null) {
        inputData
            .getCommingleUpdateList()
            .forEach(
                commingle -> {
                  updateCommingleBuilder
                      .setLoadingInformationId(
                          commingle.getLoadingInformationId() == null
                              ? 0
                              : commingle.getLoadingInformationId().longValue())
                      .setDischargingInformationId(
                          commingle.getDischargingInformationId() == null
                              ? 0
                              : commingle.getDischargingInformationId())
                      .setTankId(
                          commingle.getTankId() == null ? 0 : commingle.getTankId().longValue())
                      .setTemperature(
                          commingle.getTemperature() == null
                              ? "0"
                              : commingle.getTemperature().toString())
                      .setQuantityMT(
                          commingle.getQuantityMT() == null
                              ? "0"
                              : commingle.getQuantityMT().toString())
                      .setFillingPercentage(
                          commingle.getFillingPercentage() == null
                              ? "0"
                              : commingle.getFillingPercentage().toString())
                      .setApi(commingle.getApi() == null ? "0" : commingle.getApi().toString())
                      .setCargoNomination1Id(
                          commingle.getCargoNomination1Id() == null
                              ? 0
                              : commingle.getCargoNomination1Id().longValue())
                      .setCargoNomination2Id(
                          commingle.getCargoNomination2Id() == null
                              ? 0
                              : commingle.getCargoNomination2Id().longValue())
                      .setUllage(
                          commingle.getUllage() == null ? "" : commingle.getUllage().toString())
                      .setArrivalDeparture(
                          commingle.getArrival_departutre() == null
                              ? 0
                              : commingle.getArrival_departutre().intValue())
                      .setActualPlanned(
                          commingle.getActual_planned() == null
                              ? 0
                              : commingle.getActual_planned().intValue())
                      .setIsUpdate(commingle.getIsUpdate())
                      .setAbbreviation(
                          commingle.getAbbreviation() == null ? "" : commingle.getAbbreviation())
                      .setCargo1Id(commingle.getCargo1Id() == null ? 0 : commingle.getCargo1Id())
                      .setCargo2Id(commingle.getCargo2Id() == null ? 0 : commingle.getCargo2Id())
                      .setQuantity1MT(
                          commingle.getQuantity1MT() == null
                              ? ""
                              : commingle.getQuantity1MT().toString())
                      .setQuantity2MT(
                          commingle.getQuantity2MT() == null
                              ? ""
                              : commingle.getQuantity2MT().toString())
                      .setQuantity1M3(
                          commingle.getQuantity1M3() == null
                              ? ""
                              : commingle.getQuantity1M3().toString())
                      .setQuantity2M3(
                          commingle.getQuantity2M3() == null
                              ? ""
                              : commingle.getQuantity2M3().toString())
                      .setUllage1(
                          commingle.getUllage1() == null ? "" : commingle.getUllage1().toString())
                      .setUllage2(
                          commingle.getUllage2() == null ? "" : commingle.getUllage2().toString())
                      .setColorCode(
                          commingle.getColorCode() == null ? "" : commingle.getColorCode())
                      .build();
                  builder.addCommingleUpdate(updateCommingleBuilder.build());
                });
      }
    } catch (Exception e) {
      log.error("GenericServiceException when update LoadableStudy", e);
      throw new GenericServiceException(
          "failed to get or save UllageBill ",
          replays.getResponseStatus().getStatus(),
          HttpStatusCode.valueOf(500));
    }

    if (isDischarging) {
      com.cpdss.common.generated.loading_plan.LoadingPlanModels.UllageBillReply
          dischargeUllageReply =
              dischargePlanServiceBlockingStub.updateDischargeUllageDetails(builder.build());
      if (!SUCCESS.equals(dischargeUllageReply.getResponseStatus().getStatus())) {
        throw new GenericServiceException(
            "failed to get or save UllageBill ",
            dischargeUllageReply.getResponseStatus().getStatus(),
            HttpStatusCode.valueOf(500));
      }
      replays.setProcessId(dischargeUllageReply.getProcessId());
      replays.setResponseStatus(
          new CommonSuccessResponse(
              dischargeUllageReply.getResponseStatus().getStatus(),
              dischargeUllageReply.getResponseStatus().getCode()));
    } else {
      replays = loadingPlanGrpcService.getLoadableStudyShoreTwo(correlationID, builder);
      if (!SUCCESS.equals(replays.getResponseStatus().getStatus())) {
        throw new GenericServiceException(
            "failed to get or save UllageBill ",
            replays.getResponseStatus().getStatus(),
            HttpStatusCode.valueOf(500));
      }
      replays.setResponseStatus(
          new CommonSuccessResponse(
              String.valueOf(HttpStatus.OK.value()), "Ullage Updated Successfully"));
    }

    return replays;
  }

  private List<LoadablePlanCommingleDetails> buildLoadableCommingleDetails(
      LoadingPlanModels.UpdateUllageDetailsResponse response,
      String arrivalDeparture,
      List<VesselInfo.VesselTankDetail> sortedTankList) {
    List<LoadablePlanCommingleDetails> loadablePlanCommingleDetailsList = new ArrayList<>();
    List<LoadingPlanModels.LoadablePlanCommingleDetails> commingleDetails =
        response.getLoadablePlanCommingleTempDetailsList();

    // if no value in temp take actual
    if (commingleDetails.size() == 0) {
      commingleDetails =
          response.getLoadablePlanCommingleDetailsList().stream()
              .filter(
                  commingleDetail ->
                      arrivalDeparture.equalsIgnoreCase(commingleDetail.getArrivalDeparture())
                          && ACTUAL.equalsIgnoreCase(commingleDetail.getActualPlanned()))
              .collect(Collectors.toList());
    }
    // if no actual values take planned
    if (commingleDetails.size() == 0) {
      commingleDetails =
          response.getLoadablePlanCommingleDetailsList().stream()
              .filter(
                  commingleDetail ->
                      commingleDetail.getArrivalDeparture().equalsIgnoreCase(arrivalDeparture)
                          && commingleDetail.getActualPlanned().equalsIgnoreCase(PLANNED))
              .collect(Collectors.toList());
    }
    if (commingleDetails.size() > 0) {
      commingleDetails.stream()
          .forEach(
              commingleDetail -> {
                LoadablePlanCommingleDetails commingle = new LoadablePlanCommingleDetails();
                commingle.setId(commingleDetail.getId());
                commingle.setLoadingInformationId(commingleDetail.getLoadingInformationId());
                commingle.setLoadablePatternId(commingleDetail.getLoadablePatternId());
                commingle.setDischargePatternId(commingleDetail.getLoadablePatternId());
                commingle.setCargoNomination1Id(commingleDetail.getCargoNomination1Id());
                commingle.setCargoNomination2Id(commingleDetail.getCargoNomination2Id());
                commingle.setCargo1Id(commingleDetail.getCargo1Id());
                commingle.setCargo2Id(commingleDetail.getCargo2Id());
                commingle.setTankId(commingleDetail.getTankId());
                commingle.setQuantity(
                    commingleDetail.getQuantity().isEmpty()
                        ? null
                        : Double.parseDouble(commingleDetail.getQuantity()));
                commingle.setLoadingInformationId(commingle.getLoadingInformationId());
                commingle.setDischargeInformationId(commingle.getLoadingInformationId());
                commingle.setGrade(commingleDetail.getGrade());
                commingle.setTankName(commingleDetail.getTankName());
                commingle.setQuantity(
                    commingleDetail.getQuantity().isEmpty()
                        ? null
                        : Double.parseDouble(commingleDetail.getQuantity()));
                commingle.setApi(
                    commingleDetail.getApi().isEmpty()
                        ? null
                        : Double.parseDouble(commingleDetail.getApi()));
                commingle.setTemperature(
                    commingleDetail.getTemperature().isEmpty()
                        ? null
                        : Double.parseDouble(commingleDetail.getTemperature()));
                commingle.setCargo1Abbreviation(commingleDetail.getCargo1Abbreviation());
                commingle.setCargo2Abbreviation(commingleDetail.getCargo2Abbreviation());
                commingle.setCargo1Percentage(
                    commingleDetail.getCargo1Percentage().isEmpty()
                        ? null
                        : Double.parseDouble(commingleDetail.getCargo1Percentage()));
                commingle.setCargo2Percentage(
                    commingleDetail.getCargo2Percentage().isEmpty()
                        ? null
                        : Double.parseDouble(commingleDetail.getCargo2Percentage()));
                commingle.setCargo1BblsDbs(
                    commingleDetail.getCargo1BblsDbs().isEmpty()
                        ? null
                        : Double.parseDouble(commingleDetail.getCargo1BblsDbs()));
                commingle.setCargo2BblsDbs(
                    commingleDetail.getCargo2BblsDbs().isEmpty()
                        ? null
                        : Double.parseDouble(commingleDetail.getCargo2BblsDbs()));
                commingle.setCargo1Bbls60f(
                    commingleDetail.getCargo1Bbls60F().isEmpty()
                        ? null
                        : Double.parseDouble(commingleDetail.getCargo1Bbls60F()));
                commingle.setCargo2Bbls60f(
                    commingleDetail.getCargo2Bbls60F().isEmpty()
                        ? null
                        : Double.parseDouble(commingleDetail.getCargo2Bbls60F()));
                commingle.setCargo1Lt(
                    commingleDetail.getCargo1Lt().isEmpty()
                        ? null
                        : Double.parseDouble(commingleDetail.getCargo1Lt()));
                commingle.setCargo2Lt(
                    commingleDetail.getCargo2Lt().isEmpty()
                        ? null
                        : Double.parseDouble(commingleDetail.getCargo2Lt()));
                commingle.setCargo1Mt(
                    commingleDetail.getCargo1Mt().isEmpty()
                        ? null
                        : Double.parseDouble(commingleDetail.getCargo1Mt()));
                commingle.setCargo2Mt(
                    commingleDetail.getCargo2Mt().isEmpty()
                        ? null
                        : Double.parseDouble(commingleDetail.getCargo2Mt()));
                commingle.setCargo1Kl(
                    commingleDetail.getCargo1Kl().isEmpty()
                        ? null
                        : Double.parseDouble(commingleDetail.getCargo1Kl()));
                commingle.setCargo2Kl(
                    commingleDetail.getCargo2Kl().isEmpty()
                        ? null
                        : Double.parseDouble(commingleDetail.getCargo2Kl()));
                commingle.setPriority(commingleDetail.getPriority());
                commingle.setOrderQuantity(
                    commingleDetail.getOrderQuantity().isEmpty()
                        ? null
                        : Double.parseDouble(commingleDetail.getOrderQuantity()));
                commingle.setLoadingOrder(commingleDetail.getLoadingOrder());
                commingle.setTankId(commingleDetail.getTankId());
                commingle.setFillingRatio(
                    commingleDetail.getFillingRatio().isEmpty()
                        ? null
                        : Double.parseDouble(commingleDetail.getFillingRatio()));
                commingle.setCorrectedUllage(
                    commingleDetail.getCorrectedUllage().isEmpty()
                        ? null
                        : Double.parseDouble(commingleDetail.getCorrectedUllage()));
                commingle.setCorrectionFactor(
                    commingleDetail.getCorrectionFactor().isEmpty()
                        ? null
                        : Double.parseDouble(commingleDetail.getCorrectionFactor()));
                commingle.setRdgUllage(
                    commingleDetail.getRdgUllage().isEmpty()
                        ? null
                        : Double.parseDouble(commingleDetail.getRdgUllage()));
                commingle.setSlopQuantity(
                    commingleDetail.getSlopQuantity().isEmpty()
                        ? null
                        : Double.parseDouble(commingleDetail.getSlopQuantity()));
                commingle.setTimeRequiredForLoading(
                    commingleDetail.getTimeRequiredForLoading().isEmpty()
                        ? null
                        : Double.parseDouble(commingleDetail.getTimeRequiredForLoading()));
                commingle.setQuantity1MT(
                    commingleDetail.getQuantity1MT().isEmpty()
                        ? null
                        : Double.parseDouble(commingleDetail.getQuantity1MT()));
                commingle.setQuantity2MT(
                    commingleDetail.getQuantity2MT().isEmpty()
                        ? null
                        : Double.parseDouble(commingleDetail.getQuantity2MT()));
                commingle.setQuantity1M3(
                    commingleDetail.getQuantity1M3().isEmpty()
                        ? null
                        : Double.parseDouble(commingleDetail.getQuantity1M3()));
                commingle.setQuantity2M3(
                    commingleDetail.getQuantity2M3().isEmpty()
                        ? null
                        : Double.parseDouble(commingleDetail.getQuantity2M3()));
                commingle.setUllage1(
                    commingleDetail.getUllage1().isEmpty()
                        ? null
                        : Double.parseDouble(commingleDetail.getUllage1()));
                commingle.setUllage2(
                    commingleDetail.getUllage2().isEmpty()
                        ? null
                        : Double.parseDouble(commingleDetail.getUllage2()));
                commingle.setColorCode(commingleDetail.getColorCode());
                commingle.setUllage(
                    commingleDetail.getUllage().isEmpty()
                        ? null
                        : Double.parseDouble(commingleDetail.getUllage()));
                Optional<VesselInfo.VesselTankDetail> tankDetail =
                    sortedTankList.stream()
                        .filter(
                            vesselTankDetail ->
                                vesselTankDetail.getTankId() == commingleDetail.getTankId())
                        .findFirst();
                if (tankDetail.isPresent()) {
                  commingle.setTankName(tankDetail.get().getTankName());
                }

                loadablePlanCommingleDetailsList.add(commingle);
              });
    }
    return loadablePlanCommingleDetailsList;
  }

  @Override
  public UploadTideDetailResponse uploadLoadingTideDetails(
      Long loadingId, MultipartFile file, String correlationId, String portName, Long portId)
      throws IOException, GenericServiceException {
    return loadingInformationService.uploadLoadingTideDetails(
        loadingId, file, correlationId, portName, portId);
  }

  @Override
  public byte[] downloadLoadingPortTideDetails(Long loadingId) throws GenericServiceException {
    return loadingInformationService.downloadLoadingPortTideDetails(loadingId);
  }

  private Long castInput(String inputData) {
    return StringUtils.isEmpty(inputData) ? 0 : Long.parseLong(inputData);
  }

  /** Import ullage report file and parse the content from the file and send it in response. */
  @Override
  public ListOfUllageReportResponse importUllageReportFile(
      MultipartFile file,
      String tankDetails,
      Long infoId,
      Long cargoNominationId,
      String correlationId,
      boolean isLoading,
      Long vesselId)
      throws GenericServiceException, IOException {
    return ullageReportFileParsingService.importUllageReportFile(
        file, tankDetails, infoId, cargoNominationId, correlationId, isLoading, vesselId);
  }

  /*
  private Long castInput(String input){
    if (input == null || input.isEmpty() || input.isBlank()){
      return 0l;
    }
    try{
      return Long.parseLong(input);
    }catch(Exception e) {
      return 0l;
    }

  }*/
  @Override
  public LoadingSimulatorJsonResponse getSimulatorJsonDataForLoading(
      Long vesselId, Long infoId, String correlationId)
      throws GenericServiceException, JsonProcessingException {
    com.cpdss.common.generated.LoadableStudy.LoadingSimulatorJsonRequest.Builder requestBuilder =
        com.cpdss.common.generated.LoadableStudy.LoadingSimulatorJsonRequest.newBuilder();
    requestBuilder.setVesselId(vesselId);
    requestBuilder.setInfoId(infoId);
    com.cpdss.common.generated.LoadableStudy.LoadingSimulatorJsonReply reply =
        loadableStudyServiceBlockingStub.getLoadingSimulatorJsonData(requestBuilder.build());
    LoadingSimulatorJsonResponse jsonResponse = new LoadingSimulatorJsonResponse();
    Object loadingJson =
        new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .readValue(reply.getLoadingJson(), Object.class);
    jsonResponse.setLoadingJson(loadingJson);
    Object loadicatorJson = null;
    if (reply.getLoadicatorJson() != null && !reply.getLoadicatorJson().isEmpty()) {
      loadicatorJson =
          new ObjectMapper()
              .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
              .readValue(reply.getLoadicatorJson(), Object.class);
    }
    jsonResponse.setLoadicatorJson(loadicatorJson);
    jsonResponse.setResponseStatus(
        new CommonSuccessResponse(String.valueOf(HttpStatus.OK.value()), correlationId));
    return jsonResponse;
  }

  @Override
  public String prepareFileName(Long vesselId, Long voyageId, Long portRotationId) {
    Long portId =
        this.loadableStudyServiceBlockingStub
            .getLoadableStudyPortRotationByPortRotationId(
                LoadableStudy.PortRotationRequest.newBuilder().setId(portRotationId).build())
            .getPortRotationDetail()
            .getPortId();
    return this.vesselInfoGrpcService
            .getVesselInfoByVesselId(
                VesselInfo.VesselIdRequest.newBuilder().setVesselId(vesselId).build())
            .getVesselDetail()
            .getName()
        + " - "
        + this.loadableStudyServiceBlockingStub
            .getVoyageByVoyageId(
                com.cpdss.common.generated.LoadableStudy.VoyageInfoRequest.newBuilder()
                    .setVoyageId(voyageId)
                    .build())
            .getVoyageDetail()
            .getVoyageNumber()
        + " - "
        + this.portInfoGrpcService
            .getPortInfoByPortIds(
                PortInfo.GetPortInfoByPortIdsRequest.newBuilder().addId(portId).build())
            .getPorts(0)
            .getName()
        + " - ";
  }
}
