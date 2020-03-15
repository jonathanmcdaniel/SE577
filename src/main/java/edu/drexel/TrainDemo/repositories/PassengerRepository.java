package edu.drexel.TrainDemo.repositories;

import edu.drexel.TrainDemo.models.Passengers;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PassengerRepository extends CrudRepository<Passenger, Long> {
  List<Passenger> findByName(String name);
  List<Passenger> findByAddress(String address);
  List<Passenger> findByPhone (String phone);
  List<Passenger> findByEmailAddress (String emailaddress);
  
}
