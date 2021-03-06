/* Licensed at AlphaOri Technologies */
package com.cpdss.loadablestudy.entity;

import com.cpdss.common.utils.EntityDoc;
import java.math.BigDecimal;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "loadable_plan_stowage_ballast_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoadablePlanStowageBallastDetails extends EntityDoc {

  @ManyToOne
  @JoinColumn(name = "loadable_plan_xid")
  private LoadablePlan loadablePlan;

  @Column(name = "tank_xid")
  private Long tankXId;

  @Column(name = "quantity")
  private BigDecimal quantity;

  @Column(name = "actual_quantity")
  private BigDecimal actualQuantity;

  @Column(name = "port_xid")
  private Long portXId;

  @Column(name = "operation_type")
  private String operationType;

  @Column(name = "loadable_pattern_xid")
  private Long loadablePatternId;

  @Column(name = "is_active")
  private Boolean isActive;

  @Column(name = "corrected_ullage")
  private String correctedUllage;

  @Column(name = "sg")
  private String sg;

  @Column(name = "color_code")
  private String colorCode;

  @Column(name = "port_rotation_xid")
  private Long portRotationId;

  @Column(name = "rdg_ullage")
  private String rdgUllage;

  @Column(name = "correction_factor")
  private String correctionFactor;

  @Column(name = "filling_percentage")
  private String fillingPercentage;

  // DS fields
  @Column(name = "volume")
  private BigDecimal volume;

  @Column(name = "max_tank_volume")
  private BigDecimal maxTankVolume;

  @Transient private Long communicationRelatedEntityId;
}
