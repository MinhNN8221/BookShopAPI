package com.example.bookshopapi.repository;

import com.example.bookshopapi.entity.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderStatusRepo extends JpaRepository<OrderStatus, Integer> {
    OrderStatus findById(int orderStatusId);
}
