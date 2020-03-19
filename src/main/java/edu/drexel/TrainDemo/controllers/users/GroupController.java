/*package edu.drexel.TrainDemo.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.drexel.TrainDemo.models.Group;
import edu.drexel.TrainDemo.models.GroupType;
import edu.drexel.TrainDemo.repositories.GroupRepository;
import edu.drexel.TrainDemo.Services.GroupService;


@Controller
public class GroupController
{

    private GroupService groupService;

    public GroupController(GroupRepository groupRepository)
    {
        this.groupService = groupService;
    }


    @RequestMapping("/group")
    String search(Model model){
        List<Group> groups = groupRepository.findAll();
        model.addAttribute("groups", groups);

        System.out.println("groups");
        return "groups";
    }

} // End of GroupController
*/
