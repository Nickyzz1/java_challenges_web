package com.example.demo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.City;
import com.example.demo.repositories.CitiesRepository;
import com.example.demo.services.CitiesService;

@Service
public class CitiesServiceImpl implements CitiesService {

    @Autowired
    private CitiesRepository citiesRepository; // cria um obj do repoositorio pq o repositório é que vai fazer as consuktas

    @Override
    public List<City> getAllCities() { // crria os métodos com o nome definifo na interface  para fazer as consultas com os métodos automátidocs do repositório
        return citiesRepository.findAll(); // métdos que já existem
    }

    @Override
    public City createCity(City city) {
        return citiesRepository.save(city);
    }

    @Override
    public List<City> findCityByName(String name) {
        return citiesRepository.findByName(name); // método criado
    }

    // public void createInitialCities() {
    //     citiesRepository.save(new City("Brazil", "Curitiba", "PR"));
    //     citiesRepository.save(new City("Japan", "Tokyo", "KT"));
    //     citiesRepository.save(new City("United States", "New York", "NY"));
    //     citiesRepository.save(new City("Chéquia", "Praga", "PR"));
    // }
}
