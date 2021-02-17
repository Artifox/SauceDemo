package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BasePage {

    public static final By BACK_BUTTON = By.cssSelector(".inventory_details_back_button");
    public static final String PRODUCT_NAME = "//*[text()='%s']";

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductDetailsPageOpened() {
        return driver.findElement(BACK_BUTTON).isDisplayed();
    }

    public boolean findProductName(String productName) {
        return driver.findElement(By.xpath(String.format(PRODUCT_NAME, productName))).isDisplayed();
    }
}
