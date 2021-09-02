/* Licensed at AlphaOri Technologies */
package com.cpdss.gateway.domain.loadingplan.sequence;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.Date;
import java.util.List;
import java.util.Set;
import lombok.Data;

@Data
@JsonInclude(value = Include.NON_EMPTY)
public class LoadingSequenceResponse {

  private Date minXAxisValue;
  private Long maxXAxisValue;
  private Integer interval;
  private List<Cargo> cargos;
  private List<Ballast> ballasts;
  private BallastPump gravity;
  private List<BallastPump> ballastPumps;
  private List<CargoLoadingRate> cargoLoadingRates;
  private List<FlowRate> flowRates;
  private Set<TankCategory> cargoTankCategories;
  private Set<TankCategory> ballastTankCategories;
  private List<PumpCategory> ballastPumpCategories;
  private Set<Long> stageTickPositions;
  private List<StabilityParam> stabilityParams;
  private List<CargoStage> cargoStages;
}
