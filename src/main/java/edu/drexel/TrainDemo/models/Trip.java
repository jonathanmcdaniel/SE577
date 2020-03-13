package edu.drexel.TrainDemo.models;

import javax.swing.plaf.basic.BasicTreeUI;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class Route {
    private TrainStation departureStation;
    private TrainStation arrivalStation;
    private Time departureTime;
    private Time arrivalTime;
    private Train train;
    private double price;
    private ArrayList<Passenger> passengers;

    public TrainStation getDepartureStation(){
        return departureStation;
    }

    public TrainStation getArrivalStation(){
        return arrivalStation;
    }

    public Date getDepartureTime(){
        return departureTime;
    }

    public Date getArrivalTime(){
        return arrivalTime;
    }

    public Train getTrain(){
        return train;
    }

    public double getPrice(){
        return price;
    }

    public Passenger getPassenger(int index){
        passengers.get(index);
    }

    public ArrayList<Passenger> getPassengers(){
        return passengers;
    }

}



