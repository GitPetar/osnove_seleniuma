package domaci24_01_2023;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;

//Zadatak
//Niz todo-a (niz stringova) koje treba da uneti. Niz je:
//Visit Paris
//Visit Prague
//Visit London
//Visit New York
//Visit Belgrade
//Maksimizirati prozor
//Ucitati stranicu https://example.cypress.io/todo
//Program petljom prolazi kroz niz todo-a i svaki unosi na stranicu
//Nakon svakog unosa todo-a, unosi se enter
//Cekanje od 5s
//Zatvorite pretrazivac
public class Zadatak2 {
public static void main(String[] args) throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    ArrayList<String> todo = new ArrayList<>(Arrays.asList("Visit Paris", "Visit Prague", "Visit London", "Visit New "
    + "York", "Visit Belgrade"));
    driver.manage().window().maximize();
    driver.get("https://example.cypress.io/todo");
    WebElement webElement = driver.findElement(By.className("new-todo"));
    for (String task : todo) {
        webElement.sendKeys(task);
        webElement.sendKeys(Keys.ENTER);
    }
    Thread.sleep(5000);
    driver.quit();
}
}
