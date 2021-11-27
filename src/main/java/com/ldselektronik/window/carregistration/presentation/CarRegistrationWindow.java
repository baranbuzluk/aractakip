package com.ldselektronik.window.carregistration.presentation;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ldselektronik.abstracts.ITabWindow;
import com.ldselektronik.window.carregistration.entity.CarBrand;
import com.ldselektronik.window.carregistration.entity.CarRegistration;
import com.ldselektronik.window.carregistration.service.CarBrandService;
import com.ldselektronik.window.carregistration.service.CarRegistrationService;
import com.ldselektronik.window.carregistration.view.CarRegistrationController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.StackPane;

/**
 * @author Baran
 *
 */
@Component
public class CarRegistrationWindow implements ITabWindow {

	private static final String TAB_NAME = "Araç Takip";

	@Autowired
	private CarBrandService carBrandService;

	@Autowired
	private CarRegistrationService carRegistrationService;

	private CarRegistrationController controller;

	@PostConstruct
	void init() {
		controller = new CarRegistrationController(this);
	}

	@Override
	public StackPane getTabPane() {
		return controller.getRootPane();
	}

	public ObservableList<CarBrand> getAllCarBrands() {
		return FXCollections.observableArrayList(carBrandService.getAllCarBrands());
	}

	public ObservableList<CarRegistration> getAllCarRegistrations() {
		return FXCollections.observableArrayList(carRegistrationService.getAllCarRegistrations());
	}

	public ObservableList<CarRegistration> searchCarRegistration(CarRegistration registration) {
		return FXCollections.observableArrayList(carRegistrationService.searchCarRegistration(registration));
	}

	public void saveCarRegistration(CarRegistration entity) {
		carRegistrationService.save(entity);
	}

	public boolean existsByDocumentNo(String documentNo) {
		return carRegistrationService.existsByDocumentNo(documentNo);
	}

	public void deleteById(int id) {
		carRegistrationService.deleteById(id);
	}

	@Override
	public String getTabTitleName() {
		return TAB_NAME;
	}
}
