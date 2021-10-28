package com.ldselektronik.window.product.window;

import org.springframework.stereotype.Component;

import com.ldselektronik.application.abstracts.IWindow;
import com.ldselektronik.application.enums.WindowType;
import com.ldselektronik.window.product.view.ProductController;

import javafx.scene.layout.Pane;

/**
 * @author Baran
 *
 */
@Component(value = WindowType.Constant.NORMAL)
public class ProductWindow implements IWindow {

	private ProductController controller;

	public ProductWindow() {
		
		controller = new ProductController();
	}
	
	public Pane getPane() {
		return controller.getPane();
	}

}
