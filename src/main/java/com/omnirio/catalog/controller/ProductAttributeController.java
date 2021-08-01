package com.omnirio.catalog.controller;

import com.omnirio.catalog.exception.AttributeNotFoundException;
import com.omnirio.catalog.exception.ProductNotFoundException;
import com.omnirio.catalog.model.Attribute;
import com.omnirio.catalog.model.Product;
import com.omnirio.catalog.model.ProductAttribute;
import com.omnirio.catalog.service.ProductAttributeService;
import com.omnirio.catalog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductAttributeController {

    @Autowired
    private ProductAttributeService productAttributeService;

    @Autowired
    private ProductService productService;

    @PostMapping("/products/{product_id}/attributes/{attribute_id}")
    public ProductAttribute createProduct(@PathVariable("product_id") Long productId, @PathVariable("attribute_id") Long attributeId, @RequestBody ProductAttribute productAttribute) {
        Product product = productService.findProductById(productId).orElseThrow(() -> new ProductNotFoundException(productId));
        Attribute attribute = product.getCategory().getAttributes()
                .parallelStream()
                .filter(attr -> attr.getId().equals(attributeId)).findAny().orElseThrow(() -> new AttributeNotFoundException(attributeId));


        productAttribute.setProduct(product);
        productAttribute.setCategory(product.getCategory());
        productAttribute.setAttribute(attribute);

        return productAttributeService.saveProductAttribute(productAttribute);

    }


}
