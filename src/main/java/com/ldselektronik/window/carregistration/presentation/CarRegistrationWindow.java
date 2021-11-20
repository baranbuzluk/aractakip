package com.ldselektronik.window.carregistration.presentation;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.ldselektronik.abstracts.ITabWindow;
import com.ldselektronik.enums.TabWindowOrder;
import com.ldselektronik.window.carregistration.data.entity.CarBrandEntity;
import com.ldselektronik.window.carregistration.data.entity.CarRegistrationEntity;
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
@Order(TabWindowOrder.CAR_REGISTRATION_ORDER)
@DependsOn({ "carRegistrationService", "carBrandService" })
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
	public StackPane getPane() {
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

	@Override
	public String getTabName() {
		return TAB_NAME;
	}
}
