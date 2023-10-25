package com.example.bookshopapi.service;

import com.example.bookshopapi.entity.Supplier;
import com.example.bookshopapi.repository.SupplierRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {
    @Autowired
    private SupplierRepo supplierRepo;

    public List<Supplier> getAllSuppliers() {
        return supplierRepo.findAll();
    }

    public Supplier addSupplier(Supplier supplier) {
        return supplierRepo.save(supplier);
    }
}
