package com.testcrew.base;

import com.testcrew.constants.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Contains all browser action reusable methods
 */
public class UiBaseModule {

  private static final Logger LOGGER = LogManager.getLogger(UiBaseModule.class);
  private static WebDriver driver;

  private UiBaseModule() {
  }

  public static void setDriver(WebDriver driver) {
    UiBaseModule.driver = driver;
  }

  public static void sleep(int sleepInSeconds) {
    try {
      LOGGER.info("Waiting for {} Seconds", sleepInSeconds);
      Thread.sleep(sleepInSeconds * 1000L);
    } catch (Exception e) {
      //
    }
  }

  public static void openUrl(String url) {
    openUrl(url, "Opened : " + url);
    driver.get(url);
  }


  public static void openUrl(String url, String message) {
    driver.get(url);
  }


  public static WebElement find(By by) {
    WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICITWAIT);
    return wait.until(ExpectedConditions.elementToBeClickable(by));
  }


  public static WebElement find(WebElement webElement) {
    WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICITWAIT);
    return wait.until(ExpectedConditions.elementToBeClickable(webElement));
  }

  public static void click(By by) {
    click(by, "Clicked : " + by.toString());
  }

  public static void click(By by, String message) {
    click(find(by), message);
  }


  public static void click(WebElement webElement, String message) {
    webElement.click();
  }


  public static void waitUntilClickable(By by) {
    WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICITWAIT);
    wait.until(ExpectedConditions.elementToBeClickable(by));
  }


  public static void waitUntilClickable(WebElement webElement) {
    WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICITWAIT);
    wait.until(ExpectedConditions.elementToBeClickable(webElement));
  }


  public static boolean checkIfWebElementExists(By by) {
    try {
      if (driver.findElement(by).isDisplayed()) {
        return true;
      }
    } catch (Exception e) {
      return false;
    }
    return false;
  }


  public static boolean checkIfWebElementExists(WebElement webelement) {
    try {
      if (webelement.isDisplayed()) {
        return true;
      }
    } catch (Exception e) {
      return false;
    }
    return false;
  }


  public static boolean waitForElementAtIntervals(By by, int interval, int maxWait) {
    boolean elementExists = false;
    try {
      int initialWait = 0;
      while (initialWait <= maxWait) {
        if (checkIfWebElementExists(by)) {
          elementExists = true;
          LOGGER.info("Found element [{}] after waiting for [{}]", by.toString(), initialWait);
          initialWait = maxWait + 1;
        } else {
          sleep(1);
          initialWait = initialWait + interval;
        }
      }
      if (!elementExists) {
        LOGGER.info("WebElement [{}] not found", by.toString());
      }
    } catch (Exception e) {
      //
    }
    return elementExists;
  }


  public static boolean waitForElementAtIntervalsAndClick(By by, int interval, int maxTime) {
    boolean flag = waitForElementAtIntervals(by, interval, maxTime);
    if (flag) {
      click(by);
    }
    return flag;
  }

  public static void clickByJS(By by) {
    clickByJS(driver.findElement(by), "Clicked web element by JS : " + by.toString());
  }


  public static void clickByJS(WebElement webElement, String message) {
    JavascriptExecutor executor = (JavascriptExecutor) driver;
    executor.executeScript("arguments[0].click();", webElement);
  }

  public static void enterText(By by, String value) {
    enterText(find(by), value, String.format("Entered text [%s] in webElement [%s]", value, by.toString()));
  }

  public static void enterText(By by, String value, String message) {
    enterText(find(by), value, message);
  }


  public static void enterText(WebElement webElement, String value, String message) {
    webElement.sendKeys(value);
  }


  public static String getText(By by) {
    return find(by).getText();
  }


  public static String getText(WebElement webElement) {
    return webElement.getText();
  }


  public Object executeJs(String javaScript) {
    JavascriptExecutor executor = (JavascriptExecutor) driver;
    return executor.executeScript(javaScript);
  }

}
