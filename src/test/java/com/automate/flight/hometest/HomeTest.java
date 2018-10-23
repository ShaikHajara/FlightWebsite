package com.automate.flight.hometest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automate.flight.basetest.BaseTest;
import com.automate.flight.homepage.HomePage;
import com.automate.flight.registerpage.RegisterPage;

public class HomeTest extends BaseTest {

	HomePage homepage;

	@BeforeMethod
	public void before() {
		homepage = new HomePage(driver);
	}

	@Test
	public RegisterPage doRegistration() {
		homepage.clickRegister();
		return new RegisterPage(driver);

	}

}
