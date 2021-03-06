/* Licensed at AlphaOri Technologies */
package com.cpdss.common.exception;

import com.cpdss.common.utils.Utils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

/**
 * Common Rest Exception
 *
 * @author krishna
 */
public class CommonRestException extends Exception {
  private final String code;
  private final String correlationId;
  private final HttpStatus status;

  public CommonRestException(
      String code,
      HttpHeaders headers,
      com.cpdss.common.utils.HttpStatusCode status,
      String errorMessage,
      Throwable throwable) {
    super(errorMessage, throwable);
    this.code = code;
    this.correlationId = null != headers ? headers.getFirst(Utils.CORRELATION_ID) : null;
    this.status = HttpStatus.valueOf(status.value());
  }

  public String getCode() {
    return code;
  }

  public String getCorrelationId() {
    return correlationId;
  }

  public HttpStatus getStatus() {
    return status;
  }
}
