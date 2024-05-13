package demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import demo.entities.Building;
import demo.repositories.BuildingRepo;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BuildingService {
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
}
