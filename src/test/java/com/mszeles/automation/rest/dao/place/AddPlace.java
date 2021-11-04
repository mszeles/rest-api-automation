package com.mszeles.automation.rest.dao.place;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddPlace {
	private Location		location;
	private int				accuracy;
	private String			name;
	private String			phoneNumber;
	private String			address;
	private List<String>	types;
	private String			website;
	private String			language;

	@JsonProperty("location")
	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@JsonProperty("accuracy")
	public int getAccuracy() {
		return this.accuracy;
	}

	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}

	@JsonProperty("name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("phone_number")
	public String getPhone_number() {
		return this.phoneNumber;
	}

	public void setPhone_number(String phone_number) {
		this.phoneNumber = phone_number;
	}

	@JsonProperty("address")
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@JsonProperty("types")
	public List<String> getTypes() {
		return this.types;
	}

	public void setTypes(List<String> types) {
		this.types = types;
	}

	@JsonProperty("website")
	public String getWebsite() {
		return this.website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	@JsonProperty("language")
	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

}