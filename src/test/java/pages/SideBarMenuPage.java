package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class SideBarMenuPage extends BasePage {

    public static final By RESET_APP_STATE_MENU_ITEM = By.id("reset_sidebar_link");
    public static final By CLOSE_MENU_BUTTON = By.xpath("//*[text()='Close Menu']");

    public SideBarMenuPage(WebDriver driver) {
        super(driver);
    }

    public void isSideBarMenuOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(RESET_APP_STATE_MENU_ITEM));
        } catch (TimeoutException exception) {
            Assert.fail("Side bar is not opened");
        }
    }

    public void closeSideBarMenu() {
        driver.findElement(CLOSE_MENU_BUTTON).click();
    }
}
