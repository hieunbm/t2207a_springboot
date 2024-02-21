package com.example.t2207a_springboot.service;

import com.example.t2207a_springboot.entity.Category;
import com.example.t2207a_springboot.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import java.util.*  ;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category updateCategory(Long id, Category category) {
        if (categoryRepository.existsById(id)) {
            category.setId(id);
            return categoryRepository.save(category);
        }
        return null; // or throw exception
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
