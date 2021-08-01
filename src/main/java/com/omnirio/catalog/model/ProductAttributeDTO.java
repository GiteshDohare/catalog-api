package com.omnirio.catalog.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductAttributeDTO {
    private Long id;
    private String name;
    private String value;

}
