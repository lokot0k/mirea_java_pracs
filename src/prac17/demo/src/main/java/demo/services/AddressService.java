package demo.services;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import demo.entities.Address;
import demo.repositories.AddressRepo;
import demo.specifications.AddressSpecifications;
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

    public List<Address> getAddressesSortedBy(String attributeName) {
        Sort sort = Sort.by(Sort.Direction.ASC, attributeName);
        return addressRepo.findAll(AddressSpecifications.sortBy(attributeName), sort);
    }
}
