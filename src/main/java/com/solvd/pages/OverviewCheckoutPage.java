package com.solvd.pages;

import com.solvd.model.Product;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class OverviewCheckoutPage extends AbstractPage {

    @FindBy(className = "cart_item")
    private List<ExtendedWebElement> products;

    @FindBy(id = "finish")
    private ExtendedWebElement finishBtn;

    public OverviewCheckoutPage(WebDriver driver) {
        super(driver);
    }

    public boolean areAllProductsListedInDescription(List<Product> items) {
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

    public CompleteCheckoutPage clickFinishBtn() {
        finishBtn.click();
        return new CompleteCheckoutPage(getDriver());
    }
}
