package edu.drexel.TrainDemo.controllers.sales;

import java.util.List;

import javax.servlet.http.HttpSession;

import edu.drexel.TrainDemo.Utils;
import edu.drexel.TrainDemo.models.sales.Order;
import edu.drexel.TrainDemo.models.users.Address;
import edu.drexel.TrainDemo.services.sales.OrderService;
import edu.drexel.TrainDemo.services.sales.PaymentService;
import edu.drexel.TrainDemo.services.users.UserService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import edu.drexel.TrainDemo.models.sales.Cart;
import edu.drexel.TrainDemo.models.sales.ticket.Ticket;

@Controller
public class CartController {

    private final Logger logger;

    @Autowired
    UserService userService;

    @Autowired
    OrderService orderService;

    @Autowired
    PaymentService paymentService;

    public CartController(Logger logger){
        this.logger = logger;
    }

    public Cart getCart(HttpSession session){
        Cart cart = (Cart) session.getAttribute("Cart");

        if (cart == null){
            cart = new Cart();
            logger.info("Creating new cart");
        }

        return cart;
    }

    @RequestMapping("/cart")
    public String viewCart(HttpSession session, Model model){
        Cart cart = getCart(session);
        List<Ticket> items = cart.getItems();
        model.addAttribute("cart", cart);
        model.addAttribute("items", items);
        model.addAttribute("cartTotal", cart.getTotal());
        // ...

        return("cart");
    }

    @PostMapping("/cart/add")
    public String addToCart(HttpSession session, @ModelAttribute Ticket ticket){

        Cart cart = getCart(session);
        logger.info("Found cart");
        logger.info(cart.toString());

        cart.addTicket(ticket);
        session.setAttribute("Cart", cart);

        return "redirect:/cart";
    }

    @PostMapping("/cart/remove")
    public String removeFromCart(HttpSession session, @ModelAttribute Ticket ticket){

        System.out.println(ticket.toString());

        Cart cart = getCart(session);
        logger.info("Found cart");
        logger.info(cart.toString());

        cart.findAndRemoveTicket(ticket);

        logger.info(cart.toString());
        session.setAttribute("Cart", cart);

        return "redirect:/cart";
    }

    @RequestMapping("/cart/checkout")
    public String checkout(@AuthenticationPrincipal OAuth2User principal, HttpSession session, Model model) {
        Cart cart = getCart(session);
        List<Address> billingAddresses = this.userService.getBillingAddresses(principal);
        List<Address> shippingAddresses = this.userService.getShippingAddresses(principal);

        model.addAttribute("cart", cart);
        model.addAttribute("billingAddresses", billingAddresses);
        model.addAttribute("shippingAddresses", shippingAddresses);
        model.addAttribute("cards", this.paymentService.getCreditCards(Utils.intToLong(principal.getAttribute("id"))));
        model.addAttribute("cartTotal", cart.getTotal());

        return "cart/checkout";
    }

    @RequestMapping("/cart/complete")
    @ResponseBody
    public String completeOrder(@AuthenticationPrincipal OAuth2User principal, HttpSession session, @RequestParam Long shippingId, @RequestParam Long billingId, @RequestParam Long paymentId) {
        System.out.println("Completing order: " + shippingId + " | " + billingId + " | " + paymentId);
        Cart cart = getCart(session);
        Order finalOrder = new Order(cart.getTotal(), this.userService.getUser(principal).getId(), billingId, shippingId, paymentId);
        this.orderService.addOrder(finalOrder);
        return ("Order " + finalOrder.getId() + " Was Successful!");
    }
}