/* Licensed at AlphaOri Technologies */
package com.cpdss.loadingplan.repository;

import com.cpdss.common.springdata.CommonCrudRepository;
import com.cpdss.loadingplan.entity.AlgoErrorHeading;
import com.cpdss.loadingplan.entity.LoadingInformation;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AlgoErrorHeadingRepository extends CommonCrudRepository<AlgoErrorHeading, Long> {

  public List<AlgoErrorHeading> findByLoadingInformationIdAndIsActiveTrue(Long loadingInfoId);

  @Modifying
  @Transactional
  @Query("UPDATE AlgoErrorHeading SET isActive = false WHERE loadingInformation = ?1")
  public void deleteByLoadingInformation(LoadingInformation loadingInformation);

  public List<AlgoErrorHeading> findByLoadingInformationIdAndConditionTypeAndIsActiveTrue(
      Long loadingInfoId, Integer conditionType);
}
