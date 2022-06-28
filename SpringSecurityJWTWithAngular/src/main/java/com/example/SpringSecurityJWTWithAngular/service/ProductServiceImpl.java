package com.example.SpringSecurityJWTWithAngular.service;

import com.example.SpringSecurityJWTWithAngular.models.Product;
import com.example.SpringSecurityJWTWithAngular.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Product newProduct, Long id) {
        Optional<Product> updateproduct = findById(id);
        if (updateproduct.isPresent()) {
            updateproduct.map(product -> {
                product.setNameProduct(newProduct.getNameProduct());
                product.setPrice(newProduct.getPrice());
                return productRepository.save(product);

            });
        }
        return updateproduct.get();
    }

    @Override
    public boolean exists(Long id) {
        return productRepository.existsById(id);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findByNameProduct(String nameProduct) {
        List<Product> product = productRepository.findByNameProduct(nameProduct);
        return product;
    }
}
