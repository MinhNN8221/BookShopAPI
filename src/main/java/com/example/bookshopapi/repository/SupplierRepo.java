package com.example.bookshopapi.repository;

import com.example.bookshopapi.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SupplierRepo extends JpaRepository<Supplier, Integer> {
    List<Supplier> findAll();

    Supplier save(Supplier supplier);
}
