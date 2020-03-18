package edu.drexel.TrainDemo.models.sales;

import java.util.List;

import edu.drexel.TrainDemo.models.sales.ticket.Ticket;

public class Cart {
	private List<Ticket> cartItems;

	public List<Ticket> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<Ticket> cartItems) {
		this.cartItems = cartItems;
	}

}
