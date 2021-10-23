package com.ldselektronik.presentation.carregistration.view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;

public final class CarRegistrationControllerHelper {

	private CarRegistrationControllerHelper() {

	}

	static void loadFxml(CarRegistrationController controller) {
		try {
			FXMLLoader loader = new FXMLLoader(CarRegistrationController.class.getResource("car_registration.fxml"));
			loader.setController(controller);
			loader.load();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
