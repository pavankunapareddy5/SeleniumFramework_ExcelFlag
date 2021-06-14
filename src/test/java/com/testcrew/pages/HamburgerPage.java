package com.testcrew.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HamburgerPage extends BasePage {

  @FindBy(xpath = "//div[text()='Mobiles, Computers']/parent::a")
  private WebElement link_mobilesandcomputers;

  @FindBy(xpath = "//a[text()='Laptops']")
  private WebElement link_laptops;


  public HamburgerPage clickMobilesAndComputers() {
    click(link_mobilesandcomputers, "Mobiles and computers");
    //link_mobilesandcomputers.click();
    return this;
  }

  public LaptopPage clickLaptops() {
    //link_laptops.click();
    click(link_laptops, "Laptops");
    return new LaptopPage();
  }

}
