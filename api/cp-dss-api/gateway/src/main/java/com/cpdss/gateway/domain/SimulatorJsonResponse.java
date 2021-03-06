/* Licensed at AlphaOri Technologies */
package com.cpdss.gateway.domain;

import com.cpdss.common.jsonbuilder.CPDSSJsonParser;
import com.cpdss.common.rest.CommonSuccessResponse;
import lombok.Data;

@Data
@CPDSSJsonParser
public class SimulatorJsonResponse {
  private CommonSuccessResponse responseStatus;
  private Object departureCondition;
}
