package domaci02_02_2023;

import com.google.common.io.Files;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

//1.Zadatak
//Kreirati BootstrapTableTests klasu koja ima:
//Base url: https://s.bootsnipp.com
//Test #1: Edit Row
//Podaci:
//First Name: ime polaznika
//Last Name: prezime polaznika
//Middle Name: srednje ime polanzika
//Koraci:
//Ucitati stranu /iframe/K5yrx
//Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
//Klik na Edit dugme prvog reda
//Sacekati da dijalog za Editovanje bude vidljiv
//Popuniti formu podacima.
//Bice potrebno da pre unosa tekst pobrisete tekst koji vec postoji, za to se koristi metoda clear. Koristan link
//Klik na Update dugme
//Sacekati da dijalog za Editovanje postane nevidljiv
//Verifikovati da se u First Name celiji prvog reda tabele javlja uneto ime
//Verifikovati da se u Last Name celiji prvog reda tabele javlja uneto prezime
//Verifikovati da se u Middle Name celiji prvog reda tabele javlja uneto srednje ime
//Za sve validacije ispisati odgovarajuce poruke u slucaju greske
//
//Test #2: Delete Row
//Podaci:
//First Name: ime polaznika
//Last Name: prezime polaznika
//Middle Name: srednje ime polanzika
//Koraci:
//Ucitati stranu /iframe/K5yrx
//Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
//Klik na Delete dugme prvog reda
//Sacekati da dijalog za brisanje bude vidljiv
//Klik na Delete dugme iz dijaloga
//Sacekati da dijalog za Editovanje postane nevidljiv
//Verifikovati da je broj redova u tabeli za jedan manji
//Za sve validacije ispisati odgovarajuce poruke u slucaju greske
//
//Test #3: Take a Screenshot
//Koraci:
//Ucitati stranu  /iframe/K5yrx
//Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
//Kreirati screenshot stranice.
//Fajl cuvajte na putanji gde su vam bile slike od proslog domaceg. Na putanji: screenshots/slike.png
public class BootstrapTableTests {
WebDriver driver = new ChromeDriver();
WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
int counter = 0;

@BeforeClass
public void BeforeClass() {
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("https://s.bootsnipp.com/iframe/K5yrx");
    Assert.assertEquals(driver.getTitle(), "Table with Edit and Update Data - Bootsnipp.com", "Unexpected page title");
}

@BeforeMethod
public void BeforeMethod() {
}

@Test
@Description("Test #1: Edit Row")
public void Test1() {
    driver.findElement(By.xpath("//button[@data-target='#edit'and@data-uid='1']")).click();
    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("modal-header"))));
    driver.findElement(By.id("fn")).clear();
    driver.findElement(By.id("fn")).sendKeys("ime polaznika");
    driver.findElement(By.id("ln")).clear();
    driver.findElement(By.id("ln")).sendKeys("prezime polaznika");
    driver.findElement(By.id("mn")).clear();
    driver.findElement(By.id("mn")).sendKeys("srednje ime polanzika");
    driver.findElement(By.id("up")).click();
    wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.className("modal-header"))));
    Assert.assertEquals(driver.findElement(By.id("f1")).getText(), "ime polaznika", "First name does not match " +
    "expected");
    Assert.assertEquals(driver.findElement(By.id("l1")).getText(), "prezime polaznika",
    "Last name does not match " + "expected");
    Assert.assertEquals(driver.findElement(By.id("m1")).getText(), "srednje ime polanzika",
    "Middle name does not " + "match" + " expected");
}

@Test
@Description("Test #2: Delete Row")
public void Test2() {
    counter = driver.findElements(By.xpath("//tbody/tr")).size();
    driver.findElement(By.xpath("//button[@data-target='#delete'and@data-uid='1']")).click();
    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//*[@class='modal-header'])[2]"))));
    driver.findElement(By.id("del")).click();
    wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("(//*[@class='modal-header'])[2]"))));
    //Assert.assertEquals(driver.findElements(By.xpath("//tbody/tr")).size(), counter - 1,
    //"Number of rows has been " + "lowered by 1");
    //Broj redova u tabeli nikad nece biti manji, jer se element ne izbrise, tako da ce test uvek da padne.
    //Nacin da se zaista proveri da li je broj redova manji je da se proveri da li su nestali elementi iz prvog reda
    // tabele. U nastavku pisem...
    Assert.assertEquals(driver.findElements(By.xpath("//*[@id='d1']/*")).size(), 0, "Table row that should have been "
    + "deleted still contains data.");
}

@Test
@Description("Test #3: Take a Screenshot")
public void Test3() {
    Date date = Calendar.getInstance().getTime();
    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yy_hhmmss");
    String datum = dateFormat.format(date);
    TakesScreenshot scrShot = (TakesScreenshot) driver;
    File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
    File screenshot = new File("screenshots/bootstrap" + datum + ".jpg");
    try {
        Files.copy(SrcFile, screenshot);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}

@AfterClass
public void AfterClass() {
    try {
        Thread.sleep(5000);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
    driver.quit();
}
}
