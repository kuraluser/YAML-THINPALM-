/* Licensed under Apache-2.0 */
package com.cpdss.vesselinfo.entity;

import com.cpdss.common.utils.EntityDoc;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** @author jerin.g */
@Entity
@Table(name = "ship_type")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShipType extends EntityDoc {

  private static final long serialVersionUID = 1L;

  @Column(name = "type")
  private String type;

  @Column(name = "description")
  private String description;

  @Column(name = "is_active")
  private Boolean isActive;
}
