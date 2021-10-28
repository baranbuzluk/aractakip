package com.ldselektronik.window.carregistration.data.dto;

/**
 *
 * 
 * @author Baran
 */
public final class CarBrandDto {

	private int id;

	private String name;

	public CarBrandDto(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public CarBrandDto() {
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

	@Override
	public String toString() {

		return this.name;
	}

}