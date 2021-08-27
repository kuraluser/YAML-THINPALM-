/* Licensed at AlphaOri Technologies */
package com.cpdss.gateway.controller;

import static com.cpdss.gateway.common.GatewayConstants.*;

import com.cpdss.common.exception.CommonRestException;
import com.cpdss.common.exception.GenericServiceException;
import com.cpdss.common.rest.CommonErrorCodes;
import com.cpdss.common.utils.HttpStatusCode;
import com.cpdss.gateway.domain.*;
import com.cpdss.gateway.service.DischargeStudyService;
import com.cpdss.gateway.service.LoadableStudyService;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/** @Author jerin.g */
@Log4j2
@Validated
@RestController
@RequestMapping({"/api/cloud", "/api/ship"})
public class DischargeStudyController {

  private static final String CORRELATION_ID_HEADER = "correlationId";

  @Autowired private DischargeStudyService dischargeStudyService;

  @Autowired private LoadableStudyService loadableStudyService;

  /**
   * @param vesselId
   * @param voyageId
   * @param dischargeStudiesId
   * @param headers
   * @throws CommonRestException void
   */
  @PostMapping(
      "/vessels/{vesselId}/voyages/{voyageId}/discharge-studies/{dischargeStudiesId}/generate-discharge-patterns")
  public AlgoPatternResponse generateDischargePatterns(
      @PathVariable @Min(value = 1, message = CommonErrorCodes.E_HTTP_BAD_REQUEST) Long vesselId,
      @PathVariable @Min(value = 1, message = CommonErrorCodes.E_HTTP_BAD_REQUEST) Long voyageId,
      @PathVariable @Min(value = 1, message = CommonErrorCodes.E_HTTP_BAD_REQUEST)
          Long dischargeStudiesId,
      @RequestHeader HttpHeaders headers)
      throws CommonRestException {
    try {
      log.info(
          "call Discharge study ALGO. correlationId: {} ", headers.getFirst(CORRELATION_ID_HEADER));
      return dischargeStudyService.generateDischargePatterns(
          vesselId, voyageId, dischargeStudiesId, headers.getFirst(CORRELATION_ID_HEADER));
    } catch (GenericServiceException e) {
      log.error("GenericServiceException in calling ALGO ", e);
      throw new CommonRestException(e.getCode(), headers, e.getStatus(), e.getMessage(), e);
    } catch (Exception e) {
      log.error("Error in calling ALGO ", e);
      throw new CommonRestException(
          CommonErrorCodes.E_GEN_INTERNAL_ERR,
          headers,
          HttpStatusCode.SERVICE_UNAVAILABLE,
          e.getMessage(),
          e);
    }
  }

  /**
   * @param vesselId
   * @param voyageId
   * @param dischargeStudyId
   * @param headers
   * @return
   * @throws CommonRestException LoadableStudyStatusResponse Reusing Loadable Study API with new URI
   *     since workflow is same
   */
  @PostMapping(
      value =
          "/vessels/{vesselId}/voyages/{voyageId}/discharge-studies/{dischargeStudyId}/discharge-pattern-status")
  public LoadableStudyStatusResponse getDischargeStudyStatus(
      @PathVariable @Min(value = 1, message = CommonErrorCodes.E_HTTP_BAD_REQUEST) Long vesselId,
      @PathVariable @Min(value = 1, message = CommonErrorCodes.E_HTTP_BAD_REQUEST) Long voyageId,
      @PathVariable @Min(value = 1, message = CommonErrorCodes.E_HTTP_BAD_REQUEST)
          Long dischargeStudyId,
      @RequestBody LoadablePlanRequest loadablePlanRequest,
      @RequestHeader HttpHeaders headers)
      throws CommonRestException {
    try {
      log.info("getDischargeStudyStatus with process id ", loadablePlanRequest.getProcessId());
      return this.loadableStudyService.getLoadableStudyStatus(
          dischargeStudyId, loadablePlanRequest, headers.getFirst(CORRELATION_ID_HEADER));
    } catch (GenericServiceException e) {
      log.error("GenericServiceException when get Discharge Study status", e);
      throw new CommonRestException(e.getCode(), headers, e.getStatus(), e.getMessage(), e);
    } catch (Exception e) {
      log.error("Exception when get Discharge Study status", e);
      throw new CommonRestException(
          CommonErrorCodes.E_GEN_INTERNAL_ERR,
          headers,
          HttpStatusCode.INTERNAL_SERVER_ERROR,
          e.getMessage(),
          e);
    }
  }

  /**
   * @param vesselId
   * @param voyageId
   * @param loadableStudyId
   * @param request
   * @param headers
   * @return
   * @throws CommonRestException AlgoStatusResponse Reusing Loadable Study API with new URI since
   *     workflow is same
   */
  @PostMapping(
      value =
          "/vessels/{vesselId}/voyages/{voyageId}/discharge-studies/{dischargeStudyId}/discharge-study-status")
  public AlgoStatusResponse updateDischargeStudyStatus(
      @PathVariable @Min(value = 1, message = CommonErrorCodes.E_HTTP_BAD_REQUEST) Long vesselId,
      @PathVariable @Min(value = 1, message = CommonErrorCodes.E_HTTP_BAD_REQUEST) Long voyageId,
      @PathVariable @Min(value = 1, message = CommonErrorCodes.E_HTTP_BAD_REQUEST)
          Long loadableStudyId,
      @RequestBody AlgoStatusRequest request,
      @RequestHeader HttpHeaders headers)
      throws CommonRestException {
    try {
      log.info("updateDischargeStudyStatus with process id - ", request.getProcessId());
      return this.loadableStudyService.saveAlgoLoadableStudyStatus(
          request, headers.getFirst(CORRELATION_ID_HEADER));
    } catch (GenericServiceException e) {
      log.error("GenericServiceException when updating Discharge Study status", e);
      throw new CommonRestException(e.getCode(), headers, e.getStatus(), e.getMessage(), e);
    } catch (Exception e) {
      log.error("Exception when updating Discharge Study status", e);
      throw new CommonRestException(
          CommonErrorCodes.E_GEN_INTERNAL_ERR,
          headers,
          HttpStatusCode.INTERNAL_SERVER_ERROR,
          e.getMessage(),
          e);
    }
  }

  /**
   * @param vesselId
   * @param voyageId
   * @param dischargeStudiesId
   * @param headers
   * @return
   * @throws CommonRestException LoadablePatternResponse Save Algo reply to data base API - This API
   *     is consumed by Algo
   */
  @PostMapping(
      "/vessels/{vesselId}/voyages/{voyageId}/discharge-studies/{dischargeStudiesId}/discharge-patterns")
  public AlgoPatternResponse saveDischargePatterns(
      @PathVariable @Min(value = 1, message = CommonErrorCodes.E_HTTP_BAD_REQUEST) Long vesselId,
      @PathVariable @Min(value = 1, message = CommonErrorCodes.E_HTTP_BAD_REQUEST) Long voyageId,
      @PathVariable @Min(value = 1, message = CommonErrorCodes.E_HTTP_BAD_REQUEST)
          Long dischargeStudiesId,
      @RequestBody LoadablePlanRequest dischargePlanRequest,
      @RequestHeader HttpHeaders headers)
      throws CommonRestException {
    try {
      log.info("saveDischargePatterns : {}", getClientIp());
      log.info(
          "saveDischargePatterns API. correlationId: {} ", headers.getFirst(CORRELATION_ID_HEADER));
      return loadableStudyService.saveAlgoPatterns(
          dischargePlanRequest,
          dischargeStudiesId,
          DISCHARGE_STUDY_SAVE_REQUEST,
          headers.getFirst(CORRELATION_ID_HEADER));
    } catch (GenericServiceException e) {
      log.error("GenericServiceException in saveLoadablePatterns ", e);
      throw new CommonRestException(e.getCode(), headers, e.getStatus(), e.getMessage(), e);
    } catch (Exception e) {
      log.error("Error in saveLoadablePatterns ", e);
      throw new CommonRestException(
          CommonErrorCodes.E_GEN_INTERNAL_ERR,
          headers,
          HttpStatusCode.INTERNAL_SERVER_ERROR,
          e.getMessage(),
          e);
    }
  }

  /**
   * Returns the caller ip for debugging
   *
   * @return
   */
  private static String getClientIp() {
    HttpServletRequest curRequest =
        ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    String remoteAddr = "";
    remoteAddr = curRequest.getHeader("X-FORWARDED-FOR");
    if (remoteAddr == null || "".equals(remoteAddr)) {
      remoteAddr = curRequest.getRemoteAddr();
    }
    return remoteAddr;
  }

  /**
   * To save rule against discharge study
   *
   * @param vesselId
   * @param dischargeStudyId
   * @param sectionId
   * @param dischargeRuleRequest
   * @param headers
   * @return
   * @throws CommonRestException
   */
  @PostMapping(
      value =
          "/discharge-study-rule/vessels/{vesselId}/ruleMasterSectionId/{sectionId}/dischargeStudyId/{dischargeStudyId}",
      produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public RuleResponse saveRulesForDischargeStudy(
      @PathVariable @Min(value = 1, message = CommonErrorCodes.E_HTTP_BAD_REQUEST) Long vesselId,
      @PathVariable @Min(value = 1, message = CommonErrorCodes.E_HTTP_BAD_REQUEST)
          Long dischargeStudyId,
      @PathVariable
          @Min(value = 1, message = CommonErrorCodes.E_HTTP_BAD_REQUEST)
          @Max(value = 3, message = CommonErrorCodes.E_HTTP_BAD_REQUEST)
          Long sectionId,
      @RequestBody RuleRequest dischargeRuleRequest,
      @RequestHeader HttpHeaders headers)
      throws CommonRestException {
    try {
      return this.dischargeStudyService.getOrSaveRulesForDischargeStudy(
          vesselId,
          sectionId,
          dischargeStudyId,
          dischargeRuleRequest,
          headers.getFirst(CORRELATION_ID_HEADER));
    } catch (GenericServiceException e) {
      log.error("GenericServiceException when saving rules against discharge study", e);
      throw new CommonRestException(e.getCode(), headers, e.getStatus(), e.getMessage(), e);
    } catch (Exception e) {
      log.error("Exception when saving rules for discharge study", e);
      throw new CommonRestException(
          CommonErrorCodes.E_GEN_INTERNAL_ERR,
          headers,
          HttpStatusCode.INTERNAL_SERVER_ERROR,
          e.getMessage(),
          e);
    }
  }

  /**
   * To retrieve rule against discharge study
   *
   * @param vesselId
   * @param dischargeStudyId
   * @param sectionId
   * @param headers
   * @return
   * @throws CommonRestException
   */
  @GetMapping(
      value =
          "/discharge-study-rule/vessels/{vesselId}/ruleMasterSectionId/{sectionId}/dischargeStudyId/{dischargeStudyId}",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public RuleResponse getRulesForLoadableStudy(
      @PathVariable @Min(value = 1, message = CommonErrorCodes.E_HTTP_BAD_REQUEST) Long vesselId,
      @PathVariable @Min(value = 1, message = CommonErrorCodes.E_HTTP_BAD_REQUEST)
          Long dischargeStudyId,
      @PathVariable
          @Min(value = 1, message = CommonErrorCodes.E_HTTP_BAD_REQUEST)
          @Max(value = 3, message = CommonErrorCodes.E_HTTP_BAD_REQUEST)
          Long sectionId,
      @RequestHeader HttpHeaders headers)
      throws CommonRestException {
    try {
      return this.dischargeStudyService.getOrSaveRulesForDischargeStudy(
          vesselId, sectionId, dischargeStudyId, null, headers.getFirst(CORRELATION_ID_HEADER));
    } catch (GenericServiceException e) {
      log.error("GenericServiceException when fetching rules against discharge study", e);
      throw new CommonRestException(e.getCode(), headers, e.getStatus(), e.getMessage(), e);
    } catch (Exception e) {
      log.error("Exception when fetching rules for discharge study", e);
      throw new CommonRestException(
          CommonErrorCodes.E_GEN_INTERNAL_ERR,
          headers,
          HttpStatusCode.INTERNAL_SERVER_ERROR,
          e.getMessage(),
          e);
    }
  }
}
