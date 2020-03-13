package edu.drexel.TrainDemo.models;

import java.sql.Time;

import javax.persistence.*;

@Entity
public class StopTime {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String stopId;
    private Long tripId;
    private int stopSequence;
    private Time arrivalTime;
    private Time departureTime;
    private int pickupType;
    private int dropoffType;

    protected StopTime(){
    }

    public String getStopId(){
        return stopId;
    }

    public Long getTripId(){
        return tripId;
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
                "stopId='" + stopId + '\'' +
                ", tripId=" + tripId +
                ", stopSequence=" + stopSequence
                ", arrivalTime=" + arrivalTime +
                ", departureTime=" + departureTime +
                ", dropoffType=" + dropoffType +
                '}';
    }

}