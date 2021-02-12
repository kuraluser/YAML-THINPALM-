/* Licensed under Apache-2.0 */
package com.cpdss.gateway.domain;

import com.cpdss.common.rest.CommonSuccessResponse;
import java.util.List;
import lombok.Data;

/** @Author jerin.g */
@Data
public class RecalculateVolume {
  private List<LoadablePlanStowageDetails> cargoDetails;
  private CommonSuccessResponse responseStatus;
}
