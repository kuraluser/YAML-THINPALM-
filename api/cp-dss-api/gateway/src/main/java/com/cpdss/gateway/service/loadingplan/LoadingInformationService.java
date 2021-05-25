/* Licensed at AlphaOri Technologies */
package com.cpdss.gateway.service.loadingplan;

import com.cpdss.gateway.domain.loadingplan.BerthDetails;
import com.cpdss.gateway.domain.loadingplan.CargoMachineryInUse;
import com.cpdss.gateway.domain.loadingplan.LoadingDetails;
import com.cpdss.gateway.domain.loadingplan.LoadingRates;
import java.util.List;

public interface LoadingInformationService {

  /**
   * Sunrise and Sunset Data must get and save at Synoptic Table in LS
   *
   * @param vesselId Long
   * @param voyageId Long
   * @param portRId Long
   * @return - LoadingDetails
   */
  LoadingDetails getLoadingDetailsByPortRotationId(Long vesselId, Long voyageId, Long portRId);

  LoadingRates getLoadingRateForVessel(Long vesselId);

  /**
   * Berth Data is based on Port, So The Port Id must be pass to Port-Info Service
   *
   * @param portId - Long
   * @return - BerthDetails
   */
  List<BerthDetails> getBerthDetailsByPortId(Long portId);

  CargoMachineryInUse getCargoMachinesInUserFromVessel(Long vesselId);
}
