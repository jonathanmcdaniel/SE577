package edu.drexel.TrainDemo.repositories.users;

import edu.drexel.TrainDemo.models.users.Passenger;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PassengerRepository extends CrudRepository<Passenger, Long> {
  List<Passenger> findByFirstNameAndLastName(String firstName, String lastName);
  List<Passenger> findByAddress(String address);
  List<Passenger> findByPhone(String phone);
  List<Passenger> findByEmailAddress(String emailaddress);
  
}
