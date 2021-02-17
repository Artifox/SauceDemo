package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test
    public void successfulCheckout() {
        checkoutPage.open();
        checkoutPage.fillingCheckoutForm("John", "Doe", "11111");
        checkoutPage.pressContinueButton();
        Assert.assertTrue(checkoutPage.isCheckoutSummaryPageOpened());
    }

    @Test
    public void cartPageShouldBeOpened() {
        checkoutPage.open();
        checkoutPage.pressCancelButton();
        Assert.assertTrue(cartPage.isCartPageOpened());
    }

    @Test
    public void finishPageShouldBeOpened() {
        checkoutPage.open();
        checkoutPage.fillingCheckoutForm("John", "Doe", "11111");
        checkoutPage.pressContinueButton();
        checkoutPage.clickFinishButton();
        Assert.assertTrue(checkoutPage.isFinishCheckoutPageOpened());
    }

    @Test
    public void emptyFirstName() {
        checkoutPage.open();
        checkoutPage.fillingCheckoutForm("", "Doe", "11111");
        checkoutPage.pressContinueButton();
        Assert.assertEquals(checkoutPage.getErrorMessage(), "Error: First Name is required", "Error message is not correct for empty First Name");
    }

    @Test
    public void emptyLastName() {
        checkoutPage.open();
        checkoutPage.fillingCheckoutForm("John", "", "11111");
        checkoutPage.pressContinueButton();
        Assert.assertEquals(checkoutPage.getErrorMessage(), "Error: Last Name is required", "Error message is not correct for empty Last Name");
    }

    @Test
    public void emptyZipCode() {
        checkoutPage.open();
        checkoutPage.fillingCheckoutForm("John", "Doe", "");
        checkoutPage.pressContinueButton();
        Assert.assertEquals(checkoutPage.getErrorMessage(), "Error: Postal Code is required", "Error message is not correct for empty Zip Code");
    }

    @Test
    public void allFieldsEmpty() {
        checkoutPage.open();
        checkoutPage.fillingCheckoutForm("", "", "");
        checkoutPage.pressContinueButton();
        Assert.assertEquals(checkoutPage.getErrorMessage(), "Error: First Name is required", "Error message is not correct when all the fields are empty");
    }
}
