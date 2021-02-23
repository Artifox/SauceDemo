package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BasePage {

    public static final By BACK_BUTTON = By.cssSelector(".inventory_details_back_button");
    public static final By PRODUCT_NAME = By.cssSelector(".inventory_details_name");

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public BasePage open() {
        driver.get("https://www.saucedemo.com/inventory-item.html");
        return this;
    }

    @Override
    public boolean isOpened() {
        boolean isOpened;
        try {
            driver.findElement(BACK_BUTTON);
            return isOpened = true;
        } catch (NoSuchElementException exception) {
            return isOpened = false;
        }
    }

    public void findProductName(String productName) {
        driver.findElement(PRODUCT_NAME);
    }
}
