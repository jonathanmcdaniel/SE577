package edu.drexel.TrainDemo.repositories;

import edu.drexel.TrainDemo.models.Address;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AddressRepository extends CrudRepository<Address, Long> {
    List<Address> findAddressesByUserIdAndIsBilling(long userid, Boolean isBilling);

    @Modifying
    @Transactional
    void deleteAddressByNameAndLine1AndCityAndZipAndUserId(String name, String line1, String city, String zip, long userid);
}
