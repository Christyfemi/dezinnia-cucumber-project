package com.dezlearn.pages;

import com.dezlearn.elements.EbayHomeElements;
import com.dezlearn.step_defs.AbstractBase;
import org.openqa.selenium.WebDriver;

public class EbayHomePage {

    WebDriver driver;
    AbstractBase base;
    EbayHomeElements ebayhomeElements;

    public EbayHomePage(AbstractBase base) {
        this.base = base;
        this.driver = base.getDriver();
        ebayhomeElements = new EbayHomeElements(this.driver);
    }

    public void clickSearchButton() {
        ebayhomeElements.ebaySearchBtn.click();
    }

}
