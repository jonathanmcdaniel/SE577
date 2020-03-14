package edu.drexel.TrainDemo.repositories;

import edu.drexel.TrainDemo.models.Agency;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AgencyRepository extends CrudRepository<Agency, Long> { 
    List<Agency> findByName(String name);
}
