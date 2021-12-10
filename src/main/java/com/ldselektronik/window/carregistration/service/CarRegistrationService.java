package com.ldselektronik.window.carregistration.service;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.ldselektronik.window.carregistration.entity.CarRegistration;
import com.ldselektronik.window.carregistration.repository.CarRegistrationRepository;

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

	public ObservableList<CarRegistration> getAllCarRegistrations() {
		return FXCollections.observableArrayList(repository.findAll());

	}

	public boolean existsByDocumentNo(String documentNo) {
		return repository.existsByDocumentNo(documentNo);
	}

	/**
	 * If there is the object has same <code>documentNo</code> value in the table,
	 * The object is not saved to the table but is updated.
	 * 
	 */
	public void save(CarRegistration registration) {
		if (registration == null) {
			logger.log(Level.WARNING, "Error CarRegistrationEntity object is null!");
			return;
		}
		if (existsByDocumentNo(registration.getDocumentNo())) {
			Integer id = repository.findByDocumentNo(registration.getDocumentNo()).getId();
			registration.setId(id);
		}
		repository.save(registration);
	}

	public void delete(CarRegistration entity) {
		repository.delete(entity);
	}

	public ObservableList<CarRegistration> searchCarRegistration(CarRegistration entity) {
		if (entity == null) {
			return FXCollections.observableArrayList();
		}
		return FXCollections.observableArrayList(repository
				.findAll(Example.of(entity, ExampleMatcher.matchingAll().withIgnoreCase().withIgnoreNullValues())));
	}
}
