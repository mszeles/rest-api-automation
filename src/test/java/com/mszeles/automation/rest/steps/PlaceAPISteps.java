package com.mszeles.automation.rest.steps;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.io.IOException;

import com.mszeles.automation.rest.TestDataBuild;
import com.mszeles.automation.rest.dao.place.AddPlace;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PlaceAPISteps extends DefaultSteps {

	private Response response;
	private AddPlace addLocation;

	@Given("add place payload with {string} {string} {string}")
	public void add_place_payload(String name, String language, String address) {
		addLocation = TestDataBuild.getAddPlacePayload(name, language, address);
	}

	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String apiMethod, String requestType) throws IOException {
		if ("AddPlaceAPI".equals(apiMethod)) {
			if ("POST".equalsIgnoreCase(requestType)) {
				response = given().spec(requestSpecification()).body(addLocation).when().post("maps/api/place/add/json")
						.then().spec(responseSpecification()).body("scope", equalTo("APP")).extract().response();
				return;
			}
		}
		throw new UnsupportedOperationException("Not implemented yet");
	}

	@Then("the API call is success with status code {int}")
	public void the_api_call_is_success_with_status_code(int statusCode) {
		assertEquals(response.getStatusCode(), statusCode);
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String value) {
		String responseString = response.asString();
		JsonPath js = new JsonPath(responseString);
		String actualValue = js.get(keyValue);
		assertEquals(actualValue,  value);
	}

}
