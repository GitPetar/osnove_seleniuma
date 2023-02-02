package domaci31_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
//2. Zadatak
//Napisati program koji:
//Ucitava stranu https://itbootcamp.rs/
//Misem prelazi preko Vesti iz navigacionog menija
//Ceka da se prikaze padajuci meni za Vesti
//Misem prelazi preko Kursevi iz navigacionog menija
//Ceka da se prikaze padajuci meni za Kursevi
//Misem prelazi preko Prijava i pravilnik iz navigacionog menija
//Ceka da se prikaze padajuci meni za Prijava i pravilnik
//Koristan link. Mouse over preko seleniuma https://www.selenium.dev/documentation/webdriver/actions_api/mouse/#move-to-element

public class Zadatak2 {
public static void main(String[] args) throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("https://itbootcamp.rs/");
    Actions actions = new Actions(driver);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
    actions.moveToElement(driver.findElement(By.xpath("//*[@id='menu-item-6408']"))).perform();
    wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id='menu-item-6408']//a"))));
    actions.moveToElement(driver.findElement(By.xpath("//*[@id='menu-item-5362']"))).perform();
    wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id='menu-item-5362']//a"))));
    actions.moveToElement(driver.findElement(By.xpath("//*[@id='menu-item-5453']"))).perform();
    wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id='menu-item-5453']//a"))));
    Thread.sleep(5000);
    driver.quit();
}
}
