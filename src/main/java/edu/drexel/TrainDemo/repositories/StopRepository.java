package edu.drexel.TrainDemo.repositories;

import edu.drexel.TrainDemo.models.Stop;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StopRepository extends CrudRepository<Stop, String> {
    List<Stop> findByName(String name);
}