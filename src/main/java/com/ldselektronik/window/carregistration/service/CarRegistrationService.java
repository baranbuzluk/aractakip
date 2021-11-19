package com.ldselektronik.window.carregistration.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.stereotype.Service;

import com.ldselektronik.window.carregistration.data.entity.CarRegistrationEntity;
import com.ldselektronik.window.carregistration.data.repository.CarRegistrationRepository;

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

	public List<CarRegistrationEntity> getAllCarRegistrations() {
		return repository.findAll();

	}

	public boolean existsByDocumentNo(String documentNo) {
		return repository.existsByDocumentNo(documentNo);
	}

	/**
	 * If there is the object has same <code>documentNo</code> value in the table,
	 * The object is not saved to the table but is updated.
	 * 
	 */
	public void save(CarRegistrationEntity registration) {
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

	/**
	 * 
	 * @return <code>null</code> - if given id is not found
	 */
	public CarRegistrationEntity findById(int id) {
		Optional<CarRegistrationEntity> optional = repository.findById(id);
		return optional.isPresent() ? optional.get() : null;
	}

	public void deleteById(int id) {
		repository.deleteById(id);
	}

	public List<CarRegistrationEntity> searchCarRegistration(CarRegistrationEntity entity) {

		if (entity == null) {
			logger.severe("Param arg is null!");
			return Arrays.asList();
		}

		ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase().withIgnorePaths("id", "phone",
				"companyName", "documentNo", "carLicense", "createdTime", "carBrand");

		boolean isHasName = entity.getName() != null && !entity.getName().isEmpty();
		boolean isHasSurname = entity.getSurname() != null && !entity.getSurname().isEmpty();

		if (isHasName && isHasSurname) {
			matcher = matcher.withMatcher("name", GenericPropertyMatchers.contains()).withMatcher("surname",
					GenericPropertyMatchers.contains());
		} else if (isHasName) {
			matcher = matcher.withIgnorePaths("surname").withMatcher("name", GenericPropertyMatchers.contains());
		} else if (isHasSurname) {
			matcher = matcher.withIgnorePaths("name").withMatcher("surname", GenericPropertyMatchers.contains());
		}

		return repository.findAll(Example.of(entity, matcher));
	}
}
