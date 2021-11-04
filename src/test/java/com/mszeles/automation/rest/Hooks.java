/*
 * Hooks.java
 *
 * Copyright 2001-2008 NETAVIS Kft. All rights reserved.
 * NETAVIS PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.mszeles.automation.rest;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class Hooks {

	@Before("@AddPlace")
	public void beforeAddPlaceScenario() {
		//Executing steps before aclling scenarios with addPLace
	}

	@After
	public void afterScenario() {
		//Executing steps after each scenario
	}

	@BeforeStep
	public void beforeStep() {
		//executing before each step
	}

	@AfterStep
	public void afterStep() {
		//executing after each step
	}

	@Before
	public void beforeScenario(Scenario scenario) {
		//executing before each scenario providing details like scenario name, number of steps, names of steps, and status (pass or fail)
	}

	@After
	public void afterScenario(Scenario scenario) {
		//executing before each scenario providing details like scenario name, number of steps, names of steps, and status (pass or fail)
	}

	@Before(order = 1)
	public void runBeforeScenarioFirst() {

	}

	@Before(order = 2)
	public void runBeforeScenarioSecond() {

	}





}
