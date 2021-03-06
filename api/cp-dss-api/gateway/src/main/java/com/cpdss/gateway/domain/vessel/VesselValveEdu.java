/* Licensed at AlphaOri Technologies */
package com.cpdss.gateway.domain.vessel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VesselValveEdu {

  private Integer sequenceNumber;
  private String valve;
  private Integer valveId;
  private String stageName;
  private String valveTypeName;
  private String tankShortName;
  private String manifoldName;
  private String manifoldSide;
}
