package com.mszeles.automation.rest;

import java.util.Arrays;

import com.mszeles.automation.rest.dao.place.AddPlace;
import com.mszeles.automation.rest.dao.place.Location;

public class TestDataBuild {

	public static AddPlace getAddPlacePayload() {
		AddPlace addLocation = new AddPlace();
		addLocation.setName("Location1");
		Location location = new Location();
		location.setLat(10.0);
		location.setLng(20);
		addLocation.setLocation(location);
		addLocation.setAddress("Address");
		addLocation.setTypes(Arrays.asList(new String[] { "a", "b" }));
		return addLocation;
	}
}
