package com.testcrew.testCases.api;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;

import com.testcrew.base.BaseTest;
import java.util.Hashtable;
import org.testng.annotations.Test;


public class Get_Request extends BaseTest {


  @Test
  public void getRequest_StatusCode(Hashtable<String, String> data) {

    given().
        baseUri(data.get("baseUri")).
        header(data.get("headerKey"), data.get("headerValue")).
        when().
        get(data.get("pathLocator")).
        then().

        assertThat().
        statusCode(200).
        log().all().
        body("workspaces.name", hasItems("My Workspace"),
            "workspaces.type", hasItems("personal"));


  }


}
