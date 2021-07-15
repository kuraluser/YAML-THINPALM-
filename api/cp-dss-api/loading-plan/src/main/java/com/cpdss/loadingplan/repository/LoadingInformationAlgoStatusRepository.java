/* Licensed at AlphaOri Technologies */
package com.cpdss.loadingplan.repository;

import com.cpdss.common.springdata.CommonCrudRepository;
import com.cpdss.loadingplan.entity.LoadingInformationAlgoStatus;
import org.springframework.stereotype.Repository;

@Repository
public interface LoadingInformationAlgoStatusRepository
    extends CommonCrudRepository<LoadingInformationAlgoStatus, Long> {}
