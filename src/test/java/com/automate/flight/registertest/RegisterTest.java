package com.automate.flight.registertest;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automate.flight.basetest.BaseTest;
import com.automate.flight.homepage.HomePage;
import com.automate.flight.pageobjects.RegisterPageObject;
import com.automate.flight.registerpage.RegisterPage;
import com.automate.flight.utility.ReadExcel;

public class RegisterTest extends BaseTest {

	HomePage homePage;
	RegisterPage registerPage;
	RegisterPageObject registerPageObj;
	ReadExcel readExcel;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow xssfRow;
	public FileInputStream fis;
	public File filePath;
	public int rowCount;
	public int colCount;
	public Object data[][];
	public XSSFCell cell;

	// @Test
	public void doRegistration() {

		registerPage.getValuesFromDropDown();
	}

	@Test(dataProvider = "getData", dataProviderClass = ReadExcel.class)
	public void enterValues(String firstNameParameter, String lastNameParameter, String phoneParameter,
			String emailParameter, String address1Parameter, String address2Parameter, String cityParameter,
			String stateParameter, String postalCodeParameter, String usernameParameter, String passwordParameter,
			String confirmPwdParameter) {
		System.out.println(firstNameParameter);
		homePage.clickRegister();
		try {
			Thread.sleep(3000);
		} catch (final InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(lastNameParameter);
		System.out.println(phoneParameter);
		RegisterPageObject.firstName.sendKeys(firstNameParameter);
		RegisterPageObject.lastName.sendKeys(lastNameParameter);
		RegisterPageObject.phone.sendKeys(phoneParameter);
		RegisterPageObject.email.sendKeys(emailParameter);
		RegisterPageObject.address1.sendKeys(address1Parameter);
		RegisterPageObject.address2.sendKeys(address2Parameter);
		RegisterPageObject.city.sendKeys(cityParameter);
		RegisterPageObject.state.sendKeys(stateParameter);
		RegisterPageObject.postalCode.sendKeys(postalCodeParameter);
		RegisterPageObject.username.sendKeys(usernameParameter);
		RegisterPageObject.password.sendKeys(passwordParameter);
		RegisterPageObject.confirmPassword.sendKeys(confirmPwdParameter);
		// RegisterPageObject.submit.click();

	}

	@BeforeMethod
	public void init() {
		homePage = new HomePage(driver);
		registerPage = new RegisterPage(driver);
		
	}
}
