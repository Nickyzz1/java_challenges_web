package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.City;
import com.example.demo.services.CitiesService;


@RestController
@RequestMapping("/cities")
public class CitiesController {

    private final CitiesService citiesService;

    @Autowired // sem isso ele nn reconehce a dependencia
    public CitiesController(CitiesService citiesService) {
        this.citiesService = citiesService;
    }

    @GetMapping
    public ResponseEntity<List<City>> getAllTheCities() {
        List<City> cities = citiesService.getAllCities();
        return ResponseEntity.ok(cities); 
    }

    @GetMapping("/{query}")
    public ResponseEntity<List<City>> getOneCity(@PathVariable String query) 
    {
        List<City> justCities = citiesService.findCityByName(query);
        return ResponseEntity.ok(justCities);
    }

    
}
