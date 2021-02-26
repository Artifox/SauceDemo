package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class)
    public void successfulCheckout() {
        checkoutPage
                .open()
                .fillingCheckoutForm("John", "Doe", "11111")
                .pressContinueButton();
        Assert.assertTrue(checkoutPage.isCheckoutOverviewPageOpened());
    }

    @Test(retryAnalyzer = Retry.class)
    public void cartPageShouldBeOpened() {
        boolean isOpened = checkoutPage
                .open()
                .pressCancelButton()
                .isOpened();
        Assert.assertTrue(isOpened);
    }

    @Test(retryAnalyzer = Retry.class)
    public void finishPageShouldBeOpened() {
        checkoutPage
                .open()
                .fillingCheckoutForm("John", "Doe", "11111")
                .pressContinueButton()
                .clickFinishButton();
        Assert.assertTrue(checkoutPage.isFinishCheckoutPageOpened());
    }

    @Test(retryAnalyzer = Retry.class)
    public void emptyFirstName() {
        checkoutPage
                .open()
                .fillingCheckoutForm("", "Doe", "11111")
                .pressContinueButton();
        Assert.assertEquals(checkoutPage.getErrorMessage(), "Error: First Name is required", "Error message is not correct for empty First Name");
    }

    @Test(retryAnalyzer = Retry.class)
    public void emptyLastName() {
        checkoutPage
                .open()
                .fillingCheckoutForm("John", "", "11111")
                .pressContinueButton();
        Assert.assertEquals(checkoutPage.getErrorMessage(), "Error: Last Name is required", "Error message is not correct for empty Last Name");
    }

    @Test(retryAnalyzer = Retry.class)
    public void emptyZipCode() {
        checkoutPage
                .open()
                .fillingCheckoutForm("John", "Doe", "")
                .pressContinueButton();
        Assert.assertEquals(checkoutPage.getErrorMessage(), "Error: Postal Code is required", "Error message is not correct for empty Zip Code");
    }

    @Test(retryAnalyzer = Retry.class)
    public void allFieldsEmpty() {
        checkoutPage
                .open()
                .pressContinueButton()
                .fillingCheckoutForm("", "", "");
        Assert.assertEquals(checkoutPage.getErrorMessage(), "Error: First Name is required", "Error message is not correct when all the fields are empty");
    }
}
