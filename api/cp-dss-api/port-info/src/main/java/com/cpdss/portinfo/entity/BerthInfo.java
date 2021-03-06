/* Licensed at AlphaOri Technologies */
package com.cpdss.portinfo.entity;

import com.cpdss.common.utils.EntityDoc;
import java.math.BigDecimal;
import java.util.Set;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** Entity class for berthinfo table */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "berth_info")
public class BerthInfo extends EntityDoc {

  @Column(name = "berth_name")
  private String berthName;

  @Column(name = "maximum_draft")
  private BigDecimal maximumDraft;

  @Column(name = "max_ship_depth")
  private BigDecimal maxShipDepth;

  @Column(name = "max_ship_channel")
  private BigDecimal maxShipChannel;

  @Column(name = "is_active")
  private Boolean isActive;

  @Column(name = "maximum_loa")
  private BigDecimal maximumLoa;

  @Column(name = "maximum_dwt")
  private BigDecimal maximumDwt;

  @Column(name = "air_draft")
  private BigDecimal airDraft;

  @Column(name = "terminal")
  private String terminal;

  @Column(name = "berth_order")
  private Long berthOrder;

  @Column(name = "line_content_displacement")
  private BigDecimal lineDisplacement;

  @Column(name = "hose_connections")
  private String hoseConnection;

  @ManyToOne
  @JoinColumn(name = "port_xid")
  private PortInfo portInfo;

  @Column(name = "under_keel_clearence")
  private String underKeelClearance;

  @Column(name = "berth_chart_datum_depth")
  private BigDecimal berthDatumDepth;

  @Column(name = "displacement")
  private BigDecimal displacement;

  @OneToMany(mappedBy = "berthInfo", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  private Set<BerthManifold> berthManifolds;
}
