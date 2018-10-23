package com.automate.flight.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPageObject {

	@FindBy(xpath = "//*[contains(@name,'firstName')]")
	public static WebElement firstName;

	@FindBy(xpath = "//*[contains(@name,'lastName')]")
	public static WebElement lastName;

	@FindBy(xpath = "//*[contains(@name,'phone')]")
	public static WebElement phone;

	@FindBy(id = "userName")
	public static WebElement email;

	@FindBy(xpath = "//*[contains(@name,'address1')]")
	public static WebElement address1;

	@FindBy(xpath = "//*[contains(@name,'address2')]")
	public static WebElement address2;

	@FindBy(xpath = "//*[contains(@name,'city')]")
	public static WebElement city;

	@FindBy(xpath = "//*[contains(@name,'state')]")
	public static WebElement state;

	@FindBy(xpath = "//*[contains(@name,'postalCode')]")
	public static WebElement postalCode;

	@FindBy(xpath = "//select[ @name='country' ]")
	public static WebElement countryDropDown;

	@FindBy(id = "email")
	public static WebElement username;

	@FindBy(xpath = "//*[contains(@name,'password')]")
	public static WebElement password;

	@FindBy(xpath = "//*[contains(@name,'confirmPassword')]")
	public static WebElement confirmPassword;

	@FindBy(xpath = "//*[contains(@name,'register')]")
	public static WebElement submit;

}
