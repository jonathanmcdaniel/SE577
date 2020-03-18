package edu.drexel.TrainDemo.controllers.search;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


import edu.drexel.TrainDemo.models.core.Stop;
import edu.drexel.TrainDemo.services.search.PathService;
import edu.drexel.TrainDemo.models.search.Path;
import edu.drexel.TrainDemo.models.search.SearchQuery;
import edu.drexel.TrainDemo.repositories.core.StopRepository;

@Controller
public class SearchController{

    private final Logger logger;
    private final StopRepository stopRepo;

    @Autowired
    private PathService pathService;

    public SearchController(Logger logger, StopRepository stopRepo){
        this.logger = logger;
        this.stopRepo = stopRepo;
    }
    
    @RequestMapping("/search")
    String search(@ModelAttribute SearchQuery query, Model model){

        logger.info("Searching for paths...");
        List<Path> paths = pathService.getPaths(query.getFrom(), query.getTo());
        Iterable<Stop> stops = stopRepo.findAll();

        model.addAttribute("stops", stops);
        model.addAttribute("query", query);
        model.addAttribute("paths", paths);

        
        return "search";
    }

}