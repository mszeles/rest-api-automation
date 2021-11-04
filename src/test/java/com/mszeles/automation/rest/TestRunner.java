
package com.mszeles.automation.rest;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/com/mszeles/automation/rest/features", glue = {"classpath:com.mszeles.automation.rest.steps"})
public class TestRunner {

}
