package demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import demo.entities.Address;
import demo.repositories.AddressRepo;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AddressService {
    private final AddressRepo addressRepo;

    public Long createAddress(Address address) {
        addressRepo.save(address);
        return address.getId();
    }

    public List<Address> getAddresses() {
        return addressRepo.findAll();
    }

    public void deleteAddress(Long id) {
        addressRepo.deleteById(id);
    }
}
