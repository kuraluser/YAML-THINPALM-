/* Licensed at AlphaOri Technologies */
package com.cpdss.gateway.domain.loadingplan;

import lombok.Data;

@Data
public class VesselParticularsForExcel {

  private Long vesselId;
  private String shipMaxLoadingRate;
  private String shipMaxFlowRate;
  private String shipMaxFlowRatePerTank;
  private String maxLoadingRateSlopP;
  private String maxLoadingRateSlopS;
  private Long ballastPumpCount;
  private Long capacityPerPump;
  private Long shipManifold;
  private String summerDraft;
  private String tropicalDraft;
  private String freshMLD;
  private String summerDeadweight;
  private String summerDisplacement;
  private String cargoTankCapacity;
}
