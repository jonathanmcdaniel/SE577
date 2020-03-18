package edu.drexel.TrainDemo.repositories.sales;

import org.springframework.data.repository.CrudRepository;

import edu.drexel.TrainDemo.models.core.Route;

public interface OrderRepository extends CrudRepository<Route, Long> {

}
