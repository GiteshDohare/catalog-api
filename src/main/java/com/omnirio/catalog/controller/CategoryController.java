package com.omnirio.catalog.controller;

import com.omnirio.catalog.exception.CategoryNotFoundException;
import com.omnirio.catalog.model.Attribute;
import com.omnirio.catalog.model.Category;
import com.omnirio.catalog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

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
        Optional<Category> optionalCategory= categoryService.getCategoryById(id);
        Category category = optionalCategory.orElseThrow(() -> new CategoryNotFoundException(id));

        category.addAttribute(attribute);
        categoryService.saveCategory(category);

        return attribute;
    }


    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }
}
