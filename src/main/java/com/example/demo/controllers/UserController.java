package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controllers.dto.UserDto;
import com.example.demo.services.LoginService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    LoginService service;

    @PostMapping
    public ResponseEntity<String> login(@RequestBody UserDto data)
    {
        if(data.login().equals("admin") && data.password().equals("batata")) {

            return ResponseEntity.ok("bem vindo");
        }
        return ResponseEntity.status(404).build();
    }
}
