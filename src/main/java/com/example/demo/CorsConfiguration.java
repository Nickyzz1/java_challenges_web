package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {
    
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("http://localhost:5257")
            .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT");

}}

//erro como nfazer 

// @GetMapping("/{current}/{step}")
//     public ResponseEntity<Object> collatz(@PathVariable Integer current, @PathVariable Integer step) {

//         if(current < 0 || step < 0)
//             return ResponseEntity
//                 .status(HttpStatus.BAD_REQUEST)
//                 .body(new ErrorResponse("Valores negativos não são permitidos.", 400));
        
//         for (int i = 0; i < step; i++) {
//             if (current % 2 == 0) {
//                 current = current / 2;
//             } else {
//                 current = 3 * current + 1;
//             }
//         }
                

//         return ResponseEntity
//             .status(HttpStatus.OK)
//             .body(new CollatzData(current));
//     }