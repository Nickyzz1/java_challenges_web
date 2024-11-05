package com.example.demo.services;

import java.util.List;

import com.example.demo.models.Product;

public interface ProductService {
    List<Product> getAllProducts();
    Product createProduct(Product product);
    List<Product> findProductsByName(String name);
    List<Product> findProductsUnderPrice(Double price);
}
