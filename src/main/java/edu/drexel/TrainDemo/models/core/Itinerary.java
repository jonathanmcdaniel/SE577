package edu.drexel.TrainDemo.models.core;

import java.util.ArrayList;

import edu.drexel.TrainDemo.models.core.Route;


public class Itinerary{
    private ArrayList<Route> itinerarySequence;
    private double price;
    
    public void addTrip(Route trip){
        // Add Trip
    }

    public void deleteTrip(Route trip){
        // Delete Trip
    }

    public Route getTrip(int index){
        return itinerarySequence.get(index);
    }

    public double getPrice(){
        return price;
    }
} 