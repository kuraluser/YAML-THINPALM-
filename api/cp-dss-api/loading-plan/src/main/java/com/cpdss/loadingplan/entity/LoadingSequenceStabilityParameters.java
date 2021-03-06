/* Licensed at AlphaOri Technologies */
package com.cpdss.loadingplan.entity;

import com.cpdss.common.utils.EntityDoc;
import java.math.BigDecimal;
import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "loading_sequence_stability_parameters")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoadingSequenceStabilityParameters extends EntityDoc {

  private static final long serialVersionUID = 1L;

  @ManyToOne
  @JoinColumn(name = "loading_information_xid", referencedColumnName = "id")
  private LoadingInformation loadingInformation;

  @Column(name = "port_xid")
  private Long portXId;

  @Column(name = "time")
  private Integer time;

  @Column(name = "draft")
  private BigDecimal draft;

  @Column(name = "fore_draft")
  private BigDecimal foreDraft;

  @Column(name = "aft_draft")
  private BigDecimal aftDraft;

  @Column(name = "mean_draft")
  private BigDecimal meanDraft;

  @Column(name = "trim")
  private BigDecimal trim;

  @Column(name = "list")
  private BigDecimal list;

  @Column(name = "bending_moment")
  private BigDecimal bendingMoment;

  @Column(name = "shearing_force")
  private BigDecimal shearingForce;

  @Column(name = "is_active")
  private Boolean isActive;

  @Column(name = "gom_value")
  private BigDecimal gomValue;

  @Transient private Long communicationRelatedEntityId;

  @Column(name = "sf_frame_number")
  private BigDecimal sfFrameNumber;

  @Column(name = "bm_frame_number")
  private BigDecimal bmFrameNumber;
}
