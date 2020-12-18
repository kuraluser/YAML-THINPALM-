/* Licensed under Apache-2.0 */
package com.cpdss.loadablestudy.entity;

import com.cpdss.common.utils.EntityDoc;
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
@Table(name = "loadable_study_algo_status")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoadableStudyAlgoStatus extends EntityDoc {

  private static final long serialVersionUID = 1L;

  @Column(name = "vesselxid")
  private Long vesselxid;

  @Column(name = "is_active")
  private Boolean isActive;

  @Column(name = "process_id")
  private String processId;

  @JoinColumn(name = "loadabale_studyxid", referencedColumnName = "id")
  @ManyToOne
  private LoadableStudy loadableStudy;

  @JoinColumn(name = "loadable_study_status", referencedColumnName = "id")
  @ManyToOne
  private LoadableStudyStatus loadableStudyStatus;
}
