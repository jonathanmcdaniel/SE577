package edu.drexel.TrainDemo.models;

import java.sql.Date;
import java.sql.Time;

public class Path {

    private Stop from;
    private Stop to;
    private Time departureTime;
    private Time arrivalTime;
    private Date departureDate;

    public Path(){
    }

    public Path(Stop from, Stop to, Time departureTime, Time arrivalTime, Date departureDate){
        this.from = from;
        this.to = to;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.departureDate = departureDate;
    }

    public Stop getFrom() {
        return from;
    }

    public void setFrom(Stop from) {
        this.from = from;
    }

    public Stop getTo() {
        return to;
    }

    public void setTo(Stop to) {
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

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    @Override
    public String toString() {
        return "Path{" +
            "from=" + from.getId() +
            ", to=" + to.getId() +
            ", departureTime=" + departureTime +
            ", arrivalTime=" + arrivalTime +
            ", departureDate=" + departureDate +
            "}";
    }
}