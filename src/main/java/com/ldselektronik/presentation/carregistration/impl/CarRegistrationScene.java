package com.ldselektronik.presentation.carregistration.impl;

import com.ldselektronik.presentation.carregistration.view.CarRegistrationController;

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
