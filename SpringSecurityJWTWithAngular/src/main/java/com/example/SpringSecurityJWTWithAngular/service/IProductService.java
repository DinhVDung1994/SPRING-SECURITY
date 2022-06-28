package com.example.SpringSecurityJWTWithAngular.service;

import com.example.SpringSecurityJWTWithAngular.models.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> findAll();
    Product save(Product product);
    Product update(Product newProduct,Long id);
    void delete(Long id);
    boolean exists(Long id);
    Optional<Product> findById(Long id);
    List<Product> findByNameProduct(String nameProduct);
}
