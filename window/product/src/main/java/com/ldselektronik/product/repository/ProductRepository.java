package com.ldselektronik.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ldselektronik.product.data.entity.Product;

/**
 * @author Baran
 *
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
