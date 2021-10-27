package com.ldselektronik.application;

import com.ldselektronik.application.carregistration.presentation.scene.CarRegistrationScene;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @author Baran
 *
 */
public class AracTakipMain extends Application {

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("LDS Elektronik Araç Takip Yazılımı v0.0.1");
		primaryStage.setResizable(false);
		CarRegistrationScene window = new CarRegistrationScene();
		primaryStage.setScene(window.getScene());
		primaryStage.show();
	}
}
