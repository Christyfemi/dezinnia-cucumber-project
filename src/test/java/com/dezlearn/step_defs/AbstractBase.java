package com.dezlearn.step_defs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class AbstractBase {
	WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "/Users/mayurdeshmukh/Documents/Drivers/geckodriver");
		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("Global Before Hook Executed");
	}
	
	@After
	public void tearDown() {
		driver.quit();
		System.out.println("Global After Hook Executed");
	}
	
	public WebDriver getDriver() {
		return driver;
	}
}
