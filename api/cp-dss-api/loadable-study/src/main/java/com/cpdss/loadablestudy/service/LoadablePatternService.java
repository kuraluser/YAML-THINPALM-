/* Licensed at AlphaOri Technologies */
package com.cpdss.loadablestudy.service;

import static com.cpdss.loadablestudy.utility.LoadableStudiesConstants.*;
import static java.util.Optional.ofNullable;

import com.cpdss.common.exception.GenericServiceException;
import com.cpdss.common.generated.Common;
import com.cpdss.common.generated.EnvoyWriter;
import com.cpdss.common.generated.LoadableStudy.AlgoResponseCommunication;
import com.cpdss.common.generated.LoadableStudy.LoadablePlanDetails;
import com.cpdss.common.generated.LoadableStudy.LoadablePlanPortWiseDetails;
import com.cpdss.common.generated.LoadableStudy.LoadableQuantityCargoDetails;
import com.cpdss.common.generated.LoadableStudy.StabilityParameter;
import com.cpdss.common.generated.VesselInfo;
import com.cpdss.common.generated.VesselInfoServiceGrpc;
import com.cpdss.common.rest.CommonErrorCodes;
import com.cpdss.common.utils.HttpStatusCode;
import com.cpdss.common.utils.MessageTypes;
import com.cpdss.loadablestudy.domain.*;
import com.cpdss.loadablestudy.entity.CommingleCargo;
import com.cpdss.loadablestudy.entity.CowTypeMaster;
import com.cpdss.loadablestudy.entity.DischargePatternQuantityCargoPortwiseDetails;
import com.cpdss.loadablestudy.entity.DischargePlanCowDetailFromAlgo;
import com.cpdss.loadablestudy.entity.LoadablePattern;
import com.cpdss.loadablestudy.entity.LoadablePatternAlgoStatus;
import com.cpdss.loadablestudy.entity.LoadablePatternCargoToppingOffSequence;
import com.cpdss.loadablestudy.entity.LoadablePlanBallastDetails;
import com.cpdss.loadablestudy.entity.LoadablePlanCommingleDetails;
import com.cpdss.loadablestudy.entity.LoadablePlanComminglePortwiseDetails;
import com.cpdss.loadablestudy.entity.LoadablePlanConstraints;
import com.cpdss.loadablestudy.entity.LoadablePlanQuantity;
import com.cpdss.loadablestudy.entity.LoadablePlanStowageBallastDetails;
import com.cpdss.loadablestudy.entity.LoadablePlanStowageDetails;
import com.cpdss.loadablestudy.entity.LoadablePlanStowageDetailsTemp;
import com.cpdss.loadablestudy.entity.LoadableQuantity;
import com.cpdss.loadablestudy.entity.LoadableStudy;
import com.cpdss.loadablestudy.entity.LoadableStudyAlgoStatus;
import com.cpdss.loadablestudy.entity.LoadableStudyCommunicationStatus;
import com.cpdss.loadablestudy.entity.LoadableStudyPortRotation;
import com.cpdss.loadablestudy.entity.StabilityParameters;
import com.cpdss.loadablestudy.entity.Voyage;
import com.cpdss.loadablestudy.repository.AlgoErrorHeadingRepository;
import com.cpdss.loadablestudy.repository.AlgoErrorsRepository;
import com.cpdss.loadablestudy.repository.CargoOperationRepository;
import com.cpdss.loadablestudy.repository.CommingleCargoRepository;
import com.cpdss.loadablestudy.repository.CowTypeMasterRepository;
import com.cpdss.loadablestudy.repository.DischargePatternQuantityCargoPortwiseRepository;
import com.cpdss.loadablestudy.repository.JsonDataRepository;
import com.cpdss.loadablestudy.repository.LoadablePatternAlgoStatusRepository;
import com.cpdss.loadablestudy.repository.LoadablePatternCargoDetailsRepository;
import com.cpdss.loadablestudy.repository.LoadablePatternCargoToppingOffSequenceRepository;
import com.cpdss.loadablestudy.repository.LoadablePatternRepository;
import com.cpdss.loadablestudy.repository.LoadablePlanBallastDetailsRepository;
import com.cpdss.loadablestudy.repository.LoadablePlanCommingleDetailsPortwiseRepository;
import com.cpdss.loadablestudy.repository.LoadablePlanCommingleDetailsRepository;
import com.cpdss.loadablestudy.repository.LoadablePlanConstraintsRespository;
import com.cpdss.loadablestudy.repository.LoadablePlanQuantityRepository;
import com.cpdss.loadablestudy.repository.LoadablePlanStowageBallastDetailsRepository;
import com.cpdss.loadablestudy.repository.LoadablePlanStowageDetailsRespository;
import com.cpdss.loadablestudy.repository.LoadablePlanStowageDetailsTempRepository;
import com.cpdss.loadablestudy.repository.LoadableQuantityRepository;
import com.cpdss.loadablestudy.repository.LoadableStudyAlgoStatusRepository;
import com.cpdss.loadablestudy.repository.LoadableStudyCommunicationStatusRepository;
import com.cpdss.loadablestudy.repository.LoadableStudyPortRotationRepository;
import com.cpdss.loadablestudy.repository.LoadableStudyRepository;
import com.cpdss.loadablestudy.repository.LoadableStudyStatusRepository;
import com.cpdss.loadablestudy.repository.StabilityParameterRepository;
import com.cpdss.loadablestudy.repository.SynopticalTableLoadicatorDataRepository;
import com.cpdss.loadablestudy.repository.SynopticalTableRepository;
import com.cpdss.loadablestudy.repository.VoyageRepository;
import com.cpdss.loadablestudy.repository.projections.PortRotationIdAndPortId;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

/**
 * Master Service for Loadable Pattern
 *
 * @author vinothkumar M
 * @since 08-07-2021
 */
@Slf4j
@Service
public class LoadablePatternService {

  @Autowired private LoadablePatternRepository loadablePatternRepository;

  @Autowired private LoadablePlanService loadablePlanService;

  @Autowired private LoadablePlanCommingleDetailsRepository loadablePlanCommingleDetailsRepository;

  @Autowired private VoyageRepository voyageRepository;

  @Autowired private LoadableStudyRepository loadableStudyRepository;

  @Autowired
  private LoadableStudyCommunicationStatusRepository loadableStudyCommunicationStatusRepository;

  @Autowired private LoadableStudyAlgoStatusRepository loadableStudyAlgoStatusRepository;

  @Autowired private LoadableStudyPortRotationService loadableStudyPortRotationService;

  @Autowired private CargoOperationRepository cargoOperationRepository;

  @Autowired private AlgoErrorsRepository algoErrorsRepository;

  @Autowired private AlgoErrorHeadingRepository algoErrorHeadingRepository;

  @Autowired private LoadablePlanConstraintsRespository loadablePlanConstraintsRespository;

  @Autowired private LoadableQuantityService loadableQuantityService;

  @Autowired private LoadablePatternCargoToppingOffSequenceRepository toppingOffSequenceRepository;

  @Autowired private LoadablePatternCargoDetailsRepository loadablePatternCargoDetailsRepository;

  @Autowired private JsonDataRepository jsonDataRepository;

  @Autowired
  private DischargePatternQuantityCargoPortwiseRepository
      dischargePatternQuantityCargoPortwiseRepository;

  @Autowired private LoadablePlanBallastDetailsRepository loadablePlanBallastDetailsRepository;

  @Autowired
  private LoadablePlanStowageBallastDetailsRepository loadablePlanStowageBallastDetailsRepository;

  @Autowired private LoadableStudyPortRotationRepository loadableStudyPortRotationRepository;

  @Autowired private LoadablePlanStowageDetailsRespository loadablePlanStowageDetailsRespository;

  @Autowired private LoadablePatternAlgoStatusRepository loadablePatternAlgoStatusRepository;

  @Autowired private StabilityParameterRepository stabilityParameterRepository;

  @Autowired private LoadicatorService loadicatorService;

  @Autowired
  private LoadablePlanCommingleDetailsPortwiseRepository
      loadablePlanCommingleDetailsPortwiseRepository;

  @Autowired private AlgoService algoService;

  @Autowired private LoadablePlanStowageDetailsTempRepository stowageDetailsTempRepository;

  @Autowired private LoadablePlanQuantityRepository loadablePlanQuantityRepository;

  @Autowired
  private SynopticalTableLoadicatorDataRepository synopticalTableLoadicatorDataRepository;

  @Autowired private VoyageService voyageService;

  @Autowired private CargoNominationService cargoNominationService;

  @Autowired private LoadableStudyStatusRepository loadableStudyStatusRepository;

  @Autowired private LoadableQuantityRepository loadableQuantityRepository;

  @Autowired private RestTemplate restTemplate;

  @Autowired private LoadableStudyService loadableStudyService;
  @Autowired JsonDataService jsonDataService;
  @Autowired CommunicationService communicationService;
  @Autowired private OnHandQuantityService onHandQuantityService;

  @Autowired private CowTypeMasterRepository cowTypeMasterRepository;

  @Autowired DischargePlanService dischargePlanService;

  @Autowired private CommingleCargoRepository commingleCargoRepository;

  @Autowired
  private LoadablePatternCargoToppingOffSequenceRepository cargoToppingOffSequenceRepository;

  @Autowired CargoService cargoService;

  @Value("${loadablestudy.attachement.rootFolder}")
  private String rootFolder;

  @Value("${algo.loadablestudy.api.url}")
  private String loadableStudyUrl;

  @GrpcClient("vesselInfoService")
  private VesselInfoServiceGrpc.VesselInfoServiceBlockingStub vesselInfoGrpcService;

  @Value("${cpdss.communication.enable}")
  private boolean enableCommunication;

  @Value("${cpdss.build.env}")
  private String env;

  /**
   * @param loadableStudy
   * @throws GenericServiceException
   */
  public void isPatternGeneratedOrConfirmed(LoadableStudy loadableStudy)
      throws GenericServiceException {
    List<LoadablePattern> generatedPatterns =
        this.loadablePatternRepository.findLoadablePatterns(
            LOADABLE_STUDY_STATUS_PLAN_GENERATED_ID, loadableStudy, true);
    List<LoadablePattern> confirmedPatterns =
        this.loadablePatternRepository.findLoadablePatterns(
            CONFIRMED_STATUS_ID, loadableStudy, true);
    if (!generatedPatterns.isEmpty() || !confirmedPatterns.isEmpty()) {
      throw new GenericServiceException(
          "Save/Edit/Delte not allowed for plan generated /confirmed loadable study",
          CommonErrorCodes.E_CPDSS_SAVE_NOT_ALLOWED,
          HttpStatusCode.BAD_REQUEST);
    }
  }

  public void getLoadableCommingleByPatternId(
      com.cpdss.common.generated.LoadableStudy.LoadablePlanDetailsRequest request,
      com.cpdss.common.generated.LoadableStudy.LoadableCommingleDetailsReply.Builder builder)
      throws Exception {
    Optional<LoadablePattern> loadablePatternOpt =
        this.loadablePatternRepository.findByIdAndIsActive(request.getLoadablePatternId(), true);
    if (loadablePatternOpt.isPresent()) {
      List<LoadablePlanCommingleDetails> loadablePlanCommingleDetails =
          this.loadablePlanCommingleDetailsRepository.findByLoadablePatternAndIsActive(
              loadablePatternOpt.get(), true);
      com.cpdss.common.generated.LoadableStudy.LoadableQuantityCommingleCargoDetails.Builder
          loadableCommingle =
              com.cpdss.common.generated.LoadableStudy.LoadableQuantityCommingleCargoDetails
                  .newBuilder();
      loadablePlanCommingleDetails.forEach(
          lpcd -> {
            com.cpdss.common.generated.LoadableStudy.LoadableQuantityCommingleCargoDetails.Builder
                loadableQtyCommCargo = getCommingleCargoBuilder(lpcd);
            builder.addLoadableQuantityCommingleCargoDetails(loadableQtyCommCargo);
          });
      builder.setResponseStatus(Common.ResponseStatus.newBuilder().setStatus(SUCCESS).build());
    } else throw new Exception("Cannot find loadable pattern");
    builder.setResponseStatus(Common.ResponseStatus.newBuilder().setStatus(SUCCESS).build());
  }

  private com.cpdss.common.generated.LoadableStudy.LoadableQuantityCommingleCargoDetails.Builder
      getCommingleCargoBuilder(LoadablePlanCommingleDetails lpcd) {
    com.cpdss.common.generated.LoadableStudy.LoadableQuantityCommingleCargoDetails.Builder builder =
        com.cpdss.common.generated.LoadableStudy.LoadableQuantityCommingleCargoDetails.newBuilder();
    ofNullable(lpcd.getId()).ifPresent(builder::setId);
    ofNullable(lpcd.getApi()).ifPresent(builder::setApi);
    ofNullable(lpcd.getCargo1Abbreviation()).ifPresent(builder::setCargo1Abbreviation);
    ofNullable(lpcd.getCargo1Bbls60f()).ifPresent(builder::setCargo1Bbls60F);
    ofNullable(lpcd.getCargo1BblsDbs()).ifPresent(builder::setCargo1Bblsdbs);
    ofNullable(lpcd.getCargo1Kl()).ifPresent(builder::setCargo1KL);
    ofNullable(lpcd.getCargo1Lt()).ifPresent(builder::setCargo1LT);
    ofNullable(lpcd.getCargo1Mt()).ifPresent(builder::setCargo1MT);
    ofNullable(lpcd.getCargo1Percentage()).ifPresent(builder::setCargo1Percentage);
    ofNullable(lpcd.getCargo2Abbreviation()).ifPresent(builder::setCargo2Abbreviation);
    ofNullable(lpcd.getCargo2Bbls60f()).ifPresent(builder::setCargo2Bbls60F);
    ofNullable(lpcd.getCargo2BblsDbs()).ifPresent(builder::setCargo2Bblsdbs);
    ofNullable(lpcd.getCargo2Kl()).ifPresent(builder::setCargo2KL);
    ofNullable(lpcd.getCargo2Lt()).ifPresent(builder::setCargo2LT);
    ofNullable(lpcd.getCargo2Mt()).ifPresent(builder::setCargo2MT);
    ofNullable(lpcd.getCargo2Percentage()).ifPresent(builder::setCargo2Percentage);
    ofNullable(lpcd.getGrade()).ifPresent(builder::setGrade);
    ofNullable(lpcd.getQuantity()).ifPresent(builder::setQuantity);
    ofNullable(lpcd.getTankName()).ifPresent(builder::setTankName);
    ofNullable(lpcd.getTemperature()).ifPresent(builder::setTemp);
    ofNullable(lpcd.getTankShortName()).ifPresent(builder::setTankShortName);
    return builder;
  }

  public com.cpdss.common.generated.LoadableStudy.LoadablePatternPortWiseDetailsJson.Builder
      getLoadablePatternDetailsJson(
          com.cpdss.common.generated.LoadableStudy.LoadablePlanDetailsRequest request,
          com.cpdss.common.generated.LoadableStudy.LoadablePatternPortWiseDetailsJson.Builder
              builder)
          throws Exception {
    Optional<LoadablePattern> loadablePatternOpt =
        this.loadablePatternRepository.findByIdAndIsActive(request.getLoadablePatternId(), true);
    if (loadablePatternOpt.isPresent()) {
      LoadabalePatternValidateRequest loadabalePatternValidateRequest =
          new LoadabalePatternValidateRequest();
      if (request.getIsDischargePlan()) { // in this case, we can skip last loading port check
        dischargePlanService.buildDischargeablePlanPortWiseDetails(
            loadablePatternOpt.get(), loadabalePatternValidateRequest);
      } else {
        loadablePlanService.buildLoadablePlanPortWiseDetails(
            loadablePatternOpt.get(), loadabalePatternValidateRequest);
      }
      ObjectMapper mapper = new ObjectMapper();
      builder.setLoadablePatternDetails(
          mapper.writeValueAsString(
              loadabalePatternValidateRequest.getLoadablePlanPortWiseDetails()));
      builder.setLoadableStudyId(loadablePatternOpt.get().getLoadableStudy().getId());
      builder.setResponseStatus(Common.ResponseStatus.newBuilder().setStatus(SUCCESS).build());
    } else throw new Exception("Cannot find loadable pattern");

    return builder;
  }

  public com.cpdss.common.generated.LoadableStudy.LoadablePatternConfirmedReply.Builder
      getLoadablePatternByVoyageAndStatus(
          com.cpdss.common.generated.LoadableStudy.LoadableStudyRequest request,
          com.cpdss.common.generated.LoadableStudy.LoadablePatternConfirmedReply.Builder builder)
          throws GenericServiceException {
    Voyage voyage = this.voyageRepository.findByIdAndIsActive(request.getVoyageId(), true);

    Optional<LoadableStudy> loadableStudy =
        loadableStudyRepository.findByVoyageAndLoadableStudyStatusAndIsActiveAndPlanningTypeXId(
            voyage, CONFIRMED_STATUS_ID, true, Common.PLANNING_TYPE.LOADABLE_STUDY_VALUE);
    if (loadableStudy.isEmpty()) {
      throw new GenericServiceException(
          "Confirmed Loadable study does not exist",
          CommonErrorCodes.E_CPDSS_CONFIRMED_LS_DOES_NOT_EXIST,
          HttpStatusCode.BAD_REQUEST);
    }
    builder.setLoadableStudyId(loadableStudy.get().getId());
    log.info("Confirmed Ls - ls id {}", loadableStudy.get().getId());
    Optional<LoadablePattern> pattern =
        loadablePatternRepository.findByLoadableStudyAndLoadableStudyStatusAndIsActive(
            loadableStudy.get(), CONFIRMED_STATUS_ID, true);
    if (pattern.isPresent()) {
      com.cpdss.common.generated.LoadableStudy.LoadablePattern.Builder loadablePattern =
          com.cpdss.common.generated.LoadableStudy.LoadablePattern.newBuilder();
      loadablePattern.setLoadablePatternId(pattern.get().getId());
      builder.setPattern(loadablePattern.build());
    }
    builder.setResponseStatus(Common.ResponseStatus.newBuilder().setStatus(SUCCESS).build());
    return builder;
  }

  public com.cpdss.common.generated.LoadableStudy.AlgoReply.Builder saveLoadablePatterns(
      com.cpdss.common.generated.LoadableStudy.LoadablePatternAlgoRequest request,
      com.cpdss.common.generated.LoadableStudy.AlgoReply.Builder builder)
      throws GenericServiceException {
    log.info("saveLoadablePatternDetails - loadable study micro service");
    final String requestType =
        null == request.getRequestType() ? LOADABLE_STUDY : request.getRequestType();
    Optional<LoadableStudy> loadableStudyOpt =
        this.loadableStudyRepository.findByIdAndIsActive(request.getLoadableStudyId(), true);
    if (!loadableStudyOpt.isPresent()) {
      throw new GenericServiceException(
          "Loadable study does not exist",
          CommonErrorCodes.E_HTTP_BAD_REQUEST,
          HttpStatusCode.BAD_REQUEST);
    }

    if (request.getLoadablePlanDetailsList().isEmpty()) {
      log.info("saveLoadablePatternDetails - loadable study micro service - no plans available");
      loadableStudyAlgoStatusRepository.updateLoadableStudyAlgoStatus(
          LOADABLE_STUDY_NO_PLAN_AVAILABLE_ID, request.getProcesssId(), true);
      loadableStudyRepository.updateLoadableStudyStatus(
          LOADABLE_STUDY_NO_PLAN_AVAILABLE_ID, loadableStudyOpt.get().getId());
    } else {

      // Save pattern details shore
      List<LoadablePattern> loadablePatterns =
          savePatternDetails(request, loadableStudyOpt, requestType, false);

      // Update pattern Ids
      if (enableCommunication && !env.equals("ship")) {
        request =
            updateAlgoResponse(
                loadableStudyOpt.get().getId(), request, loadablePatterns, requestType);
      }

      if (request.getHasLodicator()) {
        loadableStudyAlgoStatusRepository.updateLoadableStudyAlgoStatus(
            LOADABLE_STUDY_STATUS_VERIFICATION_WITH_LOADICATOR_ID, request.getProcesssId(), true);
        loadicatorService.saveLoadicatorInfo(
            loadableStudyOpt.get(), request.getProcesssId(), 0L, loadablePatterns);
      } else {

        loadableStudyRepository.updateLoadableStudyStatus(
            LOADABLE_STUDY_STATUS_PLAN_GENERATED_ID, loadableStudyOpt.get().getId());
        loadableStudyAlgoStatusRepository.updateLoadableStudyAlgoStatus(
            LOADABLE_STUDY_STATUS_PLAN_GENERATED_ID, request.getProcesssId(), true);
      }
    }
    if (request.getAlgoErrorsCount() > 0) {
      algoErrorsRepository.deleteAlgoErrorByLSId(false, request.getLoadableStudyId());
      algoErrorHeadingRepository.deleteAlgoErrorHeadingByLSId(false, request.getLoadableStudyId());
      algoService.saveAlgoErrorToDB(request, new LoadablePattern(), loadableStudyOpt.get(), false);
      loadableStudyRepository.updateLoadableStudyStatus(
          LOADABLE_STUDY_STATUS_ERROR_OCCURRED_ID, loadableStudyOpt.get().getId());
      loadableStudyAlgoStatusRepository.updateLoadableStudyAlgoStatus(
          LOADABLE_STUDY_STATUS_ERROR_OCCURRED_ID, request.getProcesssId(), true);
    }

    // Communicate data to ship
    // cases : pattern generated without loadiator and any error
    if (enableCommunication
        && !env.equals("ship")
        && (!request.getHasLodicator() || request.getAlgoErrorsCount() > 0)) {
      Optional<LoadableStudyCommunicationStatus> loadableStudyCommunicationStatus =
          this.loadableStudyCommunicationStatusRepository
              .findFirstByReferenceIdAndMessageTypeOrderByCreatedDateTimeDesc(
                  request.getLoadableStudyId(), MessageTypes.LOADABLESTUDY.getMessageType());
      if (loadableStudyCommunicationStatus.get() != null) {

        AlgoResponseCommunication.Builder algoRespComm = AlgoResponseCommunication.newBuilder();
        algoRespComm.setLoadablePatternAlgoRequest(request);
        algoRespComm.setMessageId(loadableStudyCommunicationStatus.get().getMessageUUID());
        communicationService.passResultPayloadToEnvoyWriter(algoRespComm, loadableStudyOpt.get());
      }
    }

    builder
        .setResponseStatus(
            Common.ResponseStatus.newBuilder().setStatus(SUCCESS).setMessage(SUCCESS))
        .build();
    return builder;
  }

  /**
   * Method to update ids and other missing data to algo object for communication
   *
   * @param loadableStudyId loadableStudyId value
   * @param algoCallBackRequestObj Algo Callback request object
   * @param patterns list of saved patterns
   * @param requestType requestType value LS/DS
   * @return LoadablePatternAlgoRequest object
   * @throws GenericServiceException Exception on JSON conversion failure
   */
  private com.cpdss.common.generated.LoadableStudy.LoadablePatternAlgoRequest updateAlgoResponse(
      final long loadableStudyId,
      final com.cpdss.common.generated.LoadableStudy.LoadablePatternAlgoRequest
          algoCallBackRequestObj,
      final List<LoadablePattern> patterns,
      final String requestType)
      throws GenericServiceException {

    // TODO This method was added only for updating Ids to Algo response as they won't be present.
    //  Need to optimise to a simpler mapper conversion in future. Currently avoiding for immediate
    //  critical fixes as the var names are different in proto, entity for mapper implementation.

    List<LoadablePlanDetails> loadablePlanDetailsList = new ArrayList<>();
    boolean oneTimeExecuted = false;
    long lastLoadingPort = 0;
    for (LoadablePlanDetails lpd : algoCallBackRequestObj.getLoadablePlanDetailsList()) {
      LoadablePattern loadablePattern =
          patterns.stream()
              .filter(patternDetail -> patternDetail.getCaseNumber().equals(lpd.getCaseNumber()))
              .findFirst()
              .orElseThrow(
                  () -> {
                    log.error(
                        "Case number from Algo not found in DB pattern. LS Id: {}, Algo Case No: {}",
                        loadableStudyId,
                        lpd.getCaseNumber());
                    return new GenericServiceException(
                        "Case number from Algo not found in DB pattern. LS Id: " + loadableStudyId,
                        CommonErrorCodes.E_GEN_INTERNAL_ERR,
                        HttpStatusCode.INTERNAL_SERVER_ERROR);
                  });

      if (!oneTimeExecuted) {
        // Get last loading port. Get only once for all patterns.
        lastLoadingPort =
            loadableStudyPortRotationService.getLastPort(
                loadablePattern.getLoadableStudy(),
                this.cargoOperationRepository.getOne(LOADING_OPERATION_ID));
        oneTimeExecuted = true;
      }

      List<com.cpdss.common.generated.LoadableStudy.LoadablePlanPortWiseDetails>
          loadablePlanPortWiseDetailsList = new ArrayList<>();
      for (com.cpdss.common.generated.LoadableStudy.LoadablePlanPortWiseDetails
          loadablePlanPortWiseDetails : lpd.getLoadablePlanPortWiseDetailsList()) {
        if (lastLoadingPort == loadablePlanPortWiseDetails.getPortId()) {
          com.cpdss.common.generated.LoadableStudy.LoadablePlanDetailsReply
              loadablePlanDetailsReply =
                  loadablePlanPortWiseDetails
                      .getDepartureCondition()
                      .toBuilder()
                      .clearLoadablePlanStowageDetails()
                      .addAllLoadablePlanStowageDetails(
                          loadablePlanService.buildLoadablePlanStowageDetails(
                              loadablePattern.getId()))
                      .build();
          loadablePlanPortWiseDetails =
              loadablePlanPortWiseDetails
                  .toBuilder()
                  .setDepartureCondition(loadablePlanDetailsReply)
                  .build();
        }
        loadablePlanPortWiseDetailsList.add(loadablePlanPortWiseDetails);
      }

      loadablePlanDetailsList.add(
          lpd.toBuilder()
              .setLoadablePatternId(loadablePattern.getId())
              .clearLoadablePlanPortWiseDetails()
              .addAllLoadablePlanPortWiseDetails(loadablePlanPortWiseDetailsList)
              .build());
    }

    // Modify Algo request object adding additional details
    com.cpdss.common.generated.LoadableStudy.LoadablePatternAlgoRequest
        algoCallBackRequestObjModified =
            algoCallBackRequestObj
                .toBuilder()
                .clearLoadablePlanDetails()
                .addAllLoadablePlanDetails(loadablePlanDetailsList)
                .build();
    long jsonTypeId;
    if (requestType.equals(LOADABLE_STUDY)) {
      // Saved modified data as new entry as id 17 needs to be the actual Algo response
      jsonTypeId = UPDATED_LOADABLE_STUDY_RESULT_JSON_ID;
    } else {
      jsonTypeId = DISCHARGE_STUDY_RESULT_JSON_ID;
    }

    // Update modified JSON data table with pattern id
    try {
      jsonDataService.updateJsonData(
          loadableStudyId,
          jsonTypeId,
          JsonFormat.printer()
              .omittingInsignificantWhitespace()
              .print(algoCallBackRequestObjModified));
    } catch (InvalidProtocolBufferException e) {
      log.error(
          "Error converting object to JSON string. LS: {}, Object: {}",
          loadableStudyId,
          algoCallBackRequestObjModified,
          e);
      throw new GenericServiceException(
          "Error converting object to JSON string. LS: " + loadableStudyId,
          e.getMessage(),
          HttpStatusCode.INTERNAL_SERVER_ERROR,
          e);
    }
    return algoCallBackRequestObjModified;
  }

  private List<LoadablePattern> savePatternDetails(
      com.cpdss.common.generated.LoadableStudy.LoadablePatternAlgoRequest request,
      Optional<LoadableStudy> loadableStudyOpt,
      String requestType,
      boolean isShip) {

    Long lastLoadingPort = 0L;
    if (requestType.equals(LOADABLE_STUDY)) {
      lastLoadingPort =
          loadableStudyPortRotationService.getLastPort(
              loadableStudyOpt.get(), this.cargoOperationRepository.getOne(LOADING_OPERATION_ID));
    }

    List<LoadablePattern> loadablePatterns = new ArrayList<LoadablePattern>();
    for (LoadablePlanDetails lpd : request.getLoadablePlanDetailsList()) {

      LoadablePattern loadablePattern =
          saveLoadablePattern(lpd, loadableStudyOpt.get(), request.getHasLodicator(), isShip);

      loadablePatterns.add(loadablePattern);
      saveConstrains(lpd, loadablePattern);
      if (requestType.equals(LOADABLE_STUDY)) {
        Long lastPort = lastLoadingPort;
        Optional<com.cpdss.common.generated.LoadableStudy.LoadablePlanPortWiseDetails>
            lppwdOptional =
                lpd.getLoadablePlanPortWiseDetailsList().stream()
                    .filter(lppwd -> lppwd.getPortId() == lastPort)
                    .findAny();
        if (lppwdOptional.isPresent()) {
          loadableQuantityService.saveLoadableQuantity(lppwdOptional.get(), loadablePattern);
          saveLoadablePlanCommingleCargo(
              lppwdOptional
                  .get()
                  .getDepartureCondition()
                  .getLoadableQuantityCommingleCargoDetailsList(),
              loadablePattern);
          saveLoadablePlanStowageDetails(
              lppwdOptional.get().getDepartureCondition().getLoadablePlanStowageDetailsList(),
              loadablePattern);
          saveLoadablePlanBallastDetails(
              lppwdOptional.get().getDepartureCondition().getLoadablePlanBallastDetailsList(),
              loadablePattern);
        }
      }

      AtomicInteger displayOrder = new AtomicInteger(0);
      saveLoadableQuantityCommingleCargoPortwiseDetails(
          lpd.getLoadablePlanPortWiseDetailsList(), loadablePattern, displayOrder);
      if (requestType.equals(LOADABLE_STUDY)) {
        // Saving stability for fully loaded condition at LS
        saveStabilityParameters(loadablePattern, lpd, lastLoadingPort);
      }

      saveLoadablePlanStowageDetails(loadablePattern, lpd, displayOrder);
      saveLoadablePlanBallastDetails(loadablePattern, lpd);
      // Saving stability parameter for all ports
      saveStabilityParameterForNonLodicator(request.getHasLodicator(), loadablePattern, lpd);
      // TODO ROB details - Data is coming from OHQ - As of now decided to not save
      // here.
      if (requestType.equals(DICHARGE_STUDY)) {
        saveLoadableQuantityCargoDetails(
            lpd.getLoadablePlanPortWiseDetailsList(), loadablePattern, loadableStudyOpt.get());
      }
    }
    return loadablePatterns;
  }

  private void saveLoadableQuantityCargoDetails(
      List<LoadablePlanPortWiseDetails> loadablePlanPortWiseDetailsList,
      LoadablePattern loadablePattern,
      LoadableStudy loadableStudy) {
    if (ofNullable(loadablePlanPortWiseDetailsList).isPresent()) {
      loadablePlanPortWiseDetailsList.forEach(
          lppwd -> {
            lppwd
                .getArrivalCondition()
                .getLoadableQuantityCargoDetailsList()
                .forEach(
                    lpcd -> {
                      saveLoadableQuantityCargoPortwiseDetails(
                          lpcd,
                          lppwd.getPortId(),
                          lppwd.getPortRotationId(),
                          SYNOPTICAL_TABLE_OP_TYPE_ARRIVAL,
                          loadablePattern,
                          loadableStudy);
                    });
            lppwd
                .getDepartureCondition()
                .getLoadableQuantityCargoDetailsList()
                .forEach(
                    lpcd -> {
                      saveLoadableQuantityCargoPortwiseDetails(
                          lpcd,
                          lppwd.getPortId(),
                          lppwd.getPortRotationId(),
                          SYNOPTICAL_TABLE_OP_TYPE_DEPARTURE,
                          loadablePattern,
                          loadableStudy);
                    });
          });
    }
  }

  private void saveLoadableQuantityCargoPortwiseDetails(
      LoadableQuantityCargoDetails lpcd,
      long portId,
      long portRotationId,
      String operationType,
      LoadablePattern loadablePattern,
      LoadableStudy loadableStudy) {

    DischargePatternQuantityCargoPortwiseDetails loadableQuantityCargoDetails =
        new DischargePatternQuantityCargoPortwiseDetails();
    loadableQuantityCargoDetails.setIsActive(true);
    loadableQuantityCargoDetails.setCargoId(lpcd.getCargoId());
    loadableQuantityCargoDetails.setCargoNominationId(lpcd.getCargoNominationId());
    loadableQuantityCargoDetails.setDischargeCargoNominationId(lpcd.getDscargoNominationId());
    loadableQuantityCargoDetails.setPortId(portId);
    if (portRotationId > 0) {
      loadableQuantityCargoDetails.setPortRotationId(portRotationId);
    } else {
      loadableQuantityCargoDetails.setPortRotationId(
          getPortRotationIDFromDSId(portId, loadableStudy));
    }

    loadableQuantityCargoDetails.setLoadablePatternId(loadablePattern.getId());
    loadableQuantityCargoDetails.setCargoAbbreviation(lpcd.getCargoAbbreviation());
    loadableQuantityCargoDetails.setEstimatedAPI(
        lpcd.getEstimatedAPI().isBlank() ? null : new BigDecimal(lpcd.getEstimatedAPI()));
    loadableQuantityCargoDetails.setEstimatedTemp(
        lpcd.getEstimatedTemp().isBlank() ? null : new BigDecimal(lpcd.getEstimatedTemp()));
    loadableQuantityCargoDetails.setPriority(lpcd.getPriority());
    loadableQuantityCargoDetails.setColorCode(lpcd.getColorCode());
    loadableQuantityCargoDetails.setDischargeMT(
        lpcd.getDischargeMT().isBlank() ? null : new BigDecimal(lpcd.getDischargeMT()));
    loadableQuantityCargoDetails.setOrderedQuantity(
        lpcd.getOrderedQuantity().isBlank() ? null : new BigDecimal(lpcd.getOrderedQuantity()));
    loadableQuantityCargoDetails.setSlopQuantity(
        lpcd.getSlopQuantity().isBlank() ? null : new BigDecimal(lpcd.getSlopQuantity()));
    loadableQuantityCargoDetails.setDifferencePercentage(
        lpcd.getDifferencePercentage().isBlank()
            ? null
            : new BigDecimal(lpcd.getDifferencePercentage()));
    loadableQuantityCargoDetails.setLoadingOrder(lpcd.getLoadingOrder());
    loadableQuantityCargoDetails.setTimeRequiredForDischarging(
        lpcd.getTimeRequiredForDischarging().isBlank()
            ? null
            : new BigDecimal(lpcd.getTimeRequiredForDischarging()));
    loadableQuantityCargoDetails.setDischargingRate(
        lpcd.getDischargingRate().isBlank() ? null : new BigDecimal(lpcd.getDischargingRate()));
    loadableQuantityCargoDetails.setCargoNominationTemperature(
        lpcd.getCargoNominationTemperature().isBlank()
            ? null
            : new BigDecimal(lpcd.getCargoNominationTemperature()));
    loadableQuantityCargoDetails.setOperationType(operationType);

    List<DischargePlanCowDetailFromAlgo> cowDetailFromAlgoList = new ArrayList<>();
    Optional.ofNullable(lpcd.getCowDetailsList())
        .ifPresent(
            i ->
                i.forEach(
                    item -> {
                      DischargePlanCowDetailFromAlgo cowDetail =
                          new DischargePlanCowDetailFromAlgo();
                      Optional<CowTypeMaster> cowTypeOpt =
                          cowTypeMasterRepository.findByCowTypeAndIsActiveTrue(item.getWashType());
                      if (cowTypeOpt.isPresent()) {
                        cowDetail.setCowType(cowTypeOpt.get().getId());
                      }
                      Optional.ofNullable(item.getTankId()).ifPresent(cowDetail::setTankIds);
                      Optional.ofNullable(item.getShortName()).ifPresent(cowDetail::setShortName);
                      cowDetailFromAlgoList.add(cowDetail);
                    }));
    loadableQuantityCargoDetails.setCowDetails(cowDetailFromAlgoList);

    dischargePatternQuantityCargoPortwiseRepository.save(loadableQuantityCargoDetails);
  }

  private Long getPortRotationIDFromDSId(long portId, LoadableStudy loadableStudy) {
    LoadableStudyPortRotation loadableStudyPortRotation =
        loadableStudyPortRotationRepository.findByLoadableStudyAndPortAndOperation(
            loadableStudy, portId);
    return loadableStudyPortRotation.getId();
  }

  /**
   * Method to save loadable pattern to DB
   *
   * @param lpd loadable pattern details object
   * @param loadableStudy loadableStudy object
   * @param hasLoadicator hasLoadicator flag
   * @param isShip isShip flag to identify env
   */
  private LoadablePattern saveLoadablePattern(
      com.cpdss.common.generated.LoadableStudy.LoadablePlanDetails lpd,
      LoadableStudy loadableStudy,
      boolean hasLoadicator,
      boolean isShip) {

    // Deactivate existing patterns for LS. Used for cases like feedback loop in
    // loadicator case
    Optional<LoadablePattern> lp =
        loadablePatternRepository.findOneByLoadableStudyAndCaseNumberAndIsActiveTrue(
            loadableStudy, lpd.getCaseNumber());
    if (lp.isPresent()) {
      log.info(
          "Loadable Pattern deleted for LS Id {}, Case Number {}",
          loadableStudy.getId(),
          lpd.getCaseNumber());
      loadablePatternRepository.deleteLoadablePattern(lp.get().getId());
    }

    // Create new loadable pattern
    LoadablePattern loadablePattern = new LoadablePattern();
    // Change proto default value of int64 from 0 to null
    // Ref: https://developers.google.com/protocol-buffers/docs/proto3#default
    loadablePattern.setId((0 == lpd.getLoadablePatternId()) ? null : lpd.getLoadablePatternId());

    // Activate pattern in ship after communication without checking loadicator. On
    // shore activate
    // based on loadicator status.
    if (isShip) {
      loadablePattern.setIsActive(true);
    } else {
      loadablePattern.setIsActive(!hasLoadicator);
    }

    loadablePattern.setCaseNumber(lpd.getCaseNumber());
    loadablePattern.setLoadableStudy(loadableStudy);
    loadablePattern.setLoadableStudyStatus(LOADABLE_STUDY_STATUS_PLAN_GENERATED_ID);

    loadablePatternRepository.save(loadablePattern);
    log.info(
        "Loadable Pattern Saved for LS Id {}, Case Number {}",
        loadableStudy.getId(),
        lpd.getCaseNumber());
    return loadablePattern;
  }

  /**
   * @param lpd
   * @param loadablePattern void
   */
  private void saveConstrains(
      com.cpdss.common.generated.LoadableStudy.LoadablePlanDetails lpd,
      LoadablePattern loadablePattern) {
    if (!lpd.getConstraintsList().isEmpty()) {
      lpd.getConstraintsList()
          .forEach(
              constrains -> {
                LoadablePlanConstraints constraints = new LoadablePlanConstraints();
                constraints.setConstraintsData(constrains);
                constraints.setIsActive(true);
                constraints.setLoadablePattern(loadablePattern);
                loadablePlanConstraintsRespository.save(constraints);
              });
    }
  }

  /**
   * @param loadableQuantityCommingleCargoDetailsList
   * @param loadablePattern void
   */
  public void saveLoadablePlanCommingleCargo(
      List<com.cpdss.common.generated.LoadableStudy.LoadableQuantityCommingleCargoDetails>
          loadableQuantityCommingleCargoDetailsList,
      LoadablePattern loadablePattern) {
    for (int i = 0; i < loadableQuantityCommingleCargoDetailsList.size(); i++) {
      LoadablePlanCommingleDetails loadablePlanCommingleDetails =
          new LoadablePlanCommingleDetails();
      loadablePlanCommingleDetails.setApi(
          loadableQuantityCommingleCargoDetailsList.get(i).getApi());
      loadablePlanCommingleDetails.setCargo1Abbreviation(
          loadableQuantityCommingleCargoDetailsList.get(i).getCargo1Abbreviation());
      loadablePlanCommingleDetails.setCargo1Mt(
          loadableQuantityCommingleCargoDetailsList.get(i).getCargo1MT());
      loadablePlanCommingleDetails.setCargo1Percentage(
          loadableQuantityCommingleCargoDetailsList.get(i).getCargo1Percentage());
      loadablePlanCommingleDetails.setCargo2Abbreviation(
          loadableQuantityCommingleCargoDetailsList.get(i).getCargo2Abbreviation());
      loadablePlanCommingleDetails.setCargo2Mt(
          loadableQuantityCommingleCargoDetailsList.get(i).getCargo2MT());
      loadablePlanCommingleDetails.setCargo2Percentage(
          loadableQuantityCommingleCargoDetailsList.get(i).getCargo2Percentage());
      Optional<CommingleCargo> commingleCargoOpt =
          commingleCargoRepository
              .findByLoadableStudyXIdAndCargoNomination1IdAndCargoNomination2IdAndIsActiveTrue(
                  loadablePattern.getLoadableStudy().getId(),
                  loadableQuantityCommingleCargoDetailsList.get(i).getCargo1NominationId(),
                  loadableQuantityCommingleCargoDetailsList.get(i).getCargo2NominationId());
      commingleCargoOpt.ifPresent(
          commingle -> loadablePlanCommingleDetails.setGrade(commingle.getAbbreviation()));
      loadablePlanCommingleDetails.setIsActive(true);
      loadablePlanCommingleDetails.setLoadablePattern(loadablePattern);
      loadablePlanCommingleDetails.setQuantity(
          loadableQuantityCommingleCargoDetailsList.get(i).getQuantity());
      loadablePlanCommingleDetails.setTankName(
          loadableQuantityCommingleCargoDetailsList.get(i).getTankName());
      loadablePlanCommingleDetails.setTemperature(
          loadableQuantityCommingleCargoDetailsList.get(i).getTemp());
      loadablePlanCommingleDetails.setOrderQuantity(
          loadableQuantityCommingleCargoDetailsList.get(i).getOrderedMT());
      loadablePlanCommingleDetails.setPriority(
          loadableQuantityCommingleCargoDetailsList.get(i).getPriority());
      loadablePlanCommingleDetails.setLoadingOrder(
          loadableQuantityCommingleCargoDetailsList.get(i).getLoadingOrder());
      loadablePlanCommingleDetails.setTankId(
          loadableQuantityCommingleCargoDetailsList.get(i).getTankId());
      loadablePlanCommingleDetails.setFillingRatio(
          loadableQuantityCommingleCargoDetailsList.get(i).getFillingRatio());
      loadablePlanCommingleDetails.setCorrectionFactor(
          loadableQuantityCommingleCargoDetailsList.get(i).getCorrectionFactor());
      loadablePlanCommingleDetails.setCorrectedUllage(
          loadableQuantityCommingleCargoDetailsList.get(i).getCorrectedUllage());
      loadablePlanCommingleDetails.setRdgUllage(
          loadableQuantityCommingleCargoDetailsList.get(i).getRdgUllage());
      loadablePlanCommingleDetails.setSlopQuantity(
          loadableQuantityCommingleCargoDetailsList.get(i).getSlopQuantity());
      loadablePlanCommingleDetails.setTimeRequiredForLoading(
          loadableQuantityCommingleCargoDetailsList.get(i).getTimeRequiredForLoading());
      loadablePlanCommingleDetails.setCargo2NominationId(
          loadableQuantityCommingleCargoDetailsList.get(i).getCargo2NominationId());
      loadablePlanCommingleDetails.setCargo2NominationId(
          loadableQuantityCommingleCargoDetailsList.get(i).getCargo2NominationId());
      loadablePlanCommingleDetails.setTankShortName(
          loadableQuantityCommingleCargoDetailsList.get(i).getTankShortName());
      loadablePlanCommingleDetails.setCommingleColour(
          loadableQuantityCommingleCargoDetailsList.get(i).getCommingleColour());
      loadablePlanCommingleDetailsRepository.save(loadablePlanCommingleDetails);
      loadableQuantityCommingleCargoDetailsList
          .get(i)
          .getToppingOffSequencesList()
          .forEach(
              toppingSequence -> {
                LoadablePatternCargoToppingOffSequence lpctos =
                    new LoadablePatternCargoToppingOffSequence();
                lpctos.setCargoXId(toppingSequence.getCargoId());
                lpctos.setTankXId(toppingSequence.getTankId());
                lpctos.setOrderNumber(toppingSequence.getOrderNumber());
                lpctos.setLoadablePattern(loadablePattern);
                lpctos.setIsActive(true);
                toppingOffSequenceRepository.save(lpctos);
              });
    }
  }

  public com.cpdss.common.generated.LoadableStudy.AlgoReply.Builder savePatternValidateResult(
      com.cpdss.common.generated.LoadableStudy.LoadablePatternAlgoRequest request,
      com.cpdss.common.generated.LoadableStudy.AlgoReply.Builder builder)
      throws GenericServiceException, JsonProcessingException {
    log.info("savePatternValidateResult - loadable study micro service :");
    Optional<LoadablePattern> loadablePatternOpt =
        this.loadablePatternRepository.findByIdAndIsActive(request.getLoadablePatternId(), true);
    if (!loadablePatternOpt.isPresent()) {
      throw new GenericServiceException(
          "Loadable pattern does not exist",
          CommonErrorCodes.E_HTTP_BAD_REQUEST,
          HttpStatusCode.BAD_REQUEST);
    }
    LoadablePatternAlgoRequest loadablePatternAlgoRequest = new LoadablePatternAlgoRequest();
    Optional.ofNullable(request.getValidated()).ifPresent(loadablePatternAlgoRequest::setValidated);
    Optional.ofNullable(loadablePatternOpt.get().getLoadableStudy().getId())
        .ifPresent(loadablePatternAlgoRequest::setLoadableStudyId);
    Optional.ofNullable(request.getHasLodicator())
        .ifPresent(loadablePatternAlgoRequest::setHasLoadicator);
    Optional.ofNullable(request.getProcesssId())
        .ifPresent(loadablePatternAlgoRequest::setProcessId);
    Optional.ofNullable(request.getLoadablePatternId())
        .ifPresent(loadablePatternAlgoRequest::setLoadablePatternId);
    PatternDetails patternDetails = new PatternDetails();
    if (!request.getValidated()) {
      loadablePatternAlgoStatusRepository.updateLoadablePatternAlgoStatus(
          LOADABLE_PATTERN_VALIDATION_FAILED_ID, request.getProcesssId(), true);

      algoErrorsRepository.deleteAlgoError(false, request.getLoadablePatternId());
      algoErrorHeadingRepository.deleteAlgoErrorHeading(false, request.getLoadablePatternId());

      List<com.cpdss.loadablestudy.entity.AlgoErrors> algoError =
          algoService.saveAlgoErrorToDB(
              request, loadablePatternOpt.get(), new LoadableStudy(), true);

      if (!env.equals("ship") && enableCommunication) {
        loadablePatternAlgoRequest.setAlgoError(algoError);
      }
    } else {
      deleteExistingPlanDetails(loadablePatternOpt.get());

      Long lastLoadingPort =
          loadableStudyPortRotationService.getLastPort(
              loadablePatternOpt.get().getLoadableStudy(),
              this.cargoOperationRepository.getOne(LOADING_OPERATION_ID));
      request
          .getLoadablePlanDetailsList()
          .forEach(
              lpd -> {
                Optional<com.cpdss.common.generated.LoadableStudy.LoadablePlanPortWiseDetails>
                    lppwdOptional =
                        lpd.getLoadablePlanPortWiseDetailsList().stream()
                            .filter(lppwd -> lppwd.getPortId() == lastLoadingPort)
                            .findAny();
                if (lppwdOptional.isPresent()) {
                  loadableQuantityService.saveLoadableQuantity(
                      lppwdOptional.get(), loadablePatternOpt.get());
                  saveLoadablePlanCommingleCargo(
                      lppwdOptional
                          .get()
                          .getDepartureCondition()
                          .getLoadableQuantityCommingleCargoDetailsList(),
                      loadablePatternOpt.get());
                  saveLoadablePlanStowageDetails(
                      lppwdOptional
                          .get()
                          .getDepartureCondition()
                          .getLoadablePlanStowageDetailsList(),
                      loadablePatternOpt.get());
                  saveLoadablePlanBallastDetails(
                      lppwdOptional
                          .get()
                          .getDepartureCondition()
                          .getLoadablePlanBallastDetailsList(),
                      loadablePatternOpt.get());
                }
                AtomicInteger displayOrder = new AtomicInteger(0);
                saveLoadableQuantityCommingleCargoPortwiseDetails(
                    lpd.getLoadablePlanPortWiseDetailsList(),
                    loadablePatternOpt.get(),
                    displayOrder);
                saveLoadablePlanStowageDetails(loadablePatternOpt.get(), lpd, displayOrder);
                saveLoadablePlanBallastDetails(loadablePatternOpt.get(), lpd);
                saveStabilityParameterForNonLodicator(
                    request.getHasLodicator(), loadablePatternOpt.get(), lpd);
              });
      if (request.getHasLodicator()) {
        loadicatorService.saveLoadicatorInfo(
            loadablePatternOpt.get().getLoadableStudy(),
            request.getProcesssId(),
            request.getLoadablePatternId(),
            new ArrayList<>());
      } else {
        loadablePatternAlgoStatusRepository.updateLoadablePatternAlgoStatus(
            LOADABLE_PATTERN_VALIDATION_SUCCESS_ID, request.getProcesssId(), true);
        if (!env.equals("ship") && enableCommunication) {
          fetchSavedPatternFromDB(patternDetails, loadablePatternOpt.get());
          loadablePatternAlgoRequest.setPatternDetails(patternDetails);
        }
      }
    }

    ObjectMapper objectMapper = new ObjectMapper();
    log.info(
        "============ process ID : "
            + request.getProcesssId()
            + " Env : "
            + env
            + " Communication Status : "
            + ""
            + enableCommunication
            + " Lodicator Status : "
            + request.getHasLodicator());
    //
    // objectMapper.writeValueAsString(loadablePatternAlgoRequest));
    if (!env.equals("ship") && enableCommunication && !request.getHasLodicator()) {
      Optional<LoadableStudyCommunicationStatus> patternValidateCommunicationStatus =
          this.loadableStudyCommunicationStatusRepository
              .findFirstByReferenceIdAndMessageTypeOrderByCreatedDateTimeDesc(
                  loadablePatternOpt.get().getId(), MessageTypes.VALIDATEPLAN.getMessageType());
      log.info(
          " ------message Id in shore : "
              + patternValidateCommunicationStatus.get().getMessageUUID());
      loadablePatternAlgoRequest.setMessageId(
          patternValidateCommunicationStatus.get().getMessageUUID());
      EnvoyWriter.WriterReply ewReply =
          communicationService.passRequestPayloadToEnvoyWriter(
              objectMapper.writeValueAsString(loadablePatternAlgoRequest),
              loadablePatternOpt.get().getLoadableStudy().getVesselXId(),
              MessageTypes.PATTERNDETAIL.getMessageType());
      if (SUCCESS.equals(ewReply.getResponseStatus().getStatus())) {
        log.info(
            "------- Envoy writer has called successfully in algo call back: "
                + ewReply.toString());
        LoadableStudyCommunicationStatus lsCommunicationStatus =
            new LoadableStudyCommunicationStatus();
        if (ewReply.getMessageId() != null) {
          lsCommunicationStatus.setMessageUUID(ewReply.getMessageId());
          lsCommunicationStatus.setCommunicationStatus(
              CommunicationStatus.UPLOAD_WITH_HASH_VERIFIED.getId());
        }
        lsCommunicationStatus.setReferenceId(loadablePatternOpt.get().getId());
        lsCommunicationStatus.setMessageType(MessageTypes.PATTERNDETAIL.getMessageType());
        lsCommunicationStatus.setCommunicationDateTime(LocalDateTime.now());
        LoadableStudyCommunicationStatus loadableStudyCommunicationStatus =
            this.loadableStudyCommunicationStatusRepository.save(lsCommunicationStatus);
        log.info("Communication table update : " + loadableStudyCommunicationStatus.getId());
      }
    }

    builder
        .setResponseStatus(
            Common.ResponseStatus.newBuilder().setStatus(SUCCESS).setMessage(SUCCESS))
        .build();
    return builder;
  }

  @Autowired private SynopticalTableRepository synopticalTableRepository;

  public void fetchSavedPatternFromDB(
      PatternDetails patternDetails, LoadablePattern loadablePattern) {
    ModelMapper modelMapper = new ModelMapper();
    List<LoadablePlanQuantity> loadablePlanQuantityList =
        loadablePlanQuantityRepository.findByLoadablePatternAndIsActive(loadablePattern, true);
    List<LoadablePlanQuantityDto> loadablePlanQuantityDtoList =
        Arrays.asList(modelMapper.map(loadablePlanQuantityList, LoadablePlanQuantityDto[].class));
    patternDetails.setLoadablePlanQuantityList(loadablePlanQuantityDtoList);

    List<LoadablePatternCargoToppingOffSequence> toppingOffSequenceList =
        toppingOffSequenceRepository.findByLoadablePatternAndIsActive(loadablePattern, true);
    List<LoadablePatternCargoToppingOffSequenceDto> loadablePatternCargoToppingOffSequenceDtoList =
        Arrays.asList(
            modelMapper.map(
                toppingOffSequenceList, LoadablePatternCargoToppingOffSequenceDto[].class));
    patternDetails.setToppingOffSequenceList(loadablePatternCargoToppingOffSequenceDtoList);

    List<LoadablePlanCommingleDetails> loadablePlanCommingleDetails =
        loadablePlanCommingleDetailsRepository.findByLoadablePatternAndIsActive(
            loadablePattern, true);
    List<LoadablePlanCommingleDetailsDto> loadablePlanCommingleDetailsDtoList =
        Arrays.asList(
            modelMapper.map(loadablePlanCommingleDetails, LoadablePlanCommingleDetailsDto[].class));
    patternDetails.setLoadablePlanCommingleDetails(loadablePlanCommingleDetailsDtoList);

    List<LoadablePlanStowageDetails> loadablePlanStowageDetailsList =
        loadablePlanStowageDetailsRespository.findByLoadablePatternAndIsActive(
            loadablePattern, true);
    List<LoadablePlanStowageDetailsDto> loadablePlanStowageDetailsDtoList =
        Arrays.asList(
            modelMapper.map(loadablePlanStowageDetailsList, LoadablePlanStowageDetailsDto[].class));
    patternDetails.setLoadablePlanStowageDetailsList(loadablePlanStowageDetailsDtoList);

    List<LoadablePlanBallastDetails> loadablePlanBallastDetailsList =
        loadablePlanBallastDetailsRepository.findByLoadablePatternAndIsActive(
            loadablePattern, true);
    List<LoadablePlanBallastDetailsDto> loadablePlanBallastDetailsDtoList =
        Arrays.asList(
            modelMapper.map(loadablePlanBallastDetailsList, LoadablePlanBallastDetailsDto[].class));
    patternDetails.setLoadablePlanBallastDetailsList(loadablePlanBallastDetailsDtoList);

    List<LoadablePlanComminglePortwiseDetails> loadablePlanComminglePortwiseDetailsList =
        loadablePlanCommingleDetailsPortwiseRepository.findByLoadablePatternIdAndIsActive(
            loadablePattern.getId(), true);
    List<LoadablePlanComminglePortwiseDetailsDto> loadablePlanComminglePortwiseDetailsDtoList =
        Arrays.asList(
            modelMapper.map(
                loadablePlanComminglePortwiseDetailsList,
                LoadablePlanComminglePortwiseDetailsDto[].class));
    patternDetails.setLoadablePlanComminglePortwiseDetailsList(
        loadablePlanComminglePortwiseDetailsDtoList);

    List<com.cpdss.loadablestudy.entity.LoadablePatternCargoDetails>
        loadablePatternCargoDetailsList =
            loadablePatternCargoDetailsRepository.findByLoadablePatternIdAndIsActive(
                loadablePattern.getId(), true);
    List<LoadablePatternCargoDetailsDto> loadablePatternCargoDetailsDtoList =
        Arrays.asList(
            modelMapper.map(
                loadablePatternCargoDetailsList, LoadablePatternCargoDetailsDto[].class));
    patternDetails.setLoadablePatternCargoDetailsList(loadablePatternCargoDetailsDtoList);

    List<LoadablePlanStowageBallastDetails> loadablePlanStowageBallastDetailsList =
        loadablePlanStowageBallastDetailsRepository.findByLoadablePatternIdAndIsActive(
            loadablePattern.getId(), true);
    List<LoadablePlanStowageBallastDetailsDto> loadablePlanStowageBallastDetailsDtoList =
        Arrays.asList(
            modelMapper.map(
                loadablePlanStowageBallastDetailsList,
                LoadablePlanStowageBallastDetailsDto[].class));
    patternDetails.setLoadablePlanStowageBallastDetailsList(
        loadablePlanStowageBallastDetailsDtoList);

    List<com.cpdss.loadablestudy.entity.SynopticalTableLoadicatorData>
        synopticalTableLoadicatorData =
            synopticalTableLoadicatorDataRepository.findByLoadablePatternIdAndIsActive(
                loadablePattern.getId(), true);
    List<SynopticalTableLoadicatorDataDto> synopticalTableLoadicatorDataDtoList =
        Arrays.asList(
            modelMapper.map(
                synopticalTableLoadicatorData, SynopticalTableLoadicatorDataDto[].class));
    patternDetails.setSynopticalTableLoadicatorData(synopticalTableLoadicatorDataDtoList);
    List<com.cpdss.loadablestudy.entity.SynopticalTable> synopticalTableList =
        synopticalTableRepository.findByLoadableStudyXIdAndIsActive(
            loadablePattern.getLoadableStudy().getId(), true);
    List<SynopticalTableDto> synopticalTableDtoList =
        Arrays.asList(modelMapper.map(synopticalTableList, SynopticalTableDto[].class));
    patternDetails.setSynopticalTableDtoList(synopticalTableDtoList);
  }

  /**
   * @param loadablePlanStowageDetailsList
   * @param loadablePattern void
   */
  private void saveLoadablePlanStowageDetails(
      List<com.cpdss.common.generated.LoadableStudy.LoadablePlanStowageDetails>
          loadablePlanStowageDetailsList,
      LoadablePattern loadablePattern) {
    loadablePlanStowageDetailsList.forEach(
        lpsd -> {
          LoadablePlanStowageDetails loadablePlanStowageDetails;
          // To remove proto default 0 for long
          if (0 == lpsd.getStowageDetailsId()) {
            loadablePlanStowageDetails = new LoadablePlanStowageDetails();
          } else {
            loadablePlanStowageDetails =
                loadablePlanStowageDetailsRespository
                    .findById(lpsd.getStowageDetailsId())
                    .orElse(new LoadablePlanStowageDetails());
            loadablePlanStowageDetails.setId(lpsd.getId());
          }

          // Set id and activate
          loadablePlanStowageDetails.setIsActive(true);

          loadablePlanStowageDetails.setApi(lpsd.getApi());
          loadablePlanStowageDetails.setAbbreviation(lpsd.getCargoAbbreviation());
          loadablePlanStowageDetails.setColorCode(lpsd.getColorCode());
          loadablePlanStowageDetails.setFillingPercentage(lpsd.getFillingRatio());
          loadablePlanStowageDetails.setRdgUllage(lpsd.getRdgUllage());
          loadablePlanStowageDetails.setTankId(lpsd.getTankId());
          loadablePlanStowageDetails.setTankname(lpsd.getTankName());
          loadablePlanStowageDetails.setWeight(
              StringUtils.isEmpty(lpsd.getWeight()) ? lpsd.getQuantityMT() : lpsd.getWeight());
          loadablePlanStowageDetails.setTemperature(lpsd.getTemperature());
          loadablePlanStowageDetails.setLoadablePattern(loadablePattern);
          loadablePlanStowageDetails.setCorrectionFactor(lpsd.getCorrectionFactor());
          loadablePlanStowageDetails.setCorrectedUllage(lpsd.getCorrectedUllage());
          loadablePlanStowageDetails.setCargoNominationId(lpsd.getCargoNominationId());
          if (StringUtils.hasLength(lpsd.getCargoNominationTemperature())) {
            loadablePlanStowageDetails.setCargoNominationTemperature(
                new BigDecimal(lpsd.getCargoNominationTemperature()));
          }
          loadablePlanStowageDetailsRespository.save(loadablePlanStowageDetails);
        });
  }

  /**
   * @param loadablePattern
   * @param lpd void
   */
  private void saveLoadablePlanBallastDetails(
      LoadablePattern loadablePattern,
      com.cpdss.common.generated.LoadableStudy.LoadablePlanDetails lpd) {
    lpd.getLoadablePlanPortWiseDetailsList()
        .forEach(
            lppwd -> {
              Long portRotationid = lppwd.getPortRotationId();
              LoadableStudyPortRotation portRotation =
                  loadableStudyPortRotationRepository.findByIdAndIsActive(portRotationid, true);
              if (!Objects.isNull(portRotation)) portRotationid = portRotation.getId();

              Long finalPortRotationid = portRotationid;
              lppwd
                  .getArrivalCondition()
                  .getLoadablePlanBallastDetailsList()
                  .forEach(
                      lpbd -> {
                        saveLoadablePlanBallastDetailsOperationWise(
                            SYNOPTICAL_TABLE_OP_TYPE_ARRIVAL,
                            lpbd,
                            lppwd.getPortId(),
                            finalPortRotationid,
                            loadablePattern);
                      });
              lppwd
                  .getDepartureCondition()
                  .getLoadablePlanBallastDetailsList()
                  .forEach(
                      lpbd -> {
                        saveLoadablePlanBallastDetailsOperationWise(
                            SYNOPTICAL_TABLE_OP_TYPE_DEPARTURE,
                            lpbd,
                            lppwd.getPortId(),
                            finalPortRotationid,
                            loadablePattern);
                      });
            });
  }

  /**
   * @param loadablePlanBallastDetailsList
   * @param loadablePattern void
   */
  private void saveLoadablePlanBallastDetails(
      List<com.cpdss.common.generated.LoadableStudy.LoadablePlanBallastDetails>
          loadablePlanBallastDetailsList,
      LoadablePattern loadablePattern) {
    loadablePlanBallastDetailsList.forEach(
        lpbd -> {
          LoadablePlanBallastDetails loadablePlanBallastDetails = new LoadablePlanBallastDetails();
          loadablePlanBallastDetails.setMetricTon(lpbd.getMetricTon());
          loadablePlanBallastDetails.setPercentage(lpbd.getPercentage());
          loadablePlanBallastDetails.setSg(lpbd.getSg());
          loadablePlanBallastDetails.setTankName(lpbd.getTankName());
          loadablePlanBallastDetails.setTankId(lpbd.getTankId());
          loadablePlanBallastDetails.setRdgLevel(lpbd.getRdgLevel());
          loadablePlanBallastDetails.setIsActive(true);
          loadablePlanBallastDetails.setLoadablePattern(loadablePattern);
          loadablePlanBallastDetails.setColorCode(BALLAST_TANK_COLOR_CODE);
          loadablePlanBallastDetails.setCorrectedLevel(lpbd.getCorrectedLevel());
          loadablePlanBallastDetails.setCorrectionFactor(lpbd.getCorrectionFactor());
          loadablePlanBallastDetailsRepository.save(loadablePlanBallastDetails);
        });
  }

  /**
   * @param loadablePattern
   * @param lpd void
   * @param displayOrder
   */
  private void saveLoadablePlanStowageDetails(
      LoadablePattern loadablePattern,
      com.cpdss.common.generated.LoadableStudy.LoadablePlanDetails lpd,
      AtomicInteger displayOrder) {
    lpd.getLoadablePlanPortWiseDetailsList()
        .forEach(
            lppwd -> {
              Long portRotationid = lppwd.getPortRotationId();
              LoadableStudyPortRotation portRotation =
                  loadableStudyPortRotationRepository.findByIdAndIsActive(portRotationid, true);
              if (!Objects.isNull(portRotation)) portRotationid = portRotation.getId();

              Long finalPortRotationid = portRotationid;
              lppwd
                  .getArrivalCondition()
                  .getLoadablePlanStowageDetailsList()
                  .forEach(
                      lpsd -> {
                        saveLoadablePlanStowageDetailsOperationWise(
                            SYNOPTICAL_TABLE_OP_TYPE_ARRIVAL,
                            lpsd,
                            lppwd.getPortId(),
                            finalPortRotationid,
                            loadablePattern);
                      });
              lppwd
                  .getDepartureCondition()
                  .getLoadablePlanStowageDetailsList()
                  .forEach(
                      lpsd -> {
                        saveLoadablePlanStowageDetailsOperationWise(
                            SYNOPTICAL_TABLE_OP_TYPE_DEPARTURE,
                            lpsd,
                            lppwd.getPortId(),
                            finalPortRotationid,
                            loadablePattern);
                      });
              saveCargoToppingOffList(lppwd, loadablePattern, displayOrder);
            });
  }

  /**
   * @param synopticalTableOpTypeArrival
   * @param lpsd
   * @param portId void
   * @param loadablePattern
   */
  private void saveLoadablePlanStowageDetailsOperationWise(
      String synopticalTableOpTypeArrival,
      com.cpdss.common.generated.LoadableStudy.LoadablePlanStowageDetails lpsd,
      long portId,
      Long portRotationId,
      LoadablePattern loadablePattern) {
    com.cpdss.loadablestudy.entity.LoadablePatternCargoDetails loadablePatternCargoDetails =
        new com.cpdss.loadablestudy.entity.LoadablePatternCargoDetails();
    loadablePatternCargoDetails.setIsActive(true);
    loadablePatternCargoDetails.setLoadablePatternId(loadablePattern.getId());
    loadablePatternCargoDetails.setOperationType(synopticalTableOpTypeArrival);
    loadablePatternCargoDetails.setPlannedQuantity(
        !StringUtils.isEmpty(lpsd.getWeight()) ? new BigDecimal(lpsd.getWeight()) : null);
    loadablePatternCargoDetails.setPortId(portId);
    loadablePatternCargoDetails.setPortRotationId(portRotationId);
    loadablePatternCargoDetails.setTankId(lpsd.getTankId());
    loadablePatternCargoDetails.setAbbreviation(lpsd.getCargoAbbreviation());
    loadablePatternCargoDetails.setApi(new BigDecimal(lpsd.getApi()));
    loadablePatternCargoDetails.setTemperature(new BigDecimal(lpsd.getTemperature()));
    loadablePatternCargoDetails.setColorCode(lpsd.getColorCode());
    loadablePatternCargoDetails.setCorrectionFactor(lpsd.getCorrectionFactor());
    loadablePatternCargoDetails.setCorrectedUllage(
        !StringUtils.isEmpty(lpsd.getCorrectedUllage())
            ? new BigDecimal(lpsd.getCorrectedUllage())
            : null);
    loadablePatternCargoDetails.setCargoNominationId(lpsd.getCargoNominationId());
    loadablePatternCargoDetails.setCargoNominationTemperature(
        new BigDecimal(lpsd.getTemperature()));
    loadablePatternCargoDetails.setFillingRatio(lpsd.getFillingRatio());
    // DS field
    loadablePatternCargoDetails.setOnBoard(
        lpsd.getOnboard().isBlank() ? null : new BigDecimal(lpsd.getOnboard()));
    loadablePatternCargoDetails.setMaxTankVolume(
        lpsd.getMaxTankVolume().isBlank() ? null : new BigDecimal(lpsd.getMaxTankVolume()));
    loadablePatternCargoDetailsRepository.save(loadablePatternCargoDetails);
  }

  private void saveCargoToppingOffList(
      com.cpdss.common.generated.LoadableStudy.LoadablePlanPortWiseDetails lppwd,
      LoadablePattern loadablePattern,
      AtomicInteger displayOrder) {
    lppwd
        .getDepartureCondition()
        .getLoadableQuantityCargoDetailsList()
        .forEach(
            lqcd -> {
              lqcd.getToppingOffSequencesList()
                  .forEach(
                      toppingSequence -> {
                        LoadablePatternCargoToppingOffSequence lpctos =
                            new LoadablePatternCargoToppingOffSequence();
                        lpctos.setCargoXId(toppingSequence.getCargoId());
                        lpctos.setTankXId(toppingSequence.getTankId());
                        lpctos.setOrderNumber(toppingSequence.getOrderNumber());
                        lpctos.setLoadablePattern(loadablePattern);
                        lpctos.setDisplayOrder(displayOrder.incrementAndGet());
                        lpctos.setPortRotationXId(lppwd.getPortRotationId());
                        lpctos.setIsActive(true);
                        toppingOffSequenceRepository.save(lpctos);
                      });
            });
  }

  /**
   * @param synopticalTableOpTypeDeparture
   * @param lpbd
   * @param portId
   * @param portRotationId
   * @param loadablePattern void
   */
  private void saveLoadablePlanBallastDetailsOperationWise(
      String synopticalTableOpTypeDeparture,
      com.cpdss.common.generated.LoadableStudy.LoadablePlanBallastDetails lpbd,
      long portId,
      Long portRotationId,
      LoadablePattern loadablePattern) {
    LoadablePlanStowageBallastDetails loadablePlanStowageBallastDetails =
        new LoadablePlanStowageBallastDetails();
    loadablePlanStowageBallastDetails.setLoadablePatternId(loadablePattern.getId());
    loadablePlanStowageBallastDetails.setOperationType(synopticalTableOpTypeDeparture);
    loadablePlanStowageBallastDetails.setPortXId(portId);
    loadablePlanStowageBallastDetails.setPortRotationId(portRotationId);
    loadablePlanStowageBallastDetails.setQuantity(
        !StringUtils.isEmpty(lpbd.getMetricTon()) ? new BigDecimal(lpbd.getMetricTon()) : null);
    loadablePlanStowageBallastDetails.setTankXId(lpbd.getTankId());
    loadablePlanStowageBallastDetails.setIsActive(true);
    loadablePlanStowageBallastDetails.setColorCode(BALLAST_TANK_COLOR_CODE);
    loadablePlanStowageBallastDetails.setSg(lpbd.getSg());
    loadablePlanStowageBallastDetails.setCorrectedUllage(lpbd.getCorrectedLevel());
    loadablePlanStowageBallastDetails.setCorrectionFactor(lpbd.getCorrectionFactor());
    loadablePlanStowageBallastDetails.setRdgUllage(lpbd.getRdgLevel());
    loadablePlanStowageBallastDetails.setFillingPercentage(lpbd.getPercentage());

    // DS fields
    loadablePlanStowageBallastDetails.setVolume(
        lpbd.getVolume().isBlank() ? null : new BigDecimal(lpbd.getVolume()));
    loadablePlanStowageBallastDetails.setMaxTankVolume(
        lpbd.getMaxTankVolume().isBlank() ? null : new BigDecimal(lpbd.getMaxTankVolume()));
    loadablePlanStowageBallastDetailsRepository.save(loadablePlanStowageBallastDetails);
  }

  /**
   * save comminglo cargo portwise information into loadable_plan_commingle_details_portwise table *
   */
  private void saveLoadableQuantityCommingleCargoPortwiseDetails(
      List<com.cpdss.common.generated.LoadableStudy.LoadablePlanPortWiseDetails>
          loadablePlanPortWiseDetailsList,
      LoadablePattern loadablePattern,
      AtomicInteger displayOrder) {

    loadablePlanPortWiseDetailsList.forEach(
        it -> {
          saveLodableQtyCommingleCargoPortData(
              it.getPortId(),
              it.getPortRotationId(),
              SYNOPTICAL_TABLE_OP_TYPE_ARRIVAL,
              it.getArrivalCondition().getLoadableQuantityCommingleCargoDetailsList(),
              loadablePattern,
              displayOrder);

          saveLodableQtyCommingleCargoPortData(
              it.getPortId(),
              it.getPortRotationId(),
              SYNOPTICAL_TABLE_OP_TYPE_DEPARTURE,
              it.getDepartureCondition().getLoadableQuantityCommingleCargoDetailsList(),
              loadablePattern,
              displayOrder);
        });
  }

  private void saveLodableQtyCommingleCargoPortData(
      long portId,
      long portRotationXid,
      String operationType,
      List<com.cpdss.common.generated.LoadableStudy.LoadableQuantityCommingleCargoDetails>
          loadableQuantityCommingleCargoDetailsList,
      LoadablePattern loadablePattern,
      AtomicInteger displayOrder) {

    if (Optional.ofNullable(loadableQuantityCommingleCargoDetailsList).isPresent()) {

      loadableQuantityCommingleCargoDetailsList.forEach(
          it -> {
            LoadablePlanComminglePortwiseDetails loadablePlanComminglePortwiseDetails =
                LoadablePlanComminglePortwiseDetails.builder()
                    .portId(portId)
                    .operationType(operationType)
                    .api(it.getApi())
                    .cargo1Abbreviation(it.getCargo1Abbreviation())
                    .cargo1Mt(it.getCargo1MT())
                    .cargo1Percentage(it.getCargo1Percentage())
                    .cargo2Abbreviation(it.getCargo2Abbreviation())
                    .cargo2Mt(it.getCargo2MT())
                    .cargo2Percentage(it.getCargo2Percentage())
                    .grade(it.getGrade())
                    .isActive(true)
                    .loadablePattern(loadablePattern)
                    .quantity(it.getQuantity())
                    .tankName(it.getTankName())
                    .temperature(it.getTemp())
                    .orderQuantity(it.getOrderedMT())
                    .priority(it.getPriority())
                    .loadingOrder(it.getLoadingOrder())
                    .tankId(it.getTankId())
                    .fillingRatio(it.getFillingRatio())
                    .correctionFactor(it.getCorrectionFactor())
                    .correctedUllage(it.getCorrectedUllage())
                    .rdgUllage(it.getRdgUllage())
                    .cargo1NominationId(it.getCargo1NominationId())
                    .cargo2NominationId(it.getCargo2NominationId())
                    .portRotationXid(portRotationXid)
                    .tankName(it.getTankShortName())
                    .commingleColour(it.getCommingleColour())
                    // .actualQuantity(it.getActualQuantity()!= null ? new
                    // BigDecimal(it.getActualQuantity()): null)
                    .build();

            Optional<CommingleCargo> commingleCargoOpt =
                commingleCargoRepository
                    .findByLoadableStudyXIdAndCargoNomination1IdAndCargoNomination2IdAndIsActiveTrue(
                        loadablePattern.getLoadableStudy().getId(),
                        it.getCargo1NominationId(),
                        it.getCargo2NominationId());
            commingleCargoOpt.ifPresent(
                commingle ->
                    loadablePlanComminglePortwiseDetails.setGrade(commingle.getAbbreviation()));

            loadablePlanCommingleDetailsPortwiseRepository.save(
                loadablePlanComminglePortwiseDetails);

            if (operationType.equals(SYNOPTICAL_TABLE_OP_TYPE_DEPARTURE)) {
              if (Optional.ofNullable(it.getToppingOffSequencesList())
                  .isPresent()) { // Added null check
                it.getToppingOffSequencesList()
                    .forEach(
                        toppingSequence -> {
                          LoadablePatternCargoToppingOffSequence lpctos =
                              new LoadablePatternCargoToppingOffSequence();
                          lpctos.setCargoXId(toppingSequence.getCargoId());
                          lpctos.setTankXId(toppingSequence.getTankId());
                          lpctos.setOrderNumber(toppingSequence.getOrderNumber());
                          lpctos.setLoadablePattern(loadablePattern);
                          lpctos.setDisplayOrder(displayOrder.incrementAndGet());
                          lpctos.setPortRotationXId(portRotationXid);
                          lpctos.setIsActive(true);
                          toppingOffSequenceRepository.save(lpctos);
                        });
              }
            }
          });
    }
  }

  /**
   * @param loadablePattern
   * @param lpd void
   * @param lastLoadingPort
   */
  private void saveStabilityParameters(
      LoadablePattern loadablePattern,
      com.cpdss.common.generated.LoadableStudy.LoadablePlanDetails lpd,
      Long lastLoadingPort) {
    log.info("saving stability parameter to DB");
    StabilityParameters stabilityParameter = new StabilityParameters();
    stabilityParameter.setAftDraft(lpd.getStabilityParameters().getAfterDraft());
    stabilityParameter.setBendingMoment(lpd.getStabilityParameters().getBendinMoment());
    stabilityParameter.setFwdDraft(lpd.getStabilityParameters().getForwardDraft());
    stabilityParameter.setHeal(lpd.getStabilityParameters().getHeel());
    stabilityParameter.setLoadablePattern(loadablePattern);
    stabilityParameter.setMeanDraft(lpd.getStabilityParameters().getMeanDraft());
    stabilityParameter.setPortXid(lastLoadingPort);
    stabilityParameter.setShearingForce(lpd.getStabilityParameters().getShearForce());
    stabilityParameter.setTrimValue(lpd.getStabilityParameters().getTrim());
    stabilityParameter.setIsActive(true);
    // DS field
    StabilityParameter s = lpd.getStabilityParameters();
    stabilityParameter.setAirDraft(
        lpd.getStabilityParameters().getAirDraft().isBlank()
            ? null
            : new BigDecimal(lpd.getStabilityParameters().getAirDraft()));
    stabilityParameter.setFreeboard(
        lpd.getStabilityParameters().getFreeboard().isBlank()
            ? null
            : new BigDecimal(lpd.getStabilityParameters().getFreeboard()));
    stabilityParameter.setManifoldHeight(
        lpd.getStabilityParameters().getManifoldHeight().isBlank()
            ? null
            : new BigDecimal(lpd.getStabilityParameters().getManifoldHeight()));
    stabilityParameterRepository.save(stabilityParameter);
  }

  private void saveStabilityParameterForNonLodicator(
      boolean hasLodicator,
      LoadablePattern loadablePattern,
      com.cpdss.common.generated.LoadableStudy.LoadablePlanDetails lpd) {

    if (!hasLodicator) {
      for (com.cpdss.common.generated.LoadableStudy.LoadablePlanPortWiseDetails portWiseDetails :
          lpd.getLoadablePlanPortWiseDetailsList()) {
        com.cpdss.common.generated.LoadableStudy.LoadablePlanDetailsReply arrivalCondition =
            portWiseDetails.getArrivalCondition();

        Long portRotationid = portWiseDetails.getPortRotationId();
        LoadableStudyPortRotation portRotation =
            loadableStudyPortRotationRepository.findByIdAndIsActive(portRotationid, true);
        if (!Objects.isNull(portRotation)) portRotationid = portRotation.getId();
        if (Optional.ofNullable(arrivalCondition).isPresent()) {
          loadicatorService.saveLodicatorDataForSynoptical(
              loadablePattern, arrivalCondition, lpd, "ARR", portRotationid);
        }

        com.cpdss.common.generated.LoadableStudy.LoadablePlanDetailsReply departureCondition =
            portWiseDetails.getDepartureCondition();
        if (Optional.ofNullable(departureCondition).isPresent()) {
          loadicatorService.saveLodicatorDataForSynoptical(
              loadablePattern, departureCondition, lpd, "DEP", portRotationid);
        }
      }
    }
  }

  /** @param loadablePattern */
  public void deleteExistingPlanDetails(LoadablePattern loadablePattern) {
    stowageDetailsTempRepository.deleteLoadablePlanStowageDetailsTemp(
        false, loadablePattern.getId());
    loadablePlanQuantityRepository.deleteLoadablePlanQuantity(false, loadablePattern.getId());
    loadablePlanCommingleDetailsRepository.deleteLoadablePlanCommingleDetails(
        false, loadablePattern.getId());
    loadablePlanStowageDetailsRespository.deleteLoadablePlanStowageDetails(
        false, loadablePattern.getId());
    loadablePatternCargoDetailsRepository.deleteLoadablePatternCargoDetails(
        false, loadablePattern.getId());
    loadablePlanBallastDetailsRepository.deleteLoadablePlanBallastDetails(
        false, loadablePattern.getId());
    loadablePlanStowageBallastDetailsRepository.deleteLoadablePlanStowageBallastDetails(
        false, loadablePattern.getId());
    synopticalTableLoadicatorDataRepository.deleteByLoadablePatternId(
        false, loadablePattern.getId());
    cargoToppingOffSequenceRepository.deleteByLoadablePatternId(loadablePattern.getId());
  }

  public com.cpdss.common.generated.LoadableStudy.LoadablePatternReply.Builder
      getLoadablePatternList(
          com.cpdss.common.generated.LoadableStudy.LoadablePatternRequest request,
          com.cpdss.common.generated.LoadableStudy.LoadablePatternReply.Builder replyBuilder)
          throws GenericServiceException {
    log.info("getLoadablePatternList - loadable study micro service");
    Optional<LoadableStudy> loadableStudyOpt =
        this.loadableStudyRepository.findByIdAndIsActive(request.getLoadableStudyId(), true);
    if (!loadableStudyOpt.isPresent()) {
      throw new GenericServiceException(
          "Loadable study does not exist",
          CommonErrorCodes.E_HTTP_BAD_REQUEST,
          HttpStatusCode.BAD_REQUEST);
    }
    List<LoadablePattern> patterns =
        this.loadablePatternRepository.findByLoadableStudyAndIsActiveOrderByCaseNumberAsc(
            loadableStudyOpt.get(), true);
    if (null != patterns && !patterns.isEmpty()) {
      this.buildPatternDetails(patterns, replyBuilder);
    }
    replyBuilder.setResponseStatus(Common.ResponseStatus.newBuilder().setStatus(SUCCESS).build());
    return replyBuilder;
  }

  /**
   * Build pattern reply
   *
   * @param patterns
   * @param replyBuilder
   */
  private void buildPatternDetails(
      List<LoadablePattern> patterns,
      com.cpdss.common.generated.LoadableStudy.LoadablePatternReply.Builder replyBuilder) {
    for (LoadablePattern pattern : patterns) {
      com.cpdss.common.generated.LoadableStudy.LoadablePattern.Builder builder =
          com.cpdss.common.generated.LoadableStudy.LoadablePattern.newBuilder();
      builder.setLoadablePatternId(pattern.getId());
      builder.setLoadableStudyStatusId(pattern.getLoadableStudyStatus());
      ofNullable(pattern.getCaseNumber()).ifPresent(item -> builder.setCaseNumber(item));
      replyBuilder.addLoadablePattern(builder.build());
    }
  }

  public com.cpdss.common.generated.LoadableStudy.AlgoReply.Builder generateLoadablePatterns(
      com.cpdss.common.generated.LoadableStudy.AlgoRequest request,
      com.cpdss.common.generated.LoadableStudy.AlgoReply.Builder replyBuilder)
      throws GenericServiceException, IOException {
    Optional<LoadableStudy> loadableStudyOpt =
        loadableStudyRepository.findByIdAndIsActive(request.getLoadableStudyId(), true);
    if (loadableStudyOpt.isPresent()) {
      this.voyageService.checkIfVoyageClosed(loadableStudyOpt.get().getVoyage().getId());
      this.validateLoadableStudyWithLQ(loadableStudyOpt.get());
      cargoNominationService.validateLoadableStudyWithCommingle(loadableStudyOpt.get());
      ModelMapper modelMapper = new ModelMapper();
      com.cpdss.loadablestudy.domain.LoadableStudy loadableStudy =
          new com.cpdss.loadablestudy.domain.LoadableStudy();

      loadableStudyService.buildLoadableStudy(
          request.getLoadableStudyId(), loadableStudyOpt.get(), loadableStudy, modelMapper);
      loadableStudyService.buildLoadableAttachment(request.getLoadableStudyId(), loadableStudy);
      loadableStudyService.buildSynopticalTable(request.getLoadableStudyId(), loadableStudy);

      // Voyage History
      loadableStudy.setVoyageCargoHistories(cargoService.buildPreviousVoyageDetails());
      ObjectMapper objectMapper = new ObjectMapper();

      objectMapper.writeValue(
          new File(
              this.rootFolder + "/json/loadableStudy_" + request.getLoadableStudyId() + ".json"),
          loadableStudy);

      jsonDataService.saveJsonToDatabase(
          request.getLoadableStudyId(),
          LOADABLE_STUDY_REQUEST,
          objectMapper.writeValueAsString(loadableStudy));
      if (enableCommunication && env.equals("ship")) {
        this.voyageService.buildVoyageDetails(modelMapper, loadableStudy);
        EnvoyWriter.WriterReply ewReply =
            communicationService.passRequestPayloadToEnvoyWriter(
                objectMapper.writeValueAsString(loadableStudy),
                loadableStudy.getVesselId(),
                MessageTypes.LOADABLESTUDY.getMessageType());
        if (SUCCESS.equals(ewReply.getResponseStatus().getStatus())) {
          LoadableStudyCommunicationStatus lsCommunicationStatus =
              new LoadableStudyCommunicationStatus();
          if (ewReply.getMessageId() != null) {
            lsCommunicationStatus.setMessageUUID(ewReply.getMessageId());
            lsCommunicationStatus.setCommunicationStatus(
                CommunicationStatus.UPLOAD_WITH_HASH_VERIFIED.getId());
          }
          lsCommunicationStatus.setReferenceId(request.getLoadableStudyId());
          lsCommunicationStatus.setMessageType(MessageTypes.LOADABLESTUDY.getMessageType());
          lsCommunicationStatus.setCommunicationDateTime(LocalDateTime.now());
          this.loadableStudyCommunicationStatusRepository.save(lsCommunicationStatus);
          updateProcessIdForLoadableStudy(
              "",
              loadableStudyOpt.get(),
              LOADABLE_STUDY_COMMUNICATED_TO_SHORE,
              ewReply.getMessageId(),
              true);

          loadableStudyRepository.updateLoadableStudyStatus(
              LOADABLE_STUDY_COMMUNICATED_TO_SHORE, loadableStudyOpt.get().getId());
          replyBuilder
              .setProcesssId(ewReply.getMessageId())
              .setResponseStatus(
                  Common.ResponseStatus.newBuilder()
                      .setMessage(SUCCESS)
                      .setStatus(SUCCESS)
                      .build());
        } else {
          getAlgoCall(replyBuilder, loadableStudyOpt, loadableStudy);
        }
      } else {
        getAlgoCall(replyBuilder, loadableStudyOpt, loadableStudy);
      }
    } else {
      log.info("INVALID_LOADABLE_STUDY {} - ", request.getLoadableStudyId());
      replyBuilder.setResponseStatus(
          Common.ResponseStatus.newBuilder()
              .setStatus(FAILED)
              .setMessage(INVALID_LOADABLE_STUDY_ID)
              .setCode(CommonErrorCodes.E_HTTP_BAD_REQUEST)
              .build());
    }
    replyBuilder.setResponseStatus(
        Common.ResponseStatus.newBuilder().setMessage(SUCCESS).setStatus(SUCCESS).build());
    return replyBuilder;
  }

  private void getAlgoCall(
      com.cpdss.common.generated.LoadableStudy.AlgoReply.Builder replyBuilder,
      Optional<LoadableStudy> loadableStudyOpt,
      com.cpdss.loadablestudy.domain.LoadableStudy loadableStudy)
      throws GenericServiceException {
    AlgoResponse algoResponse =
        algoService.callAlgo(
            loadableStudyOpt.get().getId(),
            loadableStudyUrl,
            loadableStudy,
            AlgoResponse.class,
            false,
            null);
    updateProcessIdForLoadableStudy(
        algoResponse.getProcessId(),
        loadableStudyOpt.get(),
        LOADABLE_STUDY_PROCESSING_STARTED_ID,
        "",
        false);

    loadableStudyRepository.updateLoadableStudyStatus(
        LOADABLE_STUDY_PROCESSING_STARTED_ID, loadableStudyOpt.get().getId());

    replyBuilder
        .setProcesssId(algoResponse.getProcessId())
        .setResponseStatus(
            Common.ResponseStatus.newBuilder().setMessage(SUCCESS).setStatus(SUCCESS).build());
  }

  private void validateLoadableStudyWithLQ(LoadableStudy ls) throws GenericServiceException {
    List<PortRotationIdAndPortId> ports =
        loadableStudyPortRotationRepository.findAllIdAndPortIdsByLSId(ls.getId(), true);
    boolean valid = false;
    for (PortRotationIdAndPortId port : ports) {
      Optional<LoadableQuantity> lQs =
          loadableQuantityRepository.findByLSIdAndPortRotationId(ls.getId(), port.getId(), true);
      if (lQs.isPresent()) {
        valid = true;
        break;
      }
    }
    if (!valid) {
      log.info("Loadable Study Validation, No Loadable Quantity Found for Ls Id - {}", ls.getId());
      throw new GenericServiceException(
          "No Loadable Quantity Found for Loadable Study, Id " + ls.getId(),
          CommonErrorCodes.E_CPDSS_LS_INVALID_LQ,
          HttpStatusCode.INTERNAL_SERVER_ERROR);
    }
  }

  /**
   * @param loadableStudy void
   * @param loadableStudyStatus
   * @param messageId
   * @param generatedFromShore
   */
  public void updateProcessIdForLoadableStudy(
      String processId,
      LoadableStudy loadableStudy,
      Long loadableStudyStatus,
      String messageId,
      boolean generatedFromShore) {

    LoadableStudyAlgoStatus status =
        loadableStudyAlgoStatusRepository
            .findByLoadableStudyIdAndMessageIdAndIsActive(loadableStudy.getId(), messageId, true)
            .orElse(new LoadableStudyAlgoStatus());

    status.setIsActive(true);
    status.setLoadableStudy(loadableStudy);
    status.setLoadableStudyStatus(loadableStudyStatusRepository.getOne(loadableStudyStatus));
    status.setProcessId(processId);
    status.setVesselxid(loadableStudy.getVesselXId());
    status.setMessageId(messageId);
    status.setGeneratedFromShore(generatedFromShore);

    loadableStudyAlgoStatusRepository.save(status);
  }

  public com.cpdss.common.generated.LoadableStudy.LoadablePatternReply.Builder
      getLoadablePatternDetails(
          com.cpdss.common.generated.LoadableStudy.LoadablePatternRequest request,
          com.cpdss.common.generated.LoadableStudy.LoadablePatternReply.Builder builder)
          throws GenericServiceException {
    Optional<LoadableStudy> loadableStudy =
        this.loadableStudyRepository.findByIdAndIsActive(request.getLoadableStudyId(), true);
    if (!loadableStudy.isPresent()) {
      log.info(INVALID_LOADABLE_STUDY_ID, request.getLoadableStudyId());
      builder.setResponseStatus(
          Common.ResponseStatus.newBuilder()
              .setStatus(FAILED)
              .setMessage(INVALID_LOADABLE_STUDY_ID)
              .setCode(CommonErrorCodes.E_HTTP_BAD_REQUEST));
    } else {
      boolean status = loadablePlanService.validateLoadableStudyForConfimPlan(loadableStudy.get());
      builder.setConfirmPlanEligibility(status);
      List<LoadablePattern> loadablePatterns =
          loadablePatternRepository.findByLoadableStudyAndIsActiveOrderByCaseNumberAsc(
              loadableStudy.get(), true);
      log.info(
          "Loadable Patterns, Found {} loadaple patterns for LS {}, Id {}",
          loadablePatterns.size(),
          loadableStudy.get().getName(),
          loadableStudy.get().getId());
      loadablePatterns.forEach(
          loadablePattern -> {
            com.cpdss.common.generated.LoadableStudy.LoadablePattern.Builder
                loadablePatternBuilder =
                    com.cpdss.common.generated.LoadableStudy.LoadablePattern.newBuilder();
            loadablePatternBuilder.setLoadablePatternId(loadablePattern.getId());
            ofNullable(loadableStudy.get().getName()).ifPresent(builder::setLoadableStudyName);
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(CREATED_DATE_FORMAT);
            ofNullable(dateTimeFormatter.format(loadablePattern.getCreatedDate()))
                .ifPresent(builder::setLoadablePatternCreatedDate);
            ofNullable(loadablePattern.getLoadableStudyStatus())
                .ifPresent(loadablePatternBuilder::setLoadableStudyStatusId);
            // if (stowageDetailsTempRepository
            // .findByLoadablePatternAndIsActive(loadablePattern, true)
            // .isEmpty()) loadablePatternBuilder.setValidated(true);
            ofNullable(loadablePattern.getCaseNumber())
                .ifPresent(loadablePatternBuilder::setCaseNumber);
            List<LoadablePatternAlgoStatus> patternStatus =
                loadablePatternAlgoStatusRepository.findByLoadablePatternAndIsActive(
                    loadablePattern, true);
            if (!patternStatus.isEmpty()) {
              loadablePatternBuilder.setLoadablePatternStatusId(
                  patternStatus.get(patternStatus.size() - 1).getLoadableStudyStatus().getId());
            }

            if (!patternStatus.isEmpty()) {
              if (stowageDetailsTempRepository
                      .findByLoadablePatternAndIsActive(loadablePattern, true)
                      .isEmpty()
                  || VALIDATED_CONDITIONS.contains(
                      loadablePatternBuilder.getLoadablePatternStatusId())) {
                loadablePatternBuilder.setValidated(true);
              }
            } else {
              if (stowageDetailsTempRepository
                  .findByLoadablePatternAndIsActive(loadablePattern, true)
                  .isEmpty()) {
                loadablePatternBuilder.setValidated(true);
              }
            }

            loadablePatternBuilder.setStabilityParameters(buildStabilityParamter(loadablePattern));

            List<LoadablePlanConstraints> loadablePlanConstraints =
                loadablePlanConstraintsRespository.findByLoadablePatternAndIsActive(
                    loadablePattern, true);
            loadablePatternBuilder.clearConstraints();
            buildLoadablePatternConstraints(loadablePlanConstraints, loadablePatternBuilder);

            loadablePatternBuilder.clearLoadablePatternCargoDetails();
            buildLoadablePatternCargoAndCommingleDetails(loadablePattern, loadablePatternBuilder);
            List<LoadablePlanStowageDetails> loadablePlanStowageDetails =
                loadablePlanStowageDetailsRespository.findByLoadablePatternAndIsActive(
                    loadablePattern, true);
            com.cpdss.common.generated.LoadableStudy.LoadablePlanDetailsReply.Builder replyBuilder =
                com.cpdss.common.generated.LoadableStudy.LoadablePlanDetailsReply.newBuilder();
            List<Long> tankIds =
                loadablePlanStowageDetails.stream()
                    .map(LoadablePlanStowageDetails::getTankId)
                    .collect(Collectors.toList());
            VesselInfo.VesselTankRequest replyTankBuilder =
                VesselInfo.VesselTankRequest.newBuilder().addAllTankIds(tankIds).build();
            VesselInfo.VesselTankResponse vesselReply =
                this.getVesselTankDetailsByTankIds(replyTankBuilder);
            loadablePlanService.buildLoadablePlanStowageCargoDetails(
                loadablePlanStowageDetails, replyBuilder, vesselReply);
            List<com.cpdss.common.generated.LoadableStudy.LoadablePlanStowageDetails>
                modifieableList = new ArrayList<>(replyBuilder.getLoadablePlanStowageDetailsList());
            Collections.sort(
                modifieableList,
                Comparator.comparing(
                    com.cpdss.common.generated.LoadableStudy.LoadablePlanStowageDetails
                        ::getTankDisplayOrder));
            loadablePatternBuilder.addAllLoadablePlanStowageDetails(modifieableList);

            // <--DSS-2016-->
            // loadableQuantityCargoDetails in json response
            List<LoadablePlanQuantity> loadablePlanQuantities =
                loadablePlanQuantityRepository.findByLoadablePatternAndIsActive(
                    loadablePattern, true);
            log.info(
                "Loadable Patters, Loadable Plan Quantity Size {}", loadablePlanQuantities.size());
            loadablePlanService.buildLoadablePlanQuantity(
                loadablePlanQuantities, loadablePatternBuilder);
            List<LoadablePlanCommingleDetails> loadablePlanCommingleDetails =
                loadablePlanCommingleDetailsRepository.findByLoadablePatternAndIsActive(
                    loadablePattern, true);
            loadablePlanService.buildLoadablePlanCommingleDetails(
                loadablePlanCommingleDetails, loadablePatternBuilder);
            List<LoadablePlanBallastDetails> loadablePlanBallastDetails =
                loadablePlanBallastDetailsRepository.findByLoadablePatternAndIsActive(
                    loadablePattern, true);
            List<LoadablePlanStowageDetailsTemp> ballstTempList =
                this.stowageDetailsTempRepository.findByLoadablePlanBallastDetailsInAndIsActive(
                    loadablePlanBallastDetails, true);
            loadablePlanService.buildBallastGridDetails(
                loadablePlanBallastDetails, ballstTempList, loadablePatternBuilder);
            // <--DSS-2016!-->

            builder.addLoadablePattern(loadablePatternBuilder);
            loadablePatternBuilder.clearLoadablePlanStowageDetails();
            loadablePatternBuilder.clearLoadableQuantityCargoDetails();
          });

      VesselInfo.VesselReply vesselReply =
          this.getTankListForPattern(loadableStudy.get().getVesselXId());
      VesselInfo.VesselReply vesselReply2 =
          this.getTanks(loadableStudy.get().getVesselXId(), CARGO_BALLAST_TANK_CATEGORIES);
      if (!SUCCESS.equals(vesselReply.getResponseStatus().getStatus())) {
        builder.setResponseStatus(Common.ResponseStatus.newBuilder().setStatus(FAILED).build());
      } else {
        builder.addAllTanks(onHandQuantityService.groupTanks(vesselReply.getVesselTanksList()));
        builder.setResponseStatus(Common.ResponseStatus.newBuilder().setStatus(SUCCESS).build());
        buildBallastTankLayout(
            vesselReply2.getVesselTanksList().stream()
                .filter(tankList -> BALLAST_TANK_CATEGORIES.contains(tankList.getTankCategoryId()))
                .collect(Collectors.toList()),
            builder);
      }
    }
    return builder;
  }

  /**
   * @param loadablePattern
   * @return StabilityParameter
   */
  private com.cpdss.common.generated.LoadableStudy.StabilityParameter buildStabilityParamter(
      LoadablePattern loadablePattern) {
    com.cpdss.common.generated.LoadableStudy.StabilityParameter.Builder builder =
        com.cpdss.common.generated.LoadableStudy.StabilityParameter.newBuilder();
    stabilityParameterRepository
        .findByLoadablePatternAndIsActive(loadablePattern, true)
        .forEach(
            sp -> {
              builder.setAfterDraft(sp.getAftDraft());
              builder.setBendinMoment(sp.getBendingMoment());
              builder.setForwardDraft(sp.getFwdDraft());
              builder.setHeel(sp.getHeal());
              builder.setMeanDraft(sp.getMeanDraft());
              builder.setShearForce(sp.getShearingForce());
              builder.setTrim(sp.getTrimValue());
            });
    return builder.build();
  }

  /**
   * @param loadablePlanConstraints
   * @param loadablePatternBuilder void
   */
  private void buildLoadablePatternConstraints(
      List<LoadablePlanConstraints> loadablePlanConstraints,
      com.cpdss.common.generated.LoadableStudy.LoadablePattern.Builder loadablePatternBuilder) {
    loadablePlanConstraints.forEach(
        lpc -> {
          loadablePatternBuilder.addConstraints(lpc.getConstraintsData());
        });
  }

  /**
   * @param loadablePattern
   * @param loadablePatternBuilder void
   */
  private void buildLoadablePatternCargoAndCommingleDetails(
      LoadablePattern loadablePattern,
      com.cpdss.common.generated.LoadableStudy.LoadablePattern.Builder loadablePatternBuilder) {
    List<LoadablePlanQuantity> loadablePlanQuantities =
        loadablePlanQuantityRepository.findByLoadablePatternAndIsActive(loadablePattern, true);
    loadablePlanQuantities.forEach(
        lpq -> {
          com.cpdss.common.generated.LoadableStudy.LoadablePatternCargoDetails.Builder
              loadablePatternCargoDetailsBuilder =
                  com.cpdss.common.generated.LoadableStudy.LoadablePatternCargoDetails.newBuilder();
          Optional.ofNullable(lpq.getMaxTolerence())
              .ifPresent(val -> loadablePatternCargoDetailsBuilder.setMaxTolerence(val));
          Optional.ofNullable(lpq.getMinTolerence())
              .ifPresent(val -> loadablePatternCargoDetailsBuilder.setMinTolerence(val));
          Optional.ofNullable(lpq.getPriority())
              .ifPresent(priority -> loadablePatternCargoDetailsBuilder.setPriority(priority));
          ofNullable(lpq.getLoadableMt())
              .ifPresent(
                  quantity ->
                      loadablePatternCargoDetailsBuilder.setQuantity(String.valueOf(quantity)));
          ofNullable(lpq.getOrderQuantity())
              .ifPresent(
                  orderedQuantity ->
                      loadablePatternCargoDetailsBuilder.setOrderedQuantity(
                          String.valueOf(orderedQuantity)));

          ofNullable(lpq.getCargoAbbreviation())
              .ifPresent(
                  cargoAbbreviation ->
                      loadablePatternCargoDetailsBuilder.setCargoAbbreviation(cargoAbbreviation));
          ofNullable(lpq.getCargoColor())
              .ifPresent(
                  cargoColor -> loadablePatternCargoDetailsBuilder.setCargoColor(cargoColor));
          ofNullable(lpq.getLoadingOrder())
              .ifPresent(
                  loadingOrder -> loadablePatternCargoDetailsBuilder.setLoadingOrder(loadingOrder));
          ofNullable(lpq.getEstimatedApi())
              .ifPresent(api -> loadablePatternCargoDetailsBuilder.setApi(String.valueOf(api)));
          Optional.ofNullable(lpq.getCargoNominationTemperature())
              .ifPresent(
                  temp -> loadablePatternCargoDetailsBuilder.setTemperature(String.valueOf(temp)));

          loadablePatternCargoDetailsBuilder.setIsCommingle(false);
          loadablePatternBuilder.addLoadablePatternCargoDetails(loadablePatternCargoDetailsBuilder);
        });

    List<LoadablePlanCommingleDetails> loadablePlanCommingleDetails =
        loadablePlanCommingleDetailsRepository.findByLoadablePatternAndIsActive(
            loadablePattern, true);
    loadablePlanCommingleDetails.forEach(
        lpcd -> {
          com.cpdss.common.generated.LoadableStudy.LoadablePatternCargoDetails.Builder
              loadablePatternCargoDetailsBuilder =
                  com.cpdss.common.generated.LoadableStudy.LoadablePatternCargoDetails.newBuilder();
          ofNullable(lpcd.getPriority())
              .ifPresent(priority -> loadablePatternCargoDetailsBuilder.setPriority(priority));
          ofNullable(lpcd.getQuantity())
              .ifPresent(
                  quantity ->
                      loadablePatternCargoDetailsBuilder.setQuantity(String.valueOf(quantity)));
          ofNullable(lpcd.getQuantity())
              .ifPresent(
                  orderedQuantity ->
                      loadablePatternCargoDetailsBuilder.setOrderedQuantity(
                          String.valueOf(orderedQuantity)));

          ofNullable(lpcd.getGrade())
              .ifPresent(
                  cargoAbbreviation ->
                      loadablePatternCargoDetailsBuilder.setCargoAbbreviation(cargoAbbreviation));

          loadablePatternCargoDetailsBuilder.setIsCommingle(true);
          ofNullable(lpcd.getId())
              .ifPresent(
                  id ->
                      loadablePatternCargoDetailsBuilder.setLoadablePatternCommingleDetailsId(id));
          ofNullable(lpcd.getLoadingOrder())
              .ifPresent(
                  loadingOrder -> loadablePatternCargoDetailsBuilder.setLoadingOrder(loadingOrder));
          ofNullable(lpcd.getApi())
              .ifPresent(api -> loadablePatternCargoDetailsBuilder.setApi(String.valueOf(api)));

          loadablePatternBuilder.addLoadablePatternCargoDetails(loadablePatternCargoDetailsBuilder);

          com.cpdss.common.generated.LoadableStudy.LoadablePlanStowageDetails.Builder builder =
              com.cpdss.common.generated.LoadableStudy.LoadablePlanStowageDetails.newBuilder();
          Optional.ofNullable(lpcd.getId()).ifPresent(builder::setId);
          Optional.ofNullable(lpcd.getGrade()).ifPresent(builder::setCargoAbbreviation);
          Optional.ofNullable(lpcd.getApi()).ifPresent(builder::setApi);
          Optional.ofNullable(lpcd.getCorrectedUllage()).ifPresent(builder::setCorrectedUllage);
          Optional.ofNullable(lpcd.getCorrectionFactor()).ifPresent(builder::setCorrectionFactor);
          Optional.ofNullable(lpcd.getFillingRatio()).ifPresent(builder::setFillingRatio);

          Optional.ofNullable(lpcd.getFillingRatio()).ifPresent(builder::setFillingRatioOrginal);
          Optional.ofNullable(lpcd.getCorrectedUllage())
              .ifPresent(builder::setCorrectedUllageOrginal);
          Optional.ofNullable(lpcd.getCorrectionFactor())
              .ifPresent(builder::setCorrectionFactorOrginal);
          Optional.ofNullable(lpcd.getRdgUllage()).ifPresent(builder::setRdgUllageOrginal);
          Optional.ofNullable(lpcd.getQuantity()).ifPresent(builder::setWeightOrginal);

          Optional.ofNullable(lpcd.getRdgUllage()).ifPresent(builder::setRdgUllage);
          Optional.ofNullable(lpcd.getTankName()).ifPresent(builder::setTankName);
          Optional.ofNullable(lpcd.getTankShortName()).ifPresent(builder::setTankShortName);
          Optional.ofNullable(lpcd.getTankId()).ifPresent(builder::setTankId);
          Optional.ofNullable(lpcd.getTemperature()).ifPresent(builder::setTemperature);
          Optional.ofNullable(lpcd.getQuantity()).ifPresent(builder::setWeight);
          builder.setIsCommingle(true);
          loadablePatternBuilder.addLoadablePlanStowageDetails(builder);
        });
  }

  /**
   * @param vesselId
   * @return VesselReply
   */
  private VesselInfo.VesselReply getTankListForPattern(Long vesselId) {
    VesselInfo.VesselRequest.Builder vesselGrpcRequest = VesselInfo.VesselRequest.newBuilder();
    vesselGrpcRequest.setVesselId(vesselId);
    vesselGrpcRequest.addAllTankCategories(CARGO_TANK_CATEGORIES);
    VesselInfo.VesselReply vesselReply =
        loadableStudyService.getVesselTanks(vesselGrpcRequest.build());
    return vesselReply;
  }

  public VesselInfo.VesselTankResponse getVesselTankDetailsByTankIds(
      VesselInfo.VesselTankRequest replyBuilder) {
    return this.vesselInfoGrpcService.getVesselInfoBytankIds(replyBuilder);
  }

  private VesselInfo.VesselReply getTanks(Long vesselId, List<Long> tankCategory)
      throws GenericServiceException {
    VesselInfo.VesselRequest.Builder vesselGrpcRequest = VesselInfo.VesselRequest.newBuilder();
    vesselGrpcRequest.setVesselId(vesselId);
    vesselGrpcRequest.addAllTankCategories(tankCategory);
    return this.getVesselTanks(vesselGrpcRequest.build());
  }

  /**
   * Ballast Tank category builder
   *
   * @param vesselTankDetails - List<VesselTankDetail>
   * @param replyBuilder - LoadablePatternReply.Builder
   */
  private void buildBallastTankLayout(
      List<VesselInfo.VesselTankDetail> vesselTankDetails,
      com.cpdss.common.generated.LoadableStudy.LoadablePatternReply.Builder replyBuilder) {

    List<VesselInfo.VesselTankDetail> frontBallastTanks = new ArrayList<>();
    List<VesselInfo.VesselTankDetail> centerBallestTanks = new ArrayList<>();
    List<VesselInfo.VesselTankDetail> rearBallastTanks = new ArrayList<>();
    frontBallastTanks.addAll(
        vesselTankDetails.stream()
            .filter(tank -> BALLAST_FRONT_TANK.equals(tank.getTankPositionCategory()))
            .collect(Collectors.toList()));
    centerBallestTanks.addAll(
        vesselTankDetails.stream()
            .filter(tank -> BALLAST_CENTER_TANK.equals(tank.getTankPositionCategory()))
            .collect(Collectors.toList()));

    rearBallastTanks.addAll(
        vesselTankDetails.stream()
            .filter(tank -> BALLAST_REAR_TANK.equals(tank.getTankPositionCategory()))
            .collect(Collectors.toList()));

    replyBuilder.addAllBallastFrontTanks(onHandQuantityService.groupTanks(frontBallastTanks));
    replyBuilder.addAllBallastCenterTanks(onHandQuantityService.groupTanks(centerBallestTanks));
    replyBuilder.addAllBallastRearTanks(onHandQuantityService.groupTanks(rearBallastTanks));
  }

  /**
   * Get vessel fuel tanks from vessel micro service
   *
   * @param request
   * @return
   */
  public VesselInfo.VesselReply getVesselTanks(VesselInfo.VesselRequest request) {
    return this.vesselInfoGrpcService.getVesselTanks(request);
  }

  public com.cpdss.common.generated.LoadableStudy.LoadablePatternCommingleDetailsReply.Builder
      getLoadablePatternCommingleDetails(
          com.cpdss.common.generated.LoadableStudy.LoadablePatternCommingleDetailsRequest request,
          com.cpdss.common.generated.LoadableStudy.LoadablePatternCommingleDetailsReply.Builder
              builder) {
    Optional<LoadablePlanCommingleDetails> loadablePlanComingleDetails =
        loadablePlanCommingleDetailsRepository.findByIdAndIsActive(
            request.getLoadablePatternCommingleDetailsId(), true);
    if (!loadablePlanComingleDetails.isPresent()) {
      log.info(
          INVALID_LOADABLE_PATTERN_COMMINGLE_DETAIL_ID,
          request.getLoadablePatternCommingleDetailsId());
      builder.setResponseStatus(
          Common.ResponseStatus.newBuilder()
              .setStatus(FAILED)
              .setMessage(INVALID_LOADABLE_PATTERN_COMMINGLE_DETAIL_ID)
              .setCode(CommonErrorCodes.E_HTTP_BAD_REQUEST));
    } else {

      buildLoadablePatternComingleDetails(loadablePlanComingleDetails.get(), builder);
      builder.setResponseStatus(Common.ResponseStatus.newBuilder().setStatus(SUCCESS).build());
    }
    return builder;
  }

  /**
   * Build upadate ullage reply
   *
   * @param builder
   * @param loadablePlanCommingleDetails
   * @return
   */
  private void buildLoadablePatternComingleDetails(
      LoadablePlanCommingleDetails loadablePlanCommingleDetails,
      com.cpdss.common.generated.LoadableStudy.LoadablePatternCommingleDetailsReply.Builder
          builder) {
    ofNullable(loadablePlanCommingleDetails.getApi())
        .ifPresent(api -> builder.setApi(String.valueOf(api)));
    ofNullable(loadablePlanCommingleDetails.getCargo1Abbreviation())
        .ifPresent(cargo1Abbrivation -> builder.setCargo1Abbrivation(cargo1Abbrivation));

    ofNullable(loadablePlanCommingleDetails.getCargo2Abbreviation())
        .ifPresent(cargo2Abbrivation -> builder.setCargo2Abbrivation(cargo2Abbrivation));

    ofNullable(loadablePlanCommingleDetails.getCargo1Percentage())
        .ifPresent(
            cargo1Percentage -> builder.setCargo1Percentage(String.valueOf(cargo1Percentage)));

    ofNullable(loadablePlanCommingleDetails.getCargo2Percentage())
        .ifPresent(
            cargo2Percentage -> builder.setCargo2Percentage(String.valueOf(cargo2Percentage)));

    ofNullable(loadablePlanCommingleDetails.getCargo1Mt())
        .ifPresent(cargo1Quantity -> builder.setCargo1Quantity(String.valueOf(cargo1Quantity)));

    ofNullable(loadablePlanCommingleDetails.getCargo2Mt())
        .ifPresent(cargo2Quantity -> builder.setCargo2Quantity(String.valueOf(cargo2Quantity)));

    ofNullable(loadablePlanCommingleDetails.getGrade()).ifPresent(grade -> builder.setGrade(grade));

    ofNullable(loadablePlanCommingleDetails.getQuantity())
        .ifPresent(quantity -> builder.setQuantity(String.valueOf(quantity)));

    ofNullable(loadablePlanCommingleDetails.getTankName())
        .ifPresent(tankShortName -> builder.setTankShortName(tankShortName));

    ofNullable(loadablePlanCommingleDetails.getTemperature())
        .ifPresent(temperature -> builder.setTemperature(String.valueOf(temperature)));

    ofNullable(loadablePlanCommingleDetails.getId()).ifPresent(id -> builder.setId(id));
  }

  public com.cpdss.common.generated.LoadableStudy.ConfirmPlanReply.Builder confirmPlanStatus(
      com.cpdss.common.generated.LoadableStudy.ConfirmPlanRequest request,
      com.cpdss.common.generated.LoadableStudy.ConfirmPlanReply.Builder replyBuilder) {
    Optional<LoadablePattern> loadablePatternOpt =
        this.loadablePatternRepository.findByIdAndIsActive(request.getLoadablePatternId(), true);
    if (!loadablePatternOpt.isPresent()) {
      log.info(INVALID_LOADABLE_PATTERN_ID, request.getLoadablePatternId());
      replyBuilder.setResponseStatus(
          Common.ResponseStatus.newBuilder()
              .setStatus(FAILED)
              .setMessage(INVALID_LOADABLE_PATTERN_ID)
              .setCode(CommonErrorCodes.E_HTTP_BAD_REQUEST));
    } else {
      List<LoadablePatternAlgoStatus> patternStatus =
          loadablePatternAlgoStatusRepository.findByLoadablePatternAndIsActive(
              loadablePatternOpt.get(), true);
      if (!patternStatus.isEmpty()) {
        replyBuilder.setLoadablePatternStatusId(
            patternStatus.get(patternStatus.size() - 1).getLoadableStudyStatus().getId());
      }

      if (!patternStatus.isEmpty()) {
        if (stowageDetailsTempRepository
                .findByLoadablePatternAndIsActive(loadablePatternOpt.get(), true)
                .isEmpty()
            || VALIDATED_CONDITIONS.contains(replyBuilder.getLoadablePatternStatusId())) {
          replyBuilder.setValidated(true);
        }
      } else {
        if (stowageDetailsTempRepository
            .findByLoadablePatternAndIsActive(loadablePatternOpt.get(), true)
            .isEmpty()) {
          replyBuilder.setValidated(true);
        }
      }
      List<LoadablePattern> loadablePatternConfirmedOpt =
          loadablePatternRepository.findByVoyageAndLoadableStudyStatusAndIsActive(
              request.getVoyageId(), CONFIRMED_STATUS_ID, true);
      if (!loadablePatternConfirmedOpt.isEmpty()) {
        // set confirm status to false since some other plan is already confirmed
        log.info("other plan is in confirmed status or verification pending");
        replyBuilder.setConfirmed(false);
      } else {
        log.info("plan is okay to confirm");

        replyBuilder.setConfirmed(true);
      }
      replyBuilder.setResponseStatus(Common.ResponseStatus.newBuilder().setStatus(SUCCESS).build());
    }
    return replyBuilder;
  }

  public com.cpdss.common.generated.LoadableStudy.ConfirmPlanReply.Builder confirmPlan(
      com.cpdss.common.generated.LoadableStudy.ConfirmPlanRequest request,
      com.cpdss.common.generated.LoadableStudy.ConfirmPlanReply.Builder replyBuilder) {
    Optional<LoadablePattern> loadablePatternOpt =
        this.loadablePatternRepository.findByIdAndIsActive(request.getLoadablePatternId(), true);
    if (!loadablePatternOpt.isPresent()) {
      log.info(INVALID_LOADABLE_PATTERN_ID, request.getLoadablePatternId());
      replyBuilder.setResponseStatus(
          Common.ResponseStatus.newBuilder()
              .setStatus(FAILED)
              .setMessage(INVALID_LOADABLE_PATTERN_ID)
              .setCode(CommonErrorCodes.E_HTTP_BAD_REQUEST));
    } else {
      List<LoadablePattern> loadablePatternConfirmedOpt =
          loadablePatternRepository.findByVoyageAndLoadableStudyStatusAndIsActiveAndPlanningType(
              loadablePatternOpt.get().getLoadableStudy().getVoyage().getId(),
              CONFIRMED_STATUS_ID,
              true,
              loadablePatternOpt.get().getLoadableStudy().getPlanningTypeXId());
      if (!loadablePatternConfirmedOpt.isEmpty()) {
        log.info("changing status of other confirmed plan to plan generated");
        loadablePatternRepository.updateLoadablePatternStatusToPlanGenerated(
            LOADABLE_STUDY_STATUS_PLAN_GENERATED_ID, loadablePatternConfirmedOpt.get(0).getId());
        loadablePatternRepository.updateLoadableStudyStatusToPlanGenerated(
            LOADABLE_STUDY_STATUS_PLAN_GENERATED_ID,
            loadablePatternConfirmedOpt.get(0).getLoadableStudy().getId());
      }
      log.info("confirming selected plan");
      loadablePatternRepository.updateLoadablePatternStatus(
          CONFIRMED_STATUS_ID, loadablePatternOpt.get().getId());
      loadableStudyRepository.updateLoadableStudyStatus(
          CONFIRMED_STATUS_ID, loadablePatternOpt.get().getLoadableStudy().getId());
      replyBuilder.setResponseStatus(Common.ResponseStatus.newBuilder().setStatus(SUCCESS).build());
    }
    return replyBuilder;
  }

  public void saveLoadablePatternDetails(
      String patternResultJson, AlgoResponseCommunication.Builder load) {
    try {
      JsonFormat.parser().ignoringUnknownFields().merge(patternResultJson, load);
      AlgoResponseCommunication responseCommunication = load.build();
      com.cpdss.common.generated.LoadableStudy.LoadablePatternAlgoRequest patternResult =
          responseCommunication.getLoadablePatternAlgoRequest();
      Optional<LoadableStudyCommunicationStatus> loadableStudyCommunicationStatus =
          this.loadableStudyCommunicationStatusRepository.findByMessageUUID(
              responseCommunication.getMessageId());
      Optional<LoadableStudy> loadableStudyOpt =
          (this.loadableStudyRepository.findById(
              loadableStudyCommunicationStatus.get().getReferenceId()));

      if (!loadableStudyOpt.isPresent()) {
        throw new GenericServiceException(
            "Loadable study does not exist",
            CommonErrorCodes.E_HTTP_BAD_REQUEST,
            HttpStatusCode.BAD_REQUEST);
      }
      loadableStudyAlgoStatusRepository.updateLoadableStudyAlgoStatusByMessageId(
          LOADABLE_STUDY_STATUS_PLAN_GENERATED_ID, responseCommunication.getMessageId(), true);
      if (patternResult.getLoadablePlanDetailsList().isEmpty()) {
        log.info("saveLoadablePatternDetails - loadable study micro service - no plans available");
        loadableStudyAlgoStatusRepository.updateLoadableStudyAlgoStatusByMessageId(
            LOADABLE_STUDY_NO_PLAN_AVAILABLE_ID, responseCommunication.getMessageId(), true);
        loadableStudyRepository.updateLoadableStudyStatus(
            LOADABLE_STUDY_NO_PLAN_AVAILABLE_ID, loadableStudyOpt.get().getId());
      } else {
        // Save pattern ship after communication
        savePatternDetails(patternResult, loadableStudyOpt, LOADABLE_STUDY, true);
        loadableStudyRepository.updateLoadableStudyStatus(
            LOADABLE_STUDY_STATUS_PLAN_GENERATED_ID, loadableStudyOpt.get().getId());
        if (responseCommunication.getLoadicatorResultsRequest() != null) {
          loadicatorService.saveLoadicatorResults(
              responseCommunication.getLoadicatorResultsRequest());
        }
      }
      if (patternResult.getAlgoErrorsCount() > 0) {
        algoErrorsRepository.deleteAlgoErrorByLSId(false, loadableStudyOpt.get().getId());
        algoErrorHeadingRepository.deleteAlgoErrorHeadingByLSId(
            false, patternResult.getLoadableStudyId());
        algoService.saveAlgoErrorToDB(
            patternResult, new LoadablePattern(), loadableStudyOpt.get(), false);
        loadableStudyRepository.updateLoadableStudyStatus(
            LOADABLE_STUDY_STATUS_ERROR_OCCURRED_ID, loadableStudyOpt.get().getId());
        loadableStudyAlgoStatusRepository.updateLoadableStudyAlgoStatusByMessageId(
            LOADABLE_STUDY_STATUS_ERROR_OCCURRED_ID, responseCommunication.getMessageId(), true);
      }

      // Update communication status table with final state
      loadableStudyCommunicationStatusRepository.updateLoadableStudyCommunicationStatus(
          CommunicationStatus.COMPLETED.getId(), loadableStudyOpt.get().getId());
    } catch (InvalidProtocolBufferException | GenericServiceException e) {
      e.printStackTrace();
    }
  }
}
