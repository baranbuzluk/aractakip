package com.ldselektronik.window.carregistration.service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ldselektronik.strategy.AbstractListStrategy;
import com.ldselektronik.util.EntityDtoConverter;
import com.ldselektronik.window.carregistration.data.dto.CarRegistrationDto;
import com.ldselektronik.window.carregistration.data.entity.CarRegistrationEntity;
import com.ldselektronik.window.carregistration.data.repository.CarRegistrationRepository;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @author Baran
 *
 */
@Service
@Transactional
public class CarRegistrationService {

	@Autowired
	private CarRegistrationRepository repository;

	@Autowired
	private Logger logger;

	@Autowired
	private AbstractListStrategy<CarRegistrationRepository, CarRegistrationEntity> listStrategy;

	public ObservableList<CarRegistrationDto> getAll() {
		List<CarRegistrationEntity> registrationList = repository.findAll();
		List<CarRegistrationDto> registrationDTOList = registrationList.stream()
				// Converts CarRegistration object to CarRegistrationDTO object
				.map(registration -> EntityDtoConverter.toCarRegistrationDTO(registration)).collect(Collectors.toList());
		return FXCollections.observableArrayList(registrationDTOList);
	}

	public boolean existsByDocumentNo(String documentNo) {
		return repository.existsByDocumentNo(documentNo);
	}

	/**
	 * If there is the object has same <code>documentNo</code> value in the table,
	 * The object is not saved to the table but is updated.
	 * 
	 */
	public void save(CarRegistrationDto registration) {
		if (registration == null) {
			logger.log(Level.WARNING, "Error CarRegistrationDTO object is null!");
			return;
		}
		if (existsByDocumentNo(registration.getDocumentNo())) {
			Integer id = repository.findByDocumentNo(registration.getDocumentNo()).getId();
			registration.setId(id);
		}
		repository.save(EntityDtoConverter.toCarRegistration(registration));
	}

	/**
	 * 
	 * @return <code>null</code> - if given id is not found
	 */
	public CarRegistrationDto findById(int id) {
		Optional<CarRegistrationEntity> optional = repository.findById(id);
		return optional.isPresent() ? EntityDtoConverter.toCarRegistrationDTO(optional.get()) : null;
	}

	public void deleteById(int id) {
		repository.deleteById(id);
	}

	public ObservableList<CarRegistrationDto> searchCarRegistration(CarRegistrationDto registration) {
		List<CarRegistrationDto> dtoList = listStrategy.getListByStrategy(EntityDtoConverter.toCarRegistration(registration))
				.stream().map(EntityDtoConverter::toCarRegistrationDTO).collect(Collectors.toList());
		return FXCollections.observableArrayList(dtoList);
	}
}
