package com.ldselektronik.window.product.presentation.view;

import com.ldselektronik.window.product.data.entity.ProductEntity;
import com.ldselektronik.window.product.presentation.window.ProductPresentation;

import javafx.beans.value.ChangeListener;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * @author Baran
 *
 */
public final class ProductController extends BaseProductController {

	public ProductController(ProductPresentation presentation) {
		super(presentation);
		init();
	}

	public void loadControlObjectsFromService() {
		clearAndRefreshFields();
	}

	void init() {
		btnSave.setOnMouseClicked(handlerBtnSave);
		btnRefresh.setOnMouseClicked(handlerBtnRefresh);
		tableProduct.getSelectionModel().selectedItemProperty().addListener(listenerSelectedTableRow);
	}

	EventHandler<MouseEvent> handlerBtnSave = event -> {
		presentation.saveProductEntity(toDtoFromFields());
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
