package com.ldselektronik.car.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ldselektronik.car.registration.entity.CarBrand;

/**
 * @author Baran
 *
 */
@Repository
public interface CarBrandRepository extends JpaRepository<CarBrand, Integer> {
	boolean existsByName(String name);
}
