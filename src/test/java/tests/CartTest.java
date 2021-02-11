package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void removeProductFromCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToCart("Sauce Labs Backpack");
        productsPage.addProductToCart("Sauce Labs Bolt T-Shirt");
        productsPage.openCartPage();
        Assert.assertEquals(cartPage.getAmountOfProducts(), 2);
        Assert.assertTrue(cartPage.findProductName("Sauce Labs Backpack"));
        Assert.assertTrue(cartPage.findProductName("Sauce Labs Bolt T-Shirt"));
        cartPage.removeProductFromCart("Sauce Labs Backpack");
        Assert.assertTrue(cartPage.findProductName("Sauce Labs Bolt T-Shirt"));
        Assert.assertEquals(cartPage.getAmountOfProducts(), 1);
    }
}
