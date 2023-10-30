package com.example.bookshopapi.repository;

import com.example.bookshopapi.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<Payment, Integer> {
    Payment findById(int paymentId);
}
