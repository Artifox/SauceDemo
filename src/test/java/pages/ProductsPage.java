package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    public static final String ADD_TO_CART = "//*[text()='%s']/ancestor::*[contains(@class,'inventory_item')]//button";
    public static final String REMOVE_FROM_CART = "//*[text()='%s']/ancestor::*[contains(@class,'inventory_item')]//button";
    public static final String PRODUCT_NAME = "//*[text()='%s']";

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void open() {

    }

    public void addProductToCart(String productName) {
        driver.findElement(By.xpath(String.format(ADD_TO_CART, productName))).click();
    }

    public void openProductDetailsPage(String productName) {
        driver.findElement(By.xpath(String.format(PRODUCT_NAME, productName))).click();
    }

    public void openCartPage() {
        driver.findElement(By.id("shopping_cart_container")).click();
    }

    public boolean isOnTheProductPage() {
        return driver.findElement(By.cssSelector(".product_label")).isDisplayed();
    }

    public boolean isAddToCartButtonPressed(String productName) {
        if(driver.findElement(By.xpath(String.format(REMOVE_FROM_CART, productName))).getText().equalsIgnoreCase("remove")){
            return true;
        }
        return false;
    }

    public void removeProductFromCart() {

    }

    public void sortProducts() {

    }
}
