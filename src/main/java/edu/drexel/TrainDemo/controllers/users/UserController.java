package edu.drexel.TrainDemo.controllers.users;

import edu.drexel.TrainDemo.models.users.Address;
import edu.drexel.TrainDemo.models.users.GroupType;
import edu.drexel.TrainDemo.services.users.GroupService;
import edu.drexel.TrainDemo.services.users.UserService;
import edu.drexel.TrainDemo.Utils;
import edu.drexel.TrainDemo.models.users.UserEntity;
import edu.drexel.TrainDemo.models.core.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    GroupService groupService;

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
        UserEntity currentUser = this.userService.getUser(Utils.intToLong(principal.getAttribute("id")));
        String groupName = this.groupService.findNameById(currentUser.getGroupId());
        model.addAttribute("firstName", currentUser.getFirstName());
        model.addAttribute("lastName", currentUser.getLastName());
        model.addAttribute("phoneNumber", currentUser.getPhoneNumber());
        model.addAttribute("groupName", groupName);
        return "user/dashboard";
    }

    @RequestMapping("/user/addresses")
    String userAddresses(@AuthenticationPrincipal OAuth2User principal, Model model, @RequestParam String addressType) {
        List<Address> addresses;
        if (addressType.equals("Billing")) {
            addresses = this.userService.getBillingAddresses(principal);
        } else {
            addresses = this.userService.getShippingAddresses(principal);
        }
        model.addAttribute("addresses", addresses);
        model.addAttribute("label", addressType);
        model.addAttribute("states", State.values());
        System.out.println(State.values());
        return "user/addresses";
    }

    @RequestMapping("/user/new")
    RedirectView newUser(@AuthenticationPrincipal OAuth2User principal, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String phoneNumber) {
        System.out.println(principal.getAttribute("id") + " | " + firstName + " | " + lastName);

        /**
         * This is only for evaluation purposes! We are making the initial user an admin...
         */
        Long groupId = this.groupService.findGroupIdByType(GroupType.ADMIN);
        this.userService.createUser(Utils.intToLong(principal.getAttribute("id")), firstName, lastName, phoneNumber, groupId);
        return new RedirectView("/");
    }

    @RequestMapping("/user/save")
    @ResponseBody
    void saveUser(@AuthenticationPrincipal OAuth2User principal, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String phoneNumber) {
        this.userService.saveUser(principal, new UserEntity(firstName, lastName, phoneNumber, Utils.intToLong(principal.getAttribute("id"))));
    }

    @RequestMapping(value = "/user/newAddress", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    void newAddress(@AuthenticationPrincipal OAuth2User principal, @RequestParam(value = "params[]") String[] params, @RequestParam(value = "isBilling") Boolean isBilling) {
        Address address = new Address(Arrays.asList(params), Utils.intToLong(principal.getAttribute("id")), isBilling);
        this.userService.saveAddress(principal, address);
        System.out.println("GOT HERE");
        //return new RedirectView("/user/dashboard");
    }

    @RequestMapping("user/deleteAddress")
    @ResponseBody
    void deleteAddress(@AuthenticationPrincipal OAuth2User principal, @RequestParam(value = "params[]") String[] params) {
        this.userService.deleteAddress(Arrays.asList(params), Utils.intToLong(principal.getAttribute("id")));
        //return new RedirectView("/user/dashbard");
    }
}
