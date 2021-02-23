package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    public static final String PRODUCT_NAME = "//*[text()='%s']";
    public static final String REMOVE_BUTTON = "//*[text()='%s']/ancestor::*[contains(@class, 'cart_item')]//button";
    public static final String CONTINUE_SHOPPING_BUTTON = ".btn_secondary";
    public static final String CHECKOUT_BUTTON = ".checkout_button";
    public static final By YOU_CART_LABEL = By.cssSelector(".subheader");
    public static final By CART_ITEM = By.cssSelector(".cart_item");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        boolean isOpened;
        try {
            driver.findElement(YOU_CART_LABEL);
            return isOpened = true;
        } catch (NoSuchElementException exception) {
            return isOpened = false;
        }
    }

    public CartPage open() {
        driver.get("https://www.saucedemo.com/cart.html");
        return this;
    }

    public boolean findProductName(String productName) {
        return driver.findElement(By.xpath(String.format(PRODUCT_NAME, productName))).isDisplayed();
    }

    public void removeProductFromCart(String productName) {
        driver.findElement(By.xpath(String.format(REMOVE_BUTTON, productName))).click();
    }

    public int getAmountOfProducts() {
        return driver.findElements(CART_ITEM).size();
    }

    public ProductsPage clickContinueShoppingButton() {
        driver.findElement(By.cssSelector(CONTINUE_SHOPPING_BUTTON)).click();
        return new ProductsPage(driver);
    }

    public CheckoutPage clickCheckoutButton() {
        driver.findElement(By.cssSelector(CHECKOUT_BUTTON)).click();
        return new CheckoutPage(driver);
    }

    public ProductDetailsPage openProductDetailsPage(String productName) {
        driver.findElement(By.xpath(String.format(PRODUCT_NAME, productName))).click();
        return new ProductDetailsPage(driver);
    }
}
