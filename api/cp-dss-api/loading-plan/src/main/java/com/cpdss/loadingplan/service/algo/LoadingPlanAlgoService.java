/* Licensed at AlphaOri Technologies */
package com.cpdss.loadingplan.service.algo;

import com.cpdss.common.constants.AlgoErrorHeaderConstants;
import com.cpdss.common.exception.GenericServiceException;
import com.cpdss.common.generated.EnvoyWriter;
import com.cpdss.common.generated.LoadableStudy;
import com.cpdss.common.generated.LoadableStudy.AlgoErrorRequest;
import com.cpdss.common.generated.LoadableStudy.AlgoStatusRequest;
import com.cpdss.common.generated.LoadableStudy.JsonRequest;
import com.cpdss.common.generated.LoadableStudyServiceGrpc.LoadableStudyServiceBlockingStub;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels.DeBallastingRate;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels.EductorOperation;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoAlgoReply.Builder;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoAlgoRequest;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoStatusRequest;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanCommingleDetails;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanPortWiseDetails;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanSaveRequest;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanSaveResponse;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParameters;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingRate;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingSequence;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperation;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels.Valve;
import com.cpdss.common.rest.CommonErrorCodes;
import com.cpdss.common.utils.HttpStatusCode;
import com.cpdss.common.utils.MessageTypes;
import com.cpdss.loadingplan.common.LoadingPlanConstants;
import com.cpdss.loadingplan.communication.LoadingPlanStagingService;
import com.cpdss.loadingplan.domain.CommunicationStatus;
import com.cpdss.loadingplan.domain.algo.LoadingInformationAlgoRequest;
import com.cpdss.loadingplan.domain.algo.LoadingInformationAlgoResponse;
import com.cpdss.loadingplan.entity.*;
import com.cpdss.loadingplan.entity.AlgoErrorHeading;
import com.cpdss.loadingplan.entity.AlgoErrors;
import com.cpdss.loadingplan.entity.BallastOperation;
import com.cpdss.loadingplan.entity.BallastValve;
import com.cpdss.loadingplan.entity.CargoLoadingRate;
import com.cpdss.loadingplan.entity.CargoValve;
import com.cpdss.loadingplan.entity.DeballastingRate;
import com.cpdss.loadingplan.entity.EductionOperation;
import com.cpdss.loadingplan.entity.LoadingInformation;
import com.cpdss.loadingplan.entity.LoadingInformationAlgoStatus;
import com.cpdss.loadingplan.entity.LoadingInformationStatus;
import com.cpdss.loadingplan.entity.LoadingPlanBallastDetails;
import com.cpdss.loadingplan.entity.LoadingPlanRobDetails;
import com.cpdss.loadingplan.entity.LoadingSequenceStabilityParameters;
import com.cpdss.loadingplan.entity.PortLoadingPlanBallastDetails;
import com.cpdss.loadingplan.entity.PortLoadingPlanCommingleDetails;
import com.cpdss.loadingplan.entity.PortLoadingPlanRobDetails;
import com.cpdss.loadingplan.entity.PortLoadingPlanStabilityParameters;
import com.cpdss.loadingplan.entity.PortLoadingPlanStowageDetails;
import com.cpdss.loadingplan.repository.*;
import com.cpdss.loadingplan.repository.AlgoErrorHeadingRepository;
import com.cpdss.loadingplan.repository.AlgoErrorsRepository;
import com.cpdss.loadingplan.repository.BallastOperationRepository;
import com.cpdss.loadingplan.repository.BallastValveRepository;
import com.cpdss.loadingplan.repository.CargoLoadingRateRepository;
import com.cpdss.loadingplan.repository.CargoValveRepository;
import com.cpdss.loadingplan.repository.DeballastingRateRepository;
import com.cpdss.loadingplan.repository.EductionOperationRepository;
import com.cpdss.loadingplan.repository.LoadingInformationAlgoStatusRepository;
import com.cpdss.loadingplan.repository.LoadingInformationRepository;
import com.cpdss.loadingplan.repository.LoadingInformationStatusRepository;
import com.cpdss.loadingplan.repository.LoadingPlanBallastDetailsRepository;
import com.cpdss.loadingplan.repository.LoadingPlanCommingleDetailsRepository;
import com.cpdss.loadingplan.repository.LoadingPlanPortWiseDetailsRepository;
import com.cpdss.loadingplan.repository.LoadingPlanRobDetailsRepository;
import com.cpdss.loadingplan.repository.LoadingPlanStabilityParametersRepository;
import com.cpdss.loadingplan.repository.LoadingPlanStowageDetailsRepository;
import com.cpdss.loadingplan.repository.LoadingSequenceRepository;
import com.cpdss.loadingplan.repository.LoadingSequenceStabiltyParametersRepository;
import com.cpdss.loadingplan.repository.PortLoadingPlanBallastDetailsRepository;
import com.cpdss.loadingplan.repository.PortLoadingPlanBallastTempDetailsRepository;
import com.cpdss.loadingplan.repository.PortLoadingPlanCommingleDetailsRepository;
import com.cpdss.loadingplan.repository.PortLoadingPlanCommingleTempDetailsRepository;
import com.cpdss.loadingplan.repository.PortLoadingPlanRobDetailsRepository;
import com.cpdss.loadingplan.repository.PortLoadingPlanStabilityParametersRepository;
import com.cpdss.loadingplan.repository.PortLoadingPlanStowageDetailsRepository;
import com.cpdss.loadingplan.repository.PortLoadingPlanStowageTempDetailsRepository;
import com.cpdss.loadingplan.service.LoadingPlanCommunicationService;
import com.cpdss.loadingplan.service.loadicator.LoadicatorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@Transactional
public class LoadingPlanAlgoService {

  @Value(value = "${algo.planGenerationUrl}")
  private String planGenerationUrl;

  @Value(value = "${loadingplan.attachment.rootFolder}")
  private String rootFolder;

  @Value("${cpdss.communication.enable}")
  private boolean enableCommunication;

  @Value("${cpdss.build.env}")
  private String env;

  @Autowired RestTemplate restTemplate;

  @Autowired LoadingInformationRepository loadingInformationRepository;
  @Autowired LoadingInformationStatusRepository loadingInfoStatusRepository;
  @Autowired LoadingInformationAlgoStatusRepository loadingInfoAlgoStatusRepository;

  @Autowired LoadingSequenceRepository loadingSequenceRepository;
  @Autowired BallastValveRepository ballastValveRepository;
  @Autowired CargoValveRepository cargoValveRepository;
  @Autowired DeballastingRateRepository deballastingRateRepository;
  @Autowired LoadingPlanPortWiseDetailsRepository loadingPlanPortWiseDetailsRepository;
  @Autowired LoadingPlanBallastDetailsRepository loadingPlanBallastDetailsRepository;
  @Autowired LoadingPlanRobDetailsRepository loadingPlanRobDetailsRepository;
  @Autowired LoadingPlanStowageDetailsRepository loadingPlanStowageDetailsRepository;
  @Autowired LoadingPlanStabilityParametersRepository loadingPlanStabilityParametersRepository;
  @Autowired CargoLoadingRateRepository cargoLoadingRateRepository;
  @Autowired PortLoadingPlanBallastDetailsRepository portBallastDetailsRepository;
  @Autowired PortLoadingPlanRobDetailsRepository portRobDetailsRepository;
  @Autowired PortLoadingPlanStabilityParametersRepository portStabilityParamsRepository;
  @Autowired PortLoadingPlanStowageDetailsRepository portStowageDetailsRepository;
  @Autowired BallastOperationRepository ballastOperationRepository;
  @Autowired LoadingSequenceStabiltyParametersRepository loadingSequenceStabilityParamsRepository;
  @Autowired AlgoErrorHeadingRepository algoErrorHeadingRepository;
  @Autowired AlgoErrorsRepository algoErrorsRepository;

  @Autowired
  PortLoadingPlanStowageTempDetailsRepository portLoadingPlanStowageTempDetailsRepository;

  @Autowired
  PortLoadingPlanBallastTempDetailsRepository portLoadingPlanBallastTempDetailsRepository;

  @Autowired LoadingPlanCommingleDetailsRepository loadingPlanCommingleDetailsRepository;
  @Autowired PortLoadingPlanCommingleDetailsRepository portLoadingPlanCommingleDetailsRepository;

  @Autowired
  PortLoadingPlanCommingleTempDetailsRepository portLoadingPlanCommingleTempDetailsRepository;

  @Autowired EductionOperationRepository eductionOperationRepository;

  @Autowired LoadingInformationAlgoRequestBuilderService loadingInfoAlgoRequestBuilderService;
  @Autowired LoadingPlanBuilderService loadingPlanBuilderService;
  @Autowired LoadicatorService loadicatorService;
  @Autowired LoadingPlanCommunicationService loadingPlancommunicationService;
  @Autowired LoadingPlanStagingService loadingPlanStagingService;
  @Autowired LoadingPlanCommunicationStatusRepository loadingPlanCommunicationStatusRepository;
  @Autowired private LoadingPlanCommunicationService communicationService;

  @GrpcClient("loadableStudyService")
  private LoadableStudyServiceBlockingStub loadableStudyService;

  /**
   * CALL TO ALGO - for LOADING PLAN Generates Loading plan from Algo
   *
   * @param request Loading Information Id Only
   * @param builder
   * @throws GenericServiceException
   */
  public void generateLoadingPlan(LoadingInfoAlgoRequest request, Builder builder)
      throws GenericServiceException {
    log.info("Generating Loading Plan");

    Optional<LoadingInformation> loadingInfoOpt =
        loadingInformationRepository.findByIdAndIsActiveTrue(request.getLoadingInfoId());

    if (loadingInfoOpt.isEmpty()) {
      throw new GenericServiceException(
          "Could not find loading information " + request.getLoadingInfoId(),
          CommonErrorCodes.E_HTTP_BAD_REQUEST,
          HttpStatusCode.BAD_REQUEST);
    }
    String processId = null;
    if (enableCommunication && env.equals("ship")) {
      processId = communicateLoadingPlan(loadingInfoOpt.get().getId(), true);
    } else {
      processId = processAlgoLoading(loadingInfoOpt.get());
      Optional<LoadingInformationStatus> loadingInfoStatusOpt =
          getLoadingInformationStatus(
              LoadingPlanConstants.LOADING_INFORMATION_PROCESSING_STARTED_ID);
      // Set Loading Status
      loadingInformationRepository.updateLoadingInfoWithInfoStatus(
          loadingInfoStatusOpt.get(), false, false, loadingInfoOpt.get().getId());
      createLoadingInformationAlgoStatus(
          loadingInfoOpt.get(), processId, loadingInfoStatusOpt.get(), null);
    }
    builder.setLoadingInfoId(loadingInfoOpt.get().getId());
    builder.setProcessId(processId);
  }

  /**
   * Method to process Algo for loadingInfo
   *
   * @param loadingInformation loadingInfo entity
   * @return Algo processId
   * @throws GenericServiceException Exception on failure
   */
  public String processAlgoLoading(final LoadingInformation loadingInformation)
      throws GenericServiceException {
    String processId = null;

    final LoadingPlanModels.LoadingInfoAlgoRequest request =
        LoadingPlanModels.LoadingInfoAlgoRequest.newBuilder()
            .setLoadingInfoId(loadingInformation.getId())
            .build();

    // Create Algo request object
    LoadingInformationAlgoRequest algoRequest =
        loadingInfoAlgoRequestBuilderService.createAlgoRequest(request);

    // Save Algo request to json_data table
    saveLoadingInformationRequestJson(algoRequest, request.getLoadingInfoId());

    // Call Algo for loading
    try {
      log.debug("Loading Info Id: {}, Algo Request: {}", loadingInformation.getId(), algoRequest);
      final LoadingInformationAlgoResponse algoResponse =
          restTemplate.postForObject(
              planGenerationUrl, algoRequest, LoadingInformationAlgoResponse.class);
      if (null != algoResponse) {
        processId = algoResponse.getProcessId();
      }
      log.info("Loading Info Id: {}, Algo Response: {}", loadingInformation.getId(), algoResponse);
    } catch (HttpStatusCodeException e) {
      log.error(
          "Error occurred in calling Algo API for Loading Plan. Loading Info Id: {}, Algo Request: {}",
          loadingInformation.getId(),
          algoRequest,
          e);

      // Save error
      saveAlgoInternalError(
          loadingInformation, null, Lists.newArrayList(e.getResponseBodyAsString()));
      LoadingInformationStatus errorOccurredStatusOpt =
          getLoadingInformationStatus(LoadingPlanConstants.LOADING_INFORMATION_ERROR_OCCURRED_ID)
              .orElseThrow(
                  () -> {
                    log.error(
                        "LoadingInformationStatus Id: {} not found in master loading_information_status",
                        LoadingPlanConstants.LOADING_INFORMATION_ERROR_OCCURRED_ID);
                    return new GenericServiceException(
                        "Master data missing. LoadingInformationStatus Id: "
                            + LoadingPlanConstants.LOADING_INFORMATION_ERROR_OCCURRED_ID,
                        CommonErrorCodes.E_GEN_INTERNAL_ERR,
                        HttpStatusCode.INTERNAL_SERVER_ERROR);
                  });

      loadingInformationRepository.updateLoadingInformationStatus(
          errorOccurredStatusOpt, loadingInformation.getId());
      throw new GenericServiceException(
          "Error calling Algo" + request.getLoadingInfoId(),
          CommonErrorCodes.E_GEN_INTERNAL_ERR,
          HttpStatusCode.valueOf(e.getRawStatusCode()));
    }
    return processId;
  }

  /**
   * Fetches Loading Information Status based on status ID.
   *
   * @param
   * @return
   * @throws GenericServiceException
   */
  public Optional<LoadingInformationStatus> getLoadingInformationStatus(
      Long loadingInformationStatusId) throws GenericServiceException {
    Optional<LoadingInformationStatus> loadingInfoStatusOpt =
        loadingInfoStatusRepository.findByIdAndIsActive(loadingInformationStatusId, true);
    if (loadingInfoStatusOpt.isEmpty()) {
      throw new GenericServiceException(
          "Could not find loading information status with id " + loadingInformationStatusId,
          CommonErrorCodes.E_HTTP_BAD_REQUEST,
          HttpStatusCode.BAD_REQUEST);
    }

    return loadingInfoStatusOpt;
  }

  /**
   * Saves the ALGO status.
   *
   * @param request void
   */
  public void saveAlgoLoadingPlanStatus(AlgoStatusRequest request) throws GenericServiceException {
    Optional<LoadingInformationAlgoStatus> loadingInfoStatusOpt =
        loadingInfoAlgoStatusRepository.findByProcessIdAndIsActiveTrue(request.getProcesssId());
    if (loadingInfoStatusOpt.isEmpty()) {
      throw new GenericServiceException(
          "Could not find loading information " + request.getProcesssId(),
          CommonErrorCodes.E_HTTP_BAD_REQUEST,
          HttpStatusCode.BAD_REQUEST);
    }

    loadingInfoAlgoStatusRepository.updateLoadingInformationAlgoStatus(
        request.getLoadableStudystatusId(), request.getProcesssId());
  }

  /**
   * Updates ALGO status of Loading Information
   *
   * @param loadingInformation
   * @param processId
   * @param status
   */
  public void createLoadingInformationAlgoStatus(
      LoadingInformation loadingInformation,
      String processId,
      LoadingInformationStatus status,
      Integer conditionType) {
    log.info(
        "Creating ALGO status for Loading Information {}, condition Type {}",
        loadingInformation.getId(),
        conditionType);
    LoadingInformationAlgoStatus algoStatus = new LoadingInformationAlgoStatus();
    algoStatus.setIsActive(true);
    algoStatus.setLoadingInformation(loadingInformation);
    algoStatus.setLoadingInformationStatus(status);
    algoStatus.setConditionType(conditionType);
    algoStatus.setProcessId(processId);
    algoStatus.setVesselXId(loadingInformation.getVesselXId());
    loadingInfoAlgoStatusRepository.save(algoStatus);
  }

  /**
   * Saves the Loading Information ALGO Request JSON to DB.
   *
   * @param algoRequest
   * @param loadingInfoId
   * @throws GenericServiceException
   */
  private void saveLoadingInformationRequestJson(
      LoadingInformationAlgoRequest algoRequest, Long loadingInfoId)
      throws GenericServiceException {
    log.info("Saving Loading Information ALGO request to Loadable study DB");
    JsonRequest.Builder jsonBuilder = JsonRequest.newBuilder();
    jsonBuilder.setReferenceId(loadingInfoId);
    jsonBuilder.setJsonTypeId(LoadingPlanConstants.LOADING_INFORMATION_REQUEST_JSON_TYPE_ID);
    ObjectMapper mapper = new ObjectMapper();
    try {
      mapper.writeValue(
          new File(this.rootFolder + "/json/loadingInformationRequest_" + loadingInfoId + ".json"),
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

  /**
   * Saves Loading sequence and Plan
   *
   * @param builder
   * @param request
   * @throws GenericServiceException
   */
  public void saveLoadingSequenceAndPlan(
      LoadingPlanSaveResponse.Builder builder, LoadingPlanSaveRequest request)
      throws GenericServiceException {
    log.info(
        "Saving Loading plan and sequence of loading information {}", request.getLoadingInfoId());

    Optional<LoadingInformation> loadingInfoOpt =
        loadingInformationRepository.findById(request.getLoadingInfoId());
    if (loadingInfoOpt.isEmpty()) {
      throw new GenericServiceException(
          "Could not find loading information " + request.getLoadingInfoId(),
          CommonErrorCodes.E_HTTP_BAD_REQUEST,
          HttpStatusCode.BAD_REQUEST);
    }
    // Returning port rotationid for excel generation in gateway
    builder.setPortRotationId(loadingInfoOpt.get().getPortRotationXId());

    loadingInformationRepository.updateLoadingPlanDetailsFromAlgo(
        loadingInfoOpt.get().getId(), request.getLoadingPlanDetailsFromAlgo());

    if (request.getLoadingSequencesList().isEmpty()) {
      log.info("No Plans Available for Loading Information {}", loadingInfoOpt.get().getId());
      Optional<LoadingInformationStatus> noPlanAvailableStatusOpt =
          getLoadingInformationStatus(
              LoadingPlanConstants.LOADING_INFORMATION_NO_PLAN_AVAILABLE_ID);
      loadingInformationRepository.updateLoadingInformationStatus(
          noPlanAvailableStatusOpt.get(), loadingInfoOpt.get().getId());
      updateLoadingInfoAlgoStatus(
          loadingInfoOpt.get(), request.getProcessId(), noPlanAvailableStatusOpt.get());
    }

    if (!request.getAlgoErrorsList().isEmpty()) {
      saveAlgoErrors(loadingInfoOpt.get(), request);
      log.info("Communication side started with Algo Errors");
      if (enableCommunication && !env.equals("ship")) {
        loadingPlanCommunication(
            com.cpdss.loadingplan.utility.LoadingPlanConstants
                .LOADING_PLAN_ALGO_ERRORS_SHORE_TO_SHIP,
            loadingInfoOpt.get());
      }
    }

    if (!request.getLoadingSequencesList().isEmpty()) {
      List<com.cpdss.loadingplan.entity.LoadingSequence> oldLoadingSequences =
          loadingSequenceRepository.findByLoadingInformationAndIsActive(loadingInfoOpt.get(), true);
      // Saving Loading Sequence
      request.getLoadingSequencesList().stream()
          .forEach(
              sequence -> {
                saveLoadingSequence(sequence, loadingInfoOpt.get());
              });
      deleteLoadingSequences(loadingInfoOpt.get().getId(), oldLoadingSequences);
      deleteLoadingSequenceStabilityParams(loadingInfoOpt.get().getId());
      saveLoadingSequenceStabilityParams(request, loadingInfoOpt.get());

      deleteLoadingPlan(loadingInfoOpt.get().getId());
      saveLoadingPlan(request, loadingInfoOpt.get());
      if (request.getHasLoadicator()) {
        log.info("Passing Loading Sequence to Loadicator");
        loadicatorService.saveLoadicatorInfo(loadingInfoOpt.get(), request.getProcessId());
        Optional<LoadingInformationStatus> loadicatorVerificationStatusOpt =
            getLoadingInformationStatus(
                LoadingPlanConstants.LOADING_INFORMATION_VERIFICATION_WITH_LOADICATOR_ID);
        updateLoadingInfoAlgoStatus(
            loadingInfoOpt.get(), request.getProcessId(), loadicatorVerificationStatusOpt.get());
      } else {
        Optional<LoadingInformationStatus> loadingInfoStatusOpt =
            getLoadingInformationStatus(LoadingPlanConstants.LOADING_INFORMATION_PLAN_GENERATED_ID);
        loadingInformationRepository.updateLoadingInformationStatuses(
            loadingInfoStatusOpt.get(),
            loadingInfoStatusOpt.get(),
            loadingInfoStatusOpt.get(),
            loadingInfoOpt.get().getId());
        updateLoadingInfoAlgoStatus(
            loadingInfoOpt.get(), request.getProcessId(), loadingInfoStatusOpt.get());
        loadingInformationRepository.updateIsLoadingSequenceGeneratedStatus(
            loadingInfoOpt.get().getId(), true);
        loadingInformationRepository.updateIsLoadingPlanGeneratedStatus(
            loadingInfoOpt.get().getId(), true);
        loadingPlanCommunicationStatusRepository.updateCommunicationStatus(
            CommunicationStatus.COMPLETED.getId(), false, loadingInfoOpt.get().getId());
      }
      log.info("Communication side started");
      if (enableCommunication && !env.equals("ship") && !request.getHasLoadicator()) {
        loadingPlanCommunication(
            com.cpdss.loadingplan.utility.LoadingPlanConstants.LOADING_PLAN_SHORE_TO_SHIP,
            loadingInfoOpt.get());
      }
    }
  }

  private void loadingPlanCommunication(
      List<String> loadingPlanCommunicationList, LoadingInformation loadingInformation)
      throws GenericServiceException {
    JsonArray jsonArray =
        loadingPlanStagingService.getCommunicationData(
            loadingPlanCommunicationList,
            UUID.randomUUID().toString(),
            MessageTypes.LOADINGPLAN_ALGORESULT.getMessageType(),
            loadingInformation.getId(),
            StringUtils.hasLength(loadingInformation.getLoadableStudyProcessId())
                ? loadingInformation.getLoadableStudyProcessId()
                : null);
    log.info("Json Array in After Algo call: " + jsonArray.toString());
    EnvoyWriter.WriterReply ewReply =
        loadingPlancommunicationService.passRequestPayloadToEnvoyWriter(
            jsonArray.toString(),
            loadingInformation.getVesselXId(),
            MessageTypes.LOADINGPLAN_ALGORESULT.getMessageType());
    log.info("------- Envoy writer has called successfully in shore: " + ewReply.toString());
    LoadingPlanCommunicationStatus loadingPlanCommunicationStatus =
        new LoadingPlanCommunicationStatus();
    if (ewReply.getMessageId() != null) {
      loadingPlanCommunicationStatus.setMessageUUID(ewReply.getMessageId());
      loadingPlanCommunicationStatus.setCommunicationStatus(
          CommunicationStatus.RECEIVED_WITH_HASH_VERIFIED.getId());
    }
    loadingPlanCommunicationStatus.setReferenceId(loadingInformation.getId());
    loadingPlanCommunicationStatus.setMessageType(
        MessageTypes.LOADINGPLAN_ALGORESULT.getMessageType());
    loadingPlanCommunicationStatus.setCommunicationDateTime(LocalDateTime.now());
    loadingPlanCommunicationStatus.setActive(true);
    LoadingPlanCommunicationStatus loadableStudyCommunicationStatus =
        this.loadingPlanCommunicationStatusRepository.save(loadingPlanCommunicationStatus);
    log.info("Communication table update : " + loadingPlanCommunicationStatus.getId());
  }

  private void saveAlgoErrors(LoadingInformation loadingInformation, LoadingPlanSaveRequest request)
      throws GenericServiceException {
    log.info(
        "ALGO returned errors while generating loading plan for loading information {}",
        loadingInformation.getId());

    algoErrorHeadingRepository.deleteByLoadingInformation(loadingInformation);
    algoErrorsRepository.deleteByLoadingInformation(loadingInformation);

    request
        .getAlgoErrorsList()
        .forEach(
            algoError -> {
              AlgoErrorHeading algoErrorHeading = new AlgoErrorHeading();
              algoErrorHeading.setErrorHeading(algoError.getErrorHeading());
              algoErrorHeading.setLoadingInformation(loadingInformation);
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
    Optional<LoadingInformationStatus> errorOccurredStatusOpt =
        getLoadingInformationStatus(LoadingPlanConstants.LOADING_INFORMATION_ERROR_OCCURRED_ID);
    loadingInformationRepository.updateLoadingInformationStatus(
        errorOccurredStatusOpt.get(), loadingInformation.getId());
    updateLoadingInfoAlgoStatus(
        loadingInformation, request.getProcessId(), errorOccurredStatusOpt.get());
  }

  public void updateLoadingInfoAlgoStatus(
      LoadingInformation loadingInformation,
      String processId,
      LoadingInformationStatus loadingInformationStatus)
      throws GenericServiceException {

    this.loadingInfoAlgoStatusRepository.updateLoadingInformationAlgoStatus(
        loadingInformationStatus.getId(), loadingInformation.getId(), processId);
  }

  private void deleteLoadingSequenceStabilityParams(Long loadingInfoId) {
    log.info(
        "Deleting Old Loading Sequence Stability Parameters of Loading Information {}",
        loadingInfoId);
    loadingSequenceStabilityParamsRepository.deleteByLoadingInformationId(loadingInfoId);
  }

  private void saveLoadingSequenceStabilityParams(
      LoadingPlanSaveRequest request, LoadingInformation loadingInformation) {
    log.info(
        "Saving Loading Sequence Stability Params for LoadingInformation {}, PortRotation {}",
        loadingInformation.getId(),
        loadingInformation.getPortRotationXId());
    List<LoadingSequenceStabilityParameters> loadingSequenceStabilityParams =
        new ArrayList<LoadingSequenceStabilityParameters>();
    request
        .getLoadingSequenceStabilityParametersList()
        .forEach(
            param -> {
              LoadingSequenceStabilityParameters stabilityParameters =
                  new LoadingSequenceStabilityParameters();
              loadingPlanBuilderService.buildLoadingSequenceStabilityParams(
                  loadingInformation, param, stabilityParameters);
              loadingSequenceStabilityParams.add(stabilityParameters);
            });
    loadingSequenceStabilityParamsRepository.saveAll(loadingSequenceStabilityParams);
  }

  private void deleteLoadingPlan(Long loadingInfoId) {
    log.info("Deleting Old Loading Plan of LoadingInformation {}", loadingInfoId);
    portBallastDetailsRepository.deleteByLoadingInformationId(loadingInfoId);
    portRobDetailsRepository.deleteByLoadingInformationId(loadingInfoId);
    portStabilityParamsRepository.deleteByLoadingInformationId(loadingInfoId);
    portStowageDetailsRepository.deleteByLoadingInformationId(loadingInfoId);
    portLoadingPlanStowageTempDetailsRepository.deleteByLoadingInformationId(loadingInfoId);
    portLoadingPlanBallastTempDetailsRepository.deleteByLoadingInformationId(loadingInfoId);
    portLoadingPlanCommingleDetailsRepository.deleteByLoadingInformationId(loadingInfoId);
    portLoadingPlanCommingleTempDetailsRepository.deleteByLoadingInformationId(loadingInfoId);
  }

  private void deleteLoadingSequences(
      Long loadingInfoId, List<com.cpdss.loadingplan.entity.LoadingSequence> oldLoadingSequences) {
    log.info("Deleting Old Loading Sequences of LoadingInformation {}", loadingInfoId);
    oldLoadingSequences.forEach(
        loadingSequence -> {
          loadingSequenceRepository.deleteById(loadingSequence.getId());
          ballastOperationRepository.deleteByLoadingSequence(loadingSequence);
          cargoLoadingRateRepository.deleteByLoadingSequence(loadingSequence);
          deballastingRateRepository.deleteByLoadingSequence(loadingSequence);
          deleteLoadingPlanPortWiseDetailsByLoadingSequence(loadingSequence);
          eductionOperationRepository.deleteByLoadingSequence(loadingSequence);
        });
  }

  private void deleteLoadingPlanPortWiseDetailsByLoadingSequence(
      com.cpdss.loadingplan.entity.LoadingSequence loadingSequence) {
    List<com.cpdss.loadingplan.entity.LoadingPlanPortWiseDetails> oldPortWiseDetails =
        loadingPlanPortWiseDetailsRepository.findByLoadingSequenceAndIsActiveTrueOrderById(
            loadingSequence);
    oldPortWiseDetails.forEach(
        loadingPlanPortWiseDetails -> {
          loadingPlanPortWiseDetailsRepository.deleteById(loadingPlanPortWiseDetails.getId());
          deballastingRateRepository.deleteByLoadingPlanPortWiseDetails(loadingPlanPortWiseDetails);
          loadingPlanBallastDetailsRepository.deleteByLoadingPlanPortWiseDetails(
              loadingPlanPortWiseDetails);
          loadingPlanRobDetailsRepository.deleteByLoadingPlanPortWiseDetails(
              loadingPlanPortWiseDetails);
          loadingPlanStabilityParametersRepository.deleteByLoadingPlanPortWiseDetails(
              loadingPlanPortWiseDetails);
          loadingPlanStowageDetailsRepository.deleteByLoadingPlanPortWiseDetails(
              loadingPlanPortWiseDetails);
          loadingPlanCommingleDetailsRepository.deleteByLoadingPlanPortWiseDetails(
              loadingPlanPortWiseDetails);
        });
  }

  private void saveLoadingPlan(
      LoadingPlanSaveRequest request, LoadingInformation loadingInformation)
      throws GenericServiceException {
    savePortBallastDetails(loadingInformation, request.getPortLoadingPlanBallastDetailsList());
    savePortRobDetails(loadingInformation, request.getPortLoadingPlanRobDetailsList());
    savePortStabilityParams(
        loadingInformation, request.getPortLoadingPlanStabilityParametersList());
    savePortStowageDetails(loadingInformation, request.getPortLoadingPlanStowageDetailsList());
    savePortCommingleDetails(loadingInformation, request.getPortLoadingPlanCommingleDetailsList());
  }

  /**
   * @param loadingInformation
   * @param portLoadingPlanCommingleDetailsList
   */
  private void savePortCommingleDetails(
      LoadingInformation loadingInformation,
      List<LoadingPlanCommingleDetails> portLoadingPlanCommingleDetailsList)
      throws GenericServiceException {
    log.info(
        "Saving Loading Plan Commingle Details for LoadingInformation {}, PortRotation {}",
        loadingInformation.getId(),
        loadingInformation.getPortRotationXId());
    List<PortLoadingPlanCommingleDetails> portLoadingPlanCommingleDetails =
        new ArrayList<PortLoadingPlanCommingleDetails>();
    Set<Long> cargoNominationIds = new LinkedHashSet<>();
    portLoadingPlanCommingleDetailsList.forEach(
        commingle -> {
          cargoNominationIds.add(commingle.getCargoNomination1Id());
          cargoNominationIds.add(commingle.getCargoNomination2Id());
        });
    Map<Long, LoadableStudy.CargoNominationDetail> cargoNomMap =
        getCargoNominationDetails(cargoNominationIds);
    portLoadingPlanCommingleDetailsList.forEach(
        commingle -> {
          PortLoadingPlanCommingleDetails commingleDetails = new PortLoadingPlanCommingleDetails();
          loadingPlanBuilderService.buildPortCommingle(
              loadingInformation, commingleDetails, cargoNomMap, commingle);
          portLoadingPlanCommingleDetails.add(commingleDetails);
        });
    portLoadingPlanCommingleDetailsRepository.saveAll(portLoadingPlanCommingleDetails);
  }

  /**
   * Fetches cargo nomination details from Loadable Study MS.
   *
   * @param cargoNominationIds
   * @return
   * @throws GenericServiceException
   */
  private Map<Long, LoadableStudy.CargoNominationDetail> getCargoNominationDetails(
      Set<Long> cargoNominationIds) throws GenericServiceException {
    Map<Long, LoadableStudy.CargoNominationDetail> details =
        new HashMap<Long, LoadableStudy.CargoNominationDetail>();
    cargoNominationIds.forEach(
        id -> {
          LoadableStudy.CargoNominationRequest.Builder builder =
              LoadableStudy.CargoNominationRequest.newBuilder();
          builder.setCargoNominationId(id);
          LoadableStudy.CargoNominationDetailReply reply =
              loadableStudyService.getCargoNominationByCargoNominationId(builder.build());
          if (reply.getResponseStatus().getStatus().equals(LoadingPlanConstants.SUCCESS)) {
            log.info("Fetched details of cargo nomination with id {}", id);
            details.put(id, reply.getCargoNominationdetail());
          }
        });

    return details;
  }

  private void savePortStowageDetails(
      LoadingInformation loadingInformation,
      List<LoadingPlanTankDetails> portLoadingPlanStowageDetailsList) {
    log.info(
        "Saving Loading Plan Stowage Details for LoadingInformation {}, PortRotation {}",
        loadingInformation.getId(),
        loadingInformation.getPortRotationXId());
    List<PortLoadingPlanStowageDetails> portLoadingPlanStowages =
        new ArrayList<PortLoadingPlanStowageDetails>();
    portLoadingPlanStowageDetailsList.forEach(
        stowage -> {
          PortLoadingPlanStowageDetails stowageDetails = new PortLoadingPlanStowageDetails();
          loadingPlanBuilderService.buildPortStowage(loadingInformation, stowageDetails, stowage);
          portLoadingPlanStowages.add(stowageDetails);
        });
    portStowageDetailsRepository.saveAll(portLoadingPlanStowages);
  }

  private void savePortStabilityParams(
      LoadingInformation loadingInformation,
      List<LoadingPlanStabilityParameters> portLoadingPlanStabilityParametersList) {
    log.info(
        "Saving Loading Plan Stability Parameters for LoadingInformation {}, PortRotation {}",
        loadingInformation.getId(),
        loadingInformation.getPortRotationXId());
    List<PortLoadingPlanStabilityParameters> portLoadingPlanStabilityParams =
        new ArrayList<PortLoadingPlanStabilityParameters>();
    portLoadingPlanStabilityParametersList.forEach(
        params -> {
          PortLoadingPlanStabilityParameters stabilityParams =
              new PortLoadingPlanStabilityParameters();
          loadingPlanBuilderService.buildPortStabilityParams(
              loadingInformation, stabilityParams, params);
          portLoadingPlanStabilityParams.add(stabilityParams);
        });
    portStabilityParamsRepository.saveAll(portLoadingPlanStabilityParams);
  }

  private void savePortRobDetails(
      LoadingInformation loadingInformation,
      List<LoadingPlanTankDetails> portLoadingPlanRobDetailsList) {
    log.info(
        "Saving Loading Plan ROB Details for LoadingInformation {}, PortRotation {}",
        loadingInformation.getId(),
        loadingInformation.getPortRotationXId());
    List<PortLoadingPlanRobDetails> portLoadingPlanRobDetails =
        new ArrayList<PortLoadingPlanRobDetails>();
    portLoadingPlanRobDetailsList.forEach(
        rob -> {
          PortLoadingPlanRobDetails robDetails = new PortLoadingPlanRobDetails();
          loadingPlanBuilderService.buildPortRob(loadingInformation, robDetails, rob);
          portLoadingPlanRobDetails.add(robDetails);
        });
    portRobDetailsRepository.saveAll(portLoadingPlanRobDetails);
  }

  private void savePortBallastDetails(
      LoadingInformation loadingInformation,
      List<LoadingPlanTankDetails> portLoadingPlanBallastDetailsList) {
    log.info(
        "Saving Loading Plan Ballast Details for LoadingInformation {}, PortRotation {}",
        loadingInformation.getId(),
        loadingInformation.getPortRotationXId());
    List<PortLoadingPlanBallastDetails> portLoadingPlanBallastDetails =
        new ArrayList<PortLoadingPlanBallastDetails>();
    portLoadingPlanBallastDetailsList.forEach(
        ballast -> {
          PortLoadingPlanBallastDetails ballastDetails = new PortLoadingPlanBallastDetails();
          loadingPlanBuilderService.buildPortBallast(loadingInformation, ballastDetails, ballast);
          portLoadingPlanBallastDetails.add(ballastDetails);
        });
    portBallastDetailsRepository.saveAll(portLoadingPlanBallastDetails);
  }

  /**
   * Saves loading sequence
   *
   * @param sequence
   * @param loadingInformation
   */
  private void saveLoadingSequence(
      LoadingSequence sequence, LoadingInformation loadingInformation) {
    log.info("Saving Loading sequence of loading information {}", loadingInformation.getId());
    com.cpdss.loadingplan.entity.LoadingSequence loadingSequence =
        new com.cpdss.loadingplan.entity.LoadingSequence();
    loadingPlanBuilderService.buildLoadingSequence(loadingSequence, sequence, loadingInformation);
    com.cpdss.loadingplan.entity.LoadingSequence savedLoadingSequence =
        loadingSequenceRepository.save(loadingSequence);

    saveBallastValves(savedLoadingSequence, sequence.getBallastValvesList());
    saveCargoValves(savedLoadingSequence, sequence.getCargoValvesList());
    saveDeBallastingRates(savedLoadingSequence, sequence.getDeBallastingRatesList());
    saveLoadingPlanPortWiseDetails(
        savedLoadingSequence, sequence.getLoadingPlanPortWiseDetailsList());
    saveCargoLoadingRates(savedLoadingSequence, sequence.getLoadingRatesList());
    saveBallastPumps(savedLoadingSequence, sequence.getBallastOperationsList());
    if (sequence.getEductorOperation().getEndTime() != 0) {
      saveEductorOperations(savedLoadingSequence, sequence.getEductorOperation());
    }
  }

  /**
   * @param
   * @param eductorOperation
   */
  private void saveEductorOperations(
      com.cpdss.loadingplan.entity.LoadingSequence loadingSequence,
      EductorOperation eductorOperation) {
    log.info("Saving Eductor Operation for Loading Sequence {}", loadingSequence.getId());
    EductionOperation eductionOperation = new EductionOperation();
    eductionOperation.setEductorsUsed(eductorOperation.getEductorPumpsUsed());
    eductionOperation.setBallastPumpsUsed(eductorOperation.getBallastPumpsUsed());
    eductionOperation.setEndTime(eductorOperation.getEndTime());
    eductionOperation.setIsActive(true);
    eductionOperation.setLoadingSequence(loadingSequence);
    eductionOperation.setStartTime(eductorOperation.getStartTime());
    eductionOperation.setTanksUsed(eductorOperation.getTanksUsed());
    eductionOperationRepository.save(eductionOperation);
  }

  private void saveBallastPumps(
      com.cpdss.loadingplan.entity.LoadingSequence loadingSequence,
      List<PumpOperation> ballastOperationsList) {
    log.info("Saving Ballast Pumps for Loading Sequence {}", loadingSequence.getId());
    List<BallastOperation> ballastOperations = new ArrayList<BallastOperation>();
    ballastOperationsList.forEach(
        pumpOperation -> {
          BallastOperation ballastOperation = new BallastOperation();
          loadingPlanBuilderService.buildBallastOperation(
              loadingSequence, ballastOperation, pumpOperation);
          ballastOperations.add(ballastOperation);
        });
    ballastOperationRepository.saveAll(ballastOperations);
  }

  private void saveCargoLoadingRates(
      com.cpdss.loadingplan.entity.LoadingSequence loadingSequence,
      List<LoadingRate> loadingRatesList) {
    log.info("Saving Cargo Loading Rates for Loading Sequence {}", loadingSequence.getId());
    List<CargoLoadingRate> cargoLoadingRates = new ArrayList<CargoLoadingRate>();
    loadingRatesList.forEach(
        loadingRate -> {
          CargoLoadingRate cargoLoadingRate = new CargoLoadingRate();
          loadingPlanBuilderService.buildCargoLoadingRate(
              loadingSequence, cargoLoadingRate, loadingRate);
          cargoLoadingRates.add(cargoLoadingRate);
        });
    cargoLoadingRateRepository.saveAll(cargoLoadingRates);
  }

  private void saveLoadingPlanPortWiseDetails(
      com.cpdss.loadingplan.entity.LoadingSequence loadingSequence,
      List<LoadingPlanPortWiseDetails> loadingPlanPortWiseDetailsList) {
    log.info(
        "Saving Loading Plan PortWise Details for Loading Sequence {}", loadingSequence.getId());
    loadingPlanPortWiseDetailsList.forEach(
        details -> {
          com.cpdss.loadingplan.entity.LoadingPlanPortWiseDetails portWiseDetails =
              new com.cpdss.loadingplan.entity.LoadingPlanPortWiseDetails();
          loadingPlanBuilderService.buildLoadingPlanPortWiseDetails(
              loadingSequence, portWiseDetails, details);
          com.cpdss.loadingplan.entity.LoadingPlanPortWiseDetails savedPortWiseDetails =
              loadingPlanPortWiseDetailsRepository.save(portWiseDetails);
          saveDeBallastingRates(savedPortWiseDetails, details.getDeballastingRatesList());
          saveLoadingPlanBallastDetails(
              savedPortWiseDetails, details.getLoadingPlanBallastDetailsList());
          saveLoadingPlanRobDetails(savedPortWiseDetails, details.getLoadingPlanRobDetailsList());
          saveLoadingPlanStowageDetails(
              savedPortWiseDetails, details.getLoadingPlanStowageDetailsList());
          saveLoadingPlanStabilityParameters(
              savedPortWiseDetails, details.getLoadingPlanStabilityParameters());
          saveLoadingPlanCommingleDetails(
              savedPortWiseDetails, details.getLoadingPlanCommingleDetailsList());
        });
  }

  /**
   * @param
   * @param loadingPlanCommingleDetailsList
   */
  private void saveLoadingPlanCommingleDetails(
      com.cpdss.loadingplan.entity.LoadingPlanPortWiseDetails loadingPlanPortWiseDetails,
      List<LoadingPlanCommingleDetails> loadingPlanCommingleDetailsList) {
    log.info(
        "Saving Loading Plan Commingle Details for LoadingPlanPortWiseDetails {}",
        loadingPlanPortWiseDetails.getId());
    List<com.cpdss.loadingplan.entity.LoadingPlanCommingleDetails> loadingPlanCommingleDetails =
        new ArrayList<com.cpdss.loadingplan.entity.LoadingPlanCommingleDetails>();
    loadingPlanCommingleDetailsList.forEach(
        commingle -> {
          com.cpdss.loadingplan.entity.LoadingPlanCommingleDetails commingleDetails =
              new com.cpdss.loadingplan.entity.LoadingPlanCommingleDetails();
          loadingPlanBuilderService.buildLoadingPlanCommingleDetails(
              loadingPlanPortWiseDetails, commingleDetails, commingle);
          loadingPlanCommingleDetails.add(commingleDetails);
        });
    loadingPlanCommingleDetailsRepository.saveAll(loadingPlanCommingleDetails);
  }

  private void saveLoadingPlanStabilityParameters(
      com.cpdss.loadingplan.entity.LoadingPlanPortWiseDetails loadingPlanPortWiseDetails,
      LoadingPlanStabilityParameters loadingPlanStabilityParameters) {
    log.info(
        "Saving Stability Parameters for LoadingPlanPortWiseDetails {}",
        loadingPlanPortWiseDetails.getId());
    com.cpdss.loadingplan.entity.LoadingPlanStabilityParameters parameters =
        new com.cpdss.loadingplan.entity.LoadingPlanStabilityParameters();
    loadingPlanBuilderService.buildStabilityParameters(
        loadingPlanPortWiseDetails, parameters, loadingPlanStabilityParameters);
    loadingPlanStabilityParametersRepository.save(parameters);
  }

  private void saveLoadingPlanStowageDetails(
      com.cpdss.loadingplan.entity.LoadingPlanPortWiseDetails loadingPlanPortWiseDetails,
      List<LoadingPlanTankDetails> loadingPlanStowageDetailsList) {
    log.info(
        "Saving Loading Plan Stowage Details for LoadingPlanPortWiseDetails {}",
        loadingPlanPortWiseDetails.getId());
    List<com.cpdss.loadingplan.entity.LoadingPlanStowageDetails> loadingPlanStowageDetails =
        new ArrayList<com.cpdss.loadingplan.entity.LoadingPlanStowageDetails>();
    loadingPlanStowageDetailsList.forEach(
        stowage -> {
          com.cpdss.loadingplan.entity.LoadingPlanStowageDetails stowageDetails =
              new com.cpdss.loadingplan.entity.LoadingPlanStowageDetails();
          loadingPlanBuilderService.buildLoadingPlanStowageDetails(
              loadingPlanPortWiseDetails, stowageDetails, stowage);
          loadingPlanStowageDetails.add(stowageDetails);
        });
    loadingPlanStowageDetailsRepository.saveAll(loadingPlanStowageDetails);
  }

  private void saveLoadingPlanRobDetails(
      com.cpdss.loadingplan.entity.LoadingPlanPortWiseDetails loadingPlanPortWiseDetails,
      List<LoadingPlanTankDetails> loadingPlanRobDetailsList) {
    log.info(
        "Saving Loading Plan ROB Details for LoadingPlanPortWiseDetails {}",
        loadingPlanPortWiseDetails.getId());
    List<LoadingPlanRobDetails> loadingPlanRobDetails = new ArrayList<LoadingPlanRobDetails>();
    loadingPlanRobDetailsList.forEach(
        rob -> {
          LoadingPlanRobDetails robDetails = new LoadingPlanRobDetails();
          loadingPlanBuilderService.buildLoadingPlanRobDetails(
              loadingPlanPortWiseDetails, robDetails, rob);
          loadingPlanRobDetails.add(robDetails);
        });
    loadingPlanRobDetailsRepository.saveAll(loadingPlanRobDetails);
  }

  private void saveLoadingPlanBallastDetails(
      com.cpdss.loadingplan.entity.LoadingPlanPortWiseDetails loadingPlanPortWiseDetails,
      List<LoadingPlanTankDetails> loadingPlanBallastDetailsList) {
    log.info(
        "Saving Loading Plan Ballast Details for LoadingPlanPortWiseDetails {}",
        loadingPlanPortWiseDetails.getId());
    List<LoadingPlanBallastDetails> loadingPlanBallastDetails =
        new ArrayList<LoadingPlanBallastDetails>();
    loadingPlanBallastDetailsList.forEach(
        ballast -> {
          LoadingPlanBallastDetails ballastDetails = new LoadingPlanBallastDetails();
          loadingPlanBuilderService.buildLoadingPlanBallastDetails(
              loadingPlanPortWiseDetails, ballastDetails, ballast);
          loadingPlanBallastDetails.add(ballastDetails);
        });
    loadingPlanBallastDetailsRepository.saveAll(loadingPlanBallastDetails);
  }

  private void saveDeBallastingRates(
      com.cpdss.loadingplan.entity.LoadingPlanPortWiseDetails loadingPlanPortWiseDetails,
      List<DeBallastingRate> deballastingRatesList) {
    log.info(
        "Saving DeBallastingRates for LoadingPlanPortWiseDetails {}",
        loadingPlanPortWiseDetails.getId());
    List<DeballastingRate> deballastingRates = new ArrayList<DeballastingRate>();
    deballastingRatesList.forEach(
        rate -> {
          DeballastingRate deballastingRate = new DeballastingRate();
          loadingPlanBuilderService.buildDeBallastingRate(
              loadingPlanPortWiseDetails, deballastingRate, rate);
          deballastingRates.add(deballastingRate);
        });
    deballastingRateRepository.saveAll(deballastingRates);
  }

  private void saveDeBallastingRates(
      com.cpdss.loadingplan.entity.LoadingSequence loadingSequence,
      List<DeBallastingRate> deBallastingRatesList) {
    log.info("Saving DeBallastingRates for LoadingSequence {}", loadingSequence.getId());
    List<DeballastingRate> deballastingRates = new ArrayList<DeballastingRate>();
    deBallastingRatesList.forEach(
        rate -> {
          DeballastingRate deballastingRate = new DeballastingRate();
          loadingPlanBuilderService.buildDeBallastingRate(loadingSequence, deballastingRate, rate);
          deballastingRates.add(deballastingRate);
        });
    deballastingRateRepository.saveAll(deballastingRates);
  }

  private void saveCargoValves(
      com.cpdss.loadingplan.entity.LoadingSequence loadingSequence, List<Valve> cargoValvesList) {
    log.info("Saving CargoValves for LoadingSequence {}", loadingSequence.getId());
    List<CargoValve> cargoValves = new ArrayList<CargoValve>();
    cargoValvesList.forEach(
        valve -> {
          CargoValve cargoValve = new CargoValve();
          loadingPlanBuilderService.buildCargoValve(loadingSequence, cargoValve, valve);
          cargoValves.add(cargoValve);
        });
    cargoValveRepository.saveAll(cargoValves);
  }

  private void saveBallastValves(
      com.cpdss.loadingplan.entity.LoadingSequence loadingSequence, List<Valve> ballastValvesList) {
    log.info("Saving BallastValves for LoadingSequence {}", loadingSequence.getId());
    List<BallastValve> ballastValves = new ArrayList<BallastValve>();
    ballastValvesList.forEach(
        valve -> {
          BallastValve ballastValve = new BallastValve();
          loadingPlanBuilderService.buildBallastValve(loadingSequence, ballastValve, valve);
          ballastValves.add(ballastValve);
        });
    this.ballastValveRepository.saveAll(ballastValves);
  }

  /**
   * @param request
   * @param builder
   * @throws GenericServiceException
   */
  public void getLoadingInfoAlgoStatus(
      LoadingInfoStatusRequest request,
      com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoStatusReply.Builder
          builder)
      throws GenericServiceException {
    log.info("Fetching ALGO status of Loading Information {}", request.getLoadingInfoId());
    Optional<LoadingInformationAlgoStatus> algoStatusOpt = null;
    if (request.getConditionType() == 0) {
      algoStatusOpt =
          loadingInfoAlgoStatusRepository
              .findByProcessIdAndLoadingInformationIdAndConditionTypeAndIsActiveTrue(
                  request.getProcessId(), request.getLoadingInfoId(), null);
    } else {
      algoStatusOpt =
          loadingInfoAlgoStatusRepository
              .findByProcessIdAndLoadingInformationIdAndConditionTypeAndIsActiveTrue(
                  request.getProcessId(), request.getLoadingInfoId(), request.getConditionType());
    }
    if (algoStatusOpt.isEmpty()) {
      throw new GenericServiceException(
          "Could not find loading info status for loading information "
              + request.getLoadingInfoId(),
          CommonErrorCodes.E_HTTP_BAD_REQUEST,
          HttpStatusCode.BAD_REQUEST);
    }

    builder.setLoadingInfoId(request.getLoadingInfoId());
    builder.setLoadingInfoStatusId(algoStatusOpt.get().getLoadingInformationStatus().getId());
    builder.setLoadingInfoStatusLastModifiedTime(
        algoStatusOpt.get().getLastModifiedDateTime().toString());
  }

  /**
   * Fetches Loading Information ALGO errors
   *
   * @param request
   * @param builder
   */
  public void getLoadingInfoAlgoErrors(
      AlgoErrorRequest request,
      com.cpdss.common.generated.LoadableStudy.AlgoErrorReply.Builder builder)
      throws GenericServiceException {
    log.info("Fetching ALGO errors of Loading Information {}", request.getLoadingInformationId());
    List<AlgoErrorHeading> errorHeaders = null;
    if (request.getConditionType() == 0) {
      errorHeaders =
          algoErrorHeadingRepository.findByLoadingInformationIdAndConditionTypeAndIsActiveTrue(
              request.getLoadingInformationId(), null);
    } else {
      errorHeaders =
          algoErrorHeadingRepository.findByLoadingInformationIdAndConditionTypeAndIsActiveTrue(
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
   * Saves ALGO errors
   *
   * @param loadingInformation
   * @param heading
   * @param conditionType
   * @param errors
   */
  public void createAlgoErrors(
      LoadingInformation loadingInformation,
      String heading,
      Integer conditionType,
      List<String> errors) {

    if (conditionType != null) {
      algoErrorHeadingRepository.deleteByLoadingInformationAndConditionType(
          loadingInformation, conditionType);
      algoErrorsRepository.deleteByLoadingInformationAndConditionType(
          loadingInformation, conditionType);
    } else {
      algoErrorHeadingRepository.deleteByLoadingInformation(loadingInformation);
      algoErrorsRepository.deleteByLoadingInformation(loadingInformation);
    }
    saveAlgoErrorEntity(loadingInformation, heading, conditionType, errors);
  }

  /* Persists Internal Server Error in ALGO side
   * @param loadingInformation
   * @param conditionType
   * @param errors
   */
  public void saveAlgoInternalError(
      LoadingInformation loadingInformation, Integer conditionType, List<String> errors) {
    createAlgoErrors(
        loadingInformation,
        AlgoErrorHeaderConstants.ALGO_INTERNAL_SERVER_ERROR,
        conditionType,
        errors);
  }

  /**
   * Persists ALGO errors
   *
   * @param errors
   * @param conditionType
   * @param heading
   * @param loadingInformation
   */
  public void saveAlgoErrorEntity(
      LoadingInformation loadingInformation,
      String heading,
      Integer conditionType,
      List<String> errors) {
    AlgoErrorHeading algoErrorHeading = new AlgoErrorHeading();
    algoErrorHeading.setErrorHeading(heading);
    algoErrorHeading.setLoadingInformation(loadingInformation);
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

  /**
   * Method to communicate loading information
   *
   * @param loadingInfoId loadingInfoId value
   * @return communication id value
   * @throws GenericServiceException Exception on invalid response from envoy-writer or invalid
   *     loadingInfoId
   */
  public String communicateLoadingPlan(final long loadingInfoId, boolean callRemoteAlgo)
      throws GenericServiceException {

    LoadingInformation loadingInformation =
        loadingInformationRepository
            .findByIdAndIsActiveTrue(loadingInfoId)
            .orElseThrow(
                () -> {
                  log.error("LoadingInformation not found. Id: {}", loadingInfoId);
                  return new GenericServiceException(
                      "LoadingInformation not found. Id: " + loadingInfoId,
                      CommonErrorCodes.E_GEN_INTERNAL_ERR,
                      HttpStatusCode.INTERNAL_SERVER_ERROR);
                });

    final String processId = UUID.randomUUID().toString();

    if (callRemoteAlgo) {
      final String messageId =
          communicateData(
              loadingInformation.getId(),
              processId,
              com.cpdss.loadingplan.utility.LoadingPlanConstants.LOADING_PLAN_SHIP_TO_SHORE,
              loadingInformation.getVesselXId(),
              MessageTypes.LOADINGPLAN);
      LoadingPlanCommunicationStatus loadingPlanCommunicationStatus =
          new LoadingPlanCommunicationStatus();

      loadingPlanCommunicationStatus.setMessageUUID(messageId);
      loadingPlanCommunicationStatus.setCommunicationStatus(
          CommunicationStatus.UPLOAD_WITH_HASH_VERIFIED.getId());

      loadingPlanCommunicationStatus.setReferenceId(loadingInformation.getId());
      loadingPlanCommunicationStatus.setMessageType(MessageTypes.LOADINGPLAN.getMessageType());
      loadingPlanCommunicationStatus.setCommunicationDateTime(LocalDateTime.now());
      loadingPlanCommunicationStatus.setActive(true);
      LoadingPlanCommunicationStatus loadingPlanCommunicationStat =
          this.loadingPlanCommunicationStatusRepository.save(loadingPlanCommunicationStatus);
      log.info("Communication table updated : " + loadingPlanCommunicationStat.getId());

      Optional<LoadingInformationStatus> loadingInfoStatusOpt =
          getLoadingInformationStatus(
              LoadingPlanConstants.LOADING_INFORMATION_COMMUNICATED_TO_SHORE);
      // Set Loading Status
      loadingInformationRepository.updateLoadingInfoWithInfoStatus(
          loadingInfoStatusOpt.get(), false, false, loadingInformation.getId());
      createLoadingInformationAlgoStatus(
          loadingInformation, processId, loadingInfoStatusOpt.get(), null);

    } else {
      // Sequence communication
      Set<String> lpSequenceTables =
          new LinkedHashSet<>(
              com.cpdss.loadingplan.utility.LoadingPlanConstants.LOADING_PLAN_SHIP_TO_SHORE);
      lpSequenceTables.addAll(
          com.cpdss.loadingplan.utility.LoadingPlanConstants.LOADING_PLAN_SHORE_TO_SHIP);
      lpSequenceTables.remove("algo_error_heading");
      lpSequenceTables.remove("algo_errors");
      communicateData(
          loadingInformation.getId(),
          processId,
          new ArrayList<>(lpSequenceTables),
          loadingInformation.getVesselXId(),
          MessageTypes.LOADINGPLAN_WITHOUT_ALGO);
    }
    return processId;
  }
  /**
   * Method to communicate data
   *
   * @param referenceId
   * @param communicationId
   * @param communicationTables
   * @param vesselId
   * @param messageType
   * @return
   * @throws GenericServiceException
   */
  private String communicateData(
      final Long referenceId,
      final String communicationId,
      final List<String> communicationTables,
      final Long vesselId,
      final MessageTypes messageType)
      throws GenericServiceException {
    JsonArray jsonArray =
        loadingPlanStagingService.getCommunicationData(
            communicationTables, communicationId, messageType.getMessageType(), referenceId, null);
    log.debug("Communication Request: {}", jsonArray.toString());

    EnvoyWriter.WriterReply ewReply =
        communicationService.passRequestPayloadToEnvoyWriter(
            jsonArray.toString(), vesselId, messageType.getMessageType());
    if (!LoadingPlanConstants.SUCCESS.equals(ewReply.getResponseStatus().getStatus())) {
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
