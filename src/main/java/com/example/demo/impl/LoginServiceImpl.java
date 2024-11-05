package com.example.demo.impl;

import com.example.demo.services.LoginService;

public class LoginServiceImpl implements LoginService {

    @Override
    public Integer login(String username, String password) {

        if(username.equals("admin") && password.equals("batata")) {

            return 1;
        }
        return -1;

    }
    
}
