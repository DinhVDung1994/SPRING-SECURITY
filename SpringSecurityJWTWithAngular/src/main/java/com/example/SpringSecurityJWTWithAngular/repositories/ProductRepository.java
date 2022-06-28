package com.example.SpringSecurityJWTWithAngular.repositories;

import com.example.SpringSecurityJWTWithAngular.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
       List<Product> findByNameProduct(String nameProduct);
}
