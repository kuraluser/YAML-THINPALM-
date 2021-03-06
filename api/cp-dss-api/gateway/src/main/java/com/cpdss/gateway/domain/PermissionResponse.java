/* Licensed at AlphaOri Technologies */
package com.cpdss.gateway.domain;

import com.cpdss.common.rest.CommonSuccessResponse;
import lombok.Data;

@Data
public class PermissionResponse {

  private CommonSuccessResponse responseStatus;
  private Long roleId;
  private String message;
}
