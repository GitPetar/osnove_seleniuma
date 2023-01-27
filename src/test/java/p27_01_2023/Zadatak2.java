package p27_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

//2.Zadatak
//Napisati program koji ucitava stranicu Zadatak4.html
//Skinite Zadatak4.html sa drajva. Otvorite u pretrazivacu duplim klikom na fajl i Downloads-a i ikopirajte url. To
// je url za get u programu
//I na stranici dodaje 5 poruka “IT Bootcamp”
//Potrebno  je u svakoj iteraciji kliknuti na dugme Show in
//Sacekati da se novi element pojavi pre nego sto se doda sledeci
public class Zadatak2 {
public static void main(String[] args) throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("file:///C:/Users/Korisnik/Desktop/Zadatak4.html");
    for (int i = 0; i < 5; i++) {
        driver.findElement(By.id("showInBtn")).click();
        if (driver.findElements(By.id("id-" + i)).size() > 0) {
            System.out.println("Element postoji");
        } else {System.out.println("Element ne postoji");}
    }
    Thread.sleep(3000);
    driver.quit();
}
}
