/* Licensed at AlphaOri Technologies */
package com.cpdss.loadablestudy.domain;

import lombok.Data;

/** @Author jerin.g */
@Data
public class OnBoardQuantity {
  private Long id;
  private Long portId;
  private Long tankId;
  private Long cargoId;
  private String volume; // volumeInM3
  private String plannedArrivalWeight;
  private String api;
  private String colorCode;
}
