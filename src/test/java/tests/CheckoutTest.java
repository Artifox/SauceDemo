package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test
    public void successfulCheckout() {
        checkoutPage
                .open()
                .fillingCheckoutForm("John", "Doe", "11111")
                .pressContinueButton();
        Assert.assertTrue(checkoutPage.isCheckoutOverviewPageOpened());
    }

    @Test
    public void cartPageShouldBeOpened() {
        boolean isOpened = checkoutPage
                .open()
                .pressCancelButton()
                .isOpened();
        Assert.assertTrue(isOpened);
    }

    @Test
    public void finishPageShouldBeOpened() {
        checkoutPage
                .open()
                .fillingCheckoutForm("John", "Doe", "11111")
                .pressContinueButton()
                .clickFinishButton();
        Assert.assertTrue(checkoutPage.isFinishCheckoutPageOpened());
    }

    @Test
    public void emptyFirstName() {
        checkoutPage
                .open()
                .fillingCheckoutForm("", "Doe", "11111")
                .pressContinueButton();
        Assert.assertEquals(checkoutPage.getErrorMessage(), "Error: First Name is required", "Error message is not correct for empty First Name");
    }

    @Test
    public void emptyLastName() {
        checkoutPage
                .open()
                .fillingCheckoutForm("John", "", "11111")
                .pressContinueButton();
        Assert.assertEquals(checkoutPage.getErrorMessage(), "Error: Last Name is required", "Error message is not correct for empty Last Name");
    }

    @Test
    public void emptyZipCode() {
        checkoutPage
                .open()
                .fillingCheckoutForm("John", "Doe", "")
                .pressContinueButton();
        Assert.assertEquals(checkoutPage.getErrorMessage(), "Error: Postal Code is required", "Error message is not correct for empty Zip Code");
    }

    @Test
    public void allFieldsEmpty() {
        checkoutPage
                .open()
                .pressContinueButton()
                .fillingCheckoutForm("", "", "");
        Assert.assertEquals(checkoutPage.getErrorMessage(), "Error: First Name is required", "Error message is not correct when all the fields are empty");
    }
}
