/* Licensed at AlphaOri Technologies */
package com.cpdss.cargoinfo.domain;

import com.cpdss.cargoinfo.entity.Cargo;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;

/**
 * Class for role specification
 *
 * @author sreekumar.k
 */
@Slf4j
@Data
@AllArgsConstructor
public class CargoSpecification implements Specification<Cargo> {
  private FilterCriteria criteria;

  @Override
  public Predicate toPredicate(Root<Cargo> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
    if (criteria.getOperation().equalsIgnoreCase(">")) {
      //      Greater than
      return builder.greaterThanOrEqualTo(
          root.<String>get(criteria.getKey()), criteria.getValue().toString());
    } else if (criteria.getOperation().equalsIgnoreCase("<")) {
      //      Less than
      return builder.lessThanOrEqualTo(
          root.<String>get(criteria.getKey()), criteria.getValue().toString());
    } else if (criteria.getOperation().equalsIgnoreCase(":")) {
      //      Exact match
      return builder.equal(root.get(criteria.getKey()), criteria.getValue());
    } else if (criteria.getOperation().equalsIgnoreCase("like")) {
      if (criteria.getValue() instanceof String) {
        String val = (String) criteria.getValue();
        return builder.like(
            builder.upper(root.<String>get(criteria.getKey())), "%" + val.toUpperCase() + "%");
      }
      //      Partial match
      return builder.like(root.<String>get(criteria.getKey()), "%" + criteria.getValue() + "%");
    } else if ("in".equalsIgnoreCase(criteria.getOperation())) {
      return builder.in(root.get(criteria.getKey())).value(criteria.getValue());
    }
    return null;
  }
}
