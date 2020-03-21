package edu.drexel.TrainDemo.repositories.users;

import edu.drexel.TrainDemo.models.users.Group;
import edu.drexel.TrainDemo.models.users.GroupType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface GroupRepository extends CrudRepository<Group, String>
{

    List<Group> findAll();
    Group findGroupByGroupId(Long groupId);
//  List<Group> findByNames(String groupName);
//  List<Group> findByType(GroupType groupType);
    Group findByGroupName(String name);
    Group findByGroupType(GroupType type);

} // End of Group Repository
