package edu.drexel.TrainDemo.models.sales;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import edu.drexel.TrainDemo.models.sales.ticket.Ticket;

@Component
@Scope("session")
public class Cart {

	private List<Ticket> items;

	public Cart(){
		items = new ArrayList<>();
	}


	public List<Ticket> getItems() {
		return items;
	}

	public void addTicket(Ticket ticket){
		items.add(ticket);
	}

	public void removeTicket(Ticket ticket){
		items.remove(ticket);
	}

	@Override
	public String toString(){
		return "Cart{" +
			"items=" + items +
			"}";
	}

}
