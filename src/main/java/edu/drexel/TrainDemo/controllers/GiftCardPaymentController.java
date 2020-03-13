package edu.drexel.TrainDemo.controllers;

import java.util.Date;

import edu.drexel.TrainDemo.models.Cart;

public class GiftCardPaymentController implements PaymentInterface {
	private double giftCardNumber;
	private Date giftCardExpirationDate;
	private int giftCardSecurityCode;
	
	public boolean processPayment(Cart cart) {
		return true;
	}

	public double getGiftCardNumber() {
		return giftCardNumber;
	}

	public void setGiftCardNumber(double giftCardNumber) {
		this.giftCardNumber = giftCardNumber;
	}

	public Date getGiftCardExpirationDate() {
		return giftCardExpirationDate;
	}

	public void setGiftCardExpirationDate(Date giftCardExpirationDate) {
		this.giftCardExpirationDate = giftCardExpirationDate;
	}

	public int getGiftCardSecurityCode() {
		return giftCardSecurityCode;
	}

	public void setGiftCardSecurityCode(int giftCardSecurityCode) {
		this.giftCardSecurityCode = giftCardSecurityCode;
	}

}
