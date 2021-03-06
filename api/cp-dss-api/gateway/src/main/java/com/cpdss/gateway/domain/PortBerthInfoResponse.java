/* Licensed at AlphaOri Technologies */
package com.cpdss.gateway.domain;

import java.math.BigDecimal;
import java.util.List;
import lombok.Data;

@Data
public class PortBerthInfoResponse {

  private Long berthId;
  private Long portId;
  private String berthName;
  private BigDecimal maxShipDepth;
  private BigDecimal depthInDatum;
  private BigDecimal maxDwt;
  private BigDecimal maxLoa;
  private List<ManifoldDetail> manifoldDetails;
  private String minUKC;
  private String regulationAndRestriction;
  private BigDecimal maxDraft;
  private BigDecimal maxManifoldHeight;
}
