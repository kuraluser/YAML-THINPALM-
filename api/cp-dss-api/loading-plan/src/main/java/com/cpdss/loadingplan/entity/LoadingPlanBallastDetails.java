/* Licensed at AlphaOri Technologies */
package com.cpdss.loadingplan.entity;

import com.cpdss.common.utils.EntityDoc;
import java.math.BigDecimal;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "loading_plan_ballast_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoadingPlanBallastDetails extends EntityDoc {

  private static final long serialVersionUID = 1L;

  @ManyToOne
  @JoinColumn(
      name = "loading_plan_portwise_details_xid",
      referencedColumnName = "id",
      nullable = true)
  private LoadingPlanPortWiseDetails loadingPlanPortWiseDetails;

  @Column(name = "tank_xid")
  private Long tankXId;

  @Column(name = "quantity")
  private BigDecimal quantity;

  @Column(name = "sounding")
  private BigDecimal sounding;

  @Column(name = "quantity_m3")
  private BigDecimal quantityM3;

  @Column(name = "is_active")
  private Boolean isActive;

  @Column(name = "color_code")
  private String colorCode;

  @Column(name = "sg")
  private BigDecimal sg;

  @Transient private Long CommunicationPortWiseId;
}
