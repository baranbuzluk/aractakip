package com.ldselektronik.car.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ldselektronik.car.registration.entity.CarRegistration;

/**
 * @author Baran
 *
 */
@Repository
public interface CarRegistrationRepository extends JpaRepository<CarRegistration, Integer> {

	boolean existsByDocumentNo(String documentNo);

	CarRegistration findByDocumentNo(String documentNo);
}
