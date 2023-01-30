package p30_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

//1.Zadatak
//Napisati program koji ucitava stranicu https://s.bootsnipp.com/iframe/klDWV i ceka da se ucita progress bar na 100%
// a zatim ispisuje tekst u konzoli “Stranica ucitana”
public class Zadatak1 {
public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("https://s.bootsnipp.com/iframe/klDWV");
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'100%')]")));
    System.out.println("Stranica nije ucitana: ne");
    driver.quit();
}
}
