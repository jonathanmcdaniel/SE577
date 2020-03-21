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

	String findNameById(Long groupid);

	Group findByName(String groupName);

	void createGroup(String groupName, GroupType groupType);

	Long findGroupIdByType(GroupType type);

} // End of GroupServices.
