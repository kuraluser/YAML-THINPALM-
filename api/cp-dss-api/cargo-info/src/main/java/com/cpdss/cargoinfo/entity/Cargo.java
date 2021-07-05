/* Licensed at AlphaOri Technologies */
package com.cpdss.cargoinfo.entity;

import com.cpdss.common.utils.EntityDoc;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cargo_master")
public class Cargo extends EntityDoc {

  @Column(name = "crude_type")
  private String crudeType;

  @Column(name = "abbreviation")
  private String abbreviation;

  @Column(name = "api")
  private String api;

  @Column(name = "company_xid")
  private String companyXId;

  @Column(name = "is_condensate_cargo")
  private Boolean isCondensateCargo;
}
