/* Licensed at AlphaOri Technologies */
package com.cpdss.dischargeplan.common;

import com.cpdss.common.generated.LoadableStudy;
import com.cpdss.common.generated.VesselInfo;
import com.cpdss.common.generated.discharge_plan.DischargeRuleReply;
import com.cpdss.dischargeplan.domain.TypeValue;
import com.cpdss.dischargeplan.domain.rules.RuleDropDownMaster;
import com.cpdss.dischargeplan.domain.rules.RulePlans;
import com.cpdss.dischargeplan.domain.rules.Rules;
import com.cpdss.dischargeplan.domain.rules.RulesInputs;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.util.CollectionUtils;

public class RuleUtility {

  public static List<RulePlans> buildAdminRulePlan(VesselInfo.VesselRuleReply vesselRuleReply) {
    List<RulePlans> rulePlans = new ArrayList<>();
    vesselRuleReply
        .getRulePlanList()
        .forEach(
            rulePlanList -> {
              RulePlans rulePlan = new RulePlans();
              Optional.of(rulePlanList.getHeader()).ifPresent(rulePlan::setHeader);
              if (!CollectionUtils.isEmpty(rulePlanList.getRulesList())) {
                rulePlan.setRules(buildRules(rulePlanList.getRulesList()));
              }
              rulePlans.add(rulePlan);
            });
    return rulePlans;
  }

  public static List<RulePlans> buildDischargingRule(DischargeRuleReply ruleReply) {
    List<RulePlans> rulePlans = new ArrayList<>();
    ruleReply
        .getRulePlanList()
        .forEach(
            rulePlanList -> {
              RulePlans rulePlan = new RulePlans();
              Optional.of(rulePlanList.getHeader()).ifPresent(rulePlan::setHeader);
              if (!CollectionUtils.isEmpty(rulePlanList.getRulesList())) {
                rulePlan.setRules(buildRules(rulePlanList.getRulesList()));
              }
              rulePlans.add(rulePlan);
            });
    return rulePlans;
  }

  public static List<RulePlans> buildLoadableRulePlan(LoadableStudy.LoadableRuleReply ruleReply) {
    List<RulePlans> rulePlans = new ArrayList<>();
    ruleReply
        .getRulePlanList()
        .forEach(
            rulePlanList -> {
              RulePlans rulePlan = new RulePlans();
              Optional.of(rulePlanList.getHeader()).ifPresent(rulePlan::setHeader);
              if (!CollectionUtils.isEmpty(rulePlanList.getRulesList())) {
                rulePlan.setRules(buildRules(rulePlanList.getRulesList()));
              }
              rulePlans.add(rulePlan);
            });
    return rulePlans;
  }

  static List<Rules> buildRules(List<com.cpdss.common.generated.Common.Rules> rulesList) {
    List<Rules> rules = new ArrayList<>();
    rulesList.forEach(
        rList -> {
          Rules rule = new Rules();
          Optional.ofNullable(rList.getEnable()).ifPresent(rule::setEnable);
          Optional.ofNullable(rList.getDisplayInSettings()).ifPresent(rule::setDisplayInSettings);
          if (isBlankString(rList.getVesselRuleXId())) {
            rule.setVesselRuleXId(rList.getVesselRuleXId());
          }
          if (isBlankString(rList.getId())) {
            rule.setId(rList.getId());
          }
          Optional.ofNullable(rList.getIsHardRule()).ifPresent(rule::setIsHardRule);
          Optional.ofNullable(rList.getNumericPrecision()).ifPresent(rule::setNumericPrecision);
          Optional.ofNullable(rList.getNumericScale()).ifPresent(rule::setNumericScale);
          Optional.ofNullable(rList.getRuleTemplateId()).ifPresent(rule::setRuleTemplateId);
          Optional.ofNullable(rList.getRuleType()).ifPresent(rule::setRuleType);
          Optional.ofNullable(rList.getEnable()).ifPresent(rule::setEnable);
          if (!CollectionUtils.isEmpty(rList.getInputsList())) {
            rule.setInputs(buildRuleInputs(rList.getInputsList()));
          }
          rules.add(rule);
        });
    return rules;
  }

  static List<RulesInputs> buildRuleInputs(
      List<com.cpdss.common.generated.Common.RulesInputs> inputsList) {
    List<RulesInputs> ruleInputsList = new ArrayList<>();
    inputsList.forEach(
        rInputsList -> {
          RulesInputs rulesInputs = new RulesInputs();
          if (isBlankString(rInputsList.getDefaultValue())) {
            rulesInputs.setDefaultValue(rInputsList.getDefaultValue());
            rulesInputs.setValue(rInputsList.getDefaultValue());
          }
          if (isBlankString(rInputsList.getMax())) {
            rulesInputs.setMax(rInputsList.getMax());
          }
          if (isBlankString(rInputsList.getMin())) {
            rulesInputs.setMin(rInputsList.getMin());
          }
          if (isBlankString(rInputsList.getPrefix())) {
            rulesInputs.setPrefix(rInputsList.getPrefix());
          }
          if (isBlankString(rInputsList.getPrefix())) {
            rulesInputs.setPrefix(rInputsList.getPrefix());
          }
          if (isBlankString(rInputsList.getSuffix())) {
            rulesInputs.setSuffix(rInputsList.getSuffix());
          }
          if (isBlankString(rInputsList.getId())) {
            rulesInputs.setId(rInputsList.getId());
          }
          Optional.ofNullable(rInputsList.getIsMandatory()).ifPresent(rulesInputs::setIsMandatory);
          if (isBlankString(rInputsList.getType())) {
            rulesInputs.setType(rInputsList.getType());
          }
          if (rInputsList.getType() != null
              && (rInputsList.getType().trim().equalsIgnoreCase(TypeValue.DROPDOWN.getType())
                  || rInputsList.getType().trim().equalsIgnoreCase(TypeValue.MULTISELECT.getType()))
              && rInputsList.getRuleDropDownMasterList() != null
              && rInputsList.getRuleDropDownMasterList().size() > 0) {
            List<RuleDropDownMaster> ruleDropDownMasters = new ArrayList<>();
            rInputsList
                .getRuleDropDownMasterList()
                .forEach(
                    ruleDropDownValue -> {
                      RuleDropDownMaster ruleDropDownMaster = new RuleDropDownMaster();
                      Optional.ofNullable(ruleDropDownValue.getId())
                          .ifPresent(ruleDropDownMaster::setId);
                      Optional.ofNullable(ruleDropDownValue.getValue())
                          .ifPresent(ruleDropDownMaster::setValue);
                      ruleDropDownMasters.add(ruleDropDownMaster);
                    });
            rulesInputs.setRuleDropDownMaster(ruleDropDownMasters);
          }
          ruleInputsList.add(rulesInputs);
        });
    return ruleInputsList;
  }

  static Boolean isBlankString(String value) {
    return value != null && value.trim() != "";
  }
}
