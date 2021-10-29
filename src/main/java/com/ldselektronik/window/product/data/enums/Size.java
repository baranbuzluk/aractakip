package com.ldselektronik.window.product.data.enums;

/**
 * @author Baran
 *
 */
public enum Size {
	SMALL("Küçük"),MEDIUM("Orta"),LARGE("Büyük");
	
	private String name;
	
	private Size(String name) {
		this.name=name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
