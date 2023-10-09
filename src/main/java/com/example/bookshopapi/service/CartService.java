package com.example.bookshopapi.service;

import com.example.bookshopapi.entity.Cart;
import com.example.bookshopapi.repository.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    @Autowired
    private CartRepo cartRepo;

    public Cart save(Cart cart) {
        return cartRepo.save(cart);
    }

    public Cart findByCustomerId(int customerId){
        return cartRepo.findByCustomerId(customerId);
    }
}
