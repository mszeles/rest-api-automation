package com.mszeles.automation.rest.dao.place;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Location {
	private double	lat;
	private double	lng;

	@JsonProperty("lat")
	public double getLat() {
		return this.lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	@JsonProperty("lng")
	public double getLng() {
		return this.lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}
}