/* Licensed at AlphaOri Technologies */
package com.cpdss.loadingplan.repository;

import com.cpdss.common.springdata.CommonCrudRepository;
import com.cpdss.loadingplan.entity.EductionOperation;
import com.cpdss.loadingplan.entity.LoadingSequence;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/** @author pranav.k */
@Repository
public interface EductionOperationRepository extends CommonCrudRepository<EductionOperation, Long> {

  @Modifying
  @Transactional
  @Query(value = "UPDATE EductionOperation SET isActive = false WHERE loadingSequence = ?1")
  public void deleteByLoadingSequence(LoadingSequence loadingSequence);

  public EductionOperation findByLoadingSequenceAndIsActiveTrue(LoadingSequence loadingSequence);
}
