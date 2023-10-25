package com.example.bookshopapi.service;

import com.example.bookshopapi.entity.OrderStatus;
import com.example.bookshopapi.repository.OrderStatusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderStatusService {
    @Autowired
    private OrderStatusRepo orderStatusRepo;

    public OrderStatus findById(int orderStatusId) {
        return orderStatusRepo.findById(orderStatusId);
    }
}
