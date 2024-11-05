package com.example.demo.services;

import java.util.List;

import com.example.demo.models.City;

public interface CitiesService {

    List<City> getAllCities();
    List<City> findCityByName(String name);
    City createCity(City city);

     // static List<City> getAllCities() {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'getAllCities'");
    // }
}
