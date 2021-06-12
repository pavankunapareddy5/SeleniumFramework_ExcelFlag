package com.testcrew.testCases.web;

import com.testcrew.base.BaseTest;
import com.testcrew.base.UiBaseModule;
import com.testcrew.browser.Driver;
import java.util.Hashtable;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AmazonTests extends BaseTest {

  @BeforeMethod
  public void setUp() {
    Driver.setUpDriver("chrome");
    UiBaseModule.setDriver(Driver.driver);
  }

  @Test
  public void amazonSearchProductTest(Hashtable<String, String> data) {
    UiBaseModule.openUrl(data.get("baseUri"), "Opened amazon url");
    UiBaseModule.enterText(By.id("twotabsearchtextbox"), data.get("SearchField"), "Searched for : Iphone");
    UiBaseModule.click(By.cssSelector("input[value='Go']"), "Clicked Go button next to search box");
    UiBaseModule.sleep(1);
  }

  @AfterMethod
  public void tearDown() {
    Driver.tearDownDriver();
  }

}
