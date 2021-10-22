package com.ldselektronik.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ldselektronik.model.CarBrand;

@Repository
public interface CarBrandRepository extends JpaRepository<CarBrand, Integer> {
	boolean existsByName(String name);
}
