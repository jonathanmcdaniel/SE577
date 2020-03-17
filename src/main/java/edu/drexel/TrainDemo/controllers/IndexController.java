package edu.drexel.TrainDemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.drexel.TrainDemo.models.SearchQuery;
import edu.drexel.TrainDemo.models.Stop;
import edu.drexel.TrainDemo.repositories.StopRepository;

@Controller
public class IndexController {

    private StopRepository stopRepo;
    
    public IndexController(StopRepository stopRepo) {
        this.stopRepo = stopRepo;
    }

    @RequestMapping("/")
    String index(Model model) {
        Iterable<Stop> stops = stopRepo.findAll();
        SearchQuery query = new SearchQuery();
        model.addAttribute("stops", stops);
        model.addAttribute("query", query);
        System.out.println("index");
        return "index";
    }

    @RequestMapping("/about")
    String about() {
        System.out.println("about");
        return "about";
    }
    
}
