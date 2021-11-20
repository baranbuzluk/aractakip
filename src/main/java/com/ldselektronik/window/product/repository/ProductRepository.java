package com.ldselektronik.window.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ldselektronik.window.product.data.entity.ProductEntity;
/**
 * @author Baran
 *
 */
@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer>{

}
