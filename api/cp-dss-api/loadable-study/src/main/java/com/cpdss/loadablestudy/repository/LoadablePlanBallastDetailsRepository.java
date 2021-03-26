/* Licensed at AlphaOri Technologies */
package com.cpdss.loadablestudy.repository;

import com.cpdss.common.springdata.CommonCrudRepository;
import com.cpdss.loadablestudy.entity.LoadablePattern;
import com.cpdss.loadablestudy.entity.LoadablePlanBallastDetails;
import java.util.List;

/** @Author jerin.g */
public interface LoadablePlanBallastDetailsRepository
    extends CommonCrudRepository<LoadablePlanBallastDetails, Long> {
  public List<LoadablePlanBallastDetails> findByLoadablePatternAndIsActive(
      LoadablePattern loadablePattern, Boolean isActive);

  public List<LoadablePlanBallastDetails> findByLoadablePatternIdInAndIsActive(
      List<Long> loadablePatternIds, Boolean isActive);
}