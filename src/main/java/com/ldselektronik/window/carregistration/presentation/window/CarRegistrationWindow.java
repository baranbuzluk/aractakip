package com.ldselektronik.window.carregistration.presentation.window;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import com.ldselektronik.application.abstracts.IWindow;
import com.ldselektronik.window.carregistration.data.dto.CarBrandDto;
import com.ldselektronik.window.carregistration.data.dto.CarRegistrationDto;
import com.ldselektronik.window.carregistration.presentation.view.CarRegistrationController;
import com.ldselektronik.window.carregistration.service.CarBrandService;
import com.ldselektronik.window.carregistration.service.CarRegistrationService;

import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;

/**
 * @author Baran
 *
 */
@Component
@DependsOn({ "carRegistrationService", "carBrandService" })
public class CarRegistrationWindow implements IWindow {

	@Autowired
	private CarBrandService carBrandService;

	@Autowired
	private CarRegistrationService carRegistrationService;

	private CarRegistrationController controller;

	public CarRegistrationWindow() {
		controller = new CarRegistrationController(this);
	}

	@PostConstruct
	public void init() {
		controller.loadControllerObjectDatas();
	}

	@Override
	public Pane getPane() {
		return controller.getRootPane();
	}

	public ObservableList<CarBrandDto> getAllCarBrand() {
		return carBrandService.getAll();
	}

	public ObservableList<CarRegistrationDto> getAllCarRegistration() {
		return carRegistrationService.getAll();
	}

	public ObservableList<CarRegistrationDto> searchCarRegistration(CarRegistrationDto registration) {
		return carRegistrationService.searchCarRegistration(registration);
	}

	public CarRegistrationDto findCarRegistrationById(int id) {
		return carRegistrationService.findById(id);
	}

	public void saveCarRegistration(CarRegistrationDto carRegistrationDto) {
		carRegistrationService.save(carRegistrationDto);
	}

	public boolean existsByDocumentNo(String documentNo) {
		return carRegistrationService.existsByDocumentNo(documentNo);
	}

	public void deleteById(int id) {
		carRegistrationService.deleteById(id);
	}
}
