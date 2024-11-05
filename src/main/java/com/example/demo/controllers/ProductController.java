// package com.example.demo.controllers;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.demo.models.Product;
// import com.example.demo.services.ProductService;

// @RestController
// @RequestMapping("/api/products")
// public class ProductController {

//     @Autowired
//     private ProductService productService;

//     // Obter todos os produtos
//     @GetMapping
//     public ResponseEntity<List<Product>> getAllProducts() {
//         List<Product> products = productService.getAllProducts();
//         return new ResponseEntity<>(products, HttpStatus.OK);
//     }

//     // Criar um novo produto
//     @PostMapping
//     public ResponseEntity<Product> createProduct(@RequestBody Product product) {
//         Product createdProduct = productService.createProduct(product);
//         return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
//     }

//     // Buscar produtos por nome
//     @GetMapping("/search")
//     public ResponseEntity<List<Product>> findProductsByName(@RequestParam String name) {
//         List<Product> products = productService.findProductsByName(name);
//         return new ResponseEntity<>(products, HttpStatus.OK);
//     }

//     // Buscar produtos abaixo de um certo preço
//     @GetMapping("/under-price")
//     public ResponseEntity<List<Product>> findProductsUnderPrice(@RequestParam Double price) {
//         List<Product> products = productService.findProductsUnderPrice(price);
//         return new ResponseEntity<>(products, HttpStatus.OK);
//     }
// }
