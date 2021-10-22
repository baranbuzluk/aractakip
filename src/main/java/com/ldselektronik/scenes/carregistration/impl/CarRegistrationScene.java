package com.ldselektronik.scenes.carregistration.impl;

import com.ldselektronik.scenes.carregistration.view.CarRegistrationController;

import javafx.scene.Scene;

public class CarRegistrationScene {

	private CarRegistrationController controller;

	public CarRegistrationScene() {
		controller = new CarRegistrationController();
	}

	public Scene getScene() {
		Scene scene = new Scene(controller.getPane());
		return scene;
	}

}
