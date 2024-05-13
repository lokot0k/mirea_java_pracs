package demo.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.entities.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Long> {
    List<Address> findAll(Specification<Address> specification, Sort sort);
}
