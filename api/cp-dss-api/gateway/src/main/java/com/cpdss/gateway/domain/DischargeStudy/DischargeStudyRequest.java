/* Licensed at AlphaOri Technologies */
package com.cpdss.gateway.domain.DischargeStudy;

import lombok.Data;

/** @author arun.j */
@Data
public class DischargeStudyRequest {

  private String name;
  private String enquiryDetails;
  private Long vesselId;
  private Long voyageId;
  private Long dischargeId;
}
