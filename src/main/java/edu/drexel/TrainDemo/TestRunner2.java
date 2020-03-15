package edu.drexel.TrainDemo;

import edu.drexel.TrainDemo.models.StopTime;
import edu.drexel.TrainDemo.repositories.*;

import org.slf4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class TestRunner2 implements ApplicationRunner {

	private final Logger logger;
    private final StopTimeRepository stopTimeRepository;
    private String departureStation;
    private String arrivalStation;

    public TestRunner2(Logger logger, StopTimeRepository stopTimeRepository) {
        this.stopTimeRepository = stopTimeRepository;
        this.logger = logger;
        this.departureStation = "PHL";
        this.arrivalStation = "BAL";
    }

    @Override
    public void run(ApplicationArguments args) {
    logger.info("============================== START MORE TEST CODE ==============================");

    List<StopTime> stPHL = stopTimeRepository.findByStopId(departureStation);
    if (!stPHL.isEmpty()) {
    logger.info("Found " + stPHL.size() + " stopTime results with stopId " + departureStation);
    } else {
    logger.info("Could not find stopTime with stopId " + departureStation);
    }

    List<StopTime> stBAL = stopTimeRepository.findByStopId(arrivalStation);
    if (!stBAL.isEmpty()) {
    logger.info("Found " + stBAL.size() + " stopTime results with stopId " + arrivalStation);
    } else {
    logger.info("Could not find stopTime with stopId " + arrivalStation);
    }
      
      logger.info("============================== CLOSE MORE TEST CODE ==============================");
    }
}