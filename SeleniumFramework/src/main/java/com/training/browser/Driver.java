package com.training.browser;

import com.training.constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.JsonParser;

import java.util.concurrent.TimeUnit;

public class Driver {

    public static WebDriver driver;

    /*
     * Singleton Class ---> You can have only one instance of the class for a thread
     * at a given time
     *
     * How to achieve this? You need -- Private Constructor and Static method
     *
     * Why i need a singleton when I can directly use it as method?
     *
     * To avoid thread safety issue in the static webdriver class variables --> ThreadLocal
     *
     *
     */

    private Driver (String browser ) {
        invokeDriver(browser);
        maximize();
        SetImpicitWait();

    }

     private static void invokeDriver(String browser) {

        if(browser.equalsIgnoreCase(Constants.CHROME)) {
            System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVERPATH);
            driver = new ChromeDriver();
            driver.get(JsonParser.getValue("config.global.url"));
        }
        else if (browser.equalsIgnoreCase(Constants.CHROME)) {
            System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVERPATH);
            driver = new ChromeDriver();
            driver.get(JsonParser.getValue("config.global.url"));
        }
        else if (browser.equalsIgnoreCase(Constants.CHROME)) {
            System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVERPATH);
            driver = new ChromeDriver();
            driver.get(JsonParser.getValue("config.global.url"));
        }

        else {
            System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVERPATH);
            driver = new ChromeDriver();
            driver.get(JsonParser.getValue("config.global.url"));
        }
    }

    public static void setUpDriver(String browser) {
        /*System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVERPATH);
        driver = new ChromeDriver();
        driver.get(JsonParser.getValue("config.global.url"));*/
        new Driver(browser);
    }

    public static void tearDownDriver() {
    	if(driver != null) {
        driver.quit();
    	}
    }


     private static void maximize() {
        driver.manage().window().maximize();
    }
    private static void SetImpicitWait() {
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICITWAIT, TimeUnit.SECONDS);
    }
}
