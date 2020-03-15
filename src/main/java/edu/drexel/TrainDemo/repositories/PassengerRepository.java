package edu.drexel.TrainDemo.repositories;

import edu.drexel.TrainDemo.models.Passenger;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PassengerRepository extends CrudRepository<Passenger, Long> {
  List<Passenger> findByFirstNameAndLastName(String firstName, String lastName);
  List<Passenger> findByAddress(String address);
  List<Passenger> findByPhone(String phone);
  List<Passenger> findByEmailAddress(String emailaddress);
  
}
