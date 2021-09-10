/* Licensed at AlphaOri Technologies */
package com.cpdss.gateway.domain.dischargeplan;

import com.cpdss.common.rest.CommonSuccessResponse;
import com.cpdss.gateway.domain.VesselTank;
import com.cpdss.gateway.domain.loadingplan.LoadingPlanStabilityParam;
import com.cpdss.gateway.domain.loadingplan.sequence.LoadingPlanBallastDetails;
import com.cpdss.gateway.domain.loadingplan.sequence.LoadingPlanRobDetails;
import com.cpdss.gateway.domain.loadingplan.sequence.LoadingPlanStowageDetails;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DischargingPlanResponse {

  private CommonSuccessResponse responseStatus;

  private List<LoadingPlanStowageDetails> planStowageDetails;
  private List<LoadingPlanBallastDetails> planBallastDetails;
  private List<LoadingPlanRobDetails> planRobDetails;
  private List<LoadingPlanStabilityParam> planStabilityParams;

  private List<List<VesselTank>> cargoTanks;
  private DischargeInformation dischargingInformation;

  public DischargingPlanResponse(CommonSuccessResponse responseStatus) {
    this.responseStatus = responseStatus;
  }
}
