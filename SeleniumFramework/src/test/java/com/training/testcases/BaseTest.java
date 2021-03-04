package com.training.testcases;

import com.training.browser.Driver;
import com.training.constants.Constants;
import com.training.reports.ExtentReport;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import utils.JsonParser;


public class BaseTest {
    @BeforeSuite
    public void setUpSuite() {

        ExtentReport.initializeReports();
    }

    @BeforeSuite
    public void tearDownSuite() {
        ExtentReport.closeReports();
    }

    @BeforeMethod
    public  void setUp() {

       // Driver.setUpDriver("chrome");
    }


    @AfterMethod
    public void tearDown() {

        Driver.tearDownDriver();
    }
}
