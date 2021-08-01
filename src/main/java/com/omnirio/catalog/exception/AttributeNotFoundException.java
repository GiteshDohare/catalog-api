package com.omnirio.catalog.exception;

public class AttributeNotFoundException extends RuntimeException {
    public AttributeNotFoundException(Long id) {
        super("Invalid Attribute id: " + id);
    }

}
