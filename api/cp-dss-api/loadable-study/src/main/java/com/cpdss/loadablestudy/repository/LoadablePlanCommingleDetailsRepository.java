/* Licensed at AlphaOri Technologies */
package com.cpdss.loadablestudy.repository;

import com.cpdss.common.springdata.CommonCrudRepository;
import com.cpdss.loadablestudy.entity.LoadablePattern;
import com.cpdss.loadablestudy.entity.LoadablePlanCommingleDetails;
import java.util.List;
import java.util.Optional;

/** @Author jerin.g */
public interface LoadablePlanCommingleDetailsRepository
    extends CommonCrudRepository<LoadablePlanCommingleDetails, Long> {

  public List<LoadablePlanCommingleDetails> findByLoadablePatternAndIsActive(
      LoadablePattern loadablePattern, Boolean isActive);

  public Optional<LoadablePlanCommingleDetails> findByIdAndIsActive(Long id, Boolean isActive);
}