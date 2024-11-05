package com.example.demo.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controllers.dto.ProductDTO;
import com.example.demo.models.Product;
import com.example.demo.services.ProductService;


@RestController
@RequestMapping("/api/products")
public class ExemploProductControllerWithDto {

    @Autowired
    private ProductService productService;

    // Obter todos os produtos
    // reponse entity é um classe spring que mostra oq ues erá retornado pelo controlador
    @GetMapping
    //significa que o método getAllProducts é um método público que retorna um objeto do tipo ResponseEntity contendo uma lista de ProductDTO. 
    @SuppressWarnings({"unchecked", "deprecation"})
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        // Isso indica que o método retornará uma resposta HTTP que inclui uma lista de objetos do tipo ProductDTO no corpo da resposta. O ResponseEntity permite configurar o status HTTP, cabeçalhos e o corpo da resposta.
        List<Product> products = productService.getAllProducts();
        // Converte List<Product> para List<ProductDTO>
        List<ProductDTO> productDTOs = products.stream()
            .map(product -> new ProductDTO(product.getId(), product.getName(), product.getType(), product.getPrice())) // cria prdoucts dto atraves de products, o prdoucts dto serão apenAS A LÓGICA DOS PRODUTOS, SEAPARADO DA DO BANDO DE DADOS DE PRODUCT
            .collect(Collectors.toList());
        return new ResponseEntity<>(productDTOs, HttpStatus.OK);
    }

    // Criar um novo produto
    @PostMapping
    @SuppressWarnings({"unchecked", "deprecation"})
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        // Converte ProductDTO para Product
        Product product = new Product(productDTO.name(), productDTO.type(), productDTO.price());
        Product createdProduct = productService.createProduct(product);
        
        // Converte de volta para ProductDTO
        ProductDTO createdProductDTO = new ProductDTO(createdProduct.getId(), createdProduct.getName(), createdProduct.getType(), createdProduct.getPrice());
        return new ResponseEntity<>(createdProductDTO, HttpStatus.CREATED);
    }

    // Outros métodos utilizando DTOs como no exemplo acima
}

// fluxo:

// Controller: A classe ProductController é responsável por lidar com requisições HTTP. Quando uma requisição GET é feita para a URL /api/products, o método getAllProducts na controller é chamado.

// Chamada ao Serviço: Dentro desse método da controller, a linha productService.getAllProducts() chama o método correspondente na interface ProductService.

// Implementação do Serviço: O método getAllProducts() na implementação ProductServiceImpl chama o repositório para obter a lista de produtos. Normalmente, isso se parece com o seguinte:


// Controller: Lida com requisições HTTP.
// Serviço: Contém a lógica de negócio.
// Repositório: Interage com a base de dados.

// Cliente ---> /api/products (GET)
//               |
//               V
//       ProductController
//               |
//               V
//       productService.getAllProducts()
//               |
//               V
//       ProductServiceImpl
//               |
//               V
//       productRepository.findAll()
//               |
//               V
//       Banco de Dados

