package com.solvd.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CompleteCheckoutPage extends AbstractPage {

    @FindBy(css = "h2.complete-header")
    private ExtendedWebElement thankYouHeader;

    public CompleteCheckoutPage(WebDriver driver) {
        super(driver);
    }

    public boolean thankYouHeaderIsDisplayed() {
        return thankYouHeader.isVisible();
    }
}
