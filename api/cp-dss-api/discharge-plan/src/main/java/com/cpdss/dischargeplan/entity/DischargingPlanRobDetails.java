/* Licensed at AlphaOri Technologies */
package com.cpdss.dischargeplan.entity;

import com.cpdss.common.utils.EntityDoc;
import java.math.BigDecimal;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "discharging_plan_rob_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DischargingPlanRobDetails extends EntityDoc {

  private static final long serialVersionUID = 1L;

  @ManyToOne
  @JoinColumn(
      name = "discharging_plan_portwise_details_xid",
      referencedColumnName = "id",
      nullable = true)
  private DischargingPlanPortWiseDetails dischargingPlanPortWiseDetails;

  @Column(name = "discharging_plan_portwise_details_xid", insertable = false, updatable = false)
  private Long dischargingPlanPortWiseDetailsId;

  @Column(name = "tank_xid")
  private Long tankXId;

  @Column(name = "quantity")
  private BigDecimal quantity;

  @Column(name = "quantity_m3")
  private BigDecimal quantityM3;

  @Column(name = "is_active")
  private Boolean isActive;

  @Column(name = "color_code")
  private String colorCode;

  @Transient private Long communicationRelatedEntityId;
}
