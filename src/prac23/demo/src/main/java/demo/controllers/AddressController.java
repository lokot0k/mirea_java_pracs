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
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Map;

import demo.services.AddressService;
import lombok.AllArgsConstructor;
import demo.entities.Address;

@RestController
@RequestMapping("/addresses")
@AllArgsConstructor
public class AddressController {
    private AddressService service;

    @GetMapping
    public List<Address> getAddresses(@RequestParam Map<String, String> queryParameters) {
        String attr = queryParameters.get("sortBy");
        if (attr == null) {
            return service.getAddresses();
        }

        return service.getAddressesSortedBy(attr);
    }

    @PostMapping
    public Long createAddress(@RequestBody Address newAddress) {
        return service.createAddress(newAddress);
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable Long id) {
        service.deleteAddress(id);
    }
}
