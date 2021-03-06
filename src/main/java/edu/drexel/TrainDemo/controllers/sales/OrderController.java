package edu.drexel.TrainDemo.controllers.sales;

import edu.drexel.TrainDemo.models.sales.Order;
import edu.drexel.TrainDemo.models.users.UserEntity;
import edu.drexel.TrainDemo.services.sales.OrderService;
import edu.drexel.TrainDemo.services.users.UserService;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.drexel.TrainDemo.models.sales.Cart;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OrderController {

	private final Logger logger;

	@Autowired
	OrderService orderService;

	@Autowired
	UserService userService;

	public OrderController(Logger logger){
		this.logger = logger;
	}

	@RequestMapping("order/remove")
	@ResponseBody
	public void removeOrder(@RequestParam long orderId) {
		System.out.println("Removing order " + orderId);
		Order orderToRemove = this.orderService.getOrder(orderId);
		this.orderService.removeOrder(orderToRemove);
	}

	@RequestMapping("order/update")
	@ResponseBody
	public void updateOrder(@RequestParam long orderId, @RequestParam double price) {
		System.out.println("updating order " + orderId);
		this.orderService.updateOrderPrice(orderId, price);
	}


	@RequestMapping("/user/orders")
	public String getOrders(@AuthenticationPrincipal OAuth2User principal, Model model){

		UserEntity user = userService.getUser(principal);
		List<Order> orders = orderService.getAllOrders();

		model.addAttribute("orders", orders);

		return ("user/orders");
	}
	
	
}
