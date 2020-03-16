package edu.drexel.TrainDemo.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.drexel.TrainDemo.models.Stop;
import edu.drexel.TrainDemo.repositories.StopRepository;

@Controller
public class SearchController{

    private StopRepository stopRepo;

    public SearchController(StopRepository stopRepo){
        this.stopRepo = stopRepo;
    }
    
    @RequestMapping("/search")
    String search(Model model){
        Iterable<Stop> stops = stopRepo.findAll();
        model.addAttribute("stops", stops);

        System.out.println("search");
        return "search";
    }

}