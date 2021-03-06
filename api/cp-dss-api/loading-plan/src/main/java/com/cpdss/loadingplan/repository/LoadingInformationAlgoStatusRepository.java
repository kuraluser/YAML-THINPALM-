/* Licensed at AlphaOri Technologies */
package com.cpdss.loadingplan.repository;

import com.cpdss.common.springdata.CommonCrudRepository;
import com.cpdss.loadingplan.entity.LoadingInformationAlgoStatus;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface LoadingInformationAlgoStatusRepository
    extends CommonCrudRepository<LoadingInformationAlgoStatus, Long> {

  Optional<LoadingInformationAlgoStatus> findByProcessIdAndIsActiveTrue(String processId);

  @Transactional
  @Modifying
  @Query(
      "UPDATE LoadingInformationAlgoStatus SET loadingInformationStatus.id = ?1 WHERE processId = ?2")
  public void updateLoadingInformationAlgoStatus(Long loadingInformationStatusId, String processId);

  Optional<LoadingInformationAlgoStatus> findByProcessIdAndLoadingInformationIdAndIsActiveTrue(
      String processId, Long loadingInfoId);

  @Transactional
  @Modifying
  @Query(
      "UPDATE LoadingInformationAlgoStatus SET isActive = false WHERE loadingInformation.id = ?1 AND processId = ?2")
  public void deleteLoadingInformationAlgoStatus(Long loadingInfoId, String processId);

  Optional<LoadingInformationAlgoStatus>
      findByProcessIdAndLoadingInformationIdAndConditionTypeAndIsActiveTrue(
          String processId, Long loadingInfoId, Integer conditionType);

  @Transactional
  @Modifying
  @Query(
      "UPDATE LoadingInformationAlgoStatus SET loadingInformationStatus.id = ?1 WHERE loadingInformation.id = ?2 AND processId = ?3")
  public void updateLoadingInformationAlgoStatus(
      Long loadingInformationStatusId, Long loadingInfoId, String processId);

  @Query(
      value =
          "select * from loading_information_algo_status where loading_information_xid= ?1 and last_modified_date_time is not null order by last_modified_date_time desc limit 1",
      nativeQuery = true)
  LoadingInformationAlgoStatus findByLoadingInformationId(Long id);

  @Query(
      value =
          "select * from loading_information_algo_status where loading_information_xid = ?1 and loading_information_status_xid = ?2 and type_xid notnull and is_active",
      nativeQuery = true)
  Optional<List<LoadingInformationAlgoStatus>> getLoadingInfoAlgoStatus(
      Long loadingInfoId, Long loadingInfoStatusId);
}
