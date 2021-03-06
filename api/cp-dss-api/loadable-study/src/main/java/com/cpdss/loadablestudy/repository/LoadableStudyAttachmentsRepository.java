/* Licensed at AlphaOri Technologies */
package com.cpdss.loadablestudy.repository;

import com.cpdss.common.springdata.CommonCrudRepository;
import com.cpdss.loadablestudy.entity.LoadableStudyAttachments;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.data.jpa.repository.Query;

public interface LoadableStudyAttachmentsRepository
    extends CommonCrudRepository<LoadableStudyAttachments, Long> {

  @Query(
      "FROM LoadableStudyAttachments LSA WHERE LSA.id = ?1 AND LSA.loadableStudy.id = ?2 AND LSA.isActive = ?3")
  public LoadableStudyAttachments findByIdAndLoadableStudyXIdAndIsActive(
      Long id, Long loadableStudyId, Boolean isActive);

  @Query("FROM LoadableStudyAttachments LSA WHERE  LSA.loadableStudy.id = ?1 AND LSA.isActive = ?2")
  public List<LoadableStudyAttachments> findByLoadableStudyXIdAndIsActive(
      Long loadableStudyId, Boolean isActive);

  public Set<LoadableStudyAttachments> findByIdInAndIsActive(List<Long> idList, Boolean isActive);

  public Optional<LoadableStudyAttachments> findByIdAndIsActive(Long id, Boolean isActive);
}
