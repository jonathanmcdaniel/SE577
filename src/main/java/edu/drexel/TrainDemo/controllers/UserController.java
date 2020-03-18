package edu.drexel.TrainDemo.controllers;

import edu.drexel.TrainDemo.Services.UserService;
import edu.drexel.TrainDemo.Utils;
import edu.drexel.TrainDemo.models.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Collections;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user")
    @ResponseBody
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
        System.out.println("USER");
        UserEntity currentUser = this.userService.getUser(principal);
        Map map;
        if (currentUser == null) {
            map = Collections.singletonMap("name", principal.getAttribute("name"));
        } else {
            map = Collections.singletonMap("name", currentUser.getFirstName() + " " + currentUser.getLastName());
        }
        return map;
    }

    @RequestMapping("/user/dashboard")
    String userDashboard(@AuthenticationPrincipal OAuth2User principal, Model model) {
        System.out.println((int) principal.getAttribute("id"));
        return "user/dashboard";
    }

    @RequestMapping("/user/billing")
    String userBilling(@AuthenticationPrincipal OAuth2User principal, Model model) {
        System.out.println((int) principal.getAttribute("id"));
        System.out.println(principal.getAttributes());
        return "user/billing";
    }

    @RequestMapping("/user/new")
    String newUser(@AuthenticationPrincipal OAuth2User principal, @RequestParam String firstName, @RequestParam String lastName) {
        System.out.println(principal.getAttribute("id") + " | " + firstName + " | " + lastName);
        this.userService.createUser(Utils.intToLong(principal.getAttribute("id")), firstName, lastName);
        return "index";
    }
}
