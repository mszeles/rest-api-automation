/*
 * Utils.java
 *
 * Copyright 2001-2008 NETAVIS Kft. All rights reserved.
 * NETAVIS PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.mszeles.automation.rest.steps;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Paths;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class DefaultSteps {

	private static final File LOG_FILE = Paths.get(System.getProperty("user.dir"), "target", "log", "requestlog.txt").toFile();

	public static RequestSpecification requestSpecification() throws IOException {
		LOG_FILE.getParentFile().mkdirs();
		LOG_FILE.createNewFile();
		PrintStream logStream = new PrintStream(new FileOutputStream(LOG_FILE, true));
		return new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addFilter(RequestLoggingFilter.logRequestTo(logStream))
				.addFilter(ResponseLoggingFilter.logResponseTo(logStream))
				.setContentType(ContentType.JSON).addQueryParam("key", "qaclick123").build();
	}

	public static ResponseSpecification responseSpecification() {
		return new ResponseSpecBuilder()
				.expectContentType(ContentType.JSON).build();
	}

}
