/* Licensed at AlphaOri Technologies */
package com.cpdss.vesselinfo.domain;

import com.cpdss.vesselinfo.entity.CrewDetails;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;

@Slf4j
@Data
@AllArgsConstructor
public class CrewDetailsSpecification implements Specification<CrewDetails> {
  private FilterCriteria criteria;

  @Override
  public Predicate toPredicate(
      Root<CrewDetails> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
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
    } else if ("like-with-join".equalsIgnoreCase(criteria.getOperation())) {
      return builder.like(
          builder.lower(
              root.join(criteria.getAttributeName())
                  .<String>get(criteria.getKey())
                  .as(String.class)),
          "%" + criteria.getValue() + "%");
    } else if ("join-with-equals".equalsIgnoreCase(criteria.getOperation())) {
      return builder.equal(
          root.join(criteria.getAttributeName()).<String>get(criteria.getKey()),
          criteria.getValue());
    } else if (criteria.getOperation().equalsIgnoreCase("not-equal")) {
      return builder.notEqual(root.get(criteria.getKey()), criteria.getValue());
    } else if (criteria.getOperation().equalsIgnoreCase("case-insensitive-equal")) {
      return builder.equal(
          builder.lower(root.get(criteria.getKey()).as(String.class)),
          criteria.getValue().toString().toLowerCase());
    }
    return null;
  }
}
