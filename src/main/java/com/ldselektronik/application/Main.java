package com.ldselektronik.application;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ldselektronik.application.view.MainApplicationController;
import com.ldselektronik.configuration.SpringApplicationContext;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Baran
 *
 */
public class Main extends Application {

	public static void main(String[] args) {
		startApplicationContext();
		launch(args);

	}

	@SuppressWarnings("resource")
	private static void startApplicationContext() {
		new AnnotationConfigApplicationContext(SpringApplicationContext.class);
	}

	@Override
	public void start(Stage primaryStage) {
		MainApplicationController controller = new MainApplicationController();
		primaryStage.setTitle("LDS Elektronik Araç Takip Yazılımı v0.0.1");
		primaryStage.setWidth(800);
		primaryStage.setHeight(600);
		primaryStage.setResizable(true);
		primaryStage.setScene(new Scene(controller.getRootPane()));
		primaryStage.show();
	}
}
