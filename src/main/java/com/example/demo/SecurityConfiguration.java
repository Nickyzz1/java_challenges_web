package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.demo.controllers.dto.Token;
import com.example.demo.filters.JWTAuthenticationFilter;
import com.example.demo.services.JWTService;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    
    @Autowired
    JWTService<Token> jwtService;
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // como mandar jwt para header depois do login?
        return http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/user").permitAll() // esses end poits permiete que façam as ações semprecisar fazer login, vc escolhe quais end poinst nn precisam de autenticação
                .requestMatchers("/user/login").permitAll() // quando testar colocar no permit all
                .requestMatchers("/user/create").permitAll() 
                .anyRequest().authenticated()
            )
            .addFilterBefore(new JWTAuthenticationFilter(jwtService), UsernamePasswordAuthenticationFilter.class) // tds os end points vão chamar isso
            .build();
    }
}