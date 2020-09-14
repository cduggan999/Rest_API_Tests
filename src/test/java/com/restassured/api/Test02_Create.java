package com.restassured.api;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import org.json.simple.JSONObject;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@Test
public class Test02_Create {

	public void test02() {
		
		// Scenario: Get/Read - Validate the id, first name, surname and email of an expected user exists

		JSONObject request = new JSONObject();
		request.put("name", "Morpheus");
		request.put("job", "Leader");

		System.out.println(request.toJSONString().toString());

		given().
		body(request.toJSONString()).
		when().
		post("https://reqres.in/api/users").
		then().statusCode(201 ); // 201 Created success status response code

	}
}


