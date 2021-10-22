package com.ldselektronik.app;

import com.ldselektronik.scenes.carregistration.impl.CarRegistrationScene;

import javafx.application.Application;
import javafx.stage.Stage;

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
