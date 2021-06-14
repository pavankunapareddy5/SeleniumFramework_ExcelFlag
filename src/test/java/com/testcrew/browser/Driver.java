package com.testcrew.browser;

import com.testcrew.constants.Constants;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

  public static WebDriver driver;

  private Driver(String browser) {
    invokeDriver(browser);
    manageDriver();
    SetImpicitWait();
  }

  private static void invokeDriver(String browser) {
    if (browser.equalsIgnoreCase(Constants.CHROME)) {
      System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVERPATH);
      driver = new ChromeDriver();
    } /*else if (browser.equalsIgnoreCase(Constants.CHROME)) {
      System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVERPATH);
      driver = new ChromeDriver();
    } else if (browser.equalsIgnoreCase(Constants.CHROME)) {
      System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVERPATH);
      driver = new ChromeDriver();
    } else {
      System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVERPATH);
      driver = new ChromeDriver();
    }*/
  }

  public static void setUpDriver(String browser) {
    new Driver(browser);
  }

  public static void tearDownDriver() {
    if (driver != null) {
      driver.quit();
    }
  }

  private static void manageDriver() {
    driver.manage().window().maximize();
    driver.manage().timeouts().pageLoadTimeout(Constants.PAGELOADWAIT, TimeUnit.SECONDS);
    driver.manage().timeouts().setScriptTimeout(Constants.PAGELOADWAIT, TimeUnit.SECONDS);
  }

  private static void SetImpicitWait() {
    driver.manage().timeouts().implicitlyWait(Constants.IMPLICITWAIT, TimeUnit.SECONDS);
  }
}
