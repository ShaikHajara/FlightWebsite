package com.automate.flight.registerpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.automate.flight.basepage.BasePage;
import com.automate.flight.pageobjects.RegisterPageObject;

public class RegisterPage extends BasePage {

	RegisterPageObject registerPageObj = new RegisterPageObject();

	public RegisterPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, registerPageObj);

		// TODO Auto-generated constructor stub
	}

	public void getCountryValuesFromDropDown() {
		final Select s = new Select((WebElement) RegisterPageObject.countryDropDown);
		System.out.println(s.getOptions().stream().count());
		s.getOptions().stream().forEach(li -> System.out.println(li.getText()));

	}

	public void register() {

	}

	public void selectOneCountry() {
		System.out.println(RegisterPageObject.countryDropDown.get(92));
	}

}
