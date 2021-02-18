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
        //loginPage.open();
        //loginPage.login("standard_user", "secret_sauce");
        //productsPage.addProductToCart("Sauce Labs Backpack");
        //productsPage.addProductToCart("Sauce Labs Bolt T-Shirt");
        //productsPage.openCartPage();
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
        loginPage
                .open()
                .login("standard_user", "secret_sauce")
                .openCartPage();
        Assert.assertTrue(cartPage.isCartPageOpened());
    }

    @Test
    public void sideBarMenuShouldBeOpened() {
        loginPage
                .open()
                .login("standard_user", "secret_sauce")
                .openSideBarMenu()
                .isSideBarMenuOpened();
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
        loginPage
                .open()
                .login("standard_user", "secret_sauce")
                .openProductDetailsPage("Sauce Labs Backpack");
        Assert.assertTrue(productDetailsPage.isProductDetailsPageOpened());
    }
}
