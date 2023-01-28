package domaci27_01_2023;

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

//1.Zadatak
//Ucitati stranicu https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example
//Klik na svako dugme od PRIMARY do DARK
//Sacekati da se toasts u desnom gornjem uglu pojavi
//Pauza izmedju klikova 1s
//Postavite implicitno cekanje za ucitavanje stranice i trazenje elemenata na 10s
public class Zadatak1 {
public static void main(String[] args) throws InterruptedException {
    //
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    List<WebElement> dugmici;
    List<WebElement> tostevi = new ArrayList<>();
    driver.get("https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example");
    //prave se liste
    dugmici = driver.findElements(By.xpath("//section[2]/section[1]/div/section/div/button"));
    for (int i = 4; i < dugmici.size() + 4; i++) {
        tostevi.add(driver.findElement(By.xpath("(//div[contains(@class,'toast-header ')])[" + i + "]")));
    }
    // sad imamo dve liste spremne, dugmici i tostevi.
    for (int i = 0; i < dugmici.size(); i++) {
        dugmici.get(i).click();
        System.out.println(dugmici.get(i).getText() + ": *klik*");
        wait.until(ExpectedConditions.visibilityOf(tostevi.get(i)));
        if (tostevi.get(i).isDisplayed()) {System.out.println("Tost"+i+": \"Bonjour!\"");}
        //Thread.sleep(1000);
    }
    driver.quit();
}
}
