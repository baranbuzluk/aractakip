package com.ldselektronik.application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ldselektronik.application.abstracts.IWindow;
import com.ldselektronik.configuration.SpringApplicationContext;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Baran
 *
 */
public class Main extends Application {

	ApplicationContext context = new AnnotationConfigApplicationContext(SpringApplicationContext.class);
	IWindow mainWindow = context.getBean("MainWindow",IWindow.class);

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("LDS Elektronik Araç Takip Yazılımı v0.0.1");
		primaryStage.setResizable(false);
		primaryStage.setScene(new Scene(mainWindow.getPane()));
		primaryStage.show();
	}
}
