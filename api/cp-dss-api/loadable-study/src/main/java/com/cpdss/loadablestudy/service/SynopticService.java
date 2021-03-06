/* Licensed at AlphaOri Technologies */
package com.cpdss.loadablestudy.service;

import static com.cpdss.loadablestudy.utility.LoadableStudiesConstants.*;
import static java.lang.String.valueOf;
import static java.util.Optional.ofNullable;
import static org.springframework.util.StringUtils.isEmpty;

import com.cpdss.common.exception.GenericServiceException;
import com.cpdss.common.generated.Common;
import com.cpdss.common.generated.Common.ResponseStatus;
import com.cpdss.common.generated.LoadableStudy;
import com.cpdss.common.generated.LoadableStudy.LoadablePatternReply;
import com.cpdss.common.generated.LoadableStudy.LoadablePatternRequest;
import com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail;
import com.cpdss.common.generated.LoadableStudy.SynopticalRecord;
import com.cpdss.common.generated.LoadableStudy.SynopticalTableRequest;
import com.cpdss.common.generated.PortInfo;
import com.cpdss.common.generated.PortInfoServiceGrpc;
import com.cpdss.common.generated.SynopticalOperationServiceGrpc.SynopticalOperationServiceImplBase;
import com.cpdss.common.generated.VesselInfo;
import com.cpdss.common.generated.VesselInfoServiceGrpc;
import com.cpdss.common.generated.discharge_plan.*;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels;
import com.cpdss.common.generated.loading_plan.LoadingPlanServiceGrpc;
import com.cpdss.common.rest.CommonErrorCodes;
import com.cpdss.common.utils.HttpStatusCode;
import com.cpdss.common.utils.Utils;
import com.cpdss.loadablestudy.domain.OperationsTable;
import com.cpdss.loadablestudy.domain.PortDetails;
import com.cpdss.loadablestudy.domain.PortOperationTable;
import com.cpdss.loadablestudy.entity.*;
import com.cpdss.loadablestudy.repository.*;
import com.cpdss.loadablestudy.repository.projections.LoadingPlanQtyAndOrder;
import com.cpdss.loadablestudy.utility.LoadableStudiesConstants;
import io.grpc.stub.StreamObserver;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import net.devh.boot.grpc.server.service.GrpcService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

/**
 * Master Service For Synoptic Related Operations
 *
 * @author Johnsooraj.X
 * @since 27-05-2021
 */
@Slf4j
@GrpcService
@Transactional
public class SynopticService extends SynopticalOperationServiceImplBase {

  @Autowired SynopticalTableRepository synopticalTableRepository;

  @Autowired LoadablePlanQuantityRepository loadablePlanQuantityRepository;

  @Autowired CargoNominationRepository cargoNominationRepository;

  @Autowired LoadableStudyRepository loadableStudyRepository;

  @Autowired CargoOperationRepository cargoOperationRepository;

  @Autowired LoadableStudyPortRotationRepository loadableStudyPortRotationRepository;

  @Autowired private OnBoardQuantityRepository onBoardQuantityRepository;

  @Autowired private OnHandQuantityRepository onHandQuantityRepository;

  @Autowired private LoadablePatternCargoDetailsRepository loadablePatternCargoDetailsRepository;

  @Autowired private LoadablePatternRepository loadablePatternRepository;

  @Autowired
  private LoadablePlanStowageBallastDetailsRepository loadablePlanStowageBallastDetailsRepository;

  @Autowired OnHandQuantityService onHandQuantityService;

  @Autowired
  private LoadablePlanCommingleDetailsPortwiseRepository
      loadablePlanCommingleDetailsPortwiseRepository;

  @Autowired private LoadablePlanCommingleDetailsRepository loadablePlanCommingleDetailsRepository;

  @Autowired private VoyageService voyageService;

  @Autowired private LoadablePatternService loadablePatternService;

  @Autowired private EntityManager entityManager;

  @Autowired private VoyageRepository voyageRepository;

  @Autowired private VoyageStatusRepository voyageStatusRepository;

  @Autowired private LoadableStudyPortRotationService loadableStudyPortRotationService;

  @Autowired
  private DischargePatternQuantityCargoPortwiseRepository
      dischargePatternQuantityCargoPortwiseRepository;

  @GrpcClient("portInfoService")
  private PortInfoServiceGrpc.PortInfoServiceBlockingStub portInfoGrpcService;

  @GrpcClient("vesselInfoService")
  private VesselInfoServiceGrpc.VesselInfoServiceBlockingStub vesselInfoGrpcService;

  @GrpcClient("dischargeInformationService")
  private DischargeInformationServiceGrpc.DischargeInformationServiceBlockingStub
      dischargeInformationGrpcService;

  @GrpcClient("loadingPlanService")
  private LoadingPlanServiceGrpc.LoadingPlanServiceBlockingStub loadingPlanGrpcService;

  @GrpcClient("dischargeInformationService")
  private DischargePlanServiceGrpc.DischargePlanServiceBlockingStub dischargingPlanGrpcService;

  @Autowired SynopticalTableLoadicatorDataRepository synopticalTableLoadicatorDataRepository;

  @Autowired DischargePatternQuantityCargoPortwiseRepository disCargoQuantityRepository;

  @Autowired PortWiseTimeRequiredForLoadingRepository portWiseTimeRequiredForLoadingRepository;

  @Autowired SynopticServiceUtils synpoticServiceUtils;

  public void fetchLoadingInformationSynopticDetails(
      LoadableStudy.LoadingPlanIdRequest request,
      LoadableStudy.LoadingPlanCommonResponse.Builder builder,
      Common.ResponseStatus.Builder repBuilder)
      throws GenericServiceException {
    Long id = request.getId();
    switch (request.getIdType()) {
      case "PORT_ROTATION":
        synpoticServiceUtils.buildPortRotationResponse(id, builder, repBuilder);
        break;
      default:
        log.info("Synoptic Data for Loading Plan Default Case");
        break;
    }
    // Not passing operation type and portId when calling for getting ballast details
    if (!StringUtils.isEmpty(request.getOperationType())) {
      if (request.getPlanningType().equals(Common.PLANNING_TYPE.LOADABLE_STUDY)) {
        log.info("Loading operation - payload \n {}", Utils.toJson(request));
        synpoticServiceUtils.buildCargoToBeLoadedForPort(request, builder, repBuilder);
      } else if (request.getPlanningType().equals(Common.PLANNING_TYPE.DISCHARGE_STUDY)) {
        log.info("Discharging operation - payload \n {}", Utils.toJson(request));
        synpoticServiceUtils.buildCargoToBeDischargedFroPort(request, builder, repBuilder);
      }
    }
    // Ballast details based on port rotation
    synpoticServiceUtils.buildBallastDetailsBasedOnPort(request, builder, repBuilder);
  }

  /**
   * Save data from loading information like timeOfSunrise, timeOfSunset etc to SynopticalTable
   *
   * @param request
   * @param builder
   * @throws Exception
   * @return
   */
  public ResponseStatus.Builder saveLoadingInformationToSynopticalTable(
      LoadableStudy.LoadingInfoSynopticalUpdateRequest request, ResponseStatus.Builder builder)
      throws Exception {
    Optional<SynopticalTable> synopticalOpt =
        this.synopticalTableRepository.findByIdAndIsActive(request.getSynopticalTableId(), true);
    if (synopticalOpt.isPresent()) {
      SynopticalTable table = synopticalOpt.get();
      if (!StringUtils.isEmpty(request.getTimeOfSunrise())) {
        table.setTimeOfSunrise(
            LocalTime.from(DateTimeFormatter.ofPattern("HH:mm").parse(request.getTimeOfSunrise())));
      }
      if (!StringUtils.isEmpty(request.getTimeOfSunset())) {
        table.setTimeOfSunSet(
            LocalTime.from(DateTimeFormatter.ofPattern("HH:mm").parse(request.getTimeOfSunset())));
      }
      this.synopticalTableRepository.save(table);
    } else
      throw new Exception("Cannot find synoptical table with id " + request.getSynopticalTableId());
    builder.setStatus(SUCCESS);
    return builder;
  }

  /**
   * Builds the port info in synoptical table
   *
   * @param entity
   * @param requestedOperationId
   * @param requestedPortId
   */
  public void buildPortsInfoSynopticalTable(
      LoadableStudyPortRotation entity, Long requestedOperationId, Long requestedPortId) {
    // build ports information to update synoptical table
    if (requestedOperationId != 0
        && !StringUtils.isEmpty(
            com.cpdss.loadablestudy.domain.CargoOperation.getOperation(requestedOperationId))) {
      List<SynopticalTable> synopticalTableEntityList = new ArrayList<>();
      if (CARGO_OPERATION_ARR_DEP_SYNOPTICAL.contains(requestedOperationId)) {
        synpoticServiceUtils.buildSynopticalTableRecord(
            requestedPortId, entity, synopticalTableEntityList, SYNOPTICAL_TABLE_OP_TYPE_ARRIVAL);
        synpoticServiceUtils.buildSynopticalTableRecord(
            requestedPortId, entity, synopticalTableEntityList, SYNOPTICAL_TABLE_OP_TYPE_DEPARTURE);
      }
      if (!CollectionUtils.isEmpty(entity.getSynopticalTable())) {
        entity.getSynopticalTable().addAll(synopticalTableEntityList);
      } else {
        entity.setSynopticalTable(synopticalTableEntityList);
      }
    }
  }

  public LoadableStudy.SynopticalTableReply.Builder getSynopticDataByLoadableStudyId(
      LoadableStudy.SynopticalTableRequest request,
      LoadableStudy.SynopticalTableReply.Builder replyBuilder)
      throws GenericServiceException {
    Optional<com.cpdss.loadablestudy.entity.LoadableStudy> loadableStudy =
        this.loadableStudyRepository.findByIdAndIsActive(request.getLoadableStudyId(), true);
    CargoOperation cOp = this.cargoOperationRepository.getOne(LOADING_OPERATION_ID);
    Long portRotationId =
        loadableStudyPortRotationService.getLastPortRotationId(loadableStudy.get(), cOp);
    LoadableStudyPortRotation lsPr = loadableStudyPortRotationRepository.getOne(portRotationId);
    Pageable pageable = PageRequest.of(0, 10);
    Page<SynopticalTable> synData =
        synopticalTableRepository.findByloadableStudyPortRotation(lsPr, pageable);
    Optional<SynopticalTable> synopticDEP =
        synData.stream()
            .filter(var1 -> (var1.getIsActive() && var1.getOperationType().equals("DEP")))
            .findFirst();
    log.info(
        "Synoptic Table data id {}, for port rotation id {}",
        synopticDEP.get().getId(),
        lsPr.getId());
    VesselInfo.VesselReply vesselReply =
        this.getSynopticalTableVesselData(request, loadableStudy.get());
    List<VesselInfo.VesselTankDetail> sortedTankList =
        new ArrayList<>(vesselReply.getVesselTanksList());
    buildSynopticalTableReply(
        request,
        Arrays.asList(synopticDEP.get()),
        this.getSynopticalTablePortDetails(Arrays.asList(synopticDEP.get())),
        this.getSynopticalTablePortRotations(loadableStudy.get()),
        loadableStudy.get(),
        sortedTankList,
        vesselReply.getVesselLoadableQuantityDetails(),
        Arrays.asList(request.getLoadablePatternId()),
        replyBuilder);
    replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS));
    return replyBuilder;
  }

  /**
   * Build Synoptical records for synoptical table
   *
   * @param request
   * @param synopticalTableList
   * @param portReply
   * @param vesselLoadableQuantityDetails
   * @param loadableStudy
   * @param portRotations
   * @param patternIds
   * @param replyBuilder
   */
  public void buildSynopticalTableReply(
      LoadableStudy.SynopticalTableRequest request,
      List<SynopticalTable> synopticalTableList,
      PortInfo.PortReply portReply,
      List<LoadableStudyPortRotation> portRotations,
      com.cpdss.loadablestudy.entity.LoadableStudy loadableStudy,
      List<VesselInfo.VesselTankDetail> sortedTankList,
      VesselInfo.VesselLoadableQuantityDetails vesselLoadableQuantityDetails,
      List<Long> patternIds,
      LoadableStudy.SynopticalTableReply.Builder replyBuilder) {
    if (!CollectionUtils.isEmpty(synopticalTableList) && !CollectionUtils.isEmpty(portRotations)) {
      Optional<com.cpdss.loadablestudy.entity.LoadableStudy> confirmedLSOpt = Optional.empty();
      if (loadableStudy.getPlanningTypeXId().equals(PLANNING_TYPE_DISCHARGE)) {
        confirmedLSOpt =
            this.loadableStudyRepository.findByIdAndIsActive(
                loadableStudy.getConfirmedLoadableStudyId(), true);
      }
      Long firstPortId = portRotations.get(0).getPortXId();
      // first port arrival condition data will be same as the data in obq
      List<OnBoardQuantity> obqEntities =
          this.onBoardQuantityRepository.findByLoadableStudyAndPortIdAndIsActive(
              loadableStudy, firstPortId, true);
      List<LoadableStudyPortRotation> lsPortRotationList = new ArrayList<>();
      confirmedLSOpt.ifPresent(
          confirmedLS -> {
            lsPortRotationList.addAll(this.getSynopticalTablePortRotations(confirmedLS));
            obqEntities.clear();
            obqEntities.addAll(
                this.onBoardQuantityRepository.findByLoadableStudyAndPortIdAndIsActive(
                    confirmedLS, lsPortRotationList.get(0).getPortXId(), true));
          });
      // populating ohq data if its empty
      List<Long> portRotationIds =
          portRotations.stream().map(LoadableStudyPortRotation::getId).collect(Collectors.toList());
      List<Object[]> objects =
          this.onHandQuantityRepository.findByLoadableStudyIdAndPortRotationIdInAndIsActive(
              loadableStudy.getId(), portRotationIds, true);

      portRotations.forEach(
          portRotation -> {
            List<Long> ohqIds = new ArrayList<>();
            objects.forEach(
                obj -> {
                  if (Long.parseLong(String.valueOf(obj[1])) == portRotation.getId())
                    ohqIds.add(Long.parseLong(String.valueOf(obj[0])));
                });
            if (ohqIds.isEmpty()) {
              try {
                this.populateOnHandQuantityData(Optional.of(loadableStudy), portRotation);
              } catch (GenericServiceException e) {
                log.error(e.getMessage(), e);
                e.printStackTrace();
              }
            }
          });
      // fething entire ohq entities based on loadable study
      List<OnHandQuantity> ohqEntities =
          this.onHandQuantityRepository.findByLoadableStudyAndIsActive(loadableStudy, true);
      confirmedLSOpt.ifPresent(
          confirmedLS -> {
            ohqEntities.addAll(
                this.onHandQuantityRepository.findByLoadableStudyAndIsActive(confirmedLS, true));
          });
      List<LoadableStudy.SynopticalRecord> records = new ArrayList<>();
      List<com.cpdss.loadablestudy.entity.LoadablePatternCargoDetails> cargoDetails =
          new ArrayList<>();
      List<LoadablePlanStowageBallastDetails> ballastDetails = new ArrayList<>();
      List<LoadablePlanComminglePortwiseDetails> commingleDetails = new ArrayList<>();
      // if there is loadable pattern selected, fetch corresponding loadicator and
      // ballast data of
      // all ports
      if (patternIds != null && !patternIds.isEmpty()) {
        cargoDetails.addAll(
            this.loadablePatternCargoDetailsRepository.findByLoadablePatternIdInAndIsActive(
                patternIds, true));
        ballastDetails.addAll(
            this.loadablePlanStowageBallastDetailsRepository.findByLoadablePatternIdInAndIsActive(
                patternIds, true));
        commingleDetails.addAll(
            this.loadablePlanCommingleDetailsPortwiseRepository
                .findByLoadablePatternIdInAndIsActive(patternIds, true));
      }

      List<LoadablePattern> loadablePatterns =
          this.loadablePatternRepository.findByIdIn(patternIds);
      List<LoadableStudyPortRotation> allPortRotations = new ArrayList<>(portRotations);
      allPortRotations.addAll(lsPortRotationList);
      Map<Long, BigDecimal> portRotationOperationHourMap =
          this.getLoadingOrDischargingHours(loadablePatterns, allPortRotations);

      for (SynopticalTable synopticalEntity : synopticalTableList) {
        LoadableStudy.SynopticalRecord.Builder builder =
            LoadableStudy.SynopticalRecord.newBuilder();
        this.buildSynopticalRecord(synopticalEntity, builder, portReply);
        // set eta/etd estamted values from port rotation table
        this.setSynopticalEtaEtdEstimated(synopticalEntity, builder, portRotations);
        this.setSynopticalTableLoadingHours(
            synopticalEntity, portRotationOperationHourMap, builder);
        this.setSynopticalCargoDetails(
            request,
            cargoDetails,
            obqEntities,
            synopticalEntity,
            builder,
            sortedTankList,
            firstPortId,
            loadableStudy.getVoyage(),
            commingleDetails,
            patternIds);
        this.setSynopticalOhqData(ohqEntities, synopticalEntity, builder, sortedTankList);
        this.setSynopticalTableVesselParticulars(
            synopticalEntity, builder, vesselLoadableQuantityDetails);
        if (patternIds != null && !patternIds.isEmpty()) {
          patternIds.forEach(
              patternId -> {
                this.setSynopticalTableLoadicatorData(synopticalEntity, patternId, builder);
                synpoticServiceUtils.setBallastDetails(
                    request, synopticalEntity, builder, ballastDetails, sortedTankList);
              });
        }
        if (synopticalEntity.getPortXid() != null && synopticalEntity.getPortXid() > 0) {
          synpoticServiceUtils.setPortDetailForSynoptics(synopticalEntity, builder);
        }
        records.add(builder.build());
      }
      replyBuilder.addAllSynopticalRecords(records);
    }
  }

  private Map<Long, BigDecimal> getLoadingOrDischargingHours(
      List<LoadablePattern> loadablePatterns, List<LoadableStudyPortRotation> portRotations) {
    Map<Long, BigDecimal> portRotationOperationHourMap = new LinkedHashMap<>();
    Map<Long, List<LoadableStudyPortRotation>> operationMap =
        portRotations.stream()
            .collect(Collectors.groupingBy(portRotation -> portRotation.getOperation().getId()));

    operationMap
        .keySet()
        .forEach(
            operationId -> {
              if (operationId.equals(LOADING_OPERATION_ID)) {
                Optional<LoadablePattern> loadablePatternOpt =
                    loadablePatterns.stream()
                        .filter(
                            loadablePattern ->
                                loadablePattern
                                    .getLoadableStudy()
                                    .getPlanningTypeXId()
                                    .equals(PLANNING_TYPE_LOADING))
                        .findFirst();
                if (loadablePatternOpt.isPresent()) {
                  List<PortWiseTimeRequiredForLoading> portWiseTimeRequiredForLoadings =
                      this.portWiseTimeRequiredForLoadingRepository
                          .findByLoadablePatternXIdAndIsActiveTrue(
                              loadablePatternOpt.get().getId());
                  if (loadablePatternOpt
                      .get()
                      .getLoadableStudy()
                      .getLoadableStudyStatus()
                      .getId()
                      .equals(CONFIRMED_STATUS_ID)) {
                    this.setLoadingHoursFromLoadingPlan(
                        operationMap.get(operationId),
                        loadablePatternOpt.get(),
                        portWiseTimeRequiredForLoadings,
                        portRotationOperationHourMap);
                  } else {
                    this.setLoadingHoursFromLoadableStudy(
                        operationMap.get(operationId),
                        loadablePatternOpt.get(),
                        portWiseTimeRequiredForLoadings,
                        portRotationOperationHourMap);
                  }
                }
              } else if (operationId.equals(DISCHARGING_OPERATION_ID)) {
                operationMap
                    .get(operationId)
                    .removeIf(
                        portRotation ->
                            portRotation
                                .getLoadableStudy()
                                .getPlanningTypeXId()
                                .equals(PLANNING_TYPE_LOADING));
                Optional<LoadablePattern> dischargePatternOpt =
                    loadablePatterns.stream()
                        .filter(
                            loadablePattern ->
                                loadablePattern
                                    .getLoadableStudy()
                                    .getPlanningTypeXId()
                                    .equals(PLANNING_TYPE_DISCHARGE))
                        .findFirst();
                if (dischargePatternOpt.isPresent()) {
                  List<DischargePatternQuantityCargoPortwiseDetails>
                      dischargePatternQuantityCargoPortwiseDetails =
                          this.dischargePatternQuantityCargoPortwiseRepository
                              .findAllByLoadablePatternIdAndIsActiveTrue(
                                  dischargePatternOpt.get().getId());
                  if (dischargePatternOpt
                      .get()
                      .getLoadableStudy()
                      .getLoadableStudyStatus()
                      .getId()
                      .equals(CONFIRMED_STATUS_ID)) {
                    this.setDischargingHoursFromDischargingPlan(
                        operationMap.get(operationId),
                        dischargePatternOpt.get(),
                        dischargePatternQuantityCargoPortwiseDetails,
                        portRotationOperationHourMap);
                  } else {
                    this.setDischargingHoursFromDischargeStudy(
                        operationMap.get(operationId),
                        dischargePatternOpt.get(),
                        dischargePatternQuantityCargoPortwiseDetails,
                        portRotationOperationHourMap);
                  }
                }
              }
            });
    return portRotationOperationHourMap;
  }

  private void setSynopticalTableLoadingHours(
      SynopticalTable synopticalEntity,
      Map<Long, BigDecimal> portRotationOperationHourMap,
      SynopticalRecord.Builder builder) {
    BigDecimal operationHours =
        portRotationOperationHourMap.get(synopticalEntity.getLoadableStudyPortRotation().getId());
    Optional.ofNullable(operationHours)
        .ifPresent(time -> builder.setOperationHours(time.toString()));
  }

  /**
   * Sets discharging hours from discharging plan.
   *
   * @param loadableStudyPortRotations list of LoadableStudyPortRotation entities
   * @param dischargePattern LoadablePattern entity
   * @param dischargePatternQuantityCargoPortwiseDetails discharge pattern quantity details
   * @param portRotationOperationHourMap map of port rotation id and discharging hours
   */
  private void setDischargingHoursFromDischargingPlan(
      List<LoadableStudyPortRotation> loadableStudyPortRotations,
      LoadablePattern dischargePattern,
      List<DischargePatternQuantityCargoPortwiseDetails>
          dischargePatternQuantityCargoPortwiseDetails,
      Map<Long, BigDecimal> portRotationOperationHourMap) {
    LoadingPlanModels.LoadingHoursRequest.Builder reqBuilder =
        LoadingPlanModels.LoadingHoursRequest.newBuilder();
    reqBuilder
        .setVesselId(dischargePattern.getLoadableStudy().getVesselXId())
        .setLoadingPatternId(dischargePattern.getId())
        .addAllPortRotationIds(
            loadableStudyPortRotations.stream()
                .map(LoadableStudyPortRotation::getId)
                .collect(Collectors.toList()));
    LoadingPlanModels.LoadingHoursReply reply =
        this.dischargingPlanGrpcService.getDischargingHours(reqBuilder.build());
    if (reply.getResponseStatus().getStatus().equals(SUCCESS)) {
      loadableStudyPortRotations.forEach(
          portRotation -> {
            Optional<LoadingPlanModels.LoadingHours> dischargingHoursOpt =
                reply.getDischargingHoursList().stream()
                    .filter(
                        loadingHours -> portRotation.getId() == loadingHours.getPortRotationId())
                    .findFirst();
            if (dischargingHoursOpt.isPresent()) {
              portRotationOperationHourMap.put(
                  portRotation.getId(),
                  StringUtils.hasLength(dischargingHoursOpt.get().getLoadingHours())
                      ? new BigDecimal(dischargingHoursOpt.get().getLoadingHours())
                      : null);
            } else {
              portRotationOperationHourMap.put(
                  portRotation.getId(),
                  this.getLoadingHoursFromDischargeStudy(
                      portRotation, dischargePatternQuantityCargoPortwiseDetails));
            }
          });
    } else {
      this.setDischargingHoursFromDischargeStudy(
          loadableStudyPortRotations,
          dischargePattern,
          dischargePatternQuantityCargoPortwiseDetails,
          portRotationOperationHourMap);
    }
  }

  /**
   * Fetches loading hours from loadable study.
   *
   * @param portRotation LoadableStudyPortRotation entity
   * @param dischargePatternQuantityCargoPortwiseDetails list of loadable pattern quantities
   */
  private BigDecimal getLoadingHoursFromDischargeStudy(
      LoadableStudyPortRotation portRotation,
      List<DischargePatternQuantityCargoPortwiseDetails>
          dischargePatternQuantityCargoPortwiseDetails) {
    Optional<BigDecimal> timeOpt =
        dischargePatternQuantityCargoPortwiseDetails.stream()
            .filter(details -> details.getPortRotationId().equals(portRotation.getId()))
            .map(DischargePatternQuantityCargoPortwiseDetails::getTimeRequiredForDischarging)
            .filter(Objects::nonNull)
            .reduce(BigDecimal::add);
    return timeOpt.orElse(null);
  }

  /**
   * Sets discharging hours from discharge study.
   *
   * @param loadableStudyPortRotations List of LoadableStudyPortRotation entity
   * @param dischargePattern list of loadable pattern
   * @param dischargePatternQuantityCargoPortwiseDetails port wise list of discharge pattern
   *     quantities
   * @param portRotationOperationHourMap map of port rotation id and operation hours
   */
  private void setDischargingHoursFromDischargeStudy(
      List<LoadableStudyPortRotation> loadableStudyPortRotations,
      LoadablePattern dischargePattern,
      List<DischargePatternQuantityCargoPortwiseDetails>
          dischargePatternQuantityCargoPortwiseDetails,
      Map<Long, BigDecimal> portRotationOperationHourMap) {
    loadableStudyPortRotations.forEach(
        portRotation -> {
          Optional<BigDecimal> timeOpt =
              dischargePatternQuantityCargoPortwiseDetails.stream()
                  .filter(details -> details.getPortRotationId().equals(portRotation.getId()))
                  .map(DischargePatternQuantityCargoPortwiseDetails::getTimeRequiredForDischarging)
                  .filter(Objects::nonNull)
                  .reduce(BigDecimal::add);
          portRotationOperationHourMap.put(portRotation.getId(), timeOpt.orElse(null));
        });
  }

  /**
   * Sets loading hours from loading plan.
   *
   * @param loadableStudyPortRotations list of LoadableStudyPortRotation entities
   * @param loadablePattern loadable pattern
   * @param portWiseTimeRequiredForLoadings port wise list of time required for loading
   * @param portRotationOperationHourMap map of port rotation id and operation hours
   */
  private void setLoadingHoursFromLoadingPlan(
      List<LoadableStudyPortRotation> loadableStudyPortRotations,
      LoadablePattern loadablePattern,
      List<PortWiseTimeRequiredForLoading> portWiseTimeRequiredForLoadings,
      Map<Long, BigDecimal> portRotationOperationHourMap) {
    LoadingPlanModels.LoadingHoursRequest.Builder reqBuilder =
        LoadingPlanModels.LoadingHoursRequest.newBuilder();
    reqBuilder
        .setVesselId(loadablePattern.getLoadableStudy().getVesselXId())
        .setLoadingPatternId(loadablePattern.getId())
        .addAllPortRotationIds(
            loadableStudyPortRotations.stream()
                .map(LoadableStudyPortRotation::getId)
                .collect(Collectors.toList()));
    LoadingPlanModels.LoadingHoursReply reply =
        this.loadingPlanGrpcService.getLoadingHours(reqBuilder.build());
    if (reply.getResponseStatus().getStatus().equals(SUCCESS)) {
      loadableStudyPortRotations.forEach(
          portRotation -> {
            Optional<LoadingPlanModels.LoadingHours> loadingHoursOpt =
                reply.getLoadingHoursList().stream()
                    .filter(
                        loadingHours -> portRotation.getId() == loadingHours.getPortRotationId())
                    .findFirst();
            if (loadingHoursOpt.isPresent()) {
              portRotationOperationHourMap.put(
                  portRotation.getId(),
                  StringUtils.hasLength(loadingHoursOpt.get().getLoadingHours())
                      ? new BigDecimal(loadingHoursOpt.get().getLoadingHours())
                      : null);
            } else {
              portRotationOperationHourMap.put(
                  portRotation.getId(),
                  this.getLoadingHoursFromLoadableStudy(
                      portRotation, portWiseTimeRequiredForLoadings));
            }
          });
    } else {
      this.setLoadingHoursFromLoadableStudy(
          loadableStudyPortRotations,
          loadablePattern,
          portWiseTimeRequiredForLoadings,
          portRotationOperationHourMap);
    }
  }

  /**
   * Fetches loading hours from loadable study.
   *
   * @param loadableStudyPortRotation LoadableStudyPortRotation entity
   * @param portWiseTimeRequiredForLoadings list of port wise loading hours
   */
  private BigDecimal getLoadingHoursFromLoadableStudy(
      LoadableStudyPortRotation loadableStudyPortRotation,
      List<PortWiseTimeRequiredForLoading> portWiseTimeRequiredForLoadings) {
    Optional<PortWiseTimeRequiredForLoading> timeRequiredForLoadingOpt =
        portWiseTimeRequiredForLoadings.stream()
            .filter(
                time -> time.getPortRotation().getId().equals(loadableStudyPortRotation.getId()))
            .findFirst();
    Optional<BigDecimal> timeOpt =
        timeRequiredForLoadingOpt.flatMap(
            timeRequiredForLoading ->
                Optional.ofNullable(timeRequiredForLoading.getTimeRequiredForLoading()));
    return timeOpt.orElse(null);
  }

  /**
   * Sets loading hours from loadable study.
   *
   * @param loadableStudyPortRotations List of LoadableStudyPortRotation entity
   * @param loadablePattern list of loadable pattern
   * @param portWiseTimeRequiredForLoadings port wise list of time required for loading operation
   * @param portRotationOperationHourMap map of port rotation id and operation hours
   */
  private void setLoadingHoursFromLoadableStudy(
      List<LoadableStudyPortRotation> loadableStudyPortRotations,
      LoadablePattern loadablePattern,
      List<PortWiseTimeRequiredForLoading> portWiseTimeRequiredForLoadings,
      Map<Long, BigDecimal> portRotationOperationHourMap) {
    loadableStudyPortRotations.forEach(
        portRotation -> {
          Optional<BigDecimal> timeOpt =
              portWiseTimeRequiredForLoadings.stream()
                  .filter(time -> time.getPortRotation().getId().equals(portRotation.getId()))
                  .map(PortWiseTimeRequiredForLoading::getTimeRequiredForLoading)
                  .findFirst();
          portRotationOperationHourMap.put(portRotation.getId(), timeOpt.orElse(null));
        });
  }

  /**
   * Fetch port details for synoptical table
   *
   * @param synopticalTableList
   * @return
   * @throws GenericServiceException
   */
  public PortInfo.PortReply getSynopticalTablePortDetails(List<SynopticalTable> synopticalTableList)
      throws GenericServiceException {
    PortInfo.GetPortInfoByPortIdsRequest.Builder portReqBuilder =
        PortInfo.GetPortInfoByPortIdsRequest.newBuilder();
    buildPortIdsRequestSynoptical(portReqBuilder, synopticalTableList);
    PortInfo.PortReply portReply = this.getPortInfo(portReqBuilder.build());
    if (portReply != null
        && portReply.getResponseStatus() != null
        && !SUCCESS.equalsIgnoreCase(portReply.getResponseStatus().getStatus())) {
      throw new GenericServiceException(
          "Error in calling port service within getSynopticalTable",
          CommonErrorCodes.E_GEN_INTERNAL_ERR,
          HttpStatusCode.INTERNAL_SERVER_ERROR);
    }
    return portReply;
  }

  /**
   * Get port rotation details for synoptical table
   *
   * @param loadableStudy
   * @return
   */
  public List<LoadableStudyPortRotation> getSynopticalTablePortRotations(
      com.cpdss.loadablestudy.entity.LoadableStudy loadableStudy) {
    return this.loadableStudyPortRotationRepository.findByLoadableStudyAndIsActiveOrderByPortOrder(
        loadableStudy, true);
  }

  /**
   * * Get vessel data for synoptical table
   *
   * @param request
   * @param loadableStudy
   * @return
   * @throws GenericServiceException
   */
  public VesselInfo.VesselReply getSynopticalTableVesselData(
      LoadableStudy.SynopticalTableRequest request,
      com.cpdss.loadablestudy.entity.LoadableStudy loadableStudy)
      throws GenericServiceException {
    VesselInfo.VesselRequest.Builder vesselGrpcRequest = VesselInfo.VesselRequest.newBuilder();
    vesselGrpcRequest.setVesselId(request.getVesselId());
    ofNullable(loadableStudy.getLoadLineXId())
        .ifPresent(vesselGrpcRequest::setVesselDraftConditionId);
    ofNullable(loadableStudy.getDraftMark())
        .ifPresent(item -> vesselGrpcRequest.setDraftExtreme(valueOf(item)));
    vesselGrpcRequest.addAllTankCategories(SYNOPTICAL_TABLE_TANK_CATEGORIES);
    VesselInfo.VesselReply vesselReply =
        this.getVesselDetailForSynopticalTable(vesselGrpcRequest.build());
    if (!SUCCESS.equals(vesselReply.getResponseStatus().getStatus())) {
      throw new GenericServiceException(
          "Failed to fetch vessel particualrs",
          vesselReply.getResponseStatus().getCode(),
          HttpStatusCode.valueOf(Integer.valueOf(vesselReply.getResponseStatus().getCode())));
    }
    return vesselReply;
  }

  public void populateOnHandQuantityData(
      Optional<com.cpdss.loadablestudy.entity.LoadableStudy> loadableStudyOpt,
      LoadableStudyPortRotation portRotation)
      throws GenericServiceException {
    VoyageStatus voyageStatus = this.voyageStatusRepository.getOne(CLOSE_VOYAGE_STATUS);
    Voyage previousVoyage =
        this.voyageRepository
            .findFirstByVesselXIdAndIsActiveAndVoyageStatusOrderByLastModifiedDateTimeDesc(
                loadableStudyOpt.get().getVoyage().getVesselXId(), true, voyageStatus);

    Optional<com.cpdss.loadablestudy.entity.LoadableStudy> confirmedLoadableStudyOpt =
        this.loadableStudyRepository
            .findByVoyageAndLoadableStudyStatusAndIsActiveAndPlanningTypeXId(
                previousVoyage,
                CONFIRMED_STATUS_ID,
                true,
                Common.PLANNING_TYPE.DISCHARGE_STUDY_VALUE);
    LoadableStudyPortRotation lastDischargingPortPortRotation = null;
    List<OnHandQuantity> onHandQuantityList = null;
    if (confirmedLoadableStudyOpt.isPresent()) {
      onHandQuantityList =
          populateOHQFromDischarging(confirmedLoadableStudyOpt.get(), previousVoyage);
    } else {
      confirmedLoadableStudyOpt =
          this.loadableStudyRepository
              .findByVoyageAndLoadableStudyStatusAndIsActiveAndPlanningTypeXId(
                  previousVoyage,
                  CONFIRMED_STATUS_ID,
                  true,
                  Common.PLANNING_TYPE.LOADABLE_STUDY_VALUE);
      if (confirmedLoadableStudyOpt.isPresent()) {
        onHandQuantityList = populateOHQFromLoadableStudy(confirmedLoadableStudyOpt.get());
      }
    }

    if (confirmedLoadableStudyOpt.isPresent()) {
      if (!onHandQuantityList.isEmpty()) {

        Long portOrder = portRotation.getPortOrder();
        List<OnHandQuantity> OnHandQuantities = new ArrayList<OnHandQuantity>();

        List<LoadableStudyPortRotation> portRotationList =
            this.loadableStudyPortRotationRepository.findByLoadableStudyAndIsActiveOrderByPortOrder(
                loadableStudyOpt.get(), true);
        if (null != portRotationList && !portRotationList.isEmpty()) {
          int index =
              IntStream.range(0, portRotationList.size())
                  .filter(i -> portRotationList.get(i).getId().equals(portRotation.getId()))
                  .findFirst()
                  .orElse(-1);
          if (portOrder.equals(portRotationList.get(0).getPortOrder())) {
            boolean ohqComplete = true;
            List<Long> fuelTypes = new ArrayList<Long>();
            for (OnHandQuantity onHandQuantity : onHandQuantityList) {
              if (ohqComplete && !fuelTypes.contains(onHandQuantity.getFuelTypeXId())) {
                fuelTypes.add(onHandQuantity.getFuelTypeXId());
                BigDecimal total = new BigDecimal(0);
                for (OnHandQuantity ohq : onHandQuantityList) {
                  if (ohq.getFuelTypeXId() == onHandQuantity.getFuelTypeXId()) {
                    total = total.add(ohq.getDepartureQuantity());
                  }
                }
                if (total.compareTo(new BigDecimal(0)) <= 0) {
                  ohqComplete = false;
                }
              }
              entityManager.detach(onHandQuantity);
              onHandQuantity.setId(null);
              onHandQuantity.setLoadableStudy(loadableStudyOpt.get());
              onHandQuantity.setActualArrivalQuantity(null);
              onHandQuantity.setActualDepartureQuantity(null);
              if (onHandQuantity.getDepartureQuantity() == null) {
                onHandQuantity.setDepartureQuantity(BigDecimal.ZERO);
              }
              onHandQuantity.setArrivalQuantity(onHandQuantity.getDepartureQuantity());
              onHandQuantity.setPortXId(portRotation.getPortXId());
              onHandQuantity.setPortRotation(portRotation);
              OnHandQuantities.add(onHandQuantity);
            }
            portRotation.setIsPortRotationOhqComplete(ohqComplete);
          } else {

            LoadableStudyPortRotation previousPortPortRotation = portRotationList.get(index - 1);
            portRotation.setIsPortRotationOhqComplete(
                previousPortPortRotation.getIsPortRotationOhqComplete());
            this.loadableStudyPortRotationRepository.save(portRotation);
            onHandQuantityList =
                this.onHandQuantityRepository.findByLoadableStudyAndPortRotationAndIsActive(
                    loadableStudyOpt.get(), previousPortPortRotation, true);
            onHandQuantityList.forEach(
                onHandQuantity -> {
                  entityManager.detach(onHandQuantity);
                  onHandQuantity.setId(null);
                  onHandQuantity.setLoadableStudy(loadableStudyOpt.get());
                  onHandQuantity.setActualArrivalQuantity(null);
                  onHandQuantity.setActualDepartureQuantity(null);
                  if (onHandQuantity.getDepartureQuantity() == null) {
                    onHandQuantity.setDepartureQuantity(BigDecimal.ZERO);
                  }
                  onHandQuantity.setArrivalQuantity(onHandQuantity.getDepartureQuantity());
                  onHandQuantity.setPortXId(portRotation.getPortXId());
                  onHandQuantity.setPortRotation(portRotation);
                  OnHandQuantities.add(onHandQuantity);
                });
          }
          this.onHandQuantityRepository.saveAll(OnHandQuantities);
        }
      }
    }
  }

  private List<OnHandQuantity> populateOHQFromLoadableStudy(
      com.cpdss.loadablestudy.entity.LoadableStudy confirmedLoadableStudy) {
    LoadableStudyPortRotation lastDischargingPortPortRotation;
    List<OnHandQuantity> onHandQuantityList;
    lastDischargingPortPortRotation =
        this.loadableStudyPortRotationRepository
            .findFirstByLoadableStudyAndOperationAndIsActiveOrderByPortOrderDesc(
                confirmedLoadableStudy,
                this.cargoOperationRepository.getOne(DISCHARGING_OPERATION_ID),
                true);
    onHandQuantityList =
        this.onHandQuantityRepository.findByLoadableStudyAndPortRotationAndIsActive(
            confirmedLoadableStudy, lastDischargingPortPortRotation, true);
    return onHandQuantityList;
  }

  private List<OnHandQuantity> populateOHQFromDischarging(
      com.cpdss.loadablestudy.entity.LoadableStudy confirmedDischargeStudy, Voyage previousVoyage)
      throws GenericServiceException {
    LoadableStudyPortRotation lastDischargingPortPortRotation;
    List<OnHandQuantity> onHandQuantityList;
    lastDischargingPortPortRotation =
        this.loadableStudyPortRotationRepository
            .findFirstByLoadableStudyAndOperationAndIsActiveOrderByPortOrderDesc(
                confirmedDischargeStudy,
                this.cargoOperationRepository.getOne(DISCHARGING_OPERATION_ID),
                true);
    PortDischargingPlanRobDetailsReply response =
        this.dischargeInformationGrpcService.getPortDischargingPlanRobDetails(
            PortDischargingPlanRobDetailsRequest.newBuilder()
                .setPortXId(lastDischargingPortPortRotation.getPortXId())
                .setPortRotationXId(lastDischargingPortPortRotation.getId())
                .setConditionType(2)
                .setValueType(1)
                .build());
    if (!SUCCESS.equals(response.getResponseStatus().getStatus())) {
      log.error(
          "Failed to fetch ROB details of port rotation: {}, response: {}",
          lastDischargingPortPortRotation.getId(),
          response.getResponseStatus().getMessage());
      throw new GenericServiceException(
          "Failed to fetch rob details",
          response.getResponseStatus().getCode(),
          HttpStatusCode.valueOf(Integer.valueOf(response.getResponseStatus().getCode())));
    }
    List<Long> tankIds = new ArrayList<>();
    response
        .getPortDischargingPlanRobDetailsList()
        .forEach(
            robDetail -> {
              tankIds.add(robDetail.getTankXId());
            });
    // GRPC call to Vessel
    VesselInfo.VesselTankRequest vesselTankRequest =
        VesselInfo.VesselTankRequest.newBuilder().addAllTankIds(tankIds).build();
    VesselInfo.VesselTankReply vesselTankReply =
        this.vesselInfoGrpcService.getVesselTanksByTankIds(vesselTankRequest);
    Map<Long, Long> tankIdsWithCategoryIds = new HashMap<>();
    vesselTankReply
        .getVesselTankInfoList()
        .forEach(
            vesselTankInfo -> {
              tankIdsWithCategoryIds.putIfAbsent(
                  vesselTankInfo.getTankId(), vesselTankInfo.getTankCategoryId());
            });
    onHandQuantityList = new ArrayList<>();
    if (response.getPortDischargingPlanRobDetailsCount() > 0) {
      for (PortDischargingPlanRobDetails robDetail :
          response.getPortDischargingPlanRobDetailsList()) {
        OnHandQuantity onHandQuantity = new OnHandQuantity();
        onHandQuantity.setArrivalQuantity(new BigDecimal(robDetail.getQuantity()));
        onHandQuantity.setDepartureQuantity(new BigDecimal(robDetail.getQuantity()));
        onHandQuantity.setDensity(new BigDecimal(robDetail.getDensity()));
        onHandQuantity.setPortXId(robDetail.getPortXId());
        onHandQuantity.setTankXId(robDetail.getTankXId());
        onHandQuantity.setFuelTypeXId(tankIdsWithCategoryIds.get(robDetail.getTankXId()));
        onHandQuantity.setIsActive(true);
        onHandQuantityList.add(onHandQuantity);
      }
    } else {
      Optional<com.cpdss.loadablestudy.entity.LoadableStudy> confirmedLoadableStudyOpt =
          this.loadableStudyRepository
              .findByVoyageAndLoadableStudyStatusAndIsActiveAndPlanningTypeXId(
                  previousVoyage,
                  CONFIRMED_STATUS_ID,
                  true,
                  Common.PLANNING_TYPE.LOADABLE_STUDY_VALUE);
      if (confirmedLoadableStudyOpt.isPresent()) {
        onHandQuantityList = populateOHQFromLoadableStudy(confirmedLoadableStudyOpt.get());
      }
    }
    return onHandQuantityList;
  }

  /**
   * Build synoptical table record
   *
   * @param synopticalEntity
   * @param builder
   * @param portReply
   */
  public void buildSynopticalRecord(
      SynopticalTable synopticalEntity,
      LoadableStudy.SynopticalRecord.Builder builder,
      PortInfo.PortReply portReply) {
    ofNullable(synopticalEntity.getId()).ifPresent(builder::setId);
    ofNullable(synopticalEntity.getPortXid()).ifPresent(builder::setPortId);
    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
    if (portReply != null) {
      portReply.getPortsList().stream()
          .filter(p -> synopticalEntity.getPortXid().equals(p.getId()))
          .findAny()
          .ifPresent(
              port -> {
                this.setSynopticalPortValues(port, builder);
              });
    }
    ofNullable(synopticalEntity.getOperationType()).ifPresent(builder::setOperationType);
    ofNullable(synopticalEntity.getDistance())
        .ifPresent(distance -> builder.setDistance(String.valueOf(distance)));
    ofNullable(synopticalEntity.getSpeed())
        .ifPresent(speed -> builder.setSpeed(String.valueOf(speed)));
    ofNullable(synopticalEntity.getRunningHours())
        .ifPresent(runningHours -> builder.setRunningHours(String.valueOf(runningHours)));
    ofNullable(synopticalEntity.getInPortHours())
        .ifPresent(inPortHours -> builder.setInPortHours(String.valueOf(inPortHours)));
    ofNullable(synopticalEntity.getTimeOfSunrise())
        .ifPresent(time -> builder.setTimeOfSunrise(timeFormatter.format(time)));
    ofNullable(synopticalEntity.getTimeOfSunSet())
        .ifPresent(time -> builder.setTimeOfSunset(timeFormatter.format(time)));
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
    ofNullable(synopticalEntity.getHwTideFrom())
        .ifPresent(hwTideFrom -> builder.setHwTideFrom(String.valueOf(hwTideFrom)));
    ofNullable(synopticalEntity.getHwTideTimeFrom())
        .ifPresent(
            hwTideTimeFrom -> builder.setHwTideTimeFrom(timeFormatter.format(hwTideTimeFrom)));
    ofNullable(synopticalEntity.getHwTideTo())
        .ifPresent(hwTideTo -> builder.setHwTideTo(String.valueOf(hwTideTo)));
    ofNullable(synopticalEntity.getHwTideTimeTo())
        .ifPresent(hwTideTimeTo -> builder.setHwTideTimeTo(timeFormatter.format(hwTideTimeTo)));
    ofNullable(synopticalEntity.getLwTideFrom())
        .ifPresent(lwTideFrom -> builder.setLwTideFrom(String.valueOf(lwTideFrom)));
    ofNullable(synopticalEntity.getLwTideTimeFrom())
        .ifPresent(
            lwTideTimeFrom -> builder.setLwTideTimeFrom(timeFormatter.format(lwTideTimeFrom)));
    ofNullable(synopticalEntity.getLwTideTo())
        .ifPresent(lwTideTo -> builder.setLwTideTo(String.valueOf(lwTideTo)));
    ofNullable(synopticalEntity.getLwTideTimeTo())
        .ifPresent(lwTideTimeTo -> builder.setLwTideTimeTo(timeFormatter.format(lwTideTimeTo)));
    ofNullable(synopticalEntity.getLoadableStudyPortRotation())
        .ifPresent(portRotation -> builder.setPortRotationId(portRotation.getId()));
    ofNullable(synopticalEntity.getLoadableStudyPortRotation())
        .ifPresent(
            portRotation ->
                ofNullable(portRotation.getPortRotationType())
                    .ifPresent(i -> builder.setPortRotationType(i)));
    ofNullable(synopticalEntity.getLoadableStudyPortRotation())
        .ifPresent(
            portRotation -> builder.setCargoOperationTypeId(portRotation.getOperation().getId()));
    if (null != synopticalEntity.getEtaActual()) {
      builder.setEtaEtdActual(formatter.format(synopticalEntity.getEtaActual()));
    } else if (null != synopticalEntity.getEtdActual()) {
      builder.setEtaEtdActual(formatter.format(synopticalEntity.getEtdActual()));
    }
    ofNullable(synopticalEntity.getLoadableStudyPortRotation())
        .ifPresent(
            portRotation ->
                builder.setSequenceNumber(
                    portRotation.getSequenceNumber() != null
                        ? portRotation.getSequenceNumber()
                        : 0));
  }

  /**
   * Set eta and etd estimated values
   *
   * @param synopticalEntity
   * @param builder
   * @param portRotations
   */
  public void setSynopticalEtaEtdEstimated(
      SynopticalTable synopticalEntity,
      LoadableStudy.SynopticalRecord.Builder builder,
      List<LoadableStudyPortRotation> portRotations) {
    /*
     * Optional<LoadableStudyPortRotationService> portRotation = portRotations
     * .stream() .filter( pr ->
     * pr.getId().equals(synopticalEntity.getLoadableStudyPortRotation().getId()))
     * .findFirst();
     */
    Optional<LoadableStudyPortRotation> portRotation =
        Optional.of(synopticalEntity.getLoadableStudyPortRotation());
    if (portRotation.isPresent()) {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
      if (SYNOPTICAL_TABLE_OP_TYPE_ARRIVAL.equals(synopticalEntity.getOperationType())) {
        builder.setEtaEtdEstimated(
            null == portRotation.get().getEta()
                ? ""
                : formatter.format(portRotation.get().getEta()));
      } else {
        builder.setEtaEtdEstimated(
            null == portRotation.get().getEtd()
                ? ""
                : formatter.format(portRotation.get().getEtd()));
      }
      if (null != portRotation.get().getPortOrder()) {
        builder.setPortOrder(portRotation.get().getPortOrder());
      }
      if (null != portRotation.get().getSeaWaterDensity()) {
        builder.setSpecificGravity(portRotation.get().getSeaWaterDensity().toString());
      }
      builder.setPortRotationId(portRotation.get().getId());
    }
  }

  /**
   * Set cargo details on synoptical record
   *
   * @param request
   * @param obqEntities
   * @param synopticalEntity
   * @param builder
   * @param firstPortId
   * @param voyage
   * @param cargoDetails
   * @param commingleCargoDetails
   */
  public void setSynopticalCargoDetails(
      LoadableStudy.SynopticalTableRequest request,
      List<com.cpdss.loadablestudy.entity.LoadablePatternCargoDetails> cargoDetails,
      List<OnBoardQuantity> obqEntities,
      SynopticalTable synopticalEntity,
      LoadableStudy.SynopticalRecord.Builder builder,
      List<VesselInfo.VesselTankDetail> sortedTankList,
      Long firstPortId,
      Voyage voyage,
      List<LoadablePlanComminglePortwiseDetails> commingleCargoDetails,
      List<Long> patternIds) {
    boolean isCallForLoadableStudy = true;
    BigDecimal cargoActualTotal = BigDecimal.ZERO;
    BigDecimal cargoPlannedTotal = BigDecimal.ZERO;
    List<com.cpdss.loadablestudy.domain.CargoHistory> cargoHistories = null;
    List<com.cpdss.loadablestudy.entity.LoadablePatternCargoDetails> portSpecificCargoDetails =
        new ArrayList<>();
    List<LoadablePlanComminglePortwiseDetails> portSpecificCommingleCargoDetails =
        new ArrayList<>();
    if (null != cargoDetails) {
      portSpecificCargoDetails.addAll(
          cargoDetails.stream()
              .filter(
                  det ->
                      det.getPortRotationId()
                              .equals(synopticalEntity.getLoadableStudyPortRotation().getId())
                          && det.getOperationType().equals(synopticalEntity.getOperationType()))
              .collect(Collectors.toList()));
    }

    if (null != commingleCargoDetails) {
      portSpecificCommingleCargoDetails.addAll(
          commingleCargoDetails.stream()
              .filter(
                  det ->
                      det.getPortRotationXid()
                              .equals(synopticalEntity.getLoadableStudyPortRotation().getId())
                          && det.getOperationType().equals(synopticalEntity.getOperationType()))
              .collect(Collectors.toList()));
    }

    Optional<com.cpdss.loadablestudy.entity.LoadableStudy> confirmedLs =
        loadableStudyRepository.findByIdAndIsActive(request.getLoadableStudyId(), true);
    if (confirmedLs.isPresent()) {
      // Skipping the status check of LS/DS, because we have already done this earlier
      isCallForLoadableStudy =
          Common.PLANNING_TYPE.LOADABLE_STUDY.getNumber() == confirmedLs.get().getPlanningTypeXId()
              ? true
              : false;
      if (isCallForLoadableStudy)
        log.info("Synoptic Cargo Details for Loadable Study - Id {}", confirmedLs.get().getId());
      else
        log.info("Synoptic Cargo Details for Discharge Study - Id {}", confirmedLs.get().getId());
    }

    log.info(
        "Synoptic Table Id, optType, port - {}, {}, {} Request optType/port - {}. {}",
        synopticalEntity.getId(),
        synopticalEntity.getOperationType(),
        synopticalEntity.getPortXid(),
        request.getOperationType(),
        request.getPortId());

    for (VesselInfo.VesselTankDetail tank : sortedTankList) {
      if (!CARGO_TANK_CATEGORIES.contains(tank.getTankCategoryId())) {
        continue;
      }
      LoadableStudy.SynopticalCargoRecord.Builder cargoBuilder =
          LoadableStudy.SynopticalCargoRecord.newBuilder();
      cargoBuilder.setTankId(tank.getTankId());
      cargoBuilder.setTankName(tank.getShortName());
      cargoBuilder.setCapacity(tank.getFullCapacityCubm());
      // first port arrival data will be same as obq data
      // if no obq data is found, previous voyage data has to be fetched
      if (isCallForLoadableStudy
          && synopticalEntity.getPortXid().equals(firstPortId)
          && synopticalEntity.getOperationType().equals(SYNOPTICAL_TABLE_OP_TYPE_ARRIVAL)) {
        this.buildObqDataForSynopticalTable(
            tank, cargoHistories, obqEntities, cargoBuilder, voyage);
      } else if (request.getLoadablePatternId() > 0
          || (patternIds != null && !patternIds.isEmpty())) {
        Optional<com.cpdss.loadablestudy.entity.LoadablePatternCargoDetails> tankDataOpt =
            portSpecificCargoDetails.stream()
                .filter(cargo -> cargo.getTankId().equals(tank.getTankId()))
                .findAny();
        if (tankDataOpt.isPresent()) {
          // cargo conditions grid must be ordered by loading/discharging order
          List<LoadingPlanQtyAndOrder> lpQty =
              loadablePlanQuantityRepository.findByCargoNominationIdAndIsActiveTrue(
                  tankDataOpt.get().getCargoNominationId());
          if (!lpQty.isEmpty()) { // means it is a loading port data
            var obj = lpQty.stream().findAny();
            Optional.ofNullable(obj.get().getId()).ifPresent(cargoBuilder::setPlanQtyId);
            Optional.ofNullable(obj.get().getLoadingOrder())
                .ifPresent(cargoBuilder::setPlanQtyCargoOrder);
          }
          // else case is discharge qty, currently no order for discharge

          ofNullable(tankDataOpt.get().getCargoNominationId())
              .ifPresent(v -> cargoBuilder.setCargoNominationId(v));
          ofNullable(tankDataOpt.get().getId()).ifPresent(v -> cargoBuilder.setLpCargoDetailId(v));
          ofNullable(tankDataOpt.get().getPlannedQuantity())
              .ifPresent(item -> cargoBuilder.setPlannedWeight(valueOf(item)));
          ofNullable(tankDataOpt.get().getActualQuantity())
              .ifPresent(item -> cargoBuilder.setActualWeight(valueOf(item)));
          // attributes for landing page
          ofNullable(tankDataOpt.get().getCargoId()).ifPresent(cargoBuilder::setCargoId);
          ofNullable(tankDataOpt.get().getAbbreviation())
              .ifPresent(cargoBuilder::setCargoAbbreviation);
          ofNullable(tankDataOpt.get().getColorCode()).ifPresent(cargoBuilder::setColorCode);
          if (tankDataOpt.get().getActualRdgUllage() != null) {
            cargoBuilder.setCorrectedUllage(valueOf(tankDataOpt.get().getActualRdgUllage()));
          } else if (tankDataOpt.get().getCorrectedUllage() != null) {
            cargoBuilder.setCorrectedUllage(valueOf(tankDataOpt.get().getCorrectedUllage()));
          }
          if (tankDataOpt.get().getActualApi() != null) {
            cargoBuilder.setApi(valueOf(tankDataOpt.get().getActualApi()));
          } else if (tankDataOpt.get().getApi() != null) {
            cargoBuilder.setApi(valueOf(tankDataOpt.get().getApi()));
          }

          if (tankDataOpt.get().getActualTemperature() != null) {
            cargoBuilder.setTemperature(valueOf(tankDataOpt.get().getActualTemperature()));
          } else if (tankDataOpt.get().getTemperature() != null) {
            cargoBuilder.setTemperature(valueOf(tankDataOpt.get().getTemperature()));
          }

          ofNullable(tankDataOpt.get().getFillingRatio()).ifPresent(cargoBuilder::setFillingRatio);
        }

        Optional<LoadablePlanComminglePortwiseDetails> commingleTankDataOpt =
            portSpecificCommingleCargoDetails.stream()
                .filter(cargo -> cargo.getTankId().equals(tank.getTankId()))
                .findAny();
        if (commingleTankDataOpt.isPresent()) {
          cargoBuilder.setIsCommingleCargo(true);
          BigDecimal cargo1Mt = null;
          BigDecimal cargo2Mt = null;

          if (!isEmpty(commingleTankDataOpt.get().getCargo1Mt())) {
            cargo1Mt = new BigDecimal(commingleTankDataOpt.get().getCargo1Mt());
          }

          if (!isEmpty(commingleTankDataOpt.get().getCargo2Mt())) {
            cargo2Mt = new BigDecimal(commingleTankDataOpt.get().getCargo2Mt());
          }

          BigDecimal plannedQuantity = cargo1Mt.add(cargo2Mt);

          Optional.ofNullable(plannedQuantity)
              .ifPresent(item -> cargoBuilder.setPlannedWeight(valueOf(item)));

          Optional.ofNullable(commingleTankDataOpt.get().getActualQuantity())
              .ifPresent(item -> cargoBuilder.setActualWeight(valueOf(item)));

          Optional.ofNullable(commingleTankDataOpt.get().getCorrectedUllage())
              .ifPresent(ullage -> cargoBuilder.setCorrectedUllage(valueOf(ullage)));
          Optional.ofNullable(commingleTankDataOpt.get().getApi())
              .ifPresent(api -> cargoBuilder.setApi(valueOf(api)));
          Optional.ofNullable(commingleTankDataOpt.get().getTemperature())
              .ifPresent(cargoBuilder::setTemperature);
          ofNullable(commingleTankDataOpt.get().getFillingRatio())
              .ifPresent(cargoBuilder::setFillingRatio);

          List<LoadablePlanCommingleDetails> commingleDetails =
              this.loadablePlanCommingleDetailsRepository.findByLoadablePatternAndIsActive(
                  commingleTankDataOpt.get().getLoadablePattern(), true);

          Optional<LoadablePlanCommingleDetails> lpcd =
              commingleDetails.stream()
                  .filter(
                      comDetail ->
                          comDetail.getTankId().equals(commingleTankDataOpt.get().getTankId()))
                  .findAny();

          lpcd.ifPresent(
              loadablePlanCommingleDetails -> {
                Optional.ofNullable(loadablePlanCommingleDetails.getGrade())
                    .ifPresent(cargoBuilder::setCargoAbbreviation);
                Optional.of(loadablePlanCommingleDetails.getCommingleColour())
                    .ifPresent(cargoBuilder::setColorCode);
                Optional.ofNullable(loadablePlanCommingleDetails.getCargo1NominationId())
                    .ifPresent(cargoBuilder::setCargo1NominationId);
                Optional.ofNullable(loadablePlanCommingleDetails.getCargo2NominationId())
                    .ifPresent(cargoBuilder::setCargo2NominationId);
                Optional.ofNullable(loadablePlanCommingleDetails.getCargo1Mt())
                    .ifPresent(cargoBuilder::setCargo1Mt);
                Optional.ofNullable(loadablePlanCommingleDetails.getCargo2Mt())
                    .ifPresent(cargoBuilder::setCargo2Mt);
                Optional.ofNullable(loadablePlanCommingleDetails.getCargo1Lt())
                    .ifPresent(cargoBuilder::setCargo1Lt);
                Optional.ofNullable(loadablePlanCommingleDetails.getCargo2Lt())
                    .ifPresent(cargoBuilder::setCargo2Lt);
                Optional.ofNullable(loadablePlanCommingleDetails.getCargo1Abbreviation())
                    .ifPresent(cargoBuilder::setCargo1Abbreviation);
                Optional.ofNullable(loadablePlanCommingleDetails.getCargo2Abbreviation())
                    .ifPresent(cargoBuilder::setCargo2Abbreviation);
              });
        }
      }
      if (!isEmpty(cargoBuilder.getActualWeight())) {
        cargoActualTotal = cargoActualTotal.add(new BigDecimal(cargoBuilder.getActualWeight()));
      }
      if (!isEmpty(cargoBuilder.getPlannedWeight())) {
        cargoPlannedTotal = cargoPlannedTotal.add(new BigDecimal(cargoBuilder.getPlannedWeight()));
      }

      builder.addCargo(cargoBuilder.build());
    }
    builder.setCargoActualTotal(valueOf(cargoActualTotal));
    builder.setCargoPlannedTotal(valueOf(cargoPlannedTotal));
  }

  public void buildObqDataForSynopticalTable(
      VesselInfo.VesselTankDetail tank,
      List<com.cpdss.loadablestudy.domain.CargoHistory> cargoHistories,
      List<OnBoardQuantity> obqEntities,
      LoadableStudy.SynopticalCargoRecord.Builder cargoBuilder,
      Voyage voyage) {

    Optional<OnBoardQuantity> obqOpt =
        obqEntities.stream().filter(obq -> obq.getTankId().equals(tank.getTankId())).findAny();
    if (obqOpt.isPresent()) {
      OnBoardQuantity obqEntity = obqOpt.get();
      if (null != obqEntity.getActualArrivalWeight()) {
        cargoBuilder.setActualWeight(valueOf(obqEntity.getActualArrivalWeight()));
      }
      if (null != obqEntity.getPlannedArrivalWeight()) {
        cargoBuilder.setPlannedWeight(valueOf(obqEntity.getPlannedArrivalWeight()));
      }
      if (null != obqEntity.getDensity()) {
        cargoBuilder.setApi(valueOf(obqEntity.getDensity()));
      }
      if (null != obqEntity.getAbbreviation()) {
        cargoBuilder.setCargoAbbreviation(obqEntity.getAbbreviation());
      }
    } else {
      // data has to be populated from previous voyage - cargo history table
      // lazy loading the cargo history
      if (null == cargoHistories) {
        cargoHistories = voyageService.findCargoHistoryForPrvsVoyage(voyage);
      }
      Optional<com.cpdss.loadablestudy.domain.CargoHistory> cargoHistoryOpt =
          cargoHistories.stream().filter(e -> e.getTankId().equals(tank.getTankId())).findAny();
      if (cargoHistoryOpt.isPresent()) {
        com.cpdss.loadablestudy.domain.CargoHistory dto = cargoHistoryOpt.get();
        ofNullable(dto.getQuantity())
            .ifPresent(item -> cargoBuilder.setPlannedWeight(valueOf(item)));
      }
    }
  }

  /**
   * Set ohq data
   *
   * @param ohqEntities
   * @param synopticalEntity
   * @param builder
   * @param sortedTankList
   */
  public void setSynopticalOhqData(
      List<OnHandQuantity> ohqEntities,
      SynopticalTable synopticalEntity,
      LoadableStudy.SynopticalRecord.Builder builder,
      List<VesselInfo.VesselTankDetail> sortedTankList) {
    List<OnHandQuantity> portSpecificEntities =
        ohqEntities.stream()
            .filter(
                entity ->
                    null != entity.getPortRotation()
                        && entity
                            .getPortRotation()
                            .getId()
                            .equals(synopticalEntity.getLoadableStudyPortRotation().getId()))
            .collect(Collectors.toList());
    for (VesselInfo.VesselTankDetail tank : sortedTankList) {
      if (!OHQ_TANK_CATEGORIES.contains(tank.getTankCategoryId()) || !tank.getShowInOhqObq()) {
        continue;
      }
      LoadableStudy.SynopticalOhqRecord.Builder ohqBuilder =
          LoadableStudy.SynopticalOhqRecord.newBuilder();
      ohqBuilder.setTankId(tank.getTankId());
      ohqBuilder.setTankName(tank.getShortName());
      ohqBuilder.setFuelTypeId(tank.getTankCategoryId());
      ohqBuilder.setFuelType(tank.getTankCategoryShortName());
      ohqBuilder.setCapacity(tank.getFullCapacityCubm());
      ohqBuilder.setPortRotationId(synopticalEntity.getLoadableStudyPortRotation().getId());
      Optional<OnHandQuantity> ohqOpt =
          portSpecificEntities.stream()
              .filter(ohq -> ohq.getTankXId().equals(tank.getTankId()))
              .findAny();
      if (ohqOpt.isPresent()) {
        OnHandQuantity ohq = ohqOpt.get();
        if (null != ohq.getDensity()) {
          ohqBuilder.setDensity(valueOf(ohq.getDensity()));
        }
        if (synopticalEntity.getOperationType().equals(SYNOPTICAL_TABLE_OP_TYPE_ARRIVAL)) {
          if (null != ohq.getArrivalQuantity()) {
            ohqBuilder.setPlannedWeight(valueOf(ohq.getArrivalQuantity()));
          }
          if (null != ohq.getActualArrivalQuantity()) {
            ohqBuilder.setActualWeight(valueOf(ohq.getActualArrivalQuantity()));
          }
        } else if (synopticalEntity.getOperationType().equals(SYNOPTICAL_TABLE_OP_TYPE_DEPARTURE)) {
          if (null != ohq.getDepartureQuantity()) {
            ohqBuilder.setPlannedWeight(valueOf(ohq.getDepartureQuantity()));
          }
          if (null != ohq.getActualDepartureQuantity()) {
            ohqBuilder.setActualWeight(valueOf(ohq.getActualDepartureQuantity()));
          }
        }
      }
      builder.addOhq(ohqBuilder.build());
    }
  }

  /**
   * Set vessel particular data
   *
   * @param synopticalEntity
   * @param builder
   * @param vesselLoadableQuantityDetails
   */
  public void setSynopticalTableVesselParticulars(
      SynopticalTable synopticalEntity,
      LoadableStudy.SynopticalRecord.Builder builder,
      VesselInfo.VesselLoadableQuantityDetails vesselLoadableQuantityDetails) {
    ofNullable(synopticalEntity.getOthersPlanned())
        .ifPresent(item -> builder.setOthersPlanned(valueOf(item)));
    ofNullable(synopticalEntity.getOthersActual())
        .ifPresent(item -> builder.setOthersActual(valueOf(item)));
    builder.setConstantPlanned(vesselLoadableQuantityDetails.getConstant());
    ofNullable(synopticalEntity.getConstantPlanned())
        .ifPresent(item -> builder.setConstantPlanned(valueOf(item)));
    ofNullable(synopticalEntity.getConstantActual())
        .ifPresent(item -> builder.setConstantActual(valueOf(item)));
    builder.setTotalDwtPlanned(vesselLoadableQuantityDetails.getDwt());
    ofNullable(synopticalEntity.getDeadWeightPlanned())
        .ifPresent(item -> builder.setTotalDwtPlanned(valueOf(item)));
    ofNullable(synopticalEntity.getDeadWeightActual())
        .ifPresent(item -> builder.setTotalDwtActual(valueOf(item)));
    builder.setDisplacementPlanned(vesselLoadableQuantityDetails.getDisplacmentDraftRestriction());
    ofNullable(synopticalEntity.getDisplacementPlanned())
        .ifPresent(item -> builder.setDisplacementPlanned(valueOf(item)));
    ofNullable(synopticalEntity.getDisplacementActual())
        .ifPresent(item -> builder.setDisplacementActual(valueOf(item)));
    ofNullable(vesselLoadableQuantityDetails.getHasLoadicator())
        .ifPresent(item -> builder.setHasLoadicator(item));
  }

  /**
   * * Set port values to synoptical response
   *
   * @param port
   * @param builder
   */
  public void setSynopticalPortValues(
      PortInfo.PortDetail port,
      com.cpdss.common.generated.LoadableStudy.SynopticalRecord.Builder builder) {
    builder.setPortName(port.getName());
    builder.setSpecificGravity(port.getWaterDensity());
    builder.setHwTideFrom(port.getHwTideFrom());
    builder.setHwTideTo(port.getHwTideTo());
    builder.setLwTideFrom(port.getLwTideFrom());
    builder.setLwTideTo(port.getLwTideTo());
    if (!isEmpty(port.getHwTideTimeFrom())) {
      builder.setHwTideTimeFrom(port.getHwTideTimeFrom());
    }
    if (!isEmpty(port.getHwTideTimeTo())) {
      builder.setHwTideTimeTo(port.getHwTideTimeTo());
    }
    if (!isEmpty(port.getLwTideTimeFrom())) {
      builder.setLwTideTimeFrom(port.getLwTideTimeFrom());
    }
    if (!isEmpty(port.getLwTideTimeTo())) {
      builder.setLwTideTimeTo(port.getLwTideTimeTo());
    }
    if (!isEmpty(port.getSunriseTime())) {
      builder.setTimeOfSunrise(port.getSunriseTime());
    }
    if (!isEmpty(port.getSunsetTime())) {
      builder.setTimeOfSunset(port.getSunsetTime());
    }
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
   * Build port request to fetch port related fields from port master
   *
   * @param portReqBuilder
   * @param synopticalTableList
   */
  public void buildPortIdsRequestSynoptical(
      com.cpdss.common.generated.PortInfo.GetPortInfoByPortIdsRequest.Builder portReqBuilder,
      List<SynopticalTable> synopticalTableList) {
    // build fetch port details request object
    if (!CollectionUtils.isEmpty(synopticalTableList)) {
      synopticalTableList.forEach(
          synopticalRecord ->
              ofNullable(synopticalRecord.getPortXid()).ifPresent(portReqBuilder::addId));
    }
  }

  /**
   * @param build
   * @return PortReply
   */
  public PortInfo.PortReply getPortInfo(PortInfo.GetPortInfoByPortIdsRequest build) {
    return portInfoGrpcService.getPortInfoByPortIds(build);
  }

  /**
   * Set loadicator data in synoptical table record
   *
   * @param synopticalEntity
   * @param builder
   */
  public void setSynopticalTableLoadicatorData(
      SynopticalTable synopticalEntity,
      Long loadablePatternId,
      com.cpdss.common.generated.LoadableStudy.SynopticalRecord.Builder builder) {
    SynopticalTableLoadicatorData loadicatorData =
        this.synopticalTableLoadicatorDataRepository
            .findBySynopticalTableAndLoadablePatternIdAndIsActive(
                synopticalEntity, loadablePatternId, true);
    if (null != loadicatorData) {
      com.cpdss.common.generated.LoadableStudy.SynopticalTableLoadicatorData.Builder dataBuilder =
          com.cpdss.common.generated.LoadableStudy.SynopticalTableLoadicatorData.newBuilder();
      ofNullable(loadicatorData.getBlindSector())
          .ifPresent(item -> dataBuilder.setBlindSector(valueOf(item)));
      ofNullable(loadicatorData.getDeflection())
          .ifPresent(item -> dataBuilder.setDeflection(valueOf(item)));
      ofNullable(loadicatorData.getCalculatedDraftAftActual())
          .ifPresent(item -> dataBuilder.setCalculatedDraftAftActual(valueOf(item)));
      ofNullable(loadicatorData.getCalculatedDraftAftPlanned())
          .ifPresent(item -> dataBuilder.setCalculatedDraftAftPlanned(valueOf(item)));
      ofNullable(loadicatorData.getCalculatedDraftFwdActual())
          .ifPresent(item -> dataBuilder.setCalculatedDraftFwdActual(valueOf(item)));
      ofNullable(loadicatorData.getCalculatedDraftFwdPlanned())
          .ifPresent(item -> dataBuilder.setCalculatedDraftFwdPlanned(valueOf(item)));
      ofNullable(loadicatorData.getCalculatedDraftMidActual())
          .ifPresent(item -> dataBuilder.setCalculatedDraftMidActual(valueOf(item)));
      ofNullable(loadicatorData.getCalculatedDraftMidPlanned())
          .ifPresent(item -> dataBuilder.setCalculatedDraftMidPlanned(valueOf(item)));
      ofNullable(loadicatorData.getCalculatedTrimActual())
          .ifPresent(item -> dataBuilder.setCalculatedTrimActual(valueOf(item)));
      ofNullable(loadicatorData.getCalculatedTrimPlanned())
          .ifPresent(item -> dataBuilder.setCalculatedTrimPlanned(valueOf(item)));
      this.setFinalDraftValues(dataBuilder, loadicatorData);
      ofNullable(loadicatorData.getList()).ifPresent(list -> dataBuilder.setList(valueOf(list)));
      ofNullable(loadicatorData.getBendingMoment())
          .ifPresent(bm -> dataBuilder.setBendingMoment(valueOf(bm)));
      ofNullable(loadicatorData.getShearingForce())
          .ifPresent(sf -> dataBuilder.setShearingForce(valueOf(sf)));
      builder.setLoadicatorData(dataBuilder.build());
      ofNullable(loadicatorData.getBallastActual())
          .ifPresent(item -> builder.setBallastActual(valueOf(item)));
    } else {
      log.info("loadicator data does not exist for loadable patter with id {}", loadablePatternId);
    }
  }

  /**
   * Set final draft values
   *
   * @param dataBuilder
   * @param loadicatorData
   */
  public void setFinalDraftValues(
      com.cpdss.common.generated.LoadableStudy.SynopticalTableLoadicatorData.Builder dataBuilder,
      SynopticalTableLoadicatorData loadicatorData) {
    BigDecimal deflection = BigDecimal.ZERO;
    if (null != loadicatorData.getDeflection()) {
      deflection = loadicatorData.getDeflection();
    }
    deflection = deflection.divide(new BigDecimal(100));
    BigDecimal calculatedDraftFwd = BigDecimal.ZERO;
    if (null != loadicatorData.getCalculatedDraftFwdActual()
        && loadicatorData.getCalculatedDraftFwdActual().doubleValue() != 0.0) {
      calculatedDraftFwd = loadicatorData.getCalculatedDraftFwdActual();
    } else if (null != loadicatorData.getCalculatedDraftFwdPlanned()) {
      calculatedDraftFwd = loadicatorData.getCalculatedDraftFwdPlanned();
    }
    BigDecimal calculatedDraftAft = BigDecimal.ZERO;
    if (null != loadicatorData.getCalculatedDraftAftActual()
        && loadicatorData.getCalculatedDraftAftActual().doubleValue() != 0.0) {
      calculatedDraftAft = loadicatorData.getCalculatedDraftAftActual();
    } else if (null != loadicatorData.getCalculatedDraftAftPlanned()) {
      calculatedDraftAft = loadicatorData.getCalculatedDraftAftPlanned();
    }
    BigDecimal calculatedDraftMid = BigDecimal.ZERO;
    if (null != loadicatorData.getCalculatedDraftMidActual()
        && loadicatorData.getCalculatedDraftMidActual().doubleValue() != 0.0) {
      calculatedDraftMid = loadicatorData.getCalculatedDraftMidActual();
    } else if (null != loadicatorData.getCalculatedDraftMidPlanned()) {
      calculatedDraftMid = loadicatorData.getCalculatedDraftMidPlanned();
    }
    dataBuilder.setFinalDraftAft(valueOf(deflection.add(calculatedDraftAft)));
    dataBuilder.setFinalDraftFwd(valueOf(deflection.add(calculatedDraftFwd)));
    dataBuilder.setFinalDraftMid(valueOf(deflection.add(calculatedDraftMid)));
  }

  /**
   * Method to build port operations table
   *
   * @param loadableStudyId loadable study id value
   * @param loadablePatternId loadable pattern id value
   * @return PortOperationTable object
   */
  public PortOperationTable buildPortOperationsTable(long loadableStudyId, long loadablePatternId)
      throws GenericServiceException {

    // Get loadable study port rotation details
    com.cpdss.loadablestudy.domain.LoadableStudy loadableStudy =
        new com.cpdss.loadablestudy.domain.LoadableStudy();
    ModelMapper modelMapper = new ModelMapper();
    loadableStudyPortRotationService.buildLoadableStudyPortRotationDetails(
        loadableStudyId, loadableStudy, modelMapper);

    // Get loadable study details
    com.cpdss.loadablestudy.entity.LoadableStudy loadableStudyDetails =
        loadableStudyRepository
            .findByIdAndIsActive(loadableStudyId, true)
            .orElseThrow(
                () ->
                    new GenericServiceException(
                        String.format(
                            "Loadable study details not found for LoadableStudyId: %d",
                            loadableStudyId),
                        CommonErrorCodes.E_HTTP_BAD_REQUEST,
                        HttpStatusCode.BAD_REQUEST));

    // GRPC call to Vessel Info
    VesselInfo.VesselRequest replyBuilder =
        VesselInfo.VesselRequest.newBuilder()
            .setVesselId(loadableStudyDetails.getVesselXId())
            .setVesselDraftConditionId(loadableStudyDetails.getLoadLineXId())
            .setDraftExtreme(loadableStudyDetails.getDraftMark().toString())
            .build();
    VesselInfo.VesselReply vesselReply =
        this.vesselInfoGrpcService.getVesselDetailByVesselId(replyBuilder);
    double vesselLwt =
        Double.parseDouble(vesselReply.getVesselLoadableQuantityDetails().getVesselLightWeight());

    // Get port rotation details
    loadableStudyPortRotationService.buildportRotationDetails(loadableStudyDetails, loadableStudy);

    // Get cargo details
    List<LoadablePatternCargoDetails> cargoes =
        loadablePatternCargoDetailsRepository.findByLoadablePatternIdAndIsActive(
            loadablePatternId, true);
    // Get on hand quantities
    List<OnHandQuantity> onHandQuantities =
        onHandQuantityRepository.findByLoadableStudyAndIsActive(loadableStudyDetails, true);
    // Get ballast details
    List<LoadablePlanStowageBallastDetails> ballastDetails =
        loadablePlanStowageBallastDetailsRepository.findByLoadablePatternIdAndIsActive(
            loadablePatternId, true);
    // Set OperationsTable details
    List<OperationsTable> operationsTableList = new ArrayList<>();

    List<SynopticalTable> arrSynopticRecords =
        this.synopticalTableRepository.findByLoadableStudyXIdAndOperationTypeAndIsActive(
            loadableStudyId, OPERATION_TYPE_ARR, true);
    List<SynopticalTableLoadicatorData> arrSynopticalTableLoadicatorDataList =
        this.synopticalTableLoadicatorDataRepository.findByLoadablePatternIdAndIsActive(
            loadablePatternId, true);
    List<SynopticalTable> depSynopticRecords =
        this.synopticalTableRepository.findByLoadableStudyXIdAndOperationTypeAndIsActive(
            loadableStudyId, OPERATION_TYPE_DEP, true);
    List<SynopticalTableLoadicatorData> depSynopticalTableLoadicatorDataList =
        this.synopticalTableLoadicatorDataRepository.findByLoadablePatternIdAndIsActive(
            loadablePatternId, true);

    for (com.cpdss.loadablestudy.domain.LoadableStudyPortRotation portDetails :
        loadableStudy.getLoadableStudyPortRotation()) {

      // Get port rotations
      LoadableStudyPortRotation loadableStudyPortRotation =
          loadableStudyDetails.getPortRotations().stream()
              .filter(
                  rotation ->
                      rotation.getPortXId().equals(portDetails.getPortId()) && rotation.isActive())
              .findFirst()
              .orElse(new LoadableStudyPortRotation());

      // Get timezone
      Optional<PortDetails> portMasterDetails =
          loadableStudy.getPortDetails().stream()
              .filter(port -> port.getId().longValue() == portDetails.getPortId().longValue())
              .findFirst();
      System.out.println(portMasterDetails.get().getOffset());

      Optional<SynopticalTable> arrSynopticRecord =
          arrSynopticRecords.stream()
              .filter(
                  arrSynopticRec ->
                      arrSynopticRec.getLoadableStudyPortRotation().getId()
                          == loadableStudyPortRotation.getId())
              .findFirst();
      SynopticalTableLoadicatorData arrSynopticalTableLoadicatorData =
          arrSynopticalTableLoadicatorDataList.stream()
              .filter(
                  arrsynoptic ->
                      arrsynoptic.getSynopticalTable().getId() == arrSynopticRecord.get().getId())
              .findFirst()
              .get();
      Optional<SynopticalTable> depSynopticRecord =
          depSynopticRecords.stream()
              .filter(
                  depSynopticRec ->
                      depSynopticRec.getLoadableStudyPortRotation().getId()
                          == loadableStudyPortRotation.getId())
              .findFirst();
      SynopticalTableLoadicatorData depSynopticalTableLoadicatorData =
          depSynopticalTableLoadicatorDataList.stream()
              .filter(
                  depsynoptic ->
                      depsynoptic.getSynopticalTable().getId() == depSynopticRecord.get().getId())
              .findFirst()
              .get();
      // Calculating displacement
      // Get the port-wise cargo total
      double cargoArrTotal =
          cargoes.stream()
              .filter(
                  cargo ->
                      cargo.getPortRotationId().doubleValue()
                              == loadableStudyPortRotation.getId().doubleValue()
                          && cargo.getOperationType().equalsIgnoreCase(OPERATION_TYPE_ARR))
              .mapToDouble(
                  cargo ->
                      cargo.getPlannedQuantity() != null
                          ? cargo.getPlannedQuantity().doubleValue()
                          : 0)
              .sum();
      double cargoDepTotal =
          cargoes.stream()
              .filter(
                  cargo ->
                      cargo.getPortRotationId().doubleValue()
                              == loadableStudyPortRotation.getId().doubleValue()
                          && cargo.getOperationType().equalsIgnoreCase(OPERATION_TYPE_DEP))
              .mapToDouble(
                  cargo ->
                      cargo.getPlannedQuantity() != null
                          ? cargo.getPlannedQuantity().doubleValue()
                          : 0)
              .sum();
      // Get portwise ohq totals
      double foArrTotal =
          onHandQuantities.stream()
              .filter(
                  ohq ->
                      ohq.getPortRotation().getId() == loadableStudyPortRotation.getId()
                          && ohq.getFuelTypeXId() == FUEL_OIL_TANK_CATEGORY_ID)
              .mapToDouble(ohq -> ohq.getArrivalQuantity().doubleValue())
              .sum();
      double foDepTotal =
          onHandQuantities.stream()
              .filter(
                  ohq ->
                      ohq.getPortRotation().getId() == loadableStudyPortRotation.getId()
                          && ohq.getFuelTypeXId() == FUEL_OIL_TANK_CATEGORY_ID)
              .mapToDouble(ohq -> ohq.getDepartureQuantity().doubleValue())
              .sum();
      double doArrTotal =
          onHandQuantities.stream()
              .filter(
                  ohq ->
                      ohq.getPortRotation().getId() == loadableStudyPortRotation.getId()
                          && ohq.getFuelTypeXId() == DIESEL_OIL_TANK_CATEGORY_ID)
              .mapToDouble(ohq -> ohq.getArrivalQuantity().doubleValue())
              .sum();
      double doDepTotal =
          onHandQuantities.stream()
              .filter(
                  ohq ->
                      ohq.getPortRotation().getId() == loadableStudyPortRotation.getId()
                          && ohq.getFuelTypeXId() == DIESEL_OIL_TANK_CATEGORY_ID)
              .mapToDouble(ohq -> ohq.getDepartureQuantity().doubleValue())
              .sum();
      double fwArrTotal =
          onHandQuantities.stream()
              .filter(
                  ohq ->
                      ohq.getPortRotation().getId() == loadableStudyPortRotation.getId()
                          && ohq.getFuelTypeXId() == FRESH_WATER_TANK_CATEGORY_ID)
              .mapToDouble(ohq -> ohq.getArrivalQuantity().doubleValue())
              .sum();
      double fwDepTotal =
          onHandQuantities.stream()
              .filter(
                  ohq ->
                      ohq.getPortRotation().getId() == loadableStudyPortRotation.getId()
                          && ohq.getFuelTypeXId() == FRESH_WATER_TANK_CATEGORY_ID)
              .mapToDouble(ohq -> ohq.getDepartureQuantity().doubleValue())
              .sum();
      // Get ballast total
      double ballastArrTotal =
          ballastDetails.stream()
              .filter(
                  ballast ->
                      ballast.getPortRotationId().doubleValue()
                              == loadableStudyPortRotation.getId().doubleValue()
                          && ballast.getOperationType().equalsIgnoreCase(OPERATION_TYPE_ARR))
              .mapToDouble(
                  ballast ->
                      ballast.getQuantity() != null ? ballast.getQuantity().doubleValue() : 0)
              .sum();
      double ballastDepTotal =
          ballastDetails.stream()
              .filter(
                  ballast ->
                      ballast.getPortRotationId().doubleValue()
                              == loadableStudyPortRotation.getId().doubleValue()
                          && ballast.getOperationType().equalsIgnoreCase(OPERATION_TYPE_DEP))
              .mapToDouble(
                  ballast ->
                      ballast.getQuantity() != null ? ballast.getQuantity().doubleValue() : 0)
              .sum();
      double arrDisplacement =
          cargoArrTotal
              + (null != arrSynopticRecord.get().getConstantPlanned()
                  ? arrSynopticRecord.get().getConstantPlanned().doubleValue()
                  : vesselReply.getVesselLoadableQuantityDetails().getDeadWeightConstant())
              + (null != arrSynopticRecord.get().getOthersPlanned()
                  ? arrSynopticRecord.get().getOthersPlanned().doubleValue()
                  : 0)
              + foArrTotal
              + doArrTotal
              + fwArrTotal
              + ballastArrTotal
              + vesselLwt;
      double depDisplacement =
          cargoDepTotal
              + (null != depSynopticRecord.get().getConstantPlanned()
                  ? depSynopticRecord.get().getConstantPlanned().doubleValue()
                  : vesselReply.getVesselLoadableQuantityDetails().getDeadWeightConstant())
              + (null != depSynopticRecord.get().getOthersPlanned()
                  ? depSynopticRecord.get().getOthersPlanned().doubleValue()
                  : 0)
              + foDepTotal
              + doDepTotal
              + fwDepTotal
              + ballastDepTotal
              + vesselLwt;
      BigDecimal depAft =
          depSynopticalTableLoadicatorData.getCalculatedDraftAftPlanned() != null
              ? depSynopticalTableLoadicatorData.getCalculatedDraftAftPlanned()
              : BigDecimal.ZERO;
      BigDecimal arrAft =
          arrSynopticalTableLoadicatorData.getCalculatedDraftAftPlanned() != null
              ? arrSynopticalTableLoadicatorData.getCalculatedDraftAftPlanned()
              : BigDecimal.ZERO;
      BigDecimal depFwd =
          depSynopticalTableLoadicatorData.getCalculatedDraftFwdPlanned() != null
              ? depSynopticalTableLoadicatorData.getCalculatedDraftFwdPlanned()
              : BigDecimal.ZERO;
      BigDecimal arrFwd =
          arrSynopticalTableLoadicatorData.getCalculatedDraftFwdPlanned() != null
              ? arrSynopticalTableLoadicatorData.getCalculatedDraftFwdPlanned()
              : BigDecimal.ZERO;

      // Setting timezone converted dates
      String eta =
          synpoticServiceUtils.getTimezoneConvertedString(
              loadableStudyPortRotation.getEta(),
              Double.parseDouble(portMasterDetails.get().getOffset()),
              portMasterDetails.get().getTimezoneAbbr());
      String etd =
          synpoticServiceUtils.getTimezoneConvertedString(
              loadableStudyPortRotation.getEtd(),
              Double.parseDouble(portMasterDetails.get().getOffset()),
              portMasterDetails.get().getTimezoneAbbr());
      LocalDate laycanFrom =
          synpoticServiceUtils.getTimezoneConvertedDate(
              loadableStudyPortRotation.getLayCanFrom(),
              Double.parseDouble(portMasterDetails.get().getOffset()),
              true);
      LocalDate laycanTo =
          synpoticServiceUtils.getTimezoneConvertedDate(
              loadableStudyPortRotation.getLayCanFrom(),
              Double.parseDouble(portMasterDetails.get().getOffset()),
              false);

      OperationsTable operationsTableData =
          OperationsTable.builder()
              .operation(loadableStudyPortRotation.getOperation().getName())
              .portName(
                  loadableStudy.getPortDetails().stream()
                      .filter(rotationObj -> rotationObj.getId().equals(portDetails.getPortId()))
                      .findFirst()
                      .orElse(new PortDetails())
                      .getName())
              .eta(eta)
              .etd(etd)
              .country(
                  loadableStudy.getPortDetails().stream()
                      .filter(rotationObj -> rotationObj.getId().equals(portDetails.getPortId()))
                      .findFirst()
                      .orElse(new PortDetails())
                      .getCountryName())
              .laycanRange(
                  null != laycanFrom && null != laycanTo
                      ? DateTimeFormatter.ofPattern(LAY_CAN_FORMAT).format(laycanFrom)
                          + "/"
                          + DateTimeFormatter.ofPattern(LAY_CAN_FORMAT).format(laycanTo)
                      : "")
              .arrFwdDraft(arrFwd.doubleValue())
              .depFwdDraft(depFwd.doubleValue())
              .arrAftDraft(arrAft.doubleValue())
              .depAftDraft(depAft.doubleValue())
              .arrDisplacement(arrDisplacement)
              .depDisp(depDisplacement)
              .build();
      operationsTableList.add(operationsTableData);
    }
    return PortOperationTable.builder().operationsTableList(operationsTableList).build();
  }

  public Optional<List<com.cpdss.loadablestudy.entity.LoadableStudy>> checkDischargeStarted(
      Long vesselId, Long voyageId) {
    // Checking if Loading completed and Discharge started or not
    return loadableStudyRepository.getLoadableStudyByVesselVoyagePlanningType(
        vesselId, voyageId, PLANNING_TYPE_DISCHARGE);
  }

  public void getSynopticalTable(
      LoadableStudy.SynopticalTableRequest request,
      LoadableStudy.SynopticalTableReply.Builder replyBuilder)
      throws GenericServiceException {

    Boolean dischargingStarted = false;

    Optional<com.cpdss.loadablestudy.entity.LoadableStudy> loadableStudyOpt =
        this.loadableStudyRepository.findById(request.getLoadableStudyId());
    if (!loadableStudyOpt.isPresent()) {
      throw new GenericServiceException(
          "Loadable/Discharge study does not exist", CommonErrorCodes.E_HTTP_BAD_REQUEST, null);
    }
    // Checking if Loading completed and Discharge started or not
    Optional<List<com.cpdss.loadablestudy.entity.LoadableStudy>> dischargeStudyEntries =
        checkDischargeStarted(request.getVesselId(), request.getVoyageId());
    List<SynopticalTable> synopticalTableList = new ArrayList<>();
    List<Long> patternIds = new ArrayList<>();
    if (dischargeStudyEntries.isPresent()
        && loadableStudyOpt.get().getConfirmedLoadableStudyId() != null) {
      dischargingStarted = true;

      synopticalTableList =
          synpoticServiceUtils.getsynopticalTableList(
              loadableStudyOpt.get().getConfirmedLoadableStudyId(), request.getLoadableStudyId());

      // Get pattern id for DS
      LoadablePatternRequest.Builder lpRequest = LoadablePatternRequest.newBuilder();
      lpRequest.setLoadableStudyId(request.getLoadableStudyId());
      Long dsPatternId = getPatternId(lpRequest);
      if (dsPatternId > 0) {
        patternIds.add(dsPatternId);
      } else {
        // If no confirmed pattern available
        List<LoadablePattern> dischargePatterns =
            this.loadablePatternRepository.findByLoadableStudyAndIsActive(
                loadableStudyOpt.get(), true);
        if (dischargePatterns.size() > 0) {
          patternIds.add(dischargePatterns.get(0).getId());
        }
      }
      // Get pattern id for LS
      LoadablePatternRequest.Builder lpLSRequest = LoadablePatternRequest.newBuilder();
      lpLSRequest.setLoadableStudyId(loadableStudyOpt.get().getConfirmedLoadableStudyId());
      Long lsPatternId = getPatternId(lpLSRequest);
      if (lsPatternId > 0) {
        patternIds.add(lsPatternId);
      }
    } else {
      patternIds.add(request.getLoadablePatternId());
      synopticalTableList =
          synpoticServiceUtils.getsynopticalTableList(request.getLoadableStudyId(), null);
    }

    if (!synopticalTableList.isEmpty()) {
      VesselInfo.VesselReply vesselReply =
          this.getSynopticalTableVesselData(request, loadableStudyOpt.get());
      List<VesselInfo.VesselTankDetail> sortedTankList =
          new ArrayList<>(vesselReply.getVesselTanksList());
      Collections.sort(
          sortedTankList, Comparator.comparing(VesselInfo.VesselTankDetail::getTankDisplayOrder));
      buildSynopticalTableReply(
          request,
          synopticalTableList,
          this.getSynopticalTablePortDetails(synopticalTableList),
          this.getSynopticalTablePortRotations(loadableStudyOpt.get()),
          loadableStudyOpt.get(),
          sortedTankList,
          vesselReply.getVesselLoadableQuantityDetails(),
          patternIds,
          replyBuilder);
    }

    replyBuilder.setDischargingStarted(dischargingStarted);
    replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS));
  }

  private Long getPatternId(LoadablePatternRequest.Builder lpRequest)
      throws GenericServiceException {
    Long patternId = 0L;
    LoadablePatternReply lpReply =
        loadablePatternService
            .getLoadablePatternList(lpRequest.build(), LoadablePatternReply.newBuilder())
            .build();
    if (lpReply.getResponseStatus().getStatus().equals(SUCCESS)) {
      Optional<com.cpdss.common.generated.LoadableStudy.LoadablePattern> optLp =
          lpReply.getLoadablePatternList().stream()
              .filter(item -> ((Long) item.getLoadableStudyStatusId()).equals(LS_STATUS_CONFIRMED))
              .findAny();
      if (optLp.isPresent()) {
        patternId = optLp.get().getLoadablePatternId();
      }
    }
    return patternId;
  }

  public void getSynopticalPortDataByPortId(
      LoadableStudy.SynopticalTableRequest request,
      LoadableStudy.SynopticalTableReply.Builder replyBuilder)
      throws GenericServiceException {
    Optional<com.cpdss.loadablestudy.entity.LoadableStudy> loadableStudyOpt =
        this.loadableStudyRepository.findById(request.getLoadableStudyId());
    if (!loadableStudyOpt.isPresent()) {
      throw new GenericServiceException(
          "Loadable study does not exist", CommonErrorCodes.E_HTTP_BAD_REQUEST, null);
    }
    List<SynopticalTable> synopticalTableList =
        this.synopticalTableRepository.findByLoadableStudyXIdAndIsActiveAndPortXid(
            request.getLoadableStudyId(), true, request.getPortId());
    if (!synopticalTableList.isEmpty()) {
      synpoticServiceUtils.buildSynopticalPortDataReplyByPortId(synopticalTableList, replyBuilder);
    }
    replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS));
  }

  public LoadableStudy.SynopticalTableReply.Builder saveSynopticalTable(
      LoadableStudy.SynopticalTableRequest request,
      LoadableStudy.SynopticalTableReply.Builder replyBuilder)
      throws GenericServiceException {
    Optional<com.cpdss.loadablestudy.entity.LoadableStudy> loadableStudyOpt =
        this.loadableStudyRepository.findByIdAndIsActive(request.getLoadableStudyId(), true);
    if (!loadableStudyOpt.isPresent()) {
      throw new GenericServiceException(
          "Loadable study does not exist with given id",
          CommonErrorCodes.E_HTTP_BAD_REQUEST,
          HttpStatusCode.BAD_REQUEST);
    }

    this.voyageService.checkIfVoyageClosed(loadableStudyOpt.get().getVoyage().getId());

    Optional<LoadablePattern> patternOpt = Optional.empty();
    if (request.getLoadablePatternId() > 0) {
      patternOpt =
          this.loadablePatternRepository.findByIdAndIsActive(request.getLoadablePatternId(), true);
      if (!patternOpt.isPresent()) {
        throw new GenericServiceException(
            "Loadable pattern does not exist with given id",
            CommonErrorCodes.E_HTTP_BAD_REQUEST,
            HttpStatusCode.BAD_REQUEST);
      }
    }
    for (LoadableStudy.SynopticalRecord record : request.getSynopticalRecordList()) {
      Optional<SynopticalTable> entityOpt =
          this.synopticalTableRepository.findByIdAndIsActive(record.getId(), true);
      if (!entityOpt.isPresent()) {
        throw new GenericServiceException(
            "Synoptical record does not exist with given id",
            CommonErrorCodes.E_HTTP_BAD_REQUEST,
            HttpStatusCode.BAD_REQUEST);
      }
      SynopticalTable entity = entityOpt.get();
      entity = this.buildSynopticalTableEntity(entity, record);
      entity = this.synopticalTableRepository.save(entity);
      this.saveSynopticalEtaEtdEstimates(entity, record);
      if (request.getLoadablePatternId() > 0) {
        this.saveSynopticalLoadicatorData(entity, request.getLoadablePatternId(), record);
        synpoticServiceUtils.saveSynopticalBallastData(
            request.getLoadablePatternId(), record, entity);
      }
      synpoticServiceUtils.saveSynopticalCargoData(
          request, loadableStudyOpt.get(), entity, record, false);
      synpoticServiceUtils.saveSynopticalOhqData(
          loadableStudyOpt.get(), entity, record, false, request.getFromOperations());
    }
    replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS).build());
    return replyBuilder;
  }

  /**
   * Populate synoptical entity fields
   *
   * @param entity
   * @param record
   * @return
   * @throws GenericServiceException
   */
  public SynopticalTable buildSynopticalTableEntity(
      SynopticalTable entity, LoadableStudy.SynopticalRecord record)
      throws GenericServiceException {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
    entity.setDistance(isEmpty(record.getDistance()) ? null : new BigDecimal(record.getDistance()));
    entity.setSpeed(isEmpty(record.getSpeed()) ? null : new BigDecimal(record.getSpeed()));
    entity.setRunningHours(
        isEmpty(record.getRunningHours()) ? null : new BigDecimal(record.getRunningHours()));
    entity.setInPortHours(
        isEmpty(record.getInPortHours()) ? null : new BigDecimal(record.getInPortHours()));
    entity.setTimeOfSunrise(
        isEmpty(record.getTimeOfSunrise())
            ? null
            : LocalTime.from(dtf.parse(record.getTimeOfSunrise())));
    entity.setTimeOfSunSet(
        isEmpty(record.getTimeOfSunset())
            ? null
            : LocalTime.from(dtf.parse(record.getTimeOfSunset())));
    entity.setHwTideFrom(
        isEmpty(record.getHwTideFrom()) ? null : new BigDecimal(record.getHwTideFrom()));
    entity.setHwTideTo(isEmpty(record.getHwTideTo()) ? null : new BigDecimal(record.getHwTideTo()));
    entity.setLwTideFrom(
        isEmpty(record.getLwTideFrom()) ? null : new BigDecimal(record.getLwTideFrom()));
    entity.setLwTideTo(isEmpty(record.getLwTideTo()) ? null : new BigDecimal(record.getLwTideTo()));
    entity.setHwTideTimeFrom(
        isEmpty(record.getHwTideTimeFrom())
            ? null
            : LocalTime.from(dtf.parse(record.getHwTideTimeFrom())));
    entity.setHwTideTimeTo(
        isEmpty(record.getHwTideTimeTo())
            ? null
            : LocalTime.from(dtf.parse(record.getHwTideTimeTo())));
    entity.setLwTideTimeFrom(
        isEmpty(record.getLwTideTimeFrom())
            ? null
            : LocalTime.from(dtf.parse(record.getLwTideTimeFrom())));
    entity.setLwTideTimeTo(
        isEmpty(record.getLwTideTimeTo())
            ? null
            : LocalTime.from(dtf.parse(record.getLwTideTimeTo())));
    synpoticServiceUtils.buidlSynopticalTableVesselData(entity, record);
    this.buildSynopticalTableEtaEtdActuals(entity, record);
    return entity;
  }

  /**
   * Update estimated values to port rotation table
   *
   * @param entity
   * @param record
   * @throws GenericServiceException
   */
  public void saveSynopticalEtaEtdEstimates(
      SynopticalTable entity, LoadableStudy.SynopticalRecord record)
      throws GenericServiceException {

    LoadableStudyPortRotation prEntity = entity.getLoadableStudyPortRotation();
    if (null == prEntity) {
      throw new GenericServiceException(
          "Port rotation does not exist for given synoptical record",
          CommonErrorCodes.E_HTTP_BAD_REQUEST,
          HttpStatusCode.BAD_REQUEST);
    }

    Optional<com.cpdss.loadablestudy.entity.LoadableStudy> loadableStudy =
        this.loadableStudyRepository.findByIdAndIsActive(entity.getLoadableStudyXId(), true);
    if (!loadableStudy.isPresent()) {
      throw new GenericServiceException(
          "Loadable study with given id does not exist",
          CommonErrorCodes.E_HTTP_BAD_REQUEST,
          HttpStatusCode.BAD_REQUEST);
    }

    synpoticServiceUtils.validateSaveSynopticalEtaEtdEstimates(
        entity, record, loadableStudy.get(), prEntity);

    LocalDateTime etaEtdEstimated =
        isEmpty(record.getEtaEtdEstimated())
            ? null
            : LocalDateTime.from(
                DateTimeFormatter.ofPattern(ETA_ETD_FORMAT).parse(record.getEtaEtdEstimated()));
    if (SYNOPTICAL_TABLE_OP_TYPE_ARRIVAL.equals(entity.getOperationType())) {
      prEntity.setEta(etaEtdEstimated);
    } else {
      prEntity.setEtd(etaEtdEstimated);
    }
    if (record.getSpecificGravity() != null && !isEmpty(record.getSpecificGravity())) {
      prEntity.setSeaWaterDensity(new BigDecimal(record.getSpecificGravity()));
    }
    this.loadableStudyPortRotationRepository.save(prEntity);
  }

  /**
   * Save synoptical table loadicator data
   *
   * @param entity
   * @param entity
   * @param loadablepatternId
   * @throws GenericServiceException
   */
  public void saveSynopticalLoadicatorData(
      SynopticalTable entity, Long loadablepatternId, LoadableStudy.SynopticalRecord record)
      throws GenericServiceException {
    com.cpdss.common.generated.LoadableStudy.SynopticalTableLoadicatorData data =
        record.getLoadicatorData();
    SynopticalTableLoadicatorData ldEntity =
        this.synopticalTableLoadicatorDataRepository
            .findBySynopticalTableAndLoadablePatternIdAndIsActive(entity, loadablepatternId, true);
    if (null == ldEntity) {
      log.info(
          "Loadicator data does not exist for given synoptical record with id {}", record.getId());
    } else {
      ldEntity.setDeflection(
          isEmpty(data.getDeflection()) ? null : new BigDecimal(data.getDeflection()));
      ldEntity.setCalculatedDraftFwdActual(
          isEmpty(data.getCalculatedDraftFwdActual())
              ? null
              : new BigDecimal(data.getCalculatedDraftFwdActual()));
      ldEntity.setCalculatedDraftAftActual(
          isEmpty(data.getCalculatedDraftAftActual())
              ? null
              : new BigDecimal(data.getCalculatedDraftAftActual()));
      ldEntity.setCalculatedDraftMidActual(
          isEmpty(data.getCalculatedDraftMidActual())
              ? null
              : new BigDecimal(data.getCalculatedDraftMidActual()));
      ldEntity.setCalculatedTrimActual(
          isEmpty(data.getCalculatedTrimActual())
              ? null
              : new BigDecimal(data.getCalculatedTrimActual()));
      ldEntity.setBlindSector(
          isEmpty(data.getBlindSector()) ? null : new BigDecimal(data.getBlindSector()));
      ldEntity.setBallastActual(
          isEmpty(record.getBallastActual()) ? null : new BigDecimal(record.getBallastActual()));
      this.synopticalTableLoadicatorDataRepository.save(ldEntity);
    }
  }

  /**
   * build eta etd actuals
   *
   * @param entity
   * @param record
   */
  public void buildSynopticalTableEtaEtdActuals(
      SynopticalTable entity, LoadableStudy.SynopticalRecord record) {
    LocalDateTime etaEtdActual =
        isEmpty(record.getEtaEtdActual())
            ? null
            : LocalDateTime.from(
                DateTimeFormatter.ofPattern(ETA_ETD_FORMAT).parse(record.getEtaEtdActual()));
    if (SYNOPTICAL_TABLE_OP_TYPE_ARRIVAL.equals(entity.getOperationType())) {
      entity.setEtaActual(etaEtdActual);
    } else {
      entity.setEtdActual(etaEtdActual);
    }
  }

  public LoadableStudy.SynopticalTableReply.Builder getSynopticalDataByPortId(
      LoadableStudy.SynopticalTableRequest request,
      LoadableStudy.SynopticalTableReply.Builder replyBuilder)
      throws GenericServiceException {
    Optional<com.cpdss.loadablestudy.entity.LoadableStudy> loadableStudyOpt =
        this.loadableStudyRepository.findByIdAndIsActive(request.getLoadableStudyId(), true);
    if (!loadableStudyOpt.isPresent()) {
      throw new GenericServiceException(
          "Loadable study does not exist", CommonErrorCodes.E_HTTP_BAD_REQUEST, null);
    }
    /**
     * updated the request object with confirmed loadable pattern id which is needed only for voyage
     * status initiated flow. In case this method is reused for any other flow then the loadable
     * pattern id should be updated accordingly using probably a flag to track initiated flow
     */
    List<LoadablePattern> confirmedLoadablePatternList =
        loadablePatternRepository.findByVoyageAndLoadableStudyStatusAndIsActive(
            request.getVoyageId(), CONFIRMED_STATUS_ID, true);
    Optional<LoadablePattern> confirmedLoadablePattern =
        confirmedLoadablePatternList.stream()
            .filter(
                v ->
                    (v.getLoadableStudy() != null)
                        && (v.getLoadableStudy().getId().equals(request.getLoadableStudyId())))
            .findAny();
    if (!confirmedLoadablePattern.isPresent()) {
      throw new GenericServiceException(
          "Confirmed loadable pattern does not exist", CommonErrorCodes.E_HTTP_BAD_REQUEST, null);
    }
    Long confirmedLoadablePatternId = confirmedLoadablePattern.get().getId();
    LoadableStudy.SynopticalTableRequest.Builder requestBuilder = request.toBuilder();
    requestBuilder.setLoadablePatternId(confirmedLoadablePatternId);
    // fetching synoptical entity list
    List<SynopticalTable> synopticalTableList =
        this.synopticalTableRepository.findByLoadableStudyXIdAndIsActiveAndPortXid(
            request.getLoadableStudyId(), true, request.getPortId());
    if (!synopticalTableList.isEmpty()) {
      // fetching vessel tanks including ohq and cargo tanks
      VesselInfo.VesselReply vesselReply =
          getSynopticalTableVesselData(request, loadableStudyOpt.get());
      // sorting the tanks based on tank display order from vessel tank table
      List<VesselInfo.VesselTankDetail> sortedTankList =
          new ArrayList<>(vesselReply.getVesselTanksList());
      Collections.sort(
          sortedTankList, Comparator.comparing(VesselInfo.VesselTankDetail::getTankDisplayOrder));
      LoadableStudy.SynopticalTableRequest stRequest = requestBuilder.build();
      buildSynopticalTableReply(
          stRequest,
          synopticalTableList,
          getSynopticalTablePortDetails(synopticalTableList),
          getSynopticalTablePortRotations(loadableStudyOpt.get()),
          loadableStudyOpt.get(),
          sortedTankList,
          vesselReply.getVesselLoadableQuantityDetails(),
          Arrays.asList(stRequest.getLoadablePatternId()),
          replyBuilder);
      // build ballast tank details not available in synoptical
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
      replyBuilder.addAllBallastFrontTanks(onHandQuantityService.groupTanks(frontBallastTanks));
      replyBuilder.addAllBallastCenterTanks(onHandQuantityService.groupTanks(centerBallastTanks));
      replyBuilder.addAllBallastRearTanks(onHandQuantityService.groupTanks(rearBallastTanks));
      // build cargo layout tanks not available in synoptical
      replyBuilder.addAllCargoTanks(
          onHandQuantityService.groupTanks(
              sortedTankList.stream()
                  .filter(tankList -> CARGO_TANK_CATEGORIES.contains(tankList.getTankCategoryId()))
                  .collect(Collectors.toList())));
    }
    replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS));
    return replyBuilder;
  }

  @Override
  public void updateSynopticalTable(
      SynopticalTableRequest request, StreamObserver<ResponseStatus> responseObserver) {
    ResponseStatus.Builder replyBuilder = ResponseStatus.newBuilder();

    try {
      Optional<Long> portRotationId =
          request.getSynopticalRecordList().stream()
              .map(SynopticalRecord::getPortRotationId)
              .findFirst();
      com.cpdss.common.generated.LoadableStudy.ActiveVoyage.Builder builder =
          LoadableStudy.ActiveVoyage.newBuilder();
      voyageService.fetchActiveVoyageByVesselId(
          builder, request.getVesselId(), LoadableStudiesConstants.ACTIVE_VOYAGE_STATUS);
      LoadableStudyDetail confirmedLoadableStudy = builder.getConfirmedLoadableStudy();
      Optional<com.cpdss.loadablestudy.entity.LoadableStudy> loadableStudy =
          loadableStudyRepository.findById(confirmedLoadableStudy.getId());
      Optional<SynopticalTable> synopticalData =
          synopticalTableRepository.findByLoadableStudyAndPortRotationAndOperationTypeAndIsActive(
              confirmedLoadableStudy.getId(),
              portRotationId.get(),
              request.getOperationType(),
              true);
      // checking whether the port rotation is part of discharge study
      if (synopticalData.isEmpty()) {
        loadableStudy =
            loadableStudyRepository.findById(builder.getConfirmedDischargeStudy().getId());
        synopticalData =
            synopticalTableRepository.findByLoadableStudyAndPortRotationAndOperationTypeAndIsActive(
                builder.getConfirmedDischargeStudy().getId(),
                portRotationId.get(),
                request.getOperationType(),
                true);
      }
      if (synopticalData.isEmpty()) {
        throw new GenericServiceException(
            "Synoptic Data Not Found for Port Rotation Id "
                + portRotationId
                + ", Type "
                + request.getOperationType(),
            CommonErrorCodes.E_HTTP_BAD_REQUEST,
            HttpStatusCode.BAD_REQUEST);
      }
      for (SynopticalRecord synopticalRecord : request.getSynopticalRecordList()) {
        synpoticServiceUtils.saveSynopticalBallastData(
            request.getLoadablePatternId(), synopticalRecord, synopticalData.get());
        synpoticServiceUtils.saveSynopticalCargoData(
            request, loadableStudy.get(), synopticalData.get(), synopticalRecord, true);
        synpoticServiceUtils.saveSynopticalOhqData(
            loadableStudy.get(),
            synopticalData.get(),
            synopticalRecord,
            true,
            request.getFromOperations());
        synpoticServiceUtils.saveSynopticalCommingleData(request, synopticalData, synopticalRecord);
      }
      replyBuilder.setStatus(SUCCESS);
    } catch (GenericServiceException e) {
      TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
      log.error("Error saving loadable study", e);
      replyBuilder
          .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
          .setHttpStatusCode(HttpStatusCode.INTERNAL_SERVER_ERROR.value())
          .setMessage("Error saving loadable study")
          .setStatus(FAILED)
          .build();
    } catch (Exception e) {
      e.printStackTrace();
      TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
      replyBuilder.setStatus(FAILED).setMessage(e.getMessage()).build();
      log.info("Failed to build synoptic data, {}", e.getMessage());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }
}
