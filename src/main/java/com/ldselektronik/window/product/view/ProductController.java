package com.ldselektronik.window.product.view;

import com.ldselektronik.window.product.data.entity.Product;
import com.ldselektronik.window.product.presentation.ProductWindow;

import javafx.beans.value.ChangeListener;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * @author Baran
 *
 */
public final class ProductController extends BaseProductController {

	public ProductController(ProductWindow presentation) {
		super(presentation);
		init();
		clearFields();
	}

	void init() {
		btnSave.setOnMouseClicked(handlerBtnSave);
		btnRefresh.setOnMouseClicked(handlerBtnRefresh);
		tableProductEntities.getSelectionModel().selectedItemProperty().addListener(listenerSelectedTableRow);
	}

	EventHandler<MouseEvent> handlerBtnSave = event -> {
		presentation.saveProductEntity(toEntityFromFields());
		clearFields();
	};

	EventHandler<MouseEvent> handlerBtnRefresh = event -> clearFields();

	ChangeListener<Product> listenerSelectedTableRow = (observable, oldValue, newValue) -> {
		if (newValue == null) {
			clearFields();
		}
		toFieldFromEntity(newValue);
	};

}
