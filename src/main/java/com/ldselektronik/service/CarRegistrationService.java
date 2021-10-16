package com.ldselektronik.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ldselektronik.model.CarRegistration;
import com.ldselektronik.repository.CarRegistrationRepository;

@Service
@Transactional
public class CarRegistrationService {

	@Autowired
	private CarRegistrationRepository repository;

	public List<CarRegistration> getAll() {
		return repository.findAll();
	}

}
