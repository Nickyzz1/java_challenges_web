package com.example.demo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.models.Product;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.services.ProductService;

public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Objetivo: O principal objetivo do @Autowired é permitir que o Spring gerencie as dependências entre os componentes de sua aplicação. Isso significa que o Spring automaticamente cria e injeta as instâncias necessárias de classes que você precisa em outras classes.

// Como Funciona: Quando você coloca @Autowired em um campo (como private ProductRepository productRepository;), o Spring:

// Localiza um bean do tipo ProductRepository que está registrado no contexto do Spring.
// Cria uma instância desse bean (se ainda não houver uma).
// Injeta essa instância no campo productRepository da classe ProductServiceImpl.

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll(); // Chama o método do repositório
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product); // Chama o método do repositório para salvar
    }

    @Override
    public List<Product> findProductsByName(String name) {
        return productRepository.findByName(name); // Chama o método personalizado do repositório
    }

    @Override
    public List<Product> findProductsUnderPrice(Double price) {
        return productRepository.findByPriceLessThan(price); // Chama o método personalizado do repositório
    }
}
