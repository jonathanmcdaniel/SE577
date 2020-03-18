package edu.drexel.TrainDemo.models.core;

import java.sql.Time;

import javax.persistence.*;

@Entity
@IdClass(StopTimeId.class)
public class StopTime {

    @Id
    @ManyToOne
    private Stop stop;

    @Id
    @ManyToOne
    private Trip trip;

    // @GeneratedValue(strategy = GenerationType.AUTO)
    // private String stopId;
    // private Long tripId;
    private int stopSequence;
    private Time arrivalTime;
    private Time departureTime;
    private int pickupType;
    private int dropoffType;

    protected StopTime(){
    }

    public Stop getStop(){
        return stop;
    }

    public Trip getTrip(){
        return trip;
    }

    public int getStopSequence(){
        return stopSequence;
    }

    public Time getArrivalTime(){
        return arrivalTime;
    }
    
    public Time getDepartureTime(){
        return departureTime;
    }

    public int getPickupType(){
        return pickupType;
    }

    public int getDropoffType(){
        return dropoffType;
    }

    @Override
    public String toString() {
        return "StopTime{" +
                "stopId='" + stop + '\'' +
                ", tripId=" + trip +
                ", stopSequence=" + stopSequence +
                ", arrivalTime=" + arrivalTime +
                ", departureTime=" + departureTime +
                ", dropoffType=" + dropoffType +
                '}';
    }

}