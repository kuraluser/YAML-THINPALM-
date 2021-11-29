/* Licensed at AlphaOri Technologies */
package com.cpdss.loadablestudy.entity;

import com.cpdss.common.utils.EntityDoc;
import java.math.BigDecimal;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** Entity for Cargo Nomination Port Details */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cargo_nomination_operation_details")
public class CargoNominationPortDetails extends EntityDoc {

  private static final long serialVersionUID = 1L;

  @ManyToOne(cascade = CascadeType.MERGE)
  @JoinColumn(name = "cargo_nomination_xid")
  private CargoNomination cargoNomination;

  @Column(name = "port_xid")
  private Long portId;

  @Column(name = "is_active")
  private Boolean isActive;

  @Column(name = "quantity")
  private BigDecimal quantity;

  @Column(name = "mode_xid")
  private Long mode;

  @Column(name = "operation_xid")
  private Long operationId;

  @Transient private Long communicationRelatedEntityId;
}
