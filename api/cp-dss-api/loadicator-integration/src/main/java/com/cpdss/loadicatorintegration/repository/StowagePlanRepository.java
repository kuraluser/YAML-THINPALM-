/* Licensed under Apache-2.0 */
package com.cpdss.loadicatorintegration.repository;

import com.cpdss.common.springdata.CommonCrudRepository;
import com.cpdss.loadicatorintegration.entity.StowagePlan;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

public interface StowagePlanRepository extends CommonCrudRepository<StowagePlan, Long> {

  Optional<StowagePlan> findByBookingListId(Long bookingListId);

  List<StowagePlan> findByIdIn(List<Long> idList);
  
  @Query(
	      "select new com.cpdss.loadicatorintegration.domain.StowagePlanDetail(sp.id, sp.portId) "
	          + "from StowagePlan sp "
	          + "join LoadicatorTrim lt on lt.stowagePlanId = sp.id where sp.id =?1 ")
	  public com.cpdss.loadicatorintegration.domain.StowagePlanDetail findPort(
	      Long stowagePlanId);
}
