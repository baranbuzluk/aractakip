package com.ldselektronik.application.carregistration.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ldselektronik.application.carregistration.data.entity.CarRegistrationEntity;

/**
 * @author Baran
 *
 */
@Repository
public interface CarRegistrationRepository extends JpaRepository<CarRegistrationEntity, Integer> {
	
	boolean existsByDocumentNo(String documentNo);

	CarRegistrationEntity findByDocumentNo(String documentNo);
}
