package com.ldselektronik.application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ldselektronik.application.abstracts.IWindow;
import com.ldselektronik.configuration.SpringApplicationContext;
import com.ldselektronik.window.carregistration.presentation.CarRegistrationPresentation;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Baran
 *
 */
public class Main extends Application {

	ApplicationContext context = new AnnotationConfigApplicationContext(SpringApplicationContext.class);
	IWindow mainWindow = context.getBean(CarRegistrationPresentation.class);

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("LDS Elektronik Araç Takip Yazılımı v0.0.1");
		primaryStage.setResizable(true);
		primaryStage.setScene(new Scene(mainWindow.getPane()));
		primaryStage.show();
	}
}
