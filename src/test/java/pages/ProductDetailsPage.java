package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BasePage {

    public static final By BACK_BUTTON = By.cssSelector(".inventory_details_back_button");
    public static final By PRODUCT_NAME = By.cssSelector(".inventory_details_name");

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductDetailsPageOpened() {
        return driver.findElement(BACK_BUTTON).isDisplayed();
    }

    public void findProductName(String productName) {
        driver.findElement(PRODUCT_NAME);
    }
}
