/* Licensed at AlphaOri Technologies */
package com.cpdss.gateway.domain;

import lombok.Data;

@Data
public class UpdateUllageCargoQuantityDetail {
  private Long cargoId;
  private String cargoColor;
  private String cargoName;
  private String cargoAbbrevation;
  private Double nominationTotal;
  private Double maxTolerance;
  private Double minTolerance;
  private Double maxQuantity;
  private Double minQuantity;
  private Double plannedQuantityTotal;
  private Double actualQuantityTotal;
  private Double blQuantityTotal;
  private Double difference;
  private String nominationApi;
  private String nominationTemp;
  private String actualAvgApi;
  private String actualAvgTemp;
  private String blAvgApi;
  private String blAvgTemp;
}
