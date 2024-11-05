package com.example.demo.controllers.dto;

public record ProductDTO(Long id, String name, String type, Double price) {
    // Aqui você pode adicionar validações ou métodos adicionais se necessário
    public ProductDTO(Long id, String name, String type, Double price)
    {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
    }
}
