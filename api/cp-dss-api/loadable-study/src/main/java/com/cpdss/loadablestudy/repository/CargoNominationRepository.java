/* Licensed at AlphaOri Technologies */
package com.cpdss.loadablestudy.repository;

import com.cpdss.common.springdata.CommonCrudRepository;
import com.cpdss.loadablestudy.entity.CargoNomination;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/** Repository interface for cargoNomination entity */
public interface CargoNominationRepository extends CommonCrudRepository<CargoNomination, Long> {

  public Optional<CargoNomination> findByIdAndIsActive(Long id, Boolean isActive);

  public List<CargoNomination> findByLoadableStudyXIdAndIsActive(
      Long loadableStudyXId, Boolean isActive);

  public List<CargoNomination> findByLoadableStudyXIdAndIsActiveOrderByCreatedDateTime(
      Long loadableStudyXId, Boolean isActive);

  @Transactional
  @Modifying
  @Query("Update CargoNomination set isActive = false where id = ?1 ")
  public void deleteCargoNomination(Long cargoNominationId);

  @Query(
      "SELECT count(*) FROM CargoNomination CN INNER JOIN CargoNominationPortDetails CNPD "
          + "ON CN.id = CNPD.cargoNomination.id AND CN.loadableStudyXId = ?1 AND CNPD.cargoNomination <> ?2 AND CNPD.portId = ?3 "
          + "AND CN.isActive = true AND CNPD.isActive = true")
  public Long getCountCargoNominationWithPortIds(
      Long loadableStudyId, CargoNomination cargoNomination, Long portId);

  @Query("SELECT MIN(priority) FROM CargoNomination where id in ?1")
  public Long getMaxPriorityCargoNominationIn(List<Long> cargoNominationIds);
}