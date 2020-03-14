package edu.drexel.TrainDemo.repositories;

import edu.drexel.TrainDemo.models.Route;
import edu.drexel.TrainDemo.models.RouteType;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RouteRepository extends CrudRepository<Route, Long> {
    List<Route> findByAgency_Id(long agencyId);
    List<Route> findByName(String name);
    List<Route> findByRouteType(RouteType routeType);
}