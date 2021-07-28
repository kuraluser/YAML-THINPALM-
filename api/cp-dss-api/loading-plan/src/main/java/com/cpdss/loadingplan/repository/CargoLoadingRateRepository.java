/* Licensed at AlphaOri Technologies */
package com.cpdss.loadingplan.repository;

import com.cpdss.common.springdata.CommonCrudRepository;
import com.cpdss.loadingplan.entity.CargoLoadingRate;
import com.cpdss.loadingplan.entity.LoadingSequence;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CargoLoadingRateRepository extends CommonCrudRepository<CargoLoadingRate, Long> {

  List<CargoLoadingRate> findByLoadingSequenceAndIsActiveTrueOrderById(
      LoadingSequence loadingSequence);

  @Modifying
  @Transactional
  @Query("UPDATE CargoLoadingRate SET isActive = false WHERE loadingSequence = ?1")
  public void deleteByLoadingSequence(LoadingSequence loadingSequence);
}
