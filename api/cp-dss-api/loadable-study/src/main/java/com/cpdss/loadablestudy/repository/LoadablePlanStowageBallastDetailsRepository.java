/* Licensed at AlphaOri Technologies */
package com.cpdss.loadablestudy.repository;

import com.cpdss.common.springdata.CommonCrudRepository;
import com.cpdss.loadablestudy.entity.LoadablePlanStowageBallastDetails;
import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/** @author suhail.k */
public interface LoadablePlanStowageBallastDetailsRepository
    extends CommonCrudRepository<LoadablePlanStowageBallastDetails, Long> {

  @Query(
      "select b from LoadablePlanStowageBallastDetails b where b.loadablePlan.id="
          + "(select p.id from LoadablePlan p "
          + "where p.loadableStudyXId=?1 and p.loadablePlanStatus=?2 and p.isActive=true)")
  public List<LoadablePlanStowageBallastDetails> findBallastDetailsForLoadableStudy(
      Long loadableStudyId, Long loadablePatternId);

  public List<LoadablePlanStowageBallastDetails> findByLoadablePatternIdAndIsActive(
      Long loadablePatternId, boolean isActive);

  public List<LoadablePlanStowageBallastDetails> findByLoadablePatternIdInAndIsActive(
      List<Long> loadablePatternId, boolean isActive);

  public List<LoadablePlanStowageBallastDetails>
      findByLoadablePatternIdAndPortRotationIdAndOperationTypeAndIsActive(
          Long loadablePatternId, Long portId, String operationType, boolean isActive);

  @Query(
      "select b from LoadablePlanStowageBallastDetails b where b.loadablePatternId in (:loadablePatternIds)"
          + " and b.portXId in (:portIds) and  b.isActive=true")
  public List<LoadablePlanStowageBallastDetails> findByLoadablePatternIdInAndPortXIdInAndIsActive(
      @Param("loadablePatternIds") List<Long> loadablePatternIds,
      @Param("portIds") Set<Long> portIds);

  @Transactional
  @Modifying
  @Query("UPDATE LoadablePlanStowageBallastDetails SET isActive = ?1 WHERE loadablePatternId = ?2")
  public void deleteLoadablePlanStowageBallastDetails(Boolean isActive, Long loadablePatternId);

  public List<LoadablePlanStowageBallastDetails>
      findByLoadablePatternIdAndPortRotationIdAndIsActive(
          Long loadablePatternId, Long portId, boolean isActive);

  @Query(
      "FROM LoadablePlanStowageBallastDetails lp WHERE lp.loadablePatternId = ?1 AND lp.portXId = ?2 and lp.isActive = true")
  List<LoadablePlanStowageBallastDetails> findAllByLoadablePatternIdAndPortXId(
      Long patternId, Long portXId);

  @Query(
      value =
          "SELECT  CAST(json_agg(u) as VARCHAR) json_out FROM loadable_plan_stowage_ballast_details u where loadable_pattern_xid=?1",
      nativeQuery = true)
  String getLoadablePlanStowageBallastDetailsDataWithPatternId(Long id);
}
