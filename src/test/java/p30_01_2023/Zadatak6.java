package p30_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

//6. Zadatak
//Napisati program koji:
//Ucitava stranicu https://tus.io/demo.html
//Hvata sve linkove sa stranice
//Skrola do svakog linka
//Od svakog linka cita href atribut i stampa ga na ekranu
public class Zadatak6 {
public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    Actions actions = new Actions(driver);
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("https://tus.io/demo.html");
    List<WebElement> linkovi = driver.findElements(By.partialLinkText(""));
    for (WebElement link : linkovi) {
        do {
            try {
                actions.scrollToElement(link).perform();
            } catch (ElementNotInteractableException e) {
                link = link.findElement(By.xpath("./.."));
            }
        } while (!link.isDisplayed());
        System.out.println(link.getAttribute("href"));
    }
    driver.quit();
}
}
