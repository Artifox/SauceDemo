import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    private static final String URL = "https://www.saucedemo.com/";

    @Test
    public static void validLogin() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(URL);
        driver.findElement(By.id("user-name")).sendKeys("John");
        driver.findElement(By.id("password")).sendKeys("Doe");
        driver.findElement(By.id("login-button")).click();
        String result = driver.findElement(By.cssSelector("h3[data-test]")).getText();
        Assert.assertEquals(result, "Epic sadface: Username and password do not match any user in this service");
        driver.quit();
    }
}
