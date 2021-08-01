package com.omnirio.catalog.repository;

import com.omnirio.catalog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
