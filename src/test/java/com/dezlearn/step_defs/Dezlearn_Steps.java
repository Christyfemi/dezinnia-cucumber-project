package com.dezlearn.step_defs;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class Dezlearn_Steps {

	WebDriver driver;
	
	@Given("I am on dezlean home page")
	public void i_am_on_dezlean_home_page() {
	    driver.get("https://www.dezlearn.com/home/");
	}

	@Given("I navigate to Explicit Wait Exapmle page")
	public void i_navigate_to_Explicit_Wait_Exapmle_page() {
//	    Actions action = new Actions(driver);
//	    WebElement testPages = driver.findElement(By.partialLinkText("Test Pages"));
//	    action.moveToElement(testPages).build().perform();
//	    driver.findElement(By.linkText("Explicit Wait Example")).click();
		driver.navigate().to("https://www.dezlearn.com/explicit-wait-example/");
	}

	@When("I submit the order with follwoing details")
	public void i_submit_the_order_with_follwoing_details(DataTable dataTable) {
	    driver.findElement(By.id("ninja_forms_field_97")).sendKeys(dataTable.row(0).get(0));
	    driver.findElement(By.id("ninja_forms_field_98")).sendKeys(dataTable.row(0).get(1));
	    driver.findElement(By.id("ninja_forms_field_100")).sendKeys(dataTable.row(0).get(2));
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}
	    driver.findElement(By.xpath("//button[text()='Submit']")).click();
	}

	@Then("I verify that the order number is generated")
	public void i_verify_that_the_order_number_is_generated() {
	    WebDriverWait wait = new WebDriverWait(driver,12);
	    WebElement goToNextPage = driver.findElement(By.xpath("//button[text()='Go to Next Page']"));
	    wait.until(ExpectedConditions.elementToBeClickable(goToNextPage));
		String order = driver.findElement(By.id("processing")).getText();
		if(order.isEmpty()) {
			fail("Order number is empty");
		}
	}
}
