/* Licensed at AlphaOri Technologies */
package com.cpdss.loadingplan.repository;

import com.cpdss.common.springdata.CommonCrudRepository;
import com.cpdss.loadingplan.entity.LoadingInformation;
import com.cpdss.loadingplan.entity.PortLoadingPlanRobDetails;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PortLoadingPlanRobDetailsRepository
    extends CommonCrudRepository<PortLoadingPlanRobDetails, Long> {

  public List<PortLoadingPlanRobDetails> findByLoadingInformationAndIsActive(
      LoadingInformation loadingInformation, Boolean isActive);

  @Query(
      "FROM PortLoadingPlanRobDetails PL INNER JOIN LoadingInformation LI ON PL.loadingInformation.id = LI.id AND LI.loadablePatternXId = ?1 AND PL.portRotationXId = ?2 AND PL.isActive = ?3")
  public List<PortLoadingPlanRobDetails> findByPatternIdAndPortRotationIdAndIsActive(
      Long patternId, Long portRotationId, Boolean isActive);

  @Modifying
  @Transactional
  @Query("UPDATE PortLoadingPlanRobDetails SET isActive = false WHERE id = ?1")
  public void deleteById(Long id);

  @Modifying
  @Transactional
  @Query("UPDATE PortLoadingPlanRobDetails SET isActive = false WHERE loadingInformation.id = ?1")
  public void deleteByLoadingInformationId(Long loadingInfoId);

  @Transactional
  @Modifying
  @Query(
      "Update PortLoadingPlanRobDetails set quantity = ?1, quantityM3 = ?2" + " where tankXId = ?3")
  public void updatePortLoadingPlanRobDetailsRepository(
      @Param("quantity") BigDecimal quantity,
      @Param("quantity_m3") BigDecimal quantityM3,
      @Param("tank_xid") Long tankXId);
}
