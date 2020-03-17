package edu.drexel.TrainDemo.controllers;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.drexel.TrainDemo.models.Stop;
import edu.drexel.TrainDemo.models.SearchQuery;
import edu.drexel.TrainDemo.repositories.StopRepository;

@Controller
public class SearchController{

    private StopRepository stopRepo;
    // private RouteService routeService;

    public SearchController(StopRepository stopRepo){
        this.stopRepo = stopRepo;
    }
    
    @RequestMapping("/search")
    String search(@ModelAttribute SearchQuery query, Model model){
        Iterable<Stop> stops = stopRepo.findAll();

        Optional<Stop> from = stopRepo.findById(query.getFrom());
        Optional<Stop> to = stopRepo.findById(query.getTo());

        
        model.addAttribute("stops", stops);

        System.out.println("search");
        return "search-results";
    }

}