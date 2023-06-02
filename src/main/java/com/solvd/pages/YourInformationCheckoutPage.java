package com.solvd.pages;

import com.solvd.model.User;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class YourInformationCheckoutPage extends AbstractPage {

    @FindBy(id = "first-name")
    private ExtendedWebElement firstNameField;

    @FindBy(id = "last-name")
    private ExtendedWebElement lastNameField;

    @FindBy(id = "postal-code")
    private ExtendedWebElement zipCodeField;

    @FindBy(id = "continue")
    private ExtendedWebElement continueBtn;

    public YourInformationCheckoutPage(WebDriver driver) {
        super(driver);
    }

    public YourInformationCheckoutPage enterFirstName(String firstName) {
        firstNameField.type(firstName);
        return this;
    }

    public YourInformationCheckoutPage enterLastName(String lastName) {
        lastNameField.type(lastName);
        return this;
    }

    public YourInformationCheckoutPage enterZipCode(String zipCode) {
        zipCodeField.type(zipCode);
        return this;
    }

    public YourInformationCheckoutPage enterUserInfo(User user) {
        enterFirstName(user.getFirstName());
        enterLastName(user.getLastName());
        enterZipCode(user.getZipCode());
        return this;
    }

    public void clickContinue() {
        continueBtn.click();
    }
}
