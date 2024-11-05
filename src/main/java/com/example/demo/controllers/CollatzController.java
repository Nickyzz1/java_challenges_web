package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controllers.dto.CollatzDto;


@RestController
@RequestMapping("/collatz")
public class CollatzController {

    @GetMapping("/{curr}/{step}")
    public CollatzDto applyCollatz(@PathVariable Float curr, @PathVariable Integer step) {

        Boolean status = true;

        if (step != null || curr != null) {


            if(step < 0 || curr < 0) {

                status = !status;

                return new CollatzDto(curr, status, "Erro ao enviar número inválido");

            } else {

                for(int i = 0; i < step; i++) {
    
                    curr = collatz(curr);
                }

                return new CollatzDto(curr, status, "Função executada com sucesso");

            }
        } else {

            status = !status;
            return new CollatzDto(curr, status, "Erro ao enviar número nulo");
        }
    }
      

    public Float collatz(Float num) {
        if (num % 2 == 0) {
            return  num/2;  
        } else {
           return 3 * num+1;
        }
    }
    
}

