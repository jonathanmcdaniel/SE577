package edu.drexel.TrainDemo.models;

import javax.persistence.*;

@Entity
public class Stop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Double lat;
    private Double lon;
    private String externalUrl;

    protected Stop(){
    }

    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public Double getLat(){
        return lat;
    }

    public Double getLon(){
        return lon;
    }
    
    public String getExternalUrl(){
        return externalUrl;
    }

    @Override
    public String toString() {
        return "Stop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lat=" + lat +
                ", lon=" + lon +
                ", externalUrl='" + externalUrl + '\'' +
                '}';
    }

}