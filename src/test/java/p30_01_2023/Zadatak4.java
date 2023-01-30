package p30_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

//4.Zadatak
//Napisati program koji:
//Ucitava stranicu https://mdbootstrap.com/docs/standard/components/toasts/
//Vrsi klik na Basic example link iz desne navigacije
//Ceka da url sadrzi #section-basic-example
public class Zadatak4 {
public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("https://mdbootstrap.com/docs/standard/components/toasts/");
    driver.findElement(By.xpath("//*[@href='#section-basic-example']")).click();
    wait.until(ExpectedConditions.urlContains("#section-basic-example"));
    driver.quit();
}
}
