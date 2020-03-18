package edu.drexel.TrainDemo.controllers.sales;

import edu.drexel.TrainDemo.models.sales.Cart;

public class OrderController {
	private String customerEmail;
	private String customerPhone;
	private String customerName;
	
	public void processOrder(Cart cart) {
		
	}
	
	public void sendConfirmationEmail() {
		
	}
	
	public String getCustomerEmail() {
		return customerEmail;
	}
	
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	
	public String getCustomerPhone() {
		return customerPhone;
	}
	
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
}
