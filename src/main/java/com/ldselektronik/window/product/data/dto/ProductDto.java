package com.ldselektronik.window.product.data.dto;

import com.ldselektronik.window.product.data.enums.Color;
import com.ldselektronik.window.product.data.enums.Size;

/**
 * @author Baran
 *
 */
public class ProductDto {

	private int id;

	private String name;

	private ProductCategoryDto category;

	private Size size;

	private Color color;

	private int creditPrice;

	private int cashPrice;

	private int year;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProductCategoryDto getCategory() {
		return category;
	}

	public void setCategory(ProductCategoryDto category) {
		this.category = category;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;

	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getCreditPrice() {
		return creditPrice;
	}

	public void setCreditPrice(int creditPrice) {
		this.creditPrice = creditPrice;
	}

	public int getCashPrice() {
		return cashPrice;
	}

	public void setCashPrice(int cashPrice) {
		this.cashPrice = cashPrice;
	}

	public int getYear() {
		return year;
	}

	/**
	 * @param year - it must be larger than zero
	 * @throws IllegalArgumentException if <code>year</code> is smaller than zero
	 */
	public void setYear(int year) {
		if (year > 0) {
			this.year = year;
		} else {
			throw new IllegalArgumentException("The year must not be smaller than zero");
		}

	}

}
