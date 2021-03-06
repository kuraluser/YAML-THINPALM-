/* Licensed at AlphaOri Technologies */
package com.cpdss.dischargeplan.entity;

import com.cpdss.common.utils.EntityDoc;
import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** The persistent class for the cow_tank_details database table. */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "cow_tank_details")
public class CowTankDetail extends EntityDoc {

  @Column(name = "cow_type_xid")
  private Integer cowTypeXid;

  @Column(name = "discharging_xid")
  private Long dischargingXid;

  @Column(name = "is_active")
  private Boolean isActive;

  @Column(name = "tank_xid")
  private Long tankXid;

  @Column(name = "actual_planned")
  private Integer actualPlanned;

  @Column(name = "time_start")
  private Long timeStart;

  @Column(name = "time_end")
  private Long timeEnd;

  @Column(name = "tank_short_name")
  private String tankShortName;

  // bi-directional many-to-one association to CowPlanDetail
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "cow_plan_details_xid")
  private CowPlanDetail cowPlanDetail;

  @Transient private Long communicationRelatedEntityId;
}
