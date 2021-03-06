/* Licensed at AlphaOri Technologies */
package com.cpdss.loadablestudy.repository;

import com.cpdss.common.springdata.CommonCrudRepository;
import com.cpdss.loadablestudy.entity.CargoHistory;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

/**
 * Cargo history repository
 *
 * @author suhail.k
 */
public interface CargoHistoryRepository extends CommonCrudRepository<CargoHistory, Long> {

  @Query(
      "select new com.cpdss.loadablestudy.domain.CargoHistory(ch.tankId, cn.id, cn.cargoXId, cn.color, cn.abbreviation, ch.quantity, ch.api) "
          + "from CargoHistory ch "
          + "join CargoNomination cn on ch.cargoNomination = cn "
          + "where ch.voyage.id = ?1 "
          + "and ch.loadingPortId = ?2 and ch.isActive = true")
  public List<com.cpdss.loadablestudy.domain.CargoHistory> findCargoHistory(
      Long previousVoyage, Long lastPortId);
}
