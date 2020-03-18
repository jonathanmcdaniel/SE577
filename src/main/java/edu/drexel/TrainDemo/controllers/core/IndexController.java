package edu.drexel.TrainDemo.controllers.core;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.drexel.TrainDemo.models.search.SearchQuery;
import edu.drexel.TrainDemo.models.core.Stop;
import edu.drexel.TrainDemo.repositories.core.StopRepository;

@Controller
public class IndexController {

    private final Logger logger;
    private final StopRepository stopRepo;
    
    public IndexController(Logger logger, StopRepository stopRepo) {
        this.logger = logger;
        this.stopRepo = stopRepo;
    }

    @RequestMapping("/")
    String index(Model model) {
        Iterable<Stop> stops = stopRepo.findAll();
        SearchQuery query = new SearchQuery();
        model.addAttribute("stops", stops);
        model.addAttribute("query", query);
        logger.info("On home page");
        return "index";
    }

    @RequestMapping("/about")
    String about() {
        logger.info("On about page");
        return "about";
    }
    
}
