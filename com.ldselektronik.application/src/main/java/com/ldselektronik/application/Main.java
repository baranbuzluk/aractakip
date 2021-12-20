package com.ldselektronik.application;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ldselektronik.application.presentation.MainApplicationWindow;
import com.ldselektronik.core.SpringApplicationContext;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * @author Baran
 *
 */
public class Main extends Application {

	private static final int HEIGHT = 768;

	private static final int WIDTH = 1024;

	private AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
			SpringApplicationContext.class);

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("LDS Elektronik Araç Takip Yazılımı v0.0.1");
		primaryStage.setWidth(WIDTH);
		primaryStage.setHeight(HEIGHT);
		primaryStage.setMinWidth(WIDTH);
		primaryStage.setMinHeight(HEIGHT);
		primaryStage.setResizable(true);
		Scene scene = createScene();
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	private Scene createScene() {
		MainApplicationWindow mainApplicationWindow = applicationContext.getBean(MainApplicationWindow.class);
		StackPane mainPane = mainApplicationWindow.getRootPane();
		return new Scene(mainPane);
	}

	@Override
	public void stop() throws Exception {
		applicationContext.close();
		super.stop();
	}
}
