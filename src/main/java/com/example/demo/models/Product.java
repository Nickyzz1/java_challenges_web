package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; // Corrigido para 'id' em minúsculo

    @Column(name = "nomeProduto")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "price")
    private Double price;

    // Construtor sem parâmetros (necessário para JPA)
    public Product() {}

    // Construtor com parâmetros
    public Product(String name, String type, Double price) {
        this.name = name;
        this.type = type;
        this.price = price; // Atribuindo o valor de 'price'
    }

    // Getters e setters
    public Long getId() {
        return id; 
    }
    

    public void setId(long id) {
        this.id = id; // Corrigido para 'id' em minúsculo
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
