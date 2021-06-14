package com.testcrew.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

  @FindBy(id = "nav-hamburger-menu")
  private WebElement link_hamburgermenu;


  public HamburgerPage clickHamburgerMenu() {
    click(link_hamburgermenu, "HamburgerMenu");
    //link_hamburgermenu.click();
    //ExtentManager.getTest().log(LogStatus.PASS,"HamburgerMenu is clicked Successfully");
    //LogStatus.pass("Successfully clicked on Mobiles");
    return new HamburgerPage();
  }
}