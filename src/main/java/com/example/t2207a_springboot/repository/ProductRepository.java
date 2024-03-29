package com.example.t2207a_springboot.repository;

import com.example.t2207a_springboot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findAllByNameContaining(String name);
    List<Product> findAllByNameContainingOrDescriptionContaining(String search,String description);
    List<Product> findAllByPrice(Integer price);
    @Query("SELECT p from Product p "+
            "Where (:name is Null or p.name like %:name%)"+
            "AND (:minPrice is Null or p.price >= :minPrice)"+
            "AND (:maxPrice is null or p.price <= :maxPrice)"
    )
    List<Product> filterProducts(@Param("name") String name,
                                 @Param("minPrice") Integer minPrice,
                                 @Param("maxPrice") Integer maxPrice);
}
