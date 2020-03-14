package edu.drexel.TrainDemo.repositories;

import edu.drexel.TrainDemo.models.StopTime;
import org.springframework.data.repository.CrudRepository;

import java.sql.Time;
import java.util.List;

public interface StopTimeRepository extends CrudRepository<StopTime, String> {
    List<StopTime> findByTrip_Id(long tripId);
    List<StopTime> findByStop_Sequence(int stopSequence);
    List<StopTime> findByArrival_Time(Time arrivalTime);
    List<StopTime> findByDeparture_Time(Time departureTime);
    List<StopTime> findByPickup_Type(int pickupType);
    List<StopTime> findbyDropoff_Type(int dropoffType);
}