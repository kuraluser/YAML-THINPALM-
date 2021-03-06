/* Licensed at AlphaOri Technologies */
package com.cpdss.gateway.domain;

import com.cpdss.common.rest.CommonSuccessResponse;
import lombok.Data;

/** @Author jerin.g */
@Data
public class LoadableStudyStatusResponse {
  private Long loadableStudyStatusId;
  private String loadableStudyStatusLastModifiedTime;
  private CommonSuccessResponse responseStatus;
}
