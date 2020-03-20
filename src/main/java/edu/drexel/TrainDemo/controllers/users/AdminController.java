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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
        if (currentUser != null && this.userService.isAllowedAdminPanel(currentUser)) {
            return "admin/dashboard";
        } else {
            return "admin/access_denied";
        }
    }

    @GetMapping("admin/users")
    String manageUsers(@AuthenticationPrincipal OAuth2User principal, Model model) {
        UserEntity currentUser = this.userService.getUser(principal);
        if (currentUser != null && this.userService.isAllowedAdminPanel(currentUser)) {
            List<UserEntity> users = this.userService.getUsers();
            model.addAttribute("users", users);
            model.addAttribute("groups", this.groupService.getGroups());
            return "admin/users";
        } else {
            return "admin/access_denied";
        }
    }

    @RequestMapping("admin/saveUser")
    @ResponseBody
    void saveUser(@RequestParam long userExternalId, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String phoneNumber, @RequestParam Long groupId) {
        UserEntity oldUser = this.userService.getUser(userExternalId);
        UserEntity newUser = new UserEntity(firstName, lastName, phoneNumber, userExternalId, groupId);
        this.userService.saveUser(oldUser, newUser);
    }

    @GetMapping("admin/groups")
    String manageGroups(@AuthenticationPrincipal OAuth2User principal, Model model) {
        UserEntity currentUser = this.userService.getUser(principal);
        if (currentUser != null && this.userService.isAllowedAdminPanel(currentUser)) {
            List<Group> groups = this.groupService.getGroups();
            model.addAttribute("groups", groups);
            return "admin/groups";
        } else {
            return "admin/access_denied";
        }
    }
}
