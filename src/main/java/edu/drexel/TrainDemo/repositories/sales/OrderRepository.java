package edu.drexel.TrainDemo.repositories.sales;

import org.springframework.data.repository.CrudRepository;

import edu.drexel.TrainDemo.models.sales.Order;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {

    Order getOrderById(Long id);
    List<Order> getOrdersByUserId(Long userid);
}
