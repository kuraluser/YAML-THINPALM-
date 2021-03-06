/* Licensed at AlphaOri Technologies */
package com.cpdss.gateway.domain.loadingplan.sequence;

import com.cpdss.gateway.domain.AlgoError;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.List;
import java.util.Map;
import lombok.Data;

@Data
@JsonInclude(Include.NON_EMPTY)
public class LoadingPlanAlgoRequest {

  private String processId;
  private Map message;
  private List<Event> events;
  private Map<String, LoadingPlan> plans;

  // stability parameters per stage
  private List<LoadingSequenceStabilityParam> stages;
  private List<AlgoError> errors;
  private Object loadingInformation;
  private Boolean hasLoadicator;
}
