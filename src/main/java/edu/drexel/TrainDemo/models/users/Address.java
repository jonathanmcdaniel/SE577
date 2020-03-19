package edu.drexel.TrainDemo.models.users;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "address")
public class Address implements Serializable {

    static final long serialVersionUID = 42L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "line1")
    private String line1;

    @Column(name = "line2")
    private String line2;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "zip")
    private String zip;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "is_billing")
    private Boolean isBilling;

    public Address(){}

    public Address(String name, String line1, String line2, String city, String state, String zip, Long userId, Boolean isBilling) {
        this.name = name;
        this.line1 = line1;
        this.line2 = line2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.userId = userId;
        this.isBilling = isBilling;
    }

    public Address(List<String> params, Long userId, Boolean isBilling) {
        this.name = params.get(0);
        this.line1 = params.get(1);
        this.line2 = params.get(2);
        this.city = params.get(3);
        this.state = params.get(4);
        this.zip = params.get(5);
        this.userId = userId;
        this.isBilling = isBilling;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLine1() {
        return line1;
    }

    public String getLine2() {
        return line2;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public Long getUserId() {
        return userId;
    }

    public Boolean getIsBilling() {
        return isBilling;
    }
}
