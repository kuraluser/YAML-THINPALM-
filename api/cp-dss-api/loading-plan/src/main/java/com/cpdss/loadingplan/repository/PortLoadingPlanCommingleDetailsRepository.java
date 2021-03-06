/* Licensed at AlphaOri Technologies */
package com.cpdss.loadingplan.repository;

import com.cpdss.common.springdata.CommonCrudRepository;
import com.cpdss.loadingplan.entity.LoadingInformation;
import com.cpdss.loadingplan.entity.PortLoadingPlanCommingleDetails;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PortLoadingPlanCommingleDetailsRepository
    extends CommonCrudRepository<PortLoadingPlanCommingleDetails, Long> {

  List<PortLoadingPlanCommingleDetails> findByLoadablePatternIdAndIsActiveTrue(
      Long loadablePatternId);

  @Modifying
  @Transactional
  @Query(
      "UPDATE PortLoadingPlanCommingleDetails SET isActive = false WHERE loadingInformation.id = ?1")
  public void deleteByLoadingInformationId(Long loadingInfoId);

  public List<PortLoadingPlanCommingleDetails> findByLoadingInformationAndIsActive(
      LoadingInformation loadingInformation, Boolean isActive);

  @Transactional
  @Modifying
  @Query(
      "Update PortLoadingPlanCommingleDetails set isActive = false WHERE loadingInformation.id = ?1 and conditionType = ?2 and valueType = ?3 and isActive = true")
  public void deleteExistingByLoadingInfoAndConditionTypeAndValueType(
      Long loadingInfoId, Integer conditionType, Integer valueType);

  @Query(
      value =
          "select * FROM port_loadable_plan_commingle_details where (cargo_nomination1_xid = ?1 or cargo_nomination2_xid = ?1 ) and actual_planned = ?2 and arrival_departure = ?3 and is_active = true;",
      nativeQuery = true)
  List<PortLoadingPlanCommingleDetails> findByCommingleCargoNominationId(
      Long cargoNominationID, Integer valueType, Integer conditionType);
}
