/* Licensed at AlphaOri Technologies */
package com.cpdss.gateway.domain;

import com.cpdss.common.rest.CommonSuccessResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.List;
import lombok.Data;

/**
 * Vessel response class
 *
 * @author suhail.k
 */
@Data
@JsonInclude(Include.NON_EMPTY)
public class VesselTankResponse {

  private CommonSuccessResponse responseStatus;

  private List<VesselTank> cargoVesselTanks;
}
