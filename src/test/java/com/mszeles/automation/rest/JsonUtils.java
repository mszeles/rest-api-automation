
package com.mszeles.automation.rest;

import io.restassured.path.json.JsonPath;

public class JsonUtils {

	public static JsonPath getJson(String jsonString) {
		return new JsonPath(jsonString);
	}
}
