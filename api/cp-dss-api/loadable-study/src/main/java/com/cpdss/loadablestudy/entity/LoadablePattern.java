/* Licensed at AlphaOri Technologies */
package com.cpdss.loadablestudy.entity;

import com.cpdss.common.utils.EntityDoc;
import java.util.Collection;
import javax.persistence.*;
import javax.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** @author jerin.g */
@Entity
@Table(name = "loadable_pattern")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoadablePattern extends EntityDoc {

  private static final long serialVersionUID = 1L;

  @Column(name = "case_number")
  private Integer caseNumber;

  @Column(name = "constraints")
  private String constraints;

  @Column(name = "difference_color")
  private String differenceColor;

  @Column(name = "loadable_study_status")
  private Long loadableStudyStatus;

  @Column(name = "is_active")
  private Boolean isActive;

  @Column(name = "feed_back_loop")
  private Boolean feedbackLoop;

  @Column(name = "feed_back_loop_count")
  private Integer feedbackLoopCount;

  @OneToMany(mappedBy = "loadablePatternXId")
  private Collection<LoadablePlan> loadablePlanCollection;

  @JoinColumn(name = "loadablestudy_xid", referencedColumnName = "id")
  @ManyToOne
  private LoadableStudy loadableStudy;

  @Transient private Long communicationRelatedEntityId;
}
