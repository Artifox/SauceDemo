package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    public static final String ADD_TO_CART = "//*[text()='%s']/ancestor::*[contains(@class,'inventory_item')]//button";
    public static final String REMOVE_FROM_CART = "//*[text()='%s']/ancestor::*[contains(@class,'inventory_item')]//button";
    public static final String PRODUCT_NAME = "//*[text()='%s']";
    public static final By SIDE_BAR_MENU_BUTTON = By.xpath("//*[text()='Open Menu']");
    public static final By COUNTER_ON_CART_BADGE = By.cssSelector(".fa-layers-counter");
    public static final By PRODUCT_LABEL = By.cssSelector(".product_label");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public ProductsPage open() {
        driver.get("https://www.saucedemo.com/inventory.html");
        return this;
    }

    @Override
    public boolean isOpened() {
        boolean isOpened;
        try {
            driver.findElement(PRODUCT_LABEL);
            return isOpened = true;
        } catch (NoSuchElementException exception) {
            return isOpened = false;
        }
    }

    public ProductsPage addProductToCart(String productName) {
        driver.findElement(By.xpath(String.format(ADD_TO_CART, productName))).click();
        return this;
    }

    public ProductDetailsPage openProductDetailsPage(String productName) {
        driver.findElement(By.xpath(String.format(PRODUCT_NAME, productName))).click();
        return new ProductDetailsPage(driver);
    }

    public CartPage openCartPage() {
        driver.findElement(By.id("shopping_cart_container")).click();
        return new CartPage(driver);
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
