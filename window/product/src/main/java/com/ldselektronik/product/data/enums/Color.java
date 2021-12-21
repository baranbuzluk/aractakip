package com.ldselektronik.product.data.enums;

/**
 * @author Baran
 *
 */
public enum Color {

	RED("Kırmızı"), GREEN("Yeşil"), BLUE("Mavi");

	private String name;

	private Color(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

}
