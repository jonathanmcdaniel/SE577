package edu.drexel.TrainDemo.models.sales;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "credit_card")
public class CreditCard {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "name")
    private String name;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "exp_month")
    private String cardExpMonth;

    @Column(name = "exp_year")
    private String cardExpYear;

    @Column(name = "cvv")
    private String cvv;

    public CreditCard(){}

    public CreditCard(Long userId, String name, String cardNumber, String cardExpMonth, String cardExpYear, String cvv) {
        this.name = name;
        this.userId = userId;
        this.cardNumber = cardNumber;
        this.cardExpMonth = cardExpMonth;
        this.cardExpYear = cardExpYear;
        this.cvv = cvv;
    }

    public CreditCard(Long userId, List<String> params) {
        this.userId = userId;
        this.name = params.get(0);
        this.cardNumber = params.get(1);
        this.cardExpMonth = params.get(2);
        this.cardExpYear = params.get(3);
        this.cvv = params.get(4);
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardExpMonth() {
        return cardExpMonth;
    }

    public String getCardExpYear() {
        return cardExpYear;
    }

    public String getCvv() {
        return cvv;
    }
}
