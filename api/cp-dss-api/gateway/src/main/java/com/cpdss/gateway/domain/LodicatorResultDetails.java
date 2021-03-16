/* Licensed at AlphaOri Technologies */
package com.cpdss.gateway.domain;

import lombok.Data;

/** @Author jerin.g */
@Data
public class LodicatorResultDetails {
  private Long operationId;
  private Long portId;
  private String hog;
  private String calculatedDraftFwdPlanned;
  private String calculatedDraftMidPlanned;
  private String calculatedDraftAftPlanned;
  private String calculatedTrimPlanned;
  private String blindSector;
  private String list;
}
