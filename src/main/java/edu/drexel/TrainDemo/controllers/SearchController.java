package edu.drexel.TrainDemo.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


import edu.drexel.TrainDemo.models.Stop;
import edu.drexel.TrainDemo.Services.PathService;
import edu.drexel.TrainDemo.models.Path;
import edu.drexel.TrainDemo.models.SearchQuery;
import edu.drexel.TrainDemo.repositories.StopRepository;

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