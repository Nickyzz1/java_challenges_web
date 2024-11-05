package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.City;

@Repository
public interface CitiesRepository extends JpaRepository<City, Long> { // vc diz que para a entidade city o id edela é um Long
    List<City> findByName(String name); // esse precisa estra declarado explicitamente pq nn é um método natuivo, padrão, mas sim um criado com base na interpretação do próporiojava do seu model
}
