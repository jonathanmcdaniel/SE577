package edu.drexel.TrainDemo.services.sales;

import edu.drexel.TrainDemo.models.sales.Order;
import edu.drexel.TrainDemo.models.users.UserEntity;
import edu.drexel.TrainDemo.repositories.sales.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    public void addOrder(Order order) {
        this.orderRepository.save(order);
    }

    public Order getOrder(Long orderid) {
        return this.orderRepository.getOrderById(orderid);
    }

    public List<Order> getUserOrders(UserEntity userEntity) {
        return this.orderRepository.getOrdersByUserId(userEntity.getId());
    }

    public List<Order> getAllOrders() {
        List<Order> allOrders = new ArrayList<>();
        this.orderRepository.findAll().forEach(allOrders::add);
        return allOrders;
    }

    public void removeOrder(Order order) {
        this.orderRepository.delete(order);
    }

    public void updateOrderPrice(long orderId, double price) {
        Order orderToUpdate = this.getOrder(orderId);
        orderToUpdate.setPrice(price);
        this.orderRepository.save(orderToUpdate);
    }

}
