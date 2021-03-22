package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CartTest extends BaseTest {

    @Test(description = "Product should be removed from cart", retryAnalyzer = Retry.class)
    public void removeProductFromCart() {
        loginPage
                .open()
                .login("standard_user", "secret_sauce")
                .addProductToCart("Sauce Labs Backpack")
                .addProductToCart("Sauce Labs Bolt T-Shirt")
                .openCartPage()
                .removeProductFromCart("Sauce Labs Backpack");
        Assert.assertTrue(cartPage.findProductName("Sauce Labs Bolt T-Shirt"));
        Assert.assertEquals(cartPage.getAmountOfProducts(), 1);
        cartPage.removeProductFromCart("Sauce Labs Bolt T-Shirt");
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        int amountOfProductsInCart = cartPage.getAmountOfProducts();
        Assert.assertEquals(amountOfProductsInCart, 0);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test(description = "Products page should be opened", retryAnalyzer = Retry.class)
    public void productsPageShouldBeOpened() {
        boolean isOpened = loginPage
                .open()
                .defaultLogin()
                .openCartPage()
                .clickContinueShoppingButton()
                .isOpened();
        Assert.assertTrue(isOpened);
    }

    @Test(description = "Checkout page should be opened", retryAnalyzer = Retry.class)
    public void checkoutPageShouldBeOpened() {
        loginPage
                .open()
                .defaultLogin()
                .openCartPage()
                .clickCheckoutButton();
        Assert.assertTrue(checkoutPage.isCheckoutPageOpened());
    }

    @Test(description = "Product details page should be opened", retryAnalyzer = Retry.class)
    public void productDetailsPageShouldBeOpened() {
        boolean isOpened = loginPage
                .open()
                .login("standard_user", "secret_sauce")
                .addProductToCart("Sauce Labs Backpack")
                .openCartPage()
                .openProductDetailsPage("Sauce Labs Backpack")
                .isOpened();
        Assert.assertTrue(isOpened, "Product details page is not opened");
    }
}
