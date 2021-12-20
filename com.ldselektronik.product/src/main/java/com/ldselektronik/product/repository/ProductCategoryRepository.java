package com.ldselektronik.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ldselektronik.product.data.entity.ProductCategory;

/**
 * @author Baran
 *
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

}
