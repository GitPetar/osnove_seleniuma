package p27_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

//1.Zadatak
//Ucitati stranicu https://demoqa.com/modal-dialogs
//Kliknuti na dugme Large modal
//Proverite da li se prikazao dijalog i ispisite u konzoli odgovarajuce poruke
public class Zadatak1 {
public static void main(String[] args) throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("https://demoqa.com/modal-dialogs");
    driver.findElement(By.id("showLargeModal")).click();
    List<WebElement> elementi = driver.findElements(By.className("modal-body"));
    if (elementi.size() != 0) {
        System.out.println("Ura! Element postoji!");
    } else {System.out.println("Zalost velika!");}
    Thread.sleep(2000);
    driver.quit();
}
}
