package com.ldselektronik.application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ldselektronik.abstracts.IMainApplicationWindow;
import com.ldselektronik.core.SpringApplicationContext;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Baran
 *
 */
public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@SuppressWarnings("resource")
	@Override
	public void start(Stage primaryStage) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringApplicationContext.class);
		IMainApplicationWindow mainWindow = context.getBean(IMainApplicationWindow.class);
		primaryStage.setTitle("LDS Elektronik Araç Takip Yazılımı v0.0.1");
		primaryStage.setScene(new Scene(mainWindow.getRootPane()));
		primaryStage.show();
	}
}