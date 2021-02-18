package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    public static final String ADD_TO_CART = "//*[text()='%s']/ancestor::*[contains(@class,'inventory_item')]//button";
    public static final String REMOVE_FROM_CART = "//*[text()='%s']/ancestor::*[contains(@class,'inventory_item')]//button";
    public static final String PRODUCT_NAME = "//*[text()='%s']";
    public static final By SIDE_BAR_MENU_BUTTON = By.xpath("//*[text()='Open Menu']");
    public static final By COUNTER_ON_CART_BADGE = By.cssSelector(".fa-layers-counter");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://www.saucedemo.com/inventory.html");
    }

    public ProductsPage addProductToCart(String productName) {
        driver.findElement(By.xpath(String.format(ADD_TO_CART, productName))).click();
        return this;
    }

    public void openProductDetailsPage(String productName) {
        driver.findElement(By.xpath(String.format(PRODUCT_NAME, productName))).click();
    }

    public CartPage openCartPage() {
        driver.findElement(By.id("shopping_cart_container")).click();
        return new CartPage(driver);
    }

    public boolean isProductPageOpened() {
        return driver.findElement(By.cssSelector(".product_label")).isDisplayed();
    }

    public boolean isAddToCartButtonPressed(String productName) {
        if (driver.findElement(By.xpath(String.format(REMOVE_FROM_CART, productName))).getText().equalsIgnoreCase("remove")) {
            return true;
        }
        return false;
    }

    public boolean isRemoveButtonPressed(String productName) {
        if (driver.findElement(By.xpath(String.format(ADD_TO_CART, productName))).getText().equalsIgnoreCase("add to cart")) {
            return true;
        }
        return false;
    }

    public ProductsPage removeProductFromCart(String productName) {
        driver.findElement(By.xpath(String.format(REMOVE_FROM_CART, productName))).click();
        return this;
    }

    public SideBarMenuPage openSideBarMenu() {
        driver.findElement(SIDE_BAR_MENU_BUTTON).click();
        return new SideBarMenuPage(driver);
    }

    public String getNumbersOfProductsOnCartBadge() {
        return driver.findElement(COUNTER_ON_CART_BADGE).getText();
    }
}
