
package com.mszeles.automation.rest;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty",
		"html:target/cucumber-reports/cucumber.html",
		"json:target/cucumber-reports/cucumber.json"
},
features = "src/test/java/com/mszeles/automation/rest/features",
glue = {"classpath:com.mszeles.automation.rest.steps"})
//@CucumberOptions(features = "src/test/java/com/mszeles/automation/rest/features", glue = {"classpath:com.mszeles.automation.rest.steps"}, tags = "@AddPlace")
public class TestRunner {

}
