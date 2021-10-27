package com.ldselektronik.application.carregistration.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ldselektronik.application.carregistration.data.entity.CarBrandEntity;

/**
 * @author Baran
 *
 */
@Repository
public interface CarBrandRepository extends JpaRepository<CarBrandEntity, Integer> {
	boolean existsByName(String name);
}
