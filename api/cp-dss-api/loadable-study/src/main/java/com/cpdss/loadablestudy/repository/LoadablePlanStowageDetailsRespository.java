/* Licensed at AlphaOri Technologies */
package com.cpdss.loadablestudy.repository;

import com.cpdss.common.springdata.CommonCrudRepository;
import com.cpdss.loadablestudy.entity.LoadablePattern;
import com.cpdss.loadablestudy.entity.LoadablePlanStowageDetails;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/** @Author jerin.g */
public interface LoadablePlanStowageDetailsRespository
    extends CommonCrudRepository<LoadablePlanStowageDetails, Long> {
  public List<LoadablePlanStowageDetails> findByLoadablePatternAndIsActive(
      LoadablePattern loadablePattern, Boolean isActive);

  public List<LoadablePlanStowageDetails> findByLoadablePattern_IdInAndIsActive(
      List<Long> loadablePatternIds, Boolean isActive);

  @Transactional
  @Modifying
  @Query("UPDATE LoadablePlanStowageDetails SET isActive = ?1 WHERE loadablePattern.id = ?2")
  public void deleteLoadablePlanStowageDetails(Boolean isActive, Long loadablePatternId);

  Optional<List<LoadablePlanStowageDetails>> findByLoadablePattern_IdAndIsActiveTrue(
      long loadablePattern);
}
