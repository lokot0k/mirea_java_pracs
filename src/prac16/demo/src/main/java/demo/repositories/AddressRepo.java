package demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.entities.Address;

public interface AddressRepo extends JpaRepository<Address, Long> {

}
