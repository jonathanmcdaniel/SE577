package edu.drexel.TrainDemo.controllers.sales;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.drexel.TrainDemo.models.sales.Cart;
import edu.drexel.TrainDemo.models.sales.ticket.Ticket;

@Controller
public class CartController {

    private final Logger logger;

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
}