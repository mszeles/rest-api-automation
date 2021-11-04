/*
 * MapAPIUrl.java
 *
 * Copyright 2001-2008 NETAVIS Kft. All rights reserved.
 * NETAVIS PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.mszeles.automation.rest;

public enum MapAPIUrl {
	ADD_PLACE("maps/api/place/add/json"),
	GET_PLACE("maps/api/place/get/json"),
	DELETE_PLACE("maps/api/place/delete/json")
	;
	private final String url;

	MapAPIUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}
}
