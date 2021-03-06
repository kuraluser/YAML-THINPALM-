/* Licensed at AlphaOri Technologies */
package com.cpdss.loadablestudy.repository;

import com.cpdss.common.springdata.CommonCrudRepository;
import com.cpdss.loadablestudy.entity.LoadablePattern;
import com.cpdss.loadablestudy.entity.LoadableStudy;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/** @Author jerin.g */
public interface LoadablePatternRepository extends CommonCrudRepository<LoadablePattern, Long> {
  public List<LoadablePattern> findByLoadableStudyAndIsActiveOrderByCaseNumberAsc(
      LoadableStudy loadableStudy, Boolean isActive);

  @Query(
      "SELECT LP FROM LoadablePattern LP INNER JOIN LoadableStudy LS ON LS.id = LP.loadableStudy.id INNER JOIN Voyage V ON LS.voyage.id = V.id AND V.id = ?1 AND LP.loadableStudyStatus = ?2 AND LP.isActive = ?3 AND LS.isActive = ?3 AND V.isActive = ?3")
  public List<LoadablePattern> findByVoyageAndLoadableStudyStatusAndIsActive(
      Long voyageId, Long loadableStudyStatus, Boolean isActive);

  @Query(
      "SELECT LP FROM LoadablePattern LP INNER JOIN LoadableStudy LS ON LS.id = LP.loadableStudy.id INNER JOIN Voyage V ON LS.voyage.id = V.id AND V.id = ?1 AND LP.loadableStudyStatus = ?2 AND LS.planningTypeXId = ?3 AND LP.isActive = ?4 AND LS.isActive = ?4 AND V.isActive = ?4")
  public List<LoadablePattern> findByVoyageAndLoadableStudyStatusAndPlanningTypeXIdAndIsActive(
      Long voyageId, Long loadableStudyStatus, Integer planningType, Boolean isActive);

  @Query(
      "SELECT LP FROM LoadablePattern LP INNER JOIN LoadableStudy LS ON LS.id = LP.loadableStudy.id INNER JOIN Voyage V ON LS.voyage.id = V.id AND V.id = ?1 AND LP.loadableStudyStatus = ?2 AND LP.isActive = ?3 AND LS.isActive = ?3 AND V.isActive = ?3 AND LS.planningTypeXId=?4")
  public List<LoadablePattern> findByVoyageAndLoadableStudyStatusAndIsActiveAndPlanningType(
      Long voyageId, Long loadableStudyStatus, Boolean isActive, Integer planningType);

  public Optional<LoadablePattern> findByLoadableStudyAndLoadableStudyStatusAndIsActive(
      LoadableStudy loadableStudy, Long loadableStudyStatus, Boolean isActive);

  public Optional<LoadablePattern> findByIdAndIsActive(Long id, Boolean isActive);

  @Transactional
  @Modifying
  @Query("UPDATE LoadablePattern SET loadableStudyStatus = ?1 WHERE id = ?2")
  public void updateLoadablePatternStatusToPlanGenerated(
      Long loadableStudyStatusId, Long loadablePatternId);

  @Transactional
  @Modifying
  @Query("UPDATE LoadableStudy SET loadableStudyStatus.id = ?1 WHERE id = ?2")
  public void updateLoadableStudyStatusToPlanGenerated(
      Long loadableStudyStatusId, Long loadableStudyId);

  @Transactional
  @Modifying
  @Query("UPDATE LoadablePattern SET loadableStudyStatus = ?1 WHERE id = ?2")
  public void updateLoadablePatternStatus(Long loadableStudyStatusId, Long id);

  @Transactional
  @Modifying
  @Query("UPDATE LoadableStudy SET loadableStudyStatus.id = ?1 WHERE id = ?2")
  public void updateLoadableStudyStatus(Long loadableStudyStatusId, Long id);

  public List<LoadablePattern> findByLoadableStudyAndIsActive(
      LoadableStudy loadableStudy, boolean isActive);

  @Query(
      "FROM LoadablePattern where loadableStudy.loadableStudyStatus.id = ?1 and loadableStudy=?2  and isActive = ?3")
  public List<LoadablePattern> findLoadablePatterns(
      Long loadableStudyStatusId, LoadableStudy loadableStudy, boolean isActive);

  @Transactional
  @Modifying
  @Query("UPDATE LoadablePattern SET isActive = false WHERE id = ?1")
  public void deleteLoadablePattern(Long id);

  @Transactional
  @Modifying
  @Query("UPDATE LoadablePattern SET feedbackLoop = ?1, feedbackLoopCount = ?2 WHERE id = ?3")
  public void updateLoadablePatternFeedbackLoopAndFeedbackLoopCount(
      Boolean feedbackLoop, Integer feedbackLoopCount, Long id);

  Optional<LoadablePattern> findOneByLoadableStudyAndCaseNumberAndIsActiveTrue(
      LoadableStudy ls, Integer cn);

  @Query(
      "from LoadablePattern lp where lp.loadableStudy.id = ?1 and lp.loadableStudyStatus = ?2 and lp.isActive = true")
  List<LoadablePattern> findConfirmedPatternByLoadableStudyId(Long lsId, Long status);

  @Query(
      value = "SELECT  CAST(json_agg(u) as VARCHAR) json_out FROM loadable_pattern u where id=?1",
      nativeQuery = true)
  String getLoadablePatternWithId(long id);

  @Query("SELECT LP.id FROM LoadablePattern LP WHERE LP.loadableStudy.id = ?1")
  List<Long> getLoadablePatternIds(Long loadableStudyId);

  @Query(
      value = "SELECT LP.loadablestudy_xid FROM loadable_pattern LP WHERE LP.id = ?1",
      nativeQuery = true)
  Long getLoadableStudyId(Long loadablePatternId);

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  @Modifying
  @Query("UPDATE LoadablePattern SET loadableStudyStatus = ?1 WHERE id = ?2")
  public void updateLoadablePatternStatusToPlanGeneratedStatus(
      Long loadableStudyStatusId, Long loadablePatternId);

  List<LoadablePattern> findByIdIn(List<Long> ids);
}
