package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class, description = "'Checkout overview' page is opened after filling 'Checkout' form")
    public void successfulCheckout() {
        checkoutPage
                .open()
                .fillingCheckoutForm("John", "Doe", "11111")
                .pressContinueButton();
        Assert.assertTrue(checkoutPage.isCheckoutOverviewPageOpened());
    }

    @Test(retryAnalyzer = Retry.class, description = "Cart page should be opened after pressing 'Cancel' button")
    public void cartPageShouldBeOpened() {
        boolean isOpened = checkoutPage
                .open()
                .pressCancelButton()
                .isOpened();
        Assert.assertTrue(isOpened);
    }

    @Test(retryAnalyzer = Retry.class, description = "Finish page should be opened after filling form with correct values")
    public void finishPageShouldBeOpened() {
        checkoutPage
                .open()
                .fillingCheckoutForm("John", "Doe", "11111")
                .pressContinueButton()
                .clickFinishButton();
        Assert.assertTrue(checkoutPage.isFinishCheckoutPageOpened());
    }

    @Test(retryAnalyzer = Retry.class, description = "Error message if First name is empty")
    public void emptyFirstName() {
        checkoutPage
                .open()
                .fillingCheckoutForm("", "Doe", "11111")
                .pressContinueButton();
        Assert.assertEquals(checkoutPage.getErrorMessage(), "Error: First Name is required", "Error message is not correct for empty First Name");
    }

    @Test(retryAnalyzer = Retry.class, description = "Error message if Last name is empty")
    public void emptyLastName() {
        checkoutPage
                .open()
                .fillingCheckoutForm("John", "", "11111")
                .pressContinueButton();
        Assert.assertEquals(checkoutPage.getErrorMessage(), "Error: Last Name is required", "Error message is not correct for empty Last Name");
    }

    @Test(retryAnalyzer = Retry.class, description = "Error message if ZIP code is empty")
    public void emptyZipCode() {
        checkoutPage
                .open()
                .fillingCheckoutForm("John", "Doe", "")
                .pressContinueButton();
        Assert.assertEquals(checkoutPage.getErrorMessage(), "Error: Postal Code is required", "Error message is not correct for empty Zip Code");
    }

    @Test(retryAnalyzer = Retry.class, description = "Error message if all fields are empty")
    public void allFieldsEmpty() {
        checkoutPage
                .open()
                .pressContinueButton()
                .fillingCheckoutForm("", "", "");
        Assert.assertEquals(checkoutPage.getErrorMessage(), "Error: First Name is required", "Error message is not correct when all the fields are empty");
    }
}
