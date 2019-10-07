package com.dezlearn.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EbayHomeElements {

    WebDriver driver;

    //Page Factory

    @FindBy(id="gh-btn") public WebElement ebaySearchBtn;

    public EbayHomeElements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
