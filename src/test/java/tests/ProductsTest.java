package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {


    @Test
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

    @Test
    public void addButtonShouldBePressed() {
        loginPage
                .open()
                .login("standard_user", "secret_sauce")
                .addProductToCart("Sauce Labs Backpack");
        Assert.assertTrue(productsPage.isAddToCartButtonPressed("Sauce Labs Backpack"));
    }

    @Test
    public void removeButtonShouldBePressed() {
        loginPage
                .open()
                .login("standard_user", "secret_sauce")
                .addProductToCart("Sauce Labs Backpack")
                .removeProductFromCart("Sauce Labs Backpack");
        Assert.assertTrue(productsPage.isRemoveButtonPressed("Sauce Labs Backpack"));
    }

    @Test
    public void cartPageShouldBeOpened() {
        boolean isOpened = loginPage
                .open()
                .login("standard_user", "secret_sauce")
                .openCartPage()
                .isOpened();
        Assert.assertTrue(isOpened);
    }

    @Test
    public void sideBarMenuShouldBeOpened() {
        boolean isOpened = loginPage
                .open()
                .login("standard_user", "secret_sauce")
                .openSideBarMenu()
                .isOpened();
        Assert.assertTrue(isOpened);
    }

    @Test
    public void sideBarMenuShouldBeClosed() {
        loginPage
                .open()
                .login("standard_user", "secret_sauce")
                .openSideBarMenu()
                .closeSideBarMenu();
        //add assert?
    }

    @Test
    public void numbersOfAddedProductsShouldBeDisplayedOnCartLogo() {
        loginPage
                .open()
                .login("standard_user", "secret_sauce")
                .addProductToCart("Sauce Labs Backpack")
                .addProductToCart("Sauce Labs Bolt T-Shirt");
        Assert.assertEquals(productsPage.getNumbersOfProductsOnCartBadge(), "2", "Numbers of products shown on badge " +
                "is not corresponded to added to cart");
    }

    @Test
    public void productDetailsPageShouldBeOpened() {
        boolean isOpened = loginPage
                .open()
                .login("standard_user", "secret_sauce")
                .openProductDetailsPage("Sauce Labs Backpack")
                .isOpened();
        Assert.assertTrue(isOpened);
    }
}
