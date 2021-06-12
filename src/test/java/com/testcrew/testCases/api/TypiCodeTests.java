package com.testcrew.testCases.api;

import static io.restassured.RestAssured.given;

import com.testcrew.base.BaseTest;
import java.util.Hashtable;
import org.testng.annotations.Test;

public class TypiCodeTests extends BaseTest {

  @Test
  public void typiCodeGetTest(Hashtable<String, String> data) {
    given()
        .log().all(true)
        .get(data.get("baseUri"))
        .then().log().all(true)
        .and().extract().response();
  }

}
