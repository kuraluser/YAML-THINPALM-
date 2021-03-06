/* Licensed at AlphaOri Technologies */
package com.cpdss.loadingplan.entity;

import com.cpdss.common.utils.EntityDoc;
import java.math.BigDecimal;
import javax.persistence.*;
import lombok.*;

/** @author ravi.r */
@Entity
@Table(name = "bill_of_ladding")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BillOfLanding extends EntityDoc {

  /*  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;*/

  @Column(name = "loading_xid")
  private Long loadingId;

  @Column(name = "port_xid")
  private Long portId;

  @Column(name = "cargo_nomination_xid")
  private Long cargoId;

  @Column(name = "bl_ref_number")
  private String blRefNumber;

  @Column(name = "bbl_at_60f")
  private BigDecimal bblAt60f;

  @Column(name = "quantity_lt")
  private BigDecimal quantityLt;

  @Column(name = "quantity_mt")
  private BigDecimal quantityMt;

  @Column(name = "kl_at_15c")
  private BigDecimal klAt15c;

  @Column(name = "api")
  private BigDecimal api;

  @Column(name = "temperature")
  private BigDecimal temperature;

  @Column(name = "is_active")
  private Boolean isActive;

  /*  @Column(name = "version")
  private Long version;*/
}
