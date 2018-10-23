package com.automate.flight.homepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.automate.flight.basepage.BasePage;
import com.automate.flight.pageobjects.HomePageObject;

public class HomePage extends BasePage {

	HomePageObject homePageObj = new HomePageObject();

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, homePageObj);
		// TODO Auto-generated constructor stub
	}

	/**
	 *
	 */

	public void clickRegister() {
		homePageObj.register.click();
	}
}
