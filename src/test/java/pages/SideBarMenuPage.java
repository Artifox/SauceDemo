package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class SideBarMenuPage extends BaseModal {

    public static final By RESET_APP_STATE_MENU_ITEM = By.id("reset_sidebar_link");
    public static final By CLOSE_MENU_BUTTON = By.xpath("//*[text()='Close Menu']");

    public SideBarMenuPage(WebDriver driver) {
        super(driver);
    }

    public ProductsPage closeSideBarMenu() {
        driver.findElement(CLOSE_MENU_BUTTON).click();
        return new ProductsPage(driver);
    }

    @Override
    public boolean isOpened() {
        boolean isOpened;
        try {
            driver.findElement(RESET_APP_STATE_MENU_ITEM);
            return isOpened = true;
        } catch (NoSuchElementException exception) {
            return isOpened = false;
        }
    }
}
