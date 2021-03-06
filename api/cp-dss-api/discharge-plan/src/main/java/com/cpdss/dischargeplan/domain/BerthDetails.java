/* Licensed at AlphaOri Technologies */
package com.cpdss.dischargeplan.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.math.BigDecimal;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BerthDetails {

  private Long berthId; // Primary key for Berth Info Master table
  private Long portId;
  private Long dischargeInfoId;
  private BigDecimal maxShpChannel;
  private String berthName;
  private Long dischargeBerthId; // Primary key for loading berth, in Loading Plan DB
  private BigDecimal maxShipDepth;
  private String hoseConnections;
  private BigDecimal seaDraftLimitation;
  private BigDecimal airDraftLimitation;
  private BigDecimal maxManifoldHeight;
  private String regulationAndRestriction;
  private BigDecimal maxLoa;
  private BigDecimal maxDraft;
  private String itemsToBeAgreedWith;
  private BigDecimal lineDisplacement;

  private BigDecimal maxManifoldPressure;
  private Boolean airPurge;
  private Boolean cargoCirculation;
  private String ukc;
  private String controllingDepth;
  private String portMaxPermissibleDraft;
  private BigDecimal displacement;
  private Boolean needFlushingOilAndCrudeStorage;
  private Boolean enableDayLightRestriction;
  private BigDecimal freshCrudeOilQuantity;
  private BigDecimal freshCrudeOilTime;
}
