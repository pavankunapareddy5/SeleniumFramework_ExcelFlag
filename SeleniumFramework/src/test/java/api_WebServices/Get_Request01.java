// Source : https://www.youtube.com/watch?v=JJ7Tp7_fX4c
 
package api_WebServices;

import static io.restassured.RestAssured.*;
import java.sql.SQLException;
import org.testng.Assert;
import org.testng.annotations.Test;

import database.DatabaseQueryManagement;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Get_Request01 {
	
	DatabaseQueryManagement db = new DatabaseQueryManagement();
	
	@Test
	void test_01() throws ClassNotFoundException, SQLException {
		
		Response response = get("https://reqres.in/api/users?page=2");
		System.out.println(response.asString());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		System.out.println(response.getTime());
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);	
		db.connectToDB().executeQuery();
	}
	
	@Test
	void test_02() {
		given()
			.get("https://reqres.in/api/users?page=2")
			.then()
				.statusCode(200)
				.body("data.id[0]", equalTo(7));
		
		
		
	}
	
}

	