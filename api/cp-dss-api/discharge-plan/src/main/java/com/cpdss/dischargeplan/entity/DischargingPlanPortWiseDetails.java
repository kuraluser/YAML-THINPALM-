/* Licensed at AlphaOri Technologies */
package com.cpdss.dischargeplan.entity;

import com.cpdss.common.utils.EntityDoc;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "discharging_plan_portwise_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DischargingPlanPortWiseDetails extends EntityDoc {

  private static final long serialVersionUID = 1L;

  @Column(name = "time")
  private Integer time;

  @Column(name = "is_active")
  private Boolean isActive;

  @ManyToOne
  @JoinColumn(name = "discharging_sequences_xid", referencedColumnName = "id")
  private DischargingSequence dischargingSequence;

  @OneToMany(mappedBy = "dischargingPlanPortWiseDetails")
  private Set<DischargingPlanStowageDetails> dischargingPlanStowageDetails;

  @OneToMany(mappedBy = "dischargingPlanPortWiseDetails")
  private Set<DischargingPlanBallastDetails> dischargingPlanBallastDetails;

  @OneToMany(mappedBy = "dischargingPlanPortWiseDetails")
  private Set<DischargingPlanRobDetails> dischargingPlanRobDetails;

  @OneToMany(mappedBy = "dischargingPlanPortWiseDetails")
  private Set<DischargingPlanStabilityParameters> dischargingPlanStabilityParameters;

  @OneToMany(mappedBy = "dischargingPlanPortWiseDetails")
  private Set<BallastingRate> ballastingRates;
}
