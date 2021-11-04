#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@api
Feature: Validating Place APIs

	@AddPlace
  Scenario Outline: Verify if place is being successfully added using AddPlaceAPI 
    Given add place payload with "<name>" "<language>" "<address>"
    When user calls "ADD_PLACE" with "POST" http request
    Then the API call is success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
  Examples:
  	|name       |language|address|
  	|McDonalds  |English  |World cross center|
  	|Burger King|Hungarian|Széll Kálmán tér  | 
  	
  Scenario: Verify if place is being successfully deleted using DeletePlaceAPI 
    Given add place payload with "AAA" "Hungarian" "Some address"
    And user calls "ADD_PLACE" with "POST" http request
    And delete place payload
    When user calls "DELETE_PLACE" with "DELETE" http request
    Then the API call is success with status code 200
    And place does not exist anymore
    
  Scenario: Verify if created place can be get using GetPlaceAPI 
    Given add place payload with "AAA" "Hungarian" "Some address"
    And user calls "ADD_PLACE" with "POST" http request
    When user calls "GET_PLACE" with "GET" http request
    Then the API call is success with status code 200
    And "name" in response body is "AAA"
    And "language" in response body is "Hungarian"
    And "address" in response body is "Some address"
