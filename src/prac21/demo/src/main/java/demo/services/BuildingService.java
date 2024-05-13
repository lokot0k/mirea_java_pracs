package demo.services;

import demo.entities.Building;
import java.util.List;

public interface BuildingService {
    public Long createBuilding(Building building);

    public List<Building> getBuildings();

    public void deleteBuilding(Long id);

    public List<Building> getBuildingsSortedBy(String attributeName);
}
