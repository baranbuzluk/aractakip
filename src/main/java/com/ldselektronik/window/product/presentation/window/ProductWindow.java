package com.ldselektronik.window.product.presentation.window;

import com.ldselektronik.application.abstracts.IWindow;
import com.ldselektronik.window.product.presentation.view.ProductController;

import javafx.scene.layout.Pane;

/**
 * @author Baran
 *
 */

public class ProductWindow implements IWindow {

	private ProductController controller;

	public ProductWindow() {
		
		controller = new ProductController();
	}
	
	public Pane getPane() {
		return controller.getPane();
	}

}
