package edu.drexel.TrainDemo.models.sales;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import edu.drexel.TrainDemo.models.sales.ticket.Ticket;
import edu.drexel.TrainDemo.models.users.UserEntity;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "price")
    private double price;

    @Column(name = "user_id")
    private Long userId;

    protected Order() {
    }

    public Order(double price, UserEntity user){
        this.price = price;
        this.userId = user.getId();
    }

    public Long getId() {
         return id;
    }

    // public void setId(Long id) {
    //     this.id = id;
    // }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(UserEntity user) {
        this.userId = user.getId();
    }

    @Override
    public String toString(){
        return "Order{" +
            ", id=" + id +
            ", price=" + price +
            ", userId=" + userId +
            "}";
    }
    




}