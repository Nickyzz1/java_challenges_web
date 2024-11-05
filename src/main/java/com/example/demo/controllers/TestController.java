package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controllers.dto.SumResultDto;

@RestController
@RequestMapping("/test")
public class TestController {
    // @GetMapping("/{a}/add/{b}")
    // public Integer test(@PathVariable Integer a, @PathVariable Integer b) 
    // {
    //     return a + b;
    // }

    @GetMapping("/{a}")
    public SumResultDto test(@PathVariable Integer a, Integer b) 
    {
        if (b == null) {
            b = 2;
        }

        var result= a + b;
        var isEven = result %2 == 0;
        return new SumResultDto(result, isEven);
    }

    // @RequestMapping("/testIsNull")
    // @GetMapping("/{value}")
    // public Integer testIsNull(@PathVariable Integer value,  Integer b) 
    // {
    //     if (b == null) 
    //         b = 2;

    //     return value + b;
    // }
}

// ?a=2&b=3 td ? é um get
// mais de uma url quando tiver mais de um get
