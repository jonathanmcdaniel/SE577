package edu.drexel.TrainDemo.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_entity")
public class UserEntity implements Serializable {

    static final long serialVersionUID = 42L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "isAdmin")
    private boolean isAdmin;


    public UserEntity(String firstName, String lastName, long clientid) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = clientid;
        this.isAdmin = false;
    }

    public long getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public boolean getIsAdmin() {
        return this.isAdmin;
    }

    /**
     * This function is most likely only used during development and eval for looking at admin panels.
     * @param shouldBeAdmin
     */
    public void setIsAdmin(boolean shouldBeAdmin) {
        this.isAdmin = shouldBeAdmin;
    }

}
