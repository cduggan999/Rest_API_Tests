package com.restassured.api;

import static io.restassured.RestAssured.given;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@Test
public class Test05_UserNotFound {

public void test05() {
		
		// Scenario: Get/Read - Request an invalid ID of a user, expect a 404 error
		// Endpoint: /api/users/{userId}
		
		given().get("https://reqres.in/api/users/23").then().
		statusCode(404).
		log().all();
		
		
		
	}
}



