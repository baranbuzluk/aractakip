package com.ldselektronik.dto;

/**
 *
 * 
 * @author Baran
 */
public final class CarBrandDTO {

	private int id;

	private String name;
	
	public CarBrandDTO(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public CarBrandDTO() {
	}

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
	
}