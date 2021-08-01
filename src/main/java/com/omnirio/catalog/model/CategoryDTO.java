package com.omnirio.catalog.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CategoryDTO {
    private Long categoryId;
    private String categoryName;

    private List<Attribute> attributes;
}
