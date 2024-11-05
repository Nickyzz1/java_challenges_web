package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.models.City;
import com.example.demo.repositories.CitiesRepository;

@Component
public class DataInitializer implements CommandLineRunner { // é uma interface que fala para o spring quie deve ser executado esse bloco de c´[odigho logo no incio

    @Autowired
    private CitiesRepository citiesRepository;

    @Override
    public void run(String... args) throws Exception {
        if (citiesRepository.count() == 0) { // Checa se já existem cidades
            citiesRepository.save(new City("Brazil", "Curitiba", "PR"));
            citiesRepository.save(new City("Japan", "Tokyo", "KT"));
            citiesRepository.save(new City("United States", "New York", "NY"));
            citiesRepository.save(new City("Czech Republic", "Prague", "PR"));
            System.out.println("Dados iniciais inseridos com sucesso.");
        }
    }
}
