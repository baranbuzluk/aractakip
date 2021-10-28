package com.ldselektronik.window.product.data.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "product")
public class ProductEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = ProductCategory.class)
	@JoinColumn(name = "fk_product_category")
	private ProductCategory category;

	@Enumerated(EnumType.STRING)
	private Size size;

	@Enumerated(EnumType.STRING)
	private Color color;

	@Column(name = "credit_price")
	private int creditPrice;

	@Column(name = "cash_price")
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

	public void setYear(int year) {
		this.year = year;
	}

}
