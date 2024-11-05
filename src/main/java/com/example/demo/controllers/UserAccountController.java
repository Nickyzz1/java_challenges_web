package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.UserModel;
import com.example.demo.services.UserService;

@RestController
@RequestMapping("/create")
public class UserAccountController {
    private final UserService userService;

    @Autowired
    public UserAccountController(UserService userService) {
        this.userService = userService;
    }

    @SuppressWarnings("rawtypes")
    @GetMapping("/{userName}/{userPass}/{userEmail}")
    public ResponseEntity createUser (@PathVariable String userName, @PathVariable String userPass, @PathVariable String userEmail) {
        userService.createNewUser(userName, userPass, userEmail);
        String msg = "User criado com sucesso";
        return ResponseEntity.ok(msg);
    }

    @GetMapping
    public ResponseEntity<List<UserModel>> getAll() {
        List<UserModel> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}
