/* Licensed at AlphaOri Technologies */
package com.cpdss.loadablestudy.repository;

import com.cpdss.common.springdata.CommonCrudRepository;
import com.cpdss.loadablestudy.entity.LoadablePattern;
import com.cpdss.loadablestudy.entity.LoadablePlanBallastDetails;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/** @Author jerin.g */
public interface LoadablePlanBallastDetailsRepository
    extends CommonCrudRepository<LoadablePlanBallastDetails, Long> {
  public List<LoadablePlanBallastDetails> findByLoadablePatternAndIsActive(
      LoadablePattern loadablePattern, Boolean isActive);

  public List<LoadablePlanBallastDetails> findByLoadablePattern_IdInAndIsActive(
      List<Long> loadablePatternIds, Boolean isActive);

  @Transactional
  @Modifying
  @Query("UPDATE LoadablePlanBallastDetails SET isActive = ?1 WHERE loadablePattern.id = ?2")
  public void deleteLoadablePlanBallastDetails(Boolean isActive, Long loadablePatternId);
}
