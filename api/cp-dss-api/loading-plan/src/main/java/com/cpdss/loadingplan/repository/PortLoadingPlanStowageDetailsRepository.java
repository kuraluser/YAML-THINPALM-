/* Licensed at AlphaOri Technologies */
package com.cpdss.loadingplan.repository;

import com.cpdss.common.springdata.CommonCrudRepository;
import com.cpdss.loadingplan.entity.LoadingInformation;
import com.cpdss.loadingplan.entity.PortLoadingPlanStowageDetails;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PortLoadingPlanStowageDetailsRepository
    extends CommonCrudRepository<PortLoadingPlanStowageDetails, Long> {

  public List<PortLoadingPlanStowageDetails> findByLoadingInformationAndIsActive(
      LoadingInformation loadingInformation, Boolean isActive);

  @Query(
      "FROM PortLoadingPlanStowageDetails PL INNER JOIN LoadingInformation LI ON PL.loadingInformation.id = LI.id AND LI.loadablePatternXId = ?1 AND PL.portRotationXId = ?2 AND PL.isActive = ?3 AND LI.isActive = ?3 ORDER BY PL.id")
  public List<PortLoadingPlanStowageDetails> findByPatternIdAndPortRotationIdAndIsActive(
      Long patternId, Long portRotationId, Boolean isActive);

  @Modifying
  @Transactional
  @Query("UPDATE PortLoadingPlanStowageDetails SET isActive = false WHERE id = ?1")
  public void deleteById(Long id);

  @Modifying
  @Transactional
  @Query(
      "UPDATE PortLoadingPlanStowageDetails SET isActive = false WHERE loadingInformation.id = ?1")
  public void deleteByLoadingInformationId(Long loadingInfoId);

  @Transactional
  @Modifying
  @Query(
      "Update PortLoadingPlanStowageDetails set quantity = ?1, ullage = ?2, quantityM3 = ?3, api = ?4, temperature = ?5"
          + " where tankXId = ?4 and portXId= ?6 and loading_information_xid =?7"
          + " and arrival_departutre =?8 and isActive = ?5")
  public void updatePortLoadingPlanStowageDetailsRepository(
      @Param("quantity") BigDecimal quantity,
      @Param("ullage") BigDecimal ullage,
      @Param("quantity_m3") BigDecimal quantity_m3,
      @Param("api") BigDecimal api,
      @Param("temperature") BigDecimal temperature,
      @Param("tank_xid") Long tankXId,
      @Param("is_active") Boolean isActive,
      @Param("port_xid") Long portXId,
      @Param("loading_information_xid") Long loadingId,
      @Param("arrival_departutre") Long arrivalDepartutre);

  public List<PortLoadingPlanStowageDetails> findByPortRotationXIdInAndIsActive(
      List<Long> portRotationId, Boolean isActive);

  public List<PortLoadingPlanStowageDetails>
      findByPortRotationXIdAndIsActiveAndConditionTypeAndValueType(
          Long portRotationId, Boolean isActive, Integer conditionType, Integer valueType);

  @Transactional
  @Modifying
  @Query(
      "Update PortLoadingPlanStowageDetails set isActive = false WHERE loadingInformation.id = ?1 and conditionType = ?2 and isActive = true")
  public void deleteExistingByLoadingInfoAndConditionType(
      Long loadingInfoId, Integer conditionType);

  @Transactional
  @Modifying
  @Query(
      "Update PortLoadingPlanStowageDetails set isActive = false WHERE loadingInformation.id = ?1 and conditionType = ?2 and valueType = ?3 and isActive = true")
  public void deleteExistingByLoadingInfoAndConditionTypeAndValueType(
      Long loadingInfoId, Integer conditionType, Integer valueType);

  @Query(
      "FROM PortLoadingPlanStowageDetails plpsd WHERE plpsd.loadingInformation.id = ?1 and plpsd.conditionType = 2 and plpsd.valueType = 1 and plpsd.isActive = true")
  List<PortLoadingPlanStowageDetails> findCargoHistoryData(Long infoId);

  public List<PortLoadingPlanStowageDetails>
      findByCargoNominationXIdAndPortRotationXIdAndValueTypeAndConditionTypeAndIsActiveTrue(
          Long cargoNominationId,
          long lastLoadingPortId,
          Integer valueTypeActuals,
          Integer conditionTypeDep);

  /**
   * Fetches list of PortLoadingPlanStowageDetails entities
   *
   * @param loadingInformation loading information entity
   * @param conditionType arrival or departure condition
   * @param valueType actual or planned value
   * @return list of PortLoadingPlanStowageDetails entities
   */
  List<PortLoadingPlanStowageDetails>
      findByLoadingInformationAndConditionTypeAndValueTypeAndIsActiveTrue(
          LoadingInformation loadingInformation, int conditionType, Integer valueType);
}
