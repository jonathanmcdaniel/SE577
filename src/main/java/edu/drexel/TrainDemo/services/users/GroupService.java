package edu.drexel.TrainDemo.services.users;

import java.util.List;
import java.util.Set;

import edu.drexel.TrainDemo.models.users.Group;
import edu.drexel.TrainDemo.models.users.GroupType;

public interface GroupService
{

	public List<Group> getGroups();

//	List<Group> listGroup(GroupType groupType);

//	List<Group> listGroupByNames(List<String> names);

	Group findByName(String groupName);

//	Group createGroup(Integer groupId, String groupName, GroupType groupType);

} // End of GroupServices.
