package com.automate.flight.basepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.automate.config.ReadConfigFile;

public class BasePage {

	public WebDriver driver;
	ReadConfigFile readConfigFile;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public void getAllElementsTextFromDropdown(WebElement ele) {
		final Select s = new Select(ele);
		s.getOptions().stream().toArray();
		s.getOptions().forEach(li -> System.out.println(li.getText()));
	}

	/**
	 * 
	 * @param ele
	 * @return
	 */
	public long getTotalCountFromDropdown(WebElement ele) {
		final Select s = new Select(ele);
		final long count = s.getOptions().stream().count();
		return count;
	}
}
