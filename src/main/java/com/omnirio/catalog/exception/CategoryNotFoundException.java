package com.omnirio.catalog.exception;

public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(Long id) {
        super("Invalid category id: " + id);
    }

}
