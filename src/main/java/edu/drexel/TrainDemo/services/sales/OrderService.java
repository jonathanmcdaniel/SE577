package edu.drexel.TrainDemo.services.sales;

import edu.drexel.TrainDemo.models.sales.Order;
import edu.drexel.TrainDemo.models.users.UserEntity;

import java.util.List;

public interface OrderService {

    void addOrder(Order order);
    Order getOrder(Long orderid);
    List<Order> getUserOrders(UserEntity userEntity);
    List<Order> getAllOrders();
    void removeOrder(Order order);
    void updateOrderPrice(long orderId, double price);
}

