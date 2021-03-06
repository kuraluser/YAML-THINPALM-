/* Licensed at AlphaOri Technologies */
package com.cpdss.gateway.service;

import com.cpdss.common.exception.GenericServiceException;
import com.cpdss.common.generated.PortInfo;
import com.cpdss.common.generated.PortInfo.*;
import com.cpdss.common.generated.PortInfo.GetPortInfoByPortIdsRequest.Builder;
import com.cpdss.common.generated.PortInfoServiceGrpc;
import com.cpdss.common.rest.CommonErrorCodes;
import com.cpdss.common.rest.CommonSuccessResponse;
import com.cpdss.common.utils.HttpStatusCode;
import com.cpdss.gateway.domain.*;
import com.cpdss.gateway.domain.ManifoldDetail;
import com.google.protobuf.Empty;
import io.micrometer.core.instrument.util.StringUtils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Slf4j
@Service
public class PortInfoService {

  private static final String SUCCESS = "SUCCESS";

  @GrpcClient("portInfoService")
  private PortInfoServiceGrpc.PortInfoServiceBlockingStub portInfoServiceBlockingStub;

  public PortInfo.BerthInfoResponse getBerthInfoByPortId(Long id) {
    PortInfo.BerthInfoResponse response =
        this.portInfoServiceBlockingStub.getBerthDetailsByPortId(
            PortInfo.PortIdRequest.newBuilder().setPortId(id).build());
    if (response.getResponseStatus().getStatus().equalsIgnoreCase(SUCCESS)) {
      return response;
    }
    return null;
  }

  /**
   * Get port master details with berth information for the requested port id.
   *
   * @param portId port id
   * @param correlationId correlation id
   * @return PortDetailResponse
   * @throws NumberFormatException In case of format mismatch
   * @throws GenericServiceException In case of failures
   */
  public PortDetailResponse getPortInformationByPortId(Long portId, String correlationId)
      throws GenericServiceException {

    Builder builder = GetPortInfoByPortIdsRequest.newBuilder();
    builder.addId(portId);
    PortReply portReply = portInfoServiceBlockingStub.getPortInfoByPortIds(builder.build());
    if (!SUCCESS.equals(portReply.getResponseStatus().getStatus())) {
      log.error("Failed to get port details for port id {}", portId);
      throw new GenericServiceException(
          "Failed to get port details for port id " + portId,
          portReply.getResponseStatus().getCode(),
          HttpStatusCode.valueOf(portReply.getResponseStatus().getHttpStatusCode()));
    }
    PortDetailResponse response = new PortDetailResponse();
    PortDetails portDetails = new PortDetails();
    List<PortDetail> portsList = portReply.getPortsList();
    portDetails.setCountryName(portsList.get(0).getCountryName());
    portDetails.setCountryId(portsList.get(0).getCountryId());
    portDetails.setDensityOfWater(returnZeroIfBlank(portsList.get(0).getWaterDensity()));
    portDetails.setMaxPermissibleDraft(
        returnZeroIfBlank(portsList.get(0).getMaxPermissibleDraft()));
    portDetails.setPortCode(portsList.get(0).getCode());
    portDetails.setPortId(portsList.get(0).getId());
    portDetails.setPortName(portsList.get(0).getName());
    portDetails.setTimezoneId(portsList.get(0).getTimezoneId());
    portDetails.setTimezone(portsList.get(0).getTimezone());
    portDetails.setTimezoneAbbreviation(portsList.get(0).getTimezoneAbbreviation());
    portDetails.setTimezoneOffsetVal(portsList.get(0).getTimezoneOffsetVal());
    portDetails.setTideHeightHigh(returnZeroIfBlank(portsList.get(0).getTideHeightTo()));
    portDetails.setTideHeightLow(returnZeroIfBlank(portsList.get(0).getTideHeightFrom()));
    portDetails.setLatitude(portsList.get(0).getLat());
    portDetails.setLongitude(portsList.get(0).getLon());
    portDetails.setAmbientTemperature(returnZeroIfBlank(portsList.get(0).getAmbientTemperature()));

    List<BerthDetail> berthDetailsList = portsList.get(0).getBerthDetailsList();
    List<PortBerthInfoResponse> berthList = setBerthInformationForThePorts(berthDetailsList);
    portDetails.setBerthInfo(berthList);
    response.setPortDetails(portDetails);
    response.setResponseStatus(
        new CommonSuccessResponse(String.valueOf(HttpStatus.OK.value()), correlationId));
    return response;
  }

  /**
   * Sets berth information in the response for the ports.
   *
   * @param berthDetailsList list of berth details
   * @return List of PortBerthInfoResponse.
   */
  private List<PortBerthInfoResponse> setBerthInformationForThePorts(
      List<BerthDetail> berthDetailsList) {

    List<PortBerthInfoResponse> berthList = new ArrayList<>();
    for (BerthDetail berth : berthDetailsList) {
      PortBerthInfoResponse berthResponse = new PortBerthInfoResponse();
      berthResponse.setBerthId(berth.getId());
      berthResponse.setBerthName(berth.getBerthName());
      berthResponse.setDepthInDatum(returnZeroIfBlank(berth.getBerthDatumDepth()));
      berthResponse.setMaxDwt(returnZeroIfBlank(berth.getMaxDwt()));
      berthResponse.setMaxManifoldHeight(returnZeroIfBlank(berth.getMaxManifoldHeight()));
      berthResponse.setMaxDraft(returnZeroIfBlank(berth.getMaxDraft()));
      berthResponse.setMaxShipDepth(returnZeroIfBlank(berth.getMaxShipDepth()));
      berthResponse.setPortId(berth.getPortId());
      berthResponse.setRegulationAndRestriction(berth.getRegulationAndRestriction());
      berthResponse.setMaxLoa(returnZeroIfBlank(berth.getMaxLoa()));
      berthResponse.setMinUKC(berth.getUkc());

      buildManifoldDetails(berth.getManifoldDetailsList(), berthResponse);
      berthList.add(berthResponse);
    }
    return berthList;
  }

  /**
   * Builds manifold details from grpc response
   *
   * @param manifoldDetailsList list of manifold details from grpc response
   * @param berthResponse berth response output
   * @see #buildManifoldDetails(List, BerthDetail.Builder)
   */
  private void buildManifoldDetails(
      List<PortInfo.ManifoldDetail> manifoldDetailsList, PortBerthInfoResponse berthResponse) {

    log.info("Inside buildManifoldDetails method!");
    List<ManifoldDetail> manifoldDetails = new ArrayList<>();

    if (!CollectionUtils.isEmpty(manifoldDetailsList)) {
      manifoldDetailsList.forEach(
          manifoldDetailGenerated -> {
            ManifoldDetail manifoldDetail = new ManifoldDetail();

            // Set fields
            Optional.of(manifoldDetailGenerated.getManifoldName())
                .ifPresent(manifoldDetail::setManifoldName);
            Optional.of(manifoldDetailGenerated.getConnectionNumber())
                .ifPresent(manifoldDetail::setConnectionNumber);
            Optional.of(manifoldDetailGenerated.getManifoldSize())
                .ifPresent(manifoldDetail::setManifoldSize);
            Optional.of(manifoldDetailGenerated.getMaxLoadingRate())
                .ifPresent(manifoldDetail::setMaxLoadingRate);
            Optional.of(manifoldDetailGenerated.getMaxDischargeRate())
                .ifPresent(manifoldDetail::setMaxDischargeRate);

            manifoldDetail.setManifoldHeight(
                returnZeroIfBlank(manifoldDetailGenerated.getManifoldHeight()));
            manifoldDetail.setMaxPressure(
                returnZeroIfBlank(manifoldDetailGenerated.getMaxPressure()));

            manifoldDetails.add(manifoldDetail);
          });
    }
    berthResponse.setManifoldDetails(manifoldDetails);
  }

  /**
   * Returns big decimal value of provided string else returns big decimal zero
   *
   * @param string input string
   * @return big decimal value
   */
  private BigDecimal returnZeroIfBlank(String string) {

    return StringUtils.isBlank(string) ? BigDecimal.ZERO : new BigDecimal(string);
  }

  /**
   * Returns string value of BigDecimal input if not null. Else returns string value of BigDecimal
   * zero
   *
   * @param bigDecimalInputValue input value of BigDecimal
   * @return output string value of BigDecimal input
   */
  private String returnZeroIfNull(BigDecimal bigDecimalInputValue) {

    return String.valueOf(Objects.requireNonNullElse(bigDecimalInputValue, BigDecimal.ZERO));
  }

  /**
   * Get all country infrmation
   *
   * @param correlationId
   * @return CountrysResponse
   * @throws GenericServiceException
   */
  public CountrysResponse getAllCountrys(String correlationId) throws GenericServiceException {

    com.google.protobuf.Empty.Builder builder = Empty.newBuilder();
    CountryReply countryReply = portInfoServiceBlockingStub.getAllCountries(builder.build());
    if (!SUCCESS.equals(countryReply.getResponseStatus().getStatus())) {
      throw new GenericServiceException(
          "failed to get country information ",
          countryReply.getResponseStatus().getCode(),
          HttpStatusCode.valueOf(Integer.valueOf(countryReply.getResponseStatus().getCode())));
    }
    CountrysResponse response = new CountrysResponse();
    List<CountryInfo> countryList = new ArrayList<>();
    List<Country> countriesList = countryReply.getCountriesList();
    countriesList.forEach(
        country -> {
          CountryInfo countryInfo = new CountryInfo();
          countryInfo.setId(country.getId());
          countryInfo.setName(country.getCountryName());
          countryList.add(countryInfo);
        });
    response.setCountrys(countryList);
    response.setResponseStatus(
        new CommonSuccessResponse(String.valueOf(HttpStatus.OK.value()), correlationId));
    return response;
  }

  /**
   * Save/Update Port Info
   *
   * @param portId
   * @param correlationId
   * @param portDetailed
   * @return
   * @throws GenericServiceException
   */
  public PortDetailResponse savePortInfo(
      Long portId, String correlationId, PortDetails portDetailed) throws GenericServiceException {
    PortDetailResponse response = new PortDetailResponse();
    PortDetail.Builder portDetailRequest = PortDetail.newBuilder();
    buildPortDetailed(portDetailed, portId, portDetailRequest);
    PortInfoReply portInfoReply =
        portInfoServiceBlockingStub.savePortInfo(portDetailRequest.build());

    if (portInfoReply == null
        || !SUCCESS.equalsIgnoreCase(portInfoReply.getResponseStatus().getStatus()))
      throw new GenericServiceException(
          "Error in calling cargo service!",
          CommonErrorCodes.E_GEN_INTERNAL_ERR,
          HttpStatusCode.INTERNAL_SERVER_ERROR);

    buildPortInfoResponse(response, portInfoReply);
    response.setResponseStatus(
        new CommonSuccessResponse(String.valueOf(HttpStatus.OK.value()), correlationId));
    return response;
  }

  /**
   * Building PortDetails Builder
   *
   * @param portDetailed
   * @param portId
   * @param portDetailRequest
   */
  private void buildPortDetailed(
      PortDetails portDetailed, long portId, PortDetail.Builder portDetailRequest) {
    portDetailRequest.setId(portId);
    portDetailRequest.setCountryName(
        portDetailed.getCountryName() == null ? "" : portDetailed.getCountryName());
    portDetailRequest.setCountryId(
        portDetailed.getCountryId() == null ? 0L : portDetailed.getCountryId());
    portDetailRequest.setWaterDensity(
        portDetailed.getDensityOfWater() == null
            ? ""
            : portDetailed.getDensityOfWater().toString());
    portDetailRequest.setMaxPermissibleDraft(
        portDetailed.getMaxPermissibleDraft() == null
            ? ""
            : portDetailed.getMaxPermissibleDraft().toString());
    portDetailRequest.setCode(portDetailed.getPortCode());
    portDetailRequest.setName(portDetailed.getPortName());
    portDetailRequest.setTimezoneId(
        portDetailed.getTimezoneId() == null ? 0 : portDetailed.getTimezoneId());
    portDetailRequest.setTimezone(
        portDetailed.getTimezone() == null ? "" : portDetailed.getTimezone());
    portDetailRequest.setTimezoneAbbreviation(
        portDetailed.getTimezoneAbbreviation() == null
            ? ""
            : portDetailed.getTimezoneAbbreviation());
    portDetailRequest.setTimezoneOffsetVal(
        portDetailed.getTimezoneOffsetVal() == null ? "" : portDetailed.getTimezoneAbbreviation());
    portDetailRequest.setTideHeightTo(
        portDetailed.getTideHeightHigh() == null
            ? ""
            : portDetailed.getTideHeightHigh().toString());
    portDetailRequest.setTideHeightFrom(
        portDetailed.getTideHeightLow() == null ? "" : portDetailed.getTideHeightLow().toString());
    portDetailRequest.setLat(portDetailed.getLatitude() == null ? "" : portDetailed.getLatitude());
    portDetailRequest.setLon(
        portDetailed.getLongitude() == null ? "" : portDetailed.getLongitude());
    portDetailRequest.setAmbientTemperature(
        portDetailed.getAmbientTemperature() == null
            ? ""
            : portDetailed.getAmbientTemperature().toString());
    buildBerthInfoForPort(portDetailed.getBerthInfo(), portDetailRequest);
  }

  /**
   * Building BerthDetail builder
   *
   * @param portBerthInfoResponseList berth details from payload
   * @param portDetailRequest grpc request builder of port details
   */
  public void buildBerthInfoForPort(
      List<PortBerthInfoResponse> portBerthInfoResponseList, PortDetail.Builder portDetailRequest) {

    if (portBerthInfoResponseList == null) return;
    portBerthInfoResponseList.forEach(
        portBerthInfoResponse -> {
          BerthDetail.Builder berthDetail = BerthDetail.newBuilder();
          berthDetail.setId(portBerthInfoResponse.getBerthId());
          berthDetail.setBerthName(
              portBerthInfoResponse.getBerthName() == null
                  ? ""
                  : portBerthInfoResponse.getBerthName());
          berthDetail.setBerthDatumDepth(
              portBerthInfoResponse.getDepthInDatum() == null
                  ? ""
                  : portBerthInfoResponse.getDepthInDatum().toString());
          berthDetail.setMaxDwt(
              portBerthInfoResponse.getMaxDwt() == null
                  ? ""
                  : portBerthInfoResponse.getMaxDwt().toString());
          berthDetail.setMaxManifoldHeight(
              portBerthInfoResponse.getMaxManifoldHeight() == null
                  ? ""
                  : portBerthInfoResponse.getMaxManifoldHeight().toString());
          berthDetail.setMaxShipDepth(
              portBerthInfoResponse.getMaxShipDepth() == null
                  ? ""
                  : portBerthInfoResponse.getMaxShipDepth().toString());
          berthDetail.setPortId(portBerthInfoResponse.getPortId());
          berthDetail.setRegulationAndRestriction(
              portBerthInfoResponse.getRegulationAndRestriction() == null
                  ? ""
                  : portBerthInfoResponse.getRegulationAndRestriction());
          berthDetail.setMaxLoa(
              portBerthInfoResponse.getMaxLoa() == null
                  ? ""
                  : portBerthInfoResponse.getMaxLoa().toString());
          berthDetail.setUkc(
              portBerthInfoResponse.getMinUKC() == null ? "" : portBerthInfoResponse.getMinUKC());

          berthDetail.setMaxDraft(
              portBerthInfoResponse.getMaxDraft() == null
                  ? ""
                  : portBerthInfoResponse.getMaxDraft().toString());
          buildManifoldDetails(portBerthInfoResponse.getManifoldDetails(), berthDetail);
          portDetailRequest.addBerthDetails(berthDetail);
        });
  }

  /**
   * Builds manifold details from payload
   *
   * @param manifoldDetails list of manifold details from payload
   * @param berthDetail berth details builder for grpc
   * @see #buildManifoldDetails(List, PortBerthInfoResponse)
   */
  private void buildManifoldDetails(
      List<ManifoldDetail> manifoldDetails, BerthDetail.Builder berthDetail) {

    log.info("Inside buildManifoldDetails method!");
    if (!CollectionUtils.isEmpty(manifoldDetails)) {

      manifoldDetails.forEach(
          manifoldDetail -> {
            PortInfo.ManifoldDetail.Builder manifoldDetailBuilder =
                PortInfo.ManifoldDetail.newBuilder();

            // Set fields
            Optional.ofNullable(manifoldDetail.getManifoldName())
                .ifPresent(manifoldDetailBuilder::setManifoldName);
            Optional.ofNullable(manifoldDetail.getConnectionNumber())
                .ifPresent(manifoldDetailBuilder::setConnectionNumber);
            Optional.ofNullable(manifoldDetail.getManifoldSize())
                .ifPresent(manifoldDetailBuilder::setManifoldSize);
            Optional.ofNullable(manifoldDetail.getMaxLoadingRate())
                .ifPresent(manifoldDetailBuilder::setMaxLoadingRate);
            Optional.ofNullable(manifoldDetail.getMaxDischargeRate())
                .ifPresent(manifoldDetailBuilder::setMaxDischargeRate);

            manifoldDetailBuilder.setManifoldHeight(
                returnZeroIfNull(manifoldDetail.getManifoldHeight()));
            manifoldDetailBuilder.setMaxPressure(returnZeroIfNull(manifoldDetail.getMaxPressure()));

            berthDetail.addManifoldDetails(manifoldDetailBuilder.build());
          });
    }
  }

  /**
   * Preparing response
   *
   * @param response
   * @param portInfoReply
   */
  public void buildPortInfoResponse(PortDetailResponse response, PortInfoReply portInfoReply) {

    PortDetails portDetails = new PortDetails();

    PortDetail portDetail = portInfoReply.getPort();
    portDetails.setCountryName(portDetail.getCountryName());
    portDetails.setCountryId(portDetail.getCountryId());
    portDetails.setDensityOfWater(returnZeroIfBlank(portDetail.getWaterDensity()));
    portDetails.setMaxPermissibleDraft(returnZeroIfBlank(portDetail.getMaxPermissibleDraft()));
    portDetails.setPortCode(portDetail.getCode());
    portDetails.setPortId(portDetail.getId());
    portDetails.setPortName(portDetail.getName());

    portDetails.setTimezoneId(portDetail.getTimezoneId());
    portDetails.setTimezone(portDetail.getTimezone());
    portDetails.setTimezoneAbbreviation(portDetail.getTimezoneAbbreviation());
    portDetails.setTimezoneOffsetVal(portDetail.getTimezoneOffsetVal());
    portDetails.setTideHeightHigh(returnZeroIfBlank(portDetail.getTideHeightTo()));
    portDetails.setTideHeightLow(returnZeroIfBlank(portDetail.getTideHeightFrom()));
    portDetails.setLatitude(portDetail.getLat());
    portDetails.setLongitude(portDetail.getLon());
    portDetails.setAmbientTemperature(returnZeroIfBlank(portDetail.getAmbientTemperature()));

    List<PortBerthInfoResponse> berthList =
        setBerthInformationForThePorts(portDetail.getBerthDetailsList());
    portDetails.setBerthInfo(berthList);
    response.setPortDetails(portDetails);
  }
}
