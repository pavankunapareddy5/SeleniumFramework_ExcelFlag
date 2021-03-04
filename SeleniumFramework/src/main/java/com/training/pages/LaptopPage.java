package com.training.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LaptopPage extends BasePage {

    @FindBy(xpath = "(//*[@class='a-icon a-icon-checkbox'])[5]")
    private WebElement checkbox_apple;

    @FindBy(xpath = "//*[@id=\"a-autoid-0-announce\"]")
    private WebElement drpdwn_menu;

    @FindBy(xpath = "//a[contains(text(),'Price: High to Low')]")
    private WebElement drpdwn_hightolow;
    
    @FindBy (xpath = "//*[@id=\"twotabsearchtextbox\"]")
    private WebElement SearchField;
    
    public LaptopPage clickAppleCheckbox() {
        click(checkbox_apple,"AppleCheckBox");
        //checkbox_apple.click();

        return this;
    }

    public LaptopPage chooseHighToLow() {
        click(drpdwn_menu,"DropDownMenu");
        click(drpdwn_hightolow, "HighToLow");
        //drpdwn_menu.click();
       // drpdwn_hightolow.click();
        return this;
    }
    
    
	public LaptopPage EnterTextToSearch(String textToEnter) {
		
		send(SearchField, textToEnter);
		
		return this;
	}

}
