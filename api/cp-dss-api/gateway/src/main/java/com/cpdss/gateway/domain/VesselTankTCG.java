/* Licensed at AlphaOri Technologies */
package com.cpdss.gateway.domain;

import lombok.Data;

/** @Author jerin.g */
@Data
public class VesselTankTCG {
  private Long id;
  private Long tankId;
  private String capacity;
  private String tcg;
  private String lcg;
  private String vcg;
  private String inertia;
}
