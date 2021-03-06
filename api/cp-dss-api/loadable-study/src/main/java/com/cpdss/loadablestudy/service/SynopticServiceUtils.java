/* Licensed at AlphaOri Technologies */
package com.cpdss.loadablestudy.service;

import static com.cpdss.loadablestudy.utility.LoadableStudiesConstants.*;
import static java.lang.String.valueOf;
import static java.util.Optional.ofNullable;
import static org.springframework.util.StringUtils.isEmpty;

import com.cpdss.common.exception.GenericServiceException;
import com.cpdss.common.generated.Common;
import com.cpdss.common.generated.LoadableStudy;
import com.cpdss.common.generated.LoadableStudy.LoadablePlanBallastDetails;
import com.cpdss.common.generated.LoadableStudy.LoadingPlanCommonResponse.Builder;
import com.cpdss.common.generated.LoadableStudy.LoadingPlanIdRequest;
import com.cpdss.common.generated.LoadableStudy.SynopticalCommingleRecord;
import com.cpdss.common.generated.LoadableStudy.SynopticalRecord;
import com.cpdss.common.generated.LoadableStudy.SynopticalTableRequest;
import com.cpdss.common.generated.PortInfo;
import com.cpdss.common.generated.PortInfoServiceGrpc;
import com.cpdss.common.generated.VesselInfo;
import com.cpdss.common.generated.VesselInfoServiceGrpc;
import com.cpdss.common.generated.discharge_plan.DischargeInformation;
import com.cpdss.common.generated.discharge_plan.DischargeInformationServiceGrpc;
import com.cpdss.common.generated.loading_plan.LoadingInformationServiceGrpc;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels;
import com.cpdss.common.rest.CommonErrorCodes;
import com.cpdss.common.utils.HttpStatusCode;
import com.cpdss.loadablestudy.entity.*;
import com.cpdss.loadablestudy.repository.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 * util functions which is consumed by {@link SynopticService}
 *
 * @author arun.j
 */
@Slf4j
@Service
@Transactional
public class SynopticServiceUtils {

  @Autowired SynopticalTableRepository synopticalTableRepository;

  @Autowired LoadablePlanQuantityRepository loadablePlanQuantityRepository;

  @Autowired CargoNominationRepository cargoNominationRepository;

  @Autowired CargoNominationOperationDetailsRepository cargoNominationOperationDetailsRepository;

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

  @Autowired LoadablePlanService loadablePlanService;

  @Autowired
  private LoadablePlanCommingleDetailsPortwiseRepository
      loadablePlanCommingleDetailsPortwiseRepository;

  @Autowired private LoadableStudyPortRotationService loadableStudyPortRotationService;

  @GrpcClient("portInfoService")
  private PortInfoServiceGrpc.PortInfoServiceBlockingStub portInfoGrpcService;

  @GrpcClient("vesselInfoService")
  private VesselInfoServiceGrpc.VesselInfoServiceBlockingStub vesselInfoGrpcService;

  @GrpcClient("loadingPlanService")
  private LoadingInformationServiceGrpc.LoadingInformationServiceBlockingStub
      loadingInfoServiceBlockingStub;

  @GrpcClient("dischargeInformationService")
  private DischargeInformationServiceGrpc.DischargeInformationServiceBlockingStub
      dischargeInformationGrpcService;

  @Autowired SynopticalTableLoadicatorDataRepository synopticalTableLoadicatorDataRepository;

  @Autowired DischargePatternQuantityCargoPortwiseRepository disCargoQuantityRepository;

  @Autowired LoadablePlanCommingleDetailsPortwiseRepository commingleDetailsPortWiseRepository;

  /**
   * Save synoptical ballast data
   *
   * @param loadablePatternId
   * @param record
   * @param entity
   */
  public void saveSynopticalBallastData(
      long loadablePatternId, LoadableStudy.SynopticalRecord record, SynopticalTable entity) {
    log.info("Saving ballast data to synoptical table {}", entity.getId());
    List<LoadablePlanStowageBallastDetails> ballastEntities =
        this.loadablePlanStowageBallastDetailsRepository
            .findByLoadablePatternIdAndPortRotationIdAndOperationTypeAndIsActive(
                loadablePatternId,
                entity.getLoadableStudyPortRotation().getId(),
                entity.getOperationType(),
                true);
    List<LoadablePlanStowageBallastDetails> toBeSaved = new ArrayList<>();
    if (!record.getBallastList().isEmpty()) {
      for (LoadableStudy.SynopticalBallastRecord rec : record.getBallastList()) {
        Optional<LoadablePlanStowageBallastDetails> entityOpt =
            ballastEntities.stream()
                .filter(b -> b.getTankXId().longValue() == rec.getTankId())
                .findAny();
        if (entityOpt.isPresent()) {
          LoadablePlanStowageBallastDetails ent = entityOpt.get();
          ent.setActualQuantity(
              isEmpty(rec.getActualWeight()) ? null : new BigDecimal(rec.getActualWeight()));
          toBeSaved.add(ent);
        } else {
          LoadablePlanStowageBallastDetails ent = new LoadablePlanStowageBallastDetails();
          ent.setTankXId(rec.getTankId());
          ent.setIsActive(true);
          ent.setLoadablePatternId(loadablePatternId);
          ent.setPortXId(entity.getPortXid());
          ent.setOperationType(entity.getOperationType());
          ent.setPortRotationId(entity.getLoadableStudyPortRotation().getId());
          ent.setActualQuantity(
              isEmpty(rec.getActualWeight()) ? null : new BigDecimal(rec.getActualWeight()));
          toBeSaved.add(ent);
        }
      }
      this.loadablePlanStowageBallastDetailsRepository.saveAll(toBeSaved);
    }
  }

  /**
   * Save cargo data
   *
   * @param request
   * @param loadableStudy
   * @param entity
   * @param request
   * @throws GenericServiceException
   */
  public void saveSynopticalCargoData(
      LoadableStudy.SynopticalTableRequest request,
      com.cpdss.loadablestudy.entity.LoadableStudy loadableStudy,
      SynopticalTable entity,
      LoadableStudy.SynopticalRecord record,
      boolean isUpdate)
      throws GenericServiceException {
    log.info("Saving cargo data to synoptical table {}", entity.getId());
    List<Long> portIds = loadableStudyPortRotationService.getPortRoationPortIds(loadableStudy);
    if (null == portIds || portIds.isEmpty()) {
      throw new GenericServiceException(
          "No ports added for loadable study with id: " + loadableStudy.getId(),
          CommonErrorCodes.E_HTTP_BAD_REQUEST,
          HttpStatusCode.BAD_REQUEST);
    }
    Long firstPortId = portIds.get(0);
    if (entity.getPortXid().equals(firstPortId)
        && SYNOPTICAL_TABLE_OP_TYPE_ARRIVAL.equals(entity.getOperationType())
        && loadableStudy.getPlanningTypeXId().equals(PLANNING_TYPE_LOADING)) {
      this.saveSynopticalObqData(loadableStudy, record, isUpdate);
    } else if (request.getLoadablePatternId() > 0) {
      this.saveSynopticalCargoByLoadablePattern(request, entity, record);
    }
  }

  public void saveSynopticalOhqData(
      com.cpdss.loadablestudy.entity.LoadableStudy loadableStudy,
      SynopticalTable entity,
      LoadableStudy.SynopticalRecord record,
      boolean isUpdate,
      boolean fromOperations)
      throws GenericServiceException {
    log.info("Saving OHQ data to synoptical table {}", entity.getId());
    List<OnHandQuantity> ohqEntities =
        this.onHandQuantityRepository.findByLoadableStudyAndPortRotationAndIsActive(
            loadableStudy, entity.getLoadableStudyPortRotation(), true);
    List<OnHandQuantity> toBeSavedList = new ArrayList<>();

    for (LoadableStudy.SynopticalOhqRecord ohqRecord : record.getOhqList()) {
      OnHandQuantity ohqEntity = null;
      Optional<OnHandQuantity> ohqEntityOpt =
          ohqEntities.stream()
              .filter(ohq -> ohq.getTankXId().equals(ohqRecord.getTankId()))
              .findAny();
      if (ohqEntityOpt.isPresent()) {
        ohqEntity = ohqEntityOpt.get();
      } else {

        ohqEntity = new OnHandQuantity();
        ohqEntity.setTankXId(ohqRecord.getTankId());
        ohqEntity.setPortXId(record.getPortId());
        ohqEntity.setFuelTypeXId(ohqRecord.getFuelTypeId());
        ohqEntity.setLoadableStudy(loadableStudy);
        ohqEntity.setPortRotation(entity.getLoadableStudyPortRotation());
        ohqEntity.setIsActive(true);
      }
      // if the update happening from loading plan to save actual then there is no need to call
      // validate
      if (!isUpdate) {
        this.validateSaveSynopticalOhqData(ohqEntity, entity, ohqRecord, loadableStudy);
      }
      if (SYNOPTICAL_TABLE_OP_TYPE_ARRIVAL.equals(entity.getOperationType())) {
        if (!fromOperations) {
          ohqEntity.setArrivalQuantity(
              isEmpty(ohqRecord.getPlannedWeight())
                  ? null
                  : new BigDecimal(ohqRecord.getPlannedWeight()));
        }
        ohqEntity.setActualArrivalQuantity(
            isEmpty(ohqRecord.getActualWeight())
                ? null
                : new BigDecimal(ohqRecord.getActualWeight()));
      } else {
        if (!fromOperations) {
          ohqEntity.setDepartureQuantity(
              isEmpty(ohqRecord.getPlannedWeight())
                  ? null
                  : new BigDecimal(ohqRecord.getPlannedWeight()));
        }
        ohqEntity.setActualDepartureQuantity(
            isEmpty(ohqRecord.getActualWeight())
                ? null
                : new BigDecimal(ohqRecord.getActualWeight()));
      }
      toBeSavedList.add(ohqEntity);
    }
    if (!toBeSavedList.isEmpty()) {
      this.onHandQuantityRepository.saveAll(toBeSavedList);
    }
  }

  void validateSynopticalVesselData(
      com.cpdss.loadablestudy.entity.LoadableStudy loadablestudy,
      SynopticalTable entity,
      LoadableStudy.SynopticalRecord record)
      throws GenericServiceException {
    List<LoadablePattern> generatedPatterns =
        this.loadablePatternRepository.findLoadablePatterns(
            LOADABLE_STUDY_STATUS_PLAN_GENERATED_ID, loadablestudy, true);

    List<LoadablePattern> confirmedPatterns =
        this.loadablePatternRepository.findLoadablePatterns(
            CONFIRMED_STATUS_ID, loadablestudy, true);
    if ((!generatedPatterns.isEmpty() || !confirmedPatterns.isEmpty())
        && ((null != entity.getOthersPlanned()
                && entity.getOthersPlanned().doubleValue()
                    != Double.parseDouble(record.getOthersPlanned()))
            || (null != entity.getConstantPlanned()
                && entity.getConstantPlanned().doubleValue()
                    != Double.parseDouble(record.getConstantPlanned()))
        // || (null != entity.getDeadWeightPlanned()
        // && entity.getDeadWeightPlanned().doubleValue() !=
        // Double.parseDouble(record.getTotalDwtPlanned()))
        // || (null != entity.getDisplacementPlanned()
        // && entity.getDisplacementPlanned().doubleValue() !=
        // Double.parseDouble(record.getDisplacementPlanned()))
        )) {
      throw new GenericServiceException(
          "Cannot update planned values for plan generated loadable study",
          CommonErrorCodes.E_CPDSS_SAVE_NOT_ALLOWED,
          HttpStatusCode.BAD_REQUEST);
    }
  }

  /**
   * Save obq data from synoptical table
   *
   * @param loadableStudy
   * @param record
   * @param isUpdate
   * @throws GenericServiceException
   */
  public void saveSynopticalObqData(
      com.cpdss.loadablestudy.entity.LoadableStudy loadableStudy,
      LoadableStudy.SynopticalRecord record,
      boolean isUpdate)
      throws GenericServiceException {
    List<OnBoardQuantity> obqEntities =
        this.onBoardQuantityRepository.findByLoadableStudyAndPortIdAndIsActive(
            loadableStudy, record.getPortId(), true);
    List<OnBoardQuantity> toBeSavedList = new ArrayList<>();

    for (LoadableStudy.SynopticalCargoRecord cargoRecord : record.getCargoList()) {

      OnBoardQuantity obqEntity = null;
      Optional<OnBoardQuantity> obqEntityOpt =
          obqEntities.stream()
              .filter(obq -> obq.getTankId().equals(cargoRecord.getTankId()))
              .findAny();
      if (obqEntityOpt.isPresent()) {

        obqEntity = obqEntityOpt.get();

      } else {
        obqEntity = new OnBoardQuantity();
        obqEntity.setTankId(cargoRecord.getTankId());
        obqEntity.setPortId(record.getPortId());
        obqEntity.setLoadableStudy(loadableStudy);
        obqEntity.setIsActive(true);
      }
      if (!isUpdate) {
        this.validateSaveSynopticalObqData(obqEntity, cargoRecord, loadableStudy);
      }

      obqEntity.setPlannedArrivalWeight(
          isEmpty(cargoRecord.getPlannedWeight())
              ? null
              : new BigDecimal(cargoRecord.getPlannedWeight()));
      obqEntity.setActualArrivalWeight(
          isEmpty(cargoRecord.getActualWeight())
              ? null
              : new BigDecimal(cargoRecord.getActualWeight()));
      toBeSavedList.add(obqEntity);
    }
    if (!toBeSavedList.isEmpty()) {
      this.onBoardQuantityRepository.saveAll(toBeSavedList);
    }
  }

  /**
   * Save synoptical cargo data by loadable pattern id
   *
   * @param request
   * @param entity
   * @param record
   */
  public void saveSynopticalCargoByLoadablePattern(
      LoadableStudy.SynopticalTableRequest request,
      SynopticalTable entity,
      LoadableStudy.SynopticalRecord record) {
    List<com.cpdss.loadablestudy.entity.LoadablePatternCargoDetails> cargoEntities =
        this.loadablePatternCargoDetailsRepository
            .findByLoadablePatternIdAndPortRotationIdAndOperationTypeAndIsActive(
                request.getLoadablePatternId(),
                entity.getLoadableStudyPortRotation().getId(),
                entity.getOperationType(),
                true);

    List<com.cpdss.loadablestudy.entity.LoadablePlanComminglePortwiseDetails>
        commingleCargoEntities =
            this.loadablePlanCommingleDetailsPortwiseRepository
                .findByLoadablePatternIdAndPortRotationIdAndOperationTypeAndIsActive(
                    request.getLoadablePatternId(),
                    entity.getLoadableStudyPortRotation().getId(),
                    entity.getOperationType(),
                    true);
    List<com.cpdss.loadablestudy.entity.LoadablePatternCargoDetails> toBeSavedCargoList =
        new ArrayList<>();

    List<com.cpdss.loadablestudy.entity.LoadablePlanComminglePortwiseDetails>
        toBeSavedCommingleCargoList = new ArrayList<>();

    for (LoadableStudy.SynopticalCargoRecord cargoRecord : record.getCargoList()) {
      if (!cargoRecord.getIsCommingleCargo()) {
        Optional<com.cpdss.loadablestudy.entity.LoadablePatternCargoDetails> entityOpt =
            cargoEntities.stream()
                .filter(cargo -> cargo.getTankId().equals(cargoRecord.getTankId()))
                .findAny();
        if (entityOpt.isPresent()) {
          com.cpdss.loadablestudy.entity.LoadablePatternCargoDetails cargoEntity = entityOpt.get();
          cargoEntity.setActualQuantity(
              isEmpty(cargoRecord.getActualWeight())
                  ? null
                  : new BigDecimal(cargoRecord.getActualWeight()));
          Optional.ofNullable(cargoRecord.getUllage())
              .filter(value -> !value.isEmpty())
              .ifPresent(value -> cargoEntity.setActualRdgUllage(new BigDecimal(value)));
          Optional.ofNullable(cargoRecord.getActualApi())
              .filter(value -> !value.isEmpty())
              .ifPresent(value -> cargoEntity.setActualApi(new BigDecimal(value)));
          Optional.ofNullable(cargoRecord.getActualTemperature())
              .filter(value -> !value.isEmpty())
              .ifPresent(value -> cargoEntity.setActualTemperature(new BigDecimal(value)));
          toBeSavedCargoList.add(cargoEntity);
        } else {
          com.cpdss.loadablestudy.entity.LoadablePatternCargoDetails cargoEntity =
              new com.cpdss.loadablestudy.entity.LoadablePatternCargoDetails();
          cargoEntity.setLoadablePatternId(request.getLoadablePatternId());
          cargoEntity.setPortId(entity.getPortXid());
          cargoEntity.setTankId(cargoRecord.getTankId());
          cargoEntity.setIsActive(true);
          cargoEntity.setOperationType(entity.getOperationType());
          cargoEntity.setPortRotationId(entity.getLoadableStudyPortRotation().getId());
          //	Currently we are only setting actual api and actual temperature.
          //	Optional.ofNullable(cargoRecord.getApi())
          //    	.ifPresent(value -> cargoEntity.setApi(new BigDecimal(value)));
          //    Optional.ofNullable(cargoRecord.getTemperature())
          //        .ifPresent(value -> cargoEntity.setTemperature(new BigDecimal(value)));
          cargoEntity.setActualQuantity(
              isEmpty(cargoRecord.getActualWeight())
                  ? null
                  : new BigDecimal(cargoRecord.getActualWeight()));
          toBeSavedCargoList.add(cargoEntity);
        }
      } else {
        Optional<com.cpdss.loadablestudy.entity.LoadablePlanComminglePortwiseDetails>
            comminleEntityOpt =
                commingleCargoEntities.stream()
                    .filter(
                        commingleCargo ->
                            commingleCargo.getTankId().equals(commingleCargo.getTankId()))
                    .findAny();
        if (comminleEntityOpt.isPresent()) {
          com.cpdss.loadablestudy.entity.LoadablePlanComminglePortwiseDetails commingleCargoEntity =
              comminleEntityOpt.get();

          commingleCargoEntity.setActualQuantity(
              isEmpty(cargoRecord.getActualWeight())
                  ? null
                  : new BigDecimal(cargoRecord.getActualWeight()));

          toBeSavedCommingleCargoList.add(commingleCargoEntity);
        } else {
          com.cpdss.loadablestudy.entity.LoadablePlanComminglePortwiseDetails commingleCargoEntity =
              new com.cpdss.loadablestudy.entity.LoadablePlanComminglePortwiseDetails();

          LoadablePattern loadablePattern =
              this.loadablePatternRepository.getOne(request.getLoadablePatternId());
          commingleCargoEntity.setLoadablePattern(loadablePattern);
          commingleCargoEntity.setPortId(entity.getPortXid());
          commingleCargoEntity.setTankId(cargoRecord.getTankId());
          commingleCargoEntity.setIsActive(true);
          commingleCargoEntity.setOperationType(entity.getOperationType());
          commingleCargoEntity.setPortRotationXid(entity.getLoadableStudyPortRotation().getId());
          commingleCargoEntity.setActualQuantity(
              isEmpty(cargoRecord.getActualWeight())
                  ? null
                  : new BigDecimal(cargoRecord.getActualWeight()));

          toBeSavedCommingleCargoList.add(commingleCargoEntity);
        }
      }
    }
    if (!toBeSavedCargoList.isEmpty()) {
      this.loadablePatternCargoDetailsRepository.saveAll(toBeSavedCargoList);
    }

    if (!toBeSavedCommingleCargoList.isEmpty()) {
      this.loadablePlanCommingleDetailsPortwiseRepository.saveAll(toBeSavedCommingleCargoList);
    }
  }

  public void validateSaveSynopticalOhqData(
      OnHandQuantity ohqEntity,
      SynopticalTable entity,
      LoadableStudy.SynopticalOhqRecord ohqRecord,
      com.cpdss.loadablestudy.entity.LoadableStudy loadableStudy)
      throws GenericServiceException {

    List<LoadablePattern> generatedPatterns =
        this.loadablePatternRepository.findLoadablePatterns(
            LOADABLE_STUDY_STATUS_PLAN_GENERATED_ID, loadableStudy, true);

    List<LoadablePattern> confirmedPatterns =
        this.loadablePatternRepository.findLoadablePatterns(
            CONFIRMED_STATUS_ID, loadableStudy, true);

    if ((!generatedPatterns.isEmpty() || !confirmedPatterns.isEmpty())
        && ((SYNOPTICAL_TABLE_OP_TYPE_ARRIVAL.equals(entity.getOperationType())
                && ohqEntity.getArrivalQuantity() != null
                && ohqEntity.getArrivalQuantity().doubleValue()
                    != Double.parseDouble(ohqRecord.getPlannedWeight()))
            || (SYNOPTICAL_TABLE_OP_TYPE_DEPARTURE.equals(entity.getOperationType())
                && ohqEntity.getDepartureQuantity() != null
                && ohqEntity.getDepartureQuantity().doubleValue()
                    != Double.parseDouble(ohqRecord.getPlannedWeight())))) {

      throw new GenericServiceException(
          "Cannot update planned values for plan generated loadable study",
          CommonErrorCodes.E_CPDSS_SAVE_NOT_ALLOWED,
          HttpStatusCode.BAD_REQUEST);
    }
  }

  public void validateSaveSynopticalObqData(
      OnBoardQuantity obqEntity,
      LoadableStudy.SynopticalCargoRecord cargoRecord,
      com.cpdss.loadablestudy.entity.LoadableStudy loadableStudy)
      throws GenericServiceException {

    List<LoadablePattern> generatedPatterns =
        this.loadablePatternRepository.findLoadablePatterns(
            LOADABLE_STUDY_STATUS_PLAN_GENERATED_ID, loadableStudy, true);

    List<LoadablePattern> confirmedPatterns =
        this.loadablePatternRepository.findLoadablePatterns(
            CONFIRMED_STATUS_ID, loadableStudy, true);

    if ((!generatedPatterns.isEmpty() || !confirmedPatterns.isEmpty())
        && null != obqEntity.getPlannedArrivalWeight()
        && !cargoRecord
            .getPlannedWeight()
            .equals(Integer.toString(obqEntity.getPlannedArrivalWeight().intValue()))) {
      throw new GenericServiceException(
          "Cannot update planned values for plan generated loadable study",
          CommonErrorCodes.E_CPDSS_SAVE_NOT_ALLOWED,
          HttpStatusCode.BAD_REQUEST);
    }
  }

  /**
   * Populates ballast Details based on Loadable Pattern Id and Port Rotation
   *
   * @param request
   * @param builder
   * @param repBuilder
   */
  public void buildBallastDetailsBasedOnPort(
      LoadingPlanIdRequest request,
      Builder builder,
      com.cpdss.common.generated.Common.ResponseStatus.Builder repBuilder) {

    List<LoadablePlanStowageBallastDetails> ballastDetails =
        this.loadablePlanStowageBallastDetailsRepository
            .findByLoadablePatternIdAndPortRotationIdAndIsActive(
                request.getPatternId(), request.getId(), true);
    if (!ballastDetails.isEmpty()) {
      builder.setResponseStatus(repBuilder.setStatus(SUCCESS).build());
    }
    ballastDetails.forEach(
        ballast -> {
          LoadablePlanBallastDetails.Builder ballastBuilder =
              LoadablePlanBallastDetails.newBuilder();
          Optional.ofNullable(ballast.getColorCode()).ifPresent(ballastBuilder::setColorCode);
          Optional.ofNullable(ballast.getCorrectionFactor())
              .ifPresent(ballastBuilder::setCorrectionFactor);
          Optional.ofNullable(ballast.getFillingPercentage())
              .ifPresent(ballastBuilder::setPercentage);
          Optional.ofNullable(ballast.getTankXId()).ifPresent(ballastBuilder::setTankId);
          Optional.ofNullable(ballast.getOperationType()).ifPresent(ballast::setOperationType);
          builder.addLoadablePlanBallastDetails(ballastBuilder.build());
        });
  }

  // Single Entry with the Operation Type - ARR
  public void buildPortRotationResponse(
      Long id,
      LoadableStudy.LoadingPlanCommonResponse.Builder builder,
      Common.ResponseStatus.Builder repBuilder)
      throws GenericServiceException {
    List<SynopticalTable> list = synopticalTableRepository.findAllByPortRotationId(id);
    if (list.isEmpty()) {
      log.error(
          "Synoptic Data Not Found for Port Rotation Id {}, Operation Type {}",
          id,
          OPERATION_TYPE_ARR);
      throw new GenericServiceException(
          "Synoptic Data Not Found for Port Rotation Id " + id + ", Type ARR",
          CommonErrorCodes.E_HTTP_BAD_REQUEST,
          HttpStatusCode.BAD_REQUEST);
    }
    log.info(
        "Synoptic Record Found for Port Rotation Id {}, Ids {}",
        id,
        list.stream().map(SynopticalTable::getId).collect(Collectors.toList()));
    try {
      for (SynopticalTable data : list) {
        LoadableStudy.LoadingSynopticResponse.Builder builder1 =
            LoadableStudy.LoadingSynopticResponse.newBuilder();
        Optional.ofNullable(data.getId()).ifPresent(builder1::setSynopticTableId);
        Optional.ofNullable(data.getLoadableStudyXId()).ifPresent(builder1::setLoadableStudyId);
        if (data.getLoadableStudyPortRotation() != null) {
          Optional.ofNullable(data.getLoadableStudyPortRotation().getId())
              .ifPresent(builder1::setPortRotationId);
          Optional.ofNullable(data.getPortXid()).ifPresent(builder1::setPortId);
        }
        Optional.ofNullable(data.getOperationType()).ifPresent(builder1::setOperationType);
        Optional.ofNullable(data.getTimeOfSunrise())
            .ifPresent(v -> builder1.setTimeOfSunrise(TIME_FORMATTER.format(v)));
        Optional.ofNullable(data.getTimeOfSunSet())
            .ifPresent(v -> builder1.setTimeOfSunset(TIME_FORMATTER.format(v)));
        builder.addSynopticData(builder1.build());
        builder.setResponseStatus(repBuilder.setStatus(SUCCESS).build());
      }
    } catch (Exception e) {
      builder.setResponseStatus(repBuilder.setStatus(FAILED).setMessage(e.getMessage()).build());
      e.printStackTrace();
      log.info("Failed to build synoptic data, {}", e.getMessage());
      throw new GenericServiceException(
          "Synoptic Data Builder Exception",
          CommonErrorCodes.E_HTTP_BAD_REQUEST,
          HttpStatusCode.BAD_REQUEST);
    }
  }

  public void buildCargoToBeDischargedFroPort(
      LoadableStudy.LoadingPlanIdRequest request,
      LoadableStudy.LoadingPlanCommonResponse.Builder builder,
      Common.ResponseStatus.Builder repBuilder) {

    List<DischargePatternQuantityCargoPortwiseDetails> disList =
        this.disCargoQuantityRepository.findAllByLoadablePatternIdAndIsActiveTrue(
            request.getPatternId());
    if (!disList.isEmpty()) {
      List<DischargePatternQuantityCargoPortwiseDetails> dataList = new ArrayList<>();
      if (request.getCargoNominationFilter()) {
        Set<Long> nominationIds =
            getCargoNominationIdList(request.getPatternId(), request.getPortId());
        dataList =
            disList.stream()
                .filter(v -> nominationIds.contains(v.getDischargeCargoNominationId()))
                .collect(Collectors.toList());
      } else {
        dataList = disList; // no filter, add all data
      }

      // Get api, temp and maxDischargingRate edited if present from
      // discharging_cargo_api_temperature table in discharging plan DB
      DischargeInformation.Builder dischargingInfoBuilder =
          DischargeInformation.newBuilder().setDischargeInfoId(request.getDischargingInfoId());
      DischargeInformation dischargeInformation =
          this.dischargeInformationGrpcService.getCargoToBeDischarged(
              dischargingInfoBuilder.build());

      // Map to map cargoNominationId with Cargo To Be Discharged Details
      Map<Long, LoadableStudy.DischargeQuantityCargoDetails> cargoNominationMapped =
          new HashMap<>();

      dischargeInformation
          .getDischargeQuantityCargoDetailsList()
          .forEach(
              dischargeQuantityCargoDetails ->
                  cargoNominationMapped.put(
                      dischargeQuantityCargoDetails.getCargoNominationId(),
                      dischargeQuantityCargoDetails));
      // Filter by PortId, Operation Type
      var quantityList =
          dataList.stream()
              .filter(
                  v ->
                      (v.getPortId().equals(request.getPortId()))
                          && (v.getOperationType().equals(request.getOperationType())))
              .collect(Collectors.toList());

      // build Entity to Message
      if (!quantityList.isEmpty()) {
        for (DischargePatternQuantityCargoPortwiseDetails var1 : quantityList) {
          LoadableStudy.LoadableQuantityCargoDetails.Builder builder1 =
              LoadableStudy.LoadableQuantityCargoDetails.newBuilder();
          Optional.ofNullable(var1.getId()).ifPresent(builder1::setId);
          // Optional.ofNullable(var1.getGrade()).ifPresent(builder1::setGrade);

          if (cargoNominationMapped.containsKey(var1.getCargoNominationId())) {

            LoadableStudy.DischargeQuantityCargoDetails dischargeQuantityCargoDetails =
                cargoNominationMapped.get(var1.getCargoNominationId());

            Optional.of(dischargeQuantityCargoDetails.getEstimatedApi())
                .ifPresent(builder1::setEstimatedAPI);
            Optional.of(dischargeQuantityCargoDetails.getEstimatedTemp())
                .ifPresent(builder1::setEstimatedTemp);
            Optional.of(dischargeQuantityCargoDetails.getMaxDischargingRate())
                .ifPresent(builder1::setDischargingRate);
          } else {

            Optional.ofNullable(var1.getEstimatedAPI())
                .ifPresent(v -> builder1.setEstimatedAPI(v.toString()));
            Optional.ofNullable(var1.getEstimatedTemp())
                .ifPresent(v -> builder1.setEstimatedTemp(v.toString()));
            Optional.ofNullable(var1.getDischargingRate())
                .ifPresent(value -> builder1.setDischargingRate(value.toString()));
          }

          Optional.ofNullable(var1.getCargoNominationTemperature())
              .ifPresent(v -> builder1.setCargoNominationTemperature(v.toString()));
          Optional.ofNullable(var1.getDischargeMT())
              .ifPresent(value1 -> builder1.setDischargeMT(value1.toString()));
          Optional.ofNullable(var1.getDifferencePercentage())
              .ifPresent(value -> builder1.setDifferencePercentage(value.toString()));
          Optional.ofNullable(var1.getCargoId()).ifPresent(builder1::setCargoId);
          Optional.ofNullable(var1.getCargoAbbreviation())
              .ifPresent(builder1::setCargoAbbreviation);
          Optional.ofNullable(var1.getColorCode()).ifPresent(builder1::setColorCode);
          Optional.ofNullable(var1.getPriority()).ifPresent(builder1::setPriority);
          Optional.ofNullable(var1.getLoadingOrder()).ifPresent(builder1::setLoadingOrder);
          Optional.ofNullable(var1.getSlopQuantity())
              .ifPresent(value -> builder1.setSlopQuantity(value.toString()));
          Optional.ofNullable(var1.getOrderedQuantity())
              .ifPresent(
                  v -> {
                    builder1.setOrderedQuantity(v.toString());
                  });
          cargoNominationOperationDetailsRepository
              .findByCargoNomination_IdAndPortIdAndIsActiveTrue(
                  var1.getDischargeCargoNominationId(), var1.getPortId())
              .ifPresent(
                  cargoNominationPortDetails -> {
                    builder1.setCargoNominationQuantity(
                        String.valueOf(cargoNominationPortDetails.getQuantity()));
                  });
          Optional.ofNullable(var1.getCargoNominationId())
              .ifPresent(builder1::setCargoNominationId);
          Optional.ofNullable(var1.getDischargeCargoNominationId())
              .ifPresent(builder1::setDscargoNominationId);
          Optional.ofNullable(var1.getTimeRequiredForDischarging())
              .ifPresent(value -> builder1.setTimeRequiredForDischarging(String.valueOf(value)));

          Optional.ofNullable(var1.getIsCommingled()).ifPresent(builder1::setIsCommingled);
          Optional.ofNullable(var1.getIfProtested()).ifPresent(builder1::setIfProtested);

          try {
            this.setLoadingPortNameFromCargoOperation(
                var1.getCargoId(), var1.getCargoNominationId(), builder1);
          } catch (Exception e) {
            log.error("Failed to set Loading port names");
          }

          builder.addLoadableQuantityCargoDetails(builder1.build());
        }
      }
    }
    builder.setResponseStatus(repBuilder.setStatus(SUCCESS).build());
    log.info("Get Discharge Quantity details for patter Id {}", request.getPatternId());
  }

  public Set<Long> getCargoNominationIdList(Long patternId, Long portId) {
    // Need to filter based on the cargo nomination id
    Optional<LoadablePattern> lp = loadablePatternRepository.findByIdAndIsActive(patternId, true);
    if (lp.isPresent()) {
      Long studyId = lp.get().getLoadableStudy().getId();
      List<CargoNomination> cargoNominations =
          this.cargoNominationRepository.findByLoadableStudyXIdAndIsActiveOrderById(studyId, true);
      Set<Long> nominationIds =
          cargoNominations.stream()
              .map(CargoNomination::getCargoNominationPortDetails)
              .flatMap(Collection::stream)
              .filter(v -> v.getPortId().equals(portId))
              .map(CargoNominationPortDetails::getCargoNomination)
              .map(CargoNomination::getId)
              .collect(Collectors.toSet());
      return nominationIds;
    }
    return new HashSet<>();
  }

  public void buildCargoToBeLoadedForPort(
      LoadableStudy.LoadingPlanIdRequest request,
      LoadableStudy.LoadingPlanCommonResponse.Builder builder,
      Common.ResponseStatus.Builder repBuilder) {

    // For Loading Module
    List<LoadablePlanQuantity> list =
        this.loadablePlanQuantityRepository.PORT_WISE_CARGO_DETAILS(
            request.getPatternId(),
            request.getOperationType(),
            request.getPortRotationId(),
            request.getPortId());

    try {
      // Commingle cargo also list along in Cargo To Be Loaded Grid
      List<LoadablePlanComminglePortwiseDetails> comCargoNomiId =
          this.commingleDetailsPortWiseRepository
              .findCargoNominationIdsByPatternPortAndOperationType(
                  request.getPatternId(), request.getPortRotationId(), request.getOperationType());
      if (!comCargoNomiId.isEmpty()) {
        log.info(
            "Commingle cargo found for Pattern Id {}, Port-R Id {}, Op-Type {}",
            request.getPatternId(),
            request.getPortRotationId(),
            request.getOperationType());
        for (LoadablePlanComminglePortwiseDetails ccN : comCargoNomiId) {

          // Setting for Grade grid
          LoadableStudy.SynopticalCargoRecord.Builder cargo1 =
              LoadableStudy.SynopticalCargoRecord.newBuilder();
          LoadableStudy.SynopticalCargoRecord.Builder cargo2 =
              LoadableStudy.SynopticalCargoRecord.newBuilder();
          cargo1.setTankId(ccN.getTankId());
          cargo2.setTankId(ccN.getTankId());

          cargo1.setLpCargoDetailId(ccN.getId());
          cargo2.setLpCargoDetailId(ccN.getId());

          cargo1.setPlannedWeight(ccN.getCargo1Mt());
          cargo2.setPlannedWeight(ccN.getCargo2Mt());

          cargo1.setPlanQtyCargoOrder(ccN.getLoadingOrder());
          cargo2.setPlanQtyCargoOrder(ccN.getLoadingOrder());

          cargo1.setCargoAbbreviation(ccN.getCargo1Abbreviation());
          cargo2.setCargoAbbreviation(ccN.getCargo2Abbreviation());

          cargo1.setActualWeight(
              ccN.getCargo1ActualMT() != null ? ccN.getCargo1ActualMT().toString() : "");
          cargo2.setActualWeight(
              ccN.getCargo2ActualMT() != null ? ccN.getCargo2ActualMT().toString() : "");
          cargo1.setCargo1Mt(
              ccN.getCargo1ActualMT() != null ? ccN.getCargo1ActualMT().toString() : "");
          cargo2.setCargo2Mt(
              ccN.getCargo2ActualMT() != null ? ccN.getCargo2ActualMT().toString() : "");
          cargo1.setApi(ccN.getApi());
          cargo2.setApi(ccN.getApi());

          cargo1.setCargoNominationId(ccN.getCargo1NominationId());
          cargo2.setCargoNominationId(ccN.getCargo2NominationId());

          cargo1.setTemperature(ccN.getTemperature());
          cargo2.setTemperature(ccN.getTemperature());

          // Setting for Cargo To be Loaded

          List<LoadablePlanQuantity> lpQList1 =
              this.loadablePlanQuantityRepository.findByPatternIdAndCargoNominationId(
                  request.getPatternId(), ccN.getCargo1NominationId());
          if (!lpQList1.isEmpty()) {
            var lpQ = lpQList1.stream().findFirst();
            cargo1.setCargoId(lpQ.get().getCargoXId());
            cargo1.setColorCode(lpQ.get().getCargoColor());
            builder.addCommingleCargo(cargo1.build());
            if (list.stream()
                .noneMatch(
                    v -> v.getId().equals(lpQ.get().getId()))) { // Check if already in this list
              list.add(lpQ.get());
            }
          }

          List<LoadablePlanQuantity> lpQList2 =
              this.loadablePlanQuantityRepository.findByPatternIdAndCargoNominationId(
                  request.getPatternId(), ccN.getCargo2NominationId());
          if (!lpQList2.isEmpty()) {
            log.info(
                "Commingle cargo - quantity details for Cargo Nomination - {}",
                ccN.getCargo2NominationId());
            var lpQ = lpQList2.stream().findFirst();
            cargo2.setCargoId(lpQ.get().getCargoXId());
            cargo2.setColorCode(lpQ.get().getCargoColor());
            builder.addCommingleCargo(cargo2.build());
            if (list.stream()
                .noneMatch(
                    v -> v.getId().equals(lpQ.get().getId()))) { // Check if already in this list
              list.add(lpQ.get());
            }
          }
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    // Get api, temp and maxLoadingRate edited if present from
    // loading_cargo_api_temperature table in loading plan DB
    LoadingPlanModels.LoadingInformation.Builder loadingInfoBuilder =
        LoadingPlanModels.LoadingInformation.newBuilder()
            .setLoadingInfoId(request.getLoadingInfoId());
    LoadingPlanModels.LoadingInformation loadingInformation =
        this.loadingInfoServiceBlockingStub.getCargoToBeLoaded(loadingInfoBuilder.build());

    // Map to map cargoNominationId with Cargo To Be Loaded Details
    Map<Long, LoadableStudy.LoadableQuantityCargoDetails> cargoNominationMapped = new HashMap<>();

    loadingInformation
        .getLoadableQuantityCargoDetailsList()
        .forEach(
            loadableQuantityCargoDetails ->
                cargoNominationMapped.put(
                    loadableQuantityCargoDetails.getCargoNominationId(),
                    loadableQuantityCargoDetails));

    // Above list provide all cargo details at this port,
    // we don't need this data (only need what loading/discharge at that port) by nomination
    List<LoadablePlanQuantity> dataList = new ArrayList<>();
    if (request.getCargoNominationFilter()) {
      Set<Long> nominationIds =
          getCargoNominationIdList(request.getPatternId(), request.getPortId());
      dataList =
          list.stream()
              .filter(v -> nominationIds.contains(v.getCargoNominationId()))
              .collect(Collectors.toList());
    } else {
      dataList = list; // no filter, add all data
    }

    if (!dataList.isEmpty()) {
      for (LoadablePlanQuantity var1 : dataList) {
        LoadableStudy.LoadableQuantityCargoDetails.Builder builder1 =
            LoadableStudy.LoadableQuantityCargoDetails.newBuilder();
        Optional.ofNullable(var1.getId()).ifPresent(builder1::setId);
        Optional.ofNullable(var1.getGrade()).ifPresent(builder1::setGrade);

        // Fetch edited cargo to be loaded details if present against cargoNominationId
        if (cargoNominationMapped.containsKey(var1.getCargoNominationId())) {
          LoadableStudy.LoadableQuantityCargoDetails loadableQuantityCargoDetails =
              cargoNominationMapped.get(var1.getCargoNominationId());

          Optional.of(loadableQuantityCargoDetails.getEstimatedAPI())
              .ifPresent(builder1::setEstimatedAPI);
          Optional.of(loadableQuantityCargoDetails.getEstimatedTemp())
              .ifPresent(builder1::setEstimatedTemp);
          Optional.of(loadableQuantityCargoDetails.getMaxLoadingRate())
              .ifPresent(builder1::setLoadingRateM3Hr);
        } else {
          Optional.ofNullable(var1.getEstimatedApi())
              .ifPresent(v -> builder1.setEstimatedAPI(v.toString()));
          Optional.ofNullable(var1.getEstimatedTemperature())
              .ifPresent(v -> builder1.setEstimatedTemp(v.toString()));
          Optional.ofNullable(var1.getLoadingRateM3Hr())
              .ifPresent(loadingRate -> builder1.setLoadingRateM3Hr(loadingRate.toString()));
        }

        Optional.ofNullable(var1.getCargoNominationTemperature())
            .ifPresent(v -> builder1.setCargoNominationTemperature(v.toString()));

        Optional.ofNullable(var1.getOrderBblsDbs()).ifPresent(builder1::setOrderBblsdbs);
        Optional.ofNullable(var1.getOrderBbls60f()).ifPresent(builder1::setOrderBbls60F);
        Optional.ofNullable(var1.getMinTolerence()).ifPresent(builder1::setMinTolerence);
        Optional.ofNullable(var1.getMaxTolerence()).ifPresent(builder1::setMaxTolerence);
        Optional.ofNullable(var1.getLoadableBblsDbs()).ifPresent(builder1::setLoadableBblsdbs);
        Optional.ofNullable(var1.getLoadableBbls60f()).ifPresent(builder1::setLoadableBbls60F);

        Optional.ofNullable(var1.getLoadableLt()).ifPresent(builder1::setLoadableLT);
        Optional.ofNullable(var1.getLoadableMt()).ifPresent(builder1::setLoadableMT);
        Optional.ofNullable(var1.getLoadableKl()).ifPresent(builder1::setLoadableKL);
        Optional.ofNullable(var1.getDifferencePercentage())
            .ifPresent(builder1::setDifferencePercentage);
        Optional.ofNullable(var1.getDifferenceColor()).ifPresent(builder1::setDifferenceColor);

        Optional.ofNullable(var1.getCargoXId()).ifPresent(builder1::setCargoId);
        Optional.ofNullable(var1.getCargoAbbreviation()).ifPresent(builder1::setCargoAbbreviation);
        Optional.ofNullable(var1.getCargoColor()).ifPresent(builder1::setColorCode);
        Optional.ofNullable(var1.getPriority()).ifPresent(builder1::setPriority);
        Optional.ofNullable(var1.getLoadingOrder()).ifPresent(builder1::setLoadingOrder);
        Optional.ofNullable(var1.getSlopQuantity()).ifPresent(builder1::setSlopQuantity);

        Optional.ofNullable(var1.getOrderQuantity())
            .ifPresent(
                v -> {
                  builder1.setOrderedQuantity(v.toString());
                });
        Optional.ofNullable(this.getCargoNominationQuantity(var1.getCargoNominationId()))
            .ifPresent(
                v -> {
                  builder1.setCargoNominationQuantity(v.toString());
                });

        Optional.ofNullable(var1.getCargoNominationId()).ifPresent(builder1::setCargoNominationId);
        Optional.ofNullable(var1.getTimeRequiredForLoading())
            .ifPresent(builder1::setTimeRequiredForLoading);

        try {
          this.setLoadingPortNameFromCargoOperation(
              var1.getCargoXId(), var1.getCargoNominationId(), builder1);
        } catch (Exception e) {
          log.error("Failed to set Loading port names");
        }
        // cargo topping off no need
        builder.addLoadableQuantityCargoDetails(builder1.build());
      }
    }
    builder.setResponseStatus(repBuilder.setStatus(SUCCESS).build());
    log.info("Get Loadable Quantity details for patter Id {}", request.getPatternId());
  }

  public boolean setLoadingPortNameFromCargoOperation(
      Long cargoId, Long cargoNomiId, LoadableStudy.LoadableQuantityCargoDetails.Builder builder) {
    Optional<CargoNomination> cN = cargoNominationRepository.findByIdAndIsActive(cargoNomiId, true);
    if (cN.isPresent()) {
      if (cN.get().getCargoXId().equals(cargoId)) {
        Set<CargoNominationPortDetails> cnPD = cN.get().getCargoNominationPortDetails();
        if (!cnPD.isEmpty()) {
          for (CargoNominationPortDetails var1 : cnPD) {
            if (var1.getPortId() != null) {
              LoadableStudy.LoadingPortDetail.Builder a =
                  loadablePlanService.fetchPortNameFromPortService(
                      var1.getPortId(), var1.getPortRotation());
              builder.addLoadingPorts(a);
            }
          }
        }
      }
    }
    return true;
  }

  public BigDecimal getCargoNominationQuantity(Long cargoNominationId) {
    try {
      Optional<CargoNomination> var1 =
          cargoNominationRepository.findByIdAndIsActive(cargoNominationId, true);
      if (var1.isPresent()) {
        if (var1.get().getQuantity() != null) {
          return var1.get().getQuantity();
        }
      }
    } catch (Exception e) {
      log.error("Failed to get cargo nomination quantity");
    }
    return BigDecimal.ZERO;
  }
  /**
   * Builds the synoptical table records
   *
   * @param portId
   * @param entity
   * @param synopticalTableList
   * @param portStage
   */
  public void buildSynopticalTableRecord(
      Long portId,
      LoadableStudyPortRotation entity,
      List<SynopticalTable> synopticalTableList,
      String portStage) {
    SynopticalTable synopticalTable = new SynopticalTable();
    synopticalTable.setLoadableStudyPortRotation(entity);
    synopticalTable.setLoadableStudyXId(entity.getLoadableStudy().getId());
    synopticalTable.setOperationType(portStage);
    synopticalTable.setPortXid(0 == portId ? null : portId);
    synopticalTable.setIsActive(true);
    synopticalTableList.add(synopticalTable);
  }

  /**
   * Set ballast details
   *
   * @param synopticalEntity
   * @param builder
   * @param ballastDetails
   * @param sortedTankList
   * @param request
   */
  public void setBallastDetails(
      LoadableStudy.SynopticalTableRequest request,
      SynopticalTable synopticalEntity,
      com.cpdss.common.generated.LoadableStudy.SynopticalRecord.Builder builder,
      List<LoadablePlanStowageBallastDetails> ballastDetails,
      List<VesselInfo.VesselTankDetail> sortedTankList) {
    List<LoadablePlanStowageBallastDetails> portBallastList = new ArrayList<>();
    portBallastList.addAll(
        ballastDetails.stream()
            .filter(
                bd ->
                    synopticalEntity.getPortXid().equals(bd.getPortXId())
                        && synopticalEntity.getOperationType().equals(bd.getOperationType()))
            .collect(Collectors.toList()));

    for (VesselInfo.VesselTankDetail tank : sortedTankList) {
      if (!BALLAST_TANK_CATEGORY_ID.equals(tank.getTankCategoryId())) {
        continue;
      }
      LoadableStudy.SynopticalBallastRecord.Builder ballastBuilder =
          LoadableStudy.SynopticalBallastRecord.newBuilder();
      ballastBuilder.setTankId(tank.getTankId());
      ballastBuilder.setTankName(tank.getShortName());
      ballastBuilder.setCapacity(tank.getFullCapacityCubm());
      Optional<LoadablePlanStowageBallastDetails> tankBallastDetail =
          portBallastList.stream()
              .filter(b -> b.getTankXId().longValue() == tank.getTankId())
              .findAny();
      if (tankBallastDetail.isPresent()) {
        LoadablePlanStowageBallastDetails ballast = tankBallastDetail.get();
        Optional.ofNullable(ballast.getQuantity())
            .ifPresent(item -> ballastBuilder.setPlannedWeight(valueOf(item)));
        Optional.ofNullable(ballast.getActualQuantity())
            .ifPresent(item -> ballastBuilder.setActualWeight(valueOf(item)));
        Optional.ofNullable(ballast.getCorrectedUllage())
            .ifPresent(ullage -> ballastBuilder.setCorrectedUllage(ullage));
        Optional.ofNullable(ballast.getSg()).ifPresent(sg -> ballastBuilder.setSpGravity(sg));
        Optional.ofNullable(ballast.getColorCode())
            .ifPresent(colorCode -> ballastBuilder.setColorCode(colorCode));
        Optional.ofNullable(ballast.getFillingPercentage())
            .ifPresent(fillingRatio -> ballastBuilder.setFillingRatio(fillingRatio));

      } else {
        log.info(
            "Ballast details not available for the tank: {}, pattern: {}",
            tank.getTankId(),
            request.getLoadablePatternId());
      }
      builder.addBallast(ballastBuilder.build());
    }
  }

  /**
   * Fetch Single Port Details
   *
   * @param synoptics
   * @param builder
   */
  public void setPortDetailForSynoptics(
      SynopticalTable synoptics, LoadableStudy.SynopticalRecord.Builder builder) {
    PortInfo.PortReply reply =
        portInfoGrpcService.getPortInfoByPortIds(
            PortInfo.GetPortInfoByPortIdsRequest.newBuilder()
                .addId(synoptics.getPortXid())
                .build());
    if (!reply.getPortsList().isEmpty()) { // Expect single entry as response
      builder.setPortTimezoneId(reply.getPortsList().get(0).getTimezoneId());
    }
  }

  public LocalDate getTimezoneConvertedDate(LocalDate date, double offset, boolean from) {
    if (date == null) {
      return null;
    }
    LocalDateTime dateTime = from ? date.atTime(0, 0, 0) : date.atTime(23, 59, 59);
    return getTimezoneConvertedDate(dateTime, offset).toLocalDate();
  }

  public LocalDateTime getTimezoneConvertedDate(LocalDateTime dateTime, double offset) {
    long hours = (long) offset;
    long minutes = (long) ((offset * 10) % 10) * 6;
    LocalDateTime newDateTime = dateTime.plusHours(hours);
    newDateTime = newDateTime.plusMinutes(minutes);
    return newDateTime;
  }

  public String getTimezoneConvertedString(LocalDateTime dateTime, double offset, String abbr) {
    if (dateTime == null) {
      return "";
    }
    LocalDateTime newDateTime = this.getTimezoneConvertedDate(dateTime, offset);
    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm");
    String formattedDate = newDateTime.format(format);
    if (offset == 0) {
      formattedDate.concat(" UTC");
    } else {
      int hours = (int) Math.abs(offset);
      int minutes = (int) Math.abs(((offset * 10) % 10) * 6);
      String formattedOffset = String.format("%02d", hours) + ":" + String.format("%02d", minutes);
      formattedDate =
          formattedDate.concat(
              " " + abbr + " (UTC " + (offset > 0 ? "+" : "-") + formattedOffset + ")");
    }

    return formattedDate;
  }

  public List<SynopticalTable> getsynopticalTableList(Long lsId, Long dsId) {
    List<SynopticalTable> synopticalTableList = new ArrayList<>();
    synopticalTableList =
        this.synopticalTableRepository.findByLoadableStudyXIdAndIsActiveOrderByPortOrder(
            lsId, true);
    synopticalTableList.stream()
        .forEach(item -> item.getLoadableStudyPortRotation().setPortRotationType(LOADING_PORT));
    if (dsId != null) {
      // Removing first discharge port added from LS
      synopticalTableList.removeIf(
          item ->
              (item.getLoadableStudyPortRotation()
                  .getOperation()
                  .getId()
                  .equals(DISCHARGING_OPERATION_ID)));
      // Appending all discharge port details added from DS
      synopticalTableList.addAll(
          this.synopticalTableRepository.findByLoadableStudyXIdAndIsActiveOrderByPortOrder(
              dsId, true));
      synopticalTableList.stream()
          .filter(item -> item.getLoadableStudyPortRotation().getPortRotationType() == null)
          .forEach(item -> item.getLoadableStudyPortRotation().setPortRotationType(DISCHARGE_PORT));
      // TODO sort if needed
    }
    return synopticalTableList;
  }

  public void buildSynopticalPortDataReplyByPortId(
      List<SynopticalTable> synopticalTableList,
      com.cpdss.common.generated.LoadableStudy.SynopticalTableReply.Builder replyBuilder) {
    if (!CollectionUtils.isEmpty(synopticalTableList)) {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
      synopticalTableList.forEach(
          synopticalRecord -> {
            LoadableStudy.SynopticalRecord.Builder recordBuilder =
                LoadableStudy.SynopticalRecord.newBuilder();
            ofNullable(synopticalRecord.getOperationType())
                .ifPresent(recordBuilder::setOperationType);
            ofNullable(synopticalRecord.getDistance())
                .ifPresent(distance -> recordBuilder.setDistance(String.valueOf(distance)));
            ofNullable(synopticalRecord.getEtaActual())
                .ifPresent(
                    etaActual ->
                        recordBuilder.setEtaEtdActual(
                            formatter.format(synopticalRecord.getEtaActual())));
            ofNullable(synopticalRecord.getEtdActual())
                .ifPresent(
                    etdActual ->
                        recordBuilder.setEtaEtdActual(
                            formatter.format(synopticalRecord.getEtdActual())));
            replyBuilder.addSynopticalRecords(recordBuilder);
          });
    }
  }

  public void validateSaveSynopticalEtaEtdEstimates(
      SynopticalTable entity,
      LoadableStudy.SynopticalRecord record,
      com.cpdss.loadablestudy.entity.LoadableStudy loadableStudy,
      LoadableStudyPortRotation prEntity)
      throws GenericServiceException {

    List<LoadablePattern> generatedPatterns =
        this.loadablePatternRepository.findLoadablePatterns(
            LOADABLE_STUDY_STATUS_PLAN_GENERATED_ID, loadableStudy, true);

    List<LoadablePattern> confirmedPatterns =
        this.loadablePatternRepository.findLoadablePatterns(
            CONFIRMED_STATUS_ID, loadableStudy, true);

    if ((!generatedPatterns.isEmpty() || !confirmedPatterns.isEmpty())
        && ((SYNOPTICAL_TABLE_OP_TYPE_ARRIVAL.equals(entity.getOperationType())
                && prEntity.getEta() != null
                && prEntity.getEta().toString().equals(record.getEtaEtdEstimated()))
            || (SYNOPTICAL_TABLE_OP_TYPE_DEPARTURE.equals(entity.getOperationType())
                && prEntity.getEtd() != null
                && prEntity.getEtd().toString().equals(record.getEtaEtdEstimated())))) {

      throw new GenericServiceException(
          "Cannot update planned values for plan generated loadable study",
          CommonErrorCodes.E_CPDSS_SAVE_NOT_ALLOWED,
          HttpStatusCode.BAD_REQUEST);
    }
  }

  /**
   * Set vessel particular data in synoptical table
   *
   * @param entity
   * @param record
   * @throws GenericServiceException
   */
  public void buidlSynopticalTableVesselData(
      SynopticalTable entity, LoadableStudy.SynopticalRecord record)
      throws GenericServiceException {

    Optional<com.cpdss.loadablestudy.entity.LoadableStudy> loadableStudy =
        this.loadableStudyRepository.findByIdAndIsActive(entity.getLoadableStudyXId(), true);
    if (!loadableStudy.isPresent()) {
      throw new GenericServiceException(
          "Loadable study with given id does not exist",
          CommonErrorCodes.E_HTTP_BAD_REQUEST,
          HttpStatusCode.BAD_REQUEST);
    }

    this.validateSynopticalVesselData(loadableStudy.get(), entity, record);

    entity.setOthersPlanned(
        isEmpty(record.getOthersPlanned()) ? null : new BigDecimal(record.getOthersPlanned()));
    entity.setOthersActual(
        isEmpty(record.getOthersActual()) ? null : new BigDecimal(record.getOthersActual()));
    entity.setConstantPlanned(
        isEmpty(record.getConstantPlanned()) ? null : new BigDecimal(record.getConstantPlanned()));
    entity.setConstantActual(
        isEmpty(record.getConstantActual()) ? null : new BigDecimal(record.getConstantActual()));
    entity.setDeadWeightPlanned(
        isEmpty(record.getTotalDwtPlanned()) ? null : new BigDecimal(record.getTotalDwtPlanned()));
    entity.setDeadWeightActual(
        isEmpty(record.getTotalDwtActual()) ? null : new BigDecimal(record.getTotalDwtActual()));
    entity.setDisplacementPlanned(
        isEmpty(record.getDisplacementPlanned())
            ? null
            : new BigDecimal(record.getDisplacementPlanned()));
    entity.setDisplacementActual(
        isEmpty(record.getDisplacementActual())
            ? null
            : new BigDecimal(record.getDisplacementActual()));
  }

  public void saveSynopticalCommingleData(
      SynopticalTableRequest request,
      Optional<SynopticalTable> synopticalData,
      SynopticalRecord synopticalRecord) {
    log.info("Saving commingle data to synoptical table {}", synopticalData.get().getId());
    if (!synopticalRecord.getCommingleList().isEmpty()) {
      List<LoadablePlanComminglePortwiseDetails> commingles =
          loadablePlanCommingleDetailsPortwiseRepository.findByLoadablePatternIdAndIsActive(
              request.getLoadablePatternId(), true);
      List<LoadablePlanComminglePortwiseDetails> toBeSaved = new ArrayList<>();
      for (SynopticalCommingleRecord rec : synopticalRecord.getCommingleList()) {
        Optional<LoadablePlanComminglePortwiseDetails> entityOpt =
            commingles.stream().filter(b -> b.getTankId().longValue() == rec.getTankId()).findAny();
        if (entityOpt.isPresent()) {
          LoadablePlanComminglePortwiseDetails ent = entityOpt.get();
          ent.setActualQuantity(
              isEmpty(rec.getActualWeight()) ? null : new BigDecimal(rec.getActualWeight()));
          ent.setCargo1ActualMT(
              rec.getCargo1ActualQty().isEmpty() ? null : new BigDecimal(rec.getCargo1ActualQty()));
          ent.setCargo2ActualMT(
              rec.getCargo2ActualQty().isEmpty() ? null : new BigDecimal(rec.getCargo2ActualQty()));
          toBeSaved.add(ent);
        } else {
          LoadablePlanComminglePortwiseDetails ent = new LoadablePlanComminglePortwiseDetails();
          ent.setTankId(rec.getTankId());
          ent.setIsActive(true);
          ent.setLoadablePattern(
              loadablePatternRepository.findById(request.getLoadablePatternId()).get());
          ent.setPortId(synopticalData.get().getPortXid());
          ent.setOperationType(synopticalData.get().getOperationType());
          ent.setPortRotationXid(synopticalData.get().getLoadableStudyPortRotation().getId());
          ent.setActualQuantity(
              isEmpty(rec.getActualWeight()) ? null : new BigDecimal(rec.getActualWeight()));
          ent.setCargo1ActualMT(
              rec.getCargo1ActualQty().isEmpty() ? null : new BigDecimal(rec.getCargo1ActualQty()));
          ent.setCargo2ActualMT(
              rec.getCargo2ActualQty().isEmpty() ? null : new BigDecimal(rec.getCargo2ActualQty()));
          toBeSaved.add(ent);
        }
      }
      this.loadablePlanCommingleDetailsPortwiseRepository.saveAll(toBeSaved);
    }
  }
}
