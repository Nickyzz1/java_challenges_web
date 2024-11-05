package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.MyEmailValidator;
import com.example.demo.MyPasswordValidator;
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

        String msg = "Default";

        if(userService.findByName(userName).isEmpty() && userService.findByEmail(userEmail).isEmpty()){
            if (MyEmailValidator.Validate(userEmail)) {
                
                if (MyPasswordValidator.Validate(userPass)) {
                    userService.createNewUser(userName, userPass, userEmail);
                    msg = "User criado com sucesso";
                    return ResponseEntity.ok(msg);
                }
                msg = "Sua senha não atinge as normas de segurança, atenção aos requisitos: Possuir ao menos 8 caracteres; Ter letras maiusculas; Ter letras minusculas; Ter números ";
                return ResponseEntity.badRequest().body(msg);
            }

            msg = "Seu email não passou na verificação! Seu email deve ter mais de 4 caracteres e possuir @ e .com ";

            return ResponseEntity.badRequest().body(msg);
        }

        msg = "O usuário já existe no banco de dados!";
        return ResponseEntity.badRequest().body(msg);

    }

    @GetMapping
    public ResponseEntity<List<UserModel>> getAll() {
        List<UserModel> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}
