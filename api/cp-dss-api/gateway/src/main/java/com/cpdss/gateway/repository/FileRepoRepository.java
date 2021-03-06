/* Licensed at AlphaOri Technologies */
package com.cpdss.gateway.repository;

import com.cpdss.common.springdata.CommonCrudRepository;
import com.cpdss.gateway.entity.FileRepo;
import javax.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;

/**
 * File repository - to interact with {@link FileRepo} table
 *
 * @author gokul.p
 */
@Transactional
public interface FileRepoRepository
    extends CommonCrudRepository<FileRepo, Long>, JpaSpecificationExecutor<FileRepo> {
  Page<FileRepo> findAllByIsActiveTrueIgnoreCase(
      @Nullable Specification<FileRepo> spec, Pageable pageable);

  @Query(
      value = "SELECT  CAST(json_agg(u) as VARCHAR) json_out FROM file_repo u where id = ?1",
      nativeQuery = true)
  String getRowAsJsonById(Long Id);

  @Modifying
  @Query(
      "UPDATE FileRepo SET isActive = false WHERE vesselXId = ?1 AND voyageNumber = ?2 AND "
          + "section =?3 AND category =?4 AND isSystemGenerated =true AND isActive =true")
  public void deleteConfirmedLoadableStudyFile(
      Long vesselId, String voyageNo, String section, String category);
}
