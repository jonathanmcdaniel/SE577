package edu.drexel.TrainDemo.controllers;

import java.util.Date;

import edu.drexel.TrainDemo.models.Cart;

public class CreditCardPaymentController implements PaymentInterface {
	private double creditCardNumber;
	private Date creditCardExpirationDate;
	private int creditCardSecurityCode;
	private int creditCardBillingZipCode;
	
	public boolean processPayment(Cart cart) {
		return true;
	}

	public double getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(double creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public Date getCreditCardExpirationDate() {
		return creditCardExpirationDate;
	}

	public void setCreditCardExpirationDate(Date creditCardExpirationDate) {
		this.creditCardExpirationDate = creditCardExpirationDate;
	}

	public int getCreditCardSecurityCode() {
		return creditCardSecurityCode;
	}

	public void setCreditCardSecurityCode(int creditCardSecurityCode) {
		this.creditCardSecurityCode = creditCardSecurityCode;
	}

	public int getCreditCardBillingZipCode() {
		return creditCardBillingZipCode;
	}

	public void setCreditCardBillingZipCode(int creditCardBillingZipCode) {
		this.creditCardBillingZipCode = creditCardBillingZipCode;
	}

}
