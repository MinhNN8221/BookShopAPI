package com.example.bookshopapi.repository;

import com.example.bookshopapi.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
    Customer findByEmail(String email);
    boolean existsByEmail(String email);

    Customer findById(int id);
}
