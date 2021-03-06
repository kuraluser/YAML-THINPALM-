/* Licensed at AlphaOri Technologies */
package com.cpdss.gateway.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.math.BigDecimal;
import java.util.List;
import lombok.Data;

/** @Author jerin.g */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BillOfLadding {
  private Long id;
  private Long portId;
  private Long cargoId;
  private Long cargoNominationId;
  private BigDecimal quantityBbls;
  private BigDecimal quantityMt;
  private BigDecimal quantityKl;
  private BigDecimal quantityLT;
  private BigDecimal api;
  private BigDecimal temperature;
  private String cargoColor;
  private String cargoName;
  private String cargoAbbrevation;
  private String blRefNo;
  private List<Long> loadingPort;

  @JsonIgnore private Long portRotationId;

  @JsonIgnore private List<Long> portRotationIds;
  private List<PortRotation> loadingPorts;
}
