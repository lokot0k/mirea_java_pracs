package demo.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.entities.Building;

@Repository
public interface BuildingRepo extends JpaRepository<Building, Long> {
    List<Building> findAll(Specification<Building> specification, Sort sort);
}
