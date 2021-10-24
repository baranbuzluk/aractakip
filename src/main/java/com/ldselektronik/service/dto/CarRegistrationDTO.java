package com.ldselektronik.service.dto;

import java.util.Date;

/**
 * 
 * @author Baran
 */

public final class CarRegistrationDTO {

	private int id;

	private String name;

	private String surname;

	private String phone;

	private String companyName;

	private String documentNo;

	private String carLicense;

	private Date createdTime;

	private CarBrandDTO carBrand;

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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDocumentNo() {
		return documentNo;
	}

	public void setDocumentNo(String documentNo) {
		this.documentNo = documentNo;
	}

	public String getCarLicense() {
		return carLicense;
	}

	public void setCarLicense(String carLicense) {
		this.carLicense = carLicense;
	}

	/**
	 * @return <code>createdTime == null ? new Date() : createdTime</code>
	 */
	public Date getCreatedTime() {
		return createdTime == null ? new Date() : createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	/**
	 * @return <code>carBrand == null ? new CarBrandDTO () : carBrand</code>
	 */
	public CarBrandDTO getCarBrand() {
		return carBrand == null ? new CarBrandDTO() : carBrand;
	}

	public void setCarBrand(CarBrandDTO carBrand) {
		this.carBrand = carBrand;
	}

	public String getNameAndSurname() {
		return this.name + " " + this.surname;
	}

}