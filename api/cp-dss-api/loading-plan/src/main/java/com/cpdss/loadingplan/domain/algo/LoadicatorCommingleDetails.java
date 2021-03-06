/* Licensed at AlphaOri Technologies */
package com.cpdss.loadingplan.domain.algo;

import java.math.BigDecimal;
import lombok.Data;

/** @author pranav.k */
@Data
public class LoadicatorCommingleDetails {

  private Long id;
  private Long tankId;
  private BigDecimal quantityMT;
  private BigDecimal quantityM3;
  private BigDecimal api;
  private BigDecimal temperature;
  private BigDecimal ullage;
  private Long cargoNomination1Id;
  private Long cargoNomination2Id;
  private Long cargo1Id;
  private Long cargo2Id;
  private String colorCode;
  private String abbreviation;
  private Integer conditionType;
  private Integer valueType;
  private BigDecimal quantity1MT;
  private BigDecimal quantity2MT;
  private BigDecimal quantity1M3;
  private BigDecimal quantity2M3;
  private BigDecimal ullage1;
  private BigDecimal ullage2;
}
