/* Licensed at AlphaOri Technologies */
package com.cpdss.gateway.domain.loadingplan.sequence;

import lombok.Data;

@Data
public class PumpCategory {

  private Long id;
  private String pumpName;
  private String pumpType;
  private Long pumpTypeId;
}
