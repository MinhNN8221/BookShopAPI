package com.example.bookshopapi.service;

import com.example.bookshopapi.entity.Payment;
import com.example.bookshopapi.repository.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepo paymentRepo;
    public Payment getPaymentById(int paymentId){
        return paymentRepo.findById(paymentId);
    }
}
