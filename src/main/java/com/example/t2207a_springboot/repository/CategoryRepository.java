package com.example.t2207a_springboot.repository;

import com.example.t2207a_springboot.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
