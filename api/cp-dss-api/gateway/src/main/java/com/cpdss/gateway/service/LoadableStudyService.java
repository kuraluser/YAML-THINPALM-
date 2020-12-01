/* Licensed under Apache-2.0 */
package com.cpdss.gateway.service;

import static java.lang.String.valueOf;
import static org.springframework.util.StringUtils.isEmpty;

import com.cpdss.common.exception.GenericServiceException;
import com.cpdss.common.generated.CargoInfo.CargoReply;
import com.cpdss.common.generated.CargoInfo.CargoRequest;
import com.cpdss.common.generated.CargoInfoServiceGrpc.CargoInfoServiceBlockingStub;
import com.cpdss.common.generated.LoadableStudy.CargoNominationDetail;
import com.cpdss.common.generated.LoadableStudy.CargoNominationReply;
import com.cpdss.common.generated.LoadableStudy.CargoNominationRequest;
import com.cpdss.common.generated.LoadableStudy.LoadablePatternReply;
import com.cpdss.common.generated.LoadableStudy.LoadablePatternRequest;
import com.cpdss.common.generated.LoadableStudy.LoadableQuantityReply;
import com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequest;
import com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment;
import com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail;
import com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail.Builder;
import com.cpdss.common.generated.LoadableStudy.LoadableStudyReply;
import com.cpdss.common.generated.LoadableStudy.LoadableStudyRequest;
import com.cpdss.common.generated.LoadableStudy.LoadingPortDetail;
import com.cpdss.common.generated.LoadableStudy.OnHandQuantityDetail;
import com.cpdss.common.generated.LoadableStudy.OnHandQuantityReply;
import com.cpdss.common.generated.LoadableStudy.OnHandQuantityRequest;
import com.cpdss.common.generated.LoadableStudy.Operation;
import com.cpdss.common.generated.LoadableStudy.PortRotationDetail;
import com.cpdss.common.generated.LoadableStudy.PortRotationReply;
import com.cpdss.common.generated.LoadableStudy.PortRotationRequest;
import com.cpdss.common.generated.LoadableStudy.PurposeOfCommingleReply;
import com.cpdss.common.generated.LoadableStudy.PurposeOfCommingleRequest;
import com.cpdss.common.generated.LoadableStudy.TankDetail;
import com.cpdss.common.generated.LoadableStudy.TankList;
import com.cpdss.common.generated.LoadableStudy.ValveSegregationReply;
import com.cpdss.common.generated.LoadableStudy.ValveSegregationRequest;
import com.cpdss.common.generated.LoadableStudy.VoyageDetail;
import com.cpdss.common.generated.LoadableStudy.VoyageListReply;
import com.cpdss.common.generated.LoadableStudy.VoyageReply;
import com.cpdss.common.generated.LoadableStudy.VoyageRequest;
import com.cpdss.common.generated.LoadableStudyServiceGrpc.LoadableStudyServiceBlockingStub;
import com.cpdss.common.generated.PortInfo.PortReply;
import com.cpdss.common.generated.PortInfo.PortRequest;
import com.cpdss.common.generated.PortInfoServiceGrpc.PortInfoServiceBlockingStub;
import com.cpdss.common.generated.VesselInfo.VesselReply;
import com.cpdss.common.generated.VesselInfo.VesselRequest;
import com.cpdss.common.generated.VesselInfoServiceGrpc.VesselInfoServiceBlockingStub;
import com.cpdss.common.rest.CommonErrorCodes;
import com.cpdss.common.rest.CommonSuccessResponse;
import com.cpdss.common.utils.HttpStatusCode;
import com.cpdss.gateway.domain.Cargo;
import com.cpdss.gateway.domain.CargoNomination;
import com.cpdss.gateway.domain.CargoNominationResponse;
import com.cpdss.gateway.domain.CommingleCargoResponse;
import com.cpdss.gateway.domain.DischargingPortRequest;
import com.cpdss.gateway.domain.LoadablePattern;
import com.cpdss.gateway.domain.LoadablePatternCargoDetails;
import com.cpdss.gateway.domain.LoadablePatternResponse;
import com.cpdss.gateway.domain.LoadableQuantity;
import com.cpdss.gateway.domain.LoadableQuantityResponse;
import com.cpdss.gateway.domain.LoadableStudy;
import com.cpdss.gateway.domain.LoadableStudyResponse;
import com.cpdss.gateway.domain.LoadingPort;
import com.cpdss.gateway.domain.OnHandQuantity;
import com.cpdss.gateway.domain.OnHandQuantityResponse;
import com.cpdss.gateway.domain.PortRotation;
import com.cpdss.gateway.domain.PortRotationResponse;
import com.cpdss.gateway.domain.Purpose;
import com.cpdss.gateway.domain.ValveSegregation;
import com.cpdss.gateway.domain.VesselTank;
import com.cpdss.gateway.domain.Voyage;
import com.cpdss.gateway.domain.VoyageResponse;
import com.google.protobuf.ByteString;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import javax.validation.constraints.Min;
import lombok.extern.log4j.Log4j2;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

/** GatewayLoadableStudyService - service class for loadable study related operations */
@Service
@Log4j2
public class LoadableStudyService {

  @GrpcClient("loadableStudyService")
  private LoadableStudyServiceBlockingStub loadableStudyServiceBlockingStub;

  @GrpcClient("cargoInfoService")
  private CargoInfoServiceBlockingStub cargoInfoServiceBlockingStub;

  @GrpcClient("portInfoService")
  private PortInfoServiceBlockingStub portInfoServiceBlockingStub;

  @GrpcClient("vesselInfoService")
  private VesselInfoServiceBlockingStub vesselInfoGrpcService;

  private static final String SUCCESS = "SUCCESS";
  private static final int LOADABLE_STUDY_ATTACHEMENT_MAX_SIZE = 1 * 1024 * 1024;
  private static final List<String> ATTACHMENT_ALLOWED_EXTENSIONS =
      Arrays.asList("docx", "pdf", "txt", "jpg", "png", "msg", "eml");

  /**
   * method for voyage save
   *
   * @param voyage
   * @param companyId
   * @param vesselId
   * @param headers
   * @return response to controller
   * @throws GenericServiceException CommonSuccessResponse
   */
  public VoyageResponse saveVoyage(
      Voyage voyage, long companyId, long vesselId, String correlationId)
      throws GenericServiceException {
    VoyageResponse voyageResponse = new VoyageResponse();
    VoyageRequest voyageRequest =
        VoyageRequest.newBuilder()
            .setCaptainId(voyage.getCaptainId())
            .setChiefOfficerId(voyage.getChiefOfficerId())
            .setCompanyId(companyId)
            .setVesselId(vesselId)
            .setVoyageNo(voyage.getVoyageNo())
            .build();

    VoyageReply voyageReply = this.saveVoyage(voyageRequest);
    if (!SUCCESS.equalsIgnoreCase(voyageReply.getResponseStatus().getStatus())) {
      if (CommonErrorCodes.E_CPDSS_VOYAGE_EXISTS.equalsIgnoreCase(
          voyageReply.getResponseStatus().getCode())) {
        throw new GenericServiceException(
            voyageReply.getResponseStatus().getMessage(),
            voyageReply.getResponseStatus().getCode(),
            HttpStatusCode.valueOf(Integer.valueOf(CommonErrorCodes.E_HTTP_BAD_REQUEST)));
      } else {
        throw new GenericServiceException(
            voyageReply.getResponseStatus().getMessage(),
            voyageReply.getResponseStatus().getCode(),
            HttpStatusCode.valueOf(Integer.valueOf(voyageReply.getResponseStatus().getCode())));
      }
    } else {
      voyageResponse.setResponseStatus(
          new CommonSuccessResponse(String.valueOf(HttpStatus.OK.value()), correlationId));
      voyageResponse.setVoyageId(voyageReply.getVoyageId());
    }
    return voyageResponse;
  }

  /**
   * @param voyageRequest
   * @return VoyageReply
   */
  public VoyageReply saveVoyage(VoyageRequest voyageRequest) {
    return loadableStudyServiceBlockingStub.saveVoyage(voyageRequest);
  }

  /**
   * @param loadableQuantity
   * @param companyId
   * @param vesselId
   * @param loadableStudiesId
   * @param headers
   * @return
   * @throws GenericServiceException CommonSuccessResponse
   */
  public LoadableQuantityResponse saveLoadableQuantity(
      LoadableQuantity loadableQuantity, long loadableStudiesId, String correlationId)
      throws GenericServiceException {
    LoadableQuantityResponse loadableQuantityResponse = new LoadableQuantityResponse();
    LoadableQuantityRequest.Builder builder = LoadableQuantityRequest.newBuilder();
    builder.setConstant(loadableQuantity.getConstant());
    Optional.ofNullable(loadableQuantity.getDisplacmentDraftRestriction())
        .ifPresent(builder::setDisplacmentDraftRestriction);
    Optional.ofNullable(loadableQuantity.getDistanceFromLastPort())
        .ifPresent(builder::setDistanceFromLastPort);

    builder.setDwt(loadableQuantity.getDwt());
    builder.setEstDOOnBoard(loadableQuantity.getEstDOOnBoard());
    builder.setEstFOOnBoard(loadableQuantity.getEstFOOnBoard());
    builder.setEstFreshWaterOnBoard(loadableQuantity.getEstFreshWaterOnBoard());
    builder.setEstSagging(loadableQuantity.getEstSagging());
    Optional.ofNullable(loadableQuantity.getEstSeaDensity()).ifPresent(builder::setEstSeaDensity);
    Optional.ofNullable(loadableQuantity.getFoConsumptionPerDay())
        .ifPresent(builder::setFoConsumptionPerDay);
    builder.setOtherIfAny(loadableQuantity.getOtherIfAny());
    builder.setSaggingDeduction(loadableQuantity.getSaggingDeduction());
    Optional.ofNullable(loadableQuantity.getSgCorrection()).ifPresent(builder::setSgCorrection);
    builder.setTotalQuantity(loadableQuantity.getTotalQuantity());
    builder.setTpc(loadableQuantity.getTpc());
    Optional.ofNullable(loadableQuantity.getVesselAverageSpeed())
        .ifPresent(builder::setVesselAverageSpeed);
    Optional.ofNullable(loadableQuantity.getVesselLightWeight())
        .ifPresent(builder::setVesselLightWeight);
    Optional.ofNullable(loadableQuantity.getPortId()).ifPresent(builder::setPortId);
    Optional.ofNullable(loadableQuantity.getBoilerWaterOnBoard())
        .ifPresent(builder::setBoilerWaterOnBoard);
    Optional.ofNullable(loadableQuantity.getBallast()).ifPresent(builder::setBallast);
    Optional.ofNullable(loadableQuantity.getRunningHours()).ifPresent(builder::setRunningHours);
    Optional.ofNullable(loadableQuantity.getRunningDays()).ifPresent(builder::setRunningDays);
    Optional.ofNullable(loadableQuantity.getFoConInSZ()).ifPresent(builder::setFoConInSZ);
    Optional.ofNullable(loadableQuantity.getDraftRestriction())
        .ifPresent(builder::setDraftRestriction);
    Optional.ofNullable(loadableQuantity.getSubTotal()).ifPresent(builder::setSubTotal);
    Optional.ofNullable(loadableQuantity.getFoConsumptionPerDay())
        .ifPresent(builder::setFoConsumptionPerDay);
    builder.setLoadableStudyId(loadableStudiesId).build();

    LoadableQuantityReply loadableQuantityReply = this.saveLoadableQuantity(builder.build());
    if (!SUCCESS.equalsIgnoreCase(loadableQuantityReply.getResponseStatus().getStatus())) {
      throw new GenericServiceException(
          loadableQuantityReply.getResponseStatus().getMessage(),
          loadableQuantityReply.getResponseStatus().getCode(),
          HttpStatusCode.valueOf(
              Integer.valueOf(loadableQuantityReply.getResponseStatus().getCode())));
    } else {

      loadableQuantityResponse.setResponseStatus(
          new CommonSuccessResponse(String.valueOf(HttpStatus.OK.value()), correlationId));
      loadableQuantityResponse.setLoadableQuantityId(loadableQuantityReply.getLoadableQuantityId());
    }
    return loadableQuantityResponse;
  }

  public LoadableQuantityReply saveLoadableQuantity(
      LoadableQuantityRequest loadableQuantityRequest) {
    return loadableStudyServiceBlockingStub.saveLoadableQuantity(loadableQuantityRequest);
  }

  /**
   * This method calls loadable study microservice to get a list of loadable studies by vessel and
   * voyage
   *
   * @param vesselId - the vessel id
   * @param voyageId - the voyage id
   * @param voyageId2
   * @param correlationdId - the correlation id
   * @return LoadableStudyResponse
   * @throws GenericServiceException
   */
  public LoadableStudyResponse getLoadableStudies(
      Long companyId, Long vesselId, Long voyageId, String correlationdId)
      throws GenericServiceException {
    log.info("fetching loadable studies. correlationId: {}", correlationdId);
    LoadableStudyRequest request =
        LoadableStudyRequest.newBuilder().setVesselId(vesselId).setVoyageId(voyageId).build();
    LoadableStudyReply reply = this.getloadableStudyList(request);
    if (!SUCCESS.equals(reply.getResponseStatus().getStatus())) {
      throw new GenericServiceException(
          "failed to fetch loadable studies",
          reply.getResponseStatus().getCode(),
          HttpStatusCode.valueOf(Integer.valueOf(reply.getResponseStatus().getCode())));
    }
    List<LoadableStudy> list = new ArrayList<>();
    for (LoadableStudyDetail grpcReply : reply.getLoadableStudiesList()) {
      LoadableStudy dto = new LoadableStudy();
      dto.setId(grpcReply.getId());
      dto.setName(grpcReply.getName());
      dto.setDetail(grpcReply.getDetail());
      dto.setCreatedDate(grpcReply.getCreatedDate());
      dto.setCharterer(grpcReply.getCharterer());
      dto.setSubCharterer(grpcReply.getSubCharterer());
      dto.setDraftMark(
          StringUtils.isEmpty(grpcReply.getDraftMark())
              ? null
              : new BigDecimal(grpcReply.getDraftMark()));
      dto.setLoadLineXId(grpcReply.getLoadLineXId());
      dto.setDraftRestriction(
          StringUtils.isEmpty(grpcReply.getDraftRestriction())
              ? null
              : new BigDecimal(grpcReply.getDraftRestriction()));
      dto.setMaxAirTemperature(
          StringUtils.isEmpty(grpcReply.getMaxAirTemperature())
              ? null
              : new BigDecimal(grpcReply.getMaxAirTemperature()));
      dto.setMaxWaterTemperature(
          StringUtils.isEmpty(grpcReply.getMaxWaterTemperature())
              ? null
              : new BigDecimal(grpcReply.getMaxWaterTemperature()));
      dto.setDischargingPortIds(grpcReply.getDischargingPortIdsList());
      dto.setStatus(grpcReply.getStatus());
      dto.setStatusId(grpcReply.getStatusId());
      list.add(dto);
    }
    LoadableStudyResponse response = new LoadableStudyResponse();
    response.setLoadableStudies(list);
    response.setResponseStatus(
        new CommonSuccessResponse(String.valueOf(HttpStatus.OK.value()), correlationdId));
    return response;
  }

  /**
   * Call loadable study microservice through grpc
   *
   * @param request {@link LoadableStudyRequest}
   * @return {@link LoadableStudyReply}
   */
  public LoadableStudyReply getloadableStudyList(LoadableStudyRequest request) {
    return this.loadableStudyServiceBlockingStub.findLoadableStudiesByVesselAndVoyage(request);
  }

  public LoadableStudyResponse saveLoadableStudy(
      final LoadableStudy request, String correlationId, MultipartFile[] files)
      throws GenericServiceException, IOException {
    this.validateLoadableStudyFiles(files);
    Builder builder = LoadableStudyDetail.newBuilder();
    Optional.ofNullable(request.getName()).ifPresent(builder::setName);
    Optional.ofNullable(request.getDetail()).ifPresent(builder::setDetail);
    Optional.ofNullable(request.getCharterer()).ifPresent(builder::setCharterer);
    Optional.ofNullable(request.getSubCharterer()).ifPresent(builder::setSubCharterer);
    Optional.ofNullable(request.getDraftMark())
        .ifPresent(draftMark -> builder.setDraftMark(String.valueOf(draftMark)));
    Optional.ofNullable(request.getLoadLineXId()).ifPresent(builder::setLoadLineXId);
    Optional.ofNullable(request.getDraftRestriction())
        .ifPresent(
            draftRestriction -> builder.setDraftRestriction(String.valueOf(draftRestriction)));
    Optional.ofNullable(request.getMaxAirTemperature())
        .ifPresent(maxTemp -> builder.setMaxAirTemperature(String.valueOf(maxTemp)));
    Optional.ofNullable(request.getMaxWaterTemperature())
        .ifPresent(maxTemp -> builder.setMaxWaterTemperature(String.valueOf(maxTemp)));
    Optional.ofNullable(request.getVesselId()).ifPresent(builder::setVesselId);
    Optional.ofNullable(request.getVoyageId()).ifPresent(builder::setVoyageId);
    Optional.ofNullable(request.getCreatedFromId()).ifPresent(builder::setDuplicatedFromId);
    for (MultipartFile file : files) {
      String orginalFileName = file.getOriginalFilename() == null ? "" : file.getOriginalFilename();
      String fileName = orginalFileName.substring(0, orginalFileName.lastIndexOf("."));
      String extension = orginalFileName.substring(orginalFileName.lastIndexOf(".")).toLowerCase();
      builder.addAttachments(
          LoadableStudyAttachment.newBuilder()
              .setFileName(fileName + System.currentTimeMillis() + extension)
              .setByteString(ByteString.copyFrom(file.getBytes()))
              .build());
    }
    LoadableStudyReply reply = this.saveLoadableStudy(builder.build());
    if (!SUCCESS.equals(reply.getResponseStatus().getStatus())) {
      throw new GenericServiceException(
          "failed to save loadable studies",
          reply.getResponseStatus().getCode(),
          HttpStatusCode.valueOf(Integer.valueOf(reply.getResponseStatus().getCode())));
    }
    LoadableStudyResponse response = new LoadableStudyResponse();
    response.setLoadableStudyId(reply.getId());
    response.setResponseStatus(
        new CommonSuccessResponse(String.valueOf(HttpStatus.OK.value()), correlationId));
    return response;
  }

  private void validateLoadableStudyFiles(MultipartFile[] files)
      throws GenericServiceException, IOException {
    log.info("validating attachment files");
    for (MultipartFile file : files) {
      if (file.getSize() > LOADABLE_STUDY_ATTACHEMENT_MAX_SIZE) {
        throw new GenericServiceException(
            "loadable study attachment size exceeds maximum allowed size",
            CommonErrorCodes.E_HTTP_BAD_REQUEST,
            HttpStatusCode.BAD_REQUEST);
      }
      String originalFileName =
          file.getOriginalFilename() == null ? "" : file.getOriginalFilename();
      if (!ATTACHMENT_ALLOWED_EXTENSIONS.contains(
          originalFileName.substring(originalFileName.lastIndexOf(".") + 1).toLowerCase())) {
        throw new GenericServiceException(
            "unsupported file type",
            CommonErrorCodes.E_HTTP_BAD_REQUEST,
            HttpStatusCode.BAD_REQUEST);
      }
    }
  }

  public LoadableStudyReply saveLoadableStudy(LoadableStudyDetail grpcRequest) {
    return this.loadableStudyServiceBlockingStub.saveLoadableStudy(grpcRequest);
  }

  /**
   * Retrieves the cargo information from cargo master, port information from port master and cargo
   * nomination details from loadable-study service
   *
   * @param loadableStudyId
   * @param headers
   * @return
   * @throws GenericServiceException
   */
  public CargoNominationResponse getCargoNomination(Long loadableStudyId, HttpHeaders headers)
      throws GenericServiceException {
    CargoNominationResponse cargoNominationResponse = new CargoNominationResponse();
    // Build response with response status
    buildCargoNominationResponseWithResponseStatus(cargoNominationResponse);
    // Retrieve cargo information from cargo master
    CargoRequest cargoRequest =
        CargoRequest.newBuilder().setLoadableStudyId(loadableStudyId).build();
    CargoReply cargoReply = cargoInfoServiceBlockingStub.getCargoInfo(cargoRequest);
    if (cargoReply != null
        && cargoReply.getResponseStatus() != null
        && SUCCESS.equalsIgnoreCase(cargoReply.getResponseStatus().getStatus())) {
      buildCargoNominationResponseWithCargo(cargoNominationResponse, cargoReply);
    } else {
      throw new GenericServiceException(
          "Error in calling cargo service",
          CommonErrorCodes.E_GEN_INTERNAL_ERR,
          HttpStatusCode.INTERNAL_SERVER_ERROR);
    }
    // Retrieve cargo Nominations from cargo nomination table
    CargoNominationRequest cargoNominationRequest =
        CargoNominationRequest.newBuilder().setLoadableStudyId(loadableStudyId).build();
    CargoNominationReply cargoNominationReply =
        loadableStudyServiceBlockingStub.getCargoNominationById(cargoNominationRequest);
    if (SUCCESS.equalsIgnoreCase(cargoNominationReply.getResponseStatus().getStatus())) {
      buildCargoNominationResponse(cargoNominationResponse, cargoNominationReply);
    } else {
      throw new GenericServiceException(
          "Error calling getCargoNominationById service",
          CommonErrorCodes.E_GEN_INTERNAL_ERR,
          HttpStatusCode.INTERNAL_SERVER_ERROR);
    }
    // Retrieve segregation List
    ValveSegregationRequest valveSegregationRequest =
        ValveSegregationRequest.newBuilder().setLoadableStudyId(loadableStudyId).build();
    ValveSegregationReply valveSegregationReply =
        loadableStudyServiceBlockingStub.getValveSegregation(valveSegregationRequest);
    if (SUCCESS.equalsIgnoreCase(valveSegregationReply.getResponseStatus().getStatus())) {
      buildCargoNominationResponseWithValveSegregation(
          cargoNominationResponse, valveSegregationReply);
    } else {
      throw new GenericServiceException(
          "Error calling getValveSegregation service",
          CommonErrorCodes.E_GEN_INTERNAL_ERR,
          HttpStatusCode.INTERNAL_SERVER_ERROR);
    }
    return cargoNominationResponse;
  }

  private CargoNominationResponse buildCargoNominationResponseWithResponseStatus(
      CargoNominationResponse cargoNominationResponse) {
    // set response status irrespective of whether cargo details are available
    CommonSuccessResponse commonSuccessResponse = new CommonSuccessResponse();
    commonSuccessResponse.setStatus(String.valueOf(HttpStatus.OK.value()));
    cargoNominationResponse.setResponseStatus(commonSuccessResponse);
    return cargoNominationResponse;
  }

  /**
   * Builds the cargoNomination saved list from database
   *
   * @param cargoNominationResponse
   * @param reply
   * @return
   */
  private CargoNominationResponse buildCargoNominationResponse(
      CargoNominationResponse cargoNominationResponse, CargoNominationReply reply) {
    if (reply != null && !reply.getCargoNominationsList().isEmpty()) {
      List<CargoNomination> cargoNominationList = new ArrayList<>();
      reply
          .getCargoNominationsList()
          .forEach(
              cargoNominationDetail -> {
                CargoNomination cargoNomination = new CargoNomination();
                cargoNomination.setId(cargoNominationDetail.getId());
                cargoNomination.setLoadableStudyId(cargoNominationDetail.getLoadableStudyId());
                cargoNomination.setPriority(cargoNominationDetail.getPriority());
                cargoNomination.setColor(cargoNominationDetail.getColor());
                cargoNomination.setCargoId(cargoNominationDetail.getCargoId());
                cargoNomination.setAbbreviation(cargoNominationDetail.getAbbreviation());
                if (!CollectionUtils.isEmpty(cargoNominationDetail.getLoadingPortDetailsList())) {
                  List<LoadingPort> loadingPortList = new ArrayList<>();
                  cargoNominationDetail
                      .getLoadingPortDetailsList()
                      .forEach(
                          port -> {
                            LoadingPort loadingPort = new LoadingPort();
                            loadingPort.setId(port.getPortId());
                            loadingPort.setQuantity(
                                port.getQuantity() != null
                                    ? new BigDecimal(port.getQuantity())
                                    : new BigDecimal("0"));
                            loadingPortList.add(loadingPort);
                          });
                  cargoNomination.setLoadingPorts(loadingPortList);
                }
                // TODO: add quantity column whena added in database
                // cargoNomination.setQuantity(cargoNominationDetail.getQuantity);
                cargoNomination.setMaxTolerance(
                    !StringUtils.isEmpty(cargoNominationDetail.getMaxTolerance())
                        ? new BigDecimal(cargoNominationDetail.getMaxTolerance())
                        : new BigDecimal("0"));
                cargoNomination.setMinTolerance(
                    !StringUtils.isEmpty(cargoNominationDetail.getMinTolerance())
                        ? new BigDecimal(cargoNominationDetail.getMinTolerance())
                        : new BigDecimal("0"));
                cargoNomination.setApi(
                    !StringUtils.isEmpty(cargoNominationDetail.getApiEst())
                        ? new BigDecimal(cargoNominationDetail.getApiEst())
                        : new BigDecimal("0"));
                cargoNomination.setTemperature(
                    !StringUtils.isEmpty(cargoNominationDetail.getTempEst())
                        ? new BigDecimal(cargoNominationDetail.getTempEst())
                        : new BigDecimal("0"));
                cargoNomination.setSegregationId(cargoNominationDetail.getSegregationId());
                cargoNominationList.add(cargoNomination);
              });
      cargoNominationResponse.setCargoNominations(cargoNominationList);
    }
    return cargoNominationResponse;
  }

  /**
   * @param cargoNominationResponse
   * @param cargoReply
   * @return
   */
  private CargoNominationResponse buildCargoNominationResponseWithValveSegregation(
      CargoNominationResponse cargoNominationResponse, ValveSegregationReply reply) {
    if (reply != null && !reply.getValveSegregationList().isEmpty()) {
      List<ValveSegregation> segregationList = new ArrayList<>();
      reply
          .getValveSegregationList()
          .forEach(
              segregationDetail -> {
                ValveSegregation valveSegregation = new ValveSegregation();
                valveSegregation.setId(segregationDetail.getId());
                valveSegregation.setName(segregationDetail.getName());
                segregationList.add(valveSegregation);
              });
      cargoNominationResponse.setSegregations(segregationList);
    }
    return cargoNominationResponse;
  }

  /**
   * @param cargoNominationResponse
   * @param cargoReply
   * @return
   */
  private CargoNominationResponse buildCargoNominationResponseWithCargo(
      CargoNominationResponse cargoNominationResponse, CargoReply cargoReply) {
    if (cargoReply != null && !cargoReply.getCargosList().isEmpty()) {
      List<Cargo> cargoList = new ArrayList<>();
      cargoReply
          .getCargosList()
          .forEach(
              cargoDetail -> {
                Cargo cargo = new Cargo();
                cargo.setId(cargoDetail.getId());
                cargo.setApi(cargoDetail.getApi());
                cargo.setAbbreviation(cargoDetail.getAbbreviation());
                cargo.setName(cargoDetail.getCrudeType());
                cargoList.add(cargo);
              });
      cargoNominationResponse.setCargos(cargoList);
    }
    return cargoNominationResponse;
  }

  /**
   * Save cargo nomination details using loadable-study service
   *
   * @param loadableStudyId
   * @param headers
   * @return
   * @throws GenericServiceException
   */
  public CargoNominationResponse saveCargoNomination(
      Long vesselId,
      Long voyageId,
      Long loadableStudyId,
      CargoNomination request,
      HttpHeaders headers)
      throws GenericServiceException {
    CargoNominationResponse cargoNominationResponse = new CargoNominationResponse();
    // Build response with response status
    buildCargoNominationResponseWithResponseStatus(cargoNominationResponse);
    // Build cargoNomination payload for grpc call
    com.cpdss.common.generated.LoadableStudy.CargoNominationRequest.Builder builder =
        CargoNominationRequest.newBuilder();
    Optional.ofNullable(vesselId).ifPresent(builder::setVesselId);
    Optional.ofNullable(voyageId).ifPresent(builder::setVoyageId);
    Optional.ofNullable(loadableStudyId).ifPresent(builder::setLoadableStudyId);
    // build inner cargoNomination detail object
    CargoNominationDetail.Builder cargoNominationDetailbuilder = CargoNominationDetail.newBuilder();
    Optional.ofNullable(request.getId()).ifPresent(cargoNominationDetailbuilder::setId);
    Optional.ofNullable(request.getLoadableStudyId())
        .ifPresent(cargoNominationDetailbuilder::setLoadableStudyId);
    Optional.ofNullable(request.getPriority()).ifPresent(cargoNominationDetailbuilder::setPriority);
    Optional.ofNullable(request.getColor()).ifPresent(cargoNominationDetailbuilder::setColor);
    Optional.ofNullable(request.getCargoId()).ifPresent(cargoNominationDetailbuilder::setCargoId);
    Optional.ofNullable(request.getAbbreviation())
        .ifPresent(cargoNominationDetailbuilder::setAbbreviation);
    // build inner loadingPort details object
    if (!CollectionUtils.isEmpty(request.getLoadingPorts())) {
      request
          .getLoadingPorts()
          .forEach(
              loadingPort -> {
                LoadingPortDetail.Builder loadingPortDetailBuilder = LoadingPortDetail.newBuilder();
                Optional.ofNullable(loadingPort.getId())
                    .ifPresent(loadingPortDetailBuilder::setPortId);
                Optional.ofNullable(loadingPort.getQuantity())
                    .ifPresent(
                        quantity -> loadingPortDetailBuilder.setQuantity(String.valueOf(quantity)));
                cargoNominationDetailbuilder.addLoadingPortDetails(loadingPortDetailBuilder);
              });
    }
    Optional.ofNullable(request.getQuantity())
        .ifPresent(quantity -> cargoNominationDetailbuilder.setQuantity(String.valueOf(quantity)));
    Optional.ofNullable(request.getMaxTolerance())
        .ifPresent(
            maxTolerance ->
                cargoNominationDetailbuilder.setMaxTolerance(String.valueOf(maxTolerance)));
    Optional.ofNullable(request.getMinTolerance())
        .ifPresent(
            minTolerance ->
                cargoNominationDetailbuilder.setMinTolerance(String.valueOf(minTolerance)));
    Optional.ofNullable(request.getApi())
        .ifPresent(api -> cargoNominationDetailbuilder.setApiEst(String.valueOf(api)));
    Optional.ofNullable(request.getTemperature())
        .ifPresent(
            temperature -> cargoNominationDetailbuilder.setTempEst(String.valueOf(temperature)));
    Optional.ofNullable(request.getSegregationId())
        .ifPresent(cargoNominationDetailbuilder::setSegregationId);
    builder.setCargoNominationDetail(cargoNominationDetailbuilder);
    CargoNominationRequest cargoNominationRequest = builder.build();
    CargoNominationReply cargoNominationReply =
        loadableStudyServiceBlockingStub.saveCargoNomination(cargoNominationRequest);
    if (cargoNominationReply != null
        && cargoNominationReply.getResponseStatus() != null
        && SUCCESS.equalsIgnoreCase(cargoNominationReply.getResponseStatus().getStatus())) {
      cargoNominationResponse.setCargoNominationId(cargoNominationReply.getCargoNominationId());
    } else {
      throw new GenericServiceException(
          "Error in saving cargo nomination",
          CommonErrorCodes.E_GEN_INTERNAL_ERR,
          HttpStatusCode.INTERNAL_SERVER_ERROR);
    }
    return cargoNominationResponse;
  }

  /**
   * Get lodable study port rotation data
   *
   * @param vesselId - the vessle id
   * @param voyageId - the voyage id
   * @param loadableStudyId - the loadable study id
   * @return {@link PortResponse}
   * @throws GenericServiceException
   */
  public PortRotationResponse getLoadableStudyPortRotationList(
      Long vesselId, Long voyageId, Long loadableStudyId, String correlationId)
      throws GenericServiceException {
    PortRotationResponse response = new PortRotationResponse();
    PortRotationReply grpcReply =
        this.getLoadableStudyPortRotationList(
            PortRotationRequest.newBuilder()
                .setLoadableStudyId(loadableStudyId)
                .setVesselId(vesselId)
                .setVoyageId(voyageId)
                .build());
    if (!SUCCESS.equals(grpcReply.getResponseStatus().getStatus())) {
      throw new GenericServiceException(
          "failed to fetch loadable study - ports",
          grpcReply.getResponseStatus().getCode(),
          HttpStatusCode.valueOf(Integer.valueOf(grpcReply.getResponseStatus().getCode())));
    }
    response.setPortList(new ArrayList<>());
    for (PortRotationDetail portDetail : grpcReply.getPortsList()) {
      PortRotation port = new PortRotation();
      port.setId(portDetail.getId());
      port.setPortId(0 == portDetail.getPortId() ? null : portDetail.getPortId());
      port.setBerthId(0 == portDetail.getBerthId() ? null : portDetail.getBerthId());
      port.setPortOrder(0 == portDetail.getPortOrder() ? null : portDetail.getPortOrder());
      port.setLoadableStudyId(loadableStudyId);
      port.setOperationId(0 == portDetail.getOperationId() ? null : portDetail.getOperationId());
      port.setSeaWaterDensity(
          isEmpty(portDetail.getSeaWaterDensity())
              ? null
              : new BigDecimal(portDetail.getSeaWaterDensity()));
      port.setDistanceBetweenPorts(
          isEmpty(portDetail.getDistanceBetweenPorts())
              ? null
              : new BigDecimal(portDetail.getDistanceBetweenPorts()));
      port.setTimeOfStay(
          isEmpty(portDetail.getTimeOfStay()) ? null : new BigDecimal(portDetail.getTimeOfStay()));
      port.setMaxDraft(
          isEmpty(portDetail.getMaxDraft()) ? null : new BigDecimal(portDetail.getMaxDraft()));
      port.setMaxAirDraft(
          isEmpty(portDetail.getMaxAirDraft())
              ? null
              : new BigDecimal(portDetail.getMaxAirDraft()));
      port.setEta(portDetail.getEta());
      port.setEtd(portDetail.getEtd());
      port.setLayCanFrom(portDetail.getLayCanFrom());
      port.setLayCanTo(portDetail.getLayCanTo());

      response.getPortList().add(port);
      response.setResponseStatus(
          new CommonSuccessResponse(String.valueOf(HttpStatus.OK.value()), correlationId));
    }
    response.setOperations(new ArrayList<>());
    for (Operation operation : grpcReply.getOperationsList()) {
      com.cpdss.gateway.domain.Operation op = new com.cpdss.gateway.domain.Operation();
      op.setId(operation.getId());
      op.setOperationName(operation.getOperationName());
      response.getOperations().add(op);
    }
    return response;
  }

  /**
   * Call grpc server to get list of ports against loadable study
   *
   * @param request {@link PortRequest}
   * @return {@link PortReply}
   */
  public PortRotationReply getLoadableStudyPortRotationList(PortRotationRequest request) {
    return this.loadableStudyServiceBlockingStub.getLoadableStudyPortRotation(request);
  }

  /**
   * Save port rotation for a loadable study
   *
   * @param request
   * @param first
   * @return
   * @throws GenericServiceException
   */
  public PortRotationResponse savePortRotation(PortRotation request, String correlationId)
      throws GenericServiceException {
    log.info("Inside savePortRotation");
    PortRotationReply grpcReply = this.savePortRotation(this.createPortRotationDetail(request));
    if (!SUCCESS.equals(grpcReply.getResponseStatus().getStatus())) {
      throw new GenericServiceException(
          "failed to save loadable study - ports",
          grpcReply.getResponseStatus().getCode(),
          HttpStatusCode.valueOf(Integer.valueOf(grpcReply.getResponseStatus().getCode())));
    }
    PortRotationResponse response = new PortRotationResponse();
    response.setId(grpcReply.getPortRotationId());
    response.setResponseStatus(
        new CommonSuccessResponse(valueOf(HttpStatus.OK.value()), correlationId));
    return response;
  }

  /**
   * Call loadable study service to save port rotation
   *
   * @param request {@link PortRotationDetail}
   * @return
   */
  public PortRotationReply savePortRotation(PortRotationDetail request) {
    return this.loadableStudyServiceBlockingStub.saveLoadableStudyPortRotation(request);
  }

  /**
   * Create Port rotation grpc request object
   *
   * @param request
   * @return
   */
  private PortRotationDetail createPortRotationDetail(PortRotation request) {
    PortRotationDetail.Builder builder = PortRotationDetail.newBuilder();
    builder.setId(request.getId());
    builder.setLoadableStudyId(request.getLoadableStudyId());
    Optional.ofNullable(request.getOperationId()).ifPresent(builder::setOperationId);
    Optional.ofNullable(request.getBerthId()).ifPresent(builder::setBerthId);
    Optional.ofNullable(request.getDistanceBetweenPorts())
        .ifPresent(
            item -> builder.setDistanceBetweenPorts(valueOf(request.getDistanceBetweenPorts())));
    Optional.ofNullable(request.getEta())
        .ifPresent(item -> builder.setEta(valueOf(request.getEta())));
    Optional.ofNullable(request.getEtd())
        .ifPresent(item -> builder.setEtd(valueOf(request.getEtd())));
    Optional.ofNullable(request.getLayCanFrom())
        .ifPresent(item -> builder.setLayCanFrom(valueOf(request.getLayCanFrom())));
    Optional.ofNullable(request.getLayCanTo())
        .ifPresent(item -> builder.setLayCanTo(valueOf(request.getLayCanTo())));
    Optional.ofNullable(request.getMaxAirDraft())
        .ifPresent(item -> builder.setMaxAirDraft(valueOf(request.getMaxAirDraft())));
    Optional.ofNullable(request.getMaxDraft())
        .ifPresent(item -> builder.setMaxDraft(valueOf(request.getMaxDraft())));
    Optional.ofNullable(request.getPortId())
        .ifPresent(item -> builder.setPortId(request.getPortId()));
    Optional.ofNullable(request.getSeaWaterDensity())
        .ifPresent(item -> builder.setSeaWaterDensity(valueOf(request.getSeaWaterDensity())));
    Optional.ofNullable(request.getTimeOfStay())
        .ifPresent(item -> builder.setTimeOfStay(valueOf(request.getTimeOfStay())));
    Optional.ofNullable(request.getPortOrder()).ifPresent(builder::setPortOrder);
    return builder.build();
  }

  /**
   * @param loadableQuantityId
   * @param correlationId
   * @return
   * @throws GenericServiceException LoadableQuantityResponse
   */
  public LoadableQuantityResponse getLoadableQuantity(long loadableStudyId, String correlationId)
      throws GenericServiceException {
    LoadableQuantityResponse loadableQuantityResponseDto = new LoadableQuantityResponse();
    LoadableQuantity loadableQuantity = new LoadableQuantity();
    LoadableQuantityReply loadableQuantityRequest =
        LoadableQuantityReply.newBuilder().setLoadableStudyId(loadableStudyId).build();
    com.cpdss.common.generated.LoadableStudy.LoadableQuantityResponse loadableQuantityResponse =
        this.getLoadableQuantityResponse(loadableQuantityRequest);
    if (!SUCCESS.equalsIgnoreCase(loadableQuantityResponse.getResponseStatus().getStatus())) {
      throw new GenericServiceException(
          loadableQuantityResponse.getResponseStatus().getMessage(),
          loadableQuantityResponse.getResponseStatus().getCode(),
          HttpStatusCode.valueOf(
              Integer.valueOf(loadableQuantityResponse.getResponseStatus().getCode())));
    }

    loadableQuantity.setConstant(
        loadableQuantityResponse.getLoadableQuantityRequest().getConstant());
    loadableQuantity.setDwt(loadableQuantityResponse.getLoadableQuantityRequest().getDwt());
    loadableQuantity.setDisplacmentDraftRestriction(
        loadableQuantityResponse.getLoadableQuantityRequest().getDisplacmentDraftRestriction());
    loadableQuantity.setDistanceFromLastPort(
        loadableQuantityResponse.getLoadableQuantityRequest().getDistanceFromLastPort());
    loadableQuantity.setEstDOOnBoard(
        loadableQuantityResponse.getLoadableQuantityRequest().getEstDOOnBoard());
    loadableQuantity.setEstFOOnBoard(
        loadableQuantityResponse.getLoadableQuantityRequest().getEstFOOnBoard());
    loadableQuantity.setEstFreshWaterOnBoard(
        loadableQuantityResponse.getLoadableQuantityRequest().getEstFreshWaterOnBoard());
    loadableQuantity.setEstSagging(
        loadableQuantityResponse.getLoadableQuantityRequest().getEstSagging());
    loadableQuantity.setEstSeaDensity(
        loadableQuantityResponse.getLoadableQuantityRequest().getEstSeaDensity());

    loadableQuantity.setFoConsumptionPerDay(
        loadableQuantityResponse.getLoadableQuantityRequest().getFoConsumptionPerDay());

    loadableQuantity.setVesselLightWeight(
        loadableQuantityResponse.getLoadableQuantityRequest().getVesselLightWeight());
    loadableQuantity.setOtherIfAny(
        loadableQuantityResponse.getLoadableQuantityRequest().getOtherIfAny());
    loadableQuantity.setSaggingDeduction(
        loadableQuantityResponse.getLoadableQuantityRequest().getSaggingDeduction());
    loadableQuantity.setSgCorrection(
        loadableQuantityResponse.getLoadableQuantityRequest().getSgCorrection());
    loadableQuantity.setTotalQuantity(
        loadableQuantityResponse.getLoadableQuantityRequest().getTotalQuantity());
    loadableQuantity.setTpc(loadableQuantityResponse.getLoadableQuantityRequest().getTpc());
    loadableQuantity.setVesselAverageSpeed(
        loadableQuantityResponse.getLoadableQuantityRequest().getVesselAverageSpeed());
    loadableQuantity.setUpdateDateAndTime(
        loadableQuantityResponse.getLoadableQuantityRequest().getUpdateDateAndTime());
    loadableQuantity.setPortId(
        Integer.parseInt(
            String.valueOf(loadableQuantityResponse.getLoadableQuantityRequest().getPortId())));
    loadableQuantity.setBoilerWaterOnBoard(
        loadableQuantityResponse.getLoadableQuantityRequest().getBoilerWaterOnBoard());
    loadableQuantity.setBallast(loadableQuantityResponse.getLoadableQuantityRequest().getBallast());
    loadableQuantity.setRunningHours(
        loadableQuantityResponse.getLoadableQuantityRequest().getRunningHours());
    loadableQuantity.setRunningDays(
        loadableQuantityResponse.getLoadableQuantityRequest().getRunningDays());
    loadableQuantity.setFoConInSZ(
        loadableQuantityResponse.getLoadableQuantityRequest().getFoConInSZ());
    loadableQuantity.setDraftRestriction(
        loadableQuantityResponse.getLoadableQuantityRequest().getDraftRestriction());
    loadableQuantity.setSubTotal(
        loadableQuantityResponse.getLoadableQuantityRequest().getSubTotal());
    loadableQuantityResponseDto.setLoadableQuantity(loadableQuantity);
    loadableQuantityResponseDto.setIsSummerZone(loadableQuantityResponse.getIsSummerZone());

    loadableQuantityResponseDto.setResponseStatus(
        new CommonSuccessResponse(String.valueOf(HttpStatus.OK.value()), correlationId));

    return loadableQuantityResponseDto;
  }

  /**
   * @param loadableQuantityId
   * @return LoadableQuantityReply
   */
  public com.cpdss.common.generated.LoadableStudy.LoadableQuantityResponse
      getLoadableQuantityResponse(LoadableQuantityReply loadableQuantityRequest) {
    return loadableStudyServiceBlockingStub.getLoadableQuantity(loadableQuantityRequest);
  }

  /**
   * Get voyage list by vessel
   *
   * @param vesselId
   * @param first
   * @return
   * @throws GenericServiceException
   */
  public VoyageResponse getVoyageListByVessel(Long vesselId, String correlationId)
      throws GenericServiceException {
    VoyageRequest request = VoyageRequest.newBuilder().setVesselId(vesselId).build();
    VoyageListReply grpcReply = this.getVoyageListByVessel(request);
    if (!SUCCESS.equals(grpcReply.getResponseStatus().getStatus())) {
      throw new GenericServiceException(
          "failed to fetch voyage list",
          grpcReply.getResponseStatus().getCode(),
          HttpStatusCode.valueOf(Integer.valueOf(grpcReply.getResponseStatus().getCode())));
    }
    VoyageResponse response = new VoyageResponse();
    response.setVoyages(new ArrayList<>());
    response.setResponseStatus(
        new CommonSuccessResponse(String.valueOf(HttpStatus.OK.value()), correlationId));
    for (VoyageDetail detail : grpcReply.getVoyagesList()) {
      Voyage voyage = new Voyage();
      voyage.setId(detail.getId());
      voyage.setVoyageNo(detail.getVoyageNumber());
      response.getVoyages().add(voyage);
    }
    return response;
  }

  /**
   * Call grpc service to fetch list of voyages by vessel
   *
   * @param request
   * @return
   */
  public VoyageListReply getVoyageListByVessel(VoyageRequest request) {
    return this.loadableStudyServiceBlockingStub.getVoyagesByVessel(request);
  }

  /**
   * Delete cargo nomination details using loadable-study service
   *
   * @param loadableStudyId
   * @param headers
   * @return
   * @throws GenericServiceException
   */
  public CargoNominationResponse deleteCargoNomination(Long cargoNominationId, HttpHeaders headers)
      throws GenericServiceException {
    CargoNominationResponse cargoNominationResponse = new CargoNominationResponse();
    // Build response with response status
    buildCargoNominationResponseWithResponseStatus(cargoNominationResponse);
    // Build cargoNomination payload for grpc call
    com.cpdss.common.generated.LoadableStudy.CargoNominationRequest.Builder builder =
        CargoNominationRequest.newBuilder();
    Optional.ofNullable(cargoNominationId).ifPresent(builder::setCargoNominationId);
    CargoNominationRequest cargoNominationRequest = builder.build();
    CargoNominationReply cargoNominationReply =
        loadableStudyServiceBlockingStub.deleteCargoNomination(cargoNominationRequest);
    if (cargoNominationReply != null
        && cargoNominationReply.getResponseStatus() != null
        && !SUCCESS.equalsIgnoreCase(cargoNominationReply.getResponseStatus().getStatus())) {
      throw new GenericServiceException(
          "Error in calling deleteCargoNomination",
          CommonErrorCodes.E_GEN_INTERNAL_ERR,
          HttpStatusCode.INTERNAL_SERVER_ERROR);
    }
    return cargoNominationResponse;
  }

  /**
   * Save discharging ports for a loadable study
   *
   * @param request {@link DischargingPortRequest}
   * @param correlationId
   * @return {@link PortRotationResponse}
   * @throws GenericServiceException
   */
  public PortRotationResponse saveDischargingPorts(
      DischargingPortRequest request, String correlationId) throws GenericServiceException {
    log.info("Inside savePortRotation");
    PortRotationRequest grpcRequest =
        PortRotationRequest.newBuilder()
            .addAllDischargingPortIds(request.getPortIds())
            .setLoadableStudyId(request.getLoadableStudyId())
            .build();
    PortRotationReply grpcReply = this.saveDischargingPorts(grpcRequest);
    if (!SUCCESS.equals(grpcReply.getResponseStatus().getStatus())) {
      throw new GenericServiceException(
          "failed to save discharging ports",
          grpcReply.getResponseStatus().getCode(),
          HttpStatusCode.valueOf(Integer.valueOf(grpcReply.getResponseStatus().getCode())));
    }
    PortRotationResponse response = new PortRotationResponse();
    response.setResponseStatus(
        new CommonSuccessResponse(valueOf(HttpStatus.OK.value()), correlationId));
    return response;
  }

  /**
   * Call loadble study micro service to save discharging ports
   *
   * @param grpcRequest {@link PortRotationRequest}
   * @return
   */
  public PortRotationReply saveDischargingPorts(PortRotationRequest grpcRequest) {
    return this.loadableStudyServiceBlockingStub.saveDischargingPorts(grpcRequest);
  }

  /**
   * Delete loadable study by id
   *
   * @param loadableStudyId - The primary key for loadable study
   * @param correlationId
   * @return
   * @throws NumberFormatException
   * @throws GenericServiceException
   */
  public LoadableStudyResponse deleteLoadableStudy(
      final Long loadableStudyId, final String correlationId) throws GenericServiceException {
    LoadableStudyRequest request =
        LoadableStudyRequest.newBuilder().setLoadableStudyId(loadableStudyId).build();
    LoadableStudyReply grpcReply = this.deleteLoadableStudy(request);
    if (!SUCCESS.equals(grpcReply.getResponseStatus().getStatus())) {
      throw new GenericServiceException(
          "failed to delete loadable study",
          grpcReply.getResponseStatus().getCode(),
          HttpStatusCode.valueOf(Integer.valueOf(grpcReply.getResponseStatus().getCode())));
    }
    LoadableStudyResponse response = new LoadableStudyResponse();
    response.setResponseStatus(
        new CommonSuccessResponse(String.valueOf(HttpStatusCode.OK.value()), correlationId));
    return response;
  }

  /**
   * Call grpc service
   *
   * @param request
   * @return
   */
  public LoadableStudyReply deleteLoadableStudy(LoadableStudyRequest request) {
    return this.loadableStudyServiceBlockingStub.deleteLoadableStudy(request);
  }

  /**
   * @param loadableStudyId
   * @param first
   * @return PortRotationResponse
   */
  public PortRotationResponse getPortRotation(
      @Min(value = 1, message = "400") Long loadableStudyId, String correlationId)
      throws GenericServiceException {
    log.info("Inside getPortRotation gateway service with correlationId : " + correlationId);
    PortRotationRequest portRotationRequest =
        PortRotationRequest.newBuilder().setLoadableStudyId(loadableStudyId).build();
    PortRotationReply portRotationReply = this.getPortRotation(portRotationRequest);
    if (!SUCCESS.equals(portRotationReply.getResponseStatus().getStatus())) {
      throw new GenericServiceException(
          "failed to get Port Rotation",
          portRotationReply.getResponseStatus().getCode(),
          HttpStatusCode.valueOf(Integer.valueOf(portRotationReply.getResponseStatus().getCode())));
    }
    PortRotationResponse response = new PortRotationResponse();
    response.setPortList(new ArrayList<>());
    portRotationReply
        .getPortsList()
        .forEach(
            portList -> {
              PortRotation portRotation = new PortRotation();
              portRotation.setPortId(portList.getPortId());
              response.getPortList().add(portRotation);
            });
    response.setResponseStatus(
        new CommonSuccessResponse(valueOf(HttpStatus.OK.value()), correlationId));
    return response;
  }

  /**
   * @param portRotationRequest
   * @return PortRotationReply
   */
  public PortRotationReply getPortRotation(PortRotationRequest portRotationRequest) {
    return this.loadableStudyServiceBlockingStub.getPortRotationByLoadableStudyId(
        portRotationRequest);
  }

  /**
   * Delete port rotation by id
   *
   * @param id
   * @param id
   * @param first
   * @return
   * @throws GenericServiceException
   */
  public PortRotationResponse deletePortRotation(
      Long loadableStudyId, Long id, String correlationId) throws GenericServiceException {
    PortRotationRequest request =
        PortRotationRequest.newBuilder().setId(id).setLoadableStudyId(loadableStudyId).build();
    PortRotationReply grpcReply = this.deletePortRotation(request);
    if (!SUCCESS.equals(grpcReply.getResponseStatus().getStatus())) {
      throw new GenericServiceException(
          "failed to delete port rotation",
          grpcReply.getResponseStatus().getCode(),
          HttpStatusCode.valueOf(Integer.valueOf(grpcReply.getResponseStatus().getCode())));
    }
    PortRotationResponse response = new PortRotationResponse();
    response.setResponseStatus(
        new CommonSuccessResponse(valueOf(HttpStatus.OK.value()), correlationId));
    return response;
  }

  /**
   * Call grpc service to delete port rotation
   *
   * @param request
   * @return
   */
  public PortRotationReply deletePortRotation(PortRotationRequest request) {
    return this.loadableStudyServiceBlockingStub.deletePortRotation(request);
  }

  /**
   * @param loadableStudiesId
   * @param first
   * @return LoadablePatternResponse
   */
  public LoadablePatternResponse getLoadablePatterns(Long loadableStudiesId, String correlationId)
      throws GenericServiceException {
    LoadablePatternRequest loadablePatternRequest =
        LoadablePatternRequest.newBuilder().setLoadableStudyId(loadableStudiesId).build();
    LoadablePatternReply loadablePatternReply = this.getLoadablePattern(loadablePatternRequest);
    if (!SUCCESS.equals(loadablePatternReply.getResponseStatus().getStatus())) {
      throw new GenericServiceException(
          "failed to get  LoadablePattern ",
          loadablePatternReply.getResponseStatus().getCode(),
          HttpStatusCode.valueOf(
              Integer.valueOf(loadablePatternReply.getResponseStatus().getCode())));
    }
    return this.buildLoadablePatternResponse(loadablePatternReply, correlationId);
  }

  /**
   * @param loadablePatternReply
   * @param correlationId
   * @return LoadablePatternResponse
   */
  private LoadablePatternResponse buildLoadablePatternResponse(
      LoadablePatternReply loadablePatternReply, String correlationId) {
    LoadablePatternResponse loadablePatternResponse = new LoadablePatternResponse();
    loadablePatternResponse.setLoadablePatterns(new ArrayList<LoadablePattern>());
    loadablePatternReply
        .getLoadablePatternList()
        .forEach(
            loadablePattern -> {
              LoadablePattern loadablePatternDto = new LoadablePattern();
              loadablePatternDto.setLoadablePatternId(loadablePattern.getLoadablePatternId());
              loadablePatternDto.setLoadablePatternCargoDetails(
                  new ArrayList<LoadablePatternCargoDetails>());
              loadablePattern
                  .getLoadablePatternCargoDetailsList()
                  .forEach(
                      loadablePatternCargoDetail -> {
                        LoadablePatternCargoDetails loadablePatternCargoDetails =
                            new LoadablePatternCargoDetails();
                        Optional.ofNullable(loadablePatternCargoDetail.getPriority())
                            .ifPresent(
                                priority -> loadablePatternCargoDetails.setPriority(priority));
                        Optional.ofNullable(loadablePatternCargoDetail.getQuantity())
                            .ifPresent(
                                quantity ->
                                    loadablePatternCargoDetails.setQuantity(
                                        String.valueOf(quantity)));
                        Optional.ofNullable(loadablePatternCargoDetail.getTankId())
                            .ifPresent(tankId -> loadablePatternCargoDetails.setTankId(tankId));
                        Optional.ofNullable(loadablePatternCargoDetail.getCargoAbbreviation())
                            .ifPresent(
                                cargoAbbreviation ->
                                    loadablePatternCargoDetails.setCargoAbbreviation(
                                        cargoAbbreviation));
                        Optional.ofNullable(loadablePatternCargoDetail.getCargoColor())
                            .ifPresent(
                                cargoColor ->
                                    loadablePatternCargoDetails.setCargoColor(cargoColor));
                        Optional.ofNullable(loadablePatternCargoDetail.getDifference())
                            .ifPresent(
                                difference ->
                                    loadablePatternCargoDetails.setDifference(
                                        String.valueOf(difference)));
                        Optional.ofNullable(loadablePatternCargoDetail.getConstraints())
                            .ifPresent(
                                constraints ->
                                    loadablePatternCargoDetails.setConstraints(constraints));
                        Optional.ofNullable(loadablePatternCargoDetail.getDifferenceColor())
                            .ifPresent(
                                differenceColor ->
                                    loadablePatternCargoDetails.setDifferenceColor(
                                        differenceColor));
                        loadablePatternDto
                            .getLoadablePatternCargoDetails()
                            .add(loadablePatternCargoDetails);
                      });
              loadablePatternResponse.getLoadablePatterns().add(loadablePatternDto);
            });
    loadablePatternResponse.setResponseStatus(
        new CommonSuccessResponse(valueOf(HttpStatus.OK.value()), correlationId));
    return loadablePatternResponse;
  }

  /**
   * @param loadablePatternRequest
   * @return LoadablePatternReply
   */
  public LoadablePatternReply getLoadablePattern(LoadablePatternRequest loadablePatternRequest) {
    return this.loadableStudyServiceBlockingStub.getLoadablePatternDetails(loadablePatternRequest);
  }

  /**
   * Get on hand quantity details
   *
   * @param companyId
   * @param vesselId
   * @param loadableStudyId
   * @param portId
   * @return
   * @throws GenericServiceException
   */
  public OnHandQuantityResponse getOnHandQuantity(
      final Long companyId,
      final Long vesselId,
      final Long loadableStudyId,
      final Long portId,
      String correlationId)
      throws GenericServiceException {
    OnHandQuantityRequest request =
        OnHandQuantityRequest.newBuilder()
            .setCompanyId(companyId)
            .setVesselId(vesselId)
            .setLoadableStudyId(loadableStudyId)
            .setPortId(portId)
            .build();
    OnHandQuantityReply grpcReply = this.getOnHandQuantity(request);
    if (!SUCCESS.equals(grpcReply.getResponseStatus().getStatus())) {
      throw new GenericServiceException(
          "Failed to fetch on hand quantities",
          grpcReply.getResponseStatus().getCode(),
          HttpStatusCode.valueOf(Integer.valueOf(grpcReply.getResponseStatus().getCode())));
    }
    return this.buildOnHandQuantityResponse(grpcReply, correlationId);
  }

  /**
   * Build on hand quantity response
   *
   * @param grpcReply
   * @return
   */
  private OnHandQuantityResponse buildOnHandQuantityResponse(
      OnHandQuantityReply grpcReply, String correlationId) {
    OnHandQuantityResponse response = new OnHandQuantityResponse();
    response.setOnHandQuantities(new ArrayList<>());
    for (OnHandQuantityDetail detail : grpcReply.getOnHandQuantityList()) {
      OnHandQuantity onHandQuantity = new OnHandQuantity();
      onHandQuantity.setId(detail.getId());
      onHandQuantity.setTankId(detail.getTankId());
      onHandQuantity.setTankName(detail.getTankName());
      onHandQuantity.setFuelTypeId(detail.getFuelTypeId());
      onHandQuantity.setFuelTypeName(detail.getFuelType());
      onHandQuantity.setArrivalQuantity(
          isEmpty(detail.getArrivalQuantity())
              ? BigDecimal.ZERO
              : new BigDecimal(detail.getArrivalQuantity()));
      onHandQuantity.setArrivalVolume(
          isEmpty(detail.getArrivalVolume())
              ? BigDecimal.ZERO
              : new BigDecimal(detail.getArrivalVolume()));
      onHandQuantity.setDepartureQuantity(
          isEmpty(detail.getDepartureQuantity())
              ? BigDecimal.ZERO
              : new BigDecimal(detail.getDepartureQuantity()));
      onHandQuantity.setDepartureVolume(
          isEmpty(detail.getDepartureVolume())
              ? BigDecimal.ZERO
              : new BigDecimal(detail.getDepartureVolume()));
      response.getOnHandQuantities().add(onHandQuantity);
    }
    response.setResponseStatus(
        new CommonSuccessResponse(String.valueOf(HttpStatus.OK.value()), correlationId));
    return this.buildTankLayoutArray(response, grpcReply);
  }

  /**
   * Build tank layout array
   *
   * @param response
   * @param grpcReply
   * @return
   */
  private OnHandQuantityResponse buildTankLayoutArray(
      OnHandQuantityResponse response, OnHandQuantityReply grpcReply) {
    List<List<VesselTank>> tanks = new ArrayList<>();
    for (TankList list : grpcReply.getVesselTanksList()) {
      List<VesselTank> tankGroup = new ArrayList<>();
      for (TankDetail detail : list.getVesselTankList()) {
        VesselTank tank = new VesselTank();
        tank.setId(detail.getTankId());
        tank.setCategoryId(detail.getTankCategoryId());
        tank.setFrameNumberFrom(detail.getFrameNumberFrom());
        tank.setFrameNumberTo(detail.getFrameNumberTo());
        tank.setShortName(detail.getShortName());
        tank.setCategoryName(detail.getTankCategoryName());
        tank.setName(detail.getTankName());
        tank.setDensity(isEmpty(detail.getDensity()) ? null : new BigDecimal(detail.getDensity()));
        tank.setFillCapcityCubm(
            isEmpty(detail.getFillCapacityCubm())
                ? null
                : new BigDecimal(detail.getFillCapacityCubm()));
        tank.setSlopTank(detail.getIsSlopTank());
        tank.setGroup(detail.getTankGroup());
        tank.setOrder(detail.getTankOrder());
        tank.setHeightFrom(detail.getHeightFrom());
        tank.setHeightTo(detail.getHeightTo());
        tankGroup.add(tank);
      }
      tanks.add(tankGroup);
    }
    response.setVesselTanks(tanks);
    return response;
  }

  /**
   * Call micro service over grpc
   *
   * @param request
   * @return
   */
  public OnHandQuantityReply getOnHandQuantity(OnHandQuantityRequest request) {
    return this.loadableStudyServiceBlockingStub.getOnHandQuantity(request);
  }

  /**
   * Save on hand quantity
   *
   * @param request
   * @param correlationId
   * @return
   * @throws GenericServiceException
   * @throws NumberFormatException
   */
  public OnHandQuantityResponse saveOnHandQuantity(OnHandQuantity request, String correlationId)
      throws GenericServiceException {
    OnHandQuantityResponse response = new OnHandQuantityResponse();
    OnHandQuantityDetail.Builder builder = OnHandQuantityDetail.newBuilder();
    builder.setId(request.getId());
    builder.setLoadableStudyId(request.getLoadableStudyId());
    builder.setPortId(request.getPortId());
    builder.setTankId(request.getTankId());
    builder.setFuelTypeId(request.getFuelTypeId());
    Optional.ofNullable(request.getArrivalQuantity())
        .ifPresent(item -> builder.setArrivalQuantity(valueOf(item)));
    Optional.ofNullable(request.getArrivalVolume())
        .ifPresent(item -> builder.setArrivalVolume(valueOf(item)));
    Optional.ofNullable(request.getDepartureQuantity())
        .ifPresent(item -> builder.setDepartureQuantity(valueOf(item)));
    Optional.ofNullable(request.getDepartureVolume())
        .ifPresent(item -> builder.setDepartureVolume(valueOf(item)));
    OnHandQuantityReply grpcReply = this.saveOnHandQuantity(builder.build());
    if (!SUCCESS.equals(grpcReply.getResponseStatus().getStatus())) {
      throw new GenericServiceException(
          "Failed to save on hand quantities",
          grpcReply.getResponseStatus().getCode(),
          HttpStatusCode.valueOf(Integer.valueOf(grpcReply.getResponseStatus().getCode())));
    }
    response.setId(grpcReply.getId());
    response.setResponseStatus(
        new CommonSuccessResponse(String.valueOf(HttpStatus.OK.value()), correlationId));
    return response;
  }

  /**
   * Call grpc service to save on hand quantity
   *
   * @param request
   * @return
   */
  public OnHandQuantityReply saveOnHandQuantity(OnHandQuantityDetail request) {
    return this.loadableStudyServiceBlockingStub.saveOnHandQuantity(request);
  }

  /**
   * Retrieves the commingle cargo information along with vessel cargo tanks lookup array
   *
   * @param loadableStudyId
   * @param headers
   * @return
   * @throws GenericServiceException
   */
  public CommingleCargoResponse getCommingleCargo(Long loadableStudyId, Long vesselId)
      throws GenericServiceException {
    CommingleCargoResponse commingleCargoResponse = new CommingleCargoResponse();
    // Build response with response status
    CommonSuccessResponse commonSuccessResponse = new CommonSuccessResponse();
    commonSuccessResponse.setStatus(String.valueOf(HttpStatus.OK.value()));
    commingleCargoResponse.setResponseStatus(commonSuccessResponse);
    // Retrieve cargos nominated for the loadable study
    CargoNominationRequest cargoNominationRequest =
        CargoNominationRequest.newBuilder().setLoadableStudyId(loadableStudyId).build();
    CargoNominationReply cargoNominationReply =
        loadableStudyServiceBlockingStub.getCargoNominationById(cargoNominationRequest);
    if (SUCCESS.equalsIgnoreCase(cargoNominationReply.getResponseStatus().getStatus())) {
      buildCommingleCargoResponseWithCargos(commingleCargoResponse, cargoNominationReply);
    } else {
      throw new GenericServiceException(
          "Error calling getCargoNominationById service",
          CommonErrorCodes.E_GEN_INTERNAL_ERR,
          HttpStatusCode.INTERNAL_SERVER_ERROR);
    }
    // Retrieve cargo Nominations from cargo nomination table
    VesselRequest vesselRequest = VesselRequest.newBuilder().setVesselId(vesselId).build();
    VesselReply vesselReply = vesselInfoGrpcService.getVesselCargoTanks(vesselRequest);
    if (SUCCESS.equalsIgnoreCase(vesselReply.getResponseStatus().getStatus())) {
      buildCommingleCargoResponseWithVesselTanks(commingleCargoResponse, vesselReply);
    } else {
      throw new GenericServiceException(
          "Error calling getVesselCargoTanks service",
          CommonErrorCodes.E_GEN_INTERNAL_ERR,
          HttpStatusCode.INTERNAL_SERVER_ERROR);
    }
    // Retrieve purpose of commingle
    PurposeOfCommingleRequest purposeOfCommingleRequest =
        PurposeOfCommingleRequest.newBuilder().setLoadableStudyId(loadableStudyId).build();
    PurposeOfCommingleReply purposeOfCommingleReply =
        loadableStudyServiceBlockingStub.getPurposeOfCommingle(purposeOfCommingleRequest);
    if (SUCCESS.equalsIgnoreCase(purposeOfCommingleReply.getResponseStatus().getStatus())) {
      buildCommingleCargoResponseWithPurposeOfCommingle(
          commingleCargoResponse, purposeOfCommingleReply);
    } else {
      throw new GenericServiceException(
          "Error calling getPurposeOfCommingle service",
          CommonErrorCodes.E_GEN_INTERNAL_ERR,
          HttpStatusCode.INTERNAL_SERVER_ERROR);
    }
    return commingleCargoResponse;
  }

  /**
   * builds commingleCargoResponse from the cargo nomination data for the specific loadable study
   *
   * @param commingleCargoResponse
   * @param reply
   * @return
   */
  private CommingleCargoResponse buildCommingleCargoResponseWithCargos(
      CommingleCargoResponse commingleCargoResponse, CargoNominationReply reply) {
    if (reply != null && !reply.getCargoNominationsList().isEmpty()) {
      List<CargoNomination> cargoNominationList = new ArrayList<>();
      List<CargoNominationDetail> cargoNominationDetailsFiltered =
          reply.getCargoNominationsList().stream()
              .filter(distinctByKey(cargoNominationDetail -> cargoNominationDetail.getCargoId()))
              .collect(Collectors.toList());
      cargoNominationDetailsFiltered.forEach(
          cargoNominationDetail -> {
            CargoNomination cargoNomination = new CargoNomination();
            cargoNomination.setId(cargoNominationDetail.getId());
            cargoNomination.setColor(cargoNominationDetail.getColor());
            cargoNomination.setCargoId(cargoNominationDetail.getCargoId());
            cargoNominationList.add(cargoNomination);
          });
      commingleCargoResponse.setCargoNominations(cargoNominationList);
    }
    return commingleCargoResponse;
  }

  /**
   * Function to retrieve distinct objects by an attribute of the object
   *
   * @param <T>
   * @param keyExtractor
   * @return
   */
  public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
    Map<Object, Boolean> seen = new ConcurrentHashMap<>();
    return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
  }

  /**
   * Builds commingle response with vessel tanks
   *
   * @param commingleCargoResponse
   * @param vesselReply
   */
  private void buildCommingleCargoResponseWithVesselTanks(
      CommingleCargoResponse commingleCargoResponse, VesselReply vesselReply) {
    if (vesselReply != null && !vesselReply.getVesselTanksList().isEmpty()) {
      List<VesselTank> vesselTankList = new ArrayList<>();
      vesselReply
          .getVesselTanksList()
          .forEach(
              vesselTankDetail -> {
                VesselTank vesselTank = new VesselTank();
                vesselTank.setId(vesselTankDetail.getTankId());
                vesselTank.setName(vesselTankDetail.getTankName());
                vesselTank.setShortName(vesselTankDetail.getShortName());
                vesselTankList.add(vesselTank);
              });
      commingleCargoResponse.setVesselTanks(vesselTankList);
    }
  }

  /**
   * building commingle response with purpose of commingle
   *
   * @param commingleCargoResponse
   * @param reply
   */
  private void buildCommingleCargoResponseWithPurposeOfCommingle(
      CommingleCargoResponse commingleCargoResponse, PurposeOfCommingleReply reply) {
    if (reply != null && !reply.getPurposeOfCommingleList().isEmpty()) {
      List<Purpose> purposeList = new ArrayList<>();
      reply
          .getPurposeOfCommingleList()
          .forEach(
              purposeDetail -> {
                Purpose purpose = new Purpose();
                purpose.setId(purposeDetail.getId());
                purpose.setName(purposeDetail.getName());
                purposeList.add(purpose);
              });
      commingleCargoResponse.setPurposes(purposeList);
    }
  }
}
