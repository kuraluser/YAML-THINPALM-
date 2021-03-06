/* Licensed at AlphaOri Technologies */
package com.cpdss.loadingplan.entity;

import com.cpdss.common.utils.EntityDoc;
import java.math.BigDecimal;
import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "loading_plan_stability_parameters")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoadingPlanStabilityParameters extends EntityDoc {

  private static final long serialVersionUID = 1L;

  @ManyToOne
  @JoinColumn(
      name = "loading_plan_portwise_details_xid",
      referencedColumnName = "id",
      nullable = true)
  private LoadingPlanPortWiseDetails loadingPlanPortWiseDetails;

  @Column(name = "trim")
  private BigDecimal trim;

  @Column(name = "draft")
  private BigDecimal draft;

  @Column(name = "fore_draft")
  private BigDecimal foreDraft;

  @Column(name = "aft_draft")
  private BigDecimal aftDraft;

  @Column(name = "mean_draft")
  private BigDecimal meanDraft;

  @Column(name = "list")
  private BigDecimal list;

  @Column(name = "bm")
  private BigDecimal bm;

  @Column(name = "sf")
  private BigDecimal sf;

  @Column(name = "is_active")
  private Boolean isActive;

  @Transient private String communicationRelatedEntityId;
}
