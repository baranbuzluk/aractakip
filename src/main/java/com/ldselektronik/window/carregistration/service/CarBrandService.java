package com.ldselektronik.window.carregistration.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ldselektronik.util.EntityDtoConverter;
import com.ldselektronik.window.carregistration.data.dto.CarBrandDto;
import com.ldselektronik.window.carregistration.data.entity.CarBrandEntity;
import com.ldselektronik.window.carregistration.data.repository.CarBrandRepository;

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

	public ObservableList<CarBrandDto> getAll() {
		List<CarBrandEntity> brandList = repository.findAll();
		// Converts CarBrand object to CarBrandDTO object
		List<CarBrandDto> brandDTOList = brandList.stream().map(brand -> EntityDtoConverter.toCarBrandDTO(brand))
				.collect(Collectors.toList());
		return FXCollections.observableArrayList(brandDTOList);
	}

	/**
	 * If there is the object has same <code>name</code> value in the table, The
	 * object is not saved to the table.
	 * 
	 */
	public void save(CarBrandDto brand) {
		if (brand == null) {
			logger.log(Level.WARNING, "Error CarBrand object is null!");
			return;
		}
		if (repository.existsByName(brand.getName()) || brand.getName().isEmpty() || brand.getName() == null)
			return;
		repository.save(EntityDtoConverter.toCarBrand(brand));
	}

}
