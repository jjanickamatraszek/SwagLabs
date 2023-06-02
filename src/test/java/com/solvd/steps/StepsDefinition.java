package com.solvd.steps;


import com.solvd.model.Product;
import com.solvd.model.User;
import com.solvd.pages.*;
import com.solvd.services.IUserService;
import com.solvd.services.UserServiceImpl;
import com.zebrunner.carina.webdriver.IDriverPool;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.Getter;
import org.testng.Assert;

import java.util.List;

public class StepsDefinition implements IDriverPool {
    private HomePage homePage;
    private CartPage cartPage;
    private CompleteCheckoutPage completeCheckoutPage;
    private User user;

    @Given("{} is logged in")
    public void isLoggedIn(UserName userName) {
        IUserService IUserService = new UserServiceImpl();
        user = IUserService.getById(userName.getId());

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(), "Login page didn't open");

        homePage = loginPage.login(user);
        Assert.assertTrue(homePage.isPageOpened(), "Home page didn't open. Possibly due to incorrect credentials");
    }

    @Given("added products to cart")
    public void addedProductsToCart() {
        for (Product product : user.getOrders().get(0).getProducts()) {
            homePage.addProductToCart(product);
        }

        cartPage = homePage.goToCart();
        Assert.assertTrue(cartPage.isPageOpened(), "Cart page didn't open");
    }

    @When("proceeds to checkout")
    public void proceedsToCheckout() {
        List<Product> orderedProducts = user.getOrders().get(0).getProducts();
        Assert.assertTrue(cartPage.areAllProductsInCart(orderedProducts), "Not all products are listed in the cart page");

        cartPage.clickCheckout();
        YourInformationCheckoutPage infoPage = new YourInformationCheckoutPage(getDriver());
        infoPage.enterUserInfo(user).clickContinue();

        OverviewCheckoutPage overviewPage = new OverviewCheckoutPage(getDriver());
        Assert.assertTrue(overviewPage.areAllProductsListedInDescription(orderedProducts), "Not all products are listed in the order description");

        completeCheckoutPage = overviewPage.clickFinishBtn();
    }

    @Then("makes successful order")
    public void makesSuccessfulOrder() {
        Assert.assertTrue(completeCheckoutPage.thankYouHeaderIsDisplayed(), "Header confirming successful order wasn't displayed");
    }


    public enum UserName {
        KATE(1), JOHN(2);

        @Getter
        final int id;

        UserName(int i) {
            id = i;
        }
    }
}
