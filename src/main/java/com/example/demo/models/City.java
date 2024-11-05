package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; // Corrigido para 'id' em minúsculo

    @Column(name = "nomeCidade")
    private String name;

    @Column(name = "paisCol")
    private String country;

    @Column(name = "estadoSiglaCol")
    private String state;

    // Construtor sem parâmetros (necessário para JPA)
    public City() {}

    // Construtor com parâmetros
    public City(String country, String name, String state) {
        this.name = name;
        this.state = state;
        this.country = country;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEstate() {
        return state;
    }

    public void setEstate(String estate) {
        this.state = estate;
    }
    
}
