package edu.drexel.TrainDemo.repositories.core;

import edu.drexel.TrainDemo.models.core.Route;
import edu.drexel.TrainDemo.models.core.RouteType;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RouteRepository extends CrudRepository<Route, Long> {
    List<Route> findByAgency_Id(long agencyId);
    List<Route> findByName(String name);
    List<Route> findByRouteType(RouteType routeType);
}