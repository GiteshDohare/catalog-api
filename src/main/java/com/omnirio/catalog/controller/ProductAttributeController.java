package com.omnirio.catalog.controller;

import com.omnirio.catalog.exception.AttributeNotFoundException;
import com.omnirio.catalog.exception.ProductNotFoundException;
import com.omnirio.catalog.model.*;
import com.omnirio.catalog.service.ProductAttributeService;
import com.omnirio.catalog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping("/products/{id}")
    public ProductDTO getAllByProductId(@PathVariable Long id) {
        Product product = productService.findProductById(id).orElseThrow(() -> new ProductNotFoundException(id));
        List<ProductAttribute> productAttributes = productAttributeService.findAllByProduct(product);

        List<ProductAttributeDTO> productAttributesDTOS = productAttributes.stream()
                .map(prodAttr -> new ProductAttributeDTO(prodAttr.getAttribute().getId(), prodAttr.getAttribute().getName(), prodAttr.getValue()))
                .collect(Collectors.toList());

        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(id);
        productDTO.setProductName(product.getName());
        productDTO.setCategoryId(product.getCategory().getId());
        productDTO.setCategoryName(product.getCategory().getName());
        productDTO.setAttributes(productAttributesDTOS);

        return productDTO;
    }


}
