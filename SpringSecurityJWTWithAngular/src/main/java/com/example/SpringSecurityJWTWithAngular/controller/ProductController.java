package com.example.SpringSecurityJWTWithAngular.controller;

import com.example.SpringSecurityJWTWithAngular.models.Product;
import com.example.SpringSecurityJWTWithAngular.models.ResponseObject;
import com.example.SpringSecurityJWTWithAngular.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @GetMapping("/products")
    ResponseEntity<ResponseObject> getAllProducts(){
        List<Product> listProducts = productService.findAll();
        if (listProducts.isEmpty()){
            return ResponseEntity.ok(new ResponseObject("Failed",
                    "List product empty!!!",""));
        }
        return ResponseEntity.ok(new ResponseObject("OKE",
                "Query list product successfully!",listProducts));
    }

    @GetMapping("/products/{id}")
    ResponseEntity<ResponseObject> getProduct(@PathVariable Long id){
        Optional<Product> product = productService.findById(id);
        if (!product.isPresent()){
            return ResponseEntity.ok(new ResponseObject("Failed",
                    "Cannot found product!",""));
        }
        return ResponseEntity.ok(new ResponseObject("OKE",
                "Query product successfully!",product));
    }

    @PostMapping("/products")
    ResponseEntity<ResponseObject> insertProduct(@RequestBody @Valid Product newProduct){
        List<Product> foundProduct = productService.findByNameProduct(newProduct.getNameProduct().trim());
        if (foundProduct.size()>0){
            return ResponseEntity.ok(new ResponseObject("FAILED",
                    "Name product already exists!",""));
        }
        return ResponseEntity.ok(new ResponseObject("OKE",
                "Insert product successfully!", productService.save(newProduct)));
    }

    @PutMapping("/products/{id}")
    ResponseEntity<ResponseObject> updateProduct(@RequestBody Product newProduct,@PathVariable Long id){
        Optional<Product> updateProduct = productService.findById(id);
        if (updateProduct.isPresent()){
            productService.update(newProduct,id);
        }else {
            return ResponseEntity.ok(new ResponseObject("Failed","Product update failed!",""));
        }

        return ResponseEntity.ok(new ResponseObject("OKE","Update product successfully!",updateProduct));
    }

    @DeleteMapping("/products/{id}")
    ResponseEntity<ResponseObject> deleteProduct(@PathVariable Long id){
        boolean exists = productService.exists(id);
        if (exists){
            productService.delete(id);
            return ResponseEntity.ok(new ResponseObject("OKE","Delete product successfully!",""));
        }
        return ResponseEntity.ok(new ResponseObject("Failed","Cannot find product to delete",""));
    }
}
