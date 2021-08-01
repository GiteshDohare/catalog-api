package com.omnirio.catalog.repository;

import com.omnirio.catalog.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
