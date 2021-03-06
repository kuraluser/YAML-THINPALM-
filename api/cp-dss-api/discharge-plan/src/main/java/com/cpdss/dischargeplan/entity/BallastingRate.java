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
@Table(name = "ballasting_rate")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BallastingRate extends EntityDoc {

  private static final long serialVersionUID = 1L;

  @ManyToOne
  @JoinColumn(name = "discharging_sequences_xid", referencedColumnName = "id", nullable = true)
  private DischargingSequence dischargingSequence;

  @ManyToOne
  @JoinColumn(
      name = "discharging_plan_portwise_details_xid",
      referencedColumnName = "id",
      nullable = true)
  private DischargingPlanPortWiseDetails dischargingPlanPortWiseDetails;

  @Column(name = "time")
  private Integer time;

  @Column(name = "tank_xid")
  private Long tankXId;

  @Column(name = "deballasting_rate")
  private BigDecimal deBallastingRate;

  @Column(name = "is_active")
  private Boolean isActive;
}
