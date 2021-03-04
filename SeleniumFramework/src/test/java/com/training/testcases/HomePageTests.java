package com.training.testcases;

import com.training.browser.Driver;
import com.training.constants.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.JsonParser;

public class HomePageTests extends  BaseTest{

    WebDriver driver;

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
