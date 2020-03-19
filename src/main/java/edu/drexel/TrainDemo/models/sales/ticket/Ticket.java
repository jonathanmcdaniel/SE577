package edu.drexel.TrainDemo.models.sales.ticket;

import java.sql.Date;
import java.sql.Time;

public class Ticket {

    private Date departureDate;
    private String from;
    private String to;
    private Time departureTime;
    private Time arrivalTime;
	private double price;

    public Ticket(){
    }
    
    public Ticket(Date departureDate, String from, String to, Time departureTime, Time arrivalTime, double price){
        this.departureDate = departureDate;
        this.from = from;
        this.to = to;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.price = price;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }
    
    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }

    public Time getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Time arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
    public String toString() {
        return "Ticket{" +
            "departureDate=" + departureDate +
            ", from=" + from +
            ", to=" + to +
            ", departureTime=" + departureTime +
			", arrivalTime=" + arrivalTime +
			", price=" + price +
            "}";
    }

	// DEPRECATED MODEL:
    // private Date departureDate;
    // private Stop from;
    // private Stop to;
    // private Time departureTime;
	// private Time arrivalTime;
	
    // public Date getDepartureDate() {
    //     return departureDate;
    // }

    // public void setDepartureDate(Date departureDate) {
    //     this.departureDate = departureDate;
    // }
    
    // public Stop getFrom() {
    //     return from;
    // }

    // public void setFrom(Stop from) {
    //     this.from = from;
    // }

    // public Stop getTo() {
    //     return to;
    // }

    // public void setTo(Stop to) {
    //     this.to = to;
    // }

    // public Time getDepartureTime() {
    //     return departureTime;
    // }

    // public void setDepartureTime(Time departureTime) {
    //     this.departureTime = departureTime;
    // }

    // public Time getArrivalTime() {
    //     return arrivalTime;
	// }


}
