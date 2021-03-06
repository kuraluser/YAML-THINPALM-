/* Licensed at AlphaOri Technologies */
package com.cpdss.loadablestudy.repository;

import com.cpdss.loadablestudy.entity.Voyage;
import com.cpdss.loadablestudy.entity.VoyageStatus;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/** @Author jerin.g */
public interface VoyageRepository
    extends JpaRepository<Voyage, Long>, JpaSpecificationExecutor<Voyage> {

  public List<Voyage> findByCompanyXIdAndVesselXIdAndVoyageNoIgnoreCase(
      Long companyId, Long vesselXId, String voyageNo);

  public List<Voyage> findByVesselXIdAndIsActiveOrderByIdDesc(Long vesselXId, boolean isActive);

  public List<Voyage> findByVesselXIdAndIsActiveOrderByCreatedDateTimeDesc(
      Long vesselXId, boolean isActive);

  public Voyage findByIdAndIsActive(Long id, boolean isActive);

  public List<Voyage> findByVoyageNoAndIsActive(String voyageNo, boolean isActive);

  /*public Voyage
  findFirstByVoyageEndDateLessThanAndVesselXIdAndIsActiveAndVoyageStatusOrderByVoyageEndDateDesc(
      LocalDateTime currentVoyageStartDate,
      Long vesselId,
      boolean isActive,
      VoyageStatus voyageStatus);*/

  public Voyage findFirstByVesselXIdAndIsActiveAndVoyageStatusOrderByLastModifiedDateDesc(
      Long vesselId, boolean isActive, VoyageStatus voyageStatus);

  public Voyage findFirstByVesselXIdAndIsActiveAndVoyageStatusOrderByLastModifiedDateTimeDesc(
      Long vesselId, boolean isActive, VoyageStatus voyageStatus);

  @Query(
      "select V from Voyage V WHERE V.vesselXId= :vesselId AND V.isActive = :isActive AND"
          + " Date(V.actualStartDate) >= :from and Date(V.actualStartDate) <= :to ORDER BY V.lastModifiedDate DESC")
  public List<Voyage> findByIsActiveAndVesselXIdAndActualStartDateBetween(
      @Param("isActive") boolean isActive,
      @Param("vesselId") Long vesselXId,
      @Param("from") LocalDate date1,
      @Param("to") LocalDate date2);

  public List<Voyage> findByIsActiveAndVesselXIdOrderByLastModifiedDateTimeDesc(
      boolean isActive, Long vesselXId);

  @Query(
      value =
          "with list1 as ("
              + "select * from voyage v "
              + "where v.voyage_status = 3 "
              + "and v.vessel_xid = :vesselXId "
              + "and v.is_active = :isActive "
              + "order by v.voyage_status desc, v.created_date_time desc),"
              + "list2 as ("
              + "select * from voyage v "
              + "where v.voyage_status notnull "
              + "and v.vessel_xid = :vesselXId "
              + "and v.is_active = :isActive "
              + "order by v.created_date_time desc)"
              + "select * from list1 union all select * from list2;",
      nativeQuery = true)
  public List<Voyage> findByIsActiveAndVesselXIdOrderByVoyageStatusDescAndLastModifiedDateTimeDesc(
      @Param("isActive") boolean isActive, @Param("vesselXId") Long vesselXId);

  @Query("select V from Voyage V WHERE V.voyageStatus.id =?1 AND V.isActive=?2")
  public List<Voyage> findByVoyageStatusAndIsActive(Long voyageId, boolean b);

  @Query(
      "select v from Voyage v WHERE v.voyageStatus.id = ?1 AND v.vesselXId = ?2 AND v.isActive = true ORDER BY v.lastModifiedDate DESC")
  List<Voyage> findActiveVoyagesByVesselId(Long activeStatusId, Long vesselId);

  @Query(
      "select V from Voyage V WHERE V.voyageStatus.id =?1 AND V.vesselXId = ?2 AND V.isActive=?3")
  public List<Voyage> findByVoyageStatusAndVesselIdAndIsActive(
      Long voyageId, Long vesselId, boolean b);

  @Query(
      "FROM Voyage vg WHERE vg.voyageStatus = ?1 AND vg.vesselXId = ?2 AND vg.actualEndDate != null AND vg.isActive = true")
  List<Voyage> findRecentClosedVoyageDetails(VoyageStatus var1, Long var2, Pageable pageable);

  @Query(
      value = "SELECT  CAST(json_agg(u) as VARCHAR) json_out FROM voyage u where id=?1",
      nativeQuery = true)
  String getVoyagebyId(long id);

  @Transactional
  @Modifying
  @Query(
      "UPDATE Voyage vg SET vg.voyageStatus.id = ?2 WHERE vg.vesselXId = ?1 and vg.voyageStatus.id = ?3")
  void deActivateAllVoyageByVesselId(Long vesselId, Long voyageStatusId, Long activeVoyageStatusId);

  @Query("SELECT V from Voyage V WHERE V.vesselXId =?1 AND V.voyageStatus.id=?2")
  List<Voyage> findByVesselXIdAndVoyageStatusId(Long vesselId, Long voyageStatusId);

  public List<Voyage> findByVesselXIdAndIsActiveAndVoyageStatus_IdOrderByCreatedDateTimeDesc(
      long vesselId, boolean b, long l);

  public Voyage findFirstByVesselXIdAndIsActiveAndVoyageStatusInOrderByLastModifiedDateTimeDesc(
      Long vesselXId, boolean b, List<VoyageStatus> voyageStatus);
}
