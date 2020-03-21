package edu.drexel.TrainDemo.controllers.users;

import edu.drexel.TrainDemo.Utils;
import edu.drexel.TrainDemo.configuration.LoggerConfiguration;
import edu.drexel.TrainDemo.models.sales.Order;
import edu.drexel.TrainDemo.models.users.Group;
import edu.drexel.TrainDemo.models.users.UserEntity;
import edu.drexel.TrainDemo.services.sales.OrderService;
import edu.drexel.TrainDemo.services.users.GroupService;
import edu.drexel.TrainDemo.services.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AdminController {

    @Autowired
    UserService userService;

    @Autowired
    GroupService groupService;

    @Autowired
    OrderService orderService;

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

    @RequestMapping("admin/removeUser")
    @ResponseBody
    void removeUser(@AuthenticationPrincipal OAuth2User principal, @RequestParam long userId) {
        System.out.println("Removing user with id = " + userId);
        if (Utils.intToLong(principal.getAttribute("id")) != userId) {
            this.userService.removeUser(userId);
        }
    }

    @GetMapping("admin/groups")
    String manageGroups(@AuthenticationPrincipal OAuth2User principal, Model model) {
        UserEntity currentUser = this.userService.getUser(principal);
        if (currentUser != null && this.userService.isAllowedAdminPanel(currentUser)) {
            List<Group> groups = this.groupService.getGroups();
            model.addAttribute("groups", groups);
            Map<Long, Integer> groupMap = new HashMap<>();
            for (Group group : this.groupService.getGroups()) {
                groupMap.put(group.getGroupId(), this.userService.getNumUsersInGroup(group.getGroupId()));
            }
            model.addAttribute("groupMap", groupMap);
            return "admin/groups";
        } else {
            return "admin/access_denied";
        }
    }

    @GetMapping("admin/orders")
    String manageOrders(@AuthenticationPrincipal OAuth2User principal, Model model) {
        UserEntity currentUser = this.userService.getUser(principal);
        if (currentUser != null && this.userService.isAllowedAdminPanel(currentUser)) {
            List<Order> orders = this.orderService.getAllOrders();
            Map<Long, String> userMap = new HashMap<>();
            for (UserEntity user : this.userService.getUsers()) {
                userMap.put(user.getId(), user.getFirstName() + " " + user.getLastName());
            }
            model.addAttribute("orders", orders);
            model.addAttribute("userMap", userMap);
            return "admin/orders";
        } else {
            return "admin/access_denied";
        }
    }
}
