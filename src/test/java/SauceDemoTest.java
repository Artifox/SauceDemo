import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SauceDemoTest {

    private static final String URL = "https://www.saucedemo.com/";
    private static final String VALID_NAME = "standard_user";
    private static final String VALID_PASSWORD = "secret_sauce";
    private static final String ADD_TO_CART_BUTTON_XPATH = "//*[text()='%s']/ancestor::div[@class='inventory_item']//button";
    private static final String PRODUCT_IN_BASKET_XPATH = "//div/child::a/child::div[text()='%s']";
    private static final String PRODUCT_NAME1 = "Sauce Labs Backpack";
    private static final String PRODUCT_NAME2 = "Sauce Labs Bike Light";
    private static final String PRODUCT_ABSENT_ERROR_MESSAGE = "Element isn't present in basket";

    @Test
    public static void validLogin() {
        WebDriver driver = UtilityWebDriver.open(URL);
        login(driver, VALID_NAME, VALID_PASSWORD);
        String result = driver.findElement(By.className("product_label")).getText();
        Assert.assertEquals(result, "Products", "Login failed");
        driver.quit();
    }

    @Test
    public static void invalidLogin() {
        WebDriver driver = UtilityWebDriver.open(URL);
        login(driver, "John", "1234567890");
        String result = driver.findElement(By.cssSelector("h3[data-test]")).getText();
        Assert.assertEquals(result, "Epic sadface: Username and password do not match any user in this service", "There is no warning message");
        driver.quit();
    }

    @Test
    public static void addGoodsToBasket() {
        WebDriver driver = UtilityWebDriver.open(URL);
        login(driver, VALID_NAME, VALID_PASSWORD);
        driver.findElement(By.xpath(String.format(ADD_TO_CART_BUTTON_XPATH, PRODUCT_NAME1))).click();
        driver.findElement(By.xpath(String.format(ADD_TO_CART_BUTTON_XPATH, PRODUCT_NAME2))).click();
        driver.findElement(By.id("shopping_cart_container")).click();
        int amountOfElementsInBasket = driver.findElements(By.cssSelector("[class='cart_item']")).size();
        Assert.assertEquals(amountOfElementsInBasket, 2, "Amount of goods doesn't much");
        String result = driver.findElement(By.xpath(String.format(PRODUCT_IN_BASKET_XPATH, PRODUCT_NAME1))).getText();
        Assert.assertEquals(result, PRODUCT_NAME1, PRODUCT_ABSENT_ERROR_MESSAGE);
        result = driver.findElement(By.xpath(String.format(PRODUCT_IN_BASKET_XPATH, PRODUCT_NAME2))).getText();
        Assert.assertEquals(result, PRODUCT_NAME2, PRODUCT_ABSENT_ERROR_MESSAGE);
        driver.quit();
    }

    private static void login(WebDriver driver, String validName, String validPassword) {
        driver.findElement(By.id("user-name")).sendKeys(validName);
        driver.findElement(By.id("password")).sendKeys(validPassword);
        driver.findElement(By.id("login-button")).click();
    }
}
