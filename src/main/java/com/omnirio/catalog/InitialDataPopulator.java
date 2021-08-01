package com.omnirio.catalog;

import com.omnirio.catalog.model.Attribute;
import com.omnirio.catalog.model.Category;
import com.omnirio.catalog.model.Product;
import com.omnirio.catalog.model.ProductAttribute;
import com.omnirio.catalog.service.CategoryService;
import com.omnirio.catalog.service.ProductAttributeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitialDataPopulator {

    @Bean
    CommandLineRunner populateInitialData (CategoryService categoryService, ProductAttributeService productAttributeService){
        return args -> {
            Attribute color = new Attribute();
            color.setName("color");

            Attribute brand = new Attribute();
            brand.setName("brand");

            Product mobile = new Product(null, "Mobile Phone", null);
            Product laptop = new Product(null, "Laptop", null);
            Category electronics = new Category();
            electronics.setName("Electronics");
            electronics.addAttribute(brand);
            electronics.addAttribute(color);
            electronics.addProduct(mobile);
            electronics.addProduct(laptop);
            categoryService.saveCategory(electronics);

            Attribute apparelColor = new Attribute();
            apparelColor.setName("color");

            Attribute size = new Attribute();
            size.setName("size");

            Product shirt = new Product(null, "Shirt", null);
            Product shoes = new Product(null, "Shoes", null);
            Category apparel = new Category();
            apparel.setName("Apparel");
            apparel.addAttribute(apparelColor);
            apparel.addAttribute(size);
            apparel.addProduct(shirt);
            apparel.addProduct(shoes);

            categoryService.saveCategory(apparel);

            // persisting product and attribute mapping

            ProductAttribute prodAttribute1 = new ProductAttribute();
            prodAttribute1.setProduct(mobile);
            prodAttribute1.setAttribute(color);
            prodAttribute1.setValue("Red");
            prodAttribute1.setCategory(electronics);
            productAttributeService.saveProductAttribute(prodAttribute1);

            ProductAttribute prodAttribute2 = new ProductAttribute();
            prodAttribute2.setProduct(mobile);
            prodAttribute2.setAttribute(brand);
            prodAttribute2.setValue("Apple");
            prodAttribute2.setCategory(electronics);
            productAttributeService.saveProductAttribute(prodAttribute2);

            ProductAttribute prodAttribute3 = new ProductAttribute();
            prodAttribute3.setProduct(laptop);
            prodAttribute3.setAttribute(color);
            prodAttribute3.setValue("Silver");
            prodAttribute3.setCategory(electronics);
            productAttributeService.saveProductAttribute(prodAttribute3);

            ProductAttribute prodAttribute4 = new ProductAttribute();
            prodAttribute4.setProduct(laptop);
            prodAttribute4.setAttribute(brand);
            prodAttribute4.setValue("HP");
            prodAttribute4.setCategory(electronics);
            productAttributeService.saveProductAttribute(prodAttribute4);

        };
    }
}
