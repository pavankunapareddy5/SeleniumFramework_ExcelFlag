package com.training.testcases;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.browser.Driver;
import com.training.pages.BasePage;
import com.training.pages.HamburgerPage;
import com.training.pages.HomePage;
import com.training.pages.LaptopPage;
//import com.training.reports.ExtentManager;
import com.training.reports.ExtentManager;
import com.training.reports.ExtentReport;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utils.TestUtils;

import java.lang.reflect.Method;
import java.util.Hashtable;

public class LoginTests extends  BaseTest{

    WebDriver driver;

   /* @BeforeMethod
    public  void setUp() {

        System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVERPATH);
        driver = new ChromeDriver();
        driver.get(JsonParser.getValue("config.global.url"));
    }*/
  //  @Test
    public void b() throws Exception {

        Driver.driver.findElement(By.name("q")).sendKeys("Automation");
        Thread.sleep(4000);
    }
    HomePage hpage;
    HamburgerPage hampage;
    LaptopPage lpage;

   // @Test
    public void dataProviderTest(Hashtable<String , String> data ) {
        System.out.println(data.get("username"));
        System.out.println(data.get("password"));
        System.out.println(data.get("firstname"));
    }

   // @Test
    public void testcase1(Hashtable<String , String> data ) {
        System.out.println(data.get("username"));
        System.out.println(data.get("password"));
        System.out.println(data.get("firstname"));
    }


    //@Test
    public void amazon(Method m,Hashtable<String , String> data) throws Exception {
        Driver.setUpDriver("chrome");
        hpage = new HomePage();
        hampage = hpage.clickHamburgerMenu();
        //ExtentTest test = ExtentReport.report.startTest(m.getName());
        lpage = hampage.clickMobilesAndComputers().clickLaptops();
        //test.log(LogStatus.PASS,"Clicked on laptops");
        lpage.clickAppleCheckbox().chooseHighToLow().EnterTextToSearch(data.get("SearchField"));
        //ExtentReport.report.endTest(test);
        BasePage.Wait();

    }
    
    @Test
    public void amazon1(Method m,Hashtable<String , String> data) throws Exception {
        Driver.setUpDriver("chrome");
        hpage = new HomePage();
        hampage = hpage.clickHamburgerMenu();       
        lpage = hampage.clickMobilesAndComputers().clickLaptops();        
        lpage.clickAppleCheckbox().chooseHighToLow().EnterTextToSearch(data.get("SearchField"));        
        BasePage.Wait();

    }

   /* @AfterMethod
    public void tearDown() {
        driver.quit();
    }*/
}
