package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class, description = "'Checkout overview' page is opened after filling 'Checkout' form")
    public void checkoutOverviewPageShouldBeOpened() {
        loginPage
                .open()
                .defaultLogin()
                .addProductToCart("Sauce Labs Backpack")
                .openCartPage()
                .clickCheckoutButton()
                .fillingCheckoutForm("John", "Doe", "11111")
                .pressContinueButton();
        Assert.assertTrue(checkoutPage.isCheckoutOverviewPageOpened());
    }

    @Test(retryAnalyzer = Retry.class, description = "Cart page should be opened after pressing 'Cancel' button")
    public void cartPageShouldBeOpened() {
        boolean isOpened = loginPage
                .open()
                .defaultLogin()
                .openCartPage()
                .clickCheckoutButton()
                .pressCancelButton()
                .isOpened();
        Assert.assertTrue(isOpened);
    }

    @Test(retryAnalyzer = Retry.class, description = "Finish page should be opened after filling form with correct values")
    public void finishPageShouldBeOpened() {
        boolean isFinishPageOpened = loginPage
                .open()
                .defaultLogin()
                .openCartPage()
                .clickCheckoutButton()
                .fillingCheckoutForm("John", "Doe", "11111")
                .pressContinueButton()
                .pressFinishButton()
                .isFinishCheckoutPageOpened();
        Assert.assertTrue(isFinishPageOpened);
    }

    @Test(retryAnalyzer = Retry.class, description = "Error message if First name is empty")
    public void emptyFirstName() {
        loginPage
                .open()
                .defaultLogin()
                .openCartPage()
                .clickCheckoutButton()
                .fillingCheckoutForm("", "Doe", "11111")
                .pressContinueButton();
        Assert.assertEquals(checkoutPage.getErrorMessage(), "Error: First Name is required", "Error message is not correct for empty First Name");
    }

    @Test(retryAnalyzer = Retry.class, description = "Error message if Last name is empty")
    public void emptyLastName() {
        loginPage
                .open()
                .defaultLogin()
                .openCartPage()
                .clickCheckoutButton()
                .fillingCheckoutForm("John", "", "11111")
                .pressContinueButton();
        Assert.assertEquals(checkoutPage.getErrorMessage(), "Error: Last Name is required", "Error message is not correct for empty Last Name");
    }

    @Test(retryAnalyzer = Retry.class, description = "Error message if ZIP code is empty")
    public void emptyZipCode() {
        loginPage
                .open()
                .defaultLogin()
                .openCartPage()
                .clickCheckoutButton()
                .fillingCheckoutForm("John", "Doe", "")
                .pressContinueButton();
        Assert.assertEquals(checkoutPage.getErrorMessage(), "Error: Postal Code is required", "Error message is not correct for empty Zip Code");
    }

    @Test(retryAnalyzer = Retry.class, description = "Error message if all fields are empty")
    public void allFieldsEmpty() {
        loginPage
                .open()
                .defaultLogin()
                .openCartPage()
                .clickCheckoutButton()
                .fillingCheckoutForm("", "", "")
                .pressContinueButton();
        Assert.assertEquals(checkoutPage.getErrorMessage(), "Error: First Name is required", "Error message is not correct when all the fields are empty");
    }
}
