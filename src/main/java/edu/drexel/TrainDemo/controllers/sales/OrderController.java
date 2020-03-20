package edu.drexel.TrainDemo.controllers.sales;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.drexel.TrainDemo.models.sales.Cart;

@Controller
public class OrderController {

	private final Logger logger;

	public OrderController(Logger logger){
		this.logger = logger;
	}

	// @RequestMapping("/orders")
	// public String getOrders(Model model){

	// 	// ...

	// 	return ("orders");
	// }
	
}
