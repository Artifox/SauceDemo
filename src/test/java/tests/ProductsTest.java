package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {


    @Test
    public void productsShouldBeAvailableInCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToCart("Sauce Labs Backpack");
        productsPage.addProductToCart("Sauce Labs Bolt T-Shirt");
        productsPage.openCartPage();
        boolean result = cartPage.findProductName("Sauce Labs Backpack");
        Assert.assertEquals(result, true);
        result = cartPage.findProductName("Sauce Labs Bolt T-Shirt");
        Assert.assertEquals(result, true);
    }

    @Test
    public void addButtonShouldBePressed() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToCart("Sauce Labs Backpack");
        Assert.assertTrue(productsPage.isAddToCartButtonPressed("Sauce Labs Backpack"));
    }

}
