package demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.services.BuildingService;
import lombok.AllArgsConstructor;
import demo.entities.Building;

@RestController
@RequestMapping("/buildings")
@AllArgsConstructor
public class BuildingController {
    private BuildingService service;

    @GetMapping
    public List<Building> getBuildings() {
        return service.getBuildings();
    }

    @PostMapping
    public Long createBuilding(@RequestBody Building newBuilding) {
        return service.createBuilding(newBuilding);
    }

    @DeleteMapping("/{id}")
    public void deleteBuilding(@PathVariable Long id) {
        service.deleteBuilding(id);
    }
}
