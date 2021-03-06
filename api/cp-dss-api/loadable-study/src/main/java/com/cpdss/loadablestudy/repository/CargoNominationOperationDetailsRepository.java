/* Licensed at AlphaOri Technologies */
package com.cpdss.loadablestudy.repository;

import com.cpdss.common.springdata.CommonCrudRepository;
import com.cpdss.loadablestudy.entity.CargoNomination;
import com.cpdss.loadablestudy.entity.CargoNominationPortDetails;
import com.cpdss.loadablestudy.entity.LoadableStudyPortRotation;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/** Repository interface for cargoNominationOperationDetails entity */
public interface CargoNominationOperationDetailsRepository
    extends CommonCrudRepository<CargoNominationPortDetails, Long> {

  @Transactional
  @Modifying
  @Query("Update CargoNominationPortDetails set isActive = false where cargoNomination.id = ?1 ")
  void deleteCargoNominationPortDetails(Long cargoNominationId);

  List<CargoNominationPortDetails> findByCargoNominationInAndIsActiveTrue(
      List<CargoNomination> cargoNominations);

  List<CargoNominationPortDetails> findByCargoNominationAndIsActiveTrue(
      CargoNomination cargoNomination);

  CargoNominationPortDetails findByCargoNominationAndPortIdAndIsActiveTrue(
      CargoNomination cargo, Long portXId);

  /**
   * Fetches cargo nomination operation details based on list of cargo nomination identifiers
   *
   * @param cargoNominationIds list of cargo nomination identifiers
   * @param portId
   * @return list of cargo nomination operation details entities
   */
  List<CargoNominationPortDetails> findByCargoNomination_IdInAndPortIdAndIsActiveTrue(
      List<Long> cargoNominationIds, Long portId);

  public CargoNominationPortDetails findByCargoNominationAndPortRotationAndIsActiveTrue(
      CargoNomination cargo, LoadableStudyPortRotation portRotation);

  @Query(
      "SELECT CASE WHEN COUNT(CNPD) > 0 THEN true ELSE false END FROM CargoNominationPortDetails CNPD WHERE CNPD.portRotation = ?1")
  public Boolean findIfPortRotationIsUsedForOperations(LoadableStudyPortRotation portRotation);

  Optional<CargoNominationPortDetails> findByCargoNomination_IdAndPortIdAndIsActiveTrue(
      Long dischargeCargoNominationId, Long portId);
}
