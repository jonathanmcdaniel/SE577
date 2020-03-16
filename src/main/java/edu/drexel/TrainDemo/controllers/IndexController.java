package edu.drexel.TrainDemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/")
    String index() {
        System.out.println("index");
        return "index";
    }

    @RequestMapping("/about")
    String about() {
        System.out.println("about");
        return "about";
    }
    
}
