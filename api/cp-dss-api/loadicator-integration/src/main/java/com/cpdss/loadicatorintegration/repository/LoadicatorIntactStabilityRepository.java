/* Licensed under Apache-2.0 */
package com.cpdss.loadicatorintegration.repository;

import com.cpdss.common.springdata.CommonCrudRepository;
import com.cpdss.loadicatorintegration.entity.IntactStability;
import java.util.List;

public interface LoadicatorIntactStabilityRepository
    extends CommonCrudRepository<IntactStability, Long> {

  List<IntactStability> findByStowagePlanIdIn(List<Long> stowagePlanIds);
}
