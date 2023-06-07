package dev.bitan.springmongodbcommunication.exception;

public class ProductNotFound extends RuntimeException {

    public ProductNotFound() {
        super("Product Not found");
    }
}