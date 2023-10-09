package com.example.bookshopapi.repository;

import com.example.bookshopapi.entity.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ShippingRepo extends JpaRepository<Shipping, Integer> {
    List<Shipping> findAll();
    Shipping findById(int shippingId);
}
