package com.restassured.api;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;



public class Test01b_Get {

	@Test
	public void test1b() {
		// Scenario: Get/Read - Validate a specific user exists and are values are as expected
		
		JSONObject request = new JSONObject();
		request.get("https://reqres.in/api/users?page=2");
		
		// Check the first name of a expected user exists
		given().body(request.toJSONString()).then().
		statusCode(200).
		body("data.id[1]", equalTo(8)).
		body("data.first_name", hasItems("Michael","Lindsay", "Tobias")).
		log().all();
		
		// 
		given().body(request.toJSONString()).then().
		statusCode(200).
		body("data.id[1]", equalTo(8)).
		body("data.last_name", hasItems("Lawson")).
		log().all();
		
		

	}

}
