package com.codemind.pms.productservice.exception;

import org.springframework.validation.BindingResult;

public class ProductValidationException extends RuntimeException {
    private final BindingResult bindingResult;

    // Constructor that accepts a custom message and the BindingResult object
    public ProductValidationException(String message, BindingResult bindingResult) {
        super(message);  // Set the custom message to the superclass (RuntimeException)
        this.bindingResult = bindingResult;  // Capture the BindingResult containing validation errors
    }

    // Getter method to retrieve the BindingResult
    public BindingResult getBindingResult() {
        return bindingResult;
    }
}
