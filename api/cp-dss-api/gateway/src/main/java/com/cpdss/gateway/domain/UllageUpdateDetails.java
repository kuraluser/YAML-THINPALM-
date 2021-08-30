/* Licensed at AlphaOri Technologies */
package com.cpdss.gateway.domain;

import java.math.BigDecimal;
import lombok.Data;

/** @author ravi.r */
@Data
public class UllageUpdateDetails {

  private Long id;

  private BigDecimal loadingInformationId;

  private BigDecimal tankId;

  private BigDecimal temperature;

  private BigDecimal correctedUllage;

  private BigDecimal correctionFactor;

  private BigDecimal quantity;

  private BigDecimal observedM3;

  private BigDecimal fillingRatio;

  private BigDecimal api;

  private BigDecimal ullage;

  private Boolean isUpdate;
}