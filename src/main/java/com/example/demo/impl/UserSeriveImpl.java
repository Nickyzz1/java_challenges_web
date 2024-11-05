package com.example.demo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.UserModel;
import com.example.demo.repositories.UserRepositoy;
import com.example.demo.services.UserService;

@Service
public class UserSeriveImpl implements UserService {

    @Autowired
    private UserRepositoy userRepository;

    @Override
    public void createNewUser(String userName, String pass, String email) {
        
        userRepository.save(new UserModel(userName, pass, email));
    }

    @Override
    public List<UserModel> getAllUsers() {
       return userRepository.findAll();
    }
}
