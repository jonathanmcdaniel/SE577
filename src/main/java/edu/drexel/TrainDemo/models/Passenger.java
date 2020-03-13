package edu.drexel.TrainDemo.models;

import java.util.Date;

public class Passenger{
    private String firstName;
    private String lastName;
    private Date dob;
    private String address;
    private String city;
    private State state;
    private String zip;
    private String phoneNo;
    private String emailAddress;

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

    public String getPhoneNo(){
        return phoneNo;
    }

    public String getEmailAddress(){
        return emailAddress;
    }

}