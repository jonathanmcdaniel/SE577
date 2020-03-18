package edu.drexel.TrainDemo.controllers.sales;

import edu.drexel.TrainDemo.models.sales.Cart;

public interface PaymentInterface {
	
	public boolean processPayment(Cart cart);

}
