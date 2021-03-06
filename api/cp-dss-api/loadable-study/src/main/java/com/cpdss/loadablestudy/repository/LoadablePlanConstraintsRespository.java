/* Licensed at AlphaOri Technologies */
package com.cpdss.loadablestudy.repository;

import com.cpdss.common.springdata.CommonCrudRepository;
import com.cpdss.loadablestudy.entity.LoadablePattern;
import com.cpdss.loadablestudy.entity.LoadablePlanConstraints;
import java.util.List;

/** @Author jerin.g */
public interface LoadablePlanConstraintsRespository
    extends CommonCrudRepository<LoadablePlanConstraints, Long> {
  public List<LoadablePlanConstraints> findByLoadablePatternAndIsActive(
      LoadablePattern loadablePattern, Boolean isActive);

  public List<LoadablePlanConstraints> findByLoadablePattern_IdInAndIsActive(
      List<Long> patternsIds, Boolean isActive);
}
