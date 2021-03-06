/* Licensed at AlphaOri Technologies */
package com.cpdss.loadingplan.domain.algo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.math.BigDecimal;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoadingMachinesInUse {
  private Long id;
  private Long loadingInfoId;
  private Long machineId;
  private String machineName;
  private BigDecimal capacity;
  private Integer machineTypeId;
  private String machineTypeName;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String tankTypeName;
}
