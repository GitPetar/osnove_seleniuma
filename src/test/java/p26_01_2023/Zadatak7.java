package p26_01_2023;
//Zadatak (ZA VEZBANJE)
//Ucitati stranicu https://netoglasi.rs/
//Ispisati sve nazive kategorija iz leve navigacije
//Validirati da je kategorija Automobili na prvom mestu
//Klik na kategoriju Automobili
//Validarati da je kategorija Automobili na prvom mestu

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class Zadatak7 {
public static void main(String[] args) throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    List<WebElement> kategorije = new ArrayList<>();
    driver.manage().window().maximize();
    driver.get("https://netoglasi.rs/");
    Thread.sleep(1000);
    kategorije = driver.findElements(By.xpath("//ion-list[1]//b"));
    for (WebElement kategorija : kategorije) {
        System.out.println(kategorija.getText());
    }
    if (kategorije.get(0).getText().equals("Automobili")) {
        System.out.println("Kategorija \"Automobili\" je na prvom mestu");
    } else {
        System.out.println("Kategorija \"Automobili\" nije na prvom mestu");
    }
    kategorije.get(0).click();
    kategorije = driver.findElements(By.xpath("//ion-list[1]//b"));
    Thread.sleep(1000);
    if (kategorije.get(0).getText().equals("Automobili")) {
        System.out.println("Kategorija \"Automobili\" je na prvom mestu");
    } else {
        System.out.println("Kategorija \"Automobili\" nije na prvom mestu");
    }
    Thread.sleep(1000);
    driver.quit();
}
}
