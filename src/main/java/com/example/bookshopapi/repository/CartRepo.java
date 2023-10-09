package com.example.bookshopapi.repository;

import com.example.bookshopapi.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepo extends JpaRepository<Cart, String> {
    Cart findByCustomerId(int customerId);
}
