package com.ldselektronik.window.carregistration.service;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ldselektronik.window.carregistration.entity.CarBrand;
import com.ldselektronik.window.carregistration.repository.CarBrandRepository;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * 
 * @author Baran
 *
 */
@Service(value = "carBrandService")
@Transactional
public class CarBrandService {

	@Autowired
	private CarBrandRepository repository;

	@Autowired
	private Logger logger;

	public ObservableList<CarBrand> getAllCarBrands() {
		return FXCollections.observableArrayList(repository.findAll());

	}

	/**
	 * If there is the object has same <code>name</code> value in the table, The
	 * object is not saved to the table.
	 */
	public void save(CarBrand entity) {
		if (entity == null) {
			logger.log(Level.WARNING, "Error CarBrand object is null!");
			return;
		}
		if (repository.existsByName(entity.getName()) || entity.getName().isEmpty() || entity.getName() == null)
			return;
		repository.save(entity);
	}

}
