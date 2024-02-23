package com.example.t2207a_springboot.service;

import com.example.t2207a_springboot.entity.Product;
import com.example.t2207a_springboot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product product) {
        if (productRepository.existsById(id)) {
            product.setId(id);
            return productRepository.save(product);
        }
        return null; // Or throw an exception
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
    public List<Product> searchProduct(String search){
        return productRepository.findAllByNameContainingOrDescriptionContaining(search,search);
    }

    public List<Product> filterProducts(String name,Integer minPrice,Integer maxPrice){
        return productRepository.filterProducts(name,minPrice,maxPrice);
    }
}
