package com.ldselektronik.window.product.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ldselektronik.window.product.data.entity.ProductCategoryEntity;

public interface ProductCategoryRepository extends JpaRepository<ProductCategoryEntity, Integer> {

}
