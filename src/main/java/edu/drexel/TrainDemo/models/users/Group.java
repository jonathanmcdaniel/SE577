package edu.drexel.TrainDemo.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import edu.drexel.TrainDemo.models.GroupType;

@Entity
public class Group
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String groupName;
    private Integer groupId;
    private GroupType groupType;

    protected Group()
    {

    }

    public Group(String groupName, GroupType groupType, Integer groupId)
    {
        this.groupName = groupName;
        this.groupType = groupType;
        this.groupId = groupId;
    }

    public String getGroupName()
    {
        return groupName;
    }

    public GroupType getGroupType()
    {
        return groupType;
    }

    public Integer getGroupId()
    {
        return groupId;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + groupId +
                ", name='" + groupName +
                ", type='" + groupType +'\'' +
                '}';
    }

} // End of Group.
