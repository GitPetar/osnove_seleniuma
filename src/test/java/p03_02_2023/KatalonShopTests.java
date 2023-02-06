package p03_02_2023;

import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

//Zadatak
//	Kreirati KatalonShopTests klasu:
//	baseUrl: https://cms.demo.katalon.com
//	Test #1:  Adding product with quantity to the cart
//	Prioritet = 10
//	Koraci:
//Ucitati stranicu /product/flying-ninja/
//Unesite kolicinu 3
//Klik na Add to cart dugme
//Verifikovati da poruka sadrzi tekst “Flying Ninja”.
//Klik na Cart link iz navigacije
//Verifikovati da u url-u stoji /cart ruta
//Verifikovati da je broj proizvoda u korpi jednako 1
//Test #2:  Removing product from cart
//	Prioritet = 20
//	Koraci:
//Klik na Cart link iz navigacije
//Verifikovati da u url-u stoji /cart ruta
//Verifikovati da je broj proizvoda u korpi jednako 1
//Klik na remove dugme iz prvog reda
//Verifikovati da je broj proizvoda u korpi jedako 0
//Test #3:  Verify error is displayed when username is missing
//	Prioritet = 30
//	Koraci:
//Kliknite na my account link
//Klik na login dugme
//Verifikovati da je prikazana poruka Error: Username is required.
//
//Test #4:  Verify error is displayed when password is missing
//	Prioritet = 40
//	Koraci:
//Kliknite na my account link
//Unesite username customer
//Klik na login dugme
//Verifikovati da je prikazana poruka ERROR: The password field is empty.
//
//Test #5:  Verify error is displayed when password is wrong
//	Prioritet = 50
//	Koraci:
//Kliknite na my account link
//Unesite username customer
//Unesite nevalidan pass invalidpassword
//Klik na login dugme
//Verifikovati da je prikazana poruka ERROR: The password you entered for the username customer is incorrect. Lost
// your password?
//
//
//
//Test #6:  Verify error is displayed when user does not exist
//	Prioritet = 60
//	Koraci:
//Kliknite na my account link
//Unesite username invaliduser
//Unesite nevalidan pass (ex: pass1234)
//Klik na login dugme
//Verifikovati da je prikazana poruka ERROR: Invalid username. Lost your password?
//
//Test #7:  Verify successful login
//	Prioritet = 70
//	Koraci:
//Kliknite na my account link
//Unesite username customer
//Unesite validan pass crz7mrb.KNG3yxv1fbn
//Klik na login dugme
//Verifikovati na stranici pise Hello Katalon Parlitul_Changed
//	Dopunite pageve za sve sto je potrebno za ove testove, ako je potrebno kreirajte i nove pageve
public class KatalonShopTests {
WebDriver driver = new ChromeDriver();
WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));

@BeforeClass
public void BeforeClass() {
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}

@BeforeMethod
public void BeforeMethod() {
    driver.get("https://cms.demo.katalon.com");
}

@Test(priority = 10)
@Description("Test #1:  Adding product with quantity to the cart")
public void Test1() {
    driver.get("https://cms.demo.katalon.com/product/flying-ninja/");
    driver.findElement(By.xpath("//*[contains(@class, 'quantity-button quantity-up')]")).click();
    driver.findElement(By.xpath("//*[contains(@class, 'quantity-button quantity-up')]")).click();
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    Assert.assertTrue(driver.findElement(By.className("woocommerce-message")).getText().contains("Flying Ninja"),
    "Message doesn't contain text \"Flying Ninja\"");
    driver.findElement(By.xpath("//*[@href='https://cms.demo.katalon.com/cart/']")).click();
    Assert.assertEquals(driver.getCurrentUrl(), "https://cms.demo.katalon.com/cart/", "Url does not match expected");
    Assert.assertEquals(driver.findElements(By.xpath("//*[contains(@class,'woocommerce-cart-form__cart-item " +
    "cart_item')" + "]")).size(), 1, "Expected number of cart items doesn't match actual nubmer.");
}

@Test(priority = 20)
@Description("Test #2:  Removing product from cart")
public void Test2() {
    driver.findElement(By.xpath("//*[@href='https://cms.demo.katalon.com/cart/']")).click();
    Assert.assertEquals(driver.getCurrentUrl(), "https://cms.demo.katalon.com/cart/", "Url does not match expected");
    Assert.assertEquals(driver.findElements(By.xpath("//*[contains(@class,'woocommerce-cart-form__cart-item " +
    "cart_item')" + "]")).size(), 1, "Expected number of cart items doesn't match actual nubmer.");
    driver.findElement(By.xpath("//*[@class='remove']")).click();
    wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//*[contains(@class," + "'woocommerce-cart" +
    "-form__cart-item" + " " + "cart_item')" + "]"), 0));
    Assert.assertEquals(driver.findElements(By.xpath("//*[contains(@class,'woocommerce-cart-form__cart-item " +
    "cart_item')" + "]")).size(), 0, "Expected number of cart items doesn't match actual nubmer.");
}

@Test(priority = 30)
@Description("Test #3:  Verify error is displayed when username is missing")
public void Test3() {
    driver.findElement(By.xpath("//*[@href='https://cms.demo.katalon.com/my-account/']")).click();
    driver.findElement(By.name("login")).click();
    Assert.assertEquals(driver.findElement(By.xpath("//*[@class='woocommerce-error']/li")).getText(), "Error: " +
    "Username is required.", "Error message does not contain \"Username is required\"");
    //Verifikovati da je prikazana poruka Error: Username is required.
}

@Test(priority = 40)
@Description("Test #4:  Verify error is displayed when password is missing")
public void Test4() {
    driver.findElement(By.xpath("//*[@href='https://cms.demo.katalon.com/my-account/']")).click();
    driver.findElement(By.id("username")).sendKeys("customer");
    driver.findElement(By.name("login")).click();
    Assert.assertEquals(driver.findElement(By.xpath("//*[@class='woocommerce-error']/li")).getText(),
    "ERROR: The " + "password field is empty.", "Error message does not contain \"The password field is empty.\"");
}

@Test(priority = 50)
@Description("Test #5:  Verify error is displayed when password is wrong")
public void Test5() {
    driver.findElement(By.xpath("//*[@href='https://cms.demo.katalon.com/my-account/']")).click();
    driver.findElement(By.id("username")).sendKeys("customer");
    driver.findElement(By.id("password")).sendKeys("invalidpassword");
    driver.findElement(By.name("login")).click();
    Assert.assertEquals(driver.findElement(By.xpath("//*[@class='woocommerce-error']/li")).getText(),
    "ERROR: The " + "password you entered for the username customer is incorrect. Lost your password?", "Error " +
    "message does not match" + " expected.");
}

@Test(priority = 60)
@Description("Test #6:  Verify error is displayed when user does not exist")
public void Test6() {
    driver.findElement(By.xpath("//*[@href='https://cms.demo.katalon.com/my-account/']")).click();
    driver.findElement(By.id("username")).sendKeys("invaliduser");
    driver.findElement(By.id("password")).sendKeys("invalidpassword");
    driver.findElement(By.name("login")).click();
    Assert.assertEquals(driver.findElement(By.xpath("//*[@class='woocommerce-error']/li")).getText(), "ERROR: " +
    "Invalid" + " username. Lost your password?", "Error message does not match" + " expected.");
}

@Test(priority = 70)
@Description("Test #7:  Verify successful login")
public void Test7() {
    driver.findElement(By.xpath("//*[@href='https://cms.demo.katalon.com/my-account/']")).click();
    driver.findElement(By.id("username")).sendKeys("customer");
    driver.findElement(By.id("password")).sendKeys("crz7mrb.KNG3yxv1fbn");
    driver.findElement(By.name("login")).click();
    Assert.assertTrue(driver.findElement(By.xpath("(//p)[3]")).getText().contains("Hello Katalon Parlitul_Changed"),
    "Message does not contain" + " expected text.");
}

@AfterClass
public void AfterClass() throws InterruptedException {
    Thread.sleep(5000);
    driver.quit();
}
}
