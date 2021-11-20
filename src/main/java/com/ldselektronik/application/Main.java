package com.ldselektronik.application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ldselektronik.abstracts.IApplicationWindow;
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
	IApplicationWindow applicationWindow = context.getBean(IApplicationWindow.class);

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("LDS Elektronik Araç Takip Yazılımı v0.0.1");
		primaryStage.setResizable(true);
		primaryStage.setScene(new Scene(applicationWindow.getPane()));
		primaryStage.show();
	}
}
