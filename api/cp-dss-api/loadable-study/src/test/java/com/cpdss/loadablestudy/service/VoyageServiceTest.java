/* Licensed at AlphaOri Technologies */
package com.cpdss.loadablestudy.service;

import static com.cpdss.loadablestudy.utility.LoadableStudiesConstants.DATE_FORMAT;
import static com.cpdss.loadablestudy.utility.LoadableStudiesConstants.SUCCESS;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import com.cpdss.common.exception.GenericServiceException;
import com.cpdss.common.generated.CargoInfo;
import com.cpdss.common.generated.Common;
import com.cpdss.common.generated.LoadableStudy;
import com.cpdss.common.generated.PortInfo;
import com.cpdss.loadablestudy.entity.*;
import com.cpdss.loadablestudy.repository.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.util.ReflectionTestUtils;

@SpringJUnitConfig(classes = {VoyageService.class})
public class VoyageServiceTest {

  @Autowired private VoyageService voyageService;
  @MockBean private CargoService cargoService;
  @MockBean private VoyageRepository voyageRepository;
  @MockBean private LoadablePatternRepository loadablePatternRepository;
  @MockBean private VoyageStatusRepository voyageStatusRepository;
  @MockBean private LoadableStudyPortRotationRepository loadableStudyPortRotationRepository;
  @MockBean private VoyageHistoryRepository voyageHistoryRepository;
  @MockBean private CargoHistoryRepository cargoHistoryRepository;
  @MockBean private LoadablePatternCargoDetailsRepository loadablePatternCargoDetailsRepository;
  @MockBean private LoadableStudyRepository loadableStudyRepository;
  @MockBean private CargoNominationRepository cargoNominationRepository;
  @MockBean private ApiTempHistoryRepository apiTempHistoryRepository;
  @MockBean private LoadablePatternCargoToppingOffSequenceRepository toppingOffSequenceRepository;
  @MockBean private LoadableStudyAlgoStatusRepository loadableStudyAlgoStatusRepository;
  @MockBean private SynopticService synopticService;
  @MockBean private CargoNominationService cargoNominationService;

  DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);

  @Test
  void testFetchActiveVoyageByVesselId() {
    LoadableStudy.ActiveVoyage.Builder builder = LoadableStudy.ActiveVoyage.newBuilder();
    Long vesselId = 1L;
    Long activeStatus = 1L;
    Mockito.when(
            this.voyageRepository.findActiveVoyagesByVesselId(Mockito.anyLong(), Mockito.anyLong()))
        .thenReturn(getLV());
    Mockito.when(cargoNominationService.getCargoNominations(Mockito.anyLong()))
        .thenReturn(getLCN());
    Mockito.when(
            loadablePatternRepository.findConfirmedPatternByLoadableStudyId(
                Mockito.anyLong(), Mockito.anyLong()))
        .thenReturn(getLP());
    this.voyageService.fetchActiveVoyageByVesselId(builder, vesselId, activeStatus);
    assertEquals(1L, builder.getId());
  }

  private List<Voyage> getLV() {
    List<Voyage> voyages = new ArrayList<>();
    Voyage voyage = new Voyage();
    voyage.setId(1L);
    voyage.setVesselXId(1L);
    voyage.setActualEndDate(LocalDateTime.now());
    voyage.setActualStartDate(LocalDateTime.now());
    voyage.setVoyageStartDate(LocalDateTime.now());
    voyage.setVoyageEndDate(LocalDateTime.now());
    voyage.setVoyageNo("1");
    voyage.setVoyageStatus(getVS());
    voyage.setLoadableStudies(getLS());
    voyages.add(voyage);
    return voyages;
  }

  private VoyageStatus getVS() {
    VoyageStatus voyageStatus = new VoyageStatus();
    voyageStatus.setName("ACTIVE");
    voyageStatus.setId(1L);
    return voyageStatus;
  }

  private Set<com.cpdss.loadablestudy.entity.LoadableStudy> getLS() {
    Set<com.cpdss.loadablestudy.entity.LoadableStudy> loadableStudies = new HashSet<>();
    com.cpdss.loadablestudy.entity.LoadableStudy loadableStudy =
        new com.cpdss.loadablestudy.entity.LoadableStudy();
    loadableStudy.setLoadableStudyStatus(getLSS());
    loadableStudy.setId(1L);
    loadableStudy.setPlanningTypeXId(2);
    loadableStudy.setName("ACTIVE");
    loadableStudy.setDraftMark(new BigDecimal(1));
    loadableStudy.setCreatedDateTime(LocalDateTime.now());
    loadableStudy.setPortRotations(getPR());
    loadableStudies.add(loadableStudy);
    return loadableStudies;
  }

  private LoadableStudyStatus getLSS() {
    LoadableStudyStatus loadableStudyStatus = new LoadableStudyStatus();
    loadableStudyStatus.setId(1L);
    loadableStudyStatus.setName("CONFIRMED");
    return loadableStudyStatus;
  }

  private Set<LoadableStudyPortRotation> getPR() {
    Set<LoadableStudyPortRotation> loadableStudyPortRotations = new HashSet<>();
    LoadableStudyPortRotation loadableStudyPortRotation = new LoadableStudyPortRotation();
    loadableStudyPortRotation.setId(1L);
    loadableStudyPortRotation.setPortXId(1L);
    loadableStudyPortRotation.setPortOrder(1L);
    loadableStudyPortRotation.setBerthXId(1L);
    loadableStudyPortRotation.setOperation(getCO());
    loadableStudyPortRotation.setSeaWaterDensity(new BigDecimal(1));
    loadableStudyPortRotations.add(loadableStudyPortRotation);
    return loadableStudyPortRotations;
  }

  private List<CargoNomination> getLCN() {
    List<CargoNomination> list = new ArrayList<>();
    CargoNomination cargoNomination = new CargoNomination();
    cargoNomination.setCargoXId(1L);
    cargoNomination.setId(1L);
    cargoNomination.setApi(new BigDecimal(1));
    cargoNomination.setColor("1");
    cargoNomination.setQuantity(new BigDecimal(1));
    cargoNomination.setTemperature(new BigDecimal(1));
    cargoNomination.setCargoNominationPortDetails(getSCNPD());
    cargoNomination.setLastModifiedDateTime(LocalDateTime.now());
    list.add(cargoNomination);
    return list;
  }

  private CargoOperation getCO() {
    CargoOperation cargoOperation = new CargoOperation();
    cargoOperation.setId(1L);
    return cargoOperation;
  }

  private List<LoadablePattern> getLP() {
    List<LoadablePattern> list = new ArrayList<>();
    LoadablePattern loadablePattern = new LoadablePattern();
    loadablePattern.setId(1L);
    loadablePattern.setCaseNumber(1);
    loadablePattern.setLoadableStudyStatus(1L);
    list.add(loadablePattern);
    return list;
  }

  @Test
  void testCheckIfVoyageClosed() {
    Long voyageId = 1L;
    Mockito.when(this.voyageRepository.findByIdAndIsActive(Mockito.anyLong(), Mockito.anyBoolean()))
        .thenReturn(getVo());
    try {
      this.voyageService.checkIfVoyageClosed(voyageId);
    } catch (GenericServiceException e) {
      e.printStackTrace();
    }
  }

  private Voyage getVo() {
    Voyage voyage = new Voyage();
    voyage.setId(1L);
    voyage.setLoadableStudies(getLS());
    voyage.setVoyageStatus(getVS());
    return voyage;
  }

  @Test
  void testSaveVoyage() {
    LoadableStudy.VoyageRequest request =
        LoadableStudy.VoyageRequest.newBuilder()
            .setStartTimezoneId(1)
            .setEndTimezoneId(1)
            .setCaptainId(1L)
            .setEndDate("15-09-2021 05:34")
            .setStartDate("15-09-2021 05:34")
            .setChiefOfficerId(1L)
            .setCompanyId(1L)
            .setVesselId(1L)
            .setVoyageNo("1")
            .build();
    LoadableStudy.VoyageReply.Builder builder = LoadableStudy.VoyageReply.newBuilder();
    Mockito.when(
            voyageRepository.findByCompanyXIdAndVesselXIdAndVoyageNoIgnoreCase(
                Mockito.anyLong(), Mockito.anyLong(), Mockito.any()))
        .thenReturn(getLVe());
    Mockito.when(this.voyageStatusRepository.getOne(Mockito.anyLong())).thenReturn(getVS());
    Mockito.when(voyageRepository.save(Mockito.any())).thenReturn(getVo());
    this.voyageService.saveVoyage(request, builder);
    assertEquals(SUCCESS, builder.getResponseStatus().getStatus());
    assertEquals(1L, builder.getVoyageId());
    verify(voyageRepository).save(Mockito.any(Voyage.class));
  }

  private List<Voyage> getLVe() {
    List<Voyage> list = new ArrayList<>();
    return list;
  }

  @Test
  void testGetVoyagesByVessel() {
    LoadableStudy.VoyageRequest request =
        LoadableStudy.VoyageRequest.newBuilder().setVesselId(1L).build();
    LoadableStudy.VoyageListReply.Builder builder = LoadableStudy.VoyageListReply.newBuilder();
    Mockito.when(
            this.voyageRepository.findByVesselXIdAndIsActiveOrderByIdDesc(
                Mockito.anyLong(), Mockito.anyBoolean()))
        .thenReturn(getLV());
    Mockito.when(
            loadableStudyRepository.getLoadableStudyByVesselVoyagePlanningType(
                Mockito.anyLong(), Mockito.anyLong(), Mockito.anyInt()))
        .thenReturn(getOLS());
    var voyageListReply = this.voyageService.getVoyagesByVessel(request, builder);
    assertEquals(SUCCESS, builder.getResponseStatus().getStatus());
  }

  private Optional<List<com.cpdss.loadablestudy.entity.LoadableStudy>> getOLS() {
    List<com.cpdss.loadablestudy.entity.LoadableStudy> list = new ArrayList<>();
    com.cpdss.loadablestudy.entity.LoadableStudy loadableStudy =
        new com.cpdss.loadablestudy.entity.LoadableStudy();

    list.add(loadableStudy);
    return Optional.of(list);
  }

  @Test
  void testfindCargoHistoryForPrvsVoyage() {
    Voyage voyage = new Voyage();
    voyage.setVoyageEndDate(LocalDateTime.now());
    voyage.setVoyageStartDate(LocalDateTime.now());
    voyage.setVesselXId(1L);
    voyage.setVoyageNo("1");
    Mockito.when(this.voyageStatusRepository.getOne(Mockito.anyLong())).thenReturn(getVS());
    Mockito.when(
            this.voyageRepository
                .findFirstByVesselXIdAndIsActiveAndVoyageStatusOrderByLastModifiedDateDesc(
                    Mockito.anyLong(), Mockito.anyBoolean(), Mockito.any()))
        .thenReturn(voyage);
    var cargoHistory = this.voyageService.findCargoHistoryForPrvsVoyage(voyage);
    assertTrue(cargoHistory.isEmpty());
  }

  @Test
  void testsaveVoyageStatus() throws GenericServiceException {
    LoadableStudy.SaveVoyageStatusRequest request =
        LoadableStudy.SaveVoyageStatusRequest.newBuilder()
            .setActualStartDate("12-09-2021 11:23")
            .setStatus("START")
            .setVoyageId(1L)
            .build();
    LoadableStudy.SaveVoyageStatusReply.Builder replyBuilder =
        LoadableStudy.SaveVoyageStatusReply.newBuilder();
    Mockito.when(this.voyageRepository.findByIdAndIsActive(Mockito.anyLong(), Mockito.anyBoolean()))
        .thenReturn(getVo());
    Mockito.when(
            this.voyageRepository.findByVoyageStatusAndIsActive(
                Mockito.anyLong(), Mockito.anyBoolean()))
        .thenReturn(getLVe());
    Mockito.when(
            this.voyageStatusRepository.findByIdAndIsActive(
                Mockito.anyLong(), Mockito.anyBoolean()))
        .thenReturn(getOVS());
    Mockito.when(
            loadableStudyRepository.findByVoyageAndLoadableStudyStatusAndIsActiveAndPlanningTypeXId(
                Mockito.any(), Mockito.anyLong(), Mockito.anyBoolean(), Mockito.anyInt()))
        .thenReturn(getOLSS());
    Mockito.when(
            loadablePatternRepository.findByLoadableStudyAndLoadableStudyStatusAndIsActive(
                Mockito.any(), Mockito.anyLong(), Mockito.anyBoolean()))
        .thenReturn(getOLP());

    Mockito.when(
            cargoNominationRepository.findByLoadableStudyXIdAndIsActive(
                Mockito.anyLong(), Mockito.anyBoolean()))
        .thenReturn(getLCN());
    var result = voyageService.saveVoyageStatus(request, replyBuilder);
    assertEquals(SUCCESS, result.build().getResponseStatus().getStatus());
    verify(voyageRepository).save(any(Voyage.class));
  }

  @Test
  void testUpdateApiTempWithCargoNominations() {
    Voyage voyage = new Voyage();
    voyage.setVesselXId(1l);
    when(loadableStudyRepository.findByVoyageAndLoadableStudyStatusAndIsActiveAndPlanningTypeXId(
            any(Voyage.class), anyLong(), anyBoolean(), anyInt()))
        .thenReturn(getOLSS());
    when(loadablePatternRepository.findByLoadableStudyAndLoadableStudyStatusAndIsActive(
            any(getOLSS().get().getClass()), anyLong(), anyBoolean()))
        .thenReturn(getOLP());
    when(cargoNominationRepository.findByLoadableStudyXIdAndIsActive(anyLong(), anyBoolean()))
        .thenReturn(getLCN());
    voyageService.updateApiTempWithCargoNominations(voyage);
    verify(apiTempHistoryRepository).save(any(ApiTempHistory.class));
  }

  @Test
  void testsaveApiTempWithPortDetails() {
    voyageService.saveApiTempWithPortDetails(new ApiTempHistory());
    verify(apiTempHistoryRepository).save(any(ApiTempHistory.class));
  }

  @Test
  void testgetVoyages() throws GenericServiceException {
    VoyageService spyService = spy(VoyageService.class);
    LoadableStudy.VoyageListReply.Builder builder = LoadableStudy.VoyageListReply.newBuilder();
    LoadableStudy.VoyageRequest request =
        LoadableStudy.VoyageRequest.newBuilder()
            .setVesselId(1l)
            .setStartDate("dd-MM-yyyy")
            .setToStartDate("")
            .build();
    PortInfo.PortReply portReply =
        PortInfo.PortReply.newBuilder()
            .setResponseStatus(Common.ResponseStatus.newBuilder().setStatus(SUCCESS).build())
            .build();
    Mockito.doReturn(portReply).when(spyService).GetPortInfo(any(PortInfo.PortRequest.class));
    CargoInfo.CargoReply cargoReply =
        CargoInfo.CargoReply.newBuilder()
            .setResponseStatus(Common.ResponseStatus.newBuilder().setStatus(SUCCESS).build())
            .build();
    Mockito.doReturn(cargoReply).when(spyService).getCargoInfo(any(CargoInfo.CargoRequest.class));
    when(loadableStudyRepository.findByListOfVoyage(anyList())).thenReturn(getOLS().get());
    List<Object[]> list = new ArrayList<>();
    when(this.loadableStudyPortRotationRepository.getDistinctLoadingPorts(anyList()))
        .thenReturn(list);
    when(this.loadableStudyPortRotationRepository.getDistinctDischarigingPortsById(anyList()))
        .thenReturn(list);
    when(this.cargoNominationRepository.findByLoadableStudyIdIn(anyList())).thenReturn(list);
    when(voyageRepository.findByIsActiveAndVesselXIdAndActualStartDateBetween(
            anyBoolean(), anyLong(), any(LocalDate.class), any(LocalDate.class)))
        .thenReturn(getLVe());
    List<Voyage> voyageList = new ArrayList<>();
    when(voyageRepository
            .findByIsActiveAndVesselXIdOrderByVoyageStatusDescAndLastModifiedDateTimeDesc(
                anyBoolean(), anyLong()))
        .thenReturn(voyageList);
    ReflectionTestUtils.setField(spyService, "voyageRepository", voyageRepository);
    ReflectionTestUtils.setField(spyService, "loadableStudyRepository", loadableStudyRepository);
    ReflectionTestUtils.setField(
        spyService, "loadableStudyPortRotationRepository", loadableStudyPortRotationRepository);
    ReflectionTestUtils.setField(
        spyService, "cargoNominationRepository", cargoNominationRepository);

    var result = spyService.getVoyages(request, builder);
    assertEquals(SUCCESS, result.build().getResponseStatus().getStatus());
  }

  @Test
  void testBuildVoyageDetails() {
    ModelMapper modelMapper = new ModelMapper();
    com.cpdss.loadablestudy.domain.LoadableStudy loadableStudy =
        new com.cpdss.loadablestudy.domain.LoadableStudy();
    loadableStudy.setVoyageId(1l);
    Voyage voyage = new Voyage();
    voyage.setId(1l);
    when(this.voyageRepository.findByIdAndIsActive(anyLong(), anyBoolean())).thenReturn(voyage);
    voyageService.buildVoyageDetails(modelMapper, loadableStudy);
    assertEquals(1l, loadableStudy.getVoyage().getId().longValue());
  }

  private Optional<VoyageStatus> getOVS() {
    VoyageStatus voyageStatus = new VoyageStatus();
    voyageStatus.setId(1L);
    return Optional.of(voyageStatus);
  }

  private Optional<com.cpdss.loadablestudy.entity.LoadableStudy> getOLSS() {
    com.cpdss.loadablestudy.entity.LoadableStudy loadableStudy =
        new com.cpdss.loadablestudy.entity.LoadableStudy();
    loadableStudy.setId(1L);
    return Optional.of(loadableStudy);
  }

  private Optional<LoadablePattern> getOLP() {
    LoadablePattern loadablePattern = new LoadablePattern();
    loadablePattern.setLoadableStudyStatus(1L);
    loadablePattern.setId(1L);
    return Optional.of(loadablePattern);
  }

  private Set<CargoNominationPortDetails> getSCNPD() {
    Set<CargoNominationPortDetails> set = new HashSet<>();
    CargoNominationPortDetails cargoNominationPortDetails = new CargoNominationPortDetails();
    cargoNominationPortDetails.setPortId(1L);
    set.add(cargoNominationPortDetails);
    return set;
  }
}