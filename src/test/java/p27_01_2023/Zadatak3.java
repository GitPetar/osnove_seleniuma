package p27_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

//Napisati program koji ucitava stranicu https://github.com/orgs/embedly/repositories?q=&type=all&language=&sort=
//Klik na Type drawdown
//Klik na Public iz drowdowna
//Proverava da li je Clear dugme u desnom uglu prikazano
//Kilk na Clear filter u desnom uglu
public class Zadatak3 {
public static void main(String[] args) throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("https://github.com/orgs/embedly/repositories?q=&type=all&language=&sort=");
    driver.findElement(By.xpath("//span[text()='Type']")).click();
    driver.findElement(By.xpath("//span[text()='Public']")).click();
    if (driver.findElement(By.xpath("(//*[@href='/orgs/embedly/repositories'])[3]")).isDisplayed()) {
        driver.findElement(By.xpath("(//*[@href='/orgs/embedly/repositories'])[3]")).click();
    } else {
        System.out.println("Error!");
    }
    Thread.sleep(5000);
    driver.quit();
}
}
