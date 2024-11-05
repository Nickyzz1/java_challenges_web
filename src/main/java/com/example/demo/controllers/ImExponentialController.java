package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controllers.dto.ImExponentialDto;

@RestController
@RequestMapping("/ImaginaryExponential")
public class ImExponentialController {

    @GetMapping("/{a}/{b}")
    public ImExponentialDto imagExp(@PathVariable Double a, @PathVariable Double b) {

        Double re = a * Math.sin(b);
        Double im = a * Math.cos(b);

        return new ImExponentialDto(re, im);

    }
    
}
