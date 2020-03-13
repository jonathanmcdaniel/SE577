package edu.drexel.TrainDemo.controllers;

import edu.drexel.TrainDemo.models.Cart;

public class VoucherPaymentController implements PaymentInterface {
	private String voucherCode;
	private int voucherSecuirtyCode;
	
	public boolean processPayment(Cart cart) {
		return true;
	}

	public String getVoucherCode() {
		return voucherCode;
	}

	public void setVoucherCode(String voucherCode) {
		this.voucherCode = voucherCode;
	}

	public int getVoucherSecuirtyCode() {
		return voucherSecuirtyCode;
	}

	public void setVoucherSecuirtyCode(int voucherSecuirtyCode) {
		this.voucherSecuirtyCode = voucherSecuirtyCode;
	}
}
