package com.example.bookshopapi.service;

import com.example.bookshopapi.entity.Book;
import com.example.bookshopapi.entity.CartItem;
import com.example.bookshopapi.entity.Order;
import com.example.bookshopapi.entity.OrderDetail;
import com.example.bookshopapi.repository.OrderDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService {
    @Autowired
    private OrderDetailRepo orderDetailRepo;
    @Autowired
    private ProductService productService;

    public void save(Order order, List<CartItem> cartItems) {
        for (CartItem cartItem : cartItems) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrder(order);
            orderDetail.setBook(cartItem.getBook());
            orderDetail.setBookName(cartItem.getBook().getName());
            orderDetail.setUniCost(cartItem.getBook().getDiscounted_price());
            orderDetail.setQuantity(cartItem.getQuantity());
            orderDetailRepo.save(orderDetail);
        }
    }

    public List<OrderDetail> getAllByCustomerId(int customerId){
        return orderDetailRepo.getAllByOrderCustomerId(customerId);
    }
    public List<OrderDetail> getAllByOrderId(int orderId){
        return orderDetailRepo.getAllByOrderId(orderId);
    }
}
