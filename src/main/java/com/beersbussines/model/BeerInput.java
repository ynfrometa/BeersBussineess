package com.beersbussines.model;

public class BeerInput {
	
	private Integer beer_id;
	private String beername;
	private String graduation;
	private String type;
	private String description;
	private Integer manufacturer_id;
	
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
	public Integer getManufacturer_id() {
		return manufacturer_id;
	}
	public void setManufacturer_id(Integer manufacturer_id) {
		this.manufacturer_id = manufacturer_id;
	}
	

}
