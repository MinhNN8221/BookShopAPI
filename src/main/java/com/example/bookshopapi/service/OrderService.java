package com.example.bookshopapi.service;

import com.example.bookshopapi.entity.Order;
import com.example.bookshopapi.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepo orderRepo;

    public Order save(Order order) {
        return orderRepo.save(order);
    }

    public List<Order> getAllByCustomerId(int customerId){
        return orderRepo.getAllByCustomerId(customerId);
    }
    public Order getOrderById(int orderId){
        return orderRepo.getOrderById(orderId);
    }

    public List<Order> getOrderByOrderStatus(int orderStatus){
        return orderRepo.getAllByOrderStatusId(orderStatus);
    }
}
