package edu.drexel.TrainDemo.models.core;

import javax.persistence.*;

@Entity
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long routeId;
    private Long calendarId;
    private String headsign;
    private Boolean direction;

    protected Trip(){
    }

    public Long getId(){
        return id;
    }

    public Long getRouteId(){
        return routeId;
    }

    public Long getCalendarId(){
        return calendarId;
    }

    public String getHeadsign(){
        return headsign;
    }

    public Boolean getDirection(){
        return direction;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", routeId=" + routeId +
                ", calendarId=" + calendarId +
                ", headsign='" + headsign + '\'' +
                ", direction=" + direction +
                '}';
    }

}



