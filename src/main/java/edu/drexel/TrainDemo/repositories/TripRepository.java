package edu.drexel.TrainDemo.repositories;

import edu.drexel.TrainDemo.models.Trip;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TripRepository extends CrudRepository<Trip, Long> { 
    List<Trip> findByRouteId(long routeId);
    List<Trip> findByCalendarId(long calendarId);
    List<Trip> findByHeadsign(String headsign);
    /*
    @Query("select t.id as trip from calendar c, trip t, stop_time st, stop s, route r where c.start_date >= :date and c.id = t.calendar_id and st.trip_id = t.id and st.stop_id = s.id and r.id = t.route_id and s.id = :stn order by t.id, st.arrival_time")
    public List<Long> findCustomTrip(@Param("date") String date, @Param("stn") String stn);
    */
}