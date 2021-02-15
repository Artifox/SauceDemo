package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//фэктори в названии для примера, в жизни это просто loginPage
public class LoginPageFactory extends BasePage{
    @FindBy(id = "user-name")
    WebElement loginInput;
    @FindBy(id = "password")
    WebElement passwordInput;
    @FindBy(id = "login-button")
    WebElement loginButton;
    @FindBy(css = "[data-test=error]")
    WebElement errorMessage;

    public LoginPageFactory(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://www.saucedemo.com/index.html");
        PageFactory.initElements(driver, this);
    }

    public void login(String userName, String password) {
        loginInput.sendKeys(userName);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
}