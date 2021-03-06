/* Licensed at AlphaOri Technologies */
package com.cpdss.loadingplan.entity;

import com.cpdss.common.utils.EntityDoc;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "deballasting_rate")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeballastingRate extends EntityDoc {

  private static final long serialVersionUID = 1L;

  @ManyToOne
  @JoinColumn(name = "loading_sequences_xid", referencedColumnName = "id", nullable = true)
  private LoadingSequence loadingSequence;

  @ManyToOne
  @JoinColumn(
      name = "loading_plan_portwise_details_xid",
      referencedColumnName = "id",
      nullable = true)
  private LoadingPlanPortWiseDetails loadingPlanPortWiseDetails;

  @Column(name = "time")
  private Integer time;

  @Column(name = "tank_xid")
  private Long tankXId;

  @Column(name = "deballasting_rate")
  private BigDecimal deBallastingRate;

  @Column(name = "is_active")
  private Boolean isActive;
}
