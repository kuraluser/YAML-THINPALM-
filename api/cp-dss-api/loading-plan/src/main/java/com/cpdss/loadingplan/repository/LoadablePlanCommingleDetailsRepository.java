/* Licensed at AlphaOri Technologies */
package com.cpdss.loadingplan.repository;

import com.cpdss.common.springdata.CommonCrudRepository;
import com.cpdss.loadingplan.entity.LoadablePlanCommingleDetails;
import com.cpdss.loadingplan.entity.LoadingInformation;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface LoadablePlanCommingleDetailsRepository
    extends CommonCrudRepository<LoadablePlanCommingleDetails, Long> {

  @Transactional
  @Modifying
  @Query("UPDATE LoadablePlanCommingleDetails SET isActive = false WHERE loadingInformation = ?1")
  public void deleteByLoadingInformation(LoadingInformation loadingInformation);
}