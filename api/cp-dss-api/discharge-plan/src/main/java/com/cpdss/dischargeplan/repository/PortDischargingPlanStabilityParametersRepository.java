/* Licensed at AlphaOri Technologies */
package com.cpdss.dischargeplan.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cpdss.common.springdata.CommonCrudRepository;
import com.cpdss.dischargeplan.entity.DischargeInformation;
import com.cpdss.dischargeplan.entity.PortDischargingPlanStabilityParameters;

@Repository
public interface PortDischargingPlanStabilityParametersRepository
    extends CommonCrudRepository<PortDischargingPlanStabilityParameters, Long> {

  public List<PortDischargingPlanStabilityParameters> findByDischargingInformationAndIsActive(
      DischargeInformation dischargingInformation, Boolean isActive);

}
