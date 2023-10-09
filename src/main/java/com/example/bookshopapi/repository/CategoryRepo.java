package com.example.bookshopapi.repository;

import com.example.bookshopapi.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
    List<Category> findAll();
    List<Category> findTop8ByOrderByIdAsc();
}
