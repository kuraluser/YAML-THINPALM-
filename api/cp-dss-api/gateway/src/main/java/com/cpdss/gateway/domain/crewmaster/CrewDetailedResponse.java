/* Licensed at AlphaOri Technologies */
package com.cpdss.gateway.domain.crewmaster;

import com.cpdss.common.rest.CommonSuccessResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CrewDetailedResponse {
  private CommonSuccessResponse responseStatus;
  private CrewDetailed crewDetailed;
}
