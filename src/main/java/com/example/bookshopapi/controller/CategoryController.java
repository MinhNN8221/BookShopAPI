package com.example.bookshopapi.controller;

import com.example.bookshopapi.dto.response.category.CategoryResponse;
import com.example.bookshopapi.entity.Category;
import com.example.bookshopapi.service.CategoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/category")
@AllArgsConstructor
@Slf4j
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<?> getCategoryAll() {
        List<Category> categories = categoryService.getCategoryAll();
        CategoryResponse response = new CategoryResponse(categories.size(), categories);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/hot")
    public ResponseEntity<?> getCategoryHot() {
        List<Category> categories = categoryService.getCategoryHot();
        CategoryResponse response = new CategoryResponse(categories.size(), categories);
        return ResponseEntity.ok(response);
    }
}
