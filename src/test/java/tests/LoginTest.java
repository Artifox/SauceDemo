package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @DataProvider(name = "Input data for Login")
    public Object[][] inputDataForLogin() {
        return new Object[][]{
                {"standard_user", "123", "Epic sadface: Username and password do not match any user in this service"},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"},
                {"", "", "Epic sadface: Username is required"},
        };
    }

    @Test(dataProvider = "Input data for Login")
    public void unsuccessfulLogin(String username, String password, String errorMessage) {
        loginPage
                .open()
                .errorLogin(username, password);
        assertEquals(loginPage.getErrorMessage(),
                errorMessage,
                "Error message is not correct");
    }

    @Test
    public void successfulLogin() {
        loginPage
                .open()
                .login("standard_user", "secret_sauce");
        assertTrue(productsPage.isOpened());
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