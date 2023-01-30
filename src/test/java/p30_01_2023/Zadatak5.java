package p30_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

//5.Zadatak
//Napisati program koji:
//Ucitava stranicu https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example
//Vrsi klik na Primary dugme, Secondary, Sucess, Danger
//Ceka da broj toasts-a bude 4
//Ispisuje poruku, toasts su prikazani
//Ceka da broj toasts-a bude 0
//Ispisuje poruku, toasts su se izgubili
public class Zadatak5 {
public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example");
    List<WebElement> dugmici = new ArrayList<>();
    List<WebElement> tostevi = new ArrayList<>();
    boolean tosteviSeVide = false;
    dugmici = driver.findElements(By.xpath("//div[contains(@class,'container text-center')]/button[position()<=4]"));
    dugmici.remove(dugmici.size() - 1);
    tostevi = driver.findElements(By.xpath("(//div[contains(@class,'toast-header ')])[position()>4 and position()<9]"));
    for (WebElement dugme : dugmici) {
        dugme.click();
        System.out.println("Klik!");
    }
    wait.until(ExpectedConditions.visibilityOfAllElements(tostevi));
    System.out.println("Svi se vide!");
    wait.until(ExpectedConditions.invisibilityOfAllElements(tostevi));
    driver.quit();
}
}
