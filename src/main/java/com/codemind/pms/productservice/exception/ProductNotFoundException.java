package com.codemind.pms.productservice.exception;

public class ProductNotFoundException extends RuntimeException {

    // Constructor that accepts a product ID and creates a custom error message
    public ProductNotFoundException(Long id) {
        super("Product not found with ID: " + id);
    }
}
