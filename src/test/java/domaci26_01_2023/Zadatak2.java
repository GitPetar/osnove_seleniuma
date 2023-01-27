package domaci26_01_2023;
//Zadatak (Za vezbanje)
//Napisati program koji matematicku formulu koju korisnik unese izvrsaav na stranici:
//Ucitati stranicu https://www.calculatorsoup.com/calculators/math/basic.php
//Korisnik unosi formulu, samo osnovne matematicke operacija, npr:
//1243+329=
//21912-4=
//12913÷4=
//U programu se formula unosi kao jedan string i potrebno je razbiti formulu na karaktere. Za to imate metodu https://www.geeksforgeeks.org/convert-a-string-to-a-list-of-characters-in-java/
//Zatim u odnosu na karakter uradite odredjenu logiku

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Scanner;

public class Zadatak2 {
public static void main(String[] args) throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    Scanner scanner = new Scanner(System.in);
    System.out.println("Unesite formulu: ");
    char[] formula = scanner.next().toCharArray();
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://www.calculatorsoup.com/calculators/math/basic.php");
    for (char c : formula) {
        if (c != ' ') {
            driver.findElement(By.xpath("//button[contains(@onmousedown,'" + c + "')]")).click();
        }
    }
    Thread.sleep(2000);
    driver.quit();
}
}
