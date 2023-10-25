package com.example.bookshopapi.service;

import com.example.bookshopapi.entity.Category;
import com.example.bookshopapi.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;

    public List<Category> getCategoryAll() {
        return categoryRepo.findAll();
    }

    public List<Category> getCategoryHot() {
        return categoryRepo.findTop8ByOrderByIdAsc();
    }

    public Category addCategory(Category category) {
        return categoryRepo.save(category);
    }

    public void deleteCategory(int idCategory) {
        categoryRepo.deleteCategoryById(idCategory);
    }
}
