package com.omnirio.catalog.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProductDTO {
    private Long productId;
    private String productName;
    private Long categoryId;
    private String categoryName;
    private List<ProductAttributeDTO> attributes = new ArrayList<>();

}
