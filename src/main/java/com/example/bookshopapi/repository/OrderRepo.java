package com.example.bookshopapi.repository;

import com.example.bookshopapi.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order, Integer> {
    Order save(Order order);

    List<Order> getAllByCustomerId(int customerId);

    Order getOrderById(int orderId);

    List<Order> getAllByOrderStatusId(int orderStatusId);
}
