/*
 * Utils.java
 *
 * Copyright 2001-2008 NETAVIS Kft. All rights reserved.
 * NETAVIS PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.mszeles.automation.rest.steps;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Paths;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class DefaultSteps {

	private static final File LOG_FILE = Paths.get(System.getProperty("user.dir"), "target", "log", "requestlog.txt").toFile();
	private static RequestSpecification requestSpecification;

	public static RequestSpecification requestSpecification() throws IOException {
		if (requestSpecification == null) {
			LOG_FILE.getParentFile().mkdirs();
			PrintStream logStream = new PrintStream(new FileOutputStream(LOG_FILE));
			requestSpecification = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl"))
					.addFilter(RequestLoggingFilter.logRequestTo(logStream))
					.addFilter(ResponseLoggingFilter.logResponseTo(logStream))
					.setContentType(ContentType.JSON).addQueryParam("key", "qaclick123").build();
		}
		return requestSpecification;
	}

	public static ResponseSpecification responseSpecification() {
		return new ResponseSpecBuilder()
				.expectContentType(ContentType.JSON).build();
	}

	public static String getGlobalValue(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(Paths.get(System.getProperty("user.dir"), "src", "test", "resources", "global.properties").toFile());
		prop.load(fis);
		return prop.getProperty(key);
	}

	public static String getJsonValue(String jsonString, String path) {
		JsonPath js = new JsonPath(jsonString);
		return js.get(path).toString();
	}

}
