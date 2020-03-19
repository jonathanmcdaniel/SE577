package edu.drexel.TrainDemo.controllers.users;

import edu.drexel.TrainDemo.models.users.GroupType;
import edu.drexel.TrainDemo.services.users.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class GroupController
{

    @Autowired
    private GroupService groupService;


    /*@RequestMapping("/group")
    String search(Model model){
        List<Group> groups = groupRepository.findAll();
        model.addAttribute("groups", groups);

        System.out.println("groups");
        return "groups";
    }*/

    @RequestMapping("group/new")
    @ResponseBody
    void newGroup(@RequestParam String groupName, @RequestParam String groupType) {
        System.out.println("newGroup: " + groupName + " | " + groupType);
        this.groupService.createGroup(groupName, GroupType.valueOf(groupType));
    }


} // End of GroupController
