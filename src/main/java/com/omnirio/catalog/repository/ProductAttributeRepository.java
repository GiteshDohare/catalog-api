package com.omnirio.catalog.repository;

import com.omnirio.catalog.model.Product;
import com.omnirio.catalog.model.ProductAttribute;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductAttributeRepository extends JpaRepository<ProductAttribute, Long> {

    List<ProductAttribute> findAllByProduct(Product product);
}
