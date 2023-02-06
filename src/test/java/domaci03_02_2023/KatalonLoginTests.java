package domaci03_02_2023;

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

//1.Zadatak
//Kreirati klasu KatalonLoginTests za testove
//Base url: https://cms.demo.katalon.com
//Test #1: Visit login page from Nav bar
//Koraci:
//Ucitati home stranicu
//Kliknuti na My account link
//Verifikovati da je naslov stranice My account – Katalon Shop
//Verifikovati da se u url-u stranice javlja /my-account
//Za sve validacije ispisati odgovarajuce poruke u slucaju greske
//Test #2: Check input types
//Koraci:
//Ucitati /my-account stranicu
//Verifikovati da  polje za unos email-a za atribu type ima vrednost text
//Verifikovati da polje za unos lozinke za atribut type ima vrednost password
//Verifikovati da checkbox Remember me za atribut type ima vrednost checkbox
//Verifikovati da je Remember me checkbox decekiran. Koristan link kako naci informaciu da li je checkbox cekiran ili
// ne.
//Za sve validacije ispisati odgovarajuce poruke u slucaju greske
//
//Test #3: Display error when credentials are wrong
//Podaci:
//email: invalidemail@gmail.com
//password: invalid123
//Koraci:
//Ucitati /my-account stranicu
//Unesite email
//Unesite password
//Kliknite na login dugme
//Verifikovati da postoji element koji prikazuje gresku
//Verifikovati da je prikazana greska ERROR: Invalid email address
//Za sve validacije ispisati odgovarajuce poruke u slucaju greske
//Verifikovati da smo idalje na login stranici posle greske, tako sto proveravamo da se url-u javlja /my-account
public class KatalonLoginTests {
WebDriver driver = new ChromeDriver();
WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));

@AfterClass
public void AfterClass() throws InterruptedException {
    Thread.sleep(5000);
    driver.quit();
}

@BeforeClass
public void BeforeClass() {
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("https://cms.demo.katalon.com");
}

@BeforeMethod
public void BeforeMethod() {
}

@Test
@Description("Test #1: Visit login page from Nav bar")
void Test1() {
    wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@href='https://cms.demo" +
    ".katalon.com/my-account/']"))));
    driver.findElement(By.xpath("//*[@href='https://cms.demo.katalon.com/my-account/']")).click();
    Assert.assertEquals(driver.getTitle(), "My account – Katalon Shop", Assert.ARRAY_MISMATCH_TEMPLATE);
    Assert.assertTrue(driver.getCurrentUrl().contains("/my-account"), Assert.ARRAY_MISMATCH_TEMPLATE);
}

@Test
@Description("Test #2: Check input types")
void Test2() {
    driver.get("https://cms.demo.katalon.com/my-account/");
    Assert.assertEquals(driver.findElement(By.xpath("//input")).getAttribute("type"), "text",
    Assert.ARRAY_MISMATCH_TEMPLATE);
    Assert.assertEquals(driver.findElement(By.xpath("(//input)[2]")).getAttribute("type"), "password",
    Assert.ARRAY_MISMATCH_TEMPLATE);
    Assert.assertEquals(driver.findElement(By.xpath("(//input)[3]")).getAttribute("type"), "checkbox",
    Assert.ARRAY_MISMATCH_TEMPLATE);
    Assert.assertFalse(driver.findElement(By.xpath("(//input)[3]")).isSelected(), "checkbox" + " is checked");
}

@Test
@Description("Test #3: Display error when credentials are wrong")
void Test3() {
    //email: invalidemail@gmail.com
    //password: invalid123
    driver.get("https://cms.demo.katalon.com/my-account/");
    driver.findElement(By.xpath("//input")).sendKeys("invalidemail@gmail.com");
    driver.findElement(By.xpath("(//input)[2]")).sendKeys("invalid123");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    Assert.assertNotEquals(driver.findElements(By.xpath("//*[@class='woocommerce-error']")).size(), 0,
    Assert.ARRAY_MISMATCH_TEMPLATE);
    Assert.assertEquals(driver.findElement(By.xpath("//*[contains(text(),'ERROR')]")).getText(), "ERROR",
    Assert.ARRAY_MISMATCH_TEMPLATE);
    Assert.assertTrue(driver.getCurrentUrl().contains("/my-account"), Assert.ARRAY_MISMATCH_TEMPLATE);
}
}