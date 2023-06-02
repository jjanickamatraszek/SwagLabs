package com.solvd.pages;

import com.solvd.RelativeURLs;
import com.solvd.model.Product;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends AbstractPage {

    @FindBy(className = "cart_item")
    private List<ExtendedWebElement> products;

    @FindBy(id = "checkout")
    private ExtendedWebElement checkoutBtn;

    public CartPage(WebDriver driver) {
        super(driver);
        setPageURL(RelativeURLs.CART_PAGE);
    }

    public int getNumberOfProducts() {
        return products.size();
    }

    public boolean areAllProductsInCart(List<Product> items) {
        List<String> ids = products
                .stream()
                .map(a -> a.findExtendedWebElement(By.cssSelector(".cart_item_label>a")).getAttribute("id"))
                .toList();
        for (Product item : items) {
            if (ids.stream().noneMatch(p -> p.contains(item.getWebId()))) {
                return false;
            }
        }
        return true;
    }

    public void clickCheckout() {
        checkoutBtn.click();
    }
}
