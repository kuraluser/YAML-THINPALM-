/* Licensed at AlphaOri Technologies */
package com.cpdss.loadablestudy.service;

import static com.cpdss.loadablestudy.utility.LoadableStudiesConstants.*;

import com.cpdss.common.exception.GenericServiceException;
import com.cpdss.common.generated.LoadableStudy.LoadableQuantityResponse;
import com.cpdss.common.generated.VesselInfo;
import com.cpdss.common.generated.VesselInfoServiceGrpc;
import com.cpdss.common.rest.CommonErrorCodes;
import com.cpdss.common.utils.HttpStatusCode;
import com.cpdss.loadablestudy.entity.LoadableQuantity;
import com.cpdss.loadablestudy.entity.LoadableStudy;
import com.cpdss.loadablestudy.entity.OnHandQuantity;
import com.cpdss.loadablestudy.repository.LoadableQuantityRepository;
import com.cpdss.loadablestudy.repository.LoadableStudyRepository;
import com.cpdss.loadablestudy.repository.OnHandQuantityRepository;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Master Service for Loadable Studies
 *
 * @author johnsooraj.x
 * @since 08-04-2021
 */
@Slf4j
@Service
public class LoadableQuantityService {

  @Autowired LoadableQuantityRepository loadableQuantityRepository;

  @Autowired LoadableStudyRepository loadableStudyRepository;

  @Autowired OnHandQuantityRepository onHandQuantityRepository;

  @Autowired PortRotationService portRotationService;

  @GrpcClient("vesselInfoService")
  private VesselInfoServiceGrpc.VesselInfoServiceBlockingStub vesselInfoGrpcService;

  public LoadableQuantityResponse.Builder loadableQuantityByPortId(
      LoadableQuantityResponse.Builder builder, Long loadableStudyId, Long portRotationId)
      throws GenericServiceException {

    Optional<LoadableQuantity> loadableQuantity =
        loadableQuantityRepository.findByLSIdAndPortRotationId(
            loadableStudyId, portRotationId, true);

    Optional<LoadableStudy> loadableStudy =
        loadableStudyRepository.findByIdAndIsActive(loadableStudyId, true);
    if (!loadableStudy.isPresent()) {
      log.info(INVALID_LOADABLE_STUDY_ID, loadableStudyId);
      throw new GenericServiceException(
          INVALID_LOADABLE_QUANTITY,
          CommonErrorCodes.E_HTTP_BAD_REQUEST,
          HttpStatusCode.BAD_REQUEST);
    }

    Map<Long, Long> portRIds = portRotationService.getPortRotationIdAndPortIds(loadableStudy.get());
    BigDecimal foOnboard = BigDecimal.ZERO;
    BigDecimal doOnboard = BigDecimal.ZERO;
    BigDecimal freshWaterOnBoard = BigDecimal.ZERO;
    BigDecimal boileWaterOnBoard = BigDecimal.ZERO;

    if (!portRIds.isEmpty() && portRIds.get(portRotationId) != null) {
      List<OnHandQuantity> onHandQuantityList =
          this.onHandQuantityRepository.findByLoadableStudyAndIsActive(loadableStudy.get(), true);
      if (!onHandQuantityList.isEmpty()) {
        foOnboard =
            onHandQuantityList.stream()
                .filter(
                    ohq ->
                        null != ohq.getFuelTypeXId()
                            && null != ohq.getPortRotation()
                            && ohq.getFuelTypeXId().equals(FUEL_OIL_TANK_CATEGORY_ID)
                            && ohq.getPortRotation().getId().equals(portRotationId)
                            && ohq.getIsActive())
                .map(OnHandQuantity::getArrivalQuantity)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        doOnboard =
            onHandQuantityList.stream()
                .filter(
                    ohq ->
                        null != ohq.getFuelTypeXId()
                            && null != ohq.getPortRotation()
                            && ohq.getFuelTypeXId().equals(DIESEL_OIL_TANK_CATEGORY_ID)
                            && ohq.getPortRotation().getId().equals(portRotationId)
                            && ohq.getIsActive())
                .map(OnHandQuantity::getArrivalQuantity)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        freshWaterOnBoard =
            onHandQuantityList.stream()
                .filter(
                    ohq ->
                        null != ohq.getFuelTypeXId()
                            && null != ohq.getPortRotation()
                            && ohq.getFuelTypeXId().equals(FRESH_WATER_TANK_CATEGORY_ID)
                            && ohq.getPortRotation().getId() == portRotationId
                            && ohq.getIsActive())
                .map(OnHandQuantity::getArrivalQuantity)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        boileWaterOnBoard =
            onHandQuantityList.stream()
                .filter(
                    ohq ->
                        ohq.getFuelTypeXId().equals(FRESH_WATER_TANK_CATEGORY_ID)
                            && null != ohq.getPortRotation()
                            && ohq.getPortRotation().getId().equals(portRotationId)
                            && ohq.getIsActive())
                .map(OnHandQuantity::getArrivalQuantity)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
      }
    }

    VesselInfo.VesselRequest replyBuilder =
        VesselInfo.VesselRequest.newBuilder()
            .setVesselId(loadableStudy.get().getVesselXId())
            .setVesselDraftConditionId(loadableStudy.get().getLoadLineXId())
            .setDraftExtreme(loadableStudy.get().getDraftMark().toString())
            .build();
    VesselInfo.VesselReply vesselReply = this.getVesselDetailsById(replyBuilder);
    String selectedZone = "";
    if (vesselReply.getVesselLoadableQuantityDetails().getDraftConditionName() != null) {
      String[] array =
          vesselReply.getVesselLoadableQuantityDetails().getDraftConditionName().split(" ");
      selectedZone = array[array.length - 1];
    }
    builder.setCaseNo(loadableStudy.get().getCaseNo());
    builder.setSelectedZone(selectedZone);

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
    String lastUpdatedTime = null;
    List<LocalDateTime> lastUpdateTimeList = new ArrayList<>();
    if (loadableQuantity.isPresent()) {
      lastUpdateTimeList.add(loadableQuantity.get().getLastModifiedDateTime());
    }
    if (loadableStudy.isPresent()) {
      lastUpdateTimeList.add(loadableStudy.get().getLastModifiedDateTime());
    }
    LocalDateTime maxOne = Collections.max(lastUpdateTimeList);
    lastUpdatedTime = formatter.format(maxOne);

    if (!loadableQuantity.isPresent()) {
      String draftRestictoin = "";
      if (Optional.ofNullable(loadableStudy.get().getDraftRestriction()).isPresent()) {
        draftRestictoin = loadableStudy.get().getDraftRestriction().toString();
      } else if (Optional.ofNullable(loadableStudy.get().getDraftMark()).isPresent()) {
        draftRestictoin = loadableStudy.get().getDraftMark().toString();
      }
      com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequest loadableQuantityRequest =
          com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequest.newBuilder()
              .setDisplacmentDraftRestriction(
                  vesselReply.getVesselLoadableQuantityDetails().getDisplacmentDraftRestriction())
              .setVesselLightWeight(
                  vesselReply.getVesselLoadableQuantityDetails().getVesselLightWeight())
              .setConstant(vesselReply.getVesselLoadableQuantityDetails().getConstant())
              .setTpc(vesselReply.getVesselLoadableQuantityDetails().getTpc())
              .setDraftRestriction(draftRestictoin)
              .setDwt(vesselReply.getVesselLoadableQuantityDetails().getDwt())
              .setEstFOOnBoard(String.valueOf(foOnboard))
              .setEstDOOnBoard(String.valueOf(doOnboard))
              .setEstFreshWaterOnBoard(String.valueOf(freshWaterOnBoard))
              .setBoilerWaterOnBoard(String.valueOf(boileWaterOnBoard))
              .setLastUpdatedTime(lastUpdatedTime)
              .setPortRotationId(portRotationId)
              .build();
      builder.setLoadableQuantityRequest(loadableQuantityRequest);
    } else {

      com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequest.Builder
          loadableQuantityRequest =
              com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequest.newBuilder();
      loadableQuantityRequest.setLastUpdatedTime(lastUpdatedTime);
      loadableQuantityRequest.setPortRotationId(portRotationId);
      loadableQuantityRequest.setId(loadableQuantity.get().getId());
      Optional.ofNullable(loadableQuantity.get().getDisplacementAtDraftRestriction())
          .ifPresent(
              disp -> loadableQuantityRequest.setDisplacmentDraftRestriction(disp.toString()));
      Optional.ofNullable(loadableQuantity.get().getConstant())
          .ifPresent(cons -> loadableQuantityRequest.setConstant(cons.toString()));
      Optional.ofNullable(loadableQuantity.get().getDraftRestriction())
          .ifPresent(
              draftRestriction ->
                  loadableQuantityRequest.setDraftRestriction(draftRestriction.toString()));
      Optional.ofNullable(loadableQuantity.get().getDistanceFromLastPort())
          .ifPresent(dist -> loadableQuantityRequest.setDistanceFromLastPort(dist.toString()));
      Optional.ofNullable(loadableQuantity.get().getDeadWeight())
          .ifPresent(deadWeight -> loadableQuantityRequest.setDwt(deadWeight.toString()));

      loadableQuantityRequest.setEstFOOnBoard(String.valueOf(foOnboard));
      loadableQuantityRequest.setEstDOOnBoard(String.valueOf(doOnboard));
      loadableQuantityRequest.setEstFreshWaterOnBoard(String.valueOf(freshWaterOnBoard));
      loadableQuantityRequest.setBoilerWaterOnBoard(String.valueOf(boileWaterOnBoard));

      Optional.ofNullable(loadableQuantity.get().getEstimatedSagging())
          .ifPresent(estSagging -> loadableQuantityRequest.setEstSagging(estSagging.toString()));
      Optional.ofNullable(loadableQuantity.get().getEstimatedSeaDensity())
          .ifPresent(
              estSeaDensity -> loadableQuantityRequest.setEstSeaDensity(estSeaDensity.toString()));
      Optional.ofNullable(loadableQuantity.get().getOtherIfAny())
          .ifPresent(otherIfAny -> loadableQuantityRequest.setOtherIfAny(otherIfAny.toString()));
      Optional.ofNullable(loadableQuantity.get().getSaggingDeduction())
          .ifPresent(
              saggingDeduction ->
                  loadableQuantityRequest.setSaggingDeduction(saggingDeduction.toString()));
      Optional.ofNullable(loadableQuantity.get().getSgCorrection())
          .ifPresent(
              sgCorrection -> loadableQuantityRequest.setSgCorrection(sgCorrection.toString()));
      Optional.ofNullable(loadableQuantity.get().getTotalQuantity())
          .ifPresent(
              totalQuantity -> loadableQuantityRequest.setTotalQuantity(totalQuantity.toString()));
      Optional.ofNullable(loadableQuantity.get().getTpcatDraft())
          .ifPresent(tpc -> loadableQuantityRequest.setTpc(tpc.toString()));
      Optional.ofNullable(loadableQuantity.get().getVesselAverageSpeed())
          .ifPresent(
              vesselAverageSpeed ->
                  loadableQuantityRequest.setVesselAverageSpeed(vesselAverageSpeed.toString()));
      Optional.ofNullable(loadableQuantity.get().getLightWeight())
          .ifPresent(
              vesselLightWeight ->
                  loadableQuantityRequest.setVesselLightWeight(vesselLightWeight.toString()));
      Optional.ofNullable(loadableQuantity.get().getLastModifiedDateTime())
          .ifPresent(
              updateDateAndTime ->
                  loadableQuantityRequest.setUpdateDateAndTime(
                      DateTimeFormatter.ofPattern(DATE_FORMAT).format(updateDateAndTime)));
      Optional.ofNullable(loadableQuantity.get().getPortId())
          .ifPresent(portId -> loadableQuantityRequest.setPortId(portId.longValue()));

      Optional.ofNullable(loadableQuantity.get().getBallast())
          .ifPresent(ballast -> loadableQuantityRequest.setBallast(ballast.toString()));
      Optional.ofNullable(loadableQuantity.get().getRunningHours())
          .ifPresent(
              runningHours -> loadableQuantityRequest.setRunningHours(runningHours.toString()));
      Optional.ofNullable(loadableQuantity.get().getRunningDays())
          .ifPresent(runningDays -> loadableQuantityRequest.setRunningDays(runningDays.toString()));
      Optional.ofNullable(loadableQuantity.get().getFoConsumptionInSZ())
          .ifPresent(
              foConsumptionInSZ ->
                  loadableQuantityRequest.setFoConInSZ(foConsumptionInSZ.toString()));
      Optional.ofNullable(loadableQuantity.get().getDraftRestriction())
          .ifPresent(
              draftRestriction ->
                  loadableQuantityRequest.setDraftRestriction(draftRestriction.toString()));
      Optional.ofNullable(loadableQuantity.get().getSubTotal())
          .ifPresent(subTotal -> loadableQuantityRequest.setSubTotal(subTotal.toString()));
      Optional.ofNullable(loadableQuantity.get().getFoConsumptionPerDay())
          .ifPresent(
              foConsumptionPerDay ->
                  loadableQuantityRequest.setFoConsumptionPerDay(foConsumptionPerDay.toString()));
      builder.setLoadableQuantityRequest(loadableQuantityRequest);
    }
    builder.setResponseStatus(
        com.cpdss.common.generated.LoadableStudy.StatusReply.newBuilder()
            .setStatus(SUCCESS)
            .setMessage(SUCCESS));
    return builder;
  }

  public VesselInfo.VesselReply getVesselDetailsById(VesselInfo.VesselRequest replyBuilder) {
    return this.vesselInfoGrpcService.getVesselDetailsById(replyBuilder);
  }
}
