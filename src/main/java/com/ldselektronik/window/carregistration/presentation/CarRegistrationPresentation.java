package com.ldselektronik.window.carregistration.presentation;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import com.ldselektronik.application.abstracts.IWindow;
import com.ldselektronik.window.carregistration.data.entity.CarBrandEntity;
import com.ldselektronik.window.carregistration.data.entity.CarRegistrationEntity;
import com.ldselektronik.window.carregistration.presentation.view.CarRegistrationController;
import com.ldselektronik.window.carregistration.service.CarBrandService;
import com.ldselektronik.window.carregistration.service.CarRegistrationService;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;

/**
 * @author Baran
 *
 */
@Component
@DependsOn({ "carRegistrationService", "carBrandService" })
public class CarRegistrationPresentation implements IWindow {

	@Autowired
	private CarBrandService carBrandService;

	@Autowired
	private CarRegistrationService carRegistrationService;

	private CarRegistrationController controller;

	public CarRegistrationPresentation() {
		controller = new CarRegistrationController(this);
	}

	@PostConstruct
	public void init() {
		controller.loadControllerObjectDatasFromService();
	}

	@Override
	public Pane getPane() {
		return controller.getRootPane();
	}

	public ObservableList<CarBrandEntity> getAllCarBrands() {
		return FXCollections.observableArrayList(carBrandService.getAllCarBrands());
	}

	public ObservableList<CarRegistrationEntity> getAllCarRegistrations() {
		return FXCollections.observableArrayList(carRegistrationService.getAllCarRegistrations());
	}

	public ObservableList<CarRegistrationEntity> searchCarRegistration(CarRegistrationEntity registration) {
		return FXCollections.observableArrayList(carRegistrationService.searchCarRegistration(registration));
	}

	public CarRegistrationEntity findCarRegistrationById(int id) {
		return carRegistrationService.findById(id);
	}

	public void saveCarRegistration(CarRegistrationEntity entity) {
		carRegistrationService.save(entity);
	}

	public boolean existsByDocumentNo(String documentNo) {
		return carRegistrationService.existsByDocumentNo(documentNo);
	}

	public void deleteById(int id) {
		carRegistrationService.deleteById(id);
	}
}
