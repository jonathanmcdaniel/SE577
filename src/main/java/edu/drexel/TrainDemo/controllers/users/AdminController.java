package edu.drexel.TrainDemo.controllers.users;

import edu.drexel.TrainDemo.models.users.Group;
import edu.drexel.TrainDemo.models.users.UserEntity;
import edu.drexel.TrainDemo.services.users.GroupService;
import edu.drexel.TrainDemo.services.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    UserService userService;

    @Autowired
    GroupService groupService;

    @GetMapping("/admin/dashboard")
    String adminDashboard(@AuthenticationPrincipal OAuth2User principal) {
        UserEntity currentUser = this.userService.getUser(principal);
        if (currentUser != null && currentUser.getIsAdmin()) {
            return "admin/dashboard";
        } else {
            return "admin/access_denied";
        }
    }

    @GetMapping("admin/users")
    String manageUsers(@AuthenticationPrincipal OAuth2User principal, Model model) {
        UserEntity currentUser = this.userService.getUser(principal);
        if (currentUser != null && currentUser.getIsAdmin()) {
            List<UserEntity> users = this.userService.getUsers();
            model.addAttribute("users", users);
            return "admin/users";
        } else {
            return "admin/access_denied";
        }
    }

    @GetMapping("admin/groups")
    String manageGroups(@AuthenticationPrincipal OAuth2User principal, Model model) {
        UserEntity currentUser = this.userService.getUser(principal);
        if (currentUser != null && currentUser.getIsAdmin()) {
            List<Group> groups = this.groupService.getGroups();
            model.addAttribute("groups", groups);
            return "admin/groups";
        } else {
            return "admin/access_denied";
        }
    }
}
