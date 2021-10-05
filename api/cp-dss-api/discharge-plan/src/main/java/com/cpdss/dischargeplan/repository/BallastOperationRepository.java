/* Licensed at AlphaOri Technologies */
package com.cpdss.dischargeplan.repository;

import com.cpdss.common.springdata.CommonCrudRepository;
import com.cpdss.dischargeplan.entity.BallastOperation;
import com.cpdss.dischargeplan.entity.DischargingSequence;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BallastOperationRepository extends CommonCrudRepository<BallastOperation, Long> {

  List<BallastOperation> findByDischargingSequenceAndIsActiveTrueOrderById(
      DischargingSequence dischargingSequence);

  @Modifying
  @Transactional
  @Query("UPDATE BallastOperation SET isActive = false WHERE dischargingSequence = ?1")
  public void deleteByDischargingSequence(DischargingSequence dischargingSequence);
}
