package demo.services;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import demo.entities.Address;
import demo.repositories.AddressRepo;
import demo.specifications.AddressSpecifications;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class AddressServiceImpl implements AddressService {
    private final AddressRepo addressRepo;

    public Long createAddress(Address address) {
        log.info("create address {}", address);
        addressRepo.save(address);
        return address.getId();
    }

    public List<Address> getAddresses() {
        log.info("get all addresses");
        return addressRepo.findAll();
    }

    public void deleteAddress(Long id) {
        log.info("delete address by id: {}", id);
        addressRepo.deleteById(id);
    }

    public List<Address> getAddressesSortedBy(String attributeName) {
        log.info("get all addresses sorted by attribute: {}", attributeName);
        Sort sort = Sort.by(Sort.Direction.ASC, attributeName);
        return addressRepo.findAll(AddressSpecifications.sortBy(attributeName), sort);
    }
}
