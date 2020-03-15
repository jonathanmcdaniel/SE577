package edu.drexel.TrainDemo.models;

import java.io.Serializable;

public class StopTimeId implements Serializable {
    
    static final long serialVersionUID = 42L; 
    
    private Stop stop;
    private Trip trip;

    // protected StopTimeId(){
    // }

    // public StopTimeId(Stop stop, Trip trip){
    //     this.stop = stop;
    //     this.trip = trip;
    // }

    public Stop getStop(){
        return stop;
    }

    public Trip getTrip(){
        return trip;
    }

    // equals(){

    // }

    // hashCode(){

    // }


}