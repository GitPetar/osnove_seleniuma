package domaci06_02_2023;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.CartPage;
import pages.NavPage;
import pages.ProductPage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
protected WebDriver driver;
protected WebDriverWait wait;
//protected NavPage navPage;
//protected ProductPage productPage;
//protected CartPage cartPage;



protected String baseUrl = "http://automationpractice.com/";

@BeforeClass
public void setup() {
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    driver = new ChromeDriver();
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get(baseUrl);
//    navPage = new NavPage(driver, wait);
//    productPage = new ProductPage(driver, wait);
//    cartPage = new CartPage(driver, wait);
}

@BeforeMethod
public void BeforeMethod() {
}

@AfterClass
public void AfterClass() throws InterruptedException {
    Thread.sleep(5000);
    driver.quit();
}
}
