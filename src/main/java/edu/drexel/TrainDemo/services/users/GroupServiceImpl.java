package edu.drexel.TrainDemo.services.users;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import edu.drexel.TrainDemo.models.users.Group;
import edu.drexel.TrainDemo.models.users.GroupType;
import edu.drexel.TrainDemo.repositories.users.GroupRepository;
import org.springframework.stereotype.Service;

@Service
public class GroupServiceImpl implements GroupService
{

    @Autowired
    private Logger logger;

    @Autowired
    GroupRepository groupRepository;

    @Override
    public List<Group> getGroups()
    {
        List<Group> allGroups = new ArrayList<>();
        this.groupRepository.findAll().forEach(allGroups::add);
        return allGroups;
    }

//    public List<Group> listGroup(GroupType groupType)
//    {
//       return groupRepository.findByType(groupType);
//    }

//    public List<Group> listGroupByIds(Set<Integer> groupId)
//    {
//        return groupRepository.findByIds(groupId);
//    }

//    public List<Group> listGroupByNames(List<String> name)
//    {
//        return groupRepository.findByNames(name);
//    }

    public String findNameById(Long groupid) {
        Group group = this.groupRepository.findGroupByGroupId(groupid);
        return group.getGroupName();
    }

    public Group findByName(String groupName)
    {
      return groupRepository.findByGroupName(groupName);
    }

    @Override
    public void createGroup(String groupName, GroupType groupType) {
        Group newGroup = new Group(groupName, groupType);
        System.out.println("createGroup: " + newGroup.getGroupId() + " | " + newGroup.getGroupName() + " | " + newGroup.getGroupType());
        this.groupRepository.save(newGroup);
    }

    @Override
    public Long findGroupIdByType(GroupType type) {
        Group group = this.groupRepository.findByGroupType(type);
        return group.getGroupId();
    }



} // End of GroupServicesImpl.
