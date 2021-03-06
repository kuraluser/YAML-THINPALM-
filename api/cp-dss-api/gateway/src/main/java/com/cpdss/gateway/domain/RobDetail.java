/* Licensed at AlphaOri Technologies */
package com.cpdss.gateway.domain;

import java.math.BigDecimal;
import lombok.Data;

/** @author ravi.r */
@Data
public class RobDetail {

  private Long id;

  private BigDecimal loadingInformationId;

  private BigDecimal dischargingInformationId;

  private BigDecimal tankId;

  private BigDecimal temperature;

  private BigDecimal correctedUllage;

  private BigDecimal correctionFactor;

  private BigDecimal quantity;

  private BigDecimal observedM3;

  private BigDecimal fillingRatio;

  private String colour_code;

  private BigDecimal density;

  private BigDecimal arrival_departutre;

  private BigDecimal actual_planned;

  private Boolean isUpdate;

  private Long portXId;

  private Long portRotationXId;
}
