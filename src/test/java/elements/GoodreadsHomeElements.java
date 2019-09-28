package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoodreadsHomeElements {
	
	WebDriver driver;
	
	//Page Factory
	
	@FindBy(id="remember_me") public WebElement rememberMeChk;
	
	@FindBy(linkText="Art") public WebElement artLink;
	
	@FindBy(linkText="Music") public WebElement musicLink;
	
	@FindBy(linkText="History") public WebElement historyLink;
	
	@FindBy(linkText="Poetry") public WebElement poetryLink;
	
	@FindBy(linkText="Business") public WebElement businessLink;
	
	@FindBy(linkText="Sports") public WebElement sportsLink;
	
	@FindBy(id="sitesearch_field") public WebElement siteSearchField;
	
	@FindBy(xpath="//img[@alt='search']") public WebElement searchButton;
	
	@FindBy(xpath="//table[@class='tableList']/tbody/tr[1]/descendant::span[@itemprop='author']") public WebElement srcResFirstAuthor;
	
	@FindBy(id="userSignInFormEmail") public WebElement signInEmail;
	
	@FindBy(id="user_password") public WebElement signInPassword;
	
	@FindBy(xpath="//input[@value='Sign in']") public WebElement signInButton;
	
	@FindBy(css="div#emailForm span[data-reactid]") public WebElement ErrMsg;
	
	public GoodreadsHomeElements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
