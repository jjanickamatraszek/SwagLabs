package com.solvd.pages;

import com.solvd.RelativeURLs;
import com.solvd.model.Product;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(id = "shopping_cart_container")
    private ExtendedWebElement shoppingCartBtn;

    @FindBy(xpath = ".//a[@id= '%s_title_link']/parent::div/following-sibling::div/button")
    private ExtendedWebElement addToCartBtn;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageURL(RelativeURLs.HOME_PAGE);
    }

    public HomePage addProductToCart(Product product) {
        addToCartBtn.format(product.getWebId()).click();
        return this;
    }

    public CartPage goToCart() {
        shoppingCartBtn.click();
        return new CartPage(getDriver());
    }
}
