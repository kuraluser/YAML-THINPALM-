/* Licensed at AlphaOri Technologies */
package com.cpdss.loadingplan.entity;

import com.cpdss.common.utils.EntityDoc;
import java.math.BigDecimal;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "loadable_pattern_cargo_details_loading")
public class LoadingPlanCargoDetails extends EntityDoc {

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "loading_xid", referencedColumnName = "id")
  private LoadingInformation loadingInformation;

  @Column(name = "loadable_pattern_xid")
  private Long loadablePatternId;

  @Column(name = "port_xid")
  private Long portId;

  @Column(name = "tank_xid")
  private Long tankId;

  @Column(name = "planned_quantity")
  private BigDecimal plannedQuantity;

  @Column(name = "actual_quantity")
  private BigDecimal actualQuantity;

  @Column(name = "is_active")
  private Boolean isActive;

  @Column(name = "operation_type")
  private String operationType;

  @Column(name = "abbreviation")
  private String abbreviation;

  @Column(name = "corrected_ullage")
  private BigDecimal correctedUllage;

  @Column(name = "color_code")
  private String colorCode;

  @Column(name = "cargo_xid")
  private Long cargoId;

  @Column(name = "api")
  private BigDecimal api;

  @Column(name = "temperature")
  private BigDecimal temperature;

  @Column(name = "port_rotation_xid")
  private Long portRotationId;

  @Column(name = "correction_factor")
  private String correctionFactor;

  @Column(name = "cargo_nomination_xid")
  private Long cargoNominationId;

  @Column(name = "filling_ratio")
  private String fillingRatio;
}
