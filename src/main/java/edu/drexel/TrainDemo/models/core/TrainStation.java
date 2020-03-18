package edu.drexel.TrainDemo.models.core;

import edu.drexel.TrainDemo.models.core.State;

public class TrainStation {

    private String name;
    private String abbrName;
    private String address;
    private String city;
    private State state;
    private String zip;


    public String getName(){
        return name;
    }

    public String getAbbrName(){
        return abbrName;
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

}