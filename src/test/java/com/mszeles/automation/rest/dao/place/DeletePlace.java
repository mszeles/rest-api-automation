/*
 * DeletePlace.java
 *
 * Copyright 2001-2008 NETAVIS Kft. All rights reserved.
 * NETAVIS PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.mszeles.automation.rest.dao.place;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeletePlace {

	private String placeId;

	@JsonProperty("place_id")
	public String getPlaceId() {
		return placeId;
	}

	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}

}
