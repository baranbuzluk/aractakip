package com.ldselektronik.window.carregistration.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.stereotype.Service;

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
@Service(value = "carRegistrationService")
@Transactional
public class CarRegistrationService {

	@Autowired
	private CarRegistrationRepository repository;

	@Autowired
	private Logger logger;

	public ObservableList<CarRegistrationDto> getAll() {
		List<CarRegistrationEntity> registrationList = repository.findAll();
		List<CarRegistrationDto> registrationDTOList = registrationList.stream()
				// Converts CarRegistration object to CarRegistrationDTO object
				.map(registration -> EntityDtoConverter.toCarRegistrationDTO(registration))
				.collect(Collectors.toList());
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
		CarRegistrationEntity arg = EntityDtoConverter.toCarRegistration(registration);
		List<CarRegistrationEntity> foundList = new ArrayList<>();

		if (arg == null) {
			logger.severe("Param arg is null!");
			return FXCollections.observableArrayList();
		}

		ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase().withIgnorePaths("id", "phone",
				"companyName", "documentNo", "carLicense", "createdTime", "carBrand");

		boolean isHasName = arg.getName() != null && !arg.getName().isEmpty();
		boolean isHasSurname = arg.getSurname() != null && !arg.getSurname().isEmpty();

		if (isHasName && isHasSurname) {
			matcher = matcher.withMatcher("name", GenericPropertyMatchers.contains()).withMatcher("surname",
					GenericPropertyMatchers.contains());
		} else if (isHasName) {
			matcher = matcher.withIgnorePaths("surname").withMatcher("name", GenericPropertyMatchers.contains());
		} else if (isHasSurname) {
			matcher = matcher.withIgnorePaths("name").withMatcher("surname", GenericPropertyMatchers.contains());
		}

		foundList = repository.findAll(Example.of(arg, matcher));

		List<CarRegistrationDto> dtoList = foundList.stream().map(EntityDtoConverter::toCarRegistrationDTO)
				.collect(Collectors.toList());
		return FXCollections.observableArrayList(dtoList);
	}
}
