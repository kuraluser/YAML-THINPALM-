/* Licensed at AlphaOri Technologies */
package com.cpdss.common.rest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Common Error response for the rest api
 *
 * @author krishna
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_EMPTY)
public class CommonSuccessResponse implements CorrelationId {

  @NotBlank private String status;

  @NotBlank private String correlationId;
}
