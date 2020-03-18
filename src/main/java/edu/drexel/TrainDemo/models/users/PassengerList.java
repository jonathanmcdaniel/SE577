package edu.drexel.TrainDemo.models.users;

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
