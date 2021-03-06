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
@Table(name = "vessel_pump_tank_mapping")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VesselPumpTankMapping extends EntityDoc {

  private static final long serialVersionUID = 1L;

  @Column(name = "vessel_xid")
  private Integer vesselXid;

  @Column(name = "is_active")
  private Boolean isActive;

  @JoinColumn(name = "vessel_pump_xid", referencedColumnName = "id")
  @ManyToOne
  private VesselPumps vesselPumps;

  @JoinColumn(name = "tank_xid", referencedColumnName = "id")
  @ManyToOne
  private VesselTank vesselTank;
}
