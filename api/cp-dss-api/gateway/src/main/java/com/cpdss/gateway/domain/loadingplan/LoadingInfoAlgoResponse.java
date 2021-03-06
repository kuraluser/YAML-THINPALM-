/* Licensed at AlphaOri Technologies */
package com.cpdss.gateway.domain.loadingplan;

import com.cpdss.common.rest.CommonSuccessResponse;
import lombok.Data;

@Data
public class LoadingInfoAlgoResponse {

  private CommonSuccessResponse responseStatus;
  private String processId;
}
