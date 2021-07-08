/* Licensed at AlphaOri Technologies */
package com.cpdss.loadablestudy.service;

import static com.cpdss.loadablestudy.utility.LoadableStudiesConstants.*;

import com.cpdss.common.exception.GenericServiceException;
import com.cpdss.common.generated.LoadableStudy;
import com.cpdss.common.rest.CommonErrorCodes;
import com.cpdss.common.utils.HttpStatusCode;
import com.cpdss.loadablestudy.entity.LoadablePattern;
import com.cpdss.loadablestudy.entity.LoadableStudyPortRotation;
import com.cpdss.loadablestudy.entity.Voyage;
import com.cpdss.loadablestudy.repository.LoadablePatternRepository;
import com.cpdss.loadablestudy.repository.VoyageRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import com.cpdss.loadablestudy.repository.VoyageStatusRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Master Service for Voyage Related Operations
 *
 * @author Johnsooraj.x
 */
@Slf4j
@Service
public class VoyageService {

  @Autowired private VoyageRepository voyageRepository;

  @Autowired private LoadablePatternRepository loadablePatternRepository;

  @Autowired private VoyageStatusRepository voyageStatusRepository;

  DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);

  /**
   * Find the voyage which have a status 3 Also, collect the LS details and Port Rotation Details
   *
   * @param builder GRPC Response
   * @param vesselId Long id
   * @param activeStatus Long Number - 3
   */
  public void fetchActiveVoyageByVesselId(
      LoadableStudy.ActiveVoyage.Builder builder, Long vesselId, Long activeStatus) {
    List<Voyage> activeVoyage =
        this.voyageRepository.findActiveVoyagesByVesselId(activeStatus, vesselId);
    if (activeVoyage != null && !activeVoyage.isEmpty()) {
      Voyage voyage = activeVoyage.stream().findFirst().get();

      // Set Voyage related properties
      Optional.ofNullable(voyage.getId()).ifPresent(builder::setId);
      Optional.ofNullable(voyage.getVoyageNo()).ifPresent(builder::setVoyageNumber);
      Optional.ofNullable(voyage.getActualEndDate())
          .ifPresent(v -> builder.setActualEndDate(formatter.format(v)));
      Optional.ofNullable(voyage.getActualStartDate())
          .ifPresent(v -> builder.setActualStartDate(formatter.format(v)));
      Optional.ofNullable(voyage.getVoyageStartDate())
          .ifPresent(startDate -> builder.setStartDate(formatter.format(startDate)));
      Optional.ofNullable(voyage.getVoyageEndDate())
          .ifPresent(endDate -> builder.setEndDate(formatter.format(endDate)));
      builder.setStatus(voyage.getVoyageStatus() != null ? voyage.getVoyageStatus().getName() : "");
      Optional.ofNullable(voyage.getVoyageStatus())
          .ifPresent(status -> builder.setStatusId(status.getId()));

      log.info(
          "Get Active voyage, for vessel {}, Voyage No {}, Id {}",
          vesselId,
          voyage.getVoyageNo(),
          voyage.getId());
      // set confirmed loadable study
      if (voyage.getVoyageStatus() != null
          && (STATUS_ACTIVE.equalsIgnoreCase(voyage.getVoyageStatus().getName())
              || STATUS_CLOSE.equalsIgnoreCase(voyage.getVoyageStatus().getName()))) {

        Optional<com.cpdss.loadablestudy.entity.LoadableStudy> confirmedLs =
            voyage.getLoadableStudies().stream()
                .filter(
                    ls ->
                        (ls.getLoadableStudyStatus() != null
                            && STATUS_CONFIRMED.equalsIgnoreCase(
                                ls.getLoadableStudyStatus().getName())))
                .findFirst();

        if (confirmedLs.isPresent()) {
          LoadableStudy.LoadableStudyDetail.Builder lsBuilder =
              LoadableStudy.LoadableStudyDetail.newBuilder();
          this.buildLoadableStudyForVoyage(lsBuilder, confirmedLs.get());
          builder.setConfirmedLoadableStudy(lsBuilder);
          if (!confirmedLs.get().getPortRotations().isEmpty()) {
            for (LoadableStudyPortRotation lsPr : confirmedLs.get().getPortRotations()) {
              LoadableStudy.PortRotationDetail.Builder grpcPRBuilder =
                  LoadableStudy.PortRotationDetail.newBuilder();
              this.buildPortRotationForLs(grpcPRBuilder, lsPr);
              builder.addPortRotation(grpcPRBuilder.build());
              log.info(
                  "Get Active voyage, Loadable Study Name {}, Id {}",
                  confirmedLs.get().getName(),
                  confirmedLs.get().getId());
              List<LoadablePattern> patterns =
                  loadablePatternRepository.findConfirmedPatternByLoadableStudyId(
                      confirmedLs.get().getId(), LS_STATUS_CONFIRMED);
              Long id = patterns.stream().findFirst().get().getId();
              builder.setPatternId(patterns.stream().findFirst().get().getId());
              builder.setPatternCaseNo(patterns.stream().findFirst().get().getCaseNumber());
              builder.setPatternStatus(
                  patterns.stream().findFirst().get().getLoadableStudyStatus());
              log.info(
                  "Get Active voyage, Confirmed Pattern Id {}, Case No {}, Status",
                  patterns.stream().findFirst().get().getId(),
                  patterns.stream().findFirst().get().getCaseNumber(),
                  patterns.stream().findFirst().get().getLoadableStudyStatus());
            }
          }
        }
      }
      log.info(
          "Active voyage for vessel {}, voyage no {}, status {}",
          vesselId,
          voyage.getVoyageNo(),
          voyage.getVoyageStatus().getId());
    }
  }

  // Few data added for now
  private void buildLoadableStudyForVoyage(
      LoadableStudy.LoadableStudyDetail.Builder builder,
      com.cpdss.loadablestudy.entity.LoadableStudy entity) {
    Optional.ofNullable(entity.getId()).ifPresent(builder::setId);
    Optional.ofNullable(entity.getName()).ifPresent(builder::setName);
    Optional.ofNullable(entity.getLoadableStudyStatus().getId()).ifPresent(builder::setStatusId);
    Optional.ofNullable(entity.getDraftMark())
        .ifPresent(v -> builder.setDraftMark(String.valueOf(v)));
    Optional.ofNullable(entity.getCreatedDateTime())
        .ifPresent(v -> builder.setCreatedDate(formatter.format(v)));
  }

  // Few data added for now
  private void buildPortRotationForLs(
      LoadableStudy.PortRotationDetail.Builder builder, LoadableStudyPortRotation entity) {
    Optional.ofNullable(entity.getId()).ifPresent(builder::setId);
    Optional.ofNullable(entity.getPortXId()).ifPresent(builder::setPortId);
    Optional.ofNullable(entity.getPortOrder()).ifPresent(builder::setPortOrder);
    Optional.ofNullable(entity.getBerthXId()).ifPresent(builder::setBerthId);
    Optional.ofNullable(entity.getOperation().getId()).ifPresent(builder::setOperationId);
    Optional.ofNullable(entity.getSeaWaterDensity())
        .ifPresent(v -> builder.setSeaWaterDensity(String.valueOf(v)));
  }

  public void checkIfVoyageClosed(Long voyageId) throws GenericServiceException {
    Voyage voyage = this.voyageRepository.findByIdAndIsActive(voyageId, true);
    if (null != voyage
        && null != voyage.getVoyageStatus()
        && voyage.getVoyageStatus().getId().equals(CLOSE_VOYAGE_STATUS)) {
      throw new GenericServiceException(
          "Save /Edit /Duplicate/Delete operations  not allowed for closed voyage",
          CommonErrorCodes.E_CPDSS_SAVE_NOT_ALLOWED,
          HttpStatusCode.BAD_REQUEST);
    }
  }

  /**
   * Save Voyage
   * @param request
   * @return
   */
  LoadableStudy.VoyageReply saveVoyage(LoadableStudy.VoyageRequest request){
    LoadableStudy.VoyageReply reply = null;
    // validation for duplicate voyages
    if (!voyageRepository
            .findByCompanyXIdAndVesselXIdAndVoyageNoIgnoreCase(
                    request.getCompanyId(), request.getVesselId(), request.getVoyageNo())
            .isEmpty()) {
      reply =
              LoadableStudy.VoyageReply.newBuilder()
                      .setResponseStatus(
                              LoadableStudy.StatusReply.newBuilder()
                                      .setStatus(FAILED)
                                      .setMessage(VOYAGE_EXISTS)
                                      .setCode(CommonErrorCodes.E_CPDSS_VOYAGE_EXISTS))
                      .build();
    } else {

      Voyage voyage = new Voyage();
      voyage.setIsActive(true);
      voyage.setCompanyXId(request.getCompanyId());
      voyage.setVesselXId(request.getVesselId());
      voyage.setVoyageNo(request.getVoyageNo());
      voyage.setCaptainXId(request.getCaptainId());
      voyage.setChiefOfficerXId(request.getChiefOfficerId());
      voyage.setVoyageStartDate(
              !StringUtils.isEmpty(request.getStartDate())
                      ? LocalDateTime.from(
                      DateTimeFormatter.ofPattern(DATE_FORMAT).parse(request.getStartDate()))
                      : null);
      voyage.setVoyageEndDate(
              !StringUtils.isEmpty(request.getEndDate())
                      ? LocalDateTime.from(
                      DateTimeFormatter.ofPattern(DATE_FORMAT).parse(request.getEndDate()))
                      : null);
      voyage.setStartTimezoneId((long) request.getStartTimezoneId());
      voyage.setEndTimezoneId((long) request.getEndTimezoneId());
      voyage.setVoyageStatus(this.voyageStatusRepository.getOne(OPEN_VOYAGE_STATUS));
      voyage = voyageRepository.save(voyage);
      // when Db save is complete we return to client a success message
      reply =
              LoadableStudy.VoyageReply.newBuilder()
                      .setResponseStatus(LoadableStudy.StatusReply.newBuilder().setStatus(SUCCESS).setMessage(SUCCESS))
                      .setVoyageId(voyage.getId())
                      .build();
    }
    return reply;
  }

}
