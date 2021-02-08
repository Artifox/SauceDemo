package Tests;

import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {


    @Test
    public void productsShouldBeAvailableInCart(){
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToCart("Sauce Labs Bolt T-Shirt");
    }
}
