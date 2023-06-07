package dev.bitan.springmongodbcommunication.repository;

import dev.bitan.springmongodbcommunication.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
