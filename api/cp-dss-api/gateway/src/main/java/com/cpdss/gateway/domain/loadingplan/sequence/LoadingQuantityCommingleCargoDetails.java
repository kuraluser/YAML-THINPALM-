/* Licensed at AlphaOri Technologies */
package com.cpdss.gateway.domain.loadingplan.sequence;

import lombok.Data;

/** @author pranav.k */
@Data
public class LoadingQuantityCommingleCargoDetails {
  private String tankShortName;
  private String tankName;
  private Long tankId;
  private String quantityMT;
  private String quantityM3;
  private String api;
  private String temperature;
  private String ullage;
  private Long cargoNomination1Id;
  private Long cargoNomination2Id;
  private Long cargo1Id;
  private Long cargo2Id;
  private String colorCode;
  private String abbreviation;
  private String quantity1MT;
  private String quantity2MT;
  private String quantity1M3;
  private String quantity2M3;
  private String ullage1;
  private String ullage2;
}
