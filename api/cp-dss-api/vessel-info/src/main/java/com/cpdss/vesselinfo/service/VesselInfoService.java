/* Licensed at AlphaOri Technologies */
package com.cpdss.vesselinfo.service;

import static com.cpdss.vesselinfo.constants.VesselInfoConstants.VESSEL_INFO_TABLES;
import static java.lang.String.valueOf;

import com.cpdss.common.exception.GenericServiceException;
import com.cpdss.common.generated.Common;
import com.cpdss.common.generated.Common.*;
import com.cpdss.common.generated.VesselInfo.*;
import com.cpdss.common.generated.VesselInfo.BendingMomentShearingForceType3;
import com.cpdss.common.generated.VesselInfo.BendingMomentType1;
import com.cpdss.common.generated.VesselInfo.BendingMomentType2;
import com.cpdss.common.generated.VesselInfo.BendingMomentType4;
import com.cpdss.common.generated.VesselInfo.CalculationSheet;
import com.cpdss.common.generated.VesselInfo.ShearingForceType1;
import com.cpdss.common.generated.VesselInfo.ShearingForceType2;
import com.cpdss.common.generated.VesselInfo.ShearingForceType4;
import com.cpdss.common.generated.VesselInfo.StationValues;
import com.cpdss.common.generated.VesselInfo.VesselDetail.Builder;
import com.cpdss.common.generated.VesselInfoServiceGrpc.VesselInfoServiceImplBase;
import com.cpdss.common.rest.CommonErrorCodes;
import com.cpdss.common.utils.HttpStatusCode;
import com.cpdss.vesselinfo.domain.*;
import com.cpdss.vesselinfo.domain.CargoTankMaster;
import com.cpdss.vesselinfo.entity.*;
import com.cpdss.vesselinfo.entity.UllageTrimCorrection;
import com.cpdss.vesselinfo.entity.VesselDraftCondition;
import com.cpdss.vesselinfo.entity.VesselPumpTankMapping;
import com.cpdss.vesselinfo.repository.*;
import com.google.common.base.Strings;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import lombok.extern.log4j.Log4j2;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.CollectionUtils;

/**
 * Vessel info grpc service class
 *
 * @author suhail.k
 */
@GrpcService
@Log4j2
@Transactional
public class VesselInfoService extends VesselInfoServiceImplBase {

  @Autowired private VesselRepository vesselRepository;
  @Autowired private VesselChartererMappingRepository chartererMappingRepository;
  @Autowired private TankCategoryRepository tankCategoryRepository;
  @Autowired private VesselTankRepository vesselTankRepository;
  @Autowired private HydrostaticTableRepository hydrostaticTableRepository;
  @Autowired private VesselDraftConditionRepository vesselDraftConditionRepository;
  @Autowired private VesselTankTcgRepository vesselTankTcgRepository;
  @Autowired private VesselPumpTankMappingRepository vesselPumpTankMappingRepository;

  @Autowired private BendingMomentRepository bendingMomentRepository;
  @Autowired private ShearingForceRepository shearingForceRepository;
  @Autowired private BendingMomentRepositoryType2 bendingMomentRepositoryType2;
  @Autowired private ShearingForceRepositoryType2 shearingForceRepositoryType2;
  @Autowired private BendingMomentRepositoryType4 bendingMomentRepositoryType4;
  @Autowired private ShearingForceRepositoryType4 shearingForceRepositoryType4;

  @Autowired
  private BendingMomentShearingForceRepositoryType3 bendingMomentShearingForceRepositoryType3;

  @Autowired private CalculationSheetRepository calculationSheetRepository;
  @Autowired private CalculationSheetTankgroupRepository calculationSheetTankgroupRepository;
  @Autowired private MinMaxValuesForBmsfRepository minMaxValuesForBmsfRepository;
  @Autowired private StationValuesRepository stationValuesRepository;
  @Autowired private InnerBulkHeadValuesRepository innerBulkHeadValuesRepository;
  @Autowired private UllageTableDataRepository ullageTableDataRepository;
  @Autowired private VesselFlowRateRepository vesselFlowRateRepository;
  @Autowired HydrostaticService hydrostaticService;
  @Autowired VesselPumpService vesselPumpService;
  @Autowired RuleTypeRepository ruleTypeRepository;
  @Autowired RuleTemplateRepository ruleTemplateRepository;
  @Autowired RuleVesselMappingRepository ruleVesselMappingRepository;
  @Autowired RuleVesselMappingInputRespository ruleVesselMappingInputRespository;
  @Autowired VesselValveSequenceRepository vesselValveSequenceRepository;
  @Autowired RuleTemplateInputRepository ruleTemplateInputRepository;
  @Autowired RuleVesselDropDownValuesRepository ruleVesselDropDownValuesRepository;
  @Autowired VesselValveEducationProcessRepository educationProcessRepository;
  @Autowired VesselValveAirPurgeSequenceRepository airPurgeSequenceRepository;
  @Autowired VesselValveStrippingSequenceRepository strippingSequenceRepository;
  @Autowired private VesselParticularService vesselParticularService;
  @Autowired VVStrippingSequenceCargoValveRepository sequenceCargoValveRepository;
  @Autowired VesselCowService vesselCowService;
  @Autowired VesselInfoCommunicationService vesselInfoCommunicationService;
  @Autowired CrewService crewService;
  @Autowired CharterService charterService;

  private static final String SUCCESS = "SUCCESS";
  private static final String FAILED = "FAILED";

  private static final Long CARGO_TANK_CATEGORY_ID = 1L;
  private static final Long CARGO_SLOP_TANK_CATEGORY_ID = 9L;
  private static final String INVALID_VESSEL_ID = "INVALID_VESSEL_ID";
  public static final Long FRESH_WATER_TANK_CATEGORY_ID = 3L;
  public static final Long FUEL_OIL_TANK_CATEGORY_ID = 5L;
  public static final Long DIESEL_OIL_TANK_CATEGORY_ID = 6L;
  public static final Long LUBRICATING_OIL_TANK_CATEGORY_ID = 14L;
  public static final Long LUBRICANT_OIL_TANK_CATEGORY_ID = 19L;
  public static final Long FUEL_VOID_TANK_CATEGORY_ID = 22L;
  public static final Long FRESH_WATER_VOID_TANK_CATEGORY_ID = 23L;
  public static final Long BALLAST_VOID_TANK_CATEGORY_ID = 16L;
  public static final Long BALLAST_TANK_CATEGORY_ID = 2L;
  public static final String BALLAST_FRONT_TANK = "FRONT";
  public static final String BALLAST_CENTER_TANK = "CENTER";
  public static final String BALLAST_REAR_TANK = "REAR";
  public static final String DATE_FORMAT = "dd-MM-yyyy";
  private static final Long CENTER_TANKS = 2L;
  private static final Long PORT_TANKS = 1L;
  private static final Long STBD_TANKS = 3L;
  private static final Long WP_TANKS = 4L;
  private static final Long WS_TANKS = 5L;

  private static final List<Long> CARGO_TANK_CATEGORIES =
      Arrays.asList(CARGO_TANK_CATEGORY_ID, CARGO_SLOP_TANK_CATEGORY_ID);

  /** Get vessel for a company */
  @Override
  public void getAllVesselsByCompany(
      VesselRequest request, StreamObserver<VesselReply> responseObserver) {
    log.info("inside grpc service: getAllVesselsByCompany");
    VesselReply.Builder replyBuilder = VesselReply.newBuilder();
    try {
      List<Vessel> vesselEntities;
      if (!request.getIsShore()) {
        vesselEntities = this.vesselRepository.findByIsActive(true);
      } else if (request.getIsShore() && !CollectionUtils.isEmpty(request.getVesselIdsList())) {
        vesselEntities =
            this.vesselRepository.findByIdInAndIsActive(
                request.getVesselIdsList(), request.getIsShore());
      } else {
        vesselEntities = new ArrayList<>();
      }
      for (Vessel entity : vesselEntities) {
        VesselDetail.Builder builder = VesselDetail.newBuilder();
        builder.setId(entity.getId());
        Optional.ofNullable(entity.getChiefofficerId()).ifPresent(builder::setCheifOfficerId);
        Optional.ofNullable(entity.getImoNumber()).ifPresent(builder::setImoNumber);
        Optional.ofNullable(entity.getMasterId()).ifPresent(builder::setCaptainId);
        Optional.ofNullable(entity.getName()).ifPresent(builder::setName);
        Optional.ofNullable(entity.getVesselFlag())
            .ifPresent(flag -> builder.setFlag(flag.getFlagImagePath()));
        Optional.ofNullable(entity.getHasLoadicator()).ifPresent(builder::setHasLoadicator);
        Optional.ofNullable(entity.getKeelToMastHeight())
            .ifPresent(height -> builder.setKeelToMastHeight(height.toString()));
        Optional.ofNullable(entity.getMaxLoadRate())
            .ifPresent(height -> builder.setMaxLoadRate(height.toString()));
        Optional.ofNullable(entity.getMastRiser())
            .ifPresent(height -> builder.setMastRiser(height.toString()));
        Optional.ofNullable(entity.getHeightOfManifoldAboveDeck())
            .ifPresent(height -> builder.setHeightOfManifoldAboveDeck(height.toString()));
        Set<VesselDraftCondition> draftConditions = entity.getVesselDraftConditionCollection();

        TreeMap<Long, TreeSet<BigDecimal>> map = new TreeMap<>();
        Comparator<BigDecimal> draftMarkComparator =
            (BigDecimal b1, BigDecimal b2) -> b2.compareTo(b1);
        draftConditions.forEach(
            condition -> {
              if (condition.getDraftCondition().getIsActive()) {
                if (null == map.get(condition.getDraftCondition().getId())) {
                  TreeSet<BigDecimal> set = new TreeSet<>(draftMarkComparator);
                  set.add(condition.getDraftExtreme());
                  map.put(condition.getDraftCondition().getId(), set);
                } else {
                  map.get(condition.getDraftCondition().getId()).add(condition.getDraftExtreme());
                }
              }
            });

        List<LoadLineDetail.Builder> builderList = new ArrayList<>();
        for (Map.Entry<Long, TreeSet<BigDecimal>> entry : map.entrySet()) {
          Optional<VesselDraftCondition> condition =
              draftConditions.stream()
                  .filter(d -> d.getDraftCondition().getId().equals(entry.getKey()))
                  .findFirst();
          if (condition.isPresent()) {
            DraftCondition draftCondition = condition.get().getDraftCondition();
            LoadLineDetail.Builder loadLineBuilder = LoadLineDetail.newBuilder();
            loadLineBuilder.setId(draftCondition.getId());
            loadLineBuilder.setName(draftCondition.getName());
            map.get(draftCondition.getId())
                .forEach(
                    draftExtreme -> {
                      loadLineBuilder.addDraftMarks(String.valueOf(draftExtreme));
                    });
            builderList.add(loadLineBuilder);
          }
        }

        builder.addAllLoadLines(
            builderList.stream().map(LoadLineDetail.Builder::build).collect(Collectors.toList()));
        VesselChartererMapping vesselChartererMapping =
            this.chartererMappingRepository.findByVesselAndIsActive(entity, true);
        if (null != vesselChartererMapping && null != vesselChartererMapping.getCharterer()) {
          builder.setCharterer(vesselChartererMapping.getCharterer().getName());
        }
        replyBuilder.addVessels(builder.build());
        replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS).build());
      }

    } catch (Exception e) {
      log.error("Exception when fetching vessel info", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage(null != e.getMessage() ? e.getMessage() : "")
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
  public void getVesselDetailsById(
      VesselRequest request, StreamObserver<VesselReply> responseObserver) {
    VesselReply.Builder replyBuilder = VesselReply.newBuilder();
    try {
      log.info("inside grpc service: getVesselDetailsById");
      VesselDetails vesselDetails =
          vesselRepository.findVesselDetailsById(
              request.getVesselId(),
              request.getVesselDraftConditionId(),
              new BigDecimal(request.getDraftExtreme()));

      VesselLoadableQuantityDetails.Builder builder = VesselLoadableQuantityDetails.newBuilder();

      Vessel vessel = vesselRepository.findByIdAndIsActive(request.getVesselId(), true);
      Optional<HydrostaticTable> hydrostaticTable =
          hydrostaticService
              .fetchAllDataByDraftAndVessel(vessel, new BigDecimal(request.getDraftExtreme()))
              .stream()
              .findFirst();
      List<BigDecimal> tpc =
          hydrostaticTableRepository.getTPCFromDraf(
              request.getVesselId(), new BigDecimal(request.getDraftForTpc()), true);
      if (null != vesselDetails) {
        Optional.ofNullable(hydrostaticTable.get().getDisplacement())
            .ifPresent(item -> builder.setDisplacmentDraftRestriction(item.toString()));
        Optional.ofNullable(vesselDetails.getVesselLightWeight())
            .ifPresent(item -> builder.setVesselLightWeight(item.toString()));
        Optional.ofNullable(vesselDetails.getDeadWeight())
            .ifPresent(dwt -> builder.setDwt(dwt.toString()));
        Optional.ofNullable(vesselDetails.getDraftConditionName())
            .ifPresent(builder::setDraftConditionName);
        Optional.ofNullable(vesselDetails.getConstant())
            .ifPresent(constant -> builder.setConstant(constant.toString()));
      }
      if (!tpc.isEmpty()) {
        Optional.ofNullable(tpc.get(0))
            .ifPresent(tpcValue -> builder.setTpc(String.valueOf(tpcValue)));
      }
      replyBuilder.setVesselLoadableQuantityDetails(builder.build());
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder().setStatus(SUCCESS).setMessage(SUCCESS).build());
    } catch (Exception e) {
      log.error("Exception when fetching vessel details by id ", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage(FAILED)
              .setStatus(FAILED)
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  /** Get fuel tanks for a vessel by its id */
  @Override
  public void getVesselTanks(VesselRequest request, StreamObserver<VesselReply> responseObserver) {
    VesselReply.Builder replyBuilder = VesselReply.newBuilder();
    try {
      log.info("inside getVesselTanks");
      List<VesselTankDetail> tankList =
          this.findVesselTanksByCategory(request.getVesselId(), request.getTankCategoriesList());
      if (null != tankList && !tankList.isEmpty()) {
        replyBuilder.addAllVesselTanks(tankList);
      }
      replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS).build());
    } catch (GenericServiceException e) {
      log.error("GenericServiceException when fetching fuel tanks", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(e.getCode())
              .setMessage("GenericServiceException when fetching fuel tanks")
              .setStatus(FAILED)
              .build());
    } catch (Exception e) {
      log.error("Exception when fetching fuel tanks", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage("Exception when fetching fuel tanks")
              .setStatus(FAILED)
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  /**
   * find tanks based on vessel and category
   *
   * @param vesselId
   * @param tankCategoryIds
   * @return
   * @throws GenericServiceException
   */
  public List<VesselTankDetail> findVesselTanksByCategory(Long vesselId, List<Long> tankCategoryIds)
      throws GenericServiceException {
    log.info("inside findVesselTanksByCategory");
    Vessel vessel = this.vesselRepository.findByIdAndIsActive(vesselId, true);
    if (null == vessel) {
      log.error("Vessel does not exist");
      throw new GenericServiceException(
          "Vessel with given id does not exist",
          CommonErrorCodes.E_HTTP_BAD_REQUEST,
          HttpStatusCode.BAD_REQUEST);
    }
    List<TankCategory> tankCategoryEntities = new ArrayList<>();
    tankCategoryIds.forEach(
        tankCategoryId ->
            tankCategoryEntities.add(this.tankCategoryRepository.getOne(tankCategoryId)));
    List<VesselTank> vesselTanks =
        this.vesselTankRepository.findByVesselAndTankCategoryInAndIsActive(
            vessel, tankCategoryEntities, true);
    List<VesselTankDetail> tankDetailsList = new ArrayList<>();
    for (VesselTank tank : vesselTanks) {
      VesselTankDetail.Builder builder = VesselTankDetail.newBuilder();
      builder.setTankId(tank.getId());
      builder.setTankCategoryId(tank.getTankCategory().getId());
      builder.setTankCategoryName(tank.getTankCategory().getName());
      Optional.ofNullable(tank.getTankCategory().getShortName())
          .ifPresent(builder::setTankCategoryShortName);
      Optional.ofNullable(tank.getShortName()).ifPresent(builder::setShortName);
      builder.setFrameNumberFrom(tank.getFrameNumberFrom());
      builder.setFrameNumberTo(tank.getFrameNumberTo());
      builder.setTankName(tank.getTankName());
      Optional.ofNullable(tank.getHeightFrom()).ifPresent(builder::setHeightFrom);
      Optional.ofNullable(tank.getHeightTo()).ifPresent(builder::setHeightTo);
      Optional.ofNullable(tank.getFillCapacityCubm())
          .ifPresent(
              capacity -> builder.setFillCapacityCubm(String.valueOf(tank.getFillCapacityCubm())));
      Optional.ofNullable(tank.getDensity())
          .ifPresent(density -> builder.setDensity(String.valueOf(tank.getDensity())));
      Optional.ofNullable(tank.getTankGroup()).ifPresent(builder::setTankGroup);
      Optional.ofNullable(tank.getTankOrder()).ifPresent(builder::setTankOrder);
      Optional.ofNullable(tank.getIsSlopTank()).ifPresent(builder::setIsSlopTank);
      Optional.ofNullable(tank.getTankCategory().getColorCode()).ifPresent(builder::setColourCode);
      Optional.ofNullable(tank.getFullCapacityCubm())
          .ifPresent(
              capacity -> builder.setFullCapacityCubm(String.valueOf(tank.getFullCapacityCubm())));
      Optional.ofNullable(tank.getTankDisplayOrder()).ifPresent(builder::setTankDisplayOrder);
      Optional.ofNullable(tank.getShowInOhqObq()).ifPresent(builder::setShowInOhqObq);
      Optional.ofNullable(tank.getTankPositionCategory())
          .ifPresent(builder::setTankPositionCategory);
      // DSS 5450 flag to identify tanks that are SLOP tanks or act as a slop tank.
      Optional.ofNullable(tank.getIsSlopWaterTank()).ifPresent(builder::setIsSlopWaterTank);
      tankDetailsList.add(builder.build());
    }
    return tankDetailsList;
  }

  /** Retrieve vessel cargo tanks for a vessel-id */
  @Override
  public void getVesselCargoTanks(
      VesselRequest request, StreamObserver<VesselReply> responseObserver) {
    VesselReply.Builder replyBuilder = VesselReply.newBuilder();
    try {
      Vessel vesselEntity = this.vesselRepository.findByIdAndIsActive(request.getVesselId(), true);
      if (vesselEntity == null) {
        throw new GenericServiceException(
            "Vessel with given id does not exist",
            CommonErrorCodes.E_HTTP_BAD_REQUEST,
            HttpStatusCode.BAD_REQUEST);
      }
      List<TankCategory> tankCategoryEntities = new ArrayList<>();
      CARGO_TANK_CATEGORIES.forEach(
          tankCategoryId ->
              tankCategoryEntities.add(this.tankCategoryRepository.getOne(tankCategoryId)));
      List<VesselTank> vesselTanks =
          this.vesselTankRepository.findByVesselAndTankCategoryInAndIsActive(
              vesselEntity, tankCategoryEntities, true);
      Map<Long, List<VesselTank>> typeWiseTanks =
          vesselTanks
              .parallelStream()
              .collect(Collectors.groupingBy(tank -> tank.getTankType().getId()));
      List<VesselTank> centerTanks = typeWiseTanks.get(CENTER_TANKS);
      createVesselTankReply(replyBuilder, centerTanks);
      createVesselTankReply(replyBuilder, typeWiseTanks.get(PORT_TANKS));
      createVesselTankReply(replyBuilder, typeWiseTanks.get(STBD_TANKS));
      createVesselTankReply(replyBuilder, typeWiseTanks.get(WP_TANKS));
      createVesselTankReply(replyBuilder, typeWiseTanks.get(WS_TANKS));

      replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS).build());
    } catch (GenericServiceException e) {
      log.error("GenericServiceException when fetching cargo tanks", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(e.getCode())
              .setMessage("GenericServiceException when fetching cargo tanks")
              .setStatus(FAILED)
              .build());
    } catch (Exception e) {
      log.error("Exception when fetching cargo tanks", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage("Exception when fetching cargo tanks")
              .setStatus(FAILED)
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  private void createVesselTankReply(
      VesselReply.Builder replyBuilder, List<VesselTank> vesselTanks) {
    if (vesselTanks == null || vesselTanks.isEmpty()) {
      return;
    }
    for (VesselTank tank : vesselTanks) {
      VesselTankDetail.Builder builder = VesselTankDetail.newBuilder();
      builder.setTankId(tank.getId());
      builder.setTankName(tank.getTankName());
      builder.setShortName(tank.getShortName());
      builder.setTankCategoryId(tank.getTankCategory().getId());
      builder.setTankOrder(tank.getTankOrder());
      builder.setTankDisplayOrder(tank.getTankDisplayOrder());
      // builder.setTankCategoryName(tank.getTankCategory().getName());
      // builder.setFrameNumberFrom(tank.getFrameNumberFrom());
      // builder.setFrameNumberTo(tank.getFrameNumberTo());
      replyBuilder.addVesselTanks(builder.build());
    }
  }

  @Override
  public void getVesselDetailsForAlgo(
      VesselAlgoRequest request, StreamObserver<VesselAlgoReply> responseObserver) {
    VesselAlgoReply.Builder replyBuilder = VesselAlgoReply.newBuilder();
    try {
      Vessel vessel = this.vesselRepository.findByIdAndIsActive(request.getVesselId(), true);
      if (vessel == null) {
        log.info(INVALID_VESSEL_ID, request.getVesselId());
        replyBuilder.setResponseStatus(
            ResponseStatus.newBuilder()
                .setStatus(FAILED)
                .setMessage(INVALID_VESSEL_ID)
                .setCode(CommonErrorCodes.E_HTTP_BAD_REQUEST));
      } else {
        VesselDetail.Builder vesselDetailBuilder = VesselDetail.newBuilder();
        replyBuilder.setVesselDetail(createVesseDetails(vessel, vesselDetailBuilder));

        com.cpdss.common.generated.VesselInfo.VesselDraftCondition.Builder
            vesselDraftConditionBuilder =
                com.cpdss.common.generated.VesselInfo.VesselDraftCondition.newBuilder();
        vesselDraftConditionRepository
            .findByVesselAndIsActive(vessel, true)
            .forEach(
                vesselDraftCondition -> {
                  replyBuilder.addVesselDraftCondition(
                      createVesselHydrostaticData(
                          vesselDraftCondition, vesselDraftConditionBuilder));
                });

        VesselTankDetail.Builder vesselTankBuilder = VesselTankDetail.newBuilder();
        vesselTankRepository
            .findByVesselAndIsActive(vessel, true)
            .forEach(
                vesselTank -> {
                  replyBuilder.addVesselTankDetail(
                      createVesselTankData(vesselTank, vesselTankBuilder));
                });

        HydrostaticData.Builder hydrostaticDataBuilder = HydrostaticData.newBuilder();
        hydrostaticTableRepository
            .findByVesselAndIsActive(vessel, true)
            .forEach(
                hydrostaticTable -> {
                  replyBuilder.addHydrostaticData(
                      createhydrostaticTableData(hydrostaticTable, hydrostaticDataBuilder));
                });

        VesselTankTCG.Builder vesselTankTcgBuilder = VesselTankTCG.newBuilder();
        vesselTankTcgRepository
            .findByVesselIdAndIsActive(vessel.getId(), true)
            .forEach(
                vesselTankTcg -> {
                  replyBuilder.addVesselTankTCG(
                      createVesselTankTcg(vesselTankTcg, vesselTankTcgBuilder));
                });

        BMAndSF.Builder bMAndSFBuilder = BMAndSF.newBuilder();
        if (vessel != null
            && vessel.getBm_sf_model_type() != null
            && vessel.getBm_sf_model_type() != 0) {

          if (vessel.getBm_sf_model_type() == 1) {
            bendingMomentRepository
                .findByVessel(vessel)
                .forEach(
                    bendingMomentType1 -> {
                      BendingMomentType1.Builder bendingMomentBuilder =
                          BendingMomentType1.newBuilder();
                      bMAndSFBuilder.addBendingMomentType1(
                          createBendingMomentType1(bendingMomentType1, bendingMomentBuilder));
                    });

            shearingForceRepository
                .findByVessel(vessel)
                .forEach(
                    shearingForceType1 -> {
                      ShearingForceType1.Builder shearingForceBuilder =
                          ShearingForceType1.newBuilder();
                      bMAndSFBuilder.addShearingForceType1(
                          createShearingForce(shearingForceType1, shearingForceBuilder));
                    });
          }
          if (vessel.getBm_sf_model_type() == 2) {
            bendingMomentRepositoryType2
                .findByVessel(vessel)
                .forEach(
                    bendingMomentType2 -> {
                      BendingMomentType2.Builder bendingMomentBuilder =
                          BendingMomentType2.newBuilder();
                      bMAndSFBuilder.addBendingMomentType2(
                          createBendingMomentType2(bendingMomentType2, bendingMomentBuilder));
                    });

            shearingForceRepositoryType2
                .findByVessel(vessel)
                .forEach(
                    shearingForceType2 -> {
                      ShearingForceType2.Builder shearingForceBuilder =
                          ShearingForceType2.newBuilder();
                      bMAndSFBuilder.addShearingForceType2(
                          createShearingForce2(shearingForceType2, shearingForceBuilder));
                    });
          }
          if (vessel.getBm_sf_model_type() == 4) {
            bendingMomentRepositoryType4
                .findByVessel(vessel)
                .forEach(
                    bendingMomentType4 -> {
                      BendingMomentType4.Builder bendingMomentBuilder =
                          BendingMomentType4.newBuilder();
                      bMAndSFBuilder.addBendingMomentType4(
                          createBendingMomentType4(bendingMomentType4, bendingMomentBuilder));
                    });

            shearingForceRepositoryType4
                .findByVessel(vessel)
                .forEach(
                    shearingForceType4 -> {
                      ShearingForceType4.Builder shearingForceBuilder =
                          ShearingForceType4.newBuilder();
                      bMAndSFBuilder.addShearingForceType4(
                          createShearingForceType4(shearingForceType4, shearingForceBuilder));
                    });
          }
          if (vessel.getBm_sf_model_type() == 4) {
            bendingMomentShearingForceRepositoryType3
                .findByVessel(vessel)
                .forEach(
                    bendingMomentShearingForceType3 -> {
                      BendingMomentShearingForceType3.Builder bendingMomentBuilder =
                          BendingMomentShearingForceType3.newBuilder();
                      bMAndSFBuilder.addBendingMomentShearingForce3(
                          createBendingMomentShearingForce3(
                              bendingMomentShearingForceType3, bendingMomentBuilder));
                    });
          }
        }

        calculationSheetRepository
            .findByVessel(vessel)
            .forEach(
                calculationSheet -> {
                  CalculationSheet.Builder calculationSheetBuilder = CalculationSheet.newBuilder();
                  bMAndSFBuilder.addCalculationSheet(
                      createCalculationSheet(calculationSheet, calculationSheetBuilder));
                });

        calculationSheetTankgroupRepository
            .findByVessel(vessel)
            .forEach(
                calculationSheetTankgroup -> {
                  CalculationSheetTankGroup.Builder calculationSheetTankGroupBuilder =
                      CalculationSheetTankGroup.newBuilder();
                  bMAndSFBuilder.addCalculationSheetTankGroup(
                      createCalculationSheetTankGroup(
                          calculationSheetTankgroup, calculationSheetTankGroupBuilder));
                });

        minMaxValuesForBmsfRepository
            .findByVessel(vessel)
            .forEach(
                minMaxValuesForBmsf -> {
                  MinMaxValuesForBMAndSf.Builder minMaxValuesForBMAndSfBuilder =
                      MinMaxValuesForBMAndSf.newBuilder();
                  bMAndSFBuilder.addMinMaxValuesForBMAndSf(
                      createMinMaxValuesForBMAndSfBuilder(
                          minMaxValuesForBmsf, minMaxValuesForBMAndSfBuilder));
                });

        stationValuesRepository
            .findByVesselId(vessel.getId())
            .forEach(
                stationValue -> {
                  StationValues.Builder stationValueBuilder = StationValues.newBuilder();
                  bMAndSFBuilder.addStationValues(
                      createStationValueBuilder(stationValue, stationValueBuilder));
                });

        innerBulkHeadValuesRepository
            .findByVesselId(vessel.getId())
            .forEach(
                innerBulkHeadSF -> {
                  InnerBulkHeadSF.Builder innerBulkHeadSFBuilder = InnerBulkHeadSF.newBuilder();
                  bMAndSFBuilder.addInnerBulkHeadSF(
                      createInnerBulkHeadSFBuilder(innerBulkHeadSF, innerBulkHeadSFBuilder));
                });

        ullageTableDataRepository
            .findByVesselOrderByVesselTankAscUllageDepthAsc(vessel)
            .forEach(
                ullageTableData -> {
                  UllageDetails.Builder ullageDetailsBuilder = UllageDetails.newBuilder();
                  replyBuilder.addUllageDetails(
                      ullageDetailsBuilder(ullageTableData, ullageDetailsBuilder));
                });

        Set<UllageTrimCorrection> ullageTrimCorrections = vessel.getUllageTrimCorrections();
        if (null != ullageTrimCorrections && !ullageTrimCorrections.isEmpty()) {
          for (UllageTrimCorrection entity : ullageTrimCorrections) {
            if (null != entity.getIsActive() && entity.getIsActive()) {
              replyBuilder.addUllageTrimCorrection(this.buildUllageTrimCorrection(entity));
            }
          }
        }

        vesselFlowRateRepository
            .findByVessel(vessel)
            .forEach(
                flowRate -> {
                  SelectableParameter.Builder selectableBuilder = SelectableParameter.newBuilder();
                  replyBuilder.addSelectableParameter(
                      selectableParameterBuilder(flowRate, selectableBuilder));
                });

        vesselPumpTankMappingRepository
            .findByVesselXidAndIsActive(vessel.getId().intValue(), true)
            .forEach(
                vesselPumpTankMapping ->
                    replyBuilder.addVesselPumpTankMapping(
                        buildVesselPumpTankMapping(vesselPumpTankMapping)));

        com.cpdss.common.generated.VesselInfo.VesselPumpsResponse.Builder pumpDetailsBuilder =
            com.cpdss.common.generated.VesselInfo.VesselPumpsResponse.newBuilder();
        this.vesselPumpService.getVesselPumpsAndTypes(pumpDetailsBuilder, vessel.getId());
        this.vesselCowService.buildVesselCowParameters(replyBuilder, vessel);

        replyBuilder.addAllPumpType(pumpDetailsBuilder.getPumpTypeList());
        replyBuilder.addAllVesselPump(pumpDetailsBuilder.getVesselPumpList());
        replyBuilder.addAllTankType(pumpDetailsBuilder.getTankTypeList());
        replyBuilder.addAllVesselManifold(pumpDetailsBuilder.getVesselManifoldList());
        replyBuilder.addAllVesselBottomLine(pumpDetailsBuilder.getVesselBottomLineList());

        replyBuilder.setBMAndSF(bMAndSFBuilder);
        replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS).build());
      }
    } catch (Exception e) {
      log.error("Exception when fetching vessel details", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage("Exception when fetching vessel details")
              .setStatus(FAILED)
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  private com.cpdss.common.generated.VesselInfo.VesselPumpTankMapping buildVesselPumpTankMapping(
      VesselPumpTankMapping vesselPumpTankMapping) {
    com.cpdss.common.generated.VesselInfo.VesselPump.Builder vesselPumpBuilder =
        com.cpdss.common.generated.VesselInfo.VesselPump.newBuilder();
    Optional.ofNullable(vesselPumpTankMapping.getVesselPumps())
        .ifPresent(
            vesselPump -> {
              Optional.ofNullable(vesselPump.getId())
                  .ifPresent(id -> vesselPumpBuilder.setId(vesselPump.getId()));
              vesselPumpBuilder.setVesselId(vesselPumpTankMapping.getVesselXid());
              Optional.ofNullable(vesselPump.getPumpCode())
                  .ifPresent(id -> vesselPumpBuilder.setPumpCode(vesselPump.getPumpCode()));
              Optional.ofNullable(vesselPump.getPumpName())
                  .ifPresent(id -> vesselPumpBuilder.setPumpName(vesselPump.getPumpName()));
              Optional.ofNullable(vesselPump.getPumpType())
                  .ifPresent(
                      id -> vesselPumpBuilder.setPumpTypeId(vesselPump.getPumpType().getId()));
              if (Optional.ofNullable(vesselPumpTankMapping.getVesselTank()).isPresent()) {
                vesselPumpBuilder.setVesselTankDetail(
                    createVesselTankData(
                        vesselPumpTankMapping.getVesselTank(), VesselTankDetail.newBuilder()));
              }
            });

    return com.cpdss.common.generated.VesselInfo.VesselPumpTankMapping.newBuilder()
        .setVesselId(vesselPumpTankMapping.getVesselXid())
        .setVesselPump(vesselPumpBuilder.build())
        .build();
  }

  private SelectableParameter selectableParameterBuilder(
      VesselFlowRate flowRate,
      com.cpdss.common.generated.VesselInfo.SelectableParameter.Builder selectableBuilder) {
    Optional.ofNullable(flowRate.getFlowRateParameter())
        .ifPresent(
            flowRateName -> selectableBuilder.setParamterName(flowRateName.getFlowRateParameter()));
    Optional.ofNullable(flowRate.getFlowRateOne())
        .ifPresent(
            flowRateOne -> {
              ParameterValue.Builder parameterBuilder = ParameterValue.newBuilder();
              parameterBuilder.setValue(String.valueOf(flowRateOne));
              parameterBuilder.setType(1);
              selectableBuilder.addValues(parameterBuilder.build());
            });
    Optional.ofNullable(flowRate.getFlowRateSix())
        .ifPresent(
            flowRateSix -> {
              ParameterValue.Builder parameterBuilder = ParameterValue.newBuilder();
              parameterBuilder.setValue(String.valueOf(flowRateSix));
              parameterBuilder.setType(6);
              selectableBuilder.addValues(parameterBuilder.build());
            });
    Optional.ofNullable(flowRate.getFlowRateSeven())
        .ifPresent(
            flowRateSeven -> {
              ParameterValue.Builder parameterBuilder = ParameterValue.newBuilder();
              parameterBuilder.setValue(String.valueOf(flowRateSeven));
              parameterBuilder.setType(7);
              selectableBuilder.addValues(parameterBuilder.build());
            });
    Optional.ofNullable(flowRate.getFlowRateTwelve())
        .ifPresent(
            flowRateTwelve -> {
              ParameterValue.Builder parameterBuilder = ParameterValue.newBuilder();
              parameterBuilder.setValue(String.valueOf(flowRateTwelve));
              parameterBuilder.setType(12);
              selectableBuilder.addValues(parameterBuilder.build());
            });

    return selectableBuilder.build();
  }

  /**
   * Build ullage trim correction value
   *
   * @param entity
   * @return
   */
  private com.cpdss.common.generated.VesselInfo.UllageTrimCorrection buildUllageTrimCorrection(
      UllageTrimCorrection entity) {
    com.cpdss.common.generated.VesselInfo.UllageTrimCorrection.Builder builder =
        com.cpdss.common.generated.VesselInfo.UllageTrimCorrection.newBuilder();
    builder.setId(entity.getId());
    Optional.ofNullable(entity.getTankId()).ifPresent(builder::setTankId);
    Optional.ofNullable(entity.getUllageDepth())
        .ifPresent(item -> builder.setUllageDepth(valueOf(item)));
    Optional.ofNullable(entity.getTrimM1()).ifPresent(item -> builder.setTrimM1(valueOf(item)));
    Optional.ofNullable(entity.getTrimM2()).ifPresent(item -> builder.setTrimM2(valueOf(item)));
    Optional.ofNullable(entity.getTrimM3()).ifPresent(item -> builder.setTrimM3(valueOf(item)));
    Optional.ofNullable(entity.getTrimM4()).ifPresent(item -> builder.setTrimM4(valueOf(item)));
    Optional.ofNullable(entity.getTrimM5()).ifPresent(item -> builder.setTrimM5(valueOf(item)));
    Optional.ofNullable(entity.getTrim0()).ifPresent(item -> builder.setTrim0(valueOf(item)));
    Optional.ofNullable(entity.getTrim1()).ifPresent(item -> builder.setTrim1(valueOf(item)));
    Optional.ofNullable(entity.getTrim2()).ifPresent(item -> builder.setTrim2(valueOf(item)));
    Optional.ofNullable(entity.getTrim3()).ifPresent(item -> builder.setTrim3(valueOf(item)));
    Optional.ofNullable(entity.getTrim4()).ifPresent(item -> builder.setTrim4(valueOf(item)));
    Optional.ofNullable(entity.getTrim5()).ifPresent(item -> builder.setTrim5(valueOf(item)));
    Optional.ofNullable(entity.getTrim6()).ifPresent(item -> builder.setTrim6(valueOf(item)));
    return builder.build();
  }

  /**
   * @param ullageTableData
   * @param ullageDetailsBuilder
   * @return UllageDetails
   */
  private UllageDetails ullageDetailsBuilder(
      UllageTableData ullageTableData,
      com.cpdss.common.generated.VesselInfo.UllageDetails.Builder ullageDetailsBuilder) {
    Optional.ofNullable(ullageTableData.getId()).ifPresent(id -> ullageDetailsBuilder.setId(id));
    Optional.ofNullable(ullageTableData.getVesselTank())
        .ifPresent(vesselTank -> ullageDetailsBuilder.setTankId(vesselTank.getId()));
    Optional.ofNullable(ullageTableData.getUllageDepth())
        .ifPresent(ullageDepth -> ullageDetailsBuilder.setUllageDepth(String.valueOf(ullageDepth)));
    Optional.ofNullable(ullageTableData.getEvenKeelCapacityCubm())
        .ifPresent(
            evenKeelCapacityCubm ->
                ullageDetailsBuilder.setEvenKeelCapacityCubm(String.valueOf(evenKeelCapacityCubm)));
    Optional.ofNullable(ullageTableData.getSoundDepth())
        .ifPresent(soundDepth -> ullageDetailsBuilder.setSoundDepth(String.valueOf(soundDepth)));
    return ullageDetailsBuilder.build();
  }

  /**
   * @param innerBulkHeadSF
   * @param innerBulkHeadSFBuilder
   * @return InnerBulkHeadSF
   */
  private InnerBulkHeadSF createInnerBulkHeadSFBuilder(
      InnerBulkHeadValues innerBulkHeadSF,
      com.cpdss.common.generated.VesselInfo.InnerBulkHeadSF.Builder innerBulkHeadSFBuilder) {

    Optional.ofNullable(innerBulkHeadSF.getId()).ifPresent(id -> innerBulkHeadSFBuilder.setId(id));
    Optional.ofNullable(String.valueOf(innerBulkHeadSF.getFrameNumber()))
        .ifPresent(innerBulkHeadSFBuilder::setFrameNumber);

    Optional.ofNullable(innerBulkHeadSF.getForeAlpha())
        .ifPresent(foreAlpha -> innerBulkHeadSFBuilder.setForeAlpha(String.valueOf(foreAlpha)));
    Optional.ofNullable(innerBulkHeadSF.getForeCenterCargotankId())
        .ifPresent(
            foreCenterCargoTankId ->
                innerBulkHeadSFBuilder.setForeCenterCargoTankId(foreCenterCargoTankId.longValue()));
    Optional.ofNullable(innerBulkHeadSF.getForeC1())
        .ifPresent(foreC1 -> innerBulkHeadSFBuilder.setForeC1(String.valueOf(foreC1)));

    Optional.ofNullable(innerBulkHeadSF.getForeWingTankId())
        .ifPresent(
            foreWingTankIds ->
                innerBulkHeadSFBuilder.setForeWingTankIds(String.valueOf(foreWingTankIds)));

    Optional.ofNullable(innerBulkHeadSF.getForeC2())
        .ifPresent(foreC2 -> innerBulkHeadSFBuilder.setForeC2(String.valueOf(foreC2)));

    Optional.ofNullable(innerBulkHeadSF.getForeBallastTank())
        .ifPresent(
            foreBallastTanks ->
                innerBulkHeadSFBuilder.setForeBallastTanks(String.valueOf(foreBallastTanks)));

    Optional.ofNullable(innerBulkHeadSF.getForeC3())
        .ifPresent(foreC3 -> innerBulkHeadSFBuilder.setForeC3(String.valueOf(foreC3)));

    Optional.ofNullable(innerBulkHeadSF.getForeBwCorrection())
        .ifPresent(
            foreBWCorrection ->
                innerBulkHeadSFBuilder.setForeBWCorrection(String.valueOf(foreBWCorrection)));

    Optional.ofNullable(innerBulkHeadSF.getForeC4())
        .ifPresent(foreC4 -> innerBulkHeadSFBuilder.setForeC4(String.valueOf(foreC4)));

    Optional.ofNullable(innerBulkHeadSF.getForeMaxAllowence())
        .ifPresent(
            foreMaxAllowence ->
                innerBulkHeadSFBuilder.setForeMaxAllowence(String.valueOf(foreMaxAllowence)));

    Optional.ofNullable(innerBulkHeadSF.getForeMinAllowence())
        .ifPresent(
            foreMinAllowence ->
                innerBulkHeadSFBuilder.setForeMinAllowence(String.valueOf(foreMinAllowence)));

    Optional.ofNullable(innerBulkHeadSF.getAftAlpha())
        .ifPresent(aftAlpha -> innerBulkHeadSFBuilder.setAftAlpha(String.valueOf(aftAlpha)));
    Optional.ofNullable(innerBulkHeadSF.getAftCenterCargotankId())
        .ifPresent(
            aftCenterCargoTankId ->
                innerBulkHeadSFBuilder.setAftCenterCargoTankId(aftCenterCargoTankId.longValue()));
    Optional.ofNullable(innerBulkHeadSF.getAftC1())
        .ifPresent(aftC1 -> innerBulkHeadSFBuilder.setAftC1(String.valueOf(aftC1)));

    Optional.ofNullable(innerBulkHeadSF.getAftWingTankId())
        .ifPresent(
            aftWingTankIds ->
                innerBulkHeadSFBuilder.setAftWingTankIds(String.valueOf(aftWingTankIds)));

    Optional.ofNullable(innerBulkHeadSF.getAftC2())
        .ifPresent(aftC2 -> innerBulkHeadSFBuilder.setAftC2(String.valueOf(aftC2)));

    Optional.ofNullable(innerBulkHeadSF.getAftBallastTank())
        .ifPresent(
            aftBallastTanks ->
                innerBulkHeadSFBuilder.setAftBallastTanks(String.valueOf(aftBallastTanks)));

    Optional.ofNullable(innerBulkHeadSF.getAftC3())
        .ifPresent(aftC3 -> innerBulkHeadSFBuilder.setAftC3(String.valueOf(aftC3)));

    Optional.ofNullable(innerBulkHeadSF.getAftBwCorrection())
        .ifPresent(
            aftBWCorrection ->
                innerBulkHeadSFBuilder.setAftBWCorrection(String.valueOf(aftBWCorrection)));

    Optional.ofNullable(innerBulkHeadSF.getAftC4())
        .ifPresent(aftC4 -> innerBulkHeadSFBuilder.setAftC4(String.valueOf(aftC4)));

    Optional.ofNullable(innerBulkHeadSF.getAftMaxFlAllowence())
        .ifPresent(
            aftMaxFlAllowence ->
                innerBulkHeadSFBuilder.setAftMaxFlAllowence(String.valueOf(aftMaxFlAllowence)));

    Optional.ofNullable(innerBulkHeadSF.getAftMinFlAllowence())
        .ifPresent(
            aftMinFlAllowence ->
                innerBulkHeadSFBuilder.setAftMinFlAllowence(String.valueOf(aftMinFlAllowence)));

    return innerBulkHeadSFBuilder.build();
  }

  /**
   * @param stationValue
   * @param stationValueBuilder
   * @return StationValues
   */
  private StationValues createStationValueBuilder(
      com.cpdss.vesselinfo.entity.StationValues stationValue,
      com.cpdss.common.generated.VesselInfo.StationValues.Builder stationValueBuilder) {
    Optional.ofNullable(stationValue.getId()).ifPresent(id -> stationValueBuilder.setId(id));
    Optional.ofNullable(stationValue.getFrameNumberFrom())
        .ifPresent(
            frameNumberFrom ->
                stationValueBuilder.setFrameNumberFrom(String.valueOf(frameNumberFrom)));
    Optional.ofNullable(stationValue.getFrameNumberTo())
        .ifPresent(
            frameNumberTo -> stationValueBuilder.setFrameNumberTo(String.valueOf(frameNumberTo)));
    Optional.ofNullable(stationValue.getStattionFrom())
        .ifPresent(stationFrom -> stationValueBuilder.setStationFrom(String.valueOf(stationFrom)));
    Optional.ofNullable(stationValue.getStationTo())
        .ifPresent(stationTo -> stationValueBuilder.setStationTo(String.valueOf(stationTo)));
    Optional.ofNullable(stationValue.getDistance())
        .ifPresent(distance -> stationValueBuilder.setDistance(String.valueOf(distance)));
    return stationValueBuilder.build();
  }

  /**
   * @param minMaxValuesForBmsf
   * @param minMaxValuesForBMAndSfBuilder
   * @return MinMaxValuesForBMAndSf
   */
  private MinMaxValuesForBMAndSf createMinMaxValuesForBMAndSfBuilder(
      MinMaxValuesForBmsf minMaxValuesForBmsf,
      com.cpdss.common.generated.VesselInfo.MinMaxValuesForBMAndSf.Builder
          minMaxValuesForBMAndSfBuilder) {
    Optional.ofNullable(minMaxValuesForBmsf.getId())
        .ifPresent(id -> minMaxValuesForBMAndSfBuilder.setId(id));
    Optional.ofNullable(minMaxValuesForBmsf.getFrameNumber())
        .ifPresent(
            frameNumber ->
                minMaxValuesForBMAndSfBuilder.setFrameNumber(String.valueOf(frameNumber)));
    Optional.ofNullable(minMaxValuesForBmsf.getMinBm())
        .ifPresent(minBm -> minMaxValuesForBMAndSfBuilder.setMinBm(String.valueOf(minBm)));

    Optional.ofNullable(minMaxValuesForBmsf.getMaxBm())
        .ifPresent(maxBm -> minMaxValuesForBMAndSfBuilder.setMaxBm(String.valueOf(maxBm)));

    Optional.ofNullable(minMaxValuesForBmsf.getMinSf())
        .ifPresent(minSf -> minMaxValuesForBMAndSfBuilder.setMinSf(String.valueOf(minSf)));

    Optional.ofNullable(minMaxValuesForBmsf.getMaxSf())
        .ifPresent(maxSf -> minMaxValuesForBMAndSfBuilder.setMaxSf(String.valueOf(maxSf)));

    return minMaxValuesForBMAndSfBuilder.build();
  }

  /**
   * @param calculationSheetTankgroup
   * @param calculationSheetTankGroupBuilder
   * @return CalculationSheetTankGroup
   */
  private CalculationSheetTankGroup createCalculationSheetTankGroup(
      CalculationSheetTankgroup calculationSheetTankgroup,
      com.cpdss.common.generated.VesselInfo.CalculationSheetTankGroup.Builder
          calculationSheetTankGroupBuilder) {
    Optional.ofNullable(calculationSheetTankgroup.getId())
        .ifPresent(id -> calculationSheetTankGroupBuilder.setId(id));
    Optional.ofNullable(calculationSheetTankgroup.getTankGroup())
        .ifPresent(tankGroup -> calculationSheetTankGroupBuilder.setTankGroup(tankGroup));
    Optional.ofNullable(calculationSheetTankgroup.getLcg())
        .ifPresent(lcg -> calculationSheetTankGroupBuilder.setLcg(String.valueOf(lcg)));
    Optional.ofNullable(calculationSheetTankgroup.getFrameNumber())
        .ifPresent(
            frameNumber ->
                calculationSheetTankGroupBuilder.setFrameNumber(String.valueOf(frameNumber)));

    return calculationSheetTankGroupBuilder.build();
  }

  /**
   * @param calculationSheet
   * @param calculationSheetBuilder
   * @return CalculationSheet
   */
  private CalculationSheet createCalculationSheet(
      com.cpdss.vesselinfo.entity.CalculationSheet calculationSheet,
      com.cpdss.common.generated.VesselInfo.CalculationSheet.Builder calculationSheetBuilder) {
    Optional.ofNullable(calculationSheet.getId())
        .ifPresent(id -> calculationSheetBuilder.setId(id));
    Optional.ofNullable(calculationSheet.getTankGroup())
        .ifPresent(tankGroup -> calculationSheetBuilder.setTankGroup(tankGroup));
    Optional.ofNullable(calculationSheet.getTankId())
        .ifPresent(tankId -> calculationSheetBuilder.setTankId(tankId));
    Optional.ofNullable(calculationSheet.getWeightRatio())
        .ifPresent(
            weightRatio -> calculationSheetBuilder.setWeightRatio(String.valueOf(weightRatio)));
    Optional.ofNullable(calculationSheet.getLcg())
        .ifPresent(lcg -> calculationSheetBuilder.setLcg(String.valueOf(lcg)));
    return calculationSheetBuilder.build();
  }

  /**
   * @param shearingForceType1
   * @param shearingForceBuilder
   * @return ShearingForce
   */
  private ShearingForceType1 createShearingForce(
      com.cpdss.vesselinfo.entity.ShearingForceType1 shearingForceType1,
      com.cpdss.common.generated.VesselInfo.ShearingForceType1.Builder shearingForceBuilder) {
    Optional.ofNullable(shearingForceType1.getId()).ifPresent(id -> shearingForceBuilder.setId(id));
    Optional.ofNullable(shearingForceType1.getFrameNumber())
        .ifPresent(frameNumber -> shearingForceBuilder.setFrameNumber(String.valueOf(frameNumber)));
    Optional.ofNullable(shearingForceType1.getBaseDraft())
        .ifPresent(baseDraft -> shearingForceBuilder.setBaseDraft(String.valueOf(baseDraft)));
    Optional.ofNullable(shearingForceType1.getBaseValue())
        .ifPresent(baseValue -> shearingForceBuilder.setBaseValue(String.valueOf(baseValue)));
    Optional.ofNullable(shearingForceType1.getDraftCorrection())
        .ifPresent(
            draftCorrection ->
                shearingForceBuilder.setDraftCorrection(String.valueOf(draftCorrection)));
    Optional.ofNullable(shearingForceType1.getTrimCorrection())
        .ifPresent(
            trimCorrection ->
                shearingForceBuilder.setTrimCorrection(String.valueOf(trimCorrection)));
    return shearingForceBuilder.build();
  }

  /**
   * @param shearingForce
   * @param shearingForceBuilder
   * @return ShearingForce
   */
  private ShearingForceType2 createShearingForce2(
      com.cpdss.vesselinfo.entity.ShearingForceType2 shearingForce,
      com.cpdss.common.generated.VesselInfo.ShearingForceType2.Builder shearingForceBuilder) {

    Optional.ofNullable(shearingForce.getDisplacement())
        .ifPresent(
            displacement -> shearingForceBuilder.setDisplacement(String.valueOf(displacement)));

    Optional.ofNullable(shearingForce.getFrameNumber())
        .ifPresent(frameNumber -> shearingForceBuilder.setFrameNumber(String.valueOf(frameNumber)));

    Optional.ofNullable(shearingForce.getBuay())
        .ifPresent(buay -> shearingForceBuilder.setBuay(String.valueOf(buay)));

    Optional.ofNullable(shearingForce.getDifft())
        .ifPresent(baseValue -> shearingForceBuilder.setDifft(String.valueOf(baseValue)));

    Optional.ofNullable(shearingForce.getCorrt())
        .ifPresent(
            draftCorrection -> shearingForceBuilder.setCorrt(String.valueOf(draftCorrection)));

    Optional.ofNullable(shearingForce.getIsActive())
        .ifPresent(isActive -> shearingForceBuilder.setIsActive(String.valueOf(isActive)));

    return shearingForceBuilder.build();
  }

  /**
   * @param shearingForce
   * @param shearingForceBuilder
   * @return ShearingForce
   */
  private ShearingForceType4 createShearingForceType4(
      com.cpdss.vesselinfo.entity.ShearingForceType4 shearingForce,
      com.cpdss.common.generated.VesselInfo.ShearingForceType4.Builder shearingForceBuilder) {

    Optional.ofNullable(shearingForce.getFrameNumber())
        .ifPresent(frameNumber -> shearingForceBuilder.setFrameNumber(String.valueOf(frameNumber)));

    Optional.ofNullable(shearingForce.getTrim_m1())
        .ifPresent(trim_m1 -> shearingForceBuilder.setTrimM1(String.valueOf(trim_m1)));

    Optional.ofNullable(shearingForce.getTrim_1())
        .ifPresent(trim1 -> shearingForceBuilder.setTrim1(String.valueOf(trim1)));
    Optional.ofNullable(shearingForce.getTrim_3())
        .ifPresent(trim2 -> shearingForceBuilder.setTrim1(String.valueOf(trim2)));
    Optional.ofNullable(shearingForce.getTrim_3())
        .ifPresent(trim3 -> shearingForceBuilder.setTrim2(String.valueOf(trim3)));
    Optional.ofNullable(shearingForce.getTrim_4())
        .ifPresent(trim4 -> shearingForceBuilder.setTrim3(String.valueOf(trim4)));
    Optional.ofNullable(shearingForce.getTrim_5())
        .ifPresent(trim5 -> shearingForceBuilder.setTrim4(String.valueOf(trim5)));

    return shearingForceBuilder.build();
  }

  /**
   * @param type3
   * @param shearingForceBuilder
   * @return ShearingForce
   */
  private BendingMomentShearingForceType3 createBendingMomentShearingForce3(
      com.cpdss.vesselinfo.entity.BendingMomentShearingForceType3 type3,
      com.cpdss.common.generated.VesselInfo.BendingMomentShearingForceType3.Builder
          shearingForceBuilder) {

    Optional.ofNullable(type3.getFrameNumber())
        .ifPresent(frameNumber -> shearingForceBuilder.setFrameNumber(String.valueOf(frameNumber)));

    return shearingForceBuilder.build();
  }

  /**
   * @param bendingMomentType1
   * @param bendingMomentBuilder
   * @return BendingMoment
   */
  private BendingMomentType1 createBendingMomentType1(
      com.cpdss.vesselinfo.entity.BendingMomentType1 bendingMomentType1,
      BendingMomentType1.Builder bendingMomentBuilder) {
    Optional.ofNullable(bendingMomentType1.getId()).ifPresent(id -> bendingMomentBuilder.setId(id));
    Optional.ofNullable(bendingMomentType1.getFrameNumber())
        .ifPresent(frameNumber -> bendingMomentBuilder.setFrameNumber(String.valueOf(frameNumber)));
    Optional.ofNullable(bendingMomentType1.getBaseDraft())
        .ifPresent(baseDraft -> bendingMomentBuilder.setBaseDraft(String.valueOf(baseDraft)));
    Optional.ofNullable(bendingMomentType1.getBaseValue())
        .ifPresent(baseValue -> bendingMomentBuilder.setBaseValue(String.valueOf(baseValue)));
    Optional.ofNullable(bendingMomentType1.getDraftCorrection())
        .ifPresent(
            draftCorrection ->
                bendingMomentBuilder.setDraftCorrection(String.valueOf(draftCorrection)));
    Optional.ofNullable(bendingMomentType1.getTrimCorrection())
        .ifPresent(
            trimCorrection ->
                bendingMomentBuilder.setTrimCorrection(String.valueOf(trimCorrection)));
    return bendingMomentBuilder.build();
  }

  /**
   * @param bendingMomentBuildertype2
   * @param bendingMoment
   * @return BendingMoment
   */
  private com.cpdss.common.generated.VesselInfo.BendingMomentType2 createBendingMomentType2(
      com.cpdss.vesselinfo.entity.BendingMomentType2 bendingMoment,
      com.cpdss.common.generated.VesselInfo.BendingMomentType2.Builder bendingMomentBuildertype2) {

    Optional.ofNullable(bendingMoment.getDisplacement())
        .ifPresent(
            displacement ->
                bendingMomentBuildertype2.setDisplacement(String.valueOf(displacement)));

    Optional.ofNullable(bendingMoment.getFrameNumber())
        .ifPresent(
            frameNumber -> bendingMomentBuildertype2.setFrameNumber(String.valueOf(frameNumber)));

    Optional.ofNullable(bendingMoment.getBuay())
        .ifPresent(buay -> bendingMomentBuildertype2.setBuay(String.valueOf(buay)));

    Optional.ofNullable(bendingMoment.getDifft())
        .ifPresent(baseValue -> bendingMomentBuildertype2.setDifft(String.valueOf(baseValue)));

    Optional.ofNullable(bendingMoment.getCorrt())
        .ifPresent(
            draftCorrection -> bendingMomentBuildertype2.setCorrt(String.valueOf(draftCorrection)));

    Optional.ofNullable(bendingMoment.getIsActive())
        .ifPresent(isActive -> bendingMomentBuildertype2.setIsActive(String.valueOf(isActive)));

    return bendingMomentBuildertype2.build();
  }

  /**
   * @param bendingMoment
   * @return BendingMoment
   */
  private com.cpdss.common.generated.VesselInfo.BendingMomentType4 createBendingMomentType4(
      com.cpdss.vesselinfo.entity.BendingMomentType4 bendingMoment,
      com.cpdss.common.generated.VesselInfo.BendingMomentType4.Builder bendingMomentBuildertype4) {

    Optional.ofNullable(bendingMoment.getFrameNumber())
        .ifPresent(
            frameNumber -> bendingMomentBuildertype4.setFrameNumber(String.valueOf(frameNumber)));

    Optional.ofNullable(bendingMoment.getTrim_m1())
        .ifPresent(trim_m1 -> bendingMomentBuildertype4.setTrimM1(String.valueOf(trim_m1)));

    Optional.ofNullable(bendingMoment.getTrim_1())
        .ifPresent(trim1 -> bendingMomentBuildertype4.setTrim1(String.valueOf(trim1)));
    Optional.ofNullable(bendingMoment.getTrim_3())
        .ifPresent(trim2 -> bendingMomentBuildertype4.setTrim1(String.valueOf(trim2)));
    Optional.ofNullable(bendingMoment.getTrim_3())
        .ifPresent(trim3 -> bendingMomentBuildertype4.setTrim2(String.valueOf(trim3)));
    Optional.ofNullable(bendingMoment.getTrim_4())
        .ifPresent(trim4 -> bendingMomentBuildertype4.setTrim3(String.valueOf(trim4)));
    Optional.ofNullable(bendingMoment.getTrim_5())
        .ifPresent(trim5 -> bendingMomentBuildertype4.setTrim4(String.valueOf(trim5)));

    Optional.ofNullable(bendingMomentBuildertype4.getIsActive())
        .ifPresent(isActive -> bendingMomentBuildertype4.setIsActive(String.valueOf(isActive)));

    return bendingMomentBuildertype4.build();
  }

  /*
   * int64 id = 1; string frameNumber = 2; string trim_m1 = 3; string trim_0 = 4;
   * string trim_1 = 5; string trim_2 = 6; string trim_3 = 7; string trim_4 = 8;
   * string trim_5 = 9; string isActive = 10;
   */

  /**
   * @param vesselTankTcg
   * @param vesselTankTcgBuilder
   * @return VesselTankTCG
   */
  private VesselTankTCG createVesselTankTcg(
      VesselTankTcg vesselTankTcg,
      com.cpdss.common.generated.VesselInfo.VesselTankTCG.Builder vesselTankTcgBuilder) {
    Optional.ofNullable(vesselTankTcg.getId()).ifPresent(id -> vesselTankTcgBuilder.setId(id));
    Optional.ofNullable(vesselTankTcg.getCapacity())
        .ifPresent(capacity -> vesselTankTcgBuilder.setCapacity(String.valueOf(capacity)));
    Optional.ofNullable(vesselTankTcg.getTankId())
        .ifPresent(tankId -> vesselTankTcgBuilder.setTankId(tankId));
    Optional.ofNullable(vesselTankTcg.getTcg())
        .ifPresent(tcg -> vesselTankTcgBuilder.setTcg(String.valueOf(tcg)));
    Optional.ofNullable(vesselTankTcg.getLcg())
        .ifPresent(lcg -> vesselTankTcgBuilder.setLcg(String.valueOf(lcg)));
    Optional.ofNullable(vesselTankTcg.getVcg())
        .ifPresent(vcg -> vesselTankTcgBuilder.setVcg(String.valueOf(vcg)));
    Optional.ofNullable(vesselTankTcg.getInertia())
        .ifPresent(inertia -> vesselTankTcgBuilder.setInertia(String.valueOf(inertia)));
    return vesselTankTcgBuilder.build();
  }

  /**
   * @param hydrostaticTable
   * @param hydrostaticDataBuilder
   * @return HydrostaticData
   */
  private HydrostaticData createhydrostaticTableData(
      HydrostaticTable hydrostaticTable,
      com.cpdss.common.generated.VesselInfo.HydrostaticData.Builder hydrostaticDataBuilder) {
    Optional.ofNullable(hydrostaticTable.getId()).ifPresent(id -> hydrostaticDataBuilder.setId(id));
    Optional.ofNullable(hydrostaticTable.getTrim())
        .ifPresent(trim -> hydrostaticDataBuilder.setTrim(String.valueOf(trim)));
    Optional.ofNullable(hydrostaticTable.getDraft())
        .ifPresent(draft -> hydrostaticDataBuilder.setDraft(String.valueOf(draft)));
    Optional.ofNullable(hydrostaticTable.getDisplacement())
        .ifPresent(
            displacement -> hydrostaticDataBuilder.setDisplacement(String.valueOf(displacement)));
    Optional.ofNullable(hydrostaticTable.getLcb())
        .ifPresent(lcb -> hydrostaticDataBuilder.setLcb(String.valueOf(lcb)));
    Optional.ofNullable(hydrostaticTable.getLcf())
        .ifPresent(lcf -> hydrostaticDataBuilder.setLcf(String.valueOf(lcf)));
    Optional.ofNullable(hydrostaticTable.getMtc())
        .ifPresent(mtc -> hydrostaticDataBuilder.setMtc(String.valueOf(mtc)));
    Optional.ofNullable(hydrostaticTable.getTpc())
        .ifPresent(tpc -> hydrostaticDataBuilder.setTpc(String.valueOf(tpc)));
    Optional.ofNullable(hydrostaticTable.getVcb())
        .ifPresent(vcb -> hydrostaticDataBuilder.setVcb(String.valueOf(vcb)));
    Optional.ofNullable(hydrostaticTable.getTkm())
        .ifPresent(tkm -> hydrostaticDataBuilder.setTkm(String.valueOf(tkm)));
    Optional.ofNullable(hydrostaticTable.getLkm())
        .ifPresent(lkm -> hydrostaticDataBuilder.setLkm(String.valueOf(lkm)));
    return hydrostaticDataBuilder.build();
  }

  /**
   * @param vesselTank
   * @param vesselTankBuilder
   * @return VesselTankDetail
   */
  private VesselTankDetail createVesselTankData(
      VesselTank vesselTank,
      com.cpdss.common.generated.VesselInfo.VesselTankDetail.Builder vesselTankBuilder) {
    Optional.ofNullable(vesselTank.getId()).ifPresent(id -> vesselTankBuilder.setTankId(id));
    Optional.ofNullable(vesselTank.getTankCategory())
        .ifPresent(tankCategory -> vesselTankBuilder.setTankCategoryId(tankCategory.getId()));
    Optional.ofNullable(vesselTank.getTankType())
        .ifPresent(tankType -> vesselTankBuilder.setTankTypeId(tankType.getId()));
    Optional.ofNullable(vesselTank.getCoatingTypeXid())
        .ifPresent(coatingTypeId -> vesselTankBuilder.setCoatingTypeId(coatingTypeId));
    Optional.ofNullable(vesselTank.getTankName())
        .ifPresent(tankName -> vesselTankBuilder.setTankName(tankName));
    Optional.ofNullable(vesselTank.getFrameNumberFrom())
        .ifPresent(frameNumberFrom -> vesselTankBuilder.setFrameNumberFrom(frameNumberFrom));
    Optional.ofNullable(vesselTank.getFrameNumberTo())
        .ifPresent(frameNumberTo -> vesselTankBuilder.setFrameNumberTo(frameNumberTo));
    Optional.ofNullable(vesselTank.getFullCapacityCubm())
        .ifPresent(
            fullCapacityCubm ->
                vesselTankBuilder.setFullCapacityCubm(String.valueOf(fullCapacityCubm)));
    Optional.ofNullable(vesselTank.getLcg())
        .ifPresent(lcg -> vesselTankBuilder.setLcg(String.valueOf(lcg)));
    Optional.ofNullable(vesselTank.getVcg())
        .ifPresent(vcg -> vesselTankBuilder.setVcg(String.valueOf(vcg)));
    Optional.ofNullable(vesselTank.getTcg())
        .ifPresent(tcg -> vesselTankBuilder.setTcg(String.valueOf(tcg)));
    Optional.ofNullable(vesselTank.getFillCapacityCubm())
        .ifPresent(
            fillCapacityCubm ->
                vesselTankBuilder.setFillCapacityCubm(String.valueOf(fillCapacityCubm)));
    Optional.ofNullable(vesselTank.getShortName())
        .ifPresent(shortName -> vesselTankBuilder.setShortName(shortName));
    Optional.ofNullable(vesselTank.getIsLoadicatorUsing())
        .ifPresent(isLoadicatorUsing -> vesselTankBuilder.setIsLoadicatorUsing(isLoadicatorUsing));
    vesselTankBuilder.setIsSlopTank(
        vesselTank.getIsSlopTank() == null ? false : vesselTank.getIsSlopTank());
    Optional.ofNullable(vesselTank.getTankDisplayOrder())
        .ifPresent(vesselTankBuilder::setTankDisplayOrder);
    return vesselTankBuilder.build();
  }

  /**
   * @param vesselDraftCondition
   * @param vesselDraftConditionBuilder
   * @return HydrostaticData
   */
  private com.cpdss.common.generated.VesselInfo.VesselDraftCondition createVesselHydrostaticData(
      VesselDraftCondition vesselDraftCondition,
      com.cpdss.common.generated.VesselInfo.VesselDraftCondition.Builder
          vesselDraftConditionBuilder) {
    Optional.ofNullable(vesselDraftCondition.getId())
        .ifPresent(id -> vesselDraftConditionBuilder.setId(id));
    Optional.ofNullable(vesselDraftCondition.getDraftCondition())
        .ifPresent(
            draftCondition ->
                vesselDraftConditionBuilder.setDraftConditionId(draftCondition.getId()));

    Optional.ofNullable(vesselDraftCondition.getDepth())
        .ifPresent(depth -> vesselDraftConditionBuilder.setDepth(String.valueOf(depth)));
    Optional.ofNullable(vesselDraftCondition.getFreeboard())
        .ifPresent(
            freeBoard -> vesselDraftConditionBuilder.setFreeboard(String.valueOf(freeBoard)));
    Optional.ofNullable(vesselDraftCondition.getDraftExtreme())
        .ifPresent(
            draftExtreme ->
                vesselDraftConditionBuilder.setDraftExtreme(String.valueOf(draftExtreme)));
    Optional.ofNullable(vesselDraftCondition.getDisplacement())
        .ifPresent(
            displacement ->
                vesselDraftConditionBuilder.setDisplacement(String.valueOf(displacement)));
    Optional.ofNullable(vesselDraftCondition.getDeadweight())
        .ifPresent(
            deadweight -> vesselDraftConditionBuilder.setDeadWeight(String.valueOf(deadweight)));
    return vesselDraftConditionBuilder.build();
  }

  /**
   * @param vessel
   * @param vesselDetailBuilder
   * @return VesselDetail
   */
  private VesselDetail createVesseDetails(Vessel vessel, Builder vesselDetailBuilder) {
    Optional.ofNullable(vessel.getName()).ifPresent(name -> vesselDetailBuilder.setName(name));
    Optional.ofNullable(vessel.getImoNumber())
        .ifPresent(imoNumber -> vesselDetailBuilder.setImoNumber(imoNumber));

    Optional.ofNullable(vessel.getPortOfRegistry())
        .ifPresent(portOfRegistory -> vesselDetailBuilder.setPortOfRegistry(portOfRegistory));

    Optional.ofNullable(vessel.getOfficialNumber())
        .ifPresent(officialNumber -> vesselDetailBuilder.setOfficialNumber(officialNumber));

    Optional.ofNullable(vessel.getSignalLetter())
        .ifPresent(signalLetter -> vesselDetailBuilder.setImoNumber(signalLetter));

    Optional.ofNullable(vessel.getNavigationAreaId())
        .ifPresent(navigationAreaId -> vesselDetailBuilder.setNavigationAreaId(navigationAreaId));

    Optional.ofNullable(vessel.getTypeOfShip())
        .ifPresent(typeOfShip -> vesselDetailBuilder.setTypeOfShip(typeOfShip));

    Optional.ofNullable(vessel.getBm_sf_model_type())
        .ifPresent(bmModelType -> vesselDetailBuilder.setBmSfModelType(bmModelType.toString()));

    Optional.ofNullable(vessel.getRegisterLength())
        .ifPresent(
            registerLength ->
                vesselDetailBuilder.setRegisterLength(String.valueOf(registerLength)));

    Optional.ofNullable(vessel.getLengthOverall())
        .ifPresent(
            lenthOverall -> vesselDetailBuilder.setLengthOverall(String.valueOf(lenthOverall)));

    Optional.ofNullable(vessel.getLengthBetweenPerpendiculars())
        .ifPresent(
            lengthBetweenPerpendiculars ->
                vesselDetailBuilder.setLengthBetweenPerpendiculars(
                    String.valueOf(lengthBetweenPerpendiculars)));

    Optional.ofNullable(vessel.getDepthMolded())
        .ifPresent(depthMolded -> vesselDetailBuilder.setDepthMolded(String.valueOf(depthMolded)));

    Optional.ofNullable(vessel.getDesignedLoaddraft())
        .ifPresent(
            designedLoaddraft ->
                vesselDetailBuilder.setDesignedLoaddraft(String.valueOf(designedLoaddraft)));

    Optional.ofNullable(vessel.getDraftFullLoadSummer())
        .ifPresent(
            draftFullLoadSummer ->
                vesselDetailBuilder.setDraftFullLoadSummer(String.valueOf(draftFullLoadSummer)));

    Optional.ofNullable(vessel.getThicknessOfUpperDeckStringerPlate())
        .ifPresent(
            thicknessOfUpperDeckStringerPlate ->
                vesselDetailBuilder.setThicknessOfUpperDeckStringerPlate(
                    String.valueOf(thicknessOfUpperDeckStringerPlate)));

    Optional.ofNullable(vessel.getThicknessOfKeelplate())
        .ifPresent(
            thicknessOfKeelplate ->
                vesselDetailBuilder.setThicknessOfKeelplate(String.valueOf(thicknessOfKeelplate)));

    Optional.ofNullable(vessel.getDeadweight())
        .ifPresent(deadweight -> vesselDetailBuilder.setDeadweight(String.valueOf(deadweight)));

    Optional.ofNullable(vessel.getLightweight())
        .ifPresent(lightweight -> vesselDetailBuilder.setLightweight(String.valueOf(lightweight)));

    Optional.ofNullable(vessel.getLcg())
        .ifPresent(lcg -> vesselDetailBuilder.setLcg(String.valueOf(lcg)));

    Optional.ofNullable(vessel.getKeelToMastHeight())
        .ifPresent(
            keelToMastHeight ->
                vesselDetailBuilder.setKeelToMastHeight(String.valueOf(keelToMastHeight)));

    Optional.ofNullable(vessel.getDeadweightConstant())
        .ifPresent(
            deadweightConstant ->
                vesselDetailBuilder.setDeadweightConstant(String.valueOf(deadweightConstant)));

    Optional.ofNullable(vessel.getProvisionalConstant())
        .ifPresent(
            provisionalConstant ->
                vesselDetailBuilder.setProvisionalConstant(String.valueOf(provisionalConstant)));

    Optional.ofNullable(vessel.getDeadweightConstantLcg())
        .ifPresent(
            deadweightConstantLcg ->
                vesselDetailBuilder.setDeadweightConstantLcg(
                    String.valueOf(deadweightConstantLcg)));

    Optional.ofNullable(vessel.getProvisionalConstantLcg())
        .ifPresent(
            provisionalConstantLcg ->
                vesselDetailBuilder.setProvisionalConstantLcg(
                    String.valueOf(provisionalConstantLcg)));

    Optional.ofNullable(vessel.getGrossTonnage())
        .ifPresent(
            grossTonnage -> vesselDetailBuilder.setGrossTonnage(String.valueOf(grossTonnage)));

    Optional.ofNullable(vessel.getNetTonnage())
        .ifPresent(netTonnage -> vesselDetailBuilder.setNetTonnage(String.valueOf(netTonnage)));

    Optional.ofNullable(vessel.getDeadweightConstantTcg())
        .ifPresent(
            deadweightConstantTcg ->
                vesselDetailBuilder.setDeadweightConstantTcg(
                    String.valueOf(deadweightConstantTcg)));

    Optional.ofNullable(vessel.getHasLoadicator())
        .ifPresent(hasLoadicator -> vesselDetailBuilder.setHasLoadicator(hasLoadicator));

    Optional.ofNullable(vessel.getMaxLoadRate())
        .ifPresent(value -> vesselDetailBuilder.setMaxLoadRate(String.valueOf(value)));

    Optional.ofNullable(vessel.getMastRiser())
        .ifPresent(value -> vesselDetailBuilder.setMastRiser(String.valueOf(value)));

    Optional.ofNullable(vessel.getHeightOfManifoldAboveDeck())
        .ifPresent(
            value -> vesselDetailBuilder.setHeightOfManifoldAboveDeck(String.valueOf(value)));

    return vesselDetailBuilder.build();
  }

  @Override
  public void getVesselDetailForSynopticalTable(
      VesselRequest request, StreamObserver<VesselReply> responseObserver) {
    VesselReply.Builder replyBuilder = VesselReply.newBuilder();
    try {
      List<VesselTankDetail> tankList =
          this.findVesselTanksByCategory(request.getVesselId(), request.getTankCategoriesList());
      if (null != tankList && !tankList.isEmpty()) {
        replyBuilder.addAllVesselTanks(tankList);
      }
      VesselDetails vesselDetails =
          vesselRepository.findVesselDetailsById(
              request.getVesselId(),
              request.getVesselDraftConditionId(),
              new BigDecimal(request.getDraftExtreme()));
      VesselLoadableQuantityDetails.Builder builder = VesselLoadableQuantityDetails.newBuilder();
      if (null != vesselDetails) {
        Optional.ofNullable(vesselDetails.getDisplacmentDraftRestriction())
            .ifPresent(item -> builder.setDisplacmentDraftRestriction(item.toString()));
        Optional.ofNullable(vesselDetails.getVesselLightWeight())
            .ifPresent(item -> builder.setVesselLightWeight(item.toString()));
        Optional.ofNullable(vesselDetails.getDeadWeight())
            .ifPresent(dwt -> builder.setDwt(dwt.toString()));
        Optional.ofNullable(vesselDetails.getDraftConditionName())
            .ifPresent(builder::setDraftConditionName);
        Optional.ofNullable(vesselDetails.getConstant())
            .ifPresent(constant -> builder.setConstant(constant.toString()));
        Optional.ofNullable(vesselDetails.getHasLoadicator())
            .ifPresent(hasLoadicator -> builder.setHasLoadicator(hasLoadicator));
      }
      replyBuilder.setVesselLoadableQuantityDetails(builder.build());
      replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS).build());
    } catch (GenericServiceException e) {
      log.error("GenericServiceException in getVesselDetailForSynopticalTable", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(e.getCode())
              .setMessage("GenericServiceException in getVesselDetailForSynopticalTable")
              .setStatus(FAILED)
              .build());
    } catch (Exception e) {
      log.error("Exception in getVesselDetailForSynopticalTable", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage("Exception in getVesselDetailForSynopticalTable")
              .setStatus(FAILED)
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  @Override
  public void getVesselDetailByVesselId(
      VesselRequest request, StreamObserver<VesselReply> responseObserver) {
    VesselReply.Builder replyBuilder = VesselReply.newBuilder();

    VesselInfo vesselDetails =
        vesselRepository.findVesselDetailsByVesselId(request.getVesselId(), true);
    try {
      if (null != vesselDetails) {
        VesselDetail.Builder builder = VesselDetail.newBuilder();

        Optional.ofNullable(vesselDetails.getId()).ifPresent(item -> builder.setId(item));
        Optional.ofNullable(vesselDetails.getName()).ifPresent(item -> builder.setName(item));
        Optional.ofNullable(vesselDetails.getImoNumber())
            .ifPresent(item -> builder.setImoNumber(item));
        Optional.ofNullable(vesselDetails.getTypeOfShip())
            .ifPresent(item -> builder.setTypeOfShip(item));
        Optional.ofNullable(vesselDetails.getCode()).ifPresent(item -> builder.setCode(item));
        Optional.ofNullable(vesselDetails.getDeadweightConstant())
            .ifPresent(item -> builder.setDeadweightConstant(item.toString()));
        Optional.ofNullable(vesselDetails.getProvisionalConstant())
            .ifPresent(item -> builder.setProvisionalConstant(item.toString()));
        Optional.ofNullable(vesselDetails.getHasLoadicator())
            .ifPresent(item -> builder.setHasLoadicator(item));
        // Set vessel loadable quantity details
        VesselLoadableQuantityDetails.Builder vesselLoadableQuantityBuilder =
            VesselLoadableQuantityDetails.newBuilder();
        Optional.ofNullable(vesselDetails.getLightWeight())
            .ifPresent(item -> vesselLoadableQuantityBuilder.setVesselLightWeight(item.toString()));
        Optional.ofNullable(vesselDetails.getDeadweightConstant())
            .ifPresent(
                item -> vesselLoadableQuantityBuilder.setDeadWeightConstant(item.doubleValue()));

        replyBuilder.addVessels(builder.build());
        replyBuilder.setVesselLoadableQuantityDetails(vesselLoadableQuantityBuilder);

        Vessel vessel = this.vesselRepository.findByIdAndIsActive(request.getVesselId(), true);
        if (null == vessel) {
          log.error("Vessel does not exist");
          throw new GenericServiceException(
              "Vessel with given id does not exist",
              CommonErrorCodes.E_HTTP_BAD_REQUEST,
              HttpStatusCode.BAD_REQUEST);
        }
        VesselTankDetail.Builder vesselTankBuilder = VesselTankDetail.newBuilder();
        vesselTankRepository
            .findByVesselAndIsActive(vessel, true)
            .forEach(
                vesselTank -> {
                  replyBuilder.addVesselTanks(createVesselTankData(vesselTank, vesselTankBuilder));
                });
        replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS).build());
      }

    } catch (Exception e) {
      log.error("Exception in getVesselDetailForSynopticalTable", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage("Exception in getVesselDetailForSynopticalTable")
              .setStatus(FAILED)
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  @Override
  public void getVesselInfoByPaging(
      com.cpdss.common.generated.VesselInfo.VesselRequestWithPaging request,
      StreamObserver<VesselReply> responseObserver) {
    VesselReply.Builder replyBuilder = VesselReply.newBuilder();
    try {
      List<Object[]> vesselResp = vesselRepository.findVesselIdAndNames();
      if (!vesselResp.isEmpty()) {
        log.info("Vessels list size {}", vesselResp.size());
        for (Object[] var1 : vesselResp) {
          VesselDetail.Builder builder = VesselDetail.newBuilder();
          if (var1[0] != null) { // First param Id
            BigInteger val = (BigInteger) var1[0];
            builder.setId(val.longValue());
          }
          if (var1[1] != null) { // Second param Name
            builder.setName((String) var1[1]);
          }
          replyBuilder.addVessels(builder);
        }
      }
    } catch (Exception e) {
      log.error("Exception in get all vessel Id and Name Only", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage("Exception in getVesselInfoByPaging")
              .setStatus(FAILED)
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  @Override
  public void getVesselInfoBytankIds(
      VesselTankRequest request, StreamObserver<VesselTankResponse> responseObserver) {
    VesselTankResponse.Builder replyBuilder = VesselTankResponse.newBuilder();
    try {
      List<Long> tankIds = new ArrayList<>(request.getTankIdsList());
      List<VesselTankDetails> tankResp = vesselTankRepository.findTankDetailsByTankIds(tankIds);
      if (!tankResp.isEmpty()) {
        log.info("Tank list size {}", tankResp.size());
        for (VesselTankDetails var1 : tankResp) {
          VesselTankOrder.Builder builder = VesselTankOrder.newBuilder();
          builder.setTankId(var1.getTankId());
          builder.setShortName(var1.getShortName() != null ? var1.getShortName() : null);
          builder.setTankDisplayOrder(
              var1.getTankDisplayOrder() != null ? var1.getTankDisplayOrder() : 0);
          builder.setTankName(var1.getTankName());
          replyBuilder.addVesselTankOrder(builder);
        }
      }
    } catch (Exception e) {
      log.error("Exception in get VesselInfo By tank Ids", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage("Exception in getVesselInfoBytankIds")
              .setStatus(FAILED)
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  @Override
  public void getDWTFromVesselByVesselId(
      com.cpdss.common.generated.VesselInfo.VesselDWTRequest request,
      StreamObserver<com.cpdss.common.generated.VesselInfo.VesselDWTResponse> responseObserver) {
    com.cpdss.common.generated.VesselInfo.VesselDWTResponse.Builder builder =
        com.cpdss.common.generated.VesselInfo.VesselDWTResponse.newBuilder();
    try {
      Long vesselId = request.getVesselId();
      BigDecimal draft =
          request.getDraftValue().length() > 0
              ? new BigDecimal(request.getDraftValue())
              : BigDecimal.ZERO;
      DecimalFormat df = new DecimalFormat("#.##");

      if (vesselId > 0) {
        Vessel vessel = vesselRepository.findByIdAndIsActive(vesselId, true);
        List<HydrostaticTable> tables =
            hydrostaticService.fetchAllDataByDraftAndVessel(
                vessel, new BigDecimal(df.format(draft)));
        Optional<HydrostaticTable> hydrostaticTable = tables.stream().findFirst();
        if (hydrostaticTable.isPresent()) {
          BigDecimal lightWeight =
              vessel.getLightweight() != null ? vessel.getLightweight() : BigDecimal.ZERO;
          BigDecimal displacement =
              hydrostaticTable.get().getDisplacement() != null
                  ? hydrostaticTable.get().getDisplacement()
                  : BigDecimal.ZERO;
          BigDecimal dwt = this.getDWTFromVesselAndDraft(displacement, lightWeight);
          builder.setDwtResult(String.valueOf(dwt));
        }
        builder.setVesselId(vessel.getId());
        builder.setCompanyId(vessel.getCompanyXId());
      }
      log.info(
          "Vessel Info, DWT for vessel - {}, Vessel Id {}, Draft {}",
          builder.getDwtResult(),
          vesselId,
          draft);
      builder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS).build());
    } catch (Exception e) {
      log.error("Exception in Calculate DWT from Vessel", e);
      builder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage("Exception in Calculate DWT from Vessel")
              .setStatus(FAILED)
              .build());
    } finally {
      responseObserver.onNext(builder.build());
      responseObserver.onCompleted();
    }
  }

  // calculation for DWT
  // dwt = displacement - light weight
  private BigDecimal getDWTFromVesselAndDraft(BigDecimal var1, BigDecimal var2) {
    return var1.subtract(var2);
  }

  @Override
  public void getVesselInfoByVesselId(
      com.cpdss.common.generated.VesselInfo.VesselIdRequest request,
      StreamObserver<VesselIdResponse> responseObserver) {
    VesselIdResponse.Builder replyBuilder = VesselIdResponse.newBuilder();
    try {
      VesselInfo vesselDetails =
          vesselRepository.findVesselDetailsByVesselId(request.getVesselId(), true);
      if (null == vesselDetails) {
        log.error("Vessel does not exist");
        throw new GenericServiceException(
            "Vessel with given id does not exist",
            CommonErrorCodes.E_HTTP_BAD_REQUEST,
            HttpStatusCode.BAD_REQUEST);
      } else {
        if (null != vesselDetails) {
          VesselDetail.Builder builder = VesselDetail.newBuilder();

          Optional.ofNullable(vesselDetails.getId()).ifPresent(item -> builder.setId(item));
          Optional.ofNullable(vesselDetails.getName()).ifPresent(item -> builder.setName(item));
          Optional.ofNullable(vesselDetails.getImoNumber())
              .ifPresent(item -> builder.setImoNumber(item));
          Optional.ofNullable(vesselDetails.getTypeOfShip())
              .ifPresent(item -> builder.setTypeOfShip(item));
          Optional.ofNullable(vesselDetails.getCode()).ifPresent(item -> builder.setCode(item));
          Optional.ofNullable(vesselDetails.getDeadweightConstant())
              .ifPresent(item -> builder.setDeadweightConstant(item.toString()));
          Optional.ofNullable(vesselDetails.getProvisionalConstant())
              .ifPresent(item -> builder.setProvisionalConstant(item.toString()));
          Optional.ofNullable(vesselDetails.getMaxLoadRate())
              .ifPresent(v -> builder.setMaxLoadingRate(v.toString()));
          Optional.ofNullable(vesselDetails.getMinLoadRate())
              .ifPresent(v -> builder.setMinLoadingRate(v.toString()));
          replyBuilder.setVesselDetail(builder.build());
          replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS).build());
        }
      }
    } catch (GenericServiceException e) {
      log.error("Exception in getVesselInfoByVesselId", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage("Exception in getVesselInfoByVesselId")
              .setStatus(FAILED)
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  @Override
  public void getVesselPumpsByVesselId(
      com.cpdss.common.generated.VesselInfo.VesselIdRequest request,
      StreamObserver<com.cpdss.common.generated.VesselInfo.VesselPumpsResponse> responseObserver) {
    com.cpdss.common.generated.VesselInfo.VesselPumpsResponse.Builder builder =
        com.cpdss.common.generated.VesselInfo.VesselPumpsResponse.newBuilder();
    try {
      this.vesselPumpService.getVesselPumpsAndTypes(builder, request.getVesselId());
    } catch (Exception e) {
      log.error("Exception in Vessel Pump and Type Getter", e);
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

  /** To retrieve vessel rule based on vessel id OR To save rule for vessel */
  @Override
  @Transactional(rollbackFor = {RuntimeException.class, Exception.class})
  public void getRulesByVesselIdAndSectionId(
      VesselRuleRequest request, StreamObserver<VesselRuleReply> responseObserver) {
    com.cpdss.common.generated.VesselInfo.VesselRuleReply.Builder builder =
        com.cpdss.common.generated.VesselInfo.VesselRuleReply.newBuilder();
    try {
      Vessel vessel = vesselRepository.findByIdAndIsActive(request.getVesselId(), true);
      if (null == vessel) {
        log.error("Vessel does not exist in saving rule");
        throw new GenericServiceException(
            "Vessel with given id does not exist",
            CommonErrorCodes.E_HTTP_BAD_REQUEST,
            HttpStatusCode.BAD_REQUEST);
      }
      // Fetch master records
      List<RuleVesselDropDownValues> listOfDropDownValue =
          ruleVesselDropDownValuesRepository.findByIsActive(true);
      // fetch master for cargo tank dropdown
      List<CargoTankMaster> cargoTankMaster =
          vesselTankRepository.findCargoTankMaster(request.getVesselId(), true);
      // fetch master for rule type
      List<RuleType> ruleTypeList = ruleTypeRepository.findByIsActive(true);
      if (!CollectionUtils.isEmpty(request.getRulePlanList())) {
        log.info("To save rule against vessel");
        saveRulesAgainstVessel(request, vessel, listOfDropDownValue, cargoTankMaster, ruleTypeList);
      }
      // Fetch rules against rule
      List<VesselRule> vesselRuleList =
          vesselRepository.findRulesAgainstVessel(request.getVesselId(), request.getSectionId());
      if (vesselRuleList != null && vesselRuleList.size() > 0) {
        if (!request.getIsNoDefaultRule()) {
          log.info("Fetch vessel rule for admin");
          buildResponseForVesselRules(
              builder,
              vesselRuleList,
              true,
              false,
              listOfDropDownValue,
              cargoTankMaster,
              request.getIsFetchEnabledRules());
        } else {
          log.info("Fetch vessel rule for loadable study");
          // isDisplayId: false means primary key will be set null for all rules
          // isDisplayVesselRuleXId: true means primary key value set to foriegn key
          // column for
          // storing rules against loadable study
          buildResponseForVesselRules(
              builder,
              vesselRuleList,
              false,
              true,
              listOfDropDownValue,
              cargoTankMaster,
              request.getIsFetchEnabledRules());
        }
      } else {
        if (!request.getIsNoDefaultRule()) {
          log.info("Fetch default rule template");
          vesselRuleList = vesselRepository.findDefaultAdminRule(request.getSectionId());
          buildResponseForVesselRules(
              builder,
              vesselRuleList,
              false,
              false,
              listOfDropDownValue,
              cargoTankMaster,
              request.getIsFetchEnabledRules());
        }
      }
      buildCargoTankMaster(builder, cargoTankMaster);
      buildRuleDropDownMaster(builder, listOfDropDownValue);
      buildRuleTypeMaster(builder, ruleTypeList);
      builder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS).build());
    } catch (GenericServiceException e) {
      log.error("GenericServiceException when save or get vessel rule", e);
      builder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage(e.getMessage())
              .setStatus(FAILED)
              .build());
    } catch (Exception e) {
      TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
      log.error("Exception in save or get vessel rule", e);
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

  /**
   * rule type master response
   *
   * @param builder
   * @param ruleTypeList
   */
  private void buildRuleTypeMaster(
      com.cpdss.common.generated.VesselInfo.VesselRuleReply.Builder builder,
      List<RuleType> ruleTypeList) {
    com.cpdss.common.generated.VesselInfo.RuleTypeMaster.Builder ruleTypeBuilder =
        com.cpdss.common.generated.VesselInfo.RuleTypeMaster.newBuilder();
    ruleTypeList.forEach(
        rule -> {
          Optional.ofNullable(rule.getId()).ifPresent(ruleTypeBuilder::setId);
          Optional.ofNullable(rule.getRuleType()).ifPresent(ruleTypeBuilder::setRuleType);
          builder.addRuleTypeMaster(ruleTypeBuilder.build());
        });
  }

  /**
   * rule master drop down response
   *
   * @param builder
   * @param listOfDropDownValue
   */
  private void buildRuleDropDownMaster(
      com.cpdss.common.generated.VesselInfo.VesselRuleReply.Builder builder,
      List<RuleVesselDropDownValues> listOfDropDownValue) {
    com.cpdss.common.generated.VesselInfo.RuleDropDownValueMaster.Builder rBuilder =
        com.cpdss.common.generated.VesselInfo.RuleDropDownValueMaster.newBuilder();
    listOfDropDownValue.forEach(
        dropDownValue -> {
          Optional.ofNullable(dropDownValue.getId()).ifPresent(rBuilder::setId);
          Optional.ofNullable(dropDownValue.getDropDownValue()).ifPresent(rBuilder::setValue);
          Optional.ofNullable(dropDownValue.getRuleTemplateXid())
              .ifPresent(rBuilder::setRuleTemplateId);
          builder.addRuleDropDownValueMaster(rBuilder.build());
        });
  }

  /**
   * cargo tank master response
   *
   * @param builder
   * @param cargoTankMaster
   */
  private void buildCargoTankMaster(
      com.cpdss.common.generated.VesselInfo.VesselRuleReply.Builder builder,
      List<CargoTankMaster> cargoTankMaster) {
    com.cpdss.common.generated.VesselInfo.CargoTankMaster.Builder cargoBuider =
        com.cpdss.common.generated.VesselInfo.CargoTankMaster.newBuilder();
    cargoTankMaster.forEach(
        cargoTank -> {
          Optional.ofNullable(cargoTank.getId()).ifPresent(cargoBuider::setId);
          Optional.ofNullable(cargoTank.getValue()).ifPresent(cargoBuider::setShortName);
          builder.addCargoTankMaster(cargoBuider.build());
        });
  }

  /**
   * To validate dropdown value while saving
   *
   * @param listOfDropDownValue
   * @param cargoTankMaster
   * @param isCargoTankMaster
   * @param input
   * @param ruleTemplateInput
   * @param rule
   * @throws GenericServiceException
   */
  private void ruleMasterDropDownValidation(
      List<RuleVesselDropDownValues> listOfDropDownValue,
      List<CargoTankMaster> cargoTankMaster,
      boolean isCargoTankMaster,
      RulesInputs input,
      RuleVesselMappingInput ruleTemplateInput,
      Rules rule)
      throws GenericServiceException {
    Optional<String> isDefaultValueExist =
        Optional.ofNullable(input.getDefaultValue()).filter(item -> item.trim().length() != 0);
    if (isDefaultValueExist.isPresent()) {
      String value = "";
      List<RuleVesselDropDownValues> filterMasterByRule =
          listOfDropDownValue.stream()
              .filter(
                  rDropDown ->
                      rDropDown.getRuleTemplateXid() != null
                          && rule.getRuleTemplateId() != null
                          && rDropDown
                              .getRuleTemplateXid()
                              .equals(Long.parseLong(rule.getRuleTemplateId().trim())))
              .collect(Collectors.toList());
      if (input.getDefaultValue().contains(",")) {
        String[] masterIds = input.getDefaultValue().split(",");
        for (int id = 0; id < masterIds.length; id++) {
          int finalId = id;
          if (isCargoTankMaster) {
            if (cargoTankMaster.stream()
                .map(CargoTankMaster::getId)
                .filter(item -> item == Long.parseLong(masterIds[finalId].trim()))
                .findFirst()
                .isPresent()) {
              if (masterIds.length - 1 != id) {
                value += masterIds[id] + ",";
              } else {
                value += masterIds[id];
              }
            } else {
              throw new GenericServiceException(
                  "Rule master master with given id does not exist",
                  CommonErrorCodes.E_HTTP_BAD_REQUEST,
                  HttpStatusCode.BAD_REQUEST);
            }
          } else {
            if (filterMasterByRule.stream()
                .map(RuleVesselDropDownValues::getId)
                .filter(item -> item == Long.parseLong(masterIds[finalId].trim()))
                .findFirst()
                .isPresent()) {
              if (masterIds.length - 1 != id) {
                value += masterIds[id] + ",";
              } else {
                value += masterIds[id];
              }
            } else {
              throw new GenericServiceException(
                  "Rule master master with given id does not exist",
                  CommonErrorCodes.E_HTTP_BAD_REQUEST,
                  HttpStatusCode.BAD_REQUEST);
            }
          }
        }
        ruleTemplateInput.setDefaultValue(value);
      } else {
        if (isCargoTankMaster) {
          if (input.getDefaultValue() != null
              && input.getDefaultValue().length() != 0
              && !cargoTankMaster.stream()
                  .map(CargoTankMaster::getId)
                  .filter(item -> item == Long.parseLong(input.getDefaultValue().trim()))
                  .findFirst()
                  .isPresent()) {
            throw new GenericServiceException(
                "Cargo master with given id does not exist",
                CommonErrorCodes.E_HTTP_BAD_REQUEST,
                HttpStatusCode.BAD_REQUEST);
          }
        } else {
          if (input.getDefaultValue() != null
              && input.getDefaultValue().length() != 0
              && !filterMasterByRule.stream()
                  .map(RuleVesselDropDownValues::getId)
                  .filter(item -> item == Long.parseLong(input.getDefaultValue().trim()))
                  .findFirst()
                  .isPresent()) {
            throw new GenericServiceException(
                "Rule master master with given id does not exist",
                CommonErrorCodes.E_HTTP_BAD_REQUEST,
                HttpStatusCode.BAD_REQUEST);
          }
        }
        ruleTemplateInput.setDefaultValue(input.getDefaultValue());
      }
    } else {
      ruleTemplateInput.setDefaultValue(null);
    }
  }

  /**
   * Generate rule list
   *
   * @param builder
   * @param vesselRuleList
   * @param isDisplayId
   * @param isDisplayVesselRuleXId
   * @param listOfDropDownValue
   * @param cargoTankMaster
   * @param isFetchEnabledRules
   */
  private void buildResponseForVesselRules(
      VesselRuleReply.Builder builder,
      List<VesselRule> vesselRuleList,
      boolean isDisplayId,
      boolean isDisplayVesselRuleXId,
      List<RuleVesselDropDownValues> listOfDropDownValue,
      List<CargoTankMaster> cargoTankMaster,
      boolean isFetchEnabledRules) {
    Map<String, List<VesselRule>> groupByHeader =
        vesselRuleList.stream()
            .collect(
                Collectors.groupingBy(
                    VesselRule::getHeader, LinkedHashMap::new, Collectors.toList()));
    groupByHeader.forEach(
        (header, v) -> {
          RulePlans.Builder rulePlanBuilder = RulePlans.newBuilder();
          Optional.ofNullable(header).ifPresent(rulePlanBuilder::setHeader);
          Map<Long, List<VesselRule>> groupByRuleTemplateId =
              v.stream()
                  .collect(
                      Collectors.groupingBy(
                          VesselRule::getTemplateId, LinkedHashMap::new, Collectors.toList()));
          groupByRuleTemplateId.forEach(
              (key, value) -> {
                RulesInputs.Builder ruleInput = RulesInputs.newBuilder();
                Rules.Builder rulesBuilder = Rules.newBuilder();
                for (int id = 0; id < value.size(); id++) {
                  Optional<Boolean> isRuleEnabled =
                      Optional.ofNullable(value.get(id).getTemplateIsEnable());
                  if (!isFetchEnabledRules) {
                    buildRuleListResponse(
                        value.get(id),
                        ruleInput,
                        rulesBuilder,
                        isDisplayId,
                        isDisplayVesselRuleXId,
                        listOfDropDownValue,
                        cargoTankMaster,
                        rulePlanBuilder,
                        value,
                        id);
                  } else {
                    if (isFetchEnabledRules && isRuleEnabled.isPresent() && isRuleEnabled.get()) {
                      buildRuleListResponse(
                          value.get(id),
                          ruleInput,
                          rulesBuilder,
                          isDisplayId,
                          isDisplayVesselRuleXId,
                          listOfDropDownValue,
                          cargoTankMaster,
                          rulePlanBuilder,
                          value,
                          id);
                    }
                  }
                }
              });
          builder.addRulePlan(rulePlanBuilder.build());
        });
  }

  /**
   * @param vesselRule
   * @param ruleInput
   * @param rulesBuilder
   * @param isDisplayId
   * @param isDisplayVesselRuleXId
   * @param listOfDropDownValue
   * @param cargoTankMaster
   * @param rulePlanBuilder
   * @param value
   * @param id
   */
  private void buildRuleListResponse(
      VesselRule vesselRule,
      RulesInputs.Builder ruleInput,
      Rules.Builder rulesBuilder,
      boolean isDisplayId,
      boolean isDisplayVesselRuleXId,
      List<RuleVesselDropDownValues> listOfDropDownValue,
      List<CargoTankMaster> cargoTankMaster,
      RulePlans.Builder rulePlanBuilder,
      List<VesselRule> value,
      int id) {
    Optional.ofNullable(vesselRule.getTemplateInputDefaultValue())
        .filter(item -> item.trim().length() != 0)
        .ifPresentOrElse(ruleInput::setDefaultValue, () -> ruleInput.setDefaultValue(""));
    Optional.ofNullable(vesselRule.getTemplateInputPrefix())
        .filter(item -> item.trim().length() != 0)
        .ifPresentOrElse(ruleInput::setPrefix, () -> ruleInput.setPrefix(""));
    Optional.ofNullable(vesselRule.getTemplateInputMinValue())
        .filter(item -> item.trim().length() != 0)
        .ifPresentOrElse(ruleInput::setMin, () -> ruleInput.setMin(""));
    Optional.ofNullable(vesselRule.getTemplateInputMaxValue())
        .filter(item -> item.trim().length() != 0)
        .ifPresentOrElse(ruleInput::setMax, () -> ruleInput.setMax(""));
    Optional.ofNullable(vesselRule.getTemplateInputTypeValue())
        .filter(item -> item.trim().length() != 0)
        .ifPresentOrElse(ruleInput::setType, () -> ruleInput.setType(""));
    Optional.ofNullable(vesselRule.getTemplateInputSuffix())
        .filter(item -> item.trim().length() != 0)
        .ifPresentOrElse(ruleInput::setSuffix, () -> ruleInput.setSuffix(""));
    Optional.ofNullable(vesselRule.getIsMandatory())
        .ifPresentOrElse(ruleInput::setIsMandatory, () -> ruleInput.setIsMandatory(false));
    Optional<String> isTypeBoolean =
        Optional.ofNullable(vesselRule.getTemplateInputTypeValue())
            .filter(
                item ->
                    item.trim().length() != 0
                        && item.trim().equalsIgnoreCase(TypeValue.BOOLEAN.getType()));
    if (isTypeBoolean.isPresent()) {
      Optional.ofNullable(vesselRule.getTemplateInputDefaultValue())
          .filter(item -> item.trim().length() != 0 && item.trim().equalsIgnoreCase("true"))
          .ifPresentOrElse(ruleInput::setDefaultValue, () -> ruleInput.setDefaultValue("false"));
    }
    Optional<String> isTypeDropDownOrMultiSelect =
        Optional.ofNullable(vesselRule.getTemplateInputTypeValue())
            .filter(
                item ->
                    item.trim().length() != 0
                            && item.trim().equalsIgnoreCase(TypeValue.DROPDOWN.getType())
                        || item.trim().equalsIgnoreCase(TypeValue.MULTISELECT.getType()));
    if (isTypeDropDownOrMultiSelect.isPresent()) {
      Optional<String> isPrefixExistCTankOne =
          Optional.ofNullable(vesselRule.getTemplateInputPrefix())
              .filter(
                  item ->
                      item.trim().length() != 0
                          && item.trim().equalsIgnoreCase(RuleMasterData.CargoTankOne.getPrefix()));
      Optional<String> isSuffixExistCTankOne =
          Optional.ofNullable(vesselRule.getTemplateInputSuffix())
              .filter(
                  item ->
                      item.trim().length() != 0
                          && item.trim().equalsIgnoreCase(RuleMasterData.CargoTankOne.getSuffix()));
      Optional<String> isPrefixExistCTankTwo =
          Optional.ofNullable(vesselRule.getTemplateInputPrefix())
              .filter(
                  item ->
                      item.trim().length() != 0
                          && item.trim().equalsIgnoreCase(RuleMasterData.CargoTankTwo.getPrefix()));
      Optional<String> isSuffixExistCTankTwo =
          Optional.ofNullable(vesselRule.getTemplateInputSuffix())
              .filter(
                  item ->
                      item.trim().length() != 0
                          && item.trim().equalsIgnoreCase(RuleMasterData.CargoTankTwo.getSuffix()));
      RuleDropDownMaster.Builder ruleDropDownMaster = RuleDropDownMaster.newBuilder();
      if ((isPrefixExistCTankTwo.isPresent() && isSuffixExistCTankTwo.isPresent())
          || (isPrefixExistCTankOne.isPresent() && isSuffixExistCTankOne.isPresent())) {
        cargoTankMaster.forEach(
            cargoTank -> {
              Optional.ofNullable(cargoTank.getId()).ifPresent(ruleDropDownMaster::setId);
              Optional.ofNullable(cargoTank.getValue())
                  .ifPresentOrElse(
                      ruleDropDownMaster::setValue, () -> ruleDropDownMaster.setValue(""));
              ruleInput.addRuleDropDownMaster(ruleDropDownMaster.build());
            });
      } else {
        Optional<Long> ruleTempId;
        if (isDisplayId || isDisplayVesselRuleXId) {
          ruleTempId = Optional.ofNullable(vesselRule.getTemplateId());
        } else {
          ruleTempId = Optional.ofNullable(vesselRule.getTemplateFId());
        }
        if (ruleTempId.isPresent()) {
          List<RuleVesselDropDownValues> filterMasterByRule =
              listOfDropDownValue.stream()
                  .filter(
                      rDropDown ->
                          rDropDown.getRuleTemplateXid() != null
                              && ruleTempId.get() != null
                              && rDropDown.getRuleTemplateXid().equals(ruleTempId.get()))
                  .collect(Collectors.toList());
          filterMasterByRule.forEach(
              masterDropDownRule -> {
                Optional.ofNullable(masterDropDownRule.getId())
                    .ifPresent(ruleDropDownMaster::setId);
                Optional.ofNullable(masterDropDownRule.getDropDownValue())
                    .ifPresentOrElse(
                        ruleDropDownMaster::setValue, () -> ruleDropDownMaster.setValue(""));
                ruleInput.addRuleDropDownMaster(ruleDropDownMaster.build());
              });
        }
      }
    }
    if (isDisplayId) {
      Optional.ofNullable(vesselRule.getTemplateInputId())
          .ifPresentOrElse(
              item -> ruleInput.setId(String.valueOf(item)), () -> ruleInput.setId(""));
    }
    rulesBuilder.addInputs(ruleInput.build());
    if (id == value.size() - 1) {
      Optional.ofNullable(vesselRule.getNumericPrecision())
          .ifPresentOrElse(
              rulesBuilder::setNumericPrecision, () -> rulesBuilder.setNumericPrecision(0));
      Optional.ofNullable(vesselRule.getNumericScale())
          .ifPresentOrElse(rulesBuilder::setNumericScale, () -> rulesBuilder.setNumericScale(0));
      Optional.ofNullable(vesselRule.getTemplateIsEnable())
          .ifPresentOrElse(rulesBuilder::setEnable, () -> rulesBuilder.setEnable(false));
      Optional.ofNullable(vesselRule.getTemplateDisplayInSettings())
          .ifPresentOrElse(
              rulesBuilder::setDisplayInSettings, () -> rulesBuilder.setDisplayInSettings(false));
      Optional.ofNullable(vesselRule.getTemplateId())
          .ifPresentOrElse(
              item -> rulesBuilder.setRuleTemplateId(String.valueOf(item)),
              () -> rulesBuilder.setRuleTemplateId(""));
      if (isDisplayId) {
        Optional.ofNullable(vesselRule.getId())
            .ifPresentOrElse(
                item -> rulesBuilder.setId(String.valueOf(item)), () -> rulesBuilder.setId(""));
      }
      Optional.ofNullable(vesselRule.getTemplateRuleType())
          .filter(item -> item.trim().length() != 0)
          .ifPresentOrElse(rulesBuilder::setRuleType, () -> rulesBuilder.setRuleType(""));
      Optional.ofNullable(vesselRule.getIsHardRule())
          .ifPresentOrElse(rulesBuilder::setIsHardRule, () -> rulesBuilder.setIsHardRule(false));
      if (isDisplayVesselRuleXId) {
        Optional.ofNullable(vesselRule.getId())
            .ifPresentOrElse(
                item -> rulesBuilder.setVesselRuleXId(String.valueOf(item)),
                () -> rulesBuilder.setVesselRuleXId(""));
      }
      rulePlanBuilder.addRules(rulesBuilder.build());
    }
  }

  @Override
  public void getVesselValveSequence(
      VesselRequest request,
      StreamObserver<com.cpdss.common.generated.VesselInfo.VesselValveSequenceReply>
          responseObserver) {
    com.cpdss.common.generated.VesselInfo.VesselValveSequenceReply.Builder builder =
        com.cpdss.common.generated.VesselInfo.VesselValveSequenceReply.newBuilder();
    try {
      builder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS).build());
      builder.addAllVvSequenceEntities(
          vesselPumpService.buildVesselValveSeqMessage(
              vesselValveSequenceRepository.findAllByVesselXid(request.getVesselId())));
      builder.addAllVvEducationEntities(
          vesselPumpService.buildVesselValveEducator(
              educationProcessRepository.findAllByVesselXid(request.getVesselId())));
      builder.addAllVvAirPurgeSequence(
          vesselPumpService.buildVesselValveAirPurge(
              airPurgeSequenceRepository.findAllByVesselId(request.getVesselId())));
      builder.addAllVvStrippingSequence(
          vesselPumpService.buildVesselValveStrippingSequence(
              strippingSequenceRepository.findAllByVesselId(request.getVesselId())));
      builder.addAllVvSSCargoValve(
          vesselPumpService.buildVVSSCargoValve(
              sequenceCargoValveRepository.findAllByVesselId(request.getVesselId())));
    } catch (Exception e) {
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
  public void getLoadingInfoRules(
      LoadingInfoRulesRequest request, StreamObserver<LoadingInfoRulesReply> responseObserver) {
    LoadingInfoRulesReply.Builder builder = LoadingInfoRulesReply.newBuilder();
    try {
      List<RuleVesselMapping> vesselRules =
          this.ruleVesselMappingRepository.findLoadingInfoRulesByVesselId(request.getVesselId());
      if (!vesselRules.isEmpty()) {
        vesselRules.forEach(
            vesselRule -> {
              Rules.Builder ruleBuilder = Rules.newBuilder();
              Optional.ofNullable(vesselRule.getId())
                  .ifPresent(id -> ruleBuilder.setId(String.valueOf(id)));
              List<RuleVesselMappingInput> inputs =
                  this.ruleVesselMappingInputRespository.findByRuleVesselMappingAndIsActive(
                      vesselRule, true);
              inputs.forEach(
                  input -> {
                    RulesInputs.Builder inputBuilder = RulesInputs.newBuilder();
                    Optional.ofNullable(input.getPrefix()).ifPresent(inputBuilder::setPrefix);
                    Optional.ofNullable(input.getSuffix()).ifPresent(inputBuilder::setSuffix);
                    Optional.ofNullable(input.getDefaultValue())
                        .ifPresent(inputBuilder::setDefaultValue);
                    ruleBuilder.addInputs(inputBuilder.build());
                  });
              builder.addRules(ruleBuilder.build());
            });
      } else {
        List<RuleTemplate> templateRules = this.ruleTemplateRepository.findLoadingInfoRules();
        templateRules.forEach(
            templateRule -> {
              Rules.Builder ruleBuilder = Rules.newBuilder();
              Optional.ofNullable(templateRule.getId())
                  .ifPresent(id -> ruleBuilder.setId(String.valueOf(id)));
              List<RuleTemplateInput> inputs =
                  this.ruleTemplateInputRepository.findByRuleTemplateAndIsActive(
                      templateRule, true);
              inputs.forEach(
                  input -> {
                    RulesInputs.Builder inputBuilder = RulesInputs.newBuilder();
                    Optional.ofNullable(input.getPrefix()).ifPresent(inputBuilder::setPrefix);
                    Optional.ofNullable(input.getSuffix()).ifPresent(inputBuilder::setSuffix);
                    Optional.ofNullable(input.getDefaultValue())
                        .ifPresent(inputBuilder::setDefaultValue);
                    ruleBuilder.addInputs(inputBuilder.build());
                  });
              builder.addRules(ruleBuilder.build());
            });
      }
      builder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS).build());
    } catch (Exception e) {
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

  /**
   * To save Rules against vessel
   *
   * @param request
   * @param vessel
   * @param listOfDropDownValue
   * @param cargoTankMaster
   * @param ruleTypeList
   */
  void saveRulesAgainstVessel(
      VesselRuleRequest request,
      Vessel vessel,
      List<RuleVesselDropDownValues> listOfDropDownValue,
      List<CargoTankMaster> cargoTankMaster,
      List<RuleType> ruleTypeList) {
    List<RuleTemplate> ruleTemplateList = ruleTemplateRepository.findByIsActive(true);
    List<RuleVesselMapping> ruleVesselMappingList = new ArrayList<>();
    request
        .getRulePlanList()
        .forEach(
            rulePlans -> {
              rulePlans
                  .getRulesList()
                  .forEach(
                      rule -> {
                        RuleVesselMapping ruleVesselMapping = new RuleVesselMapping();
                        Optional<String> isRuleTemplateIdExist =
                            Optional.ofNullable(rule.getRuleTemplateId())
                                .filter(item -> item.trim().length() != 0);
                        if (rule.getId() != null && rule.getId().trim().length() != 0) {
                          Optional<RuleVesselMapping> rVesselMapping =
                              ruleVesselMappingRepository.findById(Long.valueOf(rule.getId()));
                          if (rVesselMapping.isPresent()) {
                            ruleVesselMapping = rVesselMapping.get();
                          } else {
                            log.info("No record exist for this id in rule vessel mapping table");
                            throw new RuntimeException(
                                "No record exist for this id in rule vessel mapping table");
                          }
                        } else {
                          if (isRuleTemplateIdExist.isPresent()) {
                            Optional<RuleVesselMapping> ruleVesselMappingRecord =
                                ruleVesselMappingRepository.checkIsRuleTemplateMapped(
                                    vessel.getId(), true, Long.valueOf(rule.getRuleTemplateId()));
                            if (ruleVesselMappingRecord.isPresent()) {
                              log.info(
                                  "Duplicate row can't insert for given vessel id and rule template");
                              throw new RuntimeException(
                                  "Duplicate row can't insert for given vessel id and rule template");
                            }
                          }
                        }
                        ruleVesselMapping.setIsActive(true);
                        RuleVesselMapping finalRuleVesselMapping = ruleVesselMapping;
                        Optional.ofNullable(rule.getDisplayInSettings())
                            .ifPresentOrElse(
                                ruleVesselMapping::setDisplayInSettings,
                                () -> finalRuleVesselMapping.setDisplayInSettings(false));
                        Optional.ofNullable(rule.getNumericPrecision())
                            .ifPresent(ruleVesselMapping::setNumericPrecision);
                        Optional.ofNullable(rule.getNumericScale())
                            .ifPresent(ruleVesselMapping::setNumericScale);
                        Optional.ofNullable(rule.getEnable())
                            .ifPresentOrElse(
                                ruleVesselMapping::setIsEnable,
                                () -> finalRuleVesselMapping.setIsEnable(false));
                        Optional.ofNullable(rule.getIsHardRule())
                            .ifPresentOrElse(
                                ruleVesselMapping::setIsHardRule,
                                () -> finalRuleVesselMapping.setIsHardRule(false));
                        ruleVesselMapping.setVessel(vessel);
                        if (!CollectionUtils.isEmpty(ruleTypeList)
                            && rule.getRuleType() != null
                            && rule.getRuleType().trim() != "") {
                          Optional<RuleType> ruleType =
                              ruleTypeList.stream()
                                  .filter(
                                      rType ->
                                          rType.getRuleType().equalsIgnoreCase(rule.getRuleType()))
                                  .findAny();
                          ruleType.orElseThrow(RuntimeException::new);
                          ruleVesselMapping.setRuleType(ruleType.get());
                        } else {
                          log.info("Rule Type can't be null");
                          throw new RuntimeException("Rule type can't be null");
                        }
                        if (!CollectionUtils.isEmpty(ruleTemplateList)
                            && rule.getRuleTemplateId() != null
                            && rule.getRuleTemplateId().trim().length() != 0) {
                          Optional<RuleTemplate> ruleTemplate =
                              ruleTemplateList.stream()
                                  .filter(
                                      rTemplate ->
                                          rTemplate.getId()
                                              == Long.parseLong(rule.getRuleTemplateId()))
                                  .findAny();
                          ruleTemplate.orElseThrow(RuntimeException::new);
                          ruleVesselMapping.setRuleTemplate(ruleTemplate.get());
                        } else {
                          log.info("Template id can't be null");
                          throw new RuntimeException("Template id can't be null");
                        }
                        List<RuleVesselMappingInput> ruleVesselMappingInputList = new ArrayList<>();
                        for (RulesInputs input : rule.getInputsList()) {
                          RuleVesselMappingInput ruleTemplateInput = new RuleVesselMappingInput();
                          if (input.getId() != null && input.getId().trim().length() != 0) {
                            Optional<RuleVesselMappingInput> rTemplateInput =
                                ruleVesselMappingInputRespository.findById(
                                    Long.valueOf(input.getId()));
                            if (rTemplateInput.isPresent()) {
                              ruleTemplateInput = rTemplateInput.get();
                            } else {
                              log.info(
                                  "No record exist for this id in rule vessel mapping input table");
                              throw new RuntimeException(
                                  "No record exist for this id in rule vessel mapping input table");
                            }
                          }
                          RuleVesselMappingInput finalRuleTemplateInput1 = ruleTemplateInput;
                          Optional.ofNullable(input.getDefaultValue())
                              .filter(item -> item.trim().length() != 0)
                              .ifPresentOrElse(
                                  ruleTemplateInput::setDefaultValue,
                                  () -> finalRuleTemplateInput1.setDefaultValue(null));
                          Optional.ofNullable(input.getMax())
                              .filter(item -> item.trim().length() != 0)
                              .ifPresent(ruleTemplateInput::setMaxValue);
                          Optional.ofNullable(input.getMin())
                              .filter(item -> item.trim().length() != 0)
                              .ifPresent(ruleTemplateInput::setMinValue);
                          Optional.ofNullable(input.getSuffix())
                              .filter(item -> item.trim().length() != 0)
                              .ifPresent(ruleTemplateInput::setSuffix);
                          Optional.ofNullable(input.getPrefix())
                              .filter(item -> item.trim().length() != 0)
                              .ifPresent(ruleTemplateInput::setPrefix);
                          Optional.ofNullable(input.getType())
                              .filter(item -> item.trim().length() != 0)
                              .ifPresent(ruleTemplateInput::setTypeValue);
                          RuleVesselMappingInput finalRuleTemplateInput = ruleTemplateInput;
                          Optional.ofNullable(input.getIsMandatory())
                              .ifPresentOrElse(
                                  ruleTemplateInput::setIsMandatory,
                                  () -> finalRuleTemplateInput.setIsMandatory((false)));
                          Optional<String> isTypeDropDownOrMultiSelect =
                              Optional.ofNullable(input.getType())
                                  .filter(
                                      value ->
                                          value.trim().length() != 0
                                                  && value
                                                      .trim()
                                                      .equalsIgnoreCase(
                                                          TypeValue.DROPDOWN.getType())
                                              || value
                                                  .trim()
                                                  .equalsIgnoreCase(
                                                      TypeValue.MULTISELECT.getType()));

                          if (isTypeDropDownOrMultiSelect.isPresent()) {
                            Optional<String> isPrefixExistCTankOne =
                                Optional.ofNullable(input.getPrefix())
                                    .filter(
                                        item ->
                                            item.trim().length() != 0
                                                && item.trim()
                                                    .equalsIgnoreCase(
                                                        RuleMasterData.CargoTankOne.getPrefix()));
                            Optional<String> isSuffixExistCTankOne =
                                Optional.ofNullable(input.getSuffix())
                                    .filter(
                                        item ->
                                            item.trim().length() != 0
                                                && item.trim()
                                                    .equalsIgnoreCase(
                                                        RuleMasterData.CargoTankOne.getSuffix()));
                            Optional<String> isPrefixExistCTankTwo =
                                Optional.ofNullable(input.getPrefix())
                                    .filter(
                                        item ->
                                            item.trim().length() != 0
                                                && item.trim()
                                                    .equalsIgnoreCase(
                                                        RuleMasterData.CargoTankTwo.getPrefix()));
                            Optional<String> isSuffixExistCTankTwo =
                                Optional.ofNullable(input.getSuffix())
                                    .filter(
                                        item ->
                                            item.trim().length() != 0
                                                && item.trim()
                                                    .equalsIgnoreCase(
                                                        RuleMasterData.CargoTankTwo.getSuffix()));

                            try {
                              if ((isPrefixExistCTankOne.isPresent()
                                      && isSuffixExistCTankOne.isPresent())
                                  || (isPrefixExistCTankTwo.isPresent()
                                      && isSuffixExistCTankTwo.isPresent())) {
                                this.ruleMasterDropDownValidation(
                                    listOfDropDownValue,
                                    cargoTankMaster,
                                    true,
                                    input,
                                    ruleTemplateInput,
                                    rule);
                              } else {
                                this.ruleMasterDropDownValidation(
                                    listOfDropDownValue,
                                    cargoTankMaster,
                                    false,
                                    input,
                                    ruleTemplateInput,
                                    rule);
                              }
                            } catch (GenericServiceException e) {
                              throw new RuntimeException(
                                  "Master rule drop down value does not exist");
                            }
                          }
                          ruleTemplateInput.setIsActive(true);
                          ruleTemplateInput.setRuleVesselMapping(ruleVesselMapping);
                          ruleVesselMappingInputList.add(ruleTemplateInput);
                        }
                        ruleVesselMapping.setRuleVesselMappingInput(ruleVesselMappingInputList);
                        ruleVesselMappingList.add(ruleVesselMapping);
                      });
            });
    ruleVesselMappingRepository.saveAll(ruleVesselMappingList);
  }

  /** Get all vessel information by requested parameters. request - VesselsInfoRequest */
  @Override
  public void getVesselsInformation(
      VesselsInfoRequest request, StreamObserver<VesselsInformationReply> responseObserver) {
    log.info("inside grpc service: getVesselsInformation");
    com.cpdss.common.generated.VesselInfo.VesselsInformationReply.Builder replyBuilder =
        VesselsInformationReply.newBuilder();
    try {

      // Paging and sorting while filtering is handled separately
      Pageable pageable = null;
      if (request.getSortBy().length() > 0 && request.getOrderBy().length() > 0) {
        pageable =
            PageRequest.of(
                (int) request.getPageNo(),
                (int) request.getPageSize(),
                Sort.by(
                    Sort.Direction.valueOf(request.getOrderBy().toUpperCase()),
                    request.getSortBy()));
      } else {
        pageable = PageRequest.of((int) request.getPageNo(), (int) request.getPageSize());
      }
      Page<Vessel> page = null;
      if (request.getVesselName().isEmpty()
          && request.getVesselType().isEmpty()
          && request.getBuilder().isEmpty()
          && request.getDateOfLaunch().isEmpty()) {
        page = vesselRepository.findByIsActive(true, pageable);
      } else {
        page = createCriteriaQuery(request, pageable);
      }

      List<Vessel> vessels = page.getContent();
      for (Vessel vessel : vessels) {
        com.cpdss.common.generated.VesselInfo.VesselsInformation.Builder vesselInfo =
            VesselsInformation.newBuilder();
        vesselInfo.setVesselId(vessel.getId());
        vesselInfo.setVesselName(vessel.getName());
        vesselInfo.setBuilder(vessel.getBuilder());
        vesselInfo.setOfficialNumber(vessel.getOfficialNumber());
        vesselInfo.setSignalLetter(vessel.getSignalLetter());
        vesselInfo.setVesselType(vessel.getTypeOfShip());
        vesselInfo.setDateOfLaunch(
            new SimpleDateFormat("dd-MM-yyyy").format(vessel.getDateOfLaunching()));
        replyBuilder.addVesselsInformation(vesselInfo.build());
      }
      replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS).build());
      replyBuilder.setTotalElement(page.getTotalElements());

    } catch (Exception e) {
      log.error("Exception when fetching all vessel information", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage(null != e.getMessage() ? e.getMessage() : "")
              .setStatus(FAILED)
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  /**
   * Create search criteria by filter parameters
   *
   * @param request
   * @param pageable
   * @return Page of vessels
   * @throws ParseException
   */
  private Page<Vessel> createCriteriaQuery(VesselsInfoRequest request, Pageable pageable)
      throws ParseException {

    Specification<Vessel> specification =
        Specification.where(
            new VesselInfoSpecification(new SearchCriteria("isActive", "EQUALS", true)));
    if (!request.getVesselName().isEmpty()) {
      specification =
          specification.and(
              new VesselInfoSpecification(
                  new SearchCriteria("name", "LIKE", request.getVesselName())));
    }
    if (!request.getVesselType().isEmpty()) {
      specification =
          specification.and(
              new VesselInfoSpecification(
                  new SearchCriteria("typeOfShip", "LIKE", request.getVesselType())));
    }
    if (!request.getBuilder().isEmpty()) {
      specification =
          specification.and(
              new VesselInfoSpecification(
                  new SearchCriteria("builder", "LIKE", request.getBuilder())));
    }
    if (!request.getDateOfLaunch().isEmpty()) {
      Date date = new SimpleDateFormat("dd-MM-yyyy").parse(request.getDateOfLaunch());
      specification =
          specification.and(
              new VesselInfoSpecification(new SearchCriteria("dateOfLaunching", "EQUALS", date)));
    }
    return vesselRepository.findAll(specification, pageable);
  }

  @Override
  public void getVesselParticulars(
      LoadingInfoRulesRequest request, StreamObserver<VesselParticulars> responseObserver) {
    log.info("Getting vessel particulars for vessel Id : {}", request.getVesselId());
    VesselParticulars.Builder builder = VesselParticulars.newBuilder();
    try {
      vesselParticularService.getVesselParticulars(builder, request);
    } catch (GenericServiceException e) {
      log.info("Getting vessel particulars failed for vessel Id : {}", request.getVesselId());
      e.printStackTrace();
      builder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage(null != e.getMessage() ? e.getMessage() : "")
              .setStatus(FAILED)
              .build());
    }
    builder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS).build());
    responseObserver.onNext(builder.build());
    responseObserver.onCompleted();
  }

  /** Get vessel informations for the requested vessel id */
  @Override
  public void getVesselDetaildInformation(
      VesselIdRequest request, StreamObserver<VesselDetaildInfoReply> responseObserver) {
    com.cpdss.common.generated.VesselInfo.VesselDetaildInfoReply.Builder response =
        VesselDetaildInfoReply.newBuilder();
    try {
      Vessel vessel = vesselRepository.findByIdAndIsActive(request.getVesselId(), true);
      response.setVesselId(vessel.getId());
      response.setVesselName(vessel.getName());
      response.setVesselType(vessel.getTypeOfShip());
      response.setBuilder(vessel.getBuilder());
      response.setBreadthMoulded(vessel.getBreadthMolded().longValue());
      response.setClass_(vessel.getClass1());
      response.setDateOfDelivery(
          new SimpleDateFormat(DATE_FORMAT).format(vessel.getDateOfDelivery()));
      response.setDateOfKeelLaid(
          new SimpleDateFormat(DATE_FORMAT).format(vessel.getDateKeelLaid()));
      response.setDateOfLaunch(
          new SimpleDateFormat(DATE_FORMAT).format(vessel.getDateOfLaunching()));
      response.setDepthMoulded(vessel.getDepthMolded().doubleValue());
      if (vessel.getDesignedLoaddraft() != null)
        response.setDesignedLoadDraft(vessel.getDesignedLoaddraft().doubleValue());
      if (vessel.getDraftFullLoadSummer() != null)
        response.setDraftFullLoad(vessel.getDraftFullLoadSummer().doubleValue());
      response.setImoNumber(vessel.getImoNumber());
      response.setLengthBetweenPerpendiculars(vessel.getLengthBetweenPerpendiculars().longValue());
      response.setLengthOverall(vessel.getLengthOverall().longValue());
      response.setNavigationArea(vessel.getNavigationArea());
      response.setOfficialNumber(vessel.getOfficialNumber());
      response.setRegisterLength(vessel.getRegisterLength().longValue());
      response.setSignalLetter(vessel.getSignalLetter());
      if (vessel.getThicknessOfKeelplate() != null)
        response.setThicknessOfKeelPlate(vessel.getThicknessOfKeelplate().doubleValue());
      if (vessel.getThicknessOfUpperDeckStringerPlate() != null)
        response.setThicknessOfUpperDeck(
            vessel.getThicknessOfUpperDeckStringerPlate().doubleValue());
      if (vessel.getThicknessOfKeelplate() != null
          && vessel.getThicknessOfUpperDeckStringerPlate() != null
          && vessel.getDepthMolded() != null) {
        Double totalDepth =
            vessel.getDepthMolded().doubleValue()
                + vessel.getThicknessOfKeelplate().doubleValue()
                + vessel.getThicknessOfUpperDeckStringerPlate().doubleValue();
        response.setTotalDepth(totalDepth);
      }
      getTankDetailsForTheVessel(response, vessel);
      response.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS).build());
    } catch (Exception e) {
      log.error("Exception when fetching vessel information", e);
      response.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage(null != e.getMessage() ? e.getMessage() : "")
              .setStatus(FAILED)
              .build());
    } finally {
      responseObserver.onNext(response.build());
      responseObserver.onCompleted();
    }
  }

  /** Get vessel bunker, ballast and cargo tank details */
  private void getTankDetailsForTheVessel(
      com.cpdss.common.generated.VesselInfo.VesselDetaildInfoReply.Builder response,
      Vessel vessel) {
    com.cpdss.common.generated.VesselInfo.VesselTankInfo.Builder tankInfoBuilder =
        VesselTankInfo.newBuilder();
    List<Long> tankCategoryIds =
        new ArrayList<>(
            Arrays.asList(
                CARGO_TANK_CATEGORY_ID,
                FRESH_WATER_TANK_CATEGORY_ID,
                FUEL_OIL_TANK_CATEGORY_ID,
                DIESEL_OIL_TANK_CATEGORY_ID,
                FUEL_VOID_TANK_CATEGORY_ID,
                FRESH_WATER_VOID_TANK_CATEGORY_ID,
                BALLAST_VOID_TANK_CATEGORY_ID,
                BALLAST_TANK_CATEGORY_ID));
    List<TankCategory> tankCategoryEntities = new ArrayList<>();
    tankCategoryIds.forEach(
        tankCategoryId ->
            tankCategoryEntities.add(this.tankCategoryRepository.getOne(tankCategoryId)));
    List<VesselTank> vesselTanks =
        this.vesselTankRepository.findByVesselAndTankCategoryInAndIsActive(
            vessel, tankCategoryEntities, true);
    vesselTanks.forEach(
        vesselTank ->
            vesselTank.setTankOrder(Optional.ofNullable(vesselTank.getTankOrder()).orElse(0)));
    Collections.sort(vesselTanks, Comparator.comparing(VesselTank::getTankOrder));
    for (VesselTank tank : vesselTanks) {
      if (tank.getDensity() != null) tankInfoBuilder.setDensity(tank.getDensity().doubleValue());
      tankInfoBuilder.setFrameNumberFrom(tank.getFrameNumberFrom());
      tankInfoBuilder.setFrameNumberTo(tank.getFrameNumberTo());
      if (tank.getFullCapacityCubm() != null)
        tankInfoBuilder.setFullCapacityCubm(tank.getFullCapacityCubm().doubleValue());
      tankInfoBuilder.setIsSlopTank(tank.getIsSlopTank() == null ? false : tank.getIsSlopTank());
      tankInfoBuilder.setShortName(tank.getShortName());
      tankInfoBuilder.setTankCategoryId(tank.getTankCategory().getId());
      tankInfoBuilder.setTankCategoryName(tank.getTankCategory().getName());
      tankInfoBuilder.setTankGroup(tank.getTankGroup() == null ? 0 : tank.getTankGroup());
      tankInfoBuilder.setTankId(tank.getId());
      tankInfoBuilder.setTankName(tank.getTankName());
      tankInfoBuilder.setTankOrder(tank.getTankOrder() == null ? 0 : tank.getTankOrder());

      if (tank.getTankCategory().getId() == FRESH_WATER_TANK_CATEGORY_ID
          || tank.getTankCategory().getId() == FRESH_WATER_VOID_TANK_CATEGORY_ID) {
        response.addBunkerRearTanks(tankInfoBuilder);
      }
      if (tank.getTankCategory().getId() == FUEL_OIL_TANK_CATEGORY_ID
          || tank.getTankCategory().getId() == FUEL_VOID_TANK_CATEGORY_ID
          || tank.getTankCategory().getId() == DIESEL_OIL_TANK_CATEGORY_ID) {
        response.addBunkerTanks(tankInfoBuilder);
      }
      if (tank.getTankCategory().getId() == BALLAST_TANK_CATEGORY_ID
          && tank.getTankPositionCategory().equals(BALLAST_FRONT_TANK)) {
        response.addBallastFrontTanks(tankInfoBuilder);
      }
      if ((tank.getTankCategory().getId() == BALLAST_TANK_CATEGORY_ID
              || tank.getTankCategory().getId() == BALLAST_VOID_TANK_CATEGORY_ID)
          && tank.getTankPositionCategory().equals(BALLAST_CENTER_TANK)) {
        response.addBallastCenterTanks(tankInfoBuilder);
      }
      if (tank.getTankCategory().getId() == BALLAST_TANK_CATEGORY_ID
          && tank.getTankPositionCategory().equals(BALLAST_REAR_TANK)) {
        response.addBallastRearTanks(tankInfoBuilder);
      }
      if (tank.getTankCategory().getId() == CARGO_TANK_CATEGORY_ID) {
        response.addCargoTanks(tankInfoBuilder);
      }
    }
  }

  /**
   * Getting Vessel Tanks using Tank ids
   *
   * @param request
   * @param responseObserver
   */
  @Override
  public void getVesselTanksByTankIds(
      VesselTankRequest request,
      StreamObserver<com.cpdss.common.generated.VesselInfo.VesselTankReply> responseObserver) {
    log.info("Getting vessel tanks for tank Ids.");
    com.cpdss.common.generated.VesselInfo.VesselTankReply.Builder builder =
        com.cpdss.common.generated.VesselInfo.VesselTankReply.newBuilder();
    try {
      this.vesselParticularService.getVesselTanksByTankIds(request, builder);
      builder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS).build());
    } catch (Exception e) {
      log.info("Getting vessel tanks failed.");
      e.printStackTrace();
      builder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage(null != e.getMessage() ? e.getMessage() : "")
              .setStatus(FAILED)
              .build());
    } finally {
      responseObserver.onNext(builder.build());
      responseObserver.onCompleted();
    }
  }

  @Override
  public void getVesselData(
      Common.CommunicationDataGetRequest request,
      StreamObserver<Common.CommunicationDataResponse> responseObserver) {

    Common.CommunicationDataResponse.Builder communicationDataResponseBuilder =
        Common.CommunicationDataResponse.newBuilder();

    try {
      // Get records from table
      String records;
      log.info("Request for fetching Table: {}", request.getTableName());
      if (VESSEL_INFO_TABLES.RULE_VESSEL_MAPPING.getTableName().equals(request.getTableName())) {
        records = ruleVesselMappingRepository.getRuleVesselMappings(request.getIdList());
      } else if (VESSEL_INFO_TABLES
          .RULE_VESSEL_MAPPING_INPUT
          .getTableName()
          .equals(request.getTableName())) {
        records = ruleVesselMappingInputRespository.getRuleVesselMappingInputs(request.getIdList());
      } else {
        log.error("Table not configured: {}", request.getTableName());
        throw new GenericServiceException(
            "Table not configured: " + request.getTableName(),
            CommonErrorCodes.E_HTTP_BAD_REQUEST,
            HttpStatusCode.BAD_REQUEST);
      }
      // Set values
      communicationDataResponseBuilder.setDataJson(records);

      // Set response status
      communicationDataResponseBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setStatus(SUCCESS)
              .setMessage(SUCCESS)
              .setCode(String.valueOf(HttpStatusCode.OK.value()))
              .setHttpStatusCode(HttpStatusCode.OK.value())
              .build());
    } catch (GenericServiceException e) {
      // Set response status
      communicationDataResponseBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setStatus(FAILED)
              .setMessage(Strings.nullToEmpty(e.getMessage()))
              .setCode(e.getCode())
              .setHttpStatusCode(e.getStatus().value())
              .build());
    } catch (Exception e) {
      // Set response status
      communicationDataResponseBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setStatus(FAILED)
              .setMessage(Strings.nullToEmpty(e.getMessage()))
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setHttpStatusCode(HttpStatusCode.INTERNAL_SERVER_ERROR.value())
              .build());
    } finally {
      // Build response
      responseObserver.onNext(communicationDataResponseBuilder.build());
      responseObserver.onCompleted();
    }
  }

  @Override
  public void updateVesselData(
      Common.CommunicationDataUpdateRequest request,
      StreamObserver<ResponseStatus> responseObserver) {

    ResponseStatus.Builder responseBuilder = ResponseStatus.newBuilder();

    try {
      if (VESSEL_INFO_TABLES.RULE_VESSEL_MAPPING.getTableName().equals(request.getTableName())) {
        vesselInfoCommunicationService.saveRuleVesselMapping(request.getDataJson());
      } else if (VESSEL_INFO_TABLES
          .RULE_VESSEL_MAPPING_INPUT
          .getTableName()
          .equals(request.getTableName())) {
        vesselInfoCommunicationService.saveRuleVesselMappingInput(request.getDataJson());
      } else {
        log.error("Table not configured: {}", request.getTableName());
        throw new GenericServiceException(
            "Table not configured: " + request.getTableName(),
            CommonErrorCodes.E_HTTP_BAD_REQUEST,
            HttpStatusCode.BAD_REQUEST);
      }
      // Set response status
      responseBuilder
          .setStatus(SUCCESS)
          .setMessage(SUCCESS)
          .setCode(String.valueOf(HttpStatusCode.OK.value()))
          .setHttpStatusCode(HttpStatusCode.OK.value())
          .build();
    } catch (GenericServiceException e) {
      // Set response status
      responseBuilder
          .setStatus(FAILED)
          .setMessage(Strings.nullToEmpty(e.getMessage()))
          .setCode(e.getCode())
          .setHttpStatusCode(e.getStatus().value())
          .build();
    } catch (Exception e) {
      // Set response status
      responseBuilder
          .setStatus(FAILED)
          .setMessage(Strings.nullToEmpty(e.getMessage()))
          .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
          .setHttpStatusCode(HttpStatusCode.INTERNAL_SERVER_ERROR.value())
          .build();
    } finally {
      // Build response
      responseObserver.onNext(responseBuilder.build());
      responseObserver.onCompleted();
    }
  }

  @Override
  public void getAllCrewRank(
      Empty request,
      StreamObserver<com.cpdss.common.generated.VesselInfo.CrewReply> replyStreamObserver) {
    com.cpdss.common.generated.VesselInfo.CrewReply.Builder builder =
        com.cpdss.common.generated.VesselInfo.CrewReply.newBuilder();
    try {
      crewService.getAllCrewRank(builder);
      Common.ResponseStatus.Builder responseStatus = Common.ResponseStatus.newBuilder();
      responseStatus.setStatus(SUCCESS);
      builder.setResponseStatus(responseStatus);
    } catch (Exception e) {
      log.error("Fetch crew rank failed, e - {}", e.getMessage());
      Common.ResponseStatus.Builder responseStatus = Common.ResponseStatus.newBuilder();
      responseStatus.setStatus(FAILED);
      builder.setResponseStatus(responseStatus);
    } finally {
      replyStreamObserver.onNext(builder.build());
      replyStreamObserver.onCompleted();
    }
  }

  /**
   * to get list of crew details
   *
   * @param request
   * @param responseObserver
   */
  @Override
  public void getAllCrewVesselMapping(
      com.cpdss.common.generated.VesselInfo.CrewVesselRequest request,
      StreamObserver<com.cpdss.common.generated.VesselInfo.CrewVesselReply> responseObserver) {
    com.cpdss.common.generated.VesselInfo.CrewVesselReply.Builder replyBuilder =
        CrewVesselReply.newBuilder();
    try {
      this.crewService.getAllCrewVesselMapping(request.getVesselName(), replyBuilder);
      Common.ResponseStatus.Builder responseStatus = Common.ResponseStatus.newBuilder();
      responseStatus.setStatus(SUCCESS);
      replyBuilder.setResponseStatus(responseStatus);
    } catch (Exception e) {
      log.error("Error in getPortInfoByCargoId method ", e);
      ResponseStatus.Builder responseStatus = ResponseStatus.newBuilder();
      responseStatus.setStatus(FAILED);
      replyBuilder.setResponseStatus(responseStatus);
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  @Override
  public void getAllCrewDetails(
      com.cpdss.common.generated.VesselInfo.VesselsInfoRequest request,
      io.grpc.stub.StreamObserver<com.cpdss.common.generated.VesselInfo.CrewDetailedReply>
          responseObserver) {
    com.cpdss.common.generated.VesselInfo.CrewDetailedReply.Builder crewDetailReply =
        com.cpdss.common.generated.VesselInfo.CrewDetailedReply.newBuilder();
    try {
      this.crewService.getAllCrewDetails(crewDetailReply, request);
      ResponseStatus.Builder responseStatus = ResponseStatus.newBuilder();
      responseStatus.setStatus(SUCCESS);
      crewDetailReply.setResponseStatus(responseStatus);
    } catch (Exception e) {
      log.error("Error in getAllCrewDetails method ", e);
      ResponseStatus.Builder responseStatus = ResponseStatus.newBuilder();
      responseStatus.setStatus(FAILED);
      crewDetailReply.setResponseStatus(responseStatus);
    } finally {
      responseObserver.onNext(crewDetailReply.build());
      responseObserver.onCompleted();
    }
  }

  @Override
  public void saveCrewDetails(
      CrewDetailed request,
      io.grpc.stub.StreamObserver<com.cpdss.common.generated.VesselInfo.CrewDetailsReply>
          responseObserver) {
    CrewDetailsReply.Builder crewDetailsReply = CrewDetailsReply.newBuilder();
    try {
      crewService.saveCrewDetails(request, crewDetailsReply);
      ResponseStatus.Builder responseStatus = ResponseStatus.newBuilder();
      responseStatus.setStatus("SUCCESS");
      crewDetailsReply.setResponseStatus(responseStatus);
    } catch (GenericServiceException e) {
      log.error("Error in saveCrewDetails method ", e);
      crewDetailsReply.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(e.getCode())
              .setMessage(e.getMessage())
              .setHttpStatusCode(e.getStatus().value())
              .setStatus(FAILED)
              .build());
    } catch (Exception e) {
      log.error("Error in saveCrewDetails method ", e);
      ResponseStatus.Builder responseStatus = ResponseStatus.newBuilder();
      responseStatus.setStatus("FAILURE");
      crewDetailsReply.setResponseStatus(responseStatus);
    } finally {
      responseObserver.onNext(crewDetailsReply.build());
      responseObserver.onCompleted();
    }
  }

  @Override
  public void saveCrewVesselMappings(
      com.cpdss.common.generated.VesselInfo.CrewVesselMappingRequest request,
      StreamObserver<com.cpdss.common.generated.VesselInfo.CrewVesselReply> responseObserver) {
    CrewVesselReply.Builder crewVesselReply = CrewVesselReply.newBuilder();
    try {
      crewService.saveAllCrewVesselMapping(request);
      ResponseStatus.Builder responseStatus = ResponseStatus.newBuilder();
      responseStatus.setStatus(SUCCESS);
      crewVesselReply.setResponseStatus(responseStatus);
    } catch (Exception e) {
      log.error("Error in saveCrewVesselMapping method ", e);
      ResponseStatus.Builder responseStatus = ResponseStatus.newBuilder();
      responseStatus.setStatus("FAILURE");
      crewVesselReply.setResponseStatus(responseStatus);
    } finally {
      responseObserver.onNext(crewVesselReply.build());
      responseObserver.onCompleted();
    }
  }

  @Override
  public void getAllCrewDetailsByRank(
      com.cpdss.common.generated.VesselInfo.VesselsInfoRequest request,
      io.grpc.stub.StreamObserver<com.cpdss.common.generated.VesselInfo.CrewDetailedReply>
          responseObserver) {
    com.cpdss.common.generated.VesselInfo.CrewDetailedReply.Builder crewDetailReply =
        com.cpdss.common.generated.VesselInfo.CrewDetailedReply.newBuilder();
    try {
      this.crewService.getAllCrewDetailsByRank(crewDetailReply, request);
      ResponseStatus.Builder responseStatus = ResponseStatus.newBuilder();
      responseStatus.setStatus(SUCCESS);
      crewDetailReply.setResponseStatus(responseStatus);
    } catch (Exception e) {
      log.error("Error in getAllCrewDetails method ", e);
      ResponseStatus.Builder responseStatus = ResponseStatus.newBuilder();
      responseStatus.setStatus(FAILED);
      crewDetailReply.setResponseStatus(responseStatus);
    } finally {
      responseObserver.onNext(crewDetailReply.build());
      responseObserver.onCompleted();
    }
  }

  @Override
  public void getAllCharterDetails(
      com.cpdss.common.generated.VesselInfo.CharterInfoRequest request,
      io.grpc.stub.StreamObserver<com.cpdss.common.generated.VesselInfo.CharterDetailedReply>
          responseObserver) {

    com.cpdss.common.generated.VesselInfo.CharterDetailedReply.Builder charterDetailReply =
        com.cpdss.common.generated.VesselInfo.CharterDetailedReply.newBuilder();

    try {
      this.charterService.getAllCharterDetails(charterDetailReply, request); // here

      ResponseStatus.Builder responseStatus = ResponseStatus.newBuilder();
      responseStatus.setStatus(SUCCESS);
      charterDetailReply.setResponseStatus(responseStatus);
    } catch (Exception e) {
      log.error("Error in getAllCrewDetails method ", e);
      ResponseStatus.Builder responseStatus = ResponseStatus.newBuilder();
      responseStatus.setStatus(FAILED);
      charterDetailReply.setResponseStatus(responseStatus);
    } finally {
      responseObserver.onNext(charterDetailReply.build());
      responseObserver.onCompleted();
    }
  }

  @Override
  public void saveCharterDetails(
      CharterDetailed request, StreamObserver<CharterDetailReply> responseObserver) {

    CharterDetailReply.Builder charterDetailsReply = CharterDetailReply.newBuilder();
    try {
      charterService.saveCharterDetails(request, charterDetailsReply);
      ResponseStatus.Builder responseStatus = ResponseStatus.newBuilder();
      responseStatus.setStatus("SUCCESS");
      charterDetailsReply.setResponseStatus(responseStatus);
    } catch (GenericServiceException e) {
      log.error(e.getMessage(), e);
      charterDetailsReply.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(e.getCode())
              .setMessage(e.getMessage())
              .setStatus(FAILED)
              .setHttpStatusCode(e.getStatus().value())
              .build());
    } catch (Exception e) {
      log.error("Error in saveCharterDetails method ", e);
      charterDetailsReply.setResponseStatus(
          ResponseStatus.newBuilder().setMessage(e.getMessage()).setStatus(FAILED).build());
    } finally {
      responseObserver.onNext(charterDetailsReply.build());
      responseObserver.onCompleted();
    }
  }

  @Override
  public void saveCharterVesselMappings(
      CharterVesselMappingRequest request, StreamObserver<CharterVesselReply> responseObserver) {

    CharterVesselReply.Builder charterVesselReply = CharterVesselReply.newBuilder();
    try {
      charterService.saveCharterVesselMappings(request);
      ResponseStatus.Builder responseStatus = ResponseStatus.newBuilder();
      responseStatus.setStatus(SUCCESS);
      charterVesselReply.setResponseStatus(responseStatus);
    } catch (Exception e) {
      log.error("Error in saveCharterVesselMappings method ", e);
      ResponseStatus.Builder responseStatus = ResponseStatus.newBuilder();
      responseStatus.setStatus("FAILURE");
      charterVesselReply.setResponseStatus(responseStatus);
    } finally {
      responseObserver.onNext(charterVesselReply.build());
      responseObserver.onCompleted();
    }
  }

  @Override
  public void getAllCharterCompanyDetails(
      CharterCompanyInfoRequest request,
      StreamObserver<CharterCompanyDetailedReply> responseObserver) {

    CharterCompanyDetailedReply.Builder charterCompanyDetailedReply =
        CharterCompanyDetailedReply.newBuilder();

    try {
      this.charterService.getAllCharterCompanyDetails(charterCompanyDetailedReply, request);

      ResponseStatus.Builder responseStatus = ResponseStatus.newBuilder();
      responseStatus.setStatus(SUCCESS);
      charterCompanyDetailedReply.setResponseStatus(responseStatus);
    } catch (Exception e) {
      log.error("Error in getAllCharterCompanyDetails method ", e);
      ResponseStatus.Builder responseStatus = ResponseStatus.newBuilder();
      responseStatus.setStatus(FAILED);
      charterCompanyDetailedReply.setResponseStatus(responseStatus);
    } finally {
      responseObserver.onNext(charterCompanyDetailedReply.build());
      responseObserver.onCompleted();
    }
  }

  @Override
  public void getAllCharterTypeDetails(
      CharterTypeInfoRequest request, StreamObserver<CharterTypeDetailedReply> responseObserver) {

    CharterTypeDetailedReply.Builder charterTypeDetailedReply =
        CharterTypeDetailedReply.newBuilder();

    try {
      this.charterService.getAllCharterTypeDetails(charterTypeDetailedReply, request);

      ResponseStatus.Builder responseStatus = ResponseStatus.newBuilder();
      responseStatus.setStatus(SUCCESS);
      charterTypeDetailedReply.setResponseStatus(responseStatus);
    } catch (Exception e) {
      log.error("Error in getAllCharterTypeDetails method ", e);
      ResponseStatus.Builder responseStatus = ResponseStatus.newBuilder();
      responseStatus.setStatus(FAILED);
      charterTypeDetailedReply.setResponseStatus(responseStatus);
    } finally {
      responseObserver.onNext(charterTypeDetailedReply.build());
      responseObserver.onCompleted();
    }
  }
}
