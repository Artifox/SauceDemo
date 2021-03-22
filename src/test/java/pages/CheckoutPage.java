package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    public static final By CHECKOUT_CONTAINER = By.cssSelector(".checkout_info_container");
    public static final By CHECKOUT_OVERVIEW_SUMMARY_CONTAINER = By.cssSelector(".checkout_summary_container");
    public static final By CHECKOUT_COMPLETE_CONTAINER = By.cssSelector(".checkout_complete_container");
    public static final By FIRST_NAME = By.id("first-name");
    public static final By LAST_NAME = By.id("last-name");
    public static final By ZIP_CODE = By.id("postal-code");
    public static final By FINISH_BUTTON = By.xpath("//*[text()='FINISH']");
    public static final By CONTINUE_BUTTON = By.cssSelector("[value='CONTINUE']");
    public static final By CANCEL_BUTTON = By.cssSelector(".cart_cancel_link");
    public static final By ERROR_MESSAGE = By.cssSelector("[data-test=error]");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        boolean isOpened;
        try {
            driver.findElement(CHECKOUT_CONTAINER);
            return isOpened = true;
        } catch (NoSuchElementException exception) {
            return isOpened = false;
        }
    }

    public CheckoutPage open() {
        driver.get("https://www.saucedemo.com/checkout-step-one.html");
        return this;
    }

    public CheckoutPage fillingCheckoutForm(String firstName, String lastName, String zipCode) {
        driver.findElement(FIRST_NAME).sendKeys(firstName);
        driver.findElement(LAST_NAME).sendKeys(lastName);
        driver.findElement(ZIP_CODE).sendKeys(zipCode);
        return this;
    }

    public boolean isCheckoutPageOpened() {
        return driver.findElement(CHECKOUT_CONTAINER).isDisplayed();
    }

    public boolean isCheckoutOverviewPageOpened() {
        return driver.findElement(CHECKOUT_OVERVIEW_SUMMARY_CONTAINER).isDisplayed();
    }

    public CheckoutPage pressContinueButton() {
        driver.findElement(CONTINUE_BUTTON).click();
        return this;
    }

    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    public CartPage pressCancelButton() {
        driver.findElement(CANCEL_BUTTON).click();
        return new CartPage(driver);
    }

    public CheckoutPage pressFinishButton() {
        driver.findElement(FINISH_BUTTON).click();
        return this;
    }

    public boolean isFinishCheckoutPageOpened() {
        return driver.findElement(CHECKOUT_COMPLETE_CONTAINER).isDisplayed();
    }
}
