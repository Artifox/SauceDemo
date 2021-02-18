package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    public static final By CHECKOUT_CONTAINER = By.cssSelector(".checkout_info_container");
    public static final By CHECKOUT_SUMMARY_CONTAINER = By.cssSelector(".checkout_summary_container");
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

    public void open() {
        driver.get("https://www.saucedemo.com/checkout-step-one.html");
    }

    public void fillingCheckoutForm(String firstName, String lastName, String zipCode){
        driver.findElement(FIRST_NAME).sendKeys(firstName);
        driver.findElement(LAST_NAME).sendKeys(lastName);
        driver.findElement(ZIP_CODE).sendKeys(zipCode);
    }

    public boolean isCheckoutPageOpened() {
        return driver.findElement(CHECKOUT_CONTAINER).isDisplayed();
    }

    public boolean isCheckoutSummaryPageOpened() {
        return driver.findElement(CHECKOUT_SUMMARY_CONTAINER).isDisplayed();
    }

    public void pressContinueButton() {
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    public void pressCancelButton() {
        driver.findElement(CANCEL_BUTTON).click();
    }

    public void clickFinishButton() {
        driver.findElement(FINISH_BUTTON).click();
    }

    public boolean isFinishCheckoutPageOpened(){
        return driver.findElement(CHECKOUT_COMPLETE_CONTAINER).isDisplayed();
    }
}
