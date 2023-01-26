package p26_01_2023;

import org.checkerframework.checker.units.qual.Length;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//6. Zadatak
//Ucitati stranicu https://cms.demo.katalon.com/
//Maksimizovati prozor
//Proveriri da li je je crno MENU dugme vidljivo (Ispisati poruke u konzoli)
//Prostavite duzinu prozora na 700px i visinu na 700px
//Proverite da li je crno MENU dugme vidljivo (Ispisati poruke u konzoli)

public class Zadatak6 {
public static void main(String[] args) throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://cms.demo.katalon.com/");
    Thread.sleep(6000);
    if (driver.findElement(By.xpath("//*[@class='menu-toggle']")).isDisplayed()) {
        System.out.println("Meni je vidljiv");
    } else {System.out.println("Meni nije vidljiv");}
    driver.manage().window().setSize(new Dimension(700, 700));
    if (driver.findElement(By.xpath("//*[@class='menu-toggle']")).isDisplayed()) {
        System.out.println("Meni je vidljiv");
    } else {System.out.println("Meni nije vidljiv");}
    driver.quit();
}
}
