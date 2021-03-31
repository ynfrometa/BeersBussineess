package com.beersbussines.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "beer")
public class Beer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer beer_id;

	private String beername;
	private String graduation;

	private String type;
	private String description;

	@ManyToOne
	@JoinColumn(name = "manufacturer_id", nullable = false, updatable = true)
	private Manufacturer manufacturer;
	
	
	public Integer getBeer_id() {
		return beer_id;
	}

	public void setBeer_id(Integer beer_id) {
		this.beer_id = beer_id;
	}

	public String getBeername() {
		return beername;
	}

	public void setBeername(String beername) {
		this.beername = beername;
	}

	public String getGraduation() {
		return graduation;
	}

	public void setGraduation(String graduation) {
		this.graduation = graduation;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	


}
