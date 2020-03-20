package edu.drexel.TrainDemo.models.sales;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import edu.drexel.TrainDemo.models.sales.ticket.Ticket;
import edu.drexel.TrainDemo.models.users.UserEntity;

// @Entity
public class Order {

    // @Id
    // @GeneratedValue(strategy=GenerationType.AUTO)
    // private Long id;
    private double price;
    private UserEntity user;

    protected Order() {
    }

    public Order(double price, UserEntity user){
        this.price = price;
        this.user = user;
    }

    // public Long getId() {
    //     return id;
    // }

    // public void setId(Long id) {
    //     this.id = id;
    // }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    @Override
    public String toString(){
        return "Order{" +
            // ", id=" + id +
            ", price=" + price +
            ", user=" + user +
            "}";
    }
    




}