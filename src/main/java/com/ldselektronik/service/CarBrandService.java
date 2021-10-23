package com.ldselektronik.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ldselektronik.dto.CarBrandDTO;
import com.ldselektronik.model.CarBrand;
import com.ldselektronik.repository.CarBrandRepository;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;

/**
 * 
 * @author Baran
 *
 */
@Service
@Transactional
public class CarBrandService {

	@Autowired
	private CarBrandRepository repository;

	public ObservableList<CarBrandDTO> getAll() {
		List<CarBrand> brandList = repository.findAll();
		List<CarBrandDTO> brandDTOList	= brandList
				.stream()
				.map(brand -> new CarBrandDTO(brand.getId(), brand.getName())) // Converts CarBrand object to CarBrandDTO object
				.collect(Collectors.toList());
		
		return FXCollections.observableArrayList(brandDTOList);
	}

	/**
	 * If there is the object has same <code>name</code> value in the table, The
	 * object is not saved to the table.
	 * 
	 */
	public void save(CarBrandDTO brand) {

		if (brand == null) {
			System.out.println("Error CarBrand object is null!");
			return;
		}

		if (repository.existsByName(brand.getName()) || brand.getName().isEmpty() || brand.getName() == null)
			return;

		CarBrand temp = new CarBrand();
		temp.setId(brand.getId());
		temp.setName(brand.getName());
		repository.save(temp);
	}

}
