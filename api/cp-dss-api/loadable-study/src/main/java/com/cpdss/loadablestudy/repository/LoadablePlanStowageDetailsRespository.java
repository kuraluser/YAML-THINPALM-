/* Licensed at AlphaOri Technologies */
package com.cpdss.loadablestudy.repository;

import com.cpdss.common.springdata.CommonCrudRepository;
import com.cpdss.loadablestudy.entity.LoadablePattern;
import com.cpdss.loadablestudy.entity.LoadablePlanStowageDetails;
import java.util.List;

/** @Author jerin.g */
public interface LoadablePlanStowageDetailsRespository
    extends CommonCrudRepository<LoadablePlanStowageDetails, Long> {
  public List<LoadablePlanStowageDetails> findByLoadablePatternAndIsActive(
      LoadablePattern loadablePattern, Boolean isActive);

  public List<LoadablePlanStowageDetails> findByLoadablePatternIdInAndIsActive(
      List<Long> loadablePatternIds, boolean b);
}