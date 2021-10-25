/* Licensed at AlphaOri Technologies */
package com.cpdss.gateway.domain;

import com.cpdss.common.rest.CommonSuccessResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.List;
import lombok.Data;

/** @Author jerin.g */
@Data
@JsonInclude(Include.NON_EMPTY)
public class VoyageResponse {

  private CommonSuccessResponse responseStatus;

  private Long voyageId;

  private List<Voyage> voyages;
  private String message;
  private Long totalElements;
}