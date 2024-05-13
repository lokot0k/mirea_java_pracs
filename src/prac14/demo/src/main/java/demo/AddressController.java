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
@RequestMapping("/addresses")
public class AddressController {
    private ArrayList<Address> repo;

    public AddressController() {
        repo = new ArrayList<>();
    }

    @GetMapping("/")
    public List<Address> getAddresses() {
        return repo;
    }

    @PostMapping("/")
    public Address createAddress(@RequestBody Address newAddress) {
        repo.add(newAddress);
        Address addr = repo.get(repo.size() - 1);
        addr.id = repo.size() - 1;
        return addr;
    }

    @DeleteMapping("/{id}")
    public Address deleteAddress(@PathVariable Long id) {
        try {
            Address addr = repo.get(id.intValue());
            repo.remove(id.intValue());
            return addr;
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }
}
