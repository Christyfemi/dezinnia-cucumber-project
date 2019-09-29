package com.dezlearn.pages;

import org.openqa.selenium.WebDriver;

import com.dezlearn.step_defs.AbstractBase;

public class Common {

	WebDriver driver;
	AbstractBase base;
	
	public Common(AbstractBase base) {
		this.base = base;
		this.driver = base.getDriver();
	}

	public void navigateToPage(String url) {
		driver.get(url);
	}
	
	public String getCurrentPageUrl() {
		return driver.getCurrentUrl();
	}
	
	public String getCurrentPageTitle() {
		return driver.getTitle();
	}
}
