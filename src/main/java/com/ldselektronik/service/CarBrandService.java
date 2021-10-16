package com.ldselektronik.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ldselektronik.model.CarBrand;
import com.ldselektronik.repository.CarBrandRepository;

@Service
@Transactional
public class CarBrandService {

	@Autowired
	private CarBrandRepository repository;

	public List<CarBrand> getAll() {
		return repository.findAll();
	}

}
