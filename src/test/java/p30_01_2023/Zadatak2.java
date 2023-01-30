package p30_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

//2. Zadatak
//Napisati program koji ucitava stranicu https://youtube.com i u search baru unosi tekste Breskvica i ceka da se
// pojavi vise od 3 rezultata iz padajuceg menija i zatim klikce na prvi.
public class Zadatak2 {
public static void main(String[] args) throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("https://youtube.com");
    driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Breskvica ");
    driver.findElement(By.xpath("//input[@id='search']")).sendKeys(Keys.DOWN);
    Thread.sleep(2000);
    wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//li[@role='presentation']"), 2));
    driver.findElement(By.xpath("(//li[@role='presentation'])[1]")).click();
    Thread.sleep(3000);
    driver.quit();
}
}
