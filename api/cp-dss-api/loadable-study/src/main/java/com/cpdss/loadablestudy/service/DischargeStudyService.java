/* Licensed at AlphaOri Technologies */
package com.cpdss.loadablestudy.service;

import static com.cpdss.loadablestudy.utility.LoadableStudiesConstants.*;
import static java.util.Optional.ofNullable;

import com.cpdss.common.exception.GenericServiceException;
import com.cpdss.common.generated.CargoInfo.CargoDetail;
import com.cpdss.common.generated.CargoInfo.CargoListRequest;
import com.cpdss.common.generated.CargoInfo.CargoReply;
import com.cpdss.common.generated.CargoInfoServiceGrpc.CargoInfoServiceBlockingStub;
import com.cpdss.common.generated.Common;
import com.cpdss.common.generated.Common.ResponseStatus;
import com.cpdss.common.generated.DischargeStudyOperationServiceGrpc.DischargeStudyOperationServiceImplBase;
import com.cpdss.common.generated.LoadableStudy.AlgoReply;
import com.cpdss.common.generated.LoadableStudy.AlgoRequest;
import com.cpdss.common.generated.LoadableStudy.CargoNominationDetail;
import com.cpdss.common.generated.LoadableStudy.CargoNominationReply;
import com.cpdss.common.generated.LoadableStudy.ConfirmPlanReply;
import com.cpdss.common.generated.LoadableStudy.ConfirmPlanReply.Builder;
import com.cpdss.common.generated.LoadableStudy.ConfirmPlanRequest;
import com.cpdss.common.generated.LoadableStudy.DishargeStudyBackLoadingDetail;
import com.cpdss.common.generated.LoadableStudy.DishargeStudyBackLoadingSaveRequest;
import com.cpdss.common.generated.LoadableStudy.LoadablePlanDetailsRequest;
import com.cpdss.common.generated.LoadableStudy.LoadingPortDetail;
import com.cpdss.common.generated.LoadableStudy.PortRotationDetail;
import com.cpdss.common.generated.PortInfo;
import com.cpdss.common.generated.PortInfo.CargoInfos;
import com.cpdss.common.generated.PortInfo.CargoPortMapping;
import com.cpdss.common.generated.PortInfoServiceGrpc;
import com.cpdss.common.generated.discharge_plan.CowTankDetails;
import com.cpdss.common.generated.discharge_plan.DSCowDetails;
import com.cpdss.common.generated.discharge_plan.DischargePlanServiceGrpc;
import com.cpdss.common.generated.discharge_plan.DischargeStudyDataTransferRequest;
import com.cpdss.common.generated.discharge_plan.PortData;
import com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyDetail;
import com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyReply;
import com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyRequest;
import com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DishargeStudyCargoDetail;
import com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DishargeStudyCargoReply;
import com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DishargeStudyPortCargoMapping;
import com.cpdss.common.generated.loadableStudy.LoadableStudyModels.UpdateDischargeStudyDetail;
import com.cpdss.common.generated.loadableStudy.LoadableStudyModels.UpdateDischargeStudyReply;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels.PortWiseCargo;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels.StowageAndBillOfLaddingValidationRequest;
import com.cpdss.common.generated.loading_plan.LoadingPlanServiceGrpc;
import com.cpdss.common.rest.CommonErrorCodes;
import com.cpdss.common.utils.EntityDoc;
import com.cpdss.common.utils.HttpStatusCode;
import com.cpdss.loadablestudy.entity.*;
import com.cpdss.loadablestudy.entity.BackLoading;
import com.cpdss.loadablestudy.entity.CargoNomination;
import com.cpdss.loadablestudy.entity.CargoNominationPortDetails;
import com.cpdss.loadablestudy.entity.CargoOperation;
import com.cpdss.loadablestudy.entity.DischargePatternQuantityCargoPortwiseDetails;
import com.cpdss.loadablestudy.entity.DischargeStudyCowDetail;
import com.cpdss.loadablestudy.entity.DischargeStudyPortInstruction;
import com.cpdss.loadablestudy.entity.LoadablePattern;
import com.cpdss.loadablestudy.entity.LoadableStudy;
import com.cpdss.loadablestudy.entity.LoadableStudyPortRotation;
import com.cpdss.loadablestudy.entity.OnHandQuantity;
import com.cpdss.loadablestudy.entity.SynopticalTable;
import com.cpdss.loadablestudy.entity.Voyage;
import com.cpdss.loadablestudy.repository.*;
import com.cpdss.loadablestudy.repository.CargoOperationRepository;
import com.cpdss.loadablestudy.repository.DischargePatternQuantityCargoPortwiseRepository;
import com.cpdss.loadablestudy.repository.DischargeStudyCowDetailRepository;
import com.cpdss.loadablestudy.repository.LoadablePatternRepository;
import com.cpdss.loadablestudy.repository.LoadableStudyPortRotationRepository;
import com.cpdss.loadablestudy.repository.LoadableStudyRepository;
import com.cpdss.loadablestudy.repository.LoadableStudyStatusRepository;
import com.cpdss.loadablestudy.repository.OnHandQuantityRepository;
import com.cpdss.loadablestudy.repository.SynopticalTableRepository;
import com.cpdss.loadablestudy.repository.VoyageRepository;
import io.grpc.stub.StreamObserver;
import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import lombok.extern.log4j.Log4j2;
import net.devh.boot.grpc.client.inject.GrpcClient;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.client.ResourceAccessException;

/** @author arun.j */
@Log4j2
@GrpcService
@Transactional
public class DischargeStudyService extends DischargeStudyOperationServiceImplBase {

  @Autowired private LoadableStudyRepository dischargeStudyRepository;
  @Autowired VoyageService voyageService;
  @Autowired private LoadableStudyStatusRepository loadableStudyStatusRepository;
  @Autowired private VoyageRepository voyageRepository;
  @Autowired private SynopticalTableRepository synopticalTableRepository;
  @Autowired private OnHandQuantityRepository onHandQuantityRepository;
  @Autowired private LoadableStudyPortRotationRepository loadableStudyPortRotationRepository;
  @Autowired private CargoNominationService cargoNominationService;
  @Autowired private LoadableStudyPortRotationService loadableStudyPortRotationService;
  @Autowired private LoadableStudyRepository loadableStudyRepository;
  @Autowired private LoadablePatternService loadablePatternService;
  @Autowired private CargoOperationRepository cargoOperationRepository;
  @Autowired private CargoNominationOperationDetailsRepository cargoNominationOperationRepository;
  @Autowired private SynopticService synopticService;
  @Autowired private CowDetailService cowDetailService;
  @Autowired private PortInstructionService portInstructionService;
  @Autowired private BackLoadingService backLoadingService;
  @Autowired private GenerateDischargeStudyJson generateDischargeStudyJson;
  @Autowired private LoadablePlanService loadablePlanService;
  @Autowired private LoadablePatternRepository loadablePatternRepository;
  @Autowired private DischargeStudyCowDetailRepository dischargeStudyCowDetailRepository;
  @Autowired CowHistoryRepository cowHistoryRepository;
  @Autowired LoadableStudyAlgoStatusRepository loadableStudyAlgoStatusRepository;

  @GrpcClient("dischargeInformationService")
  private DischargePlanServiceGrpc.DischargePlanServiceBlockingStub
      dischargePlanServiceBlockingStub;

  @Autowired
  private DischargePatternQuantityCargoPortwiseRepository
      dischargePatternQuantityCargoPortwiseRepository;

  @GrpcClient("cargoService")
  private CargoInfoServiceBlockingStub cargoInfoGrpcService;

  @GrpcClient("portInfoService")
  private PortInfoServiceGrpc.PortInfoServiceBlockingStub portInfoGrpcService;

  @GrpcClient("loadingPlanService")
  private LoadingPlanServiceGrpc.LoadingPlanServiceBlockingStub loadingPlanServiceBlockingStub;

  @Override
  public void saveDischargeStudy(
      DischargeStudyDetail request, StreamObserver<DischargeStudyReply> responseObserver) {
    DischargeStudyReply.Builder builder = DischargeStudyReply.newBuilder();
    try {
      Voyage voyage = this.voyageRepository.findByIdAndIsActive(request.getVoyageId(), true);
      if (null == voyage) {
        throw new GenericServiceException(
            "Voyage does not exist",
            CommonErrorCodes.E_HTTP_BAD_REQUEST,
            HttpStatusCode.BAD_REQUEST);
      }

      List<LoadableStudy> loadables =
          this.dischargeStudyRepository
              .findByVesselXIdAndVoyageAndIsActiveAndLoadableStudyStatus_id(
                  request.getVesselId(), voyage, true, CONFIRMED_STATUS_ID);
      if (loadables.isEmpty()) {
        throw new GenericServiceException(
            "No confirmed loadable study",
            CommonErrorCodes.E_HTTP_BAD_REQUEST,
            HttpStatusCode.BAD_REQUEST);
      }
      LoadableStudy loadableStudy = loadables.get(0);
      List<LoadableStudyPortRotation> portRotationsForNonDischargingOperations =
          loadableStudyPortRotationRepository.findByLoadableStudyAndOperation_idNotAndIsActive(
              loadableStudy, DISCHARGING_OPERATION_ID, true);
      for (LoadableStudyPortRotation loadableStudyPortRotation :
          portRotationsForNonDischargingOperations) {
        List<SynopticalTable> synopticalTables =
            this.synopticalTableRepository
                .findByLoadableStudyXIdAndLoadableStudyPortRotation_idAndIsActive(
                    loadableStudy.getId(), loadableStudyPortRotation.getId(), true);
        for (SynopticalTable synopticalTable : synopticalTables) {
          if (synopticalTable.getEtaActual() == null && synopticalTable.getEtdActual() == null) {
            throw new GenericServiceException(
                "No Actual ETA/ETD values found",
                CommonErrorCodes.E_CPDSS_NO_ACTUAL_ETA_OR_ETD_FOUND,
                HttpStatusCode.BAD_REQUEST);
          }
        }
      }
      LoadableStudyPortRotation loadableStudyPortRotation = getportRotationData(loadableStudy);
      validateActuals(loadableStudy);
      if (dischargeStudyRepository.existsByNameIgnoreCaseAndPlanningTypeXIdAndVoyageAndIsActive(
          request.getName(), 2, voyage, true)) {
        throw new GenericServiceException(
            "name already exists",
            CommonErrorCodes.E_CPDSS_LS_NAME_EXISTS,
            HttpStatusCode.BAD_REQUEST);
      }
      List<SynopticalTable> synopticalData =
          this.synopticalTableRepository
              .findByLoadableStudyXIdAndLoadableStudyPortRotation_idAndIsActive(
                  loadableStudy.getId(), loadableStudyPortRotation.getId(), true);
      if (synopticalData.isEmpty()) {
        throw new GenericServiceException(
            "synoptical data missing",
            CommonErrorCodes.E_HTTP_BAD_REQUEST,
            HttpStatusCode.BAD_REQUEST);
      }
      List<OnHandQuantity> onhandQuantity =
          this.onHandQuantityRepository.findByLoadableStudyAndPortRotationAndIsActive(
              loadableStudy, loadableStudyPortRotation, true);
      if (onhandQuantity.isEmpty()) {
        throw new GenericServiceException(
            "on hand quantity data missing",
            CommonErrorCodes.E_HTTP_BAD_REQUEST,
            HttpStatusCode.BAD_REQUEST);
      }

      LoadableStudy savedDischargeStudy = saveDischargeStudy(request, voyage, loadableStudy);
      LoadableStudyPortRotation dischargeStudyPortRotation =
          createDischargeStudyPortRotationData(loadableStudyPortRotation, savedDischargeStudy);
      LoadableStudyPortRotation savedDischargeport =
          loadableStudyPortRotationRepository.save(dischargeStudyPortRotation);
      this.cargoNominationService.saveDsichargeStudyCargoNominations(
          savedDischargeStudy.getId(),
          loadableStudy.getId(),
          savedDischargeport.getPortXId(),
          savedDischargeport.getOperation().getId());

      this.synopticalTableRepository.saveAll(
          createDischargeSynoptical(synopticalData, savedDischargeport));
      this.onHandQuantityRepository.saveAll(
          createDischargeOnHandQuantity(onhandQuantity, savedDischargeport));
      DischargeStudyCowDetail dischargeStudyCowDetail = new DischargeStudyCowDetail();
      dischargeStudyCowDetail.setCowType(1L);
      dischargeStudyCowDetail.setPercentage(25L);
      cowDetailService.saveAll(Arrays.asList(dischargeStudyCowDetail));
      builder.setId(savedDischargeStudy.getId());
      builder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS).build());

    } catch (GenericServiceException e) {
      TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
      e.printStackTrace();
      builder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(e.getCode())
              .setMessage(e.getMessage())
              .setStatus(FAILED)
              .setHttpStatusCode(e.getStatus().value())
              .build());
    } catch (Exception e) {
      TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
      builder.setResponseStatus(ResponseStatus.newBuilder().setStatus(FAILED).build());
    } finally {
      responseObserver.onNext(builder.build());
      responseObserver.onCompleted();
    }
  }

  private void validateActuals(LoadableStudy loadableStudy) throws GenericServiceException {

    List<CargoNomination> cargoNominations =
        cargoNominationService.getCargoNominationByLoadableStudyId(loadableStudy.getId());
    List<LoadableStudyPortRotation> ports =
        loadableStudyPortRotationRepository
            .findByLoadableStudyAndIsActive(loadableStudy.getId(), true).stream()
            .filter(p -> p.getOperation().getId().equals(LOADING_OPERATION_ID))
            .sorted(Comparator.comparing(LoadableStudyPortRotation::getPortOrder))
            .collect(Collectors.toList());
    StowageAndBillOfLaddingValidationRequest.Builder request =
        StowageAndBillOfLaddingValidationRequest.newBuilder();
    ports.forEach(
        port -> {
          PortWiseCargo.Builder portBuilder = PortWiseCargo.newBuilder();
          portBuilder.setPortRotationId(port.getId());
          portBuilder.setPortId(port.getPortXId());
          List<Long> cargoIds =
              cargoNominations.stream()
                  .filter(
                      cargo ->
                          cargo.getCargoNominationPortDetails().stream()
                              .anyMatch(portData -> portData.getPortId().equals(port.getPortXId())))
                  .map(CargoNomination::getId)
                  .collect(Collectors.toList());

          portBuilder.addAllCargoIds(cargoIds);
          request.addPortWiseCargos(portBuilder);
        });
    ResponseStatus response =
        loadingPlanServiceBlockingStub.validateStowageAndBillOfLadding(request.build());
    if (!SUCCESS.equalsIgnoreCase(response.getStatus())) {
      throw new GenericServiceException(
          "No Atcuals",
          CommonErrorCodes.E_CPDSS_NO_ACUTALS_OR_BL_VALUES_FOUND,
          HttpStatusCode.BAD_REQUEST);
    }
  }

  /**
   * duplicate the on hand quantity object for discharge study
   *
   * @param onhandQuantity data for discharge study
   * @param savedDischargeport data from loadable study
   * @return
   */
  private List<OnHandQuantity> createDischargeOnHandQuantity(
      List<OnHandQuantity> onhandQuantity, LoadableStudyPortRotation savedDischargeport) {
    List<OnHandQuantity> dischargeOHQList = new ArrayList<>();
    onhandQuantity.forEach(
        ohq -> {
          OnHandQuantity dischargeOHQ = new OnHandQuantity();
          dischargeOHQ.setActualArrivalQuantity(ohq.getActualArrivalQuantity());
          BeanUtils.copyProperties(ohq, dischargeOHQ);
          dischargeOHQ.setId(null);
          dischargeOHQ.setLoadableStudy(savedDischargeport.getLoadableStudy());
          dischargeOHQ.setPortRotation(savedDischargeport);
          dischargeOHQList.add(dischargeOHQ);
        });
    return dischargeOHQList;
  }

  /**
   * duplicate the synoptical table object for discharge study
   *
   * @param synopticalData data for discharge study
   * @param entity data from loadable study
   * @return
   */
  private List<SynopticalTable> createDischargeSynoptical(
      List<SynopticalTable> synopticalData, LoadableStudyPortRotation entity) {
    List<SynopticalTable> dischargeSynopticalList = new ArrayList<>();
    synopticalData.forEach(
        data -> {
          SynopticalTable dischargeSynoptical = new SynopticalTable();
          BeanUtils.copyProperties(data, dischargeSynoptical);
          dischargeSynoptical.setId(null);
          dischargeSynoptical.setLoadableStudyPortRotation(entity);
          dischargeSynoptical.setLoadableStudyXId(entity.getLoadableStudy().getId());
          dischargeSynopticalList.add(dischargeSynoptical);
        });

    return dischargeSynopticalList;
  }

  /**
   * discharge study save
   *
   * @param request data to set to discharge study
   * @param voyage current voyage
   * @param loadableStudy
   * @return
   */
  private LoadableStudy saveDischargeStudy(
      DischargeStudyDetail request, Voyage voyage, LoadableStudy loadableStudy) {
    LoadableStudy dischargeStudy = new LoadableStudy();
    dischargeStudy.setName(request.getName());
    dischargeStudy.setDetails(request.getEnquiryDetails());
    dischargeStudy.setActive(true);
    dischargeStudy.setVesselXId(request.getVesselId());
    dischargeStudy.setVoyage(voyage);
    dischargeStudy.setDraftMark(loadableStudy.getDraftMark());
    dischargeStudy.setLoadLineXId(loadableStudy.getLoadLineXId());
    dischargeStudy.setPlanningTypeXId(2);
    dischargeStudy.setLoadableStudyStatus(
        loadableStudyStatusRepository.getOne(LOADABLE_STUDY_INITIAL_STATUS_ID));
    dischargeStudy.setIsPortsComplete(true);
    dischargeStudy.setDraftMark(loadableStudy.getDraftMark());
    dischargeStudy.setConfirmedLoadableStudyId(loadableStudy.getId());
    LoadableStudy savedDischargeStudy = dischargeStudyRepository.save(dischargeStudy);
    return savedDischargeStudy;
  }

  private LoadableStudyPortRotation getportRotationData(LoadableStudy loadableStudy)
      throws GenericServiceException {
    List<LoadableStudyPortRotation> portrotation =
        loadableStudyPortRotationRepository.findByLoadableStudyAndOperation_idAndIsActive(
            loadableStudy, DISCHARGING_OPERATION_ID, true);
    if (portrotation.isEmpty()) {
      throw new GenericServiceException(
          "No discharging port in port rotation against loadable study",
          CommonErrorCodes.E_HTTP_BAD_REQUEST,
          HttpStatusCode.BAD_REQUEST);
    }
    portrotation.sort(Comparator.comparing(LoadableStudyPortRotation::getPortOrder).reversed());
    return portrotation.get(0);
  }

  private LoadableStudyPortRotation createDischargeStudyPortRotationData(
      LoadableStudyPortRotation loadableStudyPortRotation, LoadableStudy savedDischargeStudy) {
    LoadableStudyPortRotation portRotation = new LoadableStudyPortRotation();
    portRotation.setActive(loadableStudyPortRotation.isActive());
    portRotation.setAirDraftRestriction(loadableStudyPortRotation.getAirDraftRestriction());
    portRotation.setBerthXId(loadableStudyPortRotation.getBerthXId());
    portRotation.setDistanceBetweenPorts(loadableStudyPortRotation.getDistanceBetweenPorts());
    portRotation.setEta(loadableStudyPortRotation.getEta());
    portRotation.setEtd(loadableStudyPortRotation.getEtd());
    portRotation.setIsPortRotationOhqComplete(
        loadableStudyPortRotation.getIsPortRotationOhqComplete());
    portRotation.setLayCanFrom(loadableStudyPortRotation.getLayCanFrom());
    portRotation.setLayCanTo(loadableStudyPortRotation.getLayCanTo());
    portRotation.setLoadableStudy(savedDischargeStudy);
    portRotation.setMaxDraft(loadableStudyPortRotation.getMaxDraft());
    portRotation.setOperation(loadableStudyPortRotation.getOperation());
    portRotation.setPortOrder(1L);
    portRotation.setPortXId(loadableStudyPortRotation.getPortXId());
    portRotation.setSeaWaterDensity(loadableStudyPortRotation.getSeaWaterDensity());
    portRotation.setSynopticalTable(loadableStudyPortRotation.getSynopticalTable());
    portRotation.setTimeOfStay(loadableStudyPortRotation.getTimeOfStay());
    portRotation.setVersion(loadableStudyPortRotation.getVersion());
    portRotation.setFreshCrudeOil(loadableStudyPortRotation.getFreshCrudeOil());
    portRotation.setFreshCrudeOilQuantity(loadableStudyPortRotation.getFreshCrudeOilQuantity());
    portRotation.setFreshCrudeOilTime(loadableStudyPortRotation.getFreshCrudeOilTime());
    return portRotation;
  }

  @Override
  public void updateDischargeStudy(
      DischargeStudyDetail request, StreamObserver<UpdateDischargeStudyReply> responseObserver) {
    UpdateDischargeStudyReply.Builder builder = UpdateDischargeStudyReply.newBuilder();
    try {
      LoadableStudy loadable =
          this.dischargeStudyRepository.findById(request.getDischargeStudyId()).orElse(null);
      if (loadable == null) {
        throw new GenericServiceException(
            "No discharge study found",
            CommonErrorCodes.E_HTTP_BAD_REQUEST,
            HttpStatusCode.BAD_REQUEST);
      }

      if (dischargeStudyRepository
          .existsByNameIgnoreCaseAndPlanningTypeXIdAndVoyageAndIsActiveAndIdNot(
              request.getName(), 2, loadable.getVoyage(), true, loadable.getId())) {
        throw new GenericServiceException(
            "name already exists",
            CommonErrorCodes.E_CPDSS_LS_NAME_EXISTS,
            HttpStatusCode.BAD_REQUEST);
      }

      loadable.setName(request.getName());
      loadable.setDetails(request.getEnquiryDetails());
      LoadableStudy updatedDischarge = this.dischargeStudyRepository.save(loadable);
      builder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS).build());
      UpdateDischargeStudyDetail.Builder detail = UpdateDischargeStudyDetail.newBuilder();
      detail.setId(updatedDischarge.getId());
      detail.setName(updatedDischarge.getName());
      detail.setEnquiryDetails(updatedDischarge.getDetails());
      builder.setDischargeStudy(detail.build());
    } catch (GenericServiceException e) {
      TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
      e.printStackTrace();
      builder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(e.getCode())
              .setMessage(e.getMessage())
              .setStatus(FAILED)
              .setHttpStatusCode(e.getStatus().value())
              .build());
    } catch (Exception e) {
      TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
      e.printStackTrace();
      builder.setResponseStatus(ResponseStatus.newBuilder().setStatus(FAILED).build());
    } finally {
      responseObserver.onNext(builder.build());
      responseObserver.onCompleted();
    }
  }

  @Override
  public void deleteDischargeStudy(
      DischargeStudyRequest request, StreamObserver<DischargeStudyReply> responseObserver) {
    DischargeStudyReply.Builder replyBuilder = DischargeStudyReply.newBuilder();
    try {
      Optional<LoadableStudy> entityOpt =
          this.dischargeStudyRepository.findById(request.getDischargeStudyId());
      if (!entityOpt.isPresent()) {
        throw new GenericServiceException(
            "Loadable study does not exist",
            CommonErrorCodes.E_HTTP_BAD_REQUEST,
            HttpStatusCode.BAD_REQUEST);
      }
      LoadableStudy entity = entityOpt.get();

      this.voyageService.checkIfVoyageClosed(entity.getVoyage().getId());

      entity.setActive(false);
      this.dischargeStudyRepository.save(entity);
      replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS).build());
    } catch (GenericServiceException e) {
      log.error("GenericServiceException when deleting discharge study", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(e.getCode())
              .setMessage(e.getMessage())
              .setStatus(FAILED)
              .setHttpStatusCode(e.getStatus().value())
              .build());
    } catch (Exception e) {
      log.error("Exception when deleting discharge study", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage("Exception  when deleting discharge study")
              .setStatus(FAILED)
              .setHttpStatusCode(Integer.valueOf(CommonErrorCodes.E_GEN_INTERNAL_ERR))
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  public com.cpdss.common.generated.LoadableStudy.PortRotationReply.Builder saveDischargingPorts(
      com.cpdss.common.generated.LoadableStudy.PortRotationRequest request,
      com.cpdss.common.generated.LoadableStudy.PortRotationReply.Builder replyBuilder)
      throws GenericServiceException {
    Optional<LoadableStudy> loadableStudyOpt =
        this.loadableStudyRepository.findById(request.getLoadableStudyId());
    if (!loadableStudyOpt.isPresent()) {
      throw new GenericServiceException(
          "Loadable study does not exist",
          CommonErrorCodes.E_HTTP_BAD_REQUEST,
          HttpStatusCode.BAD_REQUEST);
    }
    this.voyageService.checkIfVoyageClosed(loadableStudyOpt.get().getVoyage().getId());
    loadablePatternService.isPatternGeneratedOrConfirmed(loadableStudyOpt.get());
    LoadableStudy loadableStudy = loadableStudyOpt.get();
    loadableStudy.setDischargeCargoNominationId(request.getCargoNominationId());
    loadableStudy.setIsDischargePortsComplete(request.getIsDischargingPortsComplete());
    this.loadableStudyRepository.save(loadableStudy);

    CargoOperation discharging = this.cargoOperationRepository.getOne(DISCHARGING_OPERATION_ID);
    List<LoadableStudyPortRotation> dischargingPorts =
        this.loadableStudyPortRotationRepository.findByLoadableStudyAndOperationAndIsActive(
            loadableStudyOpt.get(), discharging, true);
    List<Long> portIds = new ArrayList<>(request.getDischargingPortIdsList());
    for (LoadableStudyPortRotation portRotation : dischargingPorts) {
      if (!request.getDischargingPortIdsList().contains(portRotation.getPortXId())) {
        portRotation.setActive(false);
        onHandQuantityRepository.deleteByLoadableStudyAndPortXId(
            loadableStudy, portRotation.getPortXId());
        List<SynopticalTable> synopticalEntities = portRotation.getSynopticalTable();
        if (null != synopticalEntities && !synopticalEntities.isEmpty()) {
          synopticalEntities.forEach(entity -> entity.setIsActive(false));
        }
        portIds.remove(portRotation.getPortXId());
      } else {
        portIds.remove(portRotation.getPortXId());
      }
    }
    if (!CollectionUtils.isEmpty(portIds)) {
      // ports already added as transit cannot be again added as discharge ports
      loadableStudyPortRotationService.validateTransitPorts(loadableStudyOpt.get(), portIds);
      PortInfo.GetPortInfoByPortIdsRequest.Builder reqBuilder =
          PortInfo.GetPortInfoByPortIdsRequest.newBuilder();
      portIds.forEach(
          port -> {
            reqBuilder.addId(port);
          });
      PortInfo.PortReply portReply = portInfoGrpcService.getPortInfoByPortIds(reqBuilder.build());
      if (!SUCCESS.equalsIgnoreCase(portReply.getResponseStatus().getStatus())) {
        throw new GenericServiceException(
            "Error in calling port service",
            CommonErrorCodes.E_GEN_INTERNAL_ERR,
            HttpStatusCode.INTERNAL_SERVER_ERROR);
      }

      if (!CollectionUtils.isEmpty(portIds) && !CollectionUtils.isEmpty(portReply.getPortsList())) {
        dischargingPorts =
            this.buildDischargingPorts(portReply, loadableStudy, dischargingPorts, portIds);
        loadableStudy.setIsPortsComplete(false);

        // Port complete status becomes false even when all the mandatory fields are available for
        // all ports, need to set the port complete status properly on save.
        Boolean isPortRotationComplete = true;
        for (LoadableStudyPortRotation portRotation :
            this.loadableStudyPortRotationRepository.findByLoadableStudyAndIsActive(
                loadableStudy.getId(), true)) {
          // portRotation.setIsPortRotationOhqComplete(false);
          if ((portRotation.getSeaWaterDensity() == null)
              || (portRotation.getMaxDraft() == null)
              || (portRotation.getAirDraftRestriction() == null)) {
            isPortRotationComplete = false;
          }
        }
        loadableStudy.setIsPortsComplete(isPortRotationComplete);
        this.loadableStudyRepository.save(loadableStudy);
        this.loadableStudyPortRotationRepository.saveAll(dischargingPorts);
      }
    }

    // Set port ordering after updation
    loadableStudyPortRotationService.setPortOrdering(loadableStudy);

    replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS).build());
    return replyBuilder;
  }

  /**
   * Build discharging ports
   *
   * @param portReply
   * @param loadableStudy
   * @param dischargingPorts
   * @param portIds
   * @return
   */
  private List<LoadableStudyPortRotation> buildDischargingPorts(
      PortInfo.PortReply portReply,
      LoadableStudy loadableStudy,
      List<LoadableStudyPortRotation> dischargingPorts,
      List<Long> portIds) {
    Long maxPortOrder =
        loadableStudyPortRotationService.findMaxPortOrderForLoadableStudy(loadableStudy);
    for (Long requestedPortId : portIds) {
      Optional<PortInfo.PortDetail> portOpt =
          portReply.getPortsList().stream()
              .filter(portDetail -> Objects.equals(requestedPortId, portDetail.getId()))
              .findAny();

      if (portOpt.isPresent()) {
        PortInfo.PortDetail port = portOpt.get();
        LoadableStudyPortRotation portRotationEntity = new LoadableStudyPortRotation();
        portRotationEntity.setLoadableStudy(loadableStudy);
        portRotationEntity.setPortXId(port.getId());
        portRotationEntity.setOperation(
            this.cargoOperationRepository.getOne(DISCHARGING_OPERATION_ID));
        portRotationEntity.setSeaWaterDensity(
            !StringUtils.isEmpty(port.getWaterDensity())
                ? new BigDecimal(port.getWaterDensity())
                : null);
        portRotationEntity.setMaxDraft(
            !StringUtils.isEmpty(port.getMaxDraft()) ? new BigDecimal(port.getMaxDraft()) : null);

        portRotationEntity.setAirDraftRestriction(
            !StringUtils.isEmpty(port.getMaxAirDraft())
                ? new BigDecimal(port.getMaxAirDraft())
                : null);
        portRotationEntity.setPortOrder(++maxPortOrder);

        // add ports to synoptical table by reusing the function called by
        // port-rotation flow
        synopticService.buildPortsInfoSynopticalTable(
            portRotationEntity, DISCHARGING_OPERATION_ID, port.getId());
        dischargingPorts.add(portRotationEntity);
      }
    }
    return dischargingPorts;
  }

  /**
   * @param build
   * @return PortReply
   */
  public PortInfo.PortReply getPortInfo(PortInfo.GetPortInfoByPortIdsRequest build) {
    return portInfoGrpcService.getPortInfoByPortIds(build);
  }

  @Override
  public void saveDischargeStudyBackLoading(
      DishargeStudyBackLoadingSaveRequest request,
      StreamObserver<DischargeStudyReply> responseObserver) {
    DischargeStudyReply.Builder builder = DischargeStudyReply.newBuilder();
    try {
      long dischargestudyId = request.getDischargeStudyId();
      Optional<LoadableStudy> dischargeStudy = dischargeStudyRepository.findById(dischargestudyId);
      if (!dischargeStudy.isPresent()) {
        throw new GenericServiceException(
            "No discharge study found",
            CommonErrorCodes.E_CPDSS_NO_DISCHARGE_STUDY_FOUND,
            HttpStatusCode.BAD_REQUEST);
      }
      List<DishargeStudyBackLoadingDetail> portCargos = request.getDsBackLoadingList();
      List<LoadableStudyPortRotation> portRotations =
          loadableStudyPortRotationRepository.findByLoadableStudyAndIsActiveOrderByPortOrder(
              dischargeStudy.get(), true);
      List<Long> portRotationIds =
          portRotations.stream().map(LoadableStudyPortRotation::getId).collect(Collectors.toList());

      Map<Long, DischargeStudyCowDetail> cowDetailForThePort =
          cowDetailService.getCowDetailForThePort(dischargestudyId, portRotationIds);
      Map<Long, List<DischargeStudyPortInstruction>> portWiseInstructions =
          portInstructionService.getPortWiseInstructions(dischargestudyId, portRotationIds);
      List<CargoNomination> dbCargos = cargoNominationService.getCargoNominations(dischargestudyId);
      Map<Long, List<BackLoading>> backloadingData =
          backLoadingService.getBackloadingDataByportIds(dischargestudyId, portRotationIds);
      List<DischargeStudyCowDetail> cowDetailsToSave = new ArrayList<>();
      List<DischargeStudyPortInstruction> portInstructionsToSave = new ArrayList<>();
      List<BackLoading> backLoadingToSave = new ArrayList<>();
      List<CargoNomination> cargoNominationsToSave = new ArrayList<>();

      portCargos.forEach(
          cargo -> {
            PortRotationDetail portRequestDetail = cargo.getPortDetails();
            List<CargoNominationDetail> cargoNominations = cargo.getPortCargoDetailsList();
            long portCargoId = portRequestDetail.getId();
            LoadableStudyPortRotation dbPortRoation =
                portRotations.stream()
                    .filter(port -> port.getId() == portCargoId)
                    .findFirst()
                    .get();
            portRotations.forEach(
                portRotation -> {
                  Long portId = portRotation.getId();
                  if (portCargoId == portId) {
                    portRotation.setMaxDraft(new BigDecimal(portRequestDetail.getMaxDraft()));
                    portRotation.setIsbackloadingEnabled(
                        portRequestDetail.getIsBackLoadingEnabled());
                    portRotation.setFreshCrudeOil(portRequestDetail.getFreshCrudeOil());
                    portRotation.setFreshCrudeOilQuantity(new BigDecimal(portRequestDetail.getFreshCrudeOilQuantity()));
                    portRotation.setFreshCrudeOilTime(new BigDecimal(portRequestDetail.getFreshCrudeOilTime()));
                  }
                });
            updateCowDetails(
                cowDetailForThePort,
                cowDetailsToSave,
                portRequestDetail,
                portCargoId,
                dischargestudyId);
            updateInsrtuctions(
                dischargestudyId,
                portWiseInstructions,
                portInstructionsToSave,
                portRequestDetail,
                portCargoId);

            createBackLoading(
                backloadingData,
                backLoadingToSave,
                portRequestDetail,
                portCargoId,
                dischargestudyId);

            for(int i = 0; i < cargoNominations.size(); i++){
                CargoNominationDetail cargoRequest = cargoNominations.get(i);
                Long portId = dbPortRoation.getPortXId();
                if (cargoRequest.getId() != -1) {
                  Optional<CargoNomination> optionalCargoNomination =
                      dbCargos
                          .parallelStream()
                          .filter(
                              cargoNomination -> cargoNomination.getId() == cargoRequest.getId())
                          .findFirst();
                  if (!optionalCargoNomination.isPresent()) {
                    return;
                  }
                  optionalCargoNomination.get().setSequenceNo(cargoRequest.getSequenceNo());
                  optionalCargoNomination.get().setEmptyMaxNoOfTanks(cargoRequest.getEmptyMaxNoOfTanks());
                  updateCargoNominationToSave(
                      cargoRequest,
                      optionalCargoNomination.get(),
                      cargoNominationsToSave,
                      portId);
                } else {
                  CargoNomination cargoNomination = new CargoNomination();
                  cargoNomination.setLoadableStudyXId(dischargestudyId);
                  cargoNomination.setPriority(1L);
                  cargoNomination.setIsActive(true);
                  cargoNomination.setCargoNominationPortDetails(
                      cargoNominationService.createCargoNominationPortDetails(
                          cargoNomination, null, portId, dbPortRoation.getOperation().getId()));
                  cargoNomination.setIsBackloading(true);
                  cargoNomination.setSequenceNo(Long.valueOf(i));
                  cargoNomination.setEmptyMaxNoOfTanks(false);
                  updateCargoNominationToSave(
                      cargoRequest, cargoNomination, cargoNominationsToSave, portId);
                }
            }
            List<Long> requestIds =
                cargoNominations.stream()
                    .map(CargoNominationDetail::getId)
                    .collect(Collectors.toList());
            /** delete existing cargo nomination */
            List<CargoNomination> cargosForPort =
                dbCargos.stream()
                    .flatMap(x -> x.getCargoNominationPortDetails().stream())
                    .filter(port -> port.getPortId().equals(dbPortRoation.getPortXId()))
                    .map(CargoNominationPortDetails::getCargoNomination)
                    .collect(Collectors.toList());
            List<CargoNomination> cargosToDisable =
                cargosForPort
                    .parallelStream()
                    .filter(cn -> !requestIds.contains(cn.getId()))
                    .collect(Collectors.toList());
            cargosToDisable.forEach(
                cargoToDisable -> {
                  Optional<CargoNominationPortDetails> operationDetail =
                      cargoToDisable.getCargoNominationPortDetails().stream()
                          .filter(port -> port.getPortId().equals(dbPortRoation.getPortXId()))
                          .findFirst();
                  if (operationDetail.isPresent()) {
                    operationDetail.get().setIsActive(false);
                  }
                  cargoNominationsToSave.add(cargoToDisable);
                });
            if (cargoNominations.isEmpty() && !cargosForPort.isEmpty()) {
              cargosForPort.forEach(
                  dbCargo -> {
                    dbCargo.setIsActive(false);
                  });
            }
          });
      cowDetailService.saveAll(cowDetailsToSave);
      portInstructionService.saveAll(portInstructionsToSave);
      backLoadingService.saveAll(backLoadingToSave);
      cargoNominationService.saveAll(cargoNominationsToSave);
      loadableStudyPortRotationRepository.saveAll(portRotations);
      LoadableStudy dsEntity = dischargeStudy.get();
      dsEntity.setIsDischargeStudyComplete(true);
      dischargeStudyRepository.save(dsEntity);
      builder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS).build());
      builder.setId(dischargestudyId);
    } catch (GenericServiceException e) {
      TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
      e.printStackTrace();
      builder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(e.getCode())
              .setMessage(e.getMessage())
              .setStatus(FAILED)
              .setHttpStatusCode(e.getStatus().value())
              .build());
    } catch (Exception e) {
      TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
      e.printStackTrace();
      builder.setResponseStatus(ResponseStatus.newBuilder().setStatus(FAILED).build());
    } finally {
      responseObserver.onNext(builder.build());
      responseObserver.onCompleted();
    }
  }

  private void updateCargoNominationToSave(
      CargoNominationDetail cargoRequest,
      CargoNomination cargoNomination,
      List<CargoNomination> cargoNominationsToSave,
      Long portId) {
    cargoNomination.setCargoXId(cargoRequest.getCargoId());
    cargoNomination.setAbbreviation(cargoRequest.getAbbreviation());
    cargoNomination.setColor(cargoRequest.getColor());
    cargoNomination.setApi(new BigDecimal(cargoRequest.getApi()));
    cargoNomination.setTemperature(new BigDecimal(cargoRequest.getTemperature()));
    Optional<CargoNominationPortDetails> cargoOperation =
        cargoNomination.getCargoNominationPortDetails().stream()
            .filter(cp -> cp.getIsActive() && cp.getPortId().equals(portId))
            .findFirst();
    if (cargoOperation.isPresent()) {
      cargoOperation.get().setQuantity(new BigDecimal(cargoRequest.getQuantity()));
      cargoOperation.get().setMode(cargoRequest.getMode());
      cargoOperation.get().setIsActive(true);
    }
    cargoNominationsToSave.add(cargoNomination);
  }

  private void updateInsrtuctions(
      long dischargestudyId,
      Map<Long, List<DischargeStudyPortInstruction>> portWiseInstructions,
      List<DischargeStudyPortInstruction> portInstructionsToSave,
      PortRotationDetail portRequestDetail,
      long portCargoId) {
    if (portWiseInstructions.containsKey(portCargoId)) {
      List<Long> requestInstructions = portRequestDetail.getInstructionIdList();
      List<Long> dbInstructionIds =
          portWiseInstructions.get(portCargoId).stream()
              .map(DischargeStudyPortInstruction::getPortInstructionId)
              .collect(Collectors.toList());
      requestInstructions.forEach(
          portRequestInstructionId -> {
            if (!dbInstructionIds.contains(portRequestInstructionId)) {
              createPortInstructionToSave(
                  dischargestudyId, portInstructionsToSave, portCargoId, portRequestInstructionId);
            }
          });
      /**
       * if the instruction is a list and removed anything already assigned then need to disable
       * that instruction
       */
      List<DischargeStudyPortInstruction> intructionsToDisable =
          portWiseInstructions.get(portCargoId).stream()
              .filter(dbId -> !requestInstructions.contains(dbId.getPortInstructionId()))
              .collect(Collectors.toList());
      intructionsToDisable.forEach(
          instruction -> {
            instruction.setIsActive(false);
            portInstructionsToSave.add(instruction);
          });
    } else {
      portRequestDetail
          .getInstructionIdList()
          .forEach(
              portRequestInstructionId -> {
                createPortInstructionToSave(
                    dischargestudyId,
                    portInstructionsToSave,
                    portCargoId,
                    portRequestInstructionId);
              });
    }
  }

  /**
   * creating/updating back loading for the port rotation
   *
   * @param backloadingData
   * @param backLoadingToSave
   * @param portRequestDetail
   * @param portCargoId
   * @param dischargestudyId
   */
  private void createBackLoading(
      Map<Long, List<BackLoading>> backloadingData,
      List<BackLoading> backLoadingToSave,
      PortRotationDetail portRequestDetail,
      long portCargoId,
      long dischargestudyId) {
    if (backloadingData.containsKey(portCargoId)) {
      List<BackLoading> dbBackLoadings = backloadingData.get(portCargoId);
      portRequestDetail.getBackLoadingList().stream()
          .forEach(
              backLoadingRequest -> {
                if (backLoadingRequest.getId() != -1) {
                  Optional<BackLoading> backLoading =
                      dbBackLoadings
                          .parallelStream()
                          .filter(backloading -> backloading.getId() == backLoadingRequest.getId())
                          .findFirst();
                  if (!backLoading.isPresent()) {
                    return;
                  }
                  updateBackLoadingToSave(backLoadingRequest, backLoading.get(), backLoadingToSave);
                } else {
                  BackLoading backLoading = new BackLoading();
                  backLoading.setDischargeStudyId(dischargestudyId);
                  backLoading.setPortId(portCargoId);
                  updateBackLoadingToSave(backLoadingRequest, backLoading, backLoadingToSave);
                }
              });

      /** delete existing back loading */
      List<Long> requestIds =
          portRequestDetail.getBackLoadingList().stream()
              .map(com.cpdss.common.generated.loadableStudy.LoadableStudyModels.BackLoading::getId)
              .collect(Collectors.toList());
      List<BackLoading> backLoadingToDisable =
          backloadingData.get(portCargoId).stream()
              .filter(dbId -> !requestIds.contains(dbId.getId()))
              .collect(Collectors.toList());
      backLoadingToDisable.forEach(
          backLoading -> {
            backLoading.setActive(false);
            backLoadingToSave.add(backLoading);
          });
    } else {
      if (backloadingData != null && !backloadingData.isEmpty()) {
        /** delete existing back loading */
        if (backloadingData.get(portCargoId) != null) {
          backloadingData.get(portCargoId).stream()
              .forEach(
                  backLoading -> {
                    backLoading.setActive(false);
                    backLoadingToSave.add(backLoading);
                  });
        }
      }
      portRequestDetail
          .getBackLoadingList()
          .forEach(
              backLoadingRequest -> {
                BackLoading newBackLoading = new BackLoading();
                newBackLoading.setPortId(portCargoId);
                newBackLoading.setDischargeStudyId(dischargestudyId);
                updateBackLoadingToSave(backLoadingRequest, newBackLoading, backLoadingToSave);
              });
    }
  }

  private void updateBackLoadingToSave(
      com.cpdss.common.generated.loadableStudy.LoadableStudyModels.BackLoading backLoadingRequest,
      BackLoading backLoading,
      List<BackLoading> backLoadingToSave) {
    backLoading.setAbbreviation(backLoadingRequest.getAbbreviation());
    backLoading.setActive(true);
    backLoading.setApi(new BigDecimal(backLoadingRequest.getApi()));
    backLoading.setCargoId(backLoadingRequest.getCargoId());
    backLoading.setColour(backLoadingRequest.getColour());
    backLoading.setQuantity(new BigDecimal(backLoadingRequest.getQuantity()));
    backLoading.setTemperature(new BigDecimal(backLoadingRequest.getTemperature()));
    backLoadingToSave.add(backLoading);
  }

  private void createPortInstructionToSave(
      long dischargestudyId,
      List<DischargeStudyPortInstruction> portInstructionsToSave,
      long portCargoId,
      Long portRequestInstructionId) {
    DischargeStudyPortInstruction newInstruction = new DischargeStudyPortInstruction();
    newInstruction.setDischargeStudyId(dischargestudyId);
    newInstruction.setPortId(portCargoId);
    newInstruction.setPortInstructionId(portRequestInstructionId);
    newInstruction.setIsActive(true);
    portInstructionsToSave.add(newInstruction);
  }

  private void updateCowDetails(
      Map<Long, DischargeStudyCowDetail> cowDetailForThePort,
      List<DischargeStudyCowDetail> cowDetailsToSave,
      PortRotationDetail portDetail,
      long portCargoId,
      long dischargestudyId) {
    DischargeStudyCowDetail dischargeStudyCowDetail = null;
    if (cowDetailForThePort.containsKey(portCargoId)) {
      dischargeStudyCowDetail = cowDetailForThePort.get(portCargoId);
    } else {
      dischargeStudyCowDetail = new DischargeStudyCowDetail();
      dischargeStudyCowDetail.setPortId(portCargoId);
      dischargeStudyCowDetail.setDischargeStudyStudyId(dischargestudyId);
    }
    dischargeStudyCowDetail.setCowType(portDetail.getCowId());
    if (portDetail.getCowId() == 1) {
      dischargeStudyCowDetail.setPercentage(portDetail.getPercentage());
      dischargeStudyCowDetail.setTankIds("");
    } else if (portDetail.getCowId() == 2) {
      String numberString =
          portDetail.getTanksList().stream().map(String::valueOf).collect(Collectors.joining(","));
      dischargeStudyCowDetail.setTankIds(numberString);
      dischargeStudyCowDetail.setPercentage(null);
    }
    cowDetailsToSave.add(dischargeStudyCowDetail);
  }

  @Override
  public void getDischargeStudyPortWiseCargos(
      DischargeStudyRequest request, StreamObserver<DishargeStudyCargoReply> responseObserver) {
    DishargeStudyCargoReply.Builder replyBuilder = DishargeStudyCargoReply.newBuilder();

    try {
      if (!dischargeStudyRepository.existsById(request.getDischargeStudyId())) {
        throw new GenericServiceException(
            "Loadable study does not exist",
            CommonErrorCodes.E_CPDSS_CONFIRMED_LS_DOES_NOT_EXIST,
            HttpStatusCode.BAD_REQUEST);
      }
      List<LoadableStudyPortRotation> findByLoadableStudyIdAndIsActive =
          loadableStudyPortRotationRepository.findByLoadableStudyIdAndIsActive(
              request.getDischargeStudyId(), true);
      List<Long> portIds =
          findByLoadableStudyIdAndIsActive.stream()
              .map(LoadableStudyPortRotation::getPortXId)
              .collect(Collectors.toList());
      PortInfo.GetPortInfoByPortIdsRequest.Builder reqBuilder =
          PortInfo.GetPortInfoByPortIdsRequest.newBuilder();
      portIds.forEach(
          port -> {
            reqBuilder.addId(port);
          });
      CargoInfos cargoInfos = portInfoGrpcService.getCargoInfoByPortIds(reqBuilder.build());
      if (!SUCCESS.equalsIgnoreCase(cargoInfos.getResponseStatus().getStatus())) {
        throw new GenericServiceException(
            "Error in calling port service",
            CommonErrorCodes.E_GEN_INTERNAL_ERR,
            HttpStatusCode.INTERNAL_SERVER_ERROR);
      }
      CargoListRequest.Builder cargoRequest = CargoListRequest.newBuilder();
      List<CargoPortMapping> cargoPortMappings = cargoInfos.getCargoPortsList();
      cargoRequest.addAllId(
          cargoPortMappings.stream()
              .map(CargoPortMapping::getCargoId)
              .collect(Collectors.toList()));
      CargoReply cargoInfosByCargoIds =
          cargoInfoGrpcService.getCargoInfosByCargoIds(cargoRequest.build());

      if (!SUCCESS.equalsIgnoreCase(cargoInfosByCargoIds.getResponseStatus().getStatus())) {
        throw new GenericServiceException(
            "Error in calling cargo service",
            CommonErrorCodes.E_GEN_INTERNAL_ERR,
            HttpStatusCode.INTERNAL_SERVER_ERROR);
      }

      Map<Long, List<Long>> portWiseCargos =
          cargoPortMappings.stream()
              .collect(
                  Collectors.groupingBy(
                      CargoPortMapping::getPortId,
                      Collectors.mapping(CargoPortMapping::getCargoId, Collectors.toList())));
      portWiseCargos.forEach(
          (portId, cargoIds) -> {
            List<CargoDetail> cargoDetails =
                cargoInfosByCargoIds.getCargosList().stream()
                    .filter(c -> cargoIds.contains(c.getId()))
                    .collect(Collectors.toList());
            DishargeStudyPortCargoMapping.Builder cargoPortMappingBuilder =
                DishargeStudyPortCargoMapping.newBuilder();
            createCargoResponse(cargoDetails, cargoPortMappingBuilder);
            cargoPortMappingBuilder.setPortId(portId);
            replyBuilder.addPortCargos(cargoPortMappingBuilder.build());
          });
      replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS).build());
    } catch (GenericServiceException e) {
      log.error("GenericServiceException when deleting discharge study", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(e.getCode())
              .setMessage(e.getMessage())
              .setStatus(FAILED)
              .setHttpStatusCode(e.getStatus().value())
              .build());
    } catch (Exception e) {
      log.error("Exception  when getting powtise cargo details", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage("Exception  when getting powtise cargo details")
              .setStatus(FAILED)
              .setHttpStatusCode(Integer.valueOf(CommonErrorCodes.E_GEN_INTERNAL_ERR))
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  private void createCargoResponse(
      List<CargoDetail> cargoDetails, DishargeStudyPortCargoMapping.Builder replyBuilder) {
    cargoDetails.forEach(
        cargo -> {
          DishargeStudyCargoDetail.Builder cargoDetail = DishargeStudyCargoDetail.newBuilder();
          cargoDetail.setId(cargo.getId());
          cargoDetail.setApi(cargo.getApi());
          cargoDetail.setAbbreviation(cargo.getAbbreviation());
          cargoDetail.setIsCondensateCargo(cargo.getIsCondensateCargo());
          cargoDetail.setIsHrvpCargo(cargo.getIsHrvpCargo());
          cargoDetail.setCrudeType(cargo.getCrudeType());
          replyBuilder.addCargos(cargoDetail.build());
        });
  }

  @Override
  public void generateDischargePatterns(
      AlgoRequest request, StreamObserver<AlgoReply> responseObserver) {
    log.info("Inside generateLoadablePatterns service");
    com.cpdss.common.generated.LoadableStudy.AlgoReply.Builder replyBuilder =
        AlgoReply.newBuilder();
    try {
      generateDischargeStudyJson.generateDischargePatterns(request, replyBuilder);
      replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS).build());
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
      log.info("Error calling ALGO ", request.getLoadableStudyId());
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

  public void addCargoNominationForPortRotation(long portRotationId, long loadableStudyId)
      throws GenericServiceException {
    log.info("Inside addCargoNominationForPortRotation service");

    List<LoadableStudyPortRotation> portRotations = getDischargeStudyPortRotations(loadableStudyId);
    if (portRotations == null) {
      return;
    }

    LoadableStudyPortRotation newPort = portRotations.get(portRotations.size() - 1);

    if (newPort.getId() != portRotationId) {
      throw new GenericServiceException(
          "port rotaion data mis match",
          CommonErrorCodes.E_HTTP_BAD_REQUEST,
          HttpStatusCode.BAD_REQUEST);
    }
    List<CargoNomination> cargos = createNewPortCargoNominations(loadableStudyId, newPort);
    // there should be at least 2 ports needed for backloading
    if (portRotations.size() >= 2) {
      createBackLoadingIfAny(loadableStudyId, portRotations, cargos);
    }
    cargoNominationService.saveAll(cargos);
  }

  private void createBackLoadingIfAny(
      long loadableStudyId,
      List<LoadableStudyPortRotation> portRotations,
      List<CargoNomination> cargos) {
    LoadableStudyPortRotation loadableStudyPortRotation =
        portRotations.get(portRotations.size() - 2);
    Map<Long, List<BackLoading>> backloadingDataByportIds =
        backLoadingService.getBackloadingDataByportIds(
            loadableStudyId, Arrays.asList(loadableStudyPortRotation.getId()));
    List<BackLoading> backLoadingList =
        backloadingDataByportIds.get(loadableStudyPortRotation.getId());
    if (backLoadingList != null && !backLoadingList.isEmpty()) {
      backLoadingList.stream()
          .forEach(
              backloading -> {
                CargoNomination cargoBackloading = new CargoNomination();
                cargoBackloading.setAbbreviation(backloading.getAbbreviation());
                cargoBackloading.setCargoXId(backloading.getCargoId());
                cargoBackloading.setApi(backloading.getApi());
                cargoBackloading.setColor(backloading.getColour());
                cargoBackloading.setLoadableStudyXId(backloading.getDischargeStudyId());
                cargoBackloading.setQuantity(new BigDecimal(0L));
                cargoBackloading.setIsActive(true);
                cargoBackloading.setTemperature(backloading.getTemperature());
                cargoBackloading.setVersion(1L);
                cargoBackloading.setIsBackloading(true);
                cargoBackloading.setCargoNominationPortDetails(
                    cargoNominationService.createCargoNominationPortDetails(
                        cargoBackloading,
                        null,
                        portRotations.get(portRotations.size() - 1).getPortXId(),
                        portRotations.get(portRotations.size() - 1).getOperation().getId()));
                cargoBackloading.setPriority(1L);
                cargos.add(cargoBackloading);
              });
    }
  }

  private List<CargoNomination> createNewPortCargoNominations(
      long loadableStudyId, LoadableStudyPortRotation newPort) {
    List<CargoNomination> cargos = cargoNominationService.getCargoNominations(loadableStudyId);
    List<LoadableStudyPortRotation> ports =
        loadableStudyPortRotationRepository.findByLoadableStudyIdAndIsActive(loadableStudyId, true);
    Optional<LoadableStudyPortRotation> firstDischargingPort =
        ports.stream()
            .filter(
                port ->
                    port.isActive() && port.getOperation().getId().equals(DISCHARGING_OPERATION_ID))
            .sorted(Comparator.comparing(LoadableStudyPortRotation::getPortOrder))
            .findFirst();
    List<CargoNomination> newPortCargo =
        cargos.stream()
            .filter(
                cargo -> cargo.getIsBackloading() == null || cargo.getIsBackloading().equals(false))
            .collect(Collectors.toList());
    newPortCargo.stream()
        .forEach(
            cargo -> {
              // Bug fix - DSS - 4493 - Checking for duplicate entry in Cargo nomination
              // operation table
              if (!checkIfCargoNominationAlreadyPresent(cargo, newPort.getPortXId())) {
                Set<CargoNominationPortDetails> newPortDetails = new HashSet<>();
                if (firstDischargingPort.isPresent()
                    && firstDischargingPort.get().getPortXId().equals(newPort.getPortXId())) {
                  newPortDetails =
                      cargoNominationService.createCargoNominationPortDetails(
                          cargo, cargo, newPort.getPortXId(), newPort.getOperation().getId());
                } else {
                  newPortDetails =
                      cargoNominationService.createCargoNominationPortDetails(
                          cargo, null, newPort.getPortXId(), newPort.getOperation().getId());
                }

                if (cargo.getCargoNominationPortDetails() != null
                    && !cargo.getCargoNominationPortDetails().isEmpty()) {
                  cargo.getCargoNominationPortDetails().addAll(newPortDetails);
                } else {
                  cargo.setCargoNominationPortDetails(newPortDetails);
                }
              }
            });
    return cargos;
  }

  /**
   * Method used to check if cargo nomination and port combo already present in DB This check is
   * needed to avoid duplication when user delete/rename a discharge port and later add the same
   * port. Bug fix - DSS - 4493 - Checking if for duplicate entry in Cargo nomination
   */
  private Boolean checkIfCargoNominationAlreadyPresent(CargoNomination cargo, Long portXId) {
    CargoNominationPortDetails cargoNominationOperation =
        cargoNominationOperationRepository.findByCargoNominationAndPortIdAndIsActiveTrue(
            cargo, portXId);
    return cargoNominationOperation != null ? true : false;
  }

  private List<LoadableStudyPortRotation> getDischargeStudyPortRotations(Long loadableStudyId)
      throws GenericServiceException {
    LoadableStudy loadableStudy = loadableStudyRepository.findById(loadableStudyId).get();
    /**
     * if the loadable study is a discharge study then add cargo nominations of the previous port t
     * the newly created one else return
     */
    if (loadableStudy.getPlanningTypeXId() != 2) {
      return null;
    }
    List<LoadableStudyPortRotation> portRotations =
        loadableStudyPortRotationRepository.findByLoadableStudyIdAndIsActive(
            loadableStudy.getId(), true);
    portRotations.sort(Comparator.comparing(LoadableStudyPortRotation::getPortOrder));
    return portRotations;
  }

  public void resetCargoNominationQuantityAndBackLoading(long portRotationId, long loadableStudyId)
      throws GenericServiceException {
    List<LoadableStudyPortRotation> dischargeStudyPortRotations =
        getDischargeStudyPortRotations(loadableStudyId);
    if (dischargeStudyPortRotations == null) {
      return;
    }
    List<CargoNomination> cargos = cargoNominationService.getCargoNominations(loadableStudyId);
    // finds the DS ports which is converted to DIsharging from another opertaion
    // ID.
    // These ports will be missing the cargo nomination records so adding cargo
    // nominations.
    Set<Long> nominationPortIds =
        cargos.stream()
            .flatMap(x -> x.getCargoNominationPortDetails().stream())
            .map(CargoNominationPortDetails::getPortId)
            .distinct()
            .collect(Collectors.toSet());
    List<LoadableStudyPortRotation> dischargingPorts =
        dischargeStudyPortRotations.stream()
            .filter(
                port ->
                    port.getOperation().getId().equals(DISCHARGING_OPERATION_ID)
                        && !nominationPortIds.contains(port.getPortXId()))
            .collect(Collectors.toList());
    if (!dischargingPorts.isEmpty()) {
      cargoNominationService.saveAll(
          createNewPortCargoNominations(loadableStudyId, dischargingPorts.get(0)));
    }
    Set<CargoNomination> firstPortCargos =
        cargos.stream()
            .filter(
                cargo -> cargo.getIsBackloading() == null || cargo.getIsBackloading().equals(false))
            .collect(Collectors.toSet());

    List<Long> firstPortCargoIds =
        firstPortCargos.stream()
            .distinct()
            .map(CargoNomination::getLsCargoNominationId)
            .filter(Objects::nonNull)
            .collect(Collectors.toList());
    cargoNominationService.getMaxQuantityForCargoNomination(firstPortCargoIds, firstPortCargos);
    Optional<LoadableStudyPortRotation> dischargeStudyPortRotation =
        dischargeStudyPortRotations.stream()
            .filter(port -> port.getOperation().getId().equals(DISCHARGING_OPERATION_ID))
            .sorted(Comparator.comparing(LoadableStudyPortRotation::getPortOrder))
            .findFirst();

    cargos.stream()
        .flatMap(cargo -> cargo.getCargoNominationPortDetails().stream())
        .forEach(
            operation -> {
              if (!dischargeStudyPortRotation.isEmpty()
                  && !operation.getPortId().equals(dischargeStudyPortRotation.get().getPortXId())) {
                operation.setQuantity(new BigDecimal(0));
                operation.setMode(1L);
              } else {
                operation.setQuantity(operation.getCargoNomination().getQuantity());
                operation.setMode(2L);
              }
            });
    cargos.stream()
        .forEach(
            cargo -> {
              if (cargo.getIsBackloading() != null && cargo.getIsBackloading()) {
                cargo.setIsActive(false);
              }
            });

    cargoNominationService.saveAll(cargos);
    List<BackLoading> backLoadings =
        backLoadingService.getBackLoadings(
            loadableStudyId,
            dischargeStudyPortRotations.stream()
                .map(LoadableStudyPortRotation::getId)
                .collect(Collectors.toList()));
    backLoadings
        .parallelStream()
        .forEach(
            backLoading -> {
              backLoading.setActive(false);
            });
    backLoadingService.saveAll(backLoadings);
    dischargeStudyPortRotations.stream()
        .forEach(
            port -> {
              port.setIsbackloadingEnabled(false);
            });
    loadableStudyPortRotationRepository.saveAll(dischargeStudyPortRotations);
  }

  @Override
  public void getDischargePlanDetails(
      LoadablePlanDetailsRequest request, StreamObserver<CargoNominationReply> responseObserver) {

    log.info("inside getLoadablePlanDetails loadable study service");
    CargoNominationReply.Builder replyBuilder = CargoNominationReply.newBuilder();
    try {

      Optional<LoadableStudy> dsOptional =
          dischargeStudyRepository.findByIdAndIsActive(request.getLoadablePatternId(), true);
      if (dsOptional.isEmpty()) {
        throw new GenericServiceException(
            "DS ID not match",
            CommonErrorCodes.E_CPDSS_NO_DISCHARGE_STUDY_FOUND,
            HttpStatusCode.BAD_REQUEST);
      }
      LoadableStudy dischargeStudy = dsOptional.get();
      List<LoadableStudyPortRotation> ports =
          loadableStudyPortRotationRepository.findByLoadableStudyAndIsActive(
              dischargeStudy.getId(), true);
      List<CargoNomination> cargos =
          cargoNominationService.getCargoNominationByLoadableStudyId(dischargeStudy.getId());
      List<DischargePatternQuantityCargoPortwiseDetails> generatedCargos =
          dischargePatternQuantityCargoPortwiseRepository
              .findByDischargeCargoNominationIdInAndOperationType(
                  cargos.stream().map(CargoNomination::getId).collect(Collectors.toList()),
                  SYNOPTICAL_TABLE_OP_TYPE_DEPARTURE);
      Map<Long, List<DischargePatternQuantityCargoPortwiseDetails>> portWiseCargo =
          generatedCargos.stream()
              .collect(
                  Collectors.groupingBy(
                      DischargePatternQuantityCargoPortwiseDetails::getPortRotationId));
      ports.stream()
          .forEach(
              port -> {
                List<DischargePatternQuantityCargoPortwiseDetails> portCargos =
                    portWiseCargo.get(port.getId());
                portCargos.stream()
                    .forEach(
                        pCargo -> {
                          CargoNominationDetail.Builder cargo = CargoNominationDetail.newBuilder();
                          ofNullable(pCargo.getCargoAbbreviation())
                              .ifPresent(cargo::setAbbreviation);
                          ofNullable(pCargo.getEstimatedAPI())
                              .ifPresent(api -> cargo.setApi(api.toString()));
                          ofNullable(pCargo.getCargoId()).ifPresent(cargo::setCargoId);
                          ofNullable(pCargo.getDischargeCargoNominationId())
                              .ifPresent(cargo::setId);
                          ofNullable(pCargo.getEstimatedTemp())
                              .ifPresent(value -> cargo.setTemperature(value.toString()));
                          ofNullable(pCargo.getColorCode()).ifPresent(cargo::setColor);
                          ofNullable(pCargo.getDischargeMT())
                              .ifPresent(value -> cargo.setQuantity(value.toString()));
                          ofNullable(pCargo.getDischargingRate())
                              .ifPresent(value -> cargo.setDischargingRate(value.toString()));
                          ofNullable(pCargo.getTimeRequiredForDischarging())
                              .ifPresent(value -> cargo.setDischargingTime(value.toString()));
                          LoadingPortDetail.Builder portDetail = LoadingPortDetail.newBuilder();
                          portDetail.setPortId(port.getPortXId());
                          portDetail.setQuantity(pCargo.getDischargeMT().toString());
                          portDetail.setMode(2L);
                          cargo.addLoadingPortDetails(portDetail);
                          replyBuilder.addCargoNominations(cargo);
                        });
              });
      // getting discharge pattern Id
      List<LoadablePattern> patterns =
          loadablePatternRepository.findByLoadableStudyAndIsActiveOrderByCaseNumberAsc(
              dischargeStudy, true);
      if (!patterns.isEmpty()) {
        replyBuilder.setPatternId(patterns.get(0).getId());
      }
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

  @Override
  public void confirmPlan(
      ConfirmPlanRequest request, StreamObserver<ConfirmPlanReply> responseObserver) {
    log.info("inside confirmPlan loadable study service");
    ConfirmPlanReply.Builder replyBuilder = ConfirmPlanReply.newBuilder();
    try {
      Builder reply = loadablePatternService.confirmPlan(request, replyBuilder);
      if (!SUCCESS.equals(reply.getResponseStatus().getStatus())) {
        throw new GenericServiceException(
            "failed to confirm",
            reply.getResponseStatus().getCode(),
            HttpStatusCode.valueOf(Integer.valueOf(reply.getResponseStatus().getCode())));
      }
      com.cpdss.loadablestudy.entity.LoadablePattern loadablePatternOpt =
          this.loadablePatternRepository
              .findByIdAndIsActive(request.getLoadablePatternId(), true)
              .get();
      transferDSConfirmedPlanData(loadablePatternOpt.getLoadableStudy());
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

  private void transferDSConfirmedPlanData(LoadableStudy dischargeStudy) {
    List<LoadableStudyPortRotation> ports =
        loadableStudyPortRotationRepository.findByLoadableStudyAndIsActive(
            dischargeStudy.getId(), true);
    DischargeStudyDataTransferRequest.Builder request =
        DischargeStudyDataTransferRequest.newBuilder();
    request.setVoyageId(dischargeStudy.getVoyage().getId());
    request.setVesselId(dischargeStudy.getVesselXId());

    List<LoadableStudyAlgoStatus> algoStatuses =
        loadableStudyAlgoStatusRepository.findByLoadableStudyIdAndIsActive(
            dischargeStudy.getId(), true);
    Optional<LoadableStudyAlgoStatus> latestOne =
        algoStatuses.stream()
            .sorted(Comparator.comparing(EntityDoc::getCreatedDateTime))
            .findFirst();
    if (latestOne.isPresent()) {
      request.setDischargeProcessId(latestOne.get().getProcessId());
    }

    Optional<com.cpdss.loadablestudy.entity.LoadablePattern> confirmedLoadablePatternOpt =
        this.loadablePatternRepository.findByLoadableStudyAndLoadableStudyStatusAndIsActive(
            dischargeStudy, CONFIRMED_STATUS_ID, true);
    if (confirmedLoadablePatternOpt.isPresent()) {
      request.setDischargePatternId(confirmedLoadablePatternOpt.get().getId());
    }
    ports.stream()
        .forEach(
            port -> {
              PortData.Builder portDataBuilder = PortData.newBuilder();
              portDataBuilder.setPortRotationId(port.getId());
              portDataBuilder.setPortId(port.getPortXId());
              Optional.ofNullable(port.getPortOrder())
                  .ifPresent(v -> portDataBuilder.setPortOrder(v.intValue()));
              Optional<SynopticalTable> synopticalTableOpt =
                  port.getSynopticalTable().stream()
                      .filter(
                          synopticalTable ->
                              synopticalTable.getIsActive()
                                  && synopticalTable
                                      .getOperationType()
                                      .equalsIgnoreCase(SYNOPTICAL_TABLE_OP_TYPE_ARRIVAL))
                      .findFirst();
              if (synopticalTableOpt.isPresent()) {
                portDataBuilder.setSynopticTableId(synopticalTableOpt.get().getId());
              }
              if (dischargeStudy.getId() != null) {
                portDataBuilder.setPortId(port.getPortXId());
                DischargeStudyCowDetail dsCow =
                    this.dischargeStudyCowDetailRepository
                        .findByDischargeStudyStudyIdAndPortIdAndIsActive(
                            dischargeStudy.getId(), port.getPortXId(), true);
                if (dsCow != null) { // Cow Details Per Port Ids
                  DSCowDetails.Builder dsCowDetails = DSCowDetails.newBuilder();
                  dsCowDetails.setDischargeStudyId(dischargeStudy.getId());
                  dsCowDetails.setPercent(dsCow.getPercentage());
                  dsCowDetails.setCowOptionType(
                      Common.COW_OPTION_TYPE.forNumber(dsCow.getCowType().intValue()));
                  if (dsCow.getTankIds() != null) {
                    List<Long> list =
                        Arrays.asList(dsCow.getTankIds().split(",")).stream()
                            .map(String::trim)
                            .mapToLong(Long::parseLong)
                            .boxed()
                            .collect(Collectors.toList());
                    if (!list.isEmpty()) {
                      CowTankDetails.Builder tankDetails = CowTankDetails.newBuilder();
                      tankDetails.setCowType(
                          Common.COW_TYPE.forNumber(dsCow.getCowType().intValue()));
                      tankDetails.addAllTankIds(list);
                    }
                  }
                  dsCowDetails.build();
                }
              }
              request.addPortData(portDataBuilder);
            });
    dischargePlanServiceBlockingStub.dischargePlanSynchronization(request.build());
  }

  public void getCowHistoryByVesselId(
      com.cpdss.common.generated.LoadableStudy.CowHistoryRequest request,
      StreamObserver<com.cpdss.common.generated.LoadableStudy.CowHistoryReply> responseObserver) {
    com.cpdss.common.generated.LoadableStudy.CowHistoryReply.Builder replyBuilder =
        com.cpdss.common.generated.LoadableStudy.CowHistoryReply.newBuilder();
    try {
      Pageable pageable = PageRequest.of(0, 500, Sort.by("lastModifiedDateTime").descending());
      List<CowHistory> list =
          cowHistoryRepository.findAllByVesselIdAndIsActiveTrue(request.getVesselId(), pageable);
      for (CowHistory ch : list) {
        com.cpdss.common.generated.LoadableStudy.CowHistory.Builder cowBuilder =
            com.cpdss.common.generated.LoadableStudy.CowHistory.newBuilder();
        cowBuilder.setId(ch.getId());
        cowBuilder.setVesselId(ch.getVesselId());
        cowBuilder.setVoyageId(ch.getVoyageId());
        cowBuilder.setPortId(ch.getPortId());
        if (ch.getTankId() != null) {
          cowBuilder.setTankId(ch.getTankId());
        }
        cowBuilder.setCowOptionType(Common.COW_OPTION_TYPE.forNumber(ch.getCowTypeId().intValue()));

        Voyage voyage = voyageRepository.findByIdAndIsActive(ch.getVoyageId(), true);
        if (voyage != null) {
          if (voyage.getActualEndDate() != null) {
            DateTimeFormatter dft = DateTimeFormatter.ofPattern(VOYAGE_DATE_FORMAT);
            // Changing to actual end Date : previous implementation was voyage planned end date.
            String endDate = voyage.getActualEndDate().format(dft);
            cowBuilder.setVoyageEndDate(endDate);
          }
        }
        replyBuilder.addCowHistory(cowBuilder.build());
      }
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
}
