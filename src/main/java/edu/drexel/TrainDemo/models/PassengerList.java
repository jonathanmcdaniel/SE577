package edu.java.TrainDemo.models;

import edu.drexel.TrainDemo.models.Passenger;

import java.util.List;

public class PassengerList extends Passenger {
	private List<Passenger> passengers;
	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}
	
	public List<Passenger> getPassengers(){
		return passengers;
	}	
}
