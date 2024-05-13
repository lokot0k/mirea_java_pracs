package demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import demo.entities.Address;
import demo.repositories.AddressRepo;
import demo.services.AddressServiceImpl;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AddressServiceImplTest {
    @Mock
    private AddressRepo addressRepo;

    @Captor
    ArgumentCaptor<Address> captor;

    @Test
    public void createAddress() {
        Address addr = new Address("text1", "222222");
        AddressServiceImpl service = new AddressServiceImpl(addressRepo);
        service.createAddress(addr);
        Mockito.verify(addressRepo).save(captor.capture());
        Address captured = captor.getValue();
        assertEquals("text1", captured.getAddressText());
    }

    @Test
    public void getAddresses() {
        Address addr = new Address("text1", "222222");
        Address addr1 = new Address("text2", "111111");
        Mockito.when(addressRepo.findAll()).thenReturn(List.of(addr, addr1));
        AddressServiceImpl service = new AddressServiceImpl(addressRepo);
        Assertions.assertEquals(2, service.getAddresses().size());
        Assertions.assertEquals("text1", service.getAddresses().get(0).getAddressText());
    }

    @Test
    public void deleteAddress() {
        Long id = (long)1;
        addressRepo.deleteById(id);
    }

    @Test
    public void getAddressesSortedBy() {
        Address addr = new Address("text1", "222222");
        Address addr1 = new Address("text2", "111111");
        Mockito.when(addressRepo.findAll(any(Specification.class), any(Sort.class))).thenReturn(List.of(addr1, addr));
        AddressServiceImpl service = new AddressServiceImpl(addressRepo);
        Assertions.assertEquals(2, service.getAddressesSortedBy("zipCode").size());
    }
}
