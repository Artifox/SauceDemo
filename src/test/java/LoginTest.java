import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    private static final String URL = "https://www.saucedemo.com/";
    private static final String VALID_NAME = "standard_user";
    private static final String VALID_PASSWORD = "secret_sauce";

    @Test
    public static void validLogin() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(URL);
        login(driver, VALID_NAME, VALID_PASSWORD);
        String result = driver.findElement(By.className("product_label")).getText();
        Assert.assertEquals(result, "Products", "Login failed");
        driver.quit();
    }

    @Test
    public static void invalidLogin() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(URL);
        login(driver, "John", "1234567890");
        String result = driver.findElement(By.cssSelector("h3[data-test]")).getText();
        Assert.assertEquals(result, "Epic sadface: Username and password do not match any user in this service", "There is no warning message");
        driver.quit();
    }

    @Test
    public static void addGoodsToBasket() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(URL);
        login(driver, VALID_NAME, VALID_PASSWORD);
        driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']/ancestor::div[@class='inventory_item']//button")).click();
        driver.findElement(By.xpath("//*[text()='Sauce Labs Bike Light']/ancestor::div[@class='inventory_item']//button")).click();
        driver.findElement(By.cssSelector("[data-icon=shopping-cart]")).click();
        int amountOfElementsInBasket = driver.findElements(By.cssSelector("[class='cart_item']")).size();
        Assert.assertEquals(amountOfElementsInBasket, 2);
        String result = driver.findElement(By.xpath("//div/child::a/child::div[text()='Sauce Labs Backpack']")).getText();
        Assert.assertEquals(result, "Sauce Labs Backpack");
        result = driver.findElement(By.xpath("//div/child::a/child::div[text()='Sauce Labs Bike Light']")).getText();
        Assert.assertEquals(result, "Sauce Labs Bike Light");
        driver.quit();
    }

    private static void login(WebDriver driver, String validName, String validPassword) {
        driver.findElement(By.id("user-name")).sendKeys(validName);
        driver.findElement(By.id("password")).sendKeys(validPassword);
        driver.findElement(By.id("login-button")).click();
    }
}
