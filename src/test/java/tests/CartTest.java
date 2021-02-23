package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CartTest extends BaseTest {

    @Test
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

    @Test
    public void productsPageShouldBeOpened() {
        boolean isOpened = cartPage
                .open()
                .clickContinueShoppingButton()
                .isOpened();
        Assert.assertTrue(isOpened);
    }

    @Test
    public void checkoutPageShouldBeOpened() {
        cartPage
                .open()
                .clickCheckoutButton();
        Assert.assertTrue(checkoutPage.isCheckoutPageOpened());
    }

    @Test
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
