/* Licensed at AlphaOri Technologies */
package com.cpdss.gateway.domain;

import com.cpdss.common.rest.CommonSuccessResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.List;
import lombok.Data;

/**
 * On hand quantity response
 *
 * @author suhail.k
 */
@Data
@JsonInclude(Include.NON_EMPTY)
public class OnHandQuantityResponse {

  private CommonSuccessResponse responseStatus;

  private List<OnHandQuantity> onHandQuantities;

  private List<List<VesselTank>> rearTanks;

  private List<List<VesselTank>> tanks;

  private Long id;
}
