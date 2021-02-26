package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {


    @Test(retryAnalyzer = Retry.class)
    public void productsShouldBeAvailableInCart() {
        loginPage
                .open()
                .login("standard_user", "secret_sauce")
                .addProductToCart("Sauce Labs Backpack")
                .addProductToCart("Sauce Labs Bolt T-Shirt")
                .openCartPage();
        boolean result = cartPage.findProductName("Sauce Labs Backpack");
        Assert.assertEquals(result, true);
        result = cartPage.findProductName("Sauce Labs Bolt T-Shirt");
        Assert.assertEquals(result, true);
    }

    @Test(retryAnalyzer = Retry.class)
    public void addButtonShouldBePressed() {
        loginPage
                .open()
                .login("standard_user", "secret_sauce")
                .addProductToCart("Sauce Labs Backpack");
        Assert.assertTrue(productsPage.isAddToCartButtonPressed("Sauce Labs Backpack"));
    }

    @Test(retryAnalyzer = Retry.class)
    public void removeButtonShouldBePressed() {
        loginPage
                .open()
                .login("standard_user", "secret_sauce")
                .addProductToCart("Sauce Labs Backpack")
                .removeProductFromCart("Sauce Labs Backpack");
        Assert.assertTrue(productsPage.isRemoveButtonPressed("Sauce Labs Backpack"));
    }

    @Test(retryAnalyzer = Retry.class)
    public void cartPageShouldBeOpened() {
        boolean isOpened = loginPage
                .open()
                .login("standard_user", "secret_sauce")
                .openCartPage()
                .isOpened();
        Assert.assertTrue(isOpened);
    }

    @Test(retryAnalyzer = Retry.class)
    public void sideBarMenuShouldBeOpened() {
        boolean isOpened = loginPage
                .open()
                .login("standard_user", "secret_sauce")
                .openSideBarMenu()
                .isOpened();
        Assert.assertTrue(isOpened);
    }

    @Test(retryAnalyzer = Retry.class)
    public void sideBarMenuShouldBeClosed() {
        loginPage
                .open()
                .login("standard_user", "secret_sauce")
                .openSideBarMenu()
                .closeSideBarMenu();
        //add assert?
    }

    @Test(retryAnalyzer = Retry.class)
    public void numbersOfAddedProductsShouldBeDisplayedOnCartLogo() {
        loginPage
                .open()
                .login("standard_user", "secret_sauce")
                .addProductToCart("Sauce Labs Backpack")
                .addProductToCart("Sauce Labs Bolt T-Shirt");
        Assert.assertEquals(productsPage.getNumbersOfProductsOnCartBadge(), "2", "Numbers of products shown on badge " +
                "is not corresponded to added to cart");
    }

    @Test(retryAnalyzer = Retry.class)
    public void productDetailsPageShouldBeOpened() {
        boolean isOpened = loginPage
                .open()
                .login("standard_user", "secret_sauce")
                .openProductDetailsPage("Sauce Labs Backpack")
                .isOpened();
        Assert.assertTrue(isOpened);
    }
}
