package edu.drexel.TrainDemo.repositories;

import edu.drexel.TrainDemo.models.Trip;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TripRepository extends CrudRepository<Trip, Long> { 
    // List<Trip> findByRouteId(long routeId);
    // List<Trip> findByCalendarId(long calendarId);
    // List<Trip> findByHeadsign(String headsign);
}