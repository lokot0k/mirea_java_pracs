package demo.specifications;

import demo.entities.Building;
import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class BuildingSpecifications {
    public static Specification<Building> sortBy(String attributeName) {
        return new Specification<Building>() {
            @Override
            public Predicate toPredicate(Root<Building> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                query.orderBy(criteriaBuilder.asc(root.get(attributeName)));
                return null;
            }
        };
    }
}
