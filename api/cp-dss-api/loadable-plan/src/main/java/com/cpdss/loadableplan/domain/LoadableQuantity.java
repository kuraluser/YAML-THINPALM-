/* Licensed at AlphaOri Technologies */
package com.cpdss.loadableplan.domain;

import lombok.Data;

/** @Author jerin.g */
@Data
public class LoadableQuantity {

  private String estSeaDensity;

  private String tpc;

  private String estSagging;

  private String displacmentDraftRestriction;

  private String vesselLightWeight;

  private String dwt;

  private String sgCorrection;

  private String saggingDeduction;

  private String estFOOnBoard;

  private String estDOOnBoard;

  private String estFreshWaterOnBoard;

  private String constant;

  private String otherIfAny;

  private String totalQuantity;

  private String distanceFromLastPort;

  private String vesselAverageSpeed;

  private String foConsumptionPerDay;

  private String updateDateAndTime;

  private Integer portId;

  private String sg;

  private String boilerWaterOnBoard;

  private String ballast;

  private String runningHours;

  private String runningDays;

  private String foConInSZ;

  private String draftRestriction;

  private String subTotal;
}
