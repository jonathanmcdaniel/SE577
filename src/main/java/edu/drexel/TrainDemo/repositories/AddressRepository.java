package edu.drexel.TrainDemo.repositories;

import edu.drexel.TrainDemo.models.Address;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AddressRepository extends CrudRepository<Address, Long> {
    List<Address> findAddressesByUserIdAndIsBilling(long userid, Boolean isBilling);
}
