package com.omnirio.catalog.controller;

import com.omnirio.catalog.exception.CategoryNotFoundException;
import com.omnirio.catalog.model.Attribute;
import com.omnirio.catalog.model.Category;
import com.omnirio.catalog.model.Product;
import com.omnirio.catalog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/categories")
    public Category createCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    @PostMapping("/categories/{id}/attributes")
    public Attribute createAttribute(@PathVariable Long id, @RequestBody Attribute attribute) {
        Category category = categoryService.getCategoryById(id)
                                .orElseThrow(() -> new CategoryNotFoundException(id));

        category.addAttribute(attribute);
        categoryService.saveCategory(category);

        return attribute;
    }

    @PostMapping("/categories/{id}/products")
    public Product createProduct(@PathVariable Long id, @RequestBody Product product) {
        Category category = categoryService.getCategoryById(id)
                .orElseThrow(() -> new CategoryNotFoundException(id));

        category.addProduct(product);
        categoryService.saveCategory(category);

        return product;
    }




    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }
}
