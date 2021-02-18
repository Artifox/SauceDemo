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

    @Test
    public void removeButtonShouldBePressed() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToCart("Sauce Labs Backpack");
        productsPage.removeProductFromCart("Sauce Labs Backpack");
        Assert.assertTrue(productsPage.isRemoveButtonPressed("Sauce Labs Backpack"));
    }

    @Test
    public void cartPageShouldBeOpened() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.openCartPage();
        Assert.assertTrue(cartPage.isCartPageOpened());
    }

    @Test
    public void sideBarMenuShouldBeOpened() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.isProductPageOpened();
        productsPage.openSideBarMenu();
        sideBarMenuPage.isSideBarMenuOpened();
    }

    @Test
    public void sideBarMenuShouldBeClosed() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.openSideBarMenu();
        sideBarMenuPage.closeSideBarMenu();
        //add assert
    }

    @Test
    public void numbersOfAddedProductsShouldBeDisplayedOnCartLogo() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToCart("Sauce Labs Backpack");
        productsPage.addProductToCart("Sauce Labs Bolt T-Shirt");
        Assert.assertEquals(productsPage.getNumbersOfProductsOnCartBadge(), "2", "Numbers of products shown on badge " +
                "is not corresponded to added to cart");
    }

    @Test
    public void productDetailsPageShouldBeOpened() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.openProductDetailsPage("Sauce Labs Backpack");
        Assert.assertTrue(productDetailsPage.isProductDetailsPageOpened());
    }
}
