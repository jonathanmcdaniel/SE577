package edu.drexel.TrainDemo.models;

import java.sql.Date;
import java.sql.Time;

public class Path implements Comparable<Path> {

    private Date departureDate;
    private Stop from;
    private Stop to;
    private Time departureTime;
    private Time arrivalTime;

    public Path(){
    }

    public Path(Date departureDate, Stop from, Stop to, Time departureTime, Time arrivalTime){
        this.departureDate = departureDate;
        this.from = from;
        this.to = to;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
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

    @Override
    public String toString() {
        return "Path{" +
            "departureDate=" + departureDate +
            ", from=" + from.getId() +
            ", to=" + to.getId() +
            ", departureTime=" + departureTime +
            ", arrivalTime=" + arrivalTime +
            "}";
    }

    // Compare method for sorting
    @Override
    public int compareTo(Path path){

        // First sort by departure date
        int i = this.getDepartureDate().compareTo(path.getDepartureDate());

        // For paths with the same departure date, sort by departure time
        if (i == 0){
            i = this.getDepartureTime().compareTo(path.getDepartureTime());
        }

        // For paths with the same departure time, sort by arrival time
        if (i == 0){
            i = this.getArrivalTime().compareTo(path.getArrivalTime());
        }
        
        return i;
    }
}