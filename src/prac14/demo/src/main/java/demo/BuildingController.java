package demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/buildings")
public class BuildingController {
    private ArrayList<Building> repo;

    public BuildingController() {
        repo = new ArrayList<>();
    }

    @GetMapping("/")
    public List<Building> getBuildings() {
        return repo;
    }

    @PostMapping("/")
    public Building createBuilding(@RequestBody Building newBuilding) {
        repo.add(newBuilding);
        Building build = repo.get(repo.size() - 1);
        build.id = repo.size() - 1;
        return build;
    }

    @DeleteMapping("/{id}")
    public Building deleteBuilding(@PathVariable Long id) {
        try {
            Building build = repo.get(id.intValue());
            repo.remove(id.intValue());
            return build;
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }
}
