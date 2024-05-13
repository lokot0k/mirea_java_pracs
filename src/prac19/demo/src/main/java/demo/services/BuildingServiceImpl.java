package demo.services;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import demo.entities.Building;
import demo.repositories.BuildingRepo;
import demo.specifications.BuildingSpecifications;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class BuildingServiceImpl implements BuildingService {
    private final BuildingRepo buildingRepo;

    public Long createBuilding(Building building) {
        log.info("create building {}", building);
        buildingRepo.save(building);
        return building.getId();
    }

    public List<Building> getBuildings() {
        log.info("get all buildings");
        return buildingRepo.findAll();
    }

    public void deleteBuilding(Long id) {
        log.info("delete building by id: {}", id);
        buildingRepo.deleteById(id);
    }

    public List<Building> getBuildingsSortedBy(String attributeName) {
        log.info("get all buildings sorted by attribute: {}", attributeName);
        Sort sort = Sort.by(Sort.Direction.ASC, attributeName);
        return buildingRepo.findAll(BuildingSpecifications.sortBy(attributeName), sort);
    }
}
