/* Licensed at AlphaOri Technologies */
package com.cpdss.loadablestudy.repository;

import com.cpdss.common.springdata.CommonCrudRepository;
import com.cpdss.loadablestudy.entity.LoadableStudy;
import com.cpdss.loadablestudy.entity.LoadableStudyPortRotation;
import com.cpdss.loadablestudy.entity.OnHandQuantity;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * On hand quantity repository
 *
 * @author suhail.k
 */
public interface OnHandQuantityRepository extends CommonCrudRepository<OnHandQuantity, Long> {

  /**
   * Find all on hand quantity entities based on loadable study and port
   *
   * @param loadableStudy
   * @param portXId
   * @return
   */
  public List<OnHandQuantity> findByLoadableStudyAndPortXIdAndIsActive(
      LoadableStudy loadableStudy, Long portXId, boolean isActive);

  /**
   * @param loadableStudy
   * @param portRotation
   * @param isActive
   * @return
   */
  public List<OnHandQuantity> findByLoadableStudyAndPortRotationAndIsActive(
      LoadableStudy loadableStudy, LoadableStudyPortRotation portRotation, boolean isActive);

  @Query(
      value =
          "SELECT OHQ.id, OHQ.port_rotation_xid FROM on_hand_quantity OHQ where OHQ.loadable_study_xid = ?1 AND "
              + "OHQ.port_rotation_xid in ?2 AND OHQ.is_active = ?3",
      nativeQuery = true)
  public List<Object[]> findByLoadableStudyIdAndPortRotationIdInAndIsActive(
      Long id, List<Long> portRotationIds, boolean b);

  @Query(
      value =
          "SELECT port_rotation_xid FROM on_hand_quantity OHQ where OHQ.loadable_study_xid = ?1 AND "
              + "OHQ.port_rotation_xid in ?2 AND OHQ.is_active = ?3",
      nativeQuery = true)
  public List<Long> findByLoadableStudyAndPortRotationInAndIsActive(
      Long loadableStudyId, List<Long> portRotationIds, boolean isActive);

  /**
   * Find entity by id
   *
   * @param id
   * @param isActive
   * @return
   */
  public OnHandQuantity findByIdAndIsActive(Long id, boolean isActive);

  /**
   * @param loadableStudy
   * @param isActive
   * @return List<OnHandQuantity>
   */
  public List<OnHandQuantity> findByLoadableStudyAndIsActive(
      LoadableStudy loadableStudy, Boolean isActive);

  @Query(
      " SELECT SUM(OHQ.arrivalQuantity) FROM OnHandQuantity OHQ WHERE OHQ.portXId= ?1 AND OHQ.fuelTypeXId =?2 AND OHQ.isActive = ?3")
  public BigDecimal getOnHandQuantityByPortXIdAndFuelTypeAndIsActive(
      Long portXId, Long fuelType, Boolean isActive);

  @Transactional
  @Modifying
  @Query("UPDATE OnHandQuantity SET isActive = false WHERE loadableStudy = ?1 AND portXId = ?2")
  public void deleteByLoadableStudyAndPortXId(LoadableStudy loadableStudy, Long requestPortId);

  @Query("FROM OnHandQuantity OHQ where OHQ.loadableStudy.id = ?1 AND OHQ.isActive = true")
  public List<OnHandQuantity> findByDischargeStudyIdAndActive(Long dischargeStudyId);

  @Query(
      value =
          "SELECT  CAST(json_agg(u) as VARCHAR) json_out FROM on_hand_quantity u where loadable_study_xid IN (SELECT loadablestudy_xid FROM loadable_pattern where id=?1)",
      nativeQuery = true)
  String getOnHandQuantityWithPatternId(long id);
}
