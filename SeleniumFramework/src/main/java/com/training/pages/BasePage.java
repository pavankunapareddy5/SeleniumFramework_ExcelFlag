package com.training.pages;

import com.training.browser.Driver;
import com.training.constants.Constants;
import com.training.reports.LogStatus;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected BasePage() {
        PageFactory.initElements(Driver.driver,this);
    }

    /*
        Creating Constructor in Base Class -- Hence if sub class is extending a parent class then
        parent class constructor will also be called

        Protected Keyword  --> to allow access for child classes


     */


    public static void click(WebElement element, String name) {
        explicitlyWait(element);
        ScrollToElement(element);
        HighLightElement(element);
        element.click();
        //LogStatus.pass(name + "is clicked successfully");
    }
    
    public static void send(WebElement element, String textToEnter) {
        explicitlyWait(element);
        ScrollToElement(element);
        element.clear();
        HighLightElement(element);
        element.sendKeys(textToEnter);
     
    }
    
    public static void Wait() {
    	new WebDriverWait(Driver.driver,Constants.IMPLICITWAIT);
    }

    public static void explicitlyWait(WebElement element) {
        new WebDriverWait(Driver.driver, Constants.EXPLICITWAIT)
                .until(ExpectedConditions.visibilityOf(element));
    }
    
    public static void ScrollToElement(WebElement element) {
    	try {
            JavascriptExecutor js = (JavascriptExecutor) Driver.driver;
            js.executeScript("arguments[0].style.background='LightBlue'", new Object[]{element});
            
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public static void HighLightElement(WebElement element) {
    	 try {
            JavascriptExecutor jsExec = (JavascriptExecutor) Driver.driver;
            jsExec.executeScript("arguments[0].scrollIntoView({block: \"center\"});", new Object[]{element});
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
