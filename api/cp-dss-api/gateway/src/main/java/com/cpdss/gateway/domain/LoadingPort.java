/* Licensed under Apache-2.0 */
package com.cpdss.gateway.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.math.BigDecimal;
import lombok.Data;

/** Dto for loading ports in cargo nomination */
@Data
@JsonInclude(Include.NON_EMPTY)
public class LoadingPort {

  private Long id;

  private BigDecimal quantity;
}
