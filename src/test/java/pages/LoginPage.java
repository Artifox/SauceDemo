package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class LoginPage extends BasePage {
    public static final By LOGIN_INPUT = By.id("user-name");
    public static final By PASSWORD_INPUT = By.id("password");
    public static final By LOGIN_BUTTON = By.id("login-button");
    public static final By ERROR_MESSAGE = By.cssSelector("[data-test=error]");
    public static final By ERROR_BUTTON = By.cssSelector(".error-button");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://www.saucedemo.com/index.html");
    }

    public void login(String userName, String password) {
        driver.findElement(LOGIN_INPUT).sendKeys(userName);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }

    /*public String getErrorMessage() {
        try{
            return driver.findElement(ERROR_MESSAGE).getText();
        }catch (NoSuchElementException exception){
            return "Error message is not found";
        }
    }*/

    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    public boolean isErrorMessageDisplayed() {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        int amountOfElements = driver.findElements(ERROR_MESSAGE).size();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        if (amountOfElements != 0) {
            return true;
        }
        return false;
    }

    public void pressErrorButton() {
        driver.findElement(ERROR_BUTTON).click();
    }
}