package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test
    public void wrongPassword() {
        loginPage
                .open()
                .errorLogin("standard_user", "123");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service",
                "Error message is not correct");
    }

    @Test
    public void successfulLogin() {
        loginPage
                .open()
                .login("standard_user", "secret_sauce");
        assertEquals(productsPage.isProductPageOpened(), true);
    }

    @Test
    public void emptyUsername() {
        loginPage
                .open()
                .errorLogin("", "secret_sauce");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username is required",
                "Error message is not correct");
    }

    @Test
    public void emptyPassword() {
        loginPage
                .open()
                .errorLogin("standard_user", "");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Password is required",
                "Error message is not correct");
    }

    @Test
    public void emptyUsernameAndPassword() {
        loginPage
                .open()
                .errorLogin("", "");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username is required",
                "Error message is not correct");
    }

    @Test
    public void removeErrorMessage() {
        loginPage
                .open()
                .errorLogin("", "")
                .pressErrorButton();
        Assert.assertFalse(loginPage.isErrorMessageDisplayed());
    }
}