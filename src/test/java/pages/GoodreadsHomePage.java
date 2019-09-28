package pages;

import org.openqa.selenium.WebDriver;

import com.dezlearn.step_defs.AbstractBase;

import elements.GoodreadsHomeElements;

public class GoodreadsHomePage {
	
	WebDriver driver;
	AbstractBase base;
	GoodreadsHomeElements homeElements;
	
	public GoodreadsHomePage(AbstractBase base) {
		this.base = base;
		this.driver = base.getDriver();
		homeElements = new GoodreadsHomeElements(this.driver);
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
	
	public boolean isRememberMeCheckboxSelected() {
		return homeElements.rememberMeChk.isSelected();
	}
	
	public void clickArtsLink() {
		homeElements.artLink.click();
	}
	
	public void clickMusicLink() {
		homeElements.musicLink.click();
	}
	
	public void enterSearchStringInSiteSearch(String StringData) {
		homeElements.siteSearchField.sendKeys(StringData);
	}
	
	public void clickSearchButton() {
		homeElements.searchButton.click();
	}
	
	public String getFirstSearchResultAuthor() {
		return homeElements.srcResFirstAuthor.getText();
	}
	
	public void enterUserEmail(String email) {
		homeElements.signInEmail.sendKeys(email);
	}
	
	public void enterUserPassword(String password) {
		homeElements.signInPassword.sendKeys(password);
	}
	
	public void clickSignInButton() {
		homeElements.signInButton.click();
	}
	
	public String getErrorMessage() {
		return homeElements.ErrMsg.getText();
	}
	
	public void clickHistoryLink() {
		homeElements.historyLink.click();
	}
	
	public void clickPoetryLink() {
		homeElements.poetryLink.click();
	}
	
	public void clickBusinessLink() {
		homeElements.businessLink.click();
	}
	
	public void clickSportsLink() {
		homeElements.sportsLink.click();
	}
	
}
