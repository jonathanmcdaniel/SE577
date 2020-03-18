/*

package edu.drexel.TrainDemo.services.users;

import java.util.ArrayList;
import java.util.Set;

import edu.drexel.TrainDemo.models.Group;
import edu.drexel.TrainDemo.models.GroupType;
import edu.drexel.TrainDemo.repositories.GroupRepository;

public class GroupServiceImpl implements GroupServices
{

    GroupRepository groupRepository;

    public void GroupServiceImpl(GroupRepository groupRepository)
    {
      this.groupRepository = groupRepository;
    }

    public ArrayList<Group> listGroup(GroupType groupType)
    {
        return groupRepository.findByType(groupType);
    }

    public ArrayList<Group> listGroupByIds(Set<Integer> groupId)
    {
        return groupRepository.findByIds(groupId);
    }

    public ArrayList<Group> listGroupByNames(ArrayList<String> name)
    {
        return groupRepository.findByNames(name);
    }

    public Group findByName(String groupName)
    {
      return groupRepository.findByGroupName(groupName);
    }

} // End of GroupServicesImpl

*/
