package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.example.demo.impl.CitiesServiceImpl;
import com.example.demo.impl.LoginServiceImpl;
import com.example.demo.impl.ProductServiceImpl;
import com.example.demo.services.CitiesService;
import com.example.demo.services.LoginService;
import com.example.demo.services.ProductService;

@Configuration
public class DependencyConfiguration {

    // O CONTROLLER DEVE DEPENDER DA INTERFACE DO SERVIÇO,

    @Bean // diz que está sendo gerenciada pelo spring
    @Scope("singleton") // request, prototype, singleton(se nn colocar nd é o padrão) (, oq cada um deveria ser, session
    public LoginService loginService() {
        return new LoginServiceImpl();
    }

        //apena sum retorno por interface, nn se coloca o memso serviço para vária smplementações
    @Bean
    @Scope("singleton")
    public ProductService productServiceDependency () {
        return new ProductServiceImpl();
    }

    @Bean
    public CitiesService citiesService() {
        return  new CitiesServiceImpl();
    }

}

// controlador dependencia nas interfaces , nn nas classes, sempre interface
