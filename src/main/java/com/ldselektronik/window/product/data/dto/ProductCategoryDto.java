package com.ldselektronik.window.product.data.dto;

/**
 * @author Baran
 *
 */
public class ProductCategoryDto {

	private int id;

	private String name;

	public ProductCategoryDto() {
		
	}
	
	
	public ProductCategoryDto(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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
