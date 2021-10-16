package com.ldselektronik.app;

import com.ldselektronik.window.CarRegistrationWindow;

import javafx.application.Application;
import javafx.stage.Stage;

public class AracTakipMain extends Application {

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("LDS Elektronik Araç Takip Yazılımı v0.0.1");
		primaryStage.setResizable(false);
		CarRegistrationWindow window = new CarRegistrationWindow();
		primaryStage.setScene(window.getScene());
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
