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
        driver.findElement(By.id("user-name")).sendKeys(VALID_NAME);
        driver.findElement(By.id("password")).sendKeys(VALID_PASSWORD);
        driver.findElement(By.id("login-button")).click();
        String result = driver.findElement(By.className("product_label")).getText();
        Assert.assertEquals(result, "Products");
        driver.quit();
    }

    @Test
    public static void invalidLogin() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(URL);
        driver.findElement(By.id("user-name")).sendKeys("John");
        driver.findElement(By.id("password")).sendKeys("1234567890");
        driver.findElement(By.id("login-button")).click();
        String result = driver.findElement(By.cssSelector("h3[data-test]")).getText();
        Assert.assertEquals(result, "Epic sadface: Username and password do not match any user in this service");
        driver.quit();
    }
}
