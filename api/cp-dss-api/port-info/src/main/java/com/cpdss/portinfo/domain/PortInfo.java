/* Licensed at AlphaOri Technologies */
package com.cpdss.portinfo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/** Dto for port information from port master */
@Data
@AllArgsConstructor
public class PortInfo {

  private Long id;
  private String name;
}
