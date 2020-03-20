package edu.drexel.TrainDemo.models.sales.ticket;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

// @Entity
public class Ticket {

    // @Id
    // @GeneratedValue(strategy=GenerationType.AUTO)
    // private long id;

    // @ManyToOne
    // private Order order;

    private Date departureDate;

    // @Column(name="fromStop")
    private String from;

    // @Column(name="toStop")
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

	public boolean isEqual(Ticket ticket) {
        boolean sameTicket = (this.departureDate.equals(ticket.departureDate)) && (this.departureTime.equals(ticket.departureTime)) &&
                (this.arrivalTime.equals(ticket.arrivalTime)) && (this.from.equals(ticket.from)) && (this.to.equals(ticket.to));
        return sameTicket;
    }

	@Override
    public String toString() {
        return "Ticket{" +
        // "id=" + id +
        // ", order=" + order.getId() +
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
