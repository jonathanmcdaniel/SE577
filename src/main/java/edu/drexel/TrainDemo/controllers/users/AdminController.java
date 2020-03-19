package edu.drexel.TrainDemo.controllers.users;

import edu.drexel.TrainDemo.models.users.UserEntity;
import edu.drexel.TrainDemo.services.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class AdminController {

    @Autowired
    UserService userService;

    @GetMapping("/admin/dashboard")
    String adminDashboard(@AuthenticationPrincipal OAuth2User principal) {
        UserEntity currentUser = this.userService.getUser(principal);
        if (currentUser != null && currentUser.getIsAdmin()) {
            return "admin/dashboard";
        } else {
            return "admin/access_denied";
        }
    }
}
