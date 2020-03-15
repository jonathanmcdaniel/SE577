package edu.drexel.TrainDemo;

import edu.drexel.TrainDemo.models.Calendar;
import edu.drexel.TrainDemo.models.Route;
import edu.drexel.TrainDemo.models.Stop;
import edu.drexel.TrainDemo.models.StopTime;
import edu.drexel.TrainDemo.models.Trip;
import edu.drexel.TrainDemo.repositories.*;

import org.slf4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Component
public class TestRunner implements ApplicationRunner {

	private final Logger logger;
    private final RouteRepository routeRepository;
    private final StopRepository stopRepository;
    private final StopTimeRepository stopTimeRepository;
    private final TripRepository tripRepository;
    private final CalendarRepository calendarRepository;
    private String departureStation;
    private String arrivalStation;
    private java.sql.Date departureDate;
    private java.sql.Date arrivalDate;

    public TestRunner(Logger logger, RouteRepository routeRepository, StopRepository stopRepository, StopTimeRepository stopTimeRepository, TripRepository tripRepository, CalendarRepository calendarRepository) {
        this.routeRepository = routeRepository;
        this.stopRepository = stopRepository;
        this.stopTimeRepository = stopTimeRepository;
        this.tripRepository = tripRepository;
        this.calendarRepository = calendarRepository;
        this.logger = logger;
        this.departureStation = "LVW";
        this.arrivalStation = "BAL";
        this.departureDate = java.sql.Date.valueOf("2018-03-15");
        this.arrivalDate = java.sql.Date.valueOf("2020-03-15");
    }

    @Override
    public void run(ApplicationArguments args) {
    logger.info("=======================================================================================");
    logger.info("============================== START TESTING CUSTOM CODE ==============================");
    logger.info("=======================================================================================");

      /*
      Optional<Stop> ds = stopRepository.findById(this.departureStation);
      if (ds.isPresent()) {
          logger.info("Found stop with id " + this.departureStation);
          logger.info(ds.get().toString());
      } else {
          logger.info("Could not find stop with id " + this.departureStation);
      }
      
      Optional<Stop> as = stopRepository.findById(this.arrivalStation);
      if (as.isPresent()) {
          logger.info("Found stop with id " + this.arrivalStation);
          logger.info(as.get().toString());
      } else {
          logger.info("Could not find stop with id " + this.arrivalStation);
      }
      
      logger.info("Attempting to get all calendar id by the date " + this.departureDate + "...");
      */
    
    logger.info("Finding all stop times for station stops at " + this.departureStation + " on or afer " + this.departureDate);
    List<Calendar> dates = calendarRepository.findByStartDateGreaterThan(this.departureDate);
    for (Calendar d : dates) {
        //logger.info(d.toString());
        List<Trip> trips = tripRepository.findByCalendarId(d.getId());
        for (Trip t : trips) {
            //logger.info("     " + t.toString());
            List<StopTime> stopTimes = stopTimeRepository.findByTripIdAndStopId(t.getId(), this.departureStation);
            for (StopTime st : stopTimes) {
                logger.info("     " + st.toString());
                  
              }
          }
      }
      
      
      logger.info("=======================================================================================");
      logger.info("============================== CLOSE TESTING CUSTOM CODE ==============================");
      logger.info("=======================================================================================");

    }
    
}
