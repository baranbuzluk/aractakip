package com.ldselektronik.car.registration.entity;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
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
public class CarRegistration implements Serializable {

	private static final long serialVersionUID = -7151549754486256022L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

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

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = CarBrand.class)
	@JoinColumn(name = "fk_car_brand_id", insertable = true, updatable = true)
	private CarBrand carBrand;

	public CarRegistration() {
		createdTime = new Date();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public LocalDate getCreatedTime() {
		return Instant.ofEpochMilli(createdTime.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
	}

	public void setCreatedTime(LocalDate localDate) {
		this.createdTime = Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}

	public CarBrand getCarBrand() {
		return carBrand;
	}

	public void setCarBrand(CarBrand carBrand) {
		this.carBrand = carBrand;
	}

	public String getNameAndSurname() {
		return name + " " + surname;
	}

}