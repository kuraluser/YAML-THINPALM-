/* Licensed at AlphaOri Technologies */
package com.cpdss.loadablestudy.service;

import static com.cpdss.common.constants.FileRepoConstants.FileRepoSection;
import static com.cpdss.loadablestudy.utility.LoadableStudiesConstants.*;
import static java.lang.String.valueOf;
import static java.util.Optional.ofNullable;

import com.cpdss.common.communication.CommunicationConstants.CommunicationModule;
import com.cpdss.common.domain.FileRepoReply;
import com.cpdss.common.exception.GenericServiceException;
import com.cpdss.common.generated.CargoInfo.CargoReply;
import com.cpdss.common.generated.CargoInfo.CargoRequest;
import com.cpdss.common.generated.CargoInfoServiceGrpc.CargoInfoServiceBlockingStub;
import com.cpdss.common.generated.Common;
import com.cpdss.common.generated.Common.ResponseStatus;
import com.cpdss.common.generated.LoadableStudy.*;
import com.cpdss.common.generated.LoadableStudy.LoadableStudyReply.Builder;
import com.cpdss.common.generated.LoadableStudyServiceGrpc.LoadableStudyServiceImplBase;
import com.cpdss.common.generated.PortInfo;
import com.cpdss.common.generated.PortInfo.GetPortInfoByPortIdsRequest;
import com.cpdss.common.generated.PortInfo.PortReply;
import com.cpdss.common.generated.PortInfoServiceGrpc;
import com.cpdss.common.generated.VesselInfo;
import com.cpdss.common.generated.VesselInfo.VesselReply;
import com.cpdss.common.generated.VesselInfo.VesselRequest;
import com.cpdss.common.generated.VesselInfoServiceGrpc.VesselInfoServiceBlockingStub;
import com.cpdss.common.rest.CommonErrorCodes;
import com.cpdss.common.utils.HttpStatusCode;
import com.cpdss.common.utils.MessageTypes;
import com.cpdss.common.utils.Utils;
import com.cpdss.loadablestudy.communication.LoadableStudyStagingService;
import com.cpdss.loadablestudy.domain.FileRepoAddRequest;
import com.cpdss.loadablestudy.domain.LoadablePlanDetailsAlgoJson;
import com.cpdss.loadablestudy.domain.LoadablePlanPortWiseDetailsAlgoJson;
import com.cpdss.loadablestudy.domain.LoadableStudyAlgoJson;
import com.cpdss.loadablestudy.entity.*;
import com.cpdss.loadablestudy.entity.LoadablePattern;
import com.cpdss.loadablestudy.repository.*;
import com.cpdss.loadablestudy.utility.LoadableStudiesConstants;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Strings;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.grpc.stub.StreamObserver;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import lombok.extern.log4j.Log4j2;
import net.devh.boot.grpc.client.inject.GrpcClient;
import net.devh.boot.grpc.server.service.GrpcService;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.client.ResourceAccessException;

/** @Author jerin.g */
@Log4j2
@GrpcService
@Transactional
public class LoadableStudyService extends LoadableStudyServiceImplBase {

  @Value("${loadablestudy.attachement.rootFolder}")
  private String rootFolder;

  private final long ALGO_RESPONSE_ID = 17L;
  private final long LOADING_RESPONSE_ID = 24L;
  private final long LOADICATOR_RESPONSE_ID = 14L;
  @Autowired private VoyageRepository voyageRepository;
  @Autowired private LoadableStudyPortRotationRepository loadableStudyPortRotationRepository;
  @Autowired private LoadableStudyRepository loadableStudyRepository;
  @Autowired private LoadableQuantityRepository loadableQuantityRepository;
  @Autowired private CargoNominationRepository cargoNominationRepository;
  @Autowired private LoadableStudyStatusRepository loadableStudyStatusRepository;
  @Autowired private LoadablePlanQuantityRepository loadablePlanQuantityRepository;
  @Autowired private EntityManager entityManager;
  @Autowired private LoadableStudyAttachmentsRepository loadableStudyAttachmentsRepository;
  @Autowired private VoyageStatusRepository voyageStatusRepository;
  @Autowired VoyageService voyageService;
  @Autowired SynopticService synopticService;
  @Autowired LoadableStudyRuleInputRepository loadableStudyRuleInputRepository;
  @Autowired LoadableStudyRuleRepository loadableStudyRuleRepository;
  @Autowired LoadablePatternService loadablePatternService;
  @Autowired private LoadableStudyPortRotationService loadableStudyPortRotationService;
  @Autowired private LoadableStudyRuleService loadableStudyRuleService;
  @Autowired private AlgoErrorService algoErrorService;
  @Autowired private DischargeStudyService dischargeStudyService;
  @Autowired private LoadicatorService lsLoadicatorService;
  @Autowired private OnBoardQuantityService onBoardQuantityService;
  @Autowired private AlgoService algoService;
  @Autowired CommunicationService communicationService;
  @Autowired JsonDataService jsonDataService;
  @Autowired OnHandQuantityService onHandQuantityService;
  @Autowired LoadableStudyStagingService loadableStudyStagingService;
  @Autowired private FileRepoService fileRepoService;

  @Autowired
  private CargoNominationOperationDetailsRepository cargoNominationOperationDetailsRepository;

  @Autowired private OnHandQuantityRepository onHandQuantityRepository;
  @Autowired private CommingleCargoRepository commingleCargoRepository;
  @Autowired private OnBoardQuantityRepository onBoardQuantityRepository;
  @Autowired private LoadablePatternAlgoStatusRepository loadablePatternAlgoStatusRepository;
  @Autowired private LoadableStudyAlgoStatusRepository loadableStudyAlgoStatusRepository;
  @Autowired private SynopticalTableRepository synopticalTableRepository;

  @Autowired private JsonDataRepository jsonDataRepository;
  @Autowired private JsonTypeRepository jsonTypeRepository;

  @Autowired private LoadablePlanService loadablePlanService;
  @Autowired private CargoNominationService cargoNominationService;
  @Autowired private CargoService cargoService;

  @Autowired
  private DischargePatternQuantityCargoPortwiseRepository
      dischargePatternQuantityCargoPortwiseRepository;

  @GrpcClient("vesselInfoService")
  private VesselInfoServiceBlockingStub vesselInfoGrpcService;

  @GrpcClient("cargoService")
  private CargoInfoServiceBlockingStub cargoInfoGrpcService;

  @GrpcClient("portInfoService")
  private PortInfoServiceGrpc.PortInfoServiceBlockingStub portInfoGrpcService;

  @Autowired private BillOfLandingRepository billOfLandingRepository;
  @Autowired private LoadablePatternRepository loadablePatternRepository;

  @Autowired
  private SynopticalTableLoadicatorDataRepository synopticalTableLoadicatorDataRepository;

  @Autowired private LoadableStudyCommunicationData loadableStudyCommunicationData;

  @Autowired
  private LoadablePlanStowageBallastDetailsRepository loadablePlanStowageBallastDetailsRepository;

  @Autowired private LoadablePatternCargoDetailsRepository loadablePatternCargoDetailsRepository;

  @Autowired
  private LoadablePlanCommingleDetailsPortwiseRepository
      loadablePlanCommingleDetailsPortwiseRepository;

  @Autowired GenerateDischargeStudyJson generateDischargeStudyJson;
  /**
   * method for save voyage
   *
   * @param request - voyage request details
   * @param responseObserver - grpc class
   * @return
   */
  @Override
  public void saveVoyage(VoyageRequest request, StreamObserver<VoyageReply> responseObserver) {
    VoyageReply.Builder builder = VoyageReply.newBuilder();
    try {
      this.voyageService.saveVoyage(request, builder);
    } catch (Exception e) {
      log.error("Error in saving Voyage ", e);
      builder
          .setResponseStatus(
              StatusReply.newBuilder()
                  .setStatus(FAILED)
                  .setMessage(FAILED)
                  .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR))
          .build();
    } finally {
      responseObserver.onNext(builder.build());
      responseObserver.onCompleted();
    }
  }

  /**
   * method to save loadable quantity
   *
   * @param loadableQuantityRequest
   * @param responseObserver
   * @throws Exception
   * @return void
   */
  @Override
  public void saveLoadableQuantity(
      LoadableQuantityRequest loadableQuantityRequest,
      StreamObserver<LoadableQuantityReply> responseObserver) {
    LoadableQuantityReply.Builder loadableQuantityReply = LoadableQuantityReply.newBuilder();
    try {
      loadableQuantityService.saveLoadableQuantity(loadableQuantityRequest, loadableQuantityReply);
    } catch (GenericServiceException e) {
      log.error("GenericServiceException when saving loadable quantity", e);
      loadableQuantityReply
          .setResponseStatus(
              StatusReply.newBuilder()
                  .setCode(e.getCode())
                  .setMessage(e.getMessage())
                  .setStatus(FAILED)
                  .setStatusCode(CommonErrorCodes.E_HTTP_BAD_REQUEST))
          .build();
    } catch (Exception e) {
      log.error("Error in saving loadable quantity ", e);
      loadableQuantityReply
          .setResponseStatus(
              StatusReply.newBuilder()
                  .setStatus(FAILED)
                  .setMessage(FAILED)
                  .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
                  .setStatusCode(CommonErrorCodes.E_GEN_INTERNAL_ERR))
          .build();
    } finally {
      responseObserver.onNext(loadableQuantityReply.build());
      responseObserver.onCompleted();
    }
  }

  /**
   * Method to find list of loadable studies based on vessel and voyage
   *
   * @param {@link LoadableStudyRequest} - The grpc generated message
   * @param {@link StreamObserver}
   */
  @Override
  @Transactional
  public void findLoadableStudiesByVesselAndVoyage(
      LoadableStudyRequest request, StreamObserver<LoadableStudyReply> responseObserver) {
    Builder replyBuilder = LoadableStudyReply.newBuilder();

    try {
      log.info("inside loadable study service - findLoadableStudiesByVesselAndVoyage");
      Optional<Voyage> voyageOpt = this.voyageRepository.findById(request.getVoyageId());
      if (!voyageOpt.isPresent()) {
        throw new GenericServiceException(
            "Voyage does not exist", CommonErrorCodes.E_HTTP_BAD_REQUEST, null);
      }

      List<LoadableStudy> loadableStudyEntityList =
          this.loadableStudyRepository
              .findByVoyageAndVesselXIdAndPlanningTypeXIdAndIsActiveTrueOrderByCreatedDateTimeDesc(
                  voyageOpt.get(), request.getVesselId(), request.getPlanningTypeValue());

      replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS).build());
      DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
      for (LoadableStudy entity : loadableStudyEntityList) {
        com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail.Builder builder =
            LoadableStudyDetail.newBuilder();
        builder.setLastEdited(dateTimeFormatter.format(entity.getLastModifiedDateTime()));
        builder.setId(entity.getId());
        builder.setName(entity.getName());
        ofNullable(entity.getDischargeCargoNominationId())
            .ifPresent(builder::setDischargingCargoId);
        builder.setCreatedDate(dateTimeFormatter.format(entity.getCreatedDateTime()));
        ofNullable(entity.getDuplicatedFrom())
            .ifPresent(
                duplicatedFrom -> {
                  builder.setCreatedFromId(duplicatedFrom.getId());
                  builder.setCreatedFromVoyageId(duplicatedFrom.getVoyage().getId());
                });
        ofNullable(entity.getLoadableStudyStatus())
            .ifPresent(
                status -> {
                  builder.setStatusId(status.getId());
                  builder.setStatus(status.getName());
                  List<LoadableStudyAlgoStatus> algoStatus =
                      loadableStudyAlgoStatusRepository.findByLoadableStudyIdAndIsActive(
                          entity.getId(), true);
                  if (!algoStatus.isEmpty()) {
                    DateTimeFormatter dateTimeFormatterLastModified =
                        DateTimeFormatter.ofPattern(DATE_TIME_FORMAT_LAST_MODIFIED);

                    builder.setLoadableStudyStatusLastModifiedTime(
                        dateTimeFormatterLastModified.format(
                            algoStatus.stream()
                                .reduce((f, s) -> s)
                                .orElse(null)
                                .getLastModifiedDateTime())); // getting
                    // the
                    // last
                    // algo
                    // status
                  } else {
                    builder.setLoadableStudyStatusLastModifiedTime("0");
                  }
                });
        ofNullable(entity.getDetails()).ifPresent(builder::setDetail);
        ofNullable(entity.getCharterer()).ifPresent(builder::setCharterer);
        ofNullable(entity.getSubCharterer()).ifPresent(builder::setSubCharterer);
        ofNullable(entity.getLoadLineXId()).ifPresent(builder::setLoadLineXId);
        ofNullable(entity.getDraftMark())
            .ifPresent(dratMark -> builder.setDraftMark(valueOf(dratMark)));
        ofNullable(entity.getDraftRestriction())
            .ifPresent(draftRestriction -> builder.setDraftRestriction(valueOf(draftRestriction)));
        ofNullable(entity.getMaxAirTemperature())
            .ifPresent(maxTemp -> builder.setMaxAirTemperature(valueOf(maxTemp)));
        ofNullable(entity.getMaxWaterTemperature())
            .ifPresent(maxTemp -> builder.setMaxWaterTemperature(valueOf(maxTemp)));
        Optional.ofNullable(entity.getLoadOnTop())
            .ifPresent(loadOnTop -> builder.setLoadOnTop(loadOnTop));
        Optional.ofNullable(entity.getIsCargoNominationComplete())
            .ifPresent(builder::setIsCargoNominationComplete);
        Optional.ofNullable(entity.getIsPortsComplete()).ifPresent(builder::setIsPortsComplete);
        Optional.ofNullable(entity.getIsOhqComplete()).ifPresent(builder::setIsOhqComplete);
        Optional.ofNullable(entity.getIsObqComplete()).ifPresent(builder::setIsObqComplete);
        Optional.ofNullable(entity.getIsDischargePortsComplete())
            .ifPresent(builder::setIsDischargingPortComplete);

        Set<LoadableStudyPortRotation> portRotations = entity.getPortRotations();
        if (null != portRotations && !portRotations.isEmpty()) {
          portRotations.forEach(
              port -> {
                if (port.isActive()
                    && null != port.getOperation()
                    && DISCHARGING_OPERATION_ID.equals(port.getOperation().getId())) {
                  builder.addDischargingPortIds(port.getPortXId());
                }
              });
        }

        List<LoadableStudyAttachments> loadableStudyAttachments =
            this.loadableStudyAttachmentsRepository.findByLoadableStudyXIdAndIsActive(
                entity.getId(), true);
        com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment.Builder
            loadableStudyAttachmentBuilder = LoadableStudyAttachment.newBuilder();
        if (null != loadableStudyAttachments && !loadableStudyAttachments.isEmpty()) {
          loadableStudyAttachments.forEach(
              loadableStudyAttachment -> {
                loadableStudyAttachmentBuilder.setFileName(
                    loadableStudyAttachment.getUploadedFileName());
                loadableStudyAttachmentBuilder.setId(loadableStudyAttachment.getId());

                builder.addAttachments(loadableStudyAttachmentBuilder.build());
              });
        }

        // changes made for code optimization
        if (null != portRotations && !portRotations.isEmpty()) {
          OhqPorts.Builder ohqPortsBuilder = OhqPorts.newBuilder();
          List<Long> portRotationIds = new ArrayList<>();
          portRotations.forEach(
              portRotation -> {
                if (portRotation.getIsPortRotationOhqComplete() != null
                    && !portRotation.getIsPortRotationOhqComplete()) {
                  portRotationIds.add(portRotation.getId());
                }
              });

          List<Long> ohqPortRotationIds = new ArrayList<>();
          if (portRotationIds.size() > 0) {
            ohqPortRotationIds =
                this.onHandQuantityRepository.findByLoadableStudyAndPortRotationInAndIsActive(
                    entity.getId(), portRotationIds, true);
          }
          if (ohqPortRotationIds.size() > 0) {
            this.loadableStudyPortRotationRepository.updateIsOhqCompleteByIdInAndIsActiveTrue(
                ohqPortRotationIds, true);
          }
          List<Long> finalOhqPortRotationIds = ohqPortRotationIds;
          portRotations.forEach(
              port -> {
                if (port.isActive()) {
                  ohqPortsBuilder.setId(port.getId());
                  ohqPortsBuilder.setIsPortRotationOhqComplete(
                      port.getIsPortRotationOhqComplete() == null
                          ? false
                          : port.getIsPortRotationOhqComplete());

                  // If there are ohqQuantities for the port rotation and the port rotation
                  // ohqComplete flag is false we set the flag as true since the ohq is already
                  //  there for the port rotation in the DB.
                  if (finalOhqPortRotationIds.contains(port.getId())
                      && (port.getIsPortRotationOhqComplete() != null)
                      && !port.getIsPortRotationOhqComplete()) {
                    ohqPortsBuilder.setIsPortRotationOhqComplete(true);
                  }
                  builder.addOhqPorts(ohqPortsBuilder.build());
                }
              });
        }
        // Fetching ETD of last loading port if requested for DS
        if (request.getPlanningType().equals(Common.PLANNING_TYPE.forNumber(2))) {
          Optional<LoadableStudy> loadableStudyOpt =
              this.loadableStudyRepository.findById(entity.getConfirmedLoadableStudyId());
          if (loadableStudyOpt.isPresent()) {
            Optional<LoadableStudyPortRotation> portRotationOpt =
                loadableStudyOpt.get().getPortRotations().stream()
                    .filter(item -> item.getOperation().getId() == 1L && item.isActive())
                    .max(Comparator.comparing(LoadableStudyPortRotation::getPortOrder));
            if (portRotationOpt.isPresent()) {
              builder.setLastLoadingPortETD(
                  dateTimeFormatter.format(portRotationOpt.get().getEtd()));
            }
            if (entity.getIsDischargeStudyComplete() == null) {
              builder.setIsDischargeStudyComplete(false);
            } else {
              builder.setIsDischargeStudyComplete(entity.getIsDischargeStudyComplete());
            }
          }
        }
        replyBuilder.addLoadableStudies(builder.build());
      }

    } catch (GenericServiceException e) {
      log.error("GenericServiceException when fetching loadable study", e);
      replyBuilder =
          LoadableStudyReply.newBuilder()
              .setResponseStatus(
                  ResponseStatus.newBuilder()
                      .setCode(e.getCode())
                      .setMessage(e.getMessage())
                      .setStatus(FAILED)
                      .build());
    } catch (Exception e) {
      log.error("Error fetching loadable studies", e);
      replyBuilder =
          LoadableStudyReply.newBuilder()
              .setResponseStatus(
                  ResponseStatus.newBuilder()
                      .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
                      .setMessage("Error fetching loadable studies")
                      .setStatus(FAILED)
                      .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  /**
   * Save loadable study
   *
   * @param {@link LoadableStudyDetail}
   * @param {@link StreamObserver}
   */
  @Override
  @Transactional(rollbackFor = {RuntimeException.class, Exception.class})
  public void saveLoadableStudy(
      LoadableStudyDetail request, StreamObserver<LoadableStudyReply> responseObserver) {
    Builder replyBuilder = LoadableStudyReply.newBuilder();
    LoadableStudy entity = null;
    try {
      log.info("Create Loadable Study payload - {}", Utils.toJson(request));
      this.voyageService.checkIfVoyageClosed(request.getVoyageId());
      this.voyageService.checkIfDischargingStarted(request.getVesselId(), request.getVoyageId());
      List<LoadableStudyRules> listOfExistingLSRules = null;
      if (request.getId() != 0) {
        Optional<LoadableStudy> loadableStudy =
            this.loadableStudyRepository.findByIdAndIsActive(request.getId(), true);
        if (!loadableStudy.isPresent()) {
          throw new GenericServiceException(
              "Loadable study with given id does not exist",
              CommonErrorCodes.E_HTTP_BAD_REQUEST,
              HttpStatusCode.BAD_REQUEST);
        }
        entity = loadableStudy.get();

        loadablePatternService.isPatternGeneratedOrConfirmed(entity);
        loadableQuantityService.saveLQuantity(request, loadableStudy);
        // entity.setIsCargoNominationComplete(request.getIsCargoNominationComplete());
        // entity.setIsPortsComplete(request.getIsPortsComplete());
        // entity.setIsOhqComplete(request.getIsOhqComplete());
        // entity.setIsObqComplete(request.getIsObqComplete());
        // entity.setIsDischargePortsComplete(request.getIsDischargingPortComplete());
      } else {
        entity = new LoadableStudy();
        if (request.getDuplicatedFromId() == 0) {
          // voyageService.checkIfVoyageActive(request.getVoyageId());
          entity.setIsCargoNominationComplete(false);
          entity.setIsPortsComplete(false);
          entity.setIsOhqComplete(false);
          entity.setIsObqComplete(false);
          entity.setIsDischargePortsComplete(false);
        } else {
          listOfExistingLSRules = loadableStudyRuleService.getLoadableStudyRules(request);
        }
      }

      this.validateLoadableStudySaveRequest(request, entity);
      entity.setName(request.getName());
      entity.setDetails(StringUtils.isEmpty(request.getDetail()) ? null : request.getDetail());
      entity.setCharterer(
          StringUtils.isEmpty(request.getCharterer()) ? null : request.getCharterer());
      entity.setSubCharterer(
          StringUtils.isEmpty(request.getSubCharterer()) ? null : request.getSubCharterer());
      entity.setVesselXId(request.getVesselId());
      entity.setDraftMark(
          StringUtils.isEmpty(request.getDraftMark())
              ? null
              : new BigDecimal(request.getDraftMark()));
      entity.setLoadLineXId(request.getLoadLineXId());
      entity.setDraftRestriction(
          StringUtils.isEmpty(request.getDraftRestriction())
              ? null
              : new BigDecimal(request.getDraftRestriction()));
      entity.setMaxAirTemperature(
          StringUtils.isEmpty(request.getMaxAirTemperature())
              ? null
              : new BigDecimal(request.getMaxAirTemperature()));
      entity.setMaxWaterTemperature(
          StringUtils.isEmpty(request.getMaxWaterTemperature())
              ? null
              : new BigDecimal(request.getMaxWaterTemperature()));

      Set<LoadableStudyAttachments> attachmentCollection = new HashSet<>();
      if (!request.getAttachmentsList().isEmpty()) {
        String folderLocation = this.constructFolderPath(entity);
        Files.createDirectories(Paths.get(this.rootFolder + folderLocation));
        for (LoadableStudyAttachment attachment : request.getAttachmentsList()) {
          String extension =
              attachment
                  .getFileName()
                  .substring(attachment.getFileName().lastIndexOf("."))
                  .toLowerCase();
          String fileName =
              attachment.getFileName().substring(0, attachment.getFileName().lastIndexOf("."))
                  + "_"
                  + System.currentTimeMillis()
                  + extension;
          String filePath = folderLocation + fileName;
          Path path = Paths.get(this.rootFolder + filePath);
          Files.createFile(path);
          Files.write(path, Base64.getDecoder().decode(attachment.getFilecontent()));
          LoadableStudyAttachments attachmentEntity = new LoadableStudyAttachments();
          attachmentEntity.setUploadedFileName(attachment.getFileName());
          attachmentEntity.setFilePath(filePath);
          attachmentEntity.setLoadableStudy(entity);
          attachmentEntity.setIsActive(true);
          attachmentCollection.add(attachmentEntity);

          // Save to file repo
          FileRepoAddRequest fileRepoAddRequest = new FileRepoAddRequest();
          fileRepoAddRequest.setVoyageNo(entity.getVoyage().getVoyageNo());
          fileRepoAddRequest.setFileName(fileName);
          fileRepoAddRequest.setVesselId(entity.getVesselXId());
          fileRepoAddRequest.setSection(FileRepoSection.LOADABLE_STUDY);
          fileRepoAddRequest.setCategory(ATTACHMENT_CATEGORY);
          fileRepoAddRequest.setFileType(path.toString());
          fileRepoAddRequest.setFile(Base64.getDecoder().decode(attachment.getFilecontent()));

          FileRepoReply fileRepoReply = fileRepoService.addFileToFileRepo(fileRepoAddRequest, true);
          log.debug("Added to file repo. Response: {}", fileRepoReply);
        }
        this.loadableStudyAttachmentsRepository.saveAll(attachmentCollection);
      }

      if (request.getId() != 0) {
        Set<LoadableStudyAttachments> deletedAttachmentsList =
            this.loadableStudyAttachmentsRepository.findByIdInAndIsActive(
                request.getDeletedAttachmentsList(), true);

        if (deletedAttachmentsList != null && deletedAttachmentsList.size() != 0) {
          deletedAttachmentsList.forEach(
              attachment -> {
                attachment.setIsActive(false);
              });
        }
        attachmentCollection.addAll(deletedAttachmentsList);
      }

      this.setCaseNo(entity);
      entity.setLoadableStudyStatus(
          this.loadableStudyStatusRepository.getOne(LOADABLE_STUDY_INITIAL_STATUS_ID));
      entity = this.loadableStudyRepository.save(entity);
      this.checkDuplicatedFromAndCloneEntity(request, entity);
      final LoadableStudy currentLoadableStudy = entity;

      if (request.getId() == 0) {
        if (request.getDuplicatedFromId() != 0) {
          // save rules against saved loadable study(If duplicated LS)
          log.info(" Duplicating rules against LS : " + currentLoadableStudy.getId());
          loadableStudyRuleService.saveDuplicateLoadableStudyRules(
              listOfExistingLSRules, currentLoadableStudy, request);
        } else {
          log.info(" Saving rules against LS from vessel rules : " + currentLoadableStudy.getId());
          loadableStudyRuleService.saveRulesAgainstLoadableStudy(request, currentLoadableStudy);
        }
      }
      replyBuilder
          .setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS).build())
          .setId(entity.getId());

    } catch (GenericServiceException e) {
      TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
      log.error("GenericServiceException when saving loadable study", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(e.getCode())
              .setMessage(e.getMessage())
              .setHttpStatusCode(e.getStatus().value())
              .setStatus(FAILED)
              .build());
      this.deleteFiles(entity);
    } catch (Exception e) {
      TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
      log.error("Error saving loadable study", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setHttpStatusCode(HttpStatusCode.INTERNAL_SERVER_ERROR.value())
              .setMessage("Error saving loadable study")
              .setStatus(FAILED)
              .build());
      this.deleteFiles(entity);
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  /**
   * * Set case number in loadable study entity
   *
   * @param entity
   */
  private void setCaseNo(LoadableStudy entity) {
    if (null != entity.getDraftRestriction()) {
      entity.setCaseNo(LoadableStudiesConstants.CASE_3);
    } else if (LoadableStudiesConstants.CASE_1_LOAD_LINES.contains(entity.getLoadLineXId())) {
      entity.setCaseNo(LoadableStudiesConstants.CASE_1);
    } else {
      entity.setCaseNo(LoadableStudiesConstants.CASE_2);
    }
  }

  private void validateLoadableStudySaveRequest(LoadableStudyDetail request, LoadableStudy entity)
      throws GenericServiceException {
    Optional<Voyage> voyageOpt = this.voyageRepository.findById(request.getVoyageId());
    if (!voyageOpt.isPresent()) {
      throw new GenericServiceException(
          "Voyage does not exist", CommonErrorCodes.E_HTTP_BAD_REQUEST, null);
    }
    entity.setVoyage(voyageOpt.get());
    if (0 != request.getDuplicatedFromId()) {
      Optional<LoadableStudy> createdFromOpt =
          this.loadableStudyRepository.findById(request.getDuplicatedFromId());
      if (!createdFromOpt.isPresent()) {
        throw new GenericServiceException(
            "Created from loadable study does not exist",
            CommonErrorCodes.E_HTTP_BAD_REQUEST,
            null);
      }
      entity.setDuplicatedFrom(createdFromOpt.get());
    }

    this.validateLoadableStudyName(voyageOpt.get(), request);
  }

  /**
   * Check for duplicate LS name
   *
   * @param voyage
   * @param request
   * @throws GenericServiceException
   */
  private void validateLoadableStudyName(Voyage voyage, LoadableStudyDetail request)
      throws GenericServiceException {
    LoadableStudy duplicate =
        this.loadableStudyRepository.findByVoyageAndNameIgnoreCaseAndIsActiveAndPlanningTypeXId(
            voyage, request.getName(), true, Common.PLANNING_TYPE.LOADABLE_STUDY_VALUE);
    if ((request.getId() == 0 && null != duplicate)
        || (null != duplicate && request.getId() != duplicate.getId().longValue())) {
      throw new GenericServiceException(
          "LS already exists with given name",
          CommonErrorCodes.E_CPDSS_LS_NAME_EXISTS,
          HttpStatusCode.BAD_REQUEST);
    }
  }

  /**
   * Construct folder path for loadable study attachments
   *
   * @param loadableStudy - loadable study entity
   * @return - the folder path
   */
  public String constructFolderPath(LoadableStudy loadableStudy) {
    String separator = File.separator;
    StringBuilder pathBuilder = new StringBuilder(separator);
    pathBuilder
        .append("company_")
        .append(loadableStudy.getVoyage().getCompanyXId())
        .append(separator)
        .append("vessel_")
        .append(loadableStudy.getVesselXId())
        .append(separator)
        .append(loadableStudy.getVoyage().getVoyageNo().replace(" ", "_"))
        .append("_")
        .append(loadableStudy.getVoyage().getId())
        .append(separator)
        .append(loadableStudy.getName().replace(" ", "_"))
        .append(separator);
    return valueOf(pathBuilder);
  }

  /**
   * Method to delete file if there is any exception when saving loadable study
   *
   * @param entity - the set of entities for attachments
   */
  private void deleteFiles(LoadableStudy entity) {
    if (null == entity || null == entity.getAttachments()) {
      return;
    }
    for (LoadableStudyAttachments attachment : entity.getAttachments()) {
      Path path = Paths.get(this.rootFolder + attachment.getFilePath());
      try {
        Files.deleteIfExists(path);
      } catch (IOException e) {
        log.error("unable to delete file : {}", this.rootFolder + attachment.getFilePath(), e);
      }
    }
  }

  @Override
  public void saveCargoNomination(
      CargoNominationRequest request, StreamObserver<CargoNominationReply> responseObserver) {
    CargoNominationReply.Builder cargoNominationReplyBuilder = CargoNominationReply.newBuilder();
    try {
      cargoNominationService.saveCargoNomination(request, cargoNominationReplyBuilder);
    } catch (GenericServiceException e) {
      log.error("GenericServiceException saveCargoNomination", e);
      cargoNominationReplyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(e.getCode())
              .setMessage(e.getMessage())
              .setHttpStatusCode(e.getStatus().value())
              .setStatus(FAILED)
              .build());
    } catch (Exception e) {
      log.error("Error saving cargo nomination", e);
      cargoNominationReplyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(FAILED));
    } finally {
      responseObserver.onNext(cargoNominationReplyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  @Override
  public void getLoadableStudyPortRotation(
      PortRotationRequest request, StreamObserver<PortRotationReply> responseObserver) {
    PortRotationReply.Builder replyBuilder = PortRotationReply.newBuilder();
    try {
      loadableStudyPortRotationService.getLoadableStudyPortRotation(request, replyBuilder);
    } catch (GenericServiceException e) {
      log.error("GenericServiceException when fetching loadable study - port data", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(e.getCode())
              .setMessage(e.getMessage())
              .setStatus(FAILED)
              .build());
    } catch (Exception e) {
      log.error("Exception when fetching port rotation data", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage("Exception when fetching loadable study - port data")
              .setStatus(FAILED)
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  /**
   * Retrieves list of cargoNominations by LoadableStudyId can be extended to other Ids like
   * vesselId or voyageId
   */
  @Override
  public void getCargoNominationById(
      CargoNominationRequest request, StreamObserver<CargoNominationReply> responseObserver) {
    com.cpdss.common.generated.LoadableStudy.CargoNominationReply.Builder replyBuilder =
        CargoNominationReply.newBuilder();
    try {
      cargoNominationService.getCargoNominationById(request, replyBuilder);
    } catch (GenericServiceException e) {
      log.error("GenericServiceException when fetching loadable study - port data", e);
      replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(FAILED));
    } catch (Exception e) {
      log.error("Exception when fetching loadable study - port data", e);
      replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(FAILED));
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  @Autowired LoadableQuantityService loadableQuantityService;

  /**
   * method for getting loadable quantity
   *
   * @param request - has the loadable quantity id
   * @param responseObserver
   */
  @Override
  public void getLoadableQuantity(
      LoadableQuantityReply request, StreamObserver<LoadableQuantityResponse> responseObserver) {
    LoadableQuantityResponse.Builder builder = LoadableQuantityResponse.newBuilder();
    try {
      log.info("Get Loadable Quantity payload - {}", Utils.toJson(request));
      loadableQuantityService.loadableQuantityByPortId(
          builder, request.getLoadableStudyId(), request.getPortRotationId());
    } catch (GenericServiceException e) {
      log.error("Error getting loadable quantity ", e);
      builder.setResponseStatus(
          StatusReply.newBuilder()
              .setStatus(FAILED)
              .setMessage(e.getMessage())
              .setCode(e.getCode()));
    } catch (Exception e) {
      log.error("Error getting loadable quantity ", e);
      builder.setResponseStatus(
          StatusReply.newBuilder()
              .setStatus(FAILED)
              .setMessage(FAILED)
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR));
    } finally {
      responseObserver.onNext(builder.build());
      responseObserver.onCompleted();
    }
  }

  public VesselReply getVesselDetailsById(VesselRequest replyBuilder) {
    return this.vesselInfoGrpcService.getVesselDetailsById(replyBuilder);
  }

  public VesselInfo.VesselTankResponse getVesselTankDetailsByTankIds(
      VesselInfo.VesselTankRequest replyBuilder) {
    return this.vesselInfoGrpcService.getVesselInfoBytankIds(replyBuilder);
  }

  /** Retrieves all valve segregation available */
  @Override
  public void getValveSegregation(
      ValveSegregationRequest request, StreamObserver<ValveSegregationReply> responseObserver) {
    ValveSegregationReply.Builder reply = ValveSegregationReply.newBuilder();
    try {
      cargoNominationService.getValveSegregation(request, reply);
    } catch (Exception e) {
      log.error("Error in getValveSegregation method ", e);
      ResponseStatus.Builder responseStatus = ResponseStatus.newBuilder();
      responseStatus.setStatus(FAILED);
      reply.setResponseStatus(responseStatus);
    } finally {
      responseObserver.onNext(reply.build());
      responseObserver.onCompleted();
    }
  }

  /** Get voyages by vessel */
  @Override
  public void getVoyagesByVessel(
      VoyageRequest request, StreamObserver<VoyageListReply> responseObserver) {
    VoyageListReply.Builder builder = VoyageListReply.newBuilder();
    try {
      voyageService.getVoyagesByVessel(request, builder);
    } catch (Exception e) {
      log.error("Error in getVoyagesByVessel method ", e);
      builder.setResponseStatus(
          StatusReply.newBuilder()
              .setStatus(FAILED)
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .build());
    } finally {
      responseObserver.onNext(builder.build());
      responseObserver.onCompleted();
    }
  }

  /** Save port rotation info for loadable study */
  @Override
  public void saveLoadableStudyPortRotation(
      PortRotationDetail request, StreamObserver<PortRotationReply> responseObserver) {
    PortRotationReply.Builder replyBuilder = PortRotationReply.newBuilder();
    try {
      loadableStudyPortRotationService.saveLoadableStudyPortRotation(request, replyBuilder);

      if (request.getId() == 0) {
        if (request.getOperationId() == 2) {
          dischargeStudyService.addCargoNominationForPortRotation(
              replyBuilder.getPortRotationId(), request.getLoadableStudyId());
        }
      } else {
        dischargeStudyService.resetCargoNominationQuantityAndBackLoading(
            replyBuilder.getPortRotationId(), request.getLoadableStudyId());
      }

    } catch (GenericServiceException e) {
      log.error("GenericServiceException when saving loadable study - port data", e);
      TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(e.getCode())
              .setMessage(e.getMessage())
              .setStatus(FAILED)
              .setHttpStatusCode(e.getStatus().value())
              .build());
    } catch (Exception e) {
      log.error("Exception when saving loadable study port data", e);
      TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage("Exception when saving port data")
              .setStatus(FAILED)
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  @Override
  @Transactional
  public void saveDischargingPorts(
      PortRotationRequest request, StreamObserver<PortRotationReply> responseObserver) {
    PortRotationReply.Builder replyBuilder = PortRotationReply.newBuilder();
    try {
      dischargeStudyService.saveDischargingPorts(request, replyBuilder);
    } catch (GenericServiceException e) {
      log.error("GenericServiceException when saving discharging ports", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(e.getCode())
              .setMessage(e.getMessage())
              .setHttpStatusCode(e.getStatus().value())
              .setStatus(FAILED)
              .build());
    } catch (Exception e) {
      log.error("Exception when saving discharging ports data", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage("Exception when saving discharging ports")
              .setStatus(FAILED)
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  /** Delete specific cargo nomination */
  @Override
  public void deleteCargoNomination(
      CargoNominationRequest request, StreamObserver<CargoNominationReply> responseObserver) {
    CargoNominationReply.Builder cargoNominationReplyBuilder = CargoNominationReply.newBuilder();
    try {
      cargoNominationService.deleteCargoNomination(request, cargoNominationReplyBuilder);
    } catch (GenericServiceException e) {
      log.error("GenericServiceException when deleting cargo nomination", e);
      cargoNominationReplyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(e.getCode())
              .setMessage(e.getMessage())
              .setStatus(FAILED)
              .setHttpStatusCode(e.getStatus().value())
              .build());
    } catch (Exception e) {
      log.error("Error deleting cargo nomination", e);
      cargoNominationReplyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setStatus(FAILED)
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR));
    } finally {
      responseObserver.onNext(cargoNominationReplyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  @Override
  public void deleteLoadableStudy(
      LoadableStudyRequest request, StreamObserver<LoadableStudyReply> responseObserver) {
    LoadableStudyReply.Builder replyBuilder = LoadableStudyReply.newBuilder();
    try {
      Optional<LoadableStudy> entityOpt =
          this.loadableStudyRepository.findById(request.getLoadableStudyId());
      if (!entityOpt.isPresent()) {
        throw new GenericServiceException(
            "Loadable study does not exist",
            CommonErrorCodes.E_HTTP_BAD_REQUEST,
            HttpStatusCode.BAD_REQUEST);
      }
      LoadableStudy entity = entityOpt.get();

      this.voyageService.checkIfVoyageClosed(entity.getVoyage().getId());
      this.voyageService.checkIfDischargingStarted(
          entity.getVesselXId(), entity.getVoyage().getId());

      loadablePatternService.isPatternGeneratedOrConfirmed(entity);

      if (null != entity.getLoadableStudyStatus()
          && LOADABLE_STUDY_STATUS_PLAN_GENERATED_ID.equals(
              entity.getLoadableStudyStatus().getId())) {
        throw new GenericServiceException(
            "Loadable study with status plan generated cannot be deleted",
            CommonErrorCodes.E_HTTP_BAD_REQUEST,
            HttpStatusCode.BAD_REQUEST);
      }
      entity.setActive(false);
      this.loadableStudyRepository.save(entity);
      List<LoadableStudyRules> listOfLSRules =
          loadableStudyRuleRepository.findByLoadableStudyAndIsActive(entity, true);
      if (listOfLSRules != null && listOfLSRules.size() > 0) {
        List<Long> rulesInputId =
            listOfLSRules.stream()
                .flatMap(lsRules -> lsRules.getLoadableStudyRuleInputs().stream())
                .map(LoadableStudyRuleInput::getId)
                .collect(Collectors.toList());
        loadableStudyRuleInputRepository.updateLoadbleStudyRulesInputStatus(rulesInputId);
        List<Long> rulesId =
            listOfLSRules.stream().map(LoadableStudyRules::getId).collect(Collectors.toList());
        loadableStudyRuleRepository.updateLoadbleStudyRulesStatus(rulesId);
      }
      replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS).build());
    } catch (GenericServiceException e) {
      log.error("GenericServiceException when saving loadable study - port data", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(e.getCode())
              .setMessage(e.getMessage())
              .setStatus(FAILED)
              .setHttpStatusCode(e.getStatus().value())
              .build());
    } catch (Exception e) {
      log.error("Exception when saving loadable study - port data", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage("Exception when saving loadable study - port data")
              .setStatus(FAILED)
              .setHttpStatusCode(Integer.valueOf(CommonErrorCodes.E_GEN_INTERNAL_ERR))
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  /**
   * @param request
   * @param responseObserver
   */
  @Override
  public void getPortRotationByLoadableStudyId(
      PortRotationRequest request, StreamObserver<PortRotationReply> responseObserver) {
    log.info("Inside getPortRotation loadable study micro service");
    PortRotationReply.Builder portRotationReplyBuilder = PortRotationReply.newBuilder();
    try {
      loadableStudyPortRotationService.getPortRotationByLoadableStudyId(
          request, portRotationReplyBuilder);
    } catch (Exception e) {
      log.error("Error deleting cargo nomination", e);
      portRotationReplyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setStatus(FAILED)
              .setMessage(FAILED)
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR));
    } finally {
      responseObserver.onNext(portRotationReplyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  /** Delete port rotation by id */
  @Override
  public void deletePortRotation(
      PortRotationRequest request, StreamObserver<PortRotationReply> responseObserver) {
    PortRotationReply.Builder replyBuilder = PortRotationReply.newBuilder();
    try {
      loadableStudyPortRotationService.deletePortRotation(request, replyBuilder);
    } catch (GenericServiceException e) {
      log.error("GenericServiceException when deleting port rotation", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(e.getCode())
              .setMessage(e.getMessage())
              .setStatus(FAILED)
              .setHttpStatusCode(e.getStatus().value())
              .build());
    } catch (Exception e) {
      log.error("Exception when deleting port rotation", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage("Exception when deleting port rotation")
              .setStatus(FAILED)
              .setHttpStatusCode(Integer.valueOf(CommonErrorCodes.E_GEN_INTERNAL_ERR))
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  @Override
  public void getOnHandQuantity(
      OnHandQuantityRequest request, StreamObserver<OnHandQuantityReply> responseObserver) {
    log.info("getOnHandQuantity");
    OnHandQuantityReply.Builder replyBuilder = OnHandQuantityReply.newBuilder();
    try {
      onHandQuantityService.getOnHandQuantity(request, replyBuilder);
    } catch (GenericServiceException e) {
      log.error("GenericServiceException when fetching on hand quantities", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(e.getCode())
              .setMessage(e.getMessage())
              .setStatus(FAILED)
              .build());
    } catch (Exception e) {
      log.error("Exception when fetching on hand quantities", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage("Exception when fetching on hand quantities")
              .setStatus(FAILED)
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  /**
   * Get vessel fuel tanks from vessel micro service
   *
   * @param request
   * @return
   */
  public VesselReply getVesselTanks(VesselRequest request) {
    return this.vesselInfoGrpcService.getVesselTanks(request);
  }

  /** Save on hand quantity */
  @Override
  public void saveOnHandQuantity(
      OnHandQuantityDetail request, StreamObserver<OnHandQuantityReply> responseObserver) {
    OnHandQuantityReply.Builder replyBuilder = OnHandQuantityReply.newBuilder();
    try {
      onHandQuantityService.saveOnHandQuantity(request, replyBuilder);
    } catch (GenericServiceException e) {
      log.error("GenericServiceException when saving on hand quantities", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(e.getCode())
              .setMessage(e.getMessage())
              .setStatus(FAILED)
              .setHttpStatusCode(e.getStatus().value())
              .build());
    } catch (Exception e) {
      log.error("Exception when saving on hand quantities", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage("Exception when saving on hand quantities")
              .setStatus(FAILED)
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  /** get purpose of commingle look up */
  @Override
  public void getPurposeOfCommingle(
      PurposeOfCommingleRequest request, StreamObserver<PurposeOfCommingleReply> responseObserver) {
    PurposeOfCommingleReply.Builder reply = PurposeOfCommingleReply.newBuilder();
    try {
      cargoService.getPurposeOfCommingle(request, reply);
    } catch (Exception e) {
      log.error("Error in getPurposeOfCommingle method ", e);
      ResponseStatus.Builder responseStatus = ResponseStatus.newBuilder();
      responseStatus.setStatus(FAILED);
      reply.setResponseStatus(responseStatus);
    } finally {
      responseObserver.onNext(reply.build());
      responseObserver.onCompleted();
    }
  }

  /** Get list of patterns for a loadable study */
  @Override
  public void saveLoadablePatterns(
      LoadablePatternAlgoRequest request, StreamObserver<AlgoReply> responseObserver) {
    AlgoReply.Builder builder = AlgoReply.newBuilder();
    try {
      loadablePatternService.saveLoadablePatterns(request, builder);
    } catch (GenericServiceException e) {
      log.error("GenericServiceException in loadable pattern list", e);
      builder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(e.getCode())
              .setMessage(e.getMessage())
              .setStatus(FAILED)
              .build());
    } catch (Exception e) {
      log.error("Exception in loadable pattern list", e);
      builder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage("Exception in getLoadablePatternList")
              .setStatus(FAILED)
              .build());
    } finally {
      responseObserver.onNext(builder.build());
      responseObserver.onCompleted();
    }
  }
  /**
   * @param request
   * @param responseObserver
   */
  @Override
  public void saveLoadicatorResults(
      LoadicatorResultsRequest request, StreamObserver<AlgoReply> responseObserver) {
    AlgoReply.Builder replyBuilder = AlgoReply.newBuilder();
    try {
      lsLoadicatorService.saveLoadicatorResults(request, replyBuilder);
    } catch (Exception e) {
      log.error("Exception in saveLoadicatorResults", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage("Exception in saveLoadicatorResults")
              .setStatus(FAILED)
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  @Override
  public void getLoadablePatternList(
      LoadablePatternRequest request, StreamObserver<LoadablePatternReply> responseObserver) {
    LoadablePatternReply.Builder replyBuilder = LoadablePatternReply.newBuilder();
    try {
      loadablePatternService.getLoadablePatternList(request, replyBuilder);
    } catch (GenericServiceException e) {
      log.error("GenericServiceException in loadable pattern list", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(e.getCode())
              .setMessage(e.getMessage())
              .setStatus(FAILED)
              .build());
    } catch (Exception e) {
      log.error("Exception in loadable pattern list", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage("Exception in getLoadablePatternList")
              .setStatus(FAILED)
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  @Override
  public void getLoadablePatternDetails(
      LoadablePatternRequest request, StreamObserver<LoadablePatternReply> responseObserver) {
    log.info("Inside get Loadable Pattern Details in loadable study micro service");
    LoadablePatternReply.Builder builder = LoadablePatternReply.newBuilder();
    try {
      loadablePatternService.getLoadablePatternDetails(request, builder);
    } catch (Exception e) {
      log.error("Exception when fetching get Loadable Pattern Details", e);
      builder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage("Exception when fetching on Loadable Pattern Details")
              .setStatus(FAILED)
              .build());
    } finally {
      responseObserver.onNext(builder.build());
      responseObserver.onCompleted();
    }
  }

  /** Get commingle cargo for a loadable study */
  @Override
  public void getCommingleCargo(
      CommingleCargoRequest request, StreamObserver<CommingleCargoReply> responseObserver) {
    com.cpdss.common.generated.LoadableStudy.CommingleCargoReply.Builder replyBuilder =
        CommingleCargoReply.newBuilder();
    try {
      cargoService.getCommingleCargo(request, replyBuilder);
    } catch (GenericServiceException e) {
      log.error("GenericServiceException when fetching loadable study - getCommingleCargo", e);
      replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(FAILED));
    } catch (Exception e) {
      log.error("Exception when fetching loadable study - getCommingleCargo", e);
      replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(FAILED));
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  /** Save commingle cargo for the specific loadable study */
  @Override
  public void saveCommingleCargo(
      CommingleCargoRequest request, StreamObserver<CommingleCargoReply> responseObserver) {
    com.cpdss.common.generated.LoadableStudy.CommingleCargoReply.Builder replyBuilder =
        CommingleCargoReply.newBuilder();
    try {
      cargoService.saveCommingleCargo(request, replyBuilder);
    } catch (GenericServiceException e) {
      log.error("GenericServiceException when saving CommingleCargo", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(e.getCode())
              .setMessage(e.getMessage())
              .setStatus(FAILED)
              .setHttpStatusCode(e.getStatus().value()));
    } catch (Exception e) {
      log.error("Exception when saving CommingleCargo", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage("Exception when saving CommingleCargo")
              .setStatus(FAILED));
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  @Override
  public void updateUllage(
      UpdateUllageRequest request, StreamObserver<UpdateUllageReply> responseObserver) {
    log.info("Inside get updateUllage in loadable study micro service");
    UpdateUllageReply.Builder replyBuilder = UpdateUllageReply.newBuilder();
    try {
      loadablePlanService.updateUllage(request, replyBuilder);
    } catch (GenericServiceException e) {
      log.error("GenericServiceException in update ullage", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(e.getCode())
              .setMessage(e.getMessage())
              .setStatus(FAILED)
              .build());
    } catch (Exception e) {
      log.error("Exception in update ullage", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage(e.getMessage())
              .setStatus(FAILED)
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  @Override
  public void validateLoadablePlan(
      LoadablePlanDetailsRequest request, StreamObserver<AlgoReply> responseObserver) {
    log.info("Inside get validateLoadablePlan in loadable study micro service");
    AlgoReply.Builder replyBuilder = AlgoReply.newBuilder();
    try {
      loadablePlanService.validateLoadablePlan(request, replyBuilder);
    } catch (Exception e) {
      log.error("Exception while validateLoadablePlan", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage("Exception while validate Loadable Plan")
              .setStatus(FAILED)
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  @Override
  public void getLoadablePatternCommingleDetails(
      LoadablePatternCommingleDetailsRequest request,
      StreamObserver<LoadablePatternCommingleDetailsReply> responseObserver) {
    log.info("Inside get Loadable Pattern Commingle Details in loadable study micro service");
    LoadablePatternCommingleDetailsReply.Builder builder =
        LoadablePatternCommingleDetailsReply.newBuilder();
    try {
      loadablePatternService.getLoadablePatternCommingleDetails(request, builder);
    } catch (Exception e) {
      log.error("Exception in update ullage", e);
      builder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage("Exception while recalculating volume")
              .setStatus(FAILED)
              .build());
    } finally {
      responseObserver.onNext(builder.build());
      responseObserver.onCompleted();
    }
  }

  @Override
  public void savePatternValidateResult(
      LoadablePatternAlgoRequest request, StreamObserver<AlgoReply> responseObserver) {
    AlgoReply.Builder builder = AlgoReply.newBuilder();
    try {
      loadablePatternService.savePatternValidateResult(request, builder);
    } catch (GenericServiceException e) {
      log.error("GenericServiceException in loadable pattern list", e);
      builder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(e.getCode())
              .setMessage(e.getMessage())
              .setStatus(FAILED)
              .build());
    } catch (Exception e) {
      log.error("Exception in loadable pattern list", e);
      builder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage("Exception in getLoadablePatternList")
              .setStatus(FAILED)
              .build());
    } finally {
      responseObserver.onNext(builder.build());
      responseObserver.onCompleted();
    }
  }

  @Override
  public void generateLoadablePatterns(
      AlgoRequest request, StreamObserver<AlgoReply> responseObserver) {
    log.info("Inside generateLoadablePatterns service");
    com.cpdss.common.generated.LoadableStudy.AlgoReply.Builder replyBuilder =
        AlgoReply.newBuilder();
    try {
      loadablePatternService.generateLoadablePatterns(request, replyBuilder);
    } catch (GenericServiceException e) {
      log.error("GenericServiceException when generating pattern", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(e.getCode())
              .setMessage(e.getMessage())
              .setStatus(FAILED)
              .setHttpStatusCode(e.getStatus().value())
              .build());
    } catch (ResourceAccessException e) {
      log.error("Error calling ALGO. LS Id: {}, Trace: {}", request.getLoadableStudyId(), e);
      replyBuilder =
          AlgoReply.newBuilder()
              .setResponseStatus(
                  ResponseStatus.newBuilder()
                      .setStatus(FAILED)
                      .setMessage(ERRO_CALLING_ALGO)
                      .setCode(CommonErrorCodes.E_CPDSS_ALGO_ISSUE)
                      .build());
    } catch (Exception e) {
      log.error("Exception when when calling algo  ", e);
      replyBuilder =
          AlgoReply.newBuilder()
              .setResponseStatus(
                  ResponseStatus.newBuilder()
                      .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
                      .setMessage("Error when calling algo ")
                      .setHttpStatusCode(Integer.valueOf(CommonErrorCodes.E_GEN_INTERNAL_ERR))
                      .setStatus(FAILED)
                      .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  public void buildSynopticalTable(
      long loadableStudyId, com.cpdss.loadablestudy.domain.LoadableStudy loadableStudy) {
    List<LoadableStudyPortRotation> portRotations =
        loadableStudyPortRotationRepository.findByLoadableStudyAndIsActive(loadableStudyId, true);
    loadableStudy.setSynopticalTableDetails(new ArrayList<>());
    List<SynopticalTable> synopticalTableList =
        this.synopticalTableRepository.findByLoadableStudyPortRotationAndIsActive(
            portRotations, true);
    synopticalTableList.forEach(
        synopticalTableData -> {
          com.cpdss.loadablestudy.domain.SynopticalTable synopticalTableDto =
              new com.cpdss.loadablestudy.domain.SynopticalTable();
          synopticalTableDto.setLoadableStudyPortRotationId(
              synopticalTableData.getLoadableStudyPortRotation().getId());
          synopticalTableDto.setId(synopticalTableData.getId());
          synopticalTableDto.setPortId(synopticalTableData.getPortXid());
          synopticalTableDto.setOperationType(synopticalTableData.getOperationType());
          loadableStudy.getSynopticalTableDetails().add(synopticalTableDto);
        });
  }

  public void buildLoadableAttachment(
      long loadableStudyId, com.cpdss.loadablestudy.domain.LoadableStudy loadableStudy) {
    List<LoadableStudyAttachments> loadableStudyAttachments =
        this.loadableStudyAttachmentsRepository.findByLoadableStudyXIdAndIsActive(
            loadableStudyId, true);
    loadableStudyAttachments.forEach(
        loadableAttach -> {
          com.cpdss.loadablestudy.domain.LoadableStudyAttachment loadableAttachDto =
              new com.cpdss.loadablestudy.domain.LoadableStudyAttachment();

          ofNullable(loadableAttach.getFilePath())
              .ifPresent(filePath -> loadableAttachDto.setFilePath(String.valueOf(filePath)));
          ofNullable(loadableAttach.getUploadedFileName())
              .ifPresent(fileName -> loadableAttachDto.setFileName(String.valueOf(fileName)));

          try {
            File file = ResourceUtils.getFile(this.rootFolder + loadableAttachDto.getFilePath());
            byte[] fileContent = Files.readAllBytes(file.toPath());
            // inputStream = new InputStreamResource(new FileInputStream(file));
            loadableAttachDto.setContent(fileContent);
          } catch (IOException e) {
            log.error("FileNotFoundException in buildLoadableAttachment", e);
          }
          List<com.cpdss.loadablestudy.domain.LoadableStudyAttachment> attachmentList =
              loadableStudy.getLoadableStudyAttachment();
          if (attachmentList == null) {
            attachmentList = new ArrayList<>();
          }
          attachmentList.add(loadableAttachDto);
        });
  }

  /**
   * @param loadableStudyOpt
   * @param loadableStudy
   * @param modelMapper void
   * @throws GenericServiceException
   */
  public void buildLoadableStudy(
      Long loadableStudyId,
      LoadableStudy loadableStudyOpt,
      com.cpdss.loadablestudy.domain.LoadableStudy loadableStudy,
      ModelMapper modelMapper)
      throws GenericServiceException {
    buildLoadableStuydDetails(Optional.of(loadableStudyOpt), loadableStudy);
    cargoNominationService.buildCargoNominationDetails(loadableStudyId, loadableStudy, modelMapper);
    cargoService.buildCommingleCargoDetails(loadableStudyOpt.getId(), loadableStudy, modelMapper);
    loadableQuantityService.buildLoadableQuantityDetails(loadableStudyId, loadableStudy);
    loadableStudyPortRotationService.buildLoadableStudyPortRotationDetails(
        loadableStudyId, loadableStudy, modelMapper);
    cargoNominationService.buildCargoNominationPortDetails(loadableStudyId, loadableStudy);
    onHandQuantityService.buildOnHandQuantityDetails(loadableStudyOpt, loadableStudy, modelMapper);
    onBoardQuantityService.buildOnBoardQuantityDetails(
        loadableStudyOpt, loadableStudy, modelMapper);
    loadableStudyPortRotationService.buildportRotationDetails(loadableStudyOpt, loadableStudy);
    loadableStudyRuleService.buildLoadableStudyRuleDetails(loadableStudyOpt, loadableStudy);
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void getLoadicatorData(
      LoadicatorDataRequest request, StreamObserver<LoadicatorDataReply> responseObserver) {
    log.info("Inside getLoadicatorData service");
    LoadicatorDataReply.Builder replyBuilder = LoadicatorDataReply.newBuilder();
    try {
      lsLoadicatorService.getLoadicatorData(request, replyBuilder);

    } catch (Exception e) {
      log.error("Exception when when getLoadicatorData ", e);
      replyBuilder =
          LoadicatorDataReply.newBuilder()
              .setResponseStatus(
                  ResponseStatus.newBuilder()
                      .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
                      .setMessage("Error when getLoadicatorData ")
                      .setStatus(FAILED)
                      .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  /**
   * @param build
   * @return PortReply
   */
  public PortReply getPortInfo(GetPortInfoByPortIdsRequest build) {
    return portInfoGrpcService.getPortInfoByPortIds(build);
  }

  /**
   * @param loadableStudyOpt
   * @param loadableStudy void
   */
  private void buildLoadableStuydDetails(
      Optional<LoadableStudy> loadableStudyOpt,
      com.cpdss.loadablestudy.domain.LoadableStudy loadableStudy) {
    loadableStudy.setId(loadableStudyOpt.get().getId());
    loadableStudy.setVesselId(loadableStudyOpt.get().getVesselXId());
    ofNullable(loadableStudyOpt.get().getDetails())
        .ifPresent(details -> loadableStudy.setDetails(details));
    ofNullable(loadableStudyOpt.get().getVoyage())
        .ifPresent(voyage -> loadableStudy.setVoyageId(voyage.getId()));
    ofNullable(loadableStudyOpt.get().getVoyage())
        .ifPresent(voyage -> loadableStudy.setVoyageNo(voyage.getVoyageNo()));

    ofNullable(loadableStudyOpt.get().getName()).ifPresent(name -> loadableStudy.setName(name));
    ofNullable(loadableStudyOpt.get().getCharterer())
        .ifPresent(charterer -> loadableStudy.setCharterer(charterer));
    ofNullable(loadableStudyOpt.get().getSubCharterer())
        .ifPresent(subCharterer -> loadableStudy.setSubCharterer(subCharterer));

    ofNullable(loadableStudyOpt.get().getDraftMark())
        .ifPresent(draftMark -> loadableStudy.setDraftMark(String.valueOf(draftMark)));

    ofNullable(loadableStudyOpt.get().getDraftRestriction())
        .ifPresent(
            draftRestriction ->
                loadableStudy.setDraftRestriction(String.valueOf(draftRestriction)));

    ofNullable(loadableStudyOpt.get().getLoadLineXId())
        .ifPresent(loadLineId -> loadableStudy.setLoadlineId(loadLineId));
    ofNullable(loadableStudyOpt.get().getEstimatedMaxSag())
        .ifPresent(
            estimatedMaxSag -> loadableStudy.setEstimatedMaxSG(String.valueOf(estimatedMaxSag)));
    ofNullable(loadableStudyOpt.get().getMaxAirTemperature())
        .ifPresent(
            maxAirTemperature -> loadableStudy.setMaxAirTemp(String.valueOf(maxAirTemperature)));
    ofNullable(loadableStudyOpt.get().getMaxWaterTemperature())
        .ifPresent(
            maxWaterTemperature ->
                loadableStudy.setMaxWaterTemp(String.valueOf(maxWaterTemperature)));

    if (ofNullable(loadableStudyOpt.get().getLoadOnTop()).isPresent()) {
      loadableStudy.setLoadOnTopForSlopTank(loadableStudyOpt.get().getLoadOnTop());
    } else {
      loadableStudy.setLoadOnTopForSlopTank(false);
    }
    Optional<Long> dischargeCargoId =
        ofNullable(loadableStudyOpt.get().getDischargeCargoNominationId());
    if (dischargeCargoId.isPresent() && dischargeCargoId.get().equals(new Long(0))) {
      loadableStudy.setCargoToBeDischargeFirstId(null);
    } else if (!dischargeCargoId.isPresent()) {
      loadableStudy.setCargoToBeDischargeFirstId(null);
    } else {
      loadableStudy.setCargoToBeDischargeFirstId(dischargeCargoId.get());
    }

    if (Optional.ofNullable(loadableStudyOpt.get().getFeedbackLoop()).isPresent()) {
      loadableStudy.setFeedbackLoop(loadableStudyOpt.get().getFeedbackLoop());
    } else {
      loadableStudy.setFeedbackLoop(false);
    }

    if (Optional.ofNullable(loadableStudyOpt.get().getFeedbackLoopCount()).isPresent()) {
      loadableStudy.setFeedbackLoopCount(loadableStudyOpt.get().getFeedbackLoopCount());
    } else {
      loadableStudy.setFeedbackLoopCount(0);
    }
  }

  /** Get on board quantity details corresponding to a loadable study */
  @Override
  public void getOnBoardQuantity(
      OnBoardQuantityRequest request, StreamObserver<OnBoardQuantityReply> responseObserver) {
    OnBoardQuantityReply.Builder replyBuilder = OnBoardQuantityReply.newBuilder();
    try {
      onBoardQuantityService.getOnBoardQuantity(request, replyBuilder);
    } catch (Exception e) {
      log.error("Exception when fetching on board quantities", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage("Exception when fetching on board quantities")
              .setStatus(FAILED)
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  /** Save On board quantity details */
  @Override
  public void saveOnBoardQuantity(
      OnBoardQuantityDetail request, StreamObserver<OnBoardQuantityReply> responseObserver) {
    OnBoardQuantityReply.Builder replyBuilder = OnBoardQuantityReply.newBuilder();
    try {
      onBoardQuantityService.saveOnBoardQuantity(request, replyBuilder);
    } catch (GenericServiceException e) {
      log.error("GenericServiceException when saving on board quantities", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(e.getCode())
              .setMessage("GenericServiceException when saving on board quantities")
              .setStatus(FAILED)
              .setHttpStatusCode(e.getStatus().value())
              .build());
    } catch (Exception e) {
      log.error("Exception when saving on board quantities", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage("Exception when saving on board quantities")
              .setStatus(FAILED)
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  /**
   * @param request
   * @param responseObserver
   */
  @Override
  public void saveAlgoLoadableStudyStatus(
      AlgoStatusRequest request, StreamObserver<AlgoStatusReply> responseObserver) {
    AlgoStatusReply.Builder replyBuilder = AlgoStatusReply.newBuilder();
    try {
      algoService.saveAlgoLoadableStudyStatus(request, replyBuilder);
    } catch (Exception e) {
      log.error("Exception when saving Algo Loadable Study Status ", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage("Exception when saving Algo Loadable Study Status")
              .setStatus(FAILED)
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
  public void saveSynopticalTable(
      SynopticalTableRequest request, StreamObserver<SynopticalTableReply> responseObserver) {
    SynopticalTableReply.Builder replyBuilder = SynopticalTableReply.newBuilder();
    try {
      synopticService.saveSynopticalTable(request, replyBuilder);
    } catch (GenericServiceException e) {
      log.error("GenericServiceException when saving synoptical table", e);
      TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(e.getCode())
              .setMessage("GenericServiceException when saving synoptical table")
              .setStatus(FAILED)
              .setHttpStatusCode(e.getStatus().value())
              .build());
    } catch (Exception e) {
      log.error("Exception when saving saving synoptical table", e);
      TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage("Exception when saving synoptical table")
              .setStatus(FAILED)
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  @Override
  public void getSynopticalTable(
      SynopticalTableRequest request, StreamObserver<SynopticalTableReply> responseObserver) {
    SynopticalTableReply.Builder replyBuilder = SynopticalTableReply.newBuilder();
    try {
      synopticService.getSynopticalTable(request, replyBuilder);
    } catch (GenericServiceException e) {
      log.error("GenericServiceException when fetching synoptical table", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(e.getCode())
              .setMessage(e.getMessage())
              .setStatus(FAILED)
              .build());
    } catch (Exception e) {
      log.error("Exception when fetching synoptical table", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage("Exception when fetching synoptical table")
              .setStatus(FAILED)
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  /**
   * Call vessel info grpc service for synoptical table data
   *
   * @param request
   * @return
   */
  public VesselReply getVesselDetailForSynopticalTable(VesselRequest request) {
    return this.vesselInfoGrpcService.getVesselDetailForSynopticalTable(request);
  }

  @Override
  public void getAlgoErrors(
      AlgoErrorRequest request, StreamObserver<AlgoErrorReply> responseObserver) {
    log.info("inside getAlgoErrors loadable study service");
    AlgoErrorReply.Builder replyBuilder = AlgoErrorReply.newBuilder();
    try {
      algoService.getAlgoErrors(request, replyBuilder);
    } catch (GenericServiceException e) {
      log.error("GenericServiceException when fetching loadable study - getAlgoErrors", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(e.getCode())
              .setMessage(e.getMessage())
              .setStatus(FAILED)
              .build());

    } catch (Exception e) {
      log.error("Exception when getAlgoErrors ", e);
      replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(FAILED));
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  @Override
  public void getLoadablePlanDetails(
      LoadablePlanDetailsRequest request,
      StreamObserver<LoadablePlanDetailsReply> responseObserver) {
    log.info("inside getLoadablePlanDetails loadable study service");
    LoadablePlanDetailsReply.Builder replyBuilder = LoadablePlanDetailsReply.newBuilder();
    try {
      loadablePlanService.getLoadablePlanDetails(request, replyBuilder);
    } catch (GenericServiceException e) {
      log.error("GenericServiceException when fetching loadable study - port data", e);
      replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(FAILED));
    } catch (Exception e) {
      log.error("Exception when getLoadablePlanDetails ", e);
      replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(FAILED));
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  /**
   * @param request
   * @param responseObserver
   */
  @Override
  public void confirmPlanStatus(
      ConfirmPlanRequest request, StreamObserver<ConfirmPlanReply> responseObserver) {
    log.info("inside confirmPlanStatus loadable study service");
    ConfirmPlanReply.Builder replyBuilder = ConfirmPlanReply.newBuilder();
    try {
      loadablePatternService.confirmPlanStatus(request, replyBuilder);
    } catch (Exception e) {
      log.error("Exception when confirmPlanStatus ", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setStatus(FAILED)
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage("Exception when confirmPlanStatus Loadable Study Status"));
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  /**
   * @param request
   * @param responseObserver
   */
  @Override
  public void confirmPlan(
      ConfirmPlanRequest request, StreamObserver<ConfirmPlanReply> responseObserver) {
    log.info("inside confirmPlan loadable study service");
    ConfirmPlanReply.Builder replyBuilder = ConfirmPlanReply.newBuilder();
    try {
      loadablePatternService.confirmPlan(request, replyBuilder);
    } catch (GenericServiceException e) {
      log.error("confrim plan not allowed for active voyage", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setStatus(CommonErrorCodes.E_CPDSS_CONFIRM_PLAN_NOT_ALLOWED)
              .setCode(e.getCode())
              .build());
    } catch (Exception e) {
      log.error("Exception when confirmPlan ", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setStatus(FAILED)
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage("Exception when confirmPlan Loadable Study Status"));

    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  /**
   * @param request
   * @param responseObserver
   */
  @Override
  public void getLoadableStudyStatus(
      LoadableStudyStatusRequest request,
      StreamObserver<LoadableStudyStatusReply> responseObserver) {
    LoadableStudyStatusReply.Builder replyBuilder = LoadableStudyStatusReply.newBuilder();
    try {
      if (0 == request.getLoadablePatternId()) {
        log.info("Inside getLoadableStudyStatus");
        Optional<LoadableStudyAlgoStatus> loadableStudyAlgoStatusOpt = null;
        Optional<LoadableStudyAlgoStatus> loadableStudyAlgoStatusOptWthMessageId =
            loadableStudyAlgoStatusRepository.findByLoadableStudyIdAndMessageIdAndIsActive(
                request.getLoadableStudyId(), request.getProcessId(), true);
        if (!loadableStudyAlgoStatusOptWthMessageId.isPresent()) {
          loadableStudyAlgoStatusOpt =
              loadableStudyAlgoStatusRepository.findByLoadableStudyIdAndProcessIdAndIsActive(
                  request.getLoadableStudyId(), request.getProcessId(), true);
        } else {
          loadableStudyAlgoStatusOpt = loadableStudyAlgoStatusOptWthMessageId;
        }

        if (!loadableStudyAlgoStatusOpt.isPresent()) {
          log.info("Invalid loadable study Id");
          replyBuilder.setResponseStatus(
              ResponseStatus.newBuilder()
                  .setCode(CommonErrorCodes.E_HTTP_BAD_REQUEST)
                  .setMessage("Invalid loadable study Id")
                  .build());
        } else {
          replyBuilder.setLoadableStudystatusId(
              loadableStudyAlgoStatusOpt.get().getLoadableStudyStatus().getId());
          replyBuilder.setLoadableStudyStatusLastModifiedTime(
              loadableStudyAlgoStatusOpt.get().getLastModifiedDateTime().toString());
          replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS).build());
        }
      } else {
        log.info("Inside getLoadablePatternStatus");
        Optional<LoadablePatternAlgoStatus> loadablePatternAlgoStatusOpt = null;
        Optional<LoadablePatternAlgoStatus> loadablePatternAlgoStatusOptWithProcessId =
            loadablePatternAlgoStatusRepository.findByLoadablePatternIdAndProcessIdAndIsActive(
                request.getLoadablePatternId(), request.getProcessId(), true);
        if (!loadablePatternAlgoStatusOptWithProcessId.isPresent()) {
          Optional<LoadablePatternAlgoStatus> loadablePatternAlgoStatusOptWithMsdId =
              loadablePatternAlgoStatusRepository.findByLoadablePatternIdAndMessageIdAndIsActive(
                  request.getLoadablePatternId(), request.getProcessId(), true);
          loadablePatternAlgoStatusOpt = loadablePatternAlgoStatusOptWithMsdId;
        } else {
          loadablePatternAlgoStatusOpt = loadablePatternAlgoStatusOptWithProcessId;
        }
        if (!loadablePatternAlgoStatusOpt.isPresent()) {
          log.info("Invalid loadable pattern Id");
          replyBuilder.setResponseStatus(
              ResponseStatus.newBuilder()
                  .setCode(CommonErrorCodes.E_HTTP_BAD_REQUEST)
                  .setMessage("Invalid loadable pattern Id")
                  .build());
        } else {
          replyBuilder.setLoadableStudystatusId(
              loadablePatternAlgoStatusOpt.get().getLoadableStudyStatus().getId());
          replyBuilder.setLoadableStudyStatusLastModifiedTime(
              loadablePatternAlgoStatusOpt.get().getLastModifiedDateTime().toString());
          replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS).build());
        }
      }

    } catch (Exception e) {
      log.error("Exception when getLoadableStudyStatus ", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage("Exception when saving Algo Loadable Study Status")
              .setStatus(FAILED)
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  /** Retrieves the synoptical data for a portId */
  @Override
  public void getSynopticalDataByPortId(
      SynopticalTableRequest request, StreamObserver<SynopticalTableReply> responseObserver) {
    SynopticalTableReply.Builder replyBuilder = SynopticalTableReply.newBuilder();
    try {
      log.info("Voyage Status or Dash board API");
      log.info("Get Synoptic Data for port Id : Request payload - {}", Utils.toJson(request));
      synopticService.getSynopticalDataByPortId(request, replyBuilder);
    } catch (GenericServiceException e) {
      log.error("GenericServiceException in getSynopticalDataByPortId", e);
      replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(FAILED));
    } catch (Exception e) {
      log.error("Exception in getSynopticalDataByPortId", e);
      replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(FAILED));
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  /** Retrieves the synoptical port data for a portId */
  @Override
  public void getSynopticalPortDataByPortId(
      SynopticalTableRequest request, StreamObserver<SynopticalTableReply> responseObserver) {
    SynopticalTableReply.Builder replyBuilder = SynopticalTableReply.newBuilder();
    try {
      synopticService.getSynopticalPortDataByPortId(request, replyBuilder);
    } catch (GenericServiceException e) {
      log.error("GenericServiceException in getSynopticalDataByPortId", e);
      replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(FAILED));
    } catch (Exception e) {
      log.error("Exception in getSynopticalDataByPortId", e);
      replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(FAILED));
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  @Transactional
  public void checkDuplicatedFromAndCloneEntity(LoadableStudyDetail request, LoadableStudy entity)
      throws GenericServiceException {

    if (0 != request.getDuplicatedFromId()) {
      try {
        List<LoadableStudyPortRotation> loadableStudyPortRotationParentList =
            this.loadableStudyPortRotationRepository.findByLoadableStudyAndIsActive(
                request.getDuplicatedFromId(), true);
        log.info(
            "duplicate LS, Port Rotation Parent Size - {}",
            loadableStudyPortRotationParentList.size());
        List<LoadableStudyPortRotation> loadableStudyDuplicatedPorts = new ArrayList<>();
        if (!loadableStudyPortRotationParentList.isEmpty()) {
          for (LoadableStudyPortRotation lspr : loadableStudyPortRotationParentList) {
            log.info(
                "duplicate LS, Duplicated Port Rotation - Id {}, Port Id {}, Operation {}",
                lspr.getId(),
                lspr.getPortXId(),
                lspr.getOperation().getName());
            entityManager.detach(lspr);
            lspr.setId(null);
            lspr.setLoadableStudy(entity);
            loadableStudyDuplicatedPorts.add(lspr);
          }
          loadableStudyDuplicatedPorts =
              this.loadableStudyPortRotationRepository.saveAll(loadableStudyDuplicatedPorts);
        }
        log.info(
            "duplicate LS, Duplicated Port Rotation Child Size - {}",
            loadableStudyDuplicatedPorts.size());

        List<CargoNomination> cargoNominationList =
            this.cargoNominationRepository.findByLoadableStudyXIdAndIsActiveOrderById(
                request.getDuplicatedFromId(), true);
        Map<Long, Long> cargoNominationIdMap = new HashMap<>();
        if (!cargoNominationList.isEmpty()) {
          for (CargoNomination cargoNomination : cargoNominationList) {
            Long id = cargoNomination.getId();
            CargoNomination crgoNomination = new CargoNomination();
            List<CargoNominationPortDetails> oldCargoNominationPortDetails =
                this.cargoNominationOperationDetailsRepository.findByCargoNominationAndIsActiveTrue(
                    cargoNomination);

            BeanUtils.copyProperties(cargoNomination, crgoNomination);
            crgoNomination.setLoadableStudyXId(entity.getId());
            crgoNomination.setId(null);
            crgoNomination.setCargoNominationPortDetails(new HashSet<CargoNominationPortDetails>());
            for (CargoNominationPortDetails oldCargo : oldCargoNominationPortDetails) {
              CargoNominationPortDetails cargoNominationPortDetails =
                  new CargoNominationPortDetails();
              BeanUtils.copyProperties(oldCargo, cargoNominationPortDetails);
              cargoNominationPortDetails.setId(null);
              cargoNominationPortDetails.setCargoNomination(crgoNomination);
              Optional<LoadableStudyPortRotation> portRotationOpt =
                  loadableStudyDuplicatedPorts.stream()
                      .filter(
                          portRotation ->
                              portRotation
                                  .getPortOrder()
                                  .equals(oldCargo.getPortRotation().getPortOrder()))
                      .findFirst();
              portRotationOpt.ifPresentOrElse(
                  cargoNominationPortDetails::setPortRotation,
                  () -> cargoNominationPortDetails.setPortRotation(null));
              crgoNomination.getCargoNominationPortDetails().add(cargoNominationPortDetails);
            }
            CargoNomination ent = this.cargoNominationRepository.save(crgoNomination);
            cargoNominationIdMap.put(id, ent.getId());
          }
        }

        Optional<LoadableStudy> loadableStudyOpt =
            this.loadableStudyRepository.findByIdAndIsActive(request.getDuplicatedFromId(), true);
        if (!loadableStudyOpt.isPresent()) {
          throw new GenericServiceException(
              "Loadable study does not exist",
              CommonErrorCodes.E_HTTP_BAD_REQUEST,
              HttpStatusCode.BAD_REQUEST);
        }
        entity.setDischargeCargoNominationId(
            cargoNominationIdMap.get(loadableStudyOpt.get().getDischargeCargoNominationId()));
        entity.setLoadOnTop(loadableStudyOpt.get().getLoadOnTop());
        entity.setIsCargoNominationComplete(loadableStudyOpt.get().getIsCargoNominationComplete());
        entity.setIsDischargePortsComplete(loadableStudyOpt.get().getIsDischargePortsComplete());
        entity.setIsObqComplete(loadableStudyOpt.get().getIsObqComplete());
        entity.setIsOhqComplete(loadableStudyOpt.get().getIsOhqComplete());
        entity.setIsPortsComplete(loadableStudyOpt.get().getIsPortsComplete());
        entity.setPortRotations(new HashSet<>(loadableStudyOpt.get().getPortRotations()));

        List<OnHandQuantity> onHandQuantityList =
            this.onHandQuantityRepository.findByLoadableStudyAndIsActive(
                loadableStudyOpt.get(), true);
        log.info("duplicate LS, OHQ list size - {}", onHandQuantityList.size());

        if (!onHandQuantityList.isEmpty()) {
          List<OnHandQuantity> OnHandQuantities = new ArrayList<OnHandQuantity>();
          for (OnHandQuantity onHandQuantity :
              onHandQuantityList.stream()
                  .filter(ohq -> ohq.getPortRotation().isActive())
                  .collect(Collectors.toList())) {

            // In ohq port id not getting updated with port rotation port id.
            Optional<LoadableStudyPortRotation> duplicated =
                loadableStudyDuplicatedPorts.stream()
                    .filter(
                        port ->
                            port.getPortXId()
                                    .equals(
                                        onHandQuantity
                                            .getPortRotation()
                                            .getPortXId()) // compare port id
                                && onHandQuantity.getPortRotation()
                                    != null // parent ohq port rotation
                                && port.getOperation()
                                    .getId()
                                    .equals(
                                        onHandQuantity
                                            .getPortRotation()
                                            .getOperation()
                                            .getId()) // operation check
                                && port.getPortOrder()
                                    .equals(
                                        onHandQuantity
                                            .getPortRotation()
                                            .getPortOrder())) // port order
                    .findAny();

            if (!duplicated.isPresent()) {
              throw new GenericServiceException(
                  "Could not find the duplicated port rotation entity",
                  CommonErrorCodes.E_GEN_INTERNAL_ERR,
                  HttpStatusCode.BAD_REQUEST);
            }

            entityManager.detach(onHandQuantity);
            onHandQuantity.setId(null);
            onHandQuantity.setLoadableStudy(entity);
            onHandQuantity.setActualArrivalQuantity(null);
            onHandQuantity.setActualDepartureQuantity(null);
            onHandQuantity.setPortRotation(duplicated.get());
            OnHandQuantities.add(onHandQuantity);
          }
          this.onHandQuantityRepository.saveAll(OnHandQuantities);
        }

        // Fetching On Board Quantities from Previous voyage's Discharging Plan.
        List<OnBoardQuantity> onBoardQuantities =
            this.onBoardQuantityService.populateOnBoardQuantities(entity);
        this.onBoardQuantityRepository.saveAll(onBoardQuantities);

        List<LoadableQuantity> loadableQuantityList =
            this.loadableQuantityRepository.findByLoadableStudyXIdAndIsActive(
                request.getDuplicatedFromId(), true);
        if (!loadableQuantityList.isEmpty()) {
          List<LoadableQuantity> loadableQuantities = new ArrayList<LoadableQuantity>();

          for (LoadableQuantity oldLQ : loadableQuantityList) {
            entityManager.detach(oldLQ);
            oldLQ.setId(null);
            oldLQ.setLoadableStudyXId(entity);
            log.info(
                "Duplicate loadable quantity From LS {}, LQ Port Rotation {}",
                request.getDuplicatedFromId(),
                oldLQ.getLoadableStudyPortRotation().getId());
            this.setNewPortRotationIdForNewLS(oldLQ, loadableStudyDuplicatedPorts);
            log.info(
                "Duplicate loadable quantity To LS {}, LQ Port Rotation {}",
                entity.getId(),
                oldLQ.getLoadableStudyPortRotation().getId());
            loadableQuantities.add(oldLQ);
          }
          this.loadableQuantityRepository.saveAll(loadableQuantities);
        }

        List<com.cpdss.loadablestudy.entity.CommingleCargo> CommingleCargoList =
            this.commingleCargoRepository.findByLoadableStudyXIdAndIsActive(
                request.getDuplicatedFromId(), true);
        if (!CommingleCargoList.isEmpty()) {
          List<com.cpdss.loadablestudy.entity.CommingleCargo> CommingleCargos = new ArrayList<>();

          CommingleCargoList.forEach(
              commingleCargo -> {
                entityManager.detach(commingleCargo);
                commingleCargo.setId(null);
                commingleCargo.setLoadableStudyXId(entity.getId());
                commingleCargo.setCargoNomination1Id(
                    cargoNominationIdMap.get(commingleCargo.getCargoNomination1Id()));
                commingleCargo.setCargoNomination2Id(
                    cargoNominationIdMap.get(commingleCargo.getCargoNomination2Id()));
                CommingleCargos.add(commingleCargo);
              });
          this.commingleCargoRepository.saveAll(CommingleCargos);
        }

        List<SynopticalTable> synopticalTableList =
            this.synopticalTableRepository.findByLoadableStudyXIdAndIsActive(
                request.getDuplicatedFromId(), true);

        if (!synopticalTableList.isEmpty()) {
          List<SynopticalTable> synopticalTables = new ArrayList<>();
          for (SynopticalTable synopticalTable : synopticalTableList) {
            LoadableStudyPortRotation parent = synopticalTable.getLoadableStudyPortRotation();
            Optional<LoadableStudyPortRotation> duplicated =
                loadableStudyDuplicatedPorts.stream()
                    .filter(
                        port ->
                            port.getPortXId().equals(parent.getPortXId())
                                && port.getOperation().getId().equals(parent.getOperation().getId())
                                && port.getPortOrder().equals(parent.getPortOrder()))
                    .findAny();
            if (!duplicated.isPresent()) {
              throw new GenericServiceException(
                  "Could not find the duplicated port rotation entity",
                  CommonErrorCodes.E_GEN_INTERNAL_ERR,
                  HttpStatusCode.BAD_REQUEST);
            }
            entityManager.detach(synopticalTable);
            synopticalTable.setId(null);
            synopticalTable.setLoadableStudyPortRotation(duplicated.get());
            synopticalTable.setLoadableStudyXId(entity.getId());
            synopticalTable.setEtaActual(null);
            synopticalTable.setEtdActual(null);
            synopticalTable.setConstantActual(null);
            synopticalTable.setDisplacementActual(null);
            synopticalTable.setConstantActual(null);
            synopticalTable.setDeadWeightActual(null);
            synopticalTable.setOthersActual(null);

            synopticalTables.add(synopticalTable);
          }
          this.synopticalTableRepository.saveAll(synopticalTables);
        }

        List<LoadableStudyAttachments> attachmentsList =
            this.loadableStudyAttachmentsRepository.findByLoadableStudyXIdAndIsActive(
                request.getDuplicatedFromId(), true);

        List<LoadableStudyAttachments> loadableStudyAttachmentsList =
            attachmentsList.stream()
                .filter(
                    loadableStudyAttachments ->
                        !request
                            .getDeletedAttachmentsList()
                            .contains(loadableStudyAttachments.getId()))
                .collect(Collectors.toList());

        if (!loadableStudyAttachmentsList.isEmpty()) {
          List<LoadableStudyAttachments> loadableStudyAttachments =
              new ArrayList<LoadableStudyAttachments>();

          loadableStudyAttachmentsList.forEach(
              loadableStudyAttachment -> {
                entityManager.detach(loadableStudyAttachment);
                LoadableStudyAttachments attachments = new LoadableStudyAttachments();
                attachments.setId(null);
                attachments.setFilePath(loadableStudyAttachment.getFilePath());
                attachments.setLoadableStudy(entity);
                attachments.setIsActive(true);
                attachments.setUploadedFileName(loadableStudyAttachment.getUploadedFileName());
                loadableStudyAttachments.add(attachments);
              });
          this.loadableStudyAttachmentsRepository.saveAll(loadableStudyAttachments);
        }

      } catch (Exception e) {
        log.error("GenericServiceException in checkDuplicatedFromAndCloneEntity", e);
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        throw new GenericServiceException(
            "Failed to save duplicate entries", CommonErrorCodes.E_GEN_INTERNAL_ERR, null);
      }
    }
  }

  private void setNewPortRotationIdForNewLS(
      LoadableQuantity lq, List<LoadableStudyPortRotation> newPrList) {
    if (lq != null && lq.getLoadableStudyPortRotation() != null) {
      LoadableStudyPortRotation pr = lq.getLoadableStudyPortRotation();
      if (pr.isActive()) {
        Optional<LoadableStudyPortRotation> portRotaionIdToAdd =
            newPrList.stream()
                .filter(
                    var ->
                        (pr.getPortXId().equals(var.getPortXId()))
                            && (pr.getOperation().getId().equals(var.getOperation().getId())))
                .findFirst();
        lq.setLoadableStudyPortRotation(portRotaionIdToAdd.get());
      }
    }
  }

  @Override
  public void downloadLoadableStudyAttachment(
      LoadableStudyAttachmentRequest request,
      StreamObserver<LoadableStudyAttachmentReply> responseObserver) {
    LoadableStudyAttachmentReply.Builder builder = LoadableStudyAttachmentReply.newBuilder();
    try {
      LoadableStudyAttachments attachment =
          loadableStudyAttachmentsRepository.findByIdAndLoadableStudyXIdAndIsActive(
              request.getFileId(), request.getLoadableStudyId(), true);
      if (null == attachment) {
        throw new GenericServiceException(
            "Attachment does not exist",
            CommonErrorCodes.E_HTTP_BAD_REQUEST,
            HttpStatusCode.BAD_REQUEST);
      }
      builder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS).build());
      builder.setFilePath(this.rootFolder + attachment.getFilePath());
    } catch (GenericServiceException e) {
      log.error("GenericServiceException in downloadLoadableStudyAttachment", e);
      builder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setStatus(FAILED)
              .setCode(CommonErrorCodes.E_HTTP_BAD_REQUEST)
              .build());
    } catch (Exception e) {
      log.error("Exception in downloadLoadableStudyAttachment", e);
      builder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setStatus(FAILED)
              .setCode(CommonErrorCodes.E_HTTP_BAD_REQUEST)
              .build());
    } finally {
      responseObserver.onNext(builder.build());
      responseObserver.onCompleted();
    }
  }

  /*
   * To save all port rotation details
   */
  @Override
  public void saveLoadableStudyPortRotationList(
      PortRotationRequest request, StreamObserver<PortRotationReply> responseObserver) {
    PortRotationReply.Builder replyBuilder = PortRotationReply.newBuilder();
    try {
      loadableStudyPortRotationService.saveLoadableStudyPortRotationList(request, replyBuilder);
    } catch (GenericServiceException e) {
      log.error("GenericServiceException when saveLoadableStudyPortRotationList", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(e.getCode())
              .setMessage(e.getMessage())
              .setStatus(FAILED)
              .setHttpStatusCode(e.getStatus().value())
              .build());
    } catch (Exception e) {
      log.error("Exception when saveLoadableStudyPortRotationList", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage("Exception when saving port data")
              .setStatus(FAILED)
              .setHttpStatusCode(Integer.valueOf(CommonErrorCodes.E_GEN_INTERNAL_ERR))
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  @Override
  public void saveComment(
      SaveCommentRequest request, StreamObserver<SaveCommentReply> responseObserver) {

    SaveCommentReply.Builder replyBuilder = SaveCommentReply.newBuilder();
    try {
      loadablePlanService.saveComment(request, replyBuilder);
    } catch (Exception e) {
      log.error("Error saving comment", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage("Error saving comment")
              .setStatus(FAILED)
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  public void saveLoadOnTop(
      com.cpdss.common.generated.LoadableStudy.SaveLoadOnTopRequest request,
      io.grpc.stub.StreamObserver<SaveCommentReply> responseObserver) {
    SaveCommentReply.Builder replyBuilder = SaveCommentReply.newBuilder();
    try {
      Optional<LoadableStudy> loadableStudyOpt =
          this.loadableStudyRepository.findByIdAndIsActive(request.getLoadableStudyId(), true);

      if (!loadableStudyOpt.isPresent()) {
        throw new GenericServiceException(
            "LoadableStudy does not exist",
            CommonErrorCodes.E_HTTP_BAD_REQUEST,
            HttpStatusCode.BAD_REQUEST);
      }
      loadablePatternService.isPatternGeneratedOrConfirmed(loadableStudyOpt.get());
      this.voyageService.checkIfVoyageClosed(loadableStudyOpt.get().getVoyage().getId());
      this.voyageService.checkIfDischargingStarted(
          loadableStudyOpt.get().getVesselXId(), loadableStudyOpt.get().getVoyage().getId());

      LoadableStudy entity = loadableStudyOpt.get();
      entity.setLoadOnTop(request.getLoadOnTop());
      entity = this.loadableStudyRepository.save(entity);

      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder().setStatus(SUCCESS).setMessage(SUCCESS).build());
    } catch (GenericServiceException e) {
      log.error("GenericServiceException when saving load on top", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(e.getCode())
              .setMessage(e.getMessage())
              .setStatus(FAILED)
              .setHttpStatusCode(e.getStatus().value())
              .build());
    } catch (Exception e) {
      log.error("Error saving load on top", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage("Error saving load on top")
              .setStatus(FAILED)
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  public CargoReply getCargoInfo(CargoRequest build) {
    return cargoInfoGrpcService.getCargoInfo(build);
  }

  @Override
  public void getVoyages(VoyageRequest request, StreamObserver<VoyageListReply> responseObserver) {
    VoyageListReply.Builder builder = VoyageListReply.newBuilder();
    log.info("Get Voyages - Payload \n {}", Utils.toJson(request));
    try {
      voyageService.getVoyages(request, builder);
    } catch (Exception e) {
      log.error("Error in getVoyagesByVessel method ", e);
      builder.setResponseStatus(
          StatusReply.newBuilder()
              .setStatus(FAILED)
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .build());
    } finally {
      responseObserver.onNext(builder.build());
      responseObserver.onCompleted();
    }
  }

  /**
   * Method to generate loadable plan report
   *
   * @param request LoadablePlanReportRequest object
   * @param responseObserver StreamObserver<LoadablePlanReportReply> object
   */
  @Override
  public void getLoadablePlanReport(
      com.cpdss.common.generated.LoadableStudy.LoadablePlanReportRequest request,
      StreamObserver<com.cpdss.common.generated.LoadableStudy.LoadablePlanReportReply>
          responseObserver) {
    com.cpdss.common.generated.LoadableStudy.LoadablePlanReportReply.Builder dataChunkBuilder =
        com.cpdss.common.generated.LoadableStudy.LoadablePlanReportReply.newBuilder();
    //      Create workbook
    try (XSSFWorkbook workbook = new XSSFWorkbook()) {
      loadablePlanService.getLoadablePlanReport(workbook, request, dataChunkBuilder);
    } catch (Exception e) {
      log.error("Error in getLoadablePlanReport method ", e);
      dataChunkBuilder.setResponseStatus(
          StatusReply.newBuilder()
              .setStatus(FAILED)
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .build());
    } finally {
      responseObserver.onNext(dataChunkBuilder.build());
      responseObserver.onCompleted();
    }
  }

  @Override
  public void saveVoyageStatus(
      SaveVoyageStatusRequest request, StreamObserver<SaveVoyageStatusReply> responseObserver) {
    SaveVoyageStatusReply.Builder replyBuilder = SaveVoyageStatusReply.newBuilder();
    try {
      voyageService.saveVoyageStatus(request, replyBuilder);
    } catch (GenericServiceException e) {
      log.error("GenericServiceException when saving voyage status", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(e.getCode())
              .setMessage(e.getMessage())
              .setStatus(FAILED)
              .build());
    } catch (Exception e) {
      log.error("Error saving voyage status", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage("Error saving voyage status")
              .setStatus(FAILED)
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  /** Fetch the api and temp history for cargo and port ids if available */
  @Override
  public void getCargoApiTempHistory(
      CargoHistoryRequest request, StreamObserver<CargoHistoryReply> responseObserver) {
    com.cpdss.common.generated.LoadableStudy.CargoHistoryReply.Builder replyBuilder =
        CargoHistoryReply.newBuilder();
    try {
      cargoService.getCargoApiTempHistory(request, replyBuilder);
    } catch (Exception e) {
      log.error("Exception when fetching getCargoApiTempHistory", e);
      replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(FAILED));
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  @Override
  public void getAllCargoHistory(
      CargoHistoryRequest request, StreamObserver<CargoHistoryReply> responseObserver) {
    com.cpdss.common.generated.LoadableStudy.CargoHistoryReply.Builder replyBuilder =
        CargoHistoryReply.newBuilder();
    try {
      cargoService.getAllCargoHistory(request, replyBuilder);
    } catch (Exception e) {
      log.error("Exception when fetching getCargoApiTempHistory", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder().setMessage(e.getMessage()).setStatus(FAILED));
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  /** Save JSON to database */
  @Override
  public void saveJson(JsonRequest request, StreamObserver<StatusReply> responseObserver) {
    StatusReply.Builder replyBuilder = StatusReply.newBuilder();
    try {
      this.jsonDataService.saveJsonToDatabase(
          request.getReferenceId(), request.getJsonTypeId(), request.getJson());
      replyBuilder = StatusReply.newBuilder().setStatus(SUCCESS).setMessage(SUCCESS);
    } catch (Exception e) {
      log.error("Exception occured while trying to save JSON to database.", e);
      replyBuilder =
          StatusReply.newBuilder()
              .setStatus(FAILED)
              .setMessage(FAILED)
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR);
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  /**
   * Fetch Single Synoptic Data with DEP condition,
   *
   * @param request - LoadableStudy Id, LoadablePattern Id required
   * @param responseObserver - SynopticalTableReply with One SynopticalTable Data
   */
  @Override
  public void getSynopticDataByLoadableStudyId(
      com.cpdss.common.generated.LoadableStudy.SynopticalTableRequest request,
      StreamObserver<com.cpdss.common.generated.LoadableStudy.SynopticalTableReply>
          responseObserver) {

    SynopticalTableReply.Builder replyBuilder = SynopticalTableReply.newBuilder();
    log.info(
        "Synoptic DEP data for loadable study {}, loadable pattern {}",
        request.getLoadableStudyId(),
        request.getLoadablePatternId());
    try {
      synopticService.getSynopticDataByLoadableStudyId(request, replyBuilder);
    } catch (Exception e) {
      log.error("Exception while fetch Synoptic data", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder().setMessage(e.getMessage()).setStatus(FAILED));
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  @Override
  public void saveAlgoErrors(
      com.cpdss.common.generated.LoadableStudy.AlgoErrors request,
      StreamObserver<com.cpdss.common.generated.LoadableStudy.AlgoErrors> responseObserver) {
    algoErrorService.saveAlgoError(request, responseObserver);
  }

  @Override
  public void fetchAllAlgoErrors(
      com.cpdss.common.generated.LoadableStudy.AlgoErrors request,
      StreamObserver<com.cpdss.common.generated.LoadableStudy.AlgoErrors> responseObserver) {
    algoService.fetchAllErrors(request, responseObserver);
  }

  @Override
  public void getCargoHistoryByCargo(
      LatestCargoRequest request, StreamObserver<LatestCargoReply> responseObserver) {

    LatestCargoReply.Builder replyBuilder = LatestCargoReply.newBuilder();
    try {
      cargoService.getCargoHistoryByCargo(request, replyBuilder);
    } catch (Exception e) {
      log.error("Exception when latest api temp against port data", e);
      replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(FAILED));
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  @Override
  public void getActiveVoyagesByVessel(
      VoyageRequest request,
      StreamObserver<com.cpdss.common.generated.LoadableStudy.ActiveVoyage> responseObserver) {
    com.cpdss.common.generated.LoadableStudy.ActiveVoyage.Builder builder =
        com.cpdss.common.generated.LoadableStudy.ActiveVoyage.newBuilder();
    ResponseStatus.Builder repBuilder = ResponseStatus.newBuilder();
    try {
      if (request.getVesselId() > 0) {
        // Fetch and build Voayge Response Object
        this.voyageService.fetchActiveVoyageByVesselId(
            builder, request.getVesselId(), ACTIVE_VOYAGE_STATUS);
      }
      repBuilder.setStatus(SUCCESS);
      repBuilder.setHttpStatusCode(HttpStatusCode.OK.value());
    } catch (Exception e) {
      e.printStackTrace();
      log.error("Failed to fetch active voyage for, Vessel Id {}", request.getVesselId());
      repBuilder.setStatus(FAILED);
      repBuilder.setHttpStatusCode(HttpStatusCode.INTERNAL_SERVER_ERROR.value());
      repBuilder.setMessage(e.getMessage());
    } finally {
      builder.setResponseStatus(repBuilder.build());
      responseObserver.onNext(builder.build());
      responseObserver.onCompleted();
    }
  }

  @Override
  public void getSynopticDataForLoadingPlan(
      com.cpdss.common.generated.LoadableStudy.LoadingPlanIdRequest request,
      StreamObserver<com.cpdss.common.generated.LoadableStudy.LoadingPlanCommonResponse>
          responseObserver) {
    com.cpdss.common.generated.LoadableStudy.LoadingPlanCommonResponse.Builder builder =
        com.cpdss.common.generated.LoadableStudy.LoadingPlanCommonResponse.newBuilder();
    ResponseStatus.Builder repBuilder = ResponseStatus.newBuilder();
    try {
      log.info("RPC call to Get Synoptic Data For Operation Module");
      this.synopticService.fetchLoadingInformationSynopticDetails(request, builder, repBuilder);
    } catch (Exception e) {
      e.printStackTrace();
      log.error("Failed to Get Synoptic Record", request.getId());
      repBuilder.setStatus(FAILED);
      repBuilder.setHttpStatusCode(HttpStatusCode.INTERNAL_SERVER_ERROR.value());
      repBuilder.setMessage(e.getMessage());
    } finally {
      builder.setResponseStatus(repBuilder.build());
      responseObserver.onNext(builder.build());
      responseObserver.onCompleted();
    }
  }

  @Override
  public void saveLoadingInfoToSynopticData(
      com.cpdss.common.generated.LoadableStudy.LoadingInfoSynopticalUpdateRequest request,
      StreamObserver<ResponseStatus> responseObserver) {
    ResponseStatus.Builder builder = ResponseStatus.newBuilder();
    try {
      this.synopticService.saveLoadingInformationToSynopticalTable(request, builder);
    } catch (Exception e) {
      e.printStackTrace();
      log.error("Failed to Get Synoptic Record ", request.getSynopticalTableId());
      builder.setStatus(FAILED);
      builder.setHttpStatusCode(HttpStatusCode.INTERNAL_SERVER_ERROR.value());
      builder.setMessage(e.getMessage());
    } finally {
      responseObserver.onNext(builder.build());
      responseObserver.onCompleted();
    }
  }

  @Override
  @Transactional(rollbackFor = {RuntimeException.class, Exception.class})
  public void getOrSaveRulesForLoadableStudy(
      com.cpdss.common.generated.LoadableStudy.LoadableRuleRequest request,
      StreamObserver<com.cpdss.common.generated.LoadableStudy.LoadableRuleReply> responseObserver) {
    com.cpdss.common.generated.LoadableStudy.LoadableRuleReply.Builder builder =
        com.cpdss.common.generated.LoadableStudy.LoadableRuleReply.newBuilder();
    try {
      loadableStudyRuleService.getOrSaveRulesForLoadableStudy(request, builder);

    } catch (Exception e) {
      TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
      log.error("Exception in save or get loadable study rule", e);
      builder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage(e.getMessage())
              .setStatus(FAILED)
              .build());
    } finally {
      responseObserver.onNext(builder.build());
      responseObserver.onCompleted();
    }
  }

  @Override
  public void getLoadablePatternDetailsJson(
      LoadablePlanDetailsRequest request,
      StreamObserver<LoadablePatternPortWiseDetailsJson> responseObserver) {
    LoadablePatternPortWiseDetailsJson.Builder builder =
        LoadablePatternPortWiseDetailsJson.newBuilder();
    try {
      loadablePatternService.getLoadablePatternDetailsJson(request, builder);
    } catch (Exception e) {
      e.printStackTrace();
      log.error("Failed to Get Pattern Details ", request.getLoadablePatternId());
      builder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setStatus(FAILED)
              .setHttpStatusCode(HttpStatusCode.INTERNAL_SERVER_ERROR.value())
              .setMessage(e.getMessage())
              .build());
    } finally {
      responseObserver.onNext(builder.build());
      responseObserver.onCompleted();
    }
  }

  @Override
  public void getLoadablePatternByVoyageAndStatus(
      LoadableStudyRequest request,
      StreamObserver<com.cpdss.common.generated.LoadableStudy.LoadablePatternConfirmedReply>
          responseObserver) {
    com.cpdss.common.generated.LoadableStudy.LoadablePatternConfirmedReply.Builder builder =
        com.cpdss.common.generated.LoadableStudy.LoadablePatternConfirmedReply.newBuilder();
    try {
      loadablePatternService.getLoadablePatternByVoyageAndStatus(request, builder);
    } catch (GenericServiceException e) {
      builder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(e.getCode())
              .setMessage(e.getMessage())
              .setStatus(FAILED)
              .build());
    } finally {
      responseObserver.onNext(builder.build());
      responseObserver.onCompleted();
    }
  }

  @Override
  public void getCargoNominationByCargoNominationId(
      CargoNominationRequest request,
      StreamObserver<com.cpdss.common.generated.LoadableStudy.CargoNominationDetailReply>
          responseObserver) {
    com.cpdss.common.generated.LoadableStudy.CargoNominationDetailReply.Builder builder =
        com.cpdss.common.generated.LoadableStudy.CargoNominationDetailReply.newBuilder();
    try {
      cargoNominationService.getCargoNominationByCargoNominationId(request, builder);
    } catch (Exception e) {
      e.printStackTrace();
      builder.setResponseStatus(ResponseStatus.newBuilder().setStatus(FAILED).build());
    } finally {
      responseObserver.onNext(builder.build());
      responseObserver.onCompleted();
    }
  }

  public com.cpdss.common.generated.CargoInfo.CargoDetailReply getCargoInfoById(
      CargoRequest build) {
    return cargoInfoGrpcService.getCargoInfoById(build);
  }

  @Override
  public void getLoadableCommingleByPatternId(
      LoadablePlanDetailsRequest request,
      StreamObserver<com.cpdss.common.generated.LoadableStudy.LoadableCommingleDetailsReply>
          responseObserver) {

    com.cpdss.common.generated.LoadableStudy.LoadableCommingleDetailsReply.Builder builder =
        com.cpdss.common.generated.LoadableStudy.LoadableCommingleDetailsReply.newBuilder();
    try {
      loadablePatternService.getLoadableCommingleByPatternId(request, builder);
    } catch (Exception e) {
      e.printStackTrace();
      builder.setResponseStatus(ResponseStatus.newBuilder().setStatus(FAILED).build());
    } finally {
      responseObserver.onNext(builder.build());
      responseObserver.onCompleted();
    }
  }

  public PortInfo.PortReply GetPortInfo(PortInfo.PortRequest build) {
    return portInfoGrpcService.getPortInfo(build);
  }

  @Override
  public void getLoadableStudyShore(
      com.cpdss.common.generated.LoadableStudy.LoadableStudyShoreRequest request,
      StreamObserver<com.cpdss.common.generated.LoadableStudy.LoadableStudyShoreResponse>
          responseObserver) {

    com.cpdss.common.generated.LoadableStudy.LoadableStudyShoreResponse.Builder builder =
        com.cpdss.common.generated.LoadableStudy.LoadableStudyShoreResponse.newBuilder();

    try {
      loadableStudyPortRotationService.getLoadableStudyShore(request, builder);
    } catch (Exception e) {
      e.printStackTrace();
      builder.setResponseStatus(ResponseStatus.newBuilder().setStatus(FAILED).build());
    } finally {
      responseObserver.onNext(builder.build());
      responseObserver.onCompleted();
    }
  }

  @Override
  public void getLoadableStudyPortRotationByPortRotationId(
      PortRotationRequest request, StreamObserver<PortRotationDetailReply> responseObserver) {
    PortRotationDetailReply.Builder builder = PortRotationDetailReply.newBuilder();
    try {
      loadableStudyPortRotationService.getPortRotationByPortRotationId(request, builder);
      builder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS).build());
    } catch (Exception e) {
      e.printStackTrace();
      builder.setResponseStatus(ResponseStatus.newBuilder().setStatus(FAILED).build());
    } finally {
      responseObserver.onNext(builder.build());
      responseObserver.onCompleted();
    }
  }

  @Override
  public void getLoadableStudySimulatorJsonData(
      com.cpdss.common.generated.LoadableStudy.SimulatorJsonRequest request,
      StreamObserver<com.cpdss.common.generated.LoadableStudy.SimulatorJsonReply>
          responseObserver) {
    com.cpdss.common.generated.LoadableStudy.SimulatorJsonReply.Builder builder =
        com.cpdss.common.generated.LoadableStudy.SimulatorJsonReply.newBuilder();
    try {
      builder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS).build());
      Object departureCondition = null;
      JsonData jsonData =
          this.jsonDataService.getJsonData(request.getLoadableStudyId(), ALGO_RESPONSE_ID);
      if (jsonData != null) {
        String algoJsonString = jsonData.getJsonData();
        LoadableStudyAlgoJson algoJson =
            new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .readValue(algoJsonString, LoadableStudyAlgoJson.class);
        Optional<LoadablePlanDetailsAlgoJson> loadablePlanDetails =
            algoJson.getLoadablePlanDetails().stream()
                .filter(
                    loadablePlanDetailsAlgoJson ->
                        loadablePlanDetailsAlgoJson.getCaseNumber().equals(request.getCaseNumber()))
                .findFirst();
        if (loadablePlanDetails.isPresent()) {
          List<Long> portRotationIds =
              loadablePlanDetails.get().getLoadablePlanPortWiseDetails().stream()
                  .map(LoadablePlanPortWiseDetailsAlgoJson::getPortRotationId)
                  .collect(Collectors.toList());
          List<Long> operationIds =
              this.loadableStudyPortRotationRepository.findByIdIn(portRotationIds);
          if (operationIds.size() > 0 && operationIds.contains(LOADING_OPERATION_ID)) {
            departureCondition =
                loadablePlanDetails
                    .get()
                    .getLoadablePlanPortWiseDetails()
                    .get(0)
                    .getDepartureCondition();
          }
        }
      }
      ObjectMapper mapper = new ObjectMapper();
      String departureConditionString = mapper.writeValueAsString(departureCondition);
      builder.setDepartureCondition(departureConditionString);
    } catch (Exception e) {
      e.printStackTrace();
      builder.setResponseStatus(ResponseStatus.newBuilder().setStatus(FAILED).build());
    } finally {
      responseObserver.onNext(builder.build());
      responseObserver.onCompleted();
    }
  }

  @Override
  public void getUllage(
      UpdateUllageRequest request, StreamObserver<UpdateUllageReply> responseObserver) {
    log.info("Inside get getUllage in loadable study micro service");
    UpdateUllageReply.Builder replyBuilder = UpdateUllageReply.newBuilder();
    try {
      loadablePlanService.getUllage(request, replyBuilder);
    } catch (GenericServiceException e) {
      log.error("GenericServiceException in get ullage", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(e.getCode())
              .setMessage(e.getMessage())
              .setStatus(FAILED)
              .build());
    } catch (Exception e) {
      log.error("Exception in update ullage", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage(e.getMessage())
              .setStatus(FAILED)
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  @Override
  public void updateDischargeQuantityCargoDetails(
      DischargeQuantityCargoDetailsRequest request,
      StreamObserver<ResponseStatus> responseObserver) {
    log.info("Inside get getUllage in loadable study micro service");
    ResponseStatus.Builder replyBuilder = ResponseStatus.newBuilder();
    try {
      List<Long> cargoIdsToUpdate =
          request.getCargoDetailsList().stream()
              .map(DischargeQuantityCargoDetails::getId)
              .collect(Collectors.toList());
      List<DischargePatternQuantityCargoPortwiseDetails> cargoDetailsToUpdate =
          dischargePatternQuantityCargoPortwiseRepository.findByIdIn(cargoIdsToUpdate);
      if (cargoDetailsToUpdate.isEmpty()) {
        throw new GenericServiceException(
            "cargo details ids are not coprrect",
            CommonErrorCodes.E_HTTP_BAD_REQUEST,
            HttpStatusCode.BAD_REQUEST);
      }
      Map<Long, DischargePatternQuantityCargoPortwiseDetails> cargoDetails =
          cargoDetailsToUpdate.stream()
              .collect(
                  Collectors.toMap(
                      DischargePatternQuantityCargoPortwiseDetails::getId, detail -> detail));
      request.getCargoDetailsList().stream()
          .forEach(
              dischargeCargo -> {
                DischargePatternQuantityCargoPortwiseDetails dischargeCargoDetail =
                    cargoDetails.get(dischargeCargo.getId());
                dischargeCargoDetail.setIsCommingled(dischargeCargo.getIsCommingled());
                dischargeCargoDetail.setIfProtested(dischargeCargo.getIfProtested());
                Optional.ofNullable(dischargeCargo.getSlopQuantity())
                    .ifPresent(
                        value -> dischargeCargoDetail.setSlopQuantity(new BigDecimal(value)));
              });
      dischargePatternQuantityCargoPortwiseRepository.saveAll(cargoDetailsToUpdate);

    } catch (GenericServiceException e) {
      log.error("GenericServiceException in get ullage", e);
      replyBuilder.setCode(e.getCode()).setMessage(e.getMessage()).setStatus(FAILED).build();
    } catch (Exception e) {
      log.error("Exception in update ullage", e);
      replyBuilder
          .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
          .setMessage(e.getMessage())
          .setStatus(FAILED)
          .build();
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  @Override
  public void getLoadingSimulatorJsonData(
      com.cpdss.common.generated.LoadableStudy.LoadingSimulatorJsonRequest request,
      StreamObserver<com.cpdss.common.generated.LoadableStudy.LoadingSimulatorJsonReply>
          responseObserver) {
    com.cpdss.common.generated.LoadableStudy.LoadingSimulatorJsonReply.Builder builder =
        com.cpdss.common.generated.LoadableStudy.LoadingSimulatorJsonReply.newBuilder();
    try {
      builder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS).build());
      String loadicatorJsonString = "";
      String loadingJsonString = "";
      JsonData jsonData =
          this.jsonDataService.getJsonData(request.getInfoId(), LOADICATOR_RESPONSE_ID);
      if (jsonData != null) {
        loadicatorJsonString = jsonData.getJsonData();
      }
      jsonData = this.jsonDataService.getJsonData(request.getInfoId(), LOADING_RESPONSE_ID);
      if (jsonData != null) {
        loadingJsonString = jsonData.getJsonData();
      }

      builder.setLoadicatorJson(loadicatorJsonString);
      builder.setLoadingJson(loadingJsonString);
    } catch (Exception e) {
      e.printStackTrace();
      builder.setResponseStatus(ResponseStatus.newBuilder().setStatus(FAILED).build());
    } finally {
      responseObserver.onNext(builder.build());
      responseObserver.onCompleted();
    }
  }

  public void getVoyage(
      com.cpdss.common.generated.LoadableStudy.VoyageActivateRequest request,
      StreamObserver<com.cpdss.common.generated.LoadableStudy.VoyageActivateReply>
          responseObserver) {
    com.cpdss.common.generated.LoadableStudy.VoyageActivateReply.Builder replyBuilder =
        com.cpdss.common.generated.LoadableStudy.VoyageActivateReply.newBuilder();

    // Optional<Voyage> voyageEntity = voyageRepository.findById(request.getId());
    String voyage = voyageRepository.getVoyagebyId(request.getId());
    log.info("voyage get:{}", voyage);
    if (StringUtils.hasLength(voyage)) {
      JsonObject voyageObj =
          JsonParser.parseString(voyage).getAsJsonArray().get(0).getAsJsonObject();
      Long voyageId = voyageObj.get("id").getAsLong();
      Long voyageStatus = voyageObj.get("voyage_status").getAsLong();
      // Voyage voyage = voyageEntity.get();
      com.cpdss.common.generated.LoadableStudy.VoyageActivateRequest.Builder builder =
          com.cpdss.common.generated.LoadableStudy.VoyageActivateRequest.newBuilder();
      builder.setId(voyageId);
      Optional.ofNullable(voyageStatus).ifPresent(builder::setVoyageStatus);
      replyBuilder.setVoyageActivateRequest(builder.build());
      replyBuilder.setResponseStatus(Common.ResponseStatus.newBuilder().setStatus(SUCCESS).build());
    } else {
      replyBuilder.setResponseStatus(
          Common.ResponseStatus.newBuilder().setMessage("No Voyage Found").build());
    }
    responseObserver.onNext(replyBuilder.build());
    responseObserver.onCompleted();
  }

  public void saveActivatedVoyage(
      com.cpdss.common.generated.LoadableStudy.VoyageActivateRequest request,
      StreamObserver<com.cpdss.common.generated.LoadableStudy.VoyageActivateReply>
          responseObserver) {
    com.cpdss.common.generated.LoadableStudy.VoyageActivateReply.Builder replyBuilder =
        com.cpdss.common.generated.LoadableStudy.VoyageActivateReply.newBuilder();

    try {
      Optional<Voyage> voyageEntity = voyageRepository.findById(request.getId());
      if (voyageEntity.isPresent()) {
        Voyage voyage = voyageEntity.get();
        log.info("Voayge get:{}", voyage);
        try {
          Long vesselId = voyage.getVesselXId();
          List<Voyage> voyageList = voyageRepository.findByVesselXIdAndVoyageStatusId(vesselId, 3L);
          Optional<VoyageStatus> voyageStatus = voyageStatusRepository.findById(2L);
          for (Voyage v : voyageList) {
            v.setVoyageStatus(voyageStatus.get());
          }
          voyageRepository.saveAll(voyageList);
          // log.info("vesselId get:{}", vesselId);
          // voyageRepository.deActivateAllVoyageByVesselId(vesselId, 2L, 3L);
          log.info("Deactivated voyages against this vesselId:{}", voyageList);
        } catch (Exception e) {
          log.error("Error occurred when deactivating voyages against vessel", e);
        }
        Optional<VoyageStatus> voyageStatus =
            voyageStatusRepository.findById(request.getVoyageStatus());
        if (voyageStatus.isPresent()) {
          voyage.setVoyageStatus(voyageStatus.get());
          voyageRepository.save(voyage);
          log.info("Voyage activated:{}", voyage);
          replyBuilder.setResponseStatus(
              Common.ResponseStatus.newBuilder().setStatus(SUCCESS).build());
        }
      }
    } catch (ResourceAccessException e) {
      e.printStackTrace();
      replyBuilder.setResponseStatus(
          Common.ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage(e.getMessage())
              .setStatus(FAILED_WITH_RESOURCE_EXC)
              .build());
    } catch (Exception e) {
      e.printStackTrace();
      replyBuilder.setResponseStatus(
          Common.ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage(e.getMessage())
              .setStatus(FAILED_WITH_EXC)
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  public void getLoadablePatternForCommunication(
      com.cpdss.common.generated.LoadableStudy.LoadableStudyPatternCommunicationRequest request,
      StreamObserver<
              com.cpdss.common.generated.LoadableStudy.LoadableStudyPatternCommunicationReply>
          responseObserver) {
    com.cpdss.common.generated.LoadableStudy.LoadableStudyPatternCommunicationReply.Builder
        replyBuilder =
            com.cpdss.common.generated.LoadableStudy.LoadableStudyPatternCommunicationReply
                .newBuilder();

    String loadablePattern = loadablePatternRepository.getLoadablePatternWithId(request.getId());
    if (loadablePattern != null) {
      replyBuilder.setDataJson(loadablePattern);
      replyBuilder.setResponseStatus(Common.ResponseStatus.newBuilder().setStatus(SUCCESS).build());
    } else {
      replyBuilder.setResponseStatus(
          Common.ResponseStatus.newBuilder().setMessage("No LoadablePattern Found").build());
    }
    responseObserver.onNext(replyBuilder.build());
    responseObserver.onCompleted();
  }

  public void getLoadicatorDataSynopticalForCommunication(
      com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationRequest request,
      StreamObserver<com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationReply>
          responseObserver) {
    com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationReply.Builder replyBuilder =
        com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationReply.newBuilder();

    String loadicatorDataForSynoptical =
        synopticalTableLoadicatorDataRepository
            .getSynopticalTableLoadicatorDataWithLoadablePatternId(request.getId());
    if (loadicatorDataForSynoptical != null) {
      replyBuilder.setDataJson(loadicatorDataForSynoptical);
      replyBuilder.setResponseStatus(Common.ResponseStatus.newBuilder().setStatus(SUCCESS).build());
    } else {
      replyBuilder.setResponseStatus(
          Common.ResponseStatus.newBuilder()
              .setMessage("No SynopticalTableLoadicatorData Found")
              .build());
    }
    responseObserver.onNext(replyBuilder.build());
    responseObserver.onCompleted();
  }

  public void saveLoadablePatternForCommunication(
      com.cpdss.common.generated.LoadableStudy.LoadableStudyPatternCommunicationRequest request,
      StreamObserver<
              com.cpdss.common.generated.LoadableStudy.LoadableStudyPatternCommunicationReply>
          responseObserver) {
    com.cpdss.common.generated.LoadableStudy.LoadableStudyPatternCommunicationReply.Builder
        replyBuilder =
            com.cpdss.common.generated.LoadableStudy.LoadableStudyPatternCommunicationReply
                .newBuilder();
    try {
      loadableStudyCommunicationData.saveLoadablePattern(request.getDataJson());
      replyBuilder.setResponseStatus(Common.ResponseStatus.newBuilder().setStatus(SUCCESS).build());
    } catch (ResourceAccessException e) {
      e.printStackTrace();
      replyBuilder.setResponseStatus(
          Common.ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage(e.getMessage())
              .setStatus(FAILED_WITH_RESOURCE_EXC)
              .build());
    } catch (Exception e) {
      e.printStackTrace();
      replyBuilder.setResponseStatus(
          Common.ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage(e.getMessage())
              .setStatus(FAILED_WITH_EXC)
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  public void saveLoadicatorDataSynopticalForCommunication(
      com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationRequest request,
      StreamObserver<com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationReply>
          responseObserver) {
    com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationReply.Builder replyBuilder =
        com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationReply.newBuilder();
    try {
      loadableStudyCommunicationData.saveSynopticalTableLoadicatorData(request.getDataJson());
      replyBuilder.setResponseStatus(Common.ResponseStatus.newBuilder().setStatus(SUCCESS).build());
    } catch (ResourceAccessException e) {
      e.printStackTrace();
      replyBuilder.setResponseStatus(
          Common.ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage(e.getMessage())
              .setStatus(FAILED_WITH_RESOURCE_EXC)
              .build());
    } catch (Exception e) {
      e.printStackTrace();
      replyBuilder.setResponseStatus(
          Common.ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage(e.getMessage())
              .setStatus(FAILED_WITH_EXC)
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  /**
   * Fetching Voyage using voyageId
   *
   * @param request
   * @param responseObserver
   */
  @Override
  public void getVoyageByVoyageId(
      com.cpdss.common.generated.LoadableStudy.VoyageInfoRequest request,
      StreamObserver<com.cpdss.common.generated.LoadableStudy.VoyageInfoReply> responseObserver) {
    com.cpdss.common.generated.LoadableStudy.VoyageInfoReply.Builder replyBuilder =
        com.cpdss.common.generated.LoadableStudy.VoyageInfoReply.newBuilder();
    try {
      this.voyageService.getVoyageByVoyageId(request, replyBuilder);
    } catch (Exception e) {
      log.error("Error in getting Voyage ", e);
      replyBuilder.setResponseStatus(
          Common.ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage(e.getMessage())
              .setStatus(FAILED)
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  /**
   * get json Data for loadingplan communication
   *
   * @param request
   * @param responseObserver
   */
  public void getJsonDataForCommunication(
      com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationRequest request,
      StreamObserver<com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationReply>
          responseObserver) {
    com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationReply.Builder replyBuilder =
        com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationReply.newBuilder();
    try {
      log.info("json data request:{}", request.getId());
      String jsonData = jsonDataRepository.getJsonDataWithLoadingInfoId(request.getId());
      if (jsonData != null) {
        log.info("json data get:{}", jsonData.length());
        replyBuilder.setDataJson(jsonData);
        replyBuilder.setResponseStatus(
            Common.ResponseStatus.newBuilder().setStatus(SUCCESS).build());
      } else {
        replyBuilder.setResponseStatus(
            Common.ResponseStatus.newBuilder().setMessage("No JsonData Found").build());
      }
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    } catch (Exception e) {
      log.error("Error occurred when get json data", e);
    }
  }

  /**
   * save json Data for loadingplan/dischargeplan communication
   *
   * @param request
   * @param responseObserver
   */
  public void saveJsonDataForCommunication(
      com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationRequest request,
      StreamObserver<com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationReply>
          responseObserver) {
    com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationReply.Builder replyBuilder =
        com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationReply.newBuilder();
    try {
      loadableStudyCommunicationData.saveJsonDataForCommunication(request.getDataJson());
      replyBuilder.setResponseStatus(Common.ResponseStatus.newBuilder().setStatus(SUCCESS).build());
    } catch (ResourceAccessException e) {
      e.printStackTrace();
      replyBuilder.setResponseStatus(
          Common.ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage(e.getMessage())
              .setStatus(FAILED_WITH_RESOURCE_EXC)
              .build());
    } catch (Exception e) {
      e.printStackTrace();
      replyBuilder.setResponseStatus(
          Common.ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage(e.getMessage())
              .setStatus(FAILED_WITH_EXC)
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  /**
   * get SynopticalTable Data for loadingplan communication
   *
   * @param request
   * @param responseObserver
   */
  public void getSynopticalDataForCommunication(
      com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationRequest request,
      StreamObserver<com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationReply>
          responseObserver) {
    com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationReply.Builder replyBuilder =
        com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationReply.newBuilder();

    String synopticalTableData =
        synopticalTableRepository.getSynopticalTableDataWithId(request.getId());
    if (synopticalTableData != null) {
      replyBuilder.setDataJson(synopticalTableData);
      replyBuilder.setResponseStatus(Common.ResponseStatus.newBuilder().setStatus(SUCCESS).build());
    } else {
      replyBuilder.setResponseStatus(
          Common.ResponseStatus.newBuilder().setMessage("No SynopticalTableData Found").build());
    }
    responseObserver.onNext(replyBuilder.build());
    responseObserver.onCompleted();
  }

  /**
   * save SynopticalTable Data for loadingplan communication
   *
   * @param request
   * @param responseObserver
   */
  public void saveSynopticalDataForCommunication(
      com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationRequest request,
      StreamObserver<com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationReply>
          responseObserver) {
    com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationReply.Builder replyBuilder =
        com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationReply.newBuilder();
    try {
      loadableStudyCommunicationData.saveSynopticalTableData(request.getDataJson());
      replyBuilder.setResponseStatus(Common.ResponseStatus.newBuilder().setStatus(SUCCESS).build());
    } catch (ResourceAccessException e) {
      e.printStackTrace();
      replyBuilder.setResponseStatus(
          Common.ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage(e.getMessage())
              .setStatus(FAILED_WITH_RESOURCE_EXC)
              .build());
    } catch (Exception e) {
      e.printStackTrace();
      replyBuilder.setResponseStatus(
          Common.ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage(e.getMessage())
              .setStatus(FAILED_WITH_EXC)
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  /**
   * get LoadableStudyPortRotation Data for loadingplan communication
   *
   * @param request
   * @param responseObserver
   */
  public void getLoadableStudyPortRotationDataForCommunication(
      com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationRequest request,
      StreamObserver<com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationReply>
          responseObserver) {
    com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationReply.Builder replyBuilder =
        com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationReply.newBuilder();
    log.info("Inside getLoadableStudyPortRotationDataForCommunication method");
    String loadableStudyPortRotationData = null;
    log.info("portXid:{} and patternId:{}", request.getId(), request.getLoadablePatternId());
    Optional<LoadablePattern> loadablePattern =
        loadablePatternRepository.findById(request.getLoadablePatternId());
    if (loadablePattern.isPresent()) {
      Long loadableStudyId = loadablePattern.get().getLoadableStudy().getId();
      log.info("portXid:{} and loadableStudyId:{}", request.getId(), loadableStudyId);
      loadableStudyPortRotationData =
          loadableStudyPortRotationRepository.getLoadableStudyPortRotation(loadableStudyId);
    }
    if (loadableStudyPortRotationData != null) {
      replyBuilder.setDataJson(loadableStudyPortRotationData);
      replyBuilder.setResponseStatus(Common.ResponseStatus.newBuilder().setStatus(SUCCESS).build());
    } else {
      replyBuilder.setResponseStatus(
          Common.ResponseStatus.newBuilder()
              .setMessage("No LoadableStudyPortRotation Found")
              .build());
    }
    responseObserver.onNext(replyBuilder.build());
    responseObserver.onCompleted();
  }

  /**
   * save LoadableStudyPortRotation Data for loadingplan communication
   *
   * @param request
   * @param responseObserver
   */
  public void saveLoadableStudyPortRotationDataForCommunication(
      com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationRequest request,
      StreamObserver<com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationReply>
          responseObserver) {
    com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationReply.Builder replyBuilder =
        com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationReply.newBuilder();
    try {
      loadableStudyCommunicationData.saveLoadableStudyPortRotationData(request.getDataJson());
      replyBuilder.setResponseStatus(Common.ResponseStatus.newBuilder().setStatus(SUCCESS).build());
    } catch (ResourceAccessException e) {
      e.printStackTrace();
      replyBuilder.setResponseStatus(
          Common.ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage(e.getMessage())
              .setStatus(FAILED_WITH_RESOURCE_EXC)
              .build());
    } catch (Exception e) {
      e.printStackTrace();
      replyBuilder.setResponseStatus(
          Common.ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage(e.getMessage())
              .setStatus(FAILED_WITH_EXC)
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  /**
   * get json Data for DischargePlan communication
   *
   * @param request
   * @param responseObserver
   */
  public void getJsonDataForDischargePlanCommunication(
      com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationRequest request,
      StreamObserver<com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationReply>
          responseObserver) {
    com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationReply.Builder replyBuilder =
        com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationReply.newBuilder();
    try {
      log.info("json data request:{}", request.getId());
      String jsonData = jsonDataRepository.getJsonDataWithReferenceId(request.getId());
      if (jsonData != null) {
        log.info("json data get:{}", jsonData.length());
        replyBuilder.setDataJson(jsonData);
        replyBuilder.setResponseStatus(
            Common.ResponseStatus.newBuilder().setStatus(SUCCESS).build());
      } else {
        replyBuilder.setResponseStatus(
            Common.ResponseStatus.newBuilder().setMessage("No JsonData Found").build());
      }
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    } catch (Exception e) {
      log.error("Error occurred when get json data", e);
    }
  }

  /**
   * Checking if cargo is used in any cargo nomination
   *
   * @param request
   * @param responseObserver
   */
  @Override
  public void checkCargoUsage(
      com.cpdss.common.generated.LoadableStudy.CargoNominationCheckRequest request,
      StreamObserver<com.cpdss.common.generated.LoadableStudy.CargoNominationCheckReply>
          responseObserver) {
    com.cpdss.common.generated.LoadableStudy.CargoNominationCheckReply.Builder replyBuilder =
        com.cpdss.common.generated.LoadableStudy.CargoNominationCheckReply.newBuilder();
    try {
      this.cargoService.checkCargoUsage(request, replyBuilder);
      replyBuilder.setResponseStatus(Common.ResponseStatus.newBuilder().setStatus(SUCCESS).build());
    } catch (GenericServiceException e) {
      e.printStackTrace();
      replyBuilder.setResponseStatus(
          Common.ResponseStatus.newBuilder()
              .setCode(e.getCode())
              .setHttpStatusCode(e.getStatus().value())
              .setMessage(e.getMessage())
              .setStatus(FAILED)
              .build());
    } catch (Exception e) {
      e.printStackTrace();
      replyBuilder.setResponseStatus(
          Common.ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage(e.getMessage())
              .setStatus(FAILED_WITH_EXC)
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  /**
   * get LoadablePlanStowageBallastDetails Data for LoadingPlan Ullage edit communication
   *
   * @param request
   * @param responseObserver
   */
  public void getLoadablePlanStowageBallastDetailsForCommunication(
      com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationRequest request,
      StreamObserver<com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationReply>
          responseObserver) {
    com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationReply.Builder replyBuilder =
        com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationReply.newBuilder();
    try {
      log.info("LoadablePlanStowageBallastDetails request:{}", request.getId());
      String loadablePlanStowageBallastDetailsData =
          loadablePlanStowageBallastDetailsRepository
              .getLoadablePlanStowageBallastDetailsDataWithPatternId(request.getId());
      if (loadablePlanStowageBallastDetailsData != null) {
        log.info(
            "LoadablePlanStowageBallastDetails get:{}",
            loadablePlanStowageBallastDetailsData.length());
        replyBuilder.setDataJson(loadablePlanStowageBallastDetailsData);
        replyBuilder.setResponseStatus(
            Common.ResponseStatus.newBuilder().setStatus(SUCCESS).build());
      } else {
        replyBuilder.setResponseStatus(
            Common.ResponseStatus.newBuilder()
                .setMessage("No LoadablePlanStowageBallastDetails Found")
                .build());
      }
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    } catch (Exception e) {
      log.error("Error occurred when get LoadablePlanStowageBallastDetails data", e);
      replyBuilder.setResponseStatus(
          Common.ResponseStatus.newBuilder()
              .setMessage("Error occurred when get LoadablePlanStowageBallastDetails")
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .build());
    }
  }

  /**
   * get LoadablePatternCargoDetails Data for LoadingPlan Ullage edit communication
   *
   * @param request
   * @param responseObserver
   */
  public void getLoadablePatternCargoDetailsForCommunication(
      com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationRequest request,
      StreamObserver<com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationReply>
          responseObserver) {
    com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationReply.Builder replyBuilder =
        com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationReply.newBuilder();
    try {
      log.info("LoadablePatternCargoDetails request:{}", request.getId());
      String loadablePatternCargoDetailsData =
          loadablePatternCargoDetailsRepository.getLoadablePatternCargoDetailsWithPatternId(
              request.getId());
      if (loadablePatternCargoDetailsData != null) {
        log.info("LoadablePatternCargoDetails get:{}", loadablePatternCargoDetailsData.length());
        replyBuilder.setDataJson(loadablePatternCargoDetailsData);
        replyBuilder.setResponseStatus(
            Common.ResponseStatus.newBuilder().setStatus(SUCCESS).build());
      } else {
        replyBuilder.setResponseStatus(
            Common.ResponseStatus.newBuilder()
                .setMessage("No LoadablePatternCargoDetails Found")
                .build());
      }
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    } catch (Exception e) {
      log.error("Error occurred when get LoadablePatternCargoDetails data", e);
      replyBuilder.setResponseStatus(
          Common.ResponseStatus.newBuilder()
              .setMessage("Error occurred when get LoadablePatternCargoDetails")
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .build());
    }
  }

  /**
   * get LoadablePlanComminglePortwiseDetails Data for LoadingPlan Ullage edit communication
   *
   * @param request
   * @param responseObserver
   */
  public void getLoadablePlanCommingleDetailsPortwiseForCommunication(
      com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationRequest request,
      StreamObserver<com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationReply>
          responseObserver) {
    com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationReply.Builder replyBuilder =
        com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationReply.newBuilder();
    try {
      log.info("LoadablePlanComminglePortwiseDetails request:{}", request.getId());
      String loadablePlanComminglePortwiseDetailsData =
          loadablePlanCommingleDetailsPortwiseRepository
              .getLoadablePlanComminglePortwiseDetaWithPatternId(request.getId());
      if (loadablePlanComminglePortwiseDetailsData != null) {
        log.info(
            "LoadablePlanComminglePortwiseDetails get:{}",
            loadablePlanComminglePortwiseDetailsData.length());
        replyBuilder.setDataJson(loadablePlanComminglePortwiseDetailsData);
        replyBuilder.setResponseStatus(
            Common.ResponseStatus.newBuilder().setStatus(SUCCESS).build());
      } else {
        replyBuilder.setResponseStatus(
            Common.ResponseStatus.newBuilder()
                .setMessage("No LoadablePlanComminglePortwiseDetails Found")
                .build());
      }
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    } catch (Exception e) {
      log.error("Error occurred when get LoadablePlanComminglePortwiseDetails data", e);
      replyBuilder.setResponseStatus(
          Common.ResponseStatus.newBuilder()
              .setMessage("Error occurred when get LoadablePlanComminglePortwiseDetails")
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .build());
    }
  }

  /**
   * get OnBoardQuantity Data for LoadingPlan Ullage edit communication
   *
   * @param request
   * @param responseObserver
   */
  public void getOnBoardQuantityForCommunication(
      com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationRequest request,
      StreamObserver<com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationReply>
          responseObserver) {
    com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationReply.Builder replyBuilder =
        com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationReply.newBuilder();
    try {
      log.info("OnBoardQuantity request:{}", request.getId());
      String onBoardQuantityData =
          onBoardQuantityRepository.getOnBoardQuantityWithPatternId(request.getId());
      if (onBoardQuantityData != null) {
        log.info("OnBoardQuantity get:{}", onBoardQuantityData.length());
        replyBuilder.setDataJson(onBoardQuantityData);
        replyBuilder.setResponseStatus(
            Common.ResponseStatus.newBuilder().setStatus(SUCCESS).build());
      } else {
        replyBuilder.setResponseStatus(
            Common.ResponseStatus.newBuilder().setMessage("No OnBoardQuantity Found").build());
      }
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    } catch (Exception e) {
      log.error("Error occurred when get OnBoardQuantity data", e);
      replyBuilder.setResponseStatus(
          Common.ResponseStatus.newBuilder()
              .setMessage("Error occurred when get OnBoardQuantity")
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .build());
    }
  }

  /**
   * get OnHandQuantity Data for LoadingPlan Ullage edit communication
   *
   * @param request
   * @param responseObserver
   */
  public void getOnHandQuantityForCommunication(
      com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationRequest request,
      StreamObserver<com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationReply>
          responseObserver) {
    com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationReply.Builder replyBuilder =
        com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationReply.newBuilder();
    try {
      log.info("OnHandQuantity request:{}", request.getId());
      String onHandQuantityData =
          onHandQuantityRepository.getOnHandQuantityWithPatternId(request.getId());
      if (onHandQuantityData != null) {
        log.info("OnHandQuantity get:{}", onHandQuantityData.length());
        replyBuilder.setDataJson(onHandQuantityData);
        replyBuilder.setResponseStatus(
            Common.ResponseStatus.newBuilder().setStatus(SUCCESS).build());
      } else {
        replyBuilder.setResponseStatus(
            Common.ResponseStatus.newBuilder().setMessage("No OnHandQuantity Found").build());
      }
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    } catch (Exception e) {
      log.error("Error occurred when get OnHandQuantity data", e);
      replyBuilder.setResponseStatus(
          Common.ResponseStatus.newBuilder()
              .setMessage("Error occurred when get OnHandQuantity")
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .build());
    }
  }

  /**
   * save LoadablePlanStowageBallastDetails Data for loadingplan ullage update communication
   *
   * @param request
   * @param responseObserver
   */
  public void saveLoadablePlanStowageBallastDetailsForCommunication(
      com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationRequest request,
      StreamObserver<com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationReply>
          responseObserver) {
    com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationReply.Builder replyBuilder =
        com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationReply.newBuilder();
    try {
      loadableStudyCommunicationData.saveLoadablePlanStowageBallastDetails(request.getDataJson());
      replyBuilder.setResponseStatus(Common.ResponseStatus.newBuilder().setStatus(SUCCESS).build());
    } catch (ResourceAccessException e) {
      e.printStackTrace();
      replyBuilder.setResponseStatus(
          Common.ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage(e.getMessage())
              .setStatus(FAILED_WITH_RESOURCE_EXC)
              .build());
    } catch (Exception e) {
      e.printStackTrace();
      replyBuilder.setResponseStatus(
          Common.ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage(e.getMessage())
              .setStatus(FAILED_WITH_EXC)
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  /**
   * save LoadablePatternCargoDetails Data for loadingplan ullage update communication
   *
   * @param request
   * @param responseObserver
   */
  public void saveLoadablePatternCargoDetailsForCommunication(
      com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationRequest request,
      StreamObserver<com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationReply>
          responseObserver) {
    com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationReply.Builder replyBuilder =
        com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationReply.newBuilder();
    try {
      loadableStudyCommunicationData.saveLoadablePatternCargoDetails(request.getDataJson());
      replyBuilder.setResponseStatus(Common.ResponseStatus.newBuilder().setStatus(SUCCESS).build());
    } catch (ResourceAccessException e) {
      e.printStackTrace();
      replyBuilder.setResponseStatus(
          Common.ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage(e.getMessage())
              .setStatus(FAILED_WITH_RESOURCE_EXC)
              .build());
    } catch (Exception e) {
      e.printStackTrace();
      replyBuilder.setResponseStatus(
          Common.ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage(e.getMessage())
              .setStatus(FAILED_WITH_EXC)
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  /**
   * save LoadablePlanCommingleDetailsPortwise Data for loadingplan ullage update communication
   *
   * @param request
   * @param responseObserver
   */
  public void saveLoadablePlanCommingleDetailsPortwiseForCommunication(
      com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationRequest request,
      StreamObserver<com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationReply>
          responseObserver) {
    com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationReply.Builder replyBuilder =
        com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationReply.newBuilder();
    try {
      loadableStudyCommunicationData.saveLoadablePlanCommingleDetailsPortwise(
          request.getDataJson());
      replyBuilder.setResponseStatus(Common.ResponseStatus.newBuilder().setStatus(SUCCESS).build());
    } catch (ResourceAccessException e) {
      e.printStackTrace();
      replyBuilder.setResponseStatus(
          Common.ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage(e.getMessage())
              .setStatus(FAILED_WITH_RESOURCE_EXC)
              .build());
    } catch (Exception e) {
      e.printStackTrace();
      replyBuilder.setResponseStatus(
          Common.ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage(e.getMessage())
              .setStatus(FAILED_WITH_EXC)
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  /**
   * save OnBoardQuantity Data for loadingplan ullage update communication
   *
   * @param request
   * @param responseObserver
   */
  public void saveOnBoardQuantityForCommunication(
      com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationRequest request,
      StreamObserver<com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationReply>
          responseObserver) {
    com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationReply.Builder replyBuilder =
        com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationReply.newBuilder();
    try {
      loadableStudyCommunicationData.saveOnBoardQuantity(request.getDataJson());
      replyBuilder.setResponseStatus(Common.ResponseStatus.newBuilder().setStatus(SUCCESS).build());
    } catch (ResourceAccessException e) {
      e.printStackTrace();
      replyBuilder.setResponseStatus(
          Common.ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage(e.getMessage())
              .setStatus(FAILED_WITH_RESOURCE_EXC)
              .build());
    } catch (Exception e) {
      e.printStackTrace();
      replyBuilder.setResponseStatus(
          Common.ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage(e.getMessage())
              .setStatus(FAILED_WITH_EXC)
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  /**
   * save OnBoardQuantity Data for loadingplan ullage update communication
   *
   * @param request
   * @param responseObserver
   */
  public void saveOnHandQuantityForCommunication(
      com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationRequest request,
      StreamObserver<com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationReply>
          responseObserver) {
    com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationReply.Builder replyBuilder =
        com.cpdss.common.generated.LoadableStudy.LoadableStudyCommunicationReply.newBuilder();
    try {
      loadableStudyCommunicationData.saveOnHandQuantity(request.getDataJson());
      replyBuilder.setResponseStatus(Common.ResponseStatus.newBuilder().setStatus(SUCCESS).build());
    } catch (ResourceAccessException e) {
      e.printStackTrace();
      replyBuilder.setResponseStatus(
          Common.ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage(e.getMessage())
              .setStatus(FAILED_WITH_RESOURCE_EXC)
              .build());
    } catch (Exception e) {
      e.printStackTrace();
      replyBuilder.setResponseStatus(
          Common.ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage(e.getMessage())
              .setStatus(FAILED_WITH_EXC)
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  @Override
  public void checkDependentProcess(
      Common.DependentProcessCheckRequestComm request,
      StreamObserver<Common.CommunicationCheckResponse> responseObserver) {

    log.debug("checkDependentProcess Request: {}", request);

    Common.CommunicationCheckResponse.Builder responseBuilder =
        Common.CommunicationCheckResponse.newBuilder();
    try {
      final boolean isDependentProcessCompleted =
          loadableStudyStagingService.dependantProcessIsCompleted(
              request.getDependantProcessId(), CommunicationModule.LOADABLE_STUDY.getModuleName());
      log.info(
          "checkDependentProcess Completed ::: Dependent Process Id: {}, Completed Status: {}",
          request.getDependantProcessId(),
          isDependentProcessCompleted);

      // Set response status
      responseBuilder
          .setIsCompleted(isDependentProcessCompleted)
          .setResponseStatus(
              ResponseStatus.newBuilder()
                  .setStatus(SUCCESS)
                  .setMessage(SUCCESS)
                  .setCode(String.valueOf(HttpStatusCode.OK.value()))
                  .setHttpStatusCode(HttpStatusCode.OK.value())
                  .build())
          .build();
    } catch (Exception e) {
      log.error(
          "checkDependentProcess failed. Dependent Process Id: {}",
          request.getDependantProcessId(),
          e);
      // Set response status
      responseBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setStatus(FAILED)
              .setMessage(Strings.nullToEmpty(e.getMessage()))
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setHttpStatusCode(HttpStatusCode.INTERNAL_SERVER_ERROR.value())
              .build());
    } finally {
      // Build response
      responseObserver.onNext(responseBuilder.build());
      responseObserver.onCompleted();
    }
  }

  @Override
  public void checkCommunicated(
      Common.CommunicationStatusCheckRequest request,
      StreamObserver<Common.CommunicationCheckResponse> responseObserver) {

    log.debug("checkCommunicated Request: {}", request);

    Common.CommunicationCheckResponse.Builder responseBuilder =
        Common.CommunicationCheckResponse.newBuilder();
    try {
      // referenceId for loadable study trigger is loadablePatternId from loading plan or discharge
      // plan
      final long loadableStudyId =
          loadablePatternRepository.getLoadableStudyId(request.getReferenceId());
      final boolean isCommunicated =
          loadableStudyStagingService.isCommunicated(
              request.getReference(),
              loadableStudyId,
              CommunicationModule.LOADABLE_STUDY.getModuleName());
      log.info(
          "checkCommunicated Completed ::: LS Id: {}, isCommunicated: {}",
          loadableStudyId,
          isCommunicated);

      // Set response status
      responseBuilder
          .setIsCompleted(isCommunicated)
          .setResponseStatus(
              ResponseStatus.newBuilder()
                  .setStatus(SUCCESS)
                  .setMessage(SUCCESS)
                  .setCode(String.valueOf(HttpStatusCode.OK.value()))
                  .setHttpStatusCode(HttpStatusCode.OK.value())
                  .build())
          .build();
    } catch (Exception e) {
      log.error("checkCommunicated failed. Reference Id: {}", request.getReferenceId(), e);
      // Set response status
      responseBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setStatus(FAILED)
              .setMessage(Strings.nullToEmpty(e.getMessage()))
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setHttpStatusCode(HttpStatusCode.INTERNAL_SERVER_ERROR.value())
              .build());
    } finally {
      // Build response
      responseObserver.onNext(responseBuilder.build());
      responseObserver.onCompleted();
    }
  }

  @Override
  public void triggerCommunication(
      Common.CommunicationTriggerRequest request,
      StreamObserver<Common.CommunicationTriggerResponse> responseObserver) {

    log.debug("triggerCommunication Request: {}", request);

    Common.CommunicationTriggerResponse.Builder responseBuilder =
        Common.CommunicationTriggerResponse.newBuilder();
    try {
      // referenceId for loadable study trigger is loadablePatternId from loading plan
      final long loadableOrDischargeStudyId =
          loadablePatternRepository.getLoadableStudyId(request.getReferenceId());
      String communicationId = null;

      if (MessageTypes.LOADABLESTUDY.getMessageType().equals(request.getMessageType())) {
        communicationId =
            loadablePatternService.communicateLoadableStudy(loadableOrDischargeStudyId, false);
      } else if (MessageTypes.DISCHARGESTUDY.getMessageType().equals(request.getMessageType())) {
        communicationId =
            generateDischargeStudyJson.communicateDischargeStudy(loadableOrDischargeStudyId, false);
      }

      log.info(
          "triggerCommunication Completed ::: LS Id: {}, CommunicationId: {}",
          loadableOrDischargeStudyId,
          communicationId);
      // Set response status
      responseBuilder
          .setProcessId(communicationId)
          .setResponseStatus(
              ResponseStatus.newBuilder()
                  .setStatus(SUCCESS)
                  .setMessage(SUCCESS)
                  .setCode(String.valueOf(HttpStatusCode.OK.value()))
                  .setHttpStatusCode(HttpStatusCode.OK.value())
                  .build())
          .build();
    } catch (Exception e) {
      log.error("triggerCommunication failed. Reference Id: {}", request.getReferenceId(), e);
      // Set response status
      responseBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setStatus(FAILED)
              .setMessage(Strings.nullToEmpty(e.getMessage()))
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setHttpStatusCode(HttpStatusCode.INTERNAL_SERVER_ERROR.value())
              .build());
    } finally {
      // Build response
      responseObserver.onNext(responseBuilder.build());
      responseObserver.onCompleted();
    }
  }
}
