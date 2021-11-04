package com.mszeles.automation.rest;

import java.util.Arrays;

import com.mszeles.automation.rest.dao.place.AddPlace;
import com.mszeles.automation.rest.dao.place.DeletePlace;
import com.mszeles.automation.rest.dao.place.Location;

public class TestDataBuild {

	public static AddPlace getAddPlacePayload(String name, String language, String address) {
		AddPlace addPlace = new AddPlace();
		addPlace.setName(name);
		addPlace.setLanguage(language);
		addPlace.setAddress(address);
		addPlace.setTypes(Arrays.asList(new String[] { "a", "b" }));
		Location location = new Location();
		location.setLat(10.0);
		location.setLng(20);
		addPlace.setLocation(location);
		return addPlace;
	}

	public static DeletePlace getDeletPlacePayload(String placeId) {
		DeletePlace delete = new DeletePlace();
		delete.setPlaceId(placeId);
		return delete;
	}
}
