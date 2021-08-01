package com.omnirio.catalog.repository;

import com.omnirio.catalog.model.ProductAttribute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductAttributeRepository extends JpaRepository<ProductAttribute, Long> {
}
