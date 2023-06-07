package dev.bitan.springmongodbcommunication.web;

import dev.bitan.springmongodbcommunication.exception.ProductNotFound;
import dev.bitan.springmongodbcommunication.model.Product;
import dev.bitan.springmongodbcommunication.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
public class WebController {
    private ProductRepository productRepository;

    public WebController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping("/products")
    public ResponseEntity create(@RequestBody Product product) {
        product = productRepository.save(product);
        return ResponseEntity.created(URI.create("/product/" + product.getId()))
                .body(product);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity getProduct(@PathVariable("id") String id) {
        Optional<Product> productById = productRepository.findById(id);

        return productById.map(ResponseEntity::ok)
                .orElseThrow(ProductNotFound::new);
    }
}
