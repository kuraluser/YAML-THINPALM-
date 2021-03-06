/* Licensed at AlphaOri Technologies */
package com.cpdss.loadingplan.service;

import com.cpdss.common.exception.GenericServiceException;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels.CargoToppingOffSequence;
import com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingToppingOff;
import com.cpdss.loadingplan.entity.LoadingInformation;
import java.util.List;

public interface CargoToppingOffSequenceService {

  public void saveCargoToppingOffSequenceList(
      List<CargoToppingOffSequence> cargoToppingOffSequencesList,
      LoadingInformation loadingInformation);

  public void saveCargoToppingOffSequences(List<LoadingToppingOff> toppingOffSequenceList)
      throws Exception;

  void updateUllageFromLsAlgo(
      LoadingPlanModels.UpdateUllageLoadingRequest request,
      LoadingPlanModels.UpdateUllageLoadingReplay.Builder replayBuilder)
      throws GenericServiceException;
}
