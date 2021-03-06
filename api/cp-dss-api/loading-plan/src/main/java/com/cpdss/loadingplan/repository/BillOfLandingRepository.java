/* Licensed at AlphaOri Technologies */
package com.cpdss.loadingplan.repository;

import com.cpdss.common.springdata.CommonCrudRepository;
import com.cpdss.loadingplan.entity.BillOfLanding;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface BillOfLandingRepository extends CommonCrudRepository<BillOfLanding, Long> {

  @Transactional
  @Modifying
  @Query(
      "Update BillOfLanding set bl_ref_number = ?1, bbl_at_60f = ?2, quantity_lt = ?3, quantity_mt = ?4, kl_at_15c = ?5, api = ?6,"
          + "temperature = ?7 where id = ?8")
  public void updateBillOfLandingRepository(
      @Param("bl_ref_number") String bl_ref_number,
      @Param("bbl_at_60f") BigDecimal bbl_at_60f,
      @Param("quantity_lt") BigDecimal quantity_lt,
      @Param("quantity_mt") BigDecimal quantity_mt,
      @Param("kl_at_15c") BigDecimal kl_at_15c,
      @Param("api") BigDecimal api,
      @Param("temperature") BigDecimal temperature,
      @Param("id") Long id);

  @Transactional
  @Modifying
  @Query("Update BillOfLanding set is_active = false where id = ?1")
  public void deleteBillOfLandingRepository(@Param("id") Long id);

  @Query("FROM BillOfLanding WHERE isActive = ?2")
  public List<BillOfLanding> findByBillOfLandingAndIsActive(
      List<BillOfLanding> billOfLandings, Boolean isActive);
}
