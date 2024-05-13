package demo.services;

import demo.entities.Address;
import java.util.List;

public interface AddressService {
    public Long createAddress(Address address);

    public List<Address> getAddresses();

    public void deleteAddress(Long id);

    public List<Address> getAddressesSortedBy(String attributeName);
}
