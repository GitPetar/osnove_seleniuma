package p26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

//Napisti proram koji :
//Ucitava stranicu https://s.bootsnipp.com/iframe/oV91g
//Hvatamo sve page-eve iz paginacije tabele
//Zatim petljom prolazimo kroz paginaciju tako sto kliknemo na svaki broj
//Izmedju iteracija napravite pauzu od 1s
//Zatvorite pretrazivac
public class Zadatak1 {
public static void main(String[] args) throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    List<WebElement> elements = new ArrayList<>();
    driver.manage().window().maximize();
    driver.get("https://s.bootsnipp.com/iframe/oV91g");
    elements = driver.findElements(By.xpath("//a[@href='#' and contains(@class,'page_link')]"));
    for (WebElement element : elements) {
        element.click();
        Thread.sleep(1000);
    }
    driver.quit();
}
}
