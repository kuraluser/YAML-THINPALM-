/* Licensed at AlphaOri Technologies */
package com.cpdss.loadablestudy.service;

import static java.lang.String.valueOf;
import static org.springframework.util.StringUtils.isEmpty;

import com.cpdss.common.exception.GenericServiceException;
import com.cpdss.common.generated.CargoInfo.CargoDetail;
import com.cpdss.common.generated.CargoInfo.CargoReply;
import com.cpdss.common.generated.CargoInfo.CargoRequest;
import com.cpdss.common.generated.CargoInfoServiceGrpc.CargoInfoServiceBlockingStub;
import com.cpdss.common.generated.Common.ResponseStatus;
import com.cpdss.common.generated.LoadableStudy.AlgoErrorReply;
import com.cpdss.common.generated.LoadableStudy.AlgoErrorRequest;
import com.cpdss.common.generated.LoadableStudy.AlgoErrors;
import com.cpdss.common.generated.LoadableStudy.AlgoReply;
import com.cpdss.common.generated.LoadableStudy.AlgoRequest;
import com.cpdss.common.generated.LoadableStudy.AlgoStatusReply;
import com.cpdss.common.generated.LoadableStudy.AlgoStatusRequest;
import com.cpdss.common.generated.LoadableStudy.CargoDetails;
import com.cpdss.common.generated.LoadableStudy.CargoHistoryDetail;
import com.cpdss.common.generated.LoadableStudy.CargoHistoryReply;
import com.cpdss.common.generated.LoadableStudy.CargoHistoryRequest;
import com.cpdss.common.generated.LoadableStudy.CargoNominationDetail;
import com.cpdss.common.generated.LoadableStudy.CargoNominationReply;
import com.cpdss.common.generated.LoadableStudy.CargoNominationRequest;
import com.cpdss.common.generated.LoadableStudy.CommingleCargo;
import com.cpdss.common.generated.LoadableStudy.CommingleCargoReply;
import com.cpdss.common.generated.LoadableStudy.CommingleCargoRequest;
import com.cpdss.common.generated.LoadableStudy.ConfirmPlanReply;
import com.cpdss.common.generated.LoadableStudy.ConfirmPlanRequest;
import com.cpdss.common.generated.LoadableStudy.DischargingPortDetail;
import com.cpdss.common.generated.LoadableStudy.JsonRequest;
import com.cpdss.common.generated.LoadableStudy.LDtrim;
import com.cpdss.common.generated.LoadableStudy.LoadablePatternAlgoRequest;
import com.cpdss.common.generated.LoadableStudy.LoadablePatternCargoDetails;
import com.cpdss.common.generated.LoadableStudy.LoadablePatternCommingleDetailsReply;
import com.cpdss.common.generated.LoadableStudy.LoadablePatternCommingleDetailsRequest;
import com.cpdss.common.generated.LoadableStudy.LoadablePatternReply;
import com.cpdss.common.generated.LoadableStudy.LoadablePatternRequest;
import com.cpdss.common.generated.LoadableStudy.LoadablePlanDetails;
import com.cpdss.common.generated.LoadableStudy.LoadablePlanDetailsReply;
import com.cpdss.common.generated.LoadableStudy.LoadablePlanDetailsRequest;
import com.cpdss.common.generated.LoadableStudy.LoadablePlanPortWiseDetails;
import com.cpdss.common.generated.LoadableStudy.LoadableQuantityCargoDetails;
import com.cpdss.common.generated.LoadableStudy.LoadableQuantityCommingleCargoDetails;
import com.cpdss.common.generated.LoadableStudy.LoadableQuantityReply;
import com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequest;
import com.cpdss.common.generated.LoadableStudy.LoadableQuantityResponse;
import com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment;
import com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachmentReply;
import com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachmentRequest;
import com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail;
import com.cpdss.common.generated.LoadableStudy.LoadableStudyReply;
import com.cpdss.common.generated.LoadableStudy.LoadableStudyReply.Builder;
import com.cpdss.common.generated.LoadableStudy.LoadableStudyRequest;
import com.cpdss.common.generated.LoadableStudy.LoadableStudyStatusReply;
import com.cpdss.common.generated.LoadableStudy.LoadableStudyStatusRequest;
import com.cpdss.common.generated.LoadableStudy.LoadicatorDataReply;
import com.cpdss.common.generated.LoadableStudy.LoadicatorDataRequest;
import com.cpdss.common.generated.LoadableStudy.LoadicatorResultsRequest;
import com.cpdss.common.generated.LoadableStudy.LoadingPortDetail;
import com.cpdss.common.generated.LoadableStudy.OhqPorts;
import com.cpdss.common.generated.LoadableStudy.OnBoardQuantityDetail;
import com.cpdss.common.generated.LoadableStudy.OnBoardQuantityReply;
import com.cpdss.common.generated.LoadableStudy.OnBoardQuantityRequest;
import com.cpdss.common.generated.LoadableStudy.OnHandQuantityDetail;
import com.cpdss.common.generated.LoadableStudy.OnHandQuantityReply;
import com.cpdss.common.generated.LoadableStudy.OnHandQuantityRequest;
import com.cpdss.common.generated.LoadableStudy.Operation;
import com.cpdss.common.generated.LoadableStudy.PortRotationDetail;
import com.cpdss.common.generated.LoadableStudy.PortRotationReply;
import com.cpdss.common.generated.LoadableStudy.PortRotationRequest;
import com.cpdss.common.generated.LoadableStudy.PurposeOfCommingleReply;
import com.cpdss.common.generated.LoadableStudy.PurposeOfCommingleRequest;
import com.cpdss.common.generated.LoadableStudy.SaveCommentReply;
import com.cpdss.common.generated.LoadableStudy.SaveCommentRequest;
import com.cpdss.common.generated.LoadableStudy.SaveVoyageStatusReply;
import com.cpdss.common.generated.LoadableStudy.SaveVoyageStatusRequest;
import com.cpdss.common.generated.LoadableStudy.StabilityParameter;
import com.cpdss.common.generated.LoadableStudy.StatusReply;
import com.cpdss.common.generated.LoadableStudy.SynopticalBallastRecord;
import com.cpdss.common.generated.LoadableStudy.SynopticalCargoRecord;
import com.cpdss.common.generated.LoadableStudy.SynopticalOhqRecord;
import com.cpdss.common.generated.LoadableStudy.SynopticalRecord;
import com.cpdss.common.generated.LoadableStudy.SynopticalTableReply;
import com.cpdss.common.generated.LoadableStudy.SynopticalTableRequest;
import com.cpdss.common.generated.LoadableStudy.TankDetail;
import com.cpdss.common.generated.LoadableStudy.TankList;
import com.cpdss.common.generated.LoadableStudy.UpdateUllageReply;
import com.cpdss.common.generated.LoadableStudy.UpdateUllageRequest;
import com.cpdss.common.generated.LoadableStudy.ValveSegregation;
import com.cpdss.common.generated.LoadableStudy.ValveSegregationReply;
import com.cpdss.common.generated.LoadableStudy.ValveSegregationRequest;
import com.cpdss.common.generated.LoadableStudy.VoyageDetail;
import com.cpdss.common.generated.LoadableStudy.VoyageListReply;
import com.cpdss.common.generated.LoadableStudy.VoyageReply;
import com.cpdss.common.generated.LoadableStudy.VoyageRequest;
import com.cpdss.common.generated.LoadableStudyServiceGrpc.LoadableStudyServiceImplBase;
import com.cpdss.common.generated.Loadicator.BallastInfo;
import com.cpdss.common.generated.Loadicator.CargoInfo;
import com.cpdss.common.generated.Loadicator.LoadicatorReply;
import com.cpdss.common.generated.Loadicator.LoadicatorRequest;
import com.cpdss.common.generated.Loadicator.OtherTankInfo;
import com.cpdss.common.generated.Loadicator.StowageDetails;
import com.cpdss.common.generated.Loadicator.StowagePlan;
import com.cpdss.common.generated.LoadicatorServiceGrpc.LoadicatorServiceBlockingStub;
import com.cpdss.common.generated.PortInfo;
import com.cpdss.common.generated.PortInfo.GetPortInfoByPortIdsRequest;
import com.cpdss.common.generated.PortInfo.PortDetail;
import com.cpdss.common.generated.PortInfo.PortReply;
import com.cpdss.common.generated.PortInfo.PortRequest;
import com.cpdss.common.generated.PortInfoServiceGrpc.PortInfoServiceBlockingStub;
import com.cpdss.common.generated.VesselInfo.VesselDetail;
import com.cpdss.common.generated.VesselInfo.VesselLoadableQuantityDetails;
import com.cpdss.common.generated.VesselInfo.VesselReply;
import com.cpdss.common.generated.VesselInfo.VesselRequest;
import com.cpdss.common.generated.VesselInfo.VesselTankDetail;
import com.cpdss.common.generated.VesselInfoServiceGrpc.VesselInfoServiceBlockingStub;
import com.cpdss.common.rest.CommonErrorCodes;
import com.cpdss.common.utils.HttpStatusCode;
import com.cpdss.loadablestudy.domain.AlgoResponse;
import com.cpdss.loadablestudy.domain.ApiTempHistorySpecification;
import com.cpdss.loadablestudy.domain.CargoHistory;
import com.cpdss.loadablestudy.domain.LDIntactStability;
import com.cpdss.loadablestudy.domain.LDStrength;
import com.cpdss.loadablestudy.domain.LDTrim;
import com.cpdss.loadablestudy.domain.LoadabalePatternDetails;
import com.cpdss.loadablestudy.domain.LoadabalePatternValidateRequest;
import com.cpdss.loadablestudy.domain.LoadicatorAlgoRequest;
import com.cpdss.loadablestudy.domain.LoadicatorAlgoResponse;
import com.cpdss.loadablestudy.domain.LoadicatorPatternDetails;
import com.cpdss.loadablestudy.domain.LoadicatorPatternDetailsResults;
import com.cpdss.loadablestudy.domain.PortDetails;
import com.cpdss.loadablestudy.domain.SearchCriteria;
import com.cpdss.loadablestudy.domain.UllageUpdateRequest;
import com.cpdss.loadablestudy.domain.UllageUpdateResponse;
import com.cpdss.loadablestudy.entity.AlgoErrorHeading;
import com.cpdss.loadablestudy.entity.ApiTempHistory;
import com.cpdss.loadablestudy.entity.CargoNomination;
import com.cpdss.loadablestudy.entity.CargoNominationPortDetails;
import com.cpdss.loadablestudy.entity.CargoNominationValveSegregation;
import com.cpdss.loadablestudy.entity.CargoOperation;
import com.cpdss.loadablestudy.entity.JsonData;
import com.cpdss.loadablestudy.entity.JsonType;
import com.cpdss.loadablestudy.entity.LoadablePattern;
import com.cpdss.loadablestudy.entity.LoadablePatternAlgoStatus;
import com.cpdss.loadablestudy.entity.LoadablePlanBallastDetails;
import com.cpdss.loadablestudy.entity.LoadablePlanComments;
import com.cpdss.loadablestudy.entity.LoadablePlanCommingleDetails;
import com.cpdss.loadablestudy.entity.LoadablePlanComminglePortwiseDetails;
import com.cpdss.loadablestudy.entity.LoadablePlanConstraints;
import com.cpdss.loadablestudy.entity.LoadablePlanQuantity;
import com.cpdss.loadablestudy.entity.LoadablePlanStowageBallastDetails;
import com.cpdss.loadablestudy.entity.LoadablePlanStowageDetails;
import com.cpdss.loadablestudy.entity.LoadablePlanStowageDetailsTemp;
import com.cpdss.loadablestudy.entity.LoadableQuantity;
import com.cpdss.loadablestudy.entity.LoadableStudy;
import com.cpdss.loadablestudy.entity.LoadableStudyAlgoStatus;
import com.cpdss.loadablestudy.entity.LoadableStudyAttachments;
import com.cpdss.loadablestudy.entity.LoadableStudyPortRotation;
import com.cpdss.loadablestudy.entity.OnBoardQuantity;
import com.cpdss.loadablestudy.entity.OnHandQuantity;
import com.cpdss.loadablestudy.entity.PurposeOfCommingle;
import com.cpdss.loadablestudy.entity.StabilityParameters;
import com.cpdss.loadablestudy.entity.SynopticalTable;
import com.cpdss.loadablestudy.entity.SynopticalTableLoadicatorData;
import com.cpdss.loadablestudy.entity.Voyage;
import com.cpdss.loadablestudy.entity.VoyageHistory;
import com.cpdss.loadablestudy.entity.VoyageStatus;
import com.cpdss.loadablestudy.repository.AlgoErrorHeadingRepository;
import com.cpdss.loadablestudy.repository.AlgoErrorsRepository;
import com.cpdss.loadablestudy.repository.ApiTempHistoryRepository;
import com.cpdss.loadablestudy.repository.CargoHistoryRepository;
import com.cpdss.loadablestudy.repository.CargoNominationOperationDetailsRepository;
import com.cpdss.loadablestudy.repository.CargoNominationRepository;
import com.cpdss.loadablestudy.repository.CargoNominationValveSegregationRepository;
import com.cpdss.loadablestudy.repository.CargoOperationRepository;
import com.cpdss.loadablestudy.repository.CommingleCargoRepository;
import com.cpdss.loadablestudy.repository.JsonDataRepository;
import com.cpdss.loadablestudy.repository.JsonTypeRepository;
import com.cpdss.loadablestudy.repository.LoadablePatternAlgoStatusRepository;
import com.cpdss.loadablestudy.repository.LoadablePatternCargoDetailsRepository;
import com.cpdss.loadablestudy.repository.LoadablePatternRepository;
import com.cpdss.loadablestudy.repository.LoadablePlanBallastDetailsRepository;
import com.cpdss.loadablestudy.repository.LoadablePlanCommentsRepository;
import com.cpdss.loadablestudy.repository.LoadablePlanCommingleDetailsPortwiseRepository;
import com.cpdss.loadablestudy.repository.LoadablePlanCommingleDetailsRepository;
import com.cpdss.loadablestudy.repository.LoadablePlanConstraintsRespository;
import com.cpdss.loadablestudy.repository.LoadablePlanQuantityRepository;
import com.cpdss.loadablestudy.repository.LoadablePlanStowageBallastDetailsRepository;
import com.cpdss.loadablestudy.repository.LoadablePlanStowageDetailsRespository;
import com.cpdss.loadablestudy.repository.LoadablePlanStowageDetailsTempRepository;
import com.cpdss.loadablestudy.repository.LoadableQuantityRepository;
import com.cpdss.loadablestudy.repository.LoadableStudyAlgoStatusRepository;
import com.cpdss.loadablestudy.repository.LoadableStudyAttachmentsRepository;
import com.cpdss.loadablestudy.repository.LoadableStudyPortRotationRepository;
import com.cpdss.loadablestudy.repository.LoadableStudyRepository;
import com.cpdss.loadablestudy.repository.LoadableStudyStatusRepository;
import com.cpdss.loadablestudy.repository.OnBoardQuantityRepository;
import com.cpdss.loadablestudy.repository.OnHandQuantityRepository;
import com.cpdss.loadablestudy.repository.PurposeOfCommingleRepository;
import com.cpdss.loadablestudy.repository.StabilityParameterRepository;
import com.cpdss.loadablestudy.repository.SynopticalTableLoadicatorDataRepository;
import com.cpdss.loadablestudy.repository.SynopticalTableRepository;
import com.cpdss.loadablestudy.repository.VoyageHistoryRepository;
import com.cpdss.loadablestudy.repository.VoyageRepository;
import com.cpdss.loadablestudy.repository.VoyageStatusRepository;
import com.cpdss.loadablestudy.service.builder.LoadablePlanBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.grpc.stub.StreamObserver;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import javax.persistence.EntityManager;
import lombok.extern.log4j.Log4j2;
import net.devh.boot.grpc.client.inject.GrpcClient;
import net.devh.boot.grpc.server.service.GrpcService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

/** @Author jerin.g */
@Log4j2
@GrpcService
@Transactional
public class LoadableStudyService extends LoadableStudyServiceImplBase {

  @Value("${loadablestudy.attachement.rootFolder}")
  private String rootFolder;

  @Value("${algo.loadablestudy.api.url}")
  private String loadableStudyUrl;

  @Value("${algo.loadicator.api.url}")
  private String loadicatorUrl;

  @Value("${algo.stowage.edit.api.url}")
  private String algoUpdateUllageUrl;

  @Value("${loadablestudy.voyage.day.difference}")
  private String dayDifference;

  @Autowired private VoyageRepository voyageRepository;
  @Autowired private LoadableStudyPortRotationRepository loadableStudyPortRotationRepository;
  @Autowired private CargoOperationRepository cargoOperationRepository;
  @Autowired private LoadableStudyRepository loadableStudyRepository;
  @Autowired private LoadableQuantityRepository loadableQuantityRepository;
  @Autowired private CargoNominationRepository cargoNominationRepository;
  @Autowired private CargoNominationValveSegregationRepository valveSegregationRepository;
  @Autowired private LoadableStudyStatusRepository loadableStudyStatusRepository;
  @Autowired private PurposeOfCommingleRepository purposeOfCommingleRepository;
  @Autowired private LoadablePatternRepository loadablePatternRepository;
  @Autowired private LoadablePlanQuantityRepository loadablePlanQuantityRepository;
  @Autowired private LoadablePlanCommentsRepository loadablePlanCommentsRepository;
  @Autowired private LoadablePlanCommingleDetailsRepository loadablePlanCommingleDetailsRepository;
  @Autowired private LoadablePlanStowageDetailsRespository loadablePlanStowageDetailsRespository;
  @Autowired private EntityManager entityManager;
  @Autowired private RestTemplate restTemplate;
  @Autowired private LoadablePlanBallastDetailsRepository loadablePlanBallastDetailsRepository;
  @Autowired private LoadableStudyAttachmentsRepository loadableStudyAttachmentsRepository;
  @Autowired private VoyageStatusRepository voyageStatusRepository;
  @Autowired private AlgoErrorHeadingRepository algoErrorHeadingRepository;
  @Autowired private AlgoErrorsRepository algoErrorsRepository;
  @Autowired private StabilityParameterRepository stabilityParameterRepository;

  @Autowired
  private LoadablePlanCommingleDetailsPortwiseRepository
      loadablePlanCommingleDetailsPortwiseRepository;

  @Autowired private LoadablePlanStowageDetailsTempRepository stowageDetailsTempRepository;

  @Autowired
  private LoadablePlanStowageBallastDetailsRepository loadablePlanStowageBallastDetailsRepository;

  @Autowired private LoadablePlanConstraintsRespository loadablePlanConstraintsRespository;

  @Autowired
  private CargoNominationOperationDetailsRepository cargoNominationOperationDetailsRepository;

  @Autowired private OnHandQuantityRepository onHandQuantityRepository;
  @Autowired private CommingleCargoRepository commingleCargoRepository;
  @Autowired private OnBoardQuantityRepository onBoardQuantityRepository;
  @Autowired private LoadablePatternAlgoStatusRepository loadablePatternAlgoStatusRepository;
  @Autowired private CargoHistoryRepository cargoHistoryRepository;
  @Autowired private VoyageHistoryRepository voyageHistoryRepository;
  @Autowired private LoadableStudyAlgoStatusRepository loadableStudyAlgoStatusRepository;
  @Autowired private SynopticalTableRepository synopticalTableRepository;

  @Autowired
  private SynopticalTableLoadicatorDataRepository synopticalTableLoadicatorDataRepository;

  @Autowired private LoadablePatternCargoDetailsRepository loadablePatternCargoDetailsRepository;
  @Autowired private ApiTempHistoryRepository apiTempHistoryRepository;

  @Autowired private JsonDataRepository jsonDataRepository;
  @Autowired private JsonTypeRepository jsonTypeRepository;

  private static final String SUCCESS = "SUCCESS";
  private static final String FAILED = "FAILED";
  private static final String VOYAGEEXISTS = "VOYAGE_EXISTS";
  private static final String CREATED_DATE_FORMAT = "dd-MM-yyyy";
  private static final String INVALID_LOADABLE_QUANTITY = "INVALID_LOADABLE_QUANTITY";
  private static final String COMMINGLE = "COM";
  private static final String ETA_ETD_FORMAT = "dd-MM-yyyy HH:mm";
  private static final String DATE_FORMAT = "dd-MM-yyyy HH:mm";
  private static final String LAY_CAN_FORMAT = "dd-MM-yyyy";
  private static final String DATE_TIME_FORMAT = "dd-MM-yyyy HH:mm";
  private static final Long LOADING_OPERATION_ID = 1L;
  private static final Long DISCHARGING_OPERATION_ID = 2L;
  private static final Long BUNKERING_OPERATION_ID = 3L;
  private static final Long TRANSIT_OPERATION_ID = 4L;
  private static final Long STS_LOADING_OPERATION_ID = 5L;
  private static final Long STS_DISCHARGING_OPERATION_ID = 6L;
  private static final Long LOADABLE_STUDY_INITIAL_STATUS_ID = 1L;
  private static final Long LOADABLE_STUDY_PROCESSING_STARTED_ID = 4L;
  private static final Long LOADABLE_STUDY_STATUS_PLAN_GENERATED_ID = 3L;
  private static final Long LOADABLE_STUDY_STATUS_VERIFICATION_WITH_LOADICATOR_ID = 7L;
  private static final Long LOADABLE_STUDY_STATUS_VERIFICATION_WITH_LOADICATOR_COMPLETED_ID = 8L;
  private static final Long LOADABLE_STUDY_STATUS_LOADICATOR_VERIFICATION_WITH_ALGO_ID = 9L;
  private static final Long LOADABLE_STUDY_STATUS_LOADICATOR_VERIFICATION_WITH_ALGO_COMPLETED_ID =
      10L;
  private static final Long LOADABLE_PATTERN_VALIDATION_SUCCESS_ID = 12L;
  private static final Long LOADABLE_PATTERN_VALIDATION_FAILED_ID = 13L;

  private static final Long LOADABLE_PATTERN_VALIDATION_STARTED_ID = 14L;
  private static final Long LOADABLE_PATTERN_VALIDATION_COMPLETED_ID = 15L;
  private static final Long LOADABLE_STUDY_NO_PLAN_AVAILABLE_ID = 6L;
  private static final Long CONFIRMED_STATUS_ID = 2L;
  private static final String INVALID_LOADABLE_STUDY_ID = "INVALID_LOADABLE_STUDY_ID";
  private static final String ERRO_CALLING_ALGO = "ERROR_CALLING_ALGO";
  private static final int CASE_1 = 1;
  private static final int CASE_2 = 2;
  private static final int CASE_3 = 3;
  private static final String INVALID_LOADABLE_PATTERN_COMMINGLE_DETAIL_ID =
      "INVALID_LOADABLE_PATTERN_COMMINGLE_DETAIL_ID";
  private static final String INVALID_LOADABLE_PATTERN_ID = "INVALID_LOADABLE_PATTERN_ID";
  private static final Long LOAD_LINE_TROPICAL_TO_SUMMER_ID = 7L;
  private static final Long LOAD_LINE_TROPICAL_TO_WINTER_ID = 8L;
  private static final Long LOAD_LINE_SUMMER_TO_WINTER_ID = 9L;

  private static final List<Long> CASE_1_LOAD_LINES =
      Arrays.asList(
          LOAD_LINE_TROPICAL_TO_SUMMER_ID,
          LOAD_LINE_TROPICAL_TO_WINTER_ID,
          LOAD_LINE_SUMMER_TO_WINTER_ID);

  private static final Long FRESH_WATER_TANK_CATEGORY_ID = 3L;
  private static final Long FUEL_OIL_TANK_CATEGORY_ID = 5L;
  private static final Long DIESEL_OIL_TANK_CATEGORY_ID = 6L;
  private static final Long LUBRICATING_OIL_TANK_CATEGORY_ID = 14L;
  private static final Long LUBRICANT_OIL_TANK_CATEGORY_ID = 19L;
  private static final Long FUEL_VOID_TANK_CATEGORY_ID = 22L;
  private static final Long FRESH_WATER_VOID_TANK_CATEGORY_ID = 23L;
  private static final Long BALLAST_VOID_TANK_CATEGORY_ID = 16L;
  private static final Long BALLAST_TANK_CATEGORY_ID = 2L;

  private static final String BALLAST_FRONT_TANK = "FRONT";
  private static final String BALLAST_CENTER_TANK = "CENTER";
  private static final String BALLAST_REAR_TANK = "REAR";

  private static final List<Long> BALLAST_TANK_CATEGORIES =
      Arrays.asList(BALLAST_TANK_CATEGORY_ID, BALLAST_VOID_TANK_CATEGORY_ID);

  private static final List<Long> OHQ_TANK_CATEGORIES =
      Arrays.asList(
          FRESH_WATER_TANK_CATEGORY_ID,
          FUEL_OIL_TANK_CATEGORY_ID,
          DIESEL_OIL_TANK_CATEGORY_ID,
          LUBRICATING_OIL_TANK_CATEGORY_ID,
          LUBRICANT_OIL_TANK_CATEGORY_ID,
          FUEL_VOID_TANK_CATEGORY_ID,
          FRESH_WATER_VOID_TANK_CATEGORY_ID);

  private static final List<Long> OHQ_CENTER_TANK_CATEGORIES =
      Arrays.asList(
          FUEL_OIL_TANK_CATEGORY_ID, DIESEL_OIL_TANK_CATEGORY_ID, FUEL_VOID_TANK_CATEGORY_ID);

  private static final List<Long> OHQ_REAR_TANK_CATEGORIES =
      Arrays.asList(FRESH_WATER_TANK_CATEGORY_ID, FRESH_WATER_VOID_TANK_CATEGORY_ID);

  private static final List<Long> OHQ_VOID_TANK_CATEGORIES =
      Arrays.asList(FUEL_VOID_TANK_CATEGORY_ID, FRESH_WATER_VOID_TANK_CATEGORY_ID);

  private static final Long CARGO_TANK_CATEGORY_ID = 1L;
  private static final Long CARGO_SLOP_TANK_CATEGORY_ID = 9L;
  private static final Long CARGO_VOID_TANK_CATEGORY_ID = 15L;

  private static final String BALLAST_TANK_COLOR_CODE = "#01717D";

  private static final List<Long> CARGO_BALLAST_TANK_CATEGORIES =
      Arrays.asList(
          CARGO_TANK_CATEGORY_ID,
          CARGO_SLOP_TANK_CATEGORY_ID,
          CARGO_VOID_TANK_CATEGORY_ID,
          BALLAST_TANK_CATEGORY_ID,
          BALLAST_VOID_TANK_CATEGORY_ID);

  private static final List<Long> CARGO_TANK_CATEGORIES =
      Arrays.asList(
          CARGO_TANK_CATEGORY_ID, CARGO_SLOP_TANK_CATEGORY_ID, CARGO_VOID_TANK_CATEGORY_ID);

  private static final List<Long> CARGO_OPERATION_ARR_DEP_SYNOPTICAL =
      Arrays.asList(
          LOADING_OPERATION_ID,
          DISCHARGING_OPERATION_ID,
          BUNKERING_OPERATION_ID,
          TRANSIT_OPERATION_ID,
          STS_LOADING_OPERATION_ID,
          STS_DISCHARGING_OPERATION_ID);

  private static final List<Long> SYNOPTICAL_TABLE_TANK_CATEGORIES =
      Arrays.asList(
          CARGO_TANK_CATEGORY_ID,
          CARGO_SLOP_TANK_CATEGORY_ID,
          FRESH_WATER_TANK_CATEGORY_ID,
          FUEL_OIL_TANK_CATEGORY_ID,
          DIESEL_OIL_TANK_CATEGORY_ID,
          LUBRICATING_OIL_TANK_CATEGORY_ID,
          LUBRICANT_OIL_TANK_CATEGORY_ID,
          BALLAST_TANK_CATEGORY_ID);

  private static final String SYNOPTICAL_TABLE_OP_TYPE_ARRIVAL = "ARR";
  private static final String SYNOPTICAL_TABLE_OP_TYPE_DEPARTURE = "DEP";

  private static final String STATUS_ACTIVE = "ACTIVE";
  private static final String STATUS_CONFIRMED = "CONFIRMED";
  private static final String STATUS_CLOSE = "CLOSED";

  private static final long STOWAGE_STATUS = 1L;

  private static final Long ACTIVE_VOYAGE_STATUS = 3L;

  private static final String START_VOYAGE = "START";

  private static final Long CLOSE_VOYAGE_STATUS = 2L;

  @GrpcClient("vesselInfoService")
  private VesselInfoServiceBlockingStub vesselInfoGrpcService;

  @GrpcClient("portInfoService")
  private PortInfoServiceBlockingStub portInfoGrpcService;

  @GrpcClient("cargoService")
  private CargoInfoServiceBlockingStub cargoInfoGrpcService;

  @GrpcClient("loadicatorService")
  private LoadicatorServiceBlockingStub loadicatorService;

  private static final Long LOADABLE_STUDY_REQUEST = 1L;

  private static final Long LOADABLE_PATTERN_EDIT_REQUEST = 5L;

  /**
   * method for save voyage
   *
   * @param request - voyage request details
   * @param responseObserver - grpc class
   * @return
   */
  @Override
  public void saveVoyage(VoyageRequest request, StreamObserver<VoyageReply> responseObserver) {
    VoyageReply reply = null;
    try {
      // validation for duplicate voyages
      if (!voyageRepository
          .findByCompanyXIdAndVesselXIdAndVoyageNoIgnoreCase(
              request.getCompanyId(), request.getVesselId(), request.getVoyageNo())
          .isEmpty()) {
        reply =
            VoyageReply.newBuilder()
                .setResponseStatus(
                    StatusReply.newBuilder()
                        .setStatus(FAILED)
                        .setMessage(VOYAGEEXISTS)
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
        voyage = voyageRepository.save(voyage);
        // when Db save is complete we return to client a success message
        reply =
            VoyageReply.newBuilder()
                .setResponseStatus(StatusReply.newBuilder().setStatus(SUCCESS).setMessage(SUCCESS))
                .setVoyageId(voyage.getId())
                .build();
      }
    } catch (Exception e) {

      log.error("Error in saving Voyage ", e);
      reply =
          VoyageReply.newBuilder()
              .setResponseStatus(
                  StatusReply.newBuilder()
                      .setStatus(FAILED)
                      .setMessage(FAILED)
                      .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR))
              .build();

    } finally {
      responseObserver.onNext(reply);
      responseObserver.onCompleted();
    }
  }

  /**
   * method to save loadable quantity
   *
   * @param loadableQuantityRequest
   * @param responseObserver
   * @throws Exception
   * @return void
   */
  @Override
  public void saveLoadableQuantity(
      LoadableQuantityRequest loadableQuantityRequest,
      StreamObserver<LoadableQuantityReply> responseObserver) {
    LoadableQuantityReply loadableQuantityReply = null;
    LoadableQuantity loadableQuantity = null;
    try {
      Optional<LoadableStudy> loadableStudy =
          loadableStudyRepository.findById((Long) loadableQuantityRequest.getLoadableStudyId());
      if (loadableStudy.isPresent()) {
        this.checkIfVoyageClosed(loadableStudy.get().getVoyage().getId());

        if (0 == loadableQuantityRequest.getId()) {
          loadableQuantity = new LoadableQuantity();
        } else {
          loadableQuantity =
              this.loadableQuantityRepository.findByIdAndIsActive(
                  loadableQuantityRequest.getId(), true);
          if (null == loadableQuantity) {
            throw new GenericServiceException(
                "Loadable quantity does not exist",
                CommonErrorCodes.E_HTTP_BAD_REQUEST,
                HttpStatusCode.BAD_REQUEST);
          }
        }
        loadableQuantity.setLoadableStudyXId(loadableStudy.get());

        this.isPatternGeneratedOrConfirmed(loadableQuantity.getLoadableStudyXId());

        loadableQuantity.setConstant(new BigDecimal(loadableQuantityRequest.getConstant()));
        loadableQuantity.setDeadWeight(new BigDecimal(loadableQuantityRequest.getDwt()));
        loadableQuantity.setDisplacementAtDraftRestriction(
            StringUtils.isEmpty(loadableQuantityRequest.getDisplacmentDraftRestriction())
                ? null
                : new BigDecimal(loadableQuantityRequest.getDisplacmentDraftRestriction()));
        loadableQuantity.setDistanceFromLastPort(
            StringUtils.isEmpty(loadableQuantityRequest.getDistanceFromLastPort())
                ? null
                : new BigDecimal(loadableQuantityRequest.getDistanceFromLastPort()));
        loadableQuantity.setEstimatedDOOnBoard(
            new BigDecimal(loadableQuantityRequest.getEstDOOnBoard()));
        loadableQuantity.setEstimatedFOOnBoard(
            new BigDecimal(loadableQuantityRequest.getEstFOOnBoard()));
        loadableQuantity.setEstimatedFWOnBoard(
            new BigDecimal(loadableQuantityRequest.getEstFreshWaterOnBoard()));
        loadableQuantity.setEstimatedSagging(
            new BigDecimal(loadableQuantityRequest.getEstSagging()));

        loadableQuantity.setEstimatedSeaDensity(
            StringUtils.isEmpty(loadableQuantityRequest.getEstSeaDensity())
                ? null
                : new BigDecimal(loadableQuantityRequest.getEstSeaDensity()));

        loadableQuantity.setLightWeight(
            StringUtils.isEmpty(loadableQuantityRequest.getVesselLightWeight())
                ? null
                : new BigDecimal(loadableQuantityRequest.getVesselLightWeight()));

        loadableQuantity.setOtherIfAny(new BigDecimal(loadableQuantityRequest.getOtherIfAny()));
        loadableQuantity.setSaggingDeduction(
            new BigDecimal(loadableQuantityRequest.getSaggingDeduction()));

        loadableQuantity.setSgCorrection(
            StringUtils.isEmpty(loadableQuantityRequest.getSgCorrection())
                ? null
                : new BigDecimal(loadableQuantityRequest.getSgCorrection()));

        loadableQuantity.setTotalQuantity(
            new BigDecimal(loadableQuantityRequest.getTotalQuantity()));
        loadableQuantity.setTpcatDraft(new BigDecimal(loadableQuantityRequest.getTpc()));
        loadableQuantity.setVesselAverageSpeed(
            StringUtils.isEmpty(loadableQuantityRequest.getVesselAverageSpeed())
                ? null
                : new BigDecimal(loadableQuantityRequest.getVesselAverageSpeed()));

        loadableQuantity.setPortId(
            StringUtils.isEmpty(loadableQuantityRequest.getPortId())
                ? null
                : new BigDecimal(loadableQuantityRequest.getPortId()));
        loadableQuantity.setBoilerWaterOnBoard(
            StringUtils.isEmpty(loadableQuantityRequest.getBoilerWaterOnBoard())
                ? null
                : new BigDecimal(loadableQuantityRequest.getBoilerWaterOnBoard()));
        loadableQuantity.setBallast(
            StringUtils.isEmpty(loadableQuantityRequest.getBallast())
                ? null
                : new BigDecimal(loadableQuantityRequest.getBallast()));
        loadableQuantity.setRunningHours(
            StringUtils.isEmpty(loadableQuantityRequest.getRunningHours())
                ? null
                : new BigDecimal(loadableQuantityRequest.getRunningHours()));
        loadableQuantity.setRunningDays(
            StringUtils.isEmpty(loadableQuantityRequest.getRunningDays())
                ? null
                : new BigDecimal(loadableQuantityRequest.getRunningDays()));
        loadableQuantity.setFoConsumptionInSZ(
            StringUtils.isEmpty(loadableQuantityRequest.getFoConInSZ())
                ? null
                : new BigDecimal(loadableQuantityRequest.getFoConInSZ()));
        loadableQuantity.setDraftRestriction(
            StringUtils.isEmpty(loadableQuantityRequest.getDraftRestriction())
                ? null
                : new BigDecimal(loadableQuantityRequest.getDraftRestriction()));

        loadableQuantity.setSubTotal(
            StringUtils.isEmpty(loadableQuantityRequest.getSubTotal())
                ? null
                : new BigDecimal(loadableQuantityRequest.getSubTotal()));
        loadableQuantity.setFoConsumptionPerDay(
            StringUtils.isEmpty(loadableQuantityRequest.getFoConsumptionPerDay())
                ? null
                : new BigDecimal(loadableQuantityRequest.getFoConsumptionPerDay()));
        loadableQuantity.setIsActive(true);

        loadableQuantity = loadableQuantityRepository.save(loadableQuantity);

        // when Db save is complete we return to client a success message
        loadableQuantityReply =
            LoadableQuantityReply.newBuilder()
                .setResponseStatus(StatusReply.newBuilder().setStatus(SUCCESS).setMessage(SUCCESS))
                .setLoadableQuantityId(loadableQuantity.getId())
                .build();
      } else {
        log.info("INVALID_LOADABLE_STUDY {} - ", loadableQuantityRequest.getLoadableStudyId());
        loadableQuantityReply =
            LoadableQuantityReply.newBuilder()
                .setResponseStatus(
                    StatusReply.newBuilder()
                        .setStatus(FAILED)
                        .setMessage(INVALID_LOADABLE_QUANTITY)
                        .setCode(CommonErrorCodes.E_HTTP_BAD_REQUEST)
                        .setStatusCode(CommonErrorCodes.E_HTTP_BAD_REQUEST))
                .build();
      }
    } catch (GenericServiceException e) {
      log.error("GenericServiceException when saving loadable quantity", e);
      loadableQuantityReply =
          LoadableQuantityReply.newBuilder()
              .setResponseStatus(
                  StatusReply.newBuilder()
                      .setCode(e.getCode())
                      .setMessage(e.getMessage())
                      .setStatus(FAILED)
                      .setStatusCode(CommonErrorCodes.E_HTTP_BAD_REQUEST))
              .build();
    } catch (Exception e) {
      log.error("Error in saving loadable quantity ", e);
      loadableQuantityReply =
          LoadableQuantityReply.newBuilder()
              .setResponseStatus(
                  StatusReply.newBuilder()
                      .setStatus(FAILED)
                      .setMessage(FAILED)
                      .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
                      .setStatusCode(CommonErrorCodes.E_GEN_INTERNAL_ERR))
              .build();
    } finally {
      responseObserver.onNext(loadableQuantityReply);
      responseObserver.onCompleted();
    }
  }

  /**
   * Method to find list of loadable studies based on vessel and voyage
   *
   * @param {@link LoadableStudyRequest} - The grpc generated message
   * @param {@link StreamObserver}
   */
  @Override
  @Transactional
  public void findLoadableStudiesByVesselAndVoyage(
      LoadableStudyRequest request, StreamObserver<LoadableStudyReply> responseObserver) {
    Builder replyBuilder = LoadableStudyReply.newBuilder();
    try {
      log.info("inside loadable study service - findLoadableStudiesByVesselAndVoyage");
      Optional<Voyage> voyageOpt = this.voyageRepository.findById(request.getVoyageId());
      if (!voyageOpt.isPresent()) {
        throw new GenericServiceException(
            "Voyage does not exist", CommonErrorCodes.E_HTTP_BAD_REQUEST, null);
      }
      List<LoadableStudy> loadableStudyEntityList =
          this.loadableStudyRepository
              .findByVesselXIdAndVoyageAndIsActiveOrderByCreatedDateTimeDesc(
                  request.getVesselId(), voyageOpt.get(), true);
      replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS).build());
      DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
      for (LoadableStudy entity : loadableStudyEntityList) {
        com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail.Builder builder =
            LoadableStudyDetail.newBuilder();
        builder.setLastEdited(dateTimeFormatter.format(entity.getLastModifiedDateTime()));
        builder.setId(entity.getId());
        builder.setName(entity.getName());
        Optional.ofNullable(entity.getDischargeCargoId()).ifPresent(builder::setDischargingCargoId);
        builder.setCreatedDate(dateTimeFormatter.format(entity.getCreatedDateTime()));
        Optional.ofNullable(entity.getDuplicatedFrom())
            .ifPresent(
                duplicatedFrom -> {
                  builder.setCreatedFromId(duplicatedFrom.getId());
                });
        Optional.ofNullable(entity.getLoadableStudyStatus())
            .ifPresent(
                status -> {
                  builder.setStatusId(status.getId());
                  builder.setStatus(status.getName());
                  List<LoadableStudyAlgoStatus> algoStatus =
                      loadableStudyAlgoStatusRepository.findByLoadableStudyIdAndIsActive(
                          entity.getId(), true);
                  if (!algoStatus.isEmpty()) {
                    builder.setLoadableStudyStatusLastModifiedTime(
                        algoStatus.stream()
                            .reduce((f, s) -> s)
                            .orElse(null)
                            .getLastModifiedDateTime()
                            .toString()); // getting the last algo status
                  } else {
                    builder.setLoadableStudyStatusLastModifiedTime("0");
                  }
                });
        Optional.ofNullable(entity.getDetails()).ifPresent(builder::setDetail);
        Optional.ofNullable(entity.getCharterer()).ifPresent(builder::setCharterer);
        Optional.ofNullable(entity.getSubCharterer()).ifPresent(builder::setSubCharterer);
        Optional.ofNullable(entity.getLoadLineXId()).ifPresent(builder::setLoadLineXId);
        Optional.ofNullable(entity.getDraftMark())
            .ifPresent(dratMark -> builder.setDraftMark(valueOf(dratMark)));
        Optional.ofNullable(entity.getDraftRestriction())
            .ifPresent(draftRestriction -> builder.setDraftRestriction(valueOf(draftRestriction)));
        Optional.ofNullable(entity.getMaxAirTemperature())
            .ifPresent(maxTemp -> builder.setMaxAirTemperature(valueOf(maxTemp)));
        Optional.ofNullable(entity.getMaxWaterTemperature())
            .ifPresent(maxTemp -> builder.setMaxWaterTemperature(valueOf(maxTemp)));
        Optional.ofNullable(entity.getLoadOnTop())
            .ifPresent(loadOnTop -> builder.setLoadOnTop(loadOnTop));
        Optional.ofNullable(entity.getIsCargoNominationComplete())
            .ifPresent(builder::setIsCargoNominationComplete);
        Optional.ofNullable(entity.getIsPortsComplete()).ifPresent(builder::setIsPortsComplete);
        Optional.ofNullable(entity.getIsOhqComplete()).ifPresent(builder::setIsOhqComplete);
        Optional.ofNullable(entity.getIsObqComplete()).ifPresent(builder::setIsObqComplete);
        Optional.ofNullable(entity.getIsDischargePortsComplete())
            .ifPresent(builder::setIsDischargingPortComplete);

        Set<LoadableStudyPortRotation> portRotations = entity.getPortRotations();
        if (null != portRotations && !portRotations.isEmpty()) {
          portRotations.forEach(
              port -> {
                if (port.isActive()
                    && null != port.getOperation()
                    && DISCHARGING_OPERATION_ID.equals(port.getOperation().getId())) {
                  builder.addDischargingPortIds(port.getPortXId());
                }
              });
        }

        List<LoadableStudyAttachments> loadableStudyAttachments =
            this.loadableStudyAttachmentsRepository.findByLoadableStudyXIdAndIsActive(
                entity.getId(), true);
        com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment.Builder
            loadableStudyAttachmentBuilder = LoadableStudyAttachment.newBuilder();
        if (null != loadableStudyAttachments && !loadableStudyAttachments.isEmpty()) {
          loadableStudyAttachments.forEach(
              loadableStudyAttachment -> {
                loadableStudyAttachmentBuilder.setFileName(
                    loadableStudyAttachment.getUploadedFileName());
                loadableStudyAttachmentBuilder.setId(loadableStudyAttachment.getId());

                builder.addAttachments(loadableStudyAttachmentBuilder.build());
              });
        }
        if (null != portRotations && !portRotations.isEmpty()) {
          OhqPorts.Builder ohqPortsBuilder = OhqPorts.newBuilder();
          portRotations.forEach(
              port -> {
                ohqPortsBuilder.setId(port.getId());
                Optional.ofNullable(port.getIsPortRotationOhqComplete())
                    .ifPresent(ohqPortsBuilder::setIsPortRotationOhqComplete);
                builder.addOhqPorts(ohqPortsBuilder.build());
              });
        }
        replyBuilder.addLoadableStudies(builder.build());
      }

    } catch (GenericServiceException e) {
      log.error("GenericServiceException when fetching loadable study", e);
      replyBuilder =
          LoadableStudyReply.newBuilder()
              .setResponseStatus(
                  ResponseStatus.newBuilder()
                      .setCode(e.getCode())
                      .setMessage(e.getMessage())
                      .setStatus(FAILED)
                      .build());
    } catch (Exception e) {
      log.error("Error fetching loadable studies", e);
      replyBuilder =
          LoadableStudyReply.newBuilder()
              .setResponseStatus(
                  ResponseStatus.newBuilder()
                      .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
                      .setMessage("Error fetching loadable studies")
                      .setStatus(FAILED)
                      .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  /**
   * Save loadable study
   *
   * @param {@link LoadableStudyDetail}
   * @param {@link StreamObserver}
   */
  @Override
  public void saveLoadableStudy(
      LoadableStudyDetail request, StreamObserver<LoadableStudyReply> responseObserver) {
    Builder replyBuilder = LoadableStudyReply.newBuilder();
    LoadableStudy entity = null;
    try {

      this.checkIfVoyageClosed(request.getVoyageId());

      if (request.getId() != 0) {
        Optional<LoadableStudy> loadableStudy =
            this.loadableStudyRepository.findByIdAndIsActive(request.getId(), true);
        if (!loadableStudy.isPresent()) {
          throw new GenericServiceException(
              "Loadable study with given id does not exist",
              CommonErrorCodes.E_HTTP_BAD_REQUEST,
              HttpStatusCode.BAD_REQUEST);
        }
        entity = loadableStudy.get();

        this.isPatternGeneratedOrConfirmed(entity);
        List<LoadableQuantity> loadableQuantity =
            this.loadableQuantityRepository.findByLoadableStudyXIdAndIsActive(
                loadableStudy.get().getId(), true);
        if (null != loadableQuantity && !loadableQuantity.isEmpty()) {
          loadableQuantity
              .get(0)
              .setDraftRestriction(
                  StringUtils.isEmpty(request.getDraftMark())
                      ? null
                      : new BigDecimal(request.getDraftMark()));
          this.loadableQuantityRepository.save(loadableQuantity.get(0));
        }
        entity.setIsCargoNominationComplete(request.getIsCargoNominationComplete());
        entity.setIsPortsComplete(request.getIsPortsComplete());
        entity.setIsOhqComplete(request.getIsOhqComplete());
        entity.setIsObqComplete(request.getIsObqComplete());
        entity.setIsDischargePortsComplete(request.getIsDischargingPortComplete());
      } else {
        if (request.getDuplicatedFromId() == 0) {
          this.checkIfVoyageActive(request.getVoyageId());
        }
        entity = new LoadableStudy();
        entity.setIsCargoNominationComplete(false);
        entity.setIsPortsComplete(false);
        entity.setIsOhqComplete(false);
        entity.setIsObqComplete(true);
        entity.setIsDischargePortsComplete(false);
      }

      this.validateLoadableStudySaveRequest(request, entity);
      entity.setName(request.getName());
      entity.setDetails(StringUtils.isEmpty(request.getDetail()) ? null : request.getDetail());
      entity.setCharterer(
          StringUtils.isEmpty(request.getCharterer()) ? null : request.getCharterer());
      entity.setSubCharterer(
          StringUtils.isEmpty(request.getSubCharterer()) ? null : request.getSubCharterer());
      entity.setVesselXId(request.getVesselId());
      entity.setDraftMark(
          StringUtils.isEmpty(request.getDraftMark())
              ? null
              : new BigDecimal(request.getDraftMark()));
      entity.setLoadLineXId(request.getLoadLineXId());
      entity.setDraftRestriction(
          StringUtils.isEmpty(request.getDraftRestriction())
              ? null
              : new BigDecimal(request.getDraftRestriction()));
      entity.setMaxAirTemperature(
          StringUtils.isEmpty(request.getMaxAirTemperature())
              ? null
              : new BigDecimal(request.getMaxAirTemperature()));
      entity.setMaxWaterTemperature(
          StringUtils.isEmpty(request.getMaxWaterTemperature())
              ? null
              : new BigDecimal(request.getMaxWaterTemperature()));

      Set<LoadableStudyAttachments> attachmentCollection = new HashSet<>();
      if (!request.getAttachmentsList().isEmpty()) {
        String folderLocation = this.constructFolderPath(entity);
        Files.createDirectories(Paths.get(this.rootFolder + folderLocation));
        for (LoadableStudyAttachment attachment : request.getAttachmentsList()) {
          String fileName =
              attachment.getFileName().substring(0, attachment.getFileName().lastIndexOf("."));
          String extension =
              attachment
                  .getFileName()
                  .substring(attachment.getFileName().lastIndexOf("."))
                  .toLowerCase();
          String filePath =
              folderLocation + fileName + "_" + System.currentTimeMillis() + extension;
          Path path = Paths.get(this.rootFolder + filePath);
          Files.createFile(path);
          Files.write(path, attachment.getByteString().toByteArray());
          LoadableStudyAttachments attachmentEntity = new LoadableStudyAttachments();
          attachmentEntity.setUploadedFileName(attachment.getFileName());
          attachmentEntity.setFilePath(filePath);
          attachmentEntity.setLoadableStudy(entity);
          attachmentEntity.setIsActive(true);
          attachmentCollection.add(attachmentEntity);
        }
        entity.setAttachments(attachmentCollection);
      }

      if (request.getId() != 0) {
        Set<LoadableStudyAttachments> deletedAttachmentsList =
            this.loadableStudyAttachmentsRepository.findByIdInAndIsActive(
                request.getDeletedAttachmentsList(), true);

        if (deletedAttachmentsList != null && deletedAttachmentsList.size() != 0) {
          deletedAttachmentsList.forEach(
              attachment -> {
                attachment.setIsActive(false);
              });
        }
        attachmentCollection.addAll(deletedAttachmentsList);
      }

      this.setCaseNo(entity);
      entity.setLoadableStudyStatus(
          this.loadableStudyStatusRepository.getOne(LOADABLE_STUDY_INITIAL_STATUS_ID));
      entity = this.loadableStudyRepository.save(entity);
      this.checkDuplicatedFromAndCloneEntity(request, entity);
      replyBuilder
          .setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS).build())
          .setId(entity.getId());

    } catch (GenericServiceException e) {
      log.error("GenericServiceException when saving loadable study", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(e.getCode())
              .setMessage(e.getMessage())
              .setHttpStatusCode(e.getStatus().value())
              .setStatus(FAILED)
              .build());
      this.deleteFiles(entity);
    } catch (Exception e) {
      log.error("Error saving loadable study", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setHttpStatusCode(HttpStatusCode.INTERNAL_SERVER_ERROR.value())
              .setMessage("Error saving loadable study")
              .setStatus(FAILED)
              .build());
      this.deleteFiles(entity);
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  /**
   * * Set case number in loadable study entity
   *
   * @param request
   * @param entity
   */
  private void setCaseNo(LoadableStudy entity) {
    if (null != entity.getDraftRestriction()) {
      entity.setCaseNo(CASE_3);
    } else if (CASE_1_LOAD_LINES.contains(entity.getLoadLineXId())) {
      entity.setCaseNo(CASE_1);
    } else {
      entity.setCaseNo(CASE_2);
    }
  }

  private void validateLoadableStudySaveRequest(LoadableStudyDetail request, LoadableStudy entity)
      throws GenericServiceException {
    Optional<Voyage> voyageOpt = this.voyageRepository.findById(request.getVoyageId());
    if (!voyageOpt.isPresent()) {
      throw new GenericServiceException(
          "Voyage does not exist", CommonErrorCodes.E_HTTP_BAD_REQUEST, null);
    }
    entity.setVoyage(voyageOpt.get());
    if (0 != request.getDuplicatedFromId()) {
      Optional<LoadableStudy> createdFromOpt =
          this.loadableStudyRepository.findById(request.getDuplicatedFromId());
      if (!createdFromOpt.isPresent()) {
        throw new GenericServiceException(
            "Created from loadable study does not exist",
            CommonErrorCodes.E_HTTP_BAD_REQUEST,
            null);
      }
      entity.setDuplicatedFrom(createdFromOpt.get());
    }

    this.validateLoadableStudyName(voyageOpt.get(), request);
  }

  /**
   * Check for duplicate LS name
   *
   * @param voyage
   * @param request
   * @throws GenericServiceException
   */
  private void validateLoadableStudyName(Voyage voyage, LoadableStudyDetail request)
      throws GenericServiceException {
    LoadableStudy duplicate =
        this.loadableStudyRepository.findByVoyageAndNameIgnoreCaseAndIsActive(
            voyage, request.getName(), true);
    if ((request.getId() == 0 && null != duplicate)
        || (null != duplicate && request.getId() != duplicate.getId().longValue())) {
      throw new GenericServiceException(
          "LS already exists with given name",
          CommonErrorCodes.E_CPDSS_LS_NAME_EXISTS,
          HttpStatusCode.BAD_REQUEST);
    }
  }

  /**
   * Construct folder path for loadable study attachments
   *
   * @param loadableStudy - loadable study entity
   * @param voyage - voyage entity
   * @return - the folder path
   */
  private String constructFolderPath(LoadableStudy loadableStudy) {
    String separator = File.separator;
    StringBuilder pathBuilder = new StringBuilder(separator);
    pathBuilder
        .append("company_")
        .append(loadableStudy.getVoyage().getCompanyXId())
        .append(separator)
        .append("vessel_")
        .append(loadableStudy.getVesselXId())
        .append(separator)
        .append(loadableStudy.getVoyage().getVoyageNo().replace(" ", "_"))
        .append("_")
        .append(loadableStudy.getVoyage().getId())
        .append(separator)
        .append(loadableStudy.getName().replace(" ", "_"))
        .append(separator);
    return valueOf(pathBuilder);
  }

  /**
   * Method to delete file if there is any exception when saving loadable study
   *
   * @param entity - the set of entities for attachments
   */
  private void deleteFiles(LoadableStudy entity) {
    if (null == entity || null == entity.getAttachments()) {
      return;
    }
    for (LoadableStudyAttachments attachment : entity.getAttachments()) {
      Path path = Paths.get(this.rootFolder + attachment.getFilePath());
      try {
        Files.deleteIfExists(path);
      } catch (IOException e) {
        log.error("unable to delete file : {}", this.rootFolder + attachment.getFilePath(), e);
      }
    }
  }

  @Override
  public void saveCargoNomination(
      CargoNominationRequest request, StreamObserver<CargoNominationReply> responseObserver) {
    CargoNominationReply.Builder cargoNominationReplyBuilder = CargoNominationReply.newBuilder();
    try {
      Optional<LoadableStudy> loadableStudy =
          this.loadableStudyRepository.findByIdAndIsActive(request.getLoadableStudyId(), true);
      if (!loadableStudy.isPresent()) {
        throw new GenericServiceException(
            "Loadable Study does not exist",
            CommonErrorCodes.E_HTTP_BAD_REQUEST,
            HttpStatusCode.BAD_REQUEST);
      }
      this.checkIfVoyageClosed(loadableStudy.get().getVoyage().getId());
      this.isPatternGeneratedOrConfirmed(loadableStudy.get());

      CargoNomination cargoNomination = null;
      List<Long> existingCargoPortIds = null;
      ApiTempHistory apiTempHistory   = null;
      if (request.getCargoNominationDetail() != null
          && request.getCargoNominationDetail().getId() != 0) {
        Optional<CargoNomination> existingCargoNomination =
            this.cargoNominationRepository.findByIdAndIsActive(
                request.getCargoNominationDetail().getId(), true);
        if (!existingCargoNomination.isPresent()) {
          throw new GenericServiceException(
              "Cargo Nomination does not exist",
              CommonErrorCodes.E_HTTP_BAD_REQUEST,
              HttpStatusCode.BAD_REQUEST);
        }
        cargoNomination = existingCargoNomination.get();
        if (!CollectionUtils.isEmpty(cargoNomination.getCargoNominationPortDetails())) {
          existingCargoPortIds =
              cargoNomination.getCargoNominationPortDetails().stream()
                  .map(CargoNominationPortDetails::getPortId)
                  .collect(Collectors.toList());
        }
        cargoNomination = buildCargoNomination(cargoNomination, request);
        apiTempHistory = buildApiTempHistory(cargoNomination, request);
      } else if (request.getCargoNominationDetail() != null
          && request.getCargoNominationDetail().getId() == 0) {
        cargoNomination = new CargoNomination();
        cargoNomination = buildCargoNomination(cargoNomination, request);
        apiTempHistory = buildApiTempHistory(cargoNomination, request);
      }

      // update port rotation table with loading ports from cargo nomination
      LoadableStudy loadableStudyRecord = loadableStudy.get();
      // validate if requested are already added as transit ports
      if (!cargoNomination.getCargoNominationPortDetails().isEmpty()) {
        List<Long> requestedPortIds =
            cargoNomination.getCargoNominationPortDetails().stream()
                .map(CargoNominationPortDetails::getPortId)
                .collect(Collectors.toList());
        validateTransitPorts(loadableStudyRecord, requestedPortIds);
      }
      // update loadable study level isCargoNominationComplete status
      if (request.getCargoNominationDetail() != null) {
        loadableStudyRecord.setIsCargoNominationComplete(
            request.getCargoNominationDetail().getIsCargoNominationComplete());
        this.loadableStudyRepository.save(loadableStudyRecord);
      }

      this.cargoNominationRepository.save(cargoNomination);
      this.apiTempHistoryRepository.save(apiTempHistory);
      this.updatePortRotationWithLoadingPorts(
          loadableStudyRecord, cargoNomination, existingCargoPortIds);
      cargoNominationReplyBuilder
          .setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS))
          .setCargoNominationId((cargoNomination.getId() != null) ? cargoNomination.getId() : 0);
    } catch (GenericServiceException e) {
      log.error("GenericServiceException saveCargoNomination", e);
      cargoNominationReplyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(e.getCode())
              .setMessage(e.getMessage())
              .setHttpStatusCode(e.getStatus().value())
              .setStatus(FAILED)
              .build());
    } catch (Exception e) {
      log.error("Error saving cargo nomination", e);
      cargoNominationReplyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(FAILED));
    } finally {
      responseObserver.onNext(cargoNominationReplyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  /**
   * Fetch ports for the specific loadableStudy already available in port rotation and update to
   * port rotation along with port master fields water density, maxDraft, maxAirDraft only those
   * ports that are not already available
   *
   * @param cargoNomination
   * @throws GenericServiceException
   */
  private void updatePortRotationWithLoadingPorts(
      LoadableStudy loadableStudy, CargoNomination cargoNomination, List<Long> existingCargoPortIds)
      throws GenericServiceException {
    List<LoadableStudyPortRotation> loadableStudyPortRotations =
        this.loadableStudyPortRotationRepository.findByLoadableStudyAndOperationAndIsActive(
            loadableStudy, cargoOperationRepository.getOne(LOADING_OPERATION_ID), true);
    List<Long> requestedPortIds = null;
    List<Long> existingPortIds = null;
    if (!cargoNomination.getCargoNominationPortDetails().isEmpty()) {
      requestedPortIds =
          cargoNomination.getCargoNominationPortDetails().stream()
              .map(CargoNominationPortDetails::getPortId)
              .collect(Collectors.toList());
    }
    if (!loadableStudyPortRotations.isEmpty()) {
      existingPortIds =
          loadableStudyPortRotations.stream()
              .map(LoadableStudyPortRotation::getPortXId)
              .collect(Collectors.toList());
    }
    // remove existing cargo portIds from port rotation and synoptical if not
    // available in request
    if (!CollectionUtils.isEmpty(requestedPortIds)
        && !CollectionUtils.isEmpty(existingCargoPortIds)) {
      existingCargoPortIds.removeAll(requestedPortIds);
      if (!CollectionUtils.isEmpty(existingCargoPortIds)) {
        existingCargoPortIds.forEach(
            existingPortId -> {
              Long otherCargoRefExistCount =
                  this.cargoNominationRepository.getCountCargoNominationWithPortIds(
                      cargoNomination.getLoadableStudyXId(), cargoNomination, existingPortId);
              if (Objects.equals(otherCargoRefExistCount, Long.valueOf("0"))) {
                loadableStudyPortRotationRepository.deleteLoadingPortRotationByPort(
                    loadableStudy, existingPortId);
                synopticalTableRepository.deleteSynopticalPorts(
                    loadableStudy.getId(), existingPortId);
              }
            });
      }
    }
    // remove loading portIds from request which are already available in port
    // rotation for the
    // specific loadable study
    if (!CollectionUtils.isEmpty(requestedPortIds) && !CollectionUtils.isEmpty(existingPortIds)) {
      requestedPortIds.removeAll(existingPortIds);
    }
    // fetch the specific ports attributes like waterDensity and draft values from
    // port master
    if (!CollectionUtils.isEmpty(requestedPortIds)) {
      GetPortInfoByPortIdsRequest.Builder reqBuilder = GetPortInfoByPortIdsRequest.newBuilder();
      buildGetPortInfoByPortIdsRequest(reqBuilder, cargoNomination);
      PortReply portReply = portInfoGrpcService.getPortInfoByPortIds(reqBuilder.build());
      if (portReply != null
          && portReply.getResponseStatus() != null
          && !SUCCESS.equalsIgnoreCase(portReply.getResponseStatus().getStatus())) {
        throw new GenericServiceException(
            "Error in calling port service",
            CommonErrorCodes.E_GEN_INTERNAL_ERR,
            HttpStatusCode.INTERNAL_SERVER_ERROR);
      }
      // update loadable-study-port-rotation with ports from cargoNomination and port
      // attributes
      buildAndSaveLoadableStudyPortRotationEntities(loadableStudy, requestedPortIds, portReply);
    }
  }

  /**
   * Fetch transit ports for the specific loadableStudy if available in port rotation so that they
   * are not added as loading ports
   *
   * @param cargoNomination
   * @throws GenericServiceException
   */
  private void validateTransitPorts(LoadableStudy loadableStudy, List<Long> requestedPortIds)
      throws GenericServiceException {
    List<Long> transitPorts =
        this.loadableStudyPortRotationRepository.getTransitPorts(loadableStudy, requestedPortIds);
    if (!CollectionUtils.isEmpty(transitPorts)) {
      throw new GenericServiceException(
          "Ports exist as transit ports "
              + StringUtils.collectionToCommaDelimitedString(transitPorts),
          CommonErrorCodes.E_CPDSS_TRANSIT_PORT_EXISTS,
          HttpStatusCode.BAD_REQUEST);
    }
  }

  /**
   * Create Port rotation entities for each loading port from cargoNomination with pre-populate port
   * master attributes
   *
   * @param request
   * @return
   */
  private void buildAndSaveLoadableStudyPortRotationEntities(
      LoadableStudy loadableStudy, List<Long> requestedPortIds, PortReply portReply) {
    if (!CollectionUtils.isEmpty(requestedPortIds)
        && portReply != null
        && !CollectionUtils.isEmpty(portReply.getPortsList())) {
      AtomicLong atomLong = new AtomicLong(this.findMaxPortOrderForLoadableStudy(loadableStudy));
      List<LoadableStudyPortRotation> portRotationList = new ArrayList<>();
      requestedPortIds.stream()
          .forEach(
              requestedPortId ->
                  portReply.getPortsList().stream()
                      .filter(port -> Objects.equals(requestedPortId, port.getId()))
                      .forEach(
                          port -> {
                            LoadableStudyPortRotation portRotationEntity =
                                new LoadableStudyPortRotation();
                            portRotationEntity.setLoadableStudy(loadableStudy);
                            portRotationEntity.setPortXId(port.getId());
                            portRotationEntity.setOperation(
                                this.cargoOperationRepository.getOne(LOADING_OPERATION_ID));
                            portRotationEntity.setSeaWaterDensity(
                                !StringUtils.isEmpty(port.getWaterDensity())
                                    ? new BigDecimal(port.getWaterDensity())
                                    : null);
                            portRotationEntity.setMaxDraft(
                                !StringUtils.isEmpty(port.getMaxDraft())
                                    ? new BigDecimal(port.getMaxDraft())
                                    : null);
                            portRotationEntity.setAirDraftRestriction(
                                !StringUtils.isEmpty(port.getMaxAirDraft())
                                    ? new BigDecimal(port.getMaxAirDraft())
                                    : null);
                            portRotationEntity.setPortOrder(atomLong.incrementAndGet());
                            // add ports to synoptical table by reusing the function called by
                            // port-rotation flow
                            buildPortsInfoSynopticalTable(
                                portRotationEntity, LOADING_OPERATION_ID, port.getId());
                            portRotationList.add(portRotationEntity);
                          }));
      loadableStudyPortRotationRepository.saveAll(portRotationList);
    }
  }

  /**
   * Builds the request for fetching the port attributes from port master
   *
   * @param cargoNomination
   */
  private void buildGetPortInfoByPortIdsRequest(
      GetPortInfoByPortIdsRequest.Builder reqBuilder, CargoNomination cargoNomination) {
    // build fetch port details request object
    if (cargoNomination != null
        && !CollectionUtils.isEmpty(cargoNomination.getCargoNominationPortDetails())) {
      cargoNomination
          .getCargoNominationPortDetails()
          .forEach(
              loadingPort -> {
                Optional.ofNullable(loadingPort.getPortId()).ifPresent(reqBuilder::addId);
              });
    }
  }
  
  private ApiTempHistory buildApiTempHistory(
	      CargoNomination cargoNomination, CargoNominationRequest request) {
	  
	  return ApiTempHistory.builder()
	     .vesselId(request.getVesselId())
	     .cargoId(cargoNomination.getCargoXId())
	     .api(cargoNomination.getApi())
	     .isActive(true)
	     .temp(cargoNomination.getTemperature()).build();

  }

  private CargoNomination buildCargoNomination(
      CargoNomination cargoNomination, CargoNominationRequest request) {
    cargoNomination.setLoadableStudyXId(request.getCargoNominationDetail().getLoadableStudyId());
    cargoNomination.setPriority(request.getCargoNominationDetail().getPriority());
    cargoNomination.setCargoXId(request.getCargoNominationDetail().getCargoId());
    cargoNomination.setAbbreviation(request.getCargoNominationDetail().getAbbreviation());
    cargoNomination.setColor(request.getCargoNominationDetail().getColor());
    cargoNomination.setQuantity(
        !StringUtils.isEmpty(request.getCargoNominationDetail().getQuantity())
            ? new BigDecimal(request.getCargoNominationDetail().getQuantity())
            : null);
    cargoNomination.setMaxTolerance(
        !StringUtils.isEmpty(request.getCargoNominationDetail().getMaxTolerance())
            ? new BigDecimal(request.getCargoNominationDetail().getMaxTolerance())
            : null);
    cargoNomination.setMinTolerance(
        !StringUtils.isEmpty(request.getCargoNominationDetail().getMinTolerance())
            ? new BigDecimal(request.getCargoNominationDetail().getMinTolerance())
            : null);
    cargoNomination.setApi(
        !StringUtils.isEmpty(request.getCargoNominationDetail().getApiEst())
            ? new BigDecimal(request.getCargoNominationDetail().getApiEst())
            : null);
    cargoNomination.setTemperature(
        !StringUtils.isEmpty(request.getCargoNominationDetail().getTempEst())
            ? new BigDecimal(request.getCargoNominationDetail().getTempEst())
            : null);
    cargoNomination.setSegregationXId(request.getCargoNominationDetail().getSegregationId());
    // activate the records to be saved
    cargoNomination.setIsActive(true);
    if (!request.getCargoNominationDetail().getLoadingPortDetailsList().isEmpty()) {
      // clear any existing CargoNominationPortDetails otherwise create new
      if (cargoNomination.getCargoNominationPortDetails() != null) {
        cargoNomination.getCargoNominationPortDetails().clear();
      }
      Set<CargoNominationPortDetails> cargoNominationPortDetailsList =
          request.getCargoNominationDetail().getLoadingPortDetailsList().stream()
              .map(
                  loadingPortDetail -> {
                    CargoNominationPortDetails cargoNominationPortDetails =
                        new CargoNominationPortDetails();
                    cargoNominationPortDetails.setCargoNomination(cargoNomination);
                    cargoNominationPortDetails.setPortId(loadingPortDetail.getPortId());
                    cargoNominationPortDetails.setQuantity(
                        !loadingPortDetail.getQuantity().isEmpty()
                            ? new BigDecimal(loadingPortDetail.getQuantity())
                            : null);
                    cargoNominationPortDetails.setIsActive(true);
                    return cargoNominationPortDetails;
                  })
              .collect(Collectors.toSet());
      // clear any existing CargoNominationPortDetails otherwise create new
      if (cargoNomination.getCargoNominationPortDetails() != null) {
        cargoNomination.getCargoNominationPortDetails().addAll(cargoNominationPortDetailsList);
      } else {
        cargoNomination.setCargoNominationPortDetails(cargoNominationPortDetailsList);
      }
    }
    return cargoNomination;
  }

  @Override
  public void getLoadableStudyPortRotation(
      PortRotationRequest request, StreamObserver<PortRotationReply> responseObserver) {
    PortRotationReply.Builder replyBuilder = PortRotationReply.newBuilder();
    try {
      Optional<LoadableStudy> loadableStudyOpt =
          this.loadableStudyRepository.findById(request.getLoadableStudyId());
      if (!loadableStudyOpt.isPresent()) {
        throw new GenericServiceException(
            "Loadable study does not exist in database", CommonErrorCodes.E_HTTP_BAD_REQUEST, null);
      }

      List<LoadableStudyPortRotation> entityList =
          this.loadableStudyPortRotationRepository
              .findByLoadableStudyAndIsActiveOrderByOperationAndPortOrder(
                  loadableStudyOpt.get(), true);
      for (LoadableStudyPortRotation entity : entityList) {
        replyBuilder.addPorts(
            this.createPortDetail(
                entity,
                DateTimeFormatter.ofPattern(ETA_ETD_FORMAT),
                DateTimeFormatter.ofPattern(LAY_CAN_FORMAT)));
      }
      List<CargoOperation> operationEntityList =
          this.cargoOperationRepository.findByIsActiveOrderById(true);
      for (CargoOperation entity : operationEntityList) {
        replyBuilder.addOperations(this.createOperationDetail(entity));
      }
      replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS).build());
    } catch (GenericServiceException e) {
      log.error("GenericServiceException when fetching loadable study - port data", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(e.getCode())
              .setMessage(e.getMessage())
              .setStatus(FAILED)
              .build());
    } catch (Exception e) {
      log.error("Exception when fetching port rotation data", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage("Exception when fetching loadable study - port data")
              .setStatus(FAILED)
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  /**
   * Create {@link Operation} from {@link CargoOperation}
   *
   * @param entity - {@link CargoOperation}
   * @return
   */
  private Operation createOperationDetail(CargoOperation entity) {
    return Operation.newBuilder().setId(entity.getId()).setOperationName(entity.getName()).build();
  }

  /**
   * Create {@link PortDetail} from {@link LoadableStudyPortRotation}
   *
   * @param entity {@link LoadableStudyPortRotation}
   * @return {@link PortDetail}
   */
  private PortRotationDetail createPortDetail(
      LoadableStudyPortRotation entity,
      DateTimeFormatter etaEtdFormatter,
      DateTimeFormatter layCanFormatter) {
    PortRotationDetail.Builder builder = PortRotationDetail.newBuilder();
    builder.setId(entity.getId());
    builder.setLoadableStudyId(entity.getLoadableStudy().getId());
    Optional.ofNullable(entity.getPortXId()).ifPresent(builder::setPortId);
    Optional.ofNullable(entity.getOperation()).ifPresent(op -> builder.setOperationId(op.getId()));
    Optional.ofNullable(entity.getBerthXId()).ifPresent(builder::setBerthId);
    Optional.ofNullable(entity.getSeaWaterDensity())
        .ifPresent(density -> builder.setSeaWaterDensity(valueOf(density)));
    Optional.ofNullable(entity.getDistanceBetweenPorts())
        .ifPresent(distance -> builder.setDistanceBetweenPorts(valueOf(distance)));
    Optional.ofNullable(entity.getTimeOfStay())
        .ifPresent(timeOfStay -> builder.setTimeOfStay(valueOf(timeOfStay)));
    Optional.ofNullable(entity.getMaxDraft())
        .ifPresent(maxDraft -> builder.setMaxDraft(valueOf(maxDraft)));
    Optional.ofNullable(entity.getAirDraftRestriction())
        .ifPresent(airDraft -> builder.setMaxAirDraft(valueOf(airDraft)));
    Optional.ofNullable(entity.getEta())
        .ifPresent(eta -> builder.setEta(etaEtdFormatter.format(eta)));
    Optional.ofNullable(entity.getEtd())
        .ifPresent(etd -> builder.setEtd(etaEtdFormatter.format(etd)));
    Optional.ofNullable(entity.getLayCanFrom())
        .ifPresent(layCanFrom -> builder.setLayCanFrom(layCanFormatter.format(layCanFrom)));
    Optional.ofNullable(entity.getLayCanTo())
        .ifPresent(layCanTo -> builder.setLayCanTo(layCanFormatter.format(layCanTo)));
    Optional.ofNullable(entity.getPortOrder()).ifPresent(builder::setPortOrder);
    if (entity.getPortXId() != null && entity.getPortXId() > 0) {
      this.setPortTimezoneId(entity.getPortXId(), builder);
    }
    return builder.build();
  }

  private void setPortTimezoneId(Long portId, PortRotationDetail.Builder builder) {
    PortInfo.PortReply reply =
        portInfoGrpcService.getPortInfoByPortIds(
            PortInfo.GetPortInfoByPortIdsRequest.newBuilder().addId(portId).build());
    if (!reply.getPortsList().isEmpty()) { // Expect single entry as response
      builder.setPortTimezoneId(reply.getPortsList().get(0).getTimezoneId());
    }
  }

  /**
   * Retrieves list of cargoNominations by LoadableStudyId can be extended to other Ids like
   * vesselId or voyageId
   */
  @Override
  public void getCargoNominationById(
      CargoNominationRequest request, StreamObserver<CargoNominationReply> responseObserver) {
    com.cpdss.common.generated.LoadableStudy.CargoNominationReply.Builder replyBuilder =
        CargoNominationReply.newBuilder();
    try {
      Optional<LoadableStudy> loadableStudyOpt =
          this.loadableStudyRepository.findById(request.getLoadableStudyId());
      if (!loadableStudyOpt.isPresent()) {
        throw new GenericServiceException(
            "Loadable study does not exist", CommonErrorCodes.E_HTTP_BAD_REQUEST, null);
      }
      List<CargoNomination> cargoNominationList =
          this.cargoNominationRepository.findByLoadableStudyXIdAndIsActiveOrderByCreatedDateTime(
              request.getLoadableStudyId(), true);
      buildCargoNominationReply(cargoNominationList, replyBuilder);
      replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS));
    } catch (GenericServiceException e) {
      log.error("GenericServiceException when fetching loadable study - port data", e);
      replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(FAILED));
    } catch (Exception e) {
      log.error("Exception when fetching loadable study - port data", e);
      replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(FAILED));
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  /**
   * method for getting loadable quantity
   *
   * @param request - has the loadable quantity id
   * @param responseObserver
   */
  @Override
  public void getLoadableQuantity(
      LoadableQuantityReply request, StreamObserver<LoadableQuantityResponse> responseObserver) {
    LoadableQuantityResponse.Builder builder = LoadableQuantityResponse.newBuilder();
    try {
      List<LoadableQuantity> loadableQuantity =
          loadableQuantityRepository.findByLoadableStudyXIdAndIsActive(
              request.getLoadableStudyId(), true);
      Optional<LoadableStudy> loadableStudy =
          this.loadableStudyRepository.findById(request.getLoadableStudyId());
      if (!loadableStudy.isPresent()) {
        log.info(INVALID_LOADABLE_STUDY_ID, request.getLoadableStudyId());
        throw new GenericServiceException(
            INVALID_LOADABLE_QUANTITY,
            CommonErrorCodes.E_HTTP_BAD_REQUEST,
            HttpStatusCode.BAD_REQUEST);
      }
      List<Long> portList = this.getPortRoationPortIds(loadableStudy.get());
      BigDecimal foOnboard = BigDecimal.ZERO;
      BigDecimal doOnboard = BigDecimal.ZERO;
      BigDecimal freshWaterOnBoard = BigDecimal.ZERO;
      BigDecimal boileWaterOnBoard = BigDecimal.ZERO;
      if (!portList.isEmpty()) {

        long firstPort = portList.iterator().next();

        List<OnHandQuantity> onHandQuantityList =
            this.onHandQuantityRepository.findByLoadableStudyAndIsActive(loadableStudy.get(), true);

        if (!onHandQuantityList.isEmpty()) {
          foOnboard =
              onHandQuantityList.stream()
                  .filter(
                      ohq ->
                          null != ohq.getFuelTypeXId()
                              && null != ohq.getPortXId()
                              && ohq.getFuelTypeXId().equals(FUEL_OIL_TANK_CATEGORY_ID)
                              && ohq.getPortXId().equals(firstPort)
                              && ohq.getIsActive())
                  .map(OnHandQuantity::getArrivalQuantity)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
          doOnboard =
              onHandQuantityList.stream()
                  .filter(
                      ohq ->
                          null != ohq.getFuelTypeXId()
                              && null != ohq.getPortXId()
                              && ohq.getFuelTypeXId().equals(DIESEL_OIL_TANK_CATEGORY_ID)
                              && ohq.getPortXId().equals(firstPort)
                              && ohq.getIsActive())
                  .map(OnHandQuantity::getArrivalQuantity)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
          freshWaterOnBoard =
              onHandQuantityList.stream()
                  .filter(
                      ohq ->
                          null != ohq.getFuelTypeXId()
                              && null != ohq.getPortXId()
                              && ohq.getFuelTypeXId().equals(FRESH_WATER_TANK_CATEGORY_ID)
                              && ohq.getPortXId() == firstPort
                              && ohq.getIsActive())
                  .map(OnHandQuantity::getArrivalQuantity)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
          boileWaterOnBoard =
              onHandQuantityList.stream()
                  .filter(
                      ohq ->
                          ohq.getFuelTypeXId().equals(FRESH_WATER_TANK_CATEGORY_ID)
                              && ohq.getPortXId().equals(firstPort)
                              && ohq.getIsActive())
                  .map(OnHandQuantity::getArrivalQuantity)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
        }
      }
      VesselRequest replyBuilder =
          VesselRequest.newBuilder()
              .setVesselId(loadableStudy.get().getVesselXId())
              .setVesselDraftConditionId(loadableStudy.get().getLoadLineXId())
              .setDraftExtreme(loadableStudy.get().getDraftMark().toString())
              .build();
      VesselReply vesselReply = this.getVesselDetailsById(replyBuilder);
      String selectedZone = "";
      if (vesselReply.getVesselLoadableQuantityDetails().getDraftConditionName() != null) {
        String[] array =
            vesselReply.getVesselLoadableQuantityDetails().getDraftConditionName().split(" ");
        selectedZone = array[array.length - 1];
      }
      builder.setCaseNo(loadableStudy.get().getCaseNo());
      builder.setSelectedZone(selectedZone);

      // DSS-2211
      // Collect all last update time, find max of list
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
      String lastUpdatedTime = null;
      List<LocalDateTime> lastUpdateTimeList = new ArrayList<>();
      if (!loadableQuantity.isEmpty()) {
        lastUpdateTimeList.add(loadableQuantity.get(0).getLastModifiedDateTime());
      }
      if (loadableStudy.isPresent()) {
        lastUpdateTimeList.add(loadableStudy.get().getLastModifiedDateTime());
      }
      LocalDateTime maxOne = Collections.max(lastUpdateTimeList);
      lastUpdatedTime = formatter.format(maxOne);

      if (loadableQuantity.isEmpty()) {
        String draftRestictoin = "";
        if (Optional.ofNullable(loadableStudy.get().getDraftRestriction()).isPresent()) {
          draftRestictoin = loadableStudy.get().getDraftRestriction().toString();
        } else if (Optional.ofNullable(loadableStudy.get().getDraftMark()).isPresent()) {
          draftRestictoin = loadableStudy.get().getDraftMark().toString();
        }
        LoadableQuantityRequest loadableQuantityRequest =
            LoadableQuantityRequest.newBuilder()
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
                .build();
        builder.setLoadableQuantityRequest(loadableQuantityRequest);
        builder.setResponseStatus(StatusReply.newBuilder().setStatus(SUCCESS).setMessage(SUCCESS));
      } else {

        LoadableQuantityRequest.Builder loadableQuantityRequest =
            LoadableQuantityRequest.newBuilder();
        loadableQuantityRequest.setLastUpdatedTime(lastUpdatedTime);
        loadableQuantityRequest.setId(loadableQuantity.get(0).getId());
        Optional.ofNullable(loadableQuantity.get(0).getDisplacementAtDraftRestriction())
            .ifPresent(
                disp -> loadableQuantityRequest.setDisplacmentDraftRestriction(disp.toString()));
        Optional.ofNullable(loadableQuantity.get(0).getConstant())
            .ifPresent(cons -> loadableQuantityRequest.setConstant(cons.toString()));
        Optional.ofNullable(loadableQuantity.get(0).getDraftRestriction())
            .ifPresent(
                draftRestriction ->
                    loadableQuantityRequest.setDraftRestriction(draftRestriction.toString()));
        Optional.ofNullable(loadableQuantity.get(0).getDistanceFromLastPort())
            .ifPresent(dist -> loadableQuantityRequest.setDistanceFromLastPort(dist.toString()));
        Optional.ofNullable(loadableQuantity.get(0).getDeadWeight())
            .ifPresent(deadWeight -> loadableQuantityRequest.setDwt(deadWeight.toString()));

        loadableQuantityRequest.setEstFOOnBoard(String.valueOf(foOnboard));
        loadableQuantityRequest.setEstDOOnBoard(String.valueOf(doOnboard));
        loadableQuantityRequest.setEstFreshWaterOnBoard(String.valueOf(freshWaterOnBoard));
        loadableQuantityRequest.setBoilerWaterOnBoard(String.valueOf(boileWaterOnBoard));

        Optional.ofNullable(loadableQuantity.get(0).getEstimatedSagging())
            .ifPresent(estSagging -> loadableQuantityRequest.setEstSagging(estSagging.toString()));
        Optional.ofNullable(loadableQuantity.get(0).getEstimatedSeaDensity())
            .ifPresent(
                estSeaDensity ->
                    loadableQuantityRequest.setEstSeaDensity(estSeaDensity.toString()));
        Optional.ofNullable(loadableQuantity.get(0).getOtherIfAny())
            .ifPresent(otherIfAny -> loadableQuantityRequest.setOtherIfAny(otherIfAny.toString()));
        Optional.ofNullable(loadableQuantity.get(0).getSaggingDeduction())
            .ifPresent(
                saggingDeduction ->
                    loadableQuantityRequest.setSaggingDeduction(saggingDeduction.toString()));
        Optional.ofNullable(loadableQuantity.get(0).getSgCorrection())
            .ifPresent(
                sgCorrection -> loadableQuantityRequest.setSgCorrection(sgCorrection.toString()));
        Optional.ofNullable(loadableQuantity.get(0).getTotalQuantity())
            .ifPresent(
                totalQuantity ->
                    loadableQuantityRequest.setTotalQuantity(totalQuantity.toString()));
        Optional.ofNullable(loadableQuantity.get(0).getTpcatDraft())
            .ifPresent(tpc -> loadableQuantityRequest.setTpc(tpc.toString()));
        Optional.ofNullable(loadableQuantity.get(0).getVesselAverageSpeed())
            .ifPresent(
                vesselAverageSpeed ->
                    loadableQuantityRequest.setVesselAverageSpeed(vesselAverageSpeed.toString()));
        Optional.ofNullable(loadableQuantity.get(0).getLightWeight())
            .ifPresent(
                vesselLightWeight ->
                    loadableQuantityRequest.setVesselLightWeight(vesselLightWeight.toString()));
        Optional.ofNullable(loadableQuantity.get(0).getLastModifiedDateTime())
            .ifPresent(
                updateDateAndTime ->
                    loadableQuantityRequest.setUpdateDateAndTime(
                        DateTimeFormatter.ofPattern(DATE_FORMAT).format(updateDateAndTime)));
        Optional.ofNullable(loadableQuantity.get(0).getPortId())
            .ifPresent(portId -> loadableQuantityRequest.setPortId(portId.longValue()));

        Optional.ofNullable(loadableQuantity.get(0).getBallast())
            .ifPresent(ballast -> loadableQuantityRequest.setBallast(ballast.toString()));
        Optional.ofNullable(loadableQuantity.get(0).getRunningHours())
            .ifPresent(
                runningHours -> loadableQuantityRequest.setRunningHours(runningHours.toString()));
        Optional.ofNullable(loadableQuantity.get(0).getRunningDays())
            .ifPresent(
                runningDays -> loadableQuantityRequest.setRunningDays(runningDays.toString()));
        Optional.ofNullable(loadableQuantity.get(0).getFoConsumptionInSZ())
            .ifPresent(
                foConsumptionInSZ ->
                    loadableQuantityRequest.setFoConInSZ(foConsumptionInSZ.toString()));
        Optional.ofNullable(loadableQuantity.get(0).getDraftRestriction())
            .ifPresent(
                draftRestriction ->
                    loadableQuantityRequest.setDraftRestriction(draftRestriction.toString()));
        Optional.ofNullable(loadableQuantity.get(0).getSubTotal())
            .ifPresent(subTotal -> loadableQuantityRequest.setSubTotal(subTotal.toString()));
        Optional.ofNullable(loadableQuantity.get(0).getFoConsumptionPerDay())
            .ifPresent(
                foConsumptionPerDay ->
                    loadableQuantityRequest.setFoConsumptionPerDay(foConsumptionPerDay.toString()));
        builder.setLoadableQuantityRequest(loadableQuantityRequest);
        builder.setResponseStatus(StatusReply.newBuilder().setStatus(SUCCESS).setMessage(SUCCESS));
      }
    } catch (GenericServiceException e) {
      log.error("Error getting loadable quantity ", e);
      builder.setResponseStatus(
          StatusReply.newBuilder()
              .setStatus(FAILED)
              .setMessage(e.getMessage())
              .setCode(e.getCode()));
    } catch (Exception e) {
      log.error("Error getting loadable quantity ", e);
      builder.setResponseStatus(
          StatusReply.newBuilder()
              .setStatus(FAILED)
              .setMessage(FAILED)
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR));
    } finally {
      responseObserver.onNext(builder.build());
      responseObserver.onCompleted();
    }
  }

  public VesselReply getVesselDetailsById(VesselRequest replyBuilder) {
    return this.vesselInfoGrpcService.getVesselDetailsById(replyBuilder);
  }

  private void buildCargoNominationReply(
      List<CargoNomination> cargoNominationList,
      com.cpdss.common.generated.LoadableStudy.CargoNominationReply.Builder
          cargoNominationReplyBuilder) {
    if (!CollectionUtils.isEmpty(cargoNominationList)) {
      cargoNominationList.forEach(
          cargoNomination -> {
            CargoNominationDetail.Builder builder = CargoNominationDetail.newBuilder();
            Optional.ofNullable(cargoNomination.getId()).ifPresent(builder::setId);
            Optional.ofNullable(cargoNomination.getLoadableStudyXId())
                .ifPresent(builder::setLoadableStudyId);
            Optional.ofNullable(cargoNomination.getPriority()).ifPresent(builder::setPriority);
            Optional.ofNullable(cargoNomination.getColor()).ifPresent(builder::setColor);
            Optional.ofNullable(cargoNomination.getCargoXId()).ifPresent(builder::setCargoId);
            Optional.ofNullable(cargoNomination.getAbbreviation())
                .ifPresent(builder::setAbbreviation);
            // build inner loadingPort details object
            if (!CollectionUtils.isEmpty(cargoNomination.getCargoNominationPortDetails())) {
              cargoNomination
                  .getCargoNominationPortDetails()
                  .forEach(
                      loadingPort -> {
                        LoadingPortDetail.Builder loadingPortDetailBuilder =
                            LoadingPortDetail.newBuilder();
                        Optional.ofNullable(loadingPort.getPortId())
                            .ifPresent(loadingPortDetailBuilder::setPortId);
                        Optional.ofNullable(loadingPort.getQuantity())
                            .ifPresent(
                                quantity ->
                                    loadingPortDetailBuilder.setQuantity(String.valueOf(quantity)));
                        builder.addLoadingPortDetails(loadingPortDetailBuilder);
                      });
            }
            Optional.ofNullable(cargoNomination.getMaxTolerance())
                .ifPresent(maxTolerance -> builder.setMaxTolerance(String.valueOf(maxTolerance)));
            Optional.ofNullable(cargoNomination.getMinTolerance())
                .ifPresent(minTolerance -> builder.setMinTolerance(String.valueOf(minTolerance)));
            Optional.ofNullable(cargoNomination.getApi())
                .ifPresent(api -> builder.setApiEst(String.valueOf(api)));
            Optional.ofNullable(cargoNomination.getTemperature())
                .ifPresent(temperature -> builder.setTempEst(String.valueOf(temperature)));
            Optional.ofNullable(cargoNomination.getSegregationXId())
                .ifPresent(builder::setSegregationId);
            cargoNominationReplyBuilder.addCargoNominations(builder);
          });
    }
  }

  /** Retrieves all valve segregation available */
  @Override
  public void getValveSegregation(
      ValveSegregationRequest request, StreamObserver<ValveSegregationReply> responseObserver) {
    ValveSegregationReply.Builder reply = ValveSegregationReply.newBuilder();
    try {
      Iterable<CargoNominationValveSegregation> segregationsList =
          valveSegregationRepository.findAll();
      segregationsList.forEach(
          segregation -> {
            ValveSegregation.Builder segregationDetail = ValveSegregation.newBuilder();
            if (segregation.getId() != null) {
              segregationDetail.setId(segregation.getId());
            }
            if (!StringUtils.isEmpty(segregation.getName())) {
              segregationDetail.setName(segregation.getName());
            }
            reply.addValveSegregation(segregationDetail);
          });
      ResponseStatus.Builder responseStatus = ResponseStatus.newBuilder();
      responseStatus.setStatus(SUCCESS);
      reply.setResponseStatus(responseStatus);
    } catch (Exception e) {
      log.error("Error in getValveSegregation method ", e);
      ResponseStatus.Builder responseStatus = ResponseStatus.newBuilder();
      responseStatus.setStatus(FAILED);
      reply.setResponseStatus(responseStatus);
    } finally {
      responseObserver.onNext(reply.build());
      responseObserver.onCompleted();
    }
  }

  /** Get voyages by vessel */
  @Override
  public void getVoyagesByVessel(
      VoyageRequest request, StreamObserver<VoyageListReply> responseObserver) {
    VoyageListReply.Builder builder = VoyageListReply.newBuilder();
    try {
      List<Voyage> entityList =
          this.voyageRepository.findByVesselXIdAndIsActiveOrderByIdDesc(
              request.getVesselId(), true);
      for (Voyage entity : entityList) {
        VoyageDetail.Builder detailbuilder = VoyageDetail.newBuilder();
        detailbuilder.setId(entity.getId());
        detailbuilder.setVoyageNumber(entity.getVoyageNo());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        Optional.ofNullable(entity.getActualEndDate())
            .ifPresent(
                actualEndDate -> detailbuilder.setActualEndDate(formatter.format(actualEndDate)));
        Optional.ofNullable(entity.getActualStartDate())
            .ifPresent(
                actualStartDate ->
                    detailbuilder.setActualStartDate(formatter.format(actualStartDate)));
        Optional.ofNullable(entity.getVoyageStartDate())
            .ifPresent(startDate -> detailbuilder.setStartDate(formatter.format(startDate)));
        Optional.ofNullable(entity.getVoyageEndDate())
            .ifPresent(endDate -> detailbuilder.setEndDate(formatter.format(endDate)));
        detailbuilder.setStatus(
            entity.getVoyageStatus() != null ? entity.getVoyageStatus().getName() : "");
        Optional.ofNullable(entity.getVoyageStatus())
            .ifPresent(status -> detailbuilder.setStatusId(status.getId()));
        // fetch the confirmed loadable study for active voyages
        if (entity.getVoyageStatus() != null
            && (STATUS_ACTIVE.equalsIgnoreCase(entity.getVoyageStatus().getName())
                || STATUS_CLOSE.equalsIgnoreCase(entity.getVoyageStatus().getName()))) {
          Stream<LoadableStudy> loadableStudyStream =
              Optional.ofNullable(entity.getLoadableStudies())
                  .map(Collection::stream)
                  .orElseGet(Stream::empty);
          Optional<LoadableStudy> loadableStudy =
              loadableStudyStream
                  .filter(
                      loadableStudyElement ->
                          (loadableStudyElement.getLoadableStudyStatus() != null
                              && STATUS_CONFIRMED.equalsIgnoreCase(
                                  loadableStudyElement.getLoadableStudyStatus().getName())))
                  .findFirst();

          if (loadableStudy.isPresent()) {
            detailbuilder.setConfirmedLoadableStudyId(loadableStudy.get().getId());
            Long noOfDays = this.getNumberOfDays(loadableStudy.get());
            Optional.ofNullable(noOfDays).ifPresent(item -> detailbuilder.setNoOfDays(item));
          }
        }
        builder.addVoyages(detailbuilder.build());
      }
      builder.setResponseStatus(StatusReply.newBuilder().setStatus(SUCCESS).build());
    } catch (Exception e) {
      log.error("Error in getVoyagesByVessel method ", e);
      builder.setResponseStatus(
          StatusReply.newBuilder()
              .setStatus(FAILED)
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .build());
    } finally {
      responseObserver.onNext(builder.build());
      responseObserver.onCompleted();
    }
  }

  /** Save port rotation info for loadable study */
  @Override
  public void saveLoadableStudyPortRotation(
      PortRotationDetail request, StreamObserver<PortRotationReply> responseObserver) {
    PortRotationReply.Builder replyBuilder = PortRotationReply.newBuilder();
    try {
      Optional<LoadableStudy> loadableStudyOpt =
          this.loadableStudyRepository.findById(request.getLoadableStudyId());
      if (!loadableStudyOpt.isPresent()) {
        throw new GenericServiceException(
            "Loadable study does not exist",
            CommonErrorCodes.E_HTTP_BAD_REQUEST,
            HttpStatusCode.BAD_REQUEST);
      }
      this.checkIfVoyageClosed(loadableStudyOpt.get().getVoyage().getId());
      LoadableStudyPortRotation entity = null;
      if (request.getId() == 0) {
        entity = new LoadableStudyPortRotation();
        entity.setLoadableStudy(loadableStudyOpt.get());
        // Add ports to synoptical table
        buildPortsInfoSynopticalTable(entity, request.getOperationId(), request.getPortId());
      } else {
        Optional<LoadableStudyPortRotation> portRoationOpt =
            this.loadableStudyPortRotationRepository.findById(request.getId());
        if (!portRoationOpt.isPresent()) {
          throw new GenericServiceException(
              "Port rotation does not exist",
              CommonErrorCodes.E_HTTP_BAD_REQUEST,
              HttpStatusCode.BAD_REQUEST);
        }
        entity = portRoationOpt.get();
      }

      this.isPatternGeneratedOrConfirmed(entity.getLoadableStudy());

      entity =
          this.loadableStudyPortRotationRepository.save(
              this.createPortRotationEntity(entity, request));
      loadableStudyOpt.get().setIsPortsComplete(request.getIsPortsComplete());
      this.loadableStudyRepository.save(loadableStudyOpt.get());

      replyBuilder.setPortRotationId(entity.getId());
      replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS).build());
    } catch (GenericServiceException e) {
      log.error("GenericServiceException when saving loadable study - port data", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(e.getCode())
              .setMessage(e.getMessage())
              .setStatus(FAILED)
              .setHttpStatusCode(e.getStatus().value())
              .build());
    } catch (Exception e) {
      log.error("Exception when saving loadable study port data", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage("Exception when saving port data")
              .setStatus(FAILED)
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  @Override
  @Transactional
  public void saveDischargingPorts(
      PortRotationRequest request, StreamObserver<PortRotationReply> responseObserver) {
    PortRotationReply.Builder replyBuilder = PortRotationReply.newBuilder();
    try {
      Optional<LoadableStudy> loadableStudyOpt =
          this.loadableStudyRepository.findById(request.getLoadableStudyId());
      if (!loadableStudyOpt.isPresent()) {
        throw new GenericServiceException(
            "Loadable study does not exist",
            CommonErrorCodes.E_HTTP_BAD_REQUEST,
            HttpStatusCode.BAD_REQUEST);
      }
      this.checkIfVoyageClosed(loadableStudyOpt.get().getVoyage().getId());
      this.isPatternGeneratedOrConfirmed(loadableStudyOpt.get());
      LoadableStudy loadableStudy = loadableStudyOpt.get();
      loadableStudy.setDischargeCargoId(request.getDischargingCargoId());
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
        validateTransitPorts(loadableStudyOpt.get(), portIds);
        GetPortInfoByPortIdsRequest.Builder reqBuilder = GetPortInfoByPortIdsRequest.newBuilder();
        portIds.forEach(
            port -> {
              reqBuilder.addId(port);
            });
        PortReply portReply = portInfoGrpcService.getPortInfoByPortIds(reqBuilder.build());
        if (!SUCCESS.equalsIgnoreCase(portReply.getResponseStatus().getStatus())) {
          throw new GenericServiceException(
              "Error in calling port service",
              CommonErrorCodes.E_GEN_INTERNAL_ERR,
              HttpStatusCode.INTERNAL_SERVER_ERROR);
        }

        if (!CollectionUtils.isEmpty(portIds)
            && !CollectionUtils.isEmpty(portReply.getPortsList())) {
          dischargingPorts =
              this.buildDischargingPorts(portReply, loadableStudy, dischargingPorts, portIds);
          this.loadableStudyPortRotationRepository.saveAll(dischargingPorts);
        }
      }
      replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS).build());
    } catch (GenericServiceException e) {
      log.error("GenericServiceException when saving discharging ports", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(e.getCode())
              .setMessage(e.getMessage())
              .setHttpStatusCode(e.getStatus().value())
              .setStatus(FAILED)
              .build());
    } catch (Exception e) {
      log.error("Exception when saving discharging ports data", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage("Exception when saving discharging ports")
              .setStatus(FAILED)
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
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
      PortReply portReply,
      LoadableStudy loadableStudy,
      List<LoadableStudyPortRotation> dischargingPorts,
      List<Long> portIds) {
    Long maxPortOrder = this.findMaxPortOrderForLoadableStudy(loadableStudy);
    for (Long requestedPortId : portIds) {
      Optional<PortDetail> portOpt =
          portReply.getPortsList().stream()
              .filter(portDetail -> Objects.equals(requestedPortId, portDetail.getId()))
              .findAny();

      if (portOpt.isPresent()) {
        PortDetail port = portOpt.get();
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
        buildPortsInfoSynopticalTable(portRotationEntity, DISCHARGING_OPERATION_ID, port.getId());
        dischargingPorts.add(portRotationEntity);
      }
    }
    return dischargingPorts;
  }

  /**
   * Get max port order for a LS
   *
   * @param loadableStudy
   * @return
   */
  private Long findMaxPortOrderForLoadableStudy(LoadableStudy loadableStudy) {
    Long maxPortOrder = 0L;
    LoadableStudyPortRotation maxPortOrderEntity =
        this.loadableStudyPortRotationRepository
            .findFirstByLoadableStudyAndIsActiveOrderByPortOrderDesc(loadableStudy, true);
    if (maxPortOrderEntity != null) {
      maxPortOrder = maxPortOrderEntity.getPortOrder();
    }
    return maxPortOrder;
  }

  /**
   * Create entity class from request
   *
   * @param entity
   * @param request
   * @return
   */
  private LoadableStudyPortRotation createPortRotationEntity(
      LoadableStudyPortRotation entity, PortRotationDetail request) {
    buildLoadableStudyPortRotationEntity(entity, request);
    return entity;
  }

  /**
   * Builds the port info in synoptical table
   *
   * @param entity
   * @param request
   */
  private void buildPortsInfoSynopticalTable(
      LoadableStudyPortRotation entity, Long requestedOperationId, Long requestedPortId) {
    // build ports information to update synoptical table
    if (requestedOperationId != 0
        && !StringUtils.isEmpty(
            com.cpdss.loadablestudy.domain.CargoOperation.getOperation(requestedOperationId))) {
      List<SynopticalTable> synopticalTableEntityList = new ArrayList<>();
      if (CARGO_OPERATION_ARR_DEP_SYNOPTICAL.contains(requestedOperationId)) {
        buildSynopticalTableRecord(
            requestedPortId, entity, synopticalTableEntityList, SYNOPTICAL_TABLE_OP_TYPE_ARRIVAL);
        buildSynopticalTableRecord(
            requestedPortId, entity, synopticalTableEntityList, SYNOPTICAL_TABLE_OP_TYPE_DEPARTURE);
      }
      if (!CollectionUtils.isEmpty(entity.getSynopticalTable())) {
        entity.getSynopticalTable().addAll(synopticalTableEntityList);
      } else {
        entity.setSynopticalTable(synopticalTableEntityList);
      }
    }
  }

  /**
   * Builds the synoptical table records
   *
   * @param request
   * @param entity
   * @param synopticalTableList
   * @param portStage
   */
  private void buildSynopticalTableRecord(
      Long portId,
      LoadableStudyPortRotation entity,
      List<SynopticalTable> synopticalTableList,
      String portStage) {
    SynopticalTable synopticalTable = new SynopticalTable();
    synopticalTable.setLoadableStudyPortRotation(entity);
    synopticalTable.setLoadableStudyXId(entity.getLoadableStudy().getId());
    synopticalTable.setOperationType(portStage);
    synopticalTable.setPortXid(0 == portId ? null : portId);
    synopticalTable.setIsActive(true);
    synopticalTableList.add(synopticalTable);
  }

  /** Delete specific cargo nomination */
  @Override
  public void deleteCargoNomination(
      CargoNominationRequest request, StreamObserver<CargoNominationReply> responseObserver) {
    CargoNominationReply.Builder cargoNominationReplyBuilder = CargoNominationReply.newBuilder();
    try {
      Optional<CargoNomination> existingCargoNomination =
          this.cargoNominationRepository.findById(request.getCargoNominationId());
      if (!existingCargoNomination.isPresent()) {
        throw new GenericServiceException(
            "Cargo Nomination does not exist",
            CommonErrorCodes.E_HTTP_BAD_REQUEST,
            HttpStatusCode.BAD_REQUEST);
      }
      this.validateDeleteCargoNomination(existingCargoNomination.get());

      this.commingleCargoRepository.deleteCommingleCargoByLodableStudyXId(
          existingCargoNomination.get().getLoadableStudyXId());
      Optional<LoadableStudy> loadableStudyOpt =
          this.loadableStudyRepository.findById(
              existingCargoNomination.get().getLoadableStudyXId());
      if (loadableStudyOpt.isPresent()) {
        LoadableStudy loadableStudy = loadableStudyOpt.get();
        loadableStudy.setDischargeCargoId(null);
        this.loadableStudyRepository.save(loadableStudy);
      }
      this.cargoNominationOperationDetailsRepository.deleteCargoNominationPortDetails(
          request.getCargoNominationId());
      /*
       * delete respective loading ports from port rotation table if ports not
       * associated with any other cargo nomination belonging to the same loadable
       * study
       */
      if (!existingCargoNomination.get().getCargoNominationPortDetails().isEmpty()) {
        List<Long> requestedPortIds =
            existingCargoNomination.get().getCargoNominationPortDetails().stream()
                .map(CargoNominationPortDetails::getPortId)
                .collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(requestedPortIds)) {
          requestedPortIds.forEach(
              requestPortId -> {
                Long otherCargoRefExistCount =
                    this.cargoNominationRepository.getCountCargoNominationWithPortIds(
                        existingCargoNomination.get().getLoadableStudyXId(),
                        existingCargoNomination.get(),
                        requestPortId);
                if (Objects.equals(otherCargoRefExistCount, Long.valueOf("0"))
                    && loadableStudyOpt.isPresent()) {
                  loadableStudyPortRotationRepository.deleteLoadingPortRotationByPort(
                      loadableStudyOpt.get(), requestPortId);
                  synopticalTableRepository.deleteSynopticalPorts(
                      loadableStudyOpt.get().getId(), requestPortId);
                }
              });
        }
      }
      this.cargoNominationRepository.deleteCargoNomination(request.getCargoNominationId());
      cargoNominationReplyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS));
    } catch (GenericServiceException e) {
      log.error("GenericServiceException when deleting cargo nomination", e);
      cargoNominationReplyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(e.getCode())
              .setMessage(e.getMessage())
              .setStatus(FAILED)
              .setHttpStatusCode(e.getStatus().value())
              .build());
    } catch (Exception e) {
      log.error("Error deleting cargo nomination", e);
      cargoNominationReplyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setStatus(FAILED)
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR));
    } finally {
      responseObserver.onNext(cargoNominationReplyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  @Override
  public void deleteLoadableStudy(
      LoadableStudyRequest request, StreamObserver<LoadableStudyReply> responseObserver) {
    LoadableStudyReply.Builder replyBuilder = LoadableStudyReply.newBuilder();
    try {
      Optional<LoadableStudy> entityOpt =
          this.loadableStudyRepository.findById(request.getLoadableStudyId());
      if (!entityOpt.isPresent()) {
        throw new GenericServiceException(
            "Loadable study does not exist",
            CommonErrorCodes.E_HTTP_BAD_REQUEST,
            HttpStatusCode.BAD_REQUEST);
      }
      LoadableStudy entity = entityOpt.get();

      this.checkIfVoyageClosed(entity.getVoyage().getId());

      this.isPatternGeneratedOrConfirmed(entity);

      if (null != entity.getLoadableStudyStatus()
          && LOADABLE_STUDY_STATUS_PLAN_GENERATED_ID.equals(
              entity.getLoadableStudyStatus().getId())) {
        throw new GenericServiceException(
            "Loadable study with status plan generated cannot be deleted",
            CommonErrorCodes.E_HTTP_BAD_REQUEST,
            HttpStatusCode.BAD_REQUEST);
      }
      entity.setActive(false);
      this.loadableStudyRepository.save(entity);
      replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS).build());
    } catch (GenericServiceException e) {
      log.error("GenericServiceException when saving loadable study - port data", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(e.getCode())
              .setMessage(e.getMessage())
              .setStatus(FAILED)
              .setHttpStatusCode(e.getStatus().value())
              .build());
    } catch (Exception e) {
      log.error("Exception when saving loadable study - port data", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage("Exception when saving loadable study - port data")
              .setStatus(FAILED)
              .setHttpStatusCode(Integer.valueOf(CommonErrorCodes.E_GEN_INTERNAL_ERR))
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  private List<Long> getPortRoationPortIds(LoadableStudy loadableStudy) {
    List<Long> portIds =
        this.loadableStudyPortRotationRepository.findByLoadableStudyAndIsActive(
            loadableStudy, true);
    return portIds.stream().distinct().collect(Collectors.toList());
  }

  /**
   * @param request
   * @param responseObserver
   */
  @Override
  public void getPortRotationByLoadableStudyId(
      PortRotationRequest request, StreamObserver<PortRotationReply> responseObserver) {
    log.info("Inside getPortRotation loadable study micro service");
    PortRotationReply.Builder portRotationReplyBuilder = PortRotationReply.newBuilder();
    try {
      Optional<LoadableStudy> loadableStudy =
          this.loadableStudyRepository.findByIdAndIsActive(request.getLoadableStudyId(), true);

      if (!loadableStudy.isPresent()) {
        log.info(INVALID_LOADABLE_STUDY_ID, request.getLoadableStudyId());
        portRotationReplyBuilder.setResponseStatus(
            ResponseStatus.newBuilder()
                .setStatus(FAILED)
                .setMessage(INVALID_LOADABLE_STUDY_ID)
                .setCode(CommonErrorCodes.E_HTTP_BAD_REQUEST));
      } else {
        List<LoadableStudyPortRotation> ports =
            this.loadableStudyPortRotationRepository.findByLoadableStudyAndIsActiveOrderByPortOrder(
                loadableStudy.get(), true);
        if (ports.isEmpty()) {
          log.info(INVALID_LOADABLE_STUDY_ID, request.getLoadableStudyId());
          portRotationReplyBuilder.setResponseStatus(
              ResponseStatus.newBuilder()
                  .setStatus(FAILED)
                  .setMessage(INVALID_LOADABLE_STUDY_ID)
                  .setCode(CommonErrorCodes.E_HTTP_BAD_REQUEST));
        } else {
          ports.forEach(
              port -> {
                PortRotationDetail.Builder builder = PortRotationDetail.newBuilder();
                builder.setPortId(port.getPortXId());
                builder.setId(port.getId());
                portRotationReplyBuilder.addPorts(builder);
              });
          portRotationReplyBuilder
              .setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS).setMessage(SUCCESS))
              .build();
        }
      }
    } catch (Exception e) {
      log.error("Error deleting cargo nomination", e);
      portRotationReplyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setStatus(FAILED)
              .setMessage(FAILED)
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR));
    } finally {
      responseObserver.onNext(portRotationReplyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  /** Delete port rotation by id */
  @Override
  public void deletePortRotation(
      PortRotationRequest request, StreamObserver<PortRotationReply> responseObserver) {
    PortRotationReply.Builder replyBuilder = PortRotationReply.newBuilder();
    try {
      Optional<LoadableStudy> loadableStudyOpt =
          this.loadableStudyRepository.findById(request.getLoadableStudyId());
      if (!loadableStudyOpt.isPresent() || !loadableStudyOpt.get().isActive()) {
        throw new GenericServiceException(
            "Loadable study does not exist",
            CommonErrorCodes.E_HTTP_BAD_REQUEST,
            HttpStatusCode.BAD_REQUEST);
      }
      this.checkIfVoyageClosed(loadableStudyOpt.get().getVoyage().getId());
      this.isPatternGeneratedOrConfirmed(loadableStudyOpt.get());
      LoadableStudy loadableStudy = loadableStudyOpt.get();
      if (null != loadableStudy.getLoadableStudyStatus()
          && LOADABLE_STUDY_STATUS_PLAN_GENERATED_ID.equals(
              loadableStudy.getLoadableStudyStatus().getId())) {
        throw new GenericServiceException(
            "Cannot delete ports for loadable study with status - plan generated",
            CommonErrorCodes.E_HTTP_BAD_REQUEST,
            HttpStatusCode.BAD_REQUEST);
      }
      Optional<LoadableStudyPortRotation> entityOpt =
          this.loadableStudyPortRotationRepository.findById(request.getId());
      if (!entityOpt.isPresent()) {
        throw new GenericServiceException(
            "port rotation does not exist",
            CommonErrorCodes.E_HTTP_BAD_REQUEST,
            HttpStatusCode.BAD_REQUEST);
      }
      LoadableStudyPortRotation entity = entityOpt.get();
      if (null != entity.getOperation()
          && (LOADING_OPERATION_ID.equals(entity.getOperation().getId())
              || DISCHARGING_OPERATION_ID.equals(entity.getOperation().getId()))) {
        throw new GenericServiceException(
            "Cannot delete loading/discharging ports",
            CommonErrorCodes.E_HTTP_BAD_REQUEST,
            HttpStatusCode.BAD_REQUEST);
      }
      entity.setActive(false);
      // delete ports from synoptical table
      if (!CollectionUtils.isEmpty(entity.getSynopticalTable())) {
        entity.getSynopticalTable().forEach(portRecord -> portRecord.setIsActive(false));
      }
      this.loadableStudyPortRotationRepository.save(entity);
      replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS).build());
    } catch (GenericServiceException e) {
      log.error("GenericServiceException when deleting port rotation", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(e.getCode())
              .setMessage(e.getMessage())
              .setStatus(FAILED)
              .setHttpStatusCode(e.getStatus().value())
              .build());
    } catch (Exception e) {
      log.error("Exception when deleting port rotation", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage("Exception when deleting port rotation")
              .setStatus(FAILED)
              .setHttpStatusCode(Integer.valueOf(CommonErrorCodes.E_GEN_INTERNAL_ERR))
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  /** Get on hand quantity */
  @Override
  public void getOnHandQuantity(
      OnHandQuantityRequest request, StreamObserver<OnHandQuantityReply> responseObserver) {
    OnHandQuantityReply.Builder replyBuilder = OnHandQuantityReply.newBuilder();
    try {
      Optional<LoadableStudy> loadableStudyOpt =
          this.loadableStudyRepository.findByIdAndIsActive(request.getLoadableStudyId(), true);
      if (!loadableStudyOpt.isPresent()) {
        throw new GenericServiceException(
            "Loadable study does not exist",
            CommonErrorCodes.E_HTTP_BAD_REQUEST,
            HttpStatusCode.BAD_REQUEST);
      }

      VoyageStatus voyageStatus = this.voyageStatusRepository.getOne(CLOSE_VOYAGE_STATUS);

      LoadableStudyPortRotation portRotation =
          this.loadableStudyPortRotationRepository.findByIdAndIsActive(
              request.getPortRotationId(), true);
      if (null == portRotation) {
        throw new GenericServiceException(
            "Port rotation does not exist",
            CommonErrorCodes.E_HTTP_BAD_REQUEST,
            HttpStatusCode.BAD_REQUEST);
      }

      Voyage previousVoyage =
          this.voyageRepository
              .findFirstByVoyageEndDateLessThanAndVesselXIdAndIsActiveAndVoyageStatusOrderByVoyageEndDateDesc(
                  loadableStudyOpt.get().getVoyage().getVoyageStartDate(),
                  loadableStudyOpt.get().getVoyage().getVesselXId(),
                  true,
                  voyageStatus);

      VesselReply vesselReply = this.getOhqTanks(request);
      List<OnHandQuantity> onHandQuantities =
          this.onHandQuantityRepository.findByLoadableStudyAndPortRotationAndIsActive(
              loadableStudyOpt.get(), portRotation, true);
      Optional<LoadableStudy> confirmedLoadableStudyOpt =
          this.loadableStudyRepository.findByVoyageAndLoadableStudyStatusAndIsActive(
              previousVoyage, CONFIRMED_STATUS_ID, true);

      List<OnHandQuantity> onHandQuantityList = null;
      if (confirmedLoadableStudyOpt.isPresent()) {

        LoadableStudyPortRotation lastDischargingPortPortRotation =
            this.loadableStudyPortRotationRepository
                .findFirstByLoadableStudyAndOperationAndIsActiveOrderByPortOrderDesc(
                    confirmedLoadableStudyOpt.get(),
                    this.cargoOperationRepository.getOne(DISCHARGING_OPERATION_ID),
                    true);

        onHandQuantityList =
            this.onHandQuantityRepository.findByLoadableStudyAndPortRotationAndIsActive(
                confirmedLoadableStudyOpt.get(), lastDischargingPortPortRotation, true);

        if (onHandQuantities.isEmpty() && !onHandQuantityList.isEmpty()) {

          Long portOrder = portRotation.getPortOrder();
          List<OnHandQuantity> OnHandQuantities = new ArrayList<OnHandQuantity>();

          List<LoadableStudyPortRotation> portRotationList =
              this.loadableStudyPortRotationRepository.findByLoadableStudyAndIsActive(
                  loadableStudyOpt.get().getId(), true);
          if (null != portRotationList && !portRotationList.isEmpty()) {
            int index =
                IntStream.range(0, portRotationList.size())
                    .filter(i -> portRotationList.get(i).getId().equals(portRotation.getId()))
                    .findFirst()
                    .orElse(-1);

            if (portOrder.equals(portRotationList.get(0).getPortOrder())) {

              onHandQuantityList.forEach(
                  onHandQuantity -> {
                    entityManager.detach(onHandQuantity);
                    onHandQuantity.setId(null);
                    onHandQuantity.setLoadableStudy(loadableStudyOpt.get());
                    onHandQuantity.setActualArrivalQuantity(null);
                    onHandQuantity.setActualDepartureQuantity(null);
                    onHandQuantity.setArrivalQuantity(onHandQuantity.getDepartureQuantity());
                    onHandQuantity.setPortXId(portRotation.getPortXId());
                    onHandQuantity.setPortRotation(portRotation);
                    OnHandQuantities.add(onHandQuantity);
                  });
            } else {

              LoadableStudyPortRotation previousPortPortRotation = portRotationList.get(index - 1);

              onHandQuantityList =
                  this.onHandQuantityRepository.findByLoadableStudyAndPortRotationAndIsActive(
                      loadableStudyOpt.get(), previousPortPortRotation, true);
              onHandQuantityList.forEach(
                  onHandQuantity -> {
                    entityManager.detach(onHandQuantity);
                    onHandQuantity.setId(null);
                    onHandQuantity.setLoadableStudy(loadableStudyOpt.get());
                    onHandQuantity.setActualArrivalQuantity(null);
                    onHandQuantity.setActualDepartureQuantity(null);
                    onHandQuantity.setArrivalQuantity(onHandQuantity.getDepartureQuantity());
                    onHandQuantity.setPortXId(portRotation.getPortXId());
                    onHandQuantity.setPortRotation(portRotation);
                    OnHandQuantities.add(onHandQuantity);
                  });
            }
            this.onHandQuantityRepository.saveAll(OnHandQuantities);
            onHandQuantities =
                this.onHandQuantityRepository.findByLoadableStudyAndPortRotationAndIsActive(
                    loadableStudyOpt.get(), portRotation, true);
          }
        }
      }

      for (VesselTankDetail tankDetail : vesselReply.getVesselTanksList()) {
        if (!tankDetail.getShowInOhqObq()
            || OHQ_VOID_TANK_CATEGORIES.contains(tankDetail.getTankCategoryId())) {
          continue;
        }
        OnHandQuantityDetail.Builder detailBuilder = OnHandQuantityDetail.newBuilder();
        detailBuilder.setFuelType(tankDetail.getTankCategoryName());
        detailBuilder.setFuelTypeShortName(tankDetail.getTankCategoryShortName());
        detailBuilder.setFuelTypeId(tankDetail.getTankCategoryId());
        detailBuilder.setTankId(tankDetail.getTankId());
        detailBuilder.setTankName(tankDetail.getShortName());
        detailBuilder.setColorCode(tankDetail.getColourCode());
        detailBuilder.setPortRotationId(portRotation.getId());
        detailBuilder.setPortId(portRotation.getPortXId());
        Optional<OnHandQuantity> qtyOpt =
            onHandQuantities.stream()
                .filter(
                    entity ->
                        entity.getFuelTypeXId().equals(tankDetail.getTankCategoryId())
                            && entity.getTankXId().equals(tankDetail.getTankId()))
                .findAny();
        if (qtyOpt.isPresent()) {
          OnHandQuantity qty = qtyOpt.get();
          detailBuilder.setId(qty.getId());
          Optional.ofNullable(qty.getArrivalQuantity())
              .ifPresent(item -> detailBuilder.setArrivalQuantity(valueOf(item)));
          Optional.ofNullable(qty.getActualArrivalQuantity())
              .ifPresent(item -> detailBuilder.setActualArrivalQuantity(valueOf(item)));
          Optional.ofNullable(qty.getArrivalVolume())
              .ifPresent(item -> detailBuilder.setArrivalVolume(valueOf(item)));
          Optional.ofNullable(qty.getDepartureQuantity())
              .ifPresent(item -> detailBuilder.setDepartureQuantity(valueOf(item)));
          Optional.ofNullable(qty.getActualDepartureQuantity())
              .ifPresent(item -> detailBuilder.setActualDepartureQuantity(valueOf(item)));
          Optional.ofNullable(qty.getDepartureVolume())
              .ifPresent(item -> detailBuilder.setDepartureVolume(valueOf(item)));
          Optional.ofNullable(qty.getDensity())
              .ifPresent(item -> detailBuilder.setDensity(valueOf(item)));
          Optional.ofNullable(qty.getPortRotation())
              .ifPresent(item -> detailBuilder.setPortRotationId(item.getId()));
          Optional.ofNullable(qty.getPortRotation())
              .ifPresent(item -> detailBuilder.setPortId(item.getPortXId()));
        }
        replyBuilder.addOnHandQuantity(detailBuilder.build());
      }
      this.createOhqVesselTankLayoutArray(vesselReply, replyBuilder);
      replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS).build());
    } catch (GenericServiceException e) {
      log.error("GenericServiceException when fetching on hand quantities", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(e.getCode())
              .setMessage(e.getMessage())
              .setStatus(FAILED)
              .build());
    } catch (Exception e) {
      log.error("Exception when fetching on hand quantities", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage("Exception when fetching on hand quantities")
              .setStatus(FAILED)
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  /**
   * Get On hand quantity tanks
   *
   * @param request
   * @return
   * @throws NumberFormatException
   * @throws GenericServiceException
   */
  private VesselReply getOhqTanks(OnHandQuantityRequest request) throws GenericServiceException {
    VesselRequest.Builder vesselGrpcRequest = VesselRequest.newBuilder();
    vesselGrpcRequest.setCompanyId(request.getCompanyId());
    vesselGrpcRequest.setVesselId(request.getVesselId());
    vesselGrpcRequest.addAllTankCategories(OHQ_TANK_CATEGORIES);
    VesselReply vesselReply = this.getVesselTanks(vesselGrpcRequest.build());
    if (!SUCCESS.equals(vesselReply.getResponseStatus().getStatus())) {
      throw new GenericServiceException(
          "Failed to fetch vessel particualrs",
          vesselReply.getResponseStatus().getCode(),
          HttpStatusCode.valueOf(Integer.valueOf(vesselReply.getResponseStatus().getCode())));
    }
    return vesselReply;
  }

  /**
   * Group tanks by tank group
   *
   * @param vesselReply
   * @return
   */
  private void createOhqVesselTankLayoutArray(
      VesselReply vesselReply, OnHandQuantityReply.Builder replyBuilder) {
    List<VesselTankDetail> rearTanks = new ArrayList<>();
    List<VesselTankDetail> centerTanks = new ArrayList<>();
    rearTanks.addAll(
        vesselReply.getVesselTanksList().stream()
            .filter(
                tank ->
                    OHQ_REAR_TANK_CATEGORIES.contains(tank.getTankCategoryId())
                        && tank.getShowInOhqObq())
            .collect(Collectors.toList()));
    centerTanks.addAll(
        vesselReply.getVesselTanksList().stream()
            .filter(
                tank ->
                    OHQ_CENTER_TANK_CATEGORIES.contains(tank.getTankCategoryId())
                        && tank.getShowInOhqObq())
            .collect(Collectors.toList()));
    replyBuilder.addAllTanks(this.groupTanks(centerTanks));
    replyBuilder.addAllRearTanks(this.groupTanks(rearTanks));
  }

  /**
   * Group tanks based on tank group
   *
   * @param tankDetailList
   * @return
   */
  private List<TankList> groupTanks(List<VesselTankDetail> tankDetailList) {
    Map<Integer, List<VesselTankDetail>> vesselTankMap = new HashMap<>();
    for (VesselTankDetail tank : tankDetailList) {
      Integer tankGroup = tank.getTankGroup();
      List<VesselTankDetail> list = null;
      if (null == vesselTankMap.get(tankGroup)) {
        list = new ArrayList<>();
      } else {
        list = vesselTankMap.get(tankGroup);
      }
      list.add(tank);
      vesselTankMap.put(tankGroup, list);
    }
    List<TankList> tankList = new ArrayList<>();
    List<TankDetail> tankGroup = null;
    for (Map.Entry<Integer, List<VesselTankDetail>> entry : vesselTankMap.entrySet()) {
      tankGroup = entry.getValue().stream().map(this::buildTankDetail).collect(Collectors.toList());
      Collections.sort(tankGroup, Comparator.comparing(TankDetail::getTankOrder));
      tankList.add(TankList.newBuilder().addAllVesselTank(tankGroup).build());
    }
    return tankList;
  }

  /**
   * create tank detail
   *
   * @param detail
   * @return
   */
  public TankDetail buildTankDetail(VesselTankDetail detail) {
    TankDetail.Builder builder = TankDetail.newBuilder();
    builder.setFrameNumberFrom(detail.getFrameNumberFrom());
    builder.setFrameNumberTo(detail.getFrameNumberTo());
    builder.setShortName(detail.getShortName());
    builder.setTankCategoryId(detail.getTankCategoryId());
    builder.setTankCategoryName(detail.getTankCategoryName());
    builder.setTankId(detail.getTankId());
    builder.setTankName(detail.getTankName());
    builder.setIsSlopTank(detail.getIsSlopTank());
    builder.setDensity(detail.getDensity());
    builder.setFillCapacityCubm(detail.getFillCapacityCubm());
    builder.setHeightFrom(detail.getHeightFrom());
    builder.setHeightTo(detail.getHeightTo());
    builder.setTankOrder(detail.getTankOrder());
    builder.setTankDisplayOrder(detail.getTankDisplayOrder());
    builder.setTankGroup(detail.getTankGroup());
    builder.setFullCapacityCubm(detail.getFullCapacityCubm());
    return builder.build();
  }

  /**
   * Get vessel fuel tanks from vessel micro service
   *
   * @param request
   * @return
   */
  public VesselReply getVesselTanks(VesselRequest request) {
    return this.vesselInfoGrpcService.getVesselTanks(request);
  }

  /** Save on hand quantity */
  @Override
  public void saveOnHandQuantity(
      OnHandQuantityDetail request, StreamObserver<OnHandQuantityReply> responseObserver) {
    OnHandQuantityReply.Builder replyBuilder = OnHandQuantityReply.newBuilder();
    try {

      OnHandQuantity entity = null;
      if (request.getId() != 0) {
        entity = this.onHandQuantityRepository.findByIdAndIsActive(request.getId(), true);
        if (null == entity) {
          throw new GenericServiceException(
              "On hand quantity with given id does not exist",
              CommonErrorCodes.E_HTTP_BAD_REQUEST,
              HttpStatusCode.BAD_REQUEST);
        }

      } else {
        Optional<LoadableStudy> loadableStudyOpt =
            this.loadableStudyRepository.findByIdAndIsActive(request.getLoadableStudyId(), true);
        if (!loadableStudyOpt.isPresent()) {
          throw new GenericServiceException(
              "Loadable study does not exist",
              CommonErrorCodes.E_HTTP_BAD_REQUEST,
              HttpStatusCode.BAD_REQUEST);
        }
        LoadableStudyPortRotation portRotation =
            this.loadableStudyPortRotationRepository.findByIdAndIsActive(
                request.getPortRotationId(), true);
        if (null == portRotation) {
          throw new GenericServiceException(
              "Port rotation does not exist",
              CommonErrorCodes.E_HTTP_BAD_REQUEST,
              HttpStatusCode.BAD_REQUEST);
        }
        entity = new OnHandQuantity();
        entity.setLoadableStudy(loadableStudyOpt.get());
        entity.setPortRotation(portRotation);
        entity.setPortXId(portRotation.getPortXId());
      }
      this.checkIfVoyageClosed(entity.getLoadableStudy().getVoyage().getId());
      this.isPatternGeneratedOrConfirmed(entity.getLoadableStudy());

      entity = this.buildOnHandQuantityEntity(entity, request);

      // save obq level status in port rotation table
      if (null != entity.getPortRotation()) {
        entity
            .getPortRotation()
            .setIsPortRotationOhqComplete(request.getIsPortRotationOhqComplete());
        this.loadableStudyPortRotationRepository.save(entity.getPortRotation());
      }
      // save obq level status in loadable study table
      this.saveOhqLevelStatus(request);

      entity = this.onHandQuantityRepository.save(entity);
      replyBuilder
          .setId(entity.getId())
          .setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS).build());
    } catch (GenericServiceException e) {
      log.error("GenericServiceException when saving on hand quantities", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(e.getCode())
              .setMessage(e.getMessage())
              .setStatus(FAILED)
              .setHttpStatusCode(e.getStatus().value())
              .build());
    } catch (Exception e) {
      log.error("Exception when saving on hand quantities", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage("Exception when saving on hand quantities")
              .setStatus(FAILED)
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  private void saveOhqLevelStatus(OnHandQuantityDetail request) throws GenericServiceException {
    Optional<LoadableStudy> loadableStudyOpt =
        this.loadableStudyRepository.findByIdAndIsActive(request.getLoadableStudyId(), true);
    if (!loadableStudyOpt.isPresent()) {
      throw new GenericServiceException(
          "Loadable study does not exist",
          CommonErrorCodes.E_HTTP_BAD_REQUEST,
          HttpStatusCode.BAD_REQUEST);
    }
    List<LoadableStudyPortRotation> portRotations =
        this.loadableStudyPortRotationRepository.findByLoadableStudyIdAndIsActive(
            loadableStudyOpt.get().getId(), true);

    if (!portRotations.isEmpty()) {
      Boolean status = true;

      for (LoadableStudyPortRotation port : portRotations) {
        Boolean ohqPortRotationStatus = port.getIsPortRotationOhqComplete();
        if (null == ohqPortRotationStatus) {
          ohqPortRotationStatus = false;
        }
        status = status && ohqPortRotationStatus;
      }
      loadableStudyOpt.get().setIsOhqComplete(status);
      this.loadableStudyRepository.save(loadableStudyOpt.get());
    }
  }

  /**
   * Build on hand quantity entity from request
   *
   * @param entity
   * @param request
   * @return
   */
  private OnHandQuantity buildOnHandQuantityEntity(
      OnHandQuantity entity, OnHandQuantityDetail request) {
    entity.setIsActive(true);
    entity.setFuelTypeXId(0 == request.getFuelTypeId() ? null : request.getFuelTypeId());
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
    entity.setDensity(isEmpty(request.getDensity()) ? null : new BigDecimal(request.getDensity()));
    return entity;
  }

  /** get purpose of commingle look up */
  @Override
  public void getPurposeOfCommingle(
      PurposeOfCommingleRequest request, StreamObserver<PurposeOfCommingleReply> responseObserver) {
    PurposeOfCommingleReply.Builder reply = PurposeOfCommingleReply.newBuilder();
    try {
      Iterable<PurposeOfCommingle> purposeList = purposeOfCommingleRepository.findAll();
      purposeList.forEach(
          purposeEntity -> {
            com.cpdss.common.generated.LoadableStudy.PurposeOfCommingle.Builder purpose =
                com.cpdss.common.generated.LoadableStudy.PurposeOfCommingle.newBuilder();

            if (purposeEntity.getId() != null) {
              purpose.setId(purposeEntity.getId());
            }
            if (!StringUtils.isEmpty(purposeEntity.getPurpose())) {
              purpose.setName(purposeEntity.getPurpose());
            }
            reply.addPurposeOfCommingle(purpose);
          });
      ResponseStatus.Builder responseStatus = ResponseStatus.newBuilder();
      responseStatus.setStatus(SUCCESS);
      reply.setResponseStatus(responseStatus);
    } catch (Exception e) {
      log.error("Error in getPurposeOfCommingle method ", e);
      ResponseStatus.Builder responseStatus = ResponseStatus.newBuilder();
      responseStatus.setStatus(FAILED);
      reply.setResponseStatus(responseStatus);
    } finally {
      responseObserver.onNext(reply.build());
      responseObserver.onCompleted();
    }
  }

  /** Get list of patterns for a loadable study */
  @Override
  public void saveLoadablePatterns(
      LoadablePatternAlgoRequest request, StreamObserver<AlgoReply> responseObserver) {
    AlgoReply.Builder builder = AlgoReply.newBuilder();
    try {

      log.info("saveLoadablePatternDetails - loadable study micro service");
      Optional<LoadableStudy> loadableStudyOpt =
          this.loadableStudyRepository.findByIdAndIsActive(request.getLoadableStudyId(), true);
      if (!loadableStudyOpt.isPresent()) {
        throw new GenericServiceException(
            "Loadable study does not exist",
            CommonErrorCodes.E_HTTP_BAD_REQUEST,
            HttpStatusCode.BAD_REQUEST);
      }
      loadableStudyAlgoStatusRepository.updateLoadableStudyAlgoStatus(
          LOADABLE_STUDY_STATUS_PLAN_GENERATED_ID, request.getProcesssId(), true);
      if (request.getLoadablePlanDetailsList().isEmpty()) {
        loadableStudyAlgoStatusRepository.updateLoadableStudyAlgoStatus(
            LOADABLE_STUDY_NO_PLAN_AVAILABLE_ID, request.getProcesssId(), true);
        loadableStudyRepository.updateLoadableStudyStatus(
            LOADABLE_STUDY_NO_PLAN_AVAILABLE_ID, loadableStudyOpt.get().getId());
      } else {

        Long lastLoadingPort =
            getLastPort(
                loadableStudyOpt.get(), this.cargoOperationRepository.getOne(LOADING_OPERATION_ID));
        request
            .getLoadablePlanDetailsList()
            .forEach(
                lpd -> {
                  LoadablePattern loadablePattern =
                      saveloadablePattern(lpd, loadableStudyOpt.get());
                  Optional<LoadablePlanPortWiseDetails> lppwdOptional =
                      lpd.getLoadablePlanPortWiseDetailsList().stream()
                          .filter(lppwd -> lppwd.getPortId() == lastLoadingPort)
                          .findAny();
                  if (lppwdOptional.isPresent()) {
                    saveLoadableQuantity(lppwdOptional.get(), loadablePattern);
                    saveLoadablePlanCommingleCargo(
                        lppwdOptional
                            .get()
                            .getDepartureCondition()
                            .getLoadableQuantityCommingleCargoDetailsList(),
                        loadablePattern);
                    saveLoadablePlanStowageDetails(
                        lppwdOptional
                            .get()
                            .getDepartureCondition()
                            .getLoadablePlanStowageDetailsList(),
                        loadablePattern);
                    saveLoadablePlanBallastDetails(
                        lppwdOptional
                            .get()
                            .getDepartureCondition()
                            .getLoadablePlanBallastDetailsList(),
                        loadablePattern);
                  }
                  saveLoadableQuantityCommingleCargoPortwiseDetails(
                      lpd.getLoadablePlanPortWiseDetailsList(), loadablePattern);
                  saveStabilityParameters(loadablePattern, lpd, lastLoadingPort);
                  saveLoadablePlanStowageDetails(loadablePattern, lpd);
                  saveLoadablePlanBallastDetails(loadablePattern, lpd);
                });
        this.saveLoadicatorInfo(loadableStudyOpt.get(), request.getProcesssId());
        loadableStudyRepository.updateLoadableStudyStatus(
            LOADABLE_STUDY_STATUS_PLAN_GENERATED_ID,
            loadableStudyOpt
                .get()
                .getId()); // ToDo - remove this code once Lodicator is implemented
        loadableStudyAlgoStatusRepository.updateLoadableStudyAlgoStatus(
            LOADABLE_STUDY_STATUS_PLAN_GENERATED_ID,
            request.getProcesssId(),
            true); // ToDo - remove this code once Lodicator is implemented
      }

      builder
          .setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS).setMessage(SUCCESS))
          .build();
    } catch (GenericServiceException e) {
      log.error("GenericServiceException in loadable pattern list", e);
      builder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(e.getCode())
              .setMessage(e.getMessage())
              .setStatus(FAILED)
              .build());
    } catch (Exception e) {
      log.error("Exception in loadable pattern list", e);
      builder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage("Exception in getLoadablePatternList")
              .setStatus(FAILED)
              .build());
    } finally {
      responseObserver.onNext(builder.build());
      responseObserver.onCompleted();
    }
  }

  /**
   * save comminglo cargo portwise information into loadable_plan_commingle_details_portwise table *
   */
  private void saveLoadableQuantityCommingleCargoPortwiseDetails(
      List<LoadablePlanPortWiseDetails> loadablePlanPortWiseDetailsList,
      LoadablePattern loadablePattern) {

    loadablePlanPortWiseDetailsList.forEach(
        it -> {
          saveLodableQtyCommingleCargoPortData(
              it.getPortId(),
              it.getPortRotationId(),
              SYNOPTICAL_TABLE_OP_TYPE_ARRIVAL,
              it.getArrivalCondition().getLoadableQuantityCommingleCargoDetailsList(),
              loadablePattern);

          saveLodableQtyCommingleCargoPortData(
              it.getPortId(),
              it.getPortRotationId(),
              SYNOPTICAL_TABLE_OP_TYPE_DEPARTURE,
              it.getDepartureCondition().getLoadableQuantityCommingleCargoDetailsList(),
              loadablePattern);
        });
  }

  private void saveLodableQtyCommingleCargoPortData(
      long portId,
      long portRotationXid,
      String operationType,
      List<LoadableQuantityCommingleCargoDetails> loadableQuantityCommingleCargoDetailsList,
      LoadablePattern loadablePattern) {

    if (Optional.ofNullable(loadableQuantityCommingleCargoDetailsList).isPresent()) {

      loadableQuantityCommingleCargoDetailsList.forEach(
          it -> {
            LoadablePlanComminglePortwiseDetails loadablePlanComminglePortwiseDetails =
                LoadablePlanComminglePortwiseDetails.builder()
                    .portId(portId)
                    .operationType(operationType)
                    .api(it.getApi())
                    .cargo1Abbreviation(it.getCargo1Abbreviation())
                    .cargo1Mt(it.getCargo1MT())
                    .cargo1Percentage(it.getCargo1Percentage())
                    .cargo2Abbreviation(it.getCargo2Abbreviation())
                    .cargo2Mt(it.getCargo2MT())
                    .cargo2Percentage(it.getCargo2Percentage())
                    .grade(it.getGrade())
                    .isActive(true)
                    .loadablePattern(loadablePattern)
                    .quantity(it.getQuantity())
                    .tankName(it.getTankName())
                    .temperature(it.getTemp())
                    .orderQuantity(it.getOrderedMT())
                    .priority(it.getPriority())
                    .loadingOrder(it.getLoadingOrder())
                    .tankId(it.getTankId())
                    .fillingRatio(it.getFillingRatio())
                    .correctionFactor(it.getCorrectionFactor())
                    .correctedUllage(it.getCorrectedUllage())
                    .rdgUllage(it.getRdgUllage())
                    .portRotationXid(portRotationXid)
                    .build();

            loadablePlanCommingleDetailsPortwiseRepository.save(
                loadablePlanComminglePortwiseDetails);
          });
    }
  }

  /**
   * @param loadablePattern
   * @param lpd void
   * @param lastLoadingPort
   */
  private void saveStabilityParameters(
      LoadablePattern loadablePattern, LoadablePlanDetails lpd, Long lastLoadingPort) {
    log.info("saving stability parameter to DB");
    StabilityParameters stabilityParameter = new StabilityParameters();
    stabilityParameter.setAftDraft(lpd.getStabilityParameters().getAfterDraft());
    stabilityParameter.setBendingMoment(lpd.getStabilityParameters().getBendinMoment());
    stabilityParameter.setFwdDraft(lpd.getStabilityParameters().getForwardDraft());
    stabilityParameter.setHeal(lpd.getStabilityParameters().getHeel());
    stabilityParameter.setLoadablePattern(loadablePattern);
    stabilityParameter.setMeanDraft(lpd.getStabilityParameters().getMeanDraft());
    stabilityParameter.setPortXid(lastLoadingPort);
    stabilityParameter.setShearingForce(lpd.getStabilityParameters().getShearForce());
    stabilityParameter.setTrimValue(lpd.getStabilityParameters().getTrim());
    stabilityParameter.setIsActive(true);
    stabilityParameterRepository.save(stabilityParameter);
  }

  /**
   * @param loadablePattern
   * @param lpd void
   */
  private void saveLoadablePlanBallastDetails(
      LoadablePattern loadablePattern, LoadablePlanDetails lpd) {
    lpd.getLoadablePlanPortWiseDetailsList()
        .forEach(
            lppwd -> {
              LoadableStudyPortRotation loadableStudyPortRotation =
                  this.loadableStudyPortRotationRepository.getOne(lppwd.getPortRotationId());
              lppwd
                  .getArrivalCondition()
                  .getLoadablePlanBallastDetailsList()
                  .forEach(
                      lpbd -> {
                        saveLoadablePlanBallastDetailsOperationWise(
                            SYNOPTICAL_TABLE_OP_TYPE_ARRIVAL,
                            lpbd,
                            lppwd.getPortId(),
                            lppwd.getPortRotationId(),
                            loadablePattern);
                      });
              lppwd
                  .getDepartureCondition()
                  .getLoadablePlanBallastDetailsList()
                  .forEach(
                      lpbd -> {
                        saveLoadablePlanBallastDetailsOperationWise(
                            SYNOPTICAL_TABLE_OP_TYPE_DEPARTURE,
                            lpbd,
                            lppwd.getPortId(),
                            lppwd.getPortRotationId(),
                            loadablePattern);
                      });
            });
  }

  /**
   * @param synopticalTableOpTypeDeparture
   * @param lpbd
   * @param portId
   * @param loadableStudyPortRotation
   * @param loadablePattern void
   */
  private void saveLoadablePlanBallastDetailsOperationWise(
      String synopticalTableOpTypeDeparture,
      com.cpdss.common.generated.LoadableStudy.LoadablePlanBallastDetails lpbd,
      long portId,
      Long portRotationId,
      LoadablePattern loadablePattern) {
    LoadablePlanStowageBallastDetails loadablePlanStowageBallastDetails =
        new LoadablePlanStowageBallastDetails();
    loadablePlanStowageBallastDetails.setLoadablePatternId(loadablePattern.getId());
    loadablePlanStowageBallastDetails.setOperationType(synopticalTableOpTypeDeparture);
    loadablePlanStowageBallastDetails.setPortXId(portId);
    loadablePlanStowageBallastDetails.setPortRotationId(portRotationId);
    loadablePlanStowageBallastDetails.setQuantity(
        !StringUtils.isEmpty(lpbd.getMetricTon()) ? new BigDecimal(lpbd.getMetricTon()) : null);
    loadablePlanStowageBallastDetails.setTankXId(lpbd.getTankId());
    loadablePlanStowageBallastDetails.setIsActive(true);
    loadablePlanStowageBallastDetails.setColorCode(BALLAST_TANK_COLOR_CODE);
    loadablePlanStowageBallastDetails.setSg(lpbd.getSg());
    loadablePlanStowageBallastDetailsRepository.save(loadablePlanStowageBallastDetails);
  }

  /**
   * @param loadablePattern
   * @param lpd void
   */
  private void saveLoadablePlanStowageDetails(
      LoadablePattern loadablePattern, LoadablePlanDetails lpd) {
    lpd.getLoadablePlanPortWiseDetailsList()
        .forEach(
            lppwd -> {
              lppwd
                  .getArrivalCondition()
                  .getLoadablePlanStowageDetailsList()
                  .forEach(
                      lpsd -> {
                        saveLoadablePlanStowageDetailsOperationWise(
                            SYNOPTICAL_TABLE_OP_TYPE_ARRIVAL,
                            lpsd,
                            lppwd.getPortId(),
                            lppwd.getPortRotationId(),
                            loadablePattern);
                      });
              lppwd
                  .getDepartureCondition()
                  .getLoadablePlanStowageDetailsList()
                  .forEach(
                      lpsd -> {
                        saveLoadablePlanStowageDetailsOperationWise(
                            SYNOPTICAL_TABLE_OP_TYPE_DEPARTURE,
                            lpsd,
                            lppwd.getPortId(),
                            lppwd.getPortRotationId(),
                            loadablePattern);
                      });
            });
  }

  /**
   * @param synopticalTableOpTypeArrival
   * @param lpsd
   * @param portId void
   * @param loadablePattern
   */
  private void saveLoadablePlanStowageDetailsOperationWise(
      String synopticalTableOpTypeArrival,
      com.cpdss.common.generated.LoadableStudy.LoadablePlanStowageDetails lpsd,
      long portId,
      Long portRotationId,
      LoadablePattern loadablePattern) {
    com.cpdss.loadablestudy.entity.LoadablePatternCargoDetails loadablePatternCargoDetails =
        new com.cpdss.loadablestudy.entity.LoadablePatternCargoDetails();
    loadablePatternCargoDetails.setIsActive(true);
    loadablePatternCargoDetails.setLoadablePatternId(loadablePattern.getId());
    loadablePatternCargoDetails.setOperationType(synopticalTableOpTypeArrival);
    loadablePatternCargoDetails.setPlannedQuantity(
        !StringUtils.isEmpty(lpsd.getWeight()) ? new BigDecimal(lpsd.getWeight()) : null);
    loadablePatternCargoDetails.setPortId(portId);
    loadablePatternCargoDetails.setPortRotationId(portRotationId);
    loadablePatternCargoDetails.setTankId(lpsd.getTankId());
    loadablePatternCargoDetails.setAbbreviation(lpsd.getCargoAbbreviation());
    loadablePatternCargoDetails.setApi(new BigDecimal(lpsd.getApi()));
    loadablePatternCargoDetails.setTemperature(new BigDecimal(lpsd.getTemperature()));
    loadablePatternCargoDetails.setColorCode(lpsd.getColorCode());
    loadablePatternCargoDetails.setCorrectionFactor(lpsd.getCorrectionFactor());
    loadablePatternCargoDetails.setCorrectedUllage(
        !StringUtils.isEmpty(lpsd.getCorrectedUllage())
            ? new BigDecimal(lpsd.getCorrectedUllage())
            : null);
    loadablePatternCargoDetails.setCargoNominationId(lpsd.getCargoNominationId());
    loadablePatternCargoDetailsRepository.save(loadablePatternCargoDetails);
  }

  /**
   * @param loadablePlanBallastDetailsList
   * @param loadablePattern void
   */
  private void saveLoadablePlanBallastDetails(
      List<com.cpdss.common.generated.LoadableStudy.LoadablePlanBallastDetails>
          loadablePlanBallastDetailsList,
      LoadablePattern loadablePattern) {
    loadablePlanBallastDetailsList.forEach(
        lpbd -> {
          LoadablePlanBallastDetails loadablePlanBallastDetails = new LoadablePlanBallastDetails();
          loadablePlanBallastDetails.setMetricTon(lpbd.getMetricTon());
          loadablePlanBallastDetails.setPercentage(lpbd.getPercentage());
          loadablePlanBallastDetails.setSg(lpbd.getSg());
          loadablePlanBallastDetails.setTankName(lpbd.getTankName());
          loadablePlanBallastDetails.setTankId(lpbd.getTankId());
          loadablePlanBallastDetails.setRdgLevel(lpbd.getRdgLevel());
          loadablePlanBallastDetails.setIsActive(true);
          loadablePlanBallastDetails.setLoadablePattern(loadablePattern);
          loadablePlanBallastDetails.setColorCode(BALLAST_TANK_COLOR_CODE);
          loadablePlanBallastDetailsRepository.save(loadablePlanBallastDetails);
        });
  }

  /**
   * @param loadablePlanStowageDetailsList
   * @param loadablePattern void
   */
  private void saveLoadablePlanStowageDetails(
      List<com.cpdss.common.generated.LoadableStudy.LoadablePlanStowageDetails>
          loadablePlanStowageDetailsList,
      LoadablePattern loadablePattern) {
    loadablePlanStowageDetailsList.forEach(
        lpsd -> {
          LoadablePlanStowageDetails loadablePlanStowageDetails = new LoadablePlanStowageDetails();
          loadablePlanStowageDetails.setApi(lpsd.getApi());
          loadablePlanStowageDetails.setAbbreviation(lpsd.getCargoAbbreviation());
          loadablePlanStowageDetails.setColorCode(lpsd.getColorCode());
          loadablePlanStowageDetails.setFillingPercentage(lpsd.getFillingRatio());
          loadablePlanStowageDetails.setRdgUllage(lpsd.getRdgUllage());
          loadablePlanStowageDetails.setTankId(lpsd.getTankId());
          loadablePlanStowageDetails.setTankname(lpsd.getTankName());
          loadablePlanStowageDetails.setWeight(lpsd.getWeight());
          loadablePlanStowageDetails.setTemperature(lpsd.getTemperature());
          loadablePlanStowageDetails.setIsActive(true);
          loadablePlanStowageDetails.setLoadablePattern(loadablePattern);
          loadablePlanStowageDetails.setCorrectionFactor(lpsd.getCorrectionFactor());
          loadablePlanStowageDetails.setCorrectedUllage(lpsd.getCorrectedUllage());
          loadablePlanStowageDetails.setCargoNominationId(lpsd.getCargoNominationId());
          loadablePlanStowageDetailsRespository.save(loadablePlanStowageDetails);
        });
  }

  /**
   * @param loadableQuantityCommingleCargoDetailsList
   * @param loadablePattern void
   */
  private void saveLoadablePlanCommingleCargo(
      List<LoadableQuantityCommingleCargoDetails> loadableQuantityCommingleCargoDetailsList,
      LoadablePattern loadablePattern) {
    for (int i = 0; i < loadableQuantityCommingleCargoDetailsList.size(); i++) {
      LoadablePlanCommingleDetails loadablePlanCommingleDetails =
          new LoadablePlanCommingleDetails();
      loadablePlanCommingleDetails.setApi(
          loadableQuantityCommingleCargoDetailsList.get(i).getApi());
      loadablePlanCommingleDetails.setCargo1Abbreviation(
          loadableQuantityCommingleCargoDetailsList.get(i).getCargo1Abbreviation());
      loadablePlanCommingleDetails.setCargo1Mt(
          loadableQuantityCommingleCargoDetailsList.get(i).getCargo1MT());
      loadablePlanCommingleDetails.setCargo1Percentage(
          loadableQuantityCommingleCargoDetailsList.get(i).getCargo1Percentage());
      loadablePlanCommingleDetails.setCargo2Abbreviation(
          loadableQuantityCommingleCargoDetailsList.get(i).getCargo2Abbreviation());
      loadablePlanCommingleDetails.setCargo2Mt(
          loadableQuantityCommingleCargoDetailsList.get(i).getCargo2MT());
      loadablePlanCommingleDetails.setCargo2Percentage(
          loadableQuantityCommingleCargoDetailsList.get(i).getCargo2Percentage());
      loadablePlanCommingleDetails.setGrade(COMMINGLE + (i + 1));
      loadablePlanCommingleDetails.setIsActive(true);
      loadablePlanCommingleDetails.setLoadablePattern(loadablePattern);
      loadablePlanCommingleDetails.setQuantity(
          loadableQuantityCommingleCargoDetailsList.get(i).getQuantity());
      loadablePlanCommingleDetails.setTankName(
          loadableQuantityCommingleCargoDetailsList.get(i).getTankName());
      loadablePlanCommingleDetails.setTemperature(
          loadableQuantityCommingleCargoDetailsList.get(i).getTemp());
      loadablePlanCommingleDetails.setOrderQuantity(
          loadableQuantityCommingleCargoDetailsList.get(i).getOrderedMT());
      loadablePlanCommingleDetails.setPriority(
          loadableQuantityCommingleCargoDetailsList.get(i).getPriority());
      loadablePlanCommingleDetails.setLoadingOrder(
          loadableQuantityCommingleCargoDetailsList.get(i).getLoadingOrder());
      loadablePlanCommingleDetails.setTankId(
          loadableQuantityCommingleCargoDetailsList.get(i).getTankId());
      loadablePlanCommingleDetails.setFillingRatio(
          loadableQuantityCommingleCargoDetailsList.get(i).getFillingRatio());
      loadablePlanCommingleDetails.setCorrectionFactor(
          loadableQuantityCommingleCargoDetailsList.get(i).getCorrectionFactor());
      loadablePlanCommingleDetails.setCorrectedUllage(
          loadableQuantityCommingleCargoDetailsList.get(i).getCorrectedUllage());
      loadablePlanCommingleDetails.setRdgUllage(
          loadableQuantityCommingleCargoDetailsList.get(i).getRdgUllage());
      loadablePlanCommingleDetailsRepository.save(loadablePlanCommingleDetails);
    }
  }

  /**
   * @param loadablePlanPortWiseDetails
   * @return Consumer<? super LoadablePlanPortWiseDetails>
   */
  private void saveLoadableQuantity(
      LoadablePlanPortWiseDetails loadablePlanPortWiseDetails, LoadablePattern loadablePattern) {
    loadablePlanPortWiseDetails
        .getDepartureCondition()
        .getLoadableQuantityCargoDetailsList()
        .forEach(
            lqcd -> {
              LoadablePlanQuantity loadablePlanQuantity = new LoadablePlanQuantity();
              loadablePlanQuantity.setDifferencePercentage(lqcd.getDifferencePercentage());
              loadablePlanQuantity.setEstimatedApi(new BigDecimal(lqcd.getEstimatedAPI()));
              loadablePlanQuantity.setEstimatedTemperature(new BigDecimal(lqcd.getEstimatedTemp()));
              loadablePlanQuantity.setCargoXId(lqcd.getCargoId());
              loadablePlanQuantity.setIsActive(true);
              loadablePlanQuantity.setLoadableMt(lqcd.getLoadableMT());
              loadablePlanQuantity.setOrderQuantity(new BigDecimal(lqcd.getOrderedMT()));
              loadablePlanQuantity.setLoadablePattern(loadablePattern);
              loadablePlanQuantity.setCargoAbbreviation(lqcd.getCargoAbbreviation());
              loadablePlanQuantity.setCargoColor(lqcd.getColorCode());
              loadablePlanQuantity.setPriority(lqcd.getPriority());
              loadablePlanQuantity.setLoadingOrder(lqcd.getLoadingOrder());
              loadablePlanQuantity.setMinTolerence(lqcd.getMinTolerence());
              loadablePlanQuantity.setMaxTolerence(lqcd.getMaxTolerence());
              loadablePlanQuantityRepository.save(loadablePlanQuantity);
            });
  }

  /**
   * @param lpd void
   * @param loadableStudy
   */
  private LoadablePattern saveloadablePattern(
      LoadablePlanDetails lpd, LoadableStudy loadableStudy) {
    LoadablePattern loadablePattern = new LoadablePattern();
    loadablePattern.setCaseNumber(lpd.getCaseNumber());
    loadablePattern.setIsActive(true);
    loadablePattern.setLoadableStudy(loadableStudy);
    loadablePattern.setLoadableStudyStatus(LOADABLE_STUDY_STATUS_PLAN_GENERATED_ID);
    loadablePatternRepository.save(loadablePattern);
    return loadablePattern;
  }

  /**
   * @param loadableStudy
   * @param one
   * @return Long
   */
  private Long getLastPort(LoadableStudy loadableStudy, CargoOperation loading) {
    Object[] ob = getLastPortRotationData(loadableStudy, loading, true);
    return (long) ob[0];
  }

  /**
   * @param loadableStudy
   * @param loading
   * @return Long - id
   */
  private Long getLastPortRotationId(LoadableStudy loadableStudy, CargoOperation loading) {
    Object[] ob = getLastPortRotationData(loadableStudy, loading, true);
    return (long) ob[1];
  }

  private Object[] getLastPortRotationData(
      LoadableStudy loadableStudy, CargoOperation loading, boolean status) {
    Object ob = loadableStudyPortRotationRepository.findLastPort(loadableStudy, loading, status);
    Object[] obA = (Object[]) ob;
    return obA;
  }

  /**
   * @param request
   * @param responseObserver
   */
  @Override
  public void saveLoadicatorResults(
      LoadicatorResultsRequest request, StreamObserver<AlgoReply> responseObserver) {
    AlgoReply.Builder replyBuilder = AlgoReply.newBuilder();
    try {
      log.info("saveLoadicatorResults - loadable study micro service");
      Optional<LoadableStudy> loadableStudy =
          this.loadableStudyRepository.findByIdAndIsActive(request.getLoadableStudyId(), true);
      if (!loadableStudy.isPresent()) {
        log.info(INVALID_LOADABLE_STUDY_ID, request.getLoadableStudyId());
        replyBuilder.setResponseStatus(
            ResponseStatus.newBuilder()
                .setStatus(FAILED)
                .setMessage(INVALID_LOADABLE_STUDY_ID)
                .setCode(CommonErrorCodes.E_HTTP_BAD_REQUEST));
      } else {
        updateloadablestudystatus(request);
        saveLoadicatorResults(request);
        replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS).build());
      }
    } catch (Exception e) {
      log.error("Exception in saveLoadicatorResults", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage("Exception in saveLoadicatorResults")
              .setStatus(FAILED)
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  /** @param request void */
  private void updateloadablestudystatus(LoadicatorResultsRequest request) {
    loadableStudyRepository.updateLoadableStudyStatus(
        LOADABLE_STUDY_STATUS_PLAN_GENERATED_ID, request.getLoadableStudyId());
    loadableStudyAlgoStatusRepository.updateLoadableStudyAlgoStatus(
        LOADABLE_STUDY_STATUS_PLAN_GENERATED_ID, request.getProcessId(), true);
  }

  /** @param request void */
  private void saveLoadicatorResults(LoadicatorResultsRequest request) {
    request
        .getLoadicatorPatternDetailsResultsList()
        .forEach(
            lrr -> {
              lrr.getLodicatorResultDetailsList()
                  .forEach(
                      lrdl -> {
                        SynopticalTableLoadicatorData loadicatorData =
                            new SynopticalTableLoadicatorData();
                        loadicatorData.setActive(true);
                        loadicatorData.setBlindSector(
                            !StringUtils.isEmpty(lrdl.getBlindSector())
                                ? new BigDecimal(lrdl.getBlindSector())
                                : null);
                        loadicatorData.setCalculatedDraftAftPlanned(
                            !StringUtils.isEmpty(lrdl.getCalculatedDraftAftPlanned())
                                ? new BigDecimal(lrdl.getCalculatedDraftAftPlanned())
                                : null);
                        loadicatorData.setCalculatedDraftFwdPlanned(
                            !StringUtils.isEmpty(lrdl.getCalculatedDraftFwdPlanned())
                                ? new BigDecimal(lrdl.getCalculatedDraftFwdPlanned())
                                : null);
                        loadicatorData.setCalculatedDraftMidPlanned(
                            !StringUtils.isEmpty(lrdl.getCalculatedDraftMidPlanned())
                                ? new BigDecimal(lrdl.getCalculatedDraftMidPlanned())
                                : null);
                        loadicatorData.setCalculatedTrimPlanned(
                            !StringUtils.isEmpty(lrdl.getCalculatedTrimPlanned())
                                ? new BigDecimal(lrdl.getCalculatedTrimPlanned())
                                : null);
                        loadicatorData.setHog(
                            !StringUtils.isEmpty(lrdl.getHog())
                                ? new BigDecimal(lrdl.getHog())
                                : null);
                        loadicatorData.setList(
                            !StringUtils.isEmpty(lrdl.getList())
                                ? new BigDecimal(lrdl.getList())
                                : null);
                        loadicatorData.setPortId(lrdl.getPortId());
                        loadicatorData.setOperationId(lrdl.getOperationId());
                        loadicatorData.setLoadablePatternId(lrr.getLoadablePatternId());
                        synopticalTableLoadicatorDataRepository.save(loadicatorData);
                      });
            });
  }

  @Override
  public void getLoadablePatternList(
      LoadablePatternRequest request, StreamObserver<LoadablePatternReply> responseObserver) {
    LoadablePatternReply.Builder replyBuilder = LoadablePatternReply.newBuilder();
    try {
      log.info("getLoadablePatternList - loadable study micro service");
      Optional<LoadableStudy> loadableStudyOpt =
          this.loadableStudyRepository.findByIdAndIsActive(request.getLoadableStudyId(), true);
      if (!loadableStudyOpt.isPresent()) {
        throw new GenericServiceException(
            "Loadable study does not exist",
            CommonErrorCodes.E_HTTP_BAD_REQUEST,
            HttpStatusCode.BAD_REQUEST);
      }
      List<LoadablePattern> patterns =
          this.loadablePatternRepository.findByLoadableStudyAndIsActiveOrderByCaseNumberAsc(
              loadableStudyOpt.get(), true);
      if (null != patterns && !patterns.isEmpty()) {
        this.buildPatternDetails(patterns, replyBuilder);
      }
      replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS).build());
    } catch (GenericServiceException e) {
      log.error("GenericServiceException in loadable pattern list", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(e.getCode())
              .setMessage(e.getMessage())
              .setStatus(FAILED)
              .build());
    } catch (Exception e) {
      log.error("Exception in loadable pattern list", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage("Exception in getLoadablePatternList")
              .setStatus(FAILED)
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  /**
   * Build pattern reply
   *
   * @param patterns
   * @param replyBuilder
   */
  private void buildPatternDetails(
      List<LoadablePattern> patterns, LoadablePatternReply.Builder replyBuilder) {
    for (LoadablePattern pattern : patterns) {
      com.cpdss.common.generated.LoadableStudy.LoadablePattern.Builder builder =
          com.cpdss.common.generated.LoadableStudy.LoadablePattern.newBuilder();
      builder.setLoadablePatternId(pattern.getId());
      builder.setLoadableStudyStatusId(pattern.getLoadableStudyStatus());
      Optional.ofNullable(pattern.getCaseNumber()).ifPresent(item -> builder.setCaseNumber(item));
      replyBuilder.addLoadablePattern(builder.build());
    }
  }

  @Override
  public void getLoadablePatternDetails(
      LoadablePatternRequest request, StreamObserver<LoadablePatternReply> responseObserver) {
    log.info("Inside get Loadable Pattern Details in loadable study micro service");
    LoadablePatternReply.Builder builder = LoadablePatternReply.newBuilder();
    try {
      Optional<LoadableStudy> loadableStudy =
          this.loadableStudyRepository.findByIdAndIsActive(request.getLoadableStudyId(), true);
      if (!loadableStudy.isPresent()) {
        log.info(INVALID_LOADABLE_STUDY_ID, request.getLoadableStudyId());
        builder.setResponseStatus(
            ResponseStatus.newBuilder()
                .setStatus(FAILED)
                .setMessage(INVALID_LOADABLE_STUDY_ID)
                .setCode(CommonErrorCodes.E_HTTP_BAD_REQUEST));
      } else {
        com.cpdss.common.generated.LoadableStudy.LoadablePattern.Builder loadablePatternBuilder =
            com.cpdss.common.generated.LoadableStudy.LoadablePattern.newBuilder();
        List<LoadablePattern> loadablePatterns =
            loadablePatternRepository.findByLoadableStudyAndIsActiveOrderByCaseNumberAsc(
                loadableStudy.get(), true);
        loadablePatterns.forEach(
            loadablePattern -> {
              loadablePatternBuilder.setLoadablePatternId(loadablePattern.getId());
              Optional.ofNullable(loadableStudy.get().getName())
                  .ifPresent(builder::setLoadableStudyName);
              DateTimeFormatter dateTimeFormatter =
                  DateTimeFormatter.ofPattern(CREATED_DATE_FORMAT);

              Optional.ofNullable(dateTimeFormatter.format(loadablePattern.getCreatedDate()))
                  .ifPresent(builder::setLoadablePatternCreatedDate);
              Optional.ofNullable(loadablePattern.getLoadableStudyStatus())
                  .ifPresent(loadablePatternBuilder::setLoadableStudyStatusId);

              Optional.ofNullable(loadablePattern.getCaseNumber())
                  .ifPresent(loadablePatternBuilder::setCaseNumber);

              loadablePatternBuilder.setStabilityParameters(
                  buildStabilityParamter(loadablePattern));

              List<LoadablePlanConstraints> loadablePlanConstraints =
                  loadablePlanConstraintsRespository.findByLoadablePatternAndIsActive(
                      loadablePattern, true);
              loadablePatternBuilder.clearConstraints();
              buildLoadablePatternConstraints(loadablePlanConstraints, loadablePatternBuilder);

              loadablePatternBuilder.clearLoadablePatternCargoDetails();
              buildLoadablePatternCargoAndCommingleDetails(loadablePattern, loadablePatternBuilder);
              List<LoadablePlanStowageDetails> loadablePlanStowageDetails =
                  loadablePlanStowageDetailsRespository.findByLoadablePatternAndIsActive(
                      loadablePattern, true);
              com.cpdss.common.generated.LoadableStudy.LoadablePlanDetailsReply.Builder
                  replyBuilder =
                      com.cpdss.common.generated.LoadableStudy.LoadablePlanDetailsReply
                          .newBuilder();
              buildLoadablePlanStowageCargoDetails(loadablePlanStowageDetails, replyBuilder);
              loadablePatternBuilder.addAllLoadablePlanStowageDetails(
                  replyBuilder.getLoadablePlanStowageDetailsList());

              // <--DSS-2016-->
              List<LoadablePlanQuantity> loadablePlanQuantities =
                  loadablePlanQuantityRepository.findByLoadablePatternAndIsActive(
                      loadablePattern, true);
              LoadablePlanBuilder.buildLoadablePlanQuantity(
                  loadablePlanQuantities, loadablePatternBuilder);
              List<LoadablePlanCommingleDetails> loadablePlanCommingleDetails =
                  loadablePlanCommingleDetailsRepository.findByLoadablePatternAndIsActive(
                      loadablePattern, true);
              LoadablePlanBuilder.buildLoadablePlanCommingleDetails(
                  loadablePlanCommingleDetails, loadablePatternBuilder);
              List<LoadablePlanBallastDetails> loadablePlanBallastDetails =
                  loadablePlanBallastDetailsRepository.findByLoadablePatternAndIsActive(
                      loadablePattern, true);
              LoadablePlanBuilder.buildBallastGridDetails(
                  loadablePlanBallastDetails, loadablePatternBuilder);
              // <--DSS-2016!-->

              builder.addLoadablePattern(loadablePatternBuilder);
              loadablePatternBuilder.clearLoadablePlanStowageDetails();
            });

        VesselReply vesselReply = this.getTankListForPattern(loadableStudy.get().getVesselXId());
        VesselReply vesselReply2 =
            this.getTanks(loadableStudy.get().getVesselXId(), CARGO_BALLAST_TANK_CATEGORIES);
        if (!SUCCESS.equals(vesselReply.getResponseStatus().getStatus())) {
          builder.setResponseStatus(ResponseStatus.newBuilder().setStatus(FAILED).build());
        } else {
          builder.addAllTanks(this.groupTanks(vesselReply.getVesselTanksList()));
          builder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS).build());
          buildBallastTankLayout(
              vesselReply2.getVesselTanksList().stream()
                  .filter(
                      tankList -> BALLAST_TANK_CATEGORIES.contains(tankList.getTankCategoryId()))
                  .collect(Collectors.toList()),
              builder);
        }
      }
    } catch (Exception e) {
      log.error("Exception when fetching get Loadable Pattern Details", e);
      builder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage("Exception when fetching on Loadable Pattern Details")
              .setStatus(FAILED)
              .build());
    } finally {
      responseObserver.onNext(builder.build());
      responseObserver.onCompleted();
    }
  }

  /**
   * Ballast Tank category builder
   *
   * @param vesselTankDetails - List<VesselTankDetail>
   * @param replyBuilder - LoadablePatternReply.Builder
   */
  private void buildBallastTankLayout(
      List<VesselTankDetail> vesselTankDetails, LoadablePatternReply.Builder replyBuilder) {

    List<VesselTankDetail> frontBallastTanks = new ArrayList<>();
    List<VesselTankDetail> centerBallestTanks = new ArrayList<>();
    List<VesselTankDetail> rearBallastTanks = new ArrayList<>();
    frontBallastTanks.addAll(
        vesselTankDetails.stream()
            .filter(tank -> BALLAST_FRONT_TANK.equals(tank.getTankPositionCategory()))
            .collect(Collectors.toList()));
    centerBallestTanks.addAll(
        vesselTankDetails.stream()
            .filter(tank -> BALLAST_CENTER_TANK.equals(tank.getTankPositionCategory()))
            .collect(Collectors.toList()));

    rearBallastTanks.addAll(
        vesselTankDetails.stream()
            .filter(tank -> BALLAST_REAR_TANK.equals(tank.getTankPositionCategory()))
            .collect(Collectors.toList()));

    replyBuilder.addAllBallastFrontTanks(this.groupTanks(frontBallastTanks));
    replyBuilder.addAllBallastCenterTanks(this.groupTanks(centerBallestTanks));
    replyBuilder.addAllBallastRearTanks(this.groupTanks(rearBallastTanks));
  }

  /**
   * @param loadablePattern
   * @return StabilityParameter
   */
  private StabilityParameter buildStabilityParamter(LoadablePattern loadablePattern) {
    StabilityParameter.Builder builder = StabilityParameter.newBuilder();
    stabilityParameterRepository
        .findByLoadablePatternAndIsActive(loadablePattern, true)
        .forEach(
            sp -> {
              builder.setAfterDraft(sp.getAftDraft());
              builder.setBendinMoment(sp.getBendingMoment());
              builder.setForwardDraft(sp.getFwdDraft());
              builder.setHeel(sp.getHeal());
              builder.setMeanDraft(sp.getMeanDraft());
              builder.setShearForce(sp.getShearingForce());
              builder.setTrim(sp.getTrimValue());
            });
    return builder.build();
  }

  /**
   * @param loadablePlanConstraints
   * @param loadablePatternBuilder void
   */
  private void buildLoadablePatternConstraints(
      List<LoadablePlanConstraints> loadablePlanConstraints,
      com.cpdss.common.generated.LoadableStudy.LoadablePattern.Builder loadablePatternBuilder) {
    loadablePlanConstraints.forEach(
        lpc -> {
          loadablePatternBuilder.addConstraints(lpc.getConstraintsData());
        });
  }

  /**
   * @param loadablePattern
   * @param loadablePatternBuilder void
   */
  private void buildLoadablePatternCargoAndCommingleDetails(
      LoadablePattern loadablePattern,
      com.cpdss.common.generated.LoadableStudy.LoadablePattern.Builder loadablePatternBuilder) {
    List<LoadablePlanQuantity> loadablePlanQuantities =
        loadablePlanQuantityRepository.findByLoadablePatternAndIsActive(loadablePattern, true);
    loadablePlanQuantities.forEach(
        lpq -> {
          LoadablePatternCargoDetails.Builder loadablePatternCargoDetailsBuilder =
              LoadablePatternCargoDetails.newBuilder();
          Optional.ofNullable(lpq.getMaxTolerence())
              .ifPresent(val -> loadablePatternCargoDetailsBuilder.setMaxTolerence(val));
          Optional.ofNullable(lpq.getMinTolerence())
              .ifPresent(val -> loadablePatternCargoDetailsBuilder.setMinTolerence(val));
          Optional.ofNullable(lpq.getPriority())
              .ifPresent(priority -> loadablePatternCargoDetailsBuilder.setPriority(priority));
          Optional.ofNullable(lpq.getLoadableMt())
              .ifPresent(
                  quantity ->
                      loadablePatternCargoDetailsBuilder.setQuantity(String.valueOf(quantity)));
          Optional.ofNullable(lpq.getOrderQuantity())
              .ifPresent(
                  orderedQuantity ->
                      loadablePatternCargoDetailsBuilder.setOrderedQuantity(
                          String.valueOf(orderedQuantity)));

          Optional.ofNullable(lpq.getCargoAbbreviation())
              .ifPresent(
                  cargoAbbreviation ->
                      loadablePatternCargoDetailsBuilder.setCargoAbbreviation(cargoAbbreviation));
          Optional.ofNullable(lpq.getCargoColor())
              .ifPresent(
                  cargoColor -> loadablePatternCargoDetailsBuilder.setCargoColor(cargoColor));
          Optional.ofNullable(lpq.getLoadingOrder())
              .ifPresent(
                  loadingOrder -> loadablePatternCargoDetailsBuilder.setLoadingOrder(loadingOrder));
          Optional.ofNullable(lpq.getEstimatedApi())
              .ifPresent(api -> loadablePatternCargoDetailsBuilder.setApi(String.valueOf(api)));

          loadablePatternCargoDetailsBuilder.setIsCommingle(false);
          loadablePatternBuilder.addLoadablePatternCargoDetails(loadablePatternCargoDetailsBuilder);
        });

    List<LoadablePlanCommingleDetails> loadablePlanCommingleDetails =
        loadablePlanCommingleDetailsRepository.findByLoadablePatternAndIsActive(
            loadablePattern, true);
    loadablePlanCommingleDetails.forEach(
        lpcd -> {
          LoadablePatternCargoDetails.Builder loadablePatternCargoDetailsBuilder =
              LoadablePatternCargoDetails.newBuilder();
          Optional.ofNullable(lpcd.getPriority())
              .ifPresent(priority -> loadablePatternCargoDetailsBuilder.setPriority(priority));
          Optional.ofNullable(lpcd.getQuantity())
              .ifPresent(
                  quantity ->
                      loadablePatternCargoDetailsBuilder.setQuantity(String.valueOf(quantity)));
          Optional.ofNullable(lpcd.getQuantity())
              .ifPresent(
                  orderedQuantity ->
                      loadablePatternCargoDetailsBuilder.setOrderedQuantity(
                          String.valueOf(orderedQuantity)));

          Optional.ofNullable(lpcd.getGrade())
              .ifPresent(
                  cargoAbbreviation ->
                      loadablePatternCargoDetailsBuilder.setCargoAbbreviation(cargoAbbreviation));

          loadablePatternCargoDetailsBuilder.setIsCommingle(true);
          Optional.ofNullable(lpcd.getId())
              .ifPresent(
                  id ->
                      loadablePatternCargoDetailsBuilder.setLoadablePatternCommingleDetailsId(id));
          Optional.ofNullable(lpcd.getLoadingOrder())
              .ifPresent(
                  loadingOrder -> loadablePatternCargoDetailsBuilder.setLoadingOrder(loadingOrder));
          Optional.ofNullable(lpcd.getApi())
              .ifPresent(api -> loadablePatternCargoDetailsBuilder.setApi(String.valueOf(api)));

          loadablePatternBuilder.addLoadablePatternCargoDetails(loadablePatternCargoDetailsBuilder);

          com.cpdss.common.generated.LoadableStudy.LoadablePlanStowageDetails.Builder builder =
              com.cpdss.common.generated.LoadableStudy.LoadablePlanStowageDetails.newBuilder();
          Optional.ofNullable(lpcd.getId()).ifPresent(builder::setId);
          Optional.ofNullable(lpcd.getGrade()).ifPresent(builder::setCargoAbbreviation);
          Optional.ofNullable(lpcd.getApi()).ifPresent(builder::setApi);
          Optional.ofNullable(lpcd.getCorrectedUllage()).ifPresent(builder::setCorrectedUllage);
          Optional.ofNullable(lpcd.getCorrectionFactor()).ifPresent(builder::setCorrectionFactor);
          Optional.ofNullable(lpcd.getFillingRatio()).ifPresent(builder::setFillingRatio);

          Optional.ofNullable(lpcd.getRdgUllage()).ifPresent(builder::setRdgUllage);
          Optional.ofNullable(lpcd.getTankName()).ifPresent(builder::setTankName);
          Optional.ofNullable(lpcd.getTankId()).ifPresent(builder::setTankId);
          Optional.ofNullable(lpcd.getTemperature()).ifPresent(builder::setTemperature);
          Optional.ofNullable(lpcd.getQuantity()).ifPresent(builder::setWeight);
          builder.setIsCommingle(true);
          loadablePatternBuilder.addLoadablePlanStowageDetails(builder);
        });
  }

  /**
   * @param vesselXId
   * @return VesselReply
   */
  private VesselReply getTankListForPattern(Long vesselId) {
    VesselRequest.Builder vesselGrpcRequest = VesselRequest.newBuilder();
    vesselGrpcRequest.setVesselId(vesselId);
    vesselGrpcRequest.addAllTankCategories(CARGO_TANK_CATEGORIES);
    VesselReply vesselReply = this.getVesselTanks(vesselGrpcRequest.build());
    return vesselReply;
  }

  /** Get commingle cargo for a loadable study */
  @Override
  public void getCommingleCargo(
      CommingleCargoRequest request, StreamObserver<CommingleCargoReply> responseObserver) {
    com.cpdss.common.generated.LoadableStudy.CommingleCargoReply.Builder replyBuilder =
        CommingleCargoReply.newBuilder();
    try {
      Optional<LoadableStudy> loadableStudyOpt =
          this.loadableStudyRepository.findByIdAndIsActive(request.getLoadableStudyId(), true);
      if (!loadableStudyOpt.isPresent()) {
        throw new GenericServiceException(
            "Loadable study does not exist", CommonErrorCodes.E_HTTP_BAD_REQUEST, null);
      }
      List<com.cpdss.loadablestudy.entity.CommingleCargo> commingleCargoList =
          this.commingleCargoRepository.findByLoadableStudyXIdAndIsActive(
              request.getLoadableStudyId(), true);
      // get preferred tanks
      VesselRequest.Builder vesselGrpcRequest = VesselRequest.newBuilder();
      vesselGrpcRequest.setVesselId(request.getVesselId());
      vesselGrpcRequest.addAllTankCategories(CARGO_TANK_CATEGORIES);
      VesselReply vesselReply = this.getVesselTanks(vesselGrpcRequest.build());
      if (!SUCCESS.equals(vesselReply.getResponseStatus().getStatus())) {
        throw new GenericServiceException(
            "Failed to fetch vessel particualrs",
            vesselReply.getResponseStatus().getCode(),
            HttpStatusCode.valueOf(Integer.valueOf(vesselReply.getResponseStatus().getCode())));
      }
      buildCommingleCargoReply(commingleCargoList, replyBuilder, vesselReply);
      replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS));
    } catch (GenericServiceException e) {
      log.error("GenericServiceException when fetching loadable study - getCommingleCargo", e);
      replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(FAILED));
    } catch (Exception e) {
      log.error("Exception when fetching loadable study - getCommingleCargo", e);
      replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(FAILED));
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  /**
   * build commingleCargo reply with commingle values from db
   *
   * @param commingleCargoList
   * @param replyBuilder
   */
  private void buildCommingleCargoReply(
      List<com.cpdss.loadablestudy.entity.CommingleCargo> commingleCargoList,
      CommingleCargoReply.Builder replyBuilder,
      VesselReply vesselReply) {
    if (!CollectionUtils.isEmpty(commingleCargoList)) {
      commingleCargoList.forEach(
          commingleCargo -> {
            CommingleCargo.Builder builder = CommingleCargo.newBuilder();
            Optional.ofNullable(commingleCargo.getId()).ifPresent(builder::setId);
            Optional.ofNullable(commingleCargo.getPurposeXid()).ifPresent(builder::setPurposeId);
            Optional.ofNullable(commingleCargo.getIsSlopOnly()).ifPresent(builder::setSlopOnly);
            // Convert comma separated tank list to arrays
            if (commingleCargo.getTankIds() != null && !commingleCargo.getTankIds().isEmpty()) {
              List<Long> tankIdList =
                  Stream.of(commingleCargo.getTankIds().split(","))
                      .map(String::trim)
                      .map(Long::parseLong)
                      .collect(Collectors.toList());
              builder.addAllPreferredTanks(tankIdList);
            }
            Optional.ofNullable(commingleCargo.getCargo1Xid()).ifPresent(builder::setCargo1Id);
            Optional.ofNullable(commingleCargo.getCargo1Pct())
                .ifPresent(cargo1Pct -> builder.setCargo1Pct(String.valueOf(cargo1Pct)));
            Optional.ofNullable(commingleCargo.getCargo2Xid()).ifPresent(builder::setCargo2Id);
            Optional.ofNullable(commingleCargo.getCargo2Pct())
                .ifPresent(cargo2Pct -> builder.setCargo2Pct(String.valueOf(cargo2Pct)));
            Optional.ofNullable(commingleCargo.getQuantity())
                .ifPresent(quantity -> builder.setQuantity(String.valueOf(quantity)));
            Optional.ofNullable(commingleCargo.getCargoNomination1Id())
                .ifPresent(builder::setCargoNomination1Id);
            Optional.ofNullable(commingleCargo.getCargoNomination2Id())
                .ifPresent(builder::setCargoNomination2Id);
            replyBuilder.addCommingleCargo(builder);
          });
    }
    // build preferred tanks
    replyBuilder.addAllTanks(groupTanks(vesselReply.getVesselTanksList()));
  }

  /** Save commingle cargo for the specific loadable study */
  @Override
  public void saveCommingleCargo(
      CommingleCargoRequest request, StreamObserver<CommingleCargoReply> responseObserver) {
    com.cpdss.common.generated.LoadableStudy.CommingleCargoReply.Builder replyBuilder =
        CommingleCargoReply.newBuilder();
    try {
      Optional<LoadableStudy> loadableStudyOpt =
          this.loadableStudyRepository.findByIdAndIsActive(request.getLoadableStudyId(), true);
      if (!loadableStudyOpt.isPresent()) {
        throw new GenericServiceException(
            "Loadable study does not exist", CommonErrorCodes.E_HTTP_BAD_REQUEST, null);
      }
      this.checkIfVoyageClosed(loadableStudyOpt.get().getVoyage().getId());
      this.isPatternGeneratedOrConfirmed(loadableStudyOpt.get());

      if (!CollectionUtils.isEmpty(request.getCommingleCargoList())) {
        // for existing commingle cargo find missing ids in request and delete them
        deleteCommingleCargo(request);
        Long loadableStudyId = request.getLoadableStudyId();
        List<com.cpdss.loadablestudy.entity.CommingleCargo> commingleEntities = new ArrayList<>();
        // for id = 0 save as new commingle cargo
        request
            .getCommingleCargoList()
            .forEach(
                commingleCargo -> {
                  try {
                    com.cpdss.loadablestudy.entity.CommingleCargo commingleCargoEntity = null;
                    if (commingleCargo != null && commingleCargo.getId() != 0) {
                      Optional<com.cpdss.loadablestudy.entity.CommingleCargo>
                          existingCommingleCargo =
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
                          buildCommingleCargo(
                              commingleCargoEntity, commingleCargo, loadableStudyId);
                    } else if (commingleCargo != null && commingleCargo.getId() == 0) {
                      commingleCargoEntity = new com.cpdss.loadablestudy.entity.CommingleCargo();
                      commingleCargoEntity =
                          buildCommingleCargo(
                              commingleCargoEntity, commingleCargo, loadableStudyId);
                    }

                    commingleEntities.add(commingleCargoEntity);
                  } catch (Exception e) {
                    log.error("Exception in creating entities for save commingle cargo", e);
                    throw new RuntimeException(e);
                  }
                });
        // save all entities
        this.commingleCargoRepository.saveAll(commingleEntities);
      }
      replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS));
    } catch (GenericServiceException e) {
      log.error("GenericServiceException when saving CommingleCargo", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(e.getCode())
              .setMessage(e.getMessage())
              .setStatus(FAILED)
              .setHttpStatusCode(e.getStatus().value()));
    } catch (Exception e) {
      log.error("Exception when saving CommingleCargo", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage("Exception when saving CommingleCargo")
              .setStatus(FAILED));
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  /**
   * build entity to save in commingle cargo
   *
   * @param commingleCargoEntity
   * @param commingleCargoRequestRecord
   * @return
   */
  private com.cpdss.loadablestudy.entity.CommingleCargo buildCommingleCargo(
      com.cpdss.loadablestudy.entity.CommingleCargo commingleCargoEntity,
      CommingleCargo requestRecord,
      Long loadableStudyId) {
    List<Long> cargoNominationIds = new ArrayList<>();
    cargoNominationIds.add(requestRecord.getCargoNomination1Id());
    cargoNominationIds.add(requestRecord.getCargoNomination2Id());
    // fetch the max priority for the cargoNomination ids and set as priority for
    // commingle
    Long maxPriority =
        cargoNominationRepository.getMaxPriorityCargoNominationIn(cargoNominationIds);
    commingleCargoEntity.setPriority(maxPriority != null ? maxPriority.intValue() : null);
    commingleCargoEntity.setCargoNomination1Id(requestRecord.getCargoNomination1Id());
    commingleCargoEntity.setCargoNomination2Id(requestRecord.getCargoNomination2Id());
    commingleCargoEntity.setLoadableStudyXId(loadableStudyId);
    commingleCargoEntity.setPurposeXid(requestRecord.getPurposeId());
    commingleCargoEntity.setTankIds(
        StringUtils.collectionToCommaDelimitedString(requestRecord.getPreferredTanksList()));
    commingleCargoEntity.setCargo1Xid(requestRecord.getCargo1Id());
    commingleCargoEntity.setCargo1Pct(
        !StringUtils.isEmpty(requestRecord.getCargo1Pct())
            ? new BigDecimal(requestRecord.getCargo1Pct())
            : null);
    commingleCargoEntity.setCargo2Xid(requestRecord.getCargo2Id());
    commingleCargoEntity.setCargo2Pct(
        !StringUtils.isEmpty(requestRecord.getCargo2Pct())
            ? new BigDecimal(requestRecord.getCargo2Pct())
            : null);
    commingleCargoEntity.setQuantity(
        !StringUtils.isEmpty(requestRecord.getQuantity())
            ? new BigDecimal(requestRecord.getQuantity())
            : null);
    commingleCargoEntity.setIsActive(true);
    commingleCargoEntity.setIsSlopOnly(requestRecord.getSlopOnly());
    return commingleCargoEntity;
  }

  /**
   * delete commingle cargo not available in the save request
   *
   * @param request
   */
  private void deleteCommingleCargo(CommingleCargoRequest request) {
    List<com.cpdss.loadablestudy.entity.CommingleCargo> commingleCargoEntityList =
        this.commingleCargoRepository.findByLoadableStudyXIdAndIsActive(
            request.getLoadableStudyId(), true);
    List<Long> requestedCommingleCargoIds = null;
    List<Long> existingCommingleCargoIds = null;
    if (!request.getCommingleCargoList().isEmpty()) {
      requestedCommingleCargoIds =
          request.getCommingleCargoList().stream()
              .map(CommingleCargo::getId)
              .collect(Collectors.toList());
    }
    if (!commingleCargoEntityList.isEmpty()) {
      existingCommingleCargoIds =
          commingleCargoEntityList.stream()
              .map(com.cpdss.loadablestudy.entity.CommingleCargo::getId)
              .collect(Collectors.toList());
    }
    /**
     * find commingle ids available for the loadable study that are not available in save request so
     * that they can be deleted
     */
    if (!CollectionUtils.isEmpty(requestedCommingleCargoIds)
        && !CollectionUtils.isEmpty(existingCommingleCargoIds)) {
      existingCommingleCargoIds.removeAll(requestedCommingleCargoIds);
      commingleCargoRepository.deleteCommingleCargo(existingCommingleCargoIds);
    }
  }

  @Override
  public void updateUllage(
      UpdateUllageRequest request, StreamObserver<UpdateUllageReply> responseObserver) {
    log.info("Inside get updateUllage in loadable study micro service");
    UpdateUllageReply.Builder replyBuilder = UpdateUllageReply.newBuilder();
    try {
      Optional<LoadablePattern> loadablePatternOpt =
          this.loadablePatternRepository.findByIdAndIsActive(request.getLoadablePatternId(), true);
      if (!loadablePatternOpt.isPresent()) {
        throw new GenericServiceException(
            INVALID_LOADABLE_PATTERN_ID,
            CommonErrorCodes.E_HTTP_BAD_REQUEST,
            HttpStatusCode.BAD_REQUEST);
      }
      UllageUpdateResponse algoResponse =
          this.callAlgoUllageUpdateApi(this.prepareUllageUpdateRequest(request));
      this.saveUllageUpdateResponse(algoResponse, request);
      replyBuilder.setLoadablePlanStowageDetails(
          this.buildUpdateUllageReply(algoResponse, request));
      replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS).build());

    } catch (GenericServiceException e) {
      log.error("GenericServiceException in update ullage", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(e.getCode())
              .setMessage(e.getMessage())
              .setStatus(FAILED)
              .build());
    } catch (Exception e) {
      log.error("Exception in update ullage", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage("Exception while recalculating volume")
              .setStatus(FAILED)
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  /**
   * Build upadate ullage reply
   *
   * @param algoResponse
   * @param request
   * @return
   */
  private com.cpdss.common.generated.LoadableStudy.LoadablePlanStowageDetails
      buildUpdateUllageReply(UllageUpdateResponse algoResponse, UpdateUllageRequest request) {
    com.cpdss.common.generated.LoadableStudy.LoadablePlanStowageDetails.Builder builder =
        com.cpdss.common.generated.LoadableStudy.LoadablePlanStowageDetails.newBuilder();
    Optional.ofNullable(algoResponse.getCorrectedUllage()).ifPresent(builder::setCorrectedUllage);
    Optional.ofNullable(algoResponse.getCorrectionFactor()).ifPresent(builder::setCorrectionFactor);
    Optional.ofNullable(algoResponse.getFillingRatio()).ifPresent(builder::setFillingRatio);
    Optional.ofNullable(algoResponse.getQuantityMt()).ifPresent(builder::setWeight);
    Optional.ofNullable(request.getLoadablePlanStowageDetails().getIsBallast())
        .ifPresent(builder::setIsBallast);
    return builder.build();
  }

  /**
   * Save corrected ullage to the temp table
   *
   * @param algoResponse
   */
  private void saveUllageUpdateResponse(
      UllageUpdateResponse algoResponse, UpdateUllageRequest request) {
    LoadablePlanStowageDetails stowageDetails =
        this.loadablePlanStowageDetailsRespository.getOne(algoResponse.getId());
    LoadablePlanStowageDetailsTemp stowageTemp =
        this.stowageDetailsTempRepository.findByLoadablePlanStowageDetailsAndIsActive(
            stowageDetails, true);
    if (null == stowageTemp) {
      stowageTemp = new LoadablePlanStowageDetailsTemp();
      stowageTemp.setLoadablePlanStowageDetails(stowageDetails);
      stowageTemp.setIsActive(true);
    }
    stowageTemp.setCorrectedUllage(
        isEmpty(algoResponse.getCorrectedUllage())
            ? null
            : new BigDecimal(algoResponse.getCorrectedUllage()));
    stowageTemp.setCorrectionFactor(
        isEmpty(algoResponse.getCorrectionFactor())
            ? null
            : new BigDecimal(algoResponse.getCorrectionFactor()));
    stowageTemp.setFillingRatio(
        isEmpty(algoResponse.getFillingRatio())
            ? null
            : new BigDecimal(algoResponse.getFillingRatio()));
    stowageTemp.setQuantity(
        isEmpty(algoResponse.getQuantityMt())
            ? null
            : new BigDecimal(algoResponse.getQuantityMt()));
    stowageTemp.setIsBallast(request.getLoadablePlanStowageDetails().getIsBallast());
    this.stowageDetailsTempRepository.save(stowageTemp);
  }

  /**
   * Call algo - ullage update api and validate the resonse
   *
   * @param algoRequest
   * @return
   * @throws GenericServiceException
   */
  private UllageUpdateResponse callAlgoUllageUpdateApi(UllageUpdateRequest algoRequest)
      throws GenericServiceException {
    ResponseEntity<UllageUpdateResponse> responseEntity =
        this.restTemplate.postForEntity(
            this.algoUpdateUllageUrl, algoRequest, UllageUpdateResponse.class);
    if (HttpStatusCode.OK.value() != responseEntity.getStatusCodeValue()) {
      throw new GenericServiceException(
          "Error calling algo: invalid status received",
          CommonErrorCodes.E_GEN_INTERNAL_ERR,
          HttpStatusCode.INTERNAL_SERVER_ERROR);
    }
    return responseEntity.getBody();
  }

  /**
   * Prepare ullage upate request for algo
   *
   * @param request
   * @return
   */
  private UllageUpdateRequest prepareUllageUpdateRequest(UpdateUllageRequest request) {
    UllageUpdateRequest algoRequest = new UllageUpdateRequest();
    algoRequest.setCorrectedUllage(request.getLoadablePlanStowageDetails().getCorrectedUllage());
    algoRequest.setId(request.getLoadablePlanStowageDetails().getId());
    algoRequest.setTankId(request.getLoadablePlanStowageDetails().getTankId());
    return algoRequest;
  }

  @Override
  public void validateLoadablePlan(
      LoadablePlanDetailsRequest request, StreamObserver<AlgoReply> responseObserver) {
    log.info("Inside get validateLoadablePlan in loadable study micro service");
    AlgoReply.Builder replyBuilder = AlgoReply.newBuilder();
    try {
      Optional<LoadablePattern> loadablePatternOpt =
          this.loadablePatternRepository.findByIdAndIsActive(request.getLoadablePatternId(), true);
      if (!loadablePatternOpt.isPresent()) {
        log.info(INVALID_LOADABLE_PATTERN_ID, request.getLoadablePatternId());
        replyBuilder.setResponseStatus(
            ResponseStatus.newBuilder()
                .setStatus(FAILED)
                .setMessage(INVALID_LOADABLE_PATTERN_ID)
                .setCode(CommonErrorCodes.E_HTTP_BAD_REQUEST));

      } else {
        LoadabalePatternValidateRequest loadabalePatternValidateRequest =
            new LoadabalePatternValidateRequest();

        ModelMapper modelMapper = new ModelMapper();
        com.cpdss.loadablestudy.domain.LoadableStudy loadableStudy =
            new com.cpdss.loadablestudy.domain.LoadableStudy();

        buildLoadableStudy(
            loadablePatternOpt.get().getLoadableStudy().getId(),
            loadablePatternOpt.get().getLoadableStudy(),
            loadableStudy,
            modelMapper);

        buildLoadablePlanPortWiseDetails(loadablePatternOpt.get(), loadabalePatternValidateRequest);

        loadabalePatternValidateRequest.setLoadableStudy(loadableStudy);

        loadabalePatternValidateRequest.setBallastEdited(
            stowageDetailsTempRepository.isBallastEdited(request.getLoadablePatternId(), true));
        loadabalePatternValidateRequest.setLoadablePatternId(request.getLoadablePatternId());
        loadabalePatternValidateRequest.setCaseNumber(loadablePatternOpt.get().getCaseNumber());

        ObjectMapper objectMapper = new ObjectMapper();
        this.saveJsonToDatabase(
            request.getLoadablePatternId(),
            LOADABLE_PATTERN_EDIT_REQUEST,
            objectMapper.writeValueAsString(loadabalePatternValidateRequest));
        objectMapper.writeValue(
            new File("json/loadablePattern_request_" + request.getLoadablePatternId() + ".json"),
            loadabalePatternValidateRequest);

        AlgoResponse algoResponse =
            restTemplate.postForObject(
                loadableStudyUrl, loadabalePatternValidateRequest, AlgoResponse.class);

        updateProcessIdForLoadablePattern(
            algoResponse.getProcessId(),
            loadablePatternOpt.get(),
            LOADABLE_PATTERN_VALIDATION_STARTED_ID);

        replyBuilder =
            AlgoReply.newBuilder()
                .setProcesssId(algoResponse.getProcessId())
                .setResponseStatus(
                    ResponseStatus.newBuilder().setMessage(SUCCESS).setStatus(SUCCESS).build());
      }

    } catch (Exception e) {
      log.error("Exception while validateLoadablePlan", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage("Exception while validate Loadable Plan")
              .setStatus(FAILED)
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  /**
   * @param loadablePattern
   * @param loadabalePatternValidateRequest void
   */
  private void buildLoadablePlanPortWiseDetails(
      LoadablePattern loadablePattern,
      LoadabalePatternValidateRequest loadabalePatternValidateRequest) {
    List<LoadableStudyPortRotation> entityList =
        this.loadableStudyPortRotationRepository
            .findByLoadableStudyAndIsActiveOrderByOperationAndPortOrder(
                loadablePattern.getLoadableStudy(), true);
    Long lastLoadingRotationId =
        getLastPortRotationId(
            loadablePattern.getLoadableStudy(),
            this.cargoOperationRepository.getOne(LOADING_OPERATION_ID));

    Long lastLoadingPortId =
        getLastPort(
            loadablePattern.getLoadableStudy(),
            this.cargoOperationRepository.getOne(LOADING_OPERATION_ID));

    GetPortInfoByPortIdsRequest.Builder reqBuilder = GetPortInfoByPortIdsRequest.newBuilder();
    entityList.stream()
        .map(LoadableStudyPortRotation::getPortXId)
        .collect(Collectors.toList())
        .forEach(
            port -> {
              reqBuilder.addId(port);
            });
    PortReply portReply = portInfoGrpcService.getPortInfoByPortIds(reqBuilder.build());

    List<com.cpdss.loadablestudy.domain.LoadablePlanPortWiseDetails> loadablePlanPortWiseDetails =
        new ArrayList<com.cpdss.loadablestudy.domain.LoadablePlanPortWiseDetails>();
    entityList.stream()
        .filter(portRotation -> !portRotation.getId().equals(lastLoadingRotationId))
        .collect(Collectors.toList())
        .forEach(
            portRotate -> {
              com.cpdss.loadablestudy.domain.LoadablePlanPortWiseDetails portWiseDetails =
                  new com.cpdss.loadablestudy.domain.LoadablePlanPortWiseDetails();
              portWiseDetails.setPortId(portRotate.getPortXId());
              portWiseDetails.setPortRotationId(portRotate.getId());
              portWiseDetails.setPortCode(
                  portReply.getPortsList().stream()
                      .filter(
                          portDetail -> Objects.equals(portRotate.getPortXId(), portDetail.getId()))
                      .findAny()
                      .get()
                      .getCode());
              LoadabalePatternDetails arrivalCondition = new LoadabalePatternDetails();
              LoadabalePatternDetails departureCondition = new LoadabalePatternDetails();

              arrivalCondition.setLoadablePlanStowageDetails(
                  addLoadablePatternsStowageDetails(
                      loadablePatternCargoDetailsRepository
                          .findByLoadablePatternIdAndPortRotationIdAndOperationTypeAndIsActive(
                              loadablePattern.getId(),
                              portRotate.getId(),
                              SYNOPTICAL_TABLE_OP_TYPE_ARRIVAL,
                              true),
                      false,
                      loadablePattern.getId()));
              departureCondition.setLoadablePlanStowageDetails(
                  addLoadablePatternsStowageDetails(
                      loadablePatternCargoDetailsRepository
                          .findByLoadablePatternIdAndPortRotationIdAndOperationTypeAndIsActive(
                              loadablePattern.getId(),
                              portRotate.getId(),
                              SYNOPTICAL_TABLE_OP_TYPE_DEPARTURE,
                              true),
                      false,
                      loadablePattern.getId()));
              arrivalCondition.setLoadablePlanBallastDetails(
                  addLoadablePlanBallastDetails(
                      loadablePlanStowageBallastDetailsRepository
                          .findByLoadablePatternIdAndPortRotationIdAndOperationTypeAndIsActive(
                              loadablePattern.getId(),
                              portRotate.getId(),
                              SYNOPTICAL_TABLE_OP_TYPE_ARRIVAL,
                              true),
                      false,
                      loadablePattern.getId()));
              departureCondition.setLoadablePlanBallastDetails(
                  addLoadablePlanBallastDetails(
                      loadablePlanStowageBallastDetailsRepository
                          .findByLoadablePatternIdAndPortRotationIdAndOperationTypeAndIsActive(
                              loadablePattern.getId(),
                              portRotate.getId(),
                              SYNOPTICAL_TABLE_OP_TYPE_DEPARTURE,
                              true),
                      false,
                      loadablePattern.getId()));

              portWiseDetails.setArrivalCondition(arrivalCondition);
              portWiseDetails.setDepartureCondition(departureCondition);
              loadablePlanPortWiseDetails.add(portWiseDetails);
            });

    com.cpdss.loadablestudy.domain.LoadablePlanPortWiseDetails portWiseDetails =
        new com.cpdss.loadablestudy.domain.LoadablePlanPortWiseDetails();

    portWiseDetails.setPortId(lastLoadingPortId);
    portWiseDetails.setPortRotationId(lastLoadingRotationId);
    portWiseDetails.setPortCode(
        portReply.getPortsList().stream()
            .filter(portDetail -> Objects.equals(lastLoadingPortId, portDetail.getId()))
            .findAny()
            .get()
            .getCode());
    LoadabalePatternDetails arrivalCondition = new LoadabalePatternDetails();
    LoadabalePatternDetails departureCondition = new LoadabalePatternDetails();

    arrivalCondition.setLoadablePlanStowageDetails(
        addLoadablePatternsStowageDetails(
            loadablePatternCargoDetailsRepository
                .findByLoadablePatternIdAndPortRotationIdAndOperationTypeAndIsActive(
                    loadablePattern.getId(),
                    lastLoadingRotationId,
                    SYNOPTICAL_TABLE_OP_TYPE_ARRIVAL,
                    true),
            false,
            loadablePattern.getId()));
    departureCondition.setLoadablePlanStowageDetails(
        addLoadablePatternsStowageDetails(
            loadablePatternCargoDetailsRepository
                .findByLoadablePatternIdAndPortRotationIdAndOperationTypeAndIsActive(
                    loadablePattern.getId(),
                    lastLoadingRotationId,
                    SYNOPTICAL_TABLE_OP_TYPE_DEPARTURE,
                    true),
            true,
            loadablePattern.getId()));
    arrivalCondition.setLoadablePlanBallastDetails(
        addLoadablePlanBallastDetails(
            loadablePlanStowageBallastDetailsRepository
                .findByLoadablePatternIdAndPortRotationIdAndOperationTypeAndIsActive(
                    loadablePattern.getId(),
                    lastLoadingRotationId,
                    SYNOPTICAL_TABLE_OP_TYPE_ARRIVAL,
                    true),
            false,
            loadablePattern.getId()));
    departureCondition.setLoadablePlanBallastDetails(
        addLoadablePlanBallastDetails(
            loadablePlanStowageBallastDetailsRepository
                .findByLoadablePatternIdAndPortRotationIdAndOperationTypeAndIsActive(
                    loadablePattern.getId(),
                    lastLoadingRotationId,
                    SYNOPTICAL_TABLE_OP_TYPE_DEPARTURE,
                    true),
            true,
            loadablePattern.getId()));

    portWiseDetails.setArrivalCondition(arrivalCondition);
    portWiseDetails.setDepartureCondition(departureCondition);
    loadablePlanPortWiseDetails.add(portWiseDetails);

    loadabalePatternValidateRequest.setLoadablePlanPortWiseDetails(loadablePlanPortWiseDetails);
  }

  /**
   * @param findByLoadablePatternIdAndPortRotationIdAndOperationTypeAndIsActive
   * @param synopticalTableOpTypeArrival
   * @return List<com.cpdss.loadablestudy.domain.LoadablePlanBallastDetails>
   */
  private List<com.cpdss.loadablestudy.domain.LoadablePlanBallastDetails>
      addLoadablePlanBallastDetails(
          List<LoadablePlanStowageBallastDetails> loadablePlanStowageBallastDetails,
          Boolean isLastPortDeparture,
          Long loadablePatternId) {
    List<com.cpdss.loadablestudy.domain.LoadablePlanBallastDetails> ballastDetails =
        new ArrayList<com.cpdss.loadablestudy.domain.LoadablePlanBallastDetails>();

    if (isLastPortDeparture) {
      stowageDetailsTempRepository
          .findByLoadablePlanBallastTempDetailsAndIsActive(loadablePatternId, true)
          .forEach(
              lpsd -> {
                com.cpdss.loadablestudy.domain.LoadablePlanBallastDetails details =
                    new com.cpdss.loadablestudy.domain.LoadablePlanBallastDetails();
                Object[] obA = (Object[]) lpsd;
                details.setId((Long) obA[0]);
                details.setTankId((Long) obA[1]);
                details.setQuantityMT(String.valueOf(obA[2]));
                ballastDetails.add(details);
              });
    } else {
      loadablePlanStowageBallastDetails.forEach(
          lpsd -> {
            com.cpdss.loadablestudy.domain.LoadablePlanBallastDetails details =
                new com.cpdss.loadablestudy.domain.LoadablePlanBallastDetails();

            details.setId(lpsd.getId());
            details.setQuantityMT(String.valueOf(lpsd.getQuantity()));
            details.setTankId(lpsd.getTankXId());
            ballastDetails.add(details);
          });
    }
    return ballastDetails;
  }

  /**
   * @param findByLoadablePatternIdAndPortRotationIdAndOperationTypeAndIsActive
   * @param synopticalTableOpTypeArrival
   * @return List<com.cpdss.loadablestudy.domain.LoadablePlanStowageDetails>
   */
  private List<com.cpdss.loadablestudy.domain.LoadablePlanStowageDetails>
      addLoadablePatternsStowageDetails(
          List<com.cpdss.loadablestudy.entity.LoadablePatternCargoDetails>
              loadablePatternCargoDetails,
          Boolean isLastPortDeparture,
          Long loadablePatternId) {
    List<com.cpdss.loadablestudy.domain.LoadablePlanStowageDetails> stowageDetails =
        new ArrayList<com.cpdss.loadablestudy.domain.LoadablePlanStowageDetails>();
    if (isLastPortDeparture) {
      stowageDetailsTempRepository
          .findByLoadablePlanStowageTempDetailsAndIsActive(loadablePatternId, true)
          .forEach(
              lpsd -> {
                com.cpdss.loadablestudy.domain.LoadablePlanStowageDetails details =
                    new com.cpdss.loadablestudy.domain.LoadablePlanStowageDetails();
                Object[] obA = (Object[]) lpsd;
                details.setId((Long) obA[0]);
                details.setCargoNominationId((Long) obA[1]);
                details.setTankId((Long) obA[2]);
                details.setQuantityMT(String.valueOf(obA[3]));
                stowageDetails.add(details);
              });
    } else {

      loadablePatternCargoDetails.forEach(
          lpsd -> {
            com.cpdss.loadablestudy.domain.LoadablePlanStowageDetails details =
                new com.cpdss.loadablestudy.domain.LoadablePlanStowageDetails();
            details.setId(lpsd.getId());
            details.setCargoNominationId(lpsd.getCargoNominationId());
            details.setTankId(lpsd.getTankId());
            details.setQuantityMT(String.valueOf(lpsd.getPlannedQuantity()));
            stowageDetails.add(details);
          });
    }
    return stowageDetails;
  }

  /**
   * @param processId
   * @param loadablePattern
   * @param loadableStudyProcessingStartedId void
   */
  private void updateProcessIdForLoadablePattern(
      String processId, LoadablePattern loadablePattern, Long loadablePatternProcessingStartedId) {
    LoadablePatternAlgoStatus status = new LoadablePatternAlgoStatus();
    status.setLoadablePattern(loadablePattern);
    status.setIsActive(true);
    status.setLoadableStudyStatus(
        loadableStudyStatusRepository.getOne(loadablePatternProcessingStartedId));
    status.setProcessId(processId);
    status.setVesselxid(loadablePattern.getLoadableStudy().getVesselXId());
    loadablePatternAlgoStatusRepository.save(status);
  }

  @Override
  public void getLoadablePatternCommingleDetails(
      LoadablePatternCommingleDetailsRequest request,
      StreamObserver<LoadablePatternCommingleDetailsReply> responseObserver) {
    log.info("Inside get Loadable Pattern Commingle Details in loadable study micro service");
    LoadablePatternCommingleDetailsReply.Builder builder =
        LoadablePatternCommingleDetailsReply.newBuilder();
    try {
      Optional<LoadablePlanCommingleDetails> loadablePlanComingleDetails =
          loadablePlanCommingleDetailsRepository.findByIdAndIsActive(
              request.getLoadablePatternCommingleDetailsId(), true);
      if (!loadablePlanComingleDetails.isPresent()) {
        log.info(
            INVALID_LOADABLE_PATTERN_COMMINGLE_DETAIL_ID,
            request.getLoadablePatternCommingleDetailsId());
        builder.setResponseStatus(
            ResponseStatus.newBuilder()
                .setStatus(FAILED)
                .setMessage(INVALID_LOADABLE_PATTERN_COMMINGLE_DETAIL_ID)
                .setCode(CommonErrorCodes.E_HTTP_BAD_REQUEST));
      } else {

        buildLoadablePatternComingleDetails(loadablePlanComingleDetails.get(), builder);
        builder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS).build());
      }

    } catch (Exception e) {
      log.error("Exception when fetching get Loadable Pattern Details", e);
      builder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage("Exception when fetching Loadable Pattern Commingle Details")
              .setStatus(FAILED)
              .build());
    } finally {
      responseObserver.onNext(builder.build());
      responseObserver.onCompleted();
    }
  }

  /**
   * @param loadablePatternComingleDetails void
   * @param builder
   */
  private void buildLoadablePatternComingleDetails(
      LoadablePlanCommingleDetails loadablePlanCommingleDetails,
      com.cpdss.common.generated.LoadableStudy.LoadablePatternCommingleDetailsReply.Builder
          builder) {
    Optional.ofNullable(loadablePlanCommingleDetails.getApi())
        .ifPresent(api -> builder.setApi(String.valueOf(api)));
    Optional.ofNullable(loadablePlanCommingleDetails.getCargo1Abbreviation())
        .ifPresent(cargo1Abbrivation -> builder.setCargo1Abbrivation(cargo1Abbrivation));

    Optional.ofNullable(loadablePlanCommingleDetails.getCargo2Abbreviation())
        .ifPresent(cargo2Abbrivation -> builder.setCargo2Abbrivation(cargo2Abbrivation));

    Optional.ofNullable(loadablePlanCommingleDetails.getCargo1Percentage())
        .ifPresent(
            cargo1Percentage -> builder.setCargo1Percentage(String.valueOf(cargo1Percentage)));

    Optional.ofNullable(loadablePlanCommingleDetails.getCargo2Percentage())
        .ifPresent(
            cargo2Percentage -> builder.setCargo2Percentage(String.valueOf(cargo2Percentage)));

    Optional.ofNullable(loadablePlanCommingleDetails.getCargo1Mt())
        .ifPresent(cargo1Quantity -> builder.setCargo1Quantity(String.valueOf(cargo1Quantity)));

    Optional.ofNullable(loadablePlanCommingleDetails.getCargo2Mt())
        .ifPresent(cargo2Quantity -> builder.setCargo2Quantity(String.valueOf(cargo2Quantity)));

    Optional.ofNullable(loadablePlanCommingleDetails.getGrade())
        .ifPresent(grade -> builder.setGrade(grade));

    Optional.ofNullable(loadablePlanCommingleDetails.getQuantity())
        .ifPresent(quantity -> builder.setQuantity(String.valueOf(quantity)));

    Optional.ofNullable(loadablePlanCommingleDetails.getTankName())
        .ifPresent(tankShortName -> builder.setTankShortName(tankShortName));

    Optional.ofNullable(loadablePlanCommingleDetails.getTemperature())
        .ifPresent(temperature -> builder.setTemperature(String.valueOf(temperature)));

    Optional.ofNullable(loadablePlanCommingleDetails.getId()).ifPresent(id -> builder.setId(id));
  }

  @Override
  public void savePatternValidateResult(
      LoadablePatternAlgoRequest request, StreamObserver<AlgoReply> responseObserver) {
    AlgoReply.Builder builder = AlgoReply.newBuilder();
    try {

      log.info("savePatternValidateResult - loadable study micro service");
      Optional<LoadablePattern> loadablePatternOpt =
          this.loadablePatternRepository.findByIdAndIsActive(request.getLoadablePatternId(), true);
      if (!loadablePatternOpt.isPresent()) {
        throw new GenericServiceException(
            "Loadable pattern does not exist",
            CommonErrorCodes.E_HTTP_BAD_REQUEST,
            HttpStatusCode.BAD_REQUEST);
      }

      if (!request.getValidated()) {
        loadablePatternAlgoStatusRepository.updateLoadablePatternAlgoStatus(
            LOADABLE_PATTERN_VALIDATION_FAILED_ID, request.getProcesssId(), true);

        algoErrorsRepository.deleteAlgoError(false, request.getLoadablePatternId());
        algoErrorHeadingRepository.deleteAlgoErrorHeading(false, request.getLoadablePatternId());

        saveAlgoErrorToDB(request, loadablePatternOpt.get(), new LoadableStudy(), true);

      } else {

        deleteExistingPlanDetails(loadablePatternOpt.get());

        Long lastLoadingPort =
            getLastPort(
                loadablePatternOpt.get().getLoadableStudy(),
                this.cargoOperationRepository.getOne(LOADING_OPERATION_ID));
        request
            .getLoadablePlanDetailsList()
            .forEach(
                lpd -> {
                  Optional<LoadablePlanPortWiseDetails> lppwdOptional =
                      lpd.getLoadablePlanPortWiseDetailsList().stream()
                          .filter(lppwd -> lppwd.getPortId() == lastLoadingPort)
                          .findAny();
                  if (lppwdOptional.isPresent()) {
                    saveLoadableQuantity(lppwdOptional.get(), loadablePatternOpt.get());
                    saveLoadablePlanCommingleCargo(
                        lppwdOptional
                            .get()
                            .getDepartureCondition()
                            .getLoadableQuantityCommingleCargoDetailsList(),
                        loadablePatternOpt.get());
                    saveLoadablePlanStowageDetails(
                        lppwdOptional
                            .get()
                            .getDepartureCondition()
                            .getLoadablePlanStowageDetailsList(),
                        loadablePatternOpt.get());
                    saveLoadablePlanBallastDetails(
                        lppwdOptional
                            .get()
                            .getDepartureCondition()
                            .getLoadablePlanBallastDetailsList(),
                        loadablePatternOpt.get());
                  }
                  // saveStabilityParameters(loadablePatternOpt.get(), lpd, lastLoadingPort);
                  saveLoadablePlanStowageDetails(loadablePatternOpt.get(), lpd);
                  saveLoadablePlanBallastDetails(loadablePatternOpt.get(), lpd);
                });
        // this.saveLoadicatorInfo(loadableStudyOpt.get(), request.getProcesssId());
        loadablePatternAlgoStatusRepository.updateLoadablePatternAlgoStatus(
            LOADABLE_PATTERN_VALIDATION_SUCCESS_ID, request.getProcesssId(), true);
      }

      builder
          .setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS).setMessage(SUCCESS))
          .build();
    } catch (GenericServiceException e) {
      log.error("GenericServiceException in loadable pattern list", e);
      builder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(e.getCode())
              .setMessage(e.getMessage())
              .setStatus(FAILED)
              .build());
    } catch (Exception e) {
      log.error("Exception in loadable pattern list", e);
      builder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage("Exception in getLoadablePatternList")
              .setStatus(FAILED)
              .build());
    } finally {
      responseObserver.onNext(builder.build());
      responseObserver.onCompleted();
    }
  }

  /**
   * @param request
   * @param loadableStudy
   * @param loadablePattern
   * @param b void
   */
  private void saveAlgoErrorToDB(
      LoadablePatternAlgoRequest request,
      LoadablePattern loadablePattern,
      LoadableStudy loadableStudy,
      boolean isPatternErrorSaving) {
    request
        .getAlgoErrorsList()
        .forEach(
            algoError -> {
              AlgoErrorHeading algoErrorHeading = new AlgoErrorHeading();
              algoErrorHeading.setErrorHeading(algoError.getErrorHeading());
              if (isPatternErrorSaving) {
                algoErrorHeading.setLoadablePattern(loadablePattern);
              } else {
                algoErrorHeading.setLoadableStudy(loadableStudy);
              }
              algoErrorHeading.setIsActive(true);
              algoErrorHeadingRepository.save(algoErrorHeading);
              algoError
                  .getErrorMessagesList()
                  .forEach(
                      error -> {
                        com.cpdss.loadablestudy.entity.AlgoErrors algoErrors =
                            new com.cpdss.loadablestudy.entity.AlgoErrors();
                        algoErrors.setAlgoErrorHeading(algoErrorHeading);
                        algoErrors.setErrorMessage(error);
                        algoErrors.setIsActive(true);
                        algoErrorsRepository.save(algoErrors);
                      });
            });
  }

  /** @param loadablePattern void */
  private void deleteExistingPlanDetails(LoadablePattern loadablePattern) {
    stowageDetailsTempRepository.deleteLoadablePlanStowageDetailsTemp(
        false, loadablePattern.getId());
    loadablePlanQuantityRepository.deleteLoadablePlanQuantity(false, loadablePattern.getId());
    loadablePlanCommingleDetailsRepository.deleteLoadablePlanCommingleDetails(
        false, loadablePattern.getId());
    loadablePlanStowageDetailsRespository.deleteLoadablePlanStowageDetails(
        false, loadablePattern.getId());
    loadablePatternCargoDetailsRepository.deleteLoadablePatternCargoDetails(
        false, loadablePattern.getId());
    loadablePlanBallastDetailsRepository.deleteLoadablePlanBallastDetails(
        false, loadablePattern.getId());
    loadablePlanStowageBallastDetailsRepository.deleteLoadablePlanStowageBallastDetails(
        false, loadablePattern.getId());
  }

  @Override
  public void generateLoadablePatterns(
      AlgoRequest request, StreamObserver<AlgoReply> responseObserver) {
    log.info("Inside generateLoadablePatterns service");
    com.cpdss.common.generated.LoadableStudy.AlgoReply.Builder replyBuilder =
        AlgoReply.newBuilder();
    try {

      Optional<LoadableStudy> loadableStudyOpt =
          loadableStudyRepository.findByIdAndIsActive(request.getLoadableStudyId(), true);
      if (loadableStudyOpt.isPresent()) {
        this.checkIfVoyageClosed(loadableStudyOpt.get().getVoyage().getId());
        ModelMapper modelMapper = new ModelMapper();
        com.cpdss.loadablestudy.domain.LoadableStudy loadableStudy =
            new com.cpdss.loadablestudy.domain.LoadableStudy();

        buildLoadableStudy(
            request.getLoadableStudyId(), loadableStudyOpt.get(), loadableStudy, modelMapper);

        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.writeValue(
            new File("json/loadableStudy_" + request.getLoadableStudyId() + ".json"),
            loadableStudy);

        this.saveJsonToDatabase(
            request.getLoadableStudyId(),
            LOADABLE_STUDY_REQUEST,
            objectMapper.writeValueAsString(loadableStudy));

        AlgoResponse algoResponse =
            restTemplate.postForObject(loadableStudyUrl, loadableStudy, AlgoResponse.class);
        updateProcessIdForLoadableStudy(
            algoResponse.getProcessId(),
            loadableStudyOpt.get(),
            LOADABLE_STUDY_PROCESSING_STARTED_ID);

        loadableStudyRepository.updateLoadableStudyStatus(
            LOADABLE_STUDY_PROCESSING_STARTED_ID, loadableStudyOpt.get().getId());

        replyBuilder =
            AlgoReply.newBuilder()
                .setProcesssId(algoResponse.getProcessId())
                .setResponseStatus(
                    ResponseStatus.newBuilder().setMessage(SUCCESS).setStatus(SUCCESS).build());
      } else {
        log.info("INVALID_LOADABLE_STUDY {} - ", request.getLoadableStudyId());
        replyBuilder =
            AlgoReply.newBuilder()
                .setResponseStatus(
                    ResponseStatus.newBuilder()
                        .setStatus(FAILED)
                        .setMessage(INVALID_LOADABLE_STUDY_ID)
                        .setCode(CommonErrorCodes.E_HTTP_BAD_REQUEST)
                        .build());
      }
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

  /**
   * @param loadableStudyOpt
   * @param loadableStudy
   * @param modelMapper void
   */
  private void buildLoadableStudy(
      Long loadableStudyId,
      LoadableStudy loadableStudyOpt,
      com.cpdss.loadablestudy.domain.LoadableStudy loadableStudy,
      ModelMapper modelMapper) {
    buildLoadableStuydDetails(Optional.of(loadableStudyOpt), loadableStudy);
    buildCargoNominationDetails(loadableStudyId, loadableStudy, modelMapper);
    buildCommingleCargoDetails(loadableStudyOpt.getId(), loadableStudy, modelMapper);
    buildLoadableQuantityDetails(loadableStudyId, loadableStudy);
    buildLoadableStudyPortRotationDetails(loadableStudyId, loadableStudy, modelMapper);
    buildCargoNominationPortDetails(loadableStudyId, loadableStudy);
    buildOnHandQuantityDetails(loadableStudyOpt, loadableStudy, modelMapper);
    buildOnBoardQuantityDetails(loadableStudyOpt, loadableStudy, modelMapper);
    buildportRotationDetails(loadableStudyOpt, loadableStudy);
  }

  /**
   * @param algoResponse
   * @param loadableStudy void
   */
  public void updateProcessIdForLoadableStudy(
      String processId, LoadableStudy loadableStudy, Long loadableStudyStatus) {
    LoadableStudyAlgoStatus status = new LoadableStudyAlgoStatus();
    status.setLoadableStudy(loadableStudy);
    status.setIsActive(true);
    status.setLoadableStudyStatus(loadableStudyStatusRepository.getOne(loadableStudyStatus));
    status.setProcessId(processId);
    status.setVesselxid(loadableStudy.getVesselXId());
    loadableStudyAlgoStatusRepository.save(status);
  }

  @Override
  public void getLoadicatorData(
      LoadicatorDataRequest request, StreamObserver<LoadicatorDataReply> responseObserver) {
    log.info("Inside getLoadicatorData service");
    LoadicatorDataReply.Builder replyBuilder = LoadicatorDataReply.newBuilder();
    try {
      LoadicatorAlgoRequest loadicator = new LoadicatorAlgoRequest();
      this.buildLoadicatorUrlRequest(request, loadicator);
      ObjectMapper objectMapper = new ObjectMapper();

      objectMapper.writeValue(
          new File("json/loadicator_" + request.getLoadableStudyId() + ".json"), loadicator);
      LoadicatorAlgoResponse algoResponse =
          restTemplate.postForObject(loadicatorUrl, loadicator, LoadicatorAlgoResponse.class);
      this.saveloadicatorDataForSynopticalTable(algoResponse);
      loadableStudyAlgoStatusRepository.updateLoadableStudyAlgoStatus(
          LOADABLE_STUDY_STATUS_LOADICATOR_VERIFICATION_WITH_ALGO_ID,
          algoResponse.getProcessId(),
          true);
      replyBuilder =
          LoadicatorDataReply.newBuilder()
              .setResponseStatus(
                  ResponseStatus.newBuilder().setMessage(SUCCESS).setStatus(SUCCESS).build());

    } catch (Exception e) {
      log.error("Exception when when getLoadicatorData ", e);
      replyBuilder =
          LoadicatorDataReply.newBuilder()
              .setResponseStatus(
                  ResponseStatus.newBuilder()
                      .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
                      .setMessage("Error when getLoadicatorData ")
                      .setStatus(FAILED)
                      .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  /**
   * Save data for synoptical table
   *
   * @param algoResponse
   */
  private void saveloadicatorDataForSynopticalTable(LoadicatorAlgoResponse algoResponse) {
    List<SynopticalTableLoadicatorData> entities = new ArrayList<>();
    for (LoadicatorPatternDetailsResults patternDetails :
        algoResponse.getLoadicatorResultsPatternWise()) {
      patternDetails
          .getLoadicatorResultDetails()
          .forEach(
              result -> {
                SynopticalTableLoadicatorData entity = new SynopticalTableLoadicatorData();
                entity.setLoadablePatternId(patternDetails.getLoadablePatternId());
                entity.setSynopticalTable(
                    this.synopticalTableRepository.getOne(result.getSynopticalId()));
                entity.setActive(true);
                entity.setBlindSector(
                    isEmpty(result.getDeflection())
                        ? null
                        : new BigDecimal(result.getDeflection()));
                entity.setCalculatedDraftAftPlanned(
                    isEmpty(result.getCalculatedDraftAftPlanned())
                        ? null
                        : new BigDecimal(result.getCalculatedDraftAftPlanned()));
                entity.setCalculatedDraftFwdPlanned(
                    isEmpty(result.getCalculatedDraftFwdPlanned())
                        ? null
                        : new BigDecimal(result.getCalculatedDraftFwdPlanned()));
                entity.setCalculatedDraftMidPlanned(
                    isEmpty(result.getCalculatedDraftMidPlanned())
                        ? null
                        : new BigDecimal(result.getCalculatedDraftMidPlanned()));
                entity.setCalculatedTrimPlanned(
                    isEmpty(result.getCalculatedTrimPlanned())
                        ? null
                        : new BigDecimal(result.getCalculatedTrimPlanned()));
                entity.setList(isEmpty(result.getList()) ? null : new BigDecimal(result.getList()));
                entities.add(entity);
              });
    }
    this.synopticalTableLoadicatorDataRepository.saveAll(entities);
  }

  /**
   * @param request
   * @param loadicator void
   */
  private void buildLoadicatorUrlRequest(
      LoadicatorDataRequest request, LoadicatorAlgoRequest loadicator) {
    loadicator.setProcessId(request.getProcessId());
    loadicator.setLoadicatorPatternDetails(new ArrayList<>());
    request
        .getLoadicatorPatternDetailsList()
        .forEach(
            patternDetails -> {
              LoadicatorPatternDetails patterns = new LoadicatorPatternDetails();
              patterns.setLoadablePatternId(patternDetails.getLoadablePatternId());
              patterns.setLdTrim(this.createLdTrim(patternDetails.getLDtrimList()));
              patterns.setLdStrength(this.createLdStrength(patternDetails.getLDStrengthList()));
              patterns.setLdIntactStability(
                  this.createLdIntactStability(patternDetails.getLDIntactStabilityList()));
              loadicator.getLoadicatorPatternDetails().add(patterns);
            });
  }

  /**
   * @param list
   * @return LDIntactStability
   */
  private List<LDIntactStability> createLdIntactStability(
      List<com.cpdss.common.generated.LoadableStudy.LDIntactStability> list) {
    List<LDIntactStability> ldIntactStabilities = new ArrayList<LDIntactStability>();
    list.forEach(
        lDIntactStability -> {
          LDIntactStability intactStability = new LDIntactStability();
          intactStability.setAngleatmaxrleverJudgement(
              lDIntactStability.getAngleatmaxrleverJudgement());
          intactStability.setAngleatmaxrleverValue(lDIntactStability.getAngleatmaxrleverValue());
          intactStability.setAreaofStability030Judgement(
              lDIntactStability.getAreaofStability030Judgement());
          intactStability.setAreaofStability030Value(
              lDIntactStability.getAreaofStability030Value());
          intactStability.setAreaofStability040Judgement(
              lDIntactStability.getAreaofStability040Judgement());
          intactStability.setAreaofStability040Value(
              lDIntactStability.getAreaofStability040Value());
          intactStability.setAreaofStability3040Judgement(
              lDIntactStability.getAreaofStability3040Judgement());
          intactStability.setAreaofStability3040Value(
              lDIntactStability.getAreaofStability3040Value());
          intactStability.setBigIntialGomJudgement(lDIntactStability.getBigIntialGomJudgement());
          intactStability.setBigintialGomValue(lDIntactStability.getBigintialGomValue());
          intactStability.setErrorDetails(lDIntactStability.getErrorDetails());
          intactStability.setErrorStatus(lDIntactStability.getErrorStatus());
          intactStability.setGmAllowableCurveCheckJudgement(
              lDIntactStability.getGmAllowableCurveCheckJudgement());
          intactStability.setGmAllowableCurveCheckValue(
              lDIntactStability.getGmAllowableCurveCheckValue());
          intactStability.setHeelBySteadyWindJudgement(
              lDIntactStability.getHeelBySteadyWindJudgement());
          intactStability.setHeelBySteadyWindValue(lDIntactStability.getHeelBySteadyWindValue());
          intactStability.setId(lDIntactStability.getId());
          intactStability.setMaximumRightingLeverJudgement(
              lDIntactStability.getMaximumRightingLeverJudgement());
          intactStability.setMaximumRightingLeverValue(
              lDIntactStability.getMaximumRightingLeverValue());
          intactStability.setMessageText(lDIntactStability.getMessageText());
          intactStability.setStabilityAreaBaJudgement(
              lDIntactStability.getStabilityAreaBaJudgement());
          intactStability.setStabilityAreaBaValue(lDIntactStability.getStabilityAreaBaValue());
          intactStability.setPortId(lDIntactStability.getPortId());
          intactStability.setSynioticalId(lDIntactStability.getSynopticalId());
          ldIntactStabilities.add(intactStability);
        });

    return ldIntactStabilities;
  }

  /**
   * @param list
   * @return LDStrength
   */
  private List<LDStrength> createLdStrength(
      List<com.cpdss.common.generated.LoadableStudy.LDStrength> list) {
    List<LDStrength> ldStrengths = new ArrayList<LDStrength>();
    list.forEach(
        ldStrength -> {
          LDStrength strength = new LDStrength();
          strength.setBendingMomentPersentFrameNumber(
              ldStrength.getBendingMomentPersentFrameNumber());
          strength.setBendingMomentPersentJudgement(ldStrength.getBendingMomentPersentJudgement());
          strength.setBendingMomentPersentValue(ldStrength.getBendingMomentPersentValue());
          strength.setErrorDetails(ldStrength.getErrorDetails());
          strength.setId(ldStrength.getId());
          strength.setInnerLongiBhdFrameNumber(ldStrength.getInnerLongiBhdFrameNumber());
          strength.setInnerLongiBhdJudgement(ldStrength.getInnerLongiBhdJudgement());
          strength.setInnerLongiBhdValue(ldStrength.getInnerLongiBhdValue());
          strength.setMessageText(ldStrength.getMessageText());
          strength.setOuterLongiBhdFrameNumber(ldStrength.getOuterLongiBhdFrameNumber());
          strength.setOuterLongiBhdJudgement(ldStrength.getOuterLongiBhdJudgement());
          strength.setOuterLongiBhdValue(ldStrength.getOuterLongiBhdValue());
          strength.setSfFrameNumber(ldStrength.getSfFrameNumber());
          strength.setSfHopperFrameNumber(ldStrength.getSfHopperFrameNumber());
          strength.setSfHopperJudgement(ldStrength.getSfHopperJudgement());
          strength.setSfHopperValue(ldStrength.getSfHopperValue());
          strength.setSfSideShellFrameNumber(ldStrength.getSfSideShellFrameNumber());
          strength.setSfSideShellJudgement(ldStrength.getSfSideShellJudgement());
          strength.setSfSideShellValue(ldStrength.getSfSideShellValue());
          strength.setShearingForceJudgement(ldStrength.getShearingForceJudgement());
          strength.setShearingForcePersentValue(ldStrength.getShearingForcePersentValue());
          strength.setPortId(ldStrength.getPortId());
          strength.setSynioticalId(ldStrength.getSynopticalId());
          ldStrengths.add(strength);
        });

    return ldStrengths;
  }

  /**
   * @param list
   * @return LDTrim
   */
  private List<LDTrim> createLdTrim(List<LDtrim> list) {
    List<LDTrim> ldTrims = new ArrayList<LDTrim>();
    list.forEach(
        ldTrim -> {
          LDTrim trim = new LDTrim();
          trim.setAftDraftValue(ldTrim.getAftDraftValue());
          trim.setAirDraftJudgement(ldTrim.getAirDraftJudgement());
          trim.setAirDraftValue(ldTrim.getAirDraftValue());
          trim.setDisplacementJudgement(ldTrim.getDisplacementJudgement());
          trim.setDisplacementValue(ldTrim.getDisplacementValue());
          trim.setErrorDetails(ldTrim.getErrorDetails());
          trim.setErrorStatus(ldTrim.getErrorStatus());
          trim.setForeDraftValue(ldTrim.getForeDraftValue());
          trim.setHeelValue(ldTrim.getHeelValue());
          trim.setId(ldTrim.getId());
          trim.setMaximumAllowableJudement(ldTrim.getMaximumAllowableJudement());
          trim.setMaximumAllowableVisibility(ldTrim.getMaximumAllowableVisibility());
          trim.setMaximumDraftJudgement(ldTrim.getMaximumDraftJudgement());
          trim.setMeanDraftValue(ldTrim.getMaximumDraftValue());
          trim.setMaximumDraftValue(ldTrim.getMaximumDraftValue());
          trim.setMeanDraftJudgement(ldTrim.getMeanDraftJudgement());
          trim.setMeanDraftValue(ldTrim.getMeanDraftValue());
          trim.setMessageText(ldTrim.getMessageText());
          trim.setMinimumForeDraftInRoughWeatherJudgement(
              ldTrim.getMinimumForeDraftInRoughWeatherJudgement());
          trim.setMinimumForeDraftInRoughWeatherValue(
              ldTrim.getMinimumForeDraftInRoughWeatherValue());
          trim.setTrimValue(ldTrim.getTrimValue());
          trim.setPortId(ldTrim.getPortId());
          trim.setSynioticalId(ldTrim.getSynopticalId());
          ldTrims.add(trim);
        });

    return ldTrims;
  }

  /**
   * @param loadableStudy
   * @param loadableStudyEntity void
   */
  private void buildportRotationDetails(
      LoadableStudy loadableStudyEntity,
      com.cpdss.loadablestudy.domain.LoadableStudy loadableStudy) {
    GetPortInfoByPortIdsRequest.Builder portsBuilder = GetPortInfoByPortIdsRequest.newBuilder();
    List<Long> portIds = this.getPortRoationPortIds(loadableStudyEntity);
    portIds.forEach(
        portId -> {
          portsBuilder.addId(portId);
        });

    loadableStudy.setPortDetails(new ArrayList<PortDetails>());
    PortReply portReply = getPortInfo(portsBuilder.build());
    portReply
        .getPortsList()
        .forEach(
            portList -> {
              PortDetails portDetails = new PortDetails();
              portDetails.setAverageTideHeight(portList.getAverageTideHeight());
              portDetails.setCode(portList.getCode());
              portDetails.setDensitySeaWater(portList.getWaterDensity());
              portDetails.setId(portList.getId());
              portDetails.setName(portList.getName());
              portDetails.setTideHeight(portList.getTideHeight());
              loadableStudy.getPortDetails().add(portDetails);
            });
  }

  /**
   * @param build
   * @return PortReply
   */
  public PortReply getPortInfo(GetPortInfoByPortIdsRequest build) {
    return portInfoGrpcService.getPortInfoByPortIds(build);
  }

  /**
   * @param loadableStudy
   * @param loadableStudy2
   * @param modelMapper void
   */
  private void buildOnBoardQuantityDetails(
      LoadableStudy loadableStudyEntity,
      com.cpdss.loadablestudy.domain.LoadableStudy loadableStudy,
      ModelMapper modelMapper) {
    loadableStudy.setOnBoardQuantity(new ArrayList<>());
    List<OnBoardQuantity> onBoardQuantities =
        onBoardQuantityRepository.findByLoadableStudyAndIsActive(loadableStudyEntity, true);
    onBoardQuantities.forEach(
        onBoardQuantity -> {
          com.cpdss.loadablestudy.domain.OnBoardQuantity onBoardQuantityDto =
              new com.cpdss.loadablestudy.domain.OnBoardQuantity();
          onBoardQuantityDto =
              modelMapper.map(
                  onBoardQuantity, com.cpdss.loadablestudy.domain.OnBoardQuantity.class);
          onBoardQuantityDto.setApi(
              null != onBoardQuantity.getDensity()
                  ? String.valueOf(onBoardQuantity.getDensity())
                  : "");
          loadableStudy.getOnBoardQuantity().add(onBoardQuantityDto);
        });
  }

  /**
   * @param loadableStudy
   * @param loadableStudy2
   * @param modelMapper void
   */
  private void buildOnHandQuantityDetails(
      LoadableStudy loadableStudyEntity,
      com.cpdss.loadablestudy.domain.LoadableStudy loadableStudy,
      ModelMapper modelMapper) {
    loadableStudy.setOnHandQuantity(new ArrayList<>());
    List<OnHandQuantity> onHandQuantities =
        onHandQuantityRepository.findByLoadableStudyAndIsActive(loadableStudyEntity, true);
    onHandQuantities.forEach(
        onHandQuantity -> {
          com.cpdss.loadablestudy.domain.OnHandQuantity onHandQuantityDto =
              new com.cpdss.loadablestudy.domain.OnHandQuantity();
          modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
          onHandQuantityDto =
              modelMapper.map(onHandQuantity, com.cpdss.loadablestudy.domain.OnHandQuantity.class);
          loadableStudy.getOnHandQuantity().add(onHandQuantityDto);
        });
  }

  /**
   * @param loadableStudyId
   * @param loadableStudy void
   */
  private void buildCargoNominationPortDetails(
      long loadableStudyId, com.cpdss.loadablestudy.domain.LoadableStudy loadableStudy) {
    List<CargoNomination> cargoNominations =
        cargoNominationRepository.findByLoadableStudyXIdAndIsActive(loadableStudyId, true);
    loadableStudy.setCargoNominationOperationDetails(new ArrayList<>());
    List<CargoNominationPortDetails> cargoNominationOperationDetails =
        cargoNominationOperationDetailsRepository.findByCargoNominationAndIsActive(
            cargoNominations, true);
    cargoNominationOperationDetails.forEach(
        cargoNominationOperationDetail -> {
          com.cpdss.loadablestudy.domain.CargoNominationOperationDetails
              cargoNominationOperationDetailDto =
                  new com.cpdss.loadablestudy.domain.CargoNominationOperationDetails();
          cargoNominationOperationDetailDto.setCargoNominationId(
              cargoNominationOperationDetail.getCargoNomination().getId());
          cargoNominationOperationDetailDto.setId(cargoNominationOperationDetail.getId());
          cargoNominationOperationDetailDto.setPortId(cargoNominationOperationDetail.getPortId());
          cargoNominationOperationDetailDto.setQuantity(
              String.valueOf(cargoNominationOperationDetail.getQuantity()));
          loadableStudy.getCargoNominationOperationDetails().add(cargoNominationOperationDetailDto);
        });
  }

  /**
   * @param loadableStudyId
   * @param loadableStudy
   * @param modelMapper void
   */
  private void buildLoadableStudyPortRotationDetails(
      long loadableStudyId,
      com.cpdss.loadablestudy.domain.LoadableStudy loadableStudy,
      ModelMapper modelMapper) {
    List<LoadableStudyPortRotation> loadableStudyPortRotations =
        loadableStudyPortRotationRepository.findByLoadableStudyAndIsActive(loadableStudyId, true);

    loadableStudy.setLoadableStudyPortRotation(new ArrayList<>());
    if (!loadableStudyPortRotations.isEmpty()) {
      loadableStudyPortRotations.forEach(
          loadableStudyPortRotation -> {
            com.cpdss.loadablestudy.domain.LoadableStudyPortRotation loadableStudyPortRotationDto =
                new com.cpdss.loadablestudy.domain.LoadableStudyPortRotation();
            loadableStudyPortRotationDto =
                modelMapper.map(
                    loadableStudyPortRotation,
                    com.cpdss.loadablestudy.domain.LoadableStudyPortRotation.class);
            loadableStudyPortRotationDto.setMaxAirDraft(
                loadableStudyPortRotation.getAirDraftRestriction());
            loadableStudy.getLoadableStudyPortRotation().add(loadableStudyPortRotationDto);
          });
    }
  }

  /**
   * @param loadableStudyId
   * @param loadableStudy void
   */
  private void buildLoadableQuantityDetails(
      long loadableStudyId, com.cpdss.loadablestudy.domain.LoadableStudy loadableStudy) {
    List<LoadableQuantity> loadableQuantity =
        loadableQuantityRepository.findByLoadableStudyXIdAndIsActive(loadableStudyId, true);
    if (!loadableQuantity.isEmpty()) {

      loadableQuantity.forEach(
          loadableQunty -> {
            com.cpdss.loadablestudy.domain.LoadableQuantity loadableQuantityDto =
                new com.cpdss.loadablestudy.domain.LoadableQuantity();

            Optional.ofNullable(loadableQunty.getBallast())
                .ifPresent(ballast -> loadableQuantityDto.setBallast(String.valueOf(ballast)));
            Optional.ofNullable(loadableQunty.getBoilerWaterOnBoard())
                .ifPresent(
                    boilerWaterOnBoard ->
                        loadableQuantityDto.setBoilerWaterOnBoard(
                            String.valueOf(boilerWaterOnBoard)));
            Optional.ofNullable(loadableQunty.getConstant())
                .ifPresent(constant -> loadableQuantityDto.setConstant(String.valueOf(constant)));
            Optional.ofNullable(loadableQunty.getDeadWeight())
                .ifPresent(
                    deadWeight -> loadableQuantityDto.setDeadWeight(String.valueOf(deadWeight)));
            Optional.ofNullable(loadableQunty.getDisplacementAtDraftRestriction())
                .ifPresent(
                    displacementAtDraftRestriction ->
                        loadableQuantityDto.setDisplacmentDraftRestriction(
                            String.valueOf(displacementAtDraftRestriction)));
            Optional.ofNullable(loadableQunty.getDistanceFromLastPort())
                .ifPresent(
                    distanceFromLastPort ->
                        loadableQuantityDto.setDistanceFromLastPort(
                            String.valueOf(distanceFromLastPort)));
            Optional.ofNullable(loadableQunty.getDraftRestriction())
                .ifPresent(
                    draftRestriction ->
                        loadableQuantityDto.setDraftRestriction(String.valueOf(draftRestriction)));
            Optional.ofNullable(loadableQunty.getEstimatedDOOnBoard())
                .ifPresent(
                    estimatedDOOnBoard ->
                        loadableQuantityDto.setEstDOOnBoard(String.valueOf(estimatedDOOnBoard)));
            Optional.ofNullable(loadableQunty.getEstimatedFOOnBoard())
                .ifPresent(
                    estimatedFOOnBoard ->
                        loadableQuantityDto.setEstDOOnBoard(String.valueOf(estimatedFOOnBoard)));
            Optional.ofNullable(loadableQunty.getEstimatedFWOnBoard())
                .ifPresent(
                    estimatedFWOnBoard ->
                        loadableQuantityDto.setEstFreshWaterOnBoard(
                            String.valueOf(estimatedFWOnBoard)));
            Optional.ofNullable(loadableQunty.getEstimatedSagging())
                .ifPresent(
                    estimatedSagging ->
                        loadableQuantityDto.setEstSagging(String.valueOf(estimatedSagging)));
            Optional.ofNullable(loadableQunty.getEstimatedSeaDensity())
                .ifPresent(
                    estimatedSeaDensity ->
                        loadableQuantityDto.setEstSeaDensity(String.valueOf(estimatedSeaDensity)));
            Optional.ofNullable(loadableQunty.getFoConsumptionInSZ())
                .ifPresent(
                    foConsumptionInSZ ->
                        loadableQuantityDto.setFoConInSZ(String.valueOf(foConsumptionInSZ)));
            Optional.ofNullable(loadableQunty.getId())
                .ifPresent(id -> loadableQuantityDto.setId(id));
            Optional.ofNullable(loadableQunty.getLightWeight())
                .ifPresent(
                    vesselLightWeight ->
                        loadableQuantityDto.setVesselLightWeight(
                            String.valueOf(vesselLightWeight)));
            Optional.ofNullable(loadableQunty.getOtherIfAny())
                .ifPresent(
                    otherIfAny -> loadableQuantityDto.setOtherIfAny(String.valueOf(otherIfAny)));
            Optional.ofNullable(loadableQunty.getPortId())
                .ifPresent(
                    portId -> loadableQuantityDto.setPortId(Long.valueOf(portId.toString())));
            Optional.ofNullable(loadableQunty.getRunningDays())
                .ifPresent(
                    runningDays -> loadableQuantityDto.setRunningDays(String.valueOf(runningDays)));
            Optional.ofNullable(loadableQunty.getRunningHours())
                .ifPresent(
                    runningHours ->
                        loadableQuantityDto.setRunningHours(String.valueOf(runningHours)));
            Optional.ofNullable(loadableQunty.getSaggingDeduction())
                .ifPresent(
                    saggingDeduction ->
                        loadableQuantityDto.setSaggingDeduction(String.valueOf(saggingDeduction)));
            Optional.ofNullable(loadableQunty.getSgCorrection())
                .ifPresent(
                    sgCorrection ->
                        loadableQuantityDto.setSgCorrection(String.valueOf(sgCorrection)));
            Optional.ofNullable(loadableQunty.getSubTotal())
                .ifPresent(subTotal -> loadableQuantityDto.setSubTotal(String.valueOf(subTotal)));
            Optional.ofNullable(loadableQunty.getTotalFoConsumption())
                .ifPresent(
                    totalFoConsumption ->
                        loadableQuantityDto.setTotalFoConsumption(
                            String.valueOf(totalFoConsumption)));
            Optional.ofNullable(loadableQunty.getTotalQuantity())
                .ifPresent(
                    totalQuantity ->
                        loadableQuantityDto.setTotalQuantity(String.valueOf(totalQuantity)));
            Optional.ofNullable(loadableQunty.getTpcatDraft())
                .ifPresent(tpcatDraft -> loadableQuantityDto.setTpc(String.valueOf(tpcatDraft)));
            Optional.ofNullable(loadableQunty.getVesselAverageSpeed())
                .ifPresent(
                    VesselAverageSpeed ->
                        loadableQuantityDto.setVesselAverageSpeed(
                            String.valueOf(VesselAverageSpeed)));

            loadableStudy.setLoadableQuantity(loadableQuantityDto);
          });
    }
  }

  /**
   * @param id
   * @param loadableStudy void
   * @param modelMapper
   */
  private void buildCommingleCargoDetails(
      Long loadableStudyId,
      com.cpdss.loadablestudy.domain.LoadableStudy loadableStudy,
      ModelMapper modelMapper) {

    List<com.cpdss.loadablestudy.entity.CommingleCargo> commingleCargos =
        commingleCargoRepository.findByLoadableStudyXIdAndIsActive(loadableStudyId, true);
    loadableStudy.setCommingleCargos(new ArrayList<>());

    commingleCargos.forEach(
        commingleCargo -> {
          com.cpdss.loadablestudy.domain.CommingleCargo commingleCargoDto =
              new com.cpdss.loadablestudy.domain.CommingleCargo();
          commingleCargoDto =
              modelMapper.map(commingleCargo, com.cpdss.loadablestudy.domain.CommingleCargo.class);
          commingleCargoDto.setCargo1Id(commingleCargo.getCargo1Xid());
          commingleCargoDto.setCargo2Id(commingleCargo.getCargo2Xid());
          commingleCargoDto.setCargo1Percentage(
              null != commingleCargo.getCargo1Pct()
                  ? commingleCargo.getCargo1Pct().toString()
                  : null);
          commingleCargoDto.setCargo2Percentage(
              null != commingleCargo.getCargo2Pct()
                  ? commingleCargo.getCargo2Pct().toString()
                  : null);
          loadableStudy.getCommingleCargos().add(commingleCargoDto);
        });
  }

  /**
   * @param loadableStudyId
   * @param loadableStudy void
   * @param modelMapper
   */
  private void buildCargoNominationDetails(
      long loadableStudyId,
      com.cpdss.loadablestudy.domain.LoadableStudy loadableStudy,
      ModelMapper modelMapper) {
    List<CargoNomination> cargoNominations =
        cargoNominationRepository.findByLoadableStudyXIdAndIsActive(loadableStudyId, true);

    loadableStudy.setCargoNomination(new ArrayList<>());
    cargoNominations.forEach(
        cargoNomination -> {
          com.cpdss.loadablestudy.domain.CargoNomination cargoNominationDto =
              new com.cpdss.loadablestudy.domain.CargoNomination();
          cargoNominationDto =
              modelMapper.map(
                  cargoNomination, com.cpdss.loadablestudy.domain.CargoNomination.class);
          loadableStudy.getCargoNomination().add(cargoNominationDto);
        });
  }

  /**
   * @param loadableStudyOpt
   * @param loadableStudy void
   */
  private void buildLoadableStuydDetails(
      Optional<LoadableStudy> loadableStudyOpt,
      com.cpdss.loadablestudy.domain.LoadableStudy loadableStudy) {
    loadableStudy.setId(loadableStudyOpt.get().getId());
    loadableStudy.setVesselId(loadableStudyOpt.get().getVesselXId());
    Optional.ofNullable(loadableStudyOpt.get().getDetails())
        .ifPresent(details -> loadableStudy.setDetails(details));
    Optional.ofNullable(loadableStudyOpt.get().getVoyage())
        .ifPresent(voyage -> loadableStudy.setVoyageId(voyage.getId()));
    Optional.ofNullable(loadableStudyOpt.get().getVoyage())
        .ifPresent(voyage -> loadableStudy.setVoyageNo(voyage.getVoyageNo()));

    Optional.ofNullable(loadableStudyOpt.get().getName())
        .ifPresent(name -> loadableStudy.setName(name));
    Optional.ofNullable(loadableStudyOpt.get().getCharterer())
        .ifPresent(charterer -> loadableStudy.setCharterer(charterer));
    Optional.ofNullable(loadableStudyOpt.get().getSubCharterer())
        .ifPresent(subCharterer -> loadableStudy.setSubCharterer(subCharterer));

    Optional.ofNullable(loadableStudyOpt.get().getDraftMark())
        .ifPresent(draftMark -> loadableStudy.setDraftMark(String.valueOf(draftMark)));

    Optional.ofNullable(loadableStudyOpt.get().getDraftRestriction())
        .ifPresent(
            draftRestriction ->
                loadableStudy.setDraftRestriction(String.valueOf(draftRestriction)));

    Optional.ofNullable(loadableStudyOpt.get().getLoadLineXId())
        .ifPresent(loadLineId -> loadableStudy.setLoadlineId(loadLineId));
    Optional.ofNullable(loadableStudyOpt.get().getEstimatedMaxSag())
        .ifPresent(
            estimatedMaxSag -> loadableStudy.setEstimatedMaxSG(String.valueOf(estimatedMaxSag)));
    Optional.ofNullable(loadableStudyOpt.get().getMaxAirTemperature())
        .ifPresent(
            maxAirTemperature -> loadableStudy.setMaxAirTemp(String.valueOf(maxAirTemperature)));
    Optional.ofNullable(loadableStudyOpt.get().getMaxWaterTemperature())
        .ifPresent(
            maxWaterTemperature ->
                loadableStudy.setMaxWaterTemp(String.valueOf(maxWaterTemperature)));

    Optional.ofNullable(loadableStudyOpt.get().getLoadOnTop())
        .ifPresent(loadOnTop -> loadableStudy.setLoadOnTop(loadOnTop));
  }

  /** Get on board quantity details corresponding to a loadable study */
  @Override
  public void getOnBoardQuantity(
      OnBoardQuantityRequest request, StreamObserver<OnBoardQuantityReply> responseObserver) {
    OnBoardQuantityReply.Builder replyBuilder = OnBoardQuantityReply.newBuilder();
    try {
      Voyage voyage = this.voyageRepository.findByIdAndIsActive(request.getVoyageId(), true);
      if (null == voyage) {
        throw new GenericServiceException(
            "Voyage does not exist",
            CommonErrorCodes.E_HTTP_BAD_REQUEST,
            HttpStatusCode.BAD_REQUEST);
      }
      Optional<LoadableStudy> loadableStudyOpt =
          this.loadableStudyRepository.findByIdAndIsActive(request.getLoadableStudyId(), true);
      if (!loadableStudyOpt.isPresent()) {
        throw new GenericServiceException(
            "Loadable study does not exist",
            CommonErrorCodes.E_HTTP_BAD_REQUEST,
            HttpStatusCode.BAD_REQUEST);
      }
      VesselReply vesselReply = this.getObqTanks(request);
      replyBuilder.addAllOnBoardQuantity(
          this.buildOnBoardQuantity(
              request, loadableStudyOpt.get(), voyage, vesselReply.getVesselTanksList()));
      replyBuilder.addAllTanks(this.groupTanks(vesselReply.getVesselTanksList()));
      replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS).build());
    } catch (Exception e) {
      log.error("Exception when fetching on board quantities", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage("Exception when fetching on board quantities")
              .setStatus(FAILED)
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  /**
   * Build obq detail objects
   *
   * @param request
   * @param loadableStudy
   * @param vesselTanksList
   * @param replyBuilder
   */
  private List<OnBoardQuantityDetail> buildOnBoardQuantity(
      OnBoardQuantityRequest request,
      LoadableStudy loadableStudy,
      Voyage voyage,
      List<VesselTankDetail> vesselTanksList) {
    List<OnBoardQuantity> obqEntities =
        this.onBoardQuantityRepository.findByLoadableStudyAndPortIdAndIsActive(
            loadableStudy, request.getPortId(), true);
    List<CargoHistory> cargoHistories = null;
    List<OnBoardQuantityDetail> obqDetailList = new ArrayList<>();
    List<VesselTankDetail> modifieableList = new ArrayList<>(vesselTanksList);
    Collections.sort(modifieableList, Comparator.comparing(VesselTankDetail::getTankDisplayOrder));
    for (VesselTankDetail tank : modifieableList) {
      OnBoardQuantityDetail.Builder builder = OnBoardQuantityDetail.newBuilder();
      builder.setTankId(tank.getTankId());
      builder.setTankName(tank.getShortName());
      Optional<OnBoardQuantity> entityOpt =
          obqEntities.stream().filter(e -> e.getTankId().equals(tank.getTankId())).findAny();
      if (entityOpt.isPresent()) {
        OnBoardQuantity entity = entityOpt.get();
        builder.setId(entity.getId());
        Optional.ofNullable(entity.getCargoId()).ifPresent(builder::setCargoId);
        Optional.ofNullable(entity.getSounding())
            .ifPresent(item -> builder.setSounding(item.toString()));
        Optional.ofNullable(entity.getPlannedArrivalWeight())
            .ifPresent(item -> builder.setWeight(item.toString()));
        Optional.ofNullable(entity.getActualArrivalWeight())
            .ifPresent(item -> builder.setActualWeight(item.toString()));
        Optional.ofNullable(entity.getVolume())
            .ifPresent(item -> builder.setVolume(item.toString()));
        Optional.ofNullable(entity.getColorCode()).ifPresent(builder::setColorCode);
        Optional.ofNullable(entity.getAbbreviation()).ifPresent(builder::setAbbreviation);
        Optional.ofNullable(entity.getDensity())
            .ifPresent(item -> builder.setDensity(item.toString()));
      } else {
        // lazy loading the cargo history
        if (null == cargoHistories) {
          cargoHistories = this.findCargoHistoryForPrvsVoyage(voyage);
        }
        Optional<CargoHistory> cargoHistoryOpt =
            cargoHistories.stream().filter(e -> e.getTankId().equals(tank.getTankId())).findAny();
        if (cargoHistoryOpt.isPresent()) {
          CargoHistory dto = cargoHistoryOpt.get();
          Optional.ofNullable(dto.getCargoId()).ifPresent(builder::setCargoId);
          Optional.ofNullable(dto.getCargoColor()).ifPresent(builder::setColorCode);
          Optional.ofNullable(dto.getAbbreviation()).ifPresent(builder::setAbbreviation);
          Optional.ofNullable(dto.getQuantity())
              .ifPresent(item -> builder.setWeight(valueOf(item)));
          Optional.ofNullable(dto.getApi()).ifPresent(item -> builder.setDensity(valueOf(item)));
        }
      }
      obqDetailList.add(builder.build());
    }
    return obqDetailList;
  }

  /**
   * find voyage history for previous voyage
   *
   * @param voyage
   * @return
   */
  private List<CargoHistory> findCargoHistoryForPrvsVoyage(Voyage voyage) {
    if (voyage.getVoyageStartDate() != null && voyage.getVoyageEndDate() != null) {

      VoyageStatus voyageStatus = this.voyageStatusRepository.getOne(CLOSE_VOYAGE_STATUS);

      Voyage previousVoyage =
          this.voyageRepository
              .findFirstByVoyageEndDateLessThanAndVesselXIdAndIsActiveAndVoyageStatusOrderByVoyageEndDateDesc(
                  voyage.getVoyageStartDate(), voyage.getVesselXId(), true, voyageStatus);
      if (null == previousVoyage) {
        log.error("Could not find previous voyage of {}", voyage.getVoyageNo());
      } else {
        VoyageHistory voyageHistory =
            this.voyageHistoryRepository.findFirstByVoyageOrderByPortOrderDesc(previousVoyage);
        if (null == voyageHistory) {
          log.error("Could not find voyage history for voyage: {}", previousVoyage.getVoyageNo());
        } else {
          return this.cargoHistoryRepository.findCargoHistory(
              previousVoyage.getId(), voyageHistory.getLoadingPortId());
        }
      }
    } else {
      log.error(
          "Voyage start/end date for voyage {} not set and hence, cargo history cannot be fetched",
          voyage.getVoyageNo());
    }
    return new ArrayList<>();
  }

  /**
   * Fetch vessel fuel and fresh water tanks
   *
   * @param request
   * @return
   * @throws GenericServiceException
   */
  private VesselReply getObqTanks(OnBoardQuantityRequest request) throws GenericServiceException {
    VesselRequest.Builder vesselGrpcRequest = VesselRequest.newBuilder();
    vesselGrpcRequest.setCompanyId(request.getCompanyId());
    vesselGrpcRequest.setVesselId(request.getVesselId());
    vesselGrpcRequest.addAllTankCategories(CARGO_TANK_CATEGORIES);
    VesselReply vesselReply = this.getVesselTanks(vesselGrpcRequest.build());
    if (!SUCCESS.equals(vesselReply.getResponseStatus().getStatus())) {
      throw new GenericServiceException(
          "Failed to fetch vessel particualrs",
          vesselReply.getResponseStatus().getCode(),
          HttpStatusCode.valueOf(Integer.valueOf(vesselReply.getResponseStatus().getCode())));
    }
    return vesselReply;
  }

  /** Save On board quantity details */
  @Override
  public void saveOnBoardQuantity(
      OnBoardQuantityDetail request, StreamObserver<OnBoardQuantityReply> responseObserver) {
    OnBoardQuantityReply.Builder replyBuilder = OnBoardQuantityReply.newBuilder();
    try {
      Optional<LoadableStudy> loadableStudyOpt =
          this.loadableStudyRepository.findByIdAndIsActive(request.getLoadableStudyId(), true);
      if (!loadableStudyOpt.isPresent()) {
        throw new GenericServiceException(
            "Loadable study does not exist",
            CommonErrorCodes.E_HTTP_BAD_REQUEST,
            HttpStatusCode.BAD_REQUEST);
      }
      OnBoardQuantity entity = null;
      if (request.getId() == 0) {
        entity = new OnBoardQuantity();
        entity.setLoadableStudy(loadableStudyOpt.get());
      } else {
        entity = this.onBoardQuantityRepository.findByIdAndIsActive(request.getId(), true);
        if (null == entity) {
          throw new GenericServiceException(
              "On hand quantity does not exist",
              CommonErrorCodes.E_HTTP_BAD_REQUEST,
              HttpStatusCode.BAD_REQUEST);
        }
      }
      this.checkIfVoyageClosed(entity.getLoadableStudy().getVoyage().getId());
      this.isPatternGeneratedOrConfirmed(entity.getLoadableStudy());

      this.buildOnBoardQuantityEntity(entity, request);
      entity = this.onBoardQuantityRepository.save(entity);
      loadableStudyOpt.get().setIsObqComplete(request.getIsObqComplete());
      loadableStudyOpt.get().setLoadOnTop(request.getLoadOnTop());
      this.loadableStudyRepository.save(loadableStudyOpt.get());
      replyBuilder.setId(entity.getId());
      replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS).build());
    } catch (GenericServiceException e) {
      log.error("GenericServiceException when saving on board quantities", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(e.getCode())
              .setMessage("GenericServiceException when saving on board quantities")
              .setStatus(FAILED)
              .setHttpStatusCode(e.getStatus().value())
              .build());
    } catch (Exception e) {
      log.error("Exception when saving on board quantities", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage("Exception when saving on board quantities")
              .setStatus(FAILED)
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  /**
   * Build on board quantity entity
   *
   * @param entity
   * @param request
   */
  private void buildOnBoardQuantityEntity(OnBoardQuantity entity, OnBoardQuantityDetail request) {
    entity.setCargoId(0 == request.getCargoId() ? null : request.getCargoId());
    entity.setTankId(request.getTankId());
    entity.setPortId(request.getPortId());
    entity.setSounding(
        isEmpty(request.getSounding()) ? null : new BigDecimal(request.getSounding()));
    entity.setPlannedArrivalWeight(
        isEmpty(request.getWeight()) ? null : new BigDecimal(request.getWeight()));
    entity.setVolumeInM3(request.getVolume());
    entity.setColorCode(isEmpty(request.getColorCode()) ? null : request.getColorCode());
    entity.setAbbreviation(isEmpty(request.getAbbreviation()) ? null : request.getAbbreviation());
    entity.setDensity(isEmpty(request.getDensity()) ? null : new BigDecimal(request.getDensity()));
    entity.setIsActive(true);
  }

  /**
   * @param request
   * @param responseObserver
   */
  @Override
  public void saveAlgoLoadableStudyStatus(
      AlgoStatusRequest request, StreamObserver<AlgoStatusReply> responseObserver) {
    AlgoStatusReply.Builder replyBuilder = AlgoStatusReply.newBuilder();
    try {
      log.info("Inside saveAlgoLoadableStudyStatus service");
      Optional<LoadableStudyAlgoStatus> loadableStudyAlgoStatusOpt =
          loadableStudyAlgoStatusRepository.findByProcessIdAndIsActive(
              request.getProcesssId(), true);
      if (!loadableStudyAlgoStatusOpt.isPresent()) {
        log.info("Invalid process id for updating loadable study status");
        replyBuilder.setResponseStatus(
            ResponseStatus.newBuilder()
                .setCode(CommonErrorCodes.E_HTTP_BAD_REQUEST)
                .setMessage("Invalid process Id")
                .build());
      } else {
        log.info(
            "updated algo status with process-id "
                + request.getProcesssId()
                + " to "
                + request.getLoadableStudystatusId());
        loadableStudyAlgoStatusRepository.updateLoadableStudyAlgoStatus(
            request.getLoadableStudystatusId(), request.getProcesssId(), true);
        replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS).build());
      }
    } catch (Exception e) {
      log.error("Exception when saving Algo Loadable Study Status ", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage("Exception when saving Algo Loadable Study Status")
              .setStatus(FAILED)
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
  public void saveSynopticalTable(
      SynopticalTableRequest request, StreamObserver<SynopticalTableReply> responseObserver) {
    SynopticalTableReply.Builder replyBuilder = SynopticalTableReply.newBuilder();
    try {
      Optional<LoadableStudy> loadableStudyOpt =
          this.loadableStudyRepository.findByIdAndIsActive(request.getLoadableStudyId(), true);
      if (!loadableStudyOpt.isPresent()) {
        throw new GenericServiceException(
            "Loadable study does not exist with given id",
            CommonErrorCodes.E_HTTP_BAD_REQUEST,
            HttpStatusCode.BAD_REQUEST);
      }

      this.checkIfVoyageClosed(loadableStudyOpt.get().getVoyage().getId());

      Optional<LoadablePattern> patternOpt = Optional.empty();
      if (request.getLoadablePatternId() > 0) {
        patternOpt =
            this.loadablePatternRepository.findByIdAndIsActive(
                request.getLoadablePatternId(), true);
        if (!patternOpt.isPresent()) {
          throw new GenericServiceException(
              "Loadable pattern does not exist with given id",
              CommonErrorCodes.E_HTTP_BAD_REQUEST,
              HttpStatusCode.BAD_REQUEST);
        }
      }
      for (SynopticalRecord record : request.getSynopticalRecordList()) {
        Optional<SynopticalTable> entityOpt =
            this.synopticalTableRepository.findByIdAndIsActive(record.getId(), true);
        if (!entityOpt.isPresent()) {
          throw new GenericServiceException(
              "Synoptical record does not exist with given id",
              CommonErrorCodes.E_HTTP_BAD_REQUEST,
              HttpStatusCode.BAD_REQUEST);
        }
        SynopticalTable entity = entityOpt.get();
        entity = this.buildSynopticalTableEntity(entity, record);
        entity = this.synopticalTableRepository.save(entity);
        this.saveSynopticalEtaEtdEstimates(entity, record);
        if (request.getLoadablePatternId() > 0) {
          this.saveSynopticalLoadicatorData(entity, request.getLoadablePatternId(), record);
          this.saveSynopticalBallastData(request.getLoadablePatternId(), record, entity);
        }
        this.saveSynopticalCargoData(request, loadableStudyOpt.get(), entity, record);
        this.saveSynopticalOhqData(loadableStudyOpt.get(), entity, record);
      }
      replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS).build());
    } catch (GenericServiceException e) {
      log.error("GenericServiceException when saving synoptical table", e);
      TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(e.getCode())
              .setMessage("GenericServiceException when saving synoptical table")
              .setStatus(FAILED)
              .setHttpStatusCode(e.getStatus().value())
              .build());
    } catch (Exception e) {
      log.error("Exception when saving saving synoptical table", e);
      TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage("Exception when saving synoptical table")
              .setStatus(FAILED)
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  /**
   * Save synoptical ballast data
   *
   * @param loadablePatternId
   * @param record
   * @param entity
   */
  private void saveSynopticalBallastData(
      long loadablePatternId, SynopticalRecord record, SynopticalTable entity) {
    List<LoadablePlanStowageBallastDetails> ballastEntities =
        this.loadablePlanStowageBallastDetailsRepository
            .findByLoadablePatternIdAndPortRotationIdAndOperationTypeAndIsActive(
                loadablePatternId,
                entity.getLoadableStudyPortRotation().getId(),
                entity.getOperationType(),
                true);
    List<LoadablePlanStowageBallastDetails> toBeSaved = new ArrayList<>();
    if (!record.getBallastList().isEmpty()) {
      for (SynopticalBallastRecord rec : record.getBallastList()) {
        Optional<LoadablePlanStowageBallastDetails> entityOpt =
            ballastEntities.stream()
                .filter(b -> b.getTankXId().longValue() == rec.getTankId())
                .findAny();
        if (entityOpt.isPresent()) {
          LoadablePlanStowageBallastDetails ent = entityOpt.get();
          ent.setActualQuantity(
              isEmpty(rec.getActualWeight()) ? null : new BigDecimal(rec.getActualWeight()));
          toBeSaved.add(ent);
        } else {
          LoadablePlanStowageBallastDetails ent = new LoadablePlanStowageBallastDetails();
          ent.setTankXId(rec.getTankId());
          ent.setIsActive(true);
          ent.setLoadablePatternId(loadablePatternId);
          ent.setPortXId(entity.getPortXid());
          ent.setOperationType(entity.getOperationType());
          ent.setPortRotationId(entity.getLoadableStudyPortRotation().getId());
          ent.setActualQuantity(
              isEmpty(rec.getActualWeight()) ? null : new BigDecimal(rec.getActualWeight()));
          toBeSaved.add(ent);
        }
      }
      this.loadablePlanStowageBallastDetailsRepository.saveAll(toBeSaved);
    }
  }

  private void saveSynopticalOhqData(
      LoadableStudy loadableStudy, SynopticalTable entity, SynopticalRecord record)
      throws GenericServiceException {
    List<OnHandQuantity> ohqEntities =
        this.onHandQuantityRepository.findByLoadableStudyAndPortRotationAndIsActive(
            loadableStudy, entity.getLoadableStudyPortRotation(), true);
    List<OnHandQuantity> toBeSavedList = new ArrayList<>();

    for (SynopticalOhqRecord ohqRecord : record.getOhqList()) {
      OnHandQuantity ohqEntity = null;
      Optional<OnHandQuantity> ohqEntityOpt =
          ohqEntities.stream()
              .filter(ohq -> ohq.getTankXId().equals(ohqRecord.getTankId()))
              .findAny();
      if (ohqEntityOpt.isPresent()) {
        ohqEntity = ohqEntityOpt.get();
      } else {

        ohqEntity = new OnHandQuantity();
        ohqEntity.setTankXId(ohqRecord.getTankId());
        ohqEntity.setPortXId(record.getPortId());
        ohqEntity.setFuelTypeXId(ohqRecord.getFuelTypeId());
        ohqEntity.setLoadableStudy(loadableStudy);
        ohqEntity.setPortRotation(entity.getLoadableStudyPortRotation());
        ohqEntity.setIsActive(true);
      }
      this.validateSaveSynopticalOhqData(ohqEntity, entity, ohqRecord, loadableStudy);

      if (SYNOPTICAL_TABLE_OP_TYPE_ARRIVAL.equals(entity.getOperationType())) {
        ohqEntity.setArrivalQuantity(
            isEmpty(ohqRecord.getPlannedWeight())
                ? null
                : new BigDecimal(ohqRecord.getPlannedWeight()));
        ohqEntity.setActualArrivalQuantity(
            isEmpty(ohqRecord.getActualWeight())
                ? null
                : new BigDecimal(ohqRecord.getActualWeight()));
      } else {
        ohqEntity.setDepartureQuantity(
            isEmpty(ohqRecord.getPlannedWeight())
                ? null
                : new BigDecimal(ohqRecord.getPlannedWeight()));
        ohqEntity.setActualDepartureQuantity(
            isEmpty(ohqRecord.getActualWeight())
                ? null
                : new BigDecimal(ohqRecord.getActualWeight()));
      }
      toBeSavedList.add(ohqEntity);
    }
    if (!toBeSavedList.isEmpty()) {
      this.onHandQuantityRepository.saveAll(toBeSavedList);
    }
  }

  /**
   * Save cargo data
   *
   * @param request
   * @param loadableStudy
   * @param entity
   * @param request
   * @throws GenericServiceException
   */
  private void saveSynopticalCargoData(
      SynopticalTableRequest request,
      LoadableStudy loadableStudy,
      SynopticalTable entity,
      SynopticalRecord record)
      throws GenericServiceException {
    List<Long> portIds = this.getPortRoationPortIds(loadableStudy);
    if (null == portIds || portIds.isEmpty()) {
      throw new GenericServiceException(
          "No ports added for loadable study with id: " + loadableStudy.getId(),
          CommonErrorCodes.E_HTTP_BAD_REQUEST,
          HttpStatusCode.BAD_REQUEST);
    }
    Long firstPortId = portIds.get(0);
    if (entity.getPortXid().equals(firstPortId)
        && SYNOPTICAL_TABLE_OP_TYPE_ARRIVAL.equals(entity.getOperationType())) {
      this.saveSynopticalObqData(loadableStudy, record);
    } else if (request.getLoadablePatternId() > 0) {
      this.saveSynopticalCargoByLoadablePattern(request, entity, record);
    }
  }

  /**
   * Save synoptical cargo data by loadable pattern id
   *
   * @param request
   * @param entity
   * @param record
   */
  private void saveSynopticalCargoByLoadablePattern(
      SynopticalTableRequest request, SynopticalTable entity, SynopticalRecord record) {
    List<com.cpdss.loadablestudy.entity.LoadablePatternCargoDetails> cargoEntities =
        this.loadablePatternCargoDetailsRepository
            .findByLoadablePatternIdAndPortRotationIdAndOperationTypeAndIsActive(
                request.getLoadablePatternId(),
                entity.getLoadableStudyPortRotation().getId(),
                entity.getOperationType(),
                true);
    List<com.cpdss.loadablestudy.entity.LoadablePatternCargoDetails> toBeSavedCargoList =
        new ArrayList<>();
    for (SynopticalCargoRecord cargoRecord : record.getCargoList()) {
      Optional<com.cpdss.loadablestudy.entity.LoadablePatternCargoDetails> entityOpt =
          cargoEntities.stream()
              .filter(cargo -> cargo.getTankId().equals(cargoRecord.getTankId()))
              .findAny();
      if (entityOpt.isPresent()) {
        com.cpdss.loadablestudy.entity.LoadablePatternCargoDetails cargoEntity = entityOpt.get();
        cargoEntity.setActualQuantity(
            isEmpty(cargoRecord.getActualWeight())
                ? null
                : new BigDecimal(cargoRecord.getActualWeight()));
        toBeSavedCargoList.add(cargoEntity);
      } else {
        com.cpdss.loadablestudy.entity.LoadablePatternCargoDetails cargoEntity =
            new com.cpdss.loadablestudy.entity.LoadablePatternCargoDetails();
        cargoEntity.setLoadablePatternId(request.getLoadablePatternId());
        cargoEntity.setPortId(entity.getPortXid());
        cargoEntity.setTankId(cargoRecord.getTankId());
        cargoEntity.setIsActive(true);
        cargoEntity.setOperationType(entity.getOperationType());
        cargoEntity.setPortRotationId(entity.getLoadableStudyPortRotation().getId());
        cargoEntity.setActualQuantity(
            isEmpty(cargoRecord.getActualWeight())
                ? null
                : new BigDecimal(cargoRecord.getActualWeight()));
        toBeSavedCargoList.add(cargoEntity);
      }
    }
    if (!toBeSavedCargoList.isEmpty()) {
      this.loadablePatternCargoDetailsRepository.saveAll(toBeSavedCargoList);
    }
  }

  /**
   * Save obq data from synoptical table
   *
   * @param loadableStudy
   * @param record
   * @throws GenericServiceException
   */
  private void saveSynopticalObqData(LoadableStudy loadableStudy, SynopticalRecord record)
      throws GenericServiceException {
    List<OnBoardQuantity> obqEntities =
        this.onBoardQuantityRepository.findByLoadableStudyAndPortIdAndIsActive(
            loadableStudy, record.getPortId(), true);
    List<OnBoardQuantity> toBeSavedList = new ArrayList<>();

    for (SynopticalCargoRecord cargoRecord : record.getCargoList()) {

      OnBoardQuantity obqEntity = null;
      Optional<OnBoardQuantity> obqEntityOpt =
          obqEntities.stream()
              .filter(obq -> obq.getTankId().equals(cargoRecord.getTankId()))
              .findAny();
      if (obqEntityOpt.isPresent()) {

        obqEntity = obqEntityOpt.get();

      } else {
        obqEntity = new OnBoardQuantity();
        obqEntity.setTankId(cargoRecord.getTankId());
        obqEntity.setPortId(record.getPortId());
        obqEntity.setLoadableStudy(loadableStudy);
        obqEntity.setIsActive(true);
      }

      this.validateSaveSynopticalObqData(obqEntity, cargoRecord, loadableStudy);

      obqEntity.setPlannedArrivalWeight(
          isEmpty(cargoRecord.getPlannedWeight())
              ? null
              : new BigDecimal(cargoRecord.getPlannedWeight()));
      obqEntity.setActualArrivalWeight(
          isEmpty(cargoRecord.getActualWeight())
              ? null
              : new BigDecimal(cargoRecord.getActualWeight()));
      toBeSavedList.add(obqEntity);
    }
    if (!toBeSavedList.isEmpty()) {
      this.onBoardQuantityRepository.saveAll(toBeSavedList);
    }
  }

  /**
   * Save synoptical table loadicator data
   *
   * @param entity
   * @param entity
   * @param request
   * @throws GenericServiceException
   */
  public void saveSynopticalLoadicatorData(
      SynopticalTable entity, Long loadablepatternId, SynopticalRecord record)
      throws GenericServiceException {
    com.cpdss.common.generated.LoadableStudy.SynopticalTableLoadicatorData data =
        record.getLoadicatorData();
    SynopticalTableLoadicatorData ldEntity =
        this.synopticalTableLoadicatorDataRepository
            .findBySynopticalTableAndLoadablePatternIdAndIsActive(entity, loadablepatternId, true);
    if (null == ldEntity) {
      log.info(
          "Loadicator data does not exist for given synoptical record with id {}", record.getId());
    } else {
      ldEntity.setHog(isEmpty(data.getHogSag()) ? null : new BigDecimal(data.getHogSag()));
      ldEntity.setCalculatedDraftFwdActual(
          isEmpty(data.getCalculatedDraftFwdActual())
              ? null
              : new BigDecimal(data.getCalculatedDraftFwdActual()));
      ldEntity.setCalculatedDraftAftActual(
          isEmpty(data.getCalculatedDraftAftActual())
              ? null
              : new BigDecimal(data.getCalculatedDraftAftActual()));
      ldEntity.setCalculatedDraftMidActual(
          isEmpty(data.getCalculatedDraftMidActual())
              ? null
              : new BigDecimal(data.getCalculatedDraftMidActual()));
      ldEntity.setCalculatedTrimActual(
          isEmpty(data.getCalculatedTrimActual())
              ? null
              : new BigDecimal(data.getCalculatedTrimActual()));
      ldEntity.setBlindSector(
          isEmpty(data.getBlindSector()) ? null : new BigDecimal(data.getBlindSector()));
      ldEntity.setBallastActual(
          isEmpty(record.getBallastActual()) ? null : new BigDecimal(record.getBallastActual()));
      this.synopticalTableLoadicatorDataRepository.save(ldEntity);
    }
  }

  /**
   * Update estimated values to port rotation table
   *
   * @param entity
   * @param request
   * @throws GenericServiceException
   */
  public void saveSynopticalEtaEtdEstimates(SynopticalTable entity, SynopticalRecord record)
      throws GenericServiceException {

    LoadableStudyPortRotation prEntity = entity.getLoadableStudyPortRotation();
    if (null == prEntity) {
      throw new GenericServiceException(
          "Port rotation does not exist for given synoptical record",
          CommonErrorCodes.E_HTTP_BAD_REQUEST,
          HttpStatusCode.BAD_REQUEST);
    }

    Optional<LoadableStudy> loadableStudy =
        this.loadableStudyRepository.findByIdAndIsActive(entity.getLoadableStudyXId(), true);
    if (!loadableStudy.isPresent()) {
      throw new GenericServiceException(
          "Loadable study with given id does not exist",
          CommonErrorCodes.E_HTTP_BAD_REQUEST,
          HttpStatusCode.BAD_REQUEST);
    }

    this.validateSaveSynopticalEtaEtdEstimates(entity, record, loadableStudy.get(), prEntity);

    LocalDateTime etaEtdEstimated =
        isEmpty(record.getEtaEtdEstimated())
            ? null
            : LocalDateTime.from(
                DateTimeFormatter.ofPattern(ETA_ETD_FORMAT).parse(record.getEtaEtdEstimated()));
    if (SYNOPTICAL_TABLE_OP_TYPE_ARRIVAL.equals(entity.getOperationType())) {
      prEntity.setEta(etaEtdEstimated);
    } else {
      prEntity.setEtd(etaEtdEstimated);
    }
    this.loadableStudyPortRotationRepository.save(prEntity);
  }

  /**
   * Populate synoptical entity fields
   *
   * @param entity
   * @param request
   * @return
   * @throws GenericServiceException
   */
  public SynopticalTable buildSynopticalTableEntity(SynopticalTable entity, SynopticalRecord record)
      throws GenericServiceException {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
    entity.setDistance(isEmpty(record.getDistance()) ? null : new BigDecimal(record.getDistance()));
    entity.setSpeed(isEmpty(record.getSpeed()) ? null : new BigDecimal(record.getSpeed()));
    entity.setRunningHours(
        isEmpty(record.getRunningHours()) ? null : new BigDecimal(record.getRunningHours()));
    entity.setInPortHours(
        isEmpty(record.getInPortHours()) ? null : new BigDecimal(record.getInPortHours()));
    entity.setTimeOfSunrise(
        isEmpty(record.getTimeOfSunrise())
            ? null
            : LocalTime.from(dtf.parse(record.getTimeOfSunrise())));
    entity.setTimeOfSunSet(
        isEmpty(record.getTimeOfSunset())
            ? null
            : LocalTime.from(dtf.parse(record.getTimeOfSunset())));

    entity.setSpecificGravity(
        isEmpty(record.getSpecificGravity()) ? null : new BigDecimal(record.getSpecificGravity()));
    entity.setHwTideFrom(
        isEmpty(record.getHwTideFrom()) ? null : new BigDecimal(record.getHwTideFrom()));
    entity.setHwTideTo(isEmpty(record.getHwTideTo()) ? null : new BigDecimal(record.getHwTideTo()));
    entity.setLwTideFrom(
        isEmpty(record.getLwTideFrom()) ? null : new BigDecimal(record.getLwTideFrom()));
    entity.setLwTideTo(isEmpty(record.getLwTideTo()) ? null : new BigDecimal(record.getLwTideTo()));
    entity.setHwTideTimeFrom(
        isEmpty(record.getHwTideTimeFrom())
            ? null
            : LocalTime.from(dtf.parse(record.getHwTideTimeFrom())));
    entity.setHwTideTimeTo(
        isEmpty(record.getHwTideTimeTo())
            ? null
            : LocalTime.from(dtf.parse(record.getHwTideTimeTo())));
    entity.setLwTideTimeFrom(
        isEmpty(record.getLwTideTimeFrom())
            ? null
            : LocalTime.from(dtf.parse(record.getLwTideTimeFrom())));
    entity.setLwTideTimeTo(
        isEmpty(record.getLwTideTimeTo())
            ? null
            : LocalTime.from(dtf.parse(record.getLwTideTimeTo())));
    this.buidlSynopticalTableVesselData(entity, record);
    this.buildSynopticalTableEtaEtdActuals(entity, record);
    return entity;
  }

  /**
   * Set vessel particular data in synoptical table
   *
   * @param entity
   * @param record
   * @throws GenericServiceException
   */
  private void buidlSynopticalTableVesselData(SynopticalTable entity, SynopticalRecord record)
      throws GenericServiceException {

    Optional<LoadableStudy> loadableStudy =
        this.loadableStudyRepository.findByIdAndIsActive(entity.getLoadableStudyXId(), true);
    if (!loadableStudy.isPresent()) {
      throw new GenericServiceException(
          "Loadable study with given id does not exist",
          CommonErrorCodes.E_HTTP_BAD_REQUEST,
          HttpStatusCode.BAD_REQUEST);
    }

    this.validateSynopticalVesselData(loadableStudy.get(), entity, record);

    entity.setOthersPlanned(
        isEmpty(record.getOthersPlanned()) ? null : new BigDecimal(record.getOthersPlanned()));
    entity.setOthersActual(
        isEmpty(record.getOthersActual()) ? null : new BigDecimal(record.getOthersActual()));
    entity.setConstantPlanned(
        isEmpty(record.getConstantPlanned()) ? null : new BigDecimal(record.getConstantPlanned()));
    entity.setConstantActual(
        isEmpty(record.getConstantActual()) ? null : new BigDecimal(record.getConstantActual()));
    entity.setDeadWeightPlanned(
        isEmpty(record.getTotalDwtPlanned()) ? null : new BigDecimal(record.getTotalDwtPlanned()));
    entity.setDeadWeightActual(
        isEmpty(record.getTotalDwtActual()) ? null : new BigDecimal(record.getTotalDwtActual()));
    entity.setDisplacementPlanned(
        isEmpty(record.getDisplacementPlanned())
            ? null
            : new BigDecimal(record.getDisplacementPlanned()));
    entity.setDisplacementActual(
        isEmpty(record.getDisplacementActual())
            ? null
            : new BigDecimal(record.getDisplacementActual()));
  }

  /**
   * build eta etd actuals
   *
   * @param entity
   * @param record
   */
  public void buildSynopticalTableEtaEtdActuals(SynopticalTable entity, SynopticalRecord record) {
    LocalDateTime etaEtdActual =
        isEmpty(record.getEtaEtdActual())
            ? null
            : LocalDateTime.from(
                DateTimeFormatter.ofPattern(ETA_ETD_FORMAT).parse(record.getEtaEtdActual()));
    if (SYNOPTICAL_TABLE_OP_TYPE_ARRIVAL.equals(entity.getOperationType())) {
      entity.setEtaActual(etaEtdActual);
    } else {
      entity.setEtdActual(etaEtdActual);
    }
  }

  @Override
  public void getSynopticalTable(
      SynopticalTableRequest request, StreamObserver<SynopticalTableReply> responseObserver) {
    SynopticalTableReply.Builder replyBuilder = SynopticalTableReply.newBuilder();
    try {
      Optional<LoadableStudy> loadableStudyOpt =
          this.loadableStudyRepository.findById(request.getLoadableStudyId());
      if (!loadableStudyOpt.isPresent()) {
        throw new GenericServiceException(
            "Loadable study does not exist", CommonErrorCodes.E_HTTP_BAD_REQUEST, null);
      }
      List<SynopticalTable> synopticalTableList =
          this.synopticalTableRepository.findByLoadableStudyXIdAndIsActive(
              request.getLoadableStudyId(), true);
      if (!synopticalTableList.isEmpty()) {
        VesselReply vesselReply =
            this.getSynopticalTableVesselData(request, loadableStudyOpt.get());
        List<VesselTankDetail> sortedTankList = new ArrayList<>(vesselReply.getVesselTanksList());
        Collections.sort(
            sortedTankList, Comparator.comparing(VesselTankDetail::getTankDisplayOrder));
        buildSynopticalTableReply(
            request,
            synopticalTableList,
            this.getSynopticalTablePortDetails(synopticalTableList),
            this.getSynopticalTablePortRotations(loadableStudyOpt.get()),
            loadableStudyOpt.get(),
            sortedTankList,
            vesselReply.getVesselLoadableQuantityDetails(),
            replyBuilder);
      }
      replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS));
    } catch (GenericServiceException e) {
      log.error("GenericServiceException when fetching synoptical table", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(e.getCode())
              .setMessage(e.getMessage())
              .setStatus(FAILED)
              .build());
    } catch (Exception e) {
      log.error("Exception when fetching synoptical table", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage("Exception when fetching synoptical table")
              .setStatus(FAILED)
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  /**
   * Fetch port details for synoptical table
   *
   * @param synopticalTableList
   * @return
   * @throws GenericServiceException
   */
  private PortReply getSynopticalTablePortDetails(List<SynopticalTable> synopticalTableList)
      throws GenericServiceException {
    GetPortInfoByPortIdsRequest.Builder portReqBuilder = GetPortInfoByPortIdsRequest.newBuilder();
    buildPortIdsRequestSynoptical(portReqBuilder, synopticalTableList);
    PortReply portReply = this.getPortInfo(portReqBuilder.build());
    if (portReply != null
        && portReply.getResponseStatus() != null
        && !SUCCESS.equalsIgnoreCase(portReply.getResponseStatus().getStatus())) {
      throw new GenericServiceException(
          "Error in calling port service within getSynopticalTable",
          CommonErrorCodes.E_GEN_INTERNAL_ERR,
          HttpStatusCode.INTERNAL_SERVER_ERROR);
    }
    return portReply;
  }

  /**
   * Build port request to fetch port related fields from port master
   *
   * @param portReqBuilder
   * @param synopticalTableList
   */
  private void buildPortIdsRequestSynoptical(
      com.cpdss.common.generated.PortInfo.GetPortInfoByPortIdsRequest.Builder portReqBuilder,
      List<SynopticalTable> synopticalTableList) {
    // build fetch port details request object
    if (!CollectionUtils.isEmpty(synopticalTableList)) {
      synopticalTableList.forEach(
          synopticalRecord ->
              Optional.ofNullable(synopticalRecord.getPortXid()).ifPresent(portReqBuilder::addId));
    }
  }

  /**
   * Get port rotation details for synoptical table
   *
   * @param loadableStudyId
   * @return
   */
  private List<LoadableStudyPortRotation> getSynopticalTablePortRotations(
      LoadableStudy loadableStudy) {
    return this.loadableStudyPortRotationRepository.findByLoadableStudyAndIsActiveOrderByPortOrder(
        loadableStudy, true);
  }

  /**
   * Build Synoptical records for synoptical table
   *
   * @param request
   * @param synopticalTableList
   * @param portReply
   * @param vesselLoadableQuantityDetails
   * @param vesselReply
   * @param vesselReply
   * @param replyBuilder
   */
  private void buildSynopticalTableReply(
      SynopticalTableRequest request,
      List<SynopticalTable> synopticalTableList,
      PortReply portReply,
      List<LoadableStudyPortRotation> portRotations,
      LoadableStudy loadableStudy,
      List<VesselTankDetail> sortedTankList,
      VesselLoadableQuantityDetails vesselLoadableQuantityDetails,
      SynopticalTableReply.Builder replyBuilder) {
    if (!CollectionUtils.isEmpty(synopticalTableList) && !CollectionUtils.isEmpty(portRotations)) {
      Long firstPortId = portRotations.get(0).getPortXId();
      // first port arrival condition data will be same as the data in obq
      List<OnBoardQuantity> obqEntities =
          this.onBoardQuantityRepository.findByLoadableStudyAndPortIdAndIsActive(
              loadableStudy, firstPortId, true);
      // fething entire ohq entities based on loadable study
      List<OnHandQuantity> ohqEntities =
          this.onHandQuantityRepository.findByLoadableStudyAndIsActive(loadableStudy, true);
      List<SynopticalRecord> records = new ArrayList<>();
      List<com.cpdss.loadablestudy.entity.LoadablePatternCargoDetails> cargoDetails = null;
      List<LoadablePlanStowageBallastDetails> ballastDetails = new ArrayList<>();
      // if there is loadable pattern selected, fetch corresponding loadicator and
      // ballast data of
      // all ports
      if (request.getLoadablePatternId() > 0) {
        cargoDetails =
            this.loadablePatternCargoDetailsRepository.findByLoadablePatternIdAndIsActive(
                request.getLoadablePatternId(), true);
        ballastDetails.addAll(
            this.loadablePlanStowageBallastDetailsRepository.findByLoadablePatternIdAndIsActive(
                request.getLoadablePatternId(), true));
      }
      for (SynopticalTable synopticalEntity : synopticalTableList) {
        SynopticalRecord.Builder builder = SynopticalRecord.newBuilder();
        this.buildSynopticalRecord(synopticalEntity, builder, portReply);
        // set eta/etd estamted values from port rotation table
        this.setSynopticalEtaEtdEstimated(synopticalEntity, builder, portRotations);
        this.setSynopticalCargoDetails(
            request,
            cargoDetails,
            obqEntities,
            synopticalEntity,
            builder,
            sortedTankList,
            firstPortId,
            loadableStudy.getVoyage());
        this.setSynopticalOhqData(ohqEntities, synopticalEntity, builder, sortedTankList);
        this.setSynopticalTableVesselParticulars(
            synopticalEntity, builder, vesselLoadableQuantityDetails);
        if (request.getLoadablePatternId() > 0) {
          this.setSynopticalTableLoadicatorData(
              synopticalEntity, request.getLoadablePatternId(), builder);
          this.setBallastDetails(
              synopticalEntity,
              builder,
              ballastDetails,
              sortedTankList,
              request.getLoadablePatternId());
        }
        if (synopticalEntity.getPortXid() != null && synopticalEntity.getPortXid() > 0) {
          this.setPortDetailForSynoptics(synopticalEntity, builder);
        }
        records.add(builder.build());
      }
      Collections.sort(
          records,
          Comparator.comparing(SynopticalRecord::getPortOrder)
              .thenComparing(Comparator.comparing(SynopticalRecord::getOperationType)));
      replyBuilder.addAllSynopticalRecords(records);
    }
  }

  /**
   * Fetch Single Port Details
   *
   * @param synoptics
   * @param builder
   */
  private void setPortDetailForSynoptics(
      SynopticalTable synoptics, SynopticalRecord.Builder builder) {
    PortInfo.PortReply reply =
        portInfoGrpcService.getPortInfoByPortIds(
            PortInfo.GetPortInfoByPortIdsRequest.newBuilder()
                .addId(synoptics.getPortXid())
                .build());
    if (!reply.getPortsList().isEmpty()) { // Expect single entry as response
      builder.setPortTimezoneId(reply.getPortsList().get(0).getTimezoneId());
    }
  }

  /**
   * Set ballast details
   *
   * @param synopticalEntity
   * @param builder
   * @param ballastDetails
   * @param sortedTankList
   * @param paatternId
   */
  private void setBallastDetails(
      SynopticalTable synopticalEntity,
      com.cpdss.common.generated.LoadableStudy.SynopticalRecord.Builder builder,
      List<LoadablePlanStowageBallastDetails> ballastDetails,
      List<VesselTankDetail> sortedTankList,
      Long paatternId) {
    List<LoadablePlanStowageBallastDetails> portBallastList = new ArrayList<>();
    portBallastList.addAll(
        ballastDetails.stream()
            .filter(
                bd ->
                    synopticalEntity.getPortXid().equals(bd.getPortXId())
                        && synopticalEntity.getOperationType().equals(bd.getOperationType()))
            .collect(Collectors.toList()));

    for (VesselTankDetail tank : sortedTankList) {
      if (!BALLAST_TANK_CATEGORY_ID.equals(tank.getTankCategoryId())) {
        continue;
      }
      SynopticalBallastRecord.Builder ballastBuilder = SynopticalBallastRecord.newBuilder();
      ballastBuilder.setTankId(tank.getTankId());
      ballastBuilder.setTankName(tank.getShortName());
      ballastBuilder.setCapacity(tank.getFullCapacityCubm());
      Optional<LoadablePlanStowageBallastDetails> tankBallastDetail =
          portBallastList.stream()
              .filter(b -> b.getTankXId().longValue() == tank.getTankId())
              .findAny();
      if (tankBallastDetail.isPresent()) {
        LoadablePlanStowageBallastDetails ballast = tankBallastDetail.get();
        Optional.ofNullable(ballast.getQuantity())
            .ifPresent(item -> ballastBuilder.setPlannedWeight(valueOf(item)));
        Optional.ofNullable(ballast.getActualQuantity())
            .ifPresent(item -> ballastBuilder.setActualWeight(valueOf(item)));
        Optional.ofNullable(ballast.getCorrectedUllage())
            .ifPresent(ullage -> ballastBuilder.setCorrectedUllage(ullage));
        Optional.ofNullable(ballast.getSg()).ifPresent(sg -> ballastBuilder.setSpGravity(sg));
        Optional.ofNullable(ballast.getColorCode())
            .ifPresent(colorCode -> ballastBuilder.setColorCode(colorCode));
      } else {
        log.info(
            "Ballast details not available for the tank: {}, pattern: {}",
            tank.getTankId(),
            paatternId);
      }
      builder.addBallast(ballastBuilder.build());
    }
  }

  /**
   * Set loadicator data in synoptical table record
   *
   * @param synopticalEntity
   * @param builder
   */
  private void setSynopticalTableLoadicatorData(
      SynopticalTable synopticalEntity,
      Long loadablePatternId,
      com.cpdss.common.generated.LoadableStudy.SynopticalRecord.Builder builder) {
    SynopticalTableLoadicatorData loadicatorData =
        this.synopticalTableLoadicatorDataRepository
            .findBySynopticalTableAndLoadablePatternIdAndIsActive(
                synopticalEntity, loadablePatternId, true);
    if (null != loadicatorData) {
      com.cpdss.common.generated.LoadableStudy.SynopticalTableLoadicatorData.Builder dataBuilder =
          com.cpdss.common.generated.LoadableStudy.SynopticalTableLoadicatorData.newBuilder();
      Optional.ofNullable(loadicatorData.getBlindSector())
          .ifPresent(item -> dataBuilder.setBlindSector(valueOf(item)));
      Optional.ofNullable(loadicatorData.getHog())
          .ifPresent(item -> dataBuilder.setHogSag(valueOf(item)));
      Optional.ofNullable(loadicatorData.getCalculatedDraftAftActual())
          .ifPresent(item -> dataBuilder.setCalculatedDraftAftActual(valueOf(item)));
      Optional.ofNullable(loadicatorData.getCalculatedDraftAftPlanned())
          .ifPresent(item -> dataBuilder.setCalculatedDraftAftPlanned(valueOf(item)));
      Optional.ofNullable(loadicatorData.getCalculatedDraftFwdActual())
          .ifPresent(item -> dataBuilder.setCalculatedDraftFwdActual(valueOf(item)));
      Optional.ofNullable(loadicatorData.getCalculatedDraftFwdPlanned())
          .ifPresent(item -> dataBuilder.setCalculatedDraftFwdPlanned(valueOf(item)));
      Optional.ofNullable(loadicatorData.getCalculatedDraftMidActual())
          .ifPresent(item -> dataBuilder.setCalculatedDraftMidActual(valueOf(item)));
      Optional.ofNullable(loadicatorData.getCalculatedDraftMidPlanned())
          .ifPresent(item -> dataBuilder.setCalculatedDraftMidPlanned(valueOf(item)));
      Optional.ofNullable(loadicatorData.getCalculatedTrimActual())
          .ifPresent(item -> dataBuilder.setCalculatedTrimActual(valueOf(item)));
      Optional.ofNullable(loadicatorData.getCalculatedTrimPlanned())
          .ifPresent(item -> dataBuilder.setCalculatedTrimPlanned(valueOf(item)));
      this.setFinalDraftValues(dataBuilder, loadicatorData);
      Optional.ofNullable(loadicatorData.getList())
          .ifPresent(list -> dataBuilder.setList(valueOf(list)));
      builder.setLoadicatorData(dataBuilder.build());
      Optional.ofNullable(loadicatorData.getBallastActual())
          .ifPresent(item -> builder.setBallastActual(valueOf(item)));
    } else {
      log.info("loadicator data does not exist for loadable patter with id {}", loadablePatternId);
    }
  }

  /**
   * Set final draft values
   *
   * @param dataBuilder
   * @param loadicatorData
   */
  private void setFinalDraftValues(
      com.cpdss.common.generated.LoadableStudy.SynopticalTableLoadicatorData.Builder dataBuilder,
      SynopticalTableLoadicatorData loadicatorData) {
    BigDecimal hog = BigDecimal.ZERO;
    if (null != loadicatorData.getHog()) {
      hog = loadicatorData.getHog();
    }
    BigDecimal calculatedDraftFwd = BigDecimal.ZERO;
    if (null != loadicatorData.getCalculatedDraftFwdActual()) {
      calculatedDraftFwd = loadicatorData.getCalculatedDraftFwdActual();
    } else if (null != loadicatorData.getCalculatedDraftFwdPlanned()) {
      calculatedDraftFwd = loadicatorData.getCalculatedDraftFwdPlanned();
    }
    BigDecimal calculatedDraftAft = BigDecimal.ZERO;
    if (null != loadicatorData.getCalculatedDraftAftActual()) {
      calculatedDraftAft = loadicatorData.getCalculatedDraftAftActual();
    } else if (null != loadicatorData.getCalculatedDraftAftPlanned()) {
      calculatedDraftAft = loadicatorData.getCalculatedDraftAftPlanned();
    }
    BigDecimal calculatedDraftMid = BigDecimal.ZERO;
    if (null != loadicatorData.getCalculatedDraftMidActual()) {
      calculatedDraftMid = loadicatorData.getCalculatedDraftMidActual();
    } else if (null != loadicatorData.getCalculatedDraftMidPlanned()) {
      calculatedDraftMid = loadicatorData.getCalculatedDraftMidPlanned();
    }
    dataBuilder.setFinalDraftAft(valueOf(hog.add(calculatedDraftAft)));
    dataBuilder.setFinalDraftFwd(valueOf(hog.add(calculatedDraftFwd)));
    dataBuilder.setFinalDraftMid(valueOf(hog.add(calculatedDraftMid)));
  }

  /**
   * Set vessel particular data
   *
   * @param synopticalEntity
   * @param builder
   * @param vesselLoadableQuantityDetails
   */
  private void setSynopticalTableVesselParticulars(
      SynopticalTable synopticalEntity,
      SynopticalRecord.Builder builder,
      VesselLoadableQuantityDetails vesselLoadableQuantityDetails) {
    Optional.ofNullable(synopticalEntity.getOthersPlanned())
        .ifPresent(item -> builder.setOthersPlanned(valueOf(item)));
    Optional.ofNullable(synopticalEntity.getOthersActual())
        .ifPresent(item -> builder.setOthersActual(valueOf(item)));
    builder.setConstantPlanned(vesselLoadableQuantityDetails.getConstant());
    Optional.ofNullable(synopticalEntity.getConstantPlanned())
        .ifPresent(item -> builder.setConstantPlanned(valueOf(item)));
    Optional.ofNullable(synopticalEntity.getConstantActual())
        .ifPresent(item -> builder.setConstantActual(valueOf(item)));
    builder.setTotalDwtPlanned(vesselLoadableQuantityDetails.getDwt());
    Optional.ofNullable(synopticalEntity.getDeadWeightPlanned())
        .ifPresent(item -> builder.setTotalDwtPlanned(valueOf(item)));
    Optional.ofNullable(synopticalEntity.getDeadWeightActual())
        .ifPresent(item -> builder.setTotalDwtActual(valueOf(item)));
    builder.setDisplacementPlanned(vesselLoadableQuantityDetails.getDisplacmentDraftRestriction());
    Optional.ofNullable(synopticalEntity.getDisplacementPlanned())
        .ifPresent(item -> builder.setDisplacementPlanned(valueOf(item)));
    Optional.ofNullable(synopticalEntity.getDisplacementActual())
        .ifPresent(item -> builder.setDisplacementActual(valueOf(item)));
  }

  /**
   * Set ohq data
   *
   * @param ohqEntities
   * @param synopticalEntity
   * @param builder
   * @param sortedTankList
   */
  private void setSynopticalOhqData(
      List<OnHandQuantity> ohqEntities,
      SynopticalTable synopticalEntity,
      SynopticalRecord.Builder builder,
      List<VesselTankDetail> sortedTankList) {
    List<OnHandQuantity> portSpecificEntities =
        ohqEntities.stream()
            .filter(
                entity ->
                    null != entity.getPortRotation()
                        && entity
                            .getPortRotation()
                            .getId()
                            .equals(synopticalEntity.getLoadableStudyPortRotation().getId()))
            .collect(Collectors.toList());
    for (VesselTankDetail tank : sortedTankList) {
      if (!OHQ_TANK_CATEGORIES.contains(tank.getTankCategoryId()) || !tank.getShowInOhqObq()) {
        continue;
      }
      SynopticalOhqRecord.Builder ohqBuilder = SynopticalOhqRecord.newBuilder();
      ohqBuilder.setTankId(tank.getTankId());
      ohqBuilder.setTankName(tank.getShortName());
      ohqBuilder.setFuelTypeId(tank.getTankCategoryId());
      ohqBuilder.setFuelType(tank.getTankCategoryShortName());
      ohqBuilder.setCapacity(tank.getFullCapacityCubm());
      ohqBuilder.setPortRotationId(synopticalEntity.getLoadableStudyPortRotation().getId());
      Optional<OnHandQuantity> ohqOpt =
          portSpecificEntities.stream()
              .filter(ohq -> ohq.getTankXId().equals(tank.getTankId()))
              .findAny();
      if (ohqOpt.isPresent()) {
        OnHandQuantity ohq = ohqOpt.get();
        if (null != ohq.getDensity()) {
          ohqBuilder.setDensity(valueOf(ohq.getDensity()));
        }
        if (synopticalEntity.getOperationType().equals(SYNOPTICAL_TABLE_OP_TYPE_ARRIVAL)) {
          if (null != ohq.getArrivalQuantity()) {
            ohqBuilder.setPlannedWeight(valueOf(ohq.getArrivalQuantity()));
          }
          if (null != ohq.getActualArrivalQuantity()) {
            ohqBuilder.setActualWeight(valueOf(ohq.getActualArrivalQuantity()));
          }
        } else if (synopticalEntity.getOperationType().equals(SYNOPTICAL_TABLE_OP_TYPE_DEPARTURE)) {
          if (null != ohq.getDepartureQuantity()) {
            ohqBuilder.setPlannedWeight(valueOf(ohq.getDepartureQuantity()));
          }
          if (null != ohq.getActualDepartureQuantity()) {
            ohqBuilder.setActualWeight(valueOf(ohq.getActualDepartureQuantity()));
          }
        }
      }
      builder.addOhq(ohqBuilder.build());
    }
  }

  /**
   * Set cargo details on synoptical record
   *
   * @param request
   * @param obqEntities
   * @param synopticalEntity
   * @param builder
   * @param firstPortId
   * @param voyage
   * @param vesselReply
   * @param loadableStudy
   */
  private void setSynopticalCargoDetails(
      SynopticalTableRequest request,
      List<com.cpdss.loadablestudy.entity.LoadablePatternCargoDetails> cargoDetails,
      List<OnBoardQuantity> obqEntities,
      SynopticalTable synopticalEntity,
      SynopticalRecord.Builder builder,
      List<VesselTankDetail> sortedTankList,
      Long firstPortId,
      Voyage voyage) {
    BigDecimal cargoActualTotal = BigDecimal.ZERO;
    BigDecimal cargoPlannedTotal = BigDecimal.ZERO;
    List<CargoHistory> cargoHistories = null;
    List<com.cpdss.loadablestudy.entity.LoadablePatternCargoDetails> portSpecificCargoDetails =
        new ArrayList<>();
    if (null != cargoDetails) {
      portSpecificCargoDetails.addAll(
          cargoDetails.stream()
              .filter(
                  det ->
                      det.getPortId().equals(synopticalEntity.getPortXid())
                          && det.getOperationType().equals(synopticalEntity.getOperationType()))
              .collect(Collectors.toList()));
    }
    for (VesselTankDetail tank : sortedTankList) {
      if (!CARGO_TANK_CATEGORIES.contains(tank.getTankCategoryId())) {
        continue;
      }
      SynopticalCargoRecord.Builder cargoBuilder = SynopticalCargoRecord.newBuilder();
      cargoBuilder.setTankId(tank.getTankId());
      cargoBuilder.setTankName(tank.getShortName());
      cargoBuilder.setCapacity(tank.getFullCapacityCubm());
      // first port arrival data will be same as obq data
      // if no obq data is found, previos voyage data has to be fetched
      if (synopticalEntity.getPortXid().equals(firstPortId)
          && synopticalEntity.getOperationType().equals(SYNOPTICAL_TABLE_OP_TYPE_ARRIVAL)) {
        this.buildObqDataForSynopticalTable(
            tank, cargoHistories, obqEntities, cargoBuilder, voyage);
      } else if (request.getLoadablePatternId() > 0) {
        Optional<com.cpdss.loadablestudy.entity.LoadablePatternCargoDetails> tankDataOpt =
            portSpecificCargoDetails.stream()
                .filter(cargo -> cargo.getTankId().equals(tank.getTankId()))
                .findAny();
        if (tankDataOpt.isPresent()) {
          Optional.ofNullable(tankDataOpt.get().getPlannedQuantity())
              .ifPresent(item -> cargoBuilder.setPlannedWeight(valueOf(item)));
          Optional.ofNullable(tankDataOpt.get().getActualQuantity())
              .ifPresent(item -> cargoBuilder.setActualWeight(valueOf(item)));
          // attributes for landing page
          Optional.ofNullable(tankDataOpt.get().getCargoId()).ifPresent(cargoBuilder::setCargoId);
          Optional.ofNullable(tankDataOpt.get().getAbbreviation())
              .ifPresent(cargoBuilder::setCargoAbbreviation);
          Optional.ofNullable(tankDataOpt.get().getColorCode())
              .ifPresent(cargoBuilder::setColorCode);
          Optional.ofNullable(tankDataOpt.get().getCorrectedUllage())
              .ifPresent(ullage -> cargoBuilder.setCorrectedUllage(valueOf(ullage)));
          Optional.ofNullable(tankDataOpt.get().getApi())
              .ifPresent(api -> cargoBuilder.setApi(valueOf(api)));
        }
      }
      if (!isEmpty(cargoBuilder.getActualWeight())) {
        cargoActualTotal = cargoActualTotal.add(new BigDecimal(cargoBuilder.getActualWeight()));
      }
      if (!isEmpty(cargoBuilder.getPlannedWeight())) {
        cargoPlannedTotal = cargoPlannedTotal.add(new BigDecimal(cargoBuilder.getPlannedWeight()));
      }
      builder.addCargo(cargoBuilder.build());
    }
    builder.setCargoActualTotal(valueOf(cargoActualTotal));
    builder.setCargoPlannedTotal(valueOf(cargoPlannedTotal));
  }

  private void buildObqDataForSynopticalTable(
      VesselTankDetail tank,
      List<CargoHistory> cargoHistories,
      List<OnBoardQuantity> obqEntities,
      SynopticalCargoRecord.Builder cargoBuilder,
      Voyage voyage) {

    Optional<OnBoardQuantity> obqOpt =
        obqEntities.stream().filter(obq -> obq.getTankId().equals(tank.getTankId())).findAny();
    if (obqOpt.isPresent()) {
      OnBoardQuantity obqEntity = obqOpt.get();
      if (null != obqEntity.getActualArrivalWeight()) {
        cargoBuilder.setActualWeight(valueOf(obqEntity.getActualArrivalWeight()));
      }
      if (null != obqEntity.getPlannedArrivalWeight()) {
        cargoBuilder.setPlannedWeight(valueOf(obqEntity.getPlannedArrivalWeight()));
      }
      if (null != obqEntity.getDensity()) {
        cargoBuilder.setApi(valueOf(obqEntity.getDensity()));
      }
      if (null != obqEntity.getAbbreviation()) {
        cargoBuilder.setCargoAbbreviation(obqEntity.getAbbreviation());
      }
    } else {
      // data has to be populated from previous voyage - cargo history table
      // lazy loading the cargo history
      if (null == cargoHistories) {
        cargoHistories = this.findCargoHistoryForPrvsVoyage(voyage);
      }
      Optional<CargoHistory> cargoHistoryOpt =
          cargoHistories.stream().filter(e -> e.getTankId().equals(tank.getTankId())).findAny();
      if (cargoHistoryOpt.isPresent()) {
        CargoHistory dto = cargoHistoryOpt.get();
        Optional.ofNullable(dto.getQuantity())
            .ifPresent(item -> cargoBuilder.setPlannedWeight(valueOf(item)));
      }
    }
  }

  /**
   * Build synoptical table record
   *
   * @param synopticalEntity
   * @param builder
   * @param portReply
   */
  private void buildSynopticalRecord(
      SynopticalTable synopticalEntity, SynopticalRecord.Builder builder, PortReply portReply) {
    Optional.ofNullable(synopticalEntity.getId()).ifPresent(builder::setId);
    Optional.ofNullable(synopticalEntity.getPortXid()).ifPresent(builder::setPortId);
    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
    if (portReply != null) {
      portReply.getPortsList().stream()
          .filter(p -> synopticalEntity.getPortXid().equals(p.getId()))
          .findAny()
          .ifPresent(
              port -> {
                this.setSynopticalPortValues(port, builder);
              });
    }
    Optional.ofNullable(synopticalEntity.getOperationType()).ifPresent(builder::setOperationType);
    Optional.ofNullable(synopticalEntity.getDistance())
        .ifPresent(distance -> builder.setDistance(String.valueOf(distance)));
    Optional.ofNullable(synopticalEntity.getSpeed())
        .ifPresent(speed -> builder.setSpeed(String.valueOf(speed)));
    Optional.ofNullable(synopticalEntity.getRunningHours())
        .ifPresent(runningHours -> builder.setRunningHours(String.valueOf(runningHours)));
    Optional.ofNullable(synopticalEntity.getInPortHours())
        .ifPresent(inPortHours -> builder.setInPortHours(String.valueOf(inPortHours)));
    Optional.ofNullable(synopticalEntity.getTimeOfSunrise())
        .ifPresent(time -> builder.setTimeOfSunrise(timeFormatter.format(time)));
    Optional.ofNullable(synopticalEntity.getTimeOfSunSet())
        .ifPresent(time -> builder.setTimeOfSunset(timeFormatter.format(time)));
    // If specific port related data is available in synoptical table then replace
    // the port master
    // value
    Optional.ofNullable(synopticalEntity.getSpecificGravity())
        .ifPresent(sg -> builder.setSpecificGravity(valueOf(sg)));
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
    Optional.ofNullable(synopticalEntity.getHwTideFrom())
        .ifPresent(hwTideFrom -> builder.setHwTideFrom(String.valueOf(hwTideFrom)));
    Optional.ofNullable(synopticalEntity.getHwTideTimeFrom())
        .ifPresent(
            hwTideTimeFrom -> builder.setHwTideTimeFrom(timeFormatter.format(hwTideTimeFrom)));
    Optional.ofNullable(synopticalEntity.getHwTideTo())
        .ifPresent(hwTideTo -> builder.setHwTideTo(String.valueOf(hwTideTo)));
    Optional.ofNullable(synopticalEntity.getHwTideTimeTo())
        .ifPresent(hwTideTimeTo -> builder.setHwTideTimeTo(timeFormatter.format(hwTideTimeTo)));
    Optional.ofNullable(synopticalEntity.getLwTideFrom())
        .ifPresent(lwTideFrom -> builder.setLwTideFrom(String.valueOf(lwTideFrom)));
    Optional.ofNullable(synopticalEntity.getLwTideTimeFrom())
        .ifPresent(
            lwTideTimeFrom -> builder.setLwTideTimeFrom(timeFormatter.format(lwTideTimeFrom)));
    Optional.ofNullable(synopticalEntity.getLwTideTo())
        .ifPresent(lwTideTo -> builder.setLwTideTo(String.valueOf(lwTideTo)));
    Optional.ofNullable(synopticalEntity.getLwTideTimeTo())
        .ifPresent(lwTideTimeTo -> builder.setLwTideTimeTo(timeFormatter.format(lwTideTimeTo)));
    Optional.ofNullable(synopticalEntity.getLoadableStudyPortRotation())
        .ifPresent(portRotation -> builder.setPortRotationId(portRotation.getId()));
    if (null != synopticalEntity.getEtaActual()) {
      builder.setEtaEtdActual(formatter.format(synopticalEntity.getEtaActual()));
    } else if (null != synopticalEntity.getEtdActual()) {
      builder.setEtaEtdActual(formatter.format(synopticalEntity.getEtdActual()));
    }
  }

  /**
   * * Set port values to synoptical response
   *
   * @param port
   * @param builder
   */
  private void setSynopticalPortValues(
      PortDetail port, com.cpdss.common.generated.LoadableStudy.SynopticalRecord.Builder builder) {
    builder.setPortName(port.getName());
    builder.setSpecificGravity(port.getWaterDensity());
    builder.setHwTideFrom(port.getHwTideFrom());
    builder.setHwTideTo(port.getHwTideTo());
    builder.setLwTideFrom(port.getLwTideFrom());
    builder.setLwTideTo(port.getLwTideTo());
    if (!isEmpty(port.getHwTideTimeFrom())) {
      builder.setHwTideTimeFrom(port.getHwTideTimeFrom());
    }
    if (!isEmpty(port.getHwTideTimeTo())) {
      builder.setHwTideTimeTo(port.getHwTideTimeTo());
    }
    if (!isEmpty(port.getLwTideTimeFrom())) {
      builder.setLwTideTimeFrom(port.getLwTideTimeFrom());
    }
    if (!isEmpty(port.getLwTideTimeTo())) {
      builder.setLwTideTimeTo(port.getLwTideTimeTo());
    }
    if (!isEmpty(port.getSunriseTime())) {
      builder.setTimeOfSunrise(port.getSunriseTime());
    }
    if (!isEmpty(port.getSunsetTime())) {
      builder.setTimeOfSunset(port.getSunsetTime());
    }
  }

  /**
   * Set eta and etd estimated values
   *
   * @param synopticalEntity
   * @param builder
   * @param portRotations
   */
  private void setSynopticalEtaEtdEstimated(
      SynopticalTable synopticalEntity,
      SynopticalRecord.Builder builder,
      List<LoadableStudyPortRotation> portRotations) {
    /*
     * Optional<LoadableStudyPortRotation> portRotation = portRotations .stream()
     * .filter( pr ->
     * pr.getId().equals(synopticalEntity.getLoadableStudyPortRotation().getId()))
     * .findFirst();
     */
    Optional<LoadableStudyPortRotation> portRotation =
        Optional.of(synopticalEntity.getLoadableStudyPortRotation());
    if (portRotation.isPresent()) {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
      if (SYNOPTICAL_TABLE_OP_TYPE_ARRIVAL.equals(synopticalEntity.getOperationType())) {
        builder.setEtaEtdEstimated(
            null == portRotation.get().getEta()
                ? ""
                : formatter.format(portRotation.get().getEta()));
      } else {
        builder.setEtaEtdEstimated(
            null == portRotation.get().getEtd()
                ? ""
                : formatter.format(portRotation.get().getEtd()));
      }
      if (null != portRotation.get().getPortOrder()) {
        builder.setPortOrder(portRotation.get().getPortOrder());
      }
      builder.setPortRotationId(portRotation.get().getId());
    }
  }

  /**
   * * Get vessel data for synoptical table
   *
   * @param request
   * @param loadableStudy
   * @return
   * @throws GenericServiceException
   */
  private VesselReply getSynopticalTableVesselData(
      SynopticalTableRequest request, LoadableStudy loadableStudy) throws GenericServiceException {
    VesselRequest.Builder vesselGrpcRequest = VesselRequest.newBuilder();
    vesselGrpcRequest.setVesselId(request.getVesselId());
    Optional.ofNullable(loadableStudy.getLoadLineXId())
        .ifPresent(vesselGrpcRequest::setVesselDraftConditionId);
    Optional.ofNullable(loadableStudy.getDraftMark())
        .ifPresent(item -> vesselGrpcRequest.setDraftExtreme(valueOf(item)));
    vesselGrpcRequest.addAllTankCategories(SYNOPTICAL_TABLE_TANK_CATEGORIES);
    VesselReply vesselReply = this.getVesselDetailForSynopticalTable(vesselGrpcRequest.build());
    if (!SUCCESS.equals(vesselReply.getResponseStatus().getStatus())) {
      throw new GenericServiceException(
          "Failed to fetch vessel particualrs",
          vesselReply.getResponseStatus().getCode(),
          HttpStatusCode.valueOf(Integer.valueOf(vesselReply.getResponseStatus().getCode())));
    }
    return vesselReply;
  }

  /**
   * Call vessel info grpc service for synoptical table data
   *
   * @param request
   * @return
   */
  public VesselReply getVesselDetailForSynopticalTable(VesselRequest request) {
    return this.vesselInfoGrpcService.getVesselDetailForSynopticalTable(request);
  }

  @Override
  public void getAlgoErrors(
      AlgoErrorRequest request, StreamObserver<AlgoErrorReply> responseObserver) {
    log.info("inside getAlgoErrors loadable study service");
    AlgoErrorReply.Builder replyBuilder = AlgoErrorReply.newBuilder();
    try {
      if (request.getLoadablePatternId() != 0) {
        Optional<LoadablePattern> loadablePatternOpt =
            this.loadablePatternRepository.findByIdAndIsActive(
                request.getLoadablePatternId(), true);
        if (!loadablePatternOpt.isPresent()) {
          log.info(INVALID_LOADABLE_PATTERN_ID, request.getLoadablePatternId());
          throw new GenericServiceException(
              INVALID_LOADABLE_PATTERN_ID,
              CommonErrorCodes.E_HTTP_BAD_REQUEST,
              HttpStatusCode.BAD_REQUEST);

        } else {
          log.info("inside getAlgoErrors loadable study service - getting error details");
          buildLoadablePatternErrorDetails(loadablePatternOpt.get(), replyBuilder);
        }
      } else {
        // ToDo - error in pattern generate
      }

    } catch (GenericServiceException e) {
      log.error("GenericServiceException when fetching loadable study - getAlgoErrors", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(e.getCode())
              .setMessage(e.getMessage())
              .setStatus(FAILED)
              .build());

    } catch (Exception e) {
      log.error("Exception when getAlgoErrors ", e);
      replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(FAILED));
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  /**
   * @param loadablePattern
   * @param replyBuilder void
   */
  private void buildLoadablePatternErrorDetails(
      LoadablePattern loadablePattern,
      com.cpdss.common.generated.LoadableStudy.AlgoErrorReply.Builder replyBuilder) {

    Optional<List<AlgoErrorHeading>> alogError =
        algoErrorHeadingRepository.findByLoadablePatternAndIsActive(loadablePattern, true);
    if (alogError.isPresent()) {
      log.info("Adding ALGO error");
      for (AlgoErrorHeading errorHeading : alogError.get()) {
        AlgoErrors.Builder errorBuilder = AlgoErrors.newBuilder();

        Optional<List<com.cpdss.loadablestudy.entity.AlgoErrors>> algoError =
            algoErrorsRepository.findByAlgoErrorHeadingAndIsActive(errorHeading, true);
        if (algoError.isPresent()) {
          List<String> res = new ArrayList<>();
          res.addAll(
              algoError.get().stream()
                  .map(val -> val.getErrorMessage())
                  .collect(Collectors.toList()));
          errorBuilder.addAllErrorMessages(res);
        }

        errorBuilder.setErrorHeading(errorHeading.getErrorHeading());
        replyBuilder.addAlgoErrors(errorBuilder);
      }
    }
    replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS).build());
  }

  private VesselReply getTanks(Long vesselId, List<Long> tankCategory)
      throws GenericServiceException {
    VesselRequest.Builder vesselGrpcRequest = VesselRequest.newBuilder();
    vesselGrpcRequest.setVesselId(vesselId);
    vesselGrpcRequest.addAllTankCategories(tankCategory);
    return this.getVesselTanks(vesselGrpcRequest.build());
  }

  @Override
  public void getLoadablePlanDetails(
      LoadablePlanDetailsRequest request,
      StreamObserver<LoadablePlanDetailsReply> responseObserver) {
    log.info("inside getLoadablePlanDetails loadable study service");
    LoadablePlanDetailsReply.Builder replyBuilder = LoadablePlanDetailsReply.newBuilder();
    try {
      Optional<LoadablePattern> loadablePatternOpt =
          this.loadablePatternRepository.findByIdAndIsActive(request.getLoadablePatternId(), true);
      if (!loadablePatternOpt.isPresent()) {
        log.info(INVALID_LOADABLE_PATTERN_ID, request.getLoadablePatternId());
        replyBuilder.setResponseStatus(
            ResponseStatus.newBuilder()
                .setStatus(FAILED)
                .setMessage(INVALID_LOADABLE_PATTERN_ID)
                .setCode(CommonErrorCodes.E_HTTP_BAD_REQUEST));
      } else {

        buildLoadablePlanDetails(loadablePatternOpt, replyBuilder);
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

  /**
   * void
   *
   * @param replyBuilder
   * @param loadablePatternOpt
   */
  private void buildLoadablePlanDetails(
      Optional<LoadablePattern> loadablePatternOpt,
      com.cpdss.common.generated.LoadableStudy.LoadablePlanDetailsReply.Builder replyBuilder)
      throws GenericServiceException {

    VesselReply vesselReplyCargoBallastTanks =
        this.getTanks(
            loadablePatternOpt.get().getLoadableStudy().getVesselXId(),
            CARGO_BALLAST_TANK_CATEGORIES);
    if (!SUCCESS.equals(vesselReplyCargoBallastTanks.getResponseStatus().getStatus())) {
      throw new GenericServiceException(
          "Failed to fetch vessel particualrs for cargo tanks",
          vesselReplyCargoBallastTanks.getResponseStatus().getCode(),
          HttpStatusCode.valueOf(
              Integer.valueOf(vesselReplyCargoBallastTanks.getResponseStatus().getCode())));
    }

    List<LoadablePlanQuantity> loadablePlanQuantities =
        loadablePlanQuantityRepository.findByLoadablePatternAndIsActive(
            loadablePatternOpt.get(), true);
    buildLoadablePlanQuantity(loadablePlanQuantities, replyBuilder);

    List<LoadablePlanCommingleDetails> loadablePlanCommingleDetails =
        loadablePlanCommingleDetailsRepository.findByLoadablePatternAndIsActive(
            loadablePatternOpt.get(), true);
    buildLoadablePlanCommingleDetails(loadablePlanCommingleDetails, replyBuilder);

    List<LoadablePlanStowageDetails> loadablePlanStowageDetails =
        loadablePlanStowageDetailsRespository.findByLoadablePatternAndIsActive(
            loadablePatternOpt.get(), true);
    buildLoadablePlanStowageCargoDetails(loadablePlanStowageDetails, replyBuilder);

    replyBuilder.addAllTanks(
        this.groupTanks(
            vesselReplyCargoBallastTanks.getVesselTanksList().stream()
                .filter(tankList -> CARGO_TANK_CATEGORIES.contains(tankList.getTankCategoryId()))
                .collect(Collectors.toList())));

    buildBallastTankLayout(
        vesselReplyCargoBallastTanks.getVesselTanksList().stream()
            .filter(tankList -> BALLAST_TANK_CATEGORIES.contains(tankList.getTankCategoryId()))
            .collect(Collectors.toList()),
        replyBuilder);
    List<LoadablePlanBallastDetails> loadablePlanBallastDetails =
        loadablePlanBallastDetailsRepository.findByLoadablePatternAndIsActive(
            loadablePatternOpt.get(), true);
    buildBallastGridDetails(loadablePlanBallastDetails, replyBuilder);

    List<LoadablePlanComments> loadablePlanComments =
        loadablePlanCommentsRepository.findByLoadablePatternAndIsActiveOrderByIdDesc(
            loadablePatternOpt.get(), true);

    buildCommentDetails(loadablePlanComments, replyBuilder);

    buildLoadablePlanDetails(replyBuilder, loadablePatternOpt.get());

    replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS).build());
  }

  /**
   * @param replyBuilder
   * @param loadablePattern void
   */
  private void buildLoadablePlanDetails(
      com.cpdss.common.generated.LoadableStudy.LoadablePlanDetailsReply.Builder replyBuilder,
      LoadablePattern loadablePattern) {
    replyBuilder.setId(loadablePattern.getId());
    replyBuilder.setCaseNumber(loadablePattern.getCaseNumber().toString());
    replyBuilder.setDate(
        DateTimeFormatter.ofPattern(CREATED_DATE_FORMAT).format(loadablePattern.getCreatedDate()));
    replyBuilder.setVoyageNumber(loadablePattern.getLoadableStudy().getVoyage().getVoyageNo());
    replyBuilder.setVoyageStatusId(
        loadablePattern.getLoadableStudy().getVoyage().getVoyageStatus().getId());
    List<LoadablePatternAlgoStatus> status =
        loadablePatternAlgoStatusRepository.findByLoadablePatternAndIsActive(loadablePattern, true);
    if (!status.isEmpty()) {
      replyBuilder.setLoadablePatternStatusId(
          status.get(status.size() - 1).getLoadableStudyStatus().getId());
    }
  }

  /**
   * @param loadablePlanComments
   * @param replyBuilder void
   */
  private void buildCommentDetails(
      List<LoadablePlanComments> loadablePlanComments,
      com.cpdss.common.generated.LoadableStudy.LoadablePlanDetailsReply.Builder replyBuilder) {

    loadablePlanComments.forEach(
        lpc -> {
          com.cpdss.common.generated.LoadableStudy.LoadablePlanComments.Builder builder =
              com.cpdss.common.generated.LoadableStudy.LoadablePlanComments.newBuilder();
          Optional.ofNullable(lpc.getId()).ifPresent(builder::setId);
          Optional.ofNullable(lpc.getComments()).ifPresent(builder::setComment);
          Optional.ofNullable(
                  DateTimeFormatter.ofPattern(DATE_FORMAT).format(lpc.getCreatedDateTime()))
              .ifPresent(builder::setDataAndTime);
          builder.setUserName("Uttam Kumar"); // ToDo - replace it with the value taken from cache
          replyBuilder.addLoadablePlanComments(builder);
        });
  }

  /**
   * @param loadablePlanBallastDetails
   * @param replyBuilder void
   */
  private void buildBallastGridDetails(
      List<LoadablePlanBallastDetails> loadablePlanBallastDetails,
      com.cpdss.common.generated.LoadableStudy.LoadablePlanDetailsReply.Builder replyBuilder) {
    loadablePlanBallastDetails.forEach(
        lpbd -> {
          com.cpdss.common.generated.LoadableStudy.LoadablePlanBallastDetails.Builder builder =
              com.cpdss.common.generated.LoadableStudy.LoadablePlanBallastDetails.newBuilder();
          Optional.ofNullable(lpbd.getId()).ifPresent(builder::setId);
          Optional.ofNullable(lpbd.getCorrectedLevel()).ifPresent(builder::setCorrectedLevel);
          Optional.ofNullable(lpbd.getCorrectionFactor()).ifPresent(builder::setCorrectionFactor);
          Optional.ofNullable(lpbd.getCubicMeter()).ifPresent(builder::setCubicMeter);
          Optional.ofNullable(lpbd.getInertia()).ifPresent(builder::setInertia);
          Optional.ofNullable(lpbd.getLcg()).ifPresent(builder::setLcg);
          Optional.ofNullable(lpbd.getMetricTon()).ifPresent(builder::setMetricTon);
          Optional.ofNullable(lpbd.getPercentage()).ifPresent(builder::setPercentage);
          Optional.ofNullable(lpbd.getRdgLevel()).ifPresent(builder::setRdgLevel);
          Optional.ofNullable(lpbd.getSg()).ifPresent(builder::setSg);
          Optional.ofNullable(lpbd.getTankId()).ifPresent(builder::setTankId);
          Optional.ofNullable(lpbd.getTcg()).ifPresent(builder::setTcg);
          Optional.ofNullable(lpbd.getVcg()).ifPresent(builder::setVcg);
          Optional.ofNullable(lpbd.getTankName()).ifPresent(builder::setTankName);
          Optional.ofNullable(lpbd.getColorCode()).ifPresent(builder::setColorCode);
          replyBuilder.addLoadablePlanBallastDetails(builder);
        });
  }

  /**
   * @param vesselReplyBallastTanks
   * @param replyBuilder void
   */
  private void buildBallastTankLayout(
      List<VesselTankDetail> vesselTankDetails,
      com.cpdss.common.generated.LoadableStudy.LoadablePlanDetailsReply.Builder replyBuilder) {

    List<VesselTankDetail> frontBallastTanks = new ArrayList<>();
    List<VesselTankDetail> centerBallestTanks = new ArrayList<>();
    List<VesselTankDetail> rearBallastTanks = new ArrayList<>();
    frontBallastTanks.addAll(
        vesselTankDetails.stream()
            .filter(tank -> BALLAST_FRONT_TANK.equals(tank.getTankPositionCategory()))
            .collect(Collectors.toList()));
    centerBallestTanks.addAll(
        vesselTankDetails.stream()
            .filter(tank -> BALLAST_CENTER_TANK.equals(tank.getTankPositionCategory()))
            .collect(Collectors.toList()));

    rearBallastTanks.addAll(
        vesselTankDetails.stream()
            .filter(tank -> BALLAST_REAR_TANK.equals(tank.getTankPositionCategory()))
            .collect(Collectors.toList()));

    replyBuilder.addAllBallastFrontTanks(this.groupTanks(frontBallastTanks));
    replyBuilder.addAllBallastCenterTanks(this.groupTanks(centerBallestTanks));
    replyBuilder.addAllBallastRearTanks(this.groupTanks(rearBallastTanks));
  }

  /**
   * @param loadablePlanCommingleDetails
   * @param replyBuilder void
   */
  private void buildLoadablePlanCommingleDetails(
      List<LoadablePlanCommingleDetails> loadablePlanCommingleDetails,
      com.cpdss.common.generated.LoadableStudy.LoadablePlanDetailsReply.Builder replyBuilder) {
    loadablePlanCommingleDetails.forEach(
        lpcd -> {
          LoadableQuantityCommingleCargoDetails.Builder builder =
              LoadableQuantityCommingleCargoDetails.newBuilder();
          Optional.ofNullable(lpcd.getId()).ifPresent(builder::setId);
          Optional.ofNullable(lpcd.getApi()).ifPresent(builder::setApi);
          Optional.ofNullable(lpcd.getCargo1Abbreviation())
              .ifPresent(builder::setCargo1Abbreviation);
          Optional.ofNullable(lpcd.getCargo1Bbls60f()).ifPresent(builder::setCargo1Bbls60F);
          Optional.ofNullable(lpcd.getCargo1BblsDbs()).ifPresent(builder::setCargo1Bblsdbs);
          Optional.ofNullable(lpcd.getCargo1Kl()).ifPresent(builder::setCargo1KL);
          Optional.ofNullable(lpcd.getCargo1Lt()).ifPresent(builder::setCargo1LT);
          Optional.ofNullable(lpcd.getCargo1Mt()).ifPresent(builder::setCargo1MT);
          Optional.ofNullable(lpcd.getCargo1Percentage()).ifPresent(builder::setCargo1Percentage);
          Optional.ofNullable(lpcd.getCargo2Abbreviation())
              .ifPresent(builder::setCargo2Abbreviation);
          Optional.ofNullable(lpcd.getCargo2Bbls60f()).ifPresent(builder::setCargo2Bbls60F);
          Optional.ofNullable(lpcd.getCargo2BblsDbs()).ifPresent(builder::setCargo2Bblsdbs);
          Optional.ofNullable(lpcd.getCargo2Kl()).ifPresent(builder::setCargo2KL);
          Optional.ofNullable(lpcd.getCargo2Lt()).ifPresent(builder::setCargo2LT);
          Optional.ofNullable(lpcd.getCargo2Mt()).ifPresent(builder::setCargo2MT);
          Optional.ofNullable(lpcd.getCargo2Percentage()).ifPresent(builder::setCargo2Percentage);
          Optional.ofNullable(lpcd.getGrade()).ifPresent(builder::setGrade);
          Optional.ofNullable(lpcd.getQuantity()).ifPresent(builder::setQuantity);
          Optional.ofNullable(lpcd.getTankName()).ifPresent(builder::setTankName);
          Optional.ofNullable(lpcd.getTemperature()).ifPresent(builder::setTemp);
          replyBuilder.addLoadableQuantityCommingleCargoDetails(builder);

          com.cpdss.common.generated.LoadableStudy.LoadablePlanStowageDetails.Builder
              stowageBuilder =
                  com.cpdss.common.generated.LoadableStudy.LoadablePlanStowageDetails.newBuilder();
          Optional.ofNullable(lpcd.getId()).ifPresent(stowageBuilder::setId);
          Optional.ofNullable(lpcd.getGrade()).ifPresent(stowageBuilder::setCargoAbbreviation);
          Optional.ofNullable(lpcd.getApi()).ifPresent(stowageBuilder::setApi);
          Optional.ofNullable(lpcd.getCorrectedUllage())
              .ifPresent(stowageBuilder::setCorrectedUllage);
          Optional.ofNullable(lpcd.getCorrectionFactor())
              .ifPresent(stowageBuilder::setCorrectionFactor);
          Optional.ofNullable(lpcd.getFillingRatio()).ifPresent(stowageBuilder::setFillingRatio);

          Optional.ofNullable(lpcd.getRdgUllage()).ifPresent(stowageBuilder::setRdgUllage);
          Optional.ofNullable(lpcd.getTankName()).ifPresent(stowageBuilder::setTankName);
          Optional.ofNullable(lpcd.getTankId()).ifPresent(stowageBuilder::setTankId);
          Optional.ofNullable(lpcd.getTemperature()).ifPresent(stowageBuilder::setTemperature);
          Optional.ofNullable(lpcd.getQuantity()).ifPresent(stowageBuilder::setWeight);
          stowageBuilder.setIsCommingle(true);
          replyBuilder.addLoadablePlanStowageDetails(stowageBuilder);
        });
  }

  /**
   * @param loadablePlanStowageDetails
   * @param replyBuilder void
   */
  private void buildLoadablePlanStowageCargoDetails(
      List<LoadablePlanStowageDetails> loadablePlanStowageDetails,
      com.cpdss.common.generated.LoadableStudy.LoadablePlanDetailsReply.Builder replyBuilder) {
    loadablePlanStowageDetails.forEach(
        lpsd -> {
          com.cpdss.common.generated.LoadableStudy.LoadablePlanStowageDetails.Builder builder =
              com.cpdss.common.generated.LoadableStudy.LoadablePlanStowageDetails.newBuilder();
          Optional.ofNullable(lpsd.getId()).ifPresent(builder::setId);
          Optional.ofNullable(lpsd.getAbbreviation()).ifPresent(builder::setCargoAbbreviation);
          Optional.ofNullable(lpsd.getApi()).ifPresent(builder::setApi);
          Optional.ofNullable(lpsd.getCorrectedUllage()).ifPresent(builder::setCorrectedUllage);
          Optional.ofNullable(lpsd.getCorrectionFactor()).ifPresent(builder::setCorrectionFactor);
          Optional.ofNullable(lpsd.getFillingPercentage()).ifPresent(builder::setFillingRatio);
          Optional.ofNullable(lpsd.getObservedBarrels()).ifPresent(builder::setObservedBarrels);
          Optional.ofNullable(lpsd.getObservedBarrelsAt60())
              .ifPresent(builder::setObservedBarrelsAt60);
          Optional.ofNullable(lpsd.getObservedM3()).ifPresent(builder::setObservedM3);
          Optional.ofNullable(lpsd.getRdgUllage()).ifPresent(builder::setRdgUllage);
          Optional.ofNullable(lpsd.getTankname()).ifPresent(builder::setTankName);
          Optional.ofNullable(lpsd.getTankId()).ifPresent(builder::setTankId);
          Optional.ofNullable(lpsd.getTemperature()).ifPresent(builder::setTemperature);
          Optional.ofNullable(lpsd.getWeight()).ifPresent(builder::setWeight);
          Optional.ofNullable(lpsd.getColorCode()).ifPresent(builder::setColorCode);
          builder.setIsCommingle(false);
          replyBuilder.addLoadablePlanStowageDetails(builder);
        });
  }

  /**
   * @param loadablePlanQuantities
   * @param replyBuilder void
   */
  private void buildLoadablePlanQuantity(
      List<LoadablePlanQuantity> loadablePlanQuantities,
      com.cpdss.common.generated.LoadableStudy.LoadablePlanDetailsReply.Builder replyBuilder) {
    loadablePlanQuantities.forEach(
        lpq -> {
          LoadableQuantityCargoDetails.Builder builder = LoadableQuantityCargoDetails.newBuilder();
          Optional.ofNullable(lpq.getId()).ifPresent(builder::setId);
          Optional.ofNullable(lpq.getDifferenceColor()).ifPresent(builder::setDifferenceColor);
          Optional.ofNullable(lpq.getDifferencePercentage())
              .ifPresent(
                  diffPercentage ->
                      builder.setDifferencePercentage(String.valueOf(diffPercentage)));
          Optional.ofNullable(lpq.getEstimatedApi())
              .ifPresent(estimatedApi -> builder.setEstimatedAPI(String.valueOf(estimatedApi)));
          Optional.ofNullable(lpq.getEstimatedTemperature())
              .ifPresent(
                  estimatedTemperature ->
                      builder.setEstimatedTemp(String.valueOf(estimatedTemperature)));
          Optional.ofNullable(lpq.getGrade()).ifPresent(builder::setGrade);
          Optional.ofNullable(lpq.getLoadableBbls60f()).ifPresent(builder::setLoadableBbls60F);
          Optional.ofNullable(lpq.getLoadableBblsDbs()).ifPresent(builder::setLoadableBblsdbs);
          Optional.ofNullable(lpq.getLoadableKl()).ifPresent(builder::setLoadableKL);
          Optional.ofNullable(lpq.getLoadableLt()).ifPresent(builder::setLoadableLT);
          Optional.ofNullable(lpq.getLoadableMt()).ifPresent(builder::setLoadableMT);
          Optional.ofNullable(lpq.getMaxTolerence()).ifPresent(builder::setMaxTolerence);
          Optional.ofNullable(lpq.getMinTolerence()).ifPresent(builder::setMinTolerence);
          Optional.ofNullable(lpq.getOrderBbls60f()).ifPresent(builder::setOrderBbls60F);
          Optional.ofNullable(lpq.getOrderBblsDbs()).ifPresent(builder::setOrderBblsdbs);
          Optional.ofNullable(lpq.getCargoXId()).ifPresent(builder::setCargoId);
          Optional.ofNullable(lpq.getOrderQuantity())
              .ifPresent(orderQuantity -> builder.setOrderedMT(String.valueOf(orderQuantity)));
          replyBuilder.addLoadableQuantityCargoDetails(builder);
        });
  }

  /**
   * @param request
   * @param responseObserver
   */
  @Override
  public void confirmPlanStatus(
      ConfirmPlanRequest request, StreamObserver<ConfirmPlanReply> responseObserver) {
    log.info("inside confirmPlanStatus loadable study service");
    ConfirmPlanReply.Builder replyBuilder = ConfirmPlanReply.newBuilder();
    try {
      Optional<LoadablePattern> loadablePatternOpt =
          this.loadablePatternRepository.findByIdAndIsActive(request.getLoadablePatternId(), true);
      if (!loadablePatternOpt.isPresent()) {
        log.info(INVALID_LOADABLE_PATTERN_ID, request.getLoadablePatternId());
        replyBuilder.setResponseStatus(
            ResponseStatus.newBuilder()
                .setStatus(FAILED)
                .setMessage(INVALID_LOADABLE_PATTERN_ID)
                .setCode(CommonErrorCodes.E_HTTP_BAD_REQUEST));
      } else {
        List<LoadablePattern> loadablePatternConfirmedOpt =
            loadablePatternRepository.findByVoyageAndLoadableStudyStatusAndIsActive(
                request.getVoyageId(), CONFIRMED_STATUS_ID, true);
        if (!loadablePatternConfirmedOpt.isEmpty()) {
          // set confirm status to false since some other plan is already confirmed
          log.info("other plan is in confirmed status");
          replyBuilder.setConfirmed(false);
        } else {
          log.info("plan is okay to confirm");

          replyBuilder.setConfirmed(true);
        }
        replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS).build());
      }
    } catch (Exception e) {
      log.error("Exception when confirmPlanStatus ", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setStatus(FAILED)
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage("Exception when confirmPlanStatus Loadable Study Status"));
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
  public void confirmPlan(
      ConfirmPlanRequest request, StreamObserver<ConfirmPlanReply> responseObserver) {
    log.info("inside confirmPlan loadable study service");
    ConfirmPlanReply.Builder replyBuilder = ConfirmPlanReply.newBuilder();
    try {
      Optional<LoadablePattern> loadablePatternOpt =
          this.loadablePatternRepository.findByIdAndIsActive(request.getLoadablePatternId(), true);
      if (!loadablePatternOpt.isPresent()) {
        log.info(INVALID_LOADABLE_PATTERN_ID, request.getLoadablePatternId());
        replyBuilder.setResponseStatus(
            ResponseStatus.newBuilder()
                .setStatus(FAILED)
                .setMessage(INVALID_LOADABLE_PATTERN_ID)
                .setCode(CommonErrorCodes.E_HTTP_BAD_REQUEST));
      } else {
        List<LoadablePattern> loadablePatternConfirmedOpt =
            loadablePatternRepository.findByVoyageAndLoadableStudyStatusAndIsActive(
                loadablePatternOpt.get().getLoadableStudy().getVoyage().getId(),
                CONFIRMED_STATUS_ID,
                true);
        if (!loadablePatternConfirmedOpt.isEmpty()) {
          log.info("changing status of other confirmed plan to plan generated");
          loadablePatternRepository.updateLoadablePatternStatusToPlanGenerated(
              LOADABLE_STUDY_STATUS_PLAN_GENERATED_ID, loadablePatternConfirmedOpt.get(0).getId());
          loadablePatternRepository.updateLoadableStudyStatusToPlanGenerated(
              LOADABLE_STUDY_STATUS_PLAN_GENERATED_ID,
              loadablePatternConfirmedOpt.get(0).getLoadableStudy().getId());
        }
        log.info("confirming selected plan");
        loadablePatternRepository.updateLoadablePatternStatus(
            CONFIRMED_STATUS_ID, loadablePatternOpt.get().getId());
        loadableStudyRepository.updateLoadableStudyStatus(
            CONFIRMED_STATUS_ID, loadablePatternOpt.get().getLoadableStudy().getId());
        replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS).build());
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

  /**
   * @param request
   * @param responseObserver
   */
  @Override
  public void getLoadableStudyStatus(
      LoadableStudyStatusRequest request,
      StreamObserver<LoadableStudyStatusReply> responseObserver) {
    LoadableStudyStatusReply.Builder replyBuilder = LoadableStudyStatusReply.newBuilder();
    try {
      if (0 == request.getLoadablePatternId()) {
        log.info("Inside getLoadableStudyStatus");
        Optional<LoadableStudyAlgoStatus> loadableStudyAlgoStatusOpt =
            loadableStudyAlgoStatusRepository.findByLoadableStudyIdAndProcessIdAndIsActive(
                request.getLoadableStudyId(), request.getProcessId(), true);
        if (!loadableStudyAlgoStatusOpt.isPresent()) {
          log.info("Invalid loadable study Id");
          replyBuilder.setResponseStatus(
              ResponseStatus.newBuilder()
                  .setCode(CommonErrorCodes.E_HTTP_BAD_REQUEST)
                  .setMessage("Invalid loadable study Id")
                  .build());
        } else {
          replyBuilder.setLoadableStudystatusId(
              loadableStudyAlgoStatusOpt.get().getLoadableStudyStatus().getId());
          replyBuilder.setLoadableStudyStatusLastModifiedTime(
              loadableStudyAlgoStatusOpt.get().getLastModifiedDateTime().toString());
          replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS).build());
        }
      } else {
        log.info("Inside getLoadablePatternStatus");
        Optional<LoadablePatternAlgoStatus> loadablePatternAlgoStatusOpt =
            loadablePatternAlgoStatusRepository.findByLoadablePatternIdAndProcessIdAndIsActive(
                request.getLoadablePatternId(), request.getProcessId(), true);
        if (!loadablePatternAlgoStatusOpt.isPresent()) {
          log.info("Invalid loadable pattern Id");
          replyBuilder.setResponseStatus(
              ResponseStatus.newBuilder()
                  .setCode(CommonErrorCodes.E_HTTP_BAD_REQUEST)
                  .setMessage("Invalid loadable pattern Id")
                  .build());
        } else {
          replyBuilder.setLoadableStudystatusId(
              loadablePatternAlgoStatusOpt.get().getLoadableStudyStatus().getId());
          replyBuilder.setLoadableStudyStatusLastModifiedTime(
              loadablePatternAlgoStatusOpt.get().getLastModifiedDateTime().toString());
          replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS).build());
        }
      }

    } catch (Exception e) {
      log.error("Exception when getLoadableStudyStatus ", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage("Exception when saving Algo Loadable Study Status")
              .setStatus(FAILED)
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  /** Retrieves the synoptical data for a portId */
  @Override
  public void getSynopticalDataByPortId(
      SynopticalTableRequest request, StreamObserver<SynopticalTableReply> responseObserver) {
    SynopticalTableReply.Builder replyBuilder = SynopticalTableReply.newBuilder();
    try {
      Optional<LoadableStudy> loadableStudyOpt =
          this.loadableStudyRepository.findByIdAndIsActive(request.getLoadableStudyId(), true);
      if (!loadableStudyOpt.isPresent()) {
        throw new GenericServiceException(
            "Loadable study does not exist", CommonErrorCodes.E_HTTP_BAD_REQUEST, null);
      }
      /**
       * updated the request object with confirmed loadable pattern id which is needed only for
       * voyage status initiated flow. In case this method is reused for any other flow then the
       * loadable pattern id should be updated accordingly using probably a flag to track initiated
       * flow
       */
      List<LoadablePattern> confirmedLoadablePatternList =
          loadablePatternRepository.findByVoyageAndLoadableStudyStatusAndIsActive(
              request.getVoyageId(), CONFIRMED_STATUS_ID, true);
      Optional<LoadablePattern> confirmedLoadablePattern =
          confirmedLoadablePatternList.stream().findFirst();
      if (!confirmedLoadablePattern.isPresent()) {
        throw new GenericServiceException(
            "Confirmed loadable pattern does not exist", CommonErrorCodes.E_HTTP_BAD_REQUEST, null);
      }
      Long confirmedLoadablePatternId = confirmedLoadablePattern.get().getId();
      SynopticalTableRequest.Builder requestBuilder = request.toBuilder();
      requestBuilder.setLoadablePatternId(confirmedLoadablePatternId);
      // fetching synoptical entity list
      List<SynopticalTable> synopticalTableList =
          this.synopticalTableRepository.findByLoadableStudyXIdAndIsActiveAndPortXid(
              request.getLoadableStudyId(), true, request.getPortId());
      if (!synopticalTableList.isEmpty()) {
        // fetching vessel tanks including ohq and cargo tanks
        VesselReply vesselReply =
            this.getSynopticalTableVesselData(request, loadableStudyOpt.get());
        // sorting the tanks based on tank display order from vessel tank table
        List<VesselTankDetail> sortedTankList = new ArrayList<>(vesselReply.getVesselTanksList());
        Collections.sort(
            sortedTankList, Comparator.comparing(VesselTankDetail::getTankDisplayOrder));
        buildSynopticalTableReply(
            requestBuilder.build(),
            synopticalTableList,
            this.getSynopticalTablePortDetails(synopticalTableList),
            this.getSynopticalTablePortRotations(loadableStudyOpt.get()),
            loadableStudyOpt.get(),
            sortedTankList,
            vesselReply.getVesselLoadableQuantityDetails(),
            replyBuilder);
        // build ballast tank details not available in synoptical
        List<VesselTankDetail> ballastTankList =
            sortedTankList.stream()
                .filter(tankList -> BALLAST_TANK_CATEGORIES.contains(tankList.getTankCategoryId()))
                .collect(Collectors.toList());
        List<VesselTankDetail> frontBallastTanks = new ArrayList<>();
        List<VesselTankDetail> centerBallastTanks = new ArrayList<>();
        List<VesselTankDetail> rearBallastTanks = new ArrayList<>();
        frontBallastTanks.addAll(
            ballastTankList.stream()
                .filter(tank -> BALLAST_FRONT_TANK.equals(tank.getTankPositionCategory()))
                .collect(Collectors.toList()));
        centerBallastTanks.addAll(
            ballastTankList.stream()
                .filter(tank -> BALLAST_CENTER_TANK.equals(tank.getTankPositionCategory()))
                .collect(Collectors.toList()));
        rearBallastTanks.addAll(
            ballastTankList.stream()
                .filter(tank -> BALLAST_REAR_TANK.equals(tank.getTankPositionCategory()))
                .collect(Collectors.toList()));
        replyBuilder.addAllBallastFrontTanks(this.groupTanks(frontBallastTanks));
        replyBuilder.addAllBallastCenterTanks(this.groupTanks(centerBallastTanks));
        replyBuilder.addAllBallastRearTanks(this.groupTanks(rearBallastTanks));
        // build cargo layout tanks not available in synoptical
        replyBuilder.addAllCargoTanks(
            this.groupTanks(
                sortedTankList.stream()
                    .filter(
                        tankList -> CARGO_TANK_CATEGORIES.contains(tankList.getTankCategoryId()))
                    .collect(Collectors.toList())));
      }
      replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS));
    } catch (GenericServiceException e) {
      log.error("GenericServiceException in getSynopticalDataByPortId", e);
      replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(FAILED));
    } catch (Exception e) {
      log.error("Exception in getSynopticalDataByPortId", e);
      replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(FAILED));
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  /** Retrieves the synoptical port data for a portId */
  @Override
  public void getSynopticalPortDataByPortId(
      SynopticalTableRequest request, StreamObserver<SynopticalTableReply> responseObserver) {
    SynopticalTableReply.Builder replyBuilder = SynopticalTableReply.newBuilder();
    try {
      Optional<LoadableStudy> loadableStudyOpt =
          this.loadableStudyRepository.findById(request.getLoadableStudyId());
      if (!loadableStudyOpt.isPresent()) {
        throw new GenericServiceException(
            "Loadable study does not exist", CommonErrorCodes.E_HTTP_BAD_REQUEST, null);
      }
      List<SynopticalTable> synopticalTableList =
          this.synopticalTableRepository.findByLoadableStudyXIdAndIsActiveAndPortXid(
              request.getLoadableStudyId(), true, request.getPortId());
      if (!synopticalTableList.isEmpty()) {
        buildSynopticalPortDataReplyByPortId(synopticalTableList, replyBuilder);
      }
      replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS));
    } catch (GenericServiceException e) {
      log.error("GenericServiceException in getSynopticalDataByPortId", e);
      replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(FAILED));
    } catch (Exception e) {
      log.error("Exception in getSynopticalDataByPortId", e);
      replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(FAILED));
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  private void buildSynopticalPortDataReplyByPortId(
      List<SynopticalTable> synopticalTableList,
      com.cpdss.common.generated.LoadableStudy.SynopticalTableReply.Builder replyBuilder) {
    if (!CollectionUtils.isEmpty(synopticalTableList)) {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
      synopticalTableList.forEach(
          synopticalRecord -> {
            SynopticalRecord.Builder recordBuilder = SynopticalRecord.newBuilder();
            Optional.ofNullable(synopticalRecord.getOperationType())
                .ifPresent(recordBuilder::setOperationType);
            Optional.ofNullable(synopticalRecord.getDistance())
                .ifPresent(distance -> recordBuilder.setDistance(String.valueOf(distance)));
            Optional.ofNullable(synopticalRecord.getEtaActual())
                .ifPresent(
                    etaActual ->
                        recordBuilder.setEtaEtdActual(
                            formatter.format(synopticalRecord.getEtaActual())));
            Optional.ofNullable(synopticalRecord.getEtdActual())
                .ifPresent(
                    etdActual ->
                        recordBuilder.setEtaEtdActual(
                            formatter.format(synopticalRecord.getEtdActual())));
            replyBuilder.addSynopticalRecords(recordBuilder);
          });
    }
  }

  @Transactional
  public void checkDuplicatedFromAndCloneEntity(LoadableStudyDetail request, LoadableStudy entity)
      throws GenericServiceException {

    if (0 != request.getDuplicatedFromId()) {
      try {

        List<CargoNomination> cargoNominationList =
            this.cargoNominationRepository.findByLoadableStudyXIdAndIsActive(
                request.getDuplicatedFromId(), true);
        Map<Long, Long> cargoNominationIdMap = new HashMap<>();
        if (!cargoNominationList.isEmpty()) {
          cargoNominationList.forEach(
              cargoNomination -> {
                Long id = cargoNomination.getId();
                CargoNomination crgoNomination = new CargoNomination();
                List<CargoNominationPortDetails> oldCargoNominationPortDetails =
                    this.cargoNominationOperationDetailsRepository
                        .findByCargoNominationnAndIsActive(cargoNomination, true);

                BeanUtils.copyProperties(cargoNomination, crgoNomination);
                crgoNomination.setLoadableStudyXId(entity.getId());
                crgoNomination.setId(null);
                crgoNomination.setCargoNominationPortDetails(
                    new HashSet<CargoNominationPortDetails>());
                oldCargoNominationPortDetails.forEach(
                    oldCargo -> {
                      CargoNominationPortDetails cargoNominationPortDetails =
                          new CargoNominationPortDetails();
                      BeanUtils.copyProperties(oldCargo, cargoNominationPortDetails);
                      cargoNominationPortDetails.setId(null);
                      cargoNominationPortDetails.setCargoNomination(crgoNomination);
                      crgoNomination
                          .getCargoNominationPortDetails()
                          .add(cargoNominationPortDetails);
                    });
                CargoNomination ent = this.cargoNominationRepository.save(crgoNomination);
                cargoNominationIdMap.put(id, ent.getId());
              });
        }

        List<LoadableStudyPortRotation> loadableStudyPortRotationParentList =
            this.loadableStudyPortRotationRepository.findByLoadableStudyAndIsActive(
                request.getDuplicatedFromId(), true);
        List<LoadableStudyPortRotation> loadableStudyDuplicatedPorts = new ArrayList<>();
        if (!loadableStudyPortRotationParentList.isEmpty()) {
          for (LoadableStudyPortRotation loadableStudyPortRotation :
              loadableStudyPortRotationParentList) {
            entityManager.detach(loadableStudyPortRotation);
            loadableStudyPortRotation.setId(null);
            loadableStudyPortRotation.setLoadableStudy(entity);
            loadableStudyDuplicatedPorts.add(loadableStudyPortRotation);
          }
          loadableStudyDuplicatedPorts =
              this.loadableStudyPortRotationRepository.saveAll(loadableStudyDuplicatedPorts);
        }

        Optional<LoadableStudy> loadableStudyOpt =
            this.loadableStudyRepository.findByIdAndIsActive(request.getDuplicatedFromId(), true);
        if (!loadableStudyOpt.isPresent()) {
          throw new GenericServiceException(
              "Loadable study does not exist",
              CommonErrorCodes.E_HTTP_BAD_REQUEST,
              HttpStatusCode.BAD_REQUEST);
        }
        entity.setDischargeCargoId(loadableStudyOpt.get().getDischargeCargoId());
        entity.setLoadOnTop(loadableStudyOpt.get().getLoadOnTop());

        List<OnHandQuantity> onHandQuantityList =
            this.onHandQuantityRepository.findByLoadableStudyAndIsActive(
                loadableStudyOpt.get(), true);
        if (!onHandQuantityList.isEmpty()) {
          List<OnHandQuantity> OnHandQuantities = new ArrayList<OnHandQuantity>();

          onHandQuantityList.forEach(
              onHandQuantity -> {
                entityManager.detach(onHandQuantity);
                onHandQuantity.setId(null);
                onHandQuantity.setLoadableStudy(entity);
                onHandQuantity.setActualArrivalQuantity(null);
                onHandQuantity.setActualDepartureQuantity(null);
                OnHandQuantities.add(onHandQuantity);
              });
          this.onHandQuantityRepository.saveAll(OnHandQuantities);
        }
        List<OnBoardQuantity> onBoardQuantityList =
            this.onBoardQuantityRepository.findByLoadableStudyAndIsActive(
                loadableStudyOpt.get(), true);
        if (!onBoardQuantityList.isEmpty()) {
          List<OnBoardQuantity> OnBoardQuantities = new ArrayList<OnBoardQuantity>();

          onBoardQuantityList.forEach(
              onBoardQuantity -> {
                entityManager.detach(onBoardQuantity);
                onBoardQuantity.setId(null);
                onBoardQuantity.setLoadableStudy(entity);
                onBoardQuantity.setActualArrivalWeight(null);
                onBoardQuantity.setActualDepartureWeight(null);
                OnBoardQuantities.add(onBoardQuantity);
              });
          this.onBoardQuantityRepository.saveAll(OnBoardQuantities);
        }

        List<LoadableQuantity> loadableQuantityList =
            this.loadableQuantityRepository.findByLoadableStudyXIdAndIsActive(
                request.getDuplicatedFromId(), true);
        if (!loadableQuantityList.isEmpty()) {
          List<LoadableQuantity> loadableQuantities = new ArrayList<LoadableQuantity>();

          loadableQuantityList.forEach(
              loadableQuantity -> {
                entityManager.detach(loadableQuantity);
                loadableQuantity.setId(null);
                loadableQuantity.setLoadableStudyXId(entity);
                loadableQuantities.add(loadableQuantity);
              });
          this.loadableQuantityRepository.saveAll(loadableQuantities);
        }

        List<com.cpdss.loadablestudy.entity.CommingleCargo> CommingleCargoList =
            this.commingleCargoRepository.findByLoadableStudyXIdAndIsActive(
                request.getDuplicatedFromId(), true);
        if (!CommingleCargoList.isEmpty()) {
          List<com.cpdss.loadablestudy.entity.CommingleCargo> CommingleCargos = new ArrayList<>();

          CommingleCargoList.forEach(
              commingleCargo -> {
                entityManager.detach(commingleCargo);
                commingleCargo.setId(null);
                commingleCargo.setLoadableStudyXId(entity.getId());
                commingleCargo.setCargoNomination1Id(
                    cargoNominationIdMap.get(commingleCargo.getCargoNomination1Id()));
                commingleCargo.setCargoNomination2Id(
                    cargoNominationIdMap.get(commingleCargo.getCargoNomination2Id()));
                CommingleCargos.add(commingleCargo);
              });
          this.commingleCargoRepository.saveAll(CommingleCargos);
        }

        List<SynopticalTable> synopticalTableList =
            this.synopticalTableRepository.findByLoadableStudyXIdAndIsActive(
                request.getDuplicatedFromId(), true);

        if (!synopticalTableList.isEmpty()) {
          List<SynopticalTable> synopticalTables = new ArrayList<>();
          for (SynopticalTable synopticalTable : synopticalTableList) {
            LoadableStudyPortRotation parent = synopticalTable.getLoadableStudyPortRotation();
            Optional<LoadableStudyPortRotation> duplicated =
                loadableStudyDuplicatedPorts.stream()
                    .filter(
                        port ->
                            port.getPortXId().equals(parent.getPortXId())
                                && port.getOperation().getId().equals(parent.getOperation().getId())
                                && port.getPortOrder().equals(parent.getPortOrder()))
                    .findAny();
            if (!duplicated.isPresent()) {
              throw new GenericServiceException(
                  "Could not find the duplicated port rotation entity",
                  CommonErrorCodes.E_GEN_INTERNAL_ERR,
                  HttpStatusCode.BAD_REQUEST);
            }
            entityManager.detach(synopticalTable);
            synopticalTable.setId(null);
            synopticalTable.setLoadableStudyPortRotation(duplicated.get());
            synopticalTable.setLoadableStudyXId(entity.getId());
            synopticalTable.setEtaActual(null);
            synopticalTable.setEtdActual(null);
            synopticalTable.setConstantActual(null);
            synopticalTable.setDisplacementActual(null);
            synopticalTable.setConstantActual(null);
            synopticalTable.setDeadWeightActual(null);

            synopticalTables.add(synopticalTable);
          }
          this.synopticalTableRepository.saveAll(synopticalTables);
        }

        List<LoadableStudyAttachments> loadableStudyAttachmentsList =
            this.loadableStudyAttachmentsRepository.findByLoadableStudyXIdAndIsActive(
                request.getDuplicatedFromId(), true);

        if (!loadableStudyAttachmentsList.isEmpty()) {
          List<LoadableStudyAttachments> loadableStudyAttachments =
              new ArrayList<LoadableStudyAttachments>();

          loadableStudyAttachmentsList.forEach(
              loadableStudyAttachment -> {
                entityManager.detach(loadableStudyAttachment);
                loadableStudyAttachment.setId(null);
                loadableStudyAttachment.setLoadableStudy(entity);
                loadableStudyAttachments.add(loadableStudyAttachment);
              });
          this.loadableStudyAttachmentsRepository.saveAll(loadableStudyAttachments);
        }

      } catch (Exception e) {
        log.error("GenericServiceException in checkDuplicatedFromAndCloneEntity", e);
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        throw new GenericServiceException(
            "Failed to save duplicate entries", CommonErrorCodes.E_GEN_INTERNAL_ERR, null);
      }
    }
  }

  @Override
  public void downloadLoadableStudyAttachment(
      LoadableStudyAttachmentRequest request,
      StreamObserver<LoadableStudyAttachmentReply> responseObserver) {
    LoadableStudyAttachmentReply.Builder builder = LoadableStudyAttachmentReply.newBuilder();
    try {
      LoadableStudyAttachments attachment =
          loadableStudyAttachmentsRepository.findByIdAndLoadableStudyXIdAndIsActive(
              request.getFileId(), request.getLoadableStudyId(), true);
      if (null == attachment) {
        throw new GenericServiceException(
            "Attachment does not exist",
            CommonErrorCodes.E_HTTP_BAD_REQUEST,
            HttpStatusCode.BAD_REQUEST);
      }
      builder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS).build());
      builder.setFilePath(this.rootFolder + attachment.getFilePath());
    } catch (GenericServiceException e) {
      log.error("GenericServiceException in downloadLoadableStudyAttachment", e);
      builder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setStatus(FAILED)
              .setCode(CommonErrorCodes.E_HTTP_BAD_REQUEST)
              .build());
    } catch (Exception e) {
      log.error("Exception in downloadLoadableStudyAttachment", e);
      builder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setStatus(FAILED)
              .setCode(CommonErrorCodes.E_HTTP_BAD_REQUEST)
              .build());
    } finally {
      responseObserver.onNext(builder.build());
      responseObserver.onCompleted();
    }
  }

  /*
   * To save all port rotation details
   */
  @Override
  public void saveLoadableStudyPortRotationList(
      PortRotationRequest request, StreamObserver<PortRotationReply> responseObserver) {
    PortRotationReply.Builder replyBuilder = PortRotationReply.newBuilder();
    try {
      Optional<LoadableStudy> loadableStudyOpt =
          this.loadableStudyRepository.findById(request.getLoadableStudyId());
      if (!loadableStudyOpt.isPresent()) {
        throw new GenericServiceException(
            "Loadable study does not exist",
            CommonErrorCodes.E_HTTP_BAD_REQUEST,
            HttpStatusCode.BAD_REQUEST);
      }
      this.checkIfVoyageClosed(loadableStudyOpt.get().getVoyage().getId());
      // validates the input port rotation list for valid ids
      List<LoadableStudyPortRotation> existingPortRotationList = new ArrayList<>();
      if (!CollectionUtils.isEmpty(request.getPortRotationDetailsList())) {
        for (PortRotationDetail requestPortRotation : request.getPortRotationDetailsList()) {
          Optional<LoadableStudyPortRotation> portRotation =
              this.loadableStudyPortRotationRepository.findById(requestPortRotation.getId());
          if (!portRotation.isPresent()) {
            throw new GenericServiceException(
                "Port rotation does not exist",
                CommonErrorCodes.E_HTTP_BAD_REQUEST,
                HttpStatusCode.BAD_REQUEST);
          }
          existingPortRotationList.add(portRotation.get());
        }
      }
      createPortRotationEntityList(existingPortRotationList, request);
      if (!CollectionUtils.isEmpty(existingPortRotationList)) {
        this.loadableStudyPortRotationRepository.saveAll(existingPortRotationList);
      }
      replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS).build());
    } catch (GenericServiceException e) {
      log.error("GenericServiceException when saveLoadableStudyPortRotationList", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(e.getCode())
              .setMessage(e.getMessage())
              .setStatus(FAILED)
              .setHttpStatusCode(e.getStatus().value())
              .build());
    } catch (Exception e) {
      log.error("Exception when saveLoadableStudyPortRotationList", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage("Exception when saving port data")
              .setStatus(FAILED)
              .setHttpStatusCode(Integer.valueOf(CommonErrorCodes.E_GEN_INTERNAL_ERR))
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  /*
   * builds list of port rotation entities for bulk save
   */
  private List<LoadableStudyPortRotation> createPortRotationEntityList(
      List<LoadableStudyPortRotation> existingPortRotationList,
      PortRotationRequest portRotationRequest) {
    if (!CollectionUtils.isEmpty(existingPortRotationList)
        && !CollectionUtils.isEmpty(portRotationRequest.getPortRotationDetailsList())) {
      existingPortRotationList.forEach(
          entity ->
              portRotationRequest.getPortRotationDetailsList().stream()
                  .filter(requestPort -> requestPort.getId() == entity.getId().longValue())
                  .forEach(request -> buildLoadableStudyPortRotationEntity(entity, request)));
    }
    return existingPortRotationList;
  }

  /*
   * builds single entity from the request
   */
  private void buildLoadableStudyPortRotationEntity(
      LoadableStudyPortRotation entity, PortRotationDetail request) {
    entity.setAirDraftRestriction(
        isEmpty(request.getMaxAirDraft()) ? null : new BigDecimal(request.getMaxAirDraft()));
    entity.setBerthXId(0 == request.getBerthId() ? null : request.getBerthId());
    entity.setPortXId(0 == request.getPortId() ? null : request.getPortId());
    entity.setDistanceBetweenPorts(
        isEmpty(request.getDistanceBetweenPorts())
            ? null
            : new BigDecimal(request.getDistanceBetweenPorts()));
    entity.setMaxDraft(
        isEmpty(request.getMaxDraft()) ? null : new BigDecimal(request.getMaxDraft()));
    entity.setSeaWaterDensity(
        isEmpty(request.getSeaWaterDensity())
            ? null
            : new BigDecimal(request.getSeaWaterDensity()));
    entity.setTimeOfStay(
        isEmpty(request.getTimeOfStay()) ? null : new BigDecimal(request.getTimeOfStay()));
    entity.setEta(
        isEmpty(request.getEta())
            ? null
            : LocalDateTime.from(
                DateTimeFormatter.ofPattern(ETA_ETD_FORMAT).parse(request.getEta())));
    entity.setEtd(
        isEmpty(request.getEtd())
            ? null
            : LocalDateTime.from(
                DateTimeFormatter.ofPattern(ETA_ETD_FORMAT).parse(request.getEtd())));
    entity.setLayCanFrom(
        isEmpty(request.getLayCanFrom())
            ? null
            : LocalDate.from(
                DateTimeFormatter.ofPattern(LAY_CAN_FORMAT).parse(request.getLayCanFrom())));
    entity.setLayCanTo(
        isEmpty(request.getLayCanTo())
            ? null
            : LocalDate.from(
                DateTimeFormatter.ofPattern(LAY_CAN_FORMAT).parse(request.getLayCanTo())));
    entity.setOperation(this.cargoOperationRepository.getOne(request.getOperationId()));
    entity.setPortOrder(0 == request.getPortOrder() ? null : request.getPortOrder());
    // update distance, etaActual, etdActual values in synoptical
    if (!CollectionUtils.isEmpty(entity.getSynopticalTable())) {
      entity
          .getSynopticalTable()
          .forEach(
              record -> {
                record.setDistance(
                    !StringUtils.isEmpty(request.getDistanceBetweenPorts())
                        ? new BigDecimal(request.getDistanceBetweenPorts())
                        : null);
                if (SYNOPTICAL_TABLE_OP_TYPE_ARRIVAL.equalsIgnoreCase(record.getOperationType())) {
                  record.setEtaActual(
                      isEmpty(request.getEtaActual())
                          ? null
                          : LocalDateTime.from(
                              DateTimeFormatter.ofPattern(ETA_ETD_FORMAT)
                                  .parse(request.getEtaActual())));
                } else {
                  record.setEtdActual(
                      isEmpty(request.getEtdActual())
                          ? null
                          : LocalDateTime.from(
                              DateTimeFormatter.ofPattern(ETA_ETD_FORMAT)
                                  .parse(request.getEtdActual())));
                }
              });
    }
  }

  @Override
  public void saveComment(
      SaveCommentRequest request, StreamObserver<SaveCommentReply> responseObserver) {

    SaveCommentReply.Builder replyBuilder = SaveCommentReply.newBuilder();
    try {
      LoadablePlanComments entity = new LoadablePlanComments();
      entity.setComments(request.getComment());
      Optional<LoadablePattern> loadablePatternOpt =
          this.loadablePatternRepository.findByIdAndIsActive(request.getLoadablePatternId(), true);
      if (loadablePatternOpt.isPresent()) {
        entity.setLoadablePattern(loadablePatternOpt.get());
      }
      entity.setCreatedBy(Long.toString(request.getUser()));

      entity.setIsActive(true);
      entity = this.loadablePlanCommentsRepository.save(entity);

      replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS).build());
    } catch (Exception e) {
      log.error("Error saving comment", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage("Error saving comment")
              .setStatus(FAILED)
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  public void saveLoadOnTop(
      com.cpdss.common.generated.LoadableStudy.SaveLoadOnTopRequest request,
      io.grpc.stub.StreamObserver<SaveCommentReply> responseObserver) {
    SaveCommentReply.Builder replyBuilder = SaveCommentReply.newBuilder();
    try {
      Optional<LoadableStudy> loadableStudyOpt =
          this.loadableStudyRepository.findByIdAndIsActive(request.getLoadableStudyId(), true);

      if (!loadableStudyOpt.isPresent()) {
        throw new GenericServiceException(
            "LoadableStudy does not exist",
            CommonErrorCodes.E_HTTP_BAD_REQUEST,
            HttpStatusCode.BAD_REQUEST);
      }
      isPatternGeneratedOrConfirmed(loadableStudyOpt.get());
      this.checkIfVoyageClosed(loadableStudyOpt.get().getVoyage().getId());

      LoadableStudy entity = loadableStudyOpt.get();
      entity.setLoadOnTop(request.getLoadOnTop());
      entity = this.loadableStudyRepository.save(entity);

      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder().setStatus(SUCCESS).setMessage(SUCCESS).build());
    } catch (GenericServiceException e) {
      log.error("GenericServiceException when saving load on top", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(e.getCode())
              .setMessage(e.getMessage())
              .setStatus(FAILED)
              .setHttpStatusCode(e.getStatus().value())
              .build());
    } catch (Exception e) {
      log.error("Error saving load on top", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage("Error saving load on top")
              .setStatus(FAILED)
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  /**
   * Save to loadicator tables
   *
   * @param loadableStudyEntity
   * @param processId
   */
  public void saveLoadicatorInfo(LoadableStudy loadableStudyEntity, String processId) {
    LoadicatorRequest.Builder loadicatorRequestBuilder = LoadicatorRequest.newBuilder();
    try {
      List<LoadablePattern> loadablePatterns =
          this.loadablePatternRepository.findByLoadableStudyAndIsActive(loadableStudyEntity, true);
      if (null == loadablePatterns) {
        throw new GenericServiceException(
            "No loadable patterns found for this loadable study",
            CommonErrorCodes.E_HTTP_BAD_REQUEST,
            HttpStatusCode.BAD_REQUEST);
      }
      List<Long> loadablePatternIds =
          loadablePatterns.stream().map(LoadablePattern::getId).collect(Collectors.toList());
      List<com.cpdss.loadablestudy.entity.LoadablePatternCargoDetails> loadablePatternCargoDetails =
          this.loadablePatternCargoDetailsRepository.findByLoadablePatternIdInAndIsActive(
              loadablePatternIds, true);
      List<LoadablePlanStowageBallastDetails> loadablePatternBallastList =
          this.loadablePlanStowageBallastDetailsRepository.findByLoadablePatternIdInAndIsActive(
              loadablePatternIds, true);
      List<SynopticalTable> synopticalEntities =
          this.synopticalTableRepository.findByLoadableStudyXIdAndIsActive(
              loadableStudyEntity.getId(), true);
      List<OnHandQuantity> ohqEntities =
          this.onHandQuantityRepository.findByLoadableStudyAndIsActive(loadableStudyEntity, true);
      CargoReply cargoReply = this.getCargoInfoForLoadicator(loadableStudyEntity);
      VesselReply vesselReply = this.getVesselDetailsForLoadicator(loadableStudyEntity);
      PortReply portReply = this.getPortInfoForLoadicator(loadableStudyEntity);
      for (LoadablePattern pattern : loadablePatterns) {
        for (SynopticalTable synopticalEntity : synopticalEntities) {
          loadicatorRequestBuilder.addStowagePlanDetails(
              this.buildLoadicatorStowagePlan(
                  pattern,
                  synopticalEntity,
                  portReply,
                  vesselReply,
                  cargoReply,
                  processId,
                  loadableStudyEntity,
                  loadablePatternCargoDetails,
                  loadablePatternBallastList,
                  ohqEntities));
        }
      }
      LoadicatorReply reply = this.saveLoadicatorInfo(loadicatorRequestBuilder.build());

    } catch (GenericServiceException e) {
      log.error("Error in saveLoadicatorInfo ", e);
    } catch (Exception e) {
      log.error("Error saving LoadicatorInfo ", e);
    }
  }

  /**
   * Build loadicator stowage plan
   *
   * @param pattern
   * @param synopticalEntity
   * @param portReply
   * @param vesselReply
   * @param cargoReply
   * @param processId
   * @param loadableStudyEntity
   * @param loadablePatternCargoDetails
   * @param loadablePatternBallastList
   * @param ohqEntities
   * @return
   */
  private StowagePlan buildLoadicatorStowagePlan(
      LoadablePattern pattern,
      SynopticalTable synopticalEntity,
      PortReply portReply,
      VesselReply vesselReply,
      CargoReply cargoReply,
      String processId,
      LoadableStudy loadableStudyEntity,
      List<com.cpdss.loadablestudy.entity.LoadablePatternCargoDetails> loadablePatternCargoDetails,
      List<LoadablePlanStowageBallastDetails> loadablePatternBallastList,
      List<OnHandQuantity> ohqEntities) {
    StowagePlan.Builder stowagePlanBuilder = StowagePlan.newBuilder();
    this.buildLoadicatorStowagePlan(
        stowagePlanBuilder,
        pattern,
        synopticalEntity,
        portReply,
        vesselReply,
        processId,
        loadableStudyEntity);
    this.buildLoadicatorStowagePlanDetails(
        stowagePlanBuilder, loadablePatternCargoDetails, vesselReply, cargoReply, synopticalEntity);
    this.buildLoadicatorCargoDetails(
        stowagePlanBuilder, loadablePatternCargoDetails, synopticalEntity, cargoReply);
    this.buildLoadicatorBallastDetails(
        stowagePlanBuilder, vesselReply, synopticalEntity, loadablePatternBallastList);
    this.buildLoadicatorOhqDetails(stowagePlanBuilder, vesselReply, synopticalEntity, ohqEntities);
    return stowagePlanBuilder.build();
  }

  /**
   * Build stowage plan
   *
   * @param stowagePlanBuilder
   * @param pattern
   * @param synopticalEntity
   * @param portReply
   * @param vesselReply
   * @param processId
   * @param loadableStudyEntity
   */
  private void buildLoadicatorStowagePlan(
      com.cpdss.common.generated.Loadicator.StowagePlan.Builder stowagePlanBuilder,
      LoadablePattern pattern,
      SynopticalTable synopticalEntity,
      PortReply portReply,
      VesselReply vesselReply,
      String processId,
      LoadableStudy loadableStudyEntity) {
    stowagePlanBuilder.setProcessId(processId);
    VesselDetail vessel = vesselReply.getVesselsList().get(0);
    Optional.ofNullable(vessel.getId()).ifPresent(stowagePlanBuilder::setVesselId);
    Optional.ofNullable(vessel.getImoNumber()).ifPresent(stowagePlanBuilder::setImoNumber);
    Optional.ofNullable(vessel.getTypeOfShip()).ifPresent(stowagePlanBuilder::setShipType);
    Optional.ofNullable(vessel.getCode()).ifPresent(stowagePlanBuilder::setVesselCode);
    Optional.ofNullable(vessel.getProvisionalConstant())
        .ifPresent(stowagePlanBuilder::setProvisionalConstant);
    Optional.ofNullable(vessel.getDeadweightConstant())
        .ifPresent(stowagePlanBuilder::setDeadweightConstant);
    stowagePlanBuilder.setPortId(synopticalEntity.getLoadableStudyPortRotation().getId());
    stowagePlanBuilder.setStowageId(pattern.getId());
    stowagePlanBuilder.setStatus(STOWAGE_STATUS);
    stowagePlanBuilder.setBookingListId(loadableStudyEntity.getId());
    Optional<PortDetail> portDetail =
        portReply.getPortsList().stream()
            .filter(
                port ->
                    Long.valueOf(port.getId())
                        .equals(synopticalEntity.getLoadableStudyPortRotation().getId()))
            .findAny();
    if (portDetail.isPresent()) {
      Optional.ofNullable(portDetail.get().getCode()).ifPresent(stowagePlanBuilder::setPortCode);
    }
  }

  /**
   * Build stowage plan details
   *
   * @param stowagePlanBuilder
   * @param loadablePatternCargoDetails
   * @param vesselReply
   * @param cargoReply
   * @param synopticalEntity
   */
  private void buildLoadicatorStowagePlanDetails(
      StowagePlan.Builder stowagePlanBuilder,
      List<com.cpdss.loadablestudy.entity.LoadablePatternCargoDetails> loadablePatternCargoDetails,
      VesselReply vesselReply,
      CargoReply cargoReply,
      SynopticalTable synopticalEntity) {
    List<com.cpdss.loadablestudy.entity.LoadablePatternCargoDetails> synopticalWiseList =
        loadablePatternCargoDetails.stream()
            .filter(
                cargo ->
                    synopticalEntity
                            .getLoadableStudyPortRotation()
                            .getId()
                            .equals(cargo.getPortRotationId())
                        && synopticalEntity.getOperationType().equals(cargo.getOperationType()))
            .collect(Collectors.toList());
    synopticalWiseList.forEach(
        patternCargo -> {
          this.buildLoadicatorStowagePlanDetails(
              patternCargo, stowagePlanBuilder, cargoReply, vesselReply);
        });
  }

  /**
   * Build stowage plan details
   *
   * @param patternCargo
   * @param stowagePlanBuilder
   * @param cargoReply
   * @param vesselReply
   */
  private void buildLoadicatorStowagePlanDetails(
      com.cpdss.loadablestudy.entity.LoadablePatternCargoDetails patternCargo,
      com.cpdss.common.generated.Loadicator.StowagePlan.Builder stowagePlanBuilder,
      CargoReply cargoReply,
      VesselReply vesselReply) {
    StowageDetails.Builder stowageDetailsBuilder = StowageDetails.newBuilder();
    Optional.ofNullable(patternCargo.getCargoId()).ifPresent(stowageDetailsBuilder::setCargoId);
    Optional.ofNullable(patternCargo.getTankId()).ifPresent(stowageDetailsBuilder::setTankId);
    Optional.ofNullable(patternCargo.getPlannedQuantity())
        .ifPresent(quantity -> stowageDetailsBuilder.setQuantity(String.valueOf(quantity)));
    Optional.ofNullable(patternCargo.getAbbreviation())
        .ifPresent(stowageDetailsBuilder::setCargoName);
    Optional.ofNullable(patternCargo.getPortId()).ifPresent(stowageDetailsBuilder::setPortId);
    Optional.ofNullable(patternCargo.getLoadablePatternId())
        .ifPresent(stowageDetailsBuilder::setStowageId);
    Optional<VesselTankDetail> tankDetail =
        vesselReply.getVesselTanksList().stream()
            .filter(tank -> Long.valueOf(tank.getTankId()).equals(patternCargo.getTankId()))
            .findAny();
    if (tankDetail.isPresent()) {
      Optional.ofNullable(tankDetail.get().getTankName())
          .ifPresent(stowageDetailsBuilder::setTankName);
      Optional.ofNullable(tankDetail.get().getShortName())
          .ifPresent(stowageDetailsBuilder::setShortName);
    }
    Optional<CargoDetail> cargoDetail =
        cargoReply.getCargosList().stream()
            .filter(c -> Long.valueOf(c.getId()).equals(patternCargo.getId()))
            .findAny();
    if (cargoDetail.isPresent()) {
      Optional.ofNullable(cargoDetail.get().getCrudeType())
          .ifPresent(stowageDetailsBuilder::setCargoName);
    }
    stowagePlanBuilder.addStowageDetails(stowageDetailsBuilder.build());
  }

  /**
   * Build cargo details
   *
   * @param stowagePlanBuilder
   * @param loadablePatternCargoDetails
   * @param synopticalEntity
   * @param cargoReply
   */
  @SuppressWarnings("unchecked")
  private void buildLoadicatorCargoDetails(
      com.cpdss.common.generated.Loadicator.StowagePlan.Builder stowagePlanBuilder,
      List<com.cpdss.loadablestudy.entity.LoadablePatternCargoDetails> loadablePatternCargoDetails,
      SynopticalTable synopticalEntity,
      CargoReply cargoReply) {
    List<com.cpdss.loadablestudy.entity.LoadablePatternCargoDetails> synopticalWiseList =
        loadablePatternCargoDetails.stream()
            .filter(
                cargo ->
                    synopticalEntity
                            .getLoadableStudyPortRotation()
                            .getId()
                            .equals(cargo.getPortRotationId())
                        && synopticalEntity.getOperationType().equals(cargo.getOperationType()))
            .collect(Collectors.toList());
    synopticalWiseList =
        synopticalWiseList.stream()
            .filter(
                distinctByKeys(
                    com.cpdss.loadablestudy.entity.LoadablePatternCargoDetails::getCargoId))
            .collect(Collectors.toList());
    synopticalWiseList.forEach(
        patternCargo ->
            stowagePlanBuilder.addCargoInfo(
                this.buildLoadicatorCargoDetails(patternCargo, cargoReply)));
  }

  /**
   * Build cargo
   *
   * @param cargo
   * @return
   */
  private CargoInfo buildLoadicatorCargoDetails(
      com.cpdss.loadablestudy.entity.LoadablePatternCargoDetails cargo, CargoReply cargoReply) {
    CargoInfo.Builder cargoBuilder = CargoInfo.newBuilder();
    Optional.ofNullable(String.valueOf(cargo.getAbbreviation()))
        .ifPresent(cargoBuilder::setCargoAbbrev);
    Optional.ofNullable(String.valueOf(cargo.getApi())).ifPresent(cargoBuilder::setApi);
    Optional.ofNullable(String.valueOf(cargo.getTemperature()))
        .ifPresent(cargoBuilder::setStandardTemp);
    Optional.ofNullable(cargo.getPortId()).ifPresent(cargoBuilder::setPortId);
    Optional.ofNullable(cargo.getLoadablePatternId()).ifPresent(cargoBuilder::setStowageId);
    return cargoBuilder.build();
  }

  /**
   * Build ballast details
   *
   * @param stowagePlanBuilder
   * @param vesselReply
   * @param synopticalEntity
   * @param loadablePatternBallastList
   */
  private void buildLoadicatorBallastDetails(
      com.cpdss.common.generated.Loadicator.StowagePlan.Builder stowagePlanBuilder,
      VesselReply vesselReply,
      SynopticalTable synopticalEntity,
      List<LoadablePlanStowageBallastDetails> loadablePatternBallastList) {
    List<LoadablePlanStowageBallastDetails> synopticalWiseList =
        loadablePatternBallastList.stream()
            .filter(
                ballast ->
                    synopticalEntity
                            .getLoadableStudyPortRotation()
                            .getId()
                            .equals(ballast.getPortRotationId())
                        && synopticalEntity.getOperationType().equals(ballast.getOperationType()))
            .collect(Collectors.toList());
    synopticalWiseList.forEach(
        patternBallast ->
            this.buildLoadicatorBallastDetails(patternBallast, stowagePlanBuilder, vesselReply));
  }

  /**
   * Build ballast details
   *
   * @param ballast
   * @param stowagePlanBuilder
   * @param vesselReply
   */
  private void buildLoadicatorBallastDetails(
      LoadablePlanStowageBallastDetails ballast,
      com.cpdss.common.generated.Loadicator.StowagePlan.Builder stowagePlanBuilder,
      VesselReply vesselReply) {

    BallastInfo.Builder ballastBuilder = BallastInfo.newBuilder();
    Optional.ofNullable(String.valueOf(ballast.getQuantity()))
        .ifPresent(ballastBuilder::setQuantity);
    Optional.ofNullable(ballast.getLoadablePatternId()).ifPresent(ballastBuilder::setStowageId);
    Optional.ofNullable(ballast.getTankXId()).ifPresent(ballastBuilder::setTankId);
    Optional.ofNullable(ballast.getPortXId()).ifPresent(ballastBuilder::setPortId);
    Optional<VesselTankDetail> tankDetail =
        vesselReply.getVesselTanksList().stream()
            .filter(tank -> Long.valueOf(tank.getTankId()).equals(ballast.getTankXId()))
            .findAny();
    if (tankDetail.isPresent()) {
      Optional.ofNullable(tankDetail.get().getTankName()).ifPresent(ballastBuilder::setTankName);
      Optional.ofNullable(tankDetail.get().getShortName()).ifPresent(ballastBuilder::setShortName);
    }
    stowagePlanBuilder.addBallastInfo(ballastBuilder.build());
  }

  /**
   * Build loadicator OHQ data
   *
   * @param stowagePlanBuilder
   * @param vesselReply
   * @param synopticalEntity
   * @param ohqEntities
   */
  private void buildLoadicatorOhqDetails(
      com.cpdss.common.generated.Loadicator.StowagePlan.Builder stowagePlanBuilder,
      VesselReply vesselReply,
      SynopticalTable synopticalEntity,
      List<OnHandQuantity> ohqEntities) {
    List<OnHandQuantity> synopticalWiseList =
        ohqEntities.stream()
            .filter(
                ohq ->
                    ohq.getPortRotation()
                        .getId()
                        .equals(synopticalEntity.getLoadableStudyPortRotation().getId()))
            .collect(Collectors.toList());
    synopticalWiseList.forEach(
        ohq -> {
          OtherTankInfo.Builder otherTankBuilder = OtherTankInfo.newBuilder();
          otherTankBuilder.setTankId(ohq.getTankXId());
          Optional<VesselTankDetail> tankDetail =
              vesselReply.getVesselTanksList().stream()
                  .filter(tank -> Long.valueOf(tank.getTankId()).equals(ohq.getTankXId()))
                  .findAny();
          if (tankDetail.isPresent()) {
            Optional.ofNullable(tankDetail.get().getTankName())
                .ifPresent(otherTankBuilder::setTankName);
            Optional.ofNullable(tankDetail.get().getShortName())
                .ifPresent(otherTankBuilder::setShortName);
          }
          if (SYNOPTICAL_TABLE_OP_TYPE_ARRIVAL.equals(synopticalEntity.getOperationType())) {
            Optional.ofNullable(ohq.getArrivalQuantity())
                .ifPresent(qty -> otherTankBuilder.setQuantity(valueOf(qty)));
          } else {
            Optional.ofNullable(ohq.getDepartureQuantity())
                .ifPresent(qty -> otherTankBuilder.setQuantity(valueOf(qty)));
          }
          stowagePlanBuilder.addOtherTankInfo(otherTankBuilder.build());
        });
  }

  /**
   * Get port info for loadicator
   *
   * @param loadableStudyEntity
   * @return
   * @throws GenericServiceException
   */
  private PortReply getPortInfoForLoadicator(LoadableStudy loadableStudyEntity)
      throws GenericServiceException {
    PortRequest portRequest =
        PortRequest.newBuilder()
            .setVesselId(loadableStudyEntity.getVesselXId())
            .setVoyageId(loadableStudyEntity.getVoyage().getId())
            .setLoadableStudyId(loadableStudyEntity.getId())
            .build();
    PortReply portReply = this.GetPortInfo(portRequest);
    if (!SUCCESS.equalsIgnoreCase(portReply.getResponseStatus().getStatus())) {
      throw new GenericServiceException(
          "Error in calling cargo service",
          CommonErrorCodes.E_GEN_INTERNAL_ERR,
          HttpStatusCode.INTERNAL_SERVER_ERROR);
    }
    return portReply;
  }

  /**
   * get vessel detail for loadicator
   *
   * @param loadableStudyEntity
   * @return
   * @throws GenericServiceException
   */
  private VesselReply getVesselDetailsForLoadicator(LoadableStudy loadableStudyEntity)
      throws GenericServiceException {
    VesselRequest replyBuilder =
        VesselRequest.newBuilder()
            .setVesselId(loadableStudyEntity.getVesselXId())
            .setVesselDraftConditionId(loadableStudyEntity.getLoadLineXId())
            .setDraftExtreme(loadableStudyEntity.getDraftMark().toString())
            .build();
    VesselReply vesselReply = this.getVesselDetailByVesselId(replyBuilder);
    if (!SUCCESS.equalsIgnoreCase(vesselReply.getResponseStatus().getStatus())) {
      throw new GenericServiceException(
          "Error in calling vessel service",
          CommonErrorCodes.E_GEN_INTERNAL_ERR,
          HttpStatusCode.INTERNAL_SERVER_ERROR);
    }
    return vesselReply;
  }

  /**
   * Get cargo deatils
   *
   * @param loadableStudyEntity
   * @return
   * @throws GenericServiceException
   */
  private CargoReply getCargoInfoForLoadicator(LoadableStudy loadableStudyEntity)
      throws GenericServiceException {
    CargoRequest cargoRequest =
        CargoRequest.newBuilder()
            .setVesselId(loadableStudyEntity.getVesselXId())
            .setVoyageId(loadableStudyEntity.getVoyage().getId())
            .setLoadableStudyId(loadableStudyEntity.getId())
            .build();
    CargoReply cargoReply = this.getCargoInfo(cargoRequest);
    if (!SUCCESS.equalsIgnoreCase(cargoReply.getResponseStatus().getStatus())) {
      throw new GenericServiceException(
          "Error in calling cargo service",
          CommonErrorCodes.E_GEN_INTERNAL_ERR,
          HttpStatusCode.INTERNAL_SERVER_ERROR);
    }
    return cargoReply;
  }

  public CargoReply getCargoInfo(CargoRequest build) {
    return cargoInfoGrpcService.getCargoInfo(build);
  }

  public PortReply GetPortInfo(PortRequest build) {
    return portInfoGrpcService.getPortInfo(build);
  }

  public LoadicatorReply saveLoadicatorInfo(LoadicatorRequest build) {
    return loadicatorService.saveLoadicatorInfo(build);
  }

  public VesselReply getVesselDetailByVesselId(VesselRequest replyBuilder) {
    return this.vesselInfoGrpcService.getVesselDetailByVesselId(replyBuilder);
  }

  private static <T> Predicate<T> distinctByKeys(Function<? super T, ?>... keyExtractors) {
    final Map<List<?>, Boolean> seen = new ConcurrentHashMap<>();

    return t -> {
      final List<?> keys =
          Arrays.stream(keyExtractors).map(ke -> ke.apply(t)).collect(Collectors.toList());

      return seen.putIfAbsent(keys, Boolean.TRUE) == null;
    };
  }

  @Override
  public void getVoyages(VoyageRequest request, StreamObserver<VoyageListReply> responseObserver) {
    VoyageListReply.Builder builder = VoyageListReply.newBuilder();
    try {
      PortRequest.Builder portReqBuilder = PortRequest.newBuilder();
      PortReply portReply = this.GetPortInfo(portReqBuilder.build());

      if (portReply != null
          && portReply.getResponseStatus() != null
          && !SUCCESS.equalsIgnoreCase(portReply.getResponseStatus().getStatus())) {
        throw new GenericServiceException(
            "Error in calling port service",
            CommonErrorCodes.E_GEN_INTERNAL_ERR,
            HttpStatusCode.INTERNAL_SERVER_ERROR);
      }

      CargoRequest cargoRequest = CargoRequest.newBuilder().build();
      CargoReply cargoReply = this.getCargoInfo(cargoRequest);
      if (!SUCCESS.equalsIgnoreCase(cargoReply.getResponseStatus().getStatus())) {
        throw new GenericServiceException(
            "Error in calling cargo service",
            CommonErrorCodes.E_GEN_INTERNAL_ERR,
            HttpStatusCode.INTERNAL_SERVER_ERROR);
      }
      List<Voyage> entityList = null;

      // apply date filter for actual start date
      if (!request.getFromStartDate().isEmpty() && !request.getToStartDate().isEmpty()) {
        LocalDate from =
            LocalDate.from(
                DateTimeFormatter.ofPattern(CREATED_DATE_FORMAT).parse(request.getFromStartDate()));
        LocalDate to =
            LocalDate.from(
                DateTimeFormatter.ofPattern(CREATED_DATE_FORMAT).parse(request.getToStartDate()));
        entityList =
            voyageRepository.findByIsActiveAndVesselXIdAndActualStartDateBetween(
                true, request.getVesselId(), from, to);

      } else {
        entityList =
            voyageRepository.findByIsActiveAndVesselXIdOrderByLastModifiedDateTimeDesc(
                true, request.getVesselId());
      }
      for (Voyage entity : entityList) {
        VoyageDetail.Builder detailbuilder = VoyageDetail.newBuilder();
        detailbuilder.setId(entity.getId());
        detailbuilder.setVoyageNumber(entity.getVoyageNo());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        Optional.ofNullable(entity.getVoyageStartDate())
            .ifPresent(startDate -> detailbuilder.setStartDate(formatter.format(startDate)));
        Optional.ofNullable(entity.getVoyageEndDate())
            .ifPresent(endDate -> detailbuilder.setEndDate(formatter.format(endDate)));
        Optional.ofNullable(entity.getActualStartDate())
            .ifPresent(startDate -> detailbuilder.setActualStartDate(formatter.format(startDate)));
        Optional.ofNullable(entity.getActualEndDate())
            .ifPresent(endDate -> detailbuilder.setActualEndDate(formatter.format(endDate)));
        detailbuilder.setStatus(
            entity.getVoyageStatus() != null ? entity.getVoyageStatus().getName() : "");

        // fetch the confirmed loadable study for active voyages

        Stream<LoadableStudy> loadableStudyStream =
            Optional.ofNullable(entity.getLoadableStudies())
                .map(Collection::stream)
                .orElseGet(Stream::empty);
        Optional<LoadableStudy> loadableStudy =
            loadableStudyStream
                .filter(
                    loadableStudyElement ->
                        (loadableStudyElement.getLoadableStudyStatus() != null
                            && STATUS_CONFIRMED.equalsIgnoreCase(
                                loadableStudyElement.getLoadableStudyStatus().getName())))
                .findFirst();
        if (loadableStudy.isPresent()) {

          detailbuilder.setConfirmedLoadableStudyId(loadableStudy.get().getId());
          List<Long> loadingPorts =
              this.loadableStudyPortRotationRepository.getLoadingPorts(loadableStudy.get()).stream()
                  .distinct()
                  .collect(Collectors.toList());

          portReply.getPortsList().stream()
              .filter(port -> loadingPorts.contains(port.getId()))
              .forEach(
                  loadingPort -> {
                    LoadingPortDetail.Builder loadingPortDetail = LoadingPortDetail.newBuilder();
                    loadingPortDetail.setName(loadingPort.getName());
                    loadingPortDetail.setPortId(loadingPort.getId());
                    detailbuilder.addLoadingPorts(loadingPortDetail);
                  });

          List<Long> dischargingPorts =
              this.loadableStudyPortRotationRepository.getDischarigingPorts(loadableStudy.get())
                  .stream()
                  .distinct()
                  .collect(Collectors.toList());

          portReply.getPortsList().stream()
              .filter(port -> dischargingPorts.contains(port.getId()))
              .forEach(
                  dischargingPort -> {
                    DischargingPortDetail.Builder dischargingPortDetail =
                        DischargingPortDetail.newBuilder();
                    dischargingPortDetail.setName(dischargingPort.getName());
                    dischargingPortDetail.setPortId(dischargingPort.getId());
                    detailbuilder.addDischargingPorts(dischargingPortDetail);
                  });

          List<CargoNomination> cargoList =
              this.cargoNominationRepository.findByLoadableStudyXIdAndIsActive(
                  loadableStudy.get().getId(), true);

          List<Long> cargos =
              cargoList.stream()
                  .map(CargoNomination::getCargoXId)
                  .distinct()
                  .collect(Collectors.toList());

          List<CargoDetail> cargoes =
              cargoReply.getCargosList().stream()
                  .filter(cargo -> cargos.contains(cargo.getId()))
                  .collect(Collectors.toList());
          cargoes.forEach(
              cargo -> {
                CargoDetails.Builder cargoDetails = CargoDetails.newBuilder();
                cargoDetails.setName(cargo.getCrudeType());
                cargoDetails.setCargoId(cargo.getId());
                detailbuilder.addCargos(cargoDetails);
              });

          detailbuilder.setCharterer(loadableStudy.get().getCharterer());
        }

        builder.addVoyages(detailbuilder.build());
      }
      builder.setResponseStatus(StatusReply.newBuilder().setStatus(SUCCESS).build());

    } catch (Exception e) {
      log.error("Error in getVoyagesByVessel method ", e);
      builder.setResponseStatus(
          StatusReply.newBuilder()
              .setStatus(FAILED)
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .build());
    } finally {
      responseObserver.onNext(builder.build());
      responseObserver.onCompleted();
    }
  }

  private Long getNumberOfDays(LoadableStudy entity) {
    LoadableStudyPortRotation lastPort =
        this.loadableStudyPortRotationRepository
            .findFirstByLoadableStudyAndIsActiveOrderByPortOrderDesc(entity, true);
    Long daysBetween = null;

    if (null != lastPort && null != lastPort.getEtd()) {

      daysBetween = ChronoUnit.DAYS.between(LocalDate.now(), lastPort.getEtd().toLocalDate());
    }
    if (null != daysBetween && daysBetween <= Long.parseLong(dayDifference)) {
      return daysBetween;
    }
    return null;
  }

  /**
   * @param build
   * @return PortReply
   */
  public PortReply getPortDetails(PortRequest build) {
    return portInfoGrpcService.getPortInfo(build);
  }

  @Override
  public void saveVoyageStatus(
      SaveVoyageStatusRequest request, StreamObserver<SaveVoyageStatusReply> responseObserver) {
    SaveVoyageStatusReply.Builder replyBuilder = SaveVoyageStatusReply.newBuilder();
    try {
      Voyage voyageEntity = this.voyageRepository.findByIdAndIsActive(request.getVoyageId(), true);

      if (null == voyageEntity) {
        throw new GenericServiceException(
            " Voyage does not exist",
            CommonErrorCodes.E_HTTP_BAD_REQUEST,
            HttpStatusCode.BAD_REQUEST);
      }
      Stream<LoadableStudy> loadableStudyStream =
          Optional.ofNullable(voyageEntity.getLoadableStudies())
              .map(Collection::stream)
              .orElseGet(Stream::empty);
      Optional<LoadableStudy> loadableStudy =
          loadableStudyStream
              .filter(
                  loadableStudyElement ->
                      (loadableStudyElement.getLoadableStudyStatus() != null
                          && STATUS_CONFIRMED.equalsIgnoreCase(
                              loadableStudyElement.getLoadableStudyStatus().getName())))
              .findFirst();

      if (request.getStatus().equalsIgnoreCase(START_VOYAGE)) {
        List<Voyage> activeVoyage =
            this.voyageRepository.findByVoyageStatusAndIsActive(ACTIVE_VOYAGE_STATUS, true);
        if (!activeVoyage.isEmpty()) {
          throw new GenericServiceException(
              "Active Voyage already exist",
              CommonErrorCodes.E_CPDSS_ACTIVE_VOYAGE_EXISTS,
              HttpStatusCode.BAD_REQUEST);
        }
        if (!loadableStudy.isPresent()) {
          throw new GenericServiceException(
              "Confirmed Loadable study does not exist",
              CommonErrorCodes.E_CPDSS_CONFIRMED_LS_DOES_NOT_EXIST,
              HttpStatusCode.BAD_REQUEST);
        }
        Optional<VoyageStatus> status =
            this.voyageStatusRepository.findByIdAndIsActive(ACTIVE_VOYAGE_STATUS, true);
        if (!status.isPresent()) {
          throw new GenericServiceException(
              "Voyage status does not  exist",
              CommonErrorCodes.E_HTTP_BAD_REQUEST,
              HttpStatusCode.BAD_REQUEST);
        }
        voyageEntity.setVoyageStatus(status.get());

        if (request.getActualStartDate().isEmpty()) {
          LoadableStudyPortRotation minPortOrderEntity =
              this.loadableStudyPortRotationRepository
                  .findFirstByLoadableStudyAndIsActiveOrderByPortOrderAsc(
                      loadableStudy.get(), true);

          if (null != minPortOrderEntity) {
            List<SynopticalTable> synopticalData = minPortOrderEntity.getSynopticalTable();
            if (!synopticalData.isEmpty()) {
              Optional<SynopticalTable> synoptical =
                  synopticalData.stream()
                      .filter(
                          data ->
                              data.getLoadableStudyPortRotation()
                                      .getId()
                                      .equals(minPortOrderEntity.getId())
                                  && SYNOPTICAL_TABLE_OP_TYPE_ARRIVAL.equals(
                                      data.getOperationType()))
                      .findAny();
              if (synoptical.isPresent()) {
                voyageEntity.setActualStartDate(synoptical.get().getEtaActual());
              }
            }
          }
        } else {
          voyageEntity.setActualStartDate(
              !StringUtils.isEmpty(request.getActualStartDate())
                  ? LocalDateTime.from(
                      DateTimeFormatter.ofPattern(DATE_FORMAT).parse(request.getActualStartDate()))
                  : null);
        }
      } else {

        Optional<VoyageStatus> status =
            this.voyageStatusRepository.findByIdAndIsActive(CLOSE_VOYAGE_STATUS, true);
        if (!status.isPresent()) {
          throw new GenericServiceException(
              "Voyage status does not  exist",
              CommonErrorCodes.E_HTTP_BAD_REQUEST,
              HttpStatusCode.BAD_REQUEST);
        }
        voyageEntity.setVoyageStatus(status.get());

        if (request.getActualEndDate().isEmpty()) {
          LoadableStudyPortRotation maxPortOrderEntity =
              this.loadableStudyPortRotationRepository
                  .findFirstByLoadableStudyAndIsActiveOrderByPortOrderDesc(
                      loadableStudy.get(), true);
          if (maxPortOrderEntity != null) {
            List<SynopticalTable> synopticalData = maxPortOrderEntity.getSynopticalTable();
            if (!synopticalData.isEmpty()) {
              Optional<SynopticalTable> synoptical =
                  synopticalData.stream()
                      .filter(
                          data ->
                              data.getLoadableStudyPortRotation()
                                      .getId()
                                      .equals(maxPortOrderEntity.getId())
                                  && SYNOPTICAL_TABLE_OP_TYPE_DEPARTURE.equals(
                                      data.getOperationType()))
                      .findAny();

              if (synoptical.isPresent()) {
                voyageEntity.setActualEndDate(synoptical.get().getEtdActual());
              }
            }
          }
        } else {
          voyageEntity.setActualEndDate(
              !StringUtils.isEmpty(request.getActualEndDate())
                  ? LocalDateTime.from(
                      DateTimeFormatter.ofPattern(DATE_FORMAT).parse(request.getActualEndDate()))
                  : null);
        }
      }
      this.voyageRepository.save(voyageEntity);

      replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS).build());

    } catch (GenericServiceException e) {
      log.error("GenericServiceException when saving voyage status", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(e.getCode())
              .setMessage(e.getMessage())
              .setStatus(FAILED)
              .build());
    } catch (Exception e) {
      log.error("Error saving voyage status", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder()
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR)
              .setMessage("Error saving voyage status")
              .setStatus(FAILED)
              .build());
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  /** Fetch the api and temp history for cargo and port ids if available */
  @Override
  public void getCargoApiTempHistory(
      CargoHistoryRequest request, StreamObserver<CargoHistoryReply> responseObserver) {
    com.cpdss.common.generated.LoadableStudy.CargoHistoryReply.Builder replyBuilder =
        CargoHistoryReply.newBuilder();
    try {
      // fetch the history for last 5 years
      Calendar now = Calendar.getInstance();
      int year = now.get(Calendar.YEAR) - 5;
      List<com.cpdss.loadablestudy.entity.ApiTempHistory> apiTempHistList =
          this.apiTempHistoryRepository.findApiTempHistoryWithYearAfter(request.getCargoId(), year);
      buildCargoHistoryReply(apiTempHistList, replyBuilder);
      replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS));
    } catch (Exception e) {
      log.error("Exception when fetching getCargoApiTempHistory", e);
      replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(FAILED));
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  private void buildCargoHistoryReply(
      List<com.cpdss.loadablestudy.entity.ApiTempHistory> apiTempHistList,
      com.cpdss.common.generated.LoadableStudy.CargoHistoryReply.Builder replyBuilder) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(ETA_ETD_FORMAT);
    if (!CollectionUtils.isEmpty(apiTempHistList)) {
      apiTempHistList.forEach(
          apiTempRecord -> {
            CargoHistoryDetail.Builder builder = CargoHistoryDetail.newBuilder();
            Optional.ofNullable(apiTempRecord.getCargoId()).ifPresent(builder::setCargoId);
            Optional.ofNullable(apiTempRecord.getLoadingPortId())
                .ifPresent(builder::setLoadingPortId);
            Optional.ofNullable(apiTempRecord.getLoadedDate())
                .ifPresent(loadedDate -> builder.setLoadedDate(formatter.format(loadedDate)));
            Optional.ofNullable(apiTempRecord.getYear()).ifPresent(builder::setLoadedYear);
            Optional.ofNullable(apiTempRecord.getMonth()).ifPresent(builder::setLoadedMonth);
            Optional.ofNullable(apiTempRecord.getDate()).ifPresent(builder::setLoadedDay);
            Optional.ofNullable(apiTempRecord.getApi())
                .ifPresent(api -> builder.setApi(String.valueOf(api)));
            Optional.ofNullable(apiTempRecord.getTemp())
                .ifPresent(temperature -> builder.setTemperature(String.valueOf(temperature)));
            replyBuilder.addCargoHistory(builder);
          });
    }
  }

  @Override
  public void getAllCargoHistory(
      CargoHistoryRequest request, StreamObserver<CargoHistoryReply> responseObserver) {
    com.cpdss.common.generated.LoadableStudy.CargoHistoryReply.Builder replyBuilder =
        CargoHistoryReply.newBuilder();
    try {
      List<com.cpdss.loadablestudy.entity.ApiTempHistory> apiTempHistList = null;

      // Paging and sorting while filtering is handled separately
      Pageable pageable = null;
      if (request.getSortBy().length() > 0 && request.getOrderBy().length() > 0) {
        pageable =
            PageRequest.of(
                0,
                Integer.MAX_VALUE,
                Sort.by(
                    Sort.Direction.valueOf(request.getOrderBy().toUpperCase()),
                    request.getSortBy()));
        log.info(
            "Cargo History grpc: page {}, page size {},  sort-order {}, sort-by {}",
            request.getPage(),
            request.getPageSize(),
            request.getOrderBy(),
            request.getSortBy());
      } else {
        pageable = PageRequest.of(0, Integer.MAX_VALUE);
        log.info(
            "Cargo History grpc: page {}, page size {}", request.getPage(), request.getPageSize());
      }

      // apply date filter for loaded date
      if (!request.getFilterParamsMap().isEmpty()) {
        Map<String, com.cpdss.common.generated.LoadableStudy.FilterSpecification> map =
            request.getFilterParamsMap();

        Specification<ApiTempHistory> specification =
            Specification.where(
                new ApiTempHistorySpecification(new SearchCriteria("id", "GREATER_THAN", 0)));

        for (Map.Entry<String, com.cpdss.common.generated.LoadableStudy.FilterSpecification> var1 :
            map.entrySet()) {
          if (var1.getValue().getIdsList() != null && !var1.getValue().getIdsList().isEmpty()) {
            specification =
                specification.and(
                    new ApiTempHistorySpecification(
                        new SearchCriteria(
                            var1.getKey(),
                            var1.getValue().getOperation(),
                            var1.getValue().getIdsList())));
          }
          if (var1.getValue().getValuesList() != null
              && var1.getValue().getOperation().equals("BETWEEN")) {
            // Expected data Date range of loaded date
            String startDate = var1.getValue().getValuesList().get(0);
            String endDate = var1.getValue().getValuesList().get(1);
            LocalDateTime fromDate =
                LocalDateTime.from(DateTimeFormatter.ofPattern(DATE_FORMAT).parse(startDate));
            LocalDateTime toDate =
                LocalDateTime.from(DateTimeFormatter.ofPattern(DATE_FORMAT).parse(endDate));
            specification =
                specification.and(
                    new ApiTempHistorySpecification(
                        new SearchCriteria(
                            var1.getKey(),
                            var1.getValue().getOperation(),
                            Arrays.asList(fromDate, toDate))));
          }
          if (var1.getValue().getValuesList() != null
              && var1.getValue().getOperation().equalsIgnoreCase("LIKE")) {
            specification =
                specification.and(
                    new ApiTempHistorySpecification(
                        new SearchCriteria(
                            var1.getKey(),
                            var1.getValue().getOperation(),
                            var1.getValue().getValues(0))));
          }

          log.info("Cargo History grpc: Filter Key {}, Value {}", var1.getKey(), var1.getValue());
        }

        Page<ApiTempHistory> pagedResult =
            apiTempHistoryRepository.findAll(specification, pageable);
        apiTempHistList = pagedResult.toList();
        replyBuilder.setTotal(pagedResult.getTotalElements());
        log.info("ApiTempHistory paged result total {}", pagedResult.getTotalElements());
      } else { // on page load, no filter case
        Page<com.cpdss.loadablestudy.entity.ApiTempHistory> pagedResult =
            this.apiTempHistoryRepository.findAll(pageable);
        apiTempHistList = pagedResult.toList();
        replyBuilder.setTotal(pagedResult.getTotalElements());
        log.info("ApiTempHistory no filter paged result total {}", pagedResult.getTotalElements());
      }
      buildAllCargoHistoryReply(apiTempHistList, replyBuilder);
      replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS));
    } catch (Exception e) {
      log.error("Exception when fetching getCargoApiTempHistory", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder().setMessage(e.getMessage()).setStatus(FAILED));
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  private void buildAllCargoHistoryReply(
      List<com.cpdss.loadablestudy.entity.ApiTempHistory> apiTempHistList,
      com.cpdss.common.generated.LoadableStudy.CargoHistoryReply.Builder replyBuilder) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(ETA_ETD_FORMAT);
    if (!CollectionUtils.isEmpty(apiTempHistList)) {
      apiTempHistList.forEach(
          apiTempRecord -> {
            CargoHistoryDetail.Builder builder = CargoHistoryDetail.newBuilder();
            Optional.ofNullable(apiTempRecord.getVesselId()).ifPresent(builder::setVesselId);
            Optional.ofNullable(apiTempRecord.getCargoId()).ifPresent(builder::setCargoId);
            Optional.ofNullable(apiTempRecord.getLoadingPortId())
                .ifPresent(builder::setLoadingPortId);
            Optional.ofNullable(apiTempRecord.getLoadedDate())
                .ifPresent(loadedDate -> builder.setLoadedDate(formatter.format(loadedDate)));
            Optional.ofNullable(apiTempRecord.getYear()).ifPresent(builder::setLoadedYear);
            Optional.ofNullable(apiTempRecord.getMonth()).ifPresent(builder::setLoadedMonth);
            Optional.ofNullable(apiTempRecord.getDate()).ifPresent(builder::setLoadedDay);
            Optional.ofNullable(apiTempRecord.getApi())
                .ifPresent(api -> builder.setApi(String.valueOf(api)));
            Optional.ofNullable(apiTempRecord.getTemp())
                .ifPresent(temperature -> builder.setTemperature(String.valueOf(temperature)));
            replyBuilder.addCargoHistory(builder);
          });
    }
  }

  public void isPatternGeneratedOrConfirmed(LoadableStudy loadableStudy)
      throws GenericServiceException {
    List<LoadablePattern> generatedPatterns =
        this.loadablePatternRepository.findLoadablePatterns(
            LOADABLE_STUDY_STATUS_PLAN_GENERATED_ID, loadableStudy, true);
    List<LoadablePattern> confirmedPatterns =
        this.loadablePatternRepository.findLoadablePatterns(
            CONFIRMED_STATUS_ID, loadableStudy, true);

    if (!generatedPatterns.isEmpty() || !confirmedPatterns.isEmpty()) {
      throw new GenericServiceException(
          "Save/Edit/Delte not allowed for plan generated /confirmed loadable study",
          CommonErrorCodes.E_CPDSS_SAVE_NOT_ALLOWED,
          HttpStatusCode.BAD_REQUEST);
    }
  }

  private void validateSaveSynopticalOhqData(
      OnHandQuantity ohqEntity,
      SynopticalTable entity,
      SynopticalOhqRecord ohqRecord,
      LoadableStudy loadableStudy)
      throws GenericServiceException {

    List<LoadablePattern> generatedPatterns =
        this.loadablePatternRepository.findLoadablePatterns(
            LOADABLE_STUDY_STATUS_PLAN_GENERATED_ID, loadableStudy, true);

    List<LoadablePattern> confirmedPatterns =
        this.loadablePatternRepository.findLoadablePatterns(
            CONFIRMED_STATUS_ID, loadableStudy, true);

    if ((!generatedPatterns.isEmpty() || !confirmedPatterns.isEmpty())
        && ((SYNOPTICAL_TABLE_OP_TYPE_ARRIVAL.equals(entity.getOperationType())
                && ohqEntity.getArrivalQuantity() != null
                && !Integer.toString(ohqEntity.getArrivalQuantity().intValue())
                    .equals(ohqRecord.getPlannedWeight()))
            || (SYNOPTICAL_TABLE_OP_TYPE_DEPARTURE.equals(entity.getOperationType())
                && ohqEntity.getDepartureQuantity() != null
                && !Integer.toString(ohqEntity.getDepartureQuantity().intValue())
                    .equals(ohqRecord.getPlannedWeight())))) {

      throw new GenericServiceException(
          "Cannot update planned values for plan generated loadable study",
          CommonErrorCodes.E_CPDSS_SAVE_NOT_ALLOWED,
          HttpStatusCode.BAD_REQUEST);
    }
  }

  private void validateSaveSynopticalObqData(
      OnBoardQuantity obqEntity, SynopticalCargoRecord cargoRecord, LoadableStudy loadableStudy)
      throws GenericServiceException {

    List<LoadablePattern> generatedPatterns =
        this.loadablePatternRepository.findLoadablePatterns(
            LOADABLE_STUDY_STATUS_PLAN_GENERATED_ID, loadableStudy, true);

    List<LoadablePattern> confirmedPatterns =
        this.loadablePatternRepository.findLoadablePatterns(
            CONFIRMED_STATUS_ID, loadableStudy, true);

    if ((!generatedPatterns.isEmpty() || !confirmedPatterns.isEmpty())
        && null != obqEntity.getPlannedArrivalWeight()
        && !cargoRecord
            .getPlannedWeight()
            .equals(Integer.toString(obqEntity.getPlannedArrivalWeight().intValue()))) {
      throw new GenericServiceException(
          "Cannot update planned values for plan generated loadable study",
          CommonErrorCodes.E_CPDSS_SAVE_NOT_ALLOWED,
          HttpStatusCode.BAD_REQUEST);
    }
  }

  private void validateSaveSynopticalEtaEtdEstimates(
      SynopticalTable entity,
      SynopticalRecord record,
      LoadableStudy loadableStudy,
      LoadableStudyPortRotation prEntity)
      throws GenericServiceException {

    List<LoadablePattern> generatedPatterns =
        this.loadablePatternRepository.findLoadablePatterns(
            LOADABLE_STUDY_STATUS_PLAN_GENERATED_ID, loadableStudy, true);

    List<LoadablePattern> confirmedPatterns =
        this.loadablePatternRepository.findLoadablePatterns(
            CONFIRMED_STATUS_ID, loadableStudy, true);

    if ((!generatedPatterns.isEmpty() || !confirmedPatterns.isEmpty())
        && ((SYNOPTICAL_TABLE_OP_TYPE_ARRIVAL.equals(entity.getOperationType())
                && prEntity.getEta().toString().equals(record.getEtaEtdEstimated()))
            || (SYNOPTICAL_TABLE_OP_TYPE_DEPARTURE.equals(entity.getOperationType())
                && prEntity.getEtd().toString().equals(record.getEtaEtdEstimated())))) {

      throw new GenericServiceException(
          "Cannot update planned values for plan generated loadable study",
          CommonErrorCodes.E_CPDSS_SAVE_NOT_ALLOWED,
          HttpStatusCode.BAD_REQUEST);
    }
  }

  void validateDeleteCargoNomination(CargoNomination cargoNomination)
      throws GenericServiceException {
    Optional<LoadableStudy> entityOpt =
        this.loadableStudyRepository.findById(cargoNomination.getLoadableStudyXId());
    if (!entityOpt.isPresent()) {
      throw new GenericServiceException(
          "Loadable study does not exist",
          CommonErrorCodes.E_HTTP_BAD_REQUEST,
          HttpStatusCode.BAD_REQUEST);
    }
    this.checkIfVoyageClosed(entityOpt.get().getVoyage().getId());
    this.isPatternGeneratedOrConfirmed(entityOpt.get());
  }

  void validateSynopticalVesselData(
      LoadableStudy loadablestudy, SynopticalTable entity, SynopticalRecord record)
      throws GenericServiceException {
    List<LoadablePattern> generatedPatterns =
        this.loadablePatternRepository.findLoadablePatterns(
            LOADABLE_STUDY_STATUS_PLAN_GENERATED_ID, loadablestudy, true);

    List<LoadablePattern> confirmedPatterns =
        this.loadablePatternRepository.findLoadablePatterns(
            CONFIRMED_STATUS_ID, loadablestudy, true);
    if ((!generatedPatterns.isEmpty() || !confirmedPatterns.isEmpty())
        && ((null != entity.getOthersPlanned()
                && !Integer.toString(entity.getOthersPlanned().intValue())
                    .equals(record.getOthersPlanned()))
            || (null != entity.getConstantPlanned()
                && !Integer.toString(entity.getConstantPlanned().intValue())
                    .equals(record.getConstantPlanned()))
            || (null != entity.getDeadWeightPlanned()
                && !Integer.toString(entity.getDeadWeightPlanned().intValue())
                    .equals(record.getTotalDwtPlanned()))
            || (null != entity.getDisplacementPlanned()
                && !Integer.toString(entity.getDisplacementPlanned().intValue())
                    .equals(record.getDisplacementPlanned())))) {
      throw new GenericServiceException(
          "Cannot update planned values for plan generated loadable study",
          CommonErrorCodes.E_CPDSS_SAVE_NOT_ALLOWED,
          HttpStatusCode.BAD_REQUEST);
    }
  }

  /** Save JSON to database */
  @Override
  public void saveJson(JsonRequest request, StreamObserver<StatusReply> responseObserver) {
    StatusReply.Builder replyBuilder = StatusReply.newBuilder();
    try {
      this.saveJsonToDatabase(request.getReferenceId(), request.getJsonTypeId(), request.getJson());
      replyBuilder = StatusReply.newBuilder().setStatus(SUCCESS).setMessage(SUCCESS);
    } catch (Exception e) {
      log.error("Exception occured while trying to save JSON to database.", e);
      replyBuilder =
          StatusReply.newBuilder()
              .setStatus(FAILED)
              .setMessage(FAILED)
              .setCode(CommonErrorCodes.E_GEN_INTERNAL_ERR);
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  /**
   * @param referenceId
   * @param jsonTypeId
   * @param json
   */
  public void saveJsonToDatabase(Long referenceId, Long jsonTypeId, String json) {
    Optional<JsonType> jsonTypeOpt = jsonTypeRepository.findByIdAndIsActive(jsonTypeId, true);

    if (jsonTypeOpt.isPresent()) {
      JsonData jsonData = new JsonData();
      jsonData.setReferenceXId(referenceId);
      jsonData.setJsonTypeXId(jsonTypeOpt.get());
      jsonData.setJsonData(json);
      jsonDataRepository.save(jsonData);
      log.info(String.format("Saved %s JSON in database.", jsonTypeOpt.get().getTypeName()));
    } else {
      log.error("Cannot find JSON type in database.");
    }
  }

  void checkIfVoyageClosed(Long voyageId) throws GenericServiceException {
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

  void checkIfVoyageActive(Long voyageId) throws GenericServiceException {
    Voyage voyage = this.voyageRepository.findByIdAndIsActive(voyageId, true);
    if (null != voyage
        && null != voyage.getVoyageStatus()
        && voyage.getVoyageStatus().getId().equals(ACTIVE_VOYAGE_STATUS)) {
      throw new GenericServiceException(
          "Save not allowed for active voyage",
          CommonErrorCodes.E_CPDSS_SAVE_NOT_ALLOWED,
          HttpStatusCode.BAD_REQUEST);
    }
  }

  /**
   * Fetch Single Synoptic Data with DEP condition,
   *
   * @param request - LoadableStudy Id, LoadablePattern Id required
   * @param responseObserver - SynopticalTableReply with One SynopticalTable Data
   */
  @Override
  public void getSynopticDataByLoadableStudyId(
      com.cpdss.common.generated.LoadableStudy.SynopticalTableRequest request,
      StreamObserver<com.cpdss.common.generated.LoadableStudy.SynopticalTableReply>
          responseObserver) {

    SynopticalTableReply.Builder replyBuilder = SynopticalTableReply.newBuilder();
    log.info(
        "Synoptic DEP data for loadable study {}, loadable pattern {}",
        request.getLoadableStudyId(),
        request.getLoadablePatternId());
    try {
      Optional<com.cpdss.loadablestudy.entity.LoadableStudy> loadableStudy =
          this.loadableStudyRepository.findByIdAndIsActive(request.getLoadableStudyId(), true);
      CargoOperation cOp = this.cargoOperationRepository.getOne(LOADING_OPERATION_ID);
      Long portRotationId = this.getLastPortRotationId(loadableStudy.get(), cOp);
      LoadableStudyPortRotation lsPr = loadableStudyPortRotationRepository.getOne(portRotationId);
      Pageable pageable = PageRequest.of(0, 10);
      Page<SynopticalTable> synData =
          synopticalTableRepository.findByloadableStudyPortRotation(lsPr, pageable);
      Optional<SynopticalTable> synopticDEP =
          synData.stream()
              .filter(var1 -> (var1.getIsActive() && var1.getOperationType().equals("DEP")))
              .findFirst();
      log.info(
          "Synoptic Table data id {}, for port rotation id {}",
          synopticDEP.get().getId(),
          lsPr.getId());
      VesselReply vesselReply = this.getSynopticalTableVesselData(request, loadableStudy.get());
      List<VesselTankDetail> sortedTankList = new ArrayList<>(vesselReply.getVesselTanksList());
      buildSynopticalTableReply(
          request,
          Arrays.asList(synopticDEP.get()),
          this.getSynopticalTablePortDetails(Arrays.asList(synopticDEP.get())),
          this.getSynopticalTablePortRotations(loadableStudy.get()),
          loadableStudy.get(),
          sortedTankList,
          vesselReply.getVesselLoadableQuantityDetails(),
          replyBuilder);
      replyBuilder.setResponseStatus(ResponseStatus.newBuilder().setStatus(SUCCESS));
    } catch (Exception e) {
      log.error("Exception while fetch Synoptic data", e);
      replyBuilder.setResponseStatus(
          ResponseStatus.newBuilder().setMessage(e.getMessage()).setStatus(FAILED));
    } finally {
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
    }
  }

  @Autowired AlgoErrorService algoErrorService;

  @Override
  public void saveAlgoErrors(
      com.cpdss.common.generated.LoadableStudy.AlgoErrors request,
      StreamObserver<com.cpdss.common.generated.LoadableStudy.AlgoErrors> responseObserver) {
    algoErrorService.saveAlgoError(request, responseObserver);
  }

  @Override
  public void fetchAllAlgoErrors(
      com.cpdss.common.generated.LoadableStudy.AlgoErrors request,
      StreamObserver<com.cpdss.common.generated.LoadableStudy.AlgoErrors> responseObserver) {
    algoErrorService.fetchAllErrors(request, responseObserver);
  }
}
