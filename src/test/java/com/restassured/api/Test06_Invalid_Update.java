package com.restassured.api;

import static io.restassured.RestAssured.given;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Test06_Invalid_Update {

	public void test06() {
		
		// Scenario: Put/Update
		// Endpoint: /api/users/
		
		JSONObject request = new JSONObject();
		request.put("name", "Morpheus");
		request.put("job", "Zion Resident");
	
	
	
		given().
		body(request.toJSONString()).
		when().
		put("https://reqres.in/api/users/2").
		then().statusCode(200); // 200 OK success status response code
	}
	
}
