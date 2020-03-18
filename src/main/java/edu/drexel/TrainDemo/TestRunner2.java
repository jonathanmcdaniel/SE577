package edu.drexel.TrainDemo;

import edu.drexel.TrainDemo.models.search.Path;
import edu.drexel.TrainDemo.models.core.StopTime;
import edu.drexel.TrainDemo.repositories.core.StopTimeRepository;
import edu.drexel.TrainDemo.services.search.PathService;

import org.slf4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class TestRunner2 implements ApplicationRunner {

	private final Logger logger;
  private final StopTimeRepository stopTimeRepo;
  private final PathService pathService;
  private String departureStation;
  private String arrivalStation;


    public TestRunner2(Logger logger, StopTimeRepository stopTimeRepo, PathService pathService) {
        this.stopTimeRepo = stopTimeRepo;
        this.logger = logger;
        this.departureStation = "PHL";
        this.arrivalStation = "BAL";
        this.pathService = pathService;
    }

    @Override
    public void run(ApplicationArguments args) {
      logger.info("============================== START MORE TEST CODE ==============================");

      List<Path> paths = pathService.getPaths(departureStation, arrivalStation);
      if (!paths.isEmpty()){
        if(paths.size() <= 20){
          for(Path path : paths){
            logger.info(path.toString());
          } 
        } else {
          for(int i=0; i<20; i++){
            logger.info(paths.get(i).toString());
          } 
        }

      } else {
        logger.info("Could not find any paths from PHL to BAL");
      }
      
      logger.info("============================== CLOSE MORE TEST CODE ==============================");
    }
}