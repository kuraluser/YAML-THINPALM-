/* Licensed under Apache-2.0 */
package com.cpdss.gateway.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.cpdss.common.exception.GenericServiceException;
import com.cpdss.common.rest.CommonErrorCodes;
import com.cpdss.common.utils.HttpStatusCode;
import com.cpdss.gateway.GatewayTestConfiguration;
import com.cpdss.gateway.domain.CargoNomination;
import com.cpdss.gateway.domain.CargoNominationResponse;
import com.cpdss.gateway.domain.DischargingPortRequest;
import com.cpdss.gateway.domain.LoadableStudy;
import com.cpdss.gateway.domain.LoadableStudyResponse;
import com.cpdss.gateway.domain.OnHandQuantity;
import com.cpdss.gateway.domain.LoadingPort;
import com.cpdss.gateway.domain.OnHandQuantityResponse;
import com.cpdss.gateway.domain.PortRotation;
import com.cpdss.gateway.domain.PortRotationResponse;
import com.cpdss.gateway.domain.VoyageResponse;
import com.cpdss.gateway.service.LoadableStudyService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * Test class for {@link LoadableStudyController}
 *
 * @author suhail.k
 */
@MockitoSettings
@WebMvcTest(controllers = LoadableStudyController.class)
@AutoConfigureMockMvc(addFilters = false)
@ContextConfiguration(classes = {GatewayTestConfiguration.class})
class LoadableStudyControllerTest {

  @Autowired private MockMvc mockMvc;

  @MockBean private LoadableStudyService loadableStudyService;

  @MockBean private CargoNominationResponse cargoNominationResponse;

  private static final String CORRELATION_ID_HEADER = "correlationId";
  private static final String CORRELATION_ID_HEADER_VALUE = "1234";
  private static final Long TEST_VESSEL_ID = 1L;
  private static final Long TEST_VOYAGE_ID = 1L;

  private static final String CHARTERER = "charterer";
  private static final String DRAFT_MARK = "1000";
  private static final Long LOAD_LINE_ID = 1L;
  private static final String LOADABLE_STUDY_NAME = "LS-01";
  private static final String NAME = "name";
  private static final String CHARTERER_LITERAL = "charterer";
  private static final String DRAFT_MARK_LITERAL = "draftMark";
  private static final String LOAD_LINE_ID_LITERAL = "loadLineXId";
  private static final Long TEST_LODABLE_STUDY_ID = 1L;
  private static final BigDecimal TEST_BIGDECIMAL_VALUE = new BigDecimal(100);
  // API URLS
  private static final String CLOUD_API_URL_PREFIX = "/api/cloud";
  private static final String SHIP_API_URL_PREFIX = "/api/cloud";
  private static final String LOADABLE_STUDY_LIST_API_URL =
      "/vessels/{vesselId}/voyages/{voyageId}/loadable-studies";
  private static final String LOADABLE_STUDY_LIST_CLOUD_API_URL =
      CLOUD_API_URL_PREFIX + LOADABLE_STUDY_LIST_API_URL;
  private static final String LOADABLE_STUDY_LIST_SHIP_API_URL =
      SHIP_API_URL_PREFIX + LOADABLE_STUDY_LIST_API_URL;
  private static final String LOADABLE_STUDY_SAVE_API_URL =
      "/vessels/{vesselId}/voyages/{voyageId}/loadable-studies/{loadableStudyId}";
  private static final String LOADABLE_STUDY_SAVE_SHIP_API_URL =
      SHIP_API_URL_PREFIX + LOADABLE_STUDY_SAVE_API_URL;
  private static final String LOADABLE_STUDY_SAVE_CLOUD_API_URL =
      CLOUD_API_URL_PREFIX + LOADABLE_STUDY_SAVE_API_URL;

  private static final String PORT_ROTATION_API_URL =
      "/vessels/{vesselId}/voyages/{voyageId}/loadable-studies/{loadableStudyId}/ports";
  private static final String PORT_ROTATION_SHIP_API_URL =
      SHIP_API_URL_PREFIX + PORT_ROTATION_API_URL;
  private static final String PORT_ROTATION_CLOUD_API_URL =
      CLOUD_API_URL_PREFIX + PORT_ROTATION_API_URL;
  private static final String GET_VOYAGES_BY_VESSEL_URL = "/vessels/{vesselId}/voyages";
  private static final String GET_VOYAGES_BY_VESSEL_SHIP_URL =
      SHIP_API_URL_PREFIX + GET_VOYAGES_BY_VESSEL_URL;
  private static final String GET_VOYAGES_BY_VESSEL_CLOUD_URL =
      CLOUD_API_URL_PREFIX + GET_VOYAGES_BY_VESSEL_URL;

  private static final String PORT_ROTATION_SAVE_API_URL =
      "/vessels/{vesselId}/voyages/{voyageId}/loadable-studies/{loadableStudyId}/ports/{id}";
  private static final String PORT_ROTATION_SAVE_CLOUD_API_URL =
      CLOUD_API_URL_PREFIX + PORT_ROTATION_SAVE_API_URL;
  private static final String PORT_ROTATION_SAVE_SHIP_API_URL =
      SHIP_API_URL_PREFIX + PORT_ROTATION_SAVE_API_URL;

  private static final String DISCHARGING_PORTS_SAVE_API_URL =
      "/vessels/{vesselId}/voyages/{voyageId}/loadable-studies/{loadableStudyId}/discharging-ports";
  private static final String DISCHARGING_PORTS_SAVE_CLOUD_API_URL =
      CLOUD_API_URL_PREFIX + DISCHARGING_PORTS_SAVE_API_URL;
  private static final String DISCHARGING_PORTS_SAVE_SHIP_API_URL =
      SHIP_API_URL_PREFIX + DISCHARGING_PORTS_SAVE_API_URL;

  private static final String DELETE_LOADABLE_STUDY_API_URL =
      "/vessels/{vesselId}/voyages/{voyageId}/loadable-studies/{loadableStudyId}";
  private static final String DELETE_LOADABLE_STUDY_CLOUD_API_URL =
      CLOUD_API_URL_PREFIX + DELETE_LOADABLE_STUDY_API_URL;
  private static final String DELETE_LOADABLE_STUDY_SHIP_API_URL =
      SHIP_API_URL_PREFIX + DELETE_LOADABLE_STUDY_API_URL;

  private static final String DELETE_PORT_ROTATION_API_URL =
      "/vessels/{vesselId}/voyages/{voyageId}/loadable-studies/{loadableStudyId}/ports/{id}";
  private static final String DELETE_PORT_ROTATION_CLOUD_API_URL =
      CLOUD_API_URL_PREFIX + DELETE_PORT_ROTATION_API_URL;
  private static final String DELETE_PORT_ROTATION_SHIP_API_URL =
      SHIP_API_URL_PREFIX + DELETE_PORT_ROTATION_API_URL;

  private static final String GET_ON_HAND_QUANTITIES_API_URL =
      "/vessels/{vesselId}/voyages/{voyageId}/loadable-studies/{loadableStudyId}/ports/{portId}/on-hand-quantities";
  private static final String GET_ON_HAND_QUANTITIES_API_URL_CLOUD_API_URL =
      CLOUD_API_URL_PREFIX + GET_ON_HAND_QUANTITIES_API_URL;
  private static final String GET_ON_HAND_QUANTITIES_SHIP_API_URL =
      SHIP_API_URL_PREFIX + GET_ON_HAND_QUANTITIES_API_URL;
  private static final String SAVE_ON_HAND_QUANTITIES_API_URL =
      "/vessels/{vesselId}/voyages/{voyageId}/loadable-studies/{loadableStudyId}/ports/{portId}/on-hand-quantities/{id}";
  private static final String SAVE_ON_HAND_QUANTITIES_API_URL_CLOUD_API_URL =
      CLOUD_API_URL_PREFIX + SAVE_ON_HAND_QUANTITIES_API_URL;
  private static final String SAVE_ON_HAND_QUANTITIES_SHIP_API_URL =
      SHIP_API_URL_PREFIX + SAVE_ON_HAND_QUANTITIES_API_URL;
  private static final String AUTHORIZATION_HEADER = "Authorization";

  /**
   * Positive test case. Test method for positive response scenario
   *
   * @throws Exception
   */
  @ValueSource(strings = {LOADABLE_STUDY_LIST_CLOUD_API_URL, LOADABLE_STUDY_LIST_SHIP_API_URL})
  @ParameterizedTest
  void testGetLoadableStudyByVoyage(String url) throws Exception {
    when(this.loadableStudyService.getLoadableStudies(anyLong(), anyLong(), anyLong(), anyString()))
        .thenReturn(new LoadableStudyResponse());
    this.mockMvc
        .perform(
            MockMvcRequestBuilders.get(url, TEST_VESSEL_ID, TEST_VOYAGE_ID)
                .header(CORRELATION_ID_HEADER, CORRELATION_ID_HEADER_VALUE)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().isOk());
  }

  /**
   * Negative test case. Test method for generic service exception scenario
   *
   * @param url
   * @throws Exception
   */
  @ValueSource(strings = {LOADABLE_STUDY_LIST_CLOUD_API_URL, LOADABLE_STUDY_LIST_SHIP_API_URL})
  @ParameterizedTest
  void testGetLoadableStudyByVoyageServiceException(String url) throws Exception {
    when(this.loadableStudyService.getLoadableStudies(anyLong(), anyLong(), anyLong(), anyString()))
        .thenThrow(
            new GenericServiceException(
                "service exception",
                CommonErrorCodes.E_GEN_INTERNAL_ERR,
                HttpStatusCode.INTERNAL_SERVER_ERROR));
    this.mockMvc
        .perform(
            MockMvcRequestBuilders.get(url, TEST_VESSEL_ID, TEST_VOYAGE_ID)
                .header(CORRELATION_ID_HEADER, CORRELATION_ID_HEADER_VALUE)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().isInternalServerError());
  }

  /**
   * Negative test case. Test method for general run time exceptions
   *
   * @param url
   * @throws Exception
   */
  @ValueSource(strings = {LOADABLE_STUDY_LIST_CLOUD_API_URL, LOADABLE_STUDY_LIST_SHIP_API_URL})
  @ParameterizedTest
  void testGetLoadableStudyByVoyageRuntimeException(String url) throws Exception {
    when(this.loadableStudyService.getLoadableStudies(anyLong(), anyLong(), anyLong(), anyString()))
        .thenThrow(RuntimeException.class);
    this.mockMvc
        .perform(
            MockMvcRequestBuilders.get(url, TEST_VESSEL_ID, TEST_VOYAGE_ID)
                .header(CORRELATION_ID_HEADER, CORRELATION_ID_HEADER_VALUE)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().isInternalServerError());
  }

  /**
   * Test method for loadable study save operation
   *
   * @throws Exception
   */
  @ValueSource(strings = {LOADABLE_STUDY_SAVE_CLOUD_API_URL, LOADABLE_STUDY_SAVE_SHIP_API_URL})
  @ParameterizedTest
  void testSaveLoadableStudy(String url) throws Exception {
    when(this.loadableStudyService.saveLoadableStudy(any(LoadableStudy.class), anyString(), any()))
        .thenReturn(new LoadableStudyResponse());
    MockMultipartFile firstFile =
        new MockMultipartFile("files", "filename.pdf", "text/plain", "test".getBytes());
    this.mockMvc
        .perform(
            MockMvcRequestBuilders.multipart(url, TEST_VESSEL_ID, TEST_VOYAGE_ID, 0L)
                .file(firstFile)
                .param(NAME, LOADABLE_STUDY_NAME)
                .param(CHARTERER_LITERAL, CHARTERER)
                .param(DRAFT_MARK_LITERAL, DRAFT_MARK)
                .param(LOAD_LINE_ID_LITERAL, String.valueOf(LOAD_LINE_ID))
                .header(CORRELATION_ID_HEADER, CORRELATION_ID_HEADER_VALUE)
                .contentType(MediaType.MULTIPART_FORM_DATA_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().isOk());
  }

  /**
   * Test method for loadable study save operation
   *
   * @throws Exception
   */
  @ValueSource(strings = {LOADABLE_STUDY_SAVE_CLOUD_API_URL, LOADABLE_STUDY_SAVE_SHIP_API_URL})
  @ParameterizedTest
  void testSaveLoadableStudyServiceException(String url) throws Exception {
    when(this.loadableStudyService.saveLoadableStudy(any(LoadableStudy.class), anyString(), any()))
        .thenThrow(
            new GenericServiceException(
                "service exception",
                CommonErrorCodes.E_GEN_INTERNAL_ERR,
                HttpStatusCode.INTERNAL_SERVER_ERROR));
    MockMultipartFile firstFile =
        new MockMultipartFile("files", "filename.pdf", "text/plain", "test".getBytes());
    this.mockMvc
        .perform(
            MockMvcRequestBuilders.multipart(url, TEST_VESSEL_ID, TEST_VOYAGE_ID, 0L)
                .file(firstFile)
                .param(NAME, LOADABLE_STUDY_NAME)
                .param(CHARTERER_LITERAL, CHARTERER)
                .param(DRAFT_MARK_LITERAL, DRAFT_MARK)
                .param(LOAD_LINE_ID_LITERAL, String.valueOf(LOAD_LINE_ID))
                .header(CORRELATION_ID_HEADER, CORRELATION_ID_HEADER_VALUE)
                .contentType(MediaType.MULTIPART_FORM_DATA_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().isInternalServerError());
  }

  /**
   * Test method for loadable study save operation
   *
   * @throws Exception
   */
  @ValueSource(strings = {LOADABLE_STUDY_SAVE_CLOUD_API_URL, LOADABLE_STUDY_SAVE_SHIP_API_URL})
  @ParameterizedTest
  void testSaveLoadableStudyRuntimeException(String url) throws Exception {
    when(this.loadableStudyService.saveLoadableStudy(any(LoadableStudy.class), anyString(), any()))
        .thenThrow(RuntimeException.class);
    MockMultipartFile firstFile =
        new MockMultipartFile("files", "filename.pdf", "text/plain", "test".getBytes());
    this.mockMvc
        .perform(
            MockMvcRequestBuilders.multipart(url, TEST_VESSEL_ID, TEST_VOYAGE_ID, 0L)
                .file(firstFile)
                .param(NAME, LOADABLE_STUDY_NAME)
                .param(CHARTERER_LITERAL, CHARTERER)
                .param(DRAFT_MARK_LITERAL, DRAFT_MARK)
                .param(LOAD_LINE_ID_LITERAL, String.valueOf(LOAD_LINE_ID))
                .header(CORRELATION_ID_HEADER, CORRELATION_ID_HEADER_VALUE)
                .contentType(MediaType.MULTIPART_FORM_DATA_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().isInternalServerError());
  }

  /**
   * Test method for port rotation
   *
   * @throws Exception
   */
  @ValueSource(strings = {PORT_ROTATION_CLOUD_API_URL, PORT_ROTATION_SHIP_API_URL})
  @ParameterizedTest
  void testLoadableStudyPortList(String url) throws Exception {
    when(this.loadableStudyService.getLoadableStudyPortRotationList(
            anyLong(), anyLong(), anyLong(), anyString()))
        .thenReturn(new PortRotationResponse());
    this.mockMvc
        .perform(
            MockMvcRequestBuilders.get(url, TEST_VESSEL_ID, TEST_VOYAGE_ID, TEST_LODABLE_STUDY_ID)
                .header(CORRELATION_ID_HEADER, CORRELATION_ID_HEADER_VALUE)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().isOk());
  }

  /**
   * Test method for port rotation
   *
   * @throws Exception
   */
  @ValueSource(strings = {PORT_ROTATION_CLOUD_API_URL, PORT_ROTATION_SHIP_API_URL})
  @ParameterizedTest
  void testLoadableStudyPortListServiceException(String url) throws Exception {
    when(this.loadableStudyService.getLoadableStudyPortRotationList(
            anyLong(), anyLong(), anyLong(), anyString()))
        .thenThrow(
            new GenericServiceException(
                "test", CommonErrorCodes.E_HTTP_BAD_REQUEST, HttpStatusCode.BAD_REQUEST));
    this.mockMvc
        .perform(
            MockMvcRequestBuilders.get(url, TEST_VESSEL_ID, TEST_VOYAGE_ID, TEST_LODABLE_STUDY_ID)
                .header(CORRELATION_ID_HEADER, CORRELATION_ID_HEADER_VALUE)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().isBadRequest());
  }

  /**
   * Test method for port rotation
   *
   * @throws Exception
   */
  @ValueSource(strings = {PORT_ROTATION_CLOUD_API_URL, PORT_ROTATION_SHIP_API_URL})
  @ParameterizedTest
  void testLoadableStudyPortListRuntimeException(String url) throws Exception {
    when(this.loadableStudyService.getLoadableStudyPortRotationList(
            anyLong(), anyLong(), anyLong(), anyString()))
        .thenThrow(RuntimeException.class);
    this.mockMvc
        .perform(
            MockMvcRequestBuilders.get(url, TEST_VESSEL_ID, TEST_VOYAGE_ID, TEST_LODABLE_STUDY_ID)
                .header(CORRELATION_ID_HEADER, CORRELATION_ID_HEADER_VALUE)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().isInternalServerError());
  }

  /**
   * Test method for port rotation
   *
   * @throws Exception
   */
  @ValueSource(strings = {GET_VOYAGES_BY_VESSEL_CLOUD_URL, GET_VOYAGES_BY_VESSEL_SHIP_URL})
  @ParameterizedTest
  void testGetVoyageListByVessel(String url) throws Exception {
    when(this.loadableStudyService.getVoyageListByVessel(anyLong(), anyString()))
        .thenReturn(new VoyageResponse());
    this.mockMvc
        .perform(
            MockMvcRequestBuilders.get(url, TEST_VESSEL_ID)
                .header(CORRELATION_ID_HEADER, CORRELATION_ID_HEADER_VALUE)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().isOk());
  }

  /**
   * Test method for port rotation
   *
   * @throws Exception
   */
  @ValueSource(strings = {GET_VOYAGES_BY_VESSEL_CLOUD_URL, GET_VOYAGES_BY_VESSEL_SHIP_URL})
  @ParameterizedTest
  void testGetVoyageListByVesselServiceException(String url) throws Exception {
    when(this.loadableStudyService.getVoyageListByVessel(anyLong(), anyString()))
        .thenThrow(
            new GenericServiceException(
                "service exception",
                CommonErrorCodes.E_HTTP_BAD_REQUEST,
                HttpStatusCode.BAD_REQUEST));
    this.mockMvc
        .perform(
            MockMvcRequestBuilders.get(url, TEST_VESSEL_ID)
                .header(CORRELATION_ID_HEADER, CORRELATION_ID_HEADER_VALUE)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().isBadRequest());
  }

  /**
   * Test method for port rotation
   *
   * @throws Exception
   */
  @ValueSource(strings = {GET_VOYAGES_BY_VESSEL_CLOUD_URL, GET_VOYAGES_BY_VESSEL_SHIP_URL})
  @ParameterizedTest
  void testGetVoyageListByVesselRuntimeException(String url) throws Exception {
    when(this.loadableStudyService.getVoyageListByVessel(anyLong(), anyString()))
        .thenThrow(RuntimeException.class);
    this.mockMvc
        .perform(
            MockMvcRequestBuilders.get(url, TEST_VESSEL_ID)
                .header(CORRELATION_ID_HEADER, CORRELATION_ID_HEADER_VALUE)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().isInternalServerError());
  }

  @ValueSource(strings = {PORT_ROTATION_SAVE_CLOUD_API_URL, PORT_ROTATION_SAVE_SHIP_API_URL})
  @ParameterizedTest
  void testSavePortRotation(String url) throws Exception {
    when(this.loadableStudyService.savePortRotation(any(PortRotation.class), anyString()))
        .thenReturn(new PortRotationResponse());
    this.mockMvc
        .perform(
            MockMvcRequestBuilders.post(url, TEST_VESSEL_ID, TEST_VOYAGE_ID, 1, 0)
                .content(this.createPortRotationRequest())
                .header(CORRELATION_ID_HEADER, CORRELATION_ID_HEADER_VALUE)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().isOk());
    ;
  }

  @ValueSource(strings = {PORT_ROTATION_SAVE_CLOUD_API_URL, PORT_ROTATION_SAVE_SHIP_API_URL})
  @ParameterizedTest
  void testSavePortRotationServiceException(String url) throws Exception {
    when(this.loadableStudyService.savePortRotation(any(PortRotation.class), anyString()))
        .thenThrow(
            new GenericServiceException(
                "service exception",
                CommonErrorCodes.E_HTTP_BAD_REQUEST,
                HttpStatusCode.BAD_REQUEST));
    this.mockMvc
        .perform(
            MockMvcRequestBuilders.post(url, TEST_VESSEL_ID, TEST_VOYAGE_ID, 1, 0)
                .content(this.createPortRotationRequest())
                .header(CORRELATION_ID_HEADER, CORRELATION_ID_HEADER_VALUE)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().isBadRequest());
    ;
  }

  @ValueSource(strings = {PORT_ROTATION_SAVE_CLOUD_API_URL, PORT_ROTATION_SAVE_SHIP_API_URL})
  @ParameterizedTest
  void testSavePortRotationRuntimeException(String url) throws Exception {
    when(this.loadableStudyService.savePortRotation(any(PortRotation.class), anyString()))
        .thenThrow(RuntimeException.class);
    this.mockMvc
        .perform(
            MockMvcRequestBuilders.post(url, TEST_VESSEL_ID, TEST_VOYAGE_ID, 1, 0)
                .content(this.createPortRotationRequest())
                .header(CORRELATION_ID_HEADER, CORRELATION_ID_HEADER_VALUE)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().isInternalServerError());
    ;
  }

  private String createPortRotationRequest() throws JsonProcessingException {
    PortRotation request = new PortRotation();
    request.setDistanceBetweenPorts(TEST_BIGDECIMAL_VALUE);
    request.setEta(LocalDateTime.now().toString());
    request.setEtd(request.getEta());
    request.setLayCanFrom(LocalDate.now().toString());
    request.setLayCanTo(request.getLayCanFrom());
    request.setLoadableStudyId(1L);
    ObjectMapper mapper = new ObjectMapper();
    return mapper.writeValueAsString(request);
  }

  @ValueSource(
      strings = {DISCHARGING_PORTS_SAVE_CLOUD_API_URL, DISCHARGING_PORTS_SAVE_SHIP_API_URL})
  @ParameterizedTest
  void testsaveDischargingPorts(String url) throws Exception {
    when(this.loadableStudyService.saveDischargingPorts(
            any(DischargingPortRequest.class), anyString()))
        .thenReturn(new PortRotationResponse());
    this.mockMvc
        .perform(
            MockMvcRequestBuilders.post(url, TEST_VESSEL_ID, TEST_VOYAGE_ID, 1L)
                .content(this.createDischargingPortRequest())
                .header(CORRELATION_ID_HEADER, CORRELATION_ID_HEADER_VALUE)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().isOk());
    ;
  }

  @ValueSource(classes = {GenericServiceException.class, RuntimeException.class})
  @ParameterizedTest
  void testsaveDischargingPortsException(Class<? extends Exception> exceptionClass)
      throws Exception {
    Exception ex = new RuntimeException();
    if (exceptionClass == GenericServiceException.class) {
      ex =
          new GenericServiceException(
              "exception",
              CommonErrorCodes.E_GEN_INTERNAL_ERR,
              HttpStatusCode.INTERNAL_SERVER_ERROR);
    }
    when(this.loadableStudyService.saveDischargingPorts(
            any(DischargingPortRequest.class), anyString()))
        .thenThrow(ex);
    this.mockMvc
        .perform(
            MockMvcRequestBuilders.post(
                    DISCHARGING_PORTS_SAVE_CLOUD_API_URL, TEST_VESSEL_ID, TEST_VOYAGE_ID, 1L)
                .content(this.createDischargingPortRequest())
                .header(CORRELATION_ID_HEADER, CORRELATION_ID_HEADER_VALUE)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().isInternalServerError());
    ;
  }

  private String createDischargingPortRequest() throws JsonProcessingException {
    DischargingPortRequest request = new DischargingPortRequest();
    List<Long> ids = new ArrayList<>();
    ids.add(1L);
    request.setPortIds(ids);
    ObjectMapper mapper = new ObjectMapper();
    return mapper.writeValueAsString(request);
  }

  @ValueSource(strings = {DELETE_LOADABLE_STUDY_CLOUD_API_URL, DELETE_LOADABLE_STUDY_SHIP_API_URL})
  @ParameterizedTest
  void testDeleteLoadableStudy(String url) throws Exception {
    when(this.loadableStudyService.deleteLoadableStudy(anyLong(), anyString()))
        .thenReturn(new LoadableStudyResponse());
    this.mockMvc
        .perform(
            MockMvcRequestBuilders.delete(url, TEST_VESSEL_ID, TEST_VOYAGE_ID, 1)
                .header(CORRELATION_ID_HEADER, CORRELATION_ID_HEADER_VALUE)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().isOk());
  }

  @ValueSource(classes = {GenericServiceException.class, RuntimeException.class})
  @ParameterizedTest
  void testDeleteLoadableStudyException(Class<? extends Exception> exceptionClass)
      throws Exception {
    Exception ex = new RuntimeException();
    if (exceptionClass == GenericServiceException.class) {
      ex =
          new GenericServiceException(
              "exception",
              CommonErrorCodes.E_GEN_INTERNAL_ERR,
              HttpStatusCode.INTERNAL_SERVER_ERROR);
    }
    when(this.loadableStudyService.deleteLoadableStudy(anyLong(), anyString())).thenThrow(ex);
    this.mockMvc
        .perform(
            MockMvcRequestBuilders.delete(
                    DELETE_LOADABLE_STUDY_CLOUD_API_URL, TEST_VESSEL_ID, TEST_VOYAGE_ID, 1)
                .header(CORRELATION_ID_HEADER, CORRELATION_ID_HEADER_VALUE)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().isInternalServerError());
  }

  @ValueSource(strings = {DELETE_PORT_ROTATION_CLOUD_API_URL, DELETE_PORT_ROTATION_SHIP_API_URL})
  @ParameterizedTest
  void testDeletePortRotation(String url) throws Exception {
    when(this.loadableStudyService.deletePortRotation(anyLong(), anyLong(), anyString()))
        .thenReturn(new PortRotationResponse());
    this.mockMvc
        .perform(
            MockMvcRequestBuilders.delete(url, TEST_VESSEL_ID, TEST_VOYAGE_ID, 1, 1)
                .header(CORRELATION_ID_HEADER, CORRELATION_ID_HEADER_VALUE)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().isOk());
  }

  @ValueSource(classes = {GenericServiceException.class, RuntimeException.class})
  @ParameterizedTest
  void testDeletePortRotationException(Class<? extends Exception> exceptionClass) throws Exception {
    Exception ex = new RuntimeException();
    if (exceptionClass == GenericServiceException.class) {
      ex =
          new GenericServiceException(
              "exception",
              CommonErrorCodes.E_GEN_INTERNAL_ERR,
              HttpStatusCode.INTERNAL_SERVER_ERROR);
    }
    when(this.loadableStudyService.deletePortRotation(anyLong(), anyLong(), anyString()))
        .thenThrow(ex);
    this.mockMvc
        .perform(
            MockMvcRequestBuilders.delete(
                    DELETE_PORT_ROTATION_CLOUD_API_URL, TEST_VESSEL_ID, TEST_VOYAGE_ID, 1, 1)
                .header(CORRELATION_ID_HEADER, CORRELATION_ID_HEADER_VALUE)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().isInternalServerError());
  }

  @ValueSource(
      strings = {GET_ON_HAND_QUANTITIES_API_URL_CLOUD_API_URL, GET_ON_HAND_QUANTITIES_SHIP_API_URL})
  @ParameterizedTest
  void testGetOnHandQuantity(String url) throws Exception {
    when(this.loadableStudyService.getOnHandQuantity(
            anyLong(), anyLong(), anyLong(), anyLong(), anyString()))
        .thenReturn(new OnHandQuantityResponse());
    this.mockMvc
        .perform(
            MockMvcRequestBuilders.get(url, TEST_VESSEL_ID, TEST_VOYAGE_ID, 1, 1)
                .header(CORRELATION_ID_HEADER, CORRELATION_ID_HEADER_VALUE))
        .andExpect(status().isOk());
  }

  @ValueSource(classes = {GenericServiceException.class, RuntimeException.class})
  @ParameterizedTest
  void testGetOnHandQuantityRuntimeException(Class<? extends Exception> exceptionClass)
      throws Exception {
    Exception ex = new RuntimeException();
    if (exceptionClass == GenericServiceException.class) {
      ex =
          new GenericServiceException(
              "exception",
              CommonErrorCodes.E_GEN_INTERNAL_ERR,
              HttpStatusCode.INTERNAL_SERVER_ERROR);
    }
    when(this.loadableStudyService.getOnHandQuantity(
            anyLong(), anyLong(), anyLong(), anyLong(), anyString()))
        .thenThrow(ex);
    this.mockMvc
        .perform(
            MockMvcRequestBuilders.get(
                    GET_ON_HAND_QUANTITIES_API_URL_CLOUD_API_URL,
                    TEST_VESSEL_ID,
                    TEST_VOYAGE_ID,
                    1,
                    1)
                .header(CORRELATION_ID_HEADER, CORRELATION_ID_HEADER_VALUE))
        .andExpect(status().isInternalServerError());
  }

  @ValueSource(
      strings = {
        SAVE_ON_HAND_QUANTITIES_API_URL_CLOUD_API_URL,
        SAVE_ON_HAND_QUANTITIES_SHIP_API_URL
      })
  @ParameterizedTest
  void testSaveOnHandQuantity(String url) throws Exception {
    when(this.loadableStudyService.saveOnHandQuantity(any(OnHandQuantity.class), anyString()))
        .thenReturn(new OnHandQuantityResponse());
    this.mockMvc
        .perform(
            MockMvcRequestBuilders.post(url, TEST_VESSEL_ID, TEST_VOYAGE_ID, 1, 1, 0)
                .content(this.createOnHandQuantityRequest())
                .header(CORRELATION_ID_HEADER, CORRELATION_ID_HEADER_VALUE)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().isOk());
  }

  @ValueSource(classes = {GenericServiceException.class, RuntimeException.class})
  @ParameterizedTest
  void testSaveOnHandQuantityRuntimeException(Class<? extends Exception> exceptionClass)
      throws Exception {
    Exception ex = new RuntimeException();
    if (exceptionClass == GenericServiceException.class) {
      ex =
          new GenericServiceException(
              "exception",
              CommonErrorCodes.E_GEN_INTERNAL_ERR,
              HttpStatusCode.INTERNAL_SERVER_ERROR);
    }
    when(this.loadableStudyService.saveOnHandQuantity(any(OnHandQuantity.class), anyString()))
        .thenThrow(ex);
    this.mockMvc
        .perform(
            MockMvcRequestBuilders.post(
                    SAVE_ON_HAND_QUANTITIES_API_URL_CLOUD_API_URL,
                    TEST_VESSEL_ID,
                    TEST_VOYAGE_ID,
                    1,
                    1,
                    0)
                .content(this.createOnHandQuantityRequest())
                .header(CORRELATION_ID_HEADER, CORRELATION_ID_HEADER_VALUE)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().isInternalServerError());
  }

  private String createOnHandQuantityRequest() throws JsonProcessingException {
    OnHandQuantity request = new OnHandQuantity();
    request.setArrivalVolume(TEST_BIGDECIMAL_VALUE);
    request.setArrivalQuantity(TEST_BIGDECIMAL_VALUE);
    request.setDepartureQuantity(TEST_BIGDECIMAL_VALUE);
    request.setDepartureVolume(TEST_BIGDECIMAL_VALUE);
    request.setFuelTypeId(1L);
    request.setTankId(1L);
    request.setLoadableStudyId(1L);
    ObjectMapper mapper = new ObjectMapper();
    return mapper.writeValueAsString(request);
  }
  
  @Test
  void testGetCargoNomination() throws Exception {
    when(loadableStudyService.getCargoNomination(Mockito.any(), Mockito.any()))
        .thenReturn(cargoNominationResponse);
    this.mockMvc
        .perform(
            get(
                    "/api/cloud/vessels/{vesselId}/voyages/{voyageId}/loadable-studies/{loadableStudyId}/cargo-nominations",
                    1,
                    1,
                    30)
                .header(AUTHORIZATION_HEADER, "4b5608ff-b77b-40c6-9645-d69856d4aafa"))
        .andExpect(status().isOk());
  }

  @Test
  void testGetCargoNominationWithException() throws Exception {
    when(loadableStudyService.getCargoNomination(Mockito.any(), Mockito.any()))
        .thenThrow(
            new GenericServiceException(
                "Error in getCargoNomination",
                CommonErrorCodes.E_GEN_INTERNAL_ERR,
                HttpStatusCode.INTERNAL_SERVER_ERROR));
    this.mockMvc
        .perform(
            get(
                    "/api/cloud/vessels/{vesselId}/voyages/{voyageId}/loadable-studies/{loadableStudyId}/cargo-nominations",
                    1,
                    1,
                    30)
                .header(AUTHORIZATION_HEADER, "4b5608ff-b77b-40c6-9645-d69856d4aafa"))
        .andExpect(status().isInternalServerError())
        .andExpect(
            result ->
                assertEquals(
                    "Error in getCargoNomination", result.getResolvedException().getMessage()));
  }

  @Test
  void testSaveCargoNomination() throws Exception {
    when(loadableStudyService.saveCargoNomination(
            Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any()))
        .thenReturn(cargoNominationResponse);
    this.mockMvc
        .perform(
            post(
                    "/api/cloud/vessels/{vesselId}/voyages/{voyageId}/loadable-studies/{loadableStudyId}/cargo-nominations/{id}",
                    1,
                    1,
                    30,
                    0)
                .content(createSaveCargoNominationRequest(false))
                .header(AUTHORIZATION_HEADER, "4b5608ff-b77b-40c6-9645-d69856d4aafa")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().isOk());
  }

  @Test
  void testSaveCargoNominationWithException() throws Exception {
    when(loadableStudyService.saveCargoNomination(
            Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any()))
        .thenThrow(
            new GenericServiceException(
                "Error in saveCargoNomination",
                CommonErrorCodes.E_GEN_INTERNAL_ERR,
                HttpStatusCode.INTERNAL_SERVER_ERROR));
    this.mockMvc
        .perform(
            post(
                    "/api/cloud/vessels/{vesselId}/voyages/{voyageId}/loadable-studies/{loadableStudyId}/cargo-nominations/{id}",
                    1,
                    1,
                    30,
                    1)
                .content(createSaveCargoNominationRequest(true))
                .header(AUTHORIZATION_HEADER, "4b5608ff-b77b-40c6-9645-d69856d4aafa")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().isInternalServerError())
        .andExpect(
            result ->
                assertEquals(
                    "Error in saveCargoNomination", result.getResolvedException().getMessage()));
  }

  private String createSaveCargoNominationRequest(boolean existingRecord)
      throws JsonProcessingException {
    CargoNomination request = new CargoNomination();
    request.setLoadableStudyId(30L);
    request.setId(existingRecord ? 15L : 0);
    request.setPriority(3L);
    request.setCargoId(1L);
    request.setAbbreviation("ABBREV");
    request.setColor("testColor");
    request.setMaxTolerance(new BigDecimal("10.0"));
    request.setMinTolerance(new BigDecimal("20.0"));
    request.setApi(new BigDecimal("5.0"));
    request.setTemperature(new BigDecimal("6.0"));
    request.setSegregationId(2L);
    List<LoadingPort> loadingPorts = new ArrayList<>();
    LoadingPort loadingPort = new LoadingPort();
    loadingPort.setId(1L);
    loadingPort.setQuantity(new BigDecimal("100.0"));
    loadingPorts.add(loadingPort);
    request.setLoadingPorts(loadingPorts);
    ObjectMapper mapper = new ObjectMapper();
    return mapper.writeValueAsString(request);
  }
}
