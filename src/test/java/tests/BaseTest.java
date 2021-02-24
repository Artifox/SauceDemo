package tests;

import pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    SideBarMenuPage sideBarMenuPage;
    ProductDetailsPage productDetailsPage;
    CheckoutPage checkoutPage;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        sideBarMenuPage = new SideBarMenuPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }

    }
}
