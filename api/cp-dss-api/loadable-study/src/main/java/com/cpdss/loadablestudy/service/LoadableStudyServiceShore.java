/* Licensed at AlphaOri Technologies */
package com.cpdss.loadablestudy.service;

import static org.springframework.util.StringUtils.isEmpty;

import com.cpdss.common.exception.GenericServiceException;
import com.cpdss.common.generated.EnvoyReader;
import com.cpdss.common.generated.EnvoyReaderServiceGrpc;
import com.cpdss.common.rest.CommonErrorCodes;
import com.cpdss.common.utils.HttpStatusCode;
import com.cpdss.loadablestudy.domain.MessageTypes;
import com.cpdss.loadablestudy.entity.*;
import com.cpdss.loadablestudy.repository.*;
import com.google.gson.Gson;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import lombok.extern.log4j.Log4j2;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Log4j2
@Service
@Transactional
public class LoadableStudyServiceShore extends LoadableStudyService {
  @Value("${loadablestudy.attachement.rootFolder}")
  private String rootFolder;

  @GrpcClient("envoyReaderService")
  private EnvoyReaderServiceGrpc.EnvoyReaderServiceBlockingStub envoyReaderGrpcService;

  @Autowired private CommingleCargoRepository commingleCargoRepository;
  @Autowired private LoadableQuantityRepository loadableQuantityRepository;
  @Autowired private CargoNominationRepository cargoNominationRepository;
  @Autowired private VoyageRepository voyageRepository;
  @Autowired private LoadableStudyRepository loadableStudyRepository;
  @Autowired private LoadableStudyService loadableStudyService;
  @Autowired private OnHandQuantityRepository onHandQuantityRepository;
  @Autowired private OnBoardQuantityRepository onBoardQuantityRepository;

  public void getDataFromEnvoyReaderShore(String patternJson) throws GenericServiceException {
    /*EnvoyReader.EnvoyReaderResultReply erReply = getResultFromEnvoyReaderShore();
    if (!LoadableStudiesConstants.SUCCESS.equals(erReply.getResponseStatus().getStatus())) {
      throw new GenericServiceException(
          "Failed to get Result from Communication Server",
          erReply.getResponseStatus().getCode(),
          HttpStatusCode.valueOf(Integer.valueOf(erReply.getResponseStatus().getCode())));
    }*/
    // String jsonResult = erReply.getPatternResultJson();
    String jsonResult = patternJson;
    com.cpdss.loadablestudy.domain.LoadableStudy loadableStudy =
        new Gson().fromJson(jsonResult, com.cpdss.loadablestudy.domain.LoadableStudy.class);

    Voyage voyage = saveVoyageShore(loadableStudy.getVoyageId(), loadableStudy.getVoyageNo());
    if (null != checkIfLoadableStudyExist(loadableStudy.getName(), voyage)) {

    } else {

      try {
        LoadableStudy loadableStudyEntity = saveLoadableStudyShore(loadableStudy, voyage);
        saveLoadableStudyDataShore(loadableStudyEntity, loadableStudy);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  private EnvoyReader.EnvoyReaderResultReply getResultFromEnvoyReaderShore() {
    EnvoyReader.EnvoyReaderResultRequest.Builder request =
        EnvoyReader.EnvoyReaderResultRequest.newBuilder();
    request.setMessageType(String.valueOf(MessageTypes.LOADABLESTUDY));
    return this.envoyReaderGrpcService.getResultFromCommServer(request.build());
  }

  private void saveLoadableStudyDataShore(
      LoadableStudy loadableStudyEntity,
      com.cpdss.loadablestudy.domain.LoadableStudy loadableStudy) {

    List<CommingleCargo> commingleEntities = new ArrayList<>();
    loadableStudy
        .getCommingleCargos()
        .forEach(
            commingleCargo -> {
              try {
                com.cpdss.loadablestudy.entity.CommingleCargo commingleCargoEntity = null;
                if (commingleCargo != null && commingleCargo.getId() != 0) {
                  Optional<CommingleCargo> existingCommingleCargo =
                      this.commingleCargoRepository.findByIdAndIsActive(
                          commingleCargo.getId(), true);
                  if (!existingCommingleCargo.isPresent()) {
                    throw new GenericServiceException(
                        "commingle cargo does not exist",
                        CommonErrorCodes.E_HTTP_BAD_REQUEST,
                        HttpStatusCode.BAD_REQUEST);
                  }
                  commingleCargoEntity = existingCommingleCargo.get();
                  commingleCargoEntity =
                      buildCommingleCargoShore(
                          commingleCargoEntity, commingleCargo, loadableStudyEntity.getId());
                } else if (commingleCargo != null && commingleCargo.getId() == 0) {
                  commingleCargoEntity = new com.cpdss.loadablestudy.entity.CommingleCargo();
                  commingleCargoEntity =
                      buildCommingleCargoShore(
                          commingleCargoEntity, commingleCargo, loadableStudyEntity.getId());
                }

                commingleEntities.add(commingleCargoEntity);
              } catch (Exception e) {
                log.error("Exception in creating entities for save commingle cargo", e);
                throw new RuntimeException(e);
              }
            });
    this.commingleCargoRepository.saveAll(commingleEntities);

    List<CargoNomination> cargoNominationEntities = new ArrayList<>();
    loadableStudy.getCargoNomination().stream()
        .forEach(
            cargoNom -> {
              CargoNomination cargoNomination = new CargoNomination();
              cargoNomination = buildCargoNomination(cargoNomination, cargoNom);
              // apiTempHistory = buildApiTempHistory(cargoNomination, cargoNom,
              // existingCargoPortIds);
              cargoNominationEntities.add(cargoNomination);
            });
    this.cargoNominationRepository.saveAll(cargoNominationEntities);

    List<OnHandQuantity> onHandQuantityEntities = new ArrayList<>();
    loadableStudy.getOnHandQuantity().stream()
        .forEach(
            onHandQuantity -> {
              OnHandQuantity onHandQuantityEntity = new OnHandQuantity();
              onHandQuantityEntity.setLoadableStudy(loadableStudyEntity);
              onHandQuantityEntity = buildOnHandQuantity(onHandQuantityEntity, onHandQuantity);
              onHandQuantityEntities.add(onHandQuantityEntity);
            });
    this.onHandQuantityRepository.saveAll(onHandQuantityEntities);
    List<OnBoardQuantity> onBoardQuantityEntities = new ArrayList<>();
    loadableStudy.getOnBoardQuantity().stream()
        .forEach(
            onBoardQuantity -> {
              OnBoardQuantity onBoardQuantityEntity = new OnBoardQuantity();
              onBoardQuantityEntity.setLoadableStudy(loadableStudyEntity);
              onBoardQuantityEntity =
                  buildOnBoardQuantityEntity(onBoardQuantityEntity, onBoardQuantity);
              onBoardQuantityEntities.add(onBoardQuantityEntity);
            });
    this.onBoardQuantityRepository.saveAll(onBoardQuantityEntities);
    com.cpdss.loadablestudy.domain.LoadableQuantity loadableQuantityDomain =
        loadableStudy.getLoadableQuantity();
    if (null != loadableQuantityDomain) {
      LoadableQuantity loadableQuantity = new LoadableQuantity();
      loadableQuantity.setLoadableStudyXId(loadableStudyEntity);
      loadableQuantity.setConstant(
          StringUtils.isEmpty(loadableQuantityDomain.getConstant())
              ? null
              : new BigDecimal(loadableQuantityDomain.getConstant()));
      /* loadableQuantity.setDeadWeight(
      StringUtils.isEmpty(loadableQuantityDomain.getDwt())
              ? null
              : new BigDecimal(loadableQuantityDomain.getDwt()));*/

      loadableQuantity.setDisplacementAtDraftRestriction(
          StringUtils.isEmpty(loadableQuantityDomain.getDisplacmentDraftRestriction())
              ? null
              : new BigDecimal(loadableQuantityDomain.getDisplacmentDraftRestriction()));
      loadableQuantity.setDistanceFromLastPort(
          StringUtils.isEmpty(loadableQuantityDomain.getDistanceFromLastPort())
              ? null
              : new BigDecimal(loadableQuantityDomain.getDistanceFromLastPort()));

      loadableQuantity.setEstimatedDOOnBoard(
          StringUtils.isEmpty(loadableQuantityDomain.getEstDOOnBoard())
              ? null
              : new BigDecimal(loadableQuantityDomain.getEstDOOnBoard()));

      loadableQuantity.setEstimatedFOOnBoard(
          StringUtils.isEmpty(loadableQuantityDomain.getEstFOOnBoard())
              ? null
              : new BigDecimal(loadableQuantityDomain.getEstFOOnBoard()));
      loadableQuantity.setEstimatedFWOnBoard(
          StringUtils.isEmpty(loadableQuantityDomain.getEstFreshWaterOnBoard())
              ? null
              : new BigDecimal(loadableQuantityDomain.getEstFreshWaterOnBoard()));
      loadableQuantity.setEstimatedSagging(
          StringUtils.isEmpty(loadableQuantityDomain.getEstSagging())
              ? null
              : new BigDecimal(loadableQuantityDomain.getEstSagging()));

      loadableQuantity.setEstimatedSeaDensity(
          StringUtils.isEmpty(loadableQuantityDomain.getEstSeaDensity())
              ? null
              : new BigDecimal(loadableQuantityDomain.getEstSeaDensity()));

      loadableQuantity.setLightWeight(
          StringUtils.isEmpty(loadableQuantityDomain.getVesselLightWeight())
              ? null
              : new BigDecimal(loadableQuantityDomain.getVesselLightWeight()));

      loadableQuantity.setOtherIfAny(
          StringUtils.isEmpty(loadableQuantityDomain.getOtherIfAny())
              ? null
              : new BigDecimal(loadableQuantityDomain.getOtherIfAny()));
      loadableQuantity.setSaggingDeduction(
          StringUtils.isEmpty(loadableQuantityDomain.getSaggingDeduction())
              ? null
              : new BigDecimal(loadableQuantityDomain.getSaggingDeduction()));

      loadableQuantity.setSgCorrection(
          StringUtils.isEmpty(loadableQuantityDomain.getSgCorrection())
              ? null
              : new BigDecimal(loadableQuantityDomain.getSgCorrection()));

      loadableQuantity.setTotalQuantity(
          StringUtils.isEmpty(loadableQuantityDomain.getTotalQuantity())
              ? null
              : new BigDecimal(loadableQuantityDomain.getTotalQuantity()));
      loadableQuantity.setTpcatDraft(
          StringUtils.isEmpty(loadableQuantityDomain.getTpc())
              ? null
              : new BigDecimal(loadableQuantityDomain.getTpc()));

      loadableQuantity.setVesselAverageSpeed(
          StringUtils.isEmpty(loadableQuantityDomain.getVesselAverageSpeed())
              ? null
              : new BigDecimal(loadableQuantityDomain.getVesselAverageSpeed()));

      loadableQuantity.setPortId(
          StringUtils.isEmpty(loadableQuantityDomain.getPortId())
              ? null
              : new BigDecimal(loadableQuantityDomain.getPortId()));
      loadableQuantity.setBoilerWaterOnBoard(
          StringUtils.isEmpty(loadableQuantityDomain.getBoilerWaterOnBoard())
              ? null
              : new BigDecimal(loadableQuantityDomain.getBoilerWaterOnBoard()));
      loadableQuantity.setBallast(
          StringUtils.isEmpty(loadableQuantityDomain.getBallast())
              ? null
              : new BigDecimal(loadableQuantityDomain.getBallast()));
      loadableQuantity.setRunningHours(
          StringUtils.isEmpty(loadableQuantityDomain.getRunningHours())
              ? null
              : new BigDecimal(loadableQuantityDomain.getRunningHours()));
      loadableQuantity.setRunningDays(
          StringUtils.isEmpty(loadableQuantityDomain.getRunningDays())
              ? null
              : new BigDecimal(loadableQuantityDomain.getRunningDays()));
      loadableQuantity.setFoConsumptionInSZ(
          StringUtils.isEmpty(loadableQuantityDomain.getFoConInSZ())
              ? null
              : new BigDecimal(loadableQuantityDomain.getFoConInSZ()));
      loadableQuantity.setDraftRestriction(
          StringUtils.isEmpty(loadableQuantityDomain.getDraftRestriction())
              ? null
              : new BigDecimal(loadableQuantityDomain.getDraftRestriction()));

      loadableQuantity.setSubTotal(
          StringUtils.isEmpty(loadableQuantityDomain.getSubTotal())
              ? null
              : new BigDecimal(loadableQuantityDomain.getSubTotal()));
      loadableQuantity.setFoConsumptionPerDay(
          StringUtils.isEmpty(loadableQuantityDomain.getFoConsumptionPerDay())
              ? null
              : new BigDecimal(loadableQuantityDomain.getFoConsumptionPerDay()));
      loadableQuantity.setIsActive(true);

      /*if (loadableQuantityDomain.getPortRotationId() > 0) {
        log.info(
                "Save Loadable Quantity, port rotation id : {}",
                loadableQuantityDomain.getPortRotationId());
        long id = loadableQuantityDomain.getPortRotationId();
        LoadableStudyPortRotation lsPortRot =
                loadableStudyPortRotationRepository.findByIdAndIsActive(id, true);
        if (lsPortRot != null) {
          loadableQuantity.setLoadableStudyPortRotation(lsPortRot);
        }
      }*/
      this.loadableQuantityRepository.save(loadableQuantity);
    }
  }

  private OnBoardQuantity buildOnBoardQuantityEntity(
      OnBoardQuantity entity, com.cpdss.loadablestudy.domain.OnBoardQuantity request) {
    entity.setCargoId(0 == request.getCargoId() ? null : request.getCargoId());
    entity.setTankId(request.getTankId());
    entity.setPortId(request.getPortId());

    entity.setVolumeInM3(request.getVolume());
    entity.setColorCode(isEmpty(request.getColorCode()) ? null : request.getColorCode());

    entity.setIsActive(true);
    return entity;
  }

  private OnHandQuantity buildOnHandQuantity(
      OnHandQuantity entity, com.cpdss.loadablestudy.domain.OnHandQuantity request) {
    entity.setIsActive(true);
    entity.setFuelTypeXId(0 == request.getFueltypeId() ? null : request.getFueltypeId());
    entity.setTankXId(0 == request.getTankId() ? null : request.getTankId());
    entity.setArrivalQuantity(
        isEmpty(request.getArrivalQuantity())
            ? null
            : new BigDecimal(request.getArrivalQuantity()));
    entity.setArrivalVolume(
        isEmpty(request.getArrivalVolume()) ? null : new BigDecimal(request.getArrivalVolume()));
    entity.setDepartureQuantity(
        isEmpty(request.getDepartureQuantity())
            ? null
            : new BigDecimal(request.getDepartureQuantity()));
    entity.setDepartureVolume(
        isEmpty(request.getDepartureVolume())
            ? null
            : new BigDecimal(request.getDepartureVolume()));
    // entity.setDensity(isEmpty(request.getDensity()) ? null : new
    // BigDecimal(request.getDensity()));
    return entity;
  }

  private CargoNomination buildCargoNomination(
      CargoNomination cargoNomination, com.cpdss.loadablestudy.domain.CargoNomination request) {
    cargoNomination.setLoadableStudyXId(request.getLoadableStudyId());
    cargoNomination.setPriority(request.getPriority());
    cargoNomination.setCargoXId(request.getCargoId());
    cargoNomination.setAbbreviation(request.getAbbreviation());
    cargoNomination.setColor(request.getColor());
    cargoNomination.setQuantity(
        !StringUtils.isEmpty(request.getQuantity())
            ? new BigDecimal(String.valueOf(request.getQuantity()))
            : null);
    cargoNomination.setMaxTolerance(
        !StringUtils.isEmpty(request.getMaxTolerance())
            ? new BigDecimal(String.valueOf(request.getMaxTolerance()))
            : null);
    cargoNomination.setMinTolerance(
        !StringUtils.isEmpty(request.getMinTolerance())
            ? new BigDecimal(String.valueOf(request.getMinTolerance()))
            : null);

    cargoNomination.setSegregationXId(request.getSegregationId());
    // activate the records to be saved
    cargoNomination.setIsActive(true);

    return cargoNomination;
  }

  private com.cpdss.loadablestudy.entity.CommingleCargo buildCommingleCargoShore(
      com.cpdss.loadablestudy.entity.CommingleCargo commingleCargoEntity,
      com.cpdss.loadablestudy.domain.CommingleCargo commingleCargo,
      Long id) {
    List<Long> cargoNominationIds = new ArrayList<>();
    cargoNominationIds.add(commingleCargo.getCargoNomination1Id());
    cargoNominationIds.add(commingleCargo.getCargoNomination2Id());
    // fetch the max priority for the cargoNomination ids and set as priority for
    // commingle
    Long maxPriority =
        cargoNominationRepository.getMaxPriorityCargoNominationIn(cargoNominationIds);
    commingleCargoEntity.setPriority(maxPriority != null ? maxPriority.intValue() : null);
    commingleCargoEntity.setCargoNomination1Id(commingleCargo.getCargoNomination1Id());
    commingleCargoEntity.setCargoNomination2Id(commingleCargo.getCargoNomination2Id());
    commingleCargoEntity.setLoadableStudyXId(id);
    // commingleCargoEntity.setPurposeXid(commingleCargo.getPurposeId());
    /* commingleCargoEntity.setTankIds(
              StringUtils.collectionToCommaDelimitedString(commingleCargo.getPreferredTanksList()));
    */
    commingleCargoEntity.setCargo1Xid(commingleCargo.getCargo1Id());
    /* commingleCargoEntity.setCargo1Pct(
    !StringUtils.isEmpty(commingleCargo.getCargo1Pct())
            ? new BigDecimal(commingleCargo.getCargo1Pct())
            : null);*/
    commingleCargoEntity.setCargo2Xid(commingleCargo.getCargo2Id());
    /* commingleCargoEntity.setCargo2Pct(
    !StringUtils.isEmpty(commingleCargo.getCargo2Pct())
            ? new BigDecimal(commingleCargo.getCargo2Pct())
            : null);*/
    commingleCargoEntity.setQuantity(
        !StringUtils.isEmpty(commingleCargo.getQuantity())
            ? new BigDecimal(commingleCargo.getQuantity())
            : null);
    commingleCargoEntity.setIsActive(true);
    // commingleCargoEntity.setIsSlopOnly(commingleCargo.getSlopOnly());
    return commingleCargoEntity;
  }

  private LoadableStudy checkIfLoadableStudyExist(String name, Voyage voyage) {
    LoadableStudy duplicate =
        this.loadableStudyRepository.findByVoyageAndNameIgnoreCaseAndIsActive(voyage, name, true);
    return duplicate;
  }

  private Voyage saveVoyageShore(Long vesselId, String voyageNo) {
    Voyage voyage =
        voyageRepository
            .findByCompanyXIdAndVesselXIdAndVoyageNoIgnoreCase(1L, vesselId, voyageNo)
            .get(0);
    if (voyage != null) {
      return voyage;
    } else {
      voyage = new Voyage();
      voyage.setVoyageNo(voyageNo);
      voyage.setVesselXId(vesselId);
      voyage = voyageRepository.save(voyage);
      return voyage;
    }
  }

  private LoadableStudy saveLoadableStudyShore(
      com.cpdss.loadablestudy.domain.LoadableStudy loadableStudy, Voyage voyage)
      throws IOException {
    LoadableStudy entity = new LoadableStudy();
    entity.setVesselXId(loadableStudy.getVesselId());
    entity.setVoyage(voyage);
    entity.setName(loadableStudy.getName());
    entity.setDetails(loadableStudy.getDetails());
    entity.setCharterer(loadableStudy.getCharterer());
    entity.setSubCharterer(loadableStudy.getSubCharterer());
    entity.setDraftMark(new BigDecimal(loadableStudy.getDraftMark()));
    entity.setLoadLineXId(loadableStudy.getLoadlineId());
    entity.setDraftRestriction(new BigDecimal(loadableStudy.getDraftRestriction()));
    entity.setEstimatedMaxSag(new BigDecimal(loadableStudy.getEstimatedMaxSG()));
    entity.setMaxAirTemperature(new BigDecimal(loadableStudy.getMaxAirTemp()));
    entity.setMaxWaterTemperature(new BigDecimal(loadableStudy.getMaxWaterTemp()));
    entity.setActive(true);
    /*entity.setCaseNo(loadableStudy.getC);
    entity.setDischargeCargoId(loadableStudy.getD);*/
    entity.setLoadOnTop(loadableStudy.getLoadOnTop());
    /*entity.setIsCargoNominationComplete(loadableStudy.getIsCargoNominationComplete());
    entity.setIsDischargePortsComplete(loadableStudy.getIsDischargePortsComplete());
    entity.setIsObqComplete(loadableStudy.getIsObqComplete());
    entity.setIsOhqComplete(loadableStudy.getIsOhqComplete());
    entity.setIsPortsComplete(loadableStudy.getIsPortsComplete());*/
    Set<LoadableStudyAttachments> attachmentCollection = new HashSet<>();
    if (!loadableStudy.getLoadableStudyAttachment().isEmpty()) {
      String folderLocation = loadableStudyService.constructFolderPath(entity);
      Files.createDirectories(Paths.get(this.rootFolder + folderLocation));
      for (com.cpdss.loadablestudy.domain.LoadableStudyAttachment attachment :
          loadableStudy.getLoadableStudyAttachment()) {
        String fileName =
            attachment.getFileName().substring(0, attachment.getFileName().lastIndexOf("."));
        String extension =
            attachment
                .getFileName()
                .substring(attachment.getFileName().lastIndexOf("."))
                .toLowerCase();
        String filePath = folderLocation + fileName + "_" + System.currentTimeMillis() + extension;
        Path path = Paths.get(this.rootFolder + filePath);
        Files.createFile(path);
        Files.write(path, attachment.getContent());
        LoadableStudyAttachments attachmentEntity = new LoadableStudyAttachments();
        attachmentEntity.setUploadedFileName(attachment.getFileName());
        attachmentEntity.setFilePath(filePath);
        attachmentEntity.setLoadableStudy(entity);
        attachmentEntity.setIsActive(true);
        attachmentCollection.add(attachmentEntity);
      }
      entity.setAttachments(attachmentCollection);
    }
    entity = this.loadableStudyRepository.save(entity);
    return entity;
  }
}
