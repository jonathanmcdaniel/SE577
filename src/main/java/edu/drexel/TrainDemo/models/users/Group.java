package edu.drexel.TrainDemo.models.users;

import javax.persistence.*;


@Entity
@Table(name = "groups")
public class Group
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long groupId;

    @Column(name = "group_name")
    private String groupName;

    @Enumerated(EnumType.STRING)
    @Column(name = "group_type", length = 8)
    private GroupType groupType;

    protected Group()
    {

    }

    public Group(String groupName, GroupType groupType)
    {
        this.groupName = groupName;
        this.groupType = groupType;
    }

    public String getGroupName()
    {
        return groupName;
    }

    public GroupType getGroupType()
    {
        return groupType;
    }

    public Long getGroupId()
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
