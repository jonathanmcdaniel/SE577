package edu.drexel.TrainDemo.Services;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.drexel.TrainDemo.models.Path;
import edu.drexel.TrainDemo.models.Stop;
import edu.drexel.TrainDemo.models.StopTime;
import edu.drexel.TrainDemo.repositories.CalendarRepository;
import edu.drexel.TrainDemo.repositories.StopRepository;
import edu.drexel.TrainDemo.repositories.StopTimeRepository;

@Service
public class PathServiceImpl implements PathService {
    
    @Autowired
    private StopRepository stopRepo;

    @Autowired
    private StopTimeRepository stopTimeRepo;

    @Autowired
    private CalendarRepository calendarRepo;

    @Autowired
    private Logger logger;
    
    @Override
    public List<Path> getPaths(String from, String to){

        // Grab all StopTimes at the "from" Stop
        List<StopTime> allFrom = stopTimeRepo.findByStopId(from);
        logger.info("Found " + allFrom.size() + " from StopTimes");
        // Grab all StopTimes at the "to" Stop
        List<StopTime> allTo = stopTimeRepo.findByStopId(to);
        logger.info("Found " + allTo.size() + " to StopTimes");
        // Create an ArrayList where we will put our results
        List<Path> paths = new ArrayList<Path>();

        // For each "from" StopTime (if there are any)
        if(!allFrom.isEmpty()){
            for (StopTime fromStopTime : allFrom){
            
                // and each "to" StopTimes (if there are any)
                if(!allTo.isEmpty()){
                    for (StopTime toStopTime: allTo){
                    
                        // Check if they have the same TripID.  If so...
                        if (fromStopTime.getTrip().getId().equals(toStopTime.getTrip().getId())){
                            // Check to see if the "from" Stop occurs before the "to" Stop in the trip sequence.  If so...
                            if(fromStopTime.getStopSequence() < toStopTime.getStopSequence()){
                                
                                // Get the fromStop, toStop, departureTime, and arrivalTime
                                Stop fromStop = stopRepo.findById(from).get();
                                Stop toStop = stopRepo.findById(to).get();
                                Time departureTime = fromStopTime.getDepartureTime();
                                Time arrivalTime = toStopTime.getArrivalTime();

                                // Get the departure date
                                Date departureDate = calendarRepo.findById(fromStopTime.getTrip().getCalendarId()).get().getStartDate();

                                // Create the path and add it to the list of paths
                                Path path = new Path(fromStop, toStop, departureTime, arrivalTime, departureDate);
                                paths.add(path);

                            }
                        }
                    }
                }
            }            
        }

        // Return the paths 
        return paths;
    }
}