package com.ldselektronik.window.product.view;

import com.ldselektronik.window.product.data.entity.ProductEntity;
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
		clearAndRefreshFields();
	}

	void init() {
		btnSave.setOnMouseClicked(handlerBtnSave);
		btnRefresh.setOnMouseClicked(handlerBtnRefresh);
		tableProductEntities.getSelectionModel().selectedItemProperty().addListener(listenerSelectedTableRow);
	}

	EventHandler<MouseEvent> handlerBtnSave = event -> {
		presentation.saveProductEntity(toEntityFromFields());
		clearAndRefreshFields();
	};

	EventHandler<MouseEvent> handlerBtnRefresh = event -> clearAndRefreshFields();

	ChangeListener<ProductEntity> listenerSelectedTableRow = (observable, oldValue, newValue) -> {
		if (newValue == null) {
			clearAndRefreshFields();
		}
		toFieldFromEntity(newValue);
	};

}
