package demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.entities.Building;

public interface BuildingRepo extends JpaRepository<Building, Long> {
    
}
