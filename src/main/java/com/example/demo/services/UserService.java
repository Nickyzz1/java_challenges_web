package com.example.demo.services;

import java.util.List;

import com.example.demo.models.UserModel;

public interface UserService {

    void createNewUser(String userName, String pass, String email);
    List<UserModel> getAllUsers();
    
}
