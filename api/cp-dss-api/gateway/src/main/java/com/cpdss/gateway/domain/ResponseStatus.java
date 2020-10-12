/* Licensed under Apache-2.0 */
package com.cpdss.gateway.domain;

import lombok.Data;

/** @Author jerin.g */
@Data
public class ResponseStatus {
  private String status;
  private String message;
  private String erroCode;
  private String correlationId;
}
