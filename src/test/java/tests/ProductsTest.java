package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {


    @Test(retryAnalyzer = Retry.class, description = "Products should be available in cart")
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

    @Test(retryAnalyzer = Retry.class, description = "Add button should be pressed")
    public void addButtonShouldBePressed() {
        loginPage
                .open()
                .login("standard_user", "secret_sauce")
                .addProductToCart("Sauce Labs Backpack");
        Assert.assertTrue(productsPage.isAddToCartButtonPressed("Sauce Labs Backpack"));
    }

    @Test(retryAnalyzer = Retry.class, description = "Remove button should be pressed")
    public void removeButtonShouldBePressed() {
        loginPage
                .open()
                .login("standard_user", "secret_sauce")
                .addProductToCart("Sauce Labs Backpack")
                .removeProductFromCart("Sauce Labs Backpack");
        Assert.assertTrue(productsPage.isRemoveButtonPressed("Sauce Labs Backpack"));
    }

    @Test(retryAnalyzer = Retry.class, description = "Cart page should be opened")
    public void cartPageShouldBeOpened() {
        boolean isOpened = loginPage
                .open()
                .login("standard_user", "secret_sauce")
                .openCartPage()
                .isOpened();
        Assert.assertTrue(isOpened);
    }

    @Test(retryAnalyzer = Retry.class, description = "Side bar menu should be opened")
    public void sideBarMenuShouldBeOpened() {
        boolean isOpened = loginPage
                .open()
                .login("standard_user", "secret_sauce")
                .openSideBarMenu()
                .isOpened();
        Assert.assertTrue(isOpened);
    }

    @Test(retryAnalyzer = Retry.class, description = "Side bar menu should be closed")
    public void sideBarMenuShouldBeClosed() {
        loginPage
                .open()
                .login("standard_user", "secret_sauce")
                .openSideBarMenu()
                .closeSideBarMenu();
        //add assert?
    }

    @Test(retryAnalyzer = Retry.class, description = "Numbers of added products should be displayed on cart logo")
    public void numbersOfAddedProductsShouldBeDisplayedOnCartLogo() {
        loginPage
                .open()
                .login("standard_user", "secret_sauce")
                .addProductToCart("Sauce Labs Backpack")
                .addProductToCart("Sauce Labs Bolt T-Shirt");
        Assert.assertEquals(productsPage.getNumbersOfProductsOnCartBadge(), "2", "Numbers of products shown on badge " +
                "is not corresponded to added to cart");
    }

    @Test(retryAnalyzer = Retry.class, description = "Product details page should be opened")
    public void productDetailsPageShouldBeOpened() {
        boolean isOpened = loginPage
                .open()
                .login("standard_user", "secret_sauce")
                .openProductDetailsPage("Sauce Labs Backpack")
                .isOpened();
        Assert.assertTrue(isOpened);
    }
}
