package edu.drexel.TrainDemo.models;

import java.util.List;

public class Cart {
	private List<Ticket> cartItems;

	public List<Ticket> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<Ticket> cartItems) {
		this.cartItems = cartItems;
	}

}
