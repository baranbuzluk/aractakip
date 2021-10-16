package com.ldselektronik.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ldselektronik.model.CarRegistration;

@Repository
public interface CarRegistrationRepository  extends JpaRepository<CarRegistration, Integer> {

}
