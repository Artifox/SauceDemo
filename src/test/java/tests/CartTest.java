package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CartTest extends BaseTest {

    @Test
    public void removeProductFromCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToCart("Sauce Labs Backpack");
        productsPage.addProductToCart("Sauce Labs Bolt T-Shirt");
        productsPage.openCartPage();
        cartPage.removeProductFromCart("Sauce Labs Backpack");
        Assert.assertTrue(cartPage.findProductName("Sauce Labs Bolt T-Shirt"));
        Assert.assertEquals(cartPage.getAmountOfProducts(), 1);
        cartPage.removeProductFromCart("Sauce Labs Bolt T-Shirt");
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        int amountOfProductsInCart = cartPage.getAmountOfProducts();
        Assert.assertEquals(amountOfProductsInCart, 0);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void productsPageShouldBeOpened() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        cartPage.open();
        cartPage.clickContinueShoppingButton();
        Assert.assertTrue(productsPage.isProductPageOpened());
    }

    @Test
    public void checkoutPageShouldBeOpened() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        cartPage.open();
        cartPage.clickCheckoutButton();
        Assert.assertTrue(checkoutPage.isCheckoutPageOpened());
    }

    @Test
    public void productDetailsPageShouldBeOpened() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToCart("Sauce Labs Backpack");
        cartPage.open();
        Assert.assertTrue(productDetailsPage.findProductName("Sauce Labs Backpack"));
    }
}
