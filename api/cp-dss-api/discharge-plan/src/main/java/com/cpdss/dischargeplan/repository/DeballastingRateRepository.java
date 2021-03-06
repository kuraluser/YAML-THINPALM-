/* Licensed at AlphaOri Technologies */
package com.cpdss.dischargeplan.repository;

import com.cpdss.common.springdata.CommonCrudRepository;
import com.cpdss.dischargeplan.entity.DeballastingRate;
import com.cpdss.dischargeplan.entity.DischargingPlanPortWiseDetails;
import com.cpdss.dischargeplan.entity.DischargingSequence;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface DeballastingRateRepository extends CommonCrudRepository<DeballastingRate, Long> {

  List<DeballastingRate> findByDischargingSequenceAndIsActiveTrueOrderById(
      DischargingSequence dischargingSequence);

  @Query(
      "from DeballastingRate dr where dr.dischargingSequence.id in ?1 and dr.isActive = true order by dr.id")
  List<DeballastingRate> findByDischargingSequenceInAndIsActiveTrueOrderById(
      List<Long> dischargeSequencesIds);

  List<DeballastingRate> findByDischargingPlanPortWiseDetailsAndIsActiveTrueOrderById(
      DischargingPlanPortWiseDetails dischargingPlanPortWiseDetails);

  @Query(
      "from DeballastingRate dr where dr.dischargingPlanPortWiseDetails.id in ?1 and dr.isActive = true order by dr.id")
  List<DeballastingRate> findByDischargingPlanPortWiseDetailsInAndIsActiveTrueOrderById(
      List<Long> ids);

  @Modifying
  @Transactional
  @Query("UPDATE DeballastingRate SET isActive = false WHERE dischargingSequence = ?1")
  public void deleteByDischargingSequence(DischargingSequence dischargingSequence);

  @Modifying
  @Transactional
  @Query("UPDATE DeballastingRate SET isActive = false WHERE dischargingPlanPortWiseDetails = ?1")
  public void deleteByDischargingPlanPortWiseDetails(
      DischargingPlanPortWiseDetails dischargingPlanPortWiseDetails);
}
