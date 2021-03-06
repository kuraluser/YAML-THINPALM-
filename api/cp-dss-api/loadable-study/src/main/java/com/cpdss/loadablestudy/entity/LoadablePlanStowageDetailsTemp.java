/* Licensed at AlphaOri Technologies */
package com.cpdss.loadablestudy.entity;

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

/** @author jerin.g */
@Entity
@Table(name = "loadable_plan_stowage_details_temp")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoadablePlanStowageDetailsTemp extends EntityDoc {

  private static final long serialVersionUID = 1L;

  @Column(name = "correction_factor")
  private BigDecimal correctionFactor;

  @Column(name = "corrected_ullage")
  private BigDecimal correctedUllage;

  @Column(name = "quantity")
  private BigDecimal quantity;

  @Column(name = "rdg_ullage")
  private BigDecimal rdgUllage;

  @Column(name = "filling_ratio")
  private BigDecimal fillingRatio;

  @Column(name = "is_ballast")
  private Boolean isBallast;

  @Column(name = "is_commingle")
  private Boolean isCommingle;

  @Column(name = "is_active")
  private Boolean isActive;

  @JoinColumn(name = "stowage_details_xid", referencedColumnName = "id")
  @ManyToOne
  private LoadablePlanStowageDetails loadablePlanStowageDetails;

  @JoinColumn(name = "ballast_details_xid", referencedColumnName = "id")
  @ManyToOne
  private LoadablePlanBallastDetails loadablePlanBallastDetails;

  @Column(name = "ballast_details_xid", insertable = false, updatable = false)
  private Long loadablePlanBallastDetailsId;

  @JoinColumn(name = "loadable_pattern_xid", referencedColumnName = "id")
  @ManyToOne
  private LoadablePattern loadablePattern;

  @Column(name = "loadable_pattern_xid", insertable = false, updatable = false)
  private Long loadablePatternId;

  @JoinColumn(name = "loadable_plan_commingle_details_xid", referencedColumnName = "id")
  @ManyToOne
  private LoadablePlanCommingleDetails loadablePlanCommingleDetails;
}
