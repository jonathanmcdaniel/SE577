/*

package edu.drexel.TrainDemo.repositories.users;

import edu.drexel.TrainDemo.models.Group;
import edu.drexel.TrainDemo.models.GroupType;
import edu.drexel.TrainDemo.models.Permissions;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface GroupRepository extends CrudRepository<Group, String>
{

    Group findById(Integer groupId);
    ArrayList<Group> findAll();
    ArrayList<Group> findByPermissions(Permissions permission);
    ArrayList<Group> findByIds(Set<Integer> groupId);
    ArrayList<Group> findByNames(ArrayList<String> groupName);
    ArrayList<Group> findByType(GroupType groupType);
    Group findByGroupName(String name);

}

*/
