package edu.drexel.TrainDemo.models.sales;

import javax.persistence.*;

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

    @Column(name = "billing_id")
    private Long billingId;

    @Column(name = "shipping_id")
    private Long shippingId;

    @Column(name = "payment_id")
    private Long paymentId;


    protected Order() {
    }

    public Order(double price, long userId, Long shippingId, Long billingId, Long paymentId){
        this.price = price;
        this.userId = userId;
        this.billingId = billingId;
        this.shippingId = shippingId;
        this.paymentId = paymentId;
    }

    public Long getId() {
         return id;
    }

    // public void setId(Long id) {
    //     this.id = id;
    // }


    public Long getBillingId() {
        return billingId;
    }

    public Long getShippingId() {
        return shippingId;
    }

    public Long getPaymentId() {
        return paymentId;
    }

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