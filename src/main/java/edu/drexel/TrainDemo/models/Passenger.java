package edu.drexel.TrainDemo.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Passenger{
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    private String firstName;
    private String lastName;
    private Date dob;
    private String address;
    private String city;
    private State state;
    private String zip;
    private String phone;
    private String emailAddress;
    
    public Long getId() {
    	return id;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public Date getDob(){
        return dob;
    }

    public String getAddress(){
        return address;
    }

    public String getCity(){
        return city;
    }

    public State getState(){
        return state;
    }

    public String getZip(){
        return zip;
    }

    public String getPhone(){
        return phone;
    }

    public String getEmailAddress(){
        return emailAddress;
    }
    
    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", firstname='" + firstName + '\'' +
                '}';
    }

}