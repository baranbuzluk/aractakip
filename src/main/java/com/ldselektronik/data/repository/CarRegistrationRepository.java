package com.ldselektronik.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ldselektronik.data.model.CarRegistration;

@Repository
public interface CarRegistrationRepository  extends JpaRepository<CarRegistration, Integer> {
	boolean existsByDocumentNo(String documentNo);
}
