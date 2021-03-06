/* Licensed at AlphaOri Technologies */
package com.cpdss.dischargeplan.service;

import static com.cpdss.dischargeplan.common.DischargePlanConstants.*;

import com.cpdss.common.constants.RedisConfigConstants;
import com.cpdss.common.exception.GenericServiceException;
import com.cpdss.common.generated.Common;
import com.cpdss.common.generated.Common.ResponseStatus;
import com.cpdss.common.generated.PortInfo.PortDetail;
import com.cpdss.common.generated.PortInfo.PortReply;
import com.cpdss.common.generated.PortInfo.PortRequestWithPaging;
import com.cpdss.common.generated.PortInfoServiceGrpc;
import com.cpdss.common.generated.VesselInfo;
import com.cpdss.common.generated.VesselInfoServiceGrpc;
import com.cpdss.common.generated.discharge_plan.*;
import com.cpdss.common.generated.discharge_plan.DischargingDownloadTideDetailStatusReply.Builder;
import com.cpdss.common.rest.CommonErrorCodes;
import com.cpdss.common.utils.HttpStatusCode;
import com.cpdss.dischargeplan.common.DischargePlanConstants;
import com.cpdss.dischargeplan.domain.TypeValue;
import com.cpdss.dischargeplan.domain.rules.RuleMasterData;
import com.cpdss.dischargeplan.domain.rules.RuleMasterSection;
import com.cpdss.dischargeplan.domain.rules.RuleType;
import com.cpdss.dischargeplan.entity.DischargeInformation;
import com.cpdss.dischargeplan.entity.DischargePlanRuleInput;
import com.cpdss.dischargeplan.entity.DischargePlanRules;
import com.cpdss.dischargeplan.entity.DischargingBerthDetail;
import com.cpdss.dischargeplan.entity.DischargingInformationStatus;
import com.cpdss.dischargeplan.entity.DischargingInstruction;
import com.cpdss.dischargeplan.entity.PortTideDetail;
import com.cpdss.dischargeplan.repository.*;
import com.google.protobuf.ByteString;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

@Slf4j
@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = GenericServiceException.class)
public class DischargeInformationService {

  @Autowired DischargeInformationRepository dischargeInformationRepository;

  @Autowired DischargeInformationBuilderService informationBuilderService;

  @Autowired DischargeBerthDetailRepository dischargeBerthDetailRepository;

  @Autowired DischargeRulesRepository dischargeStudyRulesRepository;

  @Autowired DischargeRulesInputRepository dischargeStudyRulesInputRepository;

  @Autowired PortTideDetailsRepository portTideDetailsRepository;

  @Autowired PortDischargingPlanRobDetailsRepository portDischargingPlanRobDetailsRepository;

  @Autowired DischargeRulesRepository dischargeRulesRepository;

  @Autowired DischargeRulesInputRepository dischargeRulesInputRepository;

  @Autowired DischargingInstructionRepository dischargingInstructionRepository;

  @GrpcClient("vesselInfoService")
  private VesselInfoServiceGrpc.VesselInfoServiceBlockingStub vesselInfoGrpcService;

  @GrpcClient("portInfoService")
  private PortInfoServiceGrpc.PortInfoServiceBlockingStub portInfoServiceBlockingStub;

  public DischargeInformation getDischargeInformation(Long primaryKey) {
    return this.dischargeInformationRepository.findByIdAndIsActiveTrue(primaryKey).orElse(null);
  }

  public DischargeInformation getDischargeInformation(
      Long vesselId, Long voyage, Long portRotationId) {
    return this.dischargeInformationRepository
        .findByVesselXidAndVoyageXidAndPortRotationXidAndIsActiveTrue(
            vesselId, voyage, portRotationId)
        .orElse(null);
  }

  public List<DischargeInformation> getAllDischargeInformation(Long vesselId, Long voyageId) {
    return this.dischargeInformationRepository.findAllByVesselXidAndVoyageXidAndIsActiveTrue(
        vesselId, voyageId);
  }

  public void getDischargeInformation(
      DischargeInformationRequest request,
      com.cpdss.common.generated.discharge_plan.DischargeInformation.Builder builder)
      throws GenericServiceException {
    DischargeInformation disEntity =
        this.getDischargeInformation(
            request.getVesselId(), request.getVoyageId(), request.getPortRotationId());
    if (disEntity == null) {
      log.error(
          "Discharge information not found for Vessel Id {}, Voyage Id {}, PortR Id {}",
          request.getVesselId(),
          request.getVoyageId(),
          request.getPortRotationId());
      throw new GenericServiceException(
          "No Discharge information found",
          CommonErrorCodes.E_GEN_INTERNAL_ERR,
          HttpStatusCode.NO_CONTENT);
    }

    try {
      builder.setDischargeInfoId(disEntity.getId());
      builder.setSynopticTableId(disEntity.getSynopticTableXid());
      Optional.ofNullable(disEntity.getDischargingInformationStatus())
          .ifPresent(status -> builder.setDischargingInfoStatusId(status.getId()));
      Optional.ofNullable(disEntity.getArrivalStatusId())
          .ifPresent(builder::setDischargingPlanArrStatusId);
      Optional.ofNullable(disEntity.getDepartureStatusId())
          .ifPresent(builder::setDischargingPlanDepStatusId);
      log.info("Setting Discharge PK and Synoptic Id");
    } catch (Exception e) {
      log.error("Failed to set PK, Synoptic Id in response - {}", e.getMessage());
    }

    List<DischargingInstruction> dischargingInstructionList =
        dischargingInstructionRepository.getAllDischargingInstructions(
            request.getVesselId(), disEntity.getId(), request.getPortRotationId());
    builder.setIsDischargingInstructionsComplete(
        !dischargingInstructionList.isEmpty() ? Boolean.TRUE : Boolean.FALSE);

    // Set Discharge Details
    this.informationBuilderService.buildDischargeDetailsMessageFromEntity(disEntity, builder);

    // Set Discharge Rates
    this.informationBuilderService.buildDischargeRateMessageFromEntity(disEntity, builder);

    // Set Discharge berth
    List<DischargingBerthDetail> listVarB =
        this.dischargeBerthDetailRepository.findAllByDischargingInformationIdAndIsActiveTrue(
            disEntity.getId());
    this.informationBuilderService.buildDischargeBerthMessageFromEntity(
        disEntity, listVarB, builder);

    // Set Stages
    this.informationBuilderService.buildDischargeStageMessageFromEntity(disEntity, builder);

    // Set Delay
    this.informationBuilderService.buildDischargeDelaysMessageFromEntity(disEntity, builder);

    // Set Post Discharge stage
    this.informationBuilderService.buildPostDischargeStageMessageFromEntity(disEntity, builder);

    // set Pump and Machine Details
    this.informationBuilderService.buildMachineInUseMessageFromEntity(disEntity, builder);

    // Set Cow Details
    this.informationBuilderService.buildCowPlanMessageFromEntity(disEntity, builder);

    // Set General Items
    builder.setIsDischargeInfoComplete(disEntity.getIsDischargeInformationComplete());

    builder.setDischargeSlopTanksFirst(disEntity.getDischargeSlopTankFirst());
    builder.setDischargeCommingledCargoSeparately(disEntity.getDischargeCommingleCargoSeparately());
    builder.setIsDischargingPlanGenerated(
        disEntity.getIsDischargingPlanGenerated() == null
            ? false
            : disEntity.getIsDischargingPlanGenerated());
    builder.setIsDischargingSequenceGenerated(
        disEntity.getIsDischargingSequenceGenerated() == null
            ? false
            : disEntity.getIsDischargingSequenceGenerated());
    builder.setResponseStatus(
        Common.ResponseStatus.newBuilder()
            .setHttpStatusCode(HttpStatus.OK.value())
            .setStatus(DischargePlanConstants.SUCCESS)
            .build());
  }

  public void getOrSaveRulesForDischarge(
      DischargeRuleRequest request, DischargeRuleReply.Builder builder)
      throws GenericServiceException {
    if (!RuleMasterSection.Discharging.getId().equals(request.getSectionId())) {
      throw new GenericServiceException(
          "fetch rule for discharging study rule only not for discharging or planning module",
          CommonErrorCodes.E_HTTP_BAD_REQUEST,
          HttpStatusCode.BAD_REQUEST);
    }
    Optional<DischargeInformation> dischargeInformation =
        dischargeInformationRepository.findByIdAndIsActiveAndVesselXid(
            request.getDischargeInfoId(), true, request.getVesselId());
    if (dischargeInformation.isEmpty()) {
      log.error(
          "Failed to get discharge study for get or save rule {}", request.getDischargeInfoId());
      throw new GenericServiceException(
          "discharge study with given id does not exist",
          CommonErrorCodes.E_HTTP_BAD_REQUEST,
          HttpStatusCode.BAD_REQUEST);
    }
    VesselInfo.VesselRuleRequest.Builder vesselRuleBuilder =
        VesselInfo.VesselRuleRequest.newBuilder();
    vesselRuleBuilder.setSectionId(request.getSectionId());
    vesselRuleBuilder.setVesselId(request.getVesselId());
    vesselRuleBuilder.setIsFetchEnabledRules(false);
    vesselRuleBuilder.setIsNoDefaultRule(true);
    VesselInfo.VesselRuleReply vesselRuleReply =
        this.vesselInfoGrpcService.getRulesByVesselIdAndSectionId(vesselRuleBuilder.build());
    if (!DischargePlanConstants.SUCCESS.equals(vesselRuleReply.getResponseStatus().getStatus())) {
      throw new GenericServiceException(
          "failed to get discharge study rule Details ",
          vesselRuleReply.getResponseStatus().getCode(),
          HttpStatusCode.valueOf(Integer.parseInt(vesselRuleReply.getResponseStatus().getCode())));
    }
    if (!CollectionUtils.isEmpty(request.getRulePlanList())) {
      log.info("save discharge study rules");
      saveRulesAgainstDischargeStudy(request, dischargeInformation, vesselRuleReply);
    }
    // Filter vessel rule primary key id
    List<Long> ruleListId =
        vesselRuleReply.getRulePlanList().stream()
            .flatMap(rulesList -> rulesList.getRulesList().stream())
            .map(rules -> Long.parseLong(rules.getVesselRuleXId()))
            .collect(Collectors.toList());
    // fetch discharge study rules based on vessel rule primary key id
    List<DischargePlanRules> dischargeStudyRulesList =
        dischargeStudyRulesRepository
            .findByDischargeInformationAndVesselXIdAndIsActiveAndVesselRuleXIdInOrderById(
                dischargeInformation.get(), request.getVesselId(), true, ruleListId);
    if (dischargeStudyRulesList.size() > 0) {
      log.info("Fetch discharge study rules");
      vesselRuleReply
          .getRulePlanList()
          .forEach(
              rulePlans -> {
                Common.RulePlans.Builder rulePlanBuider = Common.RulePlans.newBuilder();
                Optional.ofNullable(rulePlans.getHeader())
                    .ifPresent(item -> rulePlanBuider.setHeader(item));
                List<Long> ruleId =
                    rulePlans.getRulesList().stream()
                        .map(rules -> Long.parseLong(rules.getVesselRuleXId()))
                        .collect(Collectors.toList());
                List<DischargePlanRules> dStudyRulesList =
                    dischargeStudyRulesList.stream()
                        .filter(lRuleList -> ruleId.contains(lRuleList.getVesselRuleXId()))
                        .collect(Collectors.toList());
                List<DischargePlanRules> sortedDStudyRulesList =
                    dStudyRulesList.stream()
                        .sorted(Comparator.comparingLong(DischargePlanRules::getId))
                        .collect(Collectors.toList());
                informationBuilderService.buildResponseForDSRules(
                    sortedDStudyRulesList, rulePlanBuider, builder, vesselRuleReply);
              });
    } else {
      log.info("default vessel rules ");
      informationBuilderService.buildResponseForDefaultDSRules(vesselRuleReply, builder);
    }
    builder.setResponseStatus(
        Common.ResponseStatus.newBuilder().setStatus(DischargePlanConstants.SUCCESS).build());
  }

  /**
   * save rules against discharge study
   *
   * @param request
   * @param dischargeStudy
   * @param vesselRuleReply
   */
  private void saveRulesAgainstDischargeStudy(
      DischargeRuleRequest request,
      Optional<DischargeInformation> dischargeStudy,
      VesselInfo.VesselRuleReply vesselRuleReply) {
    List<DischargePlanRules> dischargeStudyRulesList = new ArrayList<>();
    request
        .getRulePlanList()
        .forEach(
            rulePlans -> {
              rulePlans
                  .getRulesList()
                  .forEach(
                      rule -> {
                        DischargePlanRules dischargeStudyRules = new DischargePlanRules();
                        Optional<String> isRuleTemplateIdExist =
                            Optional.ofNullable(rule.getRuleTemplateId())
                                .filter(item -> item.trim().length() != 0);
                        if (rule.getId() != null && rule.getId().trim().length() != 0) {
                          Optional<DischargePlanRules> rVesselMapping =
                              dischargeStudyRulesRepository.findById(Long.valueOf(rule.getId()));
                          if (rVesselMapping.isPresent()) {
                            dischargeStudyRules = rVesselMapping.get();
                          } else {
                            log.info("No record exist for this id in discharge study rule table");
                            throw new RuntimeException(
                                "No record exist for this id in discharge study rule table");
                          }
                        } else {
                          if (isRuleTemplateIdExist.isPresent()) {
                            Optional<DischargePlanRules> loadableStudyRulesRecord =
                                dischargeStudyRulesRepository.checkIsRuleTemplateExist(
                                    dischargeStudy.get().getId(),
                                    true,
                                    Long.valueOf(rule.getRuleTemplateId()));
                            if (loadableStudyRulesRecord.isPresent()) {
                              log.info(
                                  "Duplicate row can't insert for given vessel id and parent rule id");
                              throw new RuntimeException(
                                  "Duplicate row can't insert for given vessel id and parent rule id");
                            }
                          }
                        }
                        dischargeStudyRules.setDischargeInformation(dischargeStudy.get());
                        dischargeStudyRules.setIsActive(true);
                        DischargePlanRules finalDischargeStudyRules = dischargeStudyRules;
                        Optional.ofNullable(rule.getDisplayInSettings())
                            .ifPresentOrElse(
                                dischargeStudyRules::setDisplayInSettings,
                                () -> finalDischargeStudyRules.setDisplayInSettings(false));
                        Optional.ofNullable(rule.getEnable())
                            .ifPresentOrElse(
                                dischargeStudyRules::setIsEnable,
                                () -> finalDischargeStudyRules.setIsEnable(false));
                        Optional.ofNullable(rule.getIsHardRule())
                            .ifPresentOrElse(
                                dischargeStudyRules::setIsHardRule,
                                () -> finalDischargeStudyRules.setIsHardRule(false));
                        Optional.ofNullable(rule.getNumericPrecision())
                            .ifPresent(dischargeStudyRules::setNumericPrecision);
                        Optional.ofNullable(rule.getNumericScale())
                            .ifPresent(dischargeStudyRules::setNumericScale);
                        Optional.ofNullable(rule.getRuleTemplateId())
                            .ifPresent(
                                item ->
                                    finalDischargeStudyRules.setParentRuleXId(
                                        Long.parseLong(item)));
                        dischargeStudyRules.setVesselXId(request.getVesselId());
                        if (!CollectionUtils.isEmpty(vesselRuleReply.getRuleTypeMasterList())
                            && rule.getRuleType() != null
                            && rule.getRuleType().trim() != "") {
                          Optional<VesselInfo.RuleTypeMaster> ruleType =
                              vesselRuleReply.getRuleTypeMasterList().stream()
                                  .filter(
                                      rType ->
                                          rType.getRuleType().equalsIgnoreCase(rule.getRuleType()))
                                  .findAny();
                          ruleType.orElseThrow(RuntimeException::new);
                          dischargeStudyRules.setRuleTypeXId(ruleType.get().getId());
                        } else {
                          log.info("Rule Type can't be null");
                          throw new RuntimeException("Rule type can't be null");
                        }
                        Optional.ofNullable(rule.getVesselRuleXId())
                            .ifPresent(
                                vesselRuleXId ->
                                    finalDischargeStudyRules.setVesselRuleXId(
                                        Long.parseLong(vesselRuleXId)));
                        List<DischargePlanRuleInput> ruleVesselMappingInputList = new ArrayList<>();
                        for (Common.RulesInputs input : rule.getInputsList()) {
                          DischargePlanRuleInput ruleTemplateInput = new DischargePlanRuleInput();
                          if (input.getId() != null && input.getId().length() != 0) {
                            Optional<DischargePlanRuleInput> rTemplateInput =
                                dischargeStudyRulesInputRepository.findById(
                                    Long.valueOf(input.getId()));
                            if (rTemplateInput.isPresent()) {
                              ruleTemplateInput = rTemplateInput.get();
                            } else {
                              log.info(
                                  "No record exist for this id in rule discharging study rule input table");
                              throw new RuntimeException(
                                  "No record exist for this id in rule discharging study rule input table");
                            }
                          }
                          DischargePlanRuleInput finalRuleTemplateInput = ruleTemplateInput;
                          Optional.ofNullable(input.getDefaultValue())
                              .filter(item -> item.trim().length() != 0)
                              .ifPresentOrElse(
                                  ruleTemplateInput::setDefaultValue,
                                  () -> finalRuleTemplateInput.setDefaultValue(null));
                          Optional.ofNullable(input.getMax())
                              .filter(item -> item.trim().length() != 0)
                              .ifPresent(ruleTemplateInput::setMaxValue);
                          Optional.ofNullable(input.getMin())
                              .filter(item -> item.trim().length() != 0)
                              .ifPresent(ruleTemplateInput::setMinValue);
                          Optional.ofNullable(input.getSuffix())
                              .filter(item -> item.trim().length() != 0)
                              .ifPresent(ruleTemplateInput::setSuffix);
                          Optional.ofNullable(input.getPrefix())
                              .filter(item -> item.trim().length() != 0)
                              .ifPresent(ruleTemplateInput::setPrefix);
                          Optional.ofNullable(input.getType())
                              .filter(item -> item.trim().length() != 0)
                              .ifPresent(ruleTemplateInput::setTypeValue);
                          Optional.ofNullable(input.getIsMandatory())
                              .ifPresentOrElse(
                                  ruleTemplateInput::setIsMandatory,
                                  () -> finalRuleTemplateInput.setIsMandatory(false));
                          ruleTemplateInput.setIsActive(true);
                          ruleTemplateInput.setDischargePlanRules(dischargeStudyRules);
                          Optional<String> isTypeDropDownOrMultiSelect =
                              Optional.ofNullable(input.getType())
                                  .filter(
                                      value ->
                                          value.trim().length() != 0
                                                  && value
                                                      .trim()
                                                      .equalsIgnoreCase(
                                                          com.cpdss.dischargeplan.domain.TypeValue
                                                              .DROPDOWN
                                                              .getType())
                                              || value
                                                  .trim()
                                                  .equalsIgnoreCase(
                                                      com.cpdss.dischargeplan.domain.TypeValue
                                                          .MULTISELECT
                                                          .getType()));

                          if (isTypeDropDownOrMultiSelect.isPresent()) {
                            Optional<String> isPrefixExist =
                                Optional.ofNullable(input.getPrefix())
                                    .filter(
                                        item ->
                                            item.trim().length() != 0
                                                && item.trim()
                                                    .equalsIgnoreCase(
                                                        RuleMasterData.CargoTank.getPrefix()));
                            Optional<String> isSuffixExist =
                                Optional.ofNullable(input.getSuffix())
                                    .filter(
                                        item ->
                                            item.trim().length() != 0
                                                && item.trim()
                                                    .equalsIgnoreCase(
                                                        RuleMasterData.CargoTank.getSuffix()));
                            try {
                              if (isPrefixExist.isPresent() && isSuffixExist.isPresent()) {
                                this.ruleMasterDropDownValidation(
                                    vesselRuleReply.getRuleDropDownValueMasterList(),
                                    vesselRuleReply.getCargoTankMasterList(),
                                    true,
                                    input,
                                    ruleTemplateInput,
                                    rule);
                              } else {
                                this.ruleMasterDropDownValidation(
                                    vesselRuleReply.getRuleDropDownValueMasterList(),
                                    vesselRuleReply.getCargoTankMasterList(),
                                    false,
                                    input,
                                    ruleTemplateInput,
                                    rule);
                              }
                            } catch (GenericServiceException e) {
                              throw new RuntimeException(
                                  "Master rule drop down value does not exist");
                            }
                          }
                          ruleVesselMappingInputList.add(ruleTemplateInput);
                        }
                        dischargeStudyRules.setDischargePlanRuleInputList(
                            ruleVesselMappingInputList);
                        dischargeStudyRulesList.add(dischargeStudyRules);
                      });
            });
    dischargeStudyRulesRepository.saveAll(dischargeStudyRulesList);
  }

  /**
   * validate master dropdown values
   *
   * @param listOfDropDownValue
   * @param cargoTankMaster
   * @param isCargoTankMaster
   * @param input
   * @param ruleTemplateInput
   * @param rule
   * @throws GenericServiceException
   */
  private void ruleMasterDropDownValidation(
      List<VesselInfo.RuleDropDownValueMaster> listOfDropDownValue,
      List<VesselInfo.CargoTankMaster> cargoTankMaster,
      boolean isCargoTankMaster,
      Common.RulesInputs input,
      DischargePlanRuleInput ruleTemplateInput,
      Common.Rules rule)
      throws GenericServiceException {
    Optional<String> isDefaultValueExist =
        Optional.ofNullable(input.getDefaultValue()).filter(item -> item.trim().length() != 0);
    if (isDefaultValueExist.isPresent()) {
      String value = "";
      List<VesselInfo.RuleDropDownValueMaster> filterMasterByRule =
          listOfDropDownValue.stream()
              .filter(
                  rDropDown ->
                      rDropDown.getRuleTemplateId() != 0
                          && rule.getRuleTemplateId() != null
                          && rDropDown.getRuleTemplateId()
                              == Long.parseLong(rule.getRuleTemplateId().trim()))
              .collect(Collectors.toList());
      if (input.getDefaultValue().contains(",")) {
        String[] masterIds = input.getDefaultValue().split(",");
        for (int id = 0; id < masterIds.length; id++) {
          int finalId = id;
          if (isCargoTankMaster) {
            if (cargoTankMaster.stream()
                .map(VesselInfo.CargoTankMaster::getId)
                .filter(item -> item == Long.parseLong(masterIds[finalId].trim()))
                .findFirst()
                .isPresent()) {
              if (masterIds.length - 1 != id) {
                value += masterIds[id] + ",";
              } else {
                value += masterIds[id];
              }
            } else {
              throw new GenericServiceException(
                  "Rule master master with given id does not exist",
                  CommonErrorCodes.E_HTTP_BAD_REQUEST,
                  HttpStatusCode.BAD_REQUEST);
            }
          } else {
            if (filterMasterByRule.stream()
                .map(VesselInfo.RuleDropDownValueMaster::getId)
                .filter(item -> item == Long.parseLong(masterIds[finalId].trim()))
                .findFirst()
                .isPresent()) {
              if (masterIds.length - 1 != id) {
                value += masterIds[id] + ",";
              } else {
                value += masterIds[id];
              }
            } else {
              throw new GenericServiceException(
                  "Rule master master with given id does not exist",
                  CommonErrorCodes.E_HTTP_BAD_REQUEST,
                  HttpStatusCode.BAD_REQUEST);
            }
          }
        }
        ruleTemplateInput.setDefaultValue(value);
      } else {
        if (isCargoTankMaster) {
          if (input.getDefaultValue() != null
              && input.getDefaultValue().length() != 0
              && !cargoTankMaster.stream()
                  .map(VesselInfo.CargoTankMaster::getId)
                  .filter(item -> item == Long.parseLong(input.getDefaultValue().trim()))
                  .findFirst()
                  .isPresent()) {
            throw new GenericServiceException(
                "Cargo master with given id does not exist",
                CommonErrorCodes.E_HTTP_BAD_REQUEST,
                HttpStatusCode.BAD_REQUEST);
          }
        } else {
          if (input.getDefaultValue() != null
              && input.getDefaultValue().length() != 0
              && !filterMasterByRule.stream()
                  .map(VesselInfo.RuleDropDownValueMaster::getId)
                  .filter(item -> item == Long.parseLong(input.getDefaultValue().trim()))
                  .findFirst()
                  .isPresent()) {
            throw new GenericServiceException(
                "Rule master master with given id does not exist",
                CommonErrorCodes.E_HTTP_BAD_REQUEST,
                HttpStatusCode.BAD_REQUEST);
          }
        }
        ruleTemplateInput.setDefaultValue(input.getDefaultValue());
      }
    } else {
      ruleTemplateInput.setDefaultValue(null);
    }
  }

  /**
   * upload Port Tide Details to DB.
   *
   * @param request - DischargingUploadTideDetailRequest.
   * @throws GenericServiceException - throws GenericServiceException from the method.
   */
  public void uploadPortTideDetails(DischargingUploadTideDetailRequest request)
      throws GenericServiceException {

    ByteString tideDetaildata = request.getTideDetaildata();
    InputStream bin = new ByteArrayInputStream(tideDetaildata.toByteArray());
    try (Workbook workbook = WorkbookFactory.create(bin)) {
      Sheet sheetAt = workbook.getSheet(SHEET);
      fileSheetIsCorrect(sheetAt);
      Iterator<Row> rowIterator = sheetAt.iterator();
      checkIsTheFileTitleFormat(rowIterator);
      if (!rowIterator.hasNext()) {
        throw new IllegalStateException(CommonErrorCodes.E_CPDSS_EMPTY_EXCEL_FILE);
      }
      List<PortTideDetail> tideDetails = new ArrayList<>();
      while (rowIterator.hasNext()) {
        PortTideDetail tideDetail = new PortTideDetail();
        tideDetail.setDischargingXid(request.getLoadingId());
        tideDetail.setIsActive(true);
        Row row = rowIterator.next();
        checkIsFileContentBlankOrNot(row);
        Iterator<Cell> cellIterator = row.cellIterator();
        for (int rowCell = 0; rowCell <= 3; rowCell++) {
          Cell cell = cellIterator.next();
          CellType cellType = cell.getCellType();
          fetchCellValues(
              rowCell, cellType, tideDetail, cell, request.getPortName(), request.getPortId());
        }
        tideDetails.add(tideDetail);
      }
      portTideDetailsRepository.updatePortDetailActiveState(request.getLoadingId());
      portTideDetailsRepository.saveAll(tideDetails);
    } catch (IllegalStateException e) {
      throw new GenericServiceException(e.getMessage(), e.getMessage(), HttpStatusCode.BAD_REQUEST);
    } catch (Exception e) {
      throw new GenericServiceException(
          e.getMessage(),
          CommonErrorCodes.E_HTTP_INTERNAL_SERVER_ERROR,
          HttpStatusCode.INTERNAL_SERVER_ERROR);
    }
  }

  /**
   * fetch each cell values from workbook
   *
   * @param rowCell
   * @param cellType
   * @param tideDetail
   * @param cell
   * @throws ParseException
   */
  private void fetchCellValues(
      int rowCell,
      CellType cellType,
      PortTideDetail tideDetail,
      Cell cell,
      String portName,
      Long portId)
      throws ParseException {
    // fetch String value from excel
    if (rowCell == 0) {
      fetchPortCellValue(cellType, tideDetail, cell, portName, portId);
    }
    // fetch Date value from excel
    if (rowCell == 1) {
      fetchTideDateCellValue(cellType, tideDetail, cell);
    }
    // fetch Time value from excel
    if (rowCell == 2) {
      fetchTideTimeCellValue(cellType, tideDetail, cell);
    }
    // fetch Double value from excel
    if (rowCell == 3) {
      if (!cellType.equals(CellType.NUMERIC)) {
        throw new IllegalStateException(CommonErrorCodes.E_CPDSS_TIDE_HEIGHT_INVALID);
      }
      tideDetail.setTideHeight(BigDecimal.valueOf(cell.getNumericCellValue()));
    }
  }

  /**
   * fetch port cell values
   *
   * @param cellType
   * @param tideDetail
   * @param cell
   */
  private void fetchPortCellValue(
      CellType cellType, PortTideDetail tideDetail, Cell cell, String portName, Long portId) {

    if (!cellType.equals(CellType.STRING)
        || !cell.getStringCellValue().trim().equalsIgnoreCase(portName.trim())) {
      throw new IllegalStateException(CommonErrorCodes.E_CPDSS_PORT_NAME_INVALID);
    }
    tideDetail.setPortXid(portId);
  }

  /**
   * fetch tide date cell value
   *
   * @param cellType
   * @param tideDetail
   * @param cell
   * @throws ParseException
   */
  private void fetchTideDateCellValue(CellType cellType, PortTideDetail tideDetail, Cell cell)
      throws ParseException {
    if (cellType.equals(CellType.NUMERIC)) {
      double numberValue = cell.getNumericCellValue();
      if (DateUtil.isCellDateFormatted(cell)) {
        tideDetail.setTideDate(DateUtil.getJavaDate(numberValue));
      } else {
        throw new IllegalStateException(CommonErrorCodes.E_CPDSS_TIDE_DATE_INVALID);
      }
    } else if (cellType.equals(CellType.STRING)) {
      if (!cell.getStringCellValue().matches("([0-9]{2})-([0-9]{2})-([0-9]{4})")) {
        throw new IllegalStateException(CommonErrorCodes.E_CPDSS_TIDE_DATE_INVALID);
      }
      tideDetail.setTideDate(new SimpleDateFormat(DATE_FORMAT).parse(cell.getStringCellValue()));
    } else {
      throw new IllegalStateException(CommonErrorCodes.E_CPDSS_TIDE_DATE_INVALID);
    }
  }

  /**
   * fetch tide time cell value
   *
   * @param cellType
   * @param tideDetail
   * @param cell
   */
  private void fetchTideTimeCellValue(CellType cellType, PortTideDetail tideDetail, Cell cell) {
    if (cellType.equals(CellType.NUMERIC)) {
      if (DateUtil.isCellDateFormatted(cell)) {
        if (cell.getLocalDateTimeCellValue().toLocalTime().equals(LocalTime.of(0, 0))) {
          throw new IllegalStateException(CommonErrorCodes.E_CPDSS_TIDE_TIME_INVALID);
        }
        tideDetail.setTideTime(cell.getLocalDateTimeCellValue().toLocalTime());
      } else {
        throw new IllegalStateException(CommonErrorCodes.E_CPDSS_TIDE_TIME_INVALID);
      }
    } else if (cellType.equals(CellType.STRING)) {
      if (!cell.getStringCellValue().matches("([0-9]{2}):([0-9]{2})")) {
        throw new IllegalStateException(CommonErrorCodes.E_CPDSS_TIDE_TIME_INVALID);
      }
      tideDetail.setTideTime(LocalTime.parse(cell.getStringCellValue()));
    } else {
      throw new IllegalStateException(CommonErrorCodes.E_CPDSS_TIDE_TIME_INVALID);
    }
  }

  /**
   * Validate is file title contents format is expected
   *
   * @param rowIterator
   */
  private void checkIsTheFileTitleFormat(Iterator<Row> rowIterator) {
    Row row = rowIterator.next();
    Iterator<Cell> cellIterator = row.cellIterator();
    for (int columnNo = 0; columnNo < PORT_EXCEL_TEMPLATE_TITLES.size(); columnNo++) {
      Cell cell = cellIterator.next();
      if (cell.getCellType().equals(CellType.BLANK)) {
        throw new IllegalStateException(CommonErrorCodes.E_CPDSS_INVALID_CONTENT);
      } else {
        try {
          if (!cell.getStringCellValue()
              .equalsIgnoreCase(PORT_EXCEL_TEMPLATE_TITLES.get(columnNo))) {
            throw new IllegalStateException(CommonErrorCodes.E_CPDSS_INVALID_CONTENT);
          }
        } catch (Exception e) {
          throw new IllegalStateException(CommonErrorCodes.E_CPDSS_INVALID_CONTENT);
        }
      }
    }
  }

  /**
   * check if the file content is blank or not
   *
   * @param row
   */
  private void checkIsFileContentBlankOrNot(Row row) {
    Iterator<Cell> secondCellIterator = row.cellIterator();
    Cell cell = secondCellIterator.next();
    if (cell.getCellType().equals(CellType.BLANK)) {
      throw new IllegalStateException(CommonErrorCodes.E_CPDSS_EMPTY_EXCEL_FILE);
    }
  }

  /**
   * Check if the file sheet is correct
   *
   * @param sheet
   */
  private void fileSheetIsCorrect(Sheet sheet) {

    if (sheet == null) {
      throw new IllegalStateException(CommonErrorCodes.E_CPDSS_INVALID_CONTENT);
    }
  }
  /**
   * download Port Tide Details template
   *
   * @param workbook - XSSFWorkbook
   * @param request - DownloadTideDetailRequest
   * @param builder - Builder class
   * @throws GenericServiceException - throws GenericServiceException from the method.
   */
  public void downloadPortTideDetails(
      XSSFWorkbook workbook, DischargingDownloadTideDetailRequest request, Builder builder)
      throws GenericServiceException, IOException {
    try {
      XSSFSheet spreadsheet = workbook.createSheet(SHEET);
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      int rowNo = 0;
      XSSFRow titleRow = spreadsheet.createRow(rowNo);
      XSSFCellStyle cellStyle = workbook.createCellStyle();
      XSSFFont font = workbook.createFont();
      font.setFontName(PORT_TITLE_FONT_STYLE);
      font.setFontHeight(PORT_TITLE_FONT_HEIGHT);
      font.setBold(true);
      cellStyle.setFont(font);
      for (int columnNo = 0; columnNo < PORT_EXCEL_TEMPLATE_TITLES.size(); columnNo++) {
        spreadsheet.setColumnWidth(columnNo, 17 * 256);
        XSSFCell titleCell = titleRow.createCell(columnNo);
        titleCell.setCellStyle(cellStyle);
        titleCell.setCellValue(PORT_EXCEL_TEMPLATE_TITLES.get(columnNo));
      }
      long loadingId = request.getLoadingId();
      if (loadingId != 0) {
        List<PortTideDetail> list =
            portTideDetailsRepository.findByDischargingXidAndIsActive(request.getLoadingId(), true);
        if (!list.isEmpty()) {
          Map<Long, String> portsMap = getPortDetailsFromPortService();
          for (rowNo = 0; rowNo < list.size(); rowNo++) {
            XSSFRow row = spreadsheet.createRow(rowNo + 1);
            for (int columnNo = 0; columnNo < PORT_EXCEL_TEMPLATE_TITLES.size(); columnNo++) {
              XSSFCell cell = row.createCell(columnNo);
              if (PORT_EXCEL_TEMPLATE_TITLES.get(columnNo).equals(PORT)) {
                cell.setCellType(CellType.STRING);
                cell.setCellValue(portsMap.get(list.get(rowNo).getPortXid()));
              }
              if (PORT_EXCEL_TEMPLATE_TITLES.get(columnNo).equals(TIDE_DATE)) {
                cell.setCellType(CellType.NUMERIC);
                cell.setCellValue(
                    new SimpleDateFormat(DATE_FORMAT).format(list.get(rowNo).getTideDate()));
              }
              if (PORT_EXCEL_TEMPLATE_TITLES.get(columnNo).equals(TIDE_TIME)) {
                cell.setCellType(CellType.NUMERIC);
                cell.setCellValue(list.get(rowNo).getTideTime().toString());
              }
              if (PORT_EXCEL_TEMPLATE_TITLES.get(columnNo).equals(TIDE_HEIGHT)) {
                cell.setCellType(CellType.NUMERIC);
                cell.setCellValue(list.get(rowNo).getTideHeight().doubleValue());
              }
            }
          }
        }
      }
      workbook.write(byteArrayOutputStream);
      byte[] bytes = byteArrayOutputStream.toByteArray();
      builder
          .setData(ByteString.copyFrom(bytes))
          .setSize(bytes.length)
          .setResponseStatus(
              ResponseStatus.newBuilder()
                  .setStatus(SUCCESS)
                  .setCode(HttpStatusCode.OK.getReasonPhrase())
                  .build())
          .build();
      byteArrayOutputStream.close();
    } catch (Exception e) {
      throw new GenericServiceException(
          e.getMessage(),
          CommonErrorCodes.E_HTTP_INTERNAL_SERVER_ERROR,
          HttpStatusCode.INTERNAL_SERVER_ERROR);
    }
  }
  /**
   * To fetch port details from port service.
   *
   * @return Map of Key value pair
   */
  private Map<Long, String> getPortDetailsFromPortService() {
    PortRequestWithPaging redisRequest =
        PortRequestWithPaging.newBuilder()
            .setOffset(RedisConfigConstants.OFFSET_VAL)
            .setLimit(RedisConfigConstants.PAGE_COUNT)
            .build();
    PortReply reply = portInfoServiceBlockingStub.getPortInfoByPaging(redisRequest);
    List<PortDetail> portsList = reply.getPortsList();
    Map<Long, String> portsMap = new HashMap<>();
    if (!portsList.isEmpty()) {
      portsMap =
          portsList.stream().collect(Collectors.toMap(map -> map.getId(), map -> map.getName()));
    }
    return portsMap;
  }

  public void updateIsDischargingInfoCompeteStatus(Long id, boolean isDischargingInfoComplete) {
    dischargeInformationRepository.updateDischargeInformationCompleteStatus(
        id, isDischargingInfoComplete);
  }

  public void updateDischargingPlanDetailsFromAlgo(Long id, String dischargingPlanDetailsFromAlgo) {
    dischargeInformationRepository.updateDischargingPlanDetailsFromAlgo(
        id, dischargingPlanDetailsFromAlgo);
  }

  public void updateDischargingInformationStatus(
      DischargingInformationStatus dischargingInformationStatus, Long id) {
    dischargeInformationRepository.updateDischargingInformationStatus(
        dischargingInformationStatus, id);
  }

  public void updateDischargingInformationStatuses(
      DischargingInformationStatus dischargingInformationStatus,
      DischargingInformationStatus arrivalStatus,
      DischargingInformationStatus departureStatus,
      Long id) {
    dischargeInformationRepository.updateDischargingInformationStatuses(
        dischargingInformationStatus, arrivalStatus.getId(), departureStatus.getId(), id);
  }

  public void updateIsDischargingSequenceGeneratedStatus(Long id, boolean sequence) {
    dischargeInformationRepository.updateIsDischargingSequenceGeneratedStatus(id, sequence);
  }

  public void updateIsDischargingPlanGeneratedStatus(Long id, boolean isPlanGenerated) {
    dischargeInformationRepository.updateIsDischargingPlanGeneratedStatus(id, isPlanGenerated);
  }

  /**
   * Get discharge rules for the algo request json
   *
   * @param vesselId
   * @param dischargingInfoId
   * @return DischargeRuleReply
   */
  public DischargeRuleReply getDischargingRuleForAlgo(Long vesselId, Long dischargingInfoId) {
    com.cpdss.common.generated.discharge_plan.DischargeRuleRequest.Builder request =
        DischargeRuleRequest.newBuilder();
    request.setDischargeInfoId(dischargingInfoId);
    request.setVesselId(vesselId);
    request.setSectionId(DISCHARGING_RULE_MASTER_ID);
    DischargeRuleReply.Builder builder = DischargeRuleReply.newBuilder();
    try {
      this.getOrSaveRulesForDischargingPlan(request.build(), builder);
    } catch (GenericServiceException e) {
      e.printStackTrace();
    }
    return builder.build();
  }

  public void getOrSaveRulesForDischargingPlan(
      DischargeRuleRequest request, DischargeRuleReply.Builder builder)
      throws GenericServiceException {
    if (!RuleMasterSection.Discharging.getId().equals(request.getSectionId())) {
      throw new GenericServiceException(
          "Invalid Rule Master Id Passed! Only Accept Discharging Rule.",
          CommonErrorCodes.E_HTTP_BAD_REQUEST,
          HttpStatusCode.BAD_REQUEST);
    }

    DischargeInformation dischargeInformation =
        this.getDischargeInformation(request.getDischargeInfoId());

    if (dischargeInformation == null) {
      log.error(
          "Failed to get loading information for get or save rule", request.getDischargeInfoId());
      throw new GenericServiceException(
          "Discharging Information with given id does not exist",
          CommonErrorCodes.E_HTTP_BAD_REQUEST,
          HttpStatusCode.BAD_REQUEST);
    }
    VesselInfo.VesselRuleRequest.Builder vesselRuleBuilder =
        VesselInfo.VesselRuleRequest.newBuilder();
    vesselRuleBuilder.setSectionId(request.getSectionId());
    vesselRuleBuilder.setVesselId(request.getVesselId());
    vesselRuleBuilder.setIsFetchEnabledRules(false);
    vesselRuleBuilder.setIsNoDefaultRule(true);
    VesselInfo.VesselRuleReply vesselRuleReply =
        this.vesselInfoGrpcService.getRulesByVesselIdAndSectionId(vesselRuleBuilder.build());
    if (!SUCCESS.equals(vesselRuleReply.getResponseStatus().getStatus())) {
      throw new GenericServiceException(
          "failed to get vessel rule Details ",
          vesselRuleReply.getResponseStatus().getCode(),
          HttpStatusCode.valueOf(Integer.parseInt(vesselRuleReply.getResponseStatus().getCode())));
    }
    if (!CollectionUtils.isEmpty(request.getRulePlanList())) {
      log.info("Save Loading Info Rules");
      saveRulesAgainstLoading(request, dischargeInformation, vesselRuleReply);
    }
    List<Long> ruleListId =
        vesselRuleReply.getRulePlanList().stream()
            .flatMap(rulesList -> rulesList.getRulesList().stream())
            .map(rules -> Long.parseLong(rules.getVesselRuleXId()))
            .collect(Collectors.toList());
    List<DischargePlanRules> dischargingRulesList =
        dischargeRulesRepository
            .findByDischargeInformationAndVesselXIdAndIsActiveAndVesselRuleXIdInOrderById(
                dischargeInformation, request.getVesselId(), true, ruleListId);
    if (dischargingRulesList.size() > 0) {
      log.info("Discharging information rules fetched, Size {}", dischargingRulesList.size());
      vesselRuleReply
          .getRulePlanList()
          .forEach(
              rulePlans -> {
                Common.RulePlans.Builder rulePlanBuider = Common.RulePlans.newBuilder();
                Optional.ofNullable(rulePlans.getHeader())
                    .ifPresent(item -> rulePlanBuider.setHeader(item));
                List<Long> ruleId =
                    rulePlans.getRulesList().stream()
                        .map(rules -> Long.parseLong(rules.getVesselRuleXId()))
                        .collect(Collectors.toList());
                List<DischargePlanRules> dStudyRulesList =
                    dischargingRulesList.stream()
                        .filter(lRuleList -> ruleId.contains(lRuleList.getVesselRuleXId()))
                        .collect(Collectors.toList());
                buildResponseForRules(dStudyRulesList, rulePlanBuider, builder, vesselRuleReply);
              });
    } else {
      log.info(
          "Fetch default loading plan Rules, Size {}", vesselRuleReply.getRulePlanList().size());
      vesselRuleReply
          .getRulePlanList()
          .forEach(
              rulePlans -> {
                Common.RulePlans.Builder rulePlanBuilder = Common.RulePlans.newBuilder();
                Optional.ofNullable(rulePlans.getHeader()).ifPresent(rulePlanBuilder::setHeader);
                List<Common.Rules> ruleList =
                    rulePlans.getRulesList().stream()
                        .filter(item -> item.getEnable())
                        .collect(Collectors.toList());
                if (ruleList != null && ruleList.size() > 0) {
                  rulePlanBuilder.addAllRules(ruleList);
                  builder.addRulePlan(rulePlanBuilder);
                }
              });
    }
    builder.setResponseStatus(Common.ResponseStatus.newBuilder().setStatus(SUCCESS).build());
  }

  private void saveRulesAgainstLoading(
      DischargeRuleRequest request,
      DischargeInformation dischargeInformation,
      VesselInfo.VesselRuleReply vesselRuleReply) {
    List<DischargePlanRules> loadingRuleList = new ArrayList<>();
    request
        .getRulePlanList()
        .forEach(
            rulePlans -> {
              rulePlans
                  .getRulesList()
                  .forEach(
                      rule -> {
                        DischargePlanRules dischargePlanRules = new DischargePlanRules();
                        Optional<String> isRuleTemplateIdExist =
                            Optional.ofNullable(rule.getRuleTemplateId())
                                .filter(item -> item.trim().length() != 0);
                        if (rule.getId() != null && rule.getId().trim().length() != 0) {
                          Optional<DischargePlanRules> rVesselMapping =
                              dischargeRulesRepository.findById(Long.valueOf(rule.getId()));
                          if (rVesselMapping.isPresent()) {
                            dischargePlanRules = rVesselMapping.get();
                          } else {
                            log.info("No record exist for this id in loading  rule table");
                            throw new RuntimeException(
                                "No record exist for this id in loading  rule table");
                          }
                        } else {
                          if (isRuleTemplateIdExist.isPresent()) {
                            Optional<DischargePlanRules> loadableStudyRulesRecord =
                                dischargeRulesRepository.checkIsRuleTemplateExist(
                                    dischargeInformation.getId(),
                                    true,
                                    Long.valueOf(rule.getRuleTemplateId()));
                            if (loadableStudyRulesRecord.isPresent()) {
                              log.info(
                                  "Duplicate row can't insert for given vessel id and rule template");
                              throw new RuntimeException(
                                  "Duplicate row can't insert for given vessel id and rule template");
                            }
                          }
                        }
                        dischargePlanRules.setDischargeInformation(dischargeInformation);
                        dischargePlanRules.setIsActive(true);
                        DischargePlanRules finalLoadingRules = dischargePlanRules;
                        Optional.ofNullable(rule.getDisplayInSettings())
                            .ifPresentOrElse(
                                dischargePlanRules::setDisplayInSettings,
                                () -> finalLoadingRules.setDisplayInSettings(false));
                        Optional.ofNullable(rule.getEnable())
                            .ifPresentOrElse(
                                dischargePlanRules::setIsEnable,
                                () -> finalLoadingRules.setIsEnable(false));
                        Optional.ofNullable(rule.getIsHardRule())
                            .ifPresentOrElse(
                                dischargePlanRules::setIsHardRule,
                                () -> finalLoadingRules.setIsHardRule(false));
                        Optional.ofNullable(rule.getNumericPrecision())
                            .ifPresent(dischargePlanRules::setNumericPrecision);
                        Optional.ofNullable(rule.getNumericScale())
                            .ifPresent(dischargePlanRules::setNumericScale);
                        Optional.ofNullable(rule.getRuleTemplateId())
                            .ifPresent(
                                item -> finalLoadingRules.setParentRuleXId(Long.parseLong(item)));
                        dischargePlanRules.setVesselXId(request.getVesselId());
                        if (!CollectionUtils.isEmpty(vesselRuleReply.getRuleTypeMasterList())
                            && rule.getRuleType() != null
                            && rule.getRuleType().trim() != "") {
                          Optional<VesselInfo.RuleTypeMaster> ruleType =
                              vesselRuleReply.getRuleTypeMasterList().stream()
                                  .filter(
                                      rType ->
                                          rType.getRuleType().equalsIgnoreCase(rule.getRuleType()))
                                  .findAny();
                          ruleType.orElseThrow(RuntimeException::new);
                          dischargePlanRules.setRuleTypeXId(ruleType.get().getId());
                        } else {
                          log.info("Rule Type can't be null");
                          throw new RuntimeException("Rule type can't be null");
                        }
                        Optional.ofNullable(rule.getVesselRuleXId())
                            .ifPresent(
                                vesselRuleXId ->
                                    finalLoadingRules.setVesselRuleXId(
                                        Long.parseLong(vesselRuleXId)));
                        List<DischargePlanRuleInput> ruleVesselMappingInputList = new ArrayList<>();
                        for (Common.RulesInputs input : rule.getInputsList()) {
                          DischargePlanRuleInput ruleTemplateInput = new DischargePlanRuleInput();
                          if (input.getId() != null && input.getId().length() != 0) {
                            Optional<DischargePlanRuleInput> rTemplateInput =
                                dischargeRulesInputRepository.findById(Long.valueOf(input.getId()));
                            if (rTemplateInput.isPresent()) {
                              ruleTemplateInput = rTemplateInput.get();
                            } else {
                              log.info(
                                  "No record exist for this id in rule loading rule input table");
                              throw new RuntimeException(
                                  "No record exist for this id in rule loading rule input input table");
                            }
                          }
                          DischargePlanRuleInput finalRuleTemplateInput = ruleTemplateInput;
                          Optional.ofNullable(input.getDefaultValue())
                              .filter(item -> item.trim().length() != 0)
                              .ifPresentOrElse(
                                  ruleTemplateInput::setDefaultValue,
                                  () -> finalRuleTemplateInput.setDefaultValue(null));
                          Optional.ofNullable(input.getMax())
                              .filter(item -> item.trim().length() != 0)
                              .ifPresent(ruleTemplateInput::setMaxValue);
                          Optional.ofNullable(input.getMin())
                              .filter(item -> item.trim().length() != 0)
                              .ifPresent(ruleTemplateInput::setMinValue);
                          Optional.ofNullable(input.getSuffix())
                              .filter(item -> item.trim().length() != 0)
                              .ifPresent(ruleTemplateInput::setSuffix);
                          Optional.ofNullable(input.getPrefix())
                              .filter(item -> item.trim().length() != 0)
                              .ifPresent(ruleTemplateInput::setPrefix);
                          Optional.ofNullable(input.getType())
                              .filter(item -> item.trim().length() != 0)
                              .ifPresent(ruleTemplateInput::setTypeValue);
                          Optional.ofNullable(input.getIsMandatory())
                              .ifPresentOrElse(
                                  ruleTemplateInput::setIsMandatory,
                                  () -> finalRuleTemplateInput.setIsMandatory(false));
                          ruleTemplateInput.setIsActive(true);
                          ruleTemplateInput.setDischargePlanRules(dischargePlanRules);
                          Optional<String> isTypeDropDownOrMultiSelect =
                              Optional.ofNullable(input.getType())
                                  .filter(
                                      value ->
                                          value.trim().length() != 0
                                                  && value
                                                      .trim()
                                                      .equalsIgnoreCase(
                                                          TypeValue.DROPDOWN.getType())
                                              || value
                                                  .trim()
                                                  .equalsIgnoreCase(
                                                      TypeValue.MULTISELECT.getType()));

                          if (isTypeDropDownOrMultiSelect.isPresent()) {
                            Optional<String> isPrefixExistCTankOne =
                                Optional.ofNullable(input.getPrefix())
                                    .filter(
                                        item ->
                                            item.trim().length() != 0
                                                && item.trim()
                                                    .equalsIgnoreCase(
                                                        RuleMasterData.CargoTank.getPrefix()));
                            Optional<String> isSuffixExistCTankOne =
                                Optional.ofNullable(input.getSuffix())
                                    .filter(
                                        item ->
                                            item.trim().length() != 0
                                                && item.trim()
                                                    .equalsIgnoreCase(
                                                        RuleMasterData.CargoTank.getSuffix()));
                            Optional<String> isPrefixExistCTankTwo =
                                Optional.ofNullable(input.getPrefix())
                                    .filter(
                                        item ->
                                            item.trim().length() != 0
                                                && item.trim()
                                                    .equalsIgnoreCase(
                                                        RuleMasterData.CargoTank.getPrefix()));
                            Optional<String> isSuffixExistCTankTwo =
                                Optional.ofNullable(input.getSuffix())
                                    .filter(
                                        item ->
                                            item.trim().length() != 0
                                                && item.trim()
                                                    .equalsIgnoreCase(
                                                        RuleMasterData.CargoTank.getSuffix()));
                            try {
                              if ((isPrefixExistCTankOne.isPresent()
                                      && isSuffixExistCTankOne.isPresent())
                                  || (isPrefixExistCTankTwo.isPresent()
                                      && isSuffixExistCTankTwo.isPresent())) {
                                this.ruleMasterDropDownValidation(
                                    vesselRuleReply.getRuleDropDownValueMasterList(),
                                    vesselRuleReply.getCargoTankMasterList(),
                                    true,
                                    input,
                                    ruleTemplateInput,
                                    rule);
                              } else {
                                this.ruleMasterDropDownValidation(
                                    vesselRuleReply.getRuleDropDownValueMasterList(),
                                    vesselRuleReply.getCargoTankMasterList(),
                                    false,
                                    input,
                                    ruleTemplateInput,
                                    rule);
                              }
                            } catch (GenericServiceException e) {
                              throw new RuntimeException(
                                  "Master rule drop down value does not exist");
                            }
                          }
                          ruleVesselMappingInputList.add(ruleTemplateInput);
                        }
                        dischargePlanRules.setDischargePlanRuleInputList(
                            ruleVesselMappingInputList);
                        loadingRuleList.add(dischargePlanRules);
                      });
            });
    log.info("Saving Loading Rule List {}", loadingRuleList.size());
    dischargeRulesRepository.saveAll(loadingRuleList);
  }

  /**
   * @param dStudyRulesList
   * @param rulePlanBuilder
   * @param builder
   * @param vesselRuleReply
   */
  private void buildResponseForRules(
      List<DischargePlanRules> dStudyRulesList,
      com.cpdss.common.generated.Common.RulePlans.Builder rulePlanBuilder,
      DischargeRuleReply.Builder builder,
      VesselInfo.VesselRuleReply vesselRuleReply) {
    dStudyRulesList.forEach(
        ruleList -> {
          // for (int ruleIndex = 0; ruleIndex < lStudyRulesList.size(); ruleIndex++) {
          Common.Rules.Builder rulesBuilder = Common.Rules.newBuilder();
          Optional.ofNullable(ruleList.getIsEnable())
              .ifPresentOrElse(rulesBuilder::setEnable, () -> rulesBuilder.setEnable(false));
          Optional.ofNullable(ruleList.getDisplayInSettings())
              .ifPresentOrElse(
                  rulesBuilder::setDisplayInSettings,
                  () -> rulesBuilder.setDisplayInSettings(false));
          Optional.ofNullable(ruleList.getId())
              .ifPresentOrElse(
                  item -> rulesBuilder.setId(String.valueOf(item)), () -> rulesBuilder.setId(""));
          Optional.ofNullable(ruleList.getRuleTypeXId())
              .filter(item -> item.equals(RuleType.ABSOLUTE.getId()))
              .ifPresentOrElse(
                  item -> rulesBuilder.setRuleType(RuleType.ABSOLUTE.getRuleType()),
                  () -> rulesBuilder.setRuleType(RuleType.PREFERABLE.getRuleType()));
          Optional.ofNullable(ruleList.getIsHardRule())
              .ifPresentOrElse(
                  rulesBuilder::setIsHardRule, () -> rulesBuilder.setIsHardRule(false));
          Optional.ofNullable(ruleList.getVesselRuleXId())
              .ifPresentOrElse(
                  item -> rulesBuilder.setVesselRuleXId(String.valueOf(item)),
                  () -> rulesBuilder.setVesselRuleXId(""));
          Optional.ofNullable(ruleList.getParentRuleXId())
              .ifPresentOrElse(
                  item -> rulesBuilder.setRuleTemplateId(String.valueOf(item)),
                  () -> rulesBuilder.setRuleTemplateId(""));
          Optional.ofNullable(ruleList.getNumericPrecision())
              .ifPresentOrElse(
                  rulesBuilder::setNumericPrecision, () -> rulesBuilder.setNumericPrecision(0));
          Optional.ofNullable(ruleList.getNumericScale())
              .ifPresentOrElse(
                  rulesBuilder::setNumericScale, () -> rulesBuilder.setNumericScale(0));
          Common.RulesInputs.Builder ruleInput = Common.RulesInputs.newBuilder();
          List<DischargePlanRuleInput> loadableStudyRuleInputs;
          if (ruleList != null && ruleList.getDischargePlanRuleInputList().size() != 0) {
            loadableStudyRuleInputs =
                ruleList.getDischargePlanRuleInputList().stream()
                    .sorted(Comparator.comparingLong(DischargePlanRuleInput::getId))
                    .collect(Collectors.toList());
          } else {
            loadableStudyRuleInputs = new ArrayList<>();
          }
          for (int inputIndex = 0; inputIndex < loadableStudyRuleInputs.size(); inputIndex++) {
            Common.RulesInputs.Builder finalRuleInput = ruleInput;
            DischargePlanRuleInput input = loadableStudyRuleInputs.get(inputIndex);
            Optional.ofNullable(input.getDefaultValue())
                .filter(item -> item.trim().length() != 0)
                .ifPresentOrElse(
                    finalRuleInput::setDefaultValue, () -> finalRuleInput.setDefaultValue(""));
            Optional.ofNullable(input.getPrefix())
                .filter(item -> item.trim().length() != 0)
                .ifPresentOrElse(finalRuleInput::setPrefix, () -> finalRuleInput.setPrefix(""));
            Optional.ofNullable(input.getMinValue())
                .filter(item -> item.trim().length() != 0)
                .ifPresentOrElse(finalRuleInput::setMin, () -> finalRuleInput.setMin(""));
            Optional.ofNullable(input.getMaxValue())
                .filter(item -> item.trim().length() != 0)
                .ifPresentOrElse(finalRuleInput::setMax, () -> finalRuleInput.setMax(""));
            Optional.ofNullable(input.getTypeValue())
                .filter(item -> item.trim().length() != 0)
                .ifPresentOrElse(finalRuleInput::setType, () -> finalRuleInput.setType(""));
            Optional.ofNullable(input.getSuffix())
                .filter(item -> item.trim().length() != 0)
                .ifPresentOrElse(finalRuleInput::setSuffix, () -> finalRuleInput.setSuffix(""));
            Optional.ofNullable(input.getId())
                .ifPresentOrElse(
                    item -> finalRuleInput.setId(String.valueOf(item)),
                    () -> finalRuleInput.setId(""));
            Optional.ofNullable(input.getIsMandatory())
                .ifPresentOrElse(
                    finalRuleInput::setIsMandatory, () -> finalRuleInput.setIsMandatory(false));
            Optional<String> isTypeBoolean =
                Optional.ofNullable(input.getTypeValue())
                    .filter(
                        item ->
                            item.trim().length() != 0
                                && item.trim().equalsIgnoreCase(TypeValue.BOOLEAN.getType()));
            if (isTypeBoolean.isPresent()) {
              Optional.ofNullable(input.getDefaultValue())
                  .filter(item -> item.trim().length() != 0 && item.trim().equalsIgnoreCase("true"))
                  .ifPresentOrElse(
                      ruleInput::setDefaultValue, () -> ruleInput.setDefaultValue("false"));
            }
            Optional<String> isTypeDropDownOrMultiSelect =
                Optional.ofNullable(input.getTypeValue())
                    .filter(
                        item ->
                            item.trim().length() != 0
                                    && item.trim().equalsIgnoreCase(TypeValue.DROPDOWN.getType())
                                || item.trim().equalsIgnoreCase(TypeValue.MULTISELECT.getType()));
            if (isTypeDropDownOrMultiSelect.isPresent()) {
              Optional<String> isPrefixExistCTOne =
                  Optional.ofNullable(input.getPrefix())
                      .filter(
                          item ->
                              item.trim().length() != 0
                                  && item.trim()
                                      .equalsIgnoreCase(RuleMasterData.CargoTank.getPrefix()));
              Optional<String> isSuffixExistCTOne =
                  Optional.ofNullable(input.getSuffix())
                      .filter(
                          item ->
                              item.trim().length() != 0
                                  && item.trim()
                                      .equalsIgnoreCase(RuleMasterData.CargoTank.getSuffix()));
              Optional<String> isPrefixExistCTTwo =
                  Optional.ofNullable(input.getPrefix())
                      .filter(
                          item ->
                              item.trim().length() != 0
                                  && item.trim()
                                      .equalsIgnoreCase(RuleMasterData.CargoTank.getPrefix()));
              Optional<String> isSuffixExistCTTwo =
                  Optional.ofNullable(input.getSuffix())
                      .filter(
                          item ->
                              item.trim().length() != 0
                                  && item.trim()
                                      .equalsIgnoreCase(RuleMasterData.CargoTank.getSuffix()));
              Common.RuleDropDownMaster.Builder ruleDropDownMaster =
                  Common.RuleDropDownMaster.newBuilder();
              if ((isPrefixExistCTOne.isPresent() && isSuffixExistCTOne.isPresent())
                  || (isPrefixExistCTTwo.isPresent() && isSuffixExistCTTwo.isPresent())) {
                vesselRuleReply
                    .getCargoTankMasterList()
                    .forEach(
                        cargoTank -> {
                          Optional.ofNullable(cargoTank.getId())
                              .ifPresent(ruleDropDownMaster::setId);
                          Optional.ofNullable(cargoTank.getShortName())
                              .ifPresentOrElse(
                                  ruleDropDownMaster::setValue,
                                  () -> ruleDropDownMaster.setValue(""));
                          ruleInput.addRuleDropDownMaster(ruleDropDownMaster.build());
                        });
              } else {
                Optional<Long> ruleTempId = Optional.ofNullable(ruleList.getParentRuleXId());
                if (ruleTempId.isPresent()) {
                  List<VesselInfo.RuleDropDownValueMaster> filterMasterByRule =
                      vesselRuleReply.getRuleDropDownValueMasterList().stream()
                          .filter(
                              rDropDown ->
                                  rDropDown.getRuleTemplateId() != 0
                                      && ruleTempId.get() != null
                                      && rDropDown.getRuleTemplateId() == ruleTempId.get())
                          .collect(Collectors.toList());
                  filterMasterByRule.forEach(
                      masterDropDownRule -> {
                        Optional.ofNullable(masterDropDownRule.getId())
                            .ifPresent(ruleDropDownMaster::setId);
                        Optional.ofNullable(masterDropDownRule.getValue())
                            .ifPresent(ruleDropDownMaster::setValue);
                        ruleInput.addRuleDropDownMaster(ruleDropDownMaster.build());
                      });
                }
              }
            }
            rulesBuilder.addInputs(finalRuleInput.build());
          }
          rulePlanBuilder.addRules(rulesBuilder.build());
        });
    builder.addRulePlan(rulePlanBuilder);
  }

  public void updateDischargePlanStatus(
      DischargeInformation dsInfo, DischargingInformationStatus disInfoStatus, int conditionType) {
    if (DischargePlanConstants.DISCHARGE_PLAN_ARRIVAL_CONDITION_VALUE == conditionType) {
      dischargeInformationRepository.updateDischargeInformationArrivalStatus(
          disInfoStatus.getId(), dsInfo.getId());
    } else if (DischargePlanConstants.DISCHARGE_PLAN_DEPARTURE_CONDITION_VALUE == conditionType) {
      dischargeInformationRepository.updateDischargeInformationDepartureStatus(
          disInfoStatus.getId(), dsInfo.getId());
    }
  }

  public int updateDischargeInstructionStatusTrue(Long infoId) {
    try {
      dischargeInformationRepository.updateDischargeInstructionStatus(true, infoId);
      return 1;
    } catch (Exception e) {
      e.printStackTrace();
      return 0;
    }
  }

  /**
   * Fetching Rob details and building reply
   *
   * @param request
   * @param builder
   */
  public void getPortDischargingPlanRobDetails(
      PortDischargingPlanRobDetailsRequest request,
      PortDischargingPlanRobDetailsReply.Builder builder) {
    List<com.cpdss.dischargeplan.entity.PortDischargingPlanRobDetails>
        portDischargingPlanRobDetailsList =
            this.portDischargingPlanRobDetailsRepository
                .findByPortXIdAndPortRotationXIdAndConditionTypeAndValueTypeAndIsActive(
                    request.getPortXId(),
                    request.getPortRotationXId(),
                    request.getConditionType(),
                    request.getValueType(),
                    true);
    builder.addAllPortDischargingPlanRobDetails(
        this.informationBuilderService.buildPortDischargingPlanRobDetailsReply(
            portDischargingPlanRobDetailsList));
  }
}
