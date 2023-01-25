package domaci24_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//Zadatak
//Maksimizirati prozor
//Ucitati stranicu https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
//Prijavite se na sistem
//Username: Admin
//Password: admin123
//Cekanje od 5s
//U input za pretragu iz navigacije unesite tekst Me
//Kliknite na prvi rezultat pretrage (to ce biti Time)
//Cekanje od 1s
//Kliknite u headeru na svog avatara (to ce biti na ime: Paul Collings)
//Klinkite na logout
//Cekanje od 5s
//Zatvorite pretrazivac
public class Zadatak1 {
public static void main(String[] args) throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
    driver.manage().window().maximize();
    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    wait.until(ExpectedConditions.elementToBeClickable(By.name("username")));
    driver.findElement(By.name("username")).sendKeys("Admin");
    driver.findElement(By.name("password")).sendKeys("admin123");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search']")));
    driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("Me");
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/web/index.php/time/viewTimeModule']")));
    driver.findElement(By.xpath("//a[@href='/web/index.php/time/viewTimeModule']")).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.className("oxd-userdropdown-name")));
    driver.findElement(By.className("oxd-userdropdown-name")).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Logout")));
    driver.findElement(By.linkText("Logout")).click();
    Thread.sleep(5000);
    driver.quit();
    //Ako se pitate zasto sam uveo 'wait', odgovor je jer bez toga ne radi.
    //Alternativa bi bila da koristim cekanje preko Thread.sleep(), al ovo mi dodje elegantnije resenje. Sigurno
    // postoji i bolje, al nek ovo bude za sad.
}
}
