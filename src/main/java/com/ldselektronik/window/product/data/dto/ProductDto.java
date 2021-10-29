package com.ldselektronik.window.product.data.dto;

import com.ldselektronik.window.product.data.entity.ProductCategory;
import com.ldselektronik.window.product.data.enums.Color;
import com.ldselektronik.window.product.data.enums.Size;

/**
 * @author Baran
 *
 */
public class ProductDto {

	private int id;

	private String name;

	private ProductCategory category;

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

	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
	}

	public String getSize() {
		return size.toString();
	}

	/**
	 * @param size must be a {@link Size} constant
	 * */
	public void setSize(String size) {
		try {
			this.size = Size.valueOf(size);
		} catch (NullPointerException e) {
			System.err.println("ERROR: Param is null.");
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			System.err.println("ERROR: Given param is not a enum constant.");
			e.printStackTrace();
		}

	}

	public String getColor() {
		return color.toString();
	}
	/**
	 * @param size must be a {@link Color} constant
	 * */
	public void setColor(String color) {
		try {
			this.color = Color.valueOf(color);
		} catch (NullPointerException e) {
			System.err.println("ERROR: Param is null.");
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			System.err.println("ERROR: Given param is not a enum constant.");
			e.printStackTrace();
		}

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
