package api_WebServices;

import org.testng.annotations.Test;

import com.training.testcases.BaseTest;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import utils.TestUtils;

import java.util.Hashtable;


public class Get_Request extends  BaseTest{
	

	@Test
	public void getRequest_StatusCode(Hashtable<String , String> data) {
		
		given().
				baseUri(data.get("baseUri")).
				header(data.get("headerKey"),data.get("headerValue")).
		when().
				get(data.get("pathLocator")).
		then().
				
				assertThat().
				statusCode(200).
				log().all().
				body("workspaces.name",hasItems("My Workspace"),
						"workspaces.type",hasItems("personal"));
		 
		
	}
	

}
