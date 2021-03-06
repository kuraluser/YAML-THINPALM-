/* Licensed at AlphaOri Technologies */
package com.cpdss.vesselinfo.entity;

import com.cpdss.common.utils.EntityDoc;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** @author jerin.g */
@Entity
@Table(name = "consumption_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConsumptionDetails extends EntityDoc {

  private static final long serialVersionUID = 1L;

  @Column(name = "is_active")
  private Boolean isActive;

  @JoinColumn(name = "fuel_type_xid", referencedColumnName = "id")
  @ManyToOne
  private FuelMaster fuelMaster;

  @JoinColumn(name = "vessel_xid", referencedColumnName = "id")
  @ManyToOne
  private Vessel vessel;

  @JoinColumn(name = "tank_xid", referencedColumnName = "id")
  @ManyToOne
  private VesselTank vesselTank;
}
