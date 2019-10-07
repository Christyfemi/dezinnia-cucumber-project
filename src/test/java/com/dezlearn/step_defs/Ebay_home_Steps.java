package com.dezlearn.step_defs;

import com.dezlearn.pages.Common;
import com.dezlearn.pages.EbayHomePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.fail;
import java.util.concurrent.TimeUnit;

public class Ebay_home_Steps {
    EbayHomePage ebayHomePage;
    Common page;
    public Ebay_home_Steps(EbayHomePage ebayHomePage, Common page) {
        this.ebayHomePage = ebayHomePage;
        this.page = page;
    }

    @Given("I am on Ebay home page")
    public void i_am_on_Ebay_home_page() {
        page.navigateToPage("https://www.ebay.com");
    }

    @When("I click on search button")
    public void I_click_on_search_button() {
        ebayHomePage.clickSearchButton();
    }

    @Then("I verify that home page is navigated to Search page")
    public void I_verify_that_home_page_is_navigated_to_Search_page() {
        String expected = "https://www.ebay.com/n/all-categories";

        String actual = page.getCurrentPageUrl();
        if (!expected.equals(actual)) {
            fail("Website does not navigate to Search result page.");
        }
    }
}
