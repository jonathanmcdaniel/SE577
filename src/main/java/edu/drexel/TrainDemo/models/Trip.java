package edu.drexel.TrainDemo.models;

public class Route {
    private TrainStation depatureStation;
    private TrainStation arrivalStation;
    private DateTime departureTime;
    private DateTime arrivalTime;
    private Train train;
    private double price;
    private ArrayList<Passenger> passengers;

    public getDepartureStation(){
        return departureStation;
    }

    public getArrivalStation(){
        return arrivalStation;
    }

    public getDepartureTime(){
        return departureTime;
    }

    public getArrivalTime(){
        return arrivalTime;
    }

    public getTrain(){
        return train;
    }

    public getPrice(){
        return Price;
    }

    public getPassenger(int index){
        passengers.get(index);
    }

    public getPassengers(){
        return passengers;
    }

}



