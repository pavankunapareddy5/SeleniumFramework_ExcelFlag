package com.testcrew.testCases.web;

import com.testcrew.base.BaseTest;
import com.testcrew.browser.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageTests extends BaseTest {

  WebDriver driver;

  // Pavan Sync44444445555566667777788888999aaaaaa
    /*@BeforeMethod
    public  void setUp() {

        System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVERPATH);
        driver = new ChromeDriver();
        driver.get(JsonParser.getValue("config.global.url"));
    }*/


  // @Test
  public void c() throws Exception {

    Driver.driver.findElement(By.name("q")).sendKeys("Selenium");
    Thread.sleep(4000);
  }

    /*@AfterMethod
    public void tearDown() {
        driver.quit();
    }*/
}
    

