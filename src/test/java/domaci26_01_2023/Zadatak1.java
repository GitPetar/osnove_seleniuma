package domaci26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
//Validira da li je novi todo dodat na stranici
//Na kraju programa proci petljom i izbrisati svaki todo sa stranice (klikom na x dugme svakog todo-a)
//Validirati da je na kraju programa broj todo-a na stranici 0.
//Cekanje od 5s
//Zatvorite pretrazivac
public class Zadatak1 {
public static void main(String[] args) throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    ArrayList<String> todo = new ArrayList<>(Arrays.asList("Visit Paris", "Visit Prague", "Visit London", "Visit New "
    + "York", "Visit Belgrade"));
    int counter;
    driver.manage().window().maximize();
    driver.get("https://example.cypress.io/todo");
    WebElement webElement = driver.findElement(By.className("new-todo"));
    counter = Integer.parseInt(driver.findElement(By.xpath("//span/strong")).getText());
    for (String task : todo) {
        webElement.sendKeys(task);
        webElement.sendKeys(Keys.ENTER);
        if (counter < Integer.parseInt(driver.findElement(By.xpath("//span/strong")).getText())) {
            counter = Integer.parseInt(driver.findElement(By.xpath("//span/strong")).getText());
            System.out.println("Novi todo je dodat");
        }
    }
    Actions actions = new Actions(driver);
    List<WebElement> webElements = driver.findElements((By.xpath("//button[contains(@class,'destroy')]")));
    webElements.forEach(element -> {
        actions.moveToElement(element.findElement(By.xpath("./.."))).build().perform();
        element.click();
    });
    webElements = driver.findElements((By.xpath("//button[contains(@class,'destroy')]")));
    if (webElements.size() == 0) {System.out.println("Svi elementi su izbrisani");}
    Thread.sleep(5000);
    driver.quit();
}
}
