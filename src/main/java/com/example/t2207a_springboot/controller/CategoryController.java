package com.example.t2207a_springboot.controller;

import com.example.t2207a_springboot.entity.Category;
import com.example.t2207a_springboot.entity.Product;
import com.example.t2207a_springboot.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public Optional<Category> getProductById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    @PostMapping
    public Category createProduct(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    @PutMapping("/{id}")
    public Category updateProduct(@PathVariable Long id, @RequestBody Category category) {
        return categoryService.updateCategory(id, category);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }
}

