package domaci26_01_2023;
//4.Zadatak
//Napisati program koji ucitava stranicu https://geodata.solutions/
//Bira Country, State i City po vasoj zelji
//Pritom potrebno je izvrsiti cekanje da se povaje State-ovi nakon izbora Country-a
//I takodje je potrebno izvrsiti cekanje da se ucitaju gradovi nakon izbora State-a
//Izabrerit Country, State i City tako da imate podatke da selektujete!

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak4 {
public static void main(String[] args) throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://geodata.solutions/");
    Select select = new Select(driver.findElement(By.xpath("//select[@name='country']")));
    select.selectByVisibleText("Serbia");
    select = new Select(driver.findElement(By.xpath("//select[@name='state']")));
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
    wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("option")));
    select.selectByVisibleText("Central Serbia");
    select = new Select(driver.findElement(By.xpath("//select[@name='city']")));
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@name='city']/option[text()='Nis']")));
    select.selectByVisibleText("Nis");
    Thread.sleep(2000);
    driver.quit();
}
}
