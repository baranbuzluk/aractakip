package com.ldselektronik.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ldselektronik.dto.CarRegistrationDTO;
import com.ldselektronik.dto.converter.Converter;
import com.ldselektronik.model.CarRegistration;
import com.ldselektronik.repository.CarRegistrationRepository;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

@Service
@Transactional
public class CarRegistrationService {

	@Autowired
	private CarRegistrationRepository repository;

	@Autowired
	private Logger logger;

	public ObservableList<CarRegistrationDTO> getAll() {
		List<CarRegistration> registrationList = repository.findAll();
		List<CarRegistrationDTO> registrationDTOList = registrationList.stream()
				// Converts CarRegistration object to CarRegistrationDTO object
				.map(registration -> Converter.toCarRegistrationDTO(registration)).collect(Collectors.toList());
		return FXCollections.observableArrayList(registrationDTOList);
	}

	/**
	 * If there is the object has same <code>documentNo</code> value in the table,
	 * The object is not saved to the table.
	 * 
	 */
	public void save(CarRegistrationDTO registration) {
		if (registration == null) {
			logger.log(Level.WARNING, "Error CarRegistrationDTO object is null!");
			return;
		}
		if (repository.existsByDocumentNo(registration.getDocumentNo()))
			return;
		repository.save(Converter.toCarRegistration(registration));
	}
}
