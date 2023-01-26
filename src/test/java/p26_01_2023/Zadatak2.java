package p26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

//2.Zadatak
//Napisti program koji:
//Ucitava stranicu https://s.bootsnipp.com/iframe/z80en
//Hvata sve elemente prve kolone i stampa tekst svakog elementa. Kako da od nekog elementa procitamo tekst imate na
// sledecem linku
//Ceka 1s
//Hvata sve elemente prvog reda i stampa tekst svakog elementa
//Ceka 5s
//Zatvara pretrazivac
public class Zadatak2 {
public static void main(String[] args) throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    List<WebElement> elementi = new ArrayList<>();
    driver.manage().window().maximize();
    driver.get("https://s.bootsnipp.com/iframe/z80en");
    Thread.sleep(1000);
    elementi = driver.findElements(By.xpath("//div[2]/div/div[1]/table/tbody/tr/td[1]"));
    String s;
    for (WebElement element : elementi) {
        System.out.println(element.getText());
    }
    Thread.sleep(5000);
    driver.quit();
}
}
