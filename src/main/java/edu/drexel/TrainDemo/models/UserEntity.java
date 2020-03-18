package edu.drexel.TrainDemo.models;

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

    @Column(name = "is_admin")
    private Boolean isAdmin;

    @Column(name = "external_id")
    private Long externalId;

    public UserEntity(){}

    public UserEntity(String firstName, String lastName, long clientid) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.externalId = clientid;
        this.isAdmin = false;
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

    public boolean getIsAdmin() {
        return this.isAdmin;
    }

    public Long getExternalId() {
        return this.externalId;
    }

    /**
     * This function is most likely only used during development and eval for looking at admin panels.
     * @param shouldBeAdmin
     */
    public void setIsAdmin(Boolean shouldBeAdmin) {
        this.isAdmin = shouldBeAdmin;
    }

}
