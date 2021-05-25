/* Licensed at AlphaOri Technologies */
package com.cpdss.gateway.service.loadingplan;

import com.cpdss.gateway.domain.loadingplan.LoadingInformationResponse;

public interface LoadingPlanService {

  Object getLoadingPortRotationDetails(Long vesselId, Long portRId);

  LoadingInformationResponse getLoadingInformationByPortRotation(
      Long vesselId, Long voyageId, Long planId, Long portRId);
}
