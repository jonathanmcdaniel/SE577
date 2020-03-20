package edu.drexel.TrainDemo.models.users;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_entity")
public class UserEntity implements Serializable {

    static final long serialVersionUID = 42L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private String phoneNumber;

    // TODO: Add email only if needed? Would need to update database tables

    @Column(name = "group_id")
    private Long groupId;

    @Column(name = "external_id")
    private Long externalId;

    public UserEntity(){}

    public UserEntity(String firstName, String lastName, String phoneNumber, long clientid) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.externalId = clientid;
        this.groupId = null;
    }

    public UserEntity(String firstName, String lastName, String phoneNumber, long clientid, Long groupId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.externalId = clientid;
        this.groupId = groupId;
    }

    public Long getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getPhoneNumber() { return this.phoneNumber; }

    public Long getGroupId() {
        return this.groupId;
    }

    public Long getExternalId() {
        return this.externalId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String toString() {
        String out = firstName + " " + lastName + " | " + phoneNumber + " | " + externalId;
        return out;
    }

}
