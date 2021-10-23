package com.ldselektronik.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ldselektronik.dto.CarBrandDTO;
import com.ldselektronik.dto.CarRegistrationDTO;
import com.ldselektronik.model.CarRegistration;
import com.ldselektronik.repository.CarRegistrationRepository;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

@Service
@Transactional
public class CarRegistrationService {

	@Autowired
	private CarRegistrationRepository repository;

	public ObservableList<CarRegistrationDTO> getAll() {
		List<CarRegistration> registrationList = repository.findAll();
		List<CarRegistrationDTO> registrationDTOList = registrationList.stream()
				.map(registration -> {
			CarRegistrationDTO dto = new CarRegistrationDTO();
			
			CarBrandDTO tempBrand = new CarBrandDTO();
			tempBrand.setId(registration.getId());
			tempBrand.setName(registration.getName());
			
			dto.setCarBrand(tempBrand);
			dto.setCarLicense(registration.getCarLicense());
			return dto;
		}) // Converts CarRegistration object to CarRegistrationDTO object
				.collect(Collectors.toList());

		return FXCollections.observableArrayList(registrationDTOList);
	}

}
