package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Busca produtos pelo nome
    List<Product> findByName(String name);
    
    // Busca produtos com preço menor que um valor específico
    List<Product> findByPriceLessThan(Double price);
    
    // Contagem de produtos por categoria
    Long countByType(String type);
}

// OS MÉTODOS DEFINIDOS NO REPOSITÓRIO EU USO NA IMPLEMENTAÇÃO DO SERVIÇO


// Funcionalidades do JpaRepository
// Ao estender JpaRepository, você obtém automaticamente vários métodos úteis sem precisar implementá-los. Aqui estão alguns métodos comuns que você encontrará:

// Operações CRUD Básicas:

// save(S entity): Salva uma entidade, inserindo-a no banco de dados ou atualizando-a se já existir.
// findById(ID id): Busca uma entidade pelo seu identificador (ID).
// findAll(): Retorna uma lista de todas as entidades do tipo especificado.
// deleteById(ID id): Remove uma entidade pelo seu identificador.
// Consultas Personalizadas: O Spring Data JPA permite criar métodos de consulta baseados em nomes. Por exemplo:

// findByNome(String nome): Busca produtos pelo nome.
// findByPrecoLessThan(double preco): Busca produtos com preço menor que um determinado valor.
// Paginação e Ordenação:

// findAll(Pageable pageable): Retorna uma página de resultados.
// findAll(Sort sort): Retorna todas as entidades ordenadas por um critério especificado.
// Contagem:

// count(): Conta o número total de entidades do tipo.


// package com.example.demo.repositories;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// import com.example.demo.impl.ProductServiceImpl;

// @Configuration
// public class ProductRepository {
//     // a classe product service impl depende da product repositoty para ter dados do produto, isso é dependencia de uma clase para outra
//     // os sprign relaciona as dependencias com beans
//     //  @Configuration indica que a classe pode ser usada pelo Spring IoC Container como uma fonte de definições de beans

//       @Bean
//         public ProductServiceImpl productService () {
//             return new ProductServiceImpl();
//         }
// }
