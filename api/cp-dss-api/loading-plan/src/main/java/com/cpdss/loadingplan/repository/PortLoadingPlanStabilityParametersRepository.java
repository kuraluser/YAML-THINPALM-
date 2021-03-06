/* Licensed at AlphaOri Technologies */
package com.cpdss.loadingplan.repository;

import com.cpdss.common.springdata.CommonCrudRepository;
import com.cpdss.loadingplan.entity.LoadingInformation;
import com.cpdss.loadingplan.entity.PortLoadingPlanStabilityParameters;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PortLoadingPlanStabilityParametersRepository
    extends CommonCrudRepository<PortLoadingPlanStabilityParameters, Long> {

  public List<PortLoadingPlanStabilityParameters> findByLoadingInformationAndIsActive(
      LoadingInformation loadingInformation, Boolean isActive);

  @Modifying
  @Transactional
  @Query("UPDATE PortLoadingPlanStabilityParameters SET isActive = false WHERE id = ?1")
  public void deleteById(Long id);

  @Modifying
  @Transactional
  @Query(
      "UPDATE PortLoadingPlanStabilityParameters SET isActive = false WHERE loadingInformation.id = ?1")
  public void deleteByLoadingInformationId(Long loadingInfoId);

  @Modifying
  @Transactional
  @Query(
      "UPDATE PortLoadingPlanStabilityParameters SET isActive = false WHERE loadingInformation.id = ?1 AND conditionType = ?2 AND valueType = ?3")
  public void deleteByLoadingInformationIdAndConditionTypeAndValueType(
      Long loadingInfoId, Integer conditionType, Integer valueType);

  public Optional<PortLoadingPlanStabilityParameters>
      findByLoadingInformationIdAndConditionTypeAndValueTypeAndIsActiveTrue(
          Long loadingInformationId, Integer conditionType, Integer valueType);

  @Transactional(isolation = Isolation.READ_UNCOMMITTED, propagation = Propagation.REQUIRES_NEW)
  public List<PortLoadingPlanStabilityParameters> findByLoadingInformationId(
      Long loadingInformationId);
}
