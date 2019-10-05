package com.dezlearn.step_defs;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.dezlearn.pages.Common;
import com.dezlearn.pages.GoodreadsHomePage;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class Goodreads_Home_Steps {

	boolean isRememberMeSelected = false;
	GoodreadsHomePage goodreadsHomePage;
	Common page;
	
	public Goodreads_Home_Steps(GoodreadsHomePage goodreadsHomePage, Common page) {
		this.goodreadsHomePage = goodreadsHomePage;
		this.page = page;
	}
	
	@Given("I am on Goodreads home page")
	public void i_am_on_Goodreads_home_page() {
		page.navigateToPage("https://www.goodreads.com");
	}

	@When("I check the status of Remember Me checkbox")
	public void i_check_the_status_of_Remember_Me_checkbox() {
		isRememberMeSelected = goodreadsHomePage.isRememberMeCheckboxSelected();
	}

	@Then("I verify that Remember Me checkbox is checked")
	public void i_verify_that_Remember_Me_checkbox_is_checked() {
		if (!isRememberMeSelected) {
			fail("Remember me checkbox not selected.");
		}
	}

	@When("I click on {string} link")
	public void i_click_on_link(String string) {
		if (string.equalsIgnoreCase("Arts")) {
			goodreadsHomePage.clickArtsLink();
		} else if (string.equalsIgnoreCase("Music")) {
			goodreadsHomePage.clickMusicLink();
		}
	}

	@Then("I verify that website navigates to {string} page")
	public void i_verify_that_website_navigates_to_page(String string) {
		String expected = "";
		if (string.equalsIgnoreCase("Arts")) {
			expected = "https://www.goodreads.com/genres/art";
		} else if (string.equalsIgnoreCase("Music")) {
			expected = "https://www.goodreads.com/genres/music";
		}
		String actual = page.getCurrentPageUrl();
		if (!expected.equals(actual)) {
			fail("Website does not navigate to arts page.");
		}
	}

	@When("I search by author {string} in search field")
	public void i_search_by_author_in_search_field(String author) {
		goodreadsHomePage.enterSearchStringInSiteSearch(author);
		goodreadsHomePage.clickSearchButton();
	}

	@Then("I verify that first author from search results is {string}")
	public void i_verify_that_first_author_from_search_results_is(String expected) {
		String actual = goodreadsHomePage.getFirstSearchResultAuthor();
		if (!expected.equals(actual)) {
			fail("Differnt author in search results: " + actual);
		}
	}

	@When("I log in with wrong creds")
	public void i_log_in_with_wrong_creds(DataTable dataTable) {
		goodreadsHomePage.enterUserEmail(dataTable.row(1).get(0));
		goodreadsHomePage.enterUserPassword(dataTable.row(1).get(1));
		goodreadsHomePage.clickSignInButton();
	}

	@Then("I verify log in error msg")
	public void i_verify_log_in_error_msg() {
		String errMsg = goodreadsHomePage.getErrorMessage();
		if (!errMsg.contains("email or password isn't right")) {
			fail("No error msg displayed");
		}
	}

	@When("I click on {string}")
	public void i_click_on(String string) {
		switch (string.toLowerCase()) {
		case "history":
			goodreadsHomePage.clickHistoryLink();
			break;
		case "poetry":
			goodreadsHomePage.clickPoetryLink();
			break;
		case "business":
			goodreadsHomePage.clickBusinessLink();
			break;
		case "sports":
			goodreadsHomePage.clickSportsLink();
			break;
		default:
			fail("Link not found");
		}
	}

	@Then("I verify that website navigates to {string}")
	public void i_verify_that_website_navigates_to(String string) {
		String actualUrl = page.getCurrentPageUrl();
		if (!actualUrl.equalsIgnoreCase(string)) {
			fail("Page does not navigate to expected url: " + actualUrl);
		}
	}

	@Then("I verify that new page title is {string}")
	public void i_verify_that_new_page_title_is(String string) {
		String actualTitle = page.getCurrentPageTitle();
		if (!actualTitle.equalsIgnoreCase(string)) {
			fail("Page does not have expected title: " + actualTitle);
		}
	}
	
	@Given("I do this")
	public void i_do_this() {
	    System.out.println("I do this.");
	}
}