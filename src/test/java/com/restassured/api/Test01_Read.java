package com.restassured.api;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.Assert;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@Test
public class Test01_Read {
	
	public void test01_1() {

		// Scenario: Get/Read - Validate Get Request for /api/users/
		// Endpoint: /api/users/
		
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(response.statusCode());
		System.out.println(response.asString());
		System.out.println(response.getBody().asString());
		System.out.println(response.statusLine());

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);

	}

	public void test01_2() {
		
		// Scenario: Get/Read - Validate JSON body and correct field names, types, and values
		// Endpoint: /api/users/
		
		given().get("https://reqres.in/api/users?page=2").then().
		statusCode(200).
		body("page", equalTo(2)).
		body("per_page", equalTo(6)).
		body("total", equalTo(12)).
		body("total_pages", equalTo(2)).
		body("data.id[1]", equalTo(8)).
		body("data.first_name", hasItems("Michael")).
		body("data.last_name", hasItems("Lawson")).
		body("data.email", hasItems("michael.lawson@reqres.in")).
		log().all();
		
		
	}
	
	public void test01_3() {
		
		// Scenario: Get/Read - Validate first name, surname and email of user specified by Id
		// Endpoint: /api/users/{userId}
		
		given().get("https://reqres.in/api/users/1").then().
		statusCode(200).
		body("data.first_name", equalTo("George")).
		body("data.last_name", equalTo("Bluth")).
		body("data.email", equalTo("george.bluth@reqres.in")).
		log().all();
		
	}
	
	

}
