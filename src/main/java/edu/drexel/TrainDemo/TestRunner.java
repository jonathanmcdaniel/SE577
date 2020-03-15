package edu.drexel.TrainDemo;

import edu.drexel.TrainDemo.models.Route;
import edu.drexel.TrainDemo.models.Stop;
import edu.drexel.TrainDemo.repositories.*;

import org.slf4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;


@Component
public class TestRunner implements ApplicationRunner {

	private final Logger logger;
    private final RouteRepository routeRepository;
    private final StopRepository stopRepository;
    private String departureStation;
    private String arrivalStation;
    private Date departureDate;
    private Date arrivalDate;

    public TestRunner(Logger logger, RouteRepository routeRepository, StopRepository stopRepository) {
        this.routeRepository = routeRepository;
        this.stopRepository = stopRepository;
        this.logger = logger;
        this.departureStation = "PHL";
        this.arrivalStation = "BAL";
    }

    @Override
    public void run(ApplicationArguments args) {
    logger.info("============================== START TESTING CUSTOM CODE ==============================");
      
      Optional<Stop> ds = stopRepository.findById(departureStation);
      if (ds.isPresent()) {
          logger.info("Found stop with id " + departureStation);
          logger.info(ds.get().toString());
      } else {
          logger.info("Could not find stop with id " + departureStation);
      }
      
      Optional<Stop> as = stopRepository.findById(arrivalStation);
      if (as.isPresent()) {
          logger.info("Found stop with id " + arrivalStation);
          logger.info(as.get().toString());
      } else {
          logger.info("Could not find stop with id " + arrivalStation);
      }
      
      
      
      logger.info("============================== CLOSE TESTING CUSTOM CODE ==============================");
    }
}
