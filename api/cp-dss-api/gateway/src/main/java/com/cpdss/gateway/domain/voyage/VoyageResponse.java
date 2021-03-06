/* Licensed at AlphaOri Technologies */
package com.cpdss.gateway.domain.voyage;

import com.cpdss.gateway.domain.LoadableStudy;
import com.cpdss.gateway.domain.PortRotation;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class VoyageResponse {

  private Long id;
  private String voyageNumber;
  private String startDate;
  private String endDate;
  private String status;
  private String charterer;
  private String actualStartDate;
  private String actualEndDate;
  private Long statusId;

  List<PortRotation> portRotations = new ArrayList<>();
  LoadableStudy activeLs;

  private Long patternId;
  private Long patternCaseNo;
  private Long patternStatus;

  // For Discharge Study
  List<PortRotation> dischargePortRotations = new ArrayList<>();
  LoadableStudy activeDs;

  private Long dischargePatternId;
  private Long dischargePatternCaseNo;
  private Long dischargePatternStatus;
  private Long chiefOfficerId;
  private Long captainId;
}
