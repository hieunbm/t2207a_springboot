package com.example.t2207a_springboot.entity;

import jakarta.persistence.*;

@Entity
@Table(name="category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long product_id; // Assuming product_id is a foreign key

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }
}
