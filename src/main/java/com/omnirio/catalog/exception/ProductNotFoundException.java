package com.omnirio.catalog.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(Long id) {
        super("Invalid Product id: " + id);
    }

}
