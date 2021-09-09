/* Licensed at AlphaOri Technologies */
package com.cpdss.loadingplan.repository;

import com.cpdss.common.springdata.CommonCrudRepository;
import com.cpdss.loadingplan.entity.PortLoadingPlanCommingleDetails;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface PortLoadingPlanCommingleDetailsRepository
    extends CommonCrudRepository<PortLoadingPlanCommingleDetails, Long> {

  List<PortLoadingPlanCommingleDetails> findByLoadablePatternIdAndIsActiveTrue(
      Long loadablePatternId);
}