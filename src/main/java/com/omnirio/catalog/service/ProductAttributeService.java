package com.omnirio.catalog.service;

import com.omnirio.catalog.model.ProductAttribute;
import com.omnirio.catalog.repository.ProductAttributeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductAttributeService {

    @Autowired
    private ProductAttributeRepository productAttributeRepository;

    public ProductAttribute saveProductAttribute(ProductAttribute productAttribute) {
        return productAttributeRepository.save(productAttribute);
    }
}
