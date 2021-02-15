package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ProductsPage extends BasePage {

    public static final String ADD_TO_CART = "//*[text()='%s']/ancestor::*[contains(@class,'inventory_item')]//button";
    public static final String REMOVE_FROM_CART = "//*[text()='%s']/ancestor::*[contains(@class,'inventory_item')]//button";
    public static final String PRODUCT_NAME = "//*[text()='%s']";
    public static final By PRODUCT_LABEL = By.cssSelector(".product_label");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    //заглушка
    public ProductsPage open() {
        return null;
    }

    public ProductsPage addProductToCart(String productName) {
        driver.findElement(By.xpath(String.format(ADD_TO_CART, productName))).click();
        return this;
    }

    public void openProductDetailsPage(String productName) {
        driver.findElement(By.xpath(String.format(PRODUCT_NAME, productName))).click();
    }

    public void openCartPage() {
        driver.findElement(By.id("shopping_cart_container")).click();
    }

    public boolean isOnTheProductPage() {
        return driver.findElement(PRODUCT_LABEL).isDisplayed();
    }

   /* public boolean isOnTheProductPage1() {
        try {
            return driver.findElement(PRODUCT_LABEL).isDisplayed();
        } catch (NoSuchElementException exception) {
            Assert.fail("");
        }
    }*/

    public boolean isOnTheProductPage2() {
        boolean isOpened;
        try {
            driver.findElement(PRODUCT_LABEL);
            isOpened = true;
        } catch (NoSuchElementException exception) {
            return isOpened = false;
        }
        return isOpened;
    }

    public void isOnTheProductPage3() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(PRODUCT_LABEL));
        } catch (TimeoutException exception) {
            Assert.fail("Page is not loaded");
        }
    }

    public boolean isAddToCartButtonPressed(String productName) {
        if (driver.findElement(By.xpath(String.format(REMOVE_FROM_CART, productName))).getText().equalsIgnoreCase("remove")) {
            return true;
        }
        return false;
    }

    public void removeProductFromCart() {

    }

    public void sortProducts() {

    }
}
