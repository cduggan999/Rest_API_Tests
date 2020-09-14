package com.restassured.api;

import static io.restassured.RestAssured.given;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@Test
public class Test03_Update {

	
	public void test03_1() {

		// Scenario: Put/Update
		// Endpoint: /api/users/
		
		JSONObject request = new JSONObject();
		request.put("name", "Morpheus");
		request.put("job", "Zion Resident");

		System.out.println(request.toString());

		given().
		body(request.toJSONString()).
		when().
		put("https://reqres.in/api/users").
		then().statusCode(200); // 200 OK success status response code
		
	}
	
	public void test03_2() {

		// Scenario: Patch/Update
		// Endpoint: /api/users/{userId}
		
		JSONObject request = new JSONObject();
		request.put("name", "Morpheus");
		request.put("job", "Tester");

		System.out.println(request);
		System.out.println(request.toString());

		given().
		body(request.toJSONString()).
		when().
		patch("https://reqres.in/api/users/2").
		then().statusCode(200);

	}

}

