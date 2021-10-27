package com.ldselektronik.application.carregistration.data.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * Araç kayıtlarının tutulacağı tablodur.
 * 
 * @author Baran
 */
@Entity(name = "car_registration")
public class CarRegistrationEntity implements Serializable {

	private static final long serialVersionUID = -7151549754486256022L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	
	private String surname;
	
	private String phone;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "document_no")
	private String documentNo;

	@Column(name = "car_license")
	private String carLicense;

	@Column(name = "created_time")
	@Temporal(TemporalType.DATE)
	private Date createdTime;

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = CarBrandEntity.class)
	@JoinColumn(name = "fk_car_brand_id", insertable = true,updatable = true)
	private CarBrandEntity carBrand;
	
	public CarRegistrationEntity() {
		createdTime = new Date();
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

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public CarBrandEntity getCarBrand() {
		return carBrand;
	}

	public void setCarBrand(CarBrandEntity carBrand) {
		this.carBrand = carBrand;
	}

}