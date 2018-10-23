package com.automate.flight.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageObject {

	@FindBy(linkText = "REGISTER")
	public WebElement register;

}
