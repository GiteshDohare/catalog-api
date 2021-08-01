package com.omnirio.catalog.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(Long id) {
        super("Invalid product id: " + id);
    }

}
