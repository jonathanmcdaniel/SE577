package edu.drexel.TrainDemo.models.sales.ticket;

import java.util.Date;

import edu.drexel.TrainDemo.models.core.Stop;

public class Ticket {
	private String passenger;
	private Stop departureStation;
	private Stop arrivalStation;
	private Date departureTime;
	private Date arrivalTime;
	private String trainName;
	private int classType;
	private double price;
	
	public String getPassenger() {
		return passenger;
	}
	
	public void setPassenger(String passenger) {
		this.passenger = passenger;
	}
	
	public Stop getDepartureStation() {
		return departureStation;
	}
	
	public void setDepartureStation(Stop departureStation) {
		this.departureStation = departureStation;
	}
	
	public Stop getArrivalStation() {
		return arrivalStation;
	}
	
	public void setArrivalStation(Stop arrivalStation) {
		this.arrivalStation = arrivalStation;
	}
	
	public Date getDepartureTime() {
		return departureTime;
	}
	
	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}
	
	public Date getArrivalTime() {
		return arrivalTime;
	}
	
	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	
	public String getTrainName() {
		return trainName;
	}
	
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	
	public int getClassType() {
		return classType;
	}
	
	public void setClassType(int classType) {
		this.classType = classType;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}


}
