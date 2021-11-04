package com.mszeles.automation.rest.steps;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

import java.io.IOException;

import com.mszeles.automation.rest.MapAPIUrl;
import com.mszeles.automation.rest.TestDataBuild;
import com.mszeles.automation.rest.dao.place.AddPlace;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PlaceAPISteps extends DefaultSteps {

	private Response response;
	private AddPlace addPlace;
	private String placeId;

	@Given("add place payload with {string} {string} {string}")
	public void add_place_payload(String name, String language, String address) {
		addPlace = TestDataBuild.getAddPlacePayload(name, language, address);
	}

	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String apiMethod, String requestType) throws IOException {
		if (Method.POST.toString().equalsIgnoreCase(requestType)) {
			response = given().spec(requestSpecification()).body(addPlace)
					.when().post(MapAPIUrl.valueOf(apiMethod).getUrl())
					.then().spec(responseSpecification()).extract().response();
			JsonPath js = new JsonPath(response.asString());
			placeId = js.get("place_id");
			return;
		}
		else if (Method.GET.toString().equalsIgnoreCase(requestType)) {
			response = given().spec(requestSpecification()).queryParam("place_id", placeId)
					.when().get(MapAPIUrl.valueOf(apiMethod).getUrl())
					.then().spec(responseSpecification()).extract().response();
			return;
		}
		else if (Method.DELETE.toString().equalsIgnoreCase(requestType)) {
			response = given().spec(requestSpecification()).body(TestDataBuild.getDeletPlacePayload(placeId))
					.when().post(MapAPIUrl.valueOf(apiMethod).getUrl())
					.then().spec(responseSpecification()).extract().response();
			return;
		}
		else if ("PUT".equalsIgnoreCase(requestType)) {
			response = given().spec(requestSpecification()).body(addPlace)
					.when().patch(MapAPIUrl.valueOf(apiMethod).getUrl())
					.then().spec(responseSpecification()).extract().response();
			return;
		}
		throw new UnsupportedOperationException("Not implemented yet");
	}

	@Then("the API call is success with status code {int}")
	public void the_api_call_is_success_with_status_code(int statusCode) {
		assertEquals(statusCode, response.getStatusCode());
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String value) {
		String responseString = response.asString();
		JsonPath js = new JsonPath(responseString);
		String actualValue = js.get(keyValue);
		assertEquals(value, actualValue);
	}

	@Then("place does not exist anymore")
	public void place_does_not_exist_anymore() throws IOException {
		response = given().spec(requestSpecification()).queryParam("place_id", placeId)
				.when().get(MapAPIUrl.GET_PLACE.getUrl())
				.then().spec(responseSpecification()).extract().response();
		assertEquals(404, response.getStatusCode());
	}




}
