package domaci30_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

//Zadatak
//Napisati program koji:
//Pre nego sto krenete u automatizaciju prvo sve korake uradite rucno
//Implicitno cekanje za trazenje elemenata je maksimalno 10s
//Implicitno cekanje za ucitavanje stranice je 5s
//Ucitava stranicu https://docs.katalon.com/
//Maksimizuje prozor
//Od html elementa cita data-theme atribut.
//Proverava da li je sadrzaj u tom atributu light i ispisuje odgovarajuce poruke
//Klikce na dugme za zamenu tema
//Ponovo cita data-theme atribut html elementa i validira da u atributu stoji vrednost dark
//Izvrsava kombinaciju tastera CTRL + K. Koristan link  za keyboard actions…kako izvrsavati precice preko Actions
// objekta
//Ceka da se dijalog za pretragu pojavi
//Zatim od inputa za pretragu cita atribut type i proverava da je vrednost tog atributa search
//Zatvara pretrazivac
public class Zadatak3 {
public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
    driver.get("https://docs.katalon.com/");
    if (driver.findElement(By.xpath("//html")).getAttribute("data-theme").equals("light")) {
        System.out.println("Theme is light!");
    }
    driver.findElement(By.xpath("//button[contains(@class, 'toggleButton')]")).click();
    if (driver.findElement(By.xpath("//html")).getAttribute("data-theme").equals("dark")) {
        System.out.println("Theme is dark!");
    }
    new Actions(driver).keyDown(Keys.CONTROL).sendKeys("k").perform();
    new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='DocSearch-Modal']"))));
    if (driver.findElement(By.xpath("//input[@class='DocSearch-Input']")).getAttribute("type").equals("search")) {
        System.out.println("Zaista je vrednost atributa jednako \"search\"");
    }
    driver.quit();
}
}
