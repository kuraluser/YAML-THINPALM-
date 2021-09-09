/* Licensed at AlphaOri Technologies */
package com.cpdss.dischargeplan.domain;

import java.util.List;
import lombok.Data;

@Data
public class DischargeStages {

  private Long id;
  private Boolean trackStartEndStage;
  private Boolean trackGradeSwitch;
  private Integer stageOffset = 4; // Default Value
  private Integer stageDuration = 4; // Default Value, in Hours

  private List<StageOffset> stageOffsetList;
  private List<StageDuration> stageDurationList;
}