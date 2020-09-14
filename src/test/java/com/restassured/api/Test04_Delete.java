package com.restassured.api;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@Test
public class Test04_Delete {

	
	public void test04() {
		
		// Scenario: Delete User
		// Endpoint: /api/users/{userId}

		JSONObject request = new JSONObject();
		given().
		body(request.toJSONString()).
		when().
		delete("https://reqres.in/api/users/2").
		then().statusCode(204). // 204 No Content success status response code
		log().all();

	}

}
