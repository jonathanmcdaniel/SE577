package edu.drexel.TrainDemo.controllers;

import edu.drexel.TrainDemo.models.Cart;

public interface PaymentInterface {
	
	public boolean processPayment(Cart cart);

}
