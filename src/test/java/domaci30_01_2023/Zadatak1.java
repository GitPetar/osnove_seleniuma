package domaci30_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

//Zadatak
//Napisati program koji testira infinity scroll.
//Ucitati stranu https://web.dev/patterns/web-vitals-patterns/infinite-scroll/infinite-scroll/demo.html
//Selektujte delay od 2000ms, koristeci Select klasu.
//Skrol do Show more dugmeta koje se nalazi na dnu stranice
//Sacekajte da dugme bude klikljivo
//Klik na Show more dugme
//Sacekjate da broj elemenata bude X (X je koliko se kod vas ucitava)
//Sacekajte da dugme vise ne bude klikljivo
public class Zadatak1 {
public static void main(String[] args) throws InterruptedException {
    //
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
    Actions actions = new Actions(driver);
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("https://web.dev/patterns/web-vitals-patterns/infinite-scroll/infinite-scroll/demo.html");
    Select select = new Select(driver.findElement(By.tagName("select")));
    
    select.selectByVisibleText("2000ms");
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("infinite-scroll-button")));
    for (WebElement item : driver.findElements(By.className("item"))) {
        actions.scrollToElement(item).perform();
    }
    actions.scrollToElement(driver.findElement(By.id("infinite-scroll-button"))).perform();
    wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("infinite-scroll-button"))));
    List<WebElement> items = new ArrayList<>(driver.findElements(By.className("item")));
    driver.findElement(By.id("infinite-scroll-button")).click();
    wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.className("item"), items.size()));
    Thread.sleep(4000);
    driver.quit();
}
}
