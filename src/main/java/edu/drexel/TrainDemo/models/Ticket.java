package edu.drexel.TrainDemo.models;

import java.util.Date;

public class Ticket {
	private String passenger;
	private TrainStation departureStation;
	private TrainStation arrivalStation;
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
	
	public TrainStation getDepartureStation() {
		return departureStation;
	}
	
	public void setDepartureStation(TrainStation departureStation) {
		this.departureStation = departureStation;
	}
	
	public TrainStation getArrivalStation() {
		return arrivalStation;
	}
	
	public void setArrivalStation(TrainStation arrivalStation) {
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
