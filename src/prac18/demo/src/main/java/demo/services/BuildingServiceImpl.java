package demo.services;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import demo.entities.Building;
import demo.repositories.BuildingRepo;
import demo.specifications.BuildingSpecifications;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BuildingServiceImpl implements BuildingService {
    private final BuildingRepo buildingRepo;

    public Long createBuilding(Building building) {
        buildingRepo.save(building);
        return building.getId();
    }

    public List<Building> getBuildings() {
        return buildingRepo.findAll();
    }

    public void deleteBuilding(Long id) {
        buildingRepo.deleteById(id);
    }

    public List<Building> getBuildingsSortedBy(String attributeName) {
        Sort sort = Sort.by(Sort.Direction.ASC, attributeName);
        return buildingRepo.findAll(BuildingSpecifications.sortBy(attributeName), sort);
    }
}
