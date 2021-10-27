package com.ldselektronik.application.carregistration.presentation.scene;

import com.ldselektronik.application.carregistration.presentation.view.CarRegistrationController;

import javafx.scene.Scene;

/**
 * @author Baran
 *
 */
public class CarRegistrationScene {

	private CarRegistrationController controller;

	public CarRegistrationScene() {
		controller = new CarRegistrationController();
	}

	public Scene getScene() {
		return  new Scene(controller.getPane());
	}

}
